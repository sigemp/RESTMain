/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigemp.gestion.shared.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author cristian
 */
@Entity
@Table(name = "gsy_roles")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GsyRoles.findAll", query = "SELECT g FROM GsyRoles g")
    , @NamedQuery(name = "GsyRoles.findByRolId", query = "SELECT g FROM GsyRoles g WHERE g.rolId = :rolId")
    , @NamedQuery(name = "GsyRoles.findByDes", query = "SELECT g FROM GsyRoles g WHERE g.des = :des")})
public class GsyRoles implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "rol_id")
    private Integer rolId;
    @Size(max = 40)
    @Column(name = "des")
    private String des;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "rolId")
    private Collection<GsyRolesr> gsyRolesrCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "rolId")
    private Collection<GsyUsuariosroles> gsyUsuariosrolesCollection;

    public GsyRoles() {
    }

    public GsyRoles(Integer rolId) {
        this.rolId = rolId;
    }

    public Integer getRolId() {
        return rolId;
    }

    public void setRolId(Integer rolId) {
        this.rolId = rolId;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    @XmlTransient
    public Collection<GsyRolesr> getGsyRolesrCollection() {
        return gsyRolesrCollection;
    }

    public void setGsyRolesrCollection(Collection<GsyRolesr> gsyRolesrCollection) {
        this.gsyRolesrCollection = gsyRolesrCollection;
    }

    @XmlTransient
    public Collection<GsyUsuariosroles> getGsyUsuariosrolesCollection() {
        return gsyUsuariosrolesCollection;
    }

    public void setGsyUsuariosrolesCollection(Collection<GsyUsuariosroles> gsyUsuariosrolesCollection) {
        this.gsyUsuariosrolesCollection = gsyUsuariosrolesCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rolId != null ? rolId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GsyRoles)) {
            return false;
        }
        GsyRoles other = (GsyRoles) object;
        if ((this.rolId == null && other.rolId != null) || (this.rolId != null && !this.rolId.equals(other.rolId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sigemp.server.entity.GsyRoles[ rolId=" + rolId + " ]";
    }
    
}
