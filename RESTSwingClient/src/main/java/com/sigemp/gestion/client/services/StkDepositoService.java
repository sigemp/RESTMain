/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigemp.gestion.client.services;

import com.sigemp.common.exception.SgException;
import com.sigemp.gestion.shared.dto.GsySucDto;
import com.sigemp.gestion.shared.dto.StkDepositosDto;
import java.util.List;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Server
 */
public class StkDepositoService extends RESTService {

    WebTarget target = getTarget().path(RESTService.ServicePoint.SERVICE_DEPOSITOS.getParam());

    public List<StkDepositosDto> restList() throws Exception {
        try {
            Response res = target
                    //.path("ptovtas")
                    .request()
                    .accept(MediaType.APPLICATION_JSON)
                    .get();
            
            if (res.getStatus() != Response.Status.OK.getStatusCode()) {
                analizeError(res);
            }
            
            List<StkDepositosDto> listCu = (List<StkDepositosDto>) res.readEntity(new GenericType<List<StkDepositosDto>>() {
            });
            return listCu;
        } catch (Exception ex) {
            throw new SgException("Error " + " URI: " + target.getUri().toASCIIString(), ex);

        }
    }

    public Integer restCreate(StkDepositosDto entity) throws Exception {
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

    public StkDepositosDto restNewEntity() throws Exception {
        try {
            Response res = target
                    .path("newentity")
                    .request()
                    .get();

            if (res.getStatus() != Response.Status.OK.getStatusCode()) {
                analizeError(res);
            }

            StkDepositosDto dto = res.readEntity(StkDepositosDto.class);

            return dto;
        } catch (Exception ex) {
            throw new Exception(ex);
        }
    }

    public void restEdit(StkDepositosDto entity) throws Exception {
        try {
            Response res = target
                    .path(entity.getDepoId().toString()) // el id del registro a editar
                    .request()
                    .put(Entity.json(entity));
            if (res.getStatus() != Response.Status.NO_CONTENT.getStatusCode()) {
                analizeError(res);
            }
        } catch (Exception ex) {
            throw new Exception(ex);
        }

    }

    public StkDepositosDto restFind(long id) throws Exception {
        try {
            Response res = target
                    .path(String.valueOf(id))
                    .request()
                    .get();

            if (res.getStatus() != Response.Status.OK.getStatusCode()) {
                analizeError(res);
            }

            StkDepositosDto dto = res.readEntity(StkDepositosDto.class);
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
