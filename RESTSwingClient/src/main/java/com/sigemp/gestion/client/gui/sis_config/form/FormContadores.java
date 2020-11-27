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
import com.sigemp.gestion.client.gui.component.base.Toast;
import com.sigemp.common.SwingUtils;
import com.sigemp.common.exception.SgException;
import com.sigemp.gestion.constants.Comprobante;
import com.sigemp.gestion.client.online.wrapper.WrapperContador;
import com.sigemp.gestion.client.services.ServiceFactory;
import com.sigemp.gestion.client.services.ventanaPtoVenta.PtoVtaService;
import com.sigemp.gestion.constants.ComportamientoEmisionComprobante;
import com.sigemp.gestion.constants.Sistema;
import com.sigemp.gestion.constants.TipoSalida;
import com.sigemp.gestion.shared.dto.ventanaPtoVenta.FormatoComprobanteDto;
import com.sigemp.gestion.shared.entity.GsyContadores;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

/**
 *
 * @author CRISTIANE
 */
public class FormContadores extends javax.swing.JPanel {

    private final DefaultListModel<Comprobante> model;
    //private final GsyContadoresTipoService controladorContadorTipo = ServiceFactory.getGsyContadoresTipo();
    //private final GsyContadoresService controladorService = ServiceFactory.getGsyContador();
    private final PtoVtaService ptovtaService = ServiceFactory.getPtoVtaService();

    protected GsyContadores currentRecord;
    private DefaultMutableTreeNode dmtn;
    private DefaultTreeModel modelo;
    private WrapperContador wcurrentRecord;

    /**
     * Get the value of currentRecord
     *
     * @return the value of currentRecord
     */
    public GsyContadores getFromForm() {
        GsyContadores contador = new GsyContadores();
        contador.setConId(SwingUtils.getInt(jFormattedTextField1));
        contador.setEstado(jCheckBox1.isSelected());
        contador.setDes(jTextField2.getText());
        contador.setNroactual(SwingUtils.getInt(jFormattedTextField2));
        contador.setCantidadCopias(SwingUtils.getInt(jfCopias));
        contador.setImpresoraDirecta(jtf_pathImpresora.getText());
        contador.setAutoIncrementa(jCheckBox2.isSelected());
        contador.setPermiteCambioFecha(jCheckBox4.isSelected());
        contador.setTalId(currentRecord.getTalId());

        return contador;
    }

    /**
     * debe venir en nullo talId para que permita ingresar un codigo de
     * talonario
     *
     * @param currentRecord new value of currentRecord
     */
    public void setCurrentRecord(GsyContadores currentRecord) {
        this.currentRecord = currentRecord;
        this.wcurrentRecord = WrapperContador.instance(currentRecord);

        if (currentRecord.getConId() != null) {
            jFormattedTextField1.setValue(currentRecord.getConId());
        } else {
            jFormattedTextField1.setValue(0);
        }

        jCheckBox1.setSelected(currentRecord.getEstado());
        jTextField2.setText(currentRecord.getDes());
        jFormattedTextField2.setValue(currentRecord.getNroactual());
        jfCopias.setValue(currentRecord.getCantidadCopias());
        jtf_pathImpresora.setText(currentRecord.getImpresoraDirecta());
        jCheckBox2.setSelected(currentRecord.getAutoIncrementa());
        jCheckBox4.setSelected(currentRecord.getPermiteCambioFecha());

        Sistema tipoContador = wcurrentRecord.getTrTipoContador();
        if (tipoContador != null) {
            jcb_tiposContador.setSelectedItem(tipoContador);
        } else {
            jcb_tiposContador.setSelectedIndex(0);
        }

        FormatoComprobanteDto formatoImpresionId = wcurrentRecord.getTrFormatoImpresion();
        FormatoComprobanteDto formatoVistaPreviaId = wcurrentRecord.getTrFormatoVistaPrevia();

        if (formatoImpresionId != null) {
            jcb_FormatoImpresion.setSelectedItem(formatoImpresionId);
        } else {
            jcb_FormatoImpresion.setSelectedIndex(0);
        }

        if (formatoVistaPreviaId != null) {
            jcb_FormatoVistaPrevia.setSelectedItem(formatoVistaPreviaId);
        } else {
            jcb_FormatoVistaPrevia.setSelectedIndex(0);
        }

        ComportamientoEmisionComprobante coomp = wcurrentRecord.getTrCompEmisionComprobante();

        if (coomp != null) {
            jcb_ComportamientoEmisionComprobante.setSelectedItem(coomp);
        } else {
            jcb_ComportamientoEmisionComprobante.setSelectedIndex(0);
        }

        
        List<Integer> listComprobantes = ptovtaService.getComprobantesByContador(currentRecord.getTipoContador());
        
        // Agrego los comprobantes que estan asignados a este contador
        model.removeAllElements();
        for (Integer tc : listComprobantes) {
            Comprobante.getById(tc);
            model.addElement(Comprobante.getById(tc));
        }

        actualizarEstadoCheckBox();

    }

