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
@Table(name = "stk_mvr")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "StkMvr.findAll", query = "SELECT s FROM StkMvr s")
    , @NamedQuery(name = "StkMvr.findByMvrId", query = "SELECT s FROM StkMvr s WHERE s.mvrId = :mvrId")
    , @NamedQuery(name = "StkMvr.findByCnt", query = "SELECT s FROM StkMvr s WHERE s.cnt = :cnt")
    , @NamedQuery(name = "StkMvr.findByCosneto", query = "SELECT s FROM StkMvr s WHERE s.cosneto = :cosneto")
    , @NamedQuery(name = "StkMvr.findByDes", query = "SELECT s FROM StkMvr s WHERE s.des = :des")
    , @NamedQuery(name = "StkMvr.findByPrcciva", query = "SELECT s FROM StkMvr s WHERE s.prcciva = :prcciva")
    , @NamedQuery(name = "StkMvr.findByRen", query = "SELECT s FROM StkMvr s WHERE s.ren = :ren")})
public class StkMvr implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "mvr_id")
    private Integer mvrId;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "cnt")
    private BigDecimal cnt;
    @Column(name = "cosneto")
    private BigDecimal cosneto;
    @Size(max = 60)
    @Column(name = "des")
    private String des;
    @Column(name = "prcciva")
    private BigDecimal prcciva;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ren")
    private int ren;
    @JoinColumn(name = "art_id", referencedColumnName = "art_id")
    @ManyToOne(optional = false)
    private StkArt artId;
    @JoinColumn(name = "mv_id", referencedColumnName = "mv_id")
    @ManyToOne(optional = false)
    private StkMv mvId;

    public StkMvr() {
    }

    public StkMvr(Integer mvrId) {
        this.mvrId = mvrId;
    }

    public StkMvr(Integer mvrId, BigDecimal cnt, int ren) {
        this.mvrId = mvrId;
        this.cnt = cnt;
        this.ren = ren;
    }

    public Integer getMvrId() {
        return mvrId;
    }

    public void setMvrId(Integer mvrId) {
        this.mvrId = mvrId;
    }

    public BigDecimal getCnt() {
        return cnt;
    }

    public void setCnt(BigDecimal cnt) {
        this.cnt = cnt;
    }

    public BigDecimal getCosneto() {
        return cosneto;
    }

    public void setCosneto(BigDecimal cosneto) {
        this.cosneto = cosneto;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public BigDecimal getPrcciva() {
        return prcciva;
    }

    public void setPrcciva(BigDecimal prcciva) {
        this.prcciva = prcciva;
    }

    public int getRen() {
        return ren;
    }

    public void setRen(int ren) {
        this.ren = ren;
    }

    public StkArt getArtId() {
        return artId;
    }

    public void setArtId(StkArt artId) {
        this.artId = artId;
    }

    public StkMv getMvId() {
        return mvId;
    }

    public void setMvId(StkMv mvId) {
        this.mvId = mvId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (mvrId != null ? mvrId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StkMvr)) {
            return false;
        }
        StkMvr other = (StkMvr) object;
        if ((this.mvrId == null && other.mvrId != null) || (this.mvrId != null && !this.mvrId.equals(other.mvrId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sigemp.server.entity.StkMvr[ mvrId=" + mvrId + " ]";
    }
    
}
