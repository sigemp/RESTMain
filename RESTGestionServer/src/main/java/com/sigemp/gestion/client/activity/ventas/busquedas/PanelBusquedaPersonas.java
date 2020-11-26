/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigemp.gestion.client.activity.ventas.busquedas;

import com.google.gwt.cell.client.CheckboxCell;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style;
import com.google.gwt.safehtml.shared.SafeHtmlUtils;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.cellview.client.SimplePager;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.view.client.ListDataProvider;
import com.google.gwt.view.client.MultiSelectionModel;
import com.google.gwt.view.client.SelectionModel;
import com.sigemp.gestion.client.api.ui.PanelBusqueda;
import com.sigemp.gestion.client.api.ui.Toast;
import com.sigemp.gestion.client.api.util.SetWrapper;
import com.sigemp.gestion.client.service.GsyPersService;
import com.sigemp.gestion.shared.dto.PersonasDto;
import java.util.List;
import org.fusesource.restygwt.client.Method;
import org.fusesource.restygwt.client.MethodCallback;

/**
 *
 * @author sigem
 */
public class PanelBusquedaPersonas extends PanelBusqueda {

    private static GsyPersService service;

    private CellTable<PersonasDto> cellTable;

    private ListDataProvider<PersonasDto> dataProvider;

    private SimplePager pager;

    private SelectionModel<PersonasDto> selectionModel;
    
    PersonasDto objetoSeleccionado = null;

    @Override
    public void onCreate() {
        super.onCreate();

        service = GWT.create(GsyPersService.class);

        createCellTable();
        
        

        // Agrego el cellTable al contenedor
        getContenedor().add(cellTable);
        
        setCellTable(cellTable);
        
 
    }

    private void createCellTable() {
        // Set a key provider that provides a unique key for each contact. If key is
        // used to identify contacts when fields (such as the name and address)
        // change.
        cellTable = new CellTable<>();
        cellTable.setWidth("100%", true);
        cellTable.setPageSize(1000);

        // Do not refresh the headers and footers every time the data is updated.
        cellTable.setAutoHeaderRefreshDisabled(true);
        cellTable.setAutoFooterRefreshDisabled(true);

        // Attach a column sort handler to the ListDataProvider to sort the list.
////        ColumnSortEvent.ListHandler<PersonasDto> sortHandler
////                = new ColumnSortEvent.ListHandler<PersonasDto>(ContactDatabase.get().getDataProvider().getList());
////        cellTable.addColumnSortHandler(sortHandler);
        // Create a Pager to control the table.
//        SimplePager.Resources pagerResources = GWT.create(SimplePager.Resources.class);
//        pager = new SimplePager(SimplePager.TextLocation.CENTER, pagerResources, false, 0, true);
//        pager.setDisplay(cellTable);

        // Add a selection model so we can select cells.
        selectionModel = new MultiSelectionModel<>();
        cellTable.setSelectionModel(selectionModel);

        //cellTable.setRowCount(EMPLOYEES.size(), true);
        // Initialize the columns.
        initTableColumns(selectionModel);

        dataProvider = new ListDataProvider<>();

        // Connect the table to the data provider.
        dataProvider.addDataDisplay(cellTable);

    }

    @Override
    public void buscar(String text) {

        service.findDto(text, new MethodCallback<List<PersonasDto>>() {
            @Override
            public void onFailure(Method method, Throwable exception) {
                //context.getErrorDrive().show(method, exception);
            }

            @Override
            public void onSuccess(Method method, List<PersonasDto> response) {
                List<PersonasDto> listProvider = dataProvider.getList();
                listProvider.clear();

                if (response.isEmpty()) {
                    Toast.show("La consulta no genero registros");
                } else {
                    Toast.show("Fin consulta");
                }

                for (PersonasDto vcc : response) {
                    listProvider.add(vcc);
                }
            }
        });
    }

    private void initTableColumns(final SelectionModel<PersonasDto> selectionModel) {
        // Checkbox column. This table will uses a checkbox column for selection.
        // Alternatively, you can call cellTable.setSelectionEnabled(true) to enable
        // mouse selection.
        Column<PersonasDto, Boolean> checkColumn = new Column<PersonasDto, Boolean>(
                new CheckboxCell(true, false)) {
            @Override
            public Boolean getValue(PersonasDto object) {
                // Get the value from the selection model.
                return selectionModel.isSelected(object);
            }
        };
        cellTable.addColumn(checkColumn, SafeHtmlUtils.fromSafeConstant("<br/>"));
        cellTable.setColumnWidth(checkColumn, 5, Style.Unit.PCT);

        TextColumn<PersonasDto> columnId = new TextColumn<PersonasDto>() {
            @Override
            public String getValue(PersonasDto object) {
                return object.getCtaId().toString();
            }
        };

        // Add column to table
        cellTable.addColumn(columnId, "ID");
        cellTable.setColumnWidth(columnId, 5, Style.Unit.PCT);

        TextColumn<PersonasDto> columnDes = new TextColumn<PersonasDto>() {
            @Override
            public String getValue(PersonasDto object) {
                return object.getNombre();
            }
        };

        // Add column to table
        cellTable.addColumn(columnDes, "Nombre");
        cellTable.setColumnWidth(columnDes, 20, Style.Unit.PCT);

    }

    @Override
    public void onAccept() {
        
        SetWrapper<PersonasDto> sw = new SetWrapper<>((MultiSelectionModel) cellTable.getSelectionModel());
        
        PersonasDto co = null;
        
        if (sw.getSet().isEmpty()) {
            int idx = cellTable.getKeyboardSelectedRow();
            if (idx > -1) {
                co = dataProvider.getList().get(idx);
            }
        } else {
            co = sw.get(0);
        }
        
        if (co != null) {
            objetoSeleccionado = co;
            fire(co);
            hide();
        } else {
            objetoSeleccionado = null;
            Toast.show("No se selecciono ningun registro");
        }
    }

    @Override
    public boolean isSelected() {
        return (objetoSeleccionado != null);
    }

    

}
