/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigemp.gestion.client.gui.component.base;

import com.sigemp.common.exception.SgException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author Server
 * @param <T>
 */
public abstract class ListTableModel<T> extends AbstractTableModel {

    private String[] columnNames = {""};
    private List<T> grupo = new ArrayList<>();
    private JTable tablaAsociada = null;

    public ListTableModel(String[] columnNames) {
        this.columnNames = columnNames;
        this.tablaAsociada = null;
    }

    public ListTableModel(String[] columnNames, JTable tablaAsociada) throws SgException {
        this.columnNames = columnNames;
        this.tablaAsociada = tablaAsociada;
    }

    public int addRow(T e) {
        int row = grupo.size();
        grupo.add(row, e);
        fireTableRowsInserted(row, row);
        return row;
    }

    @Override
    abstract public Class getColumnClass(int columnIndex);

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    /**
     * Aplica el tamaño a las columnas si se especifica -1 no se aplica el
     * tamaño
     *
     * @param columnSizes
     */
    public void setColumnasTamano(int[] columnSizes) {
        if (tablaAsociada == null) {
            return;
        }
        int columns = tablaAsociada.getColumnCount();
        for (int x = 0; x < columnSizes.length; x++) {
            if (x >= columns) {
                break;
            }
            if (columnSizes[x] < 0) {
                continue;
            }
            tablaAsociada.getColumnModel().getColumn(x).setPreferredWidth(columnSizes[x]);
        }

    }

    public int getIndexRow(T e) {
        return grupo.indexOf(e);
    }

    public List<T> getList() {
        return grupo;
    }

    /**
     *
     * Agrega items a la lista
     *
     * @param list
     */
    public void addAll(List<T> list) {
        grupo.clear();
        grupo.addAll(list);

        //03-09-2015 this.grupo = list;
        ListTableModel.this.refresh();
    }

    /**
     *
     * Iguala la lista
     *
     * @param list
     */
    public void setList(List<T> list) {

        grupo = list;

        ListTableModel.this.refresh();
    }

    public T getRow(int row) {
        return grupo.get(row);
    }

    @Override
    public int getRowCount() {
        return grupo.size();
    }

    /**
     * @return the tablaAsociada
     */
    public JTable getTablaAsociada() {
        return tablaAsociada;
    }

    /**
     * @param tablaAsociada the tablaAsociada to set
     */
    public void setTablaAsociada(JTable tablaAsociada) {
        if (tablaAsociada != null) {
            tablaAsociada.setModel(this);
        }
        this.tablaAsociada = tablaAsociada;

    }

    @Override
    abstract public Object getValueAt(int row, int column);

    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
    }

    /**
     * Oculta las columnas , tiene que estar previamente asociada una tabla
     *
     *
     * @param integer
     */
    public void ocultarColumnas(Integer[] integer) {
        if (tablaAsociada != null) {
            TableColumnModel tcm = tablaAsociada.getColumnModel();

            for (Integer nroColumn : integer) {
                TableColumn c = tcm.getColumn(nroColumn);
                if (c != null) {
                    c.setMinWidth(0);
                    c.setMaxWidth(0);
                    c.setWidth(0);
                }
            }
        }
    }

    public void refresh() {
        fireTableDataChanged();
    }

    /**
     * Refresca el objeto en el jtable
     *
     * @param object
     */
    public void refresh(T object) {
        int row = grupo.indexOf(object);
        fireTableRowsUpdated(row, row);
    }

    /**
     * Actualiza el Dto por uno nuevo Utilizado para actualizar el registro
     * despues de algun cambio
     *
     */
    public void refresh(T enityOld, T entityNew) {
        int index = grupo.indexOf(enityOld);
        grupo.set(index, entityNew);
        fireTableRowsUpdated(index, index);
    }

    public void refreshRow(int firstRow, int lastRow) {
        fireTableRowsUpdated(firstRow, lastRow);
    }

    /**
     * Borra todos los objetos de la lista
     *
     */
    public void removeAll() {
        grupo.clear();
        ListTableModel.this.refresh();
    }

    public void removeRow(T e) {
        int row = grupo.indexOf(e);
        if (row < 0) {
            return;
        }
        grupo.remove(row);
        fireTableRowsDeleted(row, row);
    }

    public void removeRow(int rowIndex) {
        grupo.remove(rowIndex);
        fireTableRowsDeleted(rowIndex, rowIndex);
    }

    /**
     * Reemplaza el Objeto seleccionado busca en la lista el objeto comparandolo
     * con el metodo equal el cual debe ser implementado
     *
     * @param e
     */
    public void replace(T e) {
        int index = getIndexRow(e);
        setRow(index, e);
    }

    /**
     * Selecciona un registro en la tabla asociada Si el index es negativo, no
     * hace nada
     *
     */
    public void seleccionar(int index) {
        if (tablaAsociada == null) {
            return;
        }
        if (index < 0 || index > grupo.size()) {
            return;
        }
        tablaAsociada.scrollRectToVisible(tablaAsociada.getCellRect(index, 0, true));
        tablaAsociada.getSelectionModel().setSelectionInterval(index, index);
    }

    /**
     * Selecciona el objeto en la tabla para que este metodo funcione antes debe
     * haberse asociado la tabla asociacda por medio de setTablaAsociada
     *
     *
     * @param enityOld
     */
    public void seleccionarEnTablaPrimero() {
        try {
            if (tablaAsociada == null) {
                return;
            }
            int row = 0;
            if (tablaAsociada.getModel().getRowCount() > 0) {
                tablaAsociada.scrollRectToVisible(tablaAsociada.getCellRect(row, 0, true));
                tablaAsociada.getSelectionModel().setSelectionInterval(row, row);
            }
        } catch (Exception e) {
        }
    }

    /**
     * Selecciona el ultimo registro de la tabla tiene que haberse asociado una
     * tabla con el metodo setTablaAsociada
     *
     *
     * @param enityOld
     */
    public void seleccionarEnTablaUltima() {
        try {
            if (tablaAsociada == null) {
                return;
            }
            int row = grupo.size() - 1;
            if (row > -1) {
                tablaAsociada.scrollRectToVisible(tablaAsociada.getCellRect(row, 0, true));
                tablaAsociada.getSelectionModel().setSelectionInterval(row, row);
            }
        } catch (Exception e) {
        }
    }

    /**
     * Selecciona el objeto en la tabla para que este metodo funcione antes debe
     * haberse asociado la tabla asociacda por medio de setTablaAsociada la
     * seleccion la hace por medio del metodo o.equals(), si el el id es nullo
     * no se va a poder identificar el objeto en la lista
     *
     * @param enityOld
     */
    public void seleccionarEntity(T enityOld) {
        try {
            if (tablaAsociada == null) {
                return;
            }
            int row = 0;
            if (enityOld == null) {
                row = tablaAsociada.convertRowIndexToView(grupo.size() - 1);
            } else {
                row = tablaAsociada.convertRowIndexToView(grupo.indexOf(enityOld));
            }

            tablaAsociada.scrollRectToVisible(tablaAsociada.getCellRect(row, 0, true));
            tablaAsociada.getSelectionModel().setSelectionInterval(row, row);
        } catch (Exception e) {
        }
    }

    public void setRow(int x, T e) {
        grupo.set(x, e);
        fireTableRowsUpdated(x, x);
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int column) {
    }
}
