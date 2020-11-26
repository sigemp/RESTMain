/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigemp.gestion.client.activity.ventas;

import com.google.gwt.cell.client.CheckboxCell;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.safehtml.shared.SafeHtmlUtils;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.cellview.client.SimplePager;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.view.client.ListDataProvider;
import com.google.gwt.view.client.MultiSelectionModel;
import com.google.gwt.view.client.SelectionModel;
import com.sigemp.gestion.client.activity.ventas.form.FromABMConceptosCaja;
import com.sigemp.gestion.client.api.Menu;
import com.sigemp.gestion.client.api.interfaces.Constantes;
import com.sigemp.gestion.client.api.interfaces.Context;
import com.sigemp.gestion.client.api.interfaces.PanelActivity;
import com.sigemp.gestion.client.api.interfaces.PanelActivityInterface;
import com.sigemp.gestion.client.api.ui.SgButton;
import com.sigemp.gestion.client.api.ui.Toast;
import com.sigemp.gestion.client.api.util.SetWrapper;
import com.sigemp.gestion.client.constantes.ConstantesComprobantes.AccionFormulario;
import com.sigemp.gestion.client.resources.ResourcesImage;
import com.sigemp.gestion.client.service.VtaCajConceptoService;
import com.sigemp.gestion.shared.entity.VtaCajConcepto;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;
import org.fusesource.restygwt.client.Method;
import org.fusesource.restygwt.client.MethodCallback;

/**
 *
 * @author Server
 */
public class ActivityABMConceptosCaja extends PanelActivity {

    interface Binder extends UiBinder<Widget, ActivityABMConceptosCaja> {
    }

    private PanelActivityInterface panelActivityParent;

    private static VtaCajConceptoService service;
    private SimplePanel widgetContainer;
    private Context context;
    private boolean init = false;

    private final ResourcesImage image = ResourcesImage.INSTANCE;
    private HandlerManager eventBus;

    private void bind() {
        widgetContainer = new SimplePanel();

        createCellTable();

        crearMenu();

        // Create the UiBinder.
        Binder uiBinder = GWT.create(Binder.class);
        panelList = uiBinder.createAndBindUi(this);

        widgetContainer.add(panelList);

        formABM = new FromABMConceptosCaja(this, context);
    }

    static final Logger LOGGER = Logger.getLogger(ActivityABMConceptosCaja.class.getName());

    // Panel con botones de comando
    private HorizontalPanel fMenu;
    // Panel del Listado
    private Widget panelList;
    // Objeto del Formulario
    FromABMConceptosCaja formABM;

    @UiField(provided = true)
    CellTable<VtaCajConcepto> cellTable;

    ListDataProvider<VtaCajConcepto> conceptosCajaListDataProvider;

    /**
     * The pager used to change the range of data.
     */
    @UiField(provided = true)
    SimplePager pager;

    public ActivityABMConceptosCaja() {

        Menu menu = getOption();
        menu.setDescripcion("ABM Conceptos Caja");
        menu.setGrupo(Constantes.MENU_SISTEMAS.TABLAS.getDescripcion());

    }

    private void crearMenu() {
        Image i = new Image(image.fromActualizar());
        SgButton btUpdate = new SgButton(image.fromActualizar(), "Actualizar");
        btUpdate.addClickHandler((ClickEvent event) -> {
            service.findAll(new MethodCallback<List<VtaCajConcepto>>() {
                @Override
                public void onFailure(Method method, Throwable exception) {
                    context.getErrorDrive().show(method, exception);
                }

                @Override
                public void onSuccess(Method method, List<VtaCajConcepto> response) {
                    List<VtaCajConcepto> listProvider = conceptosCajaListDataProvider.getList();
                    listProvider.clear();

                    if (response.isEmpty()) {
                        Toast.show("La consulta no genero registros");
                    } else {
                        Toast.show("Fin consulta");
                    }

                    for (VtaCajConcepto vcc : response) {
                        listProvider.add(vcc);
                    }

                }
            });
        });

        SgButton btEditar = new SgButton(image.formEditar(), "Editar");
        btEditar.addClickHandler((ClickEvent event) -> {
            SetWrapper<VtaCajConcepto> sw = new SetWrapper<>((MultiSelectionModel) cellTable.getSelectionModel());
            VtaCajConcepto co = sw.get(0);

            if (co == null) {
                Window.alert("No se selecciono ningun Registro");
            } else {

                // consigo el objeto actualizado de la db
                service.find(co.getConceptoId().toString(), new MethodCallback<VtaCajConcepto>() {
                    @Override
                    public void onFailure(Method method, Throwable exception) {
                        context.getErrorDrive().show(method, exception);
                    }

                    @Override
                    public void onSuccess(Method method, VtaCajConcepto response) {
                        //Asigno el objeto
                        formABM.setPojo(AccionFormulario.MODIFICACION, response);

                        setFrom(formABM);

                    }
                });

            }
        });

        SgButton btNew = new SgButton(image.formAgregar(), "Nuevo");
        btNew.addClickHandler((ClickEvent event) -> {
            VtaCajConcepto co = new VtaCajConcepto();
            co.setConceptoId(0);
            co.setDes("");
            co.setEstado(true);

            //Asigno el objeto
            formABM.setPojo(AccionFormulario.ALTA, co);

            setFrom(formABM);

////                formABM.setPojo();
////                widgetContainer.clear();
////                widgetContainer.add(formABM.getForm());
//                service.find("1", new MethodCallback<VtaCajConcepto>() {
//                    @Override
//                    public void onFailure(Method method, Throwable exception) {
//                        Window.alert("Error Mensaje:" + exception.getMessage());
//                    }
//
//                    @Override
//                    public void onSuccess(Method method, VtaCajConcepto response) {
//                        Window.alert(response.getDes());
//                    }
//                });
        });

        SgButton btDelete = new SgButton(image.formBorrar(), "Borrar");

        btDelete.addClickHandler((ClickEvent event) -> {
            service.findAll(new MethodCallback<List<VtaCajConcepto>>() {
                @Override
                public void onFailure(Method method, Throwable exception) {
                    context.getErrorDrive().show(method, exception);
                }

                @Override
                public void onSuccess(Method method, List<VtaCajConcepto> response) {
                    Window.alert(Arrays.toString(response.toArray()));

                }
            });
        });

        HorizontalPanel widget = new HorizontalPanel();

        widget.add(btUpdate);
        widget.add(btNew);
        widget.add(btEditar);
        widget.add(btDelete);

        fMenu = widget;
    }

