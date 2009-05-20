package edu.uesocc.jhard.jpa;

import java.io.Serializable;
import java.sql.Date;
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
public class Curso implements Serializable {
	public Curso(int idcurso, String nombre, int cupomax, Date fechainicio,
			int ciclo, int anio, Materia idmateria, Instructor idinstructor,
			Docente iddocente, Estadocurso idestado,
			Set<Horario> horarioCollection,
			Set<Inscripcion> inscripcionCollection) {
		super();
		this.idcurso = idcurso;
		this.nombre = nombre;
		this.cupomax = cupomax;
		this.fechainicio = fechainicio;
		this.ciclo = ciclo;
		this.anio = anio;
		this.idmateria = idmateria;
		this.idinstructor = idinstructor;
		this.iddocente = iddocente;
		this.idestado = idestado;
		this.horarioCollection = horarioCollection;
		this.inscripcionCollection = inscripcionCollection;
	}

	/**
	 * @uml.property name="idcurso"
	 */
	@Id
	private int idcurso;

	/**
	 * @uml.property name="nombre"
	 */
	private String nombre;

	/**
	 * @uml.property name="cupomax"
	 */
	private int cupomax;

	/**
	 * @uml.property name="fechainicio"
	 */
	private Date fechainicio;

	/**
	 * @uml.property name="ciclo"
	 */
	private int ciclo;

	/**
	 * @uml.property name="anio"
	 */
	private int anio;

	/**
	 * @uml.property name="idmateria"
	 * @uml.associationEnd
	 */
	@ManyToOne
	@JoinColumn(name = "idmateria")
	private Materia idmateria;

	/**
	 * @uml.property name="idinstructor"
	 * @uml.associationEnd
	 */
	@ManyToOne
	@JoinColumn(name = "idinstructor")
	private Instructor idinstructor;

	/**
	 * @uml.property name="iddocente"
	 * @uml.associationEnd
	 */
	@ManyToOne
	@JoinColumn(name = "iddocente")
	private Docente iddocente;

	/**
	 * @uml.property name="idestado"
	 * @uml.associationEnd
	 */
	@ManyToOne
	@JoinColumn(name = "idestado")
	private Estadocurso idestado;

	/**
	 * @uml.property name="horarioCollection"
	 */
	@OneToMany(mappedBy = "idcurso")
	private Set<Horario> horarioCollection;

	/**
	 * @uml.property name="inscripcionCollection"
	 */
	@OneToMany(mappedBy = "idcurso")
	private Set<Inscripcion> inscripcionCollection;

	private static final long serialVersionUID = 1L;

	public Curso() {
		super();
	}

	/**
	 * @return
	 * @uml.property name="idcurso"
	 */
	public int getIdcurso() {
		return idcurso;
	}

	/**
	 * @param idcurso
	 * @uml.property name="idcurso"
	 */
	public void setIdcurso(int idcurso) {
		this.idcurso = idcurso;
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
	 * @uml.property name="cupomax"
	 */
	public int getCupomax() {
		return cupomax;
	}

	/**
	 * @param cupomax
	 * @uml.property name="cupomax"
	 */
	public void setCupomax(int cupomax) {
		this.cupomax = cupomax;
	}

	/**
	 * @return
	 * @uml.property name="fechainicio"
	 */
	public Date getFechainicio() {
		return fechainicio;
	}

	/**
	 * @param fechainicio
	 * @uml.property name="fechainicio"
	 */
	public void setFechainicio(Date fechainicio) {
		this.fechainicio = fechainicio;
	}

	/**
	 * @return
	 * @uml.property name="ciclo"
	 */
	public int getCiclo() {
		return ciclo;
	}

	/**
	 * @param ciclo
	 * @uml.property name="ciclo"
	 */
	public void setCiclo(int ciclo) {
		this.ciclo = ciclo;
	}

	/**
	 * @return
	 * @uml.property name="anio"
	 */
	public int getAnio() {
		return anio;
	}

	/**
	 * @param anio
	 * @uml.property name="anio"
	 */
	public void setAnio(int anio) {
		this.anio = anio;
	}

	/**
	 * @return
	 * @uml.property name="idmateria"
	 */
	public Materia getIdmateria() {
		return idmateria;
	}

	/**
	 * @param idmateria
	 * @uml.property name="idmateria"
	 */
	public void setIdmateria(Materia idmateria) {
		this.idmateria = idmateria;
	}

	/**
	 * @return
	 * @uml.property name="idinstructor"
	 */
	public Instructor getIdinstructor() {
		return idinstructor;
	}

	/**
	 * @param idinstructor
	 * @uml.property name="idinstructor"
	 */
	public void setIdinstructor(Instructor idinstructor) {
		this.idinstructor = idinstructor;
	}

	/**
	 * @return
	 * @uml.property name="iddocente"
	 */
	public Docente getIddocente() {
		return iddocente;
	}

	/**
	 * @param iddocente
	 * @uml.property name="iddocente"
	 */
	public void setIddocente(Docente iddocente) {
		this.iddocente = iddocente;
	}

	/**
	 * @return
	 * @uml.property name="idestado"
	 */
	public Estadocurso getIdestado() {
		return idestado;
	}

	/**
	 * @param idestado
	 * @uml.property name="idestado"
	 */
	public void setIdestado(Estadocurso idestado) {
		this.idestado = idestado;
	}

	/**
	 * @return
	 * @uml.property name="horarioCollection"
	 */
	public Set<Horario> getHorarioCollection() {
		return horarioCollection;
	}

	/**
	 * @param horarioCollection
	 * @uml.property name="horarioCollection"
	 */
	public void setHorarioCollection(Set<Horario> horarioCollection) {
		this.horarioCollection = horarioCollection;
	}

	/**
	 * @return
	 * @uml.property name="inscripcionCollection"
	 */
	public Set<Inscripcion> getInscripcionCollection() {
		return inscripcionCollection;
	}

	/**
	 * @param inscripcionCollection
	 * @uml.property name="inscripcionCollection"
	 */
	public void setInscripcionCollection(Set<Inscripcion> inscripcionCollection) {
		this.inscripcionCollection = inscripcionCollection;
	}

}
