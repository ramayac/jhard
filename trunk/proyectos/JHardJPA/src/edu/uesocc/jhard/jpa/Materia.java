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
public class Materia implements Serializable {
	public Materia(int idmateria, String codigo, String nombre,
			Carrera idcarrera, Set<Curso> cursoCollection) {
		super();
		this.idmateria = idmateria;
		this.codigo = codigo;
		this.nombre = nombre;
		this.idcarrera = idcarrera;
		this.cursoCollection = cursoCollection;
	}

	/**
	 * @uml.property name="idmateria"
	 */
	@Id
	private int idmateria;

	/**
	 * @uml.property name="codigo"
	 */
	private String codigo;

	/**
	 * @uml.property name="nombre"
	 */
	private String nombre;

	/**
	 * @uml.property name="idcarrera"
	 * @uml.associationEnd
	 */
	@ManyToOne
	@JoinColumn(name = "idcarrera")
	private Carrera idcarrera;

	/**
	 * @uml.property name="cursoCollection"
	 */
	@OneToMany(mappedBy = "idmateria")
	private Set<Curso> cursoCollection;

	private static final long serialVersionUID = 1L;

	public Materia() {
		super();
	}

	/**
	 * @return
	 * @uml.property name="idmateria"
	 */
	public int getIdmateria() {
		return idmateria;
	}

	/**
	 * @param idmateria
	 * @uml.property name="idmateria"
	 */
	public void setIdmateria(int idmateria) {
		this.idmateria = idmateria;
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
	 * @uml.property name="idcarrera"
	 */
	public Carrera getIdcarrera() {
		return idcarrera;
	}

	/**
	 * @param idcarrera
	 * @uml.property name="idcarrera"
	 */
	public void setIdcarrera(Carrera idcarrera) {
		this.idcarrera = idcarrera;
	}

	/**
	 * @return
	 * @uml.property name="cursoCollection"
	 */
	public Set<Curso> getCursoCollection() {
		return cursoCollection;
	}

	/**
	 * @param cursoCollection
	 * @uml.property name="cursoCollection"
	 */
	public void setCursoCollection(Set<Curso> cursoCollection) {
		this.cursoCollection = cursoCollection;
	}

}
