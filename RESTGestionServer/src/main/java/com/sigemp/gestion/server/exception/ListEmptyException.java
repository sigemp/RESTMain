/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigemp.gestion.server.exception;

import static com.sigemp.gestion.server.exception.BaseExeption.getResponse;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

/**
 *
 * @author sigem
 */
public class ListEmptyException extends BaseExeption {

    public ListEmptyException(String message) {
        super(getResponse(message,Status.INTERNAL_SERVER_ERROR));
    }

}
