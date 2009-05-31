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
import javax.persistence.Lob;
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
@Table(name = "mantenimiento", catalog = "jhard", schema = "")
@NamedQueries({@NamedQuery(name = "Mantenimiento.findAll", query = "SELECT m FROM Mantenimiento m"), @NamedQuery(name = "Mantenimiento.findByIdmantenimiento", query = "SELECT m FROM Mantenimiento m WHERE m.idmantenimiento = :idmantenimiento"), @NamedQuery(name = "Mantenimiento.findByFecha", query = "SELECT m FROM Mantenimiento m WHERE m.fecha = :fecha")})
public class Mantenimiento implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idmantenimiento", nullable = false)
    private Integer idmantenimiento;
    @Basic(optional = false)
    @Column(name = "fecha", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Basic(optional = false)
    @Lob
    @Column(name = "descripcion", nullable = false, length = 65535)
    private String descripcion;
    @JoinColumn(name = "idequipoexistente", referencedColumnName = "idexistencia", nullable = false)
    @ManyToOne(optional = false)
    private Existencia idequipoexistente;
    @JoinColumn(name = "idsolicitud", referencedColumnName = "idsolicitud")
    @ManyToOne
    private Solicitud idsolicitud;
    @JoinColumn(name = "idtecnico", referencedColumnName = "idtecnico", nullable = false)
    @ManyToOne(optional = false)
    private Tecnico idtecnico;

    public Mantenimiento() {
    }

    public Mantenimiento(Integer idmantenimiento) {
        this.idmantenimiento = idmantenimiento;
    }

    public Mantenimiento(Integer idmantenimiento, Date fecha, String descripcion) {
        this.idmantenimiento = idmantenimiento;
        this.fecha = fecha;
        this.descripcion = descripcion;
    }

    public Integer getIdmantenimiento() {
        return idmantenimiento;
    }

    public void setIdmantenimiento(Integer idmantenimiento) {
        this.idmantenimiento = idmantenimiento;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Existencia getIdequipoexistente() {
        return idequipoexistente;
    }

    public void setIdequipoexistente(Existencia idequipoexistente) {
        this.idequipoexistente = idequipoexistente;
    }

    public Solicitud getIdsolicitud() {
        return idsolicitud;
    }

    public void setIdsolicitud(Solicitud idsolicitud) {
        this.idsolicitud = idsolicitud;
    }

    public Tecnico getIdtecnico() {
        return idtecnico;
    }

    public void setIdtecnico(Tecnico idtecnico) {
        this.idtecnico = idtecnico;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idmantenimiento != null ? idmantenimiento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Mantenimiento)) {
            return false;
        }
        Mantenimiento other = (Mantenimiento) object;
        if ((this.idmantenimiento == null && other.idmantenimiento != null) || (this.idmantenimiento != null && !this.idmantenimiento.equals(other.idmantenimiento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.ues.jhard.jpa.Mantenimiento[idmantenimiento=" + idmantenimiento + "]";
    }

}
