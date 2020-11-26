/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigemp.gestion.client.gui.sis_config.form;

import com.sigemp.gestion.client.gui.component.SgImage;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.DefaultListCellRenderer;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JList;

/**
 *
 * @author Server
 */
public class ListadosRender extends DefaultListCellRenderer {

    private final Icon iconoContadoresTip = SgImage.REGISTROS_EDITAR.getImage(SgImage.SIZES.S16);
    
    //private final Icon iconoContadoresTip = IconFactory.getIcon(IconFactory.ICONO_TIPO_COMPROBANTE, IconFactory.Tamano.P16);
    Color defaultBackgroundColor;
    Font defaultFont;

    public ListadosRender() {
        defaultBackgroundColor = getBackground();
        defaultFont = getFont();
    }

    @Override
    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {

        setIcon(iconoContadoresTip);
        setText("" + value);
        if (isSelected) {
            setFont(new Font("Verdana", Font.BOLD, 12));
            setBackground(Color.CYAN);
        } else {
            setFont(defaultFont);
            setBackground(defaultBackgroundColor);
        }

        return this;
    }
}
