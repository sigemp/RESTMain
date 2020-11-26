/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigemp.gestion.client.service;

import com.sigemp.gestion.shared.entity.VtaCajConcepto;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import org.fusesource.restygwt.client.MethodCallback;
import org.fusesource.restygwt.client.RestService;

/**
 *
 * @author Server
 */
@Path("/vtacajconcepto")
public interface VtaCajConceptoService extends RestService {

    @GET
    @Path("{id}")
    public void find(@PathParam("id") String id,
            MethodCallback<VtaCajConcepto> callback);

    @GET
    public void findAll(MethodCallback<List<VtaCajConcepto>> callback);

    @POST
    public void create(VtaCajConcepto entity, MethodCallback<Double> callback);

    @PUT
    @Path("{id}")
    public void edit(@PathParam("id") String id,
            VtaCajConcepto entity,
            MethodCallback<Double> callback);

}
