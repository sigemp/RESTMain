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
@Table(name = "gsy_civa")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GsyCiva.findAll", query = "SELECT g FROM GsyCiva g"),
    @NamedQuery(name = "GsyCiva.findByCivaId", query = "SELECT g FROM GsyCiva g WHERE g.civaId = :civaId"),
    @NamedQuery(name = "GsyCiva.findByDes", query = "SELECT g FROM GsyCiva g WHERE g.des = :des")})
public class GsyCiva implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "civa_id")
    private Integer civaId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "des")
    private String des;

    public GsyCiva() {
    }

    public GsyCiva(Integer civaId) {
        this.civaId = civaId;
    }

    public GsyCiva(Integer civaId, String des) {
        this.civaId = civaId;
        this.des = des;
    }

    public Integer getCivaId() {
        return civaId;
    }

    public void setCivaId(Integer civaId) {
        this.civaId = civaId;
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
        hash += (civaId != null ? civaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GsyCiva)) {
            return false;
        }
        GsyCiva other = (GsyCiva) object;
        if ((this.civaId == null && other.civaId != null) || (this.civaId != null && !this.civaId.equals(other.civaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sigemp.server.entity.GsyCiva[ civaId=" + civaId + " ]";
    }

}
