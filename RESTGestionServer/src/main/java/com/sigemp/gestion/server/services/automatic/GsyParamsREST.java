/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigemp.gestion.server.services.automatic;

import com.sigemp.gestion.shared.entity.GsyConf;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

/**
 *
 * @author cristian
 */
@Stateless
@Path("/config")
public class GsyParamsREST {

    @PersistenceContext(unitName = "CustomerService")
    private EntityManager em;

    @Context
    HttpServletRequest httpRequest;

    /**
     * Genera el link del listado y lo pasa al cliente para que lo descargue
     *
     *
     * @param list
     * @return
     */
    @POST
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response getParametros(List<String> list) {

        if (list == null || list.isEmpty()) {
            throw new WebApplicationException(400);
        }

        //String keys = ListToSQLString(list);
        Query q = em.createQuery("SELECT p FROM GsyConf p WHERE p.pmtId in :inlist");
        q.setParameter("inlist", list);
        List<GsyConf> list2 = q.getResultList();

        Map<String, String> map = new HashMap<>();

        list2.forEach((val) -> {
            map.put(val.getPmtId(), val.getValor());
        });

        return Response.status(Status.OK).entity(map).build();

    }

    public static String ListToSQLString(List<String> list) {
        StringBuilder sb = new StringBuilder();
        for (String s : list) {
            sb.append("\'").append(s).append("\'").append(",");
        }
        int x = sb.lastIndexOf(",");
        StringBuilder ss = sb.deleteCharAt(x);
        return ss.toString();
    }

}
