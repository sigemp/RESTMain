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
public class SgFiscalException extends SgException {

    private static final Logger LOG = Logger.getLogger(SgFiscalException.class.getName());

    /**
     *
     * @param message
     */
    public SgFiscalException(String message) {
        super(message);
    }

    /**
     *
     * @param message
     * @param cause
     */
    public SgFiscalException(String message, Throwable cause) {
        super(message, cause);
    }

}
