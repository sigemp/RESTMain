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
public class DeleteEstadoCuentaEvent extends GwtEvent<DeleteEstadoCuentaEventHandler> {

    public static Type<DeleteEstadoCuentaEventHandler> TYPE = new Type<DeleteEstadoCuentaEventHandler>();

    @Override
    public Type<DeleteEstadoCuentaEventHandler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(DeleteEstadoCuentaEventHandler handler) {
        handler.onDeleteEstadoCuenta(this);
    }
}