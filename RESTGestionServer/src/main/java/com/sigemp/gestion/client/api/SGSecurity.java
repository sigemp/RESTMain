/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigemp.gestion.client.api;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.user.client.Cookies;
import com.google.gwt.user.client.Window;
import com.sigemp.gestion.client.api.interfaces.Constantes;
import com.sigemp.gestion.client.resources.ResourcesImage;
import com.sigemp.gestion.shared.entity.GsyUser;
import org.fusesource.restygwt.client.Method;
import org.fusesource.restygwt.client.MethodCallback;
import com.sigemp.gestion.client.service.AuthenticationService;

/**
 *
 * @author sigem
 */
public class SGSecurity {

    private static SGSecurity security;

    private AuthenticationService service;

    public SGSecurity() {
        service = GWT.create(AuthenticationService.class);
    }

    public static SGSecurity getInstance() {
        if (security == null) {
            security = new SGSecurity();
        }
        return security;
    }
    private GsyUser gsyUser;

    public void setUser(GsyUser gsyUser) {
        this.gsyUser = gsyUser;
    }

    public GsyUser getUser() {
        return gsyUser;
    }

    public ImageResource getImageUser() {
        return ResourcesImage.INSTANCE.getFotoPerfilVacia();
    }

    public void logout() {
        String token = Cookies.getCookie(Constantes.COOKIE.SISTEMA_GESTION.name());
        service.logout(token, new MethodCallback<Boolean>() {
            @Override
            public void onFailure(Method method, Throwable exception) {

            }

            @Override
            public void onSuccess(Method method, Boolean response) {
                Cookies.removeCookie(Constantes.COOKIE.SISTEMA_GESTION.name());
                Window.Location.reload();
            }
        });

    }

}
