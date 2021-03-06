/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigemp.gestion.client.gui.component;

import java.util.ArrayList;

/**
 *
 * @author sigem
 */
public class PageableButton extends javax.swing.JPanel {

    private final PageableInterface pageableInterface;
    private long countRecord;
    private long currentFirtRecord;
    private long querySize;

    private final ArrayList<PageableListener> listenerList = new ArrayList<>();

    /**
     * Creates new form PageableButton
     *
     * @param pageableInterface
     */
    public PageableButton(PageableInterface pageableInterface) {
        this.pageableInterface = pageableInterface;
        initComponents();
        jb_anterior.setIcon(SgImage.ANTERIOR.getImage(SgImage.SIZES.S16));
        jb_siguiente.setIcon(SgImage.SIGUIENTE.getImage(SgImage.SIZES.S16));
    }

    public long getSizeQuery() {
        return Integer.valueOf((String) jComboBox1.getSelectedItem());
    }

    public PageableButton setCountRecord(long countRecord) {

        jLabel3.setText("" + countRecord);

        this.countRecord = countRecord;

        return this;

    }

    public long getCurrentFirstRecord() {
        return currentFirtRecord;
    }
    
    public PageableButton setCurrentFirstRecord(long currentFirtRecord) {
        this.currentFirtRecord = currentFirtRecord;
        return this;
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboBox1 = new javax.swing.JComboBox<>();
        jb_anterior = new javax.swing.JButton();
        jb_siguiente = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "10", "50", "100", "500", "1000" }));

        jb_anterior.setText("Previo");
        jb_anterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_anteriorActionPerformed(evt);
            }
        });

        jb_siguiente.setText("Proximo");
        jb_siguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_siguienteActionPerformed(evt);
            }
        });

        jLabel2.setText("Cantidad Registros:");

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("0");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jb_anterior)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jb_siguiente)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 18, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jb_anterior)
                    .addComponent(jb_siguiente)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jb_anteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_anteriorActionPerformed
        commandPrevius();
    }//GEN-LAST:event_jb_anteriorActionPerformed

    private void jb_siguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_siguienteActionPerformed
        commandNext();
    }//GEN-LAST:event_jb_siguienteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JButton jb_anterior;
    private javax.swing.JButton jb_siguiente;
    // End of variables declaration//GEN-END:variables

    private void commandPrevius() {
        long sizeQuery = getSizeQuery();
        long tmpCurrFirst = currentFirtRecord - sizeQuery;

        if (tmpCurrFirst <= 0) {
            currentFirtRecord = 0;
        } else if (tmpCurrFirst > 0) {
            currentFirtRecord = tmpCurrFirst;
        }
        firePressButton();

    }

    private void commandNext() {
        long sizeQuery = getSizeQuery();
        long tmpCurrFirst = currentFirtRecord + sizeQuery;
        // no hago nada
        if (tmpCurrFirst < countRecord) {
            currentFirtRecord = tmpCurrFirst;
        }
        firePressButton();
    }

    public void firePressButton() {
        listenerList.forEach(lis -> lis.onClick(currentFirtRecord, countRecord));
    }

    public void addPageableListener(PageableListener arg0) {
        listenerList.add(arg0);
    }

    public void removeCellEditorListener(PageableListener arg0) {
        listenerList.remove(arg0);
    }

}
