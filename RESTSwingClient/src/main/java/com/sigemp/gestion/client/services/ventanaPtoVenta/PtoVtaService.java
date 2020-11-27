/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigemp.gestion.client.services.ventanaPtoVenta;

import com.sigemp.gestion.client.services.RESTService;
import com.sigemp.common.exception.SgException;
import com.sigemp.gestion.shared.dto.ventanaPtoVenta.OpcionesContadorDto;
import com.sigemp.gestion.shared.dto.ventanaPtoVenta.PtoVtaDto;
import com.sigemp.gestion.shared.entity.GsyTalonarios;
import java.util.List;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author sigem
 */
public class PtoVtaService extends RESTService {

    WebTarget target = getTarget().path(RESTService.ServicePoint.SERVICE_PANTALLA_PTOVTA.getParam());

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
        throw new SgException("No Implementado");
    }

    public GsyTalonarios getDtoNew() throws SgException {
        throw new SgException("No Implementado");
    }

    public void deletePtoVta(Integer talId) throws SgException {
        throw new SgException("No Implementado");
    }

    public List<PtoVtaDto> getPtoVtas(Integer ptoVtaId, String des) throws SgException {
        WebTarget tar = target.path("ptovtas");
        try {

            if (des.trim().length() != 0) {
                tar = tar.queryParam("des", des);
            }

            Response res = tar
                    //.path("ptovtas")
                    .request()
                    .accept(MediaType.APPLICATION_JSON)
                    .get();

            List<PtoVtaDto> listDto = (List<PtoVtaDto>) res.readEntity(new GenericType<List<PtoVtaDto>>() {
            });
            return listDto;
        } catch (Exception ex) {
            throw new SgException("Error " + " URI: " + tar.getUri().toASCIIString(), ex);
        }
    }

    public OpcionesContadorDto getOpcionesVtaDtos(String tipoContador) throws SgException {
        WebTarget tar = target.path("opcionesContador");
        try {

            Response res = tar
                    .request()
                    .accept(MediaType.APPLICATION_JSON)
                    .get();

            OpcionesContadorDto opcionesContadorDto = res.readEntity(OpcionesContadorDto.class);
            return opcionesContadorDto;
        } catch (Exception ex) {
            throw new SgException("Error " + " URI: " + tar.getUri().toASCIIString(), ex);
        }
    }

}
