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
@Table(name = "stk_artdescuentos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "StkArtdescuentos.findAll", query = "SELECT s FROM StkArtdescuentos s")
    , @NamedQuery(name = "StkArtdescuentos.findByArtdescuentosId", query = "SELECT s FROM StkArtdescuentos s WHERE s.artdescuentosId = :artdescuentosId")
    , @NamedQuery(name = "StkArtdescuentos.findByDescuento", query = "SELECT s FROM StkArtdescuentos s WHERE s.descuento = :descuento")
    , @NamedQuery(name = "StkArtdescuentos.findByDesde", query = "SELECT s FROM StkArtdescuentos s WHERE s.desde = :desde")
    , @NamedQuery(name = "StkArtdescuentos.findByHasta", query = "SELECT s FROM StkArtdescuentos s WHERE s.hasta = :hasta")})
public class StkArtdescuentos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "artdescuentos_id")
    private Integer artdescuentosId;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "descuento")
    private BigDecimal descuento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "desde")
    private BigDecimal desde;
    @Basic(optional = false)
    @NotNull
    @Column(name = "hasta")
    private BigDecimal hasta;
    @JoinColumn(name = "art_id", referencedColumnName = "art_id")
    @ManyToOne(optional = false)
    private StkArt artId;

    public StkArtdescuentos() {
    }

    public StkArtdescuentos(Integer artdescuentosId) {
        this.artdescuentosId = artdescuentosId;
    }

    public StkArtdescuentos(Integer artdescuentosId, BigDecimal descuento, BigDecimal desde, BigDecimal hasta) {
        this.artdescuentosId = artdescuentosId;
        this.descuento = descuento;
        this.desde = desde;
        this.hasta = hasta;
    }

    public Integer getArtdescuentosId() {
        return artdescuentosId;
    }

    public void setArtdescuentosId(Integer artdescuentosId) {
        this.artdescuentosId = artdescuentosId;
    }

    public BigDecimal getDescuento() {
        return descuento;
    }

    public void setDescuento(BigDecimal descuento) {
        this.descuento = descuento;
    }

    public BigDecimal getDesde() {
        return desde;
    }

    public void setDesde(BigDecimal desde) {
        this.desde = desde;
    }

    public BigDecimal getHasta() {
        return hasta;
    }

    public void setHasta(BigDecimal hasta) {
        this.hasta = hasta;
    }

    public StkArt getArtId() {
        return artId;
    }

    public void setArtId(StkArt artId) {
        this.artId = artId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (artdescuentosId != null ? artdescuentosId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StkArtdescuentos)) {
            return false;
        }
        StkArtdescuentos other = (StkArtdescuentos) object;
        if ((this.artdescuentosId == null && other.artdescuentosId != null) || (this.artdescuentosId != null && !this.artdescuentosId.equals(other.artdescuentosId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sigemp.server.entity.StkArtdescuentos[ artdescuentosId=" + artdescuentosId + " ]";
    }
    
}
