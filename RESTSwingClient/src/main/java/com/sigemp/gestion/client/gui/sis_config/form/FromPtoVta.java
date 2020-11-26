package com.sigemp.gestion.client.gui.sis_config.form;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

 /*
 * PanelTalonariosForm.java
 *
 * Created on 23/11/2011, 12:53:00
 */
import com.sigemp.afip.ifis.ConstantesFiscales;
import com.sigemp.afip.ifis.ConstantesFiscales.Baudios;
import com.sigemp.afip.ifis.ConstantesFiscales.Marcas;
import com.sigemp.afip.ifis.ConstantesFiscales.Modelos;
import com.sigemp.afip.ifis.ConstantesFiscales.Puertos;
////import com.sigemp.client.comunes.utiles.SSLCripto;
////import com.sigemp.client.comunes.utiles.Util;

//import com.sigemp.client.gestion.utiles.GestionUtil;
import com.sigemp.common.SwingUtils;
import com.sigemp.common.exception.SgException;
import com.sigemp.gestion.client.gui.component.SgImage;
import com.sigemp.gestion.client.gui.component.base.CRUD;
import com.sigemp.gestion.client.gui.component.base.Toast;
import com.sigemp.gestion.client.online.wrapper.WrapperPtoVta;
import com.sigemp.gestion.client.services.GsySucService;
import com.sigemp.gestion.client.services.GsyTalonarioService;
import com.sigemp.gestion.client.services.ServiceFactory;
import com.sigemp.gestion.client.services.StkDepositoService;
import com.sigemp.gestion.shared.entity.GsySuc;
import com.sigemp.gestion.shared.entity.GsyTalonarios;
import com.sigemp.gestion.shared.entity.StkDepositos;
import java.awt.Image;
import java.awt.event.ItemEvent;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author CRISTIANE
 */
public class FromPtoVta extends javax.swing.JPanel {

//    private final ControladorStkDepositos controladorDepositos = DAOFactory.getDaoStkDepositos();
    private final GsyTalonarioService controladorTalonarios = ServiceFactory.getGsyTalonario();
    private final GsySucService controladorSucService = ServiceFactory.getGsySucService();
    private final StkDepositoService controladorDepositosService = ServiceFactory.getStkDepositoService();

//    private final ControladorGsySuc controladorSucursal = DAOFactory.getDaoGsySuc();
    private boolean confirmed = false;
    private CRUD crud;
    protected GsyTalonarios currentRecord;
    protected WrapperPtoVta wcurrentRecord;

    /**
     * Get the value of currentRecord
     *
     * @return the value of currentRecord
     */
    public GsyTalonarios getCurrentRecord() {
        return currentRecord;
    }

    public void setId(Integer id) throws Exception {
        // busco el id
        //si existe

        if (id == null) {
            setCurrentRecord(new GsyTalonarios(), CRUD.ALTA);
        } else {
            GsyTalonarios talonario = controladorTalonarios.find(id);
            setCurrentRecord(talonario, CRUD.MODIFICACION);
            // si no existe , laro error
        }
    }

    /**
     * debe venir en nullo talId para que permita ingresar un codigo de
     * talonario
     *
     * @param currentRecord new value of currentRecord
     * @param crud
     */
    public void setCurrentRecord(GsyTalonarios currentRecord, CRUD crud) {
        this.currentRecord = currentRecord;
        this.wcurrentRecord = WrapperPtoVta.instance(currentRecord);
        this.crud = crud;

        Puertos puerto = wcurrentRecord.getTrPuerto();
        if (puerto == null) {
            puerto = Puertos.COM1;
        }

        jcPuertos.setSelectedItem(puerto);
        jcBaudios.setSelectedItem(wcurrentRecord.getTrBaudios());

        jcMarca.setSelectedItem(wcurrentRecord.getTrMarca());

        jCheckBox1.setSelected(currentRecord.getEstado());

        jtDescripcion.setText(currentRecord.getDes());

        StkDepositos dep = currentRecord.getDepoId();
        if (dep != null) {
            GsySuc suc = dep.getSucId();
            jcSucursal.setSelectedItem(suc);
            actualizarDepositos();
            jcDeposito.setSelectedItem(dep);
        }

        if (currentRecord.getTalId() == null) {
            jFormattedTextField1.setEnabled(true);
            currentRecord.setTalId(0);
        } else {
            jFormattedTextField1.setEnabled(false);
            jFormattedTextField1.setValue(currentRecord.getTalId());
        }
    }

