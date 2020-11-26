/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigemp.common.exception;

import java.util.logging.Logger;

/**
 *
 * @author cristian
 */
public class SgIntegridadException extends SgException {

    private static final Logger LOG = Logger.getLogger(SgIntegridadException.class.getName());

    /**
     *
     * @param string
     */
    public SgIntegridadException(String string) {
        super(string);
    }
}
