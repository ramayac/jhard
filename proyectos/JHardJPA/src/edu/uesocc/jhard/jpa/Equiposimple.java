package edu.uesocc.jhard.jpa;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * @author robertux
 */
@Entity
public class Equiposimple implements Serializable {
	public Equiposimple(int idequiposimple, String descripcion,
			String propietario, Estadoequipo idestado,
			Set<Solicitud> solicitudCollection,
			Set<Bitacoraestados> bitacoraestadosCollection) {
		super();
		this.idequiposimple = idequiposimple;
		this.descripcion = descripcion;
		this.propietario = propietario;
		this.idestado = idestado;
		this.solicitudCollection = solicitudCollection;
		this.bitacoraestadosCollection = bitacoraestadosCollection;
	}

	/**
	 * @uml.property name="idequiposimple"
	 */
	@Id
	private int idequiposimple;

	/**
	 * @uml.property name="descripcion"
	 */
	@Lob
	private String descripcion;

	/**
	 * @uml.property name="propietario"
	 */
	private String propietario;

	/**
	 * @uml.property name="idestado"
	 * @uml.associationEnd
	 */
	@ManyToOne
	@JoinColumn(name = "idestado")
	private Estadoequipo idestado;

	/**
	 * @uml.property name="solicitudCollection"
	 */
	@OneToMany(mappedBy = "idequipoexistente2")
	private Set<Solicitud> solicitudCollection;

	/**
	 * @uml.property name="bitacoraestadosCollection"
	 */
	@OneToMany(mappedBy = "idequipoexistente2")
	private Set<Bitacoraestados> bitacoraestadosCollection;

	private static final long serialVersionUID = 1L;

	public Equiposimple() {
		super();
	}

	/**
	 * @return
	 * @uml.property name="idequiposimple"
	 */
	public int getIdequiposimple() {
		return idequiposimple;
	}

	/**
	 * @param idequiposimple
	 * @uml.property name="idequiposimple"
	 */
	public void setIdequiposimple(int idequiposimple) {
		this.idequiposimple = idequiposimple;
	}

	/**
	 * @return
	 * @uml.property name="descripcion"
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * @param descripcion
	 * @uml.property name="descripcion"
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * @return
	 * @uml.property name="propietario"
	 */
	public String getPropietario() {
		return propietario;
	}

	/**
	 * @param propietario
	 * @uml.property name="propietario"
	 */
	public void setPropietario(String propietario) {
		this.propietario = propietario;
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
