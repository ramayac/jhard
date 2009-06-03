/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.ues.jhard.jpa;

import java.io.Serializable;
import java.util.Collection;
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

/**
 *
 * @author robertux
 */
@Entity
@Table(name = "existencia", catalog = "jhard", schema = "")
@NamedQueries({@NamedQuery(name = "Existencia.findAll", query = "SELECT e FROM Existencia e"), @NamedQuery(name = "Existencia.findByIdexistencia", query = "SELECT e FROM Existencia e WHERE e.idexistencia = :idexistencia"), @NamedQuery(name = "Existencia.findByCodigo", query = "SELECT e FROM Existencia e WHERE e.codigo = :codigo")})
public class Existencia implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idexistencia", nullable = false)
    private Integer idexistencia;
    @Basic(optional = false)
    @Column(name = "codigo", nullable = false, length = 45)
    private String codigo;
    @OneToMany(mappedBy = "idequipoexistente")
    private Collection<Mantenimiento> mantenimientoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idequipoexistente")
    private Collection<Instalacion> instalacionCollection;
    @JoinColumn(name = "idhardware", referencedColumnName = "idequipo", nullable = false)
    @ManyToOne(optional = false)
    private Equipo idhardware;
    @JoinColumn(name = "idubicacion", referencedColumnName = "idubicacion", nullable = false)
    @ManyToOne(optional = false)
    private Ubicacion idubicacion;
    @JoinColumn(name = "idestado", referencedColumnName = "idestado", nullable = false)
    @ManyToOne(optional = false)
    private Estadoequipo idestado;
    @JoinColumn(name = "idadquisicion", referencedColumnName = "idadquisicion")
    @ManyToOne
    private Adquisicion idadquisicion;
    @OneToMany(mappedBy = "idequipoexistente")
    private Collection<Solicitud> solicitudCollection;
    @OneToMany(mappedBy = "idequipoexistente")
    private Collection<Bitacoraestados> bitacoraestadosCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idequipoexistente")
    private Collection<Asistencia> asistenciaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idequipoexistente")
    private Collection<Reserva> reservaCollection;

    public Existencia() {
    }

    public Existencia(Integer idexistencia) {
        this.idexistencia = idexistencia;
    }

    public Existencia(Integer idexistencia, String codigo) {
        this.idexistencia = idexistencia;
        this.codigo = codigo;
    }

    public Integer getIdexistencia() {
        return idexistencia;
    }

    public void setIdexistencia(Integer idexistencia) {
        this.idexistencia = idexistencia;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Collection<Mantenimiento> getMantenimientoCollection() {
        return mantenimientoCollection;
    }

    public void setMantenimientoCollection(Collection<Mantenimiento> mantenimientoCollection) {
        this.mantenimientoCollection = mantenimientoCollection;
    }

    public Collection<Instalacion> getInstalacionCollection() {
        return instalacionCollection;
    }

    public void setInstalacionCollection(Collection<Instalacion> instalacionCollection) {
        this.instalacionCollection = instalacionCollection;
    }

    public Equipo getIdhardware() {
        return idhardware;
    }

    public void setIdhardware(Equipo idhardware) {
        this.idhardware = idhardware;
    }

    public Ubicacion getIdubicacion() {
        return idubicacion;
    }

    public void setIdubicacion(Ubicacion idubicacion) {
        this.idubicacion = idubicacion;
    }

    public Estadoequipo getIdestado() {
        return idestado;
    }

    public void setIdestado(Estadoequipo idestado) {
        this.idestado = idestado;
    }

    public Adquisicion getIdadquisicion() {
        return idadquisicion;
    }

    public void setIdadquisicion(Adquisicion idadquisicion) {
        this.idadquisicion = idadquisicion;
    }

    public Collection<Solicitud> getSolicitudCollection() {
        return solicitudCollection;
    }

    public void setSolicitudCollection(Collection<Solicitud> solicitudCollection) {
        this.solicitudCollection = solicitudCollection;
    }

    public Collection<Bitacoraestados> getBitacoraestadosCollection() {
        return bitacoraestadosCollection;
    }

    public void setBitacoraestadosCollection(Collection<Bitacoraestados> bitacoraestadosCollection) {
        this.bitacoraestadosCollection = bitacoraestadosCollection;
    }

    public Collection<Asistencia> getAsistenciaCollection() {
        return asistenciaCollection;
    }

    public void setAsistenciaCollection(Collection<Asistencia> asistenciaCollection) {
        this.asistenciaCollection = asistenciaCollection;
    }

    public Collection<Reserva> getReservaCollection() {
        return reservaCollection;
    }

    public void setReservaCollection(Collection<Reserva> reservaCollection) {
        this.reservaCollection = reservaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idexistencia != null ? idexistencia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Existencia)) {
            return false;
        }
        Existencia other = (Existencia) object;
        if ((this.idexistencia == null && other.idexistencia != null) || (this.idexistencia != null && !this.idexistencia.equals(other.idexistencia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.ues.jhard.jpa.Existencia[idexistencia=" + idexistencia + "]";
    }

}
