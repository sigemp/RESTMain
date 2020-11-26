/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigemp.server.util;

import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 *
 * @author sigem
 */
public class Util {
    public static String formatear(String letra, int talon, int num) {
        NumberFormat formatterTalon = new DecimalFormat("0000");
        NumberFormat formatterNum = new DecimalFormat("00000000");
        if (num <= 0) {
            return letra + "-" + formatterTalon.format(talon) + "-" + "S/NUMERO";
        }
        return letra + "-" + formatterTalon.format(talon) + "-" + formatterNum.format(num);        
    }
}
