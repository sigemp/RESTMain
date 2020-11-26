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
public class GsyContadorestipos implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer tipoId;
    private GsyContadores conId;
    private Integer tcId;

    public GsyContadorestipos() {
    }

    public GsyContadorestipos(Integer tipoId) {
        this.tipoId = tipoId;
    }

    public Integer getTipoId() {
        return tipoId;
    }

    public void setTipoId(Integer tipoId) {
        this.tipoId = tipoId;
    }

    public GsyContadores getConId() {
        return conId;
    }

    public void setConId(GsyContadores conId) {
        this.conId = conId;
    }

    public Integer getTcId() {
        return tcId;
    }

    public void setTcId(Integer tcId) {
        this.tcId = tcId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tipoId != null ? tipoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GsyContadorestipos)) {
            return false;
        }
        GsyContadorestipos other = (GsyContadorestipos) object;
        if ((this.tipoId == null && other.tipoId != null) || (this.tipoId != null && !this.tipoId.equals(other.tipoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sigemp.server.entity.GsyContadorestipos[ tipoId=" + tipoId + " ]";
    }

}
