/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigemp.gestion.client.api.interfaces;

import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.sigemp.gestion.client.api.Menu;
import com.sigemp.gestion.client.resources.ResourcesImage;

/**
 * Implementacion de PanelActivityInterface se usa para crear una actividad
 * vacia
 *
 * @author Server
 */
public class PanelActivity implements PanelActivityInterface {

    Menu menu = new Menu("Sin Grupo", "Sin Nombre", "", null);

    private boolean init = false;

    private VerticalPanel panelActividad;

    @Override
    public boolean Scrollable() {
        return false;
    }

    @Override
    public void onInitialize(Context context,HandlerManager eventBus) {
        if (!init) {

            panelActividad = new VerticalPanel();
            panelActividad.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
            panelActividad.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
            panelActividad.setHeight("100%");
            panelActividad.setWidth("100%");

            HTML message = new HTML(getOption().getDescripcion() + " Sin Implementar");
            message.getElement().setAttribute("Style", "font-size: medium;"
                    + "font-family: monospace;\n"
                    + "font-weight: bold;\n"
                    + "margin-top: 20px;");

            Image image = new Image(ResourcesImage.INSTANCE.enDesarrollo());
            image.getElement().setAttribute("Style", "margin-top: 20px;");

            panelActividad.add(image);

            panelActividad.add(message);
            init = true;
        }
    }

    @Override
    public void onReturn(boolean confirm, Object form) {

    }

    public void startActivity(Intent intent) {
        

    }

    @Override
    public Widget getMainPanel() {
        return panelActividad;
    }

    @Override
    public Widget getToolMenu() {
        return null;
    }

    @Override
    public Menu getOption() {
        return menu;
    }

    @Override
    public String getId() {
        return "0";
    }

}
