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
@Table(name = "vta_caj_concepto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VtaCajConcepto.findAll", query = "SELECT v FROM VtaCajConcepto v")
    , @NamedQuery(name = "VtaCajConcepto.findByConceptoId", query = "SELECT v FROM VtaCajConcepto v WHERE v.conceptoId = :conceptoId")
    , @NamedQuery(name = "VtaCajConcepto.findByDes", query = "SELECT v FROM VtaCajConcepto v WHERE v.des = :des")
    , @NamedQuery(name = "VtaCajConcepto.findByEstado", query = "SELECT v FROM VtaCajConcepto v WHERE v.estado = :estado")})
public class VtaCajConcepto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "concepto_id")
    private Integer conceptoId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "des")
    private String des;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estado")
    private boolean estado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "conceptoId")
    private Collection<VtaCaj> vtaCajCollection;

    public VtaCajConcepto() {
    }

    public VtaCajConcepto(Integer conceptoId) {
        this.conceptoId = conceptoId;
    }

    public VtaCajConcepto(Integer conceptoId, String des, boolean estado) {
        this.conceptoId = conceptoId;
        this.des = des;
        this.estado = estado;
    }

    public Integer getConceptoId() {
        return conceptoId;
    }

    public void setConceptoId(Integer conceptoId) {
        this.conceptoId = conceptoId;
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

    @XmlTransient
    public Collection<VtaCaj> getVtaCajCollection() {
        return vtaCajCollection;
    }

    public void setVtaCajCollection(Collection<VtaCaj> vtaCajCollection) {
        this.vtaCajCollection = vtaCajCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (conceptoId != null ? conceptoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VtaCajConcepto)) {
            return false;
        }
        VtaCajConcepto other = (VtaCajConcepto) object;
        if ((this.conceptoId == null && other.conceptoId != null) || (this.conceptoId != null && !this.conceptoId.equals(other.conceptoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sigemp.server.entity.VtaCajConcepto[ conceptoId=" + conceptoId + " ]";
    }
    
}
