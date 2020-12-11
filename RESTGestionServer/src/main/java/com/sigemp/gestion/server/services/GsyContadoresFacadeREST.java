/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigemp.gestion.server.services;

import com.sigemp.gestion.shared.dto.GsyContadoresDto;
import com.sigemp.gestion.shared.entity.GsyContadores;
import com.sigemp.gestion.shared.entity.GsyContadorestipos;
import com.sigemp.gestion.shared.entity.GsyTalonarios;
import com.sigemp.gestion.shared.entity.GsyTiposcomprobantes;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
import javax.ws.rs.core.GenericEntity;
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

            if (dto.getTalId() == null) {
                return responseError(Response.Status.BAD_REQUEST, "Debe especificarce el ID del Punto de Venta");
            }

            if (dto.getConId() != null) {
                return responseError(Response.Status.BAD_REQUEST, "El ID del Contador debe ser null");
            }

            GsyContadores entity = new Convert(em).toEntity(dto);

            List<GsyContadorestipos> listNuevos = new ArrayList<>();

            //// Busco los que no estan  (los nuevos)
            for (Integer tc_id : dto.getComprobantes()) {
                GsyContadorestipos gsyContadorestipos = new GsyContadorestipos();
                GsyTiposcomprobantes referenceTcId = em.getReference(GsyTiposcomprobantes.class, tc_id);
                gsyContadorestipos.setConId(entity);
                gsyContadorestipos.setTcId(referenceTcId);
                listNuevos.add(gsyContadorestipos);
            }

            GsyTalonarios talonario = em.getReference(GsyTalonarios.class, dto.getTalId());
            entity.setGsyContadorestiposCollection(listNuevos);
            entity.setTalId(talonario);

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
    public Response restEdit(@PathParam("id") Integer id, GsyContadoresDto dto) {
        try {
            if (dto == null) {
                return responseError(Response.Status.BAD_REQUEST, "Dto es null");
            }

            if (dto.getTalId() == null) {
                return responseError(Response.Status.BAD_REQUEST, "Debe especificarce el ID del Punto de Venta");
            }

            if (dto.getConId() == null) {
                return responseError(Response.Status.BAD_REQUEST, "Debe especificarce el ID del Contador");
            }

            GsyContadores entity = new Convert(em).toEntity(dto);

            Query q = em.createQuery("select t FROM GsyContadorestipos t WHERE t.conId.conId = :conId");
            q.setParameter("conId", dto.getConId());
            List<GsyContadorestipos> listOld = q.getResultList();

            List<GsyContadorestipos> listExistentes = new ArrayList<>();
            List<GsyContadorestipos> listNuevos = new ArrayList<>();

            //// Busco los que no estan  (los nuevos)
            boolean noencontre;
            for (Integer tc_id : dto.getComprobantes()) {
                noencontre = true;
                for (GsyContadorestipos c : listOld) {
                    if (tc_id.equals(c.getTcId().getTcId())) {
                        noencontre = false;
                    }
                }
                if (noencontre) {
                    GsyContadorestipos gsyContadorestipos = new GsyContadorestipos();
                    GsyTiposcomprobantes referenceTcId = em.getReference(GsyTiposcomprobantes.class, tc_id);
                    gsyContadorestipos.setConId(entity);
                    gsyContadorestipos.setTcId(referenceTcId);
                    listNuevos.add(gsyContadorestipos);
                }
            }

            listOld.stream().filter(ct -> (dto.getComprobantes().contains(ct.getTcId().getTcId()))).forEachOrdered(ct -> {
                listExistentes.add(ct);
            });

            //Agrego las relaciones
            ArrayList<GsyContadorestipos> contadoresTipo = new ArrayList<>();
            contadoresTipo.addAll(listExistentes);
            contadoresTipo.addAll(listNuevos);

            GsyTalonarios talonario = em.getReference(GsyTalonarios.class, dto.getTalId());
            entity.setGsyContadorestiposCollection(contadoresTipo);
            entity.setTalId(talonario);

            em.persist(entity);
            em.flush();
            return Response.noContent().build();
        } catch (Exception ex) {
            LOG.log(Level.SEVERE, null, ex);
            return responseError(Response.Status.BAD_REQUEST, ex.getMessage());
        }
    }

    @DELETE
    @Path("{id}")
    public Response restRemove(@PathParam("id") Integer id) {
        try {
            super.remove(super.find(id));
            return Response.noContent().build();
        } catch (Exception ex) {
            LOG.log(Level.SEVERE, null, ex);
            return responseError(Response.Status.BAD_REQUEST, ex.getMessage());
        }
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response restFind(@PathParam("id") Integer id) {
        try {
            GsyContadores entity = super.find(id);
            if (entity == null) {
                return responseNotFound(Response.Status.NOT_FOUND, "No Existe");
            }
            GsyContadoresDto dto = new Convert(em).toDto(entity);
            return Response.ok().entity(dto).build();
        } catch (Exception ex) {
            LOG.log(Level.SEVERE, null, ex);
            return responseError(Response.Status.BAD_REQUEST, ex.getMessage());
        }
    }

    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response restListAll() {
        try {
            List<GsyContadoresDto> listDto = new ArrayList<>();
            super.findAll().stream().forEach(e -> {
                listDto.add(new Convert(em).toDto(e));
            });

            GenericEntity<List<GsyContadoresDto>> genericlistDto = new GenericEntity<List<GsyContadoresDto>>(listDto) {
            };

            return Response
                    .ok(genericlistDto)
                    .build();
        } catch (Exception ex) {
            LOG.log(Level.SEVERE, null, ex);
            return responseError(Response.Status.BAD_REQUEST, ex.getMessage());
        }
    }

//    @GET
//    @Path("{from}/{to}")
//    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
//    public List<GsyContadores> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
//        return super.findRange(new int[]{from, to});
//    }
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
