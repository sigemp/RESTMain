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
@Table(name = "pvta_repartidor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PvtaRepartidor.findAll", query = "SELECT p FROM PvtaRepartidor p")
    , @NamedQuery(name = "PvtaRepartidor.findByReparId", query = "SELECT p FROM PvtaRepartidor p WHERE p.reparId = :reparId")
    , @NamedQuery(name = "PvtaRepartidor.findByNom", query = "SELECT p FROM PvtaRepartidor p WHERE p.nom = :nom")})
public class PvtaRepartidor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "repar_id")
    private Integer reparId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "nom")
    private String nom;

    public PvtaRepartidor() {
    }

    public PvtaRepartidor(Integer reparId) {
        this.reparId = reparId;
    }

    public PvtaRepartidor(Integer reparId, String nom) {
        this.reparId = reparId;
        this.nom = nom;
    }

    public Integer getReparId() {
        return reparId;
    }

    public void setReparId(Integer reparId) {
        this.reparId = reparId;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (reparId != null ? reparId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PvtaRepartidor)) {
            return false;
        }
        PvtaRepartidor other = (PvtaRepartidor) object;
        if ((this.reparId == null && other.reparId != null) || (this.reparId != null && !this.reparId.equals(other.reparId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sigemp.server.entity.PvtaRepartidor[ reparId=" + reparId + " ]";
    }
    
}
