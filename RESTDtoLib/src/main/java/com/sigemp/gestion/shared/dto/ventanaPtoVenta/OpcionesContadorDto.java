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

    private List<FormatoComprobante> formatoImpresion;
    private List<FormatoComprobante> formatoVistaPrevia;
    private List<Comprobantes> formatosComprobantes;

    /**
     * @return the formatoImpresion
     */
    public List<FormatoComprobante> getFormatoImpresion() {
        return formatoImpresion;
    }

    /**
     * @param formatoImpresion the formatoImpresion to set
     */
    public void setFormatoImpresion(List<FormatoComprobante> formatoImpresion) {
        this.formatoImpresion = formatoImpresion;
    }

    /**
     * @return the formatoVistaPrevia
     */
    public List<FormatoComprobante> getFormatoVistaPrevia() {
        return formatoVistaPrevia;
    }

    /**
     * @param formatoVistaPrevia the formatoVistaPrevia to set
     */
    public void setFormatoVistaPrevia(List<FormatoComprobante> formatoVistaPrevia) {
        this.formatoVistaPrevia = formatoVistaPrevia;
    }

    /**
     * @return the formatosComprobantes
     */
    public List<Comprobantes> getFormatosComprobantes() {
        return formatosComprobantes;
    }

    /**
     * @param formatosComprobantes the formatosComprobantes to set
     */
    public void setFormatosComprobantes(List<Comprobantes> formatosComprobantes) {
        this.formatosComprobantes = formatosComprobantes;
    }
}
