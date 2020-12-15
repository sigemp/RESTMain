/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigemp.common;

import com.sigemp.gestion.client.gui.component.base.Pantallas;
import com.sigemp.gestion.client.gui.component.base.SgJInternalFrame;
import com.sigemp.gestion.client.inicio.MainIntro;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDesktopPane;

/**
 * Utilitario para gestion del sistema
 * @author sigem
 */
public class FW {

    /**
     * Inicia las pantallas en la aplicacion
     * 
     * @param dp
     * @param p 
     */
    public static void start(JDesktopPane dp, Pantallas p) {
        try {

            Object o = p.getPantalla().newInstance();
            if (o != null && o instanceof SgJInternalFrame) {
                SgJInternalFrame sj = (SgJInternalFrame) o;
                sj.setTitle(p.getDescripcion());
                sj.init();
                dp.add(sj);
                sj.setVisible(true);
                sj.postInit();
            }

        } catch (InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(MainIntro.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
