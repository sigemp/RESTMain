/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigemp.gestion.shared.entity;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "vta_mc")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VtaMc.findAll", query = "SELECT v FROM VtaMc v")
    , @NamedQuery(name = "VtaMc.findByMcId", query = "SELECT v FROM VtaMc v WHERE v.mcId = :mcId")
    , @NamedQuery(name = "VtaMc.findByDes", query = "SELECT v FROM VtaMc v WHERE v.des = :des")
    , @NamedQuery(name = "VtaMc.findByDiaatr", query = "SELECT v FROM VtaMc v WHERE v.diaatr = :diaatr")
    , @NamedQuery(name = "VtaMc.findByEstado", query = "SELECT v FROM VtaMc v WHERE v.estado = :estado")
    , @NamedQuery(name = "VtaMc.findByPorAgr", query = "SELECT v FROM VtaMc v WHERE v.porAgr = :porAgr")
    , @NamedQuery(name = "VtaMc.findByTipo", query = "SELECT v FROM VtaMc v WHERE v.tipo = :tipo")})
public class VtaMc implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "mc_id")
    private Integer mcId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "des")
    private String des;
    @Basic(optional = false)
    @NotNull
    @Column(name = "diaatr")
    private int diaatr;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estado")
    private boolean estado;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "por_agr")
    private BigDecimal porAgr;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "tipo")
    private String tipo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "mcId")
    private Collection<VtaCajr> vtaCajrCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "mcId")
    private Collection<VtaCobr> vtaCobrCollection;

    public VtaMc() {
    }

    public VtaMc(Integer mcId) {
        this.mcId = mcId;
    }

    public VtaMc(Integer mcId, String des, int diaatr, boolean estado, BigDecimal porAgr, String tipo) {
        this.mcId = mcId;
        this.des = des;
        this.diaatr = diaatr;
        this.estado = estado;
        this.porAgr = porAgr;
        this.tipo = tipo;
    }

    public Integer getMcId() {
        return mcId;
    }

    public void setMcId(Integer mcId) {
        this.mcId = mcId;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public int getDiaatr() {
        return diaatr;
    }

    public void setDiaatr(int diaatr) {
        this.diaatr = diaatr;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public BigDecimal getPorAgr() {
        return porAgr;
    }

    public void setPorAgr(BigDecimal porAgr) {
        this.porAgr = porAgr;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @XmlTransient
    public Collection<VtaCajr> getVtaCajrCollection() {
        return vtaCajrCollection;
    }

    public void setVtaCajrCollection(Collection<VtaCajr> vtaCajrCollection) {
        this.vtaCajrCollection = vtaCajrCollection;
    }

    @XmlTransient
    public Collection<VtaCobr> getVtaCobrCollection() {
        return vtaCobrCollection;
    }

    public void setVtaCobrCollection(Collection<VtaCobr> vtaCobrCollection) {
        this.vtaCobrCollection = vtaCobrCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (mcId != null ? mcId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VtaMc)) {
            return false;
        }
        VtaMc other = (VtaMc) object;
        if ((this.mcId == null && other.mcId != null) || (this.mcId != null && !this.mcId.equals(other.mcId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sigemp.server.entity.VtaMc[ mcId=" + mcId + " ]";
    }
    
}
