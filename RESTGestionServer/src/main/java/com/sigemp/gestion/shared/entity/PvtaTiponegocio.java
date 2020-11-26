/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigemp.gestion.shared.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author cristian
 */
@Entity
@Table(name = "pvta_tiponegocio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PvtaTiponegocio.findAll", query = "SELECT p FROM PvtaTiponegocio p")
    , @NamedQuery(name = "PvtaTiponegocio.findByPtipnegocioId", query = "SELECT p FROM PvtaTiponegocio p WHERE p.ptipnegocioId = :ptipnegocioId")
    , @NamedQuery(name = "PvtaTiponegocio.findByBotellasincargo", query = "SELECT p FROM PvtaTiponegocio p WHERE p.botellasincargo = :botellasincargo")
    , @NamedQuery(name = "PvtaTiponegocio.findByDes", query = "SELECT p FROM PvtaTiponegocio p WHERE p.des = :des")
    , @NamedQuery(name = "PvtaTiponegocio.findByDesctoxmarca", query = "SELECT p FROM PvtaTiponegocio p WHERE p.desctoxmarca = :desctoxmarca")})
public class PvtaTiponegocio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ptipnegocio_id")
    private Integer ptipnegocioId;
    @Size(max = 2)
    @Column(name = "botellasincargo")
    private String botellasincargo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "des")
    private String des;
    @Size(max = 2)
    @Column(name = "desctoxmarca")
    private String desctoxmarca;

    public PvtaTiponegocio() {
    }

    public PvtaTiponegocio(Integer ptipnegocioId) {
        this.ptipnegocioId = ptipnegocioId;
    }

    public PvtaTiponegocio(Integer ptipnegocioId, String des) {
        this.ptipnegocioId = ptipnegocioId;
        this.des = des;
    }

    public Integer getPtipnegocioId() {
        return ptipnegocioId;
    }

    public void setPtipnegocioId(Integer ptipnegocioId) {
        this.ptipnegocioId = ptipnegocioId;
    }

    public String getBotellasincargo() {
        return botellasincargo;
    }

    public void setBotellasincargo(String botellasincargo) {
        this.botellasincargo = botellasincargo;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public String getDesctoxmarca() {
        return desctoxmarca;
    }

    public void setDesctoxmarca(String desctoxmarca) {
        this.desctoxmarca = desctoxmarca;
    }


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ptipnegocioId != null ? ptipnegocioId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PvtaTiponegocio)) {
            return false;
        }
        PvtaTiponegocio other = (PvtaTiponegocio) object;
        if ((this.ptipnegocioId == null && other.ptipnegocioId != null) || (this.ptipnegocioId != null && !this.ptipnegocioId.equals(other.ptipnegocioId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sigemp.server.entity.PvtaTiponegocio[ ptipnegocioId=" + ptipnegocioId + " ]";
    }
    
}
