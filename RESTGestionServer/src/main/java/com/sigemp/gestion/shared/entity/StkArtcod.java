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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "stk_artcod")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "StkArtcod.findAll", query = "SELECT s FROM StkArtcod s")
    , @NamedQuery(name = "StkArtcod.findByArtcodId", query = "SELECT s FROM StkArtcod s WHERE s.artcodId = :artcodId")
    , @NamedQuery(name = "StkArtcod.findByCodigo", query = "SELECT s FROM StkArtcod s WHERE s.codigo = :codigo")})
public class StkArtcod implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "artcod_id")
    private Integer artcodId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "codigo")
    private String codigo;
    @JoinColumn(name = "art_id", referencedColumnName = "art_id")
    @ManyToOne(optional = false)
    private StkArt artId;

    public StkArtcod() {
    }

    public StkArtcod(Integer artcodId) {
        this.artcodId = artcodId;
    }

    public StkArtcod(Integer artcodId, String codigo) {
        this.artcodId = artcodId;
        this.codigo = codigo;
    }

    public Integer getArtcodId() {
        return artcodId;
    }

    public void setArtcodId(Integer artcodId) {
        this.artcodId = artcodId;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public StkArt getArtId() {
        return artId;
    }

    public void setArtId(StkArt artId) {
        this.artId = artId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (artcodId != null ? artcodId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StkArtcod)) {
            return false;
        }
        StkArtcod other = (StkArtcod) object;
        if ((this.artcodId == null && other.artcodId != null) || (this.artcodId != null && !this.artcodId.equals(other.artcodId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sigemp.server.entity.StkArtcod[ artcodId=" + artcodId + " ]";
    }
    
}
