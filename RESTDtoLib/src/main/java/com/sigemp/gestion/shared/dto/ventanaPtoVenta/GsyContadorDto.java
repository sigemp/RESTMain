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
public class GsyContadorDto {

    private Integer contadorId;
    private String des;
    private List<GsyContadorTipoDto> tiposComprobantes;

    /**
     * @return the contadorId
     */
    public Integer getContadorId() {
        return contadorId;
    }

    /**
     * @param contadorId the contadorId to set
     */
    public void setContadorId(Integer contadorId) {
        this.contadorId = contadorId;
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
     * @return the tiposComprobantes
     */
    public List<GsyContadorTipoDto> getTiposComprobantes() {
        return tiposComprobantes;
    }

    /**
     * @param tiposComprobantes the tiposComprobantes to set
     */
    public void setTiposComprobantes(List<GsyContadorTipoDto> tiposComprobantes) {
        this.tiposComprobantes = tiposComprobantes;
    }
}
