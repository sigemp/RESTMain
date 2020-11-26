/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigemp.constants;

import java.math.BigDecimal;

public enum TiposIva {

    EXENTO("EXENTO 0 %", 3, new BigDecimal("0")),
    IVA105("IVA 10,50 %", 4, new BigDecimal("10.5")),
    IVA21("IVA 21,00%", 5, new BigDecimal("21")),
    IVA27("IVA 27,00%", 6, new BigDecimal("27")),
    IVA5("IVA 5,00%", 8, new BigDecimal("5")),
    IVA25("IVA 2,50", 9, new BigDecimal("2.5"));

    private final String descripcion;
    private final int id;
    private final BigDecimal porcentaje;

    private TiposIva(String des, int id, BigDecimal porcentaje) {
        this.descripcion = des;
        this.id = id;
        this.porcentaje = porcentaje;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getId() {
        return id;
    }

    public BigDecimal getPorcentaje() {
        return porcentaje;
    }

    /**
     * Busca la TiposIva por ID, si no existe retora null
     *
     * @param id
     * @return TiposIva
     */
    public static TiposIva getById(Integer id) {
        if (id == null) {
            return null;
        }
        for (TiposIva x : TiposIva.values()) {
            if (id.equals(x.getId())) {
                return x;
            }
        }
        return null;
    }

    /**
     * Busca TiposIva por su id, si no encuentra retorna null
     *
     *
     * @param alicuota
     * @return
     */
    public static TiposIva getTiposByAlicuota(BigDecimal alicuota) {
        if (alicuota == null) {
            return null;
        }
        for (TiposIva x : TiposIva.values()) {
            if (alicuota.compareTo(x.getPorcentaje()) == 0) {
                return x;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return getDescripcion();
    }
}
