/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigemp.gestion.shared.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author cristian
 */
@Entity
@Table(name = "gsy_tiposcomprobantes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GsyTiposcomprobantes.findAll", query = "SELECT g FROM GsyTiposcomprobantes g")
    , @NamedQuery(name = "GsyTiposcomprobantes.findByTcId", query = "SELECT g FROM GsyTiposcomprobantes g WHERE g.tcId = :tcId")
    , @NamedQuery(name = "GsyTiposcomprobantes.findByAbr", query = "SELECT g FROM GsyTiposcomprobantes g WHERE g.abr = :abr")
    , @NamedQuery(name = "GsyTiposcomprobantes.findByDes", query = "SELECT g FROM GsyTiposcomprobantes g WHERE g.des = :des")
    , @NamedQuery(name = "GsyTiposcomprobantes.findByLetra", query = "SELECT g FROM GsyTiposcomprobantes g WHERE g.letra = :letra")
    , @NamedQuery(name = "GsyTiposcomprobantes.findByTipo", query = "SELECT g FROM GsyTiposcomprobantes g WHERE g.tipo = :tipo")})
public class GsyTiposcomprobantes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "tc_id")
    private Integer tcId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "abr")
    private String abr;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "des")
    private String des;
    @Basic(optional = false)
    @NotNull
    @Column(name = "letra")
    private Character letra;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tipo")
    private Character tipo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tcId")
    private Collection<StkMv> stkMvCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tcId")
    private Collection<VtaCob> vtaCobCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tcId")
    private Collection<VtaVta> vtaVtaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tcId")
    private Collection<StkInventarios> stkInventariosCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tcId")
    private Collection<GsyContadorestipos> gsyContadorestiposCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tcId")
    private Collection<VtaCaj> vtaCajCollection;

    public GsyTiposcomprobantes() {
    }

    public GsyTiposcomprobantes(Integer tcId) {
        this.tcId = tcId;
    }

    public GsyTiposcomprobantes(Integer tcId, String abr, String des, Character letra, Character tipo) {
        this.tcId = tcId;
        this.abr = abr;
        this.des = des;
        this.letra = letra;
        this.tipo = tipo;
    }

    public Integer getTcId() {
        return tcId;
    }

    public void setTcId(Integer tcId) {
        this.tcId = tcId;
    }

    public String getAbr() {
        return abr;
    }

    public void setAbr(String abr) {
        this.abr = abr;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public Character getLetra() {
        return letra;
    }

    public void setLetra(Character letra) {
        this.letra = letra;
    }

    public Character getTipo() {
        return tipo;
    }

    public void setTipo(Character tipo) {
        this.tipo = tipo;
    }

    @XmlTransient
    public Collection<StkMv> getStkMvCollection() {
        return stkMvCollection;
    }

    public void setStkMvCollection(Collection<StkMv> stkMvCollection) {
        this.stkMvCollection = stkMvCollection;
    }

    @XmlTransient
    public Collection<VtaCob> getVtaCobCollection() {
        return vtaCobCollection;
    }

    public void setVtaCobCollection(Collection<VtaCob> vtaCobCollection) {
        this.vtaCobCollection = vtaCobCollection;
    }

    @XmlTransient
    public Collection<VtaVta> getVtaVtaCollection() {
        return vtaVtaCollection;
    }

    public void setVtaVtaCollection(Collection<VtaVta> vtaVtaCollection) {
        this.vtaVtaCollection = vtaVtaCollection;
    }

    @XmlTransient
    public Collection<StkInventarios> getStkInventariosCollection() {
        return stkInventariosCollection;
    }

    public void setStkInventariosCollection(Collection<StkInventarios> stkInventariosCollection) {
        this.stkInventariosCollection = stkInventariosCollection;
    }

    @XmlTransient
    public Collection<GsyContadorestipos> getGsyContadorestiposCollection() {
        return gsyContadorestiposCollection;
    }

    public void setGsyContadorestiposCollection(Collection<GsyContadorestipos> gsyContadorestiposCollection) {
        this.gsyContadorestiposCollection = gsyContadorestiposCollection;
    }

    @XmlTransient
    public Collection<VtaCaj> getVtaCajCollection() {
        return vtaCajCollection;
    }

    public void setVtaCajCollection(Collection<VtaCaj> vtaCajCollection) {
        this.vtaCajCollection = vtaCajCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tcId != null ? tcId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GsyTiposcomprobantes)) {
            return false;
        }
        GsyTiposcomprobantes other = (GsyTiposcomprobantes) object;
        if ((this.tcId == null && other.tcId != null) || (this.tcId != null && !this.tcId.equals(other.tcId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sigemp.server.entity.GsyTiposcomprobantes[ tcId=" + tcId + " ]";
    }
    
}
