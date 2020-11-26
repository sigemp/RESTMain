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
@Table(name = "gsy_pais")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GsyPais.findAll", query = "SELECT g FROM GsyPais g")
    , @NamedQuery(name = "GsyPais.findByPaisId", query = "SELECT g FROM GsyPais g WHERE g.paisId = :paisId")
    , @NamedQuery(name = "GsyPais.findByDes", query = "SELECT g FROM GsyPais g WHERE g.des = :des")})
public class GsyPais implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pais_id")
    private Integer paisId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "des")
    private String des;

    public GsyPais() {
    }

    public GsyPais(Integer paisId) {
        this.paisId = paisId;
    }

    public GsyPais(Integer paisId, String des) {
        this.paisId = paisId;
        this.des = des;
    }

    public Integer getPaisId() {
        return paisId;
    }

    public void setPaisId(Integer paisId) {
        this.paisId = paisId;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (paisId != null ? paisId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GsyPais)) {
            return false;
        }
        GsyPais other = (GsyPais) object;
        if ((this.paisId == null && other.paisId != null) || (this.paisId != null && !this.paisId.equals(other.paisId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sigemp.server.entity.GsyPais[ paisId=" + paisId + " ]";
    }
    
}
