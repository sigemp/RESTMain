/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigemp.gestion.client.activity.ventas.form;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.DecoratorPanel;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import com.sigemp.gestion.client.api.interfaces.Context;
import com.sigemp.gestion.client.api.interfaces.PanelActivityInterface;
import com.sigemp.gestion.client.api.ui.SgButton;
import com.sigemp.gestion.client.api.ui.Toast;
import com.sigemp.gestion.client.constantes.ConstantesComprobantes.AccionFormulario;
import com.sigemp.gestion.client.resources.ResourcesImage;
import com.sigemp.gestion.client.service.VtaCajConceptoService;
import com.sigemp.gestion.shared.entity.VtaCajConcepto;
import org.fusesource.restygwt.client.Method;
import org.fusesource.restygwt.client.MethodCallback;

/**
 *
 * @author cristian
 */
public class FromABMConceptosCaja {

    private AccionFormulario accionFormulario;

    private final VtaCajConceptoService service;

    private TextBox tbDes;
    private PanelActivityInterface parentPanelActivity;
    private CheckBox tbEstado;

    private TextBox tbId;

    private DecoratorPanel widget = null;
    private HorizontalPanel fMenu;

    private final ResourcesImage image = ResourcesImage.INSTANCE;
    private Context context;

    private FromABMConceptosCaja() {
        service = GWT.create(VtaCajConceptoService.class);
    }

    public FromABMConceptosCaja(PanelActivityInterface parentPanelActivity,Context context) {
        this.parentPanelActivity = parentPanelActivity;
        service = GWT.create(VtaCajConceptoService.class);
        this.context = context;

        createWidget();
        createMenu();
    }

    public Widget getForm() {
        return widget;
    }

    private void createWidget() {
        // Create a panel to move components around
        FlexTable optionsBar = new FlexTable();
        tbId = new TextBox();
        tbId.setWidth("3em");
        tbId.setText("100");
        tbId.setPixelSize(40, 20);

        tbDes = new TextBox();
        tbDes.setWidth("3em");
        tbDes.setText("60");
        tbDes.setPixelSize(200, 20);

        tbEstado = new CheckBox("Estado");

        optionsBar.setHTML(0, 0, "Id");
        optionsBar.setWidget(0, 1, tbId);
        optionsBar.setHTML(1, 0, "Descripcion");
        optionsBar.setWidget(1, 1, tbDes);
        optionsBar.setHTML(2, 0, "Estado");
        optionsBar.setWidget(2, 1, tbEstado);


        widget = new DecoratorPanel();
        widget.setWidget(optionsBar);

    }

    private void createMenu() {
        fMenu = new HorizontalPanel();

        SgButton btBack = new SgButton(image.formVolver(),"Regresar");
        btBack.addClickHandler((ClickEvent event) -> {
            parentPanelActivity.onReturn(false, this);

        });

        SgButton btGuardar = new SgButton(image.formGuardar(),"Guardar");
        btGuardar.addClickHandler((ClickEvent event) -> {

            VtaCajConcepto co = getPojo();

            if (accionFormulario == AccionFormulario.ALTA) {
                service.create(co, new MethodCallback<Double>() {
                    @Override
                    public void onFailure(Method method, Throwable exception) {
                        context.getErrorDrive().show(method,exception);
                    }

                    @Override
                    public void onSuccess(Method method, Double response) {
                        Toast.show("Datos Guardados");
                        parentPanelActivity.onReturn(true, this);
                    }
                });
            } else if (accionFormulario == AccionFormulario.MODIFICACION) {
                service.edit(co.getConceptoId().toString(), co, new MethodCallback<Double>() {
                    @Override
                    public void onFailure(Method method, Throwable exception) {
                        context.getErrorDrive().show(method,exception);
                    }

                    @Override
                    public void onSuccess(Method method, Double response) {
                        String s = response.toString();
                        Toast.show("Datos Guardados");
                        parentPanelActivity.onReturn(true, this);
                    }
                });
            }

        });

        SgButton btReset = new SgButton(image.formCancelar(),"Perder Cambios");
        btReset.addClickHandler((ClickEvent event) -> {
            // Reiniciar objeto inicial
        });

        fMenu.add(btBack);
        fMenu.add(btGuardar);
        fMenu.add(btReset);
    }

    public void setPojo(AccionFormulario accionFormulario, VtaCajConcepto co) {
        this.accionFormulario = accionFormulario;
        if (accionFormulario == AccionFormulario.ALTA) {
            tbId.setEnabled(true);
        } else {
            tbId.setEnabled(false);
        }
        tbId.setText(co.getConceptoId().toString());
        tbDes.setText(co.getDes());
        tbEstado.setValue(co.getEstado());
    }

    public VtaCajConcepto getPojo() {
        Integer id = 0;
        String des = tbDes.getText();
        Boolean estado = tbEstado.getValue();

        try {
            id = Integer.valueOf(tbId.getText());
        } catch (NumberFormatException ex) {

        }
        VtaCajConcepto co = new VtaCajConcepto();
        co.setConceptoId(id);
        co.setDes(des);
        co.setEstado(estado);

        return co;

    }

    public boolean isConfirmed() {
        return true;
    }

    public Widget getMenu() {
        return fMenu;
    }
    
    public AccionFormulario getAccionFormulario() {
        return accionFormulario;
    }
}
