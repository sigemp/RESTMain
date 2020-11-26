/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigemp.gestion.server.services;

import com.sigemp.gestion.shared.dto.AuthenticationData;
import com.sigemp.gestion.shared.entity.GsyUser;
import com.sigemp.server.actualizaciones.Secured;
import com.sigemp.gestion.server.exception.NotAuthorizedException;
import com.sigemp.common.server.securrity.PreToken;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author sigem
 */
@Stateless
@Path("/authentication")
public class AuthenticationEndpoint {

    public static final String SG_KEY_SESSION = "com.sigemp.gestion.token";

    public static final String HOST_HEADER = "host";
    public static final String USER_AGENT_HEADER = "user-agent";

    @PersistenceContext(unitName = "CustomerService")
    private EntityManager em;

    @Context
    private transient HttpServletRequest servletRequest;

    @EJB
    private GsyTokenFacadeREST tokenService;

//    @EJB
//    private GsyUserFacadeREST userService;
    @EJB
    private UtilTest utilTest;

    @POST
    public Response authenticateUser(String ParamPreToken) {

        try {
            String host = servletRequest.getHeader(HOST_HEADER);
            String user_agent = servletRequest.getHeader(USER_AGENT_HEADER);

            PreToken preToken = new PreToken(ParamPreToken);

            String userName = preToken.getUserName();
            String password = preToken.getPassword();

            utilTest.validateUser(userName, password);

            // Crea el token
            String authToken = preToken.createAuthToken();

            // Almaceno el token generado
            tokenService.createToken(authToken, userName, host, user_agent);

            // Return the token on the response
            return Response.ok(authToken, MediaType.TEXT_PLAIN).build();
        } catch (Exception ex) {
            Logger.getLogger(AuthenticationEndpoint.class.getName()).log(Level.SEVERE, null, ex);
            throw new NotAuthorizedException(ex.getMessage());
        }
    }

    @GET
    @Secured
    @Path("check")
    @Produces({MediaType.APPLICATION_JSON})
    public AuthenticationData check() {
        GsyUser user = utilTest.getAuthenticatedUser();
        if (user != null) {
            AuthenticationData a = new AuthenticationData();
            a.setUser(user);
            return a;
        }

        throw new NotAuthorizedException("Session no Autorizada");

    }

    @POST
    @Secured
    @Path("logout")
    public Response test(String token) {
        tokenService.logout(token);
        return Response.ok(Boolean.TRUE).build();
    }

}
