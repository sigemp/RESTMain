/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigemp.server.util;



/**
 *
 * @author cristian
 */
public class UtilClass {

    /**
     * Retone el nombre de la clase
     * @param clazz
     * @return 
     */
    public static String getFile(Class clazz) {
        String className = clazz.getCanonicalName();
        int x = className.lastIndexOf('.');
        x++;
        className = className.substring(x);
        return className;
    }

}
