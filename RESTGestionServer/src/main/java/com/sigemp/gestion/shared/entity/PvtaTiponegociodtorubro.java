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
@Table(name = "pvta_tiponegociodtorubro")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PvtaTiponegociodtorubro.findAll", query = "SELECT p FROM PvtaTiponegociodtorubro p")
    , @NamedQuery(name = "PvtaTiponegociodtorubro.findByTipnegdtorubroId", query = "SELECT p FROM PvtaTiponegociodtorubro p WHERE p.tipnegdtorubroId = :tipnegdtorubroId")
    , @NamedQuery(name = "PvtaTiponegociodtorubro.findByDto", query = "SELECT p FROM PvtaTiponegociodtorubro p WHERE p.dto = :dto")})
public class PvtaTiponegociodtorubro implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "tipnegdtorubro_id")
    private Integer tipnegdtorubroId;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "dto")
    private BigDecimal dto;
    @JoinColumn(name = "ptipnegocio_id", referencedColumnName = "ptipnegocio_id")
    @ManyToOne(optional = false)
    private PvtaTiponegocio ptipnegocioId;
    @JoinColumn(name = "dep_id", referencedColumnName = "dep_id")
    @ManyToOne(optional = false)
    private StkDep depId;

    public PvtaTiponegociodtorubro() {
    }

    public PvtaTiponegociodtorubro(Integer tipnegdtorubroId) {
        this.tipnegdtorubroId = tipnegdtorubroId;
    }

    public PvtaTiponegociodtorubro(Integer tipnegdtorubroId, BigDecimal dto) {
        this.tipnegdtorubroId = tipnegdtorubroId;
        this.dto = dto;
    }

    public Integer getTipnegdtorubroId() {
        return tipnegdtorubroId;
    }

    public void setTipnegdtorubroId(Integer tipnegdtorubroId) {
        this.tipnegdtorubroId = tipnegdtorubroId;
    }

    public BigDecimal getDto() {
        return dto;
    }

    public void setDto(BigDecimal dto) {
        this.dto = dto;
    }

    public PvtaTiponegocio getPtipnegocioId() {
        return ptipnegocioId;
    }

    public void setPtipnegocioId(PvtaTiponegocio ptipnegocioId) {
        this.ptipnegocioId = ptipnegocioId;
    }

    public StkDep getDepId() {
        return depId;
    }

    public void setDepId(StkDep depId) {
        this.depId = depId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tipnegdtorubroId != null ? tipnegdtorubroId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PvtaTiponegociodtorubro)) {
            return false;
        }
        PvtaTiponegociodtorubro other = (PvtaTiponegociodtorubro) object;
        if ((this.tipnegdtorubroId == null && other.tipnegdtorubroId != null) || (this.tipnegdtorubroId != null && !this.tipnegdtorubroId.equals(other.tipnegdtorubroId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sigemp.server.entity.PvtaTiponegociodtorubro[ tipnegdtorubroId=" + tipnegdtorubroId + " ]";
    }
    
}
