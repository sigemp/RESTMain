/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigemp.gestion.server.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sigemp.common.exception.SgStatusDto;
import java.util.Enumeration;
import java.util.List;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;

/**
 *
 * @author cristian
 * @param <T>
 */
public abstract class AbstractFacade<T> {

    private Class<T> entityClass;

    private static final Logger LOG = Logger.getLogger(AbstractFacade.class.getName());
    
    
    @Context
    HttpServletRequest httpRequest;

    public AbstractFacade(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    protected int getIntFromString(String value) {
        if (value == null) {
            return 0;
        }
        try {
            return Integer.valueOf(value);
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    protected abstract EntityManager getEntityManager();

    public void create(T entity) {

        getEntityManager().persist(entity);
    }

    public void edit(T entity) {

        getEntityManager().merge(entity);
    }

    public void remove(T entity) {

        getEntityManager().remove(getEntityManager().merge(entity));
    }

    public T find(Object id) {
        return getEntityManager().find(entityClass, id);
    }

    public List<T> findAll() {

        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        return getEntityManager().createQuery(cq).getResultList();
    }

    public List<T> findRange(int[] range) {

        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        javax.persistence.Query q = getEntityManager().createQuery(cq);
        q.setMaxResults(range[1] - range[0] + 1);
        q.setFirstResult(range[0]);
        return q.getResultList();
    }

    public int count() {

        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        javax.persistence.criteria.Root<T> rt = cq.from(entityClass);
        cq.select(getEntityManager().getCriteriaBuilder().count(rt));
        javax.persistence.Query q = getEntityManager().createQuery(cq);
        return ((Long) q.getSingleResult()).intValue();
    }

    public int getCount(javax.persistence.Query query, javax.persistence.criteria.CriteriaQuery cq) {

        javax.persistence.criteria.Root<T> rt = cq.from(entityClass);
        cq.select(getEntityManager().getCriteriaBuilder().count(rt));
        javax.persistence.Query q = getEntityManager().createQuery(cq);
        return ((Long) q.getSingleResult()).intValue();
    }

    /**
     * Analizo el request
     */
    public static void extractHeaders(HttpServletRequest httpRequest) {

        Enumeration<String> headerNames = httpRequest.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String header = headerNames.nextElement();
            System.out.println(header.toString() + "  " + httpRequest.getHeader(header));
        }
        System.out.println("--------------------------");

    }
    
    public String getPageableString(PageableDto dto) {
        String str = "";
        //Write JSON from java objects
        ObjectMapper mapper = new ObjectMapper();
        try {
            str = mapper.writeValueAsString(dto);
        } catch (JsonProcessingException ex) {
            LOG.severe(ex.getMessage());
        }
        return str;
    }
    
     public Response responseNotFound(Response.Status status, String msg) {
        Response.Status res = Response.Status.NOT_FOUND;
        SgStatusDto statusDto = new SgStatusDto("error", res.getStatusCode(), msg);
        return Response.status(res).entity(statusDto).build();
    }

    public Response responseError(Response.Status status, String msg) {
        Response.Status res = Response.Status.BAD_REQUEST;
        SgStatusDto statusDto = new SgStatusDto("error", res.getStatusCode(), msg);
        return Response.status(res).entity(statusDto).build();
    }

}
