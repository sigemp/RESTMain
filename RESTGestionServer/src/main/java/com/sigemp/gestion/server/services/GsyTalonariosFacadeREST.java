/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigemp.gestion.server.services;

import com.sigemp.gestion.shared.dto.GsyTalonariosDto;
import com.sigemp.gestion.shared.entity.GsyTalonarios;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
import javax.ws.rs.core.Response;

/**
 *
 * @author cristian
 */
@Stateless
@Path("/gsytalonarios")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class GsyTalonariosFacadeREST extends AbstractFacade<GsyTalonarios> {

    
    private static final Logger LOG = Logger.getLogger(GsyTalonariosFacadeREST.class.getName());
    
    @PersistenceContext(unitName = "CustomerService")
    private EntityManager em;

    public GsyTalonariosFacadeREST() {
        super(GsyTalonarios.class);
    }

    @POST
    public Response restCreate(GsyTalonariosDto dto) {
        
        try {
            if (dto == null) {
                return responseError(Response.Status.BAD_REQUEST, "Dto es null");
            }
            
            dto.setFeTa("");
            GsyTalonarios entity = new Convert(em).toEntity(dto);          
            em.persist(entity);
            em.flush();
            return Response.ok().entity(entity.getTalId()).build();
        } catch (Exception ex) {
            LOG.log(Level.SEVERE, null, ex);
            return responseError(Response.Status.BAD_REQUEST, ex.getMessage());
        }
        
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
    public Response restFind(@PathParam("id") Integer id) {
        try {
            GsyTalonarios entity = super.find(id);
            if (entity == null) {
                return responseNotFound(Response.Status.NOT_FOUND, "No Existe");
            }
            GsyTalonariosDto dto = new Convert(em).toDto(entity);
            return Response.ok().entity(dto).build();
        } catch (Exception ex) {
            LOG.log(Level.SEVERE, null, ex);
            return responseError(Response.Status.BAD_REQUEST, ex.getMessage());
        }
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
