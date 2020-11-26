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
public class PtoVtaDto {
    private Integer ptoVta;
    private String des;
    private List<GsyContadorDto> contadores;

    /**
     * @return the ptoVta
     */
    public Integer getPtoVta() {
        return ptoVta;
    }

    /**
     * @param ptoVta the ptoVta to set
     */
    public void setPtoVta(Integer ptoVta) {
        this.ptoVta = ptoVta;
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
     * @return the contadores
     */
    public List<GsyContadorDto> getContadores() {
        return contadores;
    }

    /**
     * @param contadores the contadores to set
     */
    public void setContadores(List<GsyContadorDto> contadores) {
        this.contadores = contadores;
    }
}
