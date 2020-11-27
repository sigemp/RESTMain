/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigemp.gestion.constants;

public enum CondicionIva {

    RESPONSABLE_INSCRIPTO("Responsable Inscripto", 1, true),
    RESPONSABLE_NO_INSCRIPTO("No Responsable Incripto", 2, true),
    NO_RESPONSABLE("No Responsable", 3, false),
    SUJETO_EXENTO("Exento", 4, true),
    CONSUMIDOR_FINAL("Consumidor Final", 5, true),
    RESPONSABLE_MONOTRIBUTO("Monotributo", 6, true),
    SUJETO_NO_CATEGORIZADO("No Categorizado", 7, true),
    PROVEEDOR_DEL_EXTERIOR("Proveedor del Exterior", 8, false),
    CLIENTE_DEL_EXTERIOR("Cliente del Exterior", 9, false),
    IVA_LIBERADO("Iva Liberado", 10, false),
    RESPONSABLE_INSCRIPTO_AGENTE_PERCEPCION("Iva Responsable Incripto Agente Percepcion", 11, false),
    CONSTRIBUYENTE_EVENTUAL("Constribuyente Eventual", 12, false),
    MONOTRIBUTISTA_SOCIAL("Monotributo Social", 13, true),
    CONTRIBUYENTE_EVENTUAL_SOCIAL("Contribuyente Eventual Social", 14, false);

    private final String desdescripcion;
    private final Integer id;
    private final boolean habilitado;
    public static final long DOCUMENTO_SUJETO_NO_CATEGORIZADO = 23000000000L;

    private CondicionIva(String descripcion, Integer id, boolean habilitado) {
        this.desdescripcion = descripcion;
        this.id = id;
        this.habilitado = habilitado;

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
     * Busca la CondicionIva por id, si no se encuentra retorna null
     *
     * @param id
     * @return CondicionIva
     */
    public static CondicionIva getById(Integer id) {
        if (id == null) {
            return null;
        }
        for (CondicionIva x : CondicionIva.values()) {
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

    /**
     * @return the habilitado
     */
    public boolean isHabilitado() {
        return habilitado;
    }
}
