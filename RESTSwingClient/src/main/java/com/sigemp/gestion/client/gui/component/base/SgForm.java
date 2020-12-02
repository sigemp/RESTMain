/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigemp.gestion.client.gui.component.base;

import javax.swing.JOptionPane;

/**
 *
 * @author sigem
 */
public class SgForm extends javax.swing.JPanel {

    public void me(Exception ex) {
        JOptionPane.showMessageDialog(this, ex.getMessage());
    }

    public void me(String str, Exception ex) {
        JOptionPane.showMessageDialog(this, str + "\n" + ex.getMessage());
    }
}
