/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigemp.gestion.client.online.wrapper;

import com.sigemp.afip.ifis.ConstantesFiscales.Baudios;
import com.sigemp.afip.ifis.ConstantesFiscales.Marcas;
import com.sigemp.afip.ifis.ConstantesFiscales.Modelos;
import com.sigemp.afip.ifis.ConstantesFiscales.Puertos;
import com.sigemp.common.StringUtils;
import com.sigemp.gestion.shared.entity.GsyTalonarios;
import static com.sigemp.common.StringUtils.RC;

/**
 *
 * @author sigem
 */
public class WrapperPtoVta {

    private final GsyTalonarios current;
    private Marcas trMarca;
    private Puertos trPuerto;
    private Modelos trModelo;
    private Baudios trBaudios;

    public WrapperPtoVta(GsyTalonarios current) {
        this.current = current;
    }

    public static WrapperPtoVta instance(GsyTalonarios current) {

        return new WrapperPtoVta(current);
    }

    /**
     * @return the trPuerto
     */
    public Puertos getTrPuerto() {
        if (trPuerto == null) {
            trPuerto = Puertos.getFromId(current.getIfpuerto());
        }
        return trPuerto;
    }

    /**
     * @param trPuerto the trPuerto to set
     */
    public void setTrPuerto(Puertos trPuerto) {
        this.trPuerto = trPuerto;
        current.setIfpuerto(trPuerto.getId());
    }

    /**
     * @return the trMarca
     */
    public Marcas getTrMarca() {
        if (trMarca == null) {
            trMarca = Marcas.getMarca(current.getIfmarca());
        }
        return trMarca;
    }

    /**
     * @param trMarca the trMarca to set
     */
    public void setTrMarca(Marcas trMarca) {
        this.trMarca = trMarca;
        current.setIfmarca(trMarca.getDescripcion());
    }

    /**
     * @return the trModelo
     */
    public Modelos getTrModelo() {
        if (trModelo == null) {
            trModelo = Modelos.getModelo(current.getIfmodelo());
        }
        return trModelo;
    }

    /**
     * @param trModelo the trModelo to set
     */
    public void setTrModelo(Modelos trModelo) {
        this.trModelo = trModelo;
        current.setIfmodelo(trModelo.getDescripcion());
    }

    /**
     * @return the trBaudios
     */
    public Baudios getTrBaudios() {
        if (trBaudios == null) {
            trBaudios = Baudios.getFromString(current.getIfbaudios());
        }
        return trBaudios;
    }

    /**
     * @param trBaudios the trBaudios to set
     */
    public void setTrBaudios(Baudios trBaudios) {
        this.trBaudios = trBaudios;
        current.setIfbaudios(trBaudios.getDescripcion());
    }

    public String getDescripcionTalonario() {
        Marcas marca = getTrMarca();
        Modelos modelo = getTrModelo();

        String tmpDes = "";
        if (null != marca) {
            switch (marca) {
                case EPSON:
                    tmpDes = "Impresor Fiscal Epson " + modelo.getDescripcion();
                    break;
                case HASAR:
                    tmpDes = "Impresor Fiscal Hasar " + modelo.getDescripcion();
                    break;
                case AFIP:
                    tmpDes = "Factura Electronica " + modelo.getDescripcion();
                    break;
                case MANUAL:
                    tmpDes = "Talonario Manual " + modelo.getDescripcion();
                    break;
                case PREIMPRESO:
                    tmpDes = "Talonario Preimpreso " + modelo.getDescripcion();
                    break;
                default:
                    tmpDes = "No Identificado";
                    break;
            }
        }
        return tmpDes;
    }

    public String printDetail() {
        StringUtils su = new StringUtils();
        StringBuilder sb = new StringBuilder();

        sb.append(su.repetir("=-", 36)).append(RC);
        sb.append("Talonario : ").append(current.getTalId())
                .append(" Descripcion : ").append(current.getDes())
                .append(RC);

//        for (GsyContador cont : current.getGsyContadores()) {
//            sb.append("  ")
//                    .append(cont.getDes())
//                    .append(RC);
//            for (GsyContadorestipo contt : cont.getGsyContadorestipos()) {
//                sb.append("      ")
//                        .append(contt.getComprobante().getDescripcion())
//                        .append(RC);
//            }
//        }
        return sb.toString();

    }
    
}
