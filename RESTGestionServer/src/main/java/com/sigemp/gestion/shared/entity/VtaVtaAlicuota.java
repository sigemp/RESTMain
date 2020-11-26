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
@Table(name = "vta_vta_alicuota")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VtaVtaAlicuota.findAll", query = "SELECT v FROM VtaVtaAlicuota v")
    , @NamedQuery(name = "VtaVtaAlicuota.findByVtaAlicuotaId", query = "SELECT v FROM VtaVtaAlicuota v WHERE v.vtaAlicuotaId = :vtaAlicuotaId")
    , @NamedQuery(name = "VtaVtaAlicuota.findByAlicuota", query = "SELECT v FROM VtaVtaAlicuota v WHERE v.alicuota = :alicuota")
    , @NamedQuery(name = "VtaVtaAlicuota.findByBaseImponible", query = "SELECT v FROM VtaVtaAlicuota v WHERE v.baseImponible = :baseImponible")
    , @NamedQuery(name = "VtaVtaAlicuota.findByTivaId", query = "SELECT v FROM VtaVtaAlicuota v WHERE v.tivaId = :tivaId")
    , @NamedQuery(name = "VtaVtaAlicuota.findByTotal", query = "SELECT v FROM VtaVtaAlicuota v WHERE v.total = :total")})
public class VtaVtaAlicuota implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "vta_alicuota_id")
    private Integer vtaAlicuotaId;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "alicuota")
    private BigDecimal alicuota;
    @Basic(optional = false)
    @NotNull
    @Column(name = "base_imponible")
    private BigDecimal baseImponible;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tiva_id")
    private int tivaId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "total")
    private BigDecimal total;
    @JoinColumn(name = "vta_id", referencedColumnName = "vta_id")
    @ManyToOne(optional = false)
    private VtaVta vtaId;

    public VtaVtaAlicuota() {
    }

    public VtaVtaAlicuota(Integer vtaAlicuotaId) {
        this.vtaAlicuotaId = vtaAlicuotaId;
    }

    public VtaVtaAlicuota(Integer vtaAlicuotaId, BigDecimal alicuota, BigDecimal baseImponible, int tivaId, BigDecimal total) {
        this.vtaAlicuotaId = vtaAlicuotaId;
        this.alicuota = alicuota;
        this.baseImponible = baseImponible;
        this.tivaId = tivaId;
        this.total = total;
    }

    public Integer getVtaAlicuotaId() {
        return vtaAlicuotaId;
    }

    public void setVtaAlicuotaId(Integer vtaAlicuotaId) {
        this.vtaAlicuotaId = vtaAlicuotaId;
    }

    public BigDecimal getAlicuota() {
        return alicuota;
    }

    public void setAlicuota(BigDecimal alicuota) {
        this.alicuota = alicuota;
    }

    public BigDecimal getBaseImponible() {
        return baseImponible;
    }

    public void setBaseImponible(BigDecimal baseImponible) {
        this.baseImponible = baseImponible;
    }

    public int getTivaId() {
        return tivaId;
    }

    public void setTivaId(int tivaId) {
        this.tivaId = tivaId;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
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
        hash += (vtaAlicuotaId != null ? vtaAlicuotaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VtaVtaAlicuota)) {
            return false;
        }
        VtaVtaAlicuota other = (VtaVtaAlicuota) object;
        if ((this.vtaAlicuotaId == null && other.vtaAlicuotaId != null) || (this.vtaAlicuotaId != null && !this.vtaAlicuotaId.equals(other.vtaAlicuotaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sigemp.server.entity.VtaVtaAlicuota[ vtaAlicuotaId=" + vtaAlicuotaId + " ]";
    }
    
}
