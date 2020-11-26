/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigemp.gestion.server.services;

import com.sigemp.gestion.shared.entity.VtaCajConcepto;
import com.sigemp.server.actualizaciones.Secured;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author cristian
 */
@Secured
@Stateless
@Path("/vtacajconcepto")
public class VtaCajConceptoFacadeREST  {

    @PersistenceContext(unitName = "CustomerService")
    private EntityManager em;
    
    @Context
    HttpServletRequest httpRequest;
    
    
    AbstractFacadeHelper<VtaCajConcepto> helper;

    @PostConstruct
    public void VtaCajConceptoFacadeREST() {
        helper = new AbstractFacadeHelper<>(VtaCajConcepto.class,em);
    }

    @POST
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response create(VtaCajConcepto entity) {
        entity.setDes(entity.getDes().toUpperCase());
        helper.create(entity);
        return Response
                .ok(entity.getConceptoId(),MediaType.TEXT_PLAIN)
                .build();
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response edit(@PathParam("id") Integer id, VtaCajConcepto entity) {
        entity.setDes(entity.getDes().toUpperCase());
        VtaCajConcepto entityNew = helper.edit(entity);
        return Response
                .ok(entityNew.getConceptoId(),MediaType.TEXT_PLAIN)
                .build();
        
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        helper.remove(helper.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public VtaCajConcepto find(@PathParam("id") Integer id) {
         return helper.find(id);
    }

    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<VtaCajConcepto> findAll() {
        return helper.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<VtaCajConcepto> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return helper.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(helper.count());
    }

    
}
