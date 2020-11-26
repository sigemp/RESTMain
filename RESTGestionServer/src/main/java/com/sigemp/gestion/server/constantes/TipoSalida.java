/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigemp.gestion.server.constantes;

public enum TipoSalida {
    GRAFICA("Grafica", 0), MATRIZ_PUNTO("Matriz de Punto", 1);
    private int id;
    private String des;

    private TipoSalida(String des, int id) {
        this.des = des;
        this.id = id;
    }

    public int getId() {
        return id;
    }
};
