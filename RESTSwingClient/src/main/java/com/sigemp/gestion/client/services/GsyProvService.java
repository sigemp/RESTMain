/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigemp.gestion.client.services;

import com.sigemp.client.dto.PageableWrapper;
import com.sigemp.gestion.shared.dto.GsyProvDto;
import java.util.HashMap;
import java.util.List;
import javax.ws.rs.ProcessingException;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Server
 */
public class GsyProvService extends RESTService {

    WebTarget target = getTarget().path(RESTService.ServicePoint.SERVICE_PROVINCIA.getParam());

    public Integer restCreate(GsyProvDto entity) throws Exception {
        try {
            Response res = target
                    .request()
                    .post(Entity.json(entity));

            if (res.getStatus() != Response.Status.OK.getStatusCode()) {

                analizeError(res);
            }
            Integer id = res.readEntity(Integer.class);

            return id;
        } catch (Exception ex) {
            throw new Exception(ex);
        }

    }

    public void restRemove(long id) throws Exception {
        try {
            Response res = target
                    .path(String.valueOf(id))
                    .request()
                    .delete();

            if (res.getStatus() != Response.Status.NO_CONTENT.getStatusCode()) {
                analizeError(res);
            }
        } catch (Exception ex) {
            throw new Exception(ex);
        }
    }

    public GsyProvDto restNewEntity() throws Exception {
        try {
            Response res = target
                    .path("newentity")
                    .request()
                    .get();

            if (res.getStatus() != Response.Status.OK.getStatusCode()) {
                analizeError(res);
            }

            GsyProvDto dto = res.readEntity(GsyProvDto.class);

            return dto;
        } catch (Exception ex) {
            throw new Exception(ex);
        }
    }

    public void restEdit(GsyProvDto entity) throws Exception {
        try {
            Response res = target
                    .path(entity.getProvId().toString()) // el id del registro a editar
                    .request()
                    .put(Entity.json(entity));
            if (res.getStatus() != Response.Status.NO_CONTENT.getStatusCode()) {
                analizeError(res);
            }
        } catch (Exception ex) {
            throw new Exception(ex);
        }

    }

    public PageableWrapper<GsyProvDto> restList(HashMap<String, Object> map, long start, long size) throws Exception {
        if (map == null) {
            map = new HashMap<>();
        }

        WebTarget wtar = target.path(ServicePath.PATH_PROVINCIAS.getParam());
        try {

            wtar = wtar.queryParam("start", start);
            wtar = wtar.queryParam("size", size);

            String des = (String) map.get("des");
            if (des != null && des.length() > 0) {
                wtar = wtar.queryParam("des", des);
            }

            // Obtengo la respuesta
            Response res = wtar.request()
                    .get();

            if (res.getStatus() != Response.Status.OK.getStatusCode()) {
                analizeError(res);
            }

            int cnt = getIntFromString(res.getHeaderString("query_count"));

            // saco informacion de pageable del header
            PageableWrapper<GsyProvDto> dto = getPageableCount(cnt);

            // Obtengo la lista de la respuesta
            List<GsyProvDto> listCu = (List<GsyProvDto>) res.readEntity(new GenericType<List<GsyProvDto>>() {
            });

            dto.setList(listCu);

            return dto;
        } catch (ProcessingException e) {
            throw new Exception("Conexion rechazada\nURL:" + wtar.getUri().toASCIIString() + "\n" + e);
        } catch (Exception ex) {
            throw new Exception(ex);
        }

    }

    public GsyProvDto restFind(long id) throws Exception {
        try {
            Response res = target
                    .path(String.valueOf(id))
                    .request()
                    .get();

            if (res.getStatus() != Response.Status.OK.getStatusCode()) {
                analizeError(res);
            }

            GsyProvDto dto = res.readEntity(GsyProvDto.class);
            return dto;
        } catch (Exception ex) {
            throw new Exception(ex);
        }
    }

    private int getIntFromString(String headerString) {
        int x = 0;
        try {
            x = Integer.valueOf(headerString);
        } catch (NumberFormatException e) {

        }
        return x;
    }

}
