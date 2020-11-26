/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigemp.gestion.client.services;

import com.sigemp.gestion.shared.entity.GsyTalonarios;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

/**
 *
 * @author Server
 */
public class GsyTalonarioService extends RESTService {

    WebTarget target = getTarget().path(RESTService.ServicePoint.SERVICE_TALONARIO.getParam());

    public void create(GsyTalonarios entity) throws Exception {
        try {
            Response res = target
                    .request()
                    .post(Entity.json(entity));

            if (res.getStatus() != Response.Status.NO_CONTENT.getStatusCode()) {
                String str = analize(res, "creando :");
                throw new Exception(str);
            }
        } catch (Exception ex) {
            throw new Exception(ex);
        }

    }

    public void remove(long id) throws Exception {

        try {
            Response res = target
                    .path(String.valueOf(id))
                    .request()
                    .delete();

            if (res.getStatus() != Response.Status.NO_CONTENT.getStatusCode()) {
                String str = analize(res, "delete :");
                throw new Exception(str);
            }
        } catch (Exception ex) {
            throw new Exception(ex);
        }
    }

    public GsyTalonarios getNew() throws Exception {
        try {
            GsyTalonarios res = target
                    .path("newentity")
                    .request().get(GsyTalonarios.class);

            return res;
        } catch (Exception ex) {
            throw new Exception(ex);
        }
    }

    public void edit(GsyTalonarios entity) throws Exception {
        try {
            Response res = target
                    .path(entity.getTalId().toString()) // el id del registro a editar
                    .request()
                    .put(Entity.json(entity));
            if (res.getStatus() != Response.Status.NO_CONTENT.getStatusCode()) {
                String str = analize(res, "delete :");
                throw new Exception(str);
            }
        } catch (Exception ex) {
            throw new Exception(ex);
        }

    }

    public GsyTalonarios find(long id) throws Exception {
        try {
            GsyTalonarios cu = target
                    .path(String.valueOf(id))
                    .request()
                    .get(GsyTalonarios.class);
            return cu;
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
