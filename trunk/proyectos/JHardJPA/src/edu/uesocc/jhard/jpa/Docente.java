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
public class Docente implements Serializable {
	public Docente(int iddocente, String apellidos, String nombres,
			int visible, Usuario idusuario, Set<Clase> claseCollection,
			Set<Curso> cursoCollection) {
		super();
		this.iddocente = iddocente;
		this.apellidos = apellidos;
		this.nombres = nombres;
		this.visible = visible;
		this.idusuario = idusuario;
		this.claseCollection = claseCollection;
		this.cursoCollection = cursoCollection;
	}

	/**
	 * @uml.property name="iddocente"
	 */
	@Id
	private int iddocente;

	/**
	 * @uml.property name="apellidos"
	 */
	private String apellidos;

	/**
	 * @uml.property name="nombres"
	 */
	private String nombres;

	/**
	 * @uml.property name="visible"
	 */
	private int visible;

	/**
	 * @uml.property name="idusuario"
	 * @uml.associationEnd
	 */
	@ManyToOne
	@JoinColumn(name = "idusuario")
	private Usuario idusuario;

	/**
	 * @uml.property name="claseCollection"
	 */
	@OneToMany(mappedBy = "iddocente")
	private Set<Clase> claseCollection;

	/**
	 * @uml.property name="cursoCollection"
	 */
	@OneToMany(mappedBy = "iddocente")
	private Set<Curso> cursoCollection;

	private static final long serialVersionUID = 1L;

	public Docente() {
		super();
	}

	/**
	 * @return
	 * @uml.property name="iddocente"
	 */
	public int getIddocente() {
		return iddocente;
	}

	/**
	 * @param iddocente
	 * @uml.property name="iddocente"
	 */
	public void setIddocente(int iddocente) {
		this.iddocente = iddocente;
	}

	/**
	 * @return
	 * @uml.property name="apellidos"
	 */
	public String getApellidos() {
		return apellidos;
	}

	/**
	 * @param apellidos
	 * @uml.property name="apellidos"
	 */
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	/**
	 * @return
	 * @uml.property name="nombres"
	 */
	public String getNombres() {
		return nombres;
	}

	/**
	 * @param nombres
	 * @uml.property name="nombres"
	 */
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	/**
	 * @return
	 * @uml.property name="visible"
	 */
	public int getVisible() {
		return visible;
	}

	/**
	 * @param visible
	 * @uml.property name="visible"
	 */
	public void setVisible(int visible) {
		this.visible = visible;
	}

	/**
	 * @return
	 * @uml.property name="idusuario"
	 */
	public Usuario getIdusuario() {
		return idusuario;
	}

	/**
	 * @param idusuario
	 * @uml.property name="idusuario"
	 */
	public void setIdusuario(Usuario idusuario) {
		this.idusuario = idusuario;
	}

	/**
	 * @return
	 * @uml.property name="claseCollection"
	 */
	public Set<Clase> getClaseCollection() {
		return claseCollection;
	}

	/**
	 * @param claseCollection
	 * @uml.property name="claseCollection"
	 */
	public void setClaseCollection(Set<Clase> claseCollection) {
		this.claseCollection = claseCollection;
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
