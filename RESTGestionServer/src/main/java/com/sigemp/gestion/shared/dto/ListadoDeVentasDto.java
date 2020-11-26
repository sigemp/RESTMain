/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigemp.gestion.shared.dto;


import com.sigemp.gestion.client.constantes.ConstantesComprobantes.Comprobante;
import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author Server
 */
public class ListadoDeVentasDto {

    private Long ctaId;
    private BigDecimal debitoCredito;
    private String nom;
    private Long nroIdent;
    private String condicionPago;
    private Date fec;
    private Comprobante comprobante;
    private String numero;
    private BigDecimal totNeto;
    private BigDecimal totIva;
    private BigDecimal totTributos;
    private BigDecimal total;
    private Integer venId;
    private Integer usrId;
    private Integer cuotas;
    private String nomVendedor;
    private String nick;

    /**
     * @return the ctaId
     */
    public Long getCtaId() {
        return ctaId;
    }

    public void setDebitoCredito(BigDecimal debitoCredito) {
        this.debitoCredito = debitoCredito;
    }

    /**
     * @return the nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * @return the nroIdent
     */
    public Long getNroIdent() {
        return nroIdent;
    }

    /**
     * @return the condicionPago
     */
    public String getCondicionPago() {
        return condicionPago;
    }

    /**
     * @return the fec
     */
    public Date getFec() {
        return fec;
    }

    /**
     * @return the comprobante
     */
    public Comprobante getComprobante() {
        return comprobante;
    }

    /**
     * @return the numero
     */
    public String getNumero() {
        return numero;
    }

    /**
     * @return the totNeto
     */
    public BigDecimal getTotNeto() {
        return totNeto;
    }

    /**
     * @return the totIva
     */
    public BigDecimal getTotIva() {
        return totIva;
    }

    /**
     * @return the totTributos
     */
    public BigDecimal getTotTributos() {
        return totTributos;
    }

    /**
     * @return the total
     */
    public BigDecimal getTotal() {
        return total;
    }

    /**
     * @return the usrId
     */
    public Integer getUsrId() {
        return usrId;
    }

    /**
     * @return the cuotas
     */
    public Integer getCuotas() {
        return cuotas;
    }

    /**
     * @return the nomVendedor
     */
    public String getNomVendedor() {
        return nomVendedor;
    }

    /**
     * @return the nick
     */
    public String getNick() {
        return nick;
    }

    /**
     * @param ctaId the ctaId to set
     */
    public void setCtaId(Long ctaId) {
        this.ctaId = ctaId;
    }

    /**
     * @param nom the nom to set
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * @param nroIdent the nroIdent to set
     */
    public void setNroIdent(Long nroIdent) {
        this.nroIdent = nroIdent;
    }

    /**
     * @param condicionPago the condicionPago to set
     */
    public void setCondicionPago(String condicionPago) {
        this.condicionPago = condicionPago;
    }

    /**
     * @param fec the fec to set
     */
    public void setFec(Date fec) {
        this.fec = fec;
    }

    /**
     * @param comprobante the comprobante to set
     */
    public void setComprobante(Comprobante comprobante) {
        this.comprobante = comprobante;
    }

    /**
     * @param numero the numero to set
     */
    public void setNumero(String numero) {
        this.numero = numero;
    }

    /**
     * @param totNeto the totNeto to set
     */
    public void setTotNeto(BigDecimal totNeto) {
        this.totNeto = totNeto;
    }

    /**
     * @param totIva the totIva to set
     */
    public void setTotIva(BigDecimal totIva) {
        this.totIva = totIva;
    }

    /**
     * @param totTributos the totTributos to set
     */
    public void setTotTributos(BigDecimal totTributos) {
        this.totTributos = totTributos;
    }

    /**
     * @param total the total to set
     */
    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    /**
     * @param usrId the usrId to set
     */
    public void setUsrId(Integer usrId) {
        this.usrId = usrId;
    }

    /**
     * @param cuotas the cuotas to set
     */
    public void setCuotas(Integer cuotas) {
        this.cuotas = cuotas;
    }

    /**
     * @param nomVendedor the nomVendedor to set
     */
    public void setNomVendedor(String nomVendedor) {
        this.nomVendedor = nomVendedor;
    }

    /**
     * @param nick the nick to set
     */
    public void setNick(String nick) {
        this.nick = nick;
    }

    /**
     * @return the venId
     */
    public Integer getVenId() {
        return venId;
    }

    /**
     * @param venId the venId to set
     */
    public void setVenId(Integer venId) {
        this.venId = venId;
    }

    /**
     * @return the debitoCredito
     */
    public BigDecimal getDebitoCredito() {
        return debitoCredito;
    }

}
