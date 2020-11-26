/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigemp.gestion.server.constantes;

public enum EstadoCivil {

    SOLTERO("SOLTERO/A", 49),
    CASADO("CASADO", 50),
    VIUDO("VIUDO", 51),
    SEPARADO_LEGAL("SEPARADO LEGAL", 52),
    SEPERADO_DE_ECHO("SEPARADO DE ECHO", 53),
    DIVORCIADO("DIVORCIADO", 54),
    CONVIVIENTE("CONVIVIENTE", 55);

    private final String descripcion;
    private final int id;

    private EstadoCivil(String des, int id) {
        this.descripcion = des;
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getId() {
        return id;
    }

    /**
     * Busca UnidadMedidas por ID, si no existe retora null
     *
     * @param id
     * @return UnidadMedidas
     */
    public static EstadoCivil getById(Integer id) {
        if (id == null) {
            return null;
        }
        for (EstadoCivil x : EstadoCivil.values()) {
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
