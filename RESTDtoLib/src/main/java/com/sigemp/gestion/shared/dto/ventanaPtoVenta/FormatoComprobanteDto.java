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
public class FormatoComprobanteDto {

    private Integer id;
    private String des;
    private Integer tipoSalida;

    public FormatoComprobanteDto() {

    }

    public FormatoComprobanteDto(int id, String des, Integer tipoSalida) {
        this.id = id;
        this.des = des;
        this.tipoSalida = tipoSalida;
    }

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
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
     * @return the tipoSalida
     */
    public Integer getTipoSalida() {
        return tipoSalida;
    }

    /**
     * @param tipoSalida the tipoSalida to set
     */
    public void setTipoSalida(Integer tipoSalida) {
        this.tipoSalida = tipoSalida;
    }
    
    public String toString() {
        return des;
    }
}
