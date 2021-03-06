/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigemp.gestion.shared.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author cristian
 */
@Entity
@Table(name = "gsy_talonarios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GsyTalonarios.findAll", query = "SELECT g FROM GsyTalonarios g")
    , @NamedQuery(name = "GsyTalonarios.findByTalId", query = "SELECT g FROM GsyTalonarios g WHERE g.talId = :talId")
    , @NamedQuery(name = "GsyTalonarios.findByDes", query = "SELECT g FROM GsyTalonarios g WHERE g.des = :des")
    , @NamedQuery(name = "GsyTalonarios.findByEstado", query = "SELECT g FROM GsyTalonarios g WHERE g.estado = :estado")
    , @NamedQuery(name = "GsyTalonarios.findByFeTa", query = "SELECT g FROM GsyTalonarios g WHERE g.feTa = :feTa")
    , @NamedQuery(name = "GsyTalonarios.findByIfbaudios", query = "SELECT g FROM GsyTalonarios g WHERE g.ifbaudios = :ifbaudios")
    , @NamedQuery(name = "GsyTalonarios.findByIfmarca", query = "SELECT g FROM GsyTalonarios g WHERE g.ifmarca = :ifmarca")
    , @NamedQuery(name = "GsyTalonarios.findByIfmodelo", query = "SELECT g FROM GsyTalonarios g WHERE g.ifmodelo = :ifmodelo")
    , @NamedQuery(name = "GsyTalonarios.findByIfpuerto", query = "SELECT g FROM GsyTalonarios g WHERE g.ifpuerto = :ifpuerto")})
public class GsyTalonarios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "tal_id")
    private Integer talId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "des")
    private String des;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estado")
    private boolean estado;
    @Size(max = 2147483647)
    @Column(name = "fe_ta")
    private String feTa;
    @Size(max = 255)
    @Column(name = "ifbaudios")
    private String ifbaudios;
    @Size(max = 120)
    @Column(name = "ifmarca")
    private String ifmarca;
    @Size(max = 120)
    @Column(name = "ifmodelo")
    private String ifmodelo;
    @Column(name = "ifpuerto")
    private Integer ifpuerto;
    @JoinColumn(name = "depo_id", referencedColumnName = "depo_id")
    @ManyToOne(optional = false)
    private StkDepositos depoId;
    @XmlTransient
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "talId")
    private Collection<GsyContadores> gsyContadoresCollection;

    public GsyTalonarios() {
    }

    public GsyTalonarios(Integer talId) {
        this.talId = talId;
    }

    public GsyTalonarios(Integer talId, String des, boolean estado) {
        this.talId = talId;
        this.des = des;
        this.estado = estado;
    }

    public Integer getTalId() {
        return talId;
    }

    public void setTalId(Integer talId) {
        this.talId = talId;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public String getFeTa() {
        return feTa;
    }

    public void setFeTa(String feTa) {
        this.feTa = feTa;
    }

    public String getIfbaudios() {
        return ifbaudios;
    }

    public void setIfbaudios(String ifbaudios) {
        this.ifbaudios = ifbaudios;
    }

    public String getIfmarca() {
        return ifmarca;
    }

    public void setIfmarca(String ifmarca) {
        this.ifmarca = ifmarca;
    }

    public String getIfmodelo() {
        return ifmodelo;
    }

    public void setIfmodelo(String ifmodelo) {
        this.ifmodelo = ifmodelo;
    }

    public Integer getIfpuerto() {
        return ifpuerto;
    }

    public void setIfpuerto(Integer ifpuerto) {
        this.ifpuerto = ifpuerto;
    }

    public StkDepositos getDepoId() {
        return depoId;
    }

    public void setDepoId(StkDepositos depoId) {
        this.depoId = depoId;
    }

    public Collection<GsyContadores> getGsyContadoresCollection() {
        return gsyContadoresCollection;
    }

    public void setGsyContadoresCollection(Collection<GsyContadores> gsyContadoresCollection) {
        this.gsyContadoresCollection = gsyContadoresCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (talId != null ? talId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GsyTalonarios)) {
            return false;
        }
        GsyTalonarios other = (GsyTalonarios) object;
        if ((this.talId == null && other.talId != null) || (this.talId != null && !this.talId.equals(other.talId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sigemp.server.entity.GsyTalonarios[ talId=" + talId + " ]";
    }
    
}
