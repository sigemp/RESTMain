/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigemp.gestion.client.api;

import com.sigemp.gestion.client.api.interfaces.Context;

/**
 *
 * @author sigem
 */
public class ContextImp implements Context {

    private static ContextImp context;
    private static final SGErrorDrive errorDrive = new SGErrorDrive();

    public static Context getInstance() {
        if (context == null) {
            context = new ContextImp();
        }
        return context;
    }

    

    @Override
    public SGMainScreen getScreenDrive() {
        return SGMainScreen.getInstance();
    }

    @Override
    public SGErrorDrive getErrorDrive() {
        return errorDrive;
    }

    @Override
    public SGSecurity getSecurity() {
        return SGSecurity.getInstance();
    }

}
