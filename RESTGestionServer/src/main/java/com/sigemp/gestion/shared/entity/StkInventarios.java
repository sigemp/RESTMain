/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigemp.gestion.shared.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author cristian
 */
@Entity
@Table(name = "stk_inventarios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "StkInventarios.findAll", query = "SELECT s FROM StkInventarios s")
    , @NamedQuery(name = "StkInventarios.findByInvId", query = "SELECT s FROM StkInventarios s WHERE s.invId = :invId")
    , @NamedQuery(name = "StkInventarios.findByAjustaStkInicial", query = "SELECT s FROM StkInventarios s WHERE s.ajustaStkInicial = :ajustaStkInicial")
    , @NamedQuery(name = "StkInventarios.findByFec", query = "SELECT s FROM StkInventarios s WHERE s.fec = :fec")
    , @NamedQuery(name = "StkInventarios.findByFecpro", query = "SELECT s FROM StkInventarios s WHERE s.fecpro = :fecpro")
    , @NamedQuery(name = "StkInventarios.findByNum", query = "SELECT s FROM StkInventarios s WHERE s.num = :num")
    , @NamedQuery(name = "StkInventarios.findByPtovta", query = "SELECT s FROM StkInventarios s WHERE s.ptovta = :ptovta")
    , @NamedQuery(name = "StkInventarios.findByFeccontrol", query = "SELECT s FROM StkInventarios s WHERE s.feccontrol = :feccontrol")})
public class StkInventarios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "inv_id")
    private Integer invId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ajusta_stk_inicial")
    private boolean ajustaStkInicial;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fec")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fec;
    @Column(name = "fecpro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecpro;
    @Basic(optional = false)
    @NotNull
    @Column(name = "num")
    private int num;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ptovta")
    private int ptovta;
    @Column(name = "feccontrol")
    @Temporal(TemporalType.TIMESTAMP)
    private Date feccontrol;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "invId")
    private Collection<StkInventariosr> stkInventariosrCollection;
    @JoinColumn(name = "tc_id", referencedColumnName = "tc_id")
    @ManyToOne(optional = false)
    private GsyTiposcomprobantes tcId;
    @JoinColumn(name = "usr_id", referencedColumnName = "usr_id")
    @ManyToOne(optional = false)
    private GsyUser usrId;
    @JoinColumn(name = "depo_id", referencedColumnName = "depo_id")
    @ManyToOne(optional = false)
    private StkDepositos depoId;

    public StkInventarios() {
    }

    public StkInventarios(Integer invId) {
        this.invId = invId;
    }

    public StkInventarios(Integer invId, boolean ajustaStkInicial, Date fec, int num, int ptovta) {
        this.invId = invId;
        this.ajustaStkInicial = ajustaStkInicial;
        this.fec = fec;
        this.num = num;
        this.ptovta = ptovta;
    }

    public Integer getInvId() {
        return invId;
    }

    public void setInvId(Integer invId) {
        this.invId = invId;
    }

    public boolean getAjustaStkInicial() {
        return ajustaStkInicial;
    }

    public void setAjustaStkInicial(boolean ajustaStkInicial) {
        this.ajustaStkInicial = ajustaStkInicial;
    }

    public Date getFec() {
        return fec;
    }

    public void setFec(Date fec) {
        this.fec = fec;
    }

    public Date getFecpro() {
        return fecpro;
    }

    public void setFecpro(Date fecpro) {
        this.fecpro = fecpro;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getPtovta() {
        return ptovta;
    }

    public void setPtovta(int ptovta) {
        this.ptovta = ptovta;
    }

    public Date getFeccontrol() {
        return feccontrol;
    }

    public void setFeccontrol(Date feccontrol) {
        this.feccontrol = feccontrol;
    }

    @XmlTransient
    public Collection<StkInventariosr> getStkInventariosrCollection() {
        return stkInventariosrCollection;
    }

    public void setStkInventariosrCollection(Collection<StkInventariosr> stkInventariosrCollection) {
        this.stkInventariosrCollection = stkInventariosrCollection;
    }

    public GsyTiposcomprobantes getTcId() {
        return tcId;
    }

    public void setTcId(GsyTiposcomprobantes tcId) {
        this.tcId = tcId;
    }

    public GsyUser getUsrId() {
        return usrId;
    }

    public void setUsrId(GsyUser usrId) {
        this.usrId = usrId;
    }

    public StkDepositos getDepoId() {
        return depoId;
    }

    public void setDepoId(StkDepositos depoId) {
        this.depoId = depoId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (invId != null ? invId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StkInventarios)) {
            return false;
        }
        StkInventarios other = (StkInventarios) object;
        if ((this.invId == null && other.invId != null) || (this.invId != null && !this.invId.equals(other.invId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sigemp.server.entity.StkInventarios[ invId=" + invId + " ]";
    }
    
}
