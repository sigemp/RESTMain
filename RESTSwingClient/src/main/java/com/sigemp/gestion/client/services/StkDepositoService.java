/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigemp.gestion.client.services;

import com.sigemp.common.exception.SgException;
import com.sigemp.gestion.shared.entity.GsySuc;
import com.sigemp.gestion.shared.entity.StkDepositos;
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

     public List<StkDepositos> getAll() throws Exception {
        try {
            Response res = target
                    //.path("ptovtas")
                    .request()
                    .accept(MediaType.APPLICATION_JSON)
                    .get();
            List<StkDepositos> listCu = (List<StkDepositos>) res.readEntity(new GenericType<List<StkDepositos>>() {
            });
            return listCu;
        } catch (Exception ex) {
            throw new SgException("Error " + " URI: " + target.getUri().toASCIIString(), ex);

        }
    }
     
    public void create(StkDepositos entity) throws Exception {
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

    public StkDepositos getNew() throws Exception {
        try {
            StkDepositos res = target
                    .path("newentity")
                    .request().get(StkDepositos.class);

            return res;
        } catch (Exception ex) {
            throw new Exception(ex);
        }
    }

    public void edit(StkDepositos entity) throws Exception {
        try {
            Response res = target
                    .path(entity.getDepoId().toString()) // el id del registro a editar
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

    public StkDepositos find(long id) throws Exception {
        try {
            StkDepositos cu = target
                    .path(String.valueOf(id))
                    .request()
                    .get(StkDepositos.class);
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