/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigemp.gestion.server.filter;

import com.sigemp.gestion.shared.entity.GsyToken;
import com.sigemp.gestion.shared.entity.GsyUser;
import com.sigemp.server.actualizaciones.Secured;
import com.sigemp.gestion.server.exception.NotAuthorizedException;
import com.sigemp.gestion.server.services.GsyTokenFacadeREST;
import com.sigemp.common.server.securrity.CustomSecurityContext;
import java.util.logging.Logger;
import javax.annotation.Priority;
import javax.ejb.EJB;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Priorities;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Context;
import javax.ws.rs.ext.Provider;

/**
 *
 * @author Server
 */
@Secured
@Provider
@Priority(Priorities.AUTHENTICATION)
public class AuthFilter implements ContainerRequestFilter {

    @Context
    private transient HttpServletRequest servletRequest;
    
    @EJB 
    private GsyTokenFacadeREST tokenService;

    public static final String AUTHORIZATION_HEADER = "Authorization";

    private static final Logger LOG = Logger.getLogger(AuthFilter.class.getName());

    /**
     * Apply the filter : check input request, validate or not with user auth
     *
     * @param containerRequest The request from Tomcat server
     */
    @Override
    public void filter(ContainerRequestContext containerRequest) throws WebApplicationException {

        //GET, POST, PUT, DELETE, ...
        String method = containerRequest.getMethod();
        // myresource/get/56bCA for example
        String path = containerRequest.getUriInfo().getPath(true);

        //We do allow wadl to be retrieve
        if (method.equals("GET")
                && (path.equals("application.wadl")
                || path.equals("application.wadl/xsd0.xsd"))) {
            return;
        }

        //Get the authentification passed in HTTP headers parameters
        String auth = containerRequest.getHeaderString(AUTHORIZATION_HEADER);
        auth = auth.substring("Basic ".length()).trim();

        //If the user does not have the right (does not provide any HTTP Basic Auth)
        if (auth == null) {
            throw new NotAuthorizedException("NO Autorizado 1");
        }

        
        GsyToken token = tokenService.buscarToken(auth);
        
        if (token == null) {
            throw new NotAuthorizedException("NO Autorizado 2");
        }
        

        //If login or password fail
        if (!token.getToken().equals(auth)) {
            throw new NotAuthorizedException("NO Autorizado 3");
        }

        
        // We configure your Security Context here
        String scheme = containerRequest.getUriInfo().getRequestUri().getScheme();
        containerRequest.setSecurityContext(new CustomSecurityContext(new GsyUser(1), scheme));
        //TODO : HERE YOU SHOULD ADD PARAMETER TO REQUEST, TO REMEMBER USER ON YOUR REST SERVICE...
    }

    private GsyUser authentification(String user, String pass) {

        if (user.equals("admin") && pass.equals("admin")) {
            GsyUser usr = new GsyUser();
            usr.setNick("admin");
            usr.setNom("admin");
            return usr;
        }
        return null;

    }
    
}
