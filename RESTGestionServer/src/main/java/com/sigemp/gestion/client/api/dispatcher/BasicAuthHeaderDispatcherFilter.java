/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigemp.gestion.client.api.dispatcher;

import com.google.gwt.http.client.RequestBuilder;
import org.fusesource.restygwt.client.Method;
import org.fusesource.restygwt.client.dispatcher.DispatcherFilter;

/**
 *
 * @author cristian
 */
final class BasicAuthHeaderDispatcherFilter implements DispatcherFilter {

    private final String token;

    public BasicAuthHeaderDispatcherFilter(String token) {
        this.token = token;
    }

    public static final String AUTHORIZATION_HEADER = "Authorization";

    @Override
    public boolean filter(Method method, RequestBuilder builder) {

        String basicAuthHeaderValue = "Basic " + token;

        builder.setHeader(AUTHORIZATION_HEADER, basicAuthHeaderValue);

        return true;
    }
}
