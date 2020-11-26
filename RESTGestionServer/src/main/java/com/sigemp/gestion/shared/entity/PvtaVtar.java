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
@Table(name = "pvta_vtar")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PvtaVtar.findAll", query = "SELECT p FROM PvtaVtar p")
    , @NamedQuery(name = "PvtaVtar.findByPvtarId", query = "SELECT p FROM PvtaVtar p WHERE p.pvtarId = :pvtarId")
    , @NamedQuery(name = "PvtaVtar.findByAlicuota", query = "SELECT p FROM PvtaVtar p WHERE p.alicuota = :alicuota")
    , @NamedQuery(name = "PvtaVtar.findByCnt", query = "SELECT p FROM PvtaVtar p WHERE p.cnt = :cnt")
    , @NamedQuery(name = "PvtaVtar.findByCosneto", query = "SELECT p FROM PvtaVtar p WHERE p.cosneto = :cosneto")
    , @NamedQuery(name = "PvtaVtar.findByDepoId", query = "SELECT p FROM PvtaVtar p WHERE p.depoId = :depoId")
    , @NamedQuery(name = "PvtaVtar.findByDes", query = "SELECT p FROM PvtaVtar p WHERE p.des = :des")
    , @NamedQuery(name = "PvtaVtar.findByDto", query = "SELECT p FROM PvtaVtar p WHERE p.dto = :dto")
    , @NamedQuery(name = "PvtaVtar.findByPrcciva", query = "SELECT p FROM PvtaVtar p WHERE p.prcciva = :prcciva")
    , @NamedQuery(name = "PvtaVtar.findByRen", query = "SELECT p FROM PvtaVtar p WHERE p.ren = :ren")
    , @NamedQuery(name = "PvtaVtar.findByStkdto", query = "SELECT p FROM PvtaVtar p WHERE p.stkdto = :stkdto")
    , @NamedQuery(name = "PvtaVtar.findByTot", query = "SELECT p FROM PvtaVtar p WHERE p.tot = :tot")
    , @NamedQuery(name = "PvtaVtar.findByTotiva", query = "SELECT p FROM PvtaVtar p WHERE p.totiva = :totiva")
    , @NamedQuery(name = "PvtaVtar.findByTotneto", query = "SELECT p FROM PvtaVtar p WHERE p.totneto = :totneto")})
public class PvtaVtar implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pvtar_id")
    private Integer pvtarId;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "alicuota")
    private BigDecimal alicuota;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cnt")
    private BigDecimal cnt;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cosneto")
    private BigDecimal cosneto;
    @Column(name = "depo_id")
    private Integer depoId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "des")
    private String des;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dto")
    private BigDecimal dto;
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
    @Column(name = "tot")
    private BigDecimal tot;
    @Basic(optional = false)
    @NotNull
    @Column(name = "totiva")
    private BigDecimal totiva;
    @Basic(optional = false)
    @NotNull
    @Column(name = "totneto")
    private BigDecimal totneto;
    @JoinColumn(name = "pvta_id", referencedColumnName = "pvta_id")
    @ManyToOne(optional = false)
    private PvtaVta pvtaId;
    @JoinColumn(name = "art_id", referencedColumnName = "art_id")
    @ManyToOne(optional = false)
    private StkArt artId;

    public PvtaVtar() {
    }

    public PvtaVtar(Integer pvtarId) {
        this.pvtarId = pvtarId;
    }

    public PvtaVtar(Integer pvtarId, BigDecimal alicuota, BigDecimal cnt, BigDecimal cosneto, String des, BigDecimal dto, BigDecimal prcciva, int ren, boolean stkdto, BigDecimal tot, BigDecimal totiva, BigDecimal totneto) {
        this.pvtarId = pvtarId;
        this.alicuota = alicuota;
        this.cnt = cnt;
        this.cosneto = cosneto;
        this.des = des;
        this.dto = dto;
        this.prcciva = prcciva;
        this.ren = ren;
        this.stkdto = stkdto;
        this.tot = tot;
        this.totiva = totiva;
        this.totneto = totneto;
    }

    public Integer getPvtarId() {
        return pvtarId;
    }

    public void setPvtarId(Integer pvtarId) {
        this.pvtarId = pvtarId;
    }

    public BigDecimal getAlicuota() {
        return alicuota;
    }

    public void setAlicuota(BigDecimal alicuota) {
        this.alicuota = alicuota;
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

    public Integer getDepoId() {
        return depoId;
    }

    public void setDepoId(Integer depoId) {
        this.depoId = depoId;
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

    public BigDecimal getTot() {
        return tot;
    }

    public void setTot(BigDecimal tot) {
        this.tot = tot;
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

    public PvtaVta getPvtaId() {
        return pvtaId;
    }

    public void setPvtaId(PvtaVta pvtaId) {
        this.pvtaId = pvtaId;
    }

    public StkArt getArtId() {
        return artId;
    }

    public void setArtId(StkArt artId) {
        this.artId = artId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pvtarId != null ? pvtarId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PvtaVtar)) {
            return false;
        }
        PvtaVtar other = (PvtaVtar) object;
        if ((this.pvtarId == null && other.pvtarId != null) || (this.pvtarId != null && !this.pvtarId.equals(other.pvtarId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sigemp.server.entity.PvtaVtar[ pvtarId=" + pvtarId + " ]";
    }
    
}
