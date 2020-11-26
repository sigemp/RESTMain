/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigemp.gestion.client.api.interfaces;

/**
 *
 * @author Server
 */
public class Constantes {

    public enum COOKIE {
        SISTEMA_GESTION,
        USER_NAME;

    }

    public enum SISTEMA {
        VENTA("VENTAS", 1),
        COBRANZA("COBRANZA", 2),
        CAJA("CAJA", 3),
        STOCK("STOCK", 4),
        PROVEEDORES("PROVEEDORES", 5);

        private final String descripcion;
        private final int id;

        private SISTEMA(String descripcion, int id) {
            this.descripcion = descripcion;
            this.id = id;

        }

        /**
         * @return the descripcion
         */
        public String getDescripcion() {
            return descripcion;
        }

        /**
         * @return the id
         */
        public int getId() {
            return id;
        }

        /**
         * Busca la TiposContadores por id, si no se encuentra retorna null
         *
         * @param id
         * @return CondicionIva
         */
        public static SISTEMA getById(Integer id) {
            if (id == null) {
                return null;
            }
            for (SISTEMA x : SISTEMA.values()) {
                if (id.equals(x.getId())) {
                    return x;
                }
            }
            return null;
        }

        @Override
        public String toString() {
            return descripcion;
        }
    }

    public enum MENU_SISTEMAS {
        COMPROBANTES(SISTEMA.VENTA, "Comprobante", 1),
        TABLAS(SISTEMA.VENTA, "Tablas", 2),
        CONSULTAS(SISTEMA.VENTA, "Consultas", 3),
        LISTADOS(SISTEMA.VENTA, "Listados", 4),
        CONFIGURACION(SISTEMA.VENTA, "Configuracion", 5);

        private final String descripcion;
        private final int id;
        private final SISTEMA sistema;

        private MENU_SISTEMAS(SISTEMA sistema, String descripcion, int id) {
            this.sistema = sistema;
            this.descripcion = descripcion;
            this.id = id;

        }

        /**
         * @return the descripcion
         */
        public String getDescripcion() {
            return descripcion;
        }

        /**
         * @return the id
         */
        public int getId() {
            return id;
        }

        /**
         * Busca la TiposContadores por id, si no se encuentra retorna null
         *
         * @param id
         * @return CondicionIva
         */
        public static MENU_SISTEMAS getById(Integer id) {
            if (id == null) {
                return null;
            }
            for (MENU_SISTEMAS x : MENU_SISTEMAS.values()) {
                if (id.equals(x.getId())) {
                    return x;
                }
            }
            return null;
        }

        @Override
        public String toString() {
            return descripcion;
        }

        /**
         * @return the sistema
         */
        public SISTEMA getSistema() {
            return sistema;
        }
    }

}
