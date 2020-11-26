/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigemp.gestion.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.Cookies;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import com.sigemp.gestion.client.api.ContextImp;
import com.sigemp.gestion.client.api.interfaces.Constantes;
import com.sigemp.gestion.client.api.security.PreTokenC;
import com.sigemp.gestion.client.api.ui.Toast;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.fusesource.restygwt.client.Method;
import org.fusesource.restygwt.client.TextCallback;
import com.sigemp.gestion.client.service.AuthenticationService;

/**
 *
 * https://github.com/Posya/wiki/blob/master/best-practice-for-rest-token-based-authentication-with-jax-rs-and-jersey.adoc
 *
 *
 * @author sigem
 */
public class Loguin {

    private HTMLPanel panelList;

    interface LoguinUiBinder extends UiBinder<HTMLPanel, Loguin> {
    }

    private static LoguinUiBinder uiBinder = GWT.create(LoguinUiBinder.class);

    AuthenticationService service;

    @UiField
    TextBox usuario;

    @UiField
    PasswordTextBox password = new PasswordTextBox();

    @UiField
    Button buttonAceptar;

    public Loguin() {
        panelList = uiBinder.createAndBindUi(this);
    }

    public Widget getLoguin() {

        service = GWT.create(AuthenticationService.class);
        buttonAceptar.addClickHandler((ClickEvent event) -> {
            send();
        });

        return panelList;
    }

    public void send() {
        try {
            String user = usuario.getText().trim();
            String pass = password.getText().trim();

            PreTokenC preTokenC = new PreTokenC(user, pass);
            String preToken = preTokenC.getNewToken();

            service.authenticateUser(preToken, new TextCallback() {
                @Override
                public void onFailure(Method method, Throwable exception) {

                    ContextImp.getInstance().getErrorDrive().show(method, exception);

//                    switch (method.getResponse().getStatusCode()) {
//                        case 401: // Unauthorized
//                            ContextImp.getInstance().getErrorDrive().show(method, exception);
//                            break;
//                        default:
//                            ContextImp.getInstance().getErrorDrive().show(method, exception);
//                    }
                }

                @Override
                public void onSuccess(Method method, String response) {
                    Toast.show("Iniciando..");
                    Cookies.setCookie(Constantes.COOKIE.SISTEMA_GESTION.name(), response);
                    Window.Location.reload();
                }

            });
        } catch (Exception ex) {
            Logger.getLogger(Loguin.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
