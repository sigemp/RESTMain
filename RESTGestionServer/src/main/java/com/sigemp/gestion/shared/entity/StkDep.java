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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "stk_dep")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "StkDep.findAll", query = "SELECT s FROM StkDep s")
    , @NamedQuery(name = "StkDep.findByDepId", query = "SELECT s FROM StkDep s WHERE s.depId = :depId")
    , @NamedQuery(name = "StkDep.findByDes", query = "SELECT s FROM StkDep s WHERE s.des = :des")
    , @NamedQuery(name = "StkDep.findByTipo", query = "SELECT s FROM StkDep s WHERE s.tipo = :tipo")})
public class StkDep implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "dep_id")
    private Integer depId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "des")
    private String des;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "tipo")
    private String tipo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "depId")
    private Collection<StkArt> stkArtCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "depId")
    private Collection<PvtaTiponegociodtorubro> pvtaTiponegociodtorubroCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "depId")
    private Collection<VtaCtadtorubro> vtaCtadtorubroCollection;

    public StkDep() {
    }

    public StkDep(Integer depId) {
        this.depId = depId;
    }

    public StkDep(Integer depId, String des, String tipo) {
        this.depId = depId;
        this.des = des;
        this.tipo = tipo;
    }

    public Integer getDepId() {
        return depId;
    }

    public void setDepId(Integer depId) {
        this.depId = depId;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @XmlTransient
    public Collection<StkArt> getStkArtCollection() {
        return stkArtCollection;
    }

    public void setStkArtCollection(Collection<StkArt> stkArtCollection) {
        this.stkArtCollection = stkArtCollection;
    }

    @XmlTransient
    public Collection<PvtaTiponegociodtorubro> getPvtaTiponegociodtorubroCollection() {
        return pvtaTiponegociodtorubroCollection;
    }

    public void setPvtaTiponegociodtorubroCollection(Collection<PvtaTiponegociodtorubro> pvtaTiponegociodtorubroCollection) {
        this.pvtaTiponegociodtorubroCollection = pvtaTiponegociodtorubroCollection;
    }

    @XmlTransient
    public Collection<VtaCtadtorubro> getVtaCtadtorubroCollection() {
        return vtaCtadtorubroCollection;
    }

    public void setVtaCtadtorubroCollection(Collection<VtaCtadtorubro> vtaCtadtorubroCollection) {
        this.vtaCtadtorubroCollection = vtaCtadtorubroCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (depId != null ? depId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StkDep)) {
            return false;
        }
        StkDep other = (StkDep) object;
        if ((this.depId == null && other.depId != null) || (this.depId != null && !this.depId.equals(other.depId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sigemp.server.entity.StkDep[ depId=" + depId + " ]";
    }
    
}
