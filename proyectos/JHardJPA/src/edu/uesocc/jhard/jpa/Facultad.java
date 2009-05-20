package edu.uesocc.jhard.jpa;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * @author robertux
 */
@Entity
public class Facultad implements Serializable {
	public Facultad(int idfacultad, String nombre,
			Set<Carrera> carreraCollection) {
		super();
		this.idfacultad = idfacultad;
		this.nombre = nombre;
		this.carreraCollection = carreraCollection;
	}

	/**
	 * @uml.property name="idfacultad"
	 */
	@Id
	private int idfacultad;

	/**
	 * @uml.property name="nombre"
	 */
	private String nombre;

	/**
	 * @uml.property name="carreraCollection"
	 */
	@OneToMany(mappedBy = "idfacultad")
	private Set<Carrera> carreraCollection;

	private static final long serialVersionUID = 1L;

	public Facultad() {
		super();
	}

	/**
	 * @return
	 * @uml.property name="idfacultad"
	 */
	public int getIdfacultad() {
		return idfacultad;
	}

	/**
	 * @param idfacultad
	 * @uml.property name="idfacultad"
	 */
	public void setIdfacultad(int idfacultad) {
		this.idfacultad = idfacultad;
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
	 * @uml.property name="carreraCollection"
	 */
	public Set<Carrera> getCarreraCollection() {
		return carreraCollection;
	}

	/**
	 * @param carreraCollection
	 * @uml.property name="carreraCollection"
	 */
	public void setCarreraCollection(Set<Carrera> carreraCollection) {
		this.carreraCollection = carreraCollection;
	}

}