    /**
     * Creates new form PanelTalonariosForm
     */
    public FromPtoVta() {

        initComponents();

        jButton1.setIcon(SgImage.AYUDA.getImage(SgImage.SIZES.S16));
        jb_guardar.setIcon(SgImage.ACEPTAR.getImage(SgImage.SIZES.S16));
        jcMarca.removeAllItems();
        for (Marcas marca : ConstantesFiscales.Marcas.values()) {
            jcMarca.addItem(marca);
        }

        jcBaudios.removeAllItems();
        for (Baudios baudios : ConstantesFiscales.Baudios.values()) {
            jcBaudios.addItem(baudios);
        }

        jcPuertos.removeAllItems();
        for (Puertos puerto : ConstantesFiscales.Puertos.values()) {
            jcPuertos.addItem(puerto);
        }

        SwingUtils.setMaskCantidadDecimal(jFormattedTextField1, 0);
        SwingUtils.setSelectText(jFormattedTextField1);
        SwingUtils.setSelectText(jtDescripcion);

        try {
            List<GsySuc> list = controladorSucService.getAll();
            jcSucursal.removeAllItems();
            for (GsySuc s : list) {
                jcSucursal.addItem(s);
            }
        } catch (Exception ex) {
            Logger.getLogger(FromPtoVta.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

//        } catch (SgException ex) {
//            LOG.log(Level.SEVERE, null, ex);
//        }

//        } catch (SgException ex) {
//            LOG.log(Level.SEVERE, null, ex);
//        }
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
        jLabel2 = new javax.swing.JLabel();
        jFormattedTextField1 = new javax.swing.JFormattedTextField();
        jCheckBox1 = new javax.swing.JCheckBox();
        jLabel3 = new javax.swing.JLabel();
        jtDescripcion = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jcSucursal = new javax.swing.JComboBox();
        jLabel9 = new javax.swing.JLabel();
        jcDeposito = new javax.swing.JComboBox();
        jPanel1 = new javax.swing.JPanel();
        jcMarca = new javax.swing.JComboBox();
        jcModelo = new javax.swing.JComboBox();
        jcPuertos = new javax.swing.JComboBox();
        jcBaudios = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jcWSFEEntryPoint = new javax.swing.JComboBox();
        jb_guardar = new javax.swing.JButton();

        jPanel2.setLayout(null);

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("ID:");
        jPanel2.add(jLabel2);
        jLabel2.setBounds(10, 5, 60, 20);
        jPanel2.add(jFormattedTextField1);
        jFormattedTextField1.setBounds(75, 5, 110, 20);

        jCheckBox1.setText("Activo");
        jCheckBox1.setMaximumSize(new java.awt.Dimension(55, 20));
        jCheckBox1.setMinimumSize(new java.awt.Dimension(55, 20));
        jCheckBox1.setPreferredSize(new java.awt.Dimension(55, 20));
        jPanel2.add(jCheckBox1);
        jCheckBox1.setBounds(203, 5, 55, 20);

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Descripcion:");
        jPanel2.add(jLabel3);
        jLabel3.setBounds(10, 30, 60, 20);
        jPanel2.add(jtDescripcion);
        jtDescripcion.setBounds(75, 31, 300, 20);

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Sucursal:");
        jLabel7.setPreferredSize(new java.awt.Dimension(91, 20));
        jPanel2.add(jLabel7);
        jLabel7.setBounds(10, 55, 60, 20);

        jcSucursal.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcSucursalItemStateChanged(evt);
            }
        });
        jPanel2.add(jcSucursal);
        jcSucursal.setBounds(75, 55, 300, 20);

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("Deposito:");
        jLabel9.setPreferredSize(new java.awt.Dimension(91, 20));
        jPanel2.add(jLabel9);
        jLabel9.setBounds(10, 80, 60, 20);
        jPanel2.add(jcDeposito);
        jcDeposito.setBounds(75, 80, 300, 20);

