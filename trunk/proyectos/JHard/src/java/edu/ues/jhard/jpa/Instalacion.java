/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.ues.jhard.jpa;

import java.io.Serializable;
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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Hugol
 */
@Entity
@Table(name = "instalacion", catalog = "jhard", schema = "")
@NamedQueries({@NamedQuery(name = "Instalacion.findAll", query = "SELECT i FROM Instalacion i"), @NamedQuery(name = "Instalacion.findByIdinstalacion", query = "SELECT i FROM Instalacion i WHERE i.idinstalacion = :idinstalacion"), @NamedQuery(name = "Instalacion.findByFechainstalacion", query = "SELECT i FROM Instalacion i WHERE i.fechainstalacion = :fechainstalacion")})
public class Instalacion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idinstalacion", nullable = false)
    private Integer idinstalacion;
    @Basic(optional = false)
    @Column(name = "fechainstalacion", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechainstalacion;
    @JoinColumn(name = "idequipoexistente", referencedColumnName = "idexistencia", nullable = false)
    @ManyToOne(optional = false)
    private Existencia idequipoexistente;
    @JoinColumn(name = "idsoftware", referencedColumnName = "idsoftware", nullable = false)
    @ManyToOne(optional = false)
    private Software idsoftware;

    public Instalacion() {
    }

    public Instalacion(Integer idinstalacion) {
        this.idinstalacion = idinstalacion;
    }

    public Instalacion(Integer idinstalacion, Date fechainstalacion) {
        this.idinstalacion = idinstalacion;
        this.fechainstalacion = fechainstalacion;
    }

    public Integer getIdinstalacion() {
        return idinstalacion;
    }

    public void setIdinstalacion(Integer idinstalacion) {
        this.idinstalacion = idinstalacion;
    }

    public Date getFechainstalacion() {
        return fechainstalacion;
    }

    public void setFechainstalacion(Date fechainstalacion) {
        this.fechainstalacion = fechainstalacion;
    }

    public Existencia getIdequipoexistente() {
        return idequipoexistente;
    }

    public void setIdequipoexistente(Existencia idequipoexistente) {
        this.idequipoexistente = idequipoexistente;
    }

    public Software getIdsoftware() {
        return idsoftware;
    }

    public void setIdsoftware(Software idsoftware) {
        this.idsoftware = idsoftware;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idinstalacion != null ? idinstalacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Instalacion)) {
            return false;
        }
        Instalacion other = (Instalacion) object;
        if ((this.idinstalacion == null && other.idinstalacion != null) || (this.idinstalacion != null && !this.idinstalacion.equals(other.idinstalacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.ues.jhard.jpa.Instalacion[idinstalacion=" + idinstalacion + "]";
    }

}
