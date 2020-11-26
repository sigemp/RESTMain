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
@Table(name = "gsy_tdoc")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GsyTdoc.findAll", query = "SELECT g FROM GsyTdoc g")
    , @NamedQuery(name = "GsyTdoc.findByTdocId", query = "SELECT g FROM GsyTdoc g WHERE g.tdocId = :tdocId")
    , @NamedQuery(name = "GsyTdoc.findByDes", query = "SELECT g FROM GsyTdoc g WHERE g.des = :des")})
public class GsyTdoc implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "tdoc_id")
    private Integer tdocId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "des")
    private String des;

    public GsyTdoc() {
    }

    public GsyTdoc(Integer tdocId) {
        this.tdocId = tdocId;
    }

    public GsyTdoc(Integer tdocId, String des) {
        this.tdocId = tdocId;
        this.des = des;
    }

    public Integer getTdocId() {
        return tdocId;
    }

    public void setTdocId(Integer tdocId) {
        this.tdocId = tdocId;
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
        hash += (tdocId != null ? tdocId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GsyTdoc)) {
            return false;
        }
        GsyTdoc other = (GsyTdoc) object;
        if ((this.tdocId == null && other.tdocId != null) || (this.tdocId != null && !this.tdocId.equals(other.tdocId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sigemp.server.entity.GsyTdoc[ tdocId=" + tdocId + " ]";
    }
    
}
