/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigemp.gestion.client.ventas.activity.estadocuenta;

import com.google.gwt.event.shared.GwtEvent;

/**
 *
 * @author cristian
 */
public class AddEstadoCuentaEvent extends GwtEvent<AddEstadoCuentaEventHandler> {

    public static Type<AddEstadoCuentaEventHandler> TYPE = new Type<AddEstadoCuentaEventHandler>();

    @Override
    public Type<AddEstadoCuentaEventHandler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(AddEstadoCuentaEventHandler handler) {
        handler.onAddEstadoCuenta(this);
    }
}