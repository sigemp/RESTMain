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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author cristian
 */
@Entity
@Table(name = "vta_vta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VtaVta.findAll", query = "SELECT v FROM VtaVta v")
    , @NamedQuery(name = "VtaVta.findByVtaId", query = "SELECT v FROM VtaVta v WHERE v.vtaId = :vtaId")
    , @NamedQuery(name = "VtaVta.findByAdelanto", query = "SELECT v FROM VtaVta v WHERE v.adelanto = :adelanto")
    , @NamedQuery(name = "VtaVta.findByAfipObservaciones", query = "SELECT v FROM VtaVta v WHERE v.afipObservaciones = :afipObservaciones")
    , @NamedQuery(name = "VtaVta.findByCae", query = "SELECT v FROM VtaVta v WHERE v.cae = :cae")
    , @NamedQuery(name = "VtaVta.findByCaeFecVto", query = "SELECT v FROM VtaVta v WHERE v.caeFecVto = :caeFecVto")
    , @NamedQuery(name = "VtaVta.findByCuotas", query = "SELECT v FROM VtaVta v WHERE v.cuotas = :cuotas")
    , @NamedQuery(name = "VtaVta.findByDes", query = "SELECT v FROM VtaVta v WHERE v.des = :des")
    , @NamedQuery(name = "VtaVta.findByDto", query = "SELECT v FROM VtaVta v WHERE v.dto = :dto")
    , @NamedQuery(name = "VtaVta.findByEventualDir", query = "SELECT v FROM VtaVta v WHERE v.eventualDir = :eventualDir")
    , @NamedQuery(name = "VtaVta.findByEventualNom", query = "SELECT v FROM VtaVta v WHERE v.eventualNom = :eventualNom")
    , @NamedQuery(name = "VtaVta.findByFec", query = "SELECT v FROM VtaVta v WHERE v.fec = :fec")
    , @NamedQuery(name = "VtaVta.findByFeccan", query = "SELECT v FROM VtaVta v WHERE v.feccan = :feccan")
    , @NamedQuery(name = "VtaVta.findByFecvto", query = "SELECT v FROM VtaVta v WHERE v.fecvto = :fecvto")
    , @NamedQuery(name = "VtaVta.findByFlags", query = "SELECT v FROM VtaVta v WHERE v.flags = :flags")
    , @NamedQuery(name = "VtaVta.findByIdAnula", query = "SELECT v FROM VtaVta v WHERE v.idAnula = :idAnula")
    , @NamedQuery(name = "VtaVta.findByNum", query = "SELECT v FROM VtaVta v WHERE v.num = :num")
    , @NamedQuery(name = "VtaVta.findByPdto", query = "SELECT v FROM VtaVta v WHERE v.pdto = :pdto")
    , @NamedQuery(name = "VtaVta.findByPrc", query = "SELECT v FROM VtaVta v WHERE v.prc = :prc")
    , @NamedQuery(name = "VtaVta.findByPtovta", query = "SELECT v FROM VtaVta v WHERE v.ptovta = :ptovta")
    , @NamedQuery(name = "VtaVta.findByTot", query = "SELECT v FROM VtaVta v WHERE v.tot = :tot")
    , @NamedQuery(name = "VtaVta.findByTotFinanciar", query = "SELECT v FROM VtaVta v WHERE v.totFinanciar = :totFinanciar")
    , @NamedQuery(name = "VtaVta.findByTotGastosFinancieros", query = "SELECT v FROM VtaVta v WHERE v.totGastosFinancieros = :totGastosFinancieros")
    , @NamedQuery(name = "VtaVta.findByTotNeto", query = "SELECT v FROM VtaVta v WHERE v.totNeto = :totNeto")
    , @NamedQuery(name = "VtaVta.findByTotTributo", query = "SELECT v FROM VtaVta v WHERE v.totTributo = :totTributo")
    , @NamedQuery(name = "VtaVta.findByTotIva", query = "SELECT v FROM VtaVta v WHERE v.totIva = :totIva")
    , @NamedQuery(name = "VtaVta.findByTotsal", query = "SELECT v FROM VtaVta v WHERE v.totsal = :totsal")
    , @NamedQuery(name = "VtaVta.findByNroident", query = "SELECT v FROM VtaVta v WHERE v.nroident = :nroident")
    , @NamedQuery(name = "VtaVta.findByRutaId", query = "SELECT v FROM VtaVta v WHERE v.rutaId = :rutaId")})
