/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigemp.common.server.securrity;

import java.util.Base64;

/**
 *
 * @author sigem
 */
public final class PreToken {

    private final String preToken;
////    private boolean isCorrect;
    private String user;
    private String password;
    private String data;

    public PreToken(String preToken) {
        this.preToken = preToken;
        decode();
    }

    public boolean isValid() throws Exception {
        boolean noValid = false;
        if (noValid) {
            throw new Exception("el token ingresado es un PreToken");
        }

        return true;

    }

////    public void comparePass(String storePass) throws Exception {
////        if (storePass == null) {
////            throw new Exception("El usuario no tiene clave asignada!!");
////        }
////        if (password == null) {
////            throw new Exception("Hay un problema con la clave que se quiere validar");
////        }
////        if (storePass.equals(password)) {
////            isCorrect = true;
////        } else {
////            throw new Exception("Hay un problema con la clave que se quiere validar");
////        }
////        
////    }

    public String createAuthToken() {
////        if (!isCorrect) {
////            throw new Exception("usuario o clave icorrecto");
////        }
        String token = Token.createNewAuthToken(user);
        return token;
    }

    public void decode() {
        
        byte[] decodedBytes = Base64.getDecoder().decode(preToken);
        
        String tt = new String(decodedBytes);
        
        String[] d = new String(decodedBytes).split(";", 3);
        
        user = d[0];
        password = d[1];
        data = d[2];
    }

    public String getUserName() {
        return user;
    }
    
    public String getPassword() {
        return password;
    }
}
