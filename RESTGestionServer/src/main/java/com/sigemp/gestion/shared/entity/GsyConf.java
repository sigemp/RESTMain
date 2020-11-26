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
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author cristian
 */
@Entity
@Table(name = "gsy_conf")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GsyConf.findAll", query = "SELECT g FROM GsyConf g")
    , @NamedQuery(name = "GsyConf.findByPmtId", query = "SELECT g FROM GsyConf g WHERE g.pmtId = :pmtId")
    , @NamedQuery(name = "GsyConf.findByValor", query = "SELECT g FROM GsyConf g WHERE g.valor = :valor")})
public class GsyConf implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "pmt_id")
    private String pmtId;
    @Size(max = 2147483647)
    @Column(name = "valor")
    private String valor;
    @Lob
    @Column(name = "valorbytea")
    private byte[] valorbytea;

    public GsyConf() {
    }

    public GsyConf(String pmtId) {
        this.pmtId = pmtId;
    }

    public String getPmtId() {
        return pmtId;
    }

    public void setPmtId(String pmtId) {
        this.pmtId = pmtId;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public byte[] getValorbytea() {
        return valorbytea;
    }

    public void setValorbytea(byte[] valorbytea) {
        this.valorbytea = valorbytea;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pmtId != null ? pmtId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GsyConf)) {
            return false;
        }
        GsyConf other = (GsyConf) object;
        if ((this.pmtId == null && other.pmtId != null) || (this.pmtId != null && !this.pmtId.equals(other.pmtId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sigemp.server.entity.GsyConf[ pmtId=" + pmtId + " ]";
    }
    
}
