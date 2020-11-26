/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigemp.gestion.client.api.dispatcher;

import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.http.client.RequestException;
import javax.ws.rs.core.Request;
import org.fusesource.restygwt.client.Method;

/**
 *
 * @author cristian
 */
public interface Dispatcher {

    public Request send(Method method, RequestBuilder builder) throws RequestException;
    
}
