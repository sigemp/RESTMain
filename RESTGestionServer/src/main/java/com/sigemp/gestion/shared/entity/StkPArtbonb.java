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
@Table(name = "stk_p_artbonb")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "StkPArtbonb.findAll", query = "SELECT s FROM StkPArtbonb s")
    , @NamedQuery(name = "StkPArtbonb.findByArtbonbId", query = "SELECT s FROM StkPArtbonb s WHERE s.artbonbId = :artbonbId")
    , @NamedQuery(name = "StkPArtbonb.findByCnt", query = "SELECT s FROM StkPArtbonb s WHERE s.cnt = :cnt")})
public class StkPArtbonb implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "artbonb_id")
    private Integer artbonbId;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "cnt")
    private BigDecimal cnt;
    @JoinColumn(name = "art_id", referencedColumnName = "art_id")
    @ManyToOne
    private StkArt artId;
    @JoinColumn(name = "proartbon_id", referencedColumnName = "proartbon_id")
    @ManyToOne
    private StkPArtbon proartbonId;

    public StkPArtbonb() {
    }

    public StkPArtbonb(Integer artbonbId) {
        this.artbonbId = artbonbId;
    }

    public StkPArtbonb(Integer artbonbId, BigDecimal cnt) {
        this.artbonbId = artbonbId;
        this.cnt = cnt;
    }

    public Integer getArtbonbId() {
        return artbonbId;
    }

    public void setArtbonbId(Integer artbonbId) {
        this.artbonbId = artbonbId;
    }

    public BigDecimal getCnt() {
        return cnt;
    }

    public void setCnt(BigDecimal cnt) {
        this.cnt = cnt;
    }

    public StkArt getArtId() {
        return artId;
    }

    public void setArtId(StkArt artId) {
        this.artId = artId;
    }

    public StkPArtbon getProartbonId() {
        return proartbonId;
    }

    public void setProartbonId(StkPArtbon proartbonId) {
        this.proartbonId = proartbonId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (artbonbId != null ? artbonbId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StkPArtbonb)) {
            return false;
        }
        StkPArtbonb other = (StkPArtbonb) object;
        if ((this.artbonbId == null && other.artbonbId != null) || (this.artbonbId != null && !this.artbonbId.equals(other.artbonbId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sigemp.server.entity.StkPArtbonb[ artbonbId=" + artbonbId + " ]";
    }
    
}
