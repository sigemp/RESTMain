/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigemp.gestion.shared.entity;

import java.io.Serializable;

/**
 *
 * @author cristian
 */
public class GsyTalonarios implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer talId;
    private String des;
    private boolean estado;
    private String feTa;
    private String ifbaudios;
    private String ifmarca;
    private String ifmodelo;
    private Integer ifpuerto;
    private StkDepositos depoId;

    public GsyTalonarios() {
    }

    public GsyTalonarios(Integer talId) {
        this.talId = talId;
    }

    public GsyTalonarios(Integer talId, String des, boolean estado) {
        this.talId = talId;
        this.des = des;
        this.estado = estado;
    }

    public Integer getTalId() {
        return talId;
    }

    public void setTalId(Integer talId) {
        this.talId = talId;
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

    public String getFeTa() {
        return feTa;
    }

    public void setFeTa(String feTa) {
        this.feTa = feTa;
    }

    public String getIfbaudios() {
        return ifbaudios;
    }

    public void setIfbaudios(String ifbaudios) {
        this.ifbaudios = ifbaudios;
    }

    public String getIfmarca() {
        return ifmarca;
    }

    public void setIfmarca(String ifmarca) {
        this.ifmarca = ifmarca;
    }

    public String getIfmodelo() {
        return ifmodelo;
    }

    public void setIfmodelo(String ifmodelo) {
        this.ifmodelo = ifmodelo;
    }

    public Integer getIfpuerto() {
        return ifpuerto;
    }

    public void setIfpuerto(Integer ifpuerto) {
        this.ifpuerto = ifpuerto;
    }

    public StkDepositos getDepoId() {
        return depoId;
    }

    public void setDepoId(StkDepositos depoId) {
        this.depoId = depoId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (talId != null ? talId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GsyTalonarios)) {
            return false;
        }
        GsyTalonarios other = (GsyTalonarios) object;
        if ((this.talId == null && other.talId != null) || (this.talId != null && !this.talId.equals(other.talId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sigemp.server.entity.GsyTalonarios[ talId=" + talId + " ]";
    }

}
