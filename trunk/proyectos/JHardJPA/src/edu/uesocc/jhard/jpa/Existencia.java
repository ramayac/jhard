package edu.uesocc.jhard.jpa;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * @author robertux
 */
@Entity
public class Existencia implements Serializable {
	public Existencia(int idexistencia, String codigo, Equipo idhardware,
			Ubicacion idubicacion, Estadoequipo idestado,
			Adquisicion idadquisicion,
			Set<Mantenimiento> mantenimientoCollection,
			Set<Solicitud> solicitudCollection,
			Set<Asistencia> asistenciaCollection,
			Set<Reserva> reservaCollection,
			Set<Instalacion> instalacionCollection,
			Set<Bitacoraestados> bitacoraestadosCollection) {
		super();
		this.idexistencia = idexistencia;
		this.codigo = codigo;
		this.idhardware = idhardware;
		this.idubicacion = idubicacion;
		this.idestado = idestado;
		this.idadquisicion = idadquisicion;
		this.mantenimientoCollection = mantenimientoCollection;
		this.solicitudCollection = solicitudCollection;
		this.asistenciaCollection = asistenciaCollection;
		this.reservaCollection = reservaCollection;
		this.instalacionCollection = instalacionCollection;
		this.bitacoraestadosCollection = bitacoraestadosCollection;
	}

	/**
	 * @uml.property name="idexistencia"
	 */
	@Id
	private int idexistencia;

	/**
	 * @uml.property name="codigo"
	 */
	private String codigo;

	/**
	 * @uml.property name="idhardware"
	 * @uml.associationEnd
	 */
	@ManyToOne
	@JoinColumn(name = "idhardware")
	private Equipo idhardware;

	/**
	 * @uml.property name="idubicacion"
	 * @uml.associationEnd
	 */
	@ManyToOne
	@JoinColumn(name = "idubicacion")
	private Ubicacion idubicacion;

	/**
	 * @uml.property name="idestado"
	 * @uml.associationEnd
	 */
	@ManyToOne
	@JoinColumn(name = "idestado")
	private Estadoequipo idestado;

	/**
	 * @uml.property name="idadquisicion"
	 * @uml.associationEnd
	 */
	@ManyToOne
	@JoinColumn(name = "idadquisicion")
	private Adquisicion idadquisicion;

	/**
	 * @uml.property name="mantenimientoCollection"
	 */
	@OneToMany(mappedBy = "idequipoexistente")
	private Set<Mantenimiento> mantenimientoCollection;

	/**
	 * @uml.property name="solicitudCollection"
	 */
	@OneToMany(mappedBy = "idequipoexistente")
	private Set<Solicitud> solicitudCollection;

	/**
	 * @uml.property name="asistenciaCollection"
	 */
	@OneToMany(mappedBy = "idequipoexistente")
	private Set<Asistencia> asistenciaCollection;

	/**
	 * @uml.property name="reservaCollection"
	 */
	@OneToMany(mappedBy = "idequipoexistente")
	private Set<Reserva> reservaCollection;

	/**
	 * @uml.property name="instalacionCollection"
	 */
	@OneToMany(mappedBy = "idequipoexistente")
	private Set<Instalacion> instalacionCollection;

	/**
	 * @uml.property name="bitacoraestadosCollection"
	 */
	@OneToMany(mappedBy = "idequipoexistente")
	private Set<Bitacoraestados> bitacoraestadosCollection;

	private static final long serialVersionUID = 1L;

	public Existencia() {
		super();
	}

	/**
	 * @return
	 * @uml.property name="idexistencia"
	 */
	public int getIdexistencia() {
		return idexistencia;
	}

	/**
	 * @param idexistencia
	 * @uml.property name="idexistencia"
	 */
	public void setIdexistencia(int idexistencia) {
		this.idexistencia = idexistencia;
	}

	/**
	 * @return
	 * @uml.property name="codigo"
	 */
	public String getCodigo() {
		return codigo;
	}

