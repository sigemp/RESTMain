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

    public List<GsySucDto> getList() {
        return new ArrayList<>();
    }

     public List<GsySucDto> getAll() throws Exception {
        try {
            Response res = target
                    //.path("ptovtas")
                    .request()
                    .accept(MediaType.APPLICATION_JSON)
                    .get();
            List<GsySucDto> listCu = (List<GsySucDto>) res.readEntity(new GenericType<List<GsySucDto>>() {
            });
            return listCu;
        } catch (Exception ex) {
            throw new SgException("Error " + " URI: " + target.getUri().toASCIIString(), ex);

        }
    }
     
    
//    public PageableWrapper<GsyProv> getList(HashMap<String, Object> map, long start, long size) throws Exception {
//        try {
//            if (map == null) {
//                map = new HashMap<>();
//            }
//
//            WebTarget wtar = target.path(ParamSite.PATH_GSY_PROV_LIST.getParam());
//
//            wtar = wtar.queryParam("start", start);
//            wtar = wtar.queryParam("size", size);
//
//            String des = (String) map.get("des");
//            if (des != null && des.length() > 0) {
//                wtar = wtar.queryParam("des", des);
//            }
//
//            // Obtengo la respuesta
//            Response res = wtar.request().accept(MediaType.APPLICATION_XML)
//                    //.cookie("JSESSIONID","d235605938768cd6b5abe6e02c74")
//                    .get();
//
//            int cnt = getIntFromString(res.getHeaderString("query_count"));
//
//            // saco informacion de pageable del header
//            PageableWrapper<GsyProv> dto = getPageableCount(cnt);
//
//            // Obtengo la lista de la respuesta
//            List<GsyProv> listCu = (List<GsyProv>) res.readEntity(new GenericType<List<GsyProv>>() {
//            });
//
//            dto.setList(listCu);
//
//            return dto;
//        } catch (ProcessingException e) {
//            throw new Exception("Conexion rechazada\n" + e);
//        } catch (Exception ex) {
//            throw new Exception(ex);
//        }
//
//    }

}
