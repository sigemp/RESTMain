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
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "vta_cob")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VtaCob.findAll", query = "SELECT v FROM VtaCob v")
    , @NamedQuery(name = "VtaCob.findByCobId", query = "SELECT v FROM VtaCob v WHERE v.cobId = :cobId")
    , @NamedQuery(name = "VtaCob.findByFec", query = "SELECT v FROM VtaCob v WHERE v.fec = :fec")
    , @NamedQuery(name = "VtaCob.findByMorbon", query = "SELECT v FROM VtaCob v WHERE v.morbon = :morbon")
    , @NamedQuery(name = "VtaCob.findByMortot", query = "SELECT v FROM VtaCob v WHERE v.mortot = :mortot")
    , @NamedQuery(name = "VtaCob.findByNum", query = "SELECT v FROM VtaCob v WHERE v.num = :num")
    , @NamedQuery(name = "VtaCob.findByPtovta", query = "SELECT v FROM VtaCob v WHERE v.ptovta = :ptovta")
    , @NamedQuery(name = "VtaCob.findByTot", query = "SELECT v FROM VtaCob v WHERE v.tot = :tot")
    , @NamedQuery(name = "VtaCob.findByTotsal", query = "SELECT v FROM VtaCob v WHERE v.totsal = :totsal")})
public class VtaCob implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cob_id")
    private Integer cobId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fec")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fec;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "morbon")
    private BigDecimal morbon;
    @Basic(optional = false)
    @NotNull
    @Column(name = "mortot")
    private BigDecimal mortot;
    @Basic(optional = false)
    @NotNull
    @Column(name = "num")
    private int num;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ptovta")
    private int ptovta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tot")
    private BigDecimal tot;
    @Basic(optional = false)
    @NotNull
    @Column(name = "totsal")
    private BigDecimal totsal;
    @JoinColumn(name = "tc_id", referencedColumnName = "tc_id")
    @ManyToOne(optional = false)
    private GsyTiposcomprobantes tcId;
    @JoinColumn(name = "usr_id", referencedColumnName = "usr_id")
    @ManyToOne(optional = false)
    private GsyUser usrId;
    @JoinColumn(name = "depo_id", referencedColumnName = "depo_id")
    @ManyToOne(optional = false)
    private StkDepositos depoId;
    @JoinColumn(name = "cierre_id", referencedColumnName = "cierre_id")
    @ManyToOne
    private VtaCierres cierreId;
    @JoinColumn(name = "cta_id", referencedColumnName = "cta_id")
    @ManyToOne(optional = false)
    private VtaCta ctaId;
    @JoinColumn(name = "vta_id", referencedColumnName = "vta_id")
    @ManyToOne
    private VtaVta vtaId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cobId")
    private Collection<VtaCobr> vtaCobrCollection;
    @OneToMany(mappedBy = "cobId")
    private Collection<VtaCobLoteR> vtaCobLoteRCollection;

    public VtaCob() {
    }

    public VtaCob(Integer cobId) {
        this.cobId = cobId;
    }

    public VtaCob(Integer cobId, Date fec, BigDecimal morbon, BigDecimal mortot, int num, int ptovta, BigDecimal tot, BigDecimal totsal) {
        this.cobId = cobId;
        this.fec = fec;
        this.morbon = morbon;
        this.mortot = mortot;
        this.num = num;
        this.ptovta = ptovta;
        this.tot = tot;
        this.totsal = totsal;
    }

    public Integer getCobId() {
        return cobId;
    }

    public void setCobId(Integer cobId) {
        this.cobId = cobId;
    }

    public Date getFec() {
        return fec;
    }

    public void setFec(Date fec) {
        this.fec = fec;
    }

    public BigDecimal getMorbon() {
        return morbon;
    }

    public void setMorbon(BigDecimal morbon) {
        this.morbon = morbon;
    }

    public BigDecimal getMortot() {
        return mortot;
    }

    public void setMortot(BigDecimal mortot) {
        this.mortot = mortot;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getPtovta() {
        return ptovta;
    }

    public void setPtovta(int ptovta) {
        this.ptovta = ptovta;
    }

    public BigDecimal getTot() {
        return tot;
    }

    public void setTot(BigDecimal tot) {
        this.tot = tot;
    }

    public BigDecimal getTotsal() {
        return totsal;
    }

    public void setTotsal(BigDecimal totsal) {
        this.totsal = totsal;
    }

    public GsyTiposcomprobantes getTcId() {
        return tcId;
    }

    public void setTcId(GsyTiposcomprobantes tcId) {
        this.tcId = tcId;
    }

    public GsyUser getUsrId() {
        return usrId;
    }

    public void setUsrId(GsyUser usrId) {
        this.usrId = usrId;
    }

    public StkDepositos getDepoId() {
        return depoId;
    }

    public void setDepoId(StkDepositos depoId) {
        this.depoId = depoId;
    }

    public VtaCierres getCierreId() {
        return cierreId;
    }

    public void setCierreId(VtaCierres cierreId) {
        this.cierreId = cierreId;
    }

    public VtaCta getCtaId() {
        return ctaId;
    }

    public void setCtaId(VtaCta ctaId) {
        this.ctaId = ctaId;
    }

    public VtaVta getVtaId() {
        return vtaId;
    }

    public void setVtaId(VtaVta vtaId) {
        this.vtaId = vtaId;
    }

    @XmlTransient
    public Collection<VtaCobr> getVtaCobrCollection() {
        return vtaCobrCollection;
    }

    public void setVtaCobrCollection(Collection<VtaCobr> vtaCobrCollection) {
        this.vtaCobrCollection = vtaCobrCollection;
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
        hash += (cobId != null ? cobId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VtaCob)) {
            return false;
        }
        VtaCob other = (VtaCob) object;
        if ((this.cobId == null && other.cobId != null) || (this.cobId != null && !this.cobId.equals(other.cobId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sigemp.server.entity.VtaCob[ cobId=" + cobId + " ]";
    }
    
}
