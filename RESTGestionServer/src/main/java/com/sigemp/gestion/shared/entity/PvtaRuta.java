/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigemp.gestion.shared.entity;

import java.io.Serializable;
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
@Table(name = "pvta_ruta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PvtaRuta.findAll", query = "SELECT p FROM PvtaRuta p")
    , @NamedQuery(name = "PvtaRuta.findByRutaId", query = "SELECT p FROM PvtaRuta p WHERE p.rutaId = :rutaId")
    , @NamedQuery(name = "PvtaRuta.findByDes", query = "SELECT p FROM PvtaRuta p WHERE p.des = :des")
    , @NamedQuery(name = "PvtaRuta.findByObs", query = "SELECT p FROM PvtaRuta p WHERE p.obs = :obs")})
public class PvtaRuta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ruta_id")
    private Integer rutaId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "des")
    private String des;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 400)
    @Column(name = "obs")
    private String obs;
    @JoinColumn(name = "repar_id", referencedColumnName = "repar_id")
    @ManyToOne
    private PvtaRepartidor reparId;
    @JoinColumn(name = "ven_id", referencedColumnName = "ven_id")
    @ManyToOne(optional = false)
    private VtaVen venId;

    public PvtaRuta() {
    }

    public PvtaRuta(Integer rutaId) {
        this.rutaId = rutaId;
    }

    public PvtaRuta(Integer rutaId, String des, String obs) {
        this.rutaId = rutaId;
        this.des = des;
        this.obs = obs;
    }

    public Integer getRutaId() {
        return rutaId;
    }

    public void setRutaId(Integer rutaId) {
        this.rutaId = rutaId;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public PvtaRepartidor getReparId() {
        return reparId;
    }

    public void setReparId(PvtaRepartidor reparId) {
        this.reparId = reparId;
    }

    public VtaVen getVenId() {
        return venId;
    }

    public void setVenId(VtaVen venId) {
        this.venId = venId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rutaId != null ? rutaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PvtaRuta)) {
            return false;
        }
        PvtaRuta other = (PvtaRuta) object;
        if ((this.rutaId == null && other.rutaId != null) || (this.rutaId != null && !this.rutaId.equals(other.rutaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sigemp.server.entity.PvtaRuta[ rutaId=" + rutaId + " ]";
    }
    
}
