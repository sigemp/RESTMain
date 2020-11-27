/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigemp.gestion.shared.dto.ventanaPtoVenta;

import java.util.List;

/**
 *
 * @author sigem
 */
public class OpcionesContadorDto {

    private List<FormatoComprobanteDto> formatoImpresion;
    private List<FormatoComprobanteDto> formatoVistaPrevia;
    private List<Integer> comprobantes;

    /**
     * @return the formatoImpresion
     */
    public List<FormatoComprobanteDto> getFormatoImpresion() {
        return formatoImpresion;
    }

    /**
     * @param formatoImpresion the formatoImpresion to set
     */
    public void setFormatoImpresion(List<FormatoComprobanteDto> formatoImpresion) {
        this.formatoImpresion = formatoImpresion;
    }

    /**
     * @return the formatoVistaPrevia
     */
    public List<FormatoComprobanteDto> getFormatoVistaPrevia() {
        return formatoVistaPrevia;
    }

    /**
     * @param formatoVistaPrevia the formatoVistaPrevia to set
     */
    public void setFormatoVistaPrevia(List<FormatoComprobanteDto> formatoVistaPrevia) {
        this.formatoVistaPrevia = formatoVistaPrevia;
    }

    /**
     * @return the formatosComprobantes
     */
    public List<Integer> getComprobantes() {
        return comprobantes;
    }

    /**
     * @param formatosComprobantes the formatosComprobantes to set
     */
    public void setComprobantes(List<Integer> formatosComprobantes) {
        this.comprobantes = formatosComprobantes;
    }
}
