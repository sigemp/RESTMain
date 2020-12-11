/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigemp.gestion.server.services;

import static com.sigemp.gestion.server.services.AbstractFacade.extractHeaders;
import com.sigemp.gestion.shared.dto.GsyCertificadosDto;
import com.sigemp.gestion.shared.dto.ventanaCertificados.ListCertificadoDto;
import com.sigemp.gestion.shared.entity.GsyCertificados;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.EntityType;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author cristian
 */
@Stateless
@Path("/gsycertificados")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class GsyCertificadosFacadeREST extends AbstractFacade<GsyCertificados> {

    private static final Logger LOG = Logger.getLogger(GsyCertificadosFacadeREST.class.getName());

    @PersistenceContext(unitName = "CustomerService")
    private EntityManager em;

    public GsyCertificadosFacadeREST() {
        super(GsyCertificados.class);
    }

    @POST
    public Response restCreate(GsyCertificadosDto dto) {
        try {
            if (dto == null) {
                return responseError(Response.Status.BAD_REQUEST, "Dto es null");
            }
            dto.setCerId(null);
            dto.setFec(new Date());
            dto.setFeTa("");
            GsyCertificados entity = new Convert(em).toEntity(dto);          
            em.persist(entity);
            em.flush();
            return Response.ok().entity(entity.getCerId()).build();
        } catch (Exception ex) {
            LOG.log(Level.SEVERE, null, ex);
            return responseError(Response.Status.BAD_REQUEST, ex.getMessage());
        }
    }

    @PUT
    @Path("{id}")
    public Response restEdit(@PathParam("id") Integer id, GsyCertificadosDto dto) {
        try {
            if (dto == null) {
                return responseError(Response.Status.BAD_REQUEST, "Dto es null");
            }
            GsyCertificados entity = new Convert(em).toEntity(dto);
            
            GsyCertificados entityold = super.find(dto.getCerId());
            
            entity.setDes(entity.getDes().toUpperCase().trim());
            entity.setFeTa(entityold.getFeTa());
            entity.setFec(entityold.getFec());
            
            em.merge(entity);
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
    public Response restFind(@PathParam("id") Integer id) {
        try {
            GsyCertificados entity = super.find(id);
            if (entity == null) {
                return responseNotFound(Response.Status.NOT_FOUND, "No Existe");
            }
            GsyCertificadosDto dto = new Convert(em).toDto(entity);
            return Response.ok().entity(dto).build();
        } catch (Exception ex) {
            LOG.log(Level.SEVERE, null, ex);
            return responseError(Response.Status.BAD_REQUEST, ex.getMessage());
        }
    }

    @GET
    public Response restListAll() {
        try {
            List<GsyCertificadosDto> listDto = new ArrayList<>();
            super.findAll().stream().forEach(e -> {
                listDto.add(new Convert(em).toDto(e));
            });

            GenericEntity<List<GsyCertificadosDto>> genericlistDto = new GenericEntity<List<GsyCertificadosDto>>(listDto) {
            };

            return Response
                    .ok(genericlistDto)
                    .build();
        } catch (Exception ex) {
            LOG.log(Level.SEVERE, null, ex);
            return responseError(Response.Status.BAD_REQUEST, ex.getMessage());
        }
    }

////    @GET
////    @Path("{from}/{to}")
////    public List<GsyCertificadosDto> restFindRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
////        List<GsyCertificadosDto> listDto = new ArrayList<>();
////        super.findRange(new int[]{from, to}).stream().forEach(e -> {
////            listDto.add(Convert.toDto(e));
////        });
////        return listDto;
////
////    }
    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String restCount() {
        return String.valueOf(super.count());
    }
    
    @GET
    @Path("newentity")
    public GsyCertificadosDto restNewEntity() {
        GsyCertificadosDto prov = new GsyCertificadosDto();
        prov.setCerId(0);
        prov.setDes("default");
        prov.setFeCertificado("");
        prov.setFePrivatekey("");
        prov.setFeTa("");
        prov.setFec(new Date());
        prov.setTipo(GsyCertificadosDto.TIPO_CERTIFICADO.PRODUCCION.name());
        prov.setActivo(Boolean.TRUE);

        return prov;
    }

    /**
     * Retorna GenericEntity List&lt;ListCertificadoDto&gt;
     *
     *
     * @param start
     * @param size
     * @param des
     * @return
     */
    @GET
    @Path("findAll")
    public Response restListView(@QueryParam("start") int start,
            @QueryParam("size") int size,
            @QueryParam("des") String des) {

        extractHeaders(httpRequest);
        StringBuilder sb = new StringBuilder();

        try {

            // system out
            String out = sb.append("Start:")
                    .append(start)
                    .append(" Size:")
                    .append(size)
                    .toString();

            LOG.info(out);

            CriteriaBuilder cb = em.getCriteriaBuilder();

            CriteriaQuery cq = cb.createQuery(GsyCertificados.class);

            Root<GsyCertificados> gsyProv = cq.from(GsyCertificados.class);

            EntityType<GsyCertificados> type = em.getMetamodel().entity(GsyCertificados.class);

            List<Predicate> criteria = new ArrayList<>();

            // Filtro por descripcion
            if (des != null) {
//            criteria.add(cb.like(gsyProv.get("des"), "%" + des.trim().toUpperCase() + "%"));
                criteria.add(
                        cb.like(
                                cb.lower(
                                        gsyProv.get(
                                                type.getDeclaredSingularAttribute("des", String.class)
                                        )
                                ), cb.lower(cb.literal("%" + des.toUpperCase().trim() + "%")))
                );
            }

            // para saber si tiene un criterio o mas de uno
            if (criteria.size() == 1) {
                cq.where(criteria.get(0));
            } else {
                cq.where(cb.and(criteria.toArray(new Predicate[0])));
            }

            //Query qCount = em.createQuery(cq.select(cb.count(gsyProv)));
//int cnt = ((Long) qCount.getSingleResult()).intValue();
            // Intento por extraer el sql del query
            //String ss = q.unwrap(EJBQueryImpl.class).getDatabaseQuery().getSQLString();
            //int cnt = count();
            int cnt = count(em, cq).intValue();

            // Ordena por nombre
            cq.orderBy(cb.asc(gsyProv.get("des")));

            Query q = em.createQuery(cq);

            PageableDto dto = new PageableDto();
            dto.setCount(cnt);

            String str = getPageableString(dto);

            // el tamaño no puede ser 0
            if (size <= 0) {
                size = 100;
            }
            q.setMaxResults(size);
            q.setFirstResult(start);

            List<GsyCertificados> listEntity = (List<GsyCertificados>) q.getResultList();

            List<ListCertificadoDto> listDto = new Convert(em).toDto(listEntity);

            GenericEntity<List<ListCertificadoDto>> genericDto
                    = new GenericEntity<List<ListCertificadoDto>>(listDto) {
            };

            return Response
                    .ok(genericDto)
                    .header("pagable", str)
                    .build();

        } catch (Exception ex) {
            LOG.log(Level.SEVERE, null, ex);
            return responseError(Response.Status.BAD_REQUEST, ex.getMessage());
        }
    }

    @GET
    @Path("findview/{id}")
    public Response restFindView(@PathParam("id") Integer id) {
        try {
            GsyCertificados entity = super.find(id);
            if (entity == null) {
                return responseNotFound(Response.Status.NOT_FOUND, "No Existe");
            }
            ListCertificadoDto dto = new Convert(em).toDtoView(super.find(id));
            return Response.ok().entity(dto).build();
        } catch (Exception e) {
            return responseError(Response.Status.BAD_REQUEST, "Error");
        }
    }

    public static Long count(final EntityManager em, final CriteriaQuery<?> criteria) {
        final CriteriaBuilder builder = em.getCriteriaBuilder();
        final CriteriaQuery<Long> countCriteria = builder.createQuery(Long.class);
        countCriteria.select(builder.count(criteria.getRoots().iterator().next()));
        final Predicate groupRestriction = criteria.getGroupRestriction(),
                fromRestriction = criteria.getRestriction();
        if (groupRestriction != null) {
            countCriteria.having(groupRestriction);
        }
        if (fromRestriction != null) {
            countCriteria.where(fromRestriction);
        }
        countCriteria.groupBy(criteria.getGroupList());
        countCriteria.distinct(criteria.isDistinct());
        return em.createQuery(countCriteria).getSingleResult();
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

}
