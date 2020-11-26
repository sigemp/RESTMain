/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigemp.gestion.client.service;

import com.sigemp.gestion.shared.entity.GsyUser;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import org.fusesource.restygwt.client.MethodCallback;
import org.fusesource.restygwt.client.RestService;

/**
 *
 * @author Server
 */
@Path("/gsyuser")
public interface GsyUserService extends RestService {

    @GET
    @Path("{id}")
    public void find(@PathParam("id") String id,
            MethodCallback<GsyUser> callback);

    @GET
    public void findAll(MethodCallback<List<GsyUser>> callback);
}
