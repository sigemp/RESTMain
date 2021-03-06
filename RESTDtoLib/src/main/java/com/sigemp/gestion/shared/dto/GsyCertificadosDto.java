/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigemp.gestion.shared.dto;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author cristian
 */
public class GsyCertificadosDto implements Serializable {

    private static long serialVersionUID = 1L;

    public enum TIPO_CERTIFICADO {
        PRODUCCION, HOMOLOGACION;
    }

    private Integer cerId;
    private String des;

    private Boolean activo;

    private String feCertificado;

    private String fePrivatekey;

    private String feTa;

    private Date fec;

    private String tipo;

    public GsyCertificadosDto() {
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GsyCertificadosDto)) {
            return false;
        }
        GsyCertificadosDto other = (GsyCertificadosDto) object;
        if ((this.getCerId() == null && other.getCerId() != null) || (this.getCerId() != null && !this.cerId.equals(other.cerId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sigemp.server.entity.GsyCiva[ cerId=" + getCerId() + " ]";
    }

    /**
     * @return the serialVersionUID
     */
    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    /**
     * @param aSerialVersionUID the serialVersionUID to set
     */
    public static void setSerialVersionUID(long aSerialVersionUID) {
        serialVersionUID = aSerialVersionUID;
    }

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
     * @return the feCertificado
     */
    public String getFeCertificado() {
        return feCertificado;
    }

    /**
     * @param feCertificado the feCertificado to set
     */
    public void setFeCertificado(String feCertificado) {
        this.feCertificado = feCertificado;
    }

    /**
     * @return the fePrivatekey
     */
    public String getFePrivatekey() {
        return fePrivatekey;
    }

    /**
     * @param fePrivatekey the fePrivatekey to set
     */
    public void setFePrivatekey(String fePrivatekey) {
        this.fePrivatekey = fePrivatekey;
    }

    /**
     * @return the feTa
     */
    public String getFeTa() {
        return feTa;
    }

    /**
     * @param feTa the feTa to set
     */
    public void setFeTa(String feTa) {
        this.feTa = feTa;
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

}
