/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigemp.gestion.client.services;

import com.sigemp.gestion.client.services.ventanaPtoVenta.PtoVtaService;

/**
 *
 * @author sigem
 */
public class ServiceFactory {

    public static GsyContadoresService getGsyContador() {
        return new GsyContadoresService();
    }

//    public static GsyContadoresTipoService getGsyContadoresTipo() {
//        return new GsyContadoresTipoService();
//    }
//
    public static GsyTalonarioService getGsyTalonarios() {
        return new GsyTalonarioService();
    }

    public static GsySucService getGsySuc() {
        return new GsySucService();
    }

    public static PtoVtaService getPtoVtaService() {
        return new PtoVtaService();
    }

    public static GsySucService getGsySucService() {
        return new GsySucService();
    }

    public static StkDepositoService getStkDepositoService() {
        return new StkDepositoService();
    }

    public static GsyCertificadoService getGsyCertificadosService() {
        return new GsyCertificadoService();
    }
    
    
}
