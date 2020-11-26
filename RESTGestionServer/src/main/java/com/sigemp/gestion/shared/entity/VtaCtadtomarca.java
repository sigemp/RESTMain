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
@Table(name = "vta_ctadtomarca")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VtaCtadtomarca.findAll", query = "SELECT v FROM VtaCtadtomarca v")
    , @NamedQuery(name = "VtaCtadtomarca.findByCtadtomarcaId", query = "SELECT v FROM VtaCtadtomarca v WHERE v.ctadtomarcaId = :ctadtomarcaId")
    , @NamedQuery(name = "VtaCtadtomarca.findByDto", query = "SELECT v FROM VtaCtadtomarca v WHERE v.dto = :dto")})
public class VtaCtadtomarca implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ctadtomarca_id")
    private Integer ctadtomarcaId;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "dto")
    private BigDecimal dto;
    @JoinColumn(name = "mar_id", referencedColumnName = "mar_id")
    @ManyToOne(optional = false)
    private StkMar marId;
    @JoinColumn(name = "cta_id", referencedColumnName = "cta_id")
    @ManyToOne(optional = false)
    private VtaCta ctaId;

    public VtaCtadtomarca() {
    }

    public VtaCtadtomarca(Integer ctadtomarcaId) {
        this.ctadtomarcaId = ctadtomarcaId;
    }

    public VtaCtadtomarca(Integer ctadtomarcaId, BigDecimal dto) {
        this.ctadtomarcaId = ctadtomarcaId;
        this.dto = dto;
    }

    public Integer getCtadtomarcaId() {
        return ctadtomarcaId;
    }

    public void setCtadtomarcaId(Integer ctadtomarcaId) {
        this.ctadtomarcaId = ctadtomarcaId;
    }

    public BigDecimal getDto() {
        return dto;
    }

    public void setDto(BigDecimal dto) {
        this.dto = dto;
    }

    public StkMar getMarId() {
        return marId;
    }

    public void setMarId(StkMar marId) {
        this.marId = marId;
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
        hash += (ctadtomarcaId != null ? ctadtomarcaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VtaCtadtomarca)) {
            return false;
        }
        VtaCtadtomarca other = (VtaCtadtomarca) object;
        if ((this.ctadtomarcaId == null && other.ctadtomarcaId != null) || (this.ctadtomarcaId != null && !this.ctadtomarcaId.equals(other.ctadtomarcaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sigemp.server.entity.VtaCtadtomarca[ ctadtomarcaId=" + ctadtomarcaId + " ]";
    }
    
}
