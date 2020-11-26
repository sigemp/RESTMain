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
@Table(name = "stk_artbonificacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "StkArtbonificacion.findAll", query = "SELECT s FROM StkArtbonificacion s")
    , @NamedQuery(name = "StkArtbonificacion.findByArtbonificacion", query = "SELECT s FROM StkArtbonificacion s WHERE s.artbonificacion = :artbonificacion")
    , @NamedQuery(name = "StkArtbonificacion.findByCntBon", query = "SELECT s FROM StkArtbonificacion s WHERE s.cntBon = :cntBon")
    , @NamedQuery(name = "StkArtbonificacion.findByCntVend", query = "SELECT s FROM StkArtbonificacion s WHERE s.cntVend = :cntVend")
    , @NamedQuery(name = "StkArtbonificacion.findByEstado", query = "SELECT s FROM StkArtbonificacion s WHERE s.estado = :estado")})
public class StkArtbonificacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "artbonificacion")
    private Integer artbonificacion;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "cnt_bon")
    private BigDecimal cntBon;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cnt_vend")
    private BigDecimal cntVend;
    @Column(name = "estado")
    private Boolean estado;
    @JoinColumn(name = "ptipnegocio_id", referencedColumnName = "ptipnegocio_id")
    @ManyToOne
    private PvtaTiponegocio ptipnegocioId;
    @JoinColumn(name = "art_id", referencedColumnName = "art_id")
    @ManyToOne(optional = false)
    private StkArt artId;
    @JoinColumn(name = "art_id2", referencedColumnName = "art_id")
    @ManyToOne(optional = false)
    private StkArt artId2;

    public StkArtbonificacion() {
    }

    public StkArtbonificacion(Integer artbonificacion) {
        this.artbonificacion = artbonificacion;
    }

    public StkArtbonificacion(Integer artbonificacion, BigDecimal cntBon, BigDecimal cntVend) {
        this.artbonificacion = artbonificacion;
        this.cntBon = cntBon;
        this.cntVend = cntVend;
    }

    public Integer getArtbonificacion() {
        return artbonificacion;
    }

    public void setArtbonificacion(Integer artbonificacion) {
        this.artbonificacion = artbonificacion;
    }

    public BigDecimal getCntBon() {
        return cntBon;
    }

    public void setCntBon(BigDecimal cntBon) {
        this.cntBon = cntBon;
    }

    public BigDecimal getCntVend() {
        return cntVend;
    }

    public void setCntVend(BigDecimal cntVend) {
        this.cntVend = cntVend;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public PvtaTiponegocio getPtipnegocioId() {
        return ptipnegocioId;
    }

    public void setPtipnegocioId(PvtaTiponegocio ptipnegocioId) {
        this.ptipnegocioId = ptipnegocioId;
    }

    public StkArt getArtId() {
        return artId;
    }

    public void setArtId(StkArt artId) {
        this.artId = artId;
    }

    public StkArt getArtId2() {
        return artId2;
    }

    public void setArtId2(StkArt artId2) {
        this.artId2 = artId2;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (artbonificacion != null ? artbonificacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StkArtbonificacion)) {
            return false;
        }
        StkArtbonificacion other = (StkArtbonificacion) object;
        if ((this.artbonificacion == null && other.artbonificacion != null) || (this.artbonificacion != null && !this.artbonificacion.equals(other.artbonificacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sigemp.server.entity.StkArtbonificacion[ artbonificacion=" + artbonificacion + " ]";
    }
    
}
