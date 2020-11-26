/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigemp.gestion.server.services;

import com.sigemp.gestion.shared.entity.GsyTalonarios;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author cristian
 */
@Stateless
@Path("/gsytalonarios")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class GsyTalonariosFacadeREST extends AbstractFacade<GsyTalonarios> {

    @PersistenceContext(unitName = "CustomerService")
    private EntityManager em;

    public GsyTalonariosFacadeREST() {
        super(GsyTalonarios.class);
    }

    @POST
    @Override
    public void create(GsyTalonarios entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    public void edit(@PathParam("id") Integer id, GsyTalonarios entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    public GsyTalonarios find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    public List<GsyTalonarios> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    public List<GsyTalonarios> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
