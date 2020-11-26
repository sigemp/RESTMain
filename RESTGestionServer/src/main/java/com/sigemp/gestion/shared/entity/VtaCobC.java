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
import javax.persistence.ManyToOne;
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
@Table(name = "vta_cob_c")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VtaCobC.findAll", query = "SELECT v FROM VtaCobC v")
    , @NamedQuery(name = "VtaCobC.findByCobrId", query = "SELECT v FROM VtaCobC v WHERE v.cobrId = :cobrId")
    , @NamedQuery(name = "VtaCobC.findByFecEmision", query = "SELECT v FROM VtaCobC v WHERE v.fecEmision = :fecEmision")
    , @NamedQuery(name = "VtaCobC.findByFecVto", query = "SELECT v FROM VtaCobC v WHERE v.fecVto = :fecVto")
    , @NamedQuery(name = "VtaCobC.findByNom", query = "SELECT v FROM VtaCobC v WHERE v.nom = :nom")
    , @NamedQuery(name = "VtaCobC.findByNum", query = "SELECT v FROM VtaCobC v WHERE v.num = :num")
    , @NamedQuery(name = "VtaCobC.findByNumCuenta", query = "SELECT v FROM VtaCobC v WHERE v.numCuenta = :numCuenta")
    , @NamedQuery(name = "VtaCobC.findByTipo", query = "SELECT v FROM VtaCobC v WHERE v.tipo = :tipo")})
public class VtaCobC implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "cobr_id")
    private Integer cobrId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fec_emision")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecEmision;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fec_vto")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecVto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "nom")
    private String nom;
    @Basic(optional = false)
    @NotNull
    @Column(name = "num")
    private int num;
    @Basic(optional = false)
    @NotNull
    @Column(name = "num_cuenta")
    private int numCuenta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tipo")
    private int tipo;
    @JoinColumn(name = "bnc_id", referencedColumnName = "bnc_id")
    @ManyToOne(optional = false)
    private VtaBancos bncId;
    @JoinColumn(name = "cobr_id", referencedColumnName = "cobr_id", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private VtaCobr vtaCobr;

    public VtaCobC() {
    }

    public VtaCobC(Integer cobrId) {
        this.cobrId = cobrId;
    }

    public VtaCobC(Integer cobrId, Date fecEmision, Date fecVto, String nom, int num, int numCuenta, int tipo) {
        this.cobrId = cobrId;
        this.fecEmision = fecEmision;
        this.fecVto = fecVto;
        this.nom = nom;
        this.num = num;
        this.numCuenta = numCuenta;
        this.tipo = tipo;
    }

    public Integer getCobrId() {
        return cobrId;
    }

    public void setCobrId(Integer cobrId) {
        this.cobrId = cobrId;
    }

    public Date getFecEmision() {
        return fecEmision;
    }

    public void setFecEmision(Date fecEmision) {
        this.fecEmision = fecEmision;
    }

    public Date getFecVto() {
        return fecVto;
    }

    public void setFecVto(Date fecVto) {
        this.fecVto = fecVto;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getNumCuenta() {
        return numCuenta;
    }

    public void setNumCuenta(int numCuenta) {
        this.numCuenta = numCuenta;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public VtaBancos getBncId() {
        return bncId;
    }

    public void setBncId(VtaBancos bncId) {
        this.bncId = bncId;
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
        if (!(object instanceof VtaCobC)) {
            return false;
        }
        VtaCobC other = (VtaCobC) object;
        if ((this.cobrId == null && other.cobrId != null) || (this.cobrId != null && !this.cobrId.equals(other.cobrId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sigemp.server.entity.VtaCobC[ cobrId=" + cobrId + " ]";
    }
    
}
