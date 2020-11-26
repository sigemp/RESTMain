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
@Table(name = "stk_p_artbona")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "StkPArtbona.findAll", query = "SELECT s FROM StkPArtbona s")
    , @NamedQuery(name = "StkPArtbona.findByArtbonaId", query = "SELECT s FROM StkPArtbona s WHERE s.artbonaId = :artbonaId")
    , @NamedQuery(name = "StkPArtbona.findByCnt", query = "SELECT s FROM StkPArtbona s WHERE s.cnt = :cnt")})
public class StkPArtbona implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "artbona_id")
    private Integer artbonaId;
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

    public StkPArtbona() {
    }

    public StkPArtbona(Integer artbonaId) {
        this.artbonaId = artbonaId;
    }

    public StkPArtbona(Integer artbonaId, BigDecimal cnt) {
        this.artbonaId = artbonaId;
        this.cnt = cnt;
    }

    public Integer getArtbonaId() {
        return artbonaId;
    }

    public void setArtbonaId(Integer artbonaId) {
        this.artbonaId = artbonaId;
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
        hash += (artbonaId != null ? artbonaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StkPArtbona)) {
            return false;
        }
        StkPArtbona other = (StkPArtbona) object;
        if ((this.artbonaId == null && other.artbonaId != null) || (this.artbonaId != null && !this.artbonaId.equals(other.artbonaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sigemp.server.entity.StkPArtbona[ artbonaId=" + artbonaId + " ]";
    }
    
}
