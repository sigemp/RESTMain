/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigemp.gestion.client.services.ventanaPtoVenta;

import com.sigemp.common.StringUtils;
import com.sigemp.gestion.client.services.RESTService;
import com.sigemp.common.exception.SgException;
import com.sigemp.gestion.shared.dto.ventanaPtoVenta.OpcionesContadorDto;
import com.sigemp.gestion.shared.dto.ventanaPtoVenta.PtoVtaDto;
import com.sigemp.gestion.shared.dto.GsyTalonariosDto;
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

    /**
     * Retorna los Ids de comprobantes Asociados a un Contador
     *
     *
     * @param tipoContador
     * @return
     */
    public List<Integer> getComprobantesByContador(Integer tipoContador) throws SgException {
        WebTarget tar = target.path("comprobantesByContadorId");
        try {

            Response res = tar
                    .queryParam("contadorId", tipoContador.toString())
                    .request()
                    .accept(MediaType.APPLICATION_JSON)
                    .get();

            String str = res.readEntity(String.class);

            
            List<Integer> z = StringUtils.getArrayInt(str);

            

            System.out.println(z.toString());


            return z;
        } catch (Exception ex) {
            throw new SgException("Error " + " URI: " + tar.getUri().toASCIIString(), ex);
        }
    }

    public List<GsyTalonariosDto> getDtoList() throws SgException {
        throw new SgException("No Implementado");
    }

    public GsyTalonariosDto getDtoNew() throws SgException {
        throw new SgException("No Implementado");
    }

    public void deletePtoVta(Integer talId) throws SgException {
        throw new SgException("No Implementado");
    }

    /**
     * Retorna los puntos de venta permite filtrar por descripcion
     *
     * @param ptoVtaId
     * @param des
     * @return
     * @throws SgException
     */
    public List<PtoVtaDto> getPtoVtas(Integer ptoVtaId, String des) throws SgException {
        WebTarget tar = target.path("ptovtas");
        try {

            if (des.trim().length() != 0) {
                tar = tar.queryParam("des", des);
            }

            Response res = tar
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
                    .queryParam("tipoContador",tipoContador)
                    .request()
                    .accept(MediaType.APPLICATION_JSON)
                    .get();

            if (res.getStatus() != 200) {
                throw new Exception("ErrorCode :" + res.getStatus() + tipoContador);
            }
            
            OpcionesContadorDto opcionesContadorDto = res.readEntity(OpcionesContadorDto.class);
            return opcionesContadorDto;
        } catch (Exception ex) {
            throw new SgException("Error " + " URI: " + tar.getUri().toASCIIString(), ex);
        }
    }

}
