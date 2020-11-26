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
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author cristian
 */
@Entity
@Table(name = "gsy_suc")
@XmlRootElement
public class GsySuc implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "suc_id")
    private Integer sucId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "des")
    private String des;
    @Basic(optional = false)
    @NotNull
    @Size(min = 0, max = 100)
    @Column(name = "dir")
    private String dir;
    @Basic(optional = false)
    @NotNull
    @Size(min = 0, max = 100)
    @Column(name = "telefono")
    private String telefono;

    public GsySuc() {
    }

    public GsySuc(Integer sucId) {
        this.sucId = sucId;
    }

    public GsySuc(Integer sucId, String des, String dir, String telefono) {
        this.sucId = sucId;
        this.des = des;
        this.dir = dir;
        this.telefono = telefono;
    }

    public Integer getSucId() {
        return sucId;
    }

    public void setSucId(Integer sucId) {
        this.sucId = sucId;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public String getDir() {
        return dir;
    }

    public void setDir(String dir) {
        this.dir = dir;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sucId != null ? sucId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GsySuc)) {
            return false;
        }
        GsySuc other = (GsySuc) object;
        if ((this.sucId == null && other.sucId != null) || (this.sucId != null && !this.sucId.equals(other.sucId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sigemp.server.entity.GsySuc[ sucId=" + sucId + " ]";
    }
    
}
