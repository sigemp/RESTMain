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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author cristian
 */
@Entity
@Table(name = "gsy_auditoria")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GsyAuditoria.findAll", query = "SELECT g FROM GsyAuditoria g")
    , @NamedQuery(name = "GsyAuditoria.findByAudId", query = "SELECT g FROM GsyAuditoria g WHERE g.audId = :audId")
    , @NamedQuery(name = "GsyAuditoria.findByClase", query = "SELECT g FROM GsyAuditoria g WHERE g.clase = :clase")
    , @NamedQuery(name = "GsyAuditoria.findByDes", query = "SELECT g FROM GsyAuditoria g WHERE g.des = :des")
    , @NamedQuery(name = "GsyAuditoria.findByFecha", query = "SELECT g FROM GsyAuditoria g WHERE g.fecha = :fecha")
    , @NamedQuery(name = "GsyAuditoria.findByHostname", query = "SELECT g FROM GsyAuditoria g WHERE g.hostname = :hostname")
    , @NamedQuery(name = "GsyAuditoria.findByIpClient", query = "SELECT g FROM GsyAuditoria g WHERE g.ipClient = :ipClient")
    , @NamedQuery(name = "GsyAuditoria.findByUsrId", query = "SELECT g FROM GsyAuditoria g WHERE g.usrId = :usrId")})
public class GsyAuditoria implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "aud_id")
    private Integer audId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "clase")
    private String clase;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "des")
    private String des;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "hostname")
    private String hostname;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "ip_client")
    private String ipClient;
    @Basic(optional = false)
    @NotNull
    @Column(name = "usr_id")
    private int usrId;

    public GsyAuditoria() {
    }

    public GsyAuditoria(Integer audId) {
        this.audId = audId;
    }

    public GsyAuditoria(Integer audId, String clase, String des, Date fecha, String hostname, String ipClient, int usrId) {
        this.audId = audId;
        this.clase = clase;
        this.des = des;
        this.fecha = fecha;
        this.hostname = hostname;
        this.ipClient = ipClient;
        this.usrId = usrId;
    }

    public Integer getAudId() {
        return audId;
    }

    public void setAudId(Integer audId) {
        this.audId = audId;
    }

    public String getClase() {
        return clase;
    }

    public void setClase(String clase) {
        this.clase = clase;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getHostname() {
        return hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public String getIpClient() {
        return ipClient;
    }

    public void setIpClient(String ipClient) {
        this.ipClient = ipClient;
    }

    public int getUsrId() {
        return usrId;
    }

    public void setUsrId(int usrId) {
        this.usrId = usrId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (audId != null ? audId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GsyAuditoria)) {
            return false;
        }
        GsyAuditoria other = (GsyAuditoria) object;
        if ((this.audId == null && other.audId != null) || (this.audId != null && !this.audId.equals(other.audId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sigemp.server.entity.GsyAuditoria[ audId=" + audId + " ]";
    }
    
}
