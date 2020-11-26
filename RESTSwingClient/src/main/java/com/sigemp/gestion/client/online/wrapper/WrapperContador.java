/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigemp.gestion.client.online.wrapper;

import com.sigemp.constants.ComportamientoEmisionComprobante;
import com.sigemp.gestion.shared.dto.ventanaPtoVenta.FormatoComprobante;
import com.sigemp.gestion.shared.dto.ventanaPtoVenta.TipoContador;
import com.sigemp.gestion.shared.entity.GsyContadores;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sigem
 */
public class WrapperContador {

    public static List<FormatoComprobante> listaFormato = new ArrayList<>();
    public static List<TipoContador> listTipoContador = new ArrayList<>();

    private FormatoComprobante trFormatoImpresion;
    private FormatoComprobante trFormatoVistaPrevia;
    private TipoContador trSistema;
    private ComportamientoEmisionComprobante trComportamientoEnEmisionComprobante;

    public static WrapperContador instance(GsyContadores current) {

        return new WrapperContador(current);
    }
    private final GsyContadores gsyContador;

    private WrapperContador(GsyContadores current) {
        this.gsyContador = current;
    }

    public void setTrFormatoImpresion(FormatoComprobante trFormatoImpresion) {
        this.trFormatoImpresion = trFormatoImpresion;
        gsyContador.setFormatioImpresion(trFormatoImpresion.getId());
    }

    public FormatoComprobante getTrFormatoImpresion() {
        if (gsyContador.getFormatioImpresion() == null) {
            return null;
        }
        if (trFormatoImpresion == null || !gsyContador.getFormatioImpresion().equals(trFormatoImpresion.getId())) {
            trFormatoImpresion = getFormatoById(gsyContador.getFormatioImpresion());
        }
        return trFormatoImpresion;
    }

    public void setTrFormatoVistaPrevia(FormatoComprobante trFormatoVistaPrevia) {
        this.trFormatoVistaPrevia = trFormatoVistaPrevia;
        gsyContador.setFormatioVistaPrevia(trFormatoVistaPrevia.getId());
    }

    public FormatoComprobante getTrFormatoVistaPrevia() {
        if (gsyContador.getFormatioVistaPrevia() == null) {
            return null;
        }
        if (trFormatoVistaPrevia == null || !gsyContador.getFormatioVistaPrevia().equals(trFormatoVistaPrevia.getId())) {
            trFormatoVistaPrevia = getFormatoById(gsyContador.getFormatioVistaPrevia());
        }
        return trFormatoVistaPrevia;
    }

    public TipoContador getTrTipoContador() {
        if (gsyContador.getTipoContador() == null) {
            return null;
        }
        if (trSistema == null || !gsyContador.getTipoContador().equals(trSistema.getId())) {
            trSistema = getTipoContadorById(gsyContador.getTipoContador());
        }
        return trSistema;
    }

    public void setTrTipoContador(TipoContador tipoContador) {
        this.trSistema = tipoContador;
        gsyContador.setTipoContador(tipoContador.getId());
    }

    public ComportamientoEmisionComprobante getTrCompEmisionComprobante() {
        if (gsyContador.getComportamientoEmisionComprobante() == null) {
            return null;
        }
        if (trComportamientoEnEmisionComprobante == null || !gsyContador.getComportamientoEmisionComprobante().equals(trComportamientoEnEmisionComprobante.getId())) {
            trComportamientoEnEmisionComprobante = ComportamientoEmisionComprobante.getById(gsyContador.getComportamientoEmisionComprobante());
        }
        return trComportamientoEnEmisionComprobante;
    }

    public void setTrCompEmisionComprobante(ComportamientoEmisionComprobante comportamientoEmisionComprobante) {
        this.trComportamientoEnEmisionComprobante = comportamientoEmisionComprobante;
        gsyContador.setComportamientoEmisionComprobante(comportamientoEmisionComprobante.getId());
    }

    /**
     * Retorno el formato de Impresion
     *
     * @param id
     * @return
     */
    public FormatoComprobante getFormatoById(Integer id) {
        for (FormatoComprobante f : listaFormato) {
            if (f.getId().equals(id)) {
                return f;
            }
        }
        return null;
    }

    public TipoContador getTipoContadorById(Integer id) {
        for (TipoContador f : listTipoContador) {
            if (f.getId().equals(id)) {
                return f;
            }
        }
        return null;
    }
}
