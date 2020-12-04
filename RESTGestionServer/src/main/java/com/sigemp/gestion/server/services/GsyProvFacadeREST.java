/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigemp.gestion.server.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sigemp.gestion.shared.entity.GsyProv;
import java.util.ArrayList;
import java.util.List;
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
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.ws.WebServiceException;

/**
 *
 * @author cristian
 */
@Stateless
@Path("/gsyprov")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class GsyProvFacadeREST extends AbstractFacade<GsyProv> {

    private static final Logger LOG = Logger.getLogger(GsyProvFacadeREST.class.getName());

    @Context
    private HttpServletRequest request;

    @PersistenceContext(unitName = "CustomerService")
    private EntityManager em;

    public GsyProvFacadeREST() {
        super(GsyProv.class);
    }

    @POST
    @Override
    public void create(GsyProv entity) {
        em.persist(entity);
    }

    @PUT
    @Path("{id}")
    public void edit(@PathParam("id") Integer id, GsyProv entity) {
        GsyProv pp = find(id);
        if (pp == null) {
            WebApplicationException webApplicationException = new WebApplicationException(Response.Status.NOT_FOUND);
            throw webApplicationException;
        }
        em.merge(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    public GsyProv find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    /**
     * Retorna un Entity con valores por omision
     *
     * @return
     */
    @GET
    @Path("newentity")
    public GsyProv restNewEntity() {
        GsyProv prov = new GsyProv();
        prov.setProvId(0);
        prov.setDes("default");
        return prov;
    }

    @GET
    @Path("findAll")
    public Response findAll(@QueryParam("start") int start,
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

            CriteriaQuery cq = cb.createQuery(GsyProv.class);

            Root<GsyProv> gsyProv = cq.from(GsyProv.class);

            EntityType<GsyProv> type = em.getMetamodel().entity(GsyProv.class);

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
                                ), cb.lower(cb.literal("%" + des.trim() + "%")))
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

            GenericEntity<List<GsyProv>> entity
                    = new GenericEntity<List<GsyProv>>(q.getResultList()) {
            };

            Response res = Response
                    .ok(entity)
                    .header("pagable", str)
                    .build();

            String st = request.getSession().getId();
            LOG.info(st);

            return res;

        } catch (Exception ex) {
            LOG.severe(ex.getMessage());
            throw new WebServiceException(ex.getMessage());
        }
    }
    
    @GET
    @Path("provincias")
    public Response findAll2(@QueryParam("start") int start,
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

            CriteriaQuery cq = cb.createQuery(GsyProv.class);

            Root<GsyProv> gsyProv = cq.from(GsyProv.class);

            EntityType<GsyProv> type = em.getMetamodel().entity(GsyProv.class);

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
                                ), cb.lower(cb.literal("%" + des.trim() + "%")))
                );
            }

            // para saber si tiene un criterio o mas de uno
            if (criteria.size() == 1) {
                cq.where(criteria.get(0));
            } else {
                cq.where(cb.and(criteria.toArray(new Predicate[0])));
            }

            int cnt = count(em, cq).intValue();

            // Ordena por nombre
            cq.orderBy(cb.asc(gsyProv.get("des")));

            Query q = em.createQuery(cq);


            // el tamaño no puede ser 0
            if (size <= 10) {
                size = 10;
            }
            q.setMaxResults(size);
            q.setFirstResult(start);

            GenericEntity<List<GsyProv>> entity
                    = new GenericEntity<List<GsyProv>>(q.getResultList()) {
            };

            Response res = Response
                    .ok(entity)
                    .header("query_count", cnt)
                    .build();

            String st = request.getSession().getId();
            LOG.info(st);

            return res;

        } catch (Exception ex) {
            LOG.severe(ex.getMessage());
            throw new WebServiceException(ex.getMessage());
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

    @GET
    @Path("{from}/{to}")
    public List<GsyProv> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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
