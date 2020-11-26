/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigemp.gestion.client.api.dispatcher;

import org.fusesource.restygwt.client.dispatcher.DispatcherFilter;

/**
 *
 * @author cristian
 */
public interface FilterawareDispatcher extends Dispatcher {

    public void addFilter(DispatcherFilter filter);

}
