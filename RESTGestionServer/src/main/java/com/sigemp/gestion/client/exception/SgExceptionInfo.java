/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigemp.gestion.client.exception;

import java.util.logging.Logger;

/**
 *
 * @author Server
 */
public class SgExceptionInfo extends SgException {

    private static final Logger LOG = Logger.getLogger(SgExceptionInfo.class.getName());

    public SgExceptionInfo(String message) {
        super(message);
    }

    public SgExceptionInfo(String message, Throwable cause) {
        super(message, cause);
    }

}
