/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigemp.gestion.server.exception;

/**
 *
 * @author sigem
 */
public class NotAuthorizedException extends BaseExeption {

    public NotAuthorizedException(String message) {
        super(getResponse(message));
    }

}
