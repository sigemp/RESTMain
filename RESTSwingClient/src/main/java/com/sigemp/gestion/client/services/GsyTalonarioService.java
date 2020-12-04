/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigemp.gestion.client.services;

import com.sigemp.gestion.shared.dto.GsyTalonariosDto;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

/**
 *
 * @author Server
 */
public class GsyTalonarioService extends RESTService {

    WebTarget target = getTarget().path(RESTService.ServicePoint.SERVICE_TALONARIO.getParam());

    public Integer restCreate(GsyTalonariosDto entity) throws Exception {
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

    public GsyTalonariosDto restNewEntity() throws Exception {
        try {
            Response res = target
                    .path("newentity")
                    .request()
                    .get();

            if (res.getStatus() != Response.Status.OK.getStatusCode()) {
                analizeError(res);
            }

            GsyTalonariosDto dto = res.readEntity(GsyTalonariosDto.class);

            return dto;
        } catch (Exception ex) {
            throw new Exception(ex);
        }
    }

    public void restEdit(GsyTalonariosDto entity) throws Exception {
        try {
            Response res = target
                    .path(entity.getTalId().toString()) // el id del registro a editar
                    .request()
                    .put(Entity.json(entity));
            if (res.getStatus() != Response.Status.NO_CONTENT.getStatusCode()) {
                analizeError(res);
            }
        } catch (Exception ex) {
            throw new Exception(ex);
        }

    }

    public GsyTalonariosDto restFind(long id) throws Exception {
        try {
            Response res = target
                    .path(String.valueOf(id))
                    .request()
                    .get();

            if (res.getStatus() != Response.Status.OK.getStatusCode()) {
                analizeError(res);
            }

            GsyTalonariosDto dto = res.readEntity(GsyTalonariosDto.class);
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
