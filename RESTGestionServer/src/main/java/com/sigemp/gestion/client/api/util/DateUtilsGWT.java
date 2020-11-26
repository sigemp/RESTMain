/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigemp.gestion.client.api.util;

import com.google.gwt.i18n.client.DateTimeFormat;
import java.util.Date;

/**
 *
 * @author cristian
 */
public class DateUtilsGWT {


    /**
     * yyyyMMdd
     *
     * @param fec
     * @return
     */
    public static String formatFecha(Date fec) {
        return DateTimeFormat.getFormat("yyyyMMdd").format(fec);
    }

    public static String formatFechaHora(Date fec) {
        return DateTimeFormat.getFormat("dd/MM/yyyy HH:mm:ss").format(fec);
    }

    public static int diferenciaEnDias(Date fechaMayor, Date fechaMenor) {
        long diferenciaEn = fechaMayor.getTime() - fechaMenor.getTime();
        long dias = diferenciaEn / (1000 * 60 * 60 * 24);
        return (int) dias;
    }

    /**
     * retorna la fecha actual de la maquina en la que se ejecuta el sistema es
     * igual a "new Date()"
     *
     *
     *
     */
    public static Date getFechaActual() {
        return new Date();
    }


    public static Date parseFecha(String vencimiento) {
        return DateTimeFormat.getFormat("yyyyMMdd").parse(vencimiento);

    }

    /**
     * retorna string con formato yyyy-MM-dd Se usa para pasar a un sql y lo
     * pueda reconocer la base de datos Postgres
     *
     *
     * @param fec
     * @return
     */
    public static String toDateDB(Date fec) {
        return DateTimeFormat.getFormat("yyyy-MM-dd").format(fec);
    }

    /**
     * Estandariza el formato con el que se muestra unicamente la fecha
     * dd-MM-YYYY normalmente
     *
     *
     * @param fec Fecha a la que se le va a dar el formato
     * @return
     */
    public static String toDateTimeView(Date fec) {
        return DateTimeFormat.getFormat("dd/MM/yyyy HH:mm:ss").format(fec);
    }

    /**
     * Estandariza el formato con el que se muestra unicamente la fecha
     * dd-MM-YYYY normalmente
     *
     *
     * @param fec Fecha a la que se le va a dar el formato
     * @return
     */
    public static String toDateView(Date fec) {
        return DateTimeFormat.getFormat("dd-MM-yyyy").format(fec);
    }

}
