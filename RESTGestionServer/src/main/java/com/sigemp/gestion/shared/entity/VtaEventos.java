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
@Table(name = "vta_eventos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VtaEventos.findAll", query = "SELECT v FROM VtaEventos v")
    , @NamedQuery(name = "VtaEventos.findByEventId", query = "SELECT v FROM VtaEventos v WHERE v.eventId = :eventId")
    , @NamedQuery(name = "VtaEventos.findByFec", query = "SELECT v FROM VtaEventos v WHERE v.fec = :fec")
    , @NamedQuery(name = "VtaEventos.findByObs", query = "SELECT v FROM VtaEventos v WHERE v.obs = :obs")
    , @NamedQuery(name = "VtaEventos.findByTipoEvento", query = "SELECT v FROM VtaEventos v WHERE v.tipoEvento = :tipoEvento")
    , @NamedQuery(name = "VtaEventos.findByUsrId", query = "SELECT v FROM VtaEventos v WHERE v.usrId = :usrId")})
public class VtaEventos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "event_id")
    private Integer eventId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fec")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fec;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 400)
    @Column(name = "obs")
    private String obs;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tipo_evento")
    private int tipoEvento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "usr_id")
    private int usrId;
    @JoinColumn(name = "cta_id", referencedColumnName = "cta_id")
    @ManyToOne
    private VtaCta ctaId;

    public VtaEventos() {
    }

    public VtaEventos(Integer eventId) {
        this.eventId = eventId;
    }

    public VtaEventos(Integer eventId, Date fec, String obs, int tipoEvento, int usrId) {
        this.eventId = eventId;
        this.fec = fec;
        this.obs = obs;
        this.tipoEvento = tipoEvento;
        this.usrId = usrId;
    }

    public Integer getEventId() {
        return eventId;
    }

    public void setEventId(Integer eventId) {
        this.eventId = eventId;
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

    public int getTipoEvento() {
        return tipoEvento;
    }

    public void setTipoEvento(int tipoEvento) {
        this.tipoEvento = tipoEvento;
    }

    public int getUsrId() {
        return usrId;
    }

    public void setUsrId(int usrId) {
        this.usrId = usrId;
    }

    public VtaCta getCtaId() {
        return ctaId;
    }

    public void setCtaId(VtaCta ctaId) {
        this.ctaId = ctaId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (eventId != null ? eventId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VtaEventos)) {
            return false;
        }
        VtaEventos other = (VtaEventos) object;
        if ((this.eventId == null && other.eventId != null) || (this.eventId != null && !this.eventId.equals(other.eventId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sigemp.server.entity.VtaEventos[ eventId=" + eventId + " ]";
    }
    
}
