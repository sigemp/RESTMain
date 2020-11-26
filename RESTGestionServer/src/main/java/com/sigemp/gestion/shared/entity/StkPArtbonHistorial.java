/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigemp.gestion.shared.entity;

import java.io.Serializable;
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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author cristian
 */
@Entity
@Table(name = "stk_p_artbon_historial")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "StkPArtbonHistorial.findAll", query = "SELECT s FROM StkPArtbonHistorial s")
    , @NamedQuery(name = "StkPArtbonHistorial.findByArtbonhisId", query = "SELECT s FROM StkPArtbonHistorial s WHERE s.artbonhisId = :artbonhisId")
    , @NamedQuery(name = "StkPArtbonHistorial.findByFec", query = "SELECT s FROM StkPArtbonHistorial s WHERE s.fec = :fec")})
public class StkPArtbonHistorial implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "artbonhis_id")
    private Integer artbonhisId;
    @Column(name = "fec")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fec;
    @JoinColumn(name = "proartbon_id", referencedColumnName = "proartbon_id")
    @ManyToOne
    private StkPArtbon proartbonId;
    @JoinColumn(name = "cta_id", referencedColumnName = "cta_id")
    @ManyToOne
    private VtaCta ctaId;
    @JoinColumn(name = "vta_id", referencedColumnName = "vta_id")
    @ManyToOne
    private VtaVta vtaId;

    public StkPArtbonHistorial() {
    }

    public StkPArtbonHistorial(Integer artbonhisId) {
        this.artbonhisId = artbonhisId;
    }

    public Integer getArtbonhisId() {
        return artbonhisId;
    }

    public void setArtbonhisId(Integer artbonhisId) {
        this.artbonhisId = artbonhisId;
    }

    public Date getFec() {
        return fec;
    }

    public void setFec(Date fec) {
        this.fec = fec;
    }

    public StkPArtbon getProartbonId() {
        return proartbonId;
    }

    public void setProartbonId(StkPArtbon proartbonId) {
        this.proartbonId = proartbonId;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (artbonhisId != null ? artbonhisId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StkPArtbonHistorial)) {
            return false;
        }
        StkPArtbonHistorial other = (StkPArtbonHistorial) object;
        if ((this.artbonhisId == null && other.artbonhisId != null) || (this.artbonhisId != null && !this.artbonhisId.equals(other.artbonhisId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sigemp.server.entity.StkPArtbonHistorial[ artbonhisId=" + artbonhisId + " ]";
    }
    
}
