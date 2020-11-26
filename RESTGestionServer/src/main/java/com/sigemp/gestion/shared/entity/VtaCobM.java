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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
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
@Table(name = "vta_cob_m")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VtaCobM.findAll", query = "SELECT v FROM VtaCobM v")
    , @NamedQuery(name = "VtaCobM.findByCobrId", query = "SELECT v FROM VtaCobM v WHERE v.cobrId = :cobrId")
    , @NamedQuery(name = "VtaCobM.findByCuotas", query = "SELECT v FROM VtaCobM v WHERE v.cuotas = :cuotas")
    , @NamedQuery(name = "VtaCobM.findByFecCupon", query = "SELECT v FROM VtaCobM v WHERE v.fecCupon = :fecCupon")
    , @NamedQuery(name = "VtaCobM.findByFecVto", query = "SELECT v FROM VtaCobM v WHERE v.fecVto = :fecVto")
    , @NamedQuery(name = "VtaCobM.findByLegajo", query = "SELECT v FROM VtaCobM v WHERE v.legajo = :legajo")
    , @NamedQuery(name = "VtaCobM.findByNom", query = "SELECT v FROM VtaCobM v WHERE v.nom = :nom")
    , @NamedQuery(name = "VtaCobM.findByNumcupon", query = "SELECT v FROM VtaCobM v WHERE v.numcupon = :numcupon")})
public class VtaCobM implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "cobr_id")
    private Integer cobrId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cuotas")
    private int cuotas;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fec_cupon")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecCupon;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fec_vto")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecVto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "legajo")
    private int legajo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "nom")
    private String nom;
    @Basic(optional = false)
    @NotNull
    @Column(name = "numcupon")
    private int numcupon;
    @JoinColumn(name = "cobr_id", referencedColumnName = "cobr_id", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private VtaCobr vtaCobr;

    public VtaCobM() {
    }

    public VtaCobM(Integer cobrId) {
        this.cobrId = cobrId;
    }

    public VtaCobM(Integer cobrId, int cuotas, Date fecCupon, Date fecVto, int legajo, String nom, int numcupon) {
        this.cobrId = cobrId;
        this.cuotas = cuotas;
        this.fecCupon = fecCupon;
        this.fecVto = fecVto;
        this.legajo = legajo;
        this.nom = nom;
        this.numcupon = numcupon;
    }

    public Integer getCobrId() {
        return cobrId;
    }

    public void setCobrId(Integer cobrId) {
        this.cobrId = cobrId;
    }

    public int getCuotas() {
        return cuotas;
    }

    public void setCuotas(int cuotas) {
        this.cuotas = cuotas;
    }

    public Date getFecCupon() {
        return fecCupon;
    }

    public void setFecCupon(Date fecCupon) {
        this.fecCupon = fecCupon;
    }

    public Date getFecVto() {
        return fecVto;
    }

    public void setFecVto(Date fecVto) {
        this.fecVto = fecVto;
    }

    public int getLegajo() {
        return legajo;
    }

    public void setLegajo(int legajo) {
        this.legajo = legajo;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getNumcupon() {
        return numcupon;
    }

    public void setNumcupon(int numcupon) {
        this.numcupon = numcupon;
    }

    public VtaCobr getVtaCobr() {
        return vtaCobr;
    }

    public void setVtaCobr(VtaCobr vtaCobr) {
        this.vtaCobr = vtaCobr;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cobrId != null ? cobrId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VtaCobM)) {
            return false;
        }
        VtaCobM other = (VtaCobM) object;
        if ((this.cobrId == null && other.cobrId != null) || (this.cobrId != null && !this.cobrId.equals(other.cobrId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sigemp.server.entity.VtaCobM[ cobrId=" + cobrId + " ]";
    }
    
}
