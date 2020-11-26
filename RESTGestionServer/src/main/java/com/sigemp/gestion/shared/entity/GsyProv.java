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
@Table(name = "gsy_prov")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GsyProv.findAll", query = "SELECT g FROM GsyProv g")
    , @NamedQuery(name = "GsyProv.findByProvId", query = "SELECT g FROM GsyProv g WHERE g.provId = :provId")
    , @NamedQuery(name = "GsyProv.findByDes", query = "SELECT g FROM GsyProv g WHERE g.des = :des")})
public class GsyProv implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "prov_id")
    private Integer provId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "des")
    private String des;

    public GsyProv() {
    }

    public GsyProv(Integer provId) {
        this.provId = provId;
    }

    public GsyProv(Integer provId, String des) {
        this.provId = provId;
        this.des = des;
    }

    public Integer getProvId() {
        return provId;
    }

    public void setProvId(Integer provId) {
        this.provId = provId;
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
        hash += (provId != null ? provId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GsyProv)) {
            return false;
        }
        GsyProv other = (GsyProv) object;
        if ((this.provId == null && other.provId != null) || (this.provId != null && !this.provId.equals(other.provId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sigemp.server.entity.GsyProv[ provId=" + provId + " ]";
    }
    
}