public class VtaVta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "vta_id")
    private Integer vtaId;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "adelanto")
    private BigDecimal adelanto;
    @Size(max = 255)
    @Column(name = "afip_observaciones")
    private String afipObservaciones;
    @Size(max = 255)
    @Column(name = "cae")
    private String cae;
    @Column(name = "cae_fec_vto")
    @Temporal(TemporalType.DATE)
    private Date caeFecVto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cuotas")
    private int cuotas;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "des")
    private String des;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dto")
    private BigDecimal dto;
    @Size(max = 100)
    @Column(name = "eventual_dir")
    private String eventualDir;
    @Size(max = 100)
    @Column(name = "eventual_nom")
    private String eventualNom;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fec")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fec;
    @Column(name = "feccan")
    @Temporal(TemporalType.TIMESTAMP)
    private Date feccan;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecvto")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecvto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "flags")
    private String flags;
    @Column(name = "id_anula")
    private Integer idAnula;
    @Basic(optional = false)
    @NotNull
    @Column(name = "num")
    private int num;
    @Basic(optional = false)
    @NotNull
    @Column(name = "pdto")
    private BigDecimal pdto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "prc")
    private int prc;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ptovta")
    private int ptovta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tot")
    private BigDecimal tot;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tot_financiar")
    private BigDecimal totFinanciar;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tot_gastos_financieros")
    private BigDecimal totGastosFinancieros;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tot_neto")
    private BigDecimal totNeto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tot_tributo")
    private BigDecimal totTributo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tot_iva")
    private BigDecimal totIva;
    @Basic(optional = false)
    @NotNull
    @Column(name = "totsal")
    private BigDecimal totsal;
    @Column(name = "nroident")
    private BigInteger nroident;
    @Column(name = "ruta_id")
    private Integer rutaId;
    @OneToMany(mappedBy = "vtaId")
    private Collection<PvtaVta> pvtaVtaCollection;
    @OneToMany(mappedBy = "vtaId")
    private Collection<VtaCob> vtaCobCollection;
    @JoinColumn(name = "civa_id", referencedColumnName = "civa_id")
    @ManyToOne(optional = false)
    private GsyCiva civaId;
    @JoinColumn(name = "tdoc_id", referencedColumnName = "tdoc_id")
    @ManyToOne
    private GsyTdoc tdocId;
    @JoinColumn(name = "tc_id", referencedColumnName = "tc_id")
    @ManyToOne(optional = false)
    private GsyTiposcomprobantes tcId;
    @JoinColumn(name = "usr_id", referencedColumnName = "usr_id")
    @ManyToOne(optional = false)
    private GsyUser usrId;
    @JoinColumn(name = "depo_id", referencedColumnName = "depo_id")
    @ManyToOne(optional = false)
    private StkDepositos depoId;
    @JoinColumn(name = "cierre_id", referencedColumnName = "cierre_id")
    @ManyToOne
    private VtaCierres cierreId;
    @JoinColumn(name = "cpg_id", referencedColumnName = "cpg_id")
    @ManyToOne(optional = false)
    private VtaCpg cpgId;
    @JoinColumn(name = "cta_id", referencedColumnName = "cta_id")
    @ManyToOne(optional = false)
    private VtaCta ctaId;
    @JoinColumn(name = "ven_id", referencedColumnName = "ven_id")
    @ManyToOne(optional = false)
    private VtaVen venId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vtaId")
    private Collection<VtaVtaAlicuota> vtaVtaAlicuotaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vtaId")
    private Collection<VtaVtaTributo> vtaVtaTributoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vtaId")
    private Collection<VtaVtag> vtaVtagCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vtaId")
    private Collection<VtaVtap> vtaVtapCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vtaId")
    private Collection<VtaVtar> vtaVtarCollection;
    @OneToMany(mappedBy = "vtaId")
    private Collection<StkPArtbonHistorial> stkPArtbonHistorialCollection;

    public VtaVta() {
    }

    public VtaVta(Integer vtaId) {
        this.vtaId = vtaId;
    }

    public VtaVta(Integer vtaId, BigDecimal adelanto, int cuotas, String des, BigDecimal dto, Date fec, Date fecvto, String flags, int num, BigDecimal pdto, int prc, int ptovta, BigDecimal tot, BigDecimal totFinanciar, BigDecimal totGastosFinancieros, BigDecimal totNeto, BigDecimal totTributo, BigDecimal totIva, BigDecimal totsal) {
        this.vtaId = vtaId;
        this.adelanto = adelanto;
        this.cuotas = cuotas;
        this.des = des;
        this.dto = dto;
        this.fec = fec;
        this.fecvto = fecvto;
        this.flags = flags;
        this.num = num;
        this.pdto = pdto;
        this.prc = prc;
        this.ptovta = ptovta;
        this.tot = tot;
        this.totFinanciar = totFinanciar;
        this.totGastosFinancieros = totGastosFinancieros;
        this.totNeto = totNeto;
        this.totTributo = totTributo;
        this.totIva = totIva;
        this.totsal = totsal;
    }

    public Integer getVtaId() {
        return vtaId;
    }

    public void setVtaId(Integer vtaId) {
        this.vtaId = vtaId;
    }

    public BigDecimal getAdelanto() {
        return adelanto;
    }

    public void setAdelanto(BigDecimal adelanto) {
        this.adelanto = adelanto;
    }

    public String getAfipObservaciones() {
        return afipObservaciones;
    }

    public void setAfipObservaciones(String afipObservaciones) {
        this.afipObservaciones = afipObservaciones;
    }

    public String getCae() {
        return cae;
    }

    public void setCae(String cae) {
        this.cae = cae;
    }

    public Date getCaeFecVto() {
        return caeFecVto;
    }

    public void setCaeFecVto(Date caeFecVto) {
        this.caeFecVto = caeFecVto;
    }

    public int getCuotas() {
        return cuotas;
    }

    public void setCuotas(int cuotas) {
        this.cuotas = cuotas;
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

    public String getEventualDir() {
        return eventualDir;
    }

    public void setEventualDir(String eventualDir) {
        this.eventualDir = eventualDir;
    }

    public String getEventualNom() {
        return eventualNom;
    }

    public void setEventualNom(String eventualNom) {
        this.eventualNom = eventualNom;
    }

    public Date getFec() {
        return fec;
    }

    public void setFec(Date fec) {
        this.fec = fec;
    }

    public Date getFeccan() {
        return feccan;
    }

    public void setFeccan(Date feccan) {
        this.feccan = feccan;
    }

    public Date getFecvto() {
        return fecvto;
    }

    public void setFecvto(Date fecvto) {
        this.fecvto = fecvto;
    }

    public String getFlags() {
        return flags;
    }

    public void setFlags(String flags) {
        this.flags = flags;
    }

    public Integer getIdAnula() {
        return idAnula;
    }

    public void setIdAnula(Integer idAnula) {
        this.idAnula = idAnula;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public BigDecimal getPdto() {
        return pdto;
    }

    public void setPdto(BigDecimal pdto) {
        this.pdto = pdto;
    }

    public int getPrc() {
        return prc;
    }

    public void setPrc(int prc) {
        this.prc = prc;
    }

    public int getPtovta() {
        return ptovta;
    }

    public void setPtovta(int ptovta) {
        this.ptovta = ptovta;
    }

    public BigDecimal getTot() {
        return tot;
    }

    public void setTot(BigDecimal tot) {
        this.tot = tot;
    }

    public BigDecimal getTotFinanciar() {
        return totFinanciar;
    }

    public void setTotFinanciar(BigDecimal totFinanciar) {
        this.totFinanciar = totFinanciar;
    }

    public BigDecimal getTotGastosFinancieros() {
        return totGastosFinancieros;
    }

    public void setTotGastosFinancieros(BigDecimal totGastosFinancieros) {
        this.totGastosFinancieros = totGastosFinancieros;
    }

    public BigDecimal getTotNeto() {
        return totNeto;
    }

    public void setTotNeto(BigDecimal totNeto) {
        this.totNeto = totNeto;
    }

    public BigDecimal getTotTributo() {
        return totTributo;
    }

    public void setTotTributo(BigDecimal totTributo) {
        this.totTributo = totTributo;
    }

    public BigDecimal getTotIva() {
        return totIva;
    }

    public void setTotIva(BigDecimal totIva) {
        this.totIva = totIva;
    }

    public BigDecimal getTotsal() {
        return totsal;
    }

    public void setTotsal(BigDecimal totsal) {
        this.totsal = totsal;
    }

    public BigInteger getNroident() {
        return nroident;
    }

    public void setNroident(BigInteger nroident) {
        this.nroident = nroident;
    }

    public Integer getRutaId() {
        return rutaId;
    }

    public void setRutaId(Integer rutaId) {
        this.rutaId = rutaId;
    }

    @XmlTransient
    public Collection<PvtaVta> getPvtaVtaCollection() {
        return pvtaVtaCollection;
    }

    public void setPvtaVtaCollection(Collection<PvtaVta> pvtaVtaCollection) {
        this.pvtaVtaCollection = pvtaVtaCollection;
    }

    @XmlTransient
    public Collection<VtaCob> getVtaCobCollection() {
        return vtaCobCollection;
    }

    public void setVtaCobCollection(Collection<VtaCob> vtaCobCollection) {
        this.vtaCobCollection = vtaCobCollection;
    }

    public GsyCiva getCivaId() {
        return civaId;
    }

    public void setCivaId(GsyCiva civaId) {
        this.civaId = civaId;
    }

    public GsyTdoc getTdocId() {
        return tdocId;
    }

    public void setTdocId(GsyTdoc tdocId) {
        this.tdocId = tdocId;
    }

    public GsyTiposcomprobantes getTcId() {
        return tcId;
    }

    public void setTcId(GsyTiposcomprobantes tcId) {
        this.tcId = tcId;
    }

    public GsyUser getUsrId() {
        return usrId;
    }

    public void setUsrId(GsyUser usrId) {
        this.usrId = usrId;
    }

    public StkDepositos getDepoId() {
        return depoId;
    }

    public void setDepoId(StkDepositos depoId) {
        this.depoId = depoId;
    }

    public VtaCierres getCierreId() {
        return cierreId;
    }

    public void setCierreId(VtaCierres cierreId) {
        this.cierreId = cierreId;
    }

    public VtaCpg getCpgId() {
        return cpgId;
    }

    public void setCpgId(VtaCpg cpgId) {
        this.cpgId = cpgId;
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

    @XmlTransient
    public Collection<VtaVtaAlicuota> getVtaVtaAlicuotaCollection() {
        return vtaVtaAlicuotaCollection;
    }

    public void setVtaVtaAlicuotaCollection(Collection<VtaVtaAlicuota> vtaVtaAlicuotaCollection) {
        this.vtaVtaAlicuotaCollection = vtaVtaAlicuotaCollection;
    }

    @XmlTransient
    public Collection<VtaVtaTributo> getVtaVtaTributoCollection() {
        return vtaVtaTributoCollection;
    }

    public void setVtaVtaTributoCollection(Collection<VtaVtaTributo> vtaVtaTributoCollection) {
        this.vtaVtaTributoCollection = vtaVtaTributoCollection;
    }

    @XmlTransient
    public Collection<VtaVtag> getVtaVtagCollection() {
        return vtaVtagCollection;
    }

    public void setVtaVtagCollection(Collection<VtaVtag> vtaVtagCollection) {
        this.vtaVtagCollection = vtaVtagCollection;
    }

    @XmlTransient
    public Collection<VtaVtap> getVtaVtapCollection() {
        return vtaVtapCollection;
    }

    public void setVtaVtapCollection(Collection<VtaVtap> vtaVtapCollection) {
        this.vtaVtapCollection = vtaVtapCollection;
    }

    @XmlTransient
    public Collection<VtaVtar> getVtaVtarCollection() {
        return vtaVtarCollection;
    }

    public void setVtaVtarCollection(Collection<VtaVtar> vtaVtarCollection) {
        this.vtaVtarCollection = vtaVtarCollection;
    }

    @XmlTransient
    public Collection<StkPArtbonHistorial> getStkPArtbonHistorialCollection() {
        return stkPArtbonHistorialCollection;
    }

    public void setStkPArtbonHistorialCollection(Collection<StkPArtbonHistorial> stkPArtbonHistorialCollection) {
        this.stkPArtbonHistorialCollection = stkPArtbonHistorialCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (vtaId != null ? vtaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VtaVta)) {
            return false;
        }
        VtaVta other = (VtaVta) object;
        if ((this.vtaId == null && other.vtaId != null) || (this.vtaId != null && !this.vtaId.equals(other.vtaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sigemp.server.entity.VtaVta[ vtaId=" + vtaId + " ]";
    }
    
}
