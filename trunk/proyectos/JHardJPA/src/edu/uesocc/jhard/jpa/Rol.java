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
public class Rol implements Serializable {
	public Rol(int idrol, String nombre, String descripcion,
			Set<Usuario> usuarioCollection) {
		super();
		this.idrol = idrol;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.usuarioCollection = usuarioCollection;
	}

	/**
	 * @uml.property name="idrol"
	 */
	@Id
	private int idrol;

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
	 * @uml.property name="usuarioCollection"
	 */
	@OneToMany(mappedBy = "idrol")
	private Set<Usuario> usuarioCollection;

	private static final long serialVersionUID = 1L;

	public Rol() {
		super();
	}

	/**
	 * @return
	 * @uml.property name="idrol"
	 */
	public int getIdrol() {
		return idrol;
	}

	/**
	 * @param idrol
	 * @uml.property name="idrol"
	 */
	public void setIdrol(int idrol) {
		this.idrol = idrol;
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
	 * @uml.property name="usuarioCollection"
	 */
	public Set<Usuario> getUsuarioCollection() {
		return usuarioCollection;
	}

	/**
	 * @param usuarioCollection
	 * @uml.property name="usuarioCollection"
	 */
	public void setUsuarioCollection(Set<Usuario> usuarioCollection) {
		this.usuarioCollection = usuarioCollection;
	}

}
