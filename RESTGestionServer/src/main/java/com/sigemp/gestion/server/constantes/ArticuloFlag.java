/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigemp.gestion.server.constantes;

public enum ArticuloFlag {
    FLAG_MODIFICA_PRECIOS("m", "Modifica Precio"),
    FLAG_MODIFICA_DESCRIPCION("d", "Modifica Descripcion"),
    FLAG_USO_EXPLUSIVO("x", "Uso Exclusivo Sistema"),
    FLAG_MODIFICA_CANTIDAD_PRECIO("P", "Modifica Cantidad"),
    FLAG_MERCADERIA_VENTA_PESO("e", "Venta Peso"),
    FLAG_NO_PERMITE_DESCUENTO_GLOBAL("D", "Descuento Global"),
    FLAG_NO_PERMITE_DESCUENTO_UNITARIO("u", "Descuento Unitario"),
    FLAG_NO_FINANCIA("y", "No Financia"),
    FLAG_INGRESA_TODA_FACTURA("f", "Ingresa Toda Factura"),
    FLAG_GESTIONA_STOCK("s", "Gestiona Stock"),
    FLAG_NO_EXPORTA_MOBILE("I", "No Exporta a Mobil"),
    FLAG_PERMITE_FRACCIONAR("F", "Permite Fraccionar"),
    FLAG_NO_TIENE_STOCK("K", "Articulo Bloqueado"),
    FLAG_NO_PEDIR_CANTIDAD("n", "Permitir Cantidad"),
    FLAG_PRESUPUESTO_SIVA("p", "Para presupuesto"),
    FLAG_NO_REPETIR_ARTICULOS_EN_DISTINTOS_RENGLONES("r", "Repetir Articulos en Factura"),
    FLAG_IVA0_DCTO_567_2019("v", "IVA 0 Decreto 567/2019");

    private final String codigo;
    private final String des;

    ArticuloFlag(String codigo, String des) {
        this.codigo = codigo;
        this.des = des;
    }

    /**
     * @return the codigo
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * @return the des
     */
    public String getDes() {
        return des;
    }

}
