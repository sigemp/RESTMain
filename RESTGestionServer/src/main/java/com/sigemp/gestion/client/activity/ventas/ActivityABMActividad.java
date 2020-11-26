/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigemp.gestion.client.activity.ventas;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Widget;
import com.googlecode.gwt.charts.client.ChartLoader;
import com.googlecode.gwt.charts.client.ChartPackage;
import com.googlecode.gwt.charts.client.ColumnType;
import com.googlecode.gwt.charts.client.DataTable;
import com.googlecode.gwt.charts.client.corechart.BarChart;
import com.googlecode.gwt.charts.client.corechart.BarChartOptions;
import com.googlecode.gwt.charts.client.options.HAxis;
import com.googlecode.gwt.charts.client.options.VAxis;
import com.sigemp.gestion.client.api.Menu;
import com.sigemp.gestion.client.api.interfaces.Constantes;
import com.sigemp.gestion.client.api.interfaces.Context;
import com.sigemp.gestion.client.api.interfaces.PanelActivity;
import com.sigemp.gestion.client.api.ui.SgButton;
import com.sigemp.gestion.client.resources.ResourcesImage;
import com.sigemp.gestion.client.service.GsyUserService;
import com.sigemp.gestion.shared.entity.GsyUser;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;
import org.fusesource.restygwt.client.Method;
import org.fusesource.restygwt.client.MethodCallback;

/**
 *
 * @author Server
 */
public class ActivityABMActividad extends PanelActivity {

    private static GsyUserService service;
    private BarChart chart;

    private final ResourcesImage image = ResourcesImage.INSTANCE;

    Logger logger = Logger.getLogger("NameOfYourLogger");

    private FlowPanel fPanel;
    private FlowPanel fMenu;
    private Context context;
    private boolean init = false;
    private HandlerManager eventBus;

    public ActivityABMActividad() {
        Menu menu = getOption();
        menu.setDescripcion("ABM Actividad");
        menu.setGrupo(Constantes.MENU_SISTEMAS.TABLAS.getDescripcion());

    }

    private FlowPanel crearPanel() {
        FlowPanel widget = new FlowPanel();
        ChartLoader chartLoader = new ChartLoader(ChartPackage.CORECHART);
        chartLoader.loadApi(new Runnable() {
            @Override
            public void run() {
                // Create and attach the chart
                chart = new BarChart();
                widget.add(chart);
                draw();
            }
        });

        return widget;

    }

    private FlowPanel crearMenu() {
        SgButton test = new SgButton(image.formGuardar(), "Guardar");
        test.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {

            }
        });

        SgButton test2 = new SgButton(image.formBuscar(), "Buscar");
        test2.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {

                service.find("1", new MethodCallback<GsyUser>() {
                    @Override
                    public void onFailure(Method method, Throwable exception) {
                        context.getErrorDrive().show(method, exception);
                    }

                    @Override
                    public void onSuccess(Method method, GsyUser response) {
                        Window.alert(response.getNick());
                    }
                });

            }

        });

        SgButton test3 = new SgButton(image.formAgregar(), "Agregar");
        test3.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                service.findAll(new MethodCallback<List<GsyUser>>() {
                    @Override
                    public void onFailure(Method method, Throwable exception) {
                        context.getErrorDrive().show(method, exception);
                    }

                    @Override
                    public void onSuccess(Method method, List<GsyUser> response) {
                        Window.alert(Arrays.toString(response.toArray()));
                    }
                });

            }
        });

        FlowPanel widget = new FlowPanel();

        widget.add(test);

        widget.add(test2);
        widget.add(test3);

        return widget;
    }

    @Override
    public void onInitialize(Context context, HandlerManager eventBus) {
        this.context = context;
        this.eventBus = eventBus;

        if (!init) {
            bind();
        }
    }

    @Override
    public Widget getToolMenu() {
        return fMenu;
    }

    @Override
    public Widget getMainPanel() {
        return fPanel;
    }

////    private void initialize() {
////      ChartLoader chartLoader = new ChartLoader(ChartPackage.CORECHART);
////      chartLoader.loadApi(new Runnable() {
////         public void run() {
////            // Create and attach the chart
////            
////            RootPanel.get().add(chart);
////            chart = new BarChart();
////            draw();
////         }
////      });
////   }
    private void draw() {
        // Prepare the data
        DataTable data = DataTable.create();
        data.addColumn(ColumnType.STRING, "Year");
        data.addColumn(ColumnType.NUMBER, "Asia");
        data.addRow("2012", 900);
        data.addRow("2013", 1000);
        data.addRow("2014", 1170);
        data.addRow("2015", 1250);
        data.addRow("2016", 1530);

        // Set options
        BarChartOptions options = BarChartOptions.create();
        options.setTitle("Population (in millions)");
        options.setHAxis(HAxis.create("Year"));
        VAxis vAxis = VAxis.create();
        vAxis.setMinValue(0);

        options.setVAxis(vAxis);

        // Draw the chart
        chart.draw(data, options);
        chart.setWidth("400px");
        chart.setHeight("400px");
    }

    private void bind() {
        // Si no se inicio la actividad 
        service = GWT.create(GsyUserService.class);

        fPanel = crearPanel();
        fMenu = crearMenu();
        init = true;
    }
}
