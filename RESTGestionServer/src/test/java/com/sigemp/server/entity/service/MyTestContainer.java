/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigemp.server.entity.service;

import java.net.URI;
import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.test.DeploymentContext;
import org.glassfish.jersey.test.spi.TestContainer;
import org.glassfish.jersey.test.spi.TestContainerFactory;

/**
 *
 * @author Server
 */
public class MyTestContainer implements TestContainerFactory {
    
    @Override
    public TestContainer create(URI baseUri, DeploymentContext deploymentContext) {
        return new TestContainer(){

            @Override
            public ClientConfig getClientConfig() {
                return null;
            }

            @Override
            public URI getBaseUri() {
                return URI.create("http://localhost:8080/RESTGestionServer/api");
            }

            @Override
            public void start() {
                // Do nothing
            }

            @Override
            public void stop() {
                // Do nothing
            }
        };
    }
}
