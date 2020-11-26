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
@Table(name = "stk_mv")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "StkMv.findAll", query = "SELECT s FROM StkMv s")
    , @NamedQuery(name = "StkMv.findByMvId", query = "SELECT s FROM StkMv s WHERE s.mvId = :mvId")
    , @NamedQuery(name = "StkMv.findByFec", query = "SELECT s FROM StkMv s WHERE s.fec = :fec")
    , @NamedQuery(name = "StkMv.findByNum", query = "SELECT s FROM StkMv s WHERE s.num = :num")
    , @NamedQuery(name = "StkMv.findByObs", query = "SELECT s FROM StkMv s WHERE s.obs = :obs")
    , @NamedQuery(name = "StkMv.findByProveedorFechaRemito", query = "SELECT s FROM StkMv s WHERE s.proveedorFechaRemito = :proveedorFechaRemito")
    , @NamedQuery(name = "StkMv.findByProveedorNumeroPtovta", query = "SELECT s FROM StkMv s WHERE s.proveedorNumeroPtovta = :proveedorNumeroPtovta")
    , @NamedQuery(name = "StkMv.findByProveedorNumeroRemito", query = "SELECT s FROM StkMv s WHERE s.proveedorNumeroRemito = :proveedorNumeroRemito")
    , @NamedQuery(name = "StkMv.findByPtovta", query = "SELECT s FROM StkMv s WHERE s.ptovta = :ptovta")
    , @NamedQuery(name = "StkMv.findByTot", query = "SELECT s FROM StkMv s WHERE s.tot = :tot")
    , @NamedQuery(name = "StkMv.findByVtaId", query = "SELECT s FROM StkMv s WHERE s.vtaId = :vtaId")})
public class StkMv implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "mv_id")
    private Integer mvId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fec")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fec;
    @Basic(optional = false)
    @NotNull
    @Column(name = "num")
    private int num;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 400)
    @Column(name = "obs")
    private String obs;
    @Column(name = "proveedor_fecha_remito")
    @Temporal(TemporalType.TIMESTAMP)
    private Date proveedorFechaRemito;
    @Column(name = "proveedor_numero_ptovta")
    private Integer proveedorNumeroPtovta;
    @Column(name = "proveedor_numero_remito")
    private Integer proveedorNumeroRemito;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ptovta")
    private int ptovta;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "tot")
    private BigDecimal tot;
    @Column(name = "vta_id")
    private Integer vtaId;
    @JoinColumn(name = "tc_id", referencedColumnName = "tc_id")
    @ManyToOne(optional = false)
    private GsyTiposcomprobantes tcId;
    @JoinColumn(name = "usr_id", referencedColumnName = "usr_id")
    @ManyToOne(optional = false)
    private GsyUser usrId;
    @JoinColumn(name = "prv_id", referencedColumnName = "prv_id")
    @ManyToOne
    private PrvPrv prvId;
    @JoinColumn(name = "depo_id", referencedColumnName = "depo_id")
    @ManyToOne(optional = false)
    private StkDepositos depoId;
    @JoinColumn(name = "depo_id_des", referencedColumnName = "depo_id")
    @ManyToOne(optional = false)
    private StkDepositos depoIdDes;
    @JoinColumn(name = "cierre_id", referencedColumnName = "cierre_id")
    @ManyToOne
    private VtaCierres cierreId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "mvId")
    private Collection<StkMvr> stkMvrCollection;

    public StkMv() {
    }

    public StkMv(Integer mvId) {
        this.mvId = mvId;
    }

    public StkMv(Integer mvId, Date fec, int num, String obs, int ptovta, BigDecimal tot) {
        this.mvId = mvId;
        this.fec = fec;
        this.num = num;
        this.obs = obs;
        this.ptovta = ptovta;
        this.tot = tot;
    }

    public Integer getMvId() {
        return mvId;
    }

    public void setMvId(Integer mvId) {
        this.mvId = mvId;
    }

    public Date getFec() {
        return fec;
    }

    public void setFec(Date fec) {
        this.fec = fec;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public Date getProveedorFechaRemito() {
        return proveedorFechaRemito;
    }

    public void setProveedorFechaRemito(Date proveedorFechaRemito) {
        this.proveedorFechaRemito = proveedorFechaRemito;
    }

    public Integer getProveedorNumeroPtovta() {
        return proveedorNumeroPtovta;
    }

    public void setProveedorNumeroPtovta(Integer proveedorNumeroPtovta) {
        this.proveedorNumeroPtovta = proveedorNumeroPtovta;
    }

    public Integer getProveedorNumeroRemito() {
        return proveedorNumeroRemito;
    }

    public void setProveedorNumeroRemito(Integer proveedorNumeroRemito) {
        this.proveedorNumeroRemito = proveedorNumeroRemito;
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

    public Integer getVtaId() {
        return vtaId;
    }

    public void setVtaId(Integer vtaId) {
        this.vtaId = vtaId;
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

    public PrvPrv getPrvId() {
        return prvId;
    }

    public void setPrvId(PrvPrv prvId) {
        this.prvId = prvId;
    }

    public StkDepositos getDepoId() {
        return depoId;
    }

    public void setDepoId(StkDepositos depoId) {
        this.depoId = depoId;
    }

    public StkDepositos getDepoIdDes() {
        return depoIdDes;
    }

    public void setDepoIdDes(StkDepositos depoIdDes) {
        this.depoIdDes = depoIdDes;
    }

    public VtaCierres getCierreId() {
        return cierreId;
    }

    public void setCierreId(VtaCierres cierreId) {
        this.cierreId = cierreId;
    }

    @XmlTransient
    public Collection<StkMvr> getStkMvrCollection() {
        return stkMvrCollection;
    }

    public void setStkMvrCollection(Collection<StkMvr> stkMvrCollection) {
        this.stkMvrCollection = stkMvrCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (mvId != null ? mvId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StkMv)) {
            return false;
        }
        StkMv other = (StkMv) object;
        if ((this.mvId == null && other.mvId != null) || (this.mvId != null && !this.mvId.equals(other.mvId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sigemp.server.entity.StkMv[ mvId=" + mvId + " ]";
    }
    
}
