/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigemp.common;

import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;
import javax.swing.JComponent;
import javax.swing.JFormattedTextField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.JTextComponent;
import javax.swing.text.NumberFormatter;

/**
 *
 * @author cristian
 */
public class SwingUtils {

    private boolean throwErr;

    public long getLong(JTextField string) {
        long x = 0;
        if (throwErr) {
            x = Long.valueOf(string.getText());
        } else {
            try {
                x = Long.valueOf(string.getText());
            } catch (NumberFormatException e) {
            }
        }
        return x;
    }

    public SwingUtils throwError(boolean throwErr) {
        this.throwErr = throwErr;
        return this;
    }

    /**
     * Retorna un int de un JtextField
     *
     *
     * @param string
     * @return
     */
    public int getInt(JTextField string) {
        int x = 0;
        if (throwErr) {
            x = Integer.valueOf(string.getText());
        } else {
            try {
                x = Integer.valueOf(string.getText());
            } catch (NumberFormatException e) {
            }
        }
        return x;
    }
    
    public static Integer getInt(JFormattedTextField value) {
        try {
            value.commitEdit();
        } catch (ParseException ex) {
        }
        if (value.getValue() == null) {
            return null;
        }
        int val = ((Number) value.getValue()).intValue();
        return val;
    }

    
    /**
     * aca hago q' el campo se seleccione cuando agarro el foco
     *
     * @param jc
     */
    public static void setSelectText(JComponent jc) {
        if (jc instanceof JFormattedTextField) {
            final JFormattedTextField jftf = (JFormattedTextField) jc;
            jftf.addFocusListener(new FocusAdapter() {

                @Override
                public void focusGained(FocusEvent e) {
                    SwingUtilities.invokeLater(() -> {
                        jftf.selectAll();
                    });
                }
            });
        }
        if (jc instanceof JTextField) {
            JTextField jftf = (JTextField) jc;
            jftf.addFocusListener(new FocusAdapter() {

                @Override
                public void focusGained(FocusEvent e) {
                    if (e.getSource() instanceof JTextField) {
                        ((JTextComponent) e.getSource()).selectAll();
                    }
                }
            });
        }
        if (jc instanceof JDateChooser) {
            JDateChooser dateChooser = (JDateChooser) jc;
            dateChooser.getDateEditor().getUiComponent().addFocusListener(new FocusAdapter() {
                @Override
                public void focusGained(FocusEvent evt) {
                    if (evt.getSource() instanceof JTextComponent) {
                        final JTextComponent textComponent = ((JTextComponent) evt.getSource());
                        SwingUtilities.invokeLater(() -> {
                            textComponent.selectAll();
                        });
                    }
                }
            });
        }
    }
    
    
    /**
     * Enmascara el JFormattedTextField para que pueda ser facil la edicion de
     * cantidades con decimales
     *
     * @param jc
     * @param precision
     */
    public static void setMaskCantidadDecimal(JComponent jc, int precision) {
        setMaskCantidadDecimal(jc, precision, false, false);
    }

    public static void setMaskCantidadDecimal(JComponent jc, int precision, boolean selectd, boolean porcentaje) {
        if (selectd) {
            setSelectText(jc);
        }
        if (jc instanceof JFormattedTextField) {
            JFormattedTextField jftf = (JFormattedTextField) jc;
            // Formato de visualizacion
            NumberFormat dispFormat;

            if (porcentaje) {
                dispFormat = new DecimalFormat("'%' ###,##0.00");
                dispFormat.setMaximumFractionDigits(precision);
                dispFormat.setMinimumFractionDigits(precision);
            } else {
                dispFormat = NumberFormat.getInstance();
                dispFormat.setMaximumFractionDigits(precision);
                dispFormat.setMinimumFractionDigits(precision);
            }

            // Formato de edicion: ingl�s (separador decimal: el punto)
            NumberFormat editFormat = NumberFormat.getNumberInstance(Locale.ENGLISH);
            editFormat.setMaximumFractionDigits(precision);
            editFormat.setMinimumFractionDigits(precision);
            // Para la edicion, no queremos separadores de millares
            editFormat.setGroupingUsed(false);

            // Creamos los formateadores de n�meros
            NumberFormatter dnFormat = new NumberFormatter(dispFormat);
            NumberFormatter enFormat = new NumberFormatter(editFormat);
            // Creamos la factor�a de formateadores especificando los
            // formateadores por defecto, de visualizaci�n y de edici�n
            DefaultFormatterFactory currFactory = new DefaultFormatterFactory(dnFormat, dnFormat, enFormat);
            // El formateador de edici�n admite caracteres incorrectos
            enFormat.setAllowsInvalid(true);
            // Asignamos la factor�a al campo
            jftf.setFormatterFactory(currFactory);
            jftf.setForeground(Color.BLUE);
            jftf.setHorizontalAlignment(JFormattedTextField.RIGHT);
        }
    }

