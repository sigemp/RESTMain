/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigemp.gestion.shared.dto;

/**
 *
 * @author sigem
 */
public class PersonasDto {
   private Long ctaId;
   private String nombre;
   private String tipoResponsable;

    /**
     * @return the ctaId
     */
    public Long getCtaId() {
        return ctaId;
    }

    /**
     * @param ctaId the ctaId to set
     */
    public void setCtaId(Long ctaId) {
        this.ctaId = ctaId;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the tipoResponsable
     */
    public String getTipoResponsable() {
        return tipoResponsable;
    }

    /**
     * @param tipoResponsable the tipoResponsable to set
     */
    public void setTipoResponsable(String tipoResponsable) {
        this.tipoResponsable = tipoResponsable;
    }
}
