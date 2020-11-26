/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigemp.gestion.server.services;

import java.util.Date;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Server
 */
@Stateless
@Path("/test")
public class RootResource {
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello(){
        return "Hello Test " + new Date().toString();
    }
}