	/**
	 * @param codigo
	 * @uml.property name="codigo"
	 */
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	/**
	 * @return
	 * @uml.property name="idhardware"
	 */
	public Equipo getIdhardware() {
		return idhardware;
	}

	/**
	 * @param idhardware
	 * @uml.property name="idhardware"
	 */
	public void setIdhardware(Equipo idhardware) {
		this.idhardware = idhardware;
	}

	/**
	 * @return
	 * @uml.property name="idubicacion"
	 */
	public Ubicacion getIdubicacion() {
		return idubicacion;
	}

	/**
	 * @param idubicacion
	 * @uml.property name="idubicacion"
	 */
	public void setIdubicacion(Ubicacion idubicacion) {
		this.idubicacion = idubicacion;
	}

	/**
	 * @return
	 * @uml.property name="idestado"
	 */
	public Estadoequipo getIdestado() {
		return idestado;
	}

	/**
	 * @param idestado
	 * @uml.property name="idestado"
	 */
	public void setIdestado(Estadoequipo idestado) {
		this.idestado = idestado;
	}

	/**
	 * @return
	 * @uml.property name="idadquisicion"
	 */
	public Adquisicion getIdadquisicion() {
		return idadquisicion;
	}

	/**
	 * @param idadquisicion
	 * @uml.property name="idadquisicion"
	 */
	public void setIdadquisicion(Adquisicion idadquisicion) {
		this.idadquisicion = idadquisicion;
	}

	/**
	 * @return
	 * @uml.property name="mantenimientoCollection"
	 */
	public Set<Mantenimiento> getMantenimientoCollection() {
		return mantenimientoCollection;
	}

	/**
	 * @param mantenimientoCollection
	 * @uml.property name="mantenimientoCollection"
	 */
	public void setMantenimientoCollection(
			Set<Mantenimiento> mantenimientoCollection) {
		this.mantenimientoCollection = mantenimientoCollection;
	}

	/**
	 * @return
	 * @uml.property name="solicitudCollection"
	 */
	public Set<Solicitud> getSolicitudCollection() {
		return solicitudCollection;
	}

	/**
	 * @param solicitudCollection
	 * @uml.property name="solicitudCollection"
	 */
	public void setSolicitudCollection(Set<Solicitud> solicitudCollection) {
		this.solicitudCollection = solicitudCollection;
	}

	/**
	 * @return
	 * @uml.property name="asistenciaCollection"
	 */
	public Set<Asistencia> getAsistenciaCollection() {
		return asistenciaCollection;
	}

	/**
	 * @param asistenciaCollection
	 * @uml.property name="asistenciaCollection"
	 */
	public void setAsistenciaCollection(Set<Asistencia> asistenciaCollection) {
		this.asistenciaCollection = asistenciaCollection;
	}

	/**
	 * @return
	 * @uml.property name="reservaCollection"
	 */
	public Set<Reserva> getReservaCollection() {
		return reservaCollection;
	}

	/**
	 * @param reservaCollection
	 * @uml.property name="reservaCollection"
	 */
	public void setReservaCollection(Set<Reserva> reservaCollection) {
		this.reservaCollection = reservaCollection;
	}

	/**
	 * @return
	 * @uml.property name="instalacionCollection"
	 */
	public Set<Instalacion> getInstalacionCollection() {
		return instalacionCollection;
	}

	/**
	 * @param instalacionCollection
	 * @uml.property name="instalacionCollection"
	 */
	public void setInstalacionCollection(Set<Instalacion> instalacionCollection) {
		this.instalacionCollection = instalacionCollection;
	}

	/**
	 * @return
	 * @uml.property name="bitacoraestadosCollection"
	 */
	public Set<Bitacoraestados> getBitacoraestadosCollection() {
		return bitacoraestadosCollection;
	}

	/**
	 * @param bitacoraestadosCollection
	 * @uml.property name="bitacoraestadosCollection"
	 */
	public void setBitacoraestadosCollection(
			Set<Bitacoraestados> bitacoraestadosCollection) {
		this.bitacoraestadosCollection = bitacoraestadosCollection;
	}

}
