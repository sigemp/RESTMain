/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigemp.gestion.shared.entity;

import java.io.Serializable;
import java.math.BigDecimal;
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
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author cristian
 */
@Entity
@Table(name = "vta_cpgr")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VtaCpgr.findAll", query = "SELECT v FROM VtaCpgr v")
    , @NamedQuery(name = "VtaCpgr.findByCpgrId", query = "SELECT v FROM VtaCpgr v WHERE v.cpgrId = :cpgrId")
    , @NamedQuery(name = "VtaCpgr.findByCuotad", query = "SELECT v FROM VtaCpgr v WHERE v.cuotad = :cuotad")
    , @NamedQuery(name = "VtaCpgr.findByCuotah", query = "SELECT v FROM VtaCpgr v WHERE v.cuotah = :cuotah")
    , @NamedQuery(name = "VtaCpgr.findByIncrementaprc", query = "SELECT v FROM VtaCpgr v WHERE v.incrementaprc = :incrementaprc")
    , @NamedQuery(name = "VtaCpgr.findByRen", query = "SELECT v FROM VtaCpgr v WHERE v.ren = :ren")
    , @NamedQuery(name = "VtaCpgr.findByTdm", query = "SELECT v FROM VtaCpgr v WHERE v.tdm = :tdm")
    , @NamedQuery(name = "VtaCpgr.findByTvariablecuota", query = "SELECT v FROM VtaCpgr v WHERE v.tvariablecuota = :tvariablecuota")})
public class VtaCpgr implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cpgr_id")
    private Integer cpgrId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cuotad")
    private int cuotad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cuotah")
    private int cuotah;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "incrementaprc")
    private BigDecimal incrementaprc;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ren")
    private int ren;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tdm")
    private BigDecimal tdm;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tvariablecuota")
    private BigDecimal tvariablecuota;
    @JoinColumn(name = "cpg_id", referencedColumnName = "cpg_id")
    @ManyToOne(optional = false)
    private VtaCpg cpgId;

    public VtaCpgr() {
    }

    public VtaCpgr(Integer cpgrId) {
        this.cpgrId = cpgrId;
    }

    public VtaCpgr(Integer cpgrId, int cuotad, int cuotah, BigDecimal incrementaprc, int ren, BigDecimal tdm, BigDecimal tvariablecuota) {
        this.cpgrId = cpgrId;
        this.cuotad = cuotad;
        this.cuotah = cuotah;
        this.incrementaprc = incrementaprc;
        this.ren = ren;
        this.tdm = tdm;
        this.tvariablecuota = tvariablecuota;
    }

    public Integer getCpgrId() {
        return cpgrId;
    }

    public void setCpgrId(Integer cpgrId) {
        this.cpgrId = cpgrId;
    }

    public int getCuotad() {
        return cuotad;
    }

    public void setCuotad(int cuotad) {
        this.cuotad = cuotad;
    }

    public int getCuotah() {
        return cuotah;
    }

    public void setCuotah(int cuotah) {
        this.cuotah = cuotah;
    }

    public BigDecimal getIncrementaprc() {
        return incrementaprc;
    }

    public void setIncrementaprc(BigDecimal incrementaprc) {
        this.incrementaprc = incrementaprc;
    }

    public int getRen() {
        return ren;
    }

    public void setRen(int ren) {
        this.ren = ren;
    }

    public BigDecimal getTdm() {
        return tdm;
    }

    public void setTdm(BigDecimal tdm) {
        this.tdm = tdm;
    }

    public BigDecimal getTvariablecuota() {
        return tvariablecuota;
    }

    public void setTvariablecuota(BigDecimal tvariablecuota) {
        this.tvariablecuota = tvariablecuota;
    }

    public VtaCpg getCpgId() {
        return cpgId;
    }

    public void setCpgId(VtaCpg cpgId) {
        this.cpgId = cpgId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cpgrId != null ? cpgrId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VtaCpgr)) {
            return false;
        }
        VtaCpgr other = (VtaCpgr) object;
        if ((this.cpgrId == null && other.cpgrId != null) || (this.cpgrId != null && !this.cpgrId.equals(other.cpgrId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sigemp.server.entity.VtaCpgr[ cpgrId=" + cpgrId + " ]";
    }
    
}
