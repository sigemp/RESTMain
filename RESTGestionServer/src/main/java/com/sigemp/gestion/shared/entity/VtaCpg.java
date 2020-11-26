/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigemp.gestion.shared.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "vta_cpg")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VtaCpg.findAll", query = "SELECT v FROM VtaCpg v")
    , @NamedQuery(name = "VtaCpg.findByCpgId", query = "SELECT v FROM VtaCpg v WHERE v.cpgId = :cpgId")
    , @NamedQuery(name = "VtaCpg.findByDes", query = "SELECT v FROM VtaCpg v WHERE v.des = :des")
    , @NamedQuery(name = "VtaCpg.findByDtodes", query = "SELECT v FROM VtaCpg v WHERE v.dtodes = :dtodes")
    , @NamedQuery(name = "VtaCpg.findByDtohas", query = "SELECT v FROM VtaCpg v WHERE v.dtohas = :dtohas")
    , @NamedQuery(name = "VtaCpg.findByEncuotas", query = "SELECT v FROM VtaCpg v WHERE v.encuotas = :encuotas")
    , @NamedQuery(name = "VtaCpg.findByIncrementaprc", query = "SELECT v FROM VtaCpg v WHERE v.incrementaprc = :incrementaprc")
    , @NamedQuery(name = "VtaCpg.findByIntervalodias", query = "SELECT v FROM VtaCpg v WHERE v.intervalodias = :intervalodias")
    , @NamedQuery(name = "VtaCpg.findByPrc", query = "SELECT v FROM VtaCpg v WHERE v.prc = :prc")
    , @NamedQuery(name = "VtaCpg.findByStkdto", query = "SELECT v FROM VtaCpg v WHERE v.stkdto = :stkdto")})
public class VtaCpg implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cpg_id")
    private Integer cpgId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "des")
    private String des;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "dtodes")
    private BigDecimal dtodes;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dtohas")
    private BigDecimal dtohas;
    @Basic(optional = false)
    @NotNull
    @Column(name = "encuotas")
    private boolean encuotas;
    @Basic(optional = false)
    @NotNull
    @Column(name = "incrementaprc")
    private BigDecimal incrementaprc;
    @Basic(optional = false)
    @NotNull
    @Column(name = "intervalodias")
    private int intervalodias;
    @Basic(optional = false)
    @NotNull
    @Column(name = "prc")
    private int prc;
    @Basic(optional = false)
    @NotNull
    @Column(name = "stkdto")
    private boolean stkdto;

    public VtaCpg() {
    }

    public VtaCpg(Integer cpgId) {
        this.cpgId = cpgId;
    }

    public VtaCpg(Integer cpgId, String des, BigDecimal dtodes, BigDecimal dtohas, boolean encuotas, BigDecimal incrementaprc, int intervalodias, int prc, boolean stkdto) {
        this.cpgId = cpgId;
        this.des = des;
        this.dtodes = dtodes;
        this.dtohas = dtohas;
        this.encuotas = encuotas;
        this.incrementaprc = incrementaprc;
        this.intervalodias = intervalodias;
        this.prc = prc;
        this.stkdto = stkdto;
    }

    public Integer getCpgId() {
        return cpgId;
    }

    public void setCpgId(Integer cpgId) {
        this.cpgId = cpgId;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public BigDecimal getDtodes() {
        return dtodes;
    }

    public void setDtodes(BigDecimal dtodes) {
        this.dtodes = dtodes;
    }

    public BigDecimal getDtohas() {
        return dtohas;
    }

    public void setDtohas(BigDecimal dtohas) {
        this.dtohas = dtohas;
    }

    public boolean getEncuotas() {
        return encuotas;
    }

    public void setEncuotas(boolean encuotas) {
        this.encuotas = encuotas;
    }

    public BigDecimal getIncrementaprc() {
        return incrementaprc;
    }

    public void setIncrementaprc(BigDecimal incrementaprc) {
        this.incrementaprc = incrementaprc;
    }

    public int getIntervalodias() {
        return intervalodias;
    }

    public void setIntervalodias(int intervalodias) {
        this.intervalodias = intervalodias;
    }

    public int getPrc() {
        return prc;
    }

    public void setPrc(int prc) {
        this.prc = prc;
    }

    public boolean getStkdto() {
        return stkdto;
    }

    public void setStkdto(boolean stkdto) {
        this.stkdto = stkdto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cpgId != null ? cpgId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VtaCpg)) {
            return false;
        }
        VtaCpg other = (VtaCpg) object;
        if ((this.cpgId == null && other.cpgId != null) || (this.cpgId != null && !this.cpgId.equals(other.cpgId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sigemp.server.entity.VtaCpg[ cpgId=" + cpgId + " ]";
    }
    
}
