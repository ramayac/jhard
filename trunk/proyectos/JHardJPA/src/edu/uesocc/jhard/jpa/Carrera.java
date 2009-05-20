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
public class Carrera implements Serializable {
	public Carrera(int idcarrera, String codigo, String nombre,
			Facultad idfacultad, Set<Materia> materiaCollection) {
		super();
		this.idcarrera = idcarrera;
		this.codigo = codigo;
		this.nombre = nombre;
		this.idfacultad = idfacultad;
		this.materiaCollection = materiaCollection;
	}

	/**
	 * @uml.property name="idcarrera"
	 */
	@Id
	private int idcarrera;

	/**
	 * @uml.property name="codigo"
	 */
	private String codigo;

	/**
	 * @uml.property name="nombre"
	 */
	private String nombre;

	/**
	 * @uml.property name="idfacultad"
	 * @uml.associationEnd
	 */
	@ManyToOne
	@JoinColumn(name = "idfacultad")
	private Facultad idfacultad;

	/**
	 * @uml.property name="materiaCollection"
	 */
	@OneToMany(mappedBy = "idcarrera")
	private Set<Materia> materiaCollection;

	private static final long serialVersionUID = 1L;

	public Carrera() {
		super();
	}

	/**
	 * @return
	 * @uml.property name="idcarrera"
	 */
	public int getIdcarrera() {
		return idcarrera;
	}

	/**
	 * @param idcarrera
	 * @uml.property name="idcarrera"
	 */
	public void setIdcarrera(int idcarrera) {
		this.idcarrera = idcarrera;
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
	 * @uml.property name="idfacultad"
	 */
	public Facultad getIdfacultad() {
		return idfacultad;
	}

	/**
	 * @param idfacultad
	 * @uml.property name="idfacultad"
	 */
	public void setIdfacultad(Facultad idfacultad) {
		this.idfacultad = idfacultad;
	}

	/**
	 * @return
	 * @uml.property name="materiaCollection"
	 */
	public Set<Materia> getMateriaCollection() {
		return materiaCollection;
	}

	/**
	 * @param materiaCollection
	 * @uml.property name="materiaCollection"
	 */
	public void setMateriaCollection(Set<Materia> materiaCollection) {
		this.materiaCollection = materiaCollection;
	}

}
