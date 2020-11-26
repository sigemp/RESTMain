/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigemp.gestion.client.api;

import com.sigemp.gestion.client.ErrorUtil;
import com.sigemp.gestion.client.api.ui.Toast;
import org.fusesource.restygwt.client.Method;

/**
 *
 * @author sigem
 */
public class SGErrorDrive {

    public void show(Method method, Throwable exception) {
////        StringBuilder sb = new StringBuilder();
////        sb.append("Exception :").append(exception.toString()).append("\n")
////                .append("Exception Message :").append(exception.getMessage()).append("\n")
////                .append("Status code :").append(method.getResponse().getStatusCode()).append("\n");
////
////        Window.alert(sb.toString());
        String error;
        if (method.getResponse().getStatusCode() == 500 || 
                method.getResponse().getStatusCode() == 401) {
            error = ErrorUtil.getErrorObject(method.getResponse().getText());
            if (error == null) {
                Toast.show("error no reconocido");
            } else {
                Toast.show(error);
            }
        } else {
            Toast.show("error code:" + method.getResponse().getStatusCode() + " no interpretado");
        }

    }
}
