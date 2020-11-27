/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigemp.gestion.constants;

public enum EstadoCuentaFlag {
    FLAG_PERMITE_FACTURAR("f", "Permite Facturar"),
    FLAG_PERMITA_COBRAR("c", "Permite Cobrar");
    private final String des;
    private final String id;

    private EstadoCuentaFlag(String id, String des) {
        this.id = id;
        this.des = des;
    }

    /**
     * @return the des
     */
    public String getDes() {
        return des;
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

}