    /**
     * Creates new form PanelTalonariosForm
     */
    public FormContadores() {
        initComponents();
        SwingUtils.setMaskCantidadDecimal(jFormattedTextField1, 0);
        SwingUtils.setSelectText(jFormattedTextField1);
        SwingUtils.setSelectText(jTextField2);

        ActionListener actualzaListener = (ActionEvent actionEvent) -> {
            actualizarEstadoCheckBox();
        };

        jcb_FormatoImpresion.addActionListener(actualzaListener);

        jcb_ComportamientoEmisionComprobante.removeAllItems();
        for (ComportamientoEmisionComprobante o : ComportamientoEmisionComprobante.values()) {
            jcb_ComportamientoEmisionComprobante.addItem(o);
        }

        jcb_tiposContador.removeAllItems();
        for (Sistema o : Sistema.values()) {
            jcb_tiposContador.addItem(o);
        }

        jcb_tiposContador.addActionListener((ActionEvent e) -> {
            cargarFormatosEnComboBox();
        });

        model = new DefaultListModel<>();
        jList1.setModel(model);
        jList1.setCellRenderer(new ListadosRender());

        //cargarFormatosEnComboBox();
    }

    private void agregarTipoComprobante() {

        List<Comprobante> listTcIngresados = getListTiposComprobantes();

        DialogSeleccionComprobantes diag = new DialogSeleccionComprobantes(null, true);

        Sistema tiposContadores = (Sistema) jcb_tiposContador.getSelectedItem();

        diag.setTCTC(tiposContadores, listTcIngresados);
        diag.setVisible(true);
        if (diag.isConfirmed()) {
            List<Comprobante> lisResultado = diag.getCurrentRecord();
            for (Comprobante comp : lisResultado) {
                if (!contieneComprobante(comp)) {
                    model.addElement(comp);
                }
            }
        }
    }

    public boolean contieneComprobante(Comprobante c) {
        for (int x = 0; x < model.getSize(); x++) {
            if (model.get(x).equals(c)) {
                return true;
            }
        }
        return false;
    }

    private void cargarFormatosEnComboBox() {
        Sistema sistema = (Sistema) jcb_tiposContador.getSelectedItem();

        /// Consultar Formatos disponibles para el Sistem (Tipo Comprobante)
//        List<FormatoComprobanteDto> list = AbstractComprobante.getListaFormatosComprobantes(sistema);
//        
//        jcb_FormatoVistaPrevia.removeAllItems();
//        for (FormatoComprobanteDto o : list) {
//            if (o.getTipoSalida() == TipoSalida.GRAFICA) {
//                jcb_FormatoVistaPrevia.addItem(o);
//            }
//        }
//
//        jcb_FormatoImpresion.removeAllItems();
//        for (AbstractComprobante o : list) {
//            jcb_FormatoImpresion.addItem(o);
//        }
    }

    private void chequearDatosIngresados() throws SgException {
        FormatoComprobanteDto formatoImpresion = (FormatoComprobanteDto) jcb_FormatoImpresion.getSelectedItem();
        FormatoComprobanteDto formatoVistaPrevia = (FormatoComprobanteDto) jcb_FormatoVistaPrevia.getSelectedItem();

        List<Comprobante> listComprobaantes = getListTiposComprobantes();

        List<Comprobante> listNoSoportados = new ArrayList<>();

//        for (Comprobante tcIngresados : listComprobaantes) {
//            if (!formatoImpresion.comprobanteEstaSoportado(tcIngresados)) {
//                listNoSoportados.add(tcIngresados);
//            }
//        }
        if (listNoSoportados.size() > 0) {
            String msg = "El/Los Tipos de comprobantes ";

            for (Comprobante tc : listNoSoportados) {
                msg += tc.getDescripcion() + "\n";
            }
            msg += " No estan Soportados por el formato de Impresion";
            throw new SgException(msg);
        }

//        for (Comprobante tcIngresados : listComprobaantes) {
//            if (!formatoVistaPrevia.comprobanteEstaSoportado(tcIngresados)) {
//                listNoSoportados.add(tcIngresados);
//            }
//        }
        if (listNoSoportados.size() > 0) {
            String msg = "El/Los Tipos de comprobantes ";

            for (Comprobante tc : listNoSoportados) {
                msg += tc.getDescripcion() + "\n";
            }
            msg += " No estan Soportados por el formato de Vista Previa";
            throw new SgException(msg);
        }

    }

