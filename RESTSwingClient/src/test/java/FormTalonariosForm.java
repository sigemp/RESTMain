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
import com.sigemp.afip.ifis.ConstantesFiscales.AFIP_END_POINTS;
import com.sigemp.afip.ifis.ConstantesFiscales.Baudios;
import com.sigemp.afip.ifis.ConstantesFiscales.Marcas;
import com.sigemp.afip.ifis.ConstantesFiscales.Modelos;
import com.sigemp.afip.ifis.ConstantesFiscales.Puertos;
import com.sigemp.afip.ws.util.UtilXML;
import com.sigemp.client.comunes.abm.dialogs.AfipCheckDialog;
import com.sigemp.client.comunes.utiles.SSLCripto;
import com.sigemp.client.comunes.utiles.Util;
import com.sigemp.client.comunes.utiles.UtilDeComponentes;
import com.sigemp.client.gestion.utiles.GestionUtil;
import com.sigemp.client.libreria.abstractos.Toast;
import com.sigemp.server.gestion.controladores.ControladorGsySuc;
import com.sigemp.server.gestion.controladores.ControladorGsyTalonarios;
import com.sigemp.server.gestion.controladores.ControladorStkDepositos;
import com.sigemp.server.gestion.controladores.DAOFactory;
import com.sigemp.server.gestion.controladores.ParametrosGeneral;
import com.sigemp.server.gestion.entity.GsySuc;
import com.sigemp.server.gestion.entity.GsyTalonario;
import com.sigemp.server.gestion.entity.StkDeposito;
import com.sigemp.share.gestion.exception.SgException;
import java.awt.Image;
import java.awt.event.ItemEvent;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author CRISTIANE
 */
public class FormTalonariosForm extends javax.swing.JPanel {

    private final ControladorStkDepositos controladorDepositos = DAOFactory.getDaoStkDepositos();
    private final ControladorGsyTalonarios controladorTalonarios = DAOFactory.getDaoGsyTalonarios();
    private final ControladorGsySuc controladorSucursal = DAOFactory.getDaoGsySuc();

    protected GsyTalonario currentRecord;

    /**
     * Get the value of currentRecord
     *
     * @return the value of currentRecord
     */
    public GsyTalonario getCurrentRecord() {
        return currentRecord;
    }

