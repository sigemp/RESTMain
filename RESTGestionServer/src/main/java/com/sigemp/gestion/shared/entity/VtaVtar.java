/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigemp.gestion.shared.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "vta_vtar")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VtaVtar.findAll", query = "SELECT v FROM VtaVtar v")
    , @NamedQuery(name = "VtaVtar.findByVtarId", query = "SELECT v FROM VtaVtar v WHERE v.vtarId = :vtarId")
    , @NamedQuery(name = "VtaVtar.findByAlicuota", query = "SELECT v FROM VtaVtar v WHERE v.alicuota = :alicuota")
    , @NamedQuery(name = "VtaVtar.findByBonificacion", query = "SELECT v FROM VtaVtar v WHERE v.bonificacion = :bonificacion")
    , @NamedQuery(name = "VtaVtar.findByCnt", query = "SELECT v FROM VtaVtar v WHERE v.cnt = :cnt")
    , @NamedQuery(name = "VtaVtar.findByCosneto", query = "SELECT v FROM VtaVtar v WHERE v.cosneto = :cosneto")
    , @NamedQuery(name = "VtaVtar.findByDes", query = "SELECT v FROM VtaVtar v WHERE v.des = :des")
    , @NamedQuery(name = "VtaVtar.findByDto", query = "SELECT v FROM VtaVtar v WHERE v.dto = :dto")
    , @NamedQuery(name = "VtaVtar.findByDtounidad", query = "SELECT v FROM VtaVtar v WHERE v.dtounidad = :dtounidad")
    , @NamedQuery(name = "VtaVtar.findByPrcciva", query = "SELECT v FROM VtaVtar v WHERE v.prcciva = :prcciva")
    , @NamedQuery(name = "VtaVtar.findByRen", query = "SELECT v FROM VtaVtar v WHERE v.ren = :ren")
    , @NamedQuery(name = "VtaVtar.findByStkdto", query = "SELECT v FROM VtaVtar v WHERE v.stkdto = :stkdto")
    , @NamedQuery(name = "VtaVtar.findByTotiva", query = "SELECT v FROM VtaVtar v WHERE v.totiva = :totiva")
    , @NamedQuery(name = "VtaVtar.findByTotneto", query = "SELECT v FROM VtaVtar v WHERE v.totneto = :totneto")})
public class VtaVtar implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "vtar_id")
    private Integer vtarId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "alicuota")
    private BigInteger alicuota;
    @Basic(optional = false)
    @NotNull
    @Column(name = "bonificacion")
    private boolean bonificacion;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "cnt")
    private BigDecimal cnt;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cosneto")
    private BigDecimal cosneto;
    @Size(max = 100)
    @Column(name = "des")
    private String des;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dto")
    private BigDecimal dto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dtounidad")
    private BigDecimal dtounidad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "prcciva")
    private BigDecimal prcciva;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ren")
    private int ren;
    @Basic(optional = false)
    @NotNull
    @Column(name = "stkdto")
    private boolean stkdto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "totiva")
    private BigDecimal totiva;
    @Basic(optional = false)
    @NotNull
    @Column(name = "totneto")
    private BigDecimal totneto;
    @JoinColumn(name = "art_id", referencedColumnName = "art_id")
    @ManyToOne(optional = false)
    private StkArt artId;
    @JoinColumn(name = "depo_id", referencedColumnName = "depo_id")
    @ManyToOne(optional = false)
    private StkDepositos depoId;
    @JoinColumn(name = "vta_id", referencedColumnName = "vta_id")
    @ManyToOne(optional = false)
    private VtaVta vtaId;

    public VtaVtar() {
    }

    public VtaVtar(Integer vtarId) {
        this.vtarId = vtarId;
    }

    public VtaVtar(Integer vtarId, BigInteger alicuota, boolean bonificacion, BigDecimal cnt, BigDecimal cosneto, BigDecimal dto, BigDecimal dtounidad, BigDecimal prcciva, int ren, boolean stkdto, BigDecimal totiva, BigDecimal totneto) {
        this.vtarId = vtarId;
        this.alicuota = alicuota;
        this.bonificacion = bonificacion;
        this.cnt = cnt;
        this.cosneto = cosneto;
        this.dto = dto;
        this.dtounidad = dtounidad;
        this.prcciva = prcciva;
        this.ren = ren;
        this.stkdto = stkdto;
        this.totiva = totiva;
        this.totneto = totneto;
    }

    public Integer getVtarId() {
        return vtarId;
    }

    public void setVtarId(Integer vtarId) {
        this.vtarId = vtarId;
    }

    public BigInteger getAlicuota() {
        return alicuota;
    }

    public void setAlicuota(BigInteger alicuota) {
        this.alicuota = alicuota;
    }

    public boolean getBonificacion() {
        return bonificacion;
    }

    public void setBonificacion(boolean bonificacion) {
        this.bonificacion = bonificacion;
    }

    public BigDecimal getCnt() {
        return cnt;
    }

    public void setCnt(BigDecimal cnt) {
        this.cnt = cnt;
    }

    public BigDecimal getCosneto() {
        return cosneto;
    }

    public void setCosneto(BigDecimal cosneto) {
        this.cosneto = cosneto;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public BigDecimal getDto() {
        return dto;
    }

    public void setDto(BigDecimal dto) {
        this.dto = dto;
    }

    public BigDecimal getDtounidad() {
        return dtounidad;
    }

    public void setDtounidad(BigDecimal dtounidad) {
        this.dtounidad = dtounidad;
    }

    public BigDecimal getPrcciva() {
        return prcciva;
    }

    public void setPrcciva(BigDecimal prcciva) {
        this.prcciva = prcciva;
    }

    public int getRen() {
        return ren;
    }

    public void setRen(int ren) {
        this.ren = ren;
    }

    public boolean getStkdto() {
        return stkdto;
    }

    public void setStkdto(boolean stkdto) {
        this.stkdto = stkdto;
    }

    public BigDecimal getTotiva() {
        return totiva;
    }

    public void setTotiva(BigDecimal totiva) {
        this.totiva = totiva;
    }

    public BigDecimal getTotneto() {
        return totneto;
    }

    public void setTotneto(BigDecimal totneto) {
        this.totneto = totneto;
    }

    public StkArt getArtId() {
        return artId;
    }

    public void setArtId(StkArt artId) {
        this.artId = artId;
    }

    public StkDepositos getDepoId() {
        return depoId;
    }

    public void setDepoId(StkDepositos depoId) {
        this.depoId = depoId;
    }

    public VtaVta getVtaId() {
        return vtaId;
    }

    public void setVtaId(VtaVta vtaId) {
        this.vtaId = vtaId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (vtarId != null ? vtarId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VtaVtar)) {
            return false;
        }
        VtaVtar other = (VtaVtar) object;
        if ((this.vtarId == null && other.vtarId != null) || (this.vtarId != null && !this.vtarId.equals(other.vtarId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sigemp.server.entity.VtaVtar[ vtarId=" + vtarId + " ]";
    }
    
}
