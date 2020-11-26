/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigemp.gestion.shared.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author cristian
 */
@Entity
@Table(name = "vta_cob_lote")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VtaCobLote.findAll", query = "SELECT v FROM VtaCobLote v")
    , @NamedQuery(name = "VtaCobLote.findByCobloteId", query = "SELECT v FROM VtaCobLote v WHERE v.cobloteId = :cobloteId")
    , @NamedQuery(name = "VtaCobLote.findByFec", query = "SELECT v FROM VtaCobLote v WHERE v.fec = :fec")
    , @NamedQuery(name = "VtaCobLote.findByTot", query = "SELECT v FROM VtaCobLote v WHERE v.tot = :tot")
    , @NamedQuery(name = "VtaCobLote.findByTotSal", query = "SELECT v FROM VtaCobLote v WHERE v.totSal = :totSal")
    , @NamedQuery(name = "VtaCobLote.findByRutaId", query = "SELECT v FROM VtaCobLote v WHERE v.rutaId = :rutaId")
    , @NamedQuery(name = "VtaCobLote.findByVenId", query = "SELECT v FROM VtaCobLote v WHERE v.venId = :venId")
    , @NamedQuery(name = "VtaCobLote.findByPtovta", query = "SELECT v FROM VtaCobLote v WHERE v.ptovta = :ptovta")
    , @NamedQuery(name = "VtaCobLote.findByNum", query = "SELECT v FROM VtaCobLote v WHERE v.num = :num")
    , @NamedQuery(name = "VtaCobLote.findByTcId", query = "SELECT v FROM VtaCobLote v WHERE v.tcId = :tcId")})
public class VtaCobLote implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "coblote_id")
    private Integer cobloteId;
    @Column(name = "fec")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fec;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "tot")
    private BigDecimal tot;
    @Column(name = "tot_sal")
    private BigDecimal totSal;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ruta_id")
    private int rutaId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ven_id")
    private int venId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ptovta")
    private int ptovta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "num")
    private int num;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tc_id")
    private int tcId;
    @OneToMany(mappedBy = "cobloteId")
    private Collection<VtaCobLoteR> vtaCobLoteRCollection;

    public VtaCobLote() {
    }

    public VtaCobLote(Integer cobloteId) {
        this.cobloteId = cobloteId;
    }

    public VtaCobLote(Integer cobloteId, int rutaId, int venId, int ptovta, int num, int tcId) {
        this.cobloteId = cobloteId;
        this.rutaId = rutaId;
        this.venId = venId;
        this.ptovta = ptovta;
        this.num = num;
        this.tcId = tcId;
    }

    public Integer getCobloteId() {
        return cobloteId;
    }

    public void setCobloteId(Integer cobloteId) {
        this.cobloteId = cobloteId;
    }

    public Date getFec() {
        return fec;
    }

    public void setFec(Date fec) {
        this.fec = fec;
    }

    public BigDecimal getTot() {
        return tot;
    }

    public void setTot(BigDecimal tot) {
        this.tot = tot;
    }

    public BigDecimal getTotSal() {
        return totSal;
    }

    public void setTotSal(BigDecimal totSal) {
        this.totSal = totSal;
    }

    public int getRutaId() {
        return rutaId;
    }

    public void setRutaId(int rutaId) {
        this.rutaId = rutaId;
    }

    public int getVenId() {
        return venId;
    }

    public void setVenId(int venId) {
        this.venId = venId;
    }

    public int getPtovta() {
        return ptovta;
    }

    public void setPtovta(int ptovta) {
        this.ptovta = ptovta;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getTcId() {
        return tcId;
    }

    public void setTcId(int tcId) {
        this.tcId = tcId;
    }

    @XmlTransient
    public Collection<VtaCobLoteR> getVtaCobLoteRCollection() {
        return vtaCobLoteRCollection;
    }

    public void setVtaCobLoteRCollection(Collection<VtaCobLoteR> vtaCobLoteRCollection) {
        this.vtaCobLoteRCollection = vtaCobLoteRCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cobloteId != null ? cobloteId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VtaCobLote)) {
            return false;
        }
        VtaCobLote other = (VtaCobLote) object;
        if ((this.cobloteId == null && other.cobloteId != null) || (this.cobloteId != null && !this.cobloteId.equals(other.cobloteId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sigemp.server.entity.VtaCobLote[ cobloteId=" + cobloteId + " ]";
    }
    
}
