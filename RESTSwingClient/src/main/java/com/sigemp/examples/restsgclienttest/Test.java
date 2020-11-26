/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigemp.examples.restsgclienttest;

import com.sigemp.gestion.shared.entity.GsyProv;
import java.net.URI;
import java.util.List;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;
import org.glassfish.jersey.client.ClientConfig;

/**
 *
 * @author Server
 */
public class Test {

    public static void main(String[] args) {
        for (int x=0;x<10;x++) {
            new Test().test();
        }        
    }

    public void test() {
        ClientConfig config = new ClientConfig();
        Client client = ClientBuilder.newClient(config);

        WebTarget target = client.target(getBaseURI());
        // Get XML
        List<GsyProv> list = (List<GsyProv>)  target
                .path("gsyprov")
                .path("findAll")
                .queryParam("des", "CATA")
                .request()
                .accept(MediaType.APPLICATION_XML)
                .get(new GenericType<List<GsyProv>>() {  });
        System.out.println(list);
        
////        xmlResponse = target
////                .path("gsyprov")
////                .path("findAll")
////                //.queryParam("des", "CATA")
////                .request()
////                .accept(MediaType.APPLICATION_XML)
////                .get(String.class);
////        System.out.println(xmlResponse);
////        
////        xmlResponse = target
////                .path("gsyprov")
////                .path("findAll")
////                .queryParam("start", 0)
////                .queryParam("size", 2)
////                .request()
////                .accept(MediaType.APPLICATION_XML)
////                .get(String.class);
////        System.out.println(xmlResponse);
    }

    private static URI getBaseURI() {
        return UriBuilder.fromUri(
                "http://localhost:8080/RESTSGGestionServer/rest").build();
    }
}
