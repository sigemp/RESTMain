/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigemp.gestion.client.api.interfaces;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.Widget;
import com.sigemp.gestion.client.api.ui.SgButton;
import com.sigemp.gestion.client.resources.ResourcesImage;
import com.sigemp.gestion.shared.entity.constantes.FiltroQuery;
import com.sigemp.gestion.shared.entity.constantes.TypeArchive;
import java.util.HashMap;

/**
 *
 * @author sigem
 */
public class ReportBaseReportsActivity extends PanelActivity {

    private final ResourcesImage image = ResourcesImage.INSTANCE;

    private Widget fMenu;
    private ReportInterface reportImp;

    protected String actividad = "Reporte Implementar";
    protected String tipoMenu = "Reporte Implementar";

    private boolean init = false;

    /**
     * Si el listado no tiene el formulario muestro este panel
     *
     */
    private Widget panelPrincipal;
    protected Context context;
    protected HandlerManager eventBus;

    @Override
    public void onInitialize(Context context, HandlerManager eventBus) {
        this.context = context;
        this.eventBus = eventBus;
        if (!init) {
            bind();
        }
    }

    @Override
    public void onReturn(boolean confirm, Object form) {

    }

    private Widget crearMenu() {
        SgButton btImprime = new SgButton(image.imprimir(), "Imprime Reporte");
        btImprime.addClickHandler((ClickEvent event) -> {
            sistemPrint();
        });

        SgButton btVistaPrevia = new SgButton(image.vistaPrevia(), "Vista Previa");
        btVistaPrevia.addClickHandler((ClickEvent event) -> {
            vistaPrevia();
        });

        SgButton btExcel = new SgButton(image.excel(), "Descarga en un archivo Excel");
        btExcel.addClickHandler((ClickEvent event) -> {
            downExcel();
        });

        SgButton btPdf = new SgButton(image.pdf(), "Descarga en un archivo PDF");
        btPdf.addClickHandler((ClickEvent event) -> {
            downPdf();
        });

        SgButton btEmail = new SgButton(image.email(), "Envia un Email con el reporte");

        btEmail.addClickHandler((ClickEvent event) -> {
            sendEmail("to", "cuerpoMensaje");
        });
        btEmail.setEnabled(false);

        HorizontalPanel widget = new HorizontalPanel();

        widget.add(btImprime);
        widget.add(btExcel);
        widget.add(btVistaPrevia);
        widget.add(btPdf);
        widget.add(btEmail);

        return widget;
    }

    protected void setReport(ReportInterface reportImp) {
        this.reportImp = reportImp;
    }

    private boolean isNUll(ReportInterface reportImp) {
        if (reportImp == null) {
            Window.alert("Reporte no Activo");
            return true;
        }
        return false;
    }

    private void vistaPrevia() {
        if (isNUll(reportImp)) {
            return;
        }
        HashMap map = reportImp.getParameters();
        map.put(FiltroQuery.TYPE.name(), TypeArchive.VISTA_PREVIA.name());
        reportImp.getPath();
        String str = reportImp.serviceRest(map);
    }

    private void downExcel() {
        if (isNUll(reportImp)) {
            return;
        }
        HashMap map = reportImp.getParameters();
        map.put(FiltroQuery.TYPE.name(), TypeArchive.EXCEL.name());
        String str = reportImp.serviceRest(map);
    }

    private void downPdf() {
        if (isNUll(reportImp)) {
            return;
        }
        HashMap map = reportImp.getParameters();
        map.put(FiltroQuery.TYPE.name(), TypeArchive.PDF.name());
        String str = reportImp.serviceRest(map);
    }

    private void sendEmail(String to, String cuerpoMensaje) {
        if (isNUll(reportImp)) {
            return;
        }
        HashMap map = reportImp.getParameters();
        map.put(FiltroQuery.TYPE.name(), TypeArchive.SEND_EMAIL.name());
        map.put(FiltroQuery.EMAIL_TO.name(), "EMAIL");
        map.put(FiltroQuery.EMAIL_SUBJECT.name(), "SUBJECT");
        map.put(FiltroQuery.EMAIL_BODY.name(), "BODY");
        encontruccion();
    }

    private void sistemPrint() {
        if (isNUll(reportImp)) {
            return;
        }
        HashMap map = reportImp.getParameters();
        map.put(FiltroQuery.TYPE.name(), TypeArchive.SISTEM_PRINT.name());
        map.put(FiltroQuery.PRINTERNAME.name(), "NAME_PRINTER");
        String str = reportImp.serviceRest(map);
    }

    private void encontruccion() {
        Window.alert("En Construccion");
    }

    @Override
    public Widget getMainPanel() {
        return panelPrincipal;
    }

    @Override
    public Widget getToolMenu() {
        return fMenu;
    }

    private void bind() {
        if (reportImp == null && reportImp.getForm() == null) {
            panelPrincipal = new SimplePanel(new HTML(actividad));
        } else {
            // Aplico el formulario del reporte
            panelPrincipal = reportImp.getForm();
        }
        fMenu = crearMenu();

    }

}
