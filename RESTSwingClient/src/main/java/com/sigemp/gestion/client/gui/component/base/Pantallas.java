/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigemp.gestion.client.gui.component.base;

import com.sigemp.gestion.client.gui.sis_config.VentanaPtoVenta;
import com.sigemp.gestion.client.gui.sis_general.WABMGsyProv;
import com.sigemp.gestion.constants.Sistema;


/**
 *
 * @author sigem
 */
public enum Pantallas {
    PROVINCIAS(WABMGsyProv.class, 1001, Sistema.GENERAL, PantallaGrupo.TABLAS, "ABM Provincias"),
    PROVINCIAS2(WABMGsyProv.class, 1002, Sistema.GENERAL, PantallaGrupo.TABLAS, "ABM Provincias2"),
    PROVINCIAS3(WABMGsyProv.class, 1003, Sistema.GENERAL, PantallaGrupo.CONSULTAS, "ABM Provincias3"),
    PUNTOS_DE_VENTA(VentanaPtoVenta.class, 1004, Sistema.GENERAL, PantallaGrupo.CONFIG, "ABM Puntos de Venta");
    
    private final String des;
    private final Class<?> pantalla;
    private final int screenId;
    private final Sistema sistema;
    private final PantallaGrupo grupo;

    Pantallas(Class<?> pantalla, int screenId, Sistema sistema, PantallaGrupo grupo, String des) {
        this.pantalla = pantalla;
        this.des = des;
        this.sistema = sistema;
        this.screenId = screenId;
        this.grupo = grupo;
    }

    public Class<?> getPantalla() {
        return pantalla;
    }

    public String getDescripcion() {
        return des;
    }

    public Sistema getSistema() {
        return sistema;
    }

    public PantallaGrupo getPantallaGrupo() {
        return grupo;
    }

    public enum PantallaGrupo {
        TABLAS("Tablas"),
        CONSULTAS("Consultas"),
        CONFIG("Config");
        private final String des;

        PantallaGrupo(String des) {
            this.des = des;
        }

        /**
         * @return the des
         */
        public String getDes() {
            return des;
        }

    }

}
