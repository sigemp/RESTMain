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
@Table(name = "vta_cob_lote_r")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VtaCobLoteR.findAll", query = "SELECT v FROM VtaCobLoteR v")
    , @NamedQuery(name = "VtaCobLoteR.findByCobloterId", query = "SELECT v FROM VtaCobLoteR v WHERE v.cobloterId = :cobloterId")})
public class VtaCobLoteR implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cobloter_id")
    private Integer cobloterId;
    @JoinColumn(name = "cob_id", referencedColumnName = "cob_id")
    @ManyToOne
    private VtaCob cobId;
    @JoinColumn(name = "coblote_id", referencedColumnName = "coblote_id")
    @ManyToOne
    private VtaCobLote cobloteId;

    public VtaCobLoteR() {
    }

    public VtaCobLoteR(Integer cobloterId) {
        this.cobloterId = cobloterId;
    }

    public Integer getCobloterId() {
        return cobloterId;
    }

    public void setCobloterId(Integer cobloterId) {
        this.cobloterId = cobloterId;
    }

    public VtaCob getCobId() {
        return cobId;
    }

    public void setCobId(VtaCob cobId) {
        this.cobId = cobId;
    }

    public VtaCobLote getCobloteId() {
        return cobloteId;
    }

    public void setCobloteId(VtaCobLote cobloteId) {
        this.cobloteId = cobloteId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cobloterId != null ? cobloterId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VtaCobLoteR)) {
            return false;
        }
        VtaCobLoteR other = (VtaCobLoteR) object;
        if ((this.cobloterId == null && other.cobloterId != null) || (this.cobloterId != null && !this.cobloterId.equals(other.cobloterId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sigemp.server.entity.VtaCobLoteR[ cobloterId=" + cobloterId + " ]";
    }
    
}
