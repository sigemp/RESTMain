/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigemp.gestion.shared.dto.ventanaPtoVenta;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sigem
 */
public class GsySucDto {

    private Integer sucId;
    private String des;
    private List<PtoVtaDto> puntosDeVentas;

    /**
     * @return the sucId
     */
    public Integer getSucId() {
        return sucId;
    }

    /**
     * @param sucId the sucId to set
     */
    public void setSucId(Integer sucId) {
        this.sucId = sucId;
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
     * @return the puntosDeVentas
     */
    public List<PtoVtaDto> getPuntosDeVentas() {
        return puntosDeVentas;
    }

    /**
     * @param puntosDeVentas the puntosDeVentas to set
     */
    public void setPuntosDeVentas(List<PtoVtaDto> puntosDeVentas) {
        this.puntosDeVentas = puntosDeVentas;
    }
}
