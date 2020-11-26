/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigemp.gestion.client.api.dispatcher;

import org.fusesource.restygwt.client.dispatcher.DefaultFilterawareDispatcher;

/**
 *
 * @author cristian
 */
public class MyDispatcher extends DefaultFilterawareDispatcher {

    public MyDispatcher(String token) {
        addFilter(new BasicAuthHeaderDispatcherFilter(token));
    }
}
