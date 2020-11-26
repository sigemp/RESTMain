/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigemp.gestion.client.gui.component.base;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

/**
 *
 * @author Server
 */
public abstract class SgDialog extends JDialog {

    public SgDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        addEscClose();
    }

    public SgDialog(JDialog parent, boolean modal) {
        super(parent, modal);
        addEscClose();
    }

    public void me(Exception ex) {
        JOptionPane.showMessageDialog(this, ex.getMessage());
    }

    public final void addEscClose() {
        ActionListener escListener = (ActionEvent e) -> {
            setVisible(false);
        };

        getRootPane().registerKeyboardAction(escListener,
                KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0),
                JComponent.WHEN_IN_FOCUSED_WINDOW);
    }
}
