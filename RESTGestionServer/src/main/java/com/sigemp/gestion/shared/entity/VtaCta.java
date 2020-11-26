/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigemp.gestion.shared.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "vta_cta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VtaCta.findAll", query = "SELECT v FROM VtaCta v"),
    @NamedQuery(name = "VtaCta.findByActivo", query = "SELECT v FROM VtaCta v WHERE v.activo = :activo"),
    @NamedQuery(name = "VtaCta.findByBaja", query = "SELECT v FROM VtaCta v WHERE v.baja = :baja"),
    @NamedQuery(name = "VtaCta.findByCondicionRentas", query = "SELECT v FROM VtaCta v WHERE v.condicionRentas = :condicionRentas"),
    @NamedQuery(name = "VtaCta.findByContribuyenteMunicipal", query = "SELECT v FROM VtaCta v WHERE v.contribuyenteMunicipal = :contribuyenteMunicipal"),
    @NamedQuery(name = "VtaCta.findByCtaId", query = "SELECT v FROM VtaCta v WHERE v.ctaId = :ctaId"),
    @NamedQuery(name = "VtaCta.findByDomemp", query = "SELECT v FROM VtaCta v WHERE v.domemp = :domemp"),
    @NamedQuery(name = "VtaCta.findByEmpleo", query = "SELECT v FROM VtaCta v WHERE v.empleo = :empleo"),
    @NamedQuery(name = "VtaCta.findByFeccan", query = "SELECT v FROM VtaCta v WHERE v.feccan = :feccan"),
    @NamedQuery(name = "VtaCta.findByFecesp", query = "SELECT v FROM VtaCta v WHERE v.fecesp = :fecesp"),
    @NamedQuery(name = "VtaCta.findByFecest", query = "SELECT v FROM VtaCta v WHERE v.fecest = :fecest"),
    @NamedQuery(name = "VtaCta.findByFpgPredefinida", query = "SELECT v FROM VtaCta v WHERE v.fpgPredefinida = :fpgPredefinida"),
    @NamedQuery(name = "VtaCta.findByOrdenRuta", query = "SELECT v FROM VtaCta v WHERE v.ordenRuta = :ordenRuta"),
    @NamedQuery(name = "VtaCta.findByPermiteCambioCpg", query = "SELECT v FROM VtaCta v WHERE v.permiteCambioCpg = :permiteCambioCpg"),
    @NamedQuery(name = "VtaCta.findByTotsal", query = "SELECT v FROM VtaCta v WHERE v.totsal = :totsal"),
    @NamedQuery(name = "VtaCta.findByUltvto", query = "SELECT v FROM VtaCta v WHERE v.ultvto = :ultvto"),
    @NamedQuery(name = "VtaCta.findByNumprc", query = "SELECT v FROM VtaCta v WHERE v.numprc = :numprc")})
