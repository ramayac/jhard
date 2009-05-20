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
public class Asistencia implements Serializable {
	public Asistencia(int idasistencia, Estudiante idestudiante, Clase idclase,
			Existencia idequipoexistente) {
		super();
		this.idasistencia = idasistencia;
		this.idestudiante = idestudiante;
		this.idclase = idclase;
		this.idequipoexistente = idequipoexistente;
	}

	/**
	 * @uml.property name="idasistencia"
	 */
	@Id
	private int idasistencia;

	/**
	 * @uml.property name="idestudiante"
	 * @uml.associationEnd
	 */
	@ManyToOne
	@JoinColumn(name = "idestudiante")
	private Estudiante idestudiante;

	/**
	 * @uml.property name="idclase"
	 * @uml.associationEnd
	 */
	@ManyToOne
	@JoinColumn(name = "idclase")
	private Clase idclase;

	/**
	 * @uml.property name="idequipoexistente"
	 * @uml.associationEnd
	 */
	@ManyToOne
	@JoinColumn(name = "idequipoexistente")
	private Existencia idequipoexistente;

	private static final long serialVersionUID = 1L;

	public Asistencia() {
		super();
	}

	/**
	 * @return
	 * @uml.property name="idasistencia"
	 */
	public int getIdasistencia() {
		return idasistencia;
	}

	/**
	 * @param idasistencia
	 * @uml.property name="idasistencia"
	 */
	public void setIdasistencia(int idasistencia) {
		this.idasistencia = idasistencia;
	}

	/**
	 * @return
	 * @uml.property name="idestudiante"
	 */
	public Estudiante getIdestudiante() {
		return idestudiante;
	}

	/**
	 * @param idestudiante
	 * @uml.property name="idestudiante"
	 */
	public void setIdestudiante(Estudiante idestudiante) {
		this.idestudiante = idestudiante;
	}

	/**
	 * @return
	 * @uml.property name="idclase"
	 */
	public Clase getIdclase() {
		return idclase;
	}

	/**
	 * @param idclase
	 * @uml.property name="idclase"
	 */
	public void setIdclase(Clase idclase) {
		this.idclase = idclase;
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
