/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigemp.gestion.client.api;

import com.google.gwt.resources.client.ImageResource;

/**
 *
 * @author sigem
 */
public class Menu {
   
    private String grupo;
    private String descripcion;
    private String ayuda;
    private ImageResource icon;

    public Menu(String grupo, String descripcion, String string, ImageResource object) {
        this.grupo = grupo;
        this.descripcion = descripcion;
        this.ayuda = string;
        this.icon = object;
    }

    /**
     * @return the grupo
     */
    public String getGrupo() {
        return grupo;
    }

    /**
     * @param grupo the grupo to set
     */
    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    /**
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * @return the ayuda
     */
    public String getAyuda() {
        return ayuda;
    }

    /**
     * @param ayuda the ayuda to set
     */
    public void setAyuda(String ayuda) {
        this.ayuda = ayuda;
    }

    /**
     * @return the icon
     */
    public ImageResource getIcon() {
        return icon;
    }

    /**
     * @param icon the icon to set
     */
    public void setIcon(ImageResource icon) {
        this.icon = icon;
    }

    
}
