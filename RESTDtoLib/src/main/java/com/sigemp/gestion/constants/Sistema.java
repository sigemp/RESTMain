/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigemp.gestion.constants;

import java.util.Arrays;

public enum Sistema {
    GENERAL("General", 0),
    VENTA("Ventas", 1),
    COBRANZA("Cobranza", 2),
    CAJA("Caja", 3),
    STOCK("Movimiento Mercaderia", 4),
    PROVEEDORES("Proveedores", 5),
    STOCK_INVENTARIO("Proceso Inventario", 6),
    COBANZA_LOTE("Lote Cobranza", 7);

    private final String descripcion;
    private final int id;

    private Sistema(String descripcion, int id) {
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
    public static Sistema getById(Integer id) {
        if (id == null) {
            return null;
        }
        for (Sistema x : Sistema.values()) {
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

    public static String getNames() {
        StringBuilder sb = new StringBuilder();
        Arrays.stream(values()).forEach(e -> {
            sb.append(e.name()).append(",");
        });
        return sb.toString();
    }

}
