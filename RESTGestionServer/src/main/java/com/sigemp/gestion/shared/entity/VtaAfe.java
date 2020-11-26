/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigemp.gestion.shared.entity;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "vta_afe")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VtaAfe.findAll", query = "SELECT v FROM VtaAfe v")
    , @NamedQuery(name = "VtaAfe.findByAfeId", query = "SELECT v FROM VtaAfe v WHERE v.afeId = :afeId")
    , @NamedQuery(name = "VtaAfe.findByAId", query = "SELECT v FROM VtaAfe v WHERE v.aId = :aId")
    , @NamedQuery(name = "VtaAfe.findByATable", query = "SELECT v FROM VtaAfe v WHERE v.aTable = :aTable")
    , @NamedQuery(name = "VtaAfe.findByBId", query = "SELECT v FROM VtaAfe v WHERE v.bId = :bId")
    , @NamedQuery(name = "VtaAfe.findByBTable", query = "SELECT v FROM VtaAfe v WHERE v.bTable = :bTable")
    , @NamedQuery(name = "VtaAfe.findByFec", query = "SELECT v FROM VtaAfe v WHERE v.fec = :fec")
    , @NamedQuery(name = "VtaAfe.findBySucId", query = "SELECT v FROM VtaAfe v WHERE v.sucId = :sucId")
    , @NamedQuery(name = "VtaAfe.findByTot", query = "SELECT v FROM VtaAfe v WHERE v.tot = :tot")})
public class VtaAfe implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "afe_id")
    private Integer afeId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "a_id")
    private int aId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "a_table")
    private Character aTable;
    @Basic(optional = false)
    @NotNull
    @Column(name = "b_id")
    private int bId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "b_table")
    private Character bTable;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fec")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fec;
    @Basic(optional = false)
    @NotNull
    @Column(name = "suc_id")
    private int sucId;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "tot")
    private BigDecimal tot;

    public VtaAfe() {
    }

    public VtaAfe(Integer afeId) {
        this.afeId = afeId;
    }

    public VtaAfe(Integer afeId, int aId, Character aTable, int bId, Character bTable, Date fec, int sucId, BigDecimal tot) {
        this.afeId = afeId;
        this.aId = aId;
        this.aTable = aTable;
        this.bId = bId;
        this.bTable = bTable;
        this.fec = fec;
        this.sucId = sucId;
        this.tot = tot;
    }

    public Integer getAfeId() {
        return afeId;
    }

    public void setAfeId(Integer afeId) {
        this.afeId = afeId;
    }

    public int getAId() {
        return aId;
    }

    public void setAId(int aId) {
        this.aId = aId;
    }

    public Character getATable() {
        return aTable;
    }

    public void setATable(Character aTable) {
        this.aTable = aTable;
    }

    public int getBId() {
        return bId;
    }

    public void setBId(int bId) {
        this.bId = bId;
    }

    public Character getBTable() {
        return bTable;
    }

    public void setBTable(Character bTable) {
        this.bTable = bTable;
    }

    public Date getFec() {
        return fec;
    }

    public void setFec(Date fec) {
        this.fec = fec;
    }

    public int getSucId() {
        return sucId;
    }

    public void setSucId(int sucId) {
        this.sucId = sucId;
    }

    public BigDecimal getTot() {
        return tot;
    }

    public void setTot(BigDecimal tot) {
        this.tot = tot;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (afeId != null ? afeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VtaAfe)) {
            return false;
        }
        VtaAfe other = (VtaAfe) object;
        if ((this.afeId == null && other.afeId != null) || (this.afeId != null && !this.afeId.equals(other.afeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sigemp.server.entity.VtaAfe[ afeId=" + afeId + " ]";
    }
    
}
