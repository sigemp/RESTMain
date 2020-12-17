/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigemp.gestion.client.gui.sis_general;

import com.sigemp.gestion.client.gui.component.PageableButton;
import com.sigemp.gestion.client.gui.component.PageableInterface;
import com.sigemp.gestion.client.gui.component.SgImage;
import com.sigemp.gestion.client.gui.component.base.CRUD;
import com.sigemp.common.exception.SgException;
import com.sigemp.gestion.client.gui.component.base.ListTableModel;
import com.sigemp.gestion.client.gui.component.base.SgJInternalFrame;
import com.sigemp.gestion.client.gui.sis_general.form.FormGsyCertificados;
import com.sigemp.client.dto.PageableWrapper;
import com.sigemp.gestion.client.services.GsyCertificadoService;
import com.sigemp.gestion.client.services.ServiceFactory;
import com.sigemp.gestion.shared.dto.GsyCertificadosDto;
import com.sigemp.gestion.shared.dto.ventanaCertificados.ListCertificadoDto;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author cristian
 */
public class WABMCertificados extends SgJInternalFrame implements PageableInterface {

    private GsyCertificadosModel dm;
    GsyCertificadoService service = ServiceFactory.getGsyCertificadosService();
    private final PageableButton pageableButton = new PageableButton(this);
    private long firstQueryRecord;

    /**
     * Creates new form NewJDialog
     *
     * @param parent
     * @param modal
     */
    public WABMCertificados() {
        super();
    }

    @Override
    public void init() {
        initComponents();
        setIcon(SgImage.PANTALLA_PROVINCIA);

        jb_editar.setIcon(SgImage.REGISTROS_EDITAR.getImage(SgImage.SIZES.S16));
        jb_borrar.setIcon(SgImage.REGISTROS_BORRAR.getImage(SgImage.SIZES.S16));
        jb_agregar.setIcon(SgImage.REGISTROS_AGREGAR.getImage(SgImage.SIZES.S16));
        jb_buscar.setIcon(SgImage.REGISTROS_ACTUALIZAR.getImage(SgImage.SIZES.S16));

        String[] cols = {ColumName.ID.getName(),
            ColumName.DESCRIPCION.getName(),
            ColumName.ACTIVO.getName(),
            ColumName.TIPO.getName(),
            ColumName.FEC.getName()
        };

        dm = new GsyCertificadosModel(cols);
        dm.setTablaAsociada(jTable1);
        dm.setColumnasTamano(new int[]{120, 300});

        jPanelPageableContent.add(pageableButton);

        pageableButton.addPageableListener((long firstRecord, long querySize) -> {
            firstQueryRecord = firstRecord;
            consultar();
        });
        pack();
    }

    private void acciones(CRUD cur) {

        try {

            FormGsyCertificados abm = new FormGsyCertificados(getMainParent(), false);
            switch (cur) {
                case ALTA: {
                    abm.setId(0, cur);
                    abm.setVisible(true);
                    if (abm.isConfirmed()) {
                        GsyCertificadosDto cusadd = abm.getRecord();
                        int id = service.restCreate(cusadd);
                        ListCertificadoDto dto = service.restFindView(id);
                        dm.addRow(dto);
                    }
                    break;
                }
                case BAJA: {
                    int x = JOptionPane.showConfirmDialog(this, "Elimina?", "Eliminar Registro", JOptionPane.YES_NO_OPTION);
                    if (x == JOptionPane.YES_OPTION) {
                        ListCertificadoDto entity = getCurrentRecortd();
                        service.restRemove(entity.getCerId());
                        dm.removeRow(entity);
                    }
                    break;
                }
                case MODIFICACION: {
                    ListCertificadoDto entity = getCurrentRecortd();
                    abm.setId(entity.getCerId(), cur);
                    abm.setVisible(true);
                    if (abm.isConfirmed()) {
                        GsyCertificadosDto cusadd = abm.getRecord();
                        service.restEdit(cusadd);
                        ListCertificadoDto dto = service.restFindView(entity.getCerId());
                        dm.refresh(entity, dto);
                    }
                    break;
                }
                default:
            }
        } catch (Exception ex) {
            Logger.getLogger(WABMCertificados.class.getName()).log(Level.SEVERE, null, ex);
            me(ex);
        }
    }

