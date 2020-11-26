/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigemp.gestion.client.activity.ventas;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.http.client.URL;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.DecoratorPanel;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.datepicker.client.DateBox;
import com.sigemp.gestion.client.api.Menu;
import com.sigemp.gestion.client.api.SGErrorDrive;
import com.sigemp.gestion.client.api.interfaces.Constantes;
import com.sigemp.gestion.client.api.interfaces.Context;
import com.sigemp.gestion.client.api.interfaces.ReportBaseReportsActivity;
import com.sigemp.gestion.client.api.interfaces.ReportInterface;
import com.sigemp.gestion.client.api.ui.HiddenIFrame;
import com.sigemp.gestion.client.resources.ResourcesImage;
import com.sigemp.gestion.client.service.VtaReportsService;
import com.sigemp.gestion.shared.entity.constantes.FiltroPedidos;
import com.sigemp.gestion.shared.entity.constantes.FiltroQuery;
import com.sigemp.gestion.shared.entity.constantes.Formats;
import com.sigemp.gestion.shared.entity.constantes.TypeArchive;
import com.sigemp.gestion.shared.dto.EntryDto;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.fusesource.restygwt.client.Method;
import org.fusesource.restygwt.client.MethodCallback;

/**
 *
 * @author Server
 */
public class ActivityListadoVentas extends ReportBaseReportsActivity implements ReportInterface {

    private Widget fForm;

    private final ResourcesImage image = ResourcesImage.INSTANCE;

    // Panel con botones de comando
    private HorizontalPanel fMenu;
    private VtaReportsService service;
    private TextBox tbDes;
    private CheckBox tbEstado;
    private TextBox tbId;
    private SimplePanel widgetContainer;
    
    HashMap<String, Object> mapParameter = new HashMap<>();

    private DateBox dateHasta;
    private DateBox dateDesde;
    private ListBox listBox;

    @Override
    public void clearParameters() {
        mapParameter.clear();
    }

    @Override
    public Widget getForm() {
        if (fForm == null) {
            fForm = createForm();
        }
        return fForm;
    }

    @Override
    public void onInitialize(Context context, HandlerManager eventBus) {
        super.onInitialize(context,eventBus);
        service = GWT.create(VtaReportsService.class);
    }

    @Override
    public HashMap<String, Object> getParameters() {
        
        Date fechaDesde = dateDesde.getValue();
        Date fechaHasta = dateHasta.getValue();

        int i = listBox.getSelectedIndex();
        FiltroPedidos filtroPedidos = FiltroPedidos.FACTURAS;
        if (i == 1) {
            filtroPedidos = FiltroPedidos.PEDIDOS;
        } else if (i == 2) {
            filtroPedidos = FiltroPedidos.TODO;
        }

        String depositos = "";

        mapParameter.put(FiltroQuery.FECHADESDE.name(), DateTimeFormat.getFormat(Formats.DATE.getFormat()).format(fechaDesde));
        mapParameter.put(FiltroQuery.FECHAHASTA.name(), DateTimeFormat.getFormat(Formats.DATE.getFormat()).format(fechaHasta));
        mapParameter.put(FiltroQuery.DEPOSITOS_LIST.name(),depositos);
        mapParameter.put(FiltroQuery.FILTRO_TIPO_COMPROBANTE.name(), filtroPedidos.name());

        return mapParameter;

    }

    public ActivityListadoVentas() {
        super();
        
        Menu menu = getOption();
        menu.setDescripcion("Listado Ventas");
        menu.setGrupo(Constantes.MENU_SISTEMAS.LISTADOS.getDescripcion());
        
        setReport(this);
    }

    @Override
    public String getPath() {
        return "";
    }

    @Override
    public String serviceRest(HashMap<String, Object> map) {
        //List<EntryDto> listMap = new ArrayList<>();
        
        HashMap<String,String> listMap = new HashMap<>();

        // transformo a un map string,string
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            listMap.put(entry.getKey(),entry.getValue().toString());
        }
        
        service.getReportVentas(listMap, new MethodCallback<EntryDto>() {
            @Override
            public void onFailure(Method method, Throwable exception) {
                SGErrorDrive e = context.getErrorDrive();
                context.getErrorDrive().show(method, exception);
            }

            @Override
            public void onSuccess(Method method, EntryDto response) {
                String val = listMap.get(FiltroQuery.TYPE.name());
                if ( val.equals(TypeArchive.VISTA_PREVIA.name())) {
                   // Window.open(response.getValue(),"_blank","enable");
                   //Window.Location.replace(URL.encode(response.getValue()));
                   
                   Window.open(GWT.getHostPageBaseURL() + "viewer.html?file=" + URL.encodePathSegment(response.getValue()),"_blank","enable");
                   
                   

                } else {
                    HiddenIFrame hf = new HiddenIFrame(response.getValue());
                }
                
            }
        });
        return "";
    }
    
   

    private Widget createForm() {
        // Create a panel to move components around
        FlexTable optionsBar = new FlexTable();

        dateDesde = new DateBox();
        dateHasta = new DateBox();

        dateDesde.setValue(new Date());
        dateHasta.setValue(new Date());
        
        
        dateDesde.getDatePicker().setYearArrowsVisible(true);
        dateHasta.getDatePicker().setYearArrowsVisible(true);
        dateHasta.getDatePicker().setYearAndMonthDropdownVisible(true);
        dateDesde.getDatePicker().setYearAndMonthDropdownVisible(true);
        
        
        tbId = new TextBox();
        tbId.setWidth("3em");
        tbId.setText("100");
        tbId.setPixelSize(40, 20);

        listBox = new ListBox();

        listBox.addItem(FiltroPedidos.FACTURAS.toString());
        listBox.addItem(FiltroPedidos.PEDIDOS.toString());
        listBox.addItem(FiltroPedidos.TODO.toString());

        optionsBar.setHTML(0, 0, "Fecha:");
        optionsBar.setWidget(0, 1, dateDesde);
        optionsBar.setWidget(0, 2, dateHasta);
        optionsBar.setHTML(1, 0, "Filtro:");
        optionsBar.setWidget(1, 1, listBox);

        DecoratorPanel widget = new DecoratorPanel();
        widget.setWidget(optionsBar);
        return widget;
    }

}