    /**
     * debe venir en nullo talId para que permita ingresar un codigo de
     * talonario
     *
     * @param currentRecord new value of currentRecord
     */
    public void setCurrentRecord(GsyTalonario currentRecord) {
        this.currentRecord = currentRecord;

        Puertos puerto = currentRecord.getTrPuerto();
        if (puerto == null) {
            puerto = Puertos.COM1;
        }

        jtWSFEV.setText(currentRecord.getFeEndpointWsfe());
        jtWSAA.setText(currentRecord.getFeEndpointWsaa());
        jtDSTN.setText(currentRecord.getFeDstDn());

        jcPuertos.setSelectedItem(puerto);
        jcBaudios.setSelectedItem(currentRecord.getTrBaudios());

        jcMarca.setSelectedItem(currentRecord.getTrMarca());

        jCheckBox1.setSelected(currentRecord.getEstado());

        jtDescripcion.setText(currentRecord.getDes());

        StkDeposito dep = currentRecord.getStkDeposito();
        GsySuc suc = dep.getGsySuc();
        if (dep != null) {
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
        // No iporta la marca, si el id es null desactivo estos campos
        if (currentRecord.getTalId() == null) {
            jbPkBorrar.setEnabled(false);
        }
    }

    /**
     * Creates new form PanelTalonariosForm
     */
    public FormTalonariosForm() {

        initComponents();
        try {

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

            jcSucursal.removeAllItems();
            for (GsySuc s : controladorSucursal.getDtoList()) {
                jcSucursal.addItem(s);
            }

            UtilDeComponentes.setMaskCantidadDecimal(jFormattedTextField1, 0);
            UtilDeComponentes.setSelectText(jFormattedTextField1);
            UtilDeComponentes.setSelectText(jtDescripcion);

        } catch (SgException ex) {
            LOG.log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
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
        jLabel4 = new javax.swing.JLabel();
        jcMarca = new javax.swing.JComboBox();
        jcModelo = new javax.swing.JComboBox();
        jcPuertos = new javax.swing.JComboBox();
        jcBaudios = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jtWSAA = new javax.swing.JTextField();
        jbSHA = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jtWSFEV = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jtPK = new javax.swing.JTextField();
        jbPKCargar = new javax.swing.JButton();
        jbPkBorrar = new javax.swing.JButton();
        jbPKver = new javax.swing.JButton();
        jtCer = new javax.swing.JTextField();
        jbCerCargar = new javax.swing.JButton();
        jbCerBorrar = new javax.swing.JButton();
        jbCerVer = new javax.swing.JButton();
        jtDSTN = new javax.swing.JTextField();
        jbProbarConeccion = new javax.swing.JButton();
        jbTABorrar = new javax.swing.JButton();
        jbTAVer = new javax.swing.JButton();
        jbPagarProduccion = new javax.swing.JButton();
        jbPagarHomologacion = new javax.swing.JButton();
        jbSHAtest = new javax.swing.JButton();
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

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("EndPoint WSAA:");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(5, 110, 100, 20);

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

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/sigemp/client/png/p32x32/ayuda.png"))); // NOI18N
        jButton1.setToolTipText("Comprobantes que Soporta");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(225, 5, 40, 45);

        jLabel8.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel1.add(jLabel8);
        jLabel8.setBounds(370, 5, 110, 110);
        jPanel1.add(jtWSAA);
        jtWSAA.setBounds(115, 110, 290, 20);

        jbSHA.setText("SHA");
        jbSHA.setToolTipText("Pega Datos de Produccion");
        jbSHA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSHAActionPerformed(evt);
            }
        });
        jPanel1.add(jbSHA);
        jbSHA.setBounds(410, 110, 60, 20);

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setText("Baudios:");
        jPanel1.add(jLabel10);
        jLabel10.setBounds(5, 80, 100, 20);

        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel11.setText("EndPoint WSFEV1:");
        jPanel1.add(jLabel11);
        jLabel11.setBounds(5, 135, 100, 20);
        jPanel1.add(jtWSFEV);
        jtWSFEV.setBounds(115, 135, 360, 20);

        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel12.setText("Private Key:");
        jPanel1.add(jLabel12);
        jLabel12.setBounds(5, 160, 100, 20);

        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel13.setText("Certificado:");
        jPanel1.add(jLabel13);
        jLabel13.setBounds(5, 185, 100, 20);

        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel14.setText("DS TN");
        jPanel1.add(jLabel14);
        jLabel14.setBounds(5, 210, 100, 20);
        jPanel1.add(jtPK);
        jtPK.setBounds(115, 160, 70, 20);