        jPanel1.setBackground(new java.awt.Color(255, 255, 204));
        jPanel1.setLayout(null);

        jcMarca.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcMarcaItemStateChanged(evt);
            }
        });
        jPanel1.add(jcMarca);
        jcMarca.setBounds(115, 5, 100, 20);

        jcModelo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcModeloItemStateChanged(evt);
            }
        });
        jPanel1.add(jcModelo);
        jcModelo.setBounds(115, 30, 100, 20);

        jPanel1.add(jcPuertos);
        jcPuertos.setBounds(115, 55, 100, 20);

        jPanel1.add(jcBaudios);
        jcBaudios.setBounds(115, 80, 100, 20);

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Modelo:");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(5, 30, 100, 20);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Puerto:");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(5, 55, 100, 20);

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Marca:");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(5, 5, 100, 20);

        jButton1.setToolTipText("Comprobantes que Soporta");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(225, 5, 30, 20);

        jLabel8.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel1.add(jLabel8);
        jLabel8.setBounds(310, 0, 110, 100);

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setText("Baudios:");
        jPanel1.add(jLabel10);
        jLabel10.setBounds(5, 80, 100, 20);

        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel11.setText("Servicio WSFE:");
        jPanel1.add(jLabel11);
        jLabel11.setBounds(10, 110, 100, 20);
        jPanel1.add(jcWSFEEntryPoint);
        jcWSFEEntryPoint.setBounds(115, 110, 300, 20);

        jb_guardar.setText("Guardar");
        jb_guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_guardarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 423, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(324, 324, 324)
                .addComponent(jb_guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jb_guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jb_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_guardarActionPerformed
        commandAccept();
    }//GEN-LAST:event_jb_guardarActionPerformed

    private void jcMarcaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcMarcaItemStateChanged
        actualizar(evt);
    }//GEN-LAST:event_jcMarcaItemStateChanged

    private void jcModeloItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcModeloItemStateChanged
        mostrarImagen(evt);
    }//GEN-LAST:event_jcModeloItemStateChanged

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        mostrarModelosSoportados();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jcSucursalItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcSucursalItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            actualizarDepositos();
        }
    }//GEN-LAST:event_jcSucursalItemStateChanged

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JFormattedTextField jFormattedTextField1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton jb_guardar;
    private javax.swing.JComboBox jcBaudios;
    private javax.swing.JComboBox jcDeposito;
    private javax.swing.JComboBox jcMarca;
    private javax.swing.JComboBox jcModelo;
    private javax.swing.JComboBox jcPuertos;
    private javax.swing.JComboBox jcSucursal;
    private javax.swing.JComboBox jcWSFEEntryPoint;
    private javax.swing.JTextField jtDescripcion;
    // End of variables declaration//GEN-END:variables

