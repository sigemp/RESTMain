/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigemp.gestion.client.api.menu;

import com.sigemp.gestion.client.api.interfaces.PanelActivityInterface;
import java.util.ArrayList;
import java.util.List;

/**
 * Objeto Menu que posee todas las opciones
 *
 * @author Server
 */
public class SgGrupo {
    private String descripcion;
    
    //Lista de opciones del menu
    List<PanelActivityInterface> list = new ArrayList<>();

    public SgGrupo(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<PanelActivityInterface> getActivityList() {
        return list;
    }
    
    public void add(PanelActivityInterface activity) {
        list.add(activity);
    }
}
