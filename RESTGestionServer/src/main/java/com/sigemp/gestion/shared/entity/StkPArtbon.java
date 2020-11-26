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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author cristian
 */
@Entity
@Table(name = "stk_p_artbon")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "StkPArtbon.findAll", query = "SELECT s FROM StkPArtbon s")
    , @NamedQuery(name = "StkPArtbon.findByProartbonId", query = "SELECT s FROM StkPArtbon s WHERE s.proartbonId = :proartbonId")
    , @NamedQuery(name = "StkPArtbon.findByActivo", query = "SELECT s FROM StkPArtbon s WHERE s.activo = :activo")
    , @NamedQuery(name = "StkPArtbon.findByDes", query = "SELECT s FROM StkPArtbon s WHERE s.des = :des")
    , @NamedQuery(name = "StkPArtbon.findByTipnegocioAplicar", query = "SELECT s FROM StkPArtbon s WHERE s.tipnegocioAplicar = :tipnegocioAplicar")
    , @NamedQuery(name = "StkPArtbon.findByUnaBonificacion", query = "SELECT s FROM StkPArtbon s WHERE s.unaBonificacion = :unaBonificacion")
    , @NamedQuery(name = "StkPArtbon.findByUnidadesLimite", query = "SELECT s FROM StkPArtbon s WHERE s.unidadesLimite = :unidadesLimite")
    , @NamedQuery(name = "StkPArtbon.findByValidoParaTiponegocioConBonificacionEmbase", query = "SELECT s FROM StkPArtbon s WHERE s.validoParaTiponegocioConBonificacionEmbase = :validoParaTiponegocioConBonificacionEmbase")
    , @NamedQuery(name = "StkPArtbon.findByVigenciaDesde", query = "SELECT s FROM StkPArtbon s WHERE s.vigenciaDesde = :vigenciaDesde")
    , @NamedQuery(name = "StkPArtbon.findByVigenciaHasta", query = "SELECT s FROM StkPArtbon s WHERE s.vigenciaHasta = :vigenciaHasta")})
