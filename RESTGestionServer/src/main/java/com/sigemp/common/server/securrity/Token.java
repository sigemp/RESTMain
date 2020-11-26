/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigemp.common.server.securrity;

import java.util.Base64;
import java.util.UUID;

/**
 *
 * @author sigem
 */
public class Token {

    private final boolean isValidToken = false;
    private final String token;
    private String user;
    private String date;

    public Token(String token) {
          this.token = token;
    }

    /**
     * Decodifica el token
     * 
     */
    private void decode() throws Exception {
        if (token == null)
            throw new Exception("el token es null");
        byte[] decodedBytes = Base64.getDecoder().decode(token);
        String decodedString = new String(decodedBytes);
        String[] d = new String(decodedBytes).split(";", 2);
        
        user = d[1];
        date = d[2];
        
        
    }    
    
    public String getUser() {
        return user;
    }
    
    public boolean isTokenValid() throws Exception {
        decode();
        // chequeo si esta vencido
        // chequeo si el usuario coincide
        if (!isValidToken) {
            throw new Exception("el token ingresado no es valido");
        }
        
        // comparo la validez del token con los token almacenados
        return true;
    }

    /**
     * Retorna true si el token esta vencido
     * 
     * @return 
     */
    public boolean isVencido() {
        // true si esta vencido 
        return false;
    }
    
    
    /**
     * Genera un nuevo Token
     * 
     * @param user
     * @return 
     */
    public static String createNewAuthToken(String user) {
        String toCode = user + ";" + UUID.randomUUID().toString();
        String encodedString = Base64.getEncoder().encodeToString(toCode.getBytes());
        return encodedString;
    }

}
