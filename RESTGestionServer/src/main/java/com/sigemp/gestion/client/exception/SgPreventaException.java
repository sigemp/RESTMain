/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigemp.gestion.client.exception;

import java.util.logging.Logger;

/**
 *
 * @author cristian
 */
public class SgPreventaException extends SgException {

    private static final Logger LOG = Logger.getLogger(SgPreventaException.class.getName());

    public SgPreventaException(String message) {
        super(message);
    }

    public SgPreventaException(String message, Throwable cause) {
        super(message, cause);
    }
}
