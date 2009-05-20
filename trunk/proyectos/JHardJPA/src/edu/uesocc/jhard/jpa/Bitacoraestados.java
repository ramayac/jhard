package edu.uesocc.jhard.jpa;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

/**
 * @author robertux
 */
@Entity
public class Bitacoraestados implements Serializable {
	public Bitacoraestados(int idbitacora, Date fecha, String descripcion,
			Estadoequipo idestado, Existencia idequipoexistente,
			Equiposimple idequipoexistente2) {
		super();
		this.idbitacora = idbitacora;
		this.fecha = fecha;
		this.descripcion = descripcion;
		this.idestado = idestado;
		this.idequipoexistente = idequipoexistente;
		this.idequipoexistente2 = idequipoexistente2;
	}

	/**
	 * @uml.property name="idbitacora"
	 */
	@Id
	private int idbitacora;

	/**
	 * @uml.property name="fecha"
	 */
	private Date fecha;

	/**
	 * @uml.property name="descripcion"
	 */
	@Lob
	private String descripcion;

	/**
	 * @uml.property name="idestado"
	 * @uml.associationEnd
	 */
	@ManyToOne
	@JoinColumn(name = "idestado")
	private Estadoequipo idestado;

	/**
	 * @uml.property name="idequipoexistente"
	 * @uml.associationEnd
	 */
	@ManyToOne
	@JoinColumn(name = "idequipoexistente")
	private Existencia idequipoexistente;

	/**
	 * @uml.property name="idequipoexistente2"
	 * @uml.associationEnd
	 */
	@ManyToOne
	@JoinColumn(name = "idequipoexistente")
	private Equiposimple idequipoexistente2;

	private static final long serialVersionUID = 1L;

	public Bitacoraestados() {
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
	 * @uml.property name="fecha"
	 */
	public Date getFecha() {
		return fecha;
	}

	/**
	 * @param fecha
	 * @uml.property name="fecha"
	 */
	public void setFecha(Date fecha) {
		this.fecha = fecha;
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
	 * @uml.property name="idequipoexistente"
	 */
	public Existencia getIdequipoexistente() {
		return idequipoexistente;
	}

	/**
	 * @param idequipoexistente
	 * @uml.property name="idequipoexistente"
	 */
	public void setIdequipoexistente(Existencia idequipoexistente) {
		this.idequipoexistente = idequipoexistente;
	}

	/**
	 * @return
	 * @uml.property name="idequipoexistente2"
	 */
	public Equiposimple getIdequipoexistente2() {
		return idequipoexistente2;
	}

	/**
	 * @param idequipoexistente2
	 * @uml.property name="idequipoexistente2"
	 */
	public void setIdequipoexistente2(Equiposimple idequipoexistente2) {
		this.idequipoexistente2 = idequipoexistente2;
	}

}
