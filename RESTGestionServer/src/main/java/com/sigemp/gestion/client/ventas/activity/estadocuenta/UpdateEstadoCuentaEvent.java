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
public class UpdateEstadoCuentaEvent extends GwtEvent<UpdateEstadoCuentaEventHandler> {

    public static Type<UpdateEstadoCuentaEventHandler> TYPE = new Type<UpdateEstadoCuentaEventHandler>();

    @Override
    public Type<UpdateEstadoCuentaEventHandler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(UpdateEstadoCuentaEventHandler handler) {
        handler.onActualizarEstadoCuenta(this);
    }
}