/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigemp.constants;

/**
 *
 * @author sigem
 */
public enum ComportamientoEmisionComprobante {

    NO_HACER_NADA("No Hacer Nada", 1),
    IMPRIMIR("Imprimir Comprobante", 2),
    VISTA_PREVIA("Mostrar Vista Previa", 3),
    PERMITIR_SELECCIONAR_IMPRESORA("Permitir seleccionar impresora de salida", 4);

    private final String desdescripcion;
    private final Integer id;

    private ComportamientoEmisionComprobante(String descripcion, Integer id) {
        this.desdescripcion = descripcion;
        this.id = id;

    }

    /**
     * @return the desdescripcion
     */
    public String getDescripcion() {
        return desdescripcion;
    }

    /**
     * @return the civaId
     */
    public Integer getId() {
        return id;
    }

    /**
     * Busca la ComportamientoEmisionComprobante por id, si no se encuentra
     * retorna null
     *
     * @param id
     * @return CondicionIva
     */
    public static ComportamientoEmisionComprobante getById(Integer id) {
        if (id == null) {
            return null;
        }
        for (ComportamientoEmisionComprobante x : ComportamientoEmisionComprobante.values()) {
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
