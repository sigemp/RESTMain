/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigemp.common;

import com.sigemp.common.exception.StringUtils;

/**
 *
 * @author sigem
 */
public class U {

    public static DateUtils getDateUtil() {
        return new DateUtils();
    }

    public static SwingUtils getSwingUtil() {
        return new SwingUtils();
    }

    public static StringUtils getStringUtil() {
        return new StringUtils();
    }
}
