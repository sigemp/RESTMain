/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigemp.gestion.shared.entity;

import java.io.Serializable;
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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author cristian
 */
@Entity
@Table(name = "vta_vtag")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VtaVtag.findAll", query = "SELECT v FROM VtaVtag v")
    , @NamedQuery(name = "VtaVtag.findByVtagId", query = "SELECT v FROM VtaVtag v WHERE v.vtagId = :vtagId")})
public class VtaVtag implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "vtag_id")
    private Integer vtagId;
    @JoinColumn(name = "cta_id", referencedColumnName = "cta_id")
    @ManyToOne(optional = false)
    private VtaCta ctaId;
    @JoinColumn(name = "vta_id", referencedColumnName = "vta_id")
    @ManyToOne(optional = false)
    private VtaVta vtaId;

    public VtaVtag() {
    }

    public VtaVtag(Integer vtagId) {
        this.vtagId = vtagId;
    }

    public Integer getVtagId() {
        return vtagId;
    }

    public void setVtagId(Integer vtagId) {
        this.vtagId = vtagId;
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
        hash += (vtagId != null ? vtagId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VtaVtag)) {
            return false;
        }
        VtaVtag other = (VtaVtag) object;
        if ((this.vtagId == null && other.vtagId != null) || (this.vtagId != null && !this.vtagId.equals(other.vtagId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sigemp.server.entity.VtaVtag[ vtagId=" + vtagId + " ]";
    }
    
}
