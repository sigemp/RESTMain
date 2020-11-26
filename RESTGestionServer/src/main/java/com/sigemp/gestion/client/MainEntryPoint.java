package com.sigemp.gestion.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Cookies;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.gwt.user.client.ui.RootPanel;
import com.sigemp.gestion.client.api.ContextImp;
import com.sigemp.gestion.client.api.dispatcher.MyDispatcher;
import com.sigemp.gestion.client.api.interfaces.Constantes;
import com.sigemp.gestion.client.api.interfaces.Context;
import com.sigemp.gestion.shared.dto.AuthenticationData;
import com.sigemp.gestion.shared.entity.GsyUser;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.fusesource.restygwt.client.Defaults;
import org.fusesource.restygwt.client.Method;
import org.fusesource.restygwt.client.MethodCallback;
import com.sigemp.gestion.client.service.AuthenticationService;

/**
 * Main entry point.
 */
public class MainEntryPoint implements EntryPoint {

    
    static Logger logger = Logger.getLogger("Main");
    
    private AuthenticationService service;
    

    @Override
    public void onModuleLoad() {

        service = GWT.create(AuthenticationService.class);
        
        
        
        startApplication();

    }

    public void startApplication() {
        logger.log(Level.INFO,"Iniciado");


        String root_rest_service = GWT.getHostPageBaseURL()+ "api/";
        logger.log(Level.INFO,"Asignando root rest " + root_rest_service);
        Defaults.setServiceRoot(root_rest_service);
//        Defaults.setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
        Defaults.setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");

        
        checkSession();
 
    }
    
    public void cargarLogin() {
        loading(false);
        RootLayoutPanel.get().add(new Loguin().getLoguin());
    }
    
    public void cargarApp(GsyUser user) {
        loading(false);
        Context context = ContextImp.getInstance();
        
        context.getSecurity().setUser(user);
        RootLayoutPanel.get().add(context.getScreenDrive().getMainPanel());
        context.getScreenDrive().setUpdateUser();
    }
    
    private void checkSession() {
        loading(true);
        
        String token = Cookies.getCookie(Constantes.COOKIE.SISTEMA_GESTION.name());
        if (token == null || token.equals("")) {
            cargarLogin();
            return;
        }
        
        //logger.log(Level.INFO,"Session check :" + token);
        
        Defaults.setDispatcher(new MyDispatcher(token));
        
        service.check("hola",new MethodCallback<AuthenticationData>() {
            @Override
            public void onFailure(Method method, Throwable exception) {
                cargarLogin();
            }

            @Override
            public void onSuccess(Method method, AuthenticationData response) {
                cargarApp(response.getUser());
            }
        });

    }

    private void loading(boolean activo) {
       
        RootPanel r = RootPanel.get("loading");
        if (r == null) {
            return;
        }
        r.setVisible(activo);       
    }

}
