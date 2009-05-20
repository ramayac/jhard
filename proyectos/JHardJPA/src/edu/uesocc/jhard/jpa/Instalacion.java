package edu.uesocc.jhard.jpa;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * @author robertux
 */
@Entity
public class Instalacion implements Serializable {
	public Instalacion(int idinstalacion, Date fechainstalacion,
			Software idsoftware, Existencia idequipoexistente) {
		super();
		this.idinstalacion = idinstalacion;
		this.fechainstalacion = fechainstalacion;
		this.idsoftware = idsoftware;
		this.idequipoexistente = idequipoexistente;
	}

	/**
	 * @uml.property name="idinstalacion"
	 */
	@Id
	private int idinstalacion;

	/**
	 * @uml.property name="fechainstalacion"
	 */
	private Date fechainstalacion;

	/**
	 * @uml.property name="idsoftware"
	 * @uml.associationEnd
	 */
	@ManyToOne
	@JoinColumn(name = "idsoftware")
	private Software idsoftware;

	/**
	 * @uml.property name="idequipoexistente"
	 * @uml.associationEnd
	 */
	@ManyToOne
	@JoinColumn(name = "idequipoexistente")
	private Existencia idequipoexistente;

	private static final long serialVersionUID = 1L;

	public Instalacion() {
		super();
	}

	/**
	 * @return
	 * @uml.property name="idinstalacion"
	 */
	public int getIdinstalacion() {
		return idinstalacion;
	}

	/**
	 * @param idinstalacion
	 * @uml.property name="idinstalacion"
	 */
	public void setIdinstalacion(int idinstalacion) {
		this.idinstalacion = idinstalacion;
	}

	/**
	 * @return
	 * @uml.property name="fechainstalacion"
	 */
	public Date getFechainstalacion() {
		return fechainstalacion;
	}

	/**
	 * @param fechainstalacion
	 * @uml.property name="fechainstalacion"
	 */
	public void setFechainstalacion(Date fechainstalacion) {
		this.fechainstalacion = fechainstalacion;
	}

	/**
	 * @return
	 * @uml.property name="idsoftware"
	 */
	public Software getIdsoftware() {
		return idsoftware;
	}

	/**
	 * @param idsoftware
	 * @uml.property name="idsoftware"
	 */
	public void setIdsoftware(Software idsoftware) {
		this.idsoftware = idsoftware;
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
