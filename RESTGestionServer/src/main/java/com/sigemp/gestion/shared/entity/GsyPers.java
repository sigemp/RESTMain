/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigemp.gestion.shared.entity;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
@Table(name = "gsy_pers")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GsyPers.findAll", query = "SELECT g FROM GsyPers g")
    , @NamedQuery(name = "GsyPers.findByPersId", query = "SELECT g FROM GsyPers g WHERE g.persId = :persId")
    , @NamedQuery(name = "GsyPers.findByApellido", query = "SELECT g FROM GsyPers g WHERE g.apellido = :apellido")
    , @NamedQuery(name = "GsyPers.findByFechacreacion", query = "SELECT g FROM GsyPers g WHERE g.fechacreacion = :fechacreacion")
    , @NamedQuery(name = "GsyPers.findByFecmod", query = "SELECT g FROM GsyPers g WHERE g.fecmod = :fecmod")
    , @NamedQuery(name = "GsyPers.findByIngresobrutos", query = "SELECT g FROM GsyPers g WHERE g.ingresobrutos = :ingresobrutos")
    , @NamedQuery(name = "GsyPers.findByNom", query = "SELECT g FROM GsyPers g WHERE g.nom = :nom")
    , @NamedQuery(name = "GsyPers.findByNombre", query = "SELECT g FROM GsyPers g WHERE g.nombre = :nombre")
    , @NamedQuery(name = "GsyPers.findBySexo", query = "SELECT g FROM GsyPers g WHERE g.sexo = :sexo")
    , @NamedQuery(name = "GsyPers.findByTelefono", query = "SELECT g FROM GsyPers g WHERE g.telefono = :telefono")
    , @NamedQuery(name = "GsyPers.findByXaltura1", query = "SELECT g FROM GsyPers g WHERE g.xaltura1 = :xaltura1")
    , @NamedQuery(name = "GsyPers.findByXaltura2", query = "SELECT g FROM GsyPers g WHERE g.xaltura2 = :xaltura2")
    , @NamedQuery(name = "GsyPers.findByXbarrio1", query = "SELECT g FROM GsyPers g WHERE g.xbarrio1 = :xbarrio1")
    , @NamedQuery(name = "GsyPers.findByXbarrio2", query = "SELECT g FROM GsyPers g WHERE g.xbarrio2 = :xbarrio2")
    , @NamedQuery(name = "GsyPers.findByXcalle1", query = "SELECT g FROM GsyPers g WHERE g.xcalle1 = :xcalle1")
    , @NamedQuery(name = "GsyPers.findByXcalle2", query = "SELECT g FROM GsyPers g WHERE g.xcalle2 = :xcalle2")
    , @NamedQuery(name = "GsyPers.findByXdpto1", query = "SELECT g FROM GsyPers g WHERE g.xdpto1 = :xdpto1")
    , @NamedQuery(name = "GsyPers.findByXdpto2", query = "SELECT g FROM GsyPers g WHERE g.xdpto2 = :xdpto2")
    , @NamedQuery(name = "GsyPers.findByXlatitud1", query = "SELECT g FROM GsyPers g WHERE g.xlatitud1 = :xlatitud1")
    , @NamedQuery(name = "GsyPers.findByXlatitud2", query = "SELECT g FROM GsyPers g WHERE g.xlatitud2 = :xlatitud2")
    , @NamedQuery(name = "GsyPers.findByXlongitud1", query = "SELECT g FROM GsyPers g WHERE g.xlongitud1 = :xlongitud1")
    , @NamedQuery(name = "GsyPers.findByXlongitud2", query = "SELECT g FROM GsyPers g WHERE g.xlongitud2 = :xlongitud2")
    , @NamedQuery(name = "GsyPers.findByXpiso1", query = "SELECT g FROM GsyPers g WHERE g.xpiso1 = :xpiso1")
    , @NamedQuery(name = "GsyPers.findByXpiso2", query = "SELECT g FROM GsyPers g WHERE g.xpiso2 = :xpiso2")
    , @NamedQuery(name = "GsyPers.findByXpuerta1", query = "SELECT g FROM GsyPers g WHERE g.xpuerta1 = :xpuerta1")
    , @NamedQuery(name = "GsyPers.findByXpuerta2", query = "SELECT g FROM GsyPers g WHERE g.xpuerta2 = :xpuerta2")
    , @NamedQuery(name = "GsyPers.findByNroident", query = "SELECT g FROM GsyPers g WHERE g.nroident = :nroident")})
