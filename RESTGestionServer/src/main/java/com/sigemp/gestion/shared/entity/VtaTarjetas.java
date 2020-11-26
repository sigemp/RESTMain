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
@Table(name = "vta_tarjetas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VtaTarjetas.findAll", query = "SELECT v FROM VtaTarjetas v")
    , @NamedQuery(name = "VtaTarjetas.findByTrjId", query = "SELECT v FROM VtaTarjetas v WHERE v.trjId = :trjId")
    , @NamedQuery(name = "VtaTarjetas.findByActivo", query = "SELECT v FROM VtaTarjetas v WHERE v.activo = :activo")
    , @NamedQuery(name = "VtaTarjetas.findByDes", query = "SELECT v FROM VtaTarjetas v WHERE v.des = :des")})
public class VtaTarjetas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "trj_id")
    private Integer trjId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "activo")
    private boolean activo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "des")
    private String des;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "trjId")
    private Collection<VtaCobT> vtaCobTCollection;

    public VtaTarjetas() {
    }

    public VtaTarjetas(Integer trjId) {
        this.trjId = trjId;
    }

    public VtaTarjetas(Integer trjId, boolean activo, String des) {
        this.trjId = trjId;
        this.activo = activo;
        this.des = des;
    }

    public Integer getTrjId() {
        return trjId;
    }

    public void setTrjId(Integer trjId) {
        this.trjId = trjId;
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
    public Collection<VtaCobT> getVtaCobTCollection() {
        return vtaCobTCollection;
    }

    public void setVtaCobTCollection(Collection<VtaCobT> vtaCobTCollection) {
        this.vtaCobTCollection = vtaCobTCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (trjId != null ? trjId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VtaTarjetas)) {
            return false;
        }
        VtaTarjetas other = (VtaTarjetas) object;
        if ((this.trjId == null && other.trjId != null) || (this.trjId != null && !this.trjId.equals(other.trjId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sigemp.server.entity.VtaTarjetas[ trjId=" + trjId + " ]";
    }
    
}
