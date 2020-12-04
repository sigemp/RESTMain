/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigemp.gestion.shared.dto.ventanaCertificados;

import java.util.Date;

/**
 * utilizado para mostrar el listado (Resumido)
 * @author sigem
 */
public class ListCertificadoDto {

    private Integer cerId;
    private Boolean activo;
    private String des;
    private String tipo;
    private Date fec;

    /**
     * @return the cerId
     */
    public Integer getCerId() {
        return cerId;
    }

    /**
     * @param cerId the cerId to set
     */
    public void setCerId(Integer cerId) {
        this.cerId = cerId;
    }

    /**
     * @return the activo
     */
    public Boolean getActivo() {
        return activo;
    }

    /**
     * @param activo the activo to set
     */
    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    /**
     * @return the des
     */
    public String getDes() {
        return des;
    }

    /**
     * @param des the des to set
     */
    public void setDes(String des) {
        this.des = des;
    }

    /**
     * @return the tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * @return the fec
     */
    public Date getFec() {
        return fec;
    }

    /**
     * @param fec the fec to set
     */
    public void setFec(Date fec) {
        this.fec = fec;
    }
}
