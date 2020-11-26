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
@Table(name = "vta_ctadtorubro")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VtaCtadtorubro.findAll", query = "SELECT v FROM VtaCtadtorubro v")
    , @NamedQuery(name = "VtaCtadtorubro.findByCtadtorubroId", query = "SELECT v FROM VtaCtadtorubro v WHERE v.ctadtorubroId = :ctadtorubroId")
    , @NamedQuery(name = "VtaCtadtorubro.findByDto", query = "SELECT v FROM VtaCtadtorubro v WHERE v.dto = :dto")})
public class VtaCtadtorubro implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ctadtorubro_id")
    private Integer ctadtorubroId;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "dto")
    private BigDecimal dto;
    @JoinColumn(name = "dep_id", referencedColumnName = "dep_id")
    @ManyToOne(optional = false)
    private StkDep depId;
    @JoinColumn(name = "cta_id", referencedColumnName = "cta_id")
    @ManyToOne(optional = false)
    private VtaCta ctaId;

    public VtaCtadtorubro() {
    }

    public VtaCtadtorubro(Integer ctadtorubroId) {
        this.ctadtorubroId = ctadtorubroId;
    }

    public VtaCtadtorubro(Integer ctadtorubroId, BigDecimal dto) {
        this.ctadtorubroId = ctadtorubroId;
        this.dto = dto;
    }

    public Integer getCtadtorubroId() {
        return ctadtorubroId;
    }

    public void setCtadtorubroId(Integer ctadtorubroId) {
        this.ctadtorubroId = ctadtorubroId;
    }

    public BigDecimal getDto() {
        return dto;
    }

    public void setDto(BigDecimal dto) {
        this.dto = dto;
    }

    public StkDep getDepId() {
        return depId;
    }

    public void setDepId(StkDep depId) {
        this.depId = depId;
    }

    public VtaCta getCtaId() {
        return ctaId;
    }

    public void setCtaId(VtaCta ctaId) {
        this.ctaId = ctaId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ctadtorubroId != null ? ctadtorubroId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VtaCtadtorubro)) {
            return false;
        }
        VtaCtadtorubro other = (VtaCtadtorubro) object;
        if ((this.ctadtorubroId == null && other.ctadtorubroId != null) || (this.ctadtorubroId != null && !this.ctadtorubroId.equals(other.ctadtorubroId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sigemp.server.entity.VtaCtadtorubro[ ctadtorubroId=" + ctadtorubroId + " ]";
    }
    
}
