/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigemp.gestion.server.filter;

import java.io.IOException;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;

//@Provider
public class CORSFilterOld implements ContainerResponseFilter {

    @Override
    public void filter(ContainerRequestContext request,
            ContainerResponseContext response) throws IOException {

        System.out.println("Pasanfo por agregado de CORN");

        examinarRequest(request);
        examinarResponse(response);
        
//        String headerValue = request.getHeaderString("access-control-request-method");
//        String origin = request.getHeaderString("origin");
//        String allow = response.getHeaderString("allow");


        
        //response.getHeaders().add("Access-Control-Allow-Methods", allow);
        //response.getHeaders().add("access-control-request-method", headerValue);
        //response.getHeaders().add("origin", origin);
        //response.getHeaders().add("Access-Control-Allow-Origin", "*");
        response.getHeaders().add("access-control-request-headers", "x-http-method-override");
        
        //response.getHeaders().add("Access-Control-Allow-Headers", "origin, content-type, accept, authorization");
        //response.getHeaders().add("Access-Control-Allow-Credentials", "true");
        //response.getHeaders().add("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD");

        response.getHeaders().add("Access-Control-Allow-Origin", "*");
        response.getHeaders().add("Access-Control-Allow-Headers",
                "origin, content-type, accept, authorization");
        response.getHeaders().add("Access-Control-Allow-Credentials", "true");
        response.getHeaders().add("Access-Control-Allow-Methods",
                "GET, POST, PUT, DELETE, OPTIONS, HEAD");
        
        examinarRequest(request);
        examinarResponse(response);

    }

    private void examinarRequest(ContainerRequestContext request) {
        System.out.println("Request * * *-------------");
        request.getHeaders().forEach((k, v) -> {
            System.out.println(k + "  " + v.toString());

        });
        System.out.println("--------------------------");

    }

    protected void examinarResponse(ContainerResponseContext response) {

        System.out.println("Response * * *-------------");
        response.getHeaders().forEach((k, v) -> {
            System.out.println(k + "  " + v.toString());

        });
        System.out.println("--------------------------");

    }

    private String getHttpMethodOverride(ContainerRequestContext request) {
        String headerValue = request.getHeaderString("access-control-request-method");
            return headerValue;
    }
}
