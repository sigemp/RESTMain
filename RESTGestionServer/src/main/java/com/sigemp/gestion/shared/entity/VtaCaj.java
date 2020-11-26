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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author cristian
 */
@Entity
@Table(name = "vta_caj")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VtaCaj.findAll", query = "SELECT v FROM VtaCaj v")
    , @NamedQuery(name = "VtaCaj.findByCajId", query = "SELECT v FROM VtaCaj v WHERE v.cajId = :cajId")
    , @NamedQuery(name = "VtaCaj.findByFec", query = "SELECT v FROM VtaCaj v WHERE v.fec = :fec")
    , @NamedQuery(name = "VtaCaj.findByNum", query = "SELECT v FROM VtaCaj v WHERE v.num = :num")
    , @NamedQuery(name = "VtaCaj.findByObs", query = "SELECT v FROM VtaCaj v WHERE v.obs = :obs")
    , @NamedQuery(name = "VtaCaj.findByPtovta", query = "SELECT v FROM VtaCaj v WHERE v.ptovta = :ptovta")
    , @NamedQuery(name = "VtaCaj.findByTot", query = "SELECT v FROM VtaCaj v WHERE v.tot = :tot")})
public class VtaCaj implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "caj_id")
    private Integer cajId;
    @Column(name = "fec")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fec;
    @Basic(optional = false)
    @NotNull
    @Column(name = "num")
    private int num;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 400)
    @Column(name = "obs")
    private String obs;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ptovta")
    private int ptovta;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "tot")
    private BigDecimal tot;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cajId")
    private Collection<VtaCajr> vtaCajrCollection;
    @JoinColumn(name = "tc_id", referencedColumnName = "tc_id")
    @ManyToOne(optional = false)
    private GsyTiposcomprobantes tcId;
    @JoinColumn(name = "usr_id", referencedColumnName = "usr_id")
    @ManyToOne(optional = false)
    private GsyUser usrId;
    @JoinColumn(name = "depo_id", referencedColumnName = "depo_id")
    @ManyToOne(optional = false)
    private StkDepositos depoId;
    @JoinColumn(name = "concepto_id", referencedColumnName = "concepto_id")
    @ManyToOne(optional = false)
    private VtaCajConcepto conceptoId;
    @JoinColumn(name = "cierre_id", referencedColumnName = "cierre_id")
    @ManyToOne
    private VtaCierres cierreId;

    public VtaCaj() {
    }

    public VtaCaj(Integer cajId) {
        this.cajId = cajId;
    }

    public VtaCaj(Integer cajId, int num, String obs, int ptovta, BigDecimal tot) {
        this.cajId = cajId;
        this.num = num;
        this.obs = obs;
        this.ptovta = ptovta;
        this.tot = tot;
    }

    public Integer getCajId() {
        return cajId;
    }

    public void setCajId(Integer cajId) {
        this.cajId = cajId;
    }

    public Date getFec() {
        return fec;
    }

    public void setFec(Date fec) {
        this.fec = fec;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
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

    @XmlTransient
    public Collection<VtaCajr> getVtaCajrCollection() {
        return vtaCajrCollection;
    }

    public void setVtaCajrCollection(Collection<VtaCajr> vtaCajrCollection) {
        this.vtaCajrCollection = vtaCajrCollection;
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

    public VtaCajConcepto getConceptoId() {
        return conceptoId;
    }

    public void setConceptoId(VtaCajConcepto conceptoId) {
        this.conceptoId = conceptoId;
    }

    public VtaCierres getCierreId() {
        return cierreId;
    }

    public void setCierreId(VtaCierres cierreId) {
        this.cierreId = cierreId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cajId != null ? cajId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VtaCaj)) {
            return false;
        }
        VtaCaj other = (VtaCaj) object;
        if ((this.cajId == null && other.cajId != null) || (this.cajId != null && !this.cajId.equals(other.cajId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sigemp.server.entity.VtaCaj[ cajId=" + cajId + " ]";
    }
    
}
