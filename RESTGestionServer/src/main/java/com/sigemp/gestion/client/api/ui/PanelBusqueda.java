/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigemp.gestion.client.api.ui;

import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.Scheduler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyDownEvent;
import com.google.gwt.event.dom.client.KeyDownHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.Event.NativePreviewEvent;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.TextBox;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author cristian
 */
public abstract class PanelBusqueda extends PopupPanel {

    private List<SelectedEvent> listEvent = new ArrayList<>();

    public void onCreate() {

        HTMLPanel popupPanel = uiBinder.createAndBindUi(this);

        setSize("400px", "400px");
        setWidget(popupPanel);
        setAutoHideEnabled(true);
        setTitle("My Title");
        setGlassEnabled(true);
        center();

        buttonAcept.addClickHandler((ClickEvent event) -> {
            onAccept();
        });

        buttonCanel.addClickHandler((ClickEvent event) -> {
            hide();
        });

        busqueda.addKeyDownHandler((KeyDownEvent event) -> {
            if (event.getNativeKeyCode() == KeyCodes.KEY_ENTER) {
                buscar(busqueda.getText());
            }
        });

        bBusqueda.addClickHandler((ClickEvent event) -> {
            buscar(busqueda.getText());

        });
    }

    interface popupBusquedaBinder extends UiBinder<HTMLPanel, PanelBusqueda> {
    }

    private static final popupBusquedaBinder uiBinder = GWT.create(popupBusquedaBinder.class);

    @UiField
    TextBox busqueda;

    @UiField
    Button buttonAcept;

    @UiField
    Button buttonCanel;

    @UiField
    ScrollPanel contenedor;

    @UiField
    Button bBusqueda;

    CellTable cellT;

    Object object = null;

    public PanelBusqueda() {
        super(true);

        onCreate();

        // esto hace que se haga foco en el campo busqueda despues que aparece
        // la pantalla
        Scheduler.get().scheduleDeferred(new Scheduler.ScheduledCommand() {
            @Override
            public void execute() {
                //call setFocus method here:
                busqueda.setFocus(true);
            }
        });

        busqueda.addKeyDownHandler(new KeyDownHandler() {
            @Override
            public void onKeyDown(KeyDownEvent event) {
                if (event.getNativeKeyCode() == KeyCodes.KEY_DOWN) {
                    if (cellT != null) {
                        cellT.setFocus(true);
                    }
                }
            }
        });

    }

    public ScrollPanel getContenedor() {
        return contenedor;
    }

    public Button getButtonAccept() {
        return buttonAcept;
    }

    /**
     * Este metodo se ejecuta cuando el boton accept es presionado
     *
     */
    public abstract void onAccept();

    /**
     * este metodo es llamado cuando se presiona enter en el campo de busqueda
     *
     * debe sobreescribirse
     *
     *
     * @param text
     */
    public abstract void buscar(String text);

    /**
     * retorna true si hay un objeto seleccionado
     *
     *
     * @return
     */
    public abstract boolean isSelected();

    public void addCloseEvent(SelectedEvent event) {
        if (event != null) {
            listEvent.add(event);
        }
    }

    public void fire(Object o) {
        for (SelectedEvent ev : listEvent) {
            ev.doFire(o);
        }
    }

    public void setTextToFind(String text) {
        busqueda.setText(text);
    }

    public void setCellTable(CellTable cellT) {
        this.cellT = cellT;
        if (cellT == null) {
            return;
        }

        //cellT.add
    }

    @Override
    protected void onPreviewNativeEvent(NativePreviewEvent event) {
        super.onPreviewNativeEvent(event);
        switch (event.getTypeInt()) {
            case Event.ONKEYDOWN:
                switch (event.getNativeEvent().getKeyCode()) {
                    case KeyCodes.KEY_ESCAPE:
                        hide();
                        break;
                    case KeyCodes.KEY_F9:
                        onAccept();
                        break;

                }
////                if (event.getNativeEvent().getKeyCode() == KeyCodes.KEY_ESCAPE) {
////                    hide();
////                }
                break;
        }
    }

}
