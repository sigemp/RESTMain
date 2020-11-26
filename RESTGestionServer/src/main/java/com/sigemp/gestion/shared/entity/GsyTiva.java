/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigemp.gestion.shared.entity;

import java.io.Serializable;
import java.math.BigInteger;
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
@Table(name = "gsy_tiva")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GsyTiva.findAll", query = "SELECT g FROM GsyTiva g")
    , @NamedQuery(name = "GsyTiva.findByTivaId", query = "SELECT g FROM GsyTiva g WHERE g.tivaId = :tivaId")
    , @NamedQuery(name = "GsyTiva.findByDes", query = "SELECT g FROM GsyTiva g WHERE g.des = :des")
    , @NamedQuery(name = "GsyTiva.findByPiva", query = "SELECT g FROM GsyTiva g WHERE g.piva = :piva")})
public class GsyTiva implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "tiva_id")
    private Integer tivaId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "des")
    private String des;
    @Basic(optional = false)
    @NotNull
    @Column(name = "piva")
    private BigInteger piva;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tivaId")
    private Collection<StkArt> stkArtCollection;

    public GsyTiva() {
    }

    public GsyTiva(Integer tivaId) {
        this.tivaId = tivaId;
    }

    public GsyTiva(Integer tivaId, String des, BigInteger piva) {
        this.tivaId = tivaId;
        this.des = des;
        this.piva = piva;
    }

    public Integer getTivaId() {
        return tivaId;
    }

    public void setTivaId(Integer tivaId) {
        this.tivaId = tivaId;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public BigInteger getPiva() {
        return piva;
    }

    public void setPiva(BigInteger piva) {
        this.piva = piva;
    }

    @XmlTransient
    public Collection<StkArt> getStkArtCollection() {
        return stkArtCollection;
    }

    public void setStkArtCollection(Collection<StkArt> stkArtCollection) {
        this.stkArtCollection = stkArtCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tivaId != null ? tivaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GsyTiva)) {
            return false;
        }
        GsyTiva other = (GsyTiva) object;
        if ((this.tivaId == null && other.tivaId != null) || (this.tivaId != null && !this.tivaId.equals(other.tivaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sigemp.server.entity.GsyTiva[ tivaId=" + tivaId + " ]";
    }
    
}
