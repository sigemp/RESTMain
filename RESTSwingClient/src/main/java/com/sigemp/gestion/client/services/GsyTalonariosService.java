/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigemp.gestion.client.services;

import com.sigemp.common.exception.SgException;
import com.sigemp.gestion.shared.dto.GsyProvDto;
import com.sigemp.gestion.shared.dto.GsyTalonariosDto;
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

    public GsyTalonariosDto findDtoById(Integer id) throws SgException {
        try {
            GsyTalonariosDto cu = target
                    .path(String.valueOf(id))
                    .request()
                    //.accept(MediaType.APPLICATION_XML)
                    .get(GsyTalonariosDto.class);
            return cu;
        } catch (Exception ex) {
            throw new SgException("Error", ex);
        }
    }

    public List<GsyTalonariosDto> getDtoList() throws SgException {
        return new ArrayList<GsyTalonariosDto>();
    }

    public GsyTalonariosDto getDtoNew() throws SgException {
        return null;
    }

    public void deletePtoVta(Integer talId)  throws SgException {
    }
}
