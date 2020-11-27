/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigemp.gestion.constants;

public enum VentasFlags {

    ANULADO("Anulado", "A"),
    SEGUNDA_VENTA("Vta. Seg. Vendedor", "s"),
    ANULADA_NC("Anulada p NC", "N"),
    NADA("Nada", "");

    private final String descripcion;
    private final String id;

    private VentasFlags(String des, String id) {
        this.descripcion = des;
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getId() {
        return id;
    }

    /**
     * Busca por medio de su id, si no encuentra retorna null
     *
     * @param id
     * @return VentasFlags
     */
    public static VentasFlags getById(String id) {
        if (id == null) {
            return null;
        }
        for (VentasFlags x : VentasFlags.values()) {
            if (id.equals(x.getId())) {
                return x;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return getDescripcion();
    }

}