    /**
     * Crea la tabla y todo lo necesario para la vista
     *
     *
     */
    private void createCellTable() {
        // Set a key provider that provides a unique key for each contact. If key is
        // used to identify contacts when fields (such as the name and address)
        // change.
        cellTable = new CellTable<>();
        cellTable.setWidth("100%", true);

        // Do not refresh the headers and footers every time the data is updated.
        cellTable.setAutoHeaderRefreshDisabled(true);
        cellTable.setAutoFooterRefreshDisabled(true);

        // Attach a column sort handler to the ListDataProvider to sort the list.
////        ColumnSortEvent.ListHandler<VtaCajConcepto> sortHandler
////                = new ColumnSortEvent.ListHandler<VtaCajConcepto>(ContactDatabase.get().getDataProvider().getList());
////        cellTable.addColumnSortHandler(sortHandler);
        // Create a Pager to control the table.
        SimplePager.Resources pagerResources = GWT.create(SimplePager.Resources.class);
        pager = new SimplePager(SimplePager.TextLocation.CENTER, pagerResources, false, 0, true);
        pager.setDisplay(cellTable);

        // Add a selection model so we can select cells.
        final SelectionModel<VtaCajConcepto> selectionModel = new MultiSelectionModel<>();
        cellTable.setSelectionModel(selectionModel);

        //cellTable.setRowCount(EMPLOYEES.size(), true);
        // Initialize the columns.
        initTableColumns(cellTable, selectionModel);

        conceptosCajaListDataProvider = new ListDataProvider<>();

        // Connect the table to the data provider.
        conceptosCajaListDataProvider.addDataDisplay(cellTable);

    }

    @Override
    public void onInitialize(Context context, HandlerManager eventBus) {
        this.context = context;
        this.eventBus = eventBus;

        service = GWT.create(VtaCajConceptoService.class);

        if (!init) {
            bind();

        }

        setPrincipal();

    }

    private void initTableColumns(CellTable<VtaCajConcepto> cellTable, final SelectionModel<VtaCajConcepto> selectionModel) {
        // Checkbox column. This table will uses a checkbox column for selection.
        // Alternatively, you can call cellTable.setSelectionEnabled(true) to enable
        // mouse selection.
        Column<VtaCajConcepto, Boolean> checkColumn = new Column<VtaCajConcepto, Boolean>(
                new CheckboxCell(true, false)) {
            @Override
            public Boolean getValue(VtaCajConcepto object) {
                // Get the value from the selection model.
                return selectionModel.isSelected(object);
            }
        };
        cellTable.addColumn(checkColumn, SafeHtmlUtils.fromSafeConstant("<br/>"));
        cellTable.setColumnWidth(checkColumn, 15, Style.Unit.PX);

        TextColumn<VtaCajConcepto> columnId = new TextColumn<VtaCajConcepto>() {
            @Override
            public String getValue(VtaCajConcepto object) {
                return object.getConceptoId().toString();
            }
        };

        // Add column to table
        cellTable.addColumn(columnId, "ID");
        cellTable.setColumnWidth(columnId, 5, Style.Unit.PCT);

        TextColumn<VtaCajConcepto> columnDes = new TextColumn<VtaCajConcepto>() {
            @Override
            public String getValue(VtaCajConcepto object) {
                return object.getDes();
            }
        };

        // Add column to table
        cellTable.addColumn(columnDes, "Descripcion");
        cellTable.setColumnWidth(columnDes, 20, Style.Unit.PCT);

    }

    @Override
    public Widget getToolMenu() {
        return fMenu;
    }

    @Override
    public Widget getMainPanel() {
        return widgetContainer;
    }

    /**
     * Muestro el winget principal
     *
     */
    private void setPrincipal() {
        //context.getScreenDrive().showActibity(widgetContainer);
        //context.getScreenDrive().showActibity(fMenu);
    }

    private void setFrom(FromABMConceptosCaja formABM) {
        //context.getScreenDrive().showActibity(formABM.getForm());
        //context.getScreenDrive().showActibity(formABM.getMenu());
    }

    @Override
    public void onReturn(boolean confirm, Object form) {
        if (confirm == true && form == formABM) {
            switch (formABM.getAccionFormulario()) {
                case ALTA:
                // conceptosCajaListDataProvider.getList().add()
                case BAJA:
                case MODIFICACION:
            }
        }
        setPrincipal();

    }

}
