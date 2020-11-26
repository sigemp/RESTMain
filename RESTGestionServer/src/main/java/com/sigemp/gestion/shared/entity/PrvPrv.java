/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigemp.gestion.shared.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author cristian
 */
@Entity
@Table(name = "prv_prv")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PrvPrv.findAll", query = "SELECT p FROM PrvPrv p")
    , @NamedQuery(name = "PrvPrv.findByNombreCheque", query = "SELECT p FROM PrvPrv p WHERE p.nombreCheque = :nombreCheque")
    , @NamedQuery(name = "PrvPrv.findByNombreContacto", query = "SELECT p FROM PrvPrv p WHERE p.nombreContacto = :nombreContacto")
    , @NamedQuery(name = "PrvPrv.findByPrvId", query = "SELECT p FROM PrvPrv p WHERE p.prvId = :prvId")})
public class PrvPrv implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "nombre_cheque")
    private String nombreCheque;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nombre_contacto")
    private String nombreContacto;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "prv_id")
    private Long prvId;
    @JoinColumn(name = "prv_id", referencedColumnName = "pers_id", insertable = false, updatable = false)
    @OneToOne(optional = false)
    @JsonIgnore
    private GsyPers gsyPers;

    public PrvPrv() {
    }

    public PrvPrv(Long prvId) {
        this.prvId = prvId;
    }

    public PrvPrv(Long prvId, String nombreCheque, String nombreContacto) {
        this.prvId = prvId;
        this.nombreCheque = nombreCheque;
        this.nombreContacto = nombreContacto;
    }

    public String getNombreCheque() {
        return nombreCheque;
    }

    public void setNombreCheque(String nombreCheque) {
        this.nombreCheque = nombreCheque;
    }

    public String getNombreContacto() {
        return nombreContacto;
    }

    public void setNombreContacto(String nombreContacto) {
        this.nombreContacto = nombreContacto;
    }

    public Long getPrvId() {
        return prvId;
    }

    public void setPrvId(Long prvId) {
        this.prvId = prvId;
    }

    
    public GsyPers getGsyPers() {
        return gsyPers;
    }

    public void setGsyPers(GsyPers gsyPers) {
        this.gsyPers = gsyPers;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (prvId != null ? prvId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PrvPrv)) {
            return false;
        }
        PrvPrv other = (PrvPrv) object;
        if ((this.prvId == null && other.prvId != null) || (this.prvId != null && !this.prvId.equals(other.prvId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sigemp.server.entity.PrvPrv[ prvId=" + prvId + " ]";
    }
    
}