//    public void setNode(DefaultMutableTreeNode dmtn, DefaultTreeModel modelo) {
//        this.dmtn = dmtn;
//        this.modelo = modelo;
//    }
    private void actualizar(ItemEvent evt) {

        if (evt.getStateChange() == ItemEvent.SELECTED) {
            Marcas marca = (Marcas) jcMarca.getSelectedItem();
            jcModelo.removeAllItems();

            for (Modelos m : Modelos.getModelos(marca)) {
                jcModelo.addItem(m);
            }

            if (currentRecord != null) {
                jcModelo.setSelectedItem(wcurrentRecord.getTrModelo());
            }
            if (null != marca) {
                switch (marca) {
                    case AFIP:
                        jcPuertos.setEnabled(false);
                        jcBaudios.setEnabled(false);
                        jcWSFEEntryPoint.setEnabled(true);
                        break;
                    case EPSON:
                    case HASAR:
                        jcPuertos.setEnabled(true);
                        jcBaudios.setEnabled(true);
                        jcWSFEEntryPoint.setEnabled(false);
                        break;
                    case MANUAL:
                        jcPuertos.setEnabled(false);
                        jcBaudios.setEnabled(false);
                        jcWSFEEntryPoint.setEnabled(false);
                        break;
                    default:
                        break;
                }

            }
        }
    }

    private void mostrarModelosSoportados() {
        Modelos mod = (Modelos) jcModelo.getSelectedItem();

        String str = ConstantesFiscales.comprobantesSoportadosToString(mod);
        JOptionPane.showMessageDialog(this, str);

    }

    private void mostrarImagen(ItemEvent evt) {
        Modelos modelos = (Modelos) jcModelo.getSelectedItem();
        if (modelos == null) {
            return;
        }
        String imageName = modelos.getImageName().trim();
        if (!"".equals(imageName)) {
            try {
                ImageIcon icon = new ImageIcon(getClass().getResource("/com/sigemp/afip/ifis/png/" + modelos.getImageName()));
                Image newimg = icon.getImage().getScaledInstance(98, 98, java.awt.Image.SCALE_SMOOTH);
                jLabel8.setIcon(new ImageIcon(newimg));
            } catch (NullPointerException ex) {

            }
        } else {
            jLabel8.setIcon(null);
        }

    }

    private void actualizarDepositos() {
        jcDeposito.removeAllItems();
        GsySuc suc = (GsySuc) jcSucursal.getSelectedItem();
        try {
            List<StkDepositos> list = controladorDepositosService.getAll();
            jcDeposito.removeAllItems();
            for (StkDepositos s : list) {
                if (s.getSucId().getSucId().equals(suc.getSucId())) {
                    jcDeposito.addItem(s);
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(FromPtoVta.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public GsyTalonarios getFromForm() {
        wcurrentRecord.setTrPuerto((Puertos) jcPuertos.getSelectedItem());

        StkDepositos dep = (StkDepositos) jcDeposito.getSelectedItem();
        currentRecord.setDepoId(dep);

        currentRecord.setDes(jtDescripcion.getText());
        currentRecord.setEstado(jCheckBox1.isSelected());

        wcurrentRecord.setTrMarca((Marcas) jcMarca.getSelectedItem());
        wcurrentRecord.setTrModelo((Modelos) jcModelo.getSelectedItem());

        wcurrentRecord.setTrBaudios((Baudios) jcBaudios.getSelectedItem());

        if (currentRecord.getTalId() != null) {
            currentRecord.setTalId(SwingUtils.getInt(jFormattedTextField1));
        }
        return currentRecord;
    }

    private void commandAccept() {
        try {
            if (jcDeposito.getSelectedItem() == null) {
                JOptionPane.showMessageDialog(this, "Debe elejir un deposito!!");
                return;
            }

            guardarDatos();
        } catch (SgException ex) {
            LOG.log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private static final Logger LOG = Logger.getLogger(FromPtoVta.class.getName());

    private void guardarDatos() throws SgException {
//        GsyTalonarios tal = controladorTalonarios.editDto(currentRecord);
//        if (tal != null) {
//            setCurrentRecord(tal);
//            Toast.show("Datos del Talonario Guardado");
//        }
    }

    private void recarcarDatos() {
//        GsyTalonarios tal = controladorTalonarios.findDtoById(currentRecord.getTalId());
//        setCurrentRecord(tal);
    }

}
