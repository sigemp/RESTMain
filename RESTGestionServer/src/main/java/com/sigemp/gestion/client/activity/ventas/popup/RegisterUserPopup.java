/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigemp.gestion.client.activity.ventas.popup;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.sigemp.gestion.client.api.ContextImp;
import com.sigemp.gestion.client.api.interfaces.Context;

/**
 * Popup que muestra las opciones del usuario acceso a datos personales cerrar
 * session datos de ingreso egreso del sistema
 *
 * @author cristian
 */
public class RegisterUserPopup extends PopupPanel {

    private static Context context;

    private static Widget createPanel() {

        context = ContextImp.getInstance();

        VerticalPanel vp = new VerticalPanel();
        vp.setWidth("300px");
        vp.setHeight("200px");

        HorizontalPanel hp1 = new HorizontalPanel();
        HorizontalPanel hp2 = new HorizontalPanel();

        hp1.setWidth("100%");

        Image image = new Image(context.getSecurity().getImageUser());
        image.setSize("100px", "100px");

        hp1.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_LEFT);
        hp1.add(image);

        hp1.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_RIGHT);
        hp1.add(new Label(context.getSecurity().getUser().getNick()));

        hp2.setWidth("100%");
        hp2.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_LEFT);
        hp2.add(new Anchor("Datos Personales"));

        hp2.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_RIGHT);
        Anchor logout = new Anchor("Logout");
        hp2.add(logout);

        logout.addClickHandler((ClickEvent event) -> {
            ContextImp.getInstance().getSecurity().logout();
        });
        
        vp.add(hp1);
        vp.setVerticalAlignment(HasVerticalAlignment.ALIGN_BOTTOM);

        vp.add(hp2);

        return vp;
    }

    public RegisterUserPopup() {
        // PopupPanel's constructor takes 'auto-hide' as its boolean 
        // parameter. If this is set, the panel closes itself 
        // automatically when the user clicks outside of it.         
        super(true);

        // PopupPanel is a SimplePanel, so you have to set it's widget 
        // property to whatever you want its contents to be.
    }

    public static void showPopup(int y) {

        Widget wg = createPanel();

        RegisterUserPopup popup = new RegisterUserPopup();

        popup.setWidget(wg);

        popup.setPopupPositionAndShow((int offsetWidth, int offsetHeight) -> {
            int left = (Window.getClientWidth() - popup.getWidget().getOffsetWidth() - 20);
            int top = (y);
            popup.setPopupPosition(left, top);
        });

        popup.show();

    }
}