        jbPKCargar.setText("Cargar");
        jbPKCargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbPKCargarActionPerformed(evt);
            }
        });
        jPanel1.add(jbPKCargar);
        jbPKCargar.setBounds(190, 160, 80, 23);

        jbPkBorrar.setText("Borrar");
        jbPkBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbPkBorrarActionPerformed(evt);
            }
        });
        jPanel1.add(jbPkBorrar);
        jbPkBorrar.setBounds(280, 160, 80, 23);

        jbPKver.setText("Ver");
        jbPKver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbPKverActionPerformed(evt);
            }
        });
        jPanel1.add(jbPKver);
        jbPKver.setBounds(370, 160, 80, 23);
        jPanel1.add(jtCer);
        jtCer.setBounds(115, 185, 70, 20);

        jbCerCargar.setText("Cargar");
        jbCerCargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCerCargarActionPerformed(evt);
            }
        });
        jPanel1.add(jbCerCargar);
        jbCerCargar.setBounds(190, 185, 80, 23);

        jbCerBorrar.setText("Borrar");
        jbCerBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCerBorrarActionPerformed(evt);
            }
        });
        jPanel1.add(jbCerBorrar);
        jbCerBorrar.setBounds(280, 185, 80, 23);

        jbCerVer.setText("Ver");
        jbCerVer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCerVerActionPerformed(evt);
            }
        });
        jPanel1.add(jbCerVer);
        jbCerVer.setBounds(370, 185, 80, 23);
        jPanel1.add(jtDSTN);
        jtDSTN.setBounds(115, 210, 330, 20);

        jbProbarConeccion.setText("Probar Coneccion");
        jbProbarConeccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbProbarConeccionActionPerformed(evt);
            }
        });
        jPanel1.add(jbProbarConeccion);
        jbProbarConeccion.setBounds(360, 240, 120, 23);

        jbTABorrar.setText("Borrar Ta");
        jbTABorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbTABorrarActionPerformed(evt);
            }
        });
        jPanel1.add(jbTABorrar);
        jbTABorrar.setBounds(230, 240, 120, 23);

        jbTAVer.setText("Ver TA");
        jbTAVer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbTAVerActionPerformed(evt);
            }
        });
        jPanel1.add(jbTAVer);
        jbTAVer.setBounds(120, 240, 100, 23);

        jbPagarProduccion.setText("P");
        jbPagarProduccion.setToolTipText("Pega Datos de Produccion");
        jbPagarProduccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbPagarProduccionActionPerformed(evt);
            }
        });
        jPanel1.add(jbPagarProduccion);
        jbPagarProduccion.setBounds(310, 80, 39, 23);

        jbPagarHomologacion.setText("H");
        jbPagarHomologacion.setToolTipText("Pega Datos de Homologacion");
        jbPagarHomologacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbPagarHomologacionActionPerformed(evt);
            }
        });
        jPanel1.add(jbPagarHomologacion);
        jbPagarHomologacion.setBounds(240, 80, 39, 23);

        jbSHAtest.setText("Test SHA-2");
        jbSHAtest.setToolTipText("Pega Datos de Produccion");
        jbSHAtest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSHAtestActionPerformed(evt);
            }
        });
        jPanel1.add(jbSHAtest);
        jbSHAtest.setBounds(10, 240, 100, 23);

        jb_guardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/sigemp/client/png/p20x20/ok.png"))); // NOI18N
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
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 496, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jb_guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jb_guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
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

    private void jbPKCargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbPKCargarActionPerformed
        cargarPrimaryKey();
    }//GEN-LAST:event_jbPKCargarActionPerformed

    private void jbCerCargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCerCargarActionPerformed
        cargarPrimaryCer();
    }//GEN-LAST:event_jbCerCargarActionPerformed

    private void jbPkBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbPkBorrarActionPerformed
        currentRecord.setFePrivatekey("");
    }//GEN-LAST:event_jbPkBorrarActionPerformed

    private void jbCerBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCerBorrarActionPerformed
        currentRecord.setFeCertificado("");
    }//GEN-LAST:event_jbCerBorrarActionPerformed

    private void jbPKverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbPKverActionPerformed
        JOptionPane.showMessageDialog(this, currentRecord.getFePrivatekey(), "Private Key", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_jbPKverActionPerformed

    private void jbCerVerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCerVerActionPerformed
        JOptionPane.showMessageDialog(this, currentRecord.getFeCertificado(), "Certificado", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_jbCerVerActionPerformed

    private void jbProbarConeccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbProbarConeccionActionPerformed
        try {
            AfipCheckDialog afip = new AfipCheckDialog(currentRecord.getTalId());
            afip.setVisible(true);
        } catch (SQLException ex) {
            LOG.log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jbProbarConeccionActionPerformed

    private void jbTABorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbTABorrarActionPerformed
        try {
            int xres = JOptionPane.showConfirmDialog(this, "Esta seguro de Borrar el Ticket de Acceso\n\r esto lo maneja el sistema acutomaticamente", "Cuidado", JOptionPane.YES_NO_OPTION);
            if (xres != JOptionPane.YES_OPTION) {
                return;
            }
            controladorTalonarios.borarTA(currentRecord.getTalId());
            recarcarDatos();
            JOptionPane.showMessageDialog(this, "Ya se Borro el TA del registro", "Ticket Acceso", JOptionPane.INFORMATION_MESSAGE);
        } catch (SgException ex) {
            LOG.log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jbTABorrarActionPerformed

    private void jbTAVerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbTAVerActionPerformed
        String ta = UtilXML.toPrettyString(currentRecord.getFeTa(), 10);
        JOptionPane.showMessageDialog(this, ta, "Ticket Acceso", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_jbTAVerActionPerformed

    private void jbPagarProduccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbPagarProduccionActionPerformed
        pegar(AFIP_END_POINTS.PRODUCCION_WSFEV1);
    }//GEN-LAST:event_jbPagarProduccionActionPerformed

    private void jbPagarHomologacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbPagarHomologacionActionPerformed
        pegar(AFIP_END_POINTS.HOMOLOGACION_WSFEV1);
    }//GEN-LAST:event_jbPagarHomologacionActionPerformed

    private void jbSHAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSHAActionPerformed
        String cadena = SSLCripto.testViewCertificateSite(jtWSAA.getText());
        JOptionPane.showMessageDialog(this, cadena);
    }//GEN-LAST:event_jbSHAActionPerformed

    private void jbSHAtestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSHAtestActionPerformed
        boolean isUnlimitedSupported = SSLCripto.isUnlimitedSupportes();
        JOptionPane.showMessageDialog(this, "isUnlimitedSupported=" + isUnlimitedSupported);
    }//GEN-LAST:event_jbSHAtestActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JFormattedTextField jFormattedTextField1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton jbCerBorrar;
    private javax.swing.JButton jbCerCargar;
    private javax.swing.JButton jbCerVer;
    private javax.swing.JButton jbPKCargar;
    private javax.swing.JButton jbPKver;
    private javax.swing.JButton jbPagarHomologacion;
    private javax.swing.JButton jbPagarProduccion;
    private javax.swing.JButton jbPkBorrar;
    private javax.swing.JButton jbProbarConeccion;
    private javax.swing.JButton jbSHA;
    private javax.swing.JButton jbSHAtest;
    private javax.swing.JButton jbTABorrar;
    private javax.swing.JButton jbTAVer;
    private javax.swing.JButton jb_guardar;
    private javax.swing.JComboBox jcBaudios;
    private javax.swing.JComboBox jcDeposito;
    private javax.swing.JComboBox jcMarca;
    private javax.swing.JComboBox jcModelo;
    private javax.swing.JComboBox jcPuertos;
    private javax.swing.JComboBox jcSucursal;
    private javax.swing.JTextField jtCer;
    private javax.swing.JTextField jtDSTN;
    private javax.swing.JTextField jtDescripcion;
    private javax.swing.JTextField jtPK;
    private javax.swing.JTextField jtWSAA;
    private javax.swing.JTextField jtWSFEV;
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
                jcModelo.setSelectedItem(currentRecord.getTrModelo());
            }
            if (null != marca) {
                switch (marca) {
                    case AFIP:
                        jcPuertos.setEnabled(false);
                        jcBaudios.setEnabled(false);
                        jtWSAA.setEnabled(true);
                        jtWSFEV.setEnabled(true);
                        jtPK.setEnabled(true);
                        jtCer.setEnabled(true);
                        jtDSTN.setEnabled(true);
                        jbCerCargar.setEnabled(true);
                        jbPKver.setEnabled(true);
                        jbPKCargar.setEnabled(true);
                        jbPkBorrar.setEnabled(true);
                        jbCerBorrar.setEnabled(true);
                        jbProbarConeccion.setEnabled(true);
                        jbTABorrar.setEnabled(true);
                        jbCerVer.setEnabled(true);
                        jbPagarHomologacion.setEnabled(true);
                        jbPagarProduccion.setEnabled(true);
                        jbSHA.setEnabled(true);
                        jbSHAtest.setEnabled(true);
                        jbTAVer.setEnabled(true);
                        break;
                    case EPSON:
                    case HASAR:
                        jcPuertos.setEnabled(true);
                        jcBaudios.setEnabled(true);
                        jtWSAA.setEnabled(false);
                        jtWSFEV.setEnabled(false);
                        jtPK.setEnabled(false);
                        jtCer.setEnabled(false);
                        jtDSTN.setEnabled(false);
                        jbCerCargar.setEnabled(false);
                        jbPKver.setEnabled(false);
                        jbPKCargar.setEnabled(false);
                        jbPkBorrar.setEnabled(false);
                        jbCerBorrar.setEnabled(false);
                        jbProbarConeccion.setEnabled(false);
                        jbTABorrar.setEnabled(false);
                        jbCerVer.setEnabled(false);
                        jbPagarHomologacion.setEnabled(false);
                        jbPagarProduccion.setEnabled(false);
                        jbSHA.setEnabled(false);
                        jbSHAtest.setEnabled(false);
                        jbTAVer.setEnabled(false);

                        break;
                    case MANUAL:
                        jcPuertos.setEnabled(false);
                        jcBaudios.setEnabled(false);
                        jtWSAA.setEnabled(false);
                        jtWSFEV.setEnabled(false);
                        jtPK.setEnabled(false);
                        jtCer.setEnabled(false);
                        jtDSTN.setEnabled(false);
                        jbCerCargar.setEnabled(false);
                        jbPKver.setEnabled(false);
                        jbPKCargar.setEnabled(false);
                        jbPkBorrar.setEnabled(false);
                        jbCerBorrar.setEnabled(false);
                        jbProbarConeccion.setEnabled(false);
                        jbTABorrar.setEnabled(false);
                        jbCerVer.setEnabled(false);
                        jbPagarHomologacion.setEnabled(false);
                        jbPagarProduccion.setEnabled(false);
                        jbSHA.setEnabled(false);
                        jbSHAtest.setEnabled(false);
                        jbTAVer.setEnabled(false);
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
        for (StkDeposito s : controladorDepositos.getListDtoBySuc(suc.getSucId())) {
            jcDeposito.addItem(s);
        }
    }

    private void cargarPrimaryKey() {
        JFileChooser fileChooser = new JFileChooser();
        // que acceda al ultimo directorio habierto
        String ultimoPath = ParametrosGeneral.getUltimoPath();
        fileChooser.setCurrentDirectory(new File(ultimoPath + "/."));
        int seleccion = fileChooser.showOpenDialog(this);
        /*si apriete abrir entra al if*/
        if (seleccion != JFileChooser.APPROVE_OPTION) {
            return;
        }
        File file = fileChooser.getSelectedFile();
        int opt = JOptionPane.showConfirmDialog(this, "Quiere abrir este archivo ? : "
                + file.getName(), "Importacion de Llave Privada", JOptionPane.YES_NO_OPTION);
        if (opt != JOptionPane.YES_OPTION) {
            return;
        }
        ParametrosGeneral.setUltimoPath(file.getPath());
        String str = "";
        try {
            str = Util.getStringFormFile(file);
        } catch (IOException ex) {
            LOG.log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Error:\n\r" + ex.getMessage());
        }
        currentRecord.setFePrivatekey(str);
    }

    private void cargarPrimaryCer() {
        JFileChooser fileChooser = new JFileChooser();
        // que acceda al ultimo directorio habierto
        String ultimoPath = ParametrosGeneral.getUltimoPath();
        fileChooser.setCurrentDirectory(new File(ultimoPath + "/."));
        int seleccion = fileChooser.showOpenDialog(this);
        /*si apriete abrir entra al if*/
        if (seleccion != JFileChooser.APPROVE_OPTION) {
            return;
        }
        File file = fileChooser.getSelectedFile();
        int opt = JOptionPane.showConfirmDialog(this, "Quiere abrir este archivo ? : "
                + file.getName(), "Importacion de Certificado", JOptionPane.YES_NO_OPTION);
        if (opt != JOptionPane.YES_OPTION) {
            return;
        }
        ParametrosGeneral.setUltimoPath(file.getPath());
        String str = "";
        try {
            str = Util.getStringFormFile(file);
        } catch (IOException ex) {
            LOG.log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Error:\n\r" + ex.getMessage());
        }
        currentRecord.setFeCertificado(str);
    }

    private void commandAccept() {
        try {
            if (jcDeposito.getSelectedItem() == null) {
                JOptionPane.showMessageDialog(this, "Debe elejir un deposito!!");
                return;
            }

            currentRecord.setTrPuerto((Puertos) jcPuertos.getSelectedItem());

            StkDeposito dep = (StkDeposito) jcDeposito.getSelectedItem();
            currentRecord.setStkDeposito(dep);

            currentRecord.setDes(jtDescripcion.getText());
            currentRecord.setEstado(jCheckBox1.isSelected());

            currentRecord.setTrMarca((Marcas) jcMarca.getSelectedItem());
            currentRecord.setTrModelo((Modelos) jcModelo.getSelectedItem());

            currentRecord.setTrBaudios((Baudios) jcBaudios.getSelectedItem());

            if (currentRecord.getTalId() != null) {
                currentRecord.setTalId(GestionUtil.getInteger(jFormattedTextField1));
            }

            currentRecord.setFeEndpointWsfe(jtWSFEV.getText());
            currentRecord.setFeEndpointWsaa(jtWSAA.getText());
            currentRecord.setFeDstDn(jtDSTN.getText());

            guardarDatos();
        } catch (SgException ex) {
            LOG.log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private static final Logger LOG = Logger.getLogger(FormTalonariosForm.class.getName());

    private void pegar(AFIP_END_POINTS wsaaEndPoints) {
        jtWSAA.setText(wsaaEndPoints.getEndpointWSAA());
        jtWSFEV.setText(wsaaEndPoints.getEnpoint());
        jtDSTN.setText(wsaaEndPoints.getDstdn());
    }

    private void guardarDatos() throws SgException {
        GsyTalonario tal = controladorTalonarios.editDto(currentRecord);
        if (tal != null) {
            setCurrentRecord(tal);
            Toast.show("Datos del Talonario Guardado");
        }
    }

    private void recarcarDatos() {
        GsyTalonario tal = controladorTalonarios.findDtoById(currentRecord.getTalId());
        setCurrentRecord(tal);
    }

}
