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
@Table(name = "vta_est")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VtaEst.findAll", query = "SELECT v FROM VtaEst v")
    , @NamedQuery(name = "VtaEst.findByEstId", query = "SELECT v FROM VtaEst v WHERE v.estId = :estId")
    , @NamedQuery(name = "VtaEst.findByDes", query = "SELECT v FROM VtaEst v WHERE v.des = :des")
    , @NamedQuery(name = "VtaEst.findByFlags", query = "SELECT v FROM VtaEst v WHERE v.flags = :flags")})
public class VtaEst implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "est_id")
    private Integer estId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "des")
    private String des;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "flags")
    private String flags;

    public VtaEst() {
    }

    public VtaEst(Integer estId) {
        this.estId = estId;
    }

    public VtaEst(Integer estId, String des, String flags) {
        this.estId = estId;
        this.des = des;
        this.flags = flags;
    }

    public Integer getEstId() {
        return estId;
    }

    public void setEstId(Integer estId) {
        this.estId = estId;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public String getFlags() {
        return flags;
    }

    public void setFlags(String flags) {
        this.flags = flags;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (estId != null ? estId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VtaEst)) {
            return false;
        }
        VtaEst other = (VtaEst) object;
        if ((this.estId == null && other.estId != null) || (this.estId != null && !this.estId.equals(other.estId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sigemp.server.entity.VtaEst[ estId=" + estId + " ]";
    }
    
}
