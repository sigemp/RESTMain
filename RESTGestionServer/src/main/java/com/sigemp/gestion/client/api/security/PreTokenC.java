/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigemp.gestion.client.api.security;

import com.sigemp.gestion.client.api.util.Base64;
import java.util.Date;

/**
 *
 * @author sigem
 */
public class PreTokenC {

    private final String user;
    private final String password;
    private String data = "lalalala";

    public PreTokenC(String user, String password) {
        this.user = user;
        this.password = password;
    }

    public boolean isValid() throws Exception {
        boolean noValid = false;
        if (noValid) {
            throw new Exception("El token ingresado es un PreToken");
        }

        return true;

    }

    public String getNewToken() throws Exception {
        return encodePreToken(user, password);
    }

    public static String encodePreToken(String user, String password) throws Exception {
        String date = new Date().toString();

        String toEncode = user + ";" + password + ";" + date;

        String encodedString = Base64.encode(toEncode);

        //Now we can convert the byte[] into a splitted array :
        //  - the first one is login,
        //  - the second one password
        //return new String(decodedBytes).split(":", 2);
        return encodedString;
    }

    public static String[] decodePreToken(String preToken) {

        String decodePreToken = com.sigemp.gestion.client.api.util.Base64.decode(preToken);
        String decodedString = new String(decodePreToken.getBytes());
        String[] d = decodePreToken.split(";", 3);
        return d;

    }

}
