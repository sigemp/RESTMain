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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author cristian
 */
@Entity
@Table(name = "gsy_contadorestipos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GsyContadorestipos.findAll", query = "SELECT g FROM GsyContadorestipos g")
    , @NamedQuery(name = "GsyContadorestipos.findByTipoId", query = "SELECT g FROM GsyContadorestipos g WHERE g.tipoId = :tipoId")})
public class GsyContadorestipos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "tipo_id")
    private Integer tipoId;
    @JoinColumn(name = "con_id", referencedColumnName = "con_id")
    @ManyToOne(optional = false)
    private GsyContadores conId;
    @JoinColumn(name = "tc_id", referencedColumnName = "tc_id")
    @ManyToOne(optional = false)
    private GsyTiposcomprobantes tcId;

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

    public GsyTiposcomprobantes getTcId() {
        return tcId;
    }

    public void setTcId(GsyTiposcomprobantes tcId) {
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