public class VtaCta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Column(name = "activo")
    private boolean activo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "baja")
    private boolean baja;
    @Column(name = "condicion_rentas")
    private Integer condicionRentas;
    @Column(name = "contribuyente_municipal")
    private Integer contribuyenteMunicipal;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "cta_id")
    private Long ctaId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "domemp")
    private String domemp;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "empleo")
    private String empleo;
    @Column(name = "feccan")
    @Temporal(TemporalType.TIMESTAMP)
    private Date feccan;
    @Column(name = "fecesp")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecesp;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecest")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecest;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fpg_predefinida")
    private boolean fpgPredefinida;
    @Basic(optional = false)
    @NotNull
    @Column(name = "orden_ruta")
    private int ordenRuta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "permite_cambio_cpg")
    private boolean permiteCambioCpg;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "totsal")
    private BigDecimal totsal;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ultvto")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ultvto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "numprc")
    private int numprc;
    @JoinColumn(name = "cta_id", referencedColumnName = "pers_id", insertable = false, updatable = false)
    @OneToOne(optional = false)
    @JsonIgnore
    private GsyPers gsyPers;
    @JoinColumn(name = "ruta_id", referencedColumnName = "ruta_id")
    @ManyToOne(optional = false)
    private PvtaRuta rutaId;
    @JoinColumn(name = "tipnegocio_id", referencedColumnName = "ptipnegocio_id")
    @ManyToOne(optional = false)
    private PvtaTiponegocio tipnegocioId;
    @JoinColumn(name = "cpg_id", referencedColumnName = "cpg_id")
    @ManyToOne(optional = false)
    private VtaCpg cpgId;
    @JoinColumn(name = "est_id", referencedColumnName = "est_id")
    @ManyToOne(optional = false)
    private VtaEst estId;

    public VtaCta() {
    }

    public VtaCta(Long ctaId) {
        this.ctaId = ctaId;
    }

    public VtaCta(Long ctaId, boolean activo, boolean baja, String domemp, String empleo, Date fecest, boolean fpgPredefinida, int ordenRuta, boolean permiteCambioCpg, BigDecimal totsal, Date ultvto, int numprc) {
        this.ctaId = ctaId;
        this.activo = activo;
        this.baja = baja;
        this.domemp = domemp;
        this.empleo = empleo;
        this.fecest = fecest;
        this.fpgPredefinida = fpgPredefinida;
        this.ordenRuta = ordenRuta;
        this.permiteCambioCpg = permiteCambioCpg;
        this.totsal = totsal;
        this.ultvto = ultvto;
        this.numprc = numprc;
    }

    public boolean getActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public boolean getBaja() {
        return baja;
    }

    public void setBaja(boolean baja) {
        this.baja = baja;
    }

    public Integer getCondicionRentas() {
        return condicionRentas;
    }

    public void setCondicionRentas(Integer condicionRentas) {
        this.condicionRentas = condicionRentas;
    }

    public Integer getContribuyenteMunicipal() {
        return contribuyenteMunicipal;
    }

    public void setContribuyenteMunicipal(Integer contribuyenteMunicipal) {
        this.contribuyenteMunicipal = contribuyenteMunicipal;
    }

    public Long getCtaId() {
        return ctaId;
    }

    public void setCtaId(Long ctaId) {
        this.ctaId = ctaId;
    }

    public String getDomemp() {
        return domemp;
    }

    public void setDomemp(String domemp) {
        this.domemp = domemp;
    }

    public String getEmpleo() {
        return empleo;
    }

    public void setEmpleo(String empleo) {
        this.empleo = empleo;
    }

    public Date getFeccan() {
        return feccan;
    }

    public void setFeccan(Date feccan) {
        this.feccan = feccan;
    }

    public Date getFecesp() {
        return fecesp;
    }

    public void setFecesp(Date fecesp) {
        this.fecesp = fecesp;
    }

    public Date getFecest() {
        return fecest;
    }

    public void setFecest(Date fecest) {
        this.fecest = fecest;
    }

    public boolean getFpgPredefinida() {
        return fpgPredefinida;
    }

    public void setFpgPredefinida(boolean fpgPredefinida) {
        this.fpgPredefinida = fpgPredefinida;
    }

    public int getOrdenRuta() {
        return ordenRuta;
    }

    public void setOrdenRuta(int ordenRuta) {
        this.ordenRuta = ordenRuta;
    }

    public boolean getPermiteCambioCpg() {
        return permiteCambioCpg;
    }

    public void setPermiteCambioCpg(boolean permiteCambioCpg) {
        this.permiteCambioCpg = permiteCambioCpg;
    }

    public BigDecimal getTotsal() {
        return totsal;
    }

    public void setTotsal(BigDecimal totsal) {
        this.totsal = totsal;
    }

    public Date getUltvto() {
        return ultvto;
    }

    public void setUltvto(Date ultvto) {
        this.ultvto = ultvto;
    }

    public int getNumprc() {
        return numprc;
    }

    public void setNumprc(int numprc) {
        this.numprc = numprc;
    }

    public GsyPers getGsyPers() {
        return gsyPers;
    }

    public void setGsyPers(GsyPers gsyPers) {
        this.gsyPers = gsyPers;
    }

    public PvtaRuta getRutaId() {
        return rutaId;
    }

    public void setRutaId(PvtaRuta rutaId) {
        this.rutaId = rutaId;
    }

    public PvtaTiponegocio getTipnegocioId() {
        return tipnegocioId;
    }

    public void setTipnegocioId(PvtaTiponegocio tipnegocioId) {
        this.tipnegocioId = tipnegocioId;
    }

    public VtaCpg getCpgId() {
        return cpgId;
    }

    public void setCpgId(VtaCpg cpgId) {
        this.cpgId = cpgId;
    }

    public VtaEst getEstId() {
        return estId;
    }

    public void setEstId(VtaEst estId) {
        this.estId = estId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ctaId != null ? ctaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VtaCta)) {
            return false;
        }
        VtaCta other = (VtaCta) object;
        if ((this.ctaId == null && other.ctaId != null) || (this.ctaId != null && !this.ctaId.equals(other.ctaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sigemp.server.entity.VtaCta[ ctaId=" + ctaId + " ]";
    }

}
