package edu.uesocc.jhard.jpa;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;

/**
 * @author robertux
 */
@Entity
public class Estadoequipo implements Serializable {
	public Estadoequipo(int idestado, String nombre, String descripcion,
			Set<Existencia> existenciaCollection,
			Set<Equiposimple> equiposimpleCollection,
			Set<Bitacoraestados> bitacoraestadosCollection) {
		super();
		this.idestado = idestado;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.existenciaCollection = existenciaCollection;
		this.equiposimpleCollection = equiposimpleCollection;
		this.bitacoraestadosCollection = bitacoraestadosCollection;
	}

	/**
	 * @uml.property name="idestado"
	 */
	@Id
	private int idestado;

	/**
	 * @uml.property name="nombre"
	 */
	private String nombre;

	/**
	 * @uml.property name="descripcion"
	 */
	@Lob
	private String descripcion;

	/**
	 * @uml.property name="existenciaCollection"
	 */
	@OneToMany(mappedBy = "idestado")
	private Set<Existencia> existenciaCollection;

	/**
	 * @uml.property name="equiposimpleCollection"
	 */
	@OneToMany(mappedBy = "idestado")
	private Set<Equiposimple> equiposimpleCollection;

	/**
	 * @uml.property name="bitacoraestadosCollection"
	 */
	@OneToMany(mappedBy = "idestado")
	private Set<Bitacoraestados> bitacoraestadosCollection;

	private static final long serialVersionUID = 1L;

	public Estadoequipo() {
		super();
	}

	/**
	 * @return
	 * @uml.property name="idestado"
	 */
	public int getIdestado() {
		return idestado;
	}

	/**
	 * @param idestado
	 * @uml.property name="idestado"
	 */
	public void setIdestado(int idestado) {
		this.idestado = idestado;
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
	 * @uml.property name="existenciaCollection"
	 */
	public Set<Existencia> getExistenciaCollection() {
		return existenciaCollection;
	}

	/**
	 * @param existenciaCollection
	 * @uml.property name="existenciaCollection"
	 */
	public void setExistenciaCollection(Set<Existencia> existenciaCollection) {
		this.existenciaCollection = existenciaCollection;
	}

	/**
	 * @return
	 * @uml.property name="equiposimpleCollection"
	 */
	public Set<Equiposimple> getEquiposimpleCollection() {
		return equiposimpleCollection;
	}

	/**
	 * @param equiposimpleCollection
	 * @uml.property name="equiposimpleCollection"
	 */
	public void setEquiposimpleCollection(
			Set<Equiposimple> equiposimpleCollection) {
		this.equiposimpleCollection = equiposimpleCollection;
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
