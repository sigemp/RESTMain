/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigemp.gestion.client.api.util;

import com.google.gwt.i18n.client.NumberFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

/**
 * Utilitarios mas comunes para trabajar con Strings
 * @author Server
 */
public class StringUtils {

    private static final Logger LOG = Logger.getLogger(StringUtils.class.getName());
    public static final String RC = "\r\n";

    public static String ArrayToString(int[] intNumbers) {
        StringBuilder sbfNumbers = new StringBuilder();
        String strSeparator = ",";
        if (intNumbers.length > 0) {
            sbfNumbers.append(intNumbers[0]);
            for (int i = 1; i < intNumbers.length; i++) {
                sbfNumbers.append(strSeparator).append(intNumbers[i]);
            }
        }
        return sbfNumbers.toString();
    }

    public static boolean comienzaConNumero(String text) {
        char code = text.charAt(0);
        switch (code) {
            case '0':
            case '1':
            case '2':
            case '3':
            case '4':
            case '5':
            case '6':
            case '7':
            case '8':
            case '9':
                return true;
            default:
                return false;
        }
    }

    /**
     * Convierte una lista Integer en cadena separada por coma util para
     * utilizar en la clausula in de un sql ej in (1,2,3,4)
     *
     * @param valores
     * @return
     */
    public static String listToString(List<Integer> valores) {
        String sel = "";
        for (Integer val : valores) {
            if (!sel.isEmpty()) {
                sel += ",";
            }
            sel += val;
        }
        return sel;
    }

    public static String stringArrayCheck(String rutas) {
        int[] intArray = stringToArray(rutas);
        return ArrayToString(intArray);
    }

    public static int[] stringToArray(String lista) {
        String[] strArray = lista.split(",");
        int[] intArray = new int[strArray.length];
        for (int i = 0; i < strArray.length; i++) {
            intArray[i] = Integer.parseInt(strArray[i]);
        }
        return intArray;
    }

    public String numToStr(Number num, int enteros) {
        return numToStr(num, enteros, 0, false);
    }

    public String numToStr(Number num, int enteros, int decimales) {
        return numToStr(num, enteros, decimales, false);
    }

    public String numToStr(Number num, int enteros, int decimales, boolean cerosIzquierda) {
        String patt_enteros = repetir("0", enteros);
        String patt_decimales = repetir("0", decimales);
        String patt = "0";
        int longitud = enteros;
        if (cerosIzquierda) {
            patt = patt_enteros;
        }
        if (decimales > 0) {
            longitud += decimales + 1;
            patt += "." + patt_decimales;
        }
        NumberFormat formatterNum = NumberFormat.getFormat(patt);

        String str;
        // Si fine null retorno null
        if (num == null) {
            str = "null";
        } else {
            str = formatterNum.format(num);
        }

        if (enteros < 0) {
            return str;
        } else {
            return fillIzquierda(str, longitud);
        }
    }

    public final NumberFormat formatterC = NumberFormat.getFormat("#####0.00");
    private final NumberFormat formatterP = NumberFormat.getFormat("###,##0.00");
    public final NumberFormat formatterP4 = NumberFormat.getFormat("###,##0.0000");
////    public static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
////
////    public static final SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy");

    public static double truncate(double x) {
        long y = (long) (x * 100);
        return (double) y / 100;
    }

    public String fillIzquierda(String s, int n) {
        if (s.length() > n) {
            s = s.substring(0, n);
        }
        int falta = s.length() - n;
        if (falta > 0) {
            return repeat(" ", falta) + s;
        }
        return s;
    }

    public String fillDerecha(String s, int n) {
        if (s.length() > n) {
            s = s.substring(0, n);
        }
        int falta = s.length() - n;
        if (falta > 0) {
            return s + repeat(" ", falta);
        }

        return s;
    }

    public static String repeat(String s, int n) {
        if (s == null) {
            return null;
        }
        final StringBuilder sb = new StringBuilder(s.length() * n);
        for (int i = 0; i < n; i++) {
            sb.append(s);
        }
        return sb.toString();
    }

    public String formatearCantidad(Number cnt) {
        if (cnt == null) {
            return "null";
        }
        return formatterC.format(cnt);
    }

    public String formatearPrecio(Number prc) {
        if (prc == null) {
            return "null";
        }
        return formatterP.format(prc);
    }

    public String formatFechaHora(Date fec) {
        if (fec == null) {
            //"12/12/12 12:12:12"
            return "             null";
        }
        return DateUtilsGWT.toDateTimeView(fec);
    }

    public String formatFecha(Date fec) {
        if (fec == null) {
            //"12/12/12"
            return "    null";
        }
        return DateUtilsGWT.toDateView(fec);
    }

    public String repetir(String str, int cnt) {

        String s = "";
        for (int x = 0; x < cnt; x++) {
            s += str;
        }
        return s;
    }

    public int paginas(int cntItems, int cnt) {
        if (cnt == 0) {
            return 0;
        }
        double val_div = cnt / cntItems;
        int val_truncado = (int) truncate(val_div);

        if (val_div == (val_truncado + 1)) {
            return (int) val_div;
        }
        return (val_truncado + 1);
    }

    public String mes(int mes) {
        switch (mes) {
            case 1:
                return "Enero";
            case 2:
                return "Febrero";
            case 3:
                return "Marzo";
            case 4:
                return "Abril";
            case 5:
                return "Mayo";
            case 6:
                return "Junio";
            case 7:
                return "Julio";
            case 8:
                return "Agosto";
            case 9:
                return "Septiembre";
            case 10:
                return "Octubre";
            case 11:
                return "Noviembre";
            case 12:
                return "Diciembre";
        }
        return "";
    }
}