    public static void setMaskCantidadDecimal(JComponent jc, int precision, boolean selected) {
        setMaskCantidadDecimal(jc, precision, true, false);
    }

    /**
     * Enmascara el JFormattedTextField para que pueda ser facil la edicion de
     * precios, se pasa como parametro un JFormmatted textField
     *
     * @param jc
     * @param precision
     */
    public static void setMaskMoneda(JComponent jc, int precision) {
        if (jc instanceof JFormattedTextField) {

            JFormattedTextField jftf = (JFormattedTextField) jc;
            // Formato de visualizaci�n
            NumberFormat dispFormat = NumberFormat.getCurrencyInstance();
            dispFormat.setMaximumFractionDigits(precision);
            dispFormat.setMinimumFractionDigits(precision);

            // Formato de edici�n: ingl�s (separador decimal: el punto)
            NumberFormat editFormat = NumberFormat.getNumberInstance(Locale.ENGLISH);
            editFormat.setMaximumFractionDigits(precision);
            editFormat.setMinimumFractionDigits(precision);
            // Para la edici�n, no queremos separadores de millares
            editFormat.setGroupingUsed(false);

            // Creamos los formateadores de n�meros
            NumberFormatter dnFormat = new NumberFormatter(dispFormat);
            NumberFormatter enFormat = new NumberFormatter(editFormat);
            // Creamos la factor�a de formateadores especificando los
            // formateadores por defecto, de visualizaci�n y de edici�n
            DefaultFormatterFactory currFactory = new DefaultFormatterFactory(dnFormat, dnFormat, enFormat);
            // El formateador de edici�n admite caracteres incorrectos
            enFormat.setAllowsInvalid(true);
            // Asignamos la factor�a al campo
            jftf.setFormatterFactory(currFactory);
            jftf.setForeground(Color.RED);
            jftf.setFont(jftf.getFont().deriveFont(Font.BOLD));
            jftf.setHorizontalAlignment(JFormattedTextField.RIGHT);
        }
    }

    public static void setMaskMoneda(JComponent jc, int precision, boolean seleccion) {
        setMaskMoneda(jc, precision);
        setSelectText(jc);
    }

    /**
     * Enmascara el JFormattedTextField para que pueda ser facil la edicion de
     * cantidades con decimales
     *
     * @param jc
     * @param precision
     */
    public static void setMaskPorcentaje(JComponent jc, int precision) {
        if (jc instanceof JFormattedTextField) {
            JFormattedTextField jftf = (JFormattedTextField) jc;
            // Formato de visualizacion
            NumberFormat dispFormat = NumberFormat.getPercentInstance();
            dispFormat.setMaximumFractionDigits(precision);
            dispFormat.setMinimumFractionDigits(precision);

            // Formato de edicion: ingl�s (separador decimal: el punto)
            NumberFormat editFormat = NumberFormat.getPercentInstance(Locale.ROOT);
            editFormat.setMaximumFractionDigits(precision);
            editFormat.setMinimumFractionDigits(precision);
            // Para la edicion, no queremos separadores de millares
            editFormat.setGroupingUsed(false);

            // Creamos los formateadores de n�meros
            NumberFormatter dnFormat = new NumberFormatter(dispFormat);
            NumberFormatter enFormat = new NumberFormatter(editFormat);
            // Creamos la factor�a de formateadores especificando los
            // formateadores por defecto, de visualizaci�n y de edici�n
            DefaultFormatterFactory currFactory = new DefaultFormatterFactory(dnFormat, dnFormat, enFormat);
            // El formateador de edici�n admite caracteres incorrectos
            enFormat.setAllowsInvalid(true);
            // Asignamos la factor�a al campo
            jftf.setFormatterFactory(currFactory);
            jftf.setForeground(Color.BLUE);
            jftf.setHorizontalAlignment(JFormattedTextField.RIGHT);
        }
    }
}
