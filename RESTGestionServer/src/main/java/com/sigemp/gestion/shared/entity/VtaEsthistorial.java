/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigemp.gestion.shared.entity;

import java.io.Serializable;
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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author cristian
 */
@Entity
@Table(name = "vta_esthistorial")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VtaEsthistorial.findAll", query = "SELECT v FROM VtaEsthistorial v")
    , @NamedQuery(name = "VtaEsthistorial.findByEsthistorialId", query = "SELECT v FROM VtaEsthistorial v WHERE v.esthistorialId = :esthistorialId")
    , @NamedQuery(name = "VtaEsthistorial.findByFec", query = "SELECT v FROM VtaEsthistorial v WHERE v.fec = :fec")
    , @NamedQuery(name = "VtaEsthistorial.findByObs", query = "SELECT v FROM VtaEsthistorial v WHERE v.obs = :obs")})
public class VtaEsthistorial implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "esthistorial_id")
    private Integer esthistorialId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fec")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fec;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "obs")
    private String obs;
    @JoinColumn(name = "usr_id", referencedColumnName = "usr_id")
    @ManyToOne(optional = false)
    private GsyUser usrId;
    @JoinColumn(name = "cta_id", referencedColumnName = "cta_id")
    @ManyToOne(optional = false)
    private VtaCta ctaId;
    @JoinColumn(name = "est_id", referencedColumnName = "est_id")
    @ManyToOne(optional = false)
    private VtaEst estId;
    @JoinColumn(name = "estold_id", referencedColumnName = "est_id")
    @ManyToOne(optional = false)
    private VtaEst estoldId;

    public VtaEsthistorial() {
    }

    public VtaEsthistorial(Integer esthistorialId) {
        this.esthistorialId = esthistorialId;
    }

    public VtaEsthistorial(Integer esthistorialId, Date fec, String obs) {
        this.esthistorialId = esthistorialId;
        this.fec = fec;
        this.obs = obs;
    }

    public Integer getEsthistorialId() {
        return esthistorialId;
    }

    public void setEsthistorialId(Integer esthistorialId) {
        this.esthistorialId = esthistorialId;
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

    public GsyUser getUsrId() {
        return usrId;
    }

    public void setUsrId(GsyUser usrId) {
        this.usrId = usrId;
    }

    public VtaCta getCtaId() {
        return ctaId;
    }

    public void setCtaId(VtaCta ctaId) {
        this.ctaId = ctaId;
    }

    public VtaEst getEstId() {
        return estId;
    }

    public void setEstId(VtaEst estId) {
        this.estId = estId;
    }

    public VtaEst getEstoldId() {
        return estoldId;
    }

    public void setEstoldId(VtaEst estoldId) {
        this.estoldId = estoldId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (esthistorialId != null ? esthistorialId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VtaEsthistorial)) {
            return false;
        }
        VtaEsthistorial other = (VtaEsthistorial) object;
        if ((this.esthistorialId == null && other.esthistorialId != null) || (this.esthistorialId != null && !this.esthistorialId.equals(other.esthistorialId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sigemp.server.entity.VtaEsthistorial[ esthistorialId=" + esthistorialId + " ]";
    }
    
}
