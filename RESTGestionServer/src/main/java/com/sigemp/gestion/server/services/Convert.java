/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigemp.gestion.server.services;

import com.sigemp.gestion.shared.dto.GsyCertificadosDto;
import com.sigemp.gestion.shared.dto.GsyContadoresDto;
import com.sigemp.gestion.shared.dto.GsyTalonariosDto;
import com.sigemp.gestion.shared.dto.ventanaCertificados.ListCertificadoDto;
import com.sigemp.gestion.shared.entity.GsyCertificados;
import com.sigemp.gestion.shared.entity.GsyContadores;
import com.sigemp.gestion.shared.entity.GsyContadorestipos;
import com.sigemp.gestion.shared.entity.GsyTalonarios;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;

/**
 * Junta todas las Opciones de Conversion entre entity y dto
 *
 * @author sigem
 */
public class Convert {

    private final EntityManager em;
    
    public Convert(EntityManager em) {
        this.em = em;
    }

    public GsyCertificados toEntity(GsyCertificadosDto dto) {
        GsyCertificados entity = new GsyCertificados();
        entity.setActivo(dto.getActivo());
        entity.setCerId(dto.getCerId());
        entity.setDes(dto.getDes());
        entity.setFeCertificado(dto.getFeCertificado());
        entity.setFePrivatekey(dto.getFePrivatekey());
        entity.setFeTa(dto.getFeTa());
        entity.setFec(dto.getFec());
        entity.setTipo(dto.getTipo());
        return entity;
    }

    public GsyCertificadosDto toDto(GsyCertificados entity) {
        GsyCertificadosDto dto = new GsyCertificadosDto();
        dto.setActivo(entity.getActivo());
        dto.setCerId(entity.getCerId());
        dto.setDes(entity.getDes());
        dto.setFeCertificado(entity.getFeCertificado());
        dto.setFePrivatekey(entity.getFePrivatekey());
        dto.setFeTa(entity.getFeTa());
        dto.setFec(entity.getFec());
        dto.setTipo(entity.getTipo());
        return dto;
    }

    public List<ListCertificadoDto> toDto(List<GsyCertificados> listEntity) {
        List<ListCertificadoDto> listDto = new ArrayList<>();
        listEntity.stream().forEach(e -> {
            listDto.add(toDtoView(e));
        });
        return listDto;
    }

    public ListCertificadoDto toDtoView(GsyCertificados entity) {
        ListCertificadoDto dto = new ListCertificadoDto();
        dto.setActivo(entity.getActivo());
        dto.setCerId(entity.getCerId());
        dto.setDes(entity.getDes());
        dto.setFec(entity.getFec());
        dto.setTipo(entity.getTipo());
        return dto;
    }

    public GsyContadores toEntity(GsyContadoresDto dto) {
        GsyContadores entity = new GsyContadores();
        entity.setAutoIncrementa(dto.getAutoIncrementa());
        entity.setCantidadCopias(dto.getCantidadCopias());
        entity.setComportamientoEmisionComprobante(dto.getComportamientoEmisionComprobante());
        entity.setConId(dto.getConId());
        entity.setDes(dto.getDes());
        entity.setEstado(dto.getEstado());
        entity.setFormatioImpresion(dto.getFormatioImpresion());
        entity.setFormatioVistaPrevia(dto.getFormatioVistaPrevia());
        entity.setImpresoraDirecta(dto.getImpresoraDirecta());
        entity.setNroactual(dto.getNroactual());
        entity.setPermiteCambioFecha(dto.getPermiteCambioFecha());
        entity.setTipoContador(dto.getTipoContador());
        

        return entity;
    }
    
    

    public GsyContadoresDto toDto(GsyContadores entity) {
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
        dto.setTipoContador(entity.getTipoContador());
        dto.setImpresoraDirecta(entity.getImpresoraDirecta());

        for (GsyContadorestipos comprobantes : entity.getGsyContadorestiposCollection()) {
            dto.getComprobantes().add(comprobantes.getTcId().getTcId());
        }

        return dto;
    }

    public GsyTalonariosDto toDto(GsyTalonarios entity) {
        GsyTalonariosDto dto = new GsyTalonariosDto();
        //dto.setDepoId(depoId);
        return dto;
    }

}
