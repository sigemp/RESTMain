/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigemp.gestion.client.services;

import com.sigemp.common.exception.SgException;
import com.sigemp.gestion.shared.dto.GsyProvDto;
import com.sigemp.gestion.shared.dto.GsySucDto;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author sigem
 */
public class GsySucService extends RESTService {

    WebTarget target = getTarget().path(RESTService.ServicePoint.SERVICE_SUCURSAL.getParam());

    public List<GsySucDto> restList() throws Exception {
        try {
            Response res = target
                    //.path("ptovtas")
                    .request()
                    .accept(MediaType.APPLICATION_JSON)
                    .get();

            if (res.getStatus() != Response.Status.OK.getStatusCode()) {
                analizeError(res);
            }

            List<GsySucDto> listCu = (List<GsySucDto>) res.readEntity(new GenericType<List<GsySucDto>>() {
            });
            return listCu;
        } catch (Exception ex) {
            throw new SgException("Error " + " URI: " + target.getUri().toASCIIString(), ex);

        }
    }

}
