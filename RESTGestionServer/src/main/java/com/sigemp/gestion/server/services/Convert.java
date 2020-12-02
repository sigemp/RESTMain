/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigemp.gestion.server.services;

import com.sigemp.gestion.shared.dto.GsyContadoresDto;
import com.sigemp.gestion.shared.dto.GsyTalonariosDto;
import com.sigemp.gestion.shared.entity.GsyContadores;
import com.sigemp.gestion.shared.entity.GsyContadorestipos;
import com.sigemp.gestion.shared.entity.GsyTalonarios;
import com.sigemp.gestion.shared.entity.GsyTiposcomprobantes;

/**
 * Junta todas las Opciones de Conversion entre entity y dto
 *
 * @author sigem
 */
public class Convert {

    GsyContadoresDto toDto(GsyContadores entity) {
        GsyContadoresDto dto = new GsyContadoresDto();
        dto.setAutoIncrementa(entity.getAutoIncrementa());
        dto.setCantidadCopias(entity.getCantidadCopias());
        dto.setComportamientoEmisionComprobante(entity.getComportamientoEmisionComprobante());
        dto.setConId(entity.getConId());
        dto.setDes(entity.getDes());
        dto.setEstado(entity.getEstado());
        dto.setFormatioImpresion(entity.getFormatioImpresion());
        dto.setFormatioVistaPrevia(entity.getFormatioVistaPrevia());
        dto.setNroactual(entity.getNroactual());
        dto.setPermiteCambioFecha(entity.getPermiteCambioFecha());
        dto.setTalId(entity.getTalId().getTalId());
        
        for (GsyContadorestipos comprobantes : entity.getGsyContadorestiposCollection()) {
            dto.getComprobantes().add(comprobantes.getTcId().getTcId());
        }
       
        return dto;
    }

    GsyTalonariosDto toDto(GsyTalonarios entity) {
        GsyTalonariosDto dto = new GsyTalonariosDto();
        //dto.setDepoId(depoId);
        return dto;
    }

}
