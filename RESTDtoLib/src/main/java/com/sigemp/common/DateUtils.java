/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigemp.common;

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
class DateUtils {

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

    /**
     *
     * @param fec
     * @return
     */
    public static String formatFechaHora(Date fec) {
        return new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(fec);
    }

    /**
     *
     * @param fec
     * @return
     */
    public static Date getEndDate(Date fec) {
        Calendar gc = GregorianCalendar.getInstance();
        gc.setTime(fec);
        gc.set(Calendar.HOUR_OF_DAY, 23);
        gc.set(Calendar.MINUTE, 59);
        gc.set(Calendar.SECOND, 59);
        gc.set(Calendar.MILLISECOND, 999);
        return gc.getTime();
    }

    /**
     *
     * @param fechaMayor
     * @param fechaMenor
     * @return
     */
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
     * @return 
     */
    public static Date getFechaActual() {
        return new Date();
    }

    /**
     *
     * @return
     */
    public static Date getFechaUltimaSemana() {
        Calendar cal = GregorianCalendar.getInstance();
        cal.setTime(new Date());
        cal.add(Calendar.DAY_OF_WEEK, -7);
        return cal.getTime();
    }

    /**
     * Retorna la fecha pasa como argumento con 00:00:00 horas
     * 
     * 
     *
     * @param fec
     * @return
     */
    public static Date getStartDate(Date fec) {
        Calendar gc = GregorianCalendar.getInstance();
        gc.setTime(fec);
        gc.set(Calendar.HOUR_OF_DAY, 0);
        gc.set(Calendar.MINUTE, 0);
        gc.set(Calendar.SECOND, 0);
        gc.set(Calendar.MILLISECOND, 0);
        return gc.getTime();
    }

    /**
     * retorna String con Formato yyyyMMdd
     * 
     * 
     * @param vencimiento
     * @return
     */
    public static Date parseFecha(String vencimiento) {
        try {
            return new SimpleDateFormat("yyyyMMdd").parse(vencimiento);
        } catch (ParseException ex) {
            LOG.log(Level.SEVERE, ex.getMessage(), ex);
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
     * dd/MM/yyyy HH:mm:ss normalmente
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
