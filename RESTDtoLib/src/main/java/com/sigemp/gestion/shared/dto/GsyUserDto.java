package com.sigemp.gestion.shared.dto;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import com.sigemp.gestion.shared.dto.StkDepositosDto;
import java.io.Serializable;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author cristian
 */
@XmlRootElement
public class GsyUserDto implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer usrId;
    private String clave;
    private boolean estado;
    private String nick;
    private String nom;
    private Integer talId;
    private StkDepositosDto depoId;

    public GsyUserDto() {
    }

    public GsyUserDto(Integer usrId) {
        this.usrId = usrId;
    }

    public GsyUserDto(Integer usrId, boolean estado, String nick, String nom) {
        this.usrId = usrId;
        this.estado = estado;
        this.nick = nick;
        this.nom = nom;
    }

    public Integer getUsrId() {
        return usrId;
    }

    public void setUsrId(Integer usrId) {
        this.usrId = usrId;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Integer getTalId() {
        return talId;
    }

    public void setTalId(Integer talId) {
        this.talId = talId;
    }

 

    public StkDepositosDto getDepoId() {
        return depoId;
    }

    public void setDepoId(StkDepositosDto depoId) {
        this.depoId = depoId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (usrId != null ? usrId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GsyUserDto)) {
            return false;
        }
        GsyUserDto other = (GsyUserDto) object;
        if ((this.usrId == null && other.usrId != null) || (this.usrId != null && !this.usrId.equals(other.usrId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sigemp.server.entity.GsyUser[ usrId=" + usrId + " ]";
    }
    
}
