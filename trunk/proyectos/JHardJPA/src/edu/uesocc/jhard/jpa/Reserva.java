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
public class Reserva implements Serializable {
	public Reserva(int idreserva, Date fechareserva,
			java.util.Date fechahorainicioprestamo,
			java.util.Date fechahorafinprestamo, String descripcion,
			Estadoreserva idestado, Existencia idequipoexistente,
			Ubicacion idubicacion, Solicitante idsolicitante,
			Responsable idresponsable, Usuario idusuario) {
		super();
		this.idreserva = idreserva;
		this.fechareserva = fechareserva;
		this.fechahorainicioprestamo = fechahorainicioprestamo;
		this.fechahorafinprestamo = fechahorafinprestamo;
		this.descripcion = descripcion;
		this.idestado = idestado;
		this.idequipoexistente = idequipoexistente;
		this.idubicacion = idubicacion;
		this.idsolicitante = idsolicitante;
		this.idresponsable = idresponsable;
		this.idusuario = idusuario;
	}

	/**
	 * @uml.property name="idreserva"
	 */
	@Id
	private int idreserva;

	/**
	 * @uml.property name="fechareserva"
	 */
	private Date fechareserva;

	/**
	 * @uml.property name="fechahorainicioprestamo"
	 */
	private java.util.Date fechahorainicioprestamo;

	/**
	 * @uml.property name="fechahorafinprestamo"
	 */
	private java.util.Date fechahorafinprestamo;

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
	private Estadoreserva idestado;

	/**
	 * @uml.property name="idequipoexistente"
	 * @uml.associationEnd
	 */
	@ManyToOne
	@JoinColumn(name = "idequipoexistente")
	private Existencia idequipoexistente;

	/**
	 * @uml.property name="idubicacion"
	 * @uml.associationEnd
	 */
	@ManyToOne
	@JoinColumn(name = "idubicacion")
	private Ubicacion idubicacion;

	/**
	 * @uml.property name="idsolicitante"
	 * @uml.associationEnd
	 */
	@ManyToOne
	@JoinColumn(name = "idsolicitante")
	private Solicitante idsolicitante;

	/**
	 * @uml.property name="idresponsable"
	 * @uml.associationEnd
	 */
	@ManyToOne
	@JoinColumn(name = "idresponsable")
	private Responsable idresponsable;

	/**
	 * @uml.property name="idusuario"
	 * @uml.associationEnd
	 */
	@ManyToOne
	@JoinColumn(name = "idusuario")
	private Usuario idusuario;

	private static final long serialVersionUID = 1L;

	public Reserva() {
		super();
	}

	/**
	 * @return
	 * @uml.property name="idreserva"
	 */
	public int getIdreserva() {
		return idreserva;
	}

	/**
	 * @param idreserva
	 * @uml.property name="idreserva"
	 */
	public void setIdreserva(int idreserva) {
		this.idreserva = idreserva;
	}

	/**
	 * @return
	 * @uml.property name="fechareserva"
	 */
	public Date getFechareserva() {
		return fechareserva;
	}

	/**
	 * @param fechareserva
	 * @uml.property name="fechareserva"
	 */
	public void setFechareserva(Date fechareserva) {
		this.fechareserva = fechareserva;
	}

	/**
	 * @return
	 * @uml.property name="fechahorainicioprestamo"
	 */
	public java.util.Date getFechahorainicioprestamo() {
		return fechahorainicioprestamo;
	}

	/**
	 * @param fechahorainicioprestamo
	 * @uml.property name="fechahorainicioprestamo"
	 */
	public void setFechahorainicioprestamo(
			java.util.Date fechahorainicioprestamo) {
		this.fechahorainicioprestamo = fechahorainicioprestamo;
	}

	/**
	 * @return
	 * @uml.property name="fechahorafinprestamo"
	 */
	public java.util.Date getFechahorafinprestamo() {
		return fechahorafinprestamo;
	}

	/**
	 * @param fechahorafinprestamo
	 * @uml.property name="fechahorafinprestamo"
	 */
	public void setFechahorafinprestamo(java.util.Date fechahorafinprestamo) {
		this.fechahorafinprestamo = fechahorafinprestamo;
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
	public Estadoreserva getIdestado() {
		return idestado;
	}

	/**
	 * @param idestado
	 * @uml.property name="idestado"
	 */
	public void setIdestado(Estadoreserva idestado) {
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
	 * @uml.property name="idubicacion"
	 */
	public Ubicacion getIdubicacion() {
		return idubicacion;
	}

	/**
	 * @param idubicacion
	 * @uml.property name="idubicacion"
	 */
	public void setIdubicacion(Ubicacion idubicacion) {
		this.idubicacion = idubicacion;
	}

	/**
	 * @return
	 * @uml.property name="idsolicitante"
	 */
	public Solicitante getIdsolicitante() {
		return idsolicitante;
	}

	/**
	 * @param idsolicitante
	 * @uml.property name="idsolicitante"
	 */
	public void setIdsolicitante(Solicitante idsolicitante) {
		this.idsolicitante = idsolicitante;
	}

	/**
	 * @return
	 * @uml.property name="idresponsable"
	 */
	public Responsable getIdresponsable() {
		return idresponsable;
	}

	/**
	 * @param idresponsable
	 * @uml.property name="idresponsable"
	 */
	public void setIdresponsable(Responsable idresponsable) {
		this.idresponsable = idresponsable;
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
