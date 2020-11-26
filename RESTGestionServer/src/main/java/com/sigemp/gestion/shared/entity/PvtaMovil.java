/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigemp.gestion.shared.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "pvta_movil")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PvtaMovil.findAll", query = "SELECT p FROM PvtaMovil p")
    , @NamedQuery(name = "PvtaMovil.findByMovilId", query = "SELECT p FROM PvtaMovil p WHERE p.movilId = :movilId")
    , @NamedQuery(name = "PvtaMovil.findByDes", query = "SELECT p FROM PvtaMovil p WHERE p.des = :des")
    , @NamedQuery(name = "PvtaMovil.findByVenId", query = "SELECT p FROM PvtaMovil p WHERE p.venId = :venId")
    , @NamedQuery(name = "PvtaMovil.findByActivo", query = "SELECT p FROM PvtaMovil p WHERE p.activo = :activo")
    , @NamedQuery(name = "PvtaMovil.findByGuardarPosicionVenta", query = "SELECT p FROM PvtaMovil p WHERE p.guardarPosicionVenta = :guardarPosicionVenta")
    , @NamedQuery(name = "PvtaMovil.findByGuardarTrayectoVenta", query = "SELECT p FROM PvtaMovil p WHERE p.guardarTrayectoVenta = :guardarTrayectoVenta")
    , @NamedQuery(name = "PvtaMovil.findByImei", query = "SELECT p FROM PvtaMovil p WHERE p.imei = :imei")
    , @NamedQuery(name = "PvtaMovil.findByHabilitarCobranza", query = "SELECT p FROM PvtaMovil p WHERE p.habilitarCobranza = :habilitarCobranza")
    , @NamedQuery(name = "PvtaMovil.findByComprimeDatos", query = "SELECT p FROM PvtaMovil p WHERE p.comprimeDatos = :comprimeDatos")
    , @NamedQuery(name = "PvtaMovil.findByControlarCambioHorario", query = "SELECT p FROM PvtaMovil p WHERE p.controlarCambioHorario = :controlarCambioHorario")
    , @NamedQuery(name = "PvtaMovil.findByTransmitirPorInternet", query = "SELECT p FROM PvtaMovil p WHERE p.transmitirPorInternet = :transmitirPorInternet")})
public class PvtaMovil implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "movil_id")
    private Integer movilId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "des")
    private String des;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ven_id")
    private int venId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "activo")
    private boolean activo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "guardar_posicion_venta")
    private boolean guardarPosicionVenta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "guardar_trayecto_venta")
    private boolean guardarTrayectoVenta;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "imei")
    private String imei;
    @Basic(optional = false)
    @NotNull
    @Column(name = "habilitar_cobranza")
    private boolean habilitarCobranza;
    @Basic(optional = false)
    @NotNull
    @Column(name = "comprime_datos")
    private boolean comprimeDatos;
    @Basic(optional = false)
    @NotNull
    @Column(name = "controlar_cambio_horario")
    private boolean controlarCambioHorario;
    @Column(name = "transmitir_por_internet")
    private Boolean transmitirPorInternet;

    public PvtaMovil() {
    }

    public PvtaMovil(Integer movilId) {
        this.movilId = movilId;
    }

    public PvtaMovil(Integer movilId, String des, int venId, boolean activo, boolean guardarPosicionVenta, boolean guardarTrayectoVenta, String imei, boolean habilitarCobranza, boolean comprimeDatos, boolean controlarCambioHorario) {
        this.movilId = movilId;
        this.des = des;
        this.venId = venId;
        this.activo = activo;
        this.guardarPosicionVenta = guardarPosicionVenta;
        this.guardarTrayectoVenta = guardarTrayectoVenta;
        this.imei = imei;
        this.habilitarCobranza = habilitarCobranza;
        this.comprimeDatos = comprimeDatos;
        this.controlarCambioHorario = controlarCambioHorario;
    }

    public Integer getMovilId() {
        return movilId;
    }

    public void setMovilId(Integer movilId) {
        this.movilId = movilId;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public int getVenId() {
        return venId;
    }

    public void setVenId(int venId) {
        this.venId = venId;
    }

    public boolean getActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public boolean getGuardarPosicionVenta() {
        return guardarPosicionVenta;
    }

    public void setGuardarPosicionVenta(boolean guardarPosicionVenta) {
        this.guardarPosicionVenta = guardarPosicionVenta;
    }

    public boolean getGuardarTrayectoVenta() {
        return guardarTrayectoVenta;
    }

    public void setGuardarTrayectoVenta(boolean guardarTrayectoVenta) {
        this.guardarTrayectoVenta = guardarTrayectoVenta;
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    public boolean getHabilitarCobranza() {
        return habilitarCobranza;
    }

    public void setHabilitarCobranza(boolean habilitarCobranza) {
        this.habilitarCobranza = habilitarCobranza;
    }

    public boolean getComprimeDatos() {
        return comprimeDatos;
    }

    public void setComprimeDatos(boolean comprimeDatos) {
        this.comprimeDatos = comprimeDatos;
    }

    public boolean getControlarCambioHorario() {
        return controlarCambioHorario;
    }

    public void setControlarCambioHorario(boolean controlarCambioHorario) {
        this.controlarCambioHorario = controlarCambioHorario;
    }

    public Boolean getTransmitirPorInternet() {
        return transmitirPorInternet;
    }

    public void setTransmitirPorInternet(Boolean transmitirPorInternet) {
        this.transmitirPorInternet = transmitirPorInternet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (movilId != null ? movilId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PvtaMovil)) {
            return false;
        }
        PvtaMovil other = (PvtaMovil) object;
        if ((this.movilId == null && other.movilId != null) || (this.movilId != null && !this.movilId.equals(other.movilId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sigemp.server.entity.PvtaMovil[ movilId=" + movilId + " ]";
    }
    
}
