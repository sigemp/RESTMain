/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigemp.server.constantes;

/**
 *
 * @author sigem
 */
public class General {
    public static String getTempDirectory() {
        String tmp = System.getProperty("java.io.tmpdir");
        return tmp;
    }
}
