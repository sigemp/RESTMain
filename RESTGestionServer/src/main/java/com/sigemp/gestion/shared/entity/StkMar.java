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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "stk_mar")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "StkMar.findAll", query = "SELECT s FROM StkMar s")
    , @NamedQuery(name = "StkMar.findByMarId", query = "SELECT s FROM StkMar s WHERE s.marId = :marId")
    , @NamedQuery(name = "StkMar.findByDes", query = "SELECT s FROM StkMar s WHERE s.des = :des")})
public class StkMar implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "mar_id")
    private Integer marId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "des")
    private String des;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "marId")
    private Collection<StkArt> stkArtCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "marId")
    private Collection<VtaCtadtomarca> vtaCtadtomarcaCollection;

    public StkMar() {
    }

    public StkMar(Integer marId) {
        this.marId = marId;
    }

    public StkMar(Integer marId, String des) {
        this.marId = marId;
        this.des = des;
    }

    public Integer getMarId() {
        return marId;
    }

    public void setMarId(Integer marId) {
        this.marId = marId;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    @XmlTransient
    public Collection<StkArt> getStkArtCollection() {
        return stkArtCollection;
    }

    public void setStkArtCollection(Collection<StkArt> stkArtCollection) {
        this.stkArtCollection = stkArtCollection;
    }

    @XmlTransient
    public Collection<VtaCtadtomarca> getVtaCtadtomarcaCollection() {
        return vtaCtadtomarcaCollection;
    }

    public void setVtaCtadtomarcaCollection(Collection<VtaCtadtomarca> vtaCtadtomarcaCollection) {
        this.vtaCtadtomarcaCollection = vtaCtadtomarcaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (marId != null ? marId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StkMar)) {
            return false;
        }
        StkMar other = (StkMar) object;
        if ((this.marId == null && other.marId != null) || (this.marId != null && !this.marId.equals(other.marId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sigemp.server.entity.StkMar[ marId=" + marId + " ]";
    }
    
}
