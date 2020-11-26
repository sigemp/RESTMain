/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigemp.gestion.shared.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
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
@Table(name = "gsy_actividad")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GsyActividad.findAll", query = "SELECT g FROM GsyActividad g")
    , @NamedQuery(name = "GsyActividad.findByActividadId", query = "SELECT g FROM GsyActividad g WHERE g.actividadId = :actividadId")
    , @NamedQuery(name = "GsyActividad.findByDes", query = "SELECT g FROM GsyActividad g WHERE g.des = :des")})
public class GsyActividad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "actividad_id")
    private Integer actividadId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "des")
    private String des;
    @OneToMany(mappedBy = "actividadId")
    private Collection<StkArt> stkArtCollection;

    public GsyActividad() {
    }

    public GsyActividad(Integer actividadId) {
        this.actividadId = actividadId;
    }

    public GsyActividad(Integer actividadId, String des) {
        this.actividadId = actividadId;
        this.des = des;
    }

    public Integer getActividadId() {
        return actividadId;
    }

    public void setActividadId(Integer actividadId) {
        this.actividadId = actividadId;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (actividadId != null ? actividadId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GsyActividad)) {
            return false;
        }
        GsyActividad other = (GsyActividad) object;
        if ((this.actividadId == null && other.actividadId != null) || (this.actividadId != null && !this.actividadId.equals(other.actividadId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sigemp.server.entity.GsyActividad[ actividadId=" + actividadId + " ]";
    }
    
}
