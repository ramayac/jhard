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
public class Mantenimiento implements Serializable {
	public Mantenimiento(int idmantenimiento, Date fecha, String descripcion,
			Tecnico idtecnico, Solicitud idsolicitud,
			Existencia idequipoexistente) {
		super();
		this.idmantenimiento = idmantenimiento;
		this.fecha = fecha;
		this.descripcion = descripcion;
		this.idtecnico = idtecnico;
		this.idsolicitud = idsolicitud;
		this.idequipoexistente = idequipoexistente;
	}

	/**
	 * @uml.property name="idmantenimiento"
	 */
	@Id
	private int idmantenimiento;

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
	 * @uml.property name="idtecnico"
	 * @uml.associationEnd
	 */
	@ManyToOne
	@JoinColumn(name = "idtecnico")
	private Tecnico idtecnico;

	/**
	 * @uml.property name="idsolicitud"
	 * @uml.associationEnd
	 */
	@ManyToOne
	@JoinColumn(name = "idsolicitud")
	private Solicitud idsolicitud;

	/**
	 * @uml.property name="idequipoexistente"
	 * @uml.associationEnd
	 */
	@ManyToOne
	@JoinColumn(name = "idequipoexistente")
	private Existencia idequipoexistente;

	private static final long serialVersionUID = 1L;

	public Mantenimiento() {
		super();
	}

	/**
	 * @return
	 * @uml.property name="idmantenimiento"
	 */
	public int getIdmantenimiento() {
		return idmantenimiento;
	}

	/**
	 * @param idmantenimiento
	 * @uml.property name="idmantenimiento"
	 */
	public void setIdmantenimiento(int idmantenimiento) {
		this.idmantenimiento = idmantenimiento;
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
	 * @uml.property name="idtecnico"
	 */
	public Tecnico getIdtecnico() {
		return idtecnico;
	}

	/**
	 * @param idtecnico
	 * @uml.property name="idtecnico"
	 */
	public void setIdtecnico(Tecnico idtecnico) {
		this.idtecnico = idtecnico;
	}

	/**
	 * @return
	 * @uml.property name="idsolicitud"
	 */
	public Solicitud getIdsolicitud() {
		return idsolicitud;
	}

	/**
	 * @param idsolicitud
	 * @uml.property name="idsolicitud"
	 */
	public void setIdsolicitud(Solicitud idsolicitud) {
		this.idsolicitud = idsolicitud;
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

}
