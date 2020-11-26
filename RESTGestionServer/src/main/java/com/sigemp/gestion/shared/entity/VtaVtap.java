/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigemp.gestion.shared.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author cristian
 */
@Entity
@Table(name = "vta_vtap")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VtaVtap.findAll", query = "SELECT v FROM VtaVtap v")
    , @NamedQuery(name = "VtaVtap.findByVtapId", query = "SELECT v FROM VtaVtap v WHERE v.vtapId = :vtapId")
    , @NamedQuery(name = "VtaVtap.findByCuo", query = "SELECT v FROM VtaVtap v WHERE v.cuo = :cuo")
    , @NamedQuery(name = "VtaVtap.findByFecpag", query = "SELECT v FROM VtaVtap v WHERE v.fecpag = :fecpag")
    , @NamedQuery(name = "VtaVtap.findByFecvto", query = "SELECT v FROM VtaVtap v WHERE v.fecvto = :fecvto")
    , @NamedQuery(name = "VtaVtap.findByTot", query = "SELECT v FROM VtaVtap v WHERE v.tot = :tot")
    , @NamedQuery(name = "VtaVtap.findByTotent", query = "SELECT v FROM VtaVtap v WHERE v.totent = :totent")
    , @NamedQuery(name = "VtaVtap.findByTotsal", query = "SELECT v FROM VtaVtap v WHERE v.totsal = :totsal")})
public class VtaVtap implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "vtap_id")
    private Integer vtapId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cuo")
    private int cuo;
    @Column(name = "fecpag")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecpag;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecvto")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecvto;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "tot")
    private BigDecimal tot;
    @Basic(optional = false)
    @NotNull
    @Column(name = "totent")
    private BigDecimal totent;
    @Basic(optional = false)
    @NotNull
    @Column(name = "totsal")
    private BigDecimal totsal;
    @JoinColumn(name = "vta_id", referencedColumnName = "vta_id")
    @ManyToOne(optional = false)
    private VtaVta vtaId;

    public VtaVtap() {
    }

    public VtaVtap(Integer vtapId) {
        this.vtapId = vtapId;
    }

    public VtaVtap(Integer vtapId, int cuo, Date fecvto, BigDecimal tot, BigDecimal totent, BigDecimal totsal) {
        this.vtapId = vtapId;
        this.cuo = cuo;
        this.fecvto = fecvto;
        this.tot = tot;
        this.totent = totent;
        this.totsal = totsal;
    }

    public Integer getVtapId() {
        return vtapId;
    }

    public void setVtapId(Integer vtapId) {
        this.vtapId = vtapId;
    }

    public int getCuo() {
        return cuo;
    }

    public void setCuo(int cuo) {
        this.cuo = cuo;
    }

    public Date getFecpag() {
        return fecpag;
    }

    public void setFecpag(Date fecpag) {
        this.fecpag = fecpag;
    }

    public Date getFecvto() {
        return fecvto;
    }

    public void setFecvto(Date fecvto) {
        this.fecvto = fecvto;
    }

    public BigDecimal getTot() {
        return tot;
    }

    public void setTot(BigDecimal tot) {
        this.tot = tot;
    }

    public BigDecimal getTotent() {
        return totent;
    }

    public void setTotent(BigDecimal totent) {
        this.totent = totent;
    }

    public BigDecimal getTotsal() {
        return totsal;
    }

    public void setTotsal(BigDecimal totsal) {
        this.totsal = totsal;
    }

    public VtaVta getVtaId() {
        return vtaId;
    }

    public void setVtaId(VtaVta vtaId) {
        this.vtaId = vtaId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (vtapId != null ? vtapId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VtaVtap)) {
            return false;
        }
        VtaVtap other = (VtaVtap) object;
        if ((this.vtapId == null && other.vtapId != null) || (this.vtapId != null && !this.vtapId.equals(other.vtapId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sigemp.server.entity.VtaVtap[ vtapId=" + vtapId + " ]";
    }
    
}
