/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigemp.gestion.shared.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author cristian
 */
@Entity
@Table(name = "stk_depositos")
@XmlRootElement
public class StkDepositos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "depo_id")
    private Integer depoId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "des")
    private String des;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estado")
    private boolean estado;
    @JoinColumn(name = "suc_id", referencedColumnName = "suc_id")
    @ManyToOne(optional = false)
    private GsySuc sucId;

    public StkDepositos() {
    }

    public StkDepositos(Integer depoId) {
        this.depoId = depoId;
    }

    public StkDepositos(Integer depoId, String des, boolean estado) {
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


    public GsySuc getSucId() {
        return sucId;
    }

    public void setSucId(GsySuc sucId) {
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
        if (!(object instanceof StkDepositos)) {
            return false;
        }
        StkDepositos other = (StkDepositos) object;
        if ((this.depoId == null && other.depoId != null) || (this.depoId != null && !this.depoId.equals(other.depoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sigemp.server.entity.StkDepositos[ depoId=" + depoId + " ]";
    }
    
}
