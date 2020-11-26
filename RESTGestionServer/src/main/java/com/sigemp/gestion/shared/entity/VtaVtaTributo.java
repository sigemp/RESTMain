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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author cristian
 */
@Entity
@Table(name = "vta_vta_tributo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VtaVtaTributo.findAll", query = "SELECT v FROM VtaVtaTributo v")
    , @NamedQuery(name = "VtaVtaTributo.findByVtaTribId", query = "SELECT v FROM VtaVtaTributo v WHERE v.vtaTribId = :vtaTribId")
    , @NamedQuery(name = "VtaVtaTributo.findByAlicuota", query = "SELECT v FROM VtaVtaTributo v WHERE v.alicuota = :alicuota")
    , @NamedQuery(name = "VtaVtaTributo.findByBaseImponible", query = "SELECT v FROM VtaVtaTributo v WHERE v.baseImponible = :baseImponible")
    , @NamedQuery(name = "VtaVtaTributo.findByDes", query = "SELECT v FROM VtaVtaTributo v WHERE v.des = :des")
    , @NamedQuery(name = "VtaVtaTributo.findByTotal", query = "SELECT v FROM VtaVtaTributo v WHERE v.total = :total")
    , @NamedQuery(name = "VtaVtaTributo.findByTribId", query = "SELECT v FROM VtaVtaTributo v WHERE v.tribId = :tribId")})
public class VtaVtaTributo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "vta_trib_id")
    private Integer vtaTribId;
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
    @Size(min = 1, max = 60)
    @Column(name = "des")
    private String des;
    @Basic(optional = false)
    @NotNull
    @Column(name = "total")
    private BigDecimal total;
    @Basic(optional = false)
    @NotNull
    @Column(name = "trib_id")
    private int tribId;
    @JoinColumn(name = "vta_id", referencedColumnName = "vta_id")
    @ManyToOne(optional = false)
    private VtaVta vtaId;

    public VtaVtaTributo() {
    }

    public VtaVtaTributo(Integer vtaTribId) {
        this.vtaTribId = vtaTribId;
    }

    public VtaVtaTributo(Integer vtaTribId, BigDecimal alicuota, BigDecimal baseImponible, String des, BigDecimal total, int tribId) {
        this.vtaTribId = vtaTribId;
        this.alicuota = alicuota;
        this.baseImponible = baseImponible;
        this.des = des;
        this.total = total;
        this.tribId = tribId;
    }

    public Integer getVtaTribId() {
        return vtaTribId;
    }

    public void setVtaTribId(Integer vtaTribId) {
        this.vtaTribId = vtaTribId;
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

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public int getTribId() {
        return tribId;
    }

    public void setTribId(int tribId) {
        this.tribId = tribId;
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
        hash += (vtaTribId != null ? vtaTribId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VtaVtaTributo)) {
            return false;
        }
        VtaVtaTributo other = (VtaVtaTributo) object;
        if ((this.vtaTribId == null && other.vtaTribId != null) || (this.vtaTribId != null && !this.vtaTribId.equals(other.vtaTribId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sigemp.server.entity.VtaVtaTributo[ vtaTribId=" + vtaTribId + " ]";
    }
    
}
