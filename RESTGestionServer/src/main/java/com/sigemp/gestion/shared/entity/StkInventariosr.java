/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigemp.gestion.shared.entity;

import java.io.Serializable;
import java.math.BigDecimal;
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
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author cristian
 */
@Entity
@Table(name = "stk_inventariosr")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "StkInventariosr.findAll", query = "SELECT s FROM StkInventariosr s")
    , @NamedQuery(name = "StkInventariosr.findByInvrId", query = "SELECT s FROM StkInventariosr s WHERE s.invrId = :invrId")
    , @NamedQuery(name = "StkInventariosr.findByCnt", query = "SELECT s FROM StkInventariosr s WHERE s.cnt = :cnt")
    , @NamedQuery(name = "StkInventariosr.findByFec", query = "SELECT s FROM StkInventariosr s WHERE s.fec = :fec")
    , @NamedQuery(name = "StkInventariosr.findByRen", query = "SELECT s FROM StkInventariosr s WHERE s.ren = :ren")})
public class StkInventariosr implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "invr_id")
    private Integer invrId;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "cnt")
    private BigDecimal cnt;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fec")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fec;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ren")
    private int ren;
    @JoinColumn(name = "art_id", referencedColumnName = "art_id")
    @ManyToOne(optional = false)
    private StkArt artId;
    @JoinColumn(name = "inv_id", referencedColumnName = "inv_id")
    @ManyToOne(optional = false)
    private StkInventarios invId;

    public StkInventariosr() {
    }

    public StkInventariosr(Integer invrId) {
        this.invrId = invrId;
    }

    public StkInventariosr(Integer invrId, BigDecimal cnt, Date fec, int ren) {
        this.invrId = invrId;
        this.cnt = cnt;
        this.fec = fec;
        this.ren = ren;
    }

    public Integer getInvrId() {
        return invrId;
    }

    public void setInvrId(Integer invrId) {
        this.invrId = invrId;
    }

    public BigDecimal getCnt() {
        return cnt;
    }

    public void setCnt(BigDecimal cnt) {
        this.cnt = cnt;
    }

    public Date getFec() {
        return fec;
    }

    public void setFec(Date fec) {
        this.fec = fec;
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

    public StkInventarios getInvId() {
        return invId;
    }

    public void setInvId(StkInventarios invId) {
        this.invId = invId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (invrId != null ? invrId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StkInventariosr)) {
            return false;
        }
        StkInventariosr other = (StkInventariosr) object;
        if ((this.invrId == null && other.invrId != null) || (this.invrId != null && !this.invrId.equals(other.invrId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sigemp.server.entity.StkInventariosr[ invrId=" + invrId + " ]";
    }
    
}
