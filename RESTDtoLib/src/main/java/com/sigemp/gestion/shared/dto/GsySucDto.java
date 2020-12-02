package com.sigemp.gestion.shared.dto;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.Serializable;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author cristian
 */
@XmlRootElement
public class GsySucDto implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer sucId;
    private String des;
    private String dir;
    private String telefono;

    public GsySucDto() {
    }

    public GsySucDto(Integer sucId) {
        this.sucId = sucId;
    }

    public GsySucDto(Integer sucId, String des, String dir, String telefono) {
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
        if (!(object instanceof GsySucDto)) {
            return false;
        }
        GsySucDto other = (GsySucDto) object;
        if ((this.sucId == null && other.sucId != null) || (this.sucId != null && !this.sucId.equals(other.sucId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return des + " Id:" + sucId;
    }
    
}
