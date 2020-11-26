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
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author cristian
 */
@Entity
@Table(name = "gsy_rolesr")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GsyRolesr.findAll", query = "SELECT g FROM GsyRolesr g")
    , @NamedQuery(name = "GsyRolesr.findByRolrId", query = "SELECT g FROM GsyRolesr g WHERE g.rolrId = :rolrId")
    , @NamedQuery(name = "GsyRolesr.findByClaseId", query = "SELECT g FROM GsyRolesr g WHERE g.claseId = :claseId")
    , @NamedQuery(name = "GsyRolesr.findByCodigo", query = "SELECT g FROM GsyRolesr g WHERE g.codigo = :codigo")
    , @NamedQuery(name = "GsyRolesr.findByValor", query = "SELECT g FROM GsyRolesr g WHERE g.valor = :valor")})
public class GsyRolesr implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "rolr_id")
    private Integer rolrId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "clase_id")
    private int claseId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "codigo")
    private int codigo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "valor")
    private boolean valor;
    @JoinColumn(name = "rol_id", referencedColumnName = "rol_id")
    @ManyToOne(optional = false)
    private GsyRoles rolId;

    public GsyRolesr() {
    }

    public GsyRolesr(Integer rolrId) {
        this.rolrId = rolrId;
    }

    public GsyRolesr(Integer rolrId, int claseId, int codigo, boolean valor) {
        this.rolrId = rolrId;
        this.claseId = claseId;
        this.codigo = codigo;
        this.valor = valor;
    }

    public Integer getRolrId() {
        return rolrId;
    }

    public void setRolrId(Integer rolrId) {
        this.rolrId = rolrId;
    }

    public int getClaseId() {
        return claseId;
    }

    public void setClaseId(int claseId) {
        this.claseId = claseId;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public boolean getValor() {
        return valor;
    }

    public void setValor(boolean valor) {
        this.valor = valor;
    }

    public GsyRoles getRolId() {
        return rolId;
    }

    public void setRolId(GsyRoles rolId) {
        this.rolId = rolId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rolrId != null ? rolrId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GsyRolesr)) {
            return false;
        }
        GsyRolesr other = (GsyRolesr) object;
        if ((this.rolrId == null && other.rolrId != null) || (this.rolrId != null && !this.rolrId.equals(other.rolrId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sigemp.server.entity.GsyRolesr[ rolrId=" + rolrId + " ]";
    }
    
}
