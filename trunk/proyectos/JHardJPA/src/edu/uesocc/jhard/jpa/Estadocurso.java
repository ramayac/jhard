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
public class Estadocurso implements Serializable {
	public Estadocurso(int idestadocurso, String nombre,
			Set<Curso> cursoCollection) {
		super();
		this.idestadocurso = idestadocurso;
		this.nombre = nombre;
		this.cursoCollection = cursoCollection;
	}

	/**
	 * @uml.property name="idestadocurso"
	 */
	@Id
	private int idestadocurso;

	/**
	 * @uml.property name="nombre"
	 */
	private String nombre;

	/**
	 * @uml.property name="cursoCollection"
	 */
	@OneToMany(mappedBy = "idestado")
	private Set<Curso> cursoCollection;

	private static final long serialVersionUID = 1L;

	public Estadocurso() {
		super();
	}

	/**
	 * @return
	 * @uml.property name="idestadocurso"
	 */
	public int getIdestadocurso() {
		return idestadocurso;
	}

	/**
	 * @param idestadocurso
	 * @uml.property name="idestadocurso"
	 */
	public void setIdestadocurso(int idestadocurso) {
		this.idestadocurso = idestadocurso;
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