    @Override
    public void consultar() {
        try {

            HashMap<String, Object> map = new HashMap<>();

            String des = jTextField1.getText();
            if (des.length() > 0) {
                map.put("des", des);
            }

            PageableWrapper<ListCertificadoDto> pag = service.restListView(map, pageableButton.getCurrentFirstRecord(), pageableButton.getSizeQuery());

            List<ListCertificadoDto> list = pag.getList();

            pageableButton.setCountRecord(pag.getCount());

            dm.removeAll();
            dm.addAll(list);
            dm.seleccionarEnTablaPrimero();
        } catch (Exception ex) {
            Logger.getLogger(WABMCertificados.class.getName()).log(Level.SEVERE, null, ex);
            me(ex);
        }
    }

    private ListCertificadoDto getCurrentRecortd() throws Exception {
        int x = jTable1.getSelectedRow();
        if (x > -1) {
            x = jTable1.convertRowIndexToModel(x);
            ListCertificadoDto cu = dm.getRow(x);
            return cu;
        }
        throw new Exception("Seleccione un registro");

    }

    public enum ColumName {
        ID("Id"), DESCRIPCION("Descripcion"), ACTIVO("Activo"), TIPO("Tipo"), FEC("Fecha");
        private String des;

        ColumName(String des) {
            this.des = des;
        }

        public String getName() {
            return des;
        }
    }

    class GsyCertificadosModel extends ListTableModel<ListCertificadoDto> {

        public GsyCertificadosModel(String[] columnNames) {
            super(columnNames);
        }

        public GsyCertificadosModel(String[] columnNames, JTable jtablaAsociada) throws SgException {
            super(columnNames, jtablaAsociada);
        }

        @Override
        public Class getColumnClass(int c) {
            ColumName cn = ColumName.values()[c];
            switch (cn) {
                case ID:
                    return Long.class;
                case DESCRIPCION:
                    return String.class;
                case ACTIVO:
                    return Boolean.class;
                case FEC:
                    return Date.class;
                case TIPO:
                    return String.class;
            }
            return null;

        }

        @Override
        public Object getValueAt(int row, int column) {
            ListCertificadoDto e = getRow(row);
            ColumName cn = ColumName.values()[column];
            switch (cn) {
                case ID:
                    return e.getCerId();
                case DESCRIPCION:
                    return e.getDes();
                case ACTIVO:
                    return e.getActivo();
                case FEC:
                    return e.getFec();
                case TIPO:
                    return e.getTipo();
            }
            return null;
        }

        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jb_agregar = new javax.swing.JButton();
        jb_editar = new javax.swing.JButton();
        jb_borrar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jb_buscar = new javax.swing.JButton();
        jPanelPageableContent = new javax.swing.JPanel();

        getContentPane().setLayout(new java.awt.BorderLayout());

        jScrollPane1.setViewportView(jTable1);

        jPanel1.setLayout(new java.awt.FlowLayout(0));

        jb_agregar.setText("Agregar");
        jb_agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_agregarActionPerformed(evt);
            }
        });
        jPanel1.add(jb_agregar);

        jb_editar.setText("Editar");
        jb_editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_editarActionPerformed(evt);
            }
        });
        jPanel1.add(jb_editar);

        jb_borrar.setText("Borrar");
        jb_borrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_borrarActionPerformed(evt);
            }
        });
        jPanel1.add(jb_borrar);

        jLabel1.setText("Buscar:");

        jb_buscar.setText("Buscar");
        jb_buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_buscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jb_buscar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jb_buscar))
                .addContainerGap(8, Short.MAX_VALUE))
        );

        jPanelPageableContent.setLayout(new java.awt.FlowLayout(0));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 505, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 505, Short.MAX_VALUE)
                    .addComponent(jPanelPageableContent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 322, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelPageableContent, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jb_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_buscarActionPerformed
        pageableButton.setCurrentFirstRecord(0);
        consultar();
    }//GEN-LAST:event_jb_buscarActionPerformed

    private void jb_editarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_editarActionPerformed
        acciones(CRUD.MODIFICACION);
    }//GEN-LAST:event_jb_editarActionPerformed

    private void jb_borrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_borrarActionPerformed
        acciones(CRUD.BAJA);
    }//GEN-LAST:event_jb_borrarActionPerformed

    private void jb_agregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_agregarActionPerformed
        acciones(CRUD.ALTA);
    }//GEN-LAST:event_jb_agregarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanelPageableContent;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JButton jb_agregar;
    private javax.swing.JButton jb_borrar;
    private javax.swing.JButton jb_buscar;
    private javax.swing.JButton jb_editar;
    // End of variables declaration//GEN-END:variables
}
