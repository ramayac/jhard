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
public class Usuario implements Serializable {
	public Usuario(int idusuario, String nombre, String clave, Rol idrol,
			Set<Administrador> administradorCollection,
			Set<Solicitud> solicitudCollection,
			Set<Estudiante> estudianteCollection,
			Set<Reserva> reservaCollection,
			Set<Instructor> instructorCollection,
			Set<Docente> docenteCollection,
			Set<Bitacoracambiosusuario> bitacoracambiosusuarioCollection) {
		super();
		this.idusuario = idusuario;
		this.nombre = nombre;
		this.clave = clave;
		this.idrol = idrol;
		this.administradorCollection = administradorCollection;
		this.solicitudCollection = solicitudCollection;
		this.estudianteCollection = estudianteCollection;
		this.reservaCollection = reservaCollection;
		this.instructorCollection = instructorCollection;
		this.docenteCollection = docenteCollection;
		this.bitacoracambiosusuarioCollection = bitacoracambiosusuarioCollection;
	}

	/**
	 * @uml.property name="idusuario"
	 */
	@Id
	private int idusuario;

	/**
	 * @uml.property name="nombre"
	 */
	private String nombre;

	/**
	 * @uml.property name="clave"
	 */
	private String clave;

	/**
	 * @uml.property name="idrol"
	 * @uml.associationEnd
	 */
	@ManyToOne
	@JoinColumn(name = "idrol")
	private Rol idrol;

	/**
	 * @uml.property name="administradorCollection"
	 */
	@OneToMany(mappedBy = "idusuario")
	private Set<Administrador> administradorCollection;

	/**
	 * @uml.property name="solicitudCollection"
	 */
	@OneToMany(mappedBy = "idusuario")
	private Set<Solicitud> solicitudCollection;

	/**
	 * @uml.property name="estudianteCollection"
	 */
	@OneToMany(mappedBy = "idusuario")
	private Set<Estudiante> estudianteCollection;

	/**
	 * @uml.property name="reservaCollection"
	 */
	@OneToMany(mappedBy = "idusuario")
	private Set<Reserva> reservaCollection;

	/**
	 * @uml.property name="instructorCollection"
	 */
	@OneToMany(mappedBy = "idusuario")
	private Set<Instructor> instructorCollection;

	/**
	 * @uml.property name="docenteCollection"
	 */
	@OneToMany(mappedBy = "idusuario")
	private Set<Docente> docenteCollection;

	/**
	 * @uml.property name="bitacoracambiosusuarioCollection"
	 */
	@OneToMany(mappedBy = "idusuario")
	private Set<Bitacoracambiosusuario> bitacoracambiosusuarioCollection;

	private static final long serialVersionUID = 1L;

	public Usuario() {
		super();
	}

	/**
	 * @return
	 * @uml.property name="idusuario"
	 */
	public int getIdusuario() {
		return idusuario;
	}

	/**
	 * @param idusuario
	 * @uml.property name="idusuario"
	 */
	public void setIdusuario(int idusuario) {
		this.idusuario = idusuario;
	}

	/**
	 * @return
	 * @uml.property name="nombre"
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre
	 * @uml.property name="nombre"
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return
	 * @uml.property name="clave"
	 */
	public String getClave() {
		return clave;
	}

	/**
	 * @param clave
	 * @uml.property name="clave"
	 */
	public void setClave(String clave) {
		this.clave = clave;
	}

	/**
	 * @return
	 * @uml.property name="idrol"
	 */
	public Rol getIdrol() {
		return idrol;
	}

	/**
	 * @param idrol
	 * @uml.property name="idrol"
	 */
	public void setIdrol(Rol idrol) {
		this.idrol = idrol;
	}

	/**
	 * @return
	 * @uml.property name="administradorCollection"
	 */
	public Set<Administrador> getAdministradorCollection() {
		return administradorCollection;
	}

	/**
	 * @param administradorCollection
	 * @uml.property name="administradorCollection"
	 */
	public void setAdministradorCollection(
			Set<Administrador> administradorCollection) {
		this.administradorCollection = administradorCollection;
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
	 * @uml.property name="estudianteCollection"
	 */
	public Set<Estudiante> getEstudianteCollection() {
		return estudianteCollection;
	}

	/**
	 * @param estudianteCollection
	 * @uml.property name="estudianteCollection"
	 */
	public void setEstudianteCollection(Set<Estudiante> estudianteCollection) {
		this.estudianteCollection = estudianteCollection;
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
	 * @uml.property name="instructorCollection"
	 */
	public Set<Instructor> getInstructorCollection() {
		return instructorCollection;
	}

	/**
	 * @param instructorCollection
	 * @uml.property name="instructorCollection"
	 */
	public void setInstructorCollection(Set<Instructor> instructorCollection) {
		this.instructorCollection = instructorCollection;
	}

	/**
	 * @return
	 * @uml.property name="docenteCollection"
	 */
	public Set<Docente> getDocenteCollection() {
		return docenteCollection;
	}

	/**
	 * @param docenteCollection
	 * @uml.property name="docenteCollection"
	 */
	public void setDocenteCollection(Set<Docente> docenteCollection) {
		this.docenteCollection = docenteCollection;
	}

	/**
	 * @return
	 * @uml.property name="bitacoracambiosusuarioCollection"
	 */
	public Set<Bitacoracambiosusuario> getBitacoracambiosusuarioCollection() {
		return bitacoracambiosusuarioCollection;
	}

	/**
	 * @param bitacoracambiosusuarioCollection
	 * @uml.property name="bitacoracambiosusuarioCollection"
	 */
	public void setBitacoracambiosusuarioCollection(
			Set<Bitacoracambiosusuario> bitacoracambiosusuarioCollection) {
		this.bitacoracambiosusuarioCollection = bitacoracambiosusuarioCollection;
	}

}
