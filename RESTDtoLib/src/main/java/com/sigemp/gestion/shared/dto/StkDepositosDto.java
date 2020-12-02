package com.sigemp.gestion.shared.dto;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.Serializable;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author cristian
 */
@XmlRootElement
public class StkDepositosDto implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer depoId;
    private String des;
    private boolean estado;
    private GsySucDto sucId;

    public StkDepositosDto() {
    }

    public StkDepositosDto(Integer depoId) {
        this.depoId = depoId;
    }

    public StkDepositosDto(Integer depoId, String des, boolean estado) {
        this.depoId = depoId;
        this.des = des;
        this.estado = estado;
    }

    public Integer getDepoId() {
        return depoId;
    }

    public void setDepoId(Integer depoId) {
        this.depoId = depoId;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public GsySucDto getSucId() {
        return sucId;
    }

    public void setSucId(GsySucDto sucId) {
        this.sucId = sucId;
    }


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (depoId != null ? depoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StkDepositosDto)) {
            return false;
        }
        StkDepositosDto other = (StkDepositosDto) object;
        if ((this.depoId == null && other.depoId != null) || (this.depoId != null && !this.depoId.equals(other.depoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return des + " id:" + depoId ;
    }
    
}
