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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author cristian
 */
@Entity
@Table(name = "gsy_paquetemap")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GsyPaquetemap.findAll", query = "SELECT g FROM GsyPaquetemap g")
    , @NamedQuery(name = "GsyPaquetemap.findByPaquetemapId", query = "SELECT g FROM GsyPaquetemap g WHERE g.paquetemapId = :paquetemapId")
    , @NamedQuery(name = "GsyPaquetemap.findByActivo", query = "SELECT g FROM GsyPaquetemap g WHERE g.activo = :activo")
    , @NamedQuery(name = "GsyPaquetemap.findByNumeroPaqueteEnvio", query = "SELECT g FROM GsyPaquetemap g WHERE g.numeroPaqueteEnvio = :numeroPaqueteEnvio")
    , @NamedQuery(name = "GsyPaquetemap.findByNumeroPaqueteRecibido", query = "SELECT g FROM GsyPaquetemap g WHERE g.numeroPaqueteRecibido = :numeroPaqueteRecibido")
    , @NamedQuery(name = "GsyPaquetemap.findBySucDestinoId", query = "SELECT g FROM GsyPaquetemap g WHERE g.sucDestinoId = :sucDestinoId")
    , @NamedQuery(name = "GsyPaquetemap.findBySucOrigenId", query = "SELECT g FROM GsyPaquetemap g WHERE g.sucOrigenId = :sucOrigenId")
    , @NamedQuery(name = "GsyPaquetemap.findByFechaenvio", query = "SELECT g FROM GsyPaquetemap g WHERE g.fechaenvio = :fechaenvio")
    , @NamedQuery(name = "GsyPaquetemap.findByFecharecibido", query = "SELECT g FROM GsyPaquetemap g WHERE g.fecharecibido = :fecharecibido")
    , @NamedQuery(name = "GsyPaquetemap.findByIdtipo", query = "SELECT g FROM GsyPaquetemap g WHERE g.idtipo = :idtipo")})
public class GsyPaquetemap implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "paquetemap_id")
    private Integer paquetemapId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "activo")
    private boolean activo;
    @Column(name = "numero_paquete_envio")
    private Integer numeroPaqueteEnvio;
    @Column(name = "numero_paquete_recibido")
    private Integer numeroPaqueteRecibido;
    @Column(name = "suc_destino_id")
    private Integer sucDestinoId;
    @Column(name = "suc_origen_id")
    private Integer sucOrigenId;
    @Column(name = "fechaenvio")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaenvio;
    @Column(name = "fecharecibido")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecharecibido;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idtipo")
    private int idtipo;

    public GsyPaquetemap() {
    }

    public GsyPaquetemap(Integer paquetemapId) {
        this.paquetemapId = paquetemapId;
    }

    public GsyPaquetemap(Integer paquetemapId, boolean activo, int idtipo) {
        this.paquetemapId = paquetemapId;
        this.activo = activo;
        this.idtipo = idtipo;
    }

    public Integer getPaquetemapId() {
        return paquetemapId;
    }

    public void setPaquetemapId(Integer paquetemapId) {
        this.paquetemapId = paquetemapId;
    }

    public boolean getActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public Integer getNumeroPaqueteEnvio() {
        return numeroPaqueteEnvio;
    }

    public void setNumeroPaqueteEnvio(Integer numeroPaqueteEnvio) {
        this.numeroPaqueteEnvio = numeroPaqueteEnvio;
    }

    public Integer getNumeroPaqueteRecibido() {
        return numeroPaqueteRecibido;
    }

    public void setNumeroPaqueteRecibido(Integer numeroPaqueteRecibido) {
        this.numeroPaqueteRecibido = numeroPaqueteRecibido;
    }

    public Integer getSucDestinoId() {
        return sucDestinoId;
    }

    public void setSucDestinoId(Integer sucDestinoId) {
        this.sucDestinoId = sucDestinoId;
    }

    public Integer getSucOrigenId() {
        return sucOrigenId;
    }

    public void setSucOrigenId(Integer sucOrigenId) {
        this.sucOrigenId = sucOrigenId;
    }

    public Date getFechaenvio() {
        return fechaenvio;
    }

    public void setFechaenvio(Date fechaenvio) {
        this.fechaenvio = fechaenvio;
    }

    public Date getFecharecibido() {
        return fecharecibido;
    }

    public void setFecharecibido(Date fecharecibido) {
        this.fecharecibido = fecharecibido;
    }

    public int getIdtipo() {
        return idtipo;
    }

    public void setIdtipo(int idtipo) {
        this.idtipo = idtipo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (paquetemapId != null ? paquetemapId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GsyPaquetemap)) {
            return false;
        }
        GsyPaquetemap other = (GsyPaquetemap) object;
        if ((this.paquetemapId == null && other.paquetemapId != null) || (this.paquetemapId != null && !this.paquetemapId.equals(other.paquetemapId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sigemp.server.entity.GsyPaquetemap[ paquetemapId=" + paquetemapId + " ]";
    }
    
}
