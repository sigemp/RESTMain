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
@Table(name = "gsy_loc")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GsyLoc.findAll", query = "SELECT g FROM GsyLoc g")
    , @NamedQuery(name = "GsyLoc.findByLocId", query = "SELECT g FROM GsyLoc g WHERE g.locId = :locId")
    , @NamedQuery(name = "GsyLoc.findByCp", query = "SELECT g FROM GsyLoc g WHERE g.cp = :cp")
    , @NamedQuery(name = "GsyLoc.findByDes", query = "SELECT g FROM GsyLoc g WHERE g.des = :des")})
public class GsyLoc implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "loc_id")
    private Integer locId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cp")
    private int cp;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "des")
    private String des;
    @JoinColumn(name = "prov_id", referencedColumnName = "prov_id")
    @ManyToOne(optional = false)
    private GsyProv provId;

    public GsyLoc() {
    }

    public GsyLoc(Integer locId) {
        this.locId = locId;
    }

    public GsyLoc(Integer locId, int cp, String des) {
        this.locId = locId;
        this.cp = cp;
        this.des = des;
    }

    public Integer getLocId() {
        return locId;
    }

    public void setLocId(Integer locId) {
        this.locId = locId;
    }

    public int getCp() {
        return cp;
    }

    public void setCp(int cp) {
        this.cp = cp;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public GsyProv getProvId() {
        return provId;
    }

    public void setProvId(GsyProv provId) {
        this.provId = provId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (locId != null ? locId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GsyLoc)) {
            return false;
        }
        GsyLoc other = (GsyLoc) object;
        if ((this.locId == null && other.locId != null) || (this.locId != null && !this.locId.equals(other.locId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sigemp.server.entity.GsyLoc[ locId=" + locId + " ]";
    }
    
}
