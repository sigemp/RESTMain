/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigemp.gestion.client.ventas.activity.estadocuenta;

import com.google.gwt.cell.client.CheckboxCell;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.safehtml.shared.SafeHtmlUtils;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.cellview.client.SimplePager;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.view.client.ListDataProvider;
import com.google.gwt.view.client.MultiSelectionModel;
import com.google.gwt.view.client.SelectionModel;
import com.sigemp.gestion.client.api.Menu;
import com.sigemp.gestion.client.api.interfaces.Constantes;
import com.sigemp.gestion.client.api.interfaces.Context;
import com.sigemp.gestion.client.api.interfaces.PanelActivity;
import com.sigemp.gestion.client.api.ui.SgButton;
import com.sigemp.gestion.client.resources.ResourcesImage;
import com.sigemp.gestion.shared.entity.VtaEst;

/**
 *
 * @author Server
 */
public class ActivityABMEstadosCuenta extends PanelActivity {

    Menu menu = new Menu(Constantes.MENU_SISTEMAS.TABLAS.getDescripcion(), "ABM Estados de Cuenta", "", null);

    @UiTemplate(value = "ActivityABMEstadosCuenta.ui.xml")
    interface Binder extends UiBinder<Widget, ActivityABMEstadosCuenta> {
    }

    private Context context;
    private HandlerManager eventBus;

    private final ResourcesImage image = ResourcesImage.INSTANCE;

    // Panel contenedor
    private final SimplePanel widgetContainer = new SimplePanel();

    // Panel del Listado
    private Widget panelList;

    private final HorizontalPanel fMenu = new HorizontalPanel();

    private final SelectionModel<VtaEst> selectionModel = new MultiSelectionModel<>();

    boolean init = false;

    ListDataProvider<VtaEst> conceptosCajaListDataProvider;

    @UiField(provided = true)
    CellTable<VtaEst> cellTable;

    ListDataProvider<VtaEst> provider;

    /**
     * The pager used to change the range of data.
     */
    @UiField(provided = true)
    SimplePager pager;

    public ActivityABMEstadosCuenta() {

    }

    @Override
    public void onInitialize(Context context, HandlerManager eventBus) {
        super.onInitialize(context, eventBus);
        this.context = context;
        this.eventBus = eventBus;

        // solo ingresa una vez.. cuando se crea el objeto
        if (!init) {
            bind();

            crearMenu();
            init = true;
        }

    }

    private void bind() {

        createTable();

        initTableColumns(cellTable, selectionModel);

        Binder uiBinder = GWT.create(Binder.class);
        panelList = uiBinder.createAndBindUi(this);
        widgetContainer.add(panelList);

    }

    /**
     * Aca se pueden crear varios iniciadores, segun se necesite mostra en la
     * grilla de la tabla
     *
     *
     */
    private void initTableColumns(CellTable<VtaEst> cellTable, final SelectionModel<VtaEst> selectionModel) {

        // Checkbox column. This table will uses a checkbox column for selection.
        // Alternatively, you can call cellTable.setSelectionEnabled(true) to enable
        // mouse selection.
        Column<VtaEst, Boolean> checkColumn = new Column<VtaEst, Boolean>(
                new CheckboxCell(true, false)) {
            @Override
            public Boolean getValue(VtaEst object) {
                // Get the value from the selection model.
                return selectionModel.isSelected(object);
            }
        };
        cellTable.addColumn(checkColumn, SafeHtmlUtils.fromSafeConstant("<br/>"));
        cellTable.setColumnWidth(checkColumn, 15, Style.Unit.PX);

        TextColumn<VtaEst> columnId = new TextColumn<VtaEst>() {
            @Override
            public String getValue(VtaEst object) {
                return object.getEstId().toString();
            }
        };

        // Add column to table
        cellTable.addColumn(columnId, "ID");
        cellTable.setColumnWidth(columnId, 5, Style.Unit.PCT);

        TextColumn<VtaEst> columnDes = new TextColumn<VtaEst>() {
            @Override
            public String getValue(VtaEst object) {
                return object.getDes();
            }
        };

        // Add column to table
        cellTable.addColumn(columnDes, "Descripcion");
        cellTable.setColumnWidth(columnDes, 20, Style.Unit.PCT);

    }

    private void createTable() {

        cellTable = new CellTable<>();
        cellTable.setWidth("100%", true);

        SimplePager.Resources pagerResources = GWT.create(SimplePager.Resources.class);
        pager = new SimplePager(SimplePager.TextLocation.CENTER, pagerResources, false, 0, true);
        pager.setDisplay(cellTable);

        conceptosCajaListDataProvider = new ListDataProvider<>();

        // Connect the table to the data provider.
        conceptosCajaListDataProvider.addDataDisplay(cellTable);

        cellTable.setSelectionModel(selectionModel);

    }

    private void crearMenu() {
        Image i = new Image(image.fromActualizar());
        SgButton btUpdate = new SgButton(image.fromActualizar(), "Actualizar");
        btUpdate.addClickHandler((ClickEvent event) -> {
            /*service.findAll(new MethodCallback<List<VtaEst>>() {
                @Override
                public void onFailure(Method method, Throwable exception) {
                    context.getErrorDrive().show(method, exception);
                }

                @Override
                public void onSuccess(Method method, List<VtaEst> response) {
                    List<VtaEst> listProvider = provider.getList();
                    listProvider.clear();

                    if (response.isEmpty()) {
                        Toast.show("La consulta no genero registros");
                    } else {
                        Toast.show("Fin consulta");
                    }

                    for (VtaEst vcc : response) {
                        listProvider.add(vcc);
                    }

                }
            });*/
        });

        SgButton btEditar = new SgButton(image.formEditar(), "Editar");
        btEditar.addClickHandler((ClickEvent event) -> {

        });

        SgButton btNew = new SgButton(image.formAgregar(), "Nuevo");
        btNew.addClickHandler((ClickEvent event) -> {

        });

        SgButton btDelete = new SgButton(image.formBorrar(), "Borrar");

        btDelete.addClickHandler((ClickEvent event) -> {

        });

        fMenu.add(btUpdate);
        fMenu.add(btNew);
        fMenu.add(btEditar);
        fMenu.add(btDelete);

        eventBus.addHandler(AddEstadoCuentaEvent.TYPE, (AddEstadoCuentaEventHandler) (AddEstadoCuentaEvent event1) -> {

        });

    }

    @Override
    public Widget getToolMenu() {
        return fMenu;
    }

    @Override
    public Widget getMainPanel() {
        return widgetContainer;
    }

    @Override
    public Menu getOption() {
        return menu;
    }

}
