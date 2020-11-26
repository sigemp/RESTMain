/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigemp.gestion.client.services;

import com.sigemp.common.exception.SgException;
import com.sigemp.gestion.shared.entity.GsyProv;
import com.sigemp.gestion.shared.entity.GsyTalonarios;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author sigem
 */
public class GsyTalonariosService extends RESTService {

    WebTarget target = getTarget().path(RESTService.ServicePoint.SERVICE_TALONARIO.getParam());

    public GsyTalonarios findDtoById(Integer id) throws SgException {
        try {
            GsyTalonarios cu = target
                    .path(String.valueOf(id))
                    .request()
                    //.accept(MediaType.APPLICATION_XML)
                    .get(GsyTalonarios.class);
            return cu;
        } catch (Exception ex) {
            throw new SgException("Error", ex);
        }
    }

    public List<GsyTalonarios> getDtoList() throws SgException {
        return new ArrayList<GsyTalonarios>();
    }

    public GsyTalonarios getDtoNew() throws SgException {
        return null;
    }

    public void deletePtoVta(Integer talId)  throws SgException {
    }
}
