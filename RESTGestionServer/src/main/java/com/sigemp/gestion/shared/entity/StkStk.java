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
@Table(name = "stk_stk")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "StkStk.findAll", query = "SELECT s FROM StkStk s")
    , @NamedQuery(name = "StkStk.findByStkstkId", query = "SELECT s FROM StkStk s WHERE s.stkstkId = :stkstkId")
    , @NamedQuery(name = "StkStk.findByCnt", query = "SELECT s FROM StkStk s WHERE s.cnt = :cnt")})
public class StkStk implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "stkstk_id")
    private Integer stkstkId;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "cnt")
    private BigDecimal cnt;
    @JoinColumn(name = "art_id", referencedColumnName = "art_id")
    @ManyToOne(optional = false)
    private StkArt artId;
    @JoinColumn(name = "depo_id", referencedColumnName = "depo_id")
    @ManyToOne(optional = false)
    private StkDepositos depoId;

    public StkStk() {
    }

    public StkStk(Integer stkstkId) {
        this.stkstkId = stkstkId;
    }

    public StkStk(Integer stkstkId, BigDecimal cnt) {
        this.stkstkId = stkstkId;
        this.cnt = cnt;
    }

    public Integer getStkstkId() {
        return stkstkId;
    }

    public void setStkstkId(Integer stkstkId) {
        this.stkstkId = stkstkId;
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

    public StkDepositos getDepoId() {
        return depoId;
    }

    public void setDepoId(StkDepositos depoId) {
        this.depoId = depoId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (stkstkId != null ? stkstkId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StkStk)) {
            return false;
        }
        StkStk other = (StkStk) object;
        if ((this.stkstkId == null && other.stkstkId != null) || (this.stkstkId != null && !this.stkstkId.equals(other.stkstkId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sigemp.server.entity.StkStk[ stkstkId=" + stkstkId + " ]";
    }
    
}
