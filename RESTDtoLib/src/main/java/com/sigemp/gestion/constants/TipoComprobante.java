/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigemp.gestion.constants;

import java.awt.Color;

public enum TipoComprobante {

    FACTURA(1, "FACTURAS", Sistema.VENTA),
    NOTA_DEBITO(2, "NOTA DEBITO", Sistema.VENTA),
    NOTA_CREDITO(3, "NOTA CREDITO", Sistema.VENTA),
    INGRESO_COB(4, "INGRESO", Sistema.COBRANZA),
    EGRESO_COB(5, "EGRESO", Sistema.COBRANZA),
    INGRESO_CAJ(6, "OTRO", Sistema.CAJA),
    EGRESO_CAJ(7, "OTRO", Sistema.CAJA),
    INGRESO_STK(8, "OTRO", Sistema.STOCK),
    EGRESO_STK(9, "OTRO", Sistema.STOCK),
    INGRESO_PRV(10, "OTRO", Sistema.PROVEEDORES),
    EGRESO_PRV(11, "OTRO", Sistema.PROVEEDORES),
    OTRO_CAJ(12, "OTRO", Sistema.CAJA),
    LOTE_COBRANZA(13, "LOTE", Sistema.COBANZA_LOTE),
    INVENTARIO_PROCESO(14, "PROCESO INVENTARIO", Sistema.STOCK_INVENTARIO);

    private final int codigo;
    private final String des;
    private final Sistema sistema;

    TipoComprobante(int codigo, String des, Sistema sistema) {
        this.codigo = codigo;
        this.des = des;
        this.sistema = sistema;
    }

    public Sistema getSistema() {
        return sistema;
    }

    /**
     * @return the codigo
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     * @return the des
     */
    public String getDes() {
        return des;
    }

}
