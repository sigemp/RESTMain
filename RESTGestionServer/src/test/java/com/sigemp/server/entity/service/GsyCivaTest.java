/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigemp.server.entity.service;

import com.sigemp.gestion.shared.entity.GsyCiva;
import com.sigemp.gestion.server.services.automatic.GsyCivaFacadeREST;
import java.util.List;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;
import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.glassfish.jersey.test.TestProperties;
import org.junit.Ignore;

/**
 *
 * @author cristian
 */
public class GsyCivaTest extends JerseyTest {

    @Override
    public Application configure() {
        System.setProperty("jersey.config.test.container.factory", "com.sigemp.server.entity.service.MyTestContainer");
        enable(TestProperties.LOG_TRAFFIC);
        enable(TestProperties.DUMP_ENTITY);
        //forceSet(TestProperties.CONTAINER_PORT, "0");
        return new ResourceConfig(GsyCivaFacadeREST.class);
                //.register(new MyEntityManagerBinder());
    }

    //@Test
    @Ignore
    public void testFetchAll() {
        int z=1;
        Response output = target("/gsyciva").request().get();

        assertEquals("should return status 200", 200, output.getStatus());
        assertNotNull("Should return list", output.getEntity());

        //String string = output.readEntity(String.class);
        List<GsyCiva> listCu = (List<GsyCiva>) output.readEntity(new GenericType<List<GsyCiva>>() {
        });

        System.out.println("Cnt Registros:" + listCu.size());
    }
}
