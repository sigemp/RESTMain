/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigemp.gestion.server.services;

import com.sigemp.gestion.shared.dto.GsyContadoresDto;
import com.sigemp.gestion.shared.entity.GsyContadores;
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
@Path("/gsycontadores")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class GsyContadoresFacadeREST extends AbstractFacade<GsyContadores> {

    private static final Logger LOG = Logger.getLogger(GsyContadoresFacadeREST.class.getName());

    @PersistenceContext(unitName = "CustomerService")
    private EntityManager em;

    public GsyContadoresFacadeREST() {
        super(GsyContadores.class);
    }

    @POST
    public Response restCreate(GsyContadoresDto dto) {
        try {
            if (dto == null) {
                return responseError(Response.Status.BAD_REQUEST, "Dto es null");
            }
            GsyContadores entity = new Convert(em).toEntity(dto);
            
            //Agrego las relaciones
            entity.setGsyContadorestiposCollection(gsyContadorestiposCollection);
        //entity.setTalId(dto.getTalId());

            
            em.persist(entity);
            em.flush();
            return Response.ok().entity(entity.getConId()).build();
        } catch (Exception ex) {
            LOG.log(Level.SEVERE, null, ex);
            return responseError(Response.Status.BAD_REQUEST, ex.getMessage());
        }
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, GsyContadores entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public GsyContadoresDto find(@PathParam("id") Integer id) {
        GsyContadores entity = super.find(id);
        GsyContadoresDto dto = new Convert(em).toDto(entity);

        return dto;
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<GsyContadores> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<GsyContadores> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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
