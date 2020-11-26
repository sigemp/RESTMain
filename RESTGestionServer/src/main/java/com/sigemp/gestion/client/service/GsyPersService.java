/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigemp.gestion.client.service;

import com.sigemp.gestion.shared.entity.GsyPers;
import com.sigemp.gestion.shared.dto.PersonasDto;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import org.fusesource.restygwt.client.MethodCallback;
import org.fusesource.restygwt.client.Options;
import org.fusesource.restygwt.client.RestService;

/**
 *
 * @author Server
 */
@Path("/gsypers")
public interface GsyPersService extends RestService {

    @GET
    @Path("fillDto")
    public void findDto(@QueryParam("search") String search,MethodCallback<List<PersonasDto>> callback) ;
    
    @GET
    @Path("{id}")
    @Options(expect={200,201})
    public void find(@PathParam("id") Long id,MethodCallback<GsyPers> callback);
    
}
