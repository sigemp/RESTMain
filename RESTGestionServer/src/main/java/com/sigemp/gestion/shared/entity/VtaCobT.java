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
@Table(name = "vta_cob_t")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VtaCobT.findAll", query = "SELECT v FROM VtaCobT v")
    , @NamedQuery(name = "VtaCobT.findByCobrId", query = "SELECT v FROM VtaCobT v WHERE v.cobrId = :cobrId")
    , @NamedQuery(name = "VtaCobT.findByCuotas", query = "SELECT v FROM VtaCobT v WHERE v.cuotas = :cuotas")
    , @NamedQuery(name = "VtaCobT.findByFec", query = "SELECT v FROM VtaCobT v WHERE v.fec = :fec")
    , @NamedQuery(name = "VtaCobT.findByFecExpiracion", query = "SELECT v FROM VtaCobT v WHERE v.fecExpiracion = :fecExpiracion")
    , @NamedQuery(name = "VtaCobT.findByNom", query = "SELECT v FROM VtaCobT v WHERE v.nom = :nom")
    , @NamedQuery(name = "VtaCobT.findByNumAutorizacion", query = "SELECT v FROM VtaCobT v WHERE v.numAutorizacion = :numAutorizacion")
    , @NamedQuery(name = "VtaCobT.findByNumCupon", query = "SELECT v FROM VtaCobT v WHERE v.numCupon = :numCupon")})
public class VtaCobT implements Serializable {

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
    @Column(name = "fec")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fec;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fec_expiracion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecExpiracion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "nom")
    private String nom;
    @Basic(optional = false)
    @NotNull
    @Column(name = "num_autorizacion")
    private int numAutorizacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "num_cupon")
    private int numCupon;
    @JoinColumn(name = "cobr_id", referencedColumnName = "cobr_id", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private VtaCobr vtaCobr;
    @JoinColumn(name = "trj_id", referencedColumnName = "trj_id")
    @ManyToOne(optional = false)
    private VtaTarjetas trjId;

    public VtaCobT() {
    }

    public VtaCobT(Integer cobrId) {
        this.cobrId = cobrId;
    }

    public VtaCobT(Integer cobrId, int cuotas, Date fec, Date fecExpiracion, String nom, int numAutorizacion, int numCupon) {
        this.cobrId = cobrId;
        this.cuotas = cuotas;
        this.fec = fec;
        this.fecExpiracion = fecExpiracion;
        this.nom = nom;
        this.numAutorizacion = numAutorizacion;
        this.numCupon = numCupon;
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

    public Date getFec() {
        return fec;
    }

    public void setFec(Date fec) {
        this.fec = fec;
    }

    public Date getFecExpiracion() {
        return fecExpiracion;
    }

    public void setFecExpiracion(Date fecExpiracion) {
        this.fecExpiracion = fecExpiracion;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getNumAutorizacion() {
        return numAutorizacion;
    }

    public void setNumAutorizacion(int numAutorizacion) {
        this.numAutorizacion = numAutorizacion;
    }

    public int getNumCupon() {
        return numCupon;
    }

    public void setNumCupon(int numCupon) {
        this.numCupon = numCupon;
    }

    public VtaCobr getVtaCobr() {
        return vtaCobr;
    }

    public void setVtaCobr(VtaCobr vtaCobr) {
        this.vtaCobr = vtaCobr;
    }

    public VtaTarjetas getTrjId() {
        return trjId;
    }

    public void setTrjId(VtaTarjetas trjId) {
        this.trjId = trjId;
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
        if (!(object instanceof VtaCobT)) {
            return false;
        }
        VtaCobT other = (VtaCobT) object;
        if ((this.cobrId == null && other.cobrId != null) || (this.cobrId != null && !this.cobrId.equals(other.cobrId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sigemp.server.entity.VtaCobT[ cobrId=" + cobrId + " ]";
    }
    
}
