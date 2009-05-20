package edu.uesocc.jhard.jpa;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * @author robertux
 */
@Entity
public class Administrador implements Serializable {
	public Administrador(int idadministrador, String clave, Usuario idusuario) {
		super();
		this.idadministrador = idadministrador;
		this.clave = clave;
		this.idusuario = idusuario;
	}

	/**
	 * @uml.property name="idadministrador"
	 */
	@Id
	private int idadministrador;

	/**
	 * @uml.property name="clave"
	 */
	private String clave;

	/**
	 * @uml.property name="idusuario"
	 * @uml.associationEnd
	 */
	@ManyToOne
	@JoinColumn(name = "idusuario")
	private Usuario idusuario;

	private static final long serialVersionUID = 1L;

	public Administrador() {
		super();
	}

	/**
	 * @return
	 * @uml.property name="idadministrador"
	 */
	public int getIdadministrador() {
		return idadministrador;
	}

	/**
	 * @param idadministrador
	 * @uml.property name="idadministrador"
	 */
	public void setIdadministrador(int idadministrador) {
		this.idadministrador = idadministrador;
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

}
