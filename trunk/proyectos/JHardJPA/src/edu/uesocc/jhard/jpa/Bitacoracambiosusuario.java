package edu.uesocc.jhard.jpa;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

/**
 * @author robertux
 */
@Entity
public class Bitacoracambiosusuario implements Serializable {
	public Bitacoracambiosusuario(int idbitacora, String descripcion,
			Date fechahora, Usuario idusuario) {
		super();
		this.idbitacora = idbitacora;
		this.descripcion = descripcion;
		this.fechahora = fechahora;
		this.idusuario = idusuario;
	}

	/**
	 * @uml.property name="idbitacora"
	 */
	@Id
	private int idbitacora;

	/**
	 * @uml.property name="descripcion"
	 */
	@Lob
	private String descripcion;

	/**
	 * @uml.property name="fechahora"
	 */
	private Date fechahora;

	/**
	 * @uml.property name="idusuario"
	 * @uml.associationEnd
	 */
	@ManyToOne
	@JoinColumn(name = "idusuario")
	private Usuario idusuario;

	private static final long serialVersionUID = 1L;

	public Bitacoracambiosusuario() {
		super();
	}

	/**
	 * @return
	 * @uml.property name="idbitacora"
	 */
	public int getIdbitacora() {
		return idbitacora;
	}

	/**
	 * @param idbitacora
	 * @uml.property name="idbitacora"
	 */
	public void setIdbitacora(int idbitacora) {
		this.idbitacora = idbitacora;
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
	 * @uml.property name="fechahora"
	 */
	public Date getFechahora() {
		return fechahora;
	}

	/**
	 * @param fechahora
	 * @uml.property name="fechahora"
	 */
	public void setFechahora(Date fechahora) {
		this.fechahora = fechahora;
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
