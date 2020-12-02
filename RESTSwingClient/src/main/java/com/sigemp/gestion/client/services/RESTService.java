/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigemp.gestion.client.services;


import com.sigemp.gestion.client.online.filter.PrintOut;
import com.sigemp.client.dto.PageableWrapper;
import java.net.URI;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.client.authentication.HttpAuthenticationFeature;

/**
 *
 * @author cristian
 */
public class RESTService {
    
    public enum ServicePoint {
        ENTRY_POINT ("http://localhost:8080/RESTGestionServer/api"),
        SERVICE_PROVINCIA ("gsyprov"),
        SERVICE_TALONARIO ("gsytalonarios"),
        SERVICE_DEPOSITOS ("stkdepositos"),
        SERVICE_SUCURSAL ("gsysuc"),
        SERVICE_TALONARIOS ("gsytalonarios"),
        SERVICE_CONTADORES ("gsycontadores"),
        SERVICE_PANTALLA_PTOVTA ("ptovta"),
        
        ;

        private String param;

        ServicePoint(String param) {
            this.param = param;
        }
        
        public String getParam() {
            return param;
        }
    }
    
    public enum ServicePath {
        PATH_PROVINCIAS ("provincias",ServicePoint.SERVICE_PROVINCIA)
        ;

        private String param;
        private ServicePoint servicePoint;

        ServicePath(String param,ServicePoint servicePoint) {
            this.param = param;
            this.servicePoint = servicePoint;
        }
        
        public String getParam() {
            return param;
        }
    }
    

    public WebTarget getTarget() {
        HttpAuthenticationFeature feature = HttpAuthenticationFeature.basic("admin", "admin");

        ClientConfig config = new ClientConfig()
                .register(feature)
                .register(new PrintOut())                ;

        Client client = ClientBuilder.newClient(config);

        WebTarget target = client.target(getBaseURI());
        
        target.request(MediaType.APPLICATION_JSON);
        return target;
    }
    
    protected String analize(Response res, String leyenda) {
        StringBuilder sb = new StringBuilder();
        sb.append(" ")
                .append(res.getStatus());

        MultivaluedMap map = res.getMetadata();
        for (Object m : map.keySet()) {
            sb.append(m)
                    .append(" ")
                    .append(map.get(m))
                    .append("\r\n");
        }

        sb.append("Error creando");
        return sb.toString();
    }

    private static URI getBaseURI() {
        return UriBuilder.fromUri(ServicePoint.ENTRY_POINT.getParam()).build();
    }

    public PageableWrapper getPageableCount(int cnt) {
        PageableWrapper pag = new PageableWrapper();
        pag.setCount(cnt);
        return pag;
    }

////    public PageableWrapper getPageable(String json) {
////
////        String str = "";
////        //Write JSON from java objects
////        ObjectMapper mapper = new ObjectMapper();
////
////        PageableWrapper value = new PageableWrapper();
////
////        try {
////            value = mapper.readValue(json, PageableWrapper.class);
////        } catch (Exception e) {
////            e.printStackTrace();
////        }
////
////        return value;
////    }

}
