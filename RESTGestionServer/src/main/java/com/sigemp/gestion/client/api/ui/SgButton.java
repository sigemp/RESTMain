/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigemp.gestion.client.api.ui;

import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.user.client.ui.CustomButton;
import com.google.gwt.user.client.ui.Image;

/**
 *
 * @author cristian
 */
public class SgButton extends CustomButton {

    public SgButton(ImageResource img) {
        this(img,null);
    }
    
    public SgButton(ImageResource img,String tooltip) {
        super(new Image(img));
        setStyleName("sg-ButtonImage");
        setStylePrimaryName("sg-ButtonImage");
        if (tooltip!= null) {
            setTitle(tooltip);
        }
    }

}