    private List<Comprobante> getListTiposComprobantes() {
        List<Comprobante> listTcIngresados = new ArrayList<>();

        for (int x = 0; x < model.size(); x++) {
            listTcIngresados.add(model.getElementAt(x));
        }
        return listTcIngresados;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        bgPreguntaImpresora = new javax.swing.ButtonGroup();
        jPanel2 = new javax.swing.JPanel();
        jFormattedTextField1 = new javax.swing.JFormattedTextField();
        jLabel2 = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jTextField2 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jcb_tiposContador = new javax.swing.JComboBox<>();
        jbAceptar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jcb_FormatoImpresion = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jcb_FormatoVistaPrevia = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jtf_pathImpresora = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jfCopias = new javax.swing.JFormattedTextField();
        jLabel9 = new javax.swing.JLabel();
        jcb_ComportamientoEmisionComprobante = new javax.swing.JComboBox<>();
        jCheckBox4 = new javax.swing.JCheckBox();
        jPanel4 = new javax.swing.JPanel();
        jCheckBox2 = new javax.swing.JCheckBox();
        jFormattedTextField2 = new javax.swing.JFormattedTextField();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        jPanel2.setBackground(new java.awt.Color(0, 204, 255));

        jFormattedTextField1.setEnabled(false);

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("ID:");

        jCheckBox1.setText("Activo");
        jCheckBox1.setPreferredSize(new java.awt.Dimension(55, 20));

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Descripcion:");

        jLabel8.setText("Tipo de Contador :");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(jFormattedTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jCheckBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jTextField2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jcb_tiposContador, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jFormattedTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcb_tiposContador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jbAceptar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/sigemp/client/png/p20x20/guardar.png"))); // NOI18N
        jbAceptar.setText("Guardar");
        jbAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAceptarActionPerformed(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(255, 255, 204));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Formato Impresion :");

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Formato Vista Previa :");

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Direccion Impresora Red:");

        jtf_pathImpresora.setEnabled(false);

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Copias:");

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("Al Generar Comprobante:");

        jCheckBox4.setText("Permite Cambiar Fecha");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                                .addGap(10, 10, 10)))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jcb_FormatoVistaPrevia, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jcb_FormatoImpresion, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jtf_pathImpresora, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jfCopias, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jCheckBox4, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jcb_ComportamientoEmisionComprobante, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcb_FormatoImpresion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcb_FormatoVistaPrevia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtf_pathImpresora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcb_ComportamientoEmisionComprobante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jfCopias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBox4))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 204));

        jCheckBox2.setText("Autoincremente Numeracion");

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Numero Actual:");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jFormattedTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(104, 104, 104)
                .addComponent(jCheckBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jFormattedTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBox2))
                .addContainerGap())
        );

        jScrollPane1.setViewportView(jList1);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/sigemp/client/png/p20x20/agregar.png"))); // NOI18N
        jButton1.setText("Agregar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/sigemp/client/png/p20x20/eliminar-item.png"))); // NOI18N
        jButton2.setText("Quitar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jbAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jbAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton2)))))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jbAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAceptarActionPerformed
        guardarDatos();
    }//GEN-LAST:event_jbAceptarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        agregarTipoComprobante();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        quitarTipoDeComprobante();
    }//GEN-LAST:event_jButton2ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup bgPreguntaImpresora;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox4;
    private javax.swing.JFormattedTextField jFormattedTextField1;
    private javax.swing.JFormattedTextField jFormattedTextField2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JList<Comprobante> jList1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JButton jbAceptar;
    private javax.swing.JComboBox<ComportamientoEmisionComprobante> jcb_ComportamientoEmisionComprobante;
    private javax.swing.JComboBox<FormatoComprobanteDto> jcb_FormatoImpresion;
    private javax.swing.JComboBox<FormatoComprobanteDto> jcb_FormatoVistaPrevia;
    private javax.swing.JComboBox<Sistema> jcb_tiposContador;
    private javax.swing.JFormattedTextField jfCopias;
    private javax.swing.JTextField jtf_pathImpresora;
    // End of variables declaration//GEN-END:variables

    public void setNode(DefaultMutableTreeNode dmtn, DefaultTreeModel modelo) {
        this.dmtn = dmtn;
        this.modelo = modelo;
    }

    private void actualizarEstadoCheckBox() {
        FormatoComprobanteDto formato = (FormatoComprobanteDto) jcb_FormatoImpresion.getSelectedItem();
        if (formato == null
                || formato.getTipoSalida() == TipoSalida.GRAFICA.getId()) {
            jtf_pathImpresora.setEnabled(false);
        } else {
            jtf_pathImpresora.setEnabled(true);
        }
    }

    private static final Logger LOG = Logger.getLogger(FormContadores.class.getName());

    private void guardarDatos() {

        try {

            GsyContadores tmpContador = getFromForm();

            chequearDatosIngresados();

            Boolean agrego = false;
            if (tmpContador.getConId() == null || tmpContador.getConId() == 0) {
                tmpContador.setConId(null);
                agrego = true;
            }

            List<Comprobante> listTC = new ArrayList<>();

            for (int x = 0; x < model.size(); x++) {
                listTC.add(model.get(x));
            }

//            GsyContadores con = controladorService.guardarDto(tmpContador, listTC);
//
//            if (con != null) {
//                setCurrentRecord(con);
//                if (agrego) {
//                    DefaultMutableTreeNode hijo = new DefaultMutableTreeNode(con);
//                    modelo.insertNodeInto(hijo, dmtn, 0);
//                }
//            }
            Toast.show("Datos del Contador Guardado");
        } catch (SgException ex) {
            LOG.log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void quitarTipoDeComprobante() {
        int x = jList1.getSelectedIndex();
        if (x < 0) {
            JOptionPane.showMessageDialog(this, "Seleccione el Tipo de Comprobante a Quitar");
            return;
        }
        model.removeElementAt(x);
    }
}
