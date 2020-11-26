/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigemp.gestion.shared.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "vta_cobr")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VtaCobr.findAll", query = "SELECT v FROM VtaCobr v")
    , @NamedQuery(name = "VtaCobr.findByCobrId", query = "SELECT v FROM VtaCobr v WHERE v.cobrId = :cobrId")
    , @NamedQuery(name = "VtaCobr.findByObs", query = "SELECT v FROM VtaCobr v WHERE v.obs = :obs")
    , @NamedQuery(name = "VtaCobr.findByRen", query = "SELECT v FROM VtaCobr v WHERE v.ren = :ren")
    , @NamedQuery(name = "VtaCobr.findByTipo", query = "SELECT v FROM VtaCobr v WHERE v.tipo = :tipo")
    , @NamedQuery(name = "VtaCobr.findByTot", query = "SELECT v FROM VtaCobr v WHERE v.tot = :tot")})
public class VtaCobr implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cobr_id")
    private Integer cobrId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 400)
    @Column(name = "obs")
    private String obs;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ren")
    private int ren;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "tipo")
    private String tipo;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "tot")
    private BigDecimal tot;
    @JoinColumn(name = "cob_id", referencedColumnName = "cob_id")
    @ManyToOne(optional = false)
    private VtaCob cobId;
    @JoinColumn(name = "mc_id", referencedColumnName = "mc_id")
    @ManyToOne(optional = false)
    private VtaMc mcId;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "vtaCobr")
    private VtaCobM vtaCobM;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "vtaCobr")
    private VtaCobT vtaCobT;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "vtaCobr")
    private VtaCobC vtaCobC;

    public VtaCobr() {
    }

    public VtaCobr(Integer cobrId) {
        this.cobrId = cobrId;
    }

    public VtaCobr(Integer cobrId, String obs, int ren, String tipo, BigDecimal tot) {
        this.cobrId = cobrId;
        this.obs = obs;
        this.ren = ren;
        this.tipo = tipo;
        this.tot = tot;
    }

    public Integer getCobrId() {
        return cobrId;
    }

    public void setCobrId(Integer cobrId) {
        this.cobrId = cobrId;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public int getRen() {
        return ren;
    }

    public void setRen(int ren) {
        this.ren = ren;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public BigDecimal getTot() {
        return tot;
    }

    public void setTot(BigDecimal tot) {
        this.tot = tot;
    }

    public VtaCob getCobId() {
        return cobId;
    }

    public void setCobId(VtaCob cobId) {
        this.cobId = cobId;
    }

    public VtaMc getMcId() {
        return mcId;
    }

    public void setMcId(VtaMc mcId) {
        this.mcId = mcId;
    }

    public VtaCobM getVtaCobM() {
        return vtaCobM;
    }

    public void setVtaCobM(VtaCobM vtaCobM) {
        this.vtaCobM = vtaCobM;
    }

    public VtaCobT getVtaCobT() {
        return vtaCobT;
    }

    public void setVtaCobT(VtaCobT vtaCobT) {
        this.vtaCobT = vtaCobT;
    }

    public VtaCobC getVtaCobC() {
        return vtaCobC;
    }

    public void setVtaCobC(VtaCobC vtaCobC) {
        this.vtaCobC = vtaCobC;
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
        if (!(object instanceof VtaCobr)) {
            return false;
        }
        VtaCobr other = (VtaCobr) object;
        if ((this.cobrId == null && other.cobrId != null) || (this.cobrId != null && !this.cobrId.equals(other.cobrId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sigemp.server.entity.VtaCobr[ cobrId=" + cobrId + " ]";
    }
    
}
