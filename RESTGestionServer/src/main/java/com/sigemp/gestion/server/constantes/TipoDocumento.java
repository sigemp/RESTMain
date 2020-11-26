/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigemp.gestion.server.constantes;

public enum TipoDocumento {

    ACTA_NACIMIENTO(93, "ACTA NACIMIENTO"),
    CDI(87, "CDI"),
    CI_BS_AS_RNP(95, "CI BS. AS. RNP"),
    CI_BUENOS_AIRES(1, "CI BUENOS AIRES"),
    CI_CATAMARCA(2, "CI CATAMARCA"),
    CI_CHACO(16, "CI CHACO"),
    CI_CHUBUT(17, "CI CHUBUT"),
    CI_CÓRDOBA(3, "CI CÓRDOBA"),
    CI_CORRIENTES(4, "CI CORRIENTES"),
    CI_ENTRE_RÍOS(5, "CI ENTRE RÍOS"),
    CI_EXTRANJERA(91, "CI EXTRANJERA"),
    CI_FORMOSA(18, "CI FORMOSA"),
    CI_JUJUY(6, "CI JUJUY"),
    CI_LA_PAMPA(21, "CI LA PAMPA"),
    CI_LA_RIOJA(8, "CI LA RIOJA"),
    CI_MENDOZA(7, "CI MENDOZA"),
    CI_MISIONES(19, "CI MISIONES"),
    CI_NEUQUÉN(20, "CI NEUQUÉN"),
    CI_POLICÍA_FEDERAL(0, "CI POLICÍA FEDERAL"),
    CI_RÍO_NEGRO(22, "CI RÍO NEGRO"),
    CI_SALTA(9, "CI SALTA"),
    CI_SAN_JUAN(10, "CI SAN JUAN"),
    CI_SAN_LUIS(11, "CI SAN LUIS"),
    CI_SANTA_CRUZ(23, "CI SANTA CRUZ"),
    CI_SANTA_FE(12, "CI SANTA FE"),
    CI_SANTIAGO_DEL_ESTERO(13, "CI SANTIAGO DEL ESTERO"),
    CI_TIERRA_DEL_FUEGO(24, "CI TIERRA DEL FUEGO"),
    CI_TUCUMÁN(14, "CI TUCUMÁN"),
    CUIL(86, "CUIL"),
    CUIT(80, "CUIT"),
    DNI(96, "DNI"),
    DOC_OTRO(99, "DOC. (OTRO)"),
    EN_TRÁMITE(92, "EN TRÁMITE"),
    LC(90, "LC"),
    LE(89, "LE"),
    PASAPORTE(94, "PASAPORTE");

    public static TipoDocumento getByDes(String tipoClave) {
        for (TipoDocumento x : TipoDocumento.values()) {
            if (x.getDescripcion().equals(tipoClave)) {
                return x;
            }
        }
        return null;
    }

    private final String descripcion;
    private final Integer id;

    private TipoDocumento(Integer id, String des) {
        this.id = id;
        this.descripcion = des;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Integer getId() {
        return id;
    }

    /**
     * Busca la TiposDocumento por ID, si no existe retora null
     *
     * @param id
     * @return the descripcion
     */
    public static TipoDocumento getById(Integer id) {
        if (id == null) {
            return null;
        }
        for (TipoDocumento x : TipoDocumento.values()) {
            if (id.equals(x.getId())) {
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
