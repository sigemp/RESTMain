/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigemp.gestion.shared.entity.constantes;

/**
 *
 * @author sigem
 */
public enum Formats {
    DATE("yyyy-MM-dd'T'HH:mm:ss'Z'"), HORA("HH:mm:ss");
    private String str;

    Formats(String str) {
        this.str = str;
    }

    public String getFormat() {
        return str;
    }
}
