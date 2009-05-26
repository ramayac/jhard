/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package JPA;

import java.io.Serializable;
import java.util.List;
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
 * @author Hugol
 */
@Entity
@Table(name = "existencia")
@NamedQueries({@NamedQuery(name = "Existencia.findAll", query = "SELECT e FROM Existencia e"), @NamedQuery(name = "Existencia.findByIdexistencia", query = "SELECT e FROM Existencia e WHERE e.idexistencia = :idexistencia"), @NamedQuery(name = "Existencia.findByCodigo", query = "SELECT e FROM Existencia e WHERE e.codigo = :codigo")})
public class Existencia implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idexistencia")
    private Integer idexistencia;
    @Basic(optional = false)
    @Column(name = "codigo")
    private String codigo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idequipoexistente")
    private List<Mantenimiento> mantenimientoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idequipoexistente")
    private List<Instalacion> instalacionCollection;
    @JoinColumn(name = "idadquisicion", referencedColumnName = "idadquisicion")
    @ManyToOne
    private Adquisicion idadquisicion;
    @JoinColumn(name = "idestado", referencedColumnName = "idestado")
    @ManyToOne(optional = false)
    private Estadoequipo idestado;
    @JoinColumn(name = "idhardware", referencedColumnName = "idequipo")
    @ManyToOne(optional = false)
    private Equipo idhardware;
    @JoinColumn(name = "idubicacion", referencedColumnName = "idubicacion")
    @ManyToOne(optional = false)
    private Ubicacion idubicacion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idequipoexistente")
    private List<Solicitud> solicitudCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idequipoexistente")
    private List<Bitacoraestados> bitacoraestadosCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idequipoexistente")
    private List<Asistencia> asistenciaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idequipoexistente")
    private List<Reserva> reservaCollection;

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

    public List<Mantenimiento> getMantenimientoCollection() {
        return mantenimientoCollection;
    }

    public void setMantenimientoCollection(List<Mantenimiento> mantenimientoCollection) {
        this.mantenimientoCollection = mantenimientoCollection;
    }

    public List<Instalacion> getInstalacionCollection() {
        return instalacionCollection;
    }

    public void setInstalacionCollection(List<Instalacion> instalacionCollection) {
        this.instalacionCollection = instalacionCollection;
    }

    public Adquisicion getIdadquisicion() {
        return idadquisicion;
    }

    public void setIdadquisicion(Adquisicion idadquisicion) {
        this.idadquisicion = idadquisicion;
    }

    public Estadoequipo getIdestado() {
        return idestado;
    }

    public void setIdestado(Estadoequipo idestado) {
        this.idestado = idestado;
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

    public List<Solicitud> getSolicitudCollection() {
        return solicitudCollection;
    }

    public void setSolicitudCollection(List<Solicitud> solicitudCollection) {
        this.solicitudCollection = solicitudCollection;
    }

    public List<Bitacoraestados> getBitacoraestadosCollection() {
        return bitacoraestadosCollection;
    }

    public void setBitacoraestadosCollection(List<Bitacoraestados> bitacoraestadosCollection) {
        this.bitacoraestadosCollection = bitacoraestadosCollection;
    }

    public List<Asistencia> getAsistenciaCollection() {
        return asistenciaCollection;
    }

    public void setAsistenciaCollection(List<Asistencia> asistenciaCollection) {
        this.asistenciaCollection = asistenciaCollection;
    }

    public List<Reserva> getReservaCollection() {
        return reservaCollection;
    }

    public void setReservaCollection(List<Reserva> reservaCollection) {
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
        return "JPA.Existencia[idexistencia=" + idexistencia + "]";
    }

}
