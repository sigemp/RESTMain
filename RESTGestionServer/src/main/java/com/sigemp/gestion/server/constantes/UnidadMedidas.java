/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigemp.gestion.server.constantes;

public enum UnidadMedidas {

    UNIDADES("UNIDADES", 1),
    MILIGRAMOS("MILIGRAMOS", 2),
    GRAMOS("GRAMOS", 3),
    KILOGRAMOS("KILOGRAMOS", 4),
    MILILITRO("MILILITRO", 5),
    LITRO("LITRO", 6),
    KILOLITRO("KILOLITRO", 7),
    MILIMETRO("MILIMETRO", 8),
    METRO("METRO", 9),
    KILOMETRO("KILOMETRO", 10);

    private final String descripcion;
    private final int id;

    private UnidadMedidas(String des, int id) {
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
    public static UnidadMedidas getById(Integer id) {
        if (id == null) {
            return null;
        }
        for (UnidadMedidas x : UnidadMedidas.values()) {
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
