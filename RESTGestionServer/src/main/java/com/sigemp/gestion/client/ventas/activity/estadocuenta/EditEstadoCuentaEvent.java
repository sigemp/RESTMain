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
public class EditEstadoCuentaEvent extends GwtEvent<EditEstadoCuentaEventHandler> {

    public static Type<EditEstadoCuentaEventHandler> TYPE = new Type<EditEstadoCuentaEventHandler>();

    @Override
    public Type<EditEstadoCuentaEventHandler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(EditEstadoCuentaEventHandler handler) {
        handler.onEditEstadoCuenta(this);
    }
}