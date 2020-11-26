/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigemp.common.exception;

import java.util.logging.Logger;

/**
 *
 * @author Server
 */
public class SgException extends Exception {

    private static final Logger LOG = Logger.getLogger(SgException.class.getName());

    /**
     *
     * @param message
     */
    public SgException(String message) {
        super(message);
    }

    /**
     *
     * @param message
     * @param cause
     */
    public SgException(String message, Throwable cause) {
        super(message, cause);
    }

}
