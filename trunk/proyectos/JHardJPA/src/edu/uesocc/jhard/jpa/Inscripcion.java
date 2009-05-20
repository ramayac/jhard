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
public class Inscripcion implements Serializable {
	public Inscripcion(int idinscripcion, Curso idcurso, Estudiante idestudiante) {
		super();
		this.idinscripcion = idinscripcion;
		this.idcurso = idcurso;
		this.idestudiante = idestudiante;
	}

	/**
	 * @uml.property name="idinscripcion"
	 */
	@Id
	private int idinscripcion;

	/**
	 * @uml.property name="idcurso"
	 * @uml.associationEnd
	 */
	@ManyToOne
	@JoinColumn(name = "idcurso")
	private Curso idcurso;

	/**
	 * @uml.property name="idestudiante"
	 * @uml.associationEnd
	 */
	@ManyToOne
	@JoinColumn(name = "idestudiante")
	private Estudiante idestudiante;

	private static final long serialVersionUID = 1L;

	public Inscripcion() {
		super();
	}

	/**
	 * @return
	 * @uml.property name="idinscripcion"
	 */
	public int getIdinscripcion() {
		return idinscripcion;
	}

	/**
	 * @param idinscripcion
	 * @uml.property name="idinscripcion"
	 */
	public void setIdinscripcion(int idinscripcion) {
		this.idinscripcion = idinscripcion;
	}

	/**
	 * @return
	 * @uml.property name="idcurso"
	 */
	public Curso getIdcurso() {
		return idcurso;
	}

	/**
	 * @param idcurso
	 * @uml.property name="idcurso"
	 */
	public void setIdcurso(Curso idcurso) {
		this.idcurso = idcurso;
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

}
