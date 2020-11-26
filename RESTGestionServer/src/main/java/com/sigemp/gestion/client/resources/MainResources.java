/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigemp.gestion.client.resources;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.CssResource;
import com.google.gwt.resources.client.ImageResource;

/**
 *
 * @author Server
 */
public interface MainResources extends ClientBundle {

    public static final MainResources INSTANCE = GWT.create(MainResources.class);

    ImageResource usuario();

    @Source("classic.css")
    public CssResource css();

}
