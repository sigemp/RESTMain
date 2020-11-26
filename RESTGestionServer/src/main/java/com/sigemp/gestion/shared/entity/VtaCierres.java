/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigemp.gestion.shared.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author cristian
 */
@Entity
@Table(name = "vta_cierres")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VtaCierres.findAll", query = "SELECT v FROM VtaCierres v")
    , @NamedQuery(name = "VtaCierres.findByCierreId", query = "SELECT v FROM VtaCierres v WHERE v.cierreId = :cierreId")
    , @NamedQuery(name = "VtaCierres.findByFec", query = "SELECT v FROM VtaCierres v WHERE v.fec = :fec")
    , @NamedQuery(name = "VtaCierres.findByObs", query = "SELECT v FROM VtaCierres v WHERE v.obs = :obs")})
public class VtaCierres implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cierre_id")
    private Integer cierreId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fec")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fec;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "obs")
    private String obs;
    @OneToMany(mappedBy = "cierreId")
    private Collection<StkMv> stkMvCollection;
    @OneToMany(mappedBy = "cierreId")
    private Collection<VtaCob> vtaCobCollection;
    @OneToMany(mappedBy = "cierreId")
    private Collection<VtaVta> vtaVtaCollection;
    @OneToMany(mappedBy = "cierreId")
    private Collection<VtaCaj> vtaCajCollection;
    @JoinColumn(name = "usr_id", referencedColumnName = "usr_id")
    @ManyToOne(optional = false)
    private GsyUser usrId;
    @JoinColumn(name = "depo_id", referencedColumnName = "depo_id")
    @ManyToOne(optional = false)
    private StkDepositos depoId;

    public VtaCierres() {
    }

    public VtaCierres(Integer cierreId) {
        this.cierreId = cierreId;
    }

    public VtaCierres(Integer cierreId, Date fec, String obs) {
        this.cierreId = cierreId;
        this.fec = fec;
        this.obs = obs;
    }

    public Integer getCierreId() {
        return cierreId;
    }

    public void setCierreId(Integer cierreId) {
        this.cierreId = cierreId;
    }

    public Date getFec() {
        return fec;
    }

    public void setFec(Date fec) {
        this.fec = fec;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    @XmlTransient
    public Collection<StkMv> getStkMvCollection() {
        return stkMvCollection;
    }

    public void setStkMvCollection(Collection<StkMv> stkMvCollection) {
        this.stkMvCollection = stkMvCollection;
    }

    @XmlTransient
    public Collection<VtaCob> getVtaCobCollection() {
        return vtaCobCollection;
    }

    public void setVtaCobCollection(Collection<VtaCob> vtaCobCollection) {
        this.vtaCobCollection = vtaCobCollection;
    }

    @XmlTransient
    public Collection<VtaVta> getVtaVtaCollection() {
        return vtaVtaCollection;
    }

    public void setVtaVtaCollection(Collection<VtaVta> vtaVtaCollection) {
        this.vtaVtaCollection = vtaVtaCollection;
    }

    @XmlTransient
    public Collection<VtaCaj> getVtaCajCollection() {
        return vtaCajCollection;
    }

    public void setVtaCajCollection(Collection<VtaCaj> vtaCajCollection) {
        this.vtaCajCollection = vtaCajCollection;
    }

    public GsyUser getUsrId() {
        return usrId;
    }

    public void setUsrId(GsyUser usrId) {
        this.usrId = usrId;
    }

    public StkDepositos getDepoId() {
        return depoId;
    }

    public void setDepoId(StkDepositos depoId) {
        this.depoId = depoId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cierreId != null ? cierreId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VtaCierres)) {
            return false;
        }
        VtaCierres other = (VtaCierres) object;
        if ((this.cierreId == null && other.cierreId != null) || (this.cierreId != null && !this.cierreId.equals(other.cierreId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sigemp.server.entity.VtaCierres[ cierreId=" + cierreId + " ]";
    }
    
}