public class StkPArtbon implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "proartbon_id")
    private Integer proartbonId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "activo")
    private boolean activo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "des")
    private String des;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tipnegocio_aplicar")
    private boolean tipnegocioAplicar;
    @Basic(optional = false)
    @NotNull
    @Column(name = "una_bonificacion")
    private boolean unaBonificacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "unidades_limite")
    private int unidadesLimite;
    @Basic(optional = false)
    @NotNull
    @Column(name = "valido_para_tiponegocio_con_bonificacion_embase")
    private boolean validoParaTiponegocioConBonificacionEmbase;
    @Basic(optional = false)
    @NotNull
    @Column(name = "vigencia_desde")
    @Temporal(TemporalType.DATE)
    private Date vigenciaDesde;
    @Basic(optional = false)
    @NotNull
    @Column(name = "vigencia_hasta")
    @Temporal(TemporalType.DATE)
    private Date vigenciaHasta;
    @OneToMany(mappedBy = "proartbonId")
    private Collection<StkPArtbonb> stkPArtbonbCollection;
    @JoinColumn(name = "ptipnegocio_id", referencedColumnName = "ptipnegocio_id")
    @ManyToOne
    private PvtaTiponegocio ptipnegocioId;
    @OneToMany(mappedBy = "proartbonId")
    private Collection<StkPArtbonHistorial> stkPArtbonHistorialCollection;
    @OneToMany(mappedBy = "proartbonId")
    private Collection<StkPArtbona> stkPArtbonaCollection;

    public StkPArtbon() {
    }

    public StkPArtbon(Integer proartbonId) {
        this.proartbonId = proartbonId;
    }

    public StkPArtbon(Integer proartbonId, boolean activo, String des, boolean tipnegocioAplicar, boolean unaBonificacion, int unidadesLimite, boolean validoParaTiponegocioConBonificacionEmbase, Date vigenciaDesde, Date vigenciaHasta) {
        this.proartbonId = proartbonId;
        this.activo = activo;
        this.des = des;
        this.tipnegocioAplicar = tipnegocioAplicar;
        this.unaBonificacion = unaBonificacion;
        this.unidadesLimite = unidadesLimite;
        this.validoParaTiponegocioConBonificacionEmbase = validoParaTiponegocioConBonificacionEmbase;
        this.vigenciaDesde = vigenciaDesde;
        this.vigenciaHasta = vigenciaHasta;
    }

    public Integer getProartbonId() {
        return proartbonId;
    }

    public void setProartbonId(Integer proartbonId) {
        this.proartbonId = proartbonId;
    }

    public boolean getActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public boolean getTipnegocioAplicar() {
        return tipnegocioAplicar;
    }

    public void setTipnegocioAplicar(boolean tipnegocioAplicar) {
        this.tipnegocioAplicar = tipnegocioAplicar;
    }

    public boolean getUnaBonificacion() {
        return unaBonificacion;
    }

    public void setUnaBonificacion(boolean unaBonificacion) {
        this.unaBonificacion = unaBonificacion;
    }

    public int getUnidadesLimite() {
        return unidadesLimite;
    }

    public void setUnidadesLimite(int unidadesLimite) {
        this.unidadesLimite = unidadesLimite;
    }

    public boolean getValidoParaTiponegocioConBonificacionEmbase() {
        return validoParaTiponegocioConBonificacionEmbase;
    }

    public void setValidoParaTiponegocioConBonificacionEmbase(boolean validoParaTiponegocioConBonificacionEmbase) {
        this.validoParaTiponegocioConBonificacionEmbase = validoParaTiponegocioConBonificacionEmbase;
    }

    public Date getVigenciaDesde() {
        return vigenciaDesde;
    }

    public void setVigenciaDesde(Date vigenciaDesde) {
        this.vigenciaDesde = vigenciaDesde;
    }

    public Date getVigenciaHasta() {
        return vigenciaHasta;
    }

    public void setVigenciaHasta(Date vigenciaHasta) {
        this.vigenciaHasta = vigenciaHasta;
    }

    @XmlTransient
    public Collection<StkPArtbonb> getStkPArtbonbCollection() {
        return stkPArtbonbCollection;
    }

    public void setStkPArtbonbCollection(Collection<StkPArtbonb> stkPArtbonbCollection) {
        this.stkPArtbonbCollection = stkPArtbonbCollection;
    }

    public PvtaTiponegocio getPtipnegocioId() {
        return ptipnegocioId;
    }

    public void setPtipnegocioId(PvtaTiponegocio ptipnegocioId) {
        this.ptipnegocioId = ptipnegocioId;
    }

    @XmlTransient
    public Collection<StkPArtbonHistorial> getStkPArtbonHistorialCollection() {
        return stkPArtbonHistorialCollection;
    }

    public void setStkPArtbonHistorialCollection(Collection<StkPArtbonHistorial> stkPArtbonHistorialCollection) {
        this.stkPArtbonHistorialCollection = stkPArtbonHistorialCollection;
    }

    @XmlTransient
    public Collection<StkPArtbona> getStkPArtbonaCollection() {
        return stkPArtbonaCollection;
    }

    public void setStkPArtbonaCollection(Collection<StkPArtbona> stkPArtbonaCollection) {
        this.stkPArtbonaCollection = stkPArtbonaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (proartbonId != null ? proartbonId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StkPArtbon)) {
            return false;
        }
        StkPArtbon other = (StkPArtbon) object;
        if ((this.proartbonId == null && other.proartbonId != null) || (this.proartbonId != null && !this.proartbonId.equals(other.proartbonId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sigemp.server.entity.StkPArtbon[ proartbonId=" + proartbonId + " ]";
    }
    
}
