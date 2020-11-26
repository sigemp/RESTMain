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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author cristian
 */
@Entity
@Table(name = "gsy_usuariosroles")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GsyUsuariosroles.findAll", query = "SELECT g FROM GsyUsuariosroles g")
    , @NamedQuery(name = "GsyUsuariosroles.findByUsrrolId", query = "SELECT g FROM GsyUsuariosroles g WHERE g.usrrolId = :usrrolId")})
public class GsyUsuariosroles implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "usrrol_id")
    private Integer usrrolId;
    @JoinColumn(name = "rol_id", referencedColumnName = "rol_id")
    @ManyToOne(optional = false)
    private GsyRoles rolId;
    @JoinColumn(name = "usr_id", referencedColumnName = "usr_id")
    @ManyToOne(optional = false)
    private GsyUser usrId;

    public GsyUsuariosroles() {
    }

    public GsyUsuariosroles(Integer usrrolId) {
        this.usrrolId = usrrolId;
    }

    public Integer getUsrrolId() {
        return usrrolId;
    }

    public void setUsrrolId(Integer usrrolId) {
        this.usrrolId = usrrolId;
    }

    public GsyRoles getRolId() {
        return rolId;
    }

    public void setRolId(GsyRoles rolId) {
        this.rolId = rolId;
    }

    public GsyUser getUsrId() {
        return usrId;
    }

    public void setUsrId(GsyUser usrId) {
        this.usrId = usrId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (usrrolId != null ? usrrolId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GsyUsuariosroles)) {
            return false;
        }
        GsyUsuariosroles other = (GsyUsuariosroles) object;
        if ((this.usrrolId == null && other.usrrolId != null) || (this.usrrolId != null && !this.usrrolId.equals(other.usrrolId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sigemp.server.entity.GsyUsuariosroles[ usrrolId=" + usrrolId + " ]";
    }
    
}
