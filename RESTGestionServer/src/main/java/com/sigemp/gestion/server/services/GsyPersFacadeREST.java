/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigemp.gestion.server.services;

import com.sigemp.gestion.shared.entity.GsyPers;
import com.sigemp.gestion.shared.dto.PersonasDto;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author cristian
 */
@Stateless
@Path("/gsypers")
public class GsyPersFacadeREST extends AbstractFacade<GsyPers> {

    @PersistenceContext(unitName = "CustomerService")
    private EntityManager em;

    public GsyPersFacadeREST() {
        super(GsyPers.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(GsyPers entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Long id, GsyPers entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Long id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public GsyPers find(@PathParam("id") Long id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<GsyPers> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<GsyPers> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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
    
    @GET
    @Path("fillDto")
    public List<PersonasDto> findDto(@QueryParam("search") String search) {
        
        String buscar = "%" + search.toUpperCase().trim() + "%";
        Query query = em.createQuery("SELECT p FROM GsyPers p WHERE UPPER(p.nom) LIKE :text");
        query.setParameter("text",buscar);
        query.setMaxResults(100);
        
        List<GsyPers> res = query.getResultList();
        
        List<PersonasDto> pp = new ArrayList<>();
        
        for (GsyPers p : res) {
            PersonasDto ppa = new PersonasDto();
            ppa.setCtaId(p.getPersId());
            ppa.setNombre(p.getNom());
            ppa.setTipoResponsable("llenar");
            pp.add(ppa);
        }
        
        
        
        return pp;
    }
    
}
