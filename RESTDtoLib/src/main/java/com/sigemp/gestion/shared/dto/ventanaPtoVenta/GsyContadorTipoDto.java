/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigemp.gestion.shared.dto.ventanaPtoVenta;

/**
 *
 * @author sigem
 */
public class GsyContadorTipoDto {

    private Integer tipoId;
    private Integer tcId;
    private String des;

    /**
     * @return the tcId
     */
    public Integer getTcId() {
        return tcId;
    }

    /**
     * @param tcId the tcId to set
     */
    public void setTcId(Integer tcId) {
        this.tcId = tcId;
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
     * @return the tipoId
     */
    public Integer getTipoId() {
        return tipoId;
    }

    /**
     * @param tipoId the tipoId to set
     */
    public void setTipoId(Integer tipoId) {
        this.tipoId = tipoId;
    }
}
