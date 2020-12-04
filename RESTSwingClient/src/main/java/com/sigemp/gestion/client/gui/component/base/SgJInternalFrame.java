/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigemp.gestion.client.gui.component.base;

import com.sigemp.gestion.client.gui.component.SgImage;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author sigem
 */
public class SgJInternalFrame extends JInternalFrame {

    private SgImage sgImage = SgImage.PANTALLA_SIN_ICONO;

    public SgJInternalFrame() {
        super();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(true);
        setClosable(true);
        setFrameIcon(sgImage.getImage(SgImage.SIZES.S20));
    }

    public void me(Exception ex) {
        JOptionPane.showMessageDialog(this, ex.getMessage());
    }

    public void setIcon(SgImage sgImage) {
        setFrameIcon(sgImage.getImage(SgImage.SIZES.S20));
        this.sgImage = sgImage;
    }

    public SgImage getIcon() {
        return sgImage;
    }

    /**
     * Retorna el panel Principal se usa para abrir un Dialog
     *
     * @return
     */
    public JFrame getMainParent() {
        JFrame frame = (JFrame) getDesktopPane().getTopLevelAncestor();
        return frame;
    }

    /**
     * Es ejecutado despues de crear el Objeto
     *
     */
    public void init() {

    }

    public void postInit() {

    }
}
