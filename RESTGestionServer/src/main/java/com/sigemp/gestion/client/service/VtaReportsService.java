/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigemp.gestion.client.service;

import com.sigemp.gestion.shared.dto.EntryDto;
import java.util.Map;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import org.fusesource.restygwt.client.MethodCallback;
import org.fusesource.restygwt.client.RestService;

/**
 *
 * @author cristian
 */
@Path("/vta_report")
public interface VtaReportsService extends RestService {
    /**
     * Genera el link del listado y lo pasa al cliente para que lo descargue
     * 
     * 
     * @param map
     * @param callback
     * @return 
     */
    @POST
    @Path("/listado_ventas")
    public void getReportVentas(Map<String, String> map,MethodCallback<EntryDto> callback);
    
//    @GET
//    @Path("/down")
//    public void getFile(String filename,String inline,MethodCallback<Void> callback);


////    @POST
////    @Path("/listado_ventas_test2")
////    public void getReportVentasTest(Map<String, String> map,MethodCallback<Response> callback);
    

}
