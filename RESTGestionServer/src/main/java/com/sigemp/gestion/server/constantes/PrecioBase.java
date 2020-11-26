/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigemp.gestion.server.constantes;

public enum PrecioBase {
    PRECIO_1(1, "PRECIO 1"),
    PRECIO_2(2, "PRECIO 2"),
    PRECIO_3(3, "PRECIO 3"),
    PRECIO_4(4, "PRECIO 4");

    private final String des;
    private final int numPrc;

    PrecioBase(int numPrc, String des) {
        this.numPrc = numPrc;
        this.des = des;
    }

    @Override
    public String toString() {
        return name().replaceAll("_", " ");
    }

    public int getId() {
        return numPrc;
    }

    public String getDes() {
        return des;
    }

    public static PrecioBase getById(Integer numPrc) {
        if (numPrc == null) {
            return null;
        }
        for (PrecioBase x : PrecioBase.values()) {
            if (numPrc.equals(x.getId())) {
                return x;
            }
        }
        return null;
    }

}
