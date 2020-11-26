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
@Table(name = "gsy_estcivil")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GsyEstcivil.findAll", query = "SELECT g FROM GsyEstcivil g")
    , @NamedQuery(name = "GsyEstcivil.findByEstcId", query = "SELECT g FROM GsyEstcivil g WHERE g.estcId = :estcId")
    , @NamedQuery(name = "GsyEstcivil.findByDes", query = "SELECT g FROM GsyEstcivil g WHERE g.des = :des")})
public class GsyEstcivil implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "estc_id")
    private Integer estcId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "des")
    private String des;

    public GsyEstcivil() {
    }

    public GsyEstcivil(Integer estcId) {
        this.estcId = estcId;
    }

    public GsyEstcivil(Integer estcId, String des) {
        this.estcId = estcId;
        this.des = des;
    }

    public Integer getEstcId() {
        return estcId;
    }

    public void setEstcId(Integer estcId) {
        this.estcId = estcId;
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
        hash += (estcId != null ? estcId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GsyEstcivil)) {
            return false;
        }
        GsyEstcivil other = (GsyEstcivil) object;
        if ((this.estcId == null && other.estcId != null) || (this.estcId != null && !this.estcId.equals(other.estcId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sigemp.server.entity.GsyEstcivil[ estcId=" + estcId + " ]";
    }
    
}
