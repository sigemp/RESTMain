/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigemp.gestion.shared.entity;

import java.io.Serializable;
import java.util.Collection;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author cristian
 */
@Entity
@Table(name = "gsy_contadores")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GsyContadores.findAll", query = "SELECT g FROM GsyContadores g")
    , @NamedQuery(name = "GsyContadores.findByConId", query = "SELECT g FROM GsyContadores g WHERE g.conId = :conId")
    , @NamedQuery(name = "GsyContadores.findByAutoIncrementa", query = "SELECT g FROM GsyContadores g WHERE g.autoIncrementa = :autoIncrementa")
    , @NamedQuery(name = "GsyContadores.findByCantidadCopias", query = "SELECT g FROM GsyContadores g WHERE g.cantidadCopias = :cantidadCopias")
    , @NamedQuery(name = "GsyContadores.findByDes", query = "SELECT g FROM GsyContadores g WHERE g.des = :des")
    , @NamedQuery(name = "GsyContadores.findByEstado", query = "SELECT g FROM GsyContadores g WHERE g.estado = :estado")
    , @NamedQuery(name = "GsyContadores.findByImpresoraDirecta", query = "SELECT g FROM GsyContadores g WHERE g.impresoraDirecta = :impresoraDirecta")
    , @NamedQuery(name = "GsyContadores.findByNroactual", query = "SELECT g FROM GsyContadores g WHERE g.nroactual = :nroactual")
    , @NamedQuery(name = "GsyContadores.findByPermiteCambioFecha", query = "SELECT g FROM GsyContadores g WHERE g.permiteCambioFecha = :permiteCambioFecha")
    , @NamedQuery(name = "GsyContadores.findByFormatioImpresion", query = "SELECT g FROM GsyContadores g WHERE g.formatioImpresion = :formatioImpresion")
    , @NamedQuery(name = "GsyContadores.findByFormatioVistaPrevia", query = "SELECT g FROM GsyContadores g WHERE g.formatioVistaPrevia = :formatioVistaPrevia")
    , @NamedQuery(name = "GsyContadores.findByComportamientoEmisionComprobante", query = "SELECT g FROM GsyContadores g WHERE g.comportamientoEmisionComprobante = :comportamientoEmisionComprobante")
    , @NamedQuery(name = "GsyContadores.findByTipoContador", query = "SELECT g FROM GsyContadores g WHERE g.tipoContador = :tipoContador")})
public class GsyContadores implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "con_id")
    private Integer conId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "auto_incrementa")
    private boolean autoIncrementa;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidad_copias")
    private int cantidadCopias;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "des")
    private String des;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estado")
    private boolean estado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 120)
    @Column(name = "impresora_directa")
    private String impresoraDirecta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nroactual")
    private int nroactual;
    @Basic(optional = false)
    @NotNull
    @Column(name = "permite_cambio_fecha")
    private boolean permiteCambioFecha;
    @Column(name = "formatio_impresion")
    private Integer formatioImpresion;
    @Column(name = "formatio_vista_previa")
    private Integer formatioVistaPrevia;
    @Column(name = "comportamiento_emision_comprobante")
    private Integer comportamientoEmisionComprobante;
    @Column(name = "tipo_contador")
    private Integer tipoContador;
    @JoinColumn(name = "tal_id", referencedColumnName = "tal_id")
    @ManyToOne(optional = false)
    private GsyTalonarios talId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "conId")
    private Collection<GsyContadorestipos> gsyContadorestiposCollection;

    public GsyContadores() {
    }

    public GsyContadores(Integer conId) {
        this.conId = conId;
    }

    public GsyContadores(Integer conId, boolean autoIncrementa, int cantidadCopias, String des, boolean estado, String impresoraDirecta, int nroactual, boolean permiteCambioFecha) {
        this.conId = conId;
        this.autoIncrementa = autoIncrementa;
        this.cantidadCopias = cantidadCopias;
        this.des = des;
        this.estado = estado;
        this.impresoraDirecta = impresoraDirecta;
        this.nroactual = nroactual;
        this.permiteCambioFecha = permiteCambioFecha;
    }

    public Integer getConId() {
        return conId;
    }

    public void setConId(Integer conId) {
        this.conId = conId;
    }

    public boolean getAutoIncrementa() {
        return autoIncrementa;
    }

    public void setAutoIncrementa(boolean autoIncrementa) {
        this.autoIncrementa = autoIncrementa;
    }

    public int getCantidadCopias() {
        return cantidadCopias;
    }

    public void setCantidadCopias(int cantidadCopias) {
        this.cantidadCopias = cantidadCopias;
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

    public String getImpresoraDirecta() {
        return impresoraDirecta;
    }

    public void setImpresoraDirecta(String impresoraDirecta) {
        this.impresoraDirecta = impresoraDirecta;
    }

    public int getNroactual() {
        return nroactual;
    }

    public void setNroactual(int nroactual) {
        this.nroactual = nroactual;
    }

    public boolean getPermiteCambioFecha() {
        return permiteCambioFecha;
    }

    public void setPermiteCambioFecha(boolean permiteCambioFecha) {
        this.permiteCambioFecha = permiteCambioFecha;
    }

    public Integer getFormatioImpresion() {
        return formatioImpresion;
    }

    public void setFormatioImpresion(Integer formatioImpresion) {
        this.formatioImpresion = formatioImpresion;
    }

    public Integer getFormatioVistaPrevia() {
        return formatioVistaPrevia;
    }

    public void setFormatioVistaPrevia(Integer formatioVistaPrevia) {
        this.formatioVistaPrevia = formatioVistaPrevia;
    }

    public Integer getComportamientoEmisionComprobante() {
        return comportamientoEmisionComprobante;
    }

    public void setComportamientoEmisionComprobante(Integer comportamientoEmisionComprobante) {
        this.comportamientoEmisionComprobante = comportamientoEmisionComprobante;
    }

    public Integer getTipoContador() {
        return tipoContador;
    }

    public void setTipoContador(Integer tipoContador) {
        this.tipoContador = tipoContador;
    }

    public GsyTalonarios getTalId() {
        return talId;
    }

    public void setTalId(GsyTalonarios talId) {
        this.talId = talId;
    }

    @XmlTransient
    public Collection<GsyContadorestipos> getGsyContadorestiposCollection() {
        return gsyContadorestiposCollection;
    }

    public void setGsyContadorestiposCollection(Collection<GsyContadorestipos> gsyContadorestiposCollection) {
        this.gsyContadorestiposCollection = gsyContadorestiposCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (conId != null ? conId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GsyContadores)) {
            return false;
        }
        GsyContadores other = (GsyContadores) object;
        if ((this.conId == null && other.conId != null) || (this.conId != null && !this.conId.equals(other.conId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sigemp.server.entity.GsyContadores[ conId=" + conId + " ]";
    }
    
}
