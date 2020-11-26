/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigemp.common.server.securrity;

import com.sigemp.gestion.shared.entity.GsyUser;
import java.security.Principal;
import javax.ws.rs.core.SecurityContext;

/**
 * Custom Security Context.
 *
 * @author Deisss (MIT License)
 */
public class CustomSecurityContext implements SecurityContext {

    private GsyUser user;
    private String scheme;

    public CustomSecurityContext(GsyUser user, String scheme) {
        this.user = user;
        this.scheme = scheme;
    }

    @Override
    public Principal getUserPrincipal() {
        Principal pr =  new Principal(){
            @Override
            public String getName() {
               return user.getNom();
            }
            
        };
        return pr;
        
    }

    @Override
    public boolean isUserInRole(String s) {
        return true;
////        if (user.getRole() != null) {
////            return user.getRole().contains(s);
////        }
////        return false;
    }

    @Override
    public boolean isSecure() {
        return "https".equals(this.scheme);
    }

    @Override
    public String getAuthenticationScheme() {
        return SecurityContext.BASIC_AUTH;
    }
}
