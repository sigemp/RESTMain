/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigemp.server.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author cristian
 */
public class DateUtils {

    private static final Logger LOG = Logger.getLogger(DateUtils.class.getName());

    /**
     * yyyyMMdd
     *
     * @param fec
     * @return
     */
    public static String formatFecha(Date fec) {
        return new SimpleDateFormat("yyyyMMdd").format(fec);
    }

    public static String formatFechaHora(Date fec) {
        return new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(fec);
    }

    public static Date getEndDate(Date fec) {
        Calendar gc = GregorianCalendar.getInstance();
        gc.setTime(fec);
        gc.set(Calendar.HOUR_OF_DAY, 23);
        gc.set(Calendar.MINUTE, 59);
        gc.set(Calendar.SECOND, 59);
        gc.set(Calendar.MILLISECOND, 999);
        return gc.getTime();
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

    public static Date getFechaUltimaSemana() {
        Calendar cal = GregorianCalendar.getInstance();
        cal.setTime(new Date());
        cal.add(Calendar.DAY_OF_WEEK, -7);
        return cal.getTime();
    }

    public static Date getStartDate(Date fec) {
        Calendar gc = GregorianCalendar.getInstance();
        gc.setTime(fec);
        gc.set(Calendar.HOUR_OF_DAY, 0);
        gc.set(Calendar.MINUTE, 0);
        gc.set(Calendar.SECOND, 0);
        gc.set(Calendar.MILLISECOND, 0);
        return gc.getTime();
    }

    public static Date parseFecha(String vencimiento) {
        try {
            return new SimpleDateFormat("yyyyMMdd").parse(vencimiento);
        } catch (ParseException ex) {
            LOG.log(Level.SEVERE, null, ex);
            return null;
        }
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
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(fec);
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
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        return sdf.format(fec);
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
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        return sdf.format(fec);
    }

}
