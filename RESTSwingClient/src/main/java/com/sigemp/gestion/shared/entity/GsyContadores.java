/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigemp.gestion.shared.entity;

import java.io.Serializable;

/**
 *
 * @author cristian
 */
public class GsyContadores implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer conId;
    private boolean autoIncrementa;
    private int cantidadCopias;
    private String des;
    private boolean estado;
    private String impresoraDirecta;
    private int nroactual;
    private boolean permiteCambioFecha;
    private Integer formatioImpresion;
    private Integer formatioVistaPrevia;
    private Integer comportamientoEmisionComprobante;
    private Integer tipoContador;
    private GsyTalonarios talId;

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
