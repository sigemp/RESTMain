package com.sigemp.gestion.shared.dto;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.Serializable;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class GsyProvDto implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer provId;
    private String des;
//    private Collection<GsyLoc> gsyLocCollection;

    public GsyProvDto() {
    }

    public GsyProvDto(Integer provId) {
        this.provId = provId;
    }

    public GsyProvDto(Integer provId, String des) {
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

//    @XmlTransient
//    public Collection<GsyLoc> getGsyLocCollection() {
//        return gsyLocCollection;
//    }
//
//    public void setGsyLocCollection(Collection<GsyLoc> gsyLocCollection) {
//        this.gsyLocCollection = gsyLocCollection;
//    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (provId != null ? provId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GsyProvDto)) {
            return false;
        }
        GsyProvDto other = (GsyProvDto) object;
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
