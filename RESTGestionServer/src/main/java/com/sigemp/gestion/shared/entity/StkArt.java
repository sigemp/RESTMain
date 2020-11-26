/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigemp.gestion.shared.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author cristian
 */
@Entity
@Table(name = "stk_art")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "StkArt.findAll", query = "SELECT s FROM StkArt s")
    , @NamedQuery(name = "StkArt.findByArtId", query = "SELECT s FROM StkArt s WHERE s.artId = :artId")
    , @NamedQuery(name = "StkArt.findByCajas", query = "SELECT s FROM StkArt s WHERE s.cajas = :cajas")
    , @NamedQuery(name = "StkArt.findByCntMinima", query = "SELECT s FROM StkArt s WHERE s.cntMinima = :cntMinima")
    , @NamedQuery(name = "StkArt.findByContenido", query = "SELECT s FROM StkArt s WHERE s.contenido = :contenido")
    , @NamedQuery(name = "StkArt.findByCosbruto", query = "SELECT s FROM StkArt s WHERE s.cosbruto = :cosbruto")
    , @NamedQuery(name = "StkArt.findByCosneto", query = "SELECT s FROM StkArt s WHERE s.cosneto = :cosneto")
    , @NamedQuery(name = "StkArt.findByCuomax", query = "SELECT s FROM StkArt s WHERE s.cuomax = :cuomax")
    , @NamedQuery(name = "StkArt.findByDes", query = "SELECT s FROM StkArt s WHERE s.des = :des")
    , @NamedQuery(name = "StkArt.findByEstado", query = "SELECT s FROM StkArt s WHERE s.estado = :estado")
    , @NamedQuery(name = "StkArt.findByFlags", query = "SELECT s FROM StkArt s WHERE s.flags = :flags")
    , @NamedQuery(name = "StkArt.findByFlete", query = "SELECT s FROM StkArt s WHERE s.flete = :flete")
    , @NamedQuery(name = "StkArt.findByIntint", query = "SELECT s FROM StkArt s WHERE s.intint = :intint")
    , @NamedQuery(name = "StkArt.findByMedidaCnt", query = "SELECT s FROM StkArt s WHERE s.medidaCnt = :medidaCnt")
    , @NamedQuery(name = "StkArt.findByPrcciva1", query = "SELECT s FROM StkArt s WHERE s.prcciva1 = :prcciva1")
    , @NamedQuery(name = "StkArt.findByPrcciva2", query = "SELECT s FROM StkArt s WHERE s.prcciva2 = :prcciva2")
    , @NamedQuery(name = "StkArt.findByPrcciva3", query = "SELECT s FROM StkArt s WHERE s.prcciva3 = :prcciva3")
    , @NamedQuery(name = "StkArt.findByPrcciva4", query = "SELECT s FROM StkArt s WHERE s.prcciva4 = :prcciva4")
    , @NamedQuery(name = "StkArt.findByPrcsiva1", query = "SELECT s FROM StkArt s WHERE s.prcsiva1 = :prcsiva1")
    , @NamedQuery(name = "StkArt.findByPrcsiva2", query = "SELECT s FROM StkArt s WHERE s.prcsiva2 = :prcsiva2")
    , @NamedQuery(name = "StkArt.findByPrcsiva3", query = "SELECT s FROM StkArt s WHERE s.prcsiva3 = :prcsiva3")
    , @NamedQuery(name = "StkArt.findByPrcsiva4", query = "SELECT s FROM StkArt s WHERE s.prcsiva4 = :prcsiva4")
    , @NamedQuery(name = "StkArt.findByPrvart", query = "SELECT s FROM StkArt s WHERE s.prvart = :prvart")
    , @NamedQuery(name = "StkArt.findByPutilidad1", query = "SELECT s FROM StkArt s WHERE s.putilidad1 = :putilidad1")
    , @NamedQuery(name = "StkArt.findByPutilidad2", query = "SELECT s FROM StkArt s WHERE s.putilidad2 = :putilidad2")
    , @NamedQuery(name = "StkArt.findByPutilidad3", query = "SELECT s FROM StkArt s WHERE s.putilidad3 = :putilidad3")
    , @NamedQuery(name = "StkArt.findByPutilidad4", query = "SELECT s FROM StkArt s WHERE s.putilidad4 = :putilidad4")
    , @NamedQuery(name = "StkArt.findByUnidadMedida", query = "SELECT s FROM StkArt s WHERE s.unidadMedida = :unidadMedida")
    , @NamedQuery(name = "StkArt.findByUnidadcont", query = "SELECT s FROM StkArt s WHERE s.unidadcont = :unidadcont")
    , @NamedQuery(name = "StkArt.findByUxb", query = "SELECT s FROM StkArt s WHERE s.uxb = :uxb")
    , @NamedQuery(name = "StkArt.findByVar1", query = "SELECT s FROM StkArt s WHERE s.var1 = :var1")
    , @NamedQuery(name = "StkArt.findByVar2", query = "SELECT s FROM StkArt s WHERE s.var2 = :var2")
    , @NamedQuery(name = "StkArt.findByVar3", query = "SELECT s FROM StkArt s WHERE s.var3 = :var3")
    , @NamedQuery(name = "StkArt.findByVar4", query = "SELECT s FROM StkArt s WHERE s.var4 = :var4")
    , @NamedQuery(name = "StkArt.findByVar5", query = "SELECT s FROM StkArt s WHERE s.var5 = :var5")
    , @NamedQuery(name = "StkArt.findByCosbrutodcto", query = "SELECT s FROM StkArt s WHERE s.cosbrutodcto = :cosbrutodcto")})