public class GsyPers implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "pers_id")
    private Long persId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 70)
    @Column(name = "apellido")
    private String apellido;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechacreacion")
    @Temporal(TemporalType.TIMESTAMP)
    //@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ssZ")
//    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSZ")
    private Date fechacreacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecmod")
    @Temporal(TemporalType.TIMESTAMP)
    //@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ssZ")
//    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm a z")
//    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSZ")
    private Date fecmod;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ingresobrutos")
    private int ingresobrutos;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 140)
    @Column(name = "nom")
    private String nom;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 70)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "sexo")
    private String sexo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "telefono")
    private String telefono;
    @Basic(optional = false)
    @NotNull
    @Column(name = "xaltura1")
    private int xaltura1;
    @Basic(optional = false)
    @NotNull
    @Column(name = "xaltura2")
    private int xaltura2;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 70)
    @Column(name = "xbarrio1")
    private String xbarrio1;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 70)
    @Column(name = "xbarrio2")
    private String xbarrio2;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 70)
    @Column(name = "xcalle1")
    private String xcalle1;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 70)
    @Column(name = "xcalle2")
    private String xcalle2;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "xdpto1")
    private String xdpto1;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "xdpto2")
    private String xdpto2;
    @Basic(optional = false)
    @NotNull
    @Column(name = "xlatitud1")
    private double xlatitud1;
    @Basic(optional = false)
    @NotNull
    @Column(name = "xlatitud2")
    private double xlatitud2;
    @Basic(optional = false)
    @NotNull
    @Column(name = "xlongitud1")
    private double xlongitud1;
    @Basic(optional = false)
    @NotNull
    @Column(name = "xlongitud2")
    private double xlongitud2;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "xpiso1")
    private String xpiso1;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "xpiso2")
    private String xpiso2;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "xpuerta1")
    private String xpuerta1;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "xpuerta2")
    private String xpuerta2;
    @Column(name = "nroident")
    private BigInteger nroident;
    @JoinColumn(name = "civa_id", referencedColumnName = "civa_id")
    @ManyToOne(optional = false)
    private GsyCiva civaId;
    @JoinColumn(name = "estc_id", referencedColumnName = "estc_id")
    @ManyToOne(optional = false)
    private GsyEstcivil estcId;
    @JoinColumn(name = "loc_id", referencedColumnName = "loc_id")
    @ManyToOne(optional = false)
    private GsyLoc locId;
    @JoinColumn(name = "tdoc_id", referencedColumnName = "tdoc_id")
    @ManyToOne(optional = false)
    private GsyTdoc tdocId;
    @JoinColumn(name = "usr_id", referencedColumnName = "usr_id")
    @ManyToOne(optional = false)
    private GsyUser usrId;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "gsyPers")
    private VtaCta vtaCta;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "gsyPers")
    private PrvPrv prvPrv;

    public GsyPers() {
    }

    public GsyPers(Long persId) {
        this.persId = persId;
    }

    public GsyPers(Long persId, String apellido, Date fechacreacion, Date fecmod, int ingresobrutos, String nom, String nombre, String sexo, String telefono, int xaltura1, int xaltura2, String xbarrio1, String xbarrio2, String xcalle1, String xcalle2, String xdpto1, String xdpto2, double xlatitud1, double xlatitud2, double xlongitud1, double xlongitud2, String xpiso1, String xpiso2, String xpuerta1, String xpuerta2) {
        this.persId = persId;
        this.apellido = apellido;
        this.fechacreacion = fechacreacion;
        this.fecmod = fecmod;
        this.ingresobrutos = ingresobrutos;
        this.nom = nom;
        this.nombre = nombre;
        this.sexo = sexo;
        this.telefono = telefono;
        this.xaltura1 = xaltura1;
        this.xaltura2 = xaltura2;
        this.xbarrio1 = xbarrio1;
        this.xbarrio2 = xbarrio2;
        this.xcalle1 = xcalle1;
        this.xcalle2 = xcalle2;
        this.xdpto1 = xdpto1;
        this.xdpto2 = xdpto2;
        this.xlatitud1 = xlatitud1;
        this.xlatitud2 = xlatitud2;
        this.xlongitud1 = xlongitud1;
        this.xlongitud2 = xlongitud2;
        this.xpiso1 = xpiso1;
        this.xpiso2 = xpiso2;
        this.xpuerta1 = xpuerta1;
        this.xpuerta2 = xpuerta2;
    }

    public Long getPersId() {
        return persId;
    }

    public void setPersId(Long persId) {
        this.persId = persId;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Date getFechacreacion() {
        return fechacreacion;
    }

    public void setFechacreacion(Date fechacreacion) {
        this.fechacreacion = fechacreacion;
    }

    public Date getFecmod() {
        return fecmod;
    }

    public void setFecmod(Date fecmod) {
        this.fecmod = fecmod;
    }

    public int getIngresobrutos() {
        return ingresobrutos;
    }

    public void setIngresobrutos(int ingresobrutos) {
        this.ingresobrutos = ingresobrutos;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getXaltura1() {
        return xaltura1;
    }

    public void setXaltura1(int xaltura1) {
        this.xaltura1 = xaltura1;
    }

    public int getXaltura2() {
        return xaltura2;
    }

    public void setXaltura2(int xaltura2) {
        this.xaltura2 = xaltura2;
    }

    public String getXbarrio1() {
        return xbarrio1;
    }

    public void setXbarrio1(String xbarrio1) {
        this.xbarrio1 = xbarrio1;
    }

    public String getXbarrio2() {
        return xbarrio2;
    }

    public void setXbarrio2(String xbarrio2) {
        this.xbarrio2 = xbarrio2;
    }

    public String getXcalle1() {
        return xcalle1;
    }

    public void setXcalle1(String xcalle1) {
        this.xcalle1 = xcalle1;
    }

    public String getXcalle2() {
        return xcalle2;
    }

    public void setXcalle2(String xcalle2) {
        this.xcalle2 = xcalle2;
    }

    public String getXdpto1() {
        return xdpto1;
    }

    public void setXdpto1(String xdpto1) {
        this.xdpto1 = xdpto1;
    }

    public String getXdpto2() {
        return xdpto2;
    }

    public void setXdpto2(String xdpto2) {
        this.xdpto2 = xdpto2;
    }

    public double getXlatitud1() {
        return xlatitud1;
    }

    public void setXlatitud1(double xlatitud1) {
        this.xlatitud1 = xlatitud1;
    }

    public double getXlatitud2() {
        return xlatitud2;
    }

    public void setXlatitud2(double xlatitud2) {
        this.xlatitud2 = xlatitud2;
    }

    public double getXlongitud1() {
        return xlongitud1;
    }

    public void setXlongitud1(double xlongitud1) {
        this.xlongitud1 = xlongitud1;
    }

    public double getXlongitud2() {
        return xlongitud2;
    }

    public void setXlongitud2(double xlongitud2) {
        this.xlongitud2 = xlongitud2;
    }

    public String getXpiso1() {
        return xpiso1;
    }

    public void setXpiso1(String xpiso1) {
        this.xpiso1 = xpiso1;
    }

    public String getXpiso2() {
        return xpiso2;
    }

    public void setXpiso2(String xpiso2) {
        this.xpiso2 = xpiso2;
    }

    public String getXpuerta1() {
        return xpuerta1;
    }

    public void setXpuerta1(String xpuerta1) {
        this.xpuerta1 = xpuerta1;
    }

    public String getXpuerta2() {
        return xpuerta2;
    }

    public void setXpuerta2(String xpuerta2) {
        this.xpuerta2 = xpuerta2;
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

    public GsyEstcivil getEstcId() {
        return estcId;
    }

    public void setEstcId(GsyEstcivil estcId) {
        this.estcId = estcId;
    }

    public GsyLoc getLocId() {
        return locId;
    }

    public void setLocId(GsyLoc locId) {
        this.locId = locId;
    }

    public GsyTdoc getTdocId() {
        return tdocId;
    }

    public void setTdocId(GsyTdoc tdocId) {
        this.tdocId = tdocId;
    }

    public GsyUser getUsrId() {
        return usrId;
    }

    public void setUsrId(GsyUser usrId) {
        this.usrId = usrId;
    }

    public VtaCta getVtaCta() {
        return vtaCta;
    }

    public void setVtaCta(VtaCta vtaCta) {
        this.vtaCta = vtaCta;
    }

    public PrvPrv getPrvPrv() {
        return prvPrv;
    }

    public void setPrvPrv(PrvPrv prvPrv) {
        this.prvPrv = prvPrv;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (persId != null ? persId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GsyPers)) {
            return false;
        }
        GsyPers other = (GsyPers) object;
        if ((this.persId == null && other.persId != null) || (this.persId != null && !this.persId.equals(other.persId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sigemp.server.entity.GsyPers[ persId=" + persId + " ]";
    }
    
}
