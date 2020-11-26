/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigemp.gestion.shared.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author cristian
 */
@Entity
@Table(name = "pvta_tiponoventa")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PvtaTiponoventa.findAll", query = "SELECT p FROM PvtaTiponoventa p")
    , @NamedQuery(name = "PvtaTiponoventa.findByTipnvId", query = "SELECT p FROM PvtaTiponoventa p WHERE p.tipnvId = :tipnvId")
    , @NamedQuery(name = "PvtaTiponoventa.findByDes", query = "SELECT p FROM PvtaTiponoventa p WHERE p.des = :des")})
public class PvtaTiponoventa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "tipnv_id")
    private Integer tipnvId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "des")
    private String des;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipnvId")
    private Collection<PvtaMotivonoventa> pvtaMotivonoventaCollection;

    public PvtaTiponoventa() {
    }

    public PvtaTiponoventa(Integer tipnvId) {
        this.tipnvId = tipnvId;
    }

    public PvtaTiponoventa(Integer tipnvId, String des) {
        this.tipnvId = tipnvId;
        this.des = des;
    }

    public Integer getTipnvId() {
        return tipnvId;
    }

    public void setTipnvId(Integer tipnvId) {
        this.tipnvId = tipnvId;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    @XmlTransient
    public Collection<PvtaMotivonoventa> getPvtaMotivonoventaCollection() {
        return pvtaMotivonoventaCollection;
    }

    public void setPvtaMotivonoventaCollection(Collection<PvtaMotivonoventa> pvtaMotivonoventaCollection) {
        this.pvtaMotivonoventaCollection = pvtaMotivonoventaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tipnvId != null ? tipnvId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PvtaTiponoventa)) {
            return false;
        }
        PvtaTiponoventa other = (PvtaTiponoventa) object;
        if ((this.tipnvId == null && other.tipnvId != null) || (this.tipnvId != null && !this.tipnvId.equals(other.tipnvId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sigemp.server.entity.PvtaTiponoventa[ tipnvId=" + tipnvId + " ]";
    }
    
}