public class StkArt implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "art_id")
    private Integer artId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cajas")
    private long cajas;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "cnt_minima")
    private BigDecimal cntMinima;
    @Basic(optional = false)
    @NotNull
    @Column(name = "contenido")
    private int contenido;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cosbruto")
    private BigDecimal cosbruto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cosneto")
    private BigDecimal cosneto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cuomax")
    private int cuomax;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "des")
    private String des;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estado")
    private boolean estado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "flags")
    private String flags;
    @Basic(optional = false)
    @NotNull
    @Column(name = "flete")
    private BigDecimal flete;
    @Basic(optional = false)
    @NotNull
    @Column(name = "intint")
    private BigDecimal intint;
    @Basic(optional = false)
    @NotNull
    @Column(name = "medida_cnt")
    private BigDecimal medidaCnt;
    @Basic(optional = false)
    @NotNull
    @Column(name = "prcciva1")
    private BigDecimal prcciva1;
    @Basic(optional = false)
    @NotNull
    @Column(name = "prcciva2")
    private BigDecimal prcciva2;
    @Basic(optional = false)
    @NotNull
    @Column(name = "prcciva3")
    private BigDecimal prcciva3;
    @Basic(optional = false)
    @NotNull
    @Column(name = "prcciva4")
    private BigDecimal prcciva4;
    @Basic(optional = false)
    @NotNull
    @Column(name = "prcsiva1")
    private BigDecimal prcsiva1;
    @Basic(optional = false)
    @NotNull
    @Column(name = "prcsiva2")
    private BigDecimal prcsiva2;
    @Basic(optional = false)
    @NotNull
    @Column(name = "prcsiva3")
    private BigDecimal prcsiva3;
    @Basic(optional = false)
    @NotNull
    @Column(name = "prcsiva4")
    private BigDecimal prcsiva4;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "prvart")
    private String prvart;
    @Basic(optional = false)
    @NotNull
    @Column(name = "putilidad1")
    private BigDecimal putilidad1;
    @Basic(optional = false)
    @NotNull
    @Column(name = "putilidad2")
    private BigDecimal putilidad2;
    @Basic(optional = false)
    @NotNull
    @Column(name = "putilidad3")
    private BigDecimal putilidad3;
    @Basic(optional = false)
    @NotNull
    @Column(name = "putilidad4")
    private BigDecimal putilidad4;
    @Basic(optional = false)
    @NotNull
    @Column(name = "unidad_medida")
    private int unidadMedida;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "unidadcont")
    private String unidadcont;
    @Basic(optional = false)
    @NotNull
    @Column(name = "uxb")
    private BigDecimal uxb;
    @Basic(optional = false)
    @NotNull
    @Column(name = "var1")
    private BigDecimal var1;
    @Basic(optional = false)
    @NotNull
    @Column(name = "var2")
    private BigDecimal var2;
    @Basic(optional = false)
    @NotNull
    @Column(name = "var3")
    private BigDecimal var3;
    @Basic(optional = false)
    @NotNull
    @Column(name = "var4")
    private BigDecimal var4;
    @Basic(optional = false)
    @NotNull
    @Column(name = "var5")
    private BigDecimal var5;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cosbrutodcto")
    private BigDecimal cosbrutodcto;
    @OneToMany(mappedBy = "artId")
    private Collection<StkPArtbonb> stkPArtbonbCollection;
    @JoinColumn(name = "actividad_id", referencedColumnName = "actividad_id")
    @ManyToOne
    private GsyActividad actividadId;
    @JoinColumn(name = "tiva_id", referencedColumnName = "tiva_id")
    @ManyToOne(optional = false)
    private GsyTiva tivaId;
    @JoinColumn(name = "usr_id", referencedColumnName = "usr_id")
    @ManyToOne(optional = false)
    private GsyUser usrId;
    @JoinColumn(name = "prv_id", referencedColumnName = "prv_id")
    @ManyToOne(optional = false)
    private PrvPrv prvId;
    @JoinColumn(name = "dep_id", referencedColumnName = "dep_id")
    @ManyToOne(optional = false)
    private StkDep depId;
    @JoinColumn(name = "mar_id", referencedColumnName = "mar_id")
    @ManyToOne(optional = false)
    private StkMar marId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "artId")
    private Collection<StkMvr> stkMvrCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "artId")
    private Collection<PvtaVtar> pvtaVtarCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "artId")
    private Collection<StkArtbonificacion> stkArtbonificacionCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "artId2")
    private Collection<StkArtbonificacion> stkArtbonificacionCollection1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "artId")
    private Collection<StkArtdescuentos> stkArtdescuentosCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "artId")
    private Collection<StkInventariosr> stkInventariosrCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "artId")
    private Collection<VtaVtar> vtaVtarCollection;
    @OneToMany(mappedBy = "artId")
    private Collection<StkPArtbona> stkPArtbonaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "artId")
    private Collection<StkArtcod> stkArtcodCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "artId")
    private Collection<StkStk> stkStkCollection;

    public StkArt() {
    }

    public StkArt(Integer artId) {
        this.artId = artId;
    }

    public StkArt(Integer artId, long cajas, BigDecimal cntMinima, int contenido, BigDecimal cosbruto, BigDecimal cosneto, int cuomax, String des, boolean estado, String flags, BigDecimal flete, BigDecimal intint, BigDecimal medidaCnt, BigDecimal prcciva1, BigDecimal prcciva2, BigDecimal prcciva3, BigDecimal prcciva4, BigDecimal prcsiva1, BigDecimal prcsiva2, BigDecimal prcsiva3, BigDecimal prcsiva4, String prvart, BigDecimal putilidad1, BigDecimal putilidad2, BigDecimal putilidad3, BigDecimal putilidad4, int unidadMedida, String unidadcont, BigDecimal uxb, BigDecimal var1, BigDecimal var2, BigDecimal var3, BigDecimal var4, BigDecimal var5, BigDecimal cosbrutodcto) {
        this.artId = artId;
        this.cajas = cajas;
        this.cntMinima = cntMinima;
        this.contenido = contenido;
        this.cosbruto = cosbruto;
        this.cosneto = cosneto;
        this.cuomax = cuomax;
        this.des = des;
        this.estado = estado;
        this.flags = flags;
        this.flete = flete;
        this.intint = intint;
        this.medidaCnt = medidaCnt;
        this.prcciva1 = prcciva1;
        this.prcciva2 = prcciva2;
        this.prcciva3 = prcciva3;
        this.prcciva4 = prcciva4;
        this.prcsiva1 = prcsiva1;
        this.prcsiva2 = prcsiva2;
        this.prcsiva3 = prcsiva3;
        this.prcsiva4 = prcsiva4;
        this.prvart = prvart;
        this.putilidad1 = putilidad1;
        this.putilidad2 = putilidad2;
        this.putilidad3 = putilidad3;
        this.putilidad4 = putilidad4;
        this.unidadMedida = unidadMedida;
        this.unidadcont = unidadcont;
        this.uxb = uxb;
        this.var1 = var1;
        this.var2 = var2;
        this.var3 = var3;
        this.var4 = var4;
        this.var5 = var5;
        this.cosbrutodcto = cosbrutodcto;
    }

    public Integer getArtId() {
        return artId;
    }

    public void setArtId(Integer artId) {
        this.artId = artId;
    }

    public long getCajas() {
        return cajas;
    }

    public void setCajas(long cajas) {
        this.cajas = cajas;
    }

    public BigDecimal getCntMinima() {
        return cntMinima;
    }

    public void setCntMinima(BigDecimal cntMinima) {
        this.cntMinima = cntMinima;
    }

    public int getContenido() {
        return contenido;
    }

    public void setContenido(int contenido) {
        this.contenido = contenido;
    }

    public BigDecimal getCosbruto() {
        return cosbruto;
    }

    public void setCosbruto(BigDecimal cosbruto) {
        this.cosbruto = cosbruto;
    }

    public BigDecimal getCosneto() {
        return cosneto;
    }

    public void setCosneto(BigDecimal cosneto) {
        this.cosneto = cosneto;
    }

    public int getCuomax() {
        return cuomax;
    }

    public void setCuomax(int cuomax) {
        this.cuomax = cuomax;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public String getFlags() {
        return flags;
    }

    public void setFlags(String flags) {
        this.flags = flags;
    }

    public BigDecimal getFlete() {
        return flete;
    }

    public void setFlete(BigDecimal flete) {
        this.flete = flete;
    }

    public BigDecimal getIntint() {
        return intint;
    }

    public void setIntint(BigDecimal intint) {
        this.intint = intint;
    }

    public BigDecimal getMedidaCnt() {
        return medidaCnt;
    }

    public void setMedidaCnt(BigDecimal medidaCnt) {
        this.medidaCnt = medidaCnt;
    }

    public BigDecimal getPrcciva1() {
        return prcciva1;
    }

    public void setPrcciva1(BigDecimal prcciva1) {
        this.prcciva1 = prcciva1;
    }

    public BigDecimal getPrcciva2() {
        return prcciva2;
    }

    public void setPrcciva2(BigDecimal prcciva2) {
        this.prcciva2 = prcciva2;
    }

    public BigDecimal getPrcciva3() {
        return prcciva3;
    }

    public void setPrcciva3(BigDecimal prcciva3) {
        this.prcciva3 = prcciva3;
    }

    public BigDecimal getPrcciva4() {
        return prcciva4;
    }

    public void setPrcciva4(BigDecimal prcciva4) {
        this.prcciva4 = prcciva4;
    }

    public BigDecimal getPrcsiva1() {
        return prcsiva1;
    }

    public void setPrcsiva1(BigDecimal prcsiva1) {
        this.prcsiva1 = prcsiva1;
    }

    public BigDecimal getPrcsiva2() {
        return prcsiva2;
    }

    public void setPrcsiva2(BigDecimal prcsiva2) {
        this.prcsiva2 = prcsiva2;
    }

    public BigDecimal getPrcsiva3() {
        return prcsiva3;
    }

    public void setPrcsiva3(BigDecimal prcsiva3) {
        this.prcsiva3 = prcsiva3;
    }

    public BigDecimal getPrcsiva4() {
        return prcsiva4;
    }

    public void setPrcsiva4(BigDecimal prcsiva4) {
        this.prcsiva4 = prcsiva4;
    }

    public String getPrvart() {
        return prvart;
    }

    public void setPrvart(String prvart) {
        this.prvart = prvart;
    }

    public BigDecimal getPutilidad1() {
        return putilidad1;
    }

    public void setPutilidad1(BigDecimal putilidad1) {
        this.putilidad1 = putilidad1;
    }

    public BigDecimal getPutilidad2() {
        return putilidad2;
    }

    public void setPutilidad2(BigDecimal putilidad2) {
        this.putilidad2 = putilidad2;
    }

    public BigDecimal getPutilidad3() {
        return putilidad3;
    }

    public void setPutilidad3(BigDecimal putilidad3) {
        this.putilidad3 = putilidad3;
    }

    public BigDecimal getPutilidad4() {
        return putilidad4;
    }

    public void setPutilidad4(BigDecimal putilidad4) {
        this.putilidad4 = putilidad4;
    }

    public int getUnidadMedida() {
        return unidadMedida;
    }

    public void setUnidadMedida(int unidadMedida) {
        this.unidadMedida = unidadMedida;
    }

    public String getUnidadcont() {
        return unidadcont;
    }

    public void setUnidadcont(String unidadcont) {
        this.unidadcont = unidadcont;
    }

    public BigDecimal getUxb() {
        return uxb;
    }

    public void setUxb(BigDecimal uxb) {
        this.uxb = uxb;
    }

    public BigDecimal getVar1() {
        return var1;
    }

    public void setVar1(BigDecimal var1) {
        this.var1 = var1;
    }

    public BigDecimal getVar2() {
        return var2;
    }

    public void setVar2(BigDecimal var2) {
        this.var2 = var2;
    }

    public BigDecimal getVar3() {
        return var3;
    }

    public void setVar3(BigDecimal var3) {
        this.var3 = var3;
    }

    public BigDecimal getVar4() {
        return var4;
    }

    public void setVar4(BigDecimal var4) {
        this.var4 = var4;
    }

    public BigDecimal getVar5() {
        return var5;
    }

    public void setVar5(BigDecimal var5) {
        this.var5 = var5;
    }

    public BigDecimal getCosbrutodcto() {
        return cosbrutodcto;
    }

    public void setCosbrutodcto(BigDecimal cosbrutodcto) {
        this.cosbrutodcto = cosbrutodcto;
    }

    @XmlTransient
    public Collection<StkPArtbonb> getStkPArtbonbCollection() {
        return stkPArtbonbCollection;
    }

    public void setStkPArtbonbCollection(Collection<StkPArtbonb> stkPArtbonbCollection) {
        this.stkPArtbonbCollection = stkPArtbonbCollection;
    }

    public GsyActividad getActividadId() {
        return actividadId;
    }

    public void setActividadId(GsyActividad actividadId) {
        this.actividadId = actividadId;
    }

    public GsyTiva getTivaId() {
        return tivaId;
    }

    public void setTivaId(GsyTiva tivaId) {
        this.tivaId = tivaId;
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

    public StkDep getDepId() {
        return depId;
    }

    public void setDepId(StkDep depId) {
        this.depId = depId;
    }

    public StkMar getMarId() {
        return marId;
    }

    public void setMarId(StkMar marId) {
        this.marId = marId;
    }

    @XmlTransient
    public Collection<StkMvr> getStkMvrCollection() {
        return stkMvrCollection;
    }

    public void setStkMvrCollection(Collection<StkMvr> stkMvrCollection) {
        this.stkMvrCollection = stkMvrCollection;
    }

    @XmlTransient
    public Collection<PvtaVtar> getPvtaVtarCollection() {
        return pvtaVtarCollection;
    }

    public void setPvtaVtarCollection(Collection<PvtaVtar> pvtaVtarCollection) {
        this.pvtaVtarCollection = pvtaVtarCollection;
    }

    @XmlTransient
    public Collection<StkArtbonificacion> getStkArtbonificacionCollection() {
        return stkArtbonificacionCollection;
    }

    public void setStkArtbonificacionCollection(Collection<StkArtbonificacion> stkArtbonificacionCollection) {
        this.stkArtbonificacionCollection = stkArtbonificacionCollection;
    }

    @XmlTransient
    public Collection<StkArtbonificacion> getStkArtbonificacionCollection1() {
        return stkArtbonificacionCollection1;
    }

    public void setStkArtbonificacionCollection1(Collection<StkArtbonificacion> stkArtbonificacionCollection1) {
        this.stkArtbonificacionCollection1 = stkArtbonificacionCollection1;
    }

    @XmlTransient
    public Collection<StkArtdescuentos> getStkArtdescuentosCollection() {
        return stkArtdescuentosCollection;
    }

    public void setStkArtdescuentosCollection(Collection<StkArtdescuentos> stkArtdescuentosCollection) {
        this.stkArtdescuentosCollection = stkArtdescuentosCollection;
    }

    @XmlTransient
    public Collection<StkInventariosr> getStkInventariosrCollection() {
        return stkInventariosrCollection;
    }

    public void setStkInventariosrCollection(Collection<StkInventariosr> stkInventariosrCollection) {
        this.stkInventariosrCollection = stkInventariosrCollection;
    }

    @XmlTransient
    public Collection<VtaVtar> getVtaVtarCollection() {
        return vtaVtarCollection;
    }

    public void setVtaVtarCollection(Collection<VtaVtar> vtaVtarCollection) {
        this.vtaVtarCollection = vtaVtarCollection;
    }

    @XmlTransient
    public Collection<StkPArtbona> getStkPArtbonaCollection() {
        return stkPArtbonaCollection;
    }

    public void setStkPArtbonaCollection(Collection<StkPArtbona> stkPArtbonaCollection) {
        this.stkPArtbonaCollection = stkPArtbonaCollection;
    }

    @XmlTransient
    public Collection<StkArtcod> getStkArtcodCollection() {
        return stkArtcodCollection;
    }

    public void setStkArtcodCollection(Collection<StkArtcod> stkArtcodCollection) {
        this.stkArtcodCollection = stkArtcodCollection;
    }

    @XmlTransient
    public Collection<StkStk> getStkStkCollection() {
        return stkStkCollection;
    }

    public void setStkStkCollection(Collection<StkStk> stkStkCollection) {
        this.stkStkCollection = stkStkCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (artId != null ? artId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StkArt)) {
            return false;
        }
        StkArt other = (StkArt) object;
        if ((this.artId == null && other.artId != null) || (this.artId != null && !this.artId.equals(other.artId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sigemp.server.entity.StkArt[ artId=" + artId + " ]";
    }
    
}
