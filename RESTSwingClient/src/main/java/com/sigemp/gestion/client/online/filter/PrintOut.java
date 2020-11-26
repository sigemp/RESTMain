/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigemp.gestion.client.online.filter;

import java.io.IOException;
import java.net.URI;
import javax.ws.rs.client.ClientRequestContext;
import javax.ws.rs.client.ClientRequestFilter;
import javax.ws.rs.client.ClientResponseContext;
import javax.ws.rs.client.ClientResponseFilter;
import javax.ws.rs.core.MultivaluedMap;

/**
 *
 * @author Server
 */
public class PrintOut implements ClientRequestFilter, ClientResponseFilter {

    @Override
    public void filter(ClientRequestContext requestContext) throws IOException {
        System.out.println(requestContext.toString());
        System.out.println("-- Client request info --");
        log(requestContext.getUri(), requestContext.getHeaders());
    }

    @Override
    public void filter(ClientRequestContext reqContext,
            ClientResponseContext resContext) throws IOException {
        System.out.println("-- Client response info --");
        log(reqContext.getUri(), resContext.getHeaders());
    }

    private void log(URI uri, MultivaluedMap<String, ?> headers) {
        System.out.println("Request URI: " + uri.getPath());
        System.out.println("Headers:");
        headers.entrySet().forEach(h -> System.out.println(h.getKey() + ": " + h.getValue()));
    }
}
