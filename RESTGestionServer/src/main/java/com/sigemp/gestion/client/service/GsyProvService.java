/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigemp.gestion.client.service;

import com.sigemp.gestion.shared.entity.GsyProv;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import org.fusesource.restygwt.client.MethodCallback;
import org.fusesource.restygwt.client.RestService;

/**
 *
 * @author Server
 */
@Path("/gsyprov")
public interface GsyProvService extends RestService {

////    
////    @GET
////    @Path("findAll")
////    public void findAll(@QueryParam("start") int start,
////            @QueryParam("size") int size,
////            @QueryParam("des") String des,MethodCallback<List<GsyProv>> callback);
    
    @GET
    @Path("findAll")
    public void findAll(MethodCallback<List<GsyProv>> callback);

}
