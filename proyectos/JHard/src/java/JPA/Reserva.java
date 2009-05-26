/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package JPA;

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
@Table(name = "reserva")
@NamedQueries({@NamedQuery(name = "Reserva.findAll", query = "SELECT r FROM Reserva r"), @NamedQuery(name = "Reserva.findByIdreserva", query = "SELECT r FROM Reserva r WHERE r.idreserva = :idreserva"), @NamedQuery(name = "Reserva.findByFechareserva", query = "SELECT r FROM Reserva r WHERE r.fechareserva = :fechareserva"), @NamedQuery(name = "Reserva.findByFechahorainicioprestamo", query = "SELECT r FROM Reserva r WHERE r.fechahorainicioprestamo = :fechahorainicioprestamo"), @NamedQuery(name = "Reserva.findByFechahorafinprestamo", query = "SELECT r FROM Reserva r WHERE r.fechahorafinprestamo = :fechahorafinprestamo")})
public class Reserva implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idreserva")
    private Integer idreserva;
    @Basic(optional = false)
    @Column(name = "fechareserva")
    @Temporal(TemporalType.DATE)
    private Date fechareserva;
    @Basic(optional = false)
    @Column(name = "fechahorainicioprestamo")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechahorainicioprestamo;
    @Basic(optional = false)
    @Column(name = "fechahorafinprestamo")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechahorafinprestamo;
    @Basic(optional = false)
    @Lob
    @Column(name = "descripcion")
    private String descripcion;
    @JoinColumn(name = "idequipoexistente", referencedColumnName = "idexistencia")
    @ManyToOne(optional = false)
    private Existencia idequipoexistente;
    @JoinColumn(name = "idestado", referencedColumnName = "idestadoreserva")
    @ManyToOne(optional = false)
    private Estadoreserva idestado;
    @JoinColumn(name = "idresponsable", referencedColumnName = "idresponsable")
    @ManyToOne(optional = false)
    private Responsable idresponsable;
    @JoinColumn(name = "idsolicitante", referencedColumnName = "idsolicitante")
    @ManyToOne(optional = false)
    private Solicitante idsolicitante;
    @JoinColumn(name = "idubicacion", referencedColumnName = "idubicacion")
    @ManyToOne(optional = false)
    private Ubicacion idubicacion;
    @JoinColumn(name = "idusuario", referencedColumnName = "idusuario")
    @ManyToOne(optional = false)
    private Usuario idusuario;

    public Reserva() {
    }

    public Reserva(Integer idreserva) {
        this.idreserva = idreserva;
    }

    public Reserva(Integer idreserva, Date fechareserva, Date fechahorainicioprestamo, Date fechahorafinprestamo, String descripcion) {
        this.idreserva = idreserva;
        this.fechareserva = fechareserva;
        this.fechahorainicioprestamo = fechahorainicioprestamo;
        this.fechahorafinprestamo = fechahorafinprestamo;
        this.descripcion = descripcion;
    }

    public Integer getIdreserva() {
        return idreserva;
    }

    public void setIdreserva(Integer idreserva) {
        this.idreserva = idreserva;
    }

    public Date getFechareserva() {
        return fechareserva;
    }

    public void setFechareserva(Date fechareserva) {
        this.fechareserva = fechareserva;
    }

    public Date getFechahorainicioprestamo() {
        return fechahorainicioprestamo;
    }

    public void setFechahorainicioprestamo(Date fechahorainicioprestamo) {
        this.fechahorainicioprestamo = fechahorainicioprestamo;
    }

    public Date getFechahorafinprestamo() {
        return fechahorafinprestamo;
    }

    public void setFechahorafinprestamo(Date fechahorafinprestamo) {
        this.fechahorafinprestamo = fechahorafinprestamo;
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

    public Estadoreserva getIdestado() {
        return idestado;
    }

    public void setIdestado(Estadoreserva idestado) {
        this.idestado = idestado;
    }

    public Responsable getIdresponsable() {
        return idresponsable;
    }

    public void setIdresponsable(Responsable idresponsable) {
        this.idresponsable = idresponsable;
    }

    public Solicitante getIdsolicitante() {
        return idsolicitante;
    }

    public void setIdsolicitante(Solicitante idsolicitante) {
        this.idsolicitante = idsolicitante;
    }

    public Ubicacion getIdubicacion() {
        return idubicacion;
    }

    public void setIdubicacion(Ubicacion idubicacion) {
        this.idubicacion = idubicacion;
    }

    public Usuario getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(Usuario idusuario) {
        this.idusuario = idusuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idreserva != null ? idreserva.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Reserva)) {
            return false;
        }
        Reserva other = (Reserva) object;
        if ((this.idreserva == null && other.idreserva != null) || (this.idreserva != null && !this.idreserva.equals(other.idreserva))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "JPA.Reserva[idreserva=" + idreserva + "]";
    }

}
