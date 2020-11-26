/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigemp.gestion.shared.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author cristian
 */
@Entity
@Table(name = "pvta_vta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PvtaVta.findAll", query = "SELECT p FROM PvtaVta p")
    , @NamedQuery(name = "PvtaVta.findByPvtaId", query = "SELECT p FROM PvtaVta p WHERE p.pvtaId = :pvtaId")
    , @NamedQuery(name = "PvtaVta.findByCpgId", query = "SELECT p FROM PvtaVta p WHERE p.cpgId = :cpgId")
    , @NamedQuery(name = "PvtaVta.findByDto", query = "SELECT p FROM PvtaVta p WHERE p.dto = :dto")
    , @NamedQuery(name = "PvtaVta.findByFec", query = "SELECT p FROM PvtaVta p WHERE p.fec = :fec")
    , @NamedQuery(name = "PvtaVta.findByPdto", query = "SELECT p FROM PvtaVta p WHERE p.pdto = :pdto")
    , @NamedQuery(name = "PvtaVta.findByTot", query = "SELECT p FROM PvtaVta p WHERE p.tot = :tot")
    , @NamedQuery(name = "PvtaVta.findByTotIva", query = "SELECT p FROM PvtaVta p WHERE p.totIva = :totIva")
    , @NamedQuery(name = "PvtaVta.findByTotNeto", query = "SELECT p FROM PvtaVta p WHERE p.totNeto = :totNeto")
    , @NamedQuery(name = "PvtaVta.findByUsrId", query = "SELECT p FROM PvtaVta p WHERE p.usrId = :usrId")
    , @NamedQuery(name = "PvtaVta.findByOrdenVenta", query = "SELECT p FROM PvtaVta p WHERE p.ordenVenta = :ordenVenta")
    , @NamedQuery(name = "PvtaVta.findByNroident", query = "SELECT p FROM PvtaVta p WHERE p.nroident = :nroident")})
public class PvtaVta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pvta_id")
    private Integer pvtaId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cpg_id")
    private int cpgId;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "dto")
    private BigDecimal dto;
    @Column(name = "fec")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fec;
    @Basic(optional = false)
    @NotNull
    @Column(name = "pdto")
    private BigDecimal pdto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tot")
    private BigDecimal tot;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tot_iva")
    private BigDecimal totIva;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tot_neto")
    private BigDecimal totNeto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "usr_id")
    private int usrId;
    @Column(name = "orden_venta")
    private Integer ordenVenta;
    @Column(name = "nroident")
    private BigInteger nroident;
    @JoinColumn(name = "civa_id", referencedColumnName = "civa_id")
    @ManyToOne(optional = false)
    private GsyCiva civaId;
    @JoinColumn(name = "entrega_id", referencedColumnName = "entrega_id")
    @ManyToOne(optional = false)
    private PvtaEntrega entregaId;
    @JoinColumn(name = "ruta_id", referencedColumnName = "ruta_id")
    @ManyToOne(optional = false)
    private PvtaRuta rutaId;
    @JoinColumn(name = "cta_id", referencedColumnName = "cta_id")
    @ManyToOne(optional = false)
    private VtaCta ctaId;
    @JoinColumn(name = "ven_id", referencedColumnName = "ven_id")
    @ManyToOne
    private VtaVen venId;
    @JoinColumn(name = "vta_id", referencedColumnName = "vta_id")
    @ManyToOne
    private VtaVta vtaId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pvtaId")
    private Collection<PvtaVtar> pvtaVtarCollection;

    public PvtaVta() {
    }

    public PvtaVta(Integer pvtaId) {
        this.pvtaId = pvtaId;
    }

    public PvtaVta(Integer pvtaId, int cpgId, BigDecimal dto, BigDecimal pdto, BigDecimal tot, BigDecimal totIva, BigDecimal totNeto, int usrId) {
        this.pvtaId = pvtaId;
        this.cpgId = cpgId;
        this.dto = dto;
        this.pdto = pdto;
        this.tot = tot;
        this.totIva = totIva;
        this.totNeto = totNeto;
        this.usrId = usrId;
    }

    public Integer getPvtaId() {
        return pvtaId;
    }

    public void setPvtaId(Integer pvtaId) {
        this.pvtaId = pvtaId;
    }

    public int getCpgId() {
        return cpgId;
    }

    public void setCpgId(int cpgId) {
        this.cpgId = cpgId;
    }

    public BigDecimal getDto() {
        return dto;
    }

    public void setDto(BigDecimal dto) {
        this.dto = dto;
    }

    public Date getFec() {
        return fec;
    }

    public void setFec(Date fec) {
        this.fec = fec;
    }

    public BigDecimal getPdto() {
        return pdto;
    }

    public void setPdto(BigDecimal pdto) {
        this.pdto = pdto;
    }

    public BigDecimal getTot() {
        return tot;
    }

    public void setTot(BigDecimal tot) {
        this.tot = tot;
    }

    public BigDecimal getTotIva() {
        return totIva;
    }

    public void setTotIva(BigDecimal totIva) {
        this.totIva = totIva;
    }

    public BigDecimal getTotNeto() {
        return totNeto;
    }

    public void setTotNeto(BigDecimal totNeto) {
        this.totNeto = totNeto;
    }

    public int getUsrId() {
        return usrId;
    }

    public void setUsrId(int usrId) {
        this.usrId = usrId;
    }

    public Integer getOrdenVenta() {
        return ordenVenta;
    }

    public void setOrdenVenta(Integer ordenVenta) {
        this.ordenVenta = ordenVenta;
    }

    public BigInteger getNroident() {
        return nroident;
    }

    public void setNroident(BigInteger nroident) {
        this.nroident = nroident;
    }

    public GsyCiva getCivaId() {
        return civaId;
    }

    public void setCivaId(GsyCiva civaId) {
        this.civaId = civaId;
    }

    public PvtaEntrega getEntregaId() {
        return entregaId;
    }

    public void setEntregaId(PvtaEntrega entregaId) {
        this.entregaId = entregaId;
    }

    public PvtaRuta getRutaId() {
        return rutaId;
    }

    public void setRutaId(PvtaRuta rutaId) {
        this.rutaId = rutaId;
    }

    public VtaCta getCtaId() {
        return ctaId;
    }

    public void setCtaId(VtaCta ctaId) {
        this.ctaId = ctaId;
    }

    public VtaVen getVenId() {
        return venId;
    }

    public void setVenId(VtaVen venId) {
        this.venId = venId;
    }

    public VtaVta getVtaId() {
        return vtaId;
    }

    public void setVtaId(VtaVta vtaId) {
        this.vtaId = vtaId;
    }

    @XmlTransient
    public Collection<PvtaVtar> getPvtaVtarCollection() {
        return pvtaVtarCollection;
    }

    public void setPvtaVtarCollection(Collection<PvtaVtar> pvtaVtarCollection) {
        this.pvtaVtarCollection = pvtaVtarCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pvtaId != null ? pvtaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PvtaVta)) {
            return false;
        }
        PvtaVta other = (PvtaVta) object;
        if ((this.pvtaId == null && other.pvtaId != null) || (this.pvtaId != null && !this.pvtaId.equals(other.pvtaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sigemp.server.entity.PvtaVta[ pvtaId=" + pvtaId + " ]";
    }
    
}
