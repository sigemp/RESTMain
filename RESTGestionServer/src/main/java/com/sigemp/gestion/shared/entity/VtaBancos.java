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
@Table(name = "vta_bancos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VtaBancos.findAll", query = "SELECT v FROM VtaBancos v")
    , @NamedQuery(name = "VtaBancos.findByBncId", query = "SELECT v FROM VtaBancos v WHERE v.bncId = :bncId")
    , @NamedQuery(name = "VtaBancos.findByActivo", query = "SELECT v FROM VtaBancos v WHERE v.activo = :activo")
    , @NamedQuery(name = "VtaBancos.findByDes", query = "SELECT v FROM VtaBancos v WHERE v.des = :des")})
public class VtaBancos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "bnc_id")
    private Integer bncId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "activo")
    private boolean activo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "des")
    private String des;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bncId")
    private Collection<VtaCobC> vtaCobCCollection;

    public VtaBancos() {
    }

    public VtaBancos(Integer bncId) {
        this.bncId = bncId;
    }

    public VtaBancos(Integer bncId, boolean activo, String des) {
        this.bncId = bncId;
        this.activo = activo;
        this.des = des;
    }

    public Integer getBncId() {
        return bncId;
    }

    public void setBncId(Integer bncId) {
        this.bncId = bncId;
    }

    public boolean getActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    @XmlTransient
    public Collection<VtaCobC> getVtaCobCCollection() {
        return vtaCobCCollection;
    }

    public void setVtaCobCCollection(Collection<VtaCobC> vtaCobCCollection) {
        this.vtaCobCCollection = vtaCobCCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bncId != null ? bncId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VtaBancos)) {
            return false;
        }
        VtaBancos other = (VtaBancos) object;
        if ((this.bncId == null && other.bncId != null) || (this.bncId != null && !this.bncId.equals(other.bncId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sigemp.server.entity.VtaBancos[ bncId=" + bncId + " ]";
    }
    
}
