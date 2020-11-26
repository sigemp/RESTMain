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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author cristian
 */
@Entity
@Table(name = "pvta_motivonoventa")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PvtaMotivonoventa.findAll", query = "SELECT p FROM PvtaMotivonoventa p")
    , @NamedQuery(name = "PvtaMotivonoventa.findByMotnvId", query = "SELECT p FROM PvtaMotivonoventa p WHERE p.motnvId = :motnvId")
    , @NamedQuery(name = "PvtaMotivonoventa.findByFechacreacion", query = "SELECT p FROM PvtaMotivonoventa p WHERE p.fechacreacion = :fechacreacion")})
public class PvtaMotivonoventa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "motnv_id")
    private Integer motnvId;
    @Column(name = "fechacreacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechacreacion;
    @JoinColumn(name = "pers_id", referencedColumnName = "pers_id")
    @ManyToOne(optional = false)
    private GsyPers persId;
    @JoinColumn(name = "entrega_id", referencedColumnName = "entrega_id")
    @ManyToOne(optional = false)
    private PvtaEntrega entregaId;
    @JoinColumn(name = "tipnv_id", referencedColumnName = "tipnv_id")
    @ManyToOne(optional = false)
    private PvtaTiponoventa tipnvId;

    public PvtaMotivonoventa() {
    }

    public PvtaMotivonoventa(Integer motnvId) {
        this.motnvId = motnvId;
    }

    public Integer getMotnvId() {
        return motnvId;
    }

    public void setMotnvId(Integer motnvId) {
        this.motnvId = motnvId;
    }

    public Date getFechacreacion() {
        return fechacreacion;
    }

    public void setFechacreacion(Date fechacreacion) {
        this.fechacreacion = fechacreacion;
    }

    public GsyPers getPersId() {
        return persId;
    }

    public void setPersId(GsyPers persId) {
        this.persId = persId;
    }

    public PvtaEntrega getEntregaId() {
        return entregaId;
    }

    public void setEntregaId(PvtaEntrega entregaId) {
        this.entregaId = entregaId;
    }

    public PvtaTiponoventa getTipnvId() {
        return tipnvId;
    }

    public void setTipnvId(PvtaTiponoventa tipnvId) {
        this.tipnvId = tipnvId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (motnvId != null ? motnvId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PvtaMotivonoventa)) {
            return false;
        }
        PvtaMotivonoventa other = (PvtaMotivonoventa) object;
        if ((this.motnvId == null && other.motnvId != null) || (this.motnvId != null && !this.motnvId.equals(other.motnvId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sigemp.server.entity.PvtaMotivonoventa[ motnvId=" + motnvId + " ]";
    }
    
}
