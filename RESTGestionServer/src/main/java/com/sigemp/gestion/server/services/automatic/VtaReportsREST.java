/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigemp.gestion.server.services.automatic;

import com.sigemp.gestion.client.exception.SgException;
import com.sigemp.gestion.server.inferface.listados.ReportGenerateInterface;
import com.sigemp.gestion.shared.dto.EntryDto;
import com.sigemp.server.constantes.General;
import com.sigemp.server.entity.controladores.listados.ReportVentas;
import com.sigemp.gestion.server.exception.ListEmptyException;
import com.sigemp.gestion.server.services.AbstractFacade;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.StreamingOutput;
import javax.ws.rs.core.UriInfo;

/**
 *
 * @author cristian
 */
@Stateless
@Path("/vta_report")
public class VtaReportsREST {

    
    @PersistenceContext(unitName = "CustomerService")
    private EntityManager em;
    
    @Context
    HttpServletRequest httpRequest;
//
//    /**
//     * Genera el link del listado y lo pasa al cliente para que lo descargue
//     *
//     *
//     * @param map
//     * @return
//     */
//    @POST
//    @Path("/listado_ventas")
//    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
//    @Produces(MediaType.APPLICATION_JSON)
//    public EntryDto getReportVentas(Map<String, String> map) {
//
//        AbstractFacade.extractHeaders(httpRequest);
//        if (map == null) {
//            EntryDto dto = new EntryDto("url", "error");
//            return dto;
//        }
//
//        String sFecDesde = map.get("FECHADESDE");
//        if (sFecDesde != null) {
//            try {
//                SimpleDateFormat df = new SimpleDateFormat(Formats.DATE.getFormat());
//                Date pFecDesde = df.parse(sFecDesde);
//                System.out.println("Fecha:" + pFecDesde);
//            } catch (ParseException ex) {
//                Logger.getLogger(VtaReportsREST.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
//
//////
//////        for (EntryDto e : map) {
//////            String key =  e.getKey();
//////            String value = e.getValue();
//////            System.out.println("Key: " + key + " Value :" + value);
//////        }
//        for (Map.Entry<String, String> entry : map.entrySet()) {
//            String key = entry.getKey();
//            Object value = entry.getValue();
//            System.out.println("Key: " + key + " Value :" + value);
//        }
//        
//        ///
//        File f = new File("e:/tmp/test.pdf");
//
//        if (!f.exists()) {
//            throw new WebApplicationException(404);
//        }
//
//        String mt = new MimetypesFileTypeMap().getContentType(f);
//
//        ///
//        
//        
//        EntryDto dto = new EntryDto("url", "http://todo ok");
//        return dto;
//    }

    /**
     * Genera el link del listado y lo pasa al cliente para que lo descargue
     *
     *
     * @param map
     * @param request
     * @return
     */
    @POST
    @Path("/listado_ventas")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Produces(MediaType.APPLICATION_JSON)
    public Response getReportVentas(Map<String, String> map, @Context UriInfo request) {

        try {
            AbstractFacade.extractHeaders(httpRequest);
            
            if (map == null) {
                throw new WebApplicationException(400);
            }
            
            showMap(map);
            
            ReportGenerateInterface rep = new ReportVentas();
            
            // Paso los parametros
            rep.setParameters(map,em);
            
            
            String fileName = rep.getResultFilePath();
            
            StringBuilder sb = new StringBuilder(request.getBaseUri().toString());
            
            // genero el path y el nombre del archivo a descargar
            String path = sb.append("vta_report")
                    .append("/down")
                    .append("?")
                    .append("filename=")
                    .append(fileName)
                    .toString();
            
            EntryDto dto = new EntryDto("url", path);
            
            return Response.ok(dto).build();
        } catch (SgException ex) {
            Logger.getLogger(VtaReportsREST.class.getName()).log(Level.SEVERE, null, ex);
            throw new ListEmptyException("No se generaron registros");
        }
    }

    /**
     * Obtiene el archivo generado
     * 
     * @param fileName
     * @param inline
     * @return 
     */
    @GET
    @Path("/down")
    public Response downloadPdfFile(@QueryParam("filename") String fileName,
            @DefaultValue("no") @QueryParam("inline") String inline) {

        if (fileName == null) {
            throw new WebApplicationException(400);
        }

        StreamingOutput fileStream = (java.io.OutputStream output) -> {
            try {
                java.nio.file.Path path = Paths.get(General.getTempDirectory() + fileName);
                byte[] data = Files.readAllBytes(path);
                output.write(data);
                output.flush();
            } catch (Exception e) {
                throw new WebApplicationException("File Not Found !!");
            }
        };
        
        // Si viene inline si, hago que se pueda abrir en una nueva ventana
        String disposition = "attachment; filename = " + fileName;
        if (inline.equals("si")) {
            disposition = "inline";
        }
        
        return Response
                .ok(fileStream, MediaType.APPLICATION_OCTET_STREAM)
                .header("content-disposition", disposition)
                .build();
    }

    /**
     * Muestro lo que tiene el map en la consola
     * 
     */
    private void showMap(Map<String, String> map) {
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            System.out.println("Key: " + key + " Value :" + value);
        }
    }

}
