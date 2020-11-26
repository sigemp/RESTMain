/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigemp.gestion.server.exception;

import com.sigemp.gestion.shared.dto.ErrorDto;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

/**
 *
 * @author sigem
 */
public class BaseExeption extends WebApplicationException {
    
    public BaseExeption(final Response response) {
        super(response);
    }
    
    static Response getResponse(String message,Status status) {
        return Response.status(status)
                .entity(new ErrorDto(message))
                .type(MediaType.APPLICATION_JSON)
                .build();
    }
    
    static Response getResponse(String message) {
        return getResponse(message,Response.Status.UNAUTHORIZED);
    }
}
