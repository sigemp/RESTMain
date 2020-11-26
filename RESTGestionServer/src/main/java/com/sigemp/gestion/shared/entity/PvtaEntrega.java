/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigemp.gestion.shared.entity;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "pvta_entrega")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PvtaEntrega.findAll", query = "SELECT p FROM PvtaEntrega p")
    , @NamedQuery(name = "PvtaEntrega.findByEntregaId", query = "SELECT p FROM PvtaEntrega p WHERE p.entregaId = :entregaId")
    , @NamedQuery(name = "PvtaEntrega.findByCntpedidos", query = "SELECT p FROM PvtaEntrega p WHERE p.cntpedidos = :cntpedidos")
    , @NamedQuery(name = "PvtaEntrega.findByFacturado", query = "SELECT p FROM PvtaEntrega p WHERE p.facturado = :facturado")
    , @NamedQuery(name = "PvtaEntrega.findByFec", query = "SELECT p FROM PvtaEntrega p WHERE p.fec = :fec")
    , @NamedQuery(name = "PvtaEntrega.findByFecFacturacion", query = "SELECT p FROM PvtaEntrega p WHERE p.fecFacturacion = :fecFacturacion")
    , @NamedQuery(name = "PvtaEntrega.findByObs", query = "SELECT p FROM PvtaEntrega p WHERE p.obs = :obs")
    , @NamedQuery(name = "PvtaEntrega.findByPtovta", query = "SELECT p FROM PvtaEntrega p WHERE p.ptovta = :ptovta")
    , @NamedQuery(name = "PvtaEntrega.findByTot", query = "SELECT p FROM PvtaEntrega p WHERE p.tot = :tot")
    , @NamedQuery(name = "PvtaEntrega.findByTotiva", query = "SELECT p FROM PvtaEntrega p WHERE p.totiva = :totiva")
    , @NamedQuery(name = "PvtaEntrega.findByUsrId", query = "SELECT p FROM PvtaEntrega p WHERE p.usrId = :usrId")})
public class PvtaEntrega implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "entrega_id")
    private Integer entregaId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cntpedidos")
    private int cntpedidos;
    @Basic(optional = false)
    @NotNull
    @Column(name = "facturado")
    private boolean facturado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fec")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fec;
    @Column(name = "fec_facturacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecFacturacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 400)
    @Column(name = "obs")
    private String obs;
    @Column(name = "ptovta")
    private Integer ptovta;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
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
    @Column(name = "usr_id")
    private int usrId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "entregaId")
    private Collection<PvtaVta> pvtaVtaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "entregaId")
    private Collection<PvtaMotivonoventa> pvtaMotivonoventaCollection;
    @JoinColumn(name = "repar_id", referencedColumnName = "repar_id")
    @ManyToOne(optional = false)
    private PvtaRepartidor reparId;
    @JoinColumn(name = "ruta_id", referencedColumnName = "ruta_id")
    @ManyToOne(optional = false)
    private PvtaRuta rutaId;
    @JoinColumn(name = "ven_id", referencedColumnName = "ven_id")
    @ManyToOne
    private VtaVen venId;

    public PvtaEntrega() {
    }

    public PvtaEntrega(Integer entregaId) {
        this.entregaId = entregaId;
    }

    public PvtaEntrega(Integer entregaId, int cntpedidos, boolean facturado, Date fec, String obs, BigDecimal tot, BigDecimal totiva, int usrId) {
        this.entregaId = entregaId;
        this.cntpedidos = cntpedidos;
        this.facturado = facturado;
        this.fec = fec;
        this.obs = obs;
        this.tot = tot;
        this.totiva = totiva;
        this.usrId = usrId;
    }

    public Integer getEntregaId() {
        return entregaId;
    }

    public void setEntregaId(Integer entregaId) {
        this.entregaId = entregaId;
    }

    public int getCntpedidos() {
        return cntpedidos;
    }

    public void setCntpedidos(int cntpedidos) {
        this.cntpedidos = cntpedidos;
    }

    public boolean getFacturado() {
        return facturado;
    }

    public void setFacturado(boolean facturado) {
        this.facturado = facturado;
    }

    public Date getFec() {
        return fec;
    }

    public void setFec(Date fec) {
        this.fec = fec;
    }

    public Date getFecFacturacion() {
        return fecFacturacion;
    }

    public void setFecFacturacion(Date fecFacturacion) {
        this.fecFacturacion = fecFacturacion;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public Integer getPtovta() {
        return ptovta;
    }

    public void setPtovta(Integer ptovta) {
        this.ptovta = ptovta;
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

    public int getUsrId() {
        return usrId;
    }

    public void setUsrId(int usrId) {
        this.usrId = usrId;
    }

    @XmlTransient
    public Collection<PvtaVta> getPvtaVtaCollection() {
        return pvtaVtaCollection;
    }

    public void setPvtaVtaCollection(Collection<PvtaVta> pvtaVtaCollection) {
        this.pvtaVtaCollection = pvtaVtaCollection;
    }

    @XmlTransient
    public Collection<PvtaMotivonoventa> getPvtaMotivonoventaCollection() {
        return pvtaMotivonoventaCollection;
    }

    public void setPvtaMotivonoventaCollection(Collection<PvtaMotivonoventa> pvtaMotivonoventaCollection) {
        this.pvtaMotivonoventaCollection = pvtaMotivonoventaCollection;
    }

    public PvtaRepartidor getReparId() {
        return reparId;
    }

    public void setReparId(PvtaRepartidor reparId) {
        this.reparId = reparId;
    }

    public PvtaRuta getRutaId() {
        return rutaId;
    }

    public void setRutaId(PvtaRuta rutaId) {
        this.rutaId = rutaId;
    }

    public VtaVen getVenId() {
        return venId;
    }

    public void setVenId(VtaVen venId) {
        this.venId = venId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (entregaId != null ? entregaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PvtaEntrega)) {
            return false;
        }
        PvtaEntrega other = (PvtaEntrega) object;
        if ((this.entregaId == null && other.entregaId != null) || (this.entregaId != null && !this.entregaId.equals(other.entregaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sigemp.server.entity.PvtaEntrega[ entregaId=" + entregaId + " ]";
    }
    
}
