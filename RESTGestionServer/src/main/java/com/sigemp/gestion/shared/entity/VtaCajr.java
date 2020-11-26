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
@Table(name = "vta_cajr")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VtaCajr.findAll", query = "SELECT v FROM VtaCajr v")
    , @NamedQuery(name = "VtaCajr.findByCajrId", query = "SELECT v FROM VtaCajr v WHERE v.cajrId = :cajrId")
    , @NamedQuery(name = "VtaCajr.findByTipo", query = "SELECT v FROM VtaCajr v WHERE v.tipo = :tipo")
    , @NamedQuery(name = "VtaCajr.findByTot", query = "SELECT v FROM VtaCajr v WHERE v.tot = :tot")})
public class VtaCajr implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cajr_id")
    private Integer cajrId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "tipo")
    private String tipo;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "tot")
    private BigDecimal tot;
    @JoinColumn(name = "caj_id", referencedColumnName = "caj_id")
    @ManyToOne(optional = false)
    private VtaCaj cajId;
    @JoinColumn(name = "mc_id", referencedColumnName = "mc_id")
    @ManyToOne(optional = false)
    private VtaMc mcId;

    public VtaCajr() {
    }

    public VtaCajr(Integer cajrId) {
        this.cajrId = cajrId;
    }

    public VtaCajr(Integer cajrId, String tipo) {
        this.cajrId = cajrId;
        this.tipo = tipo;
    }

    public Integer getCajrId() {
        return cajrId;
    }

    public void setCajrId(Integer cajrId) {
        this.cajrId = cajrId;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public BigDecimal getTot() {
        return tot;
    }

    public void setTot(BigDecimal tot) {
        this.tot = tot;
    }

    public VtaCaj getCajId() {
        return cajId;
    }

    public void setCajId(VtaCaj cajId) {
        this.cajId = cajId;
    }

    public VtaMc getMcId() {
        return mcId;
    }

    public void setMcId(VtaMc mcId) {
        this.mcId = mcId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cajrId != null ? cajrId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VtaCajr)) {
            return false;
        }
        VtaCajr other = (VtaCajr) object;
        if ((this.cajrId == null && other.cajrId != null) || (this.cajrId != null && !this.cajrId.equals(other.cajrId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sigemp.server.entity.VtaCajr[ cajrId=" + cajrId + " ]";
    }
    
}
