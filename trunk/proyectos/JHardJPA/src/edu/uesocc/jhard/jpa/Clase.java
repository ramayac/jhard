package edu.uesocc.jhard.jpa;

import java.io.Serializable;
import java.sql.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * @author robertux
 */
@Entity
public class Clase implements Serializable {
	public Clase(int idclase, Date fecha, String tema, String observaciones,
			Horario idhorario, Instructor idinstructor, Docente iddocente,
			Set<Asistencia> asistenciaCollection) {
		super();
		this.idclase = idclase;
		this.fecha = fecha;
		this.tema = tema;
		this.observaciones = observaciones;
		this.idhorario = idhorario;
		this.idinstructor = idinstructor;
		this.iddocente = iddocente;
		this.asistenciaCollection = asistenciaCollection;
	}

	/**
	 * @uml.property name="idclase"
	 */
	@Id
	private int idclase;

	/**
	 * @uml.property name="fecha"
	 */
	private Date fecha;

	/**
	 * @uml.property name="tema"
	 */
	private String tema;

	/**
	 * @uml.property name="observaciones"
	 */
	@Lob
	private String observaciones;

	/**
	 * @uml.property name="idhorario"
	 * @uml.associationEnd
	 */
	@ManyToOne
	@JoinColumn(name = "idhorario")
	private Horario idhorario;

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
	 * @uml.property name="asistenciaCollection"
	 */
	@OneToMany(mappedBy = "idclase")
	private Set<Asistencia> asistenciaCollection;

	private static final long serialVersionUID = 1L;

	public Clase() {
		super();
	}

	/**
	 * @return
	 * @uml.property name="idclase"
	 */
	public int getIdclase() {
		return idclase;
	}

	/**
	 * @param idclase
	 * @uml.property name="idclase"
	 */
	public void setIdclase(int idclase) {
		this.idclase = idclase;
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
	 * @uml.property name="tema"
	 */
	public String getTema() {
		return tema;
	}

	/**
	 * @param tema
	 * @uml.property name="tema"
	 */
	public void setTema(String tema) {
		this.tema = tema;
	}

	/**
	 * @return
	 * @uml.property name="observaciones"
	 */
	public String getObservaciones() {
		return observaciones;
	}

	/**
	 * @param observaciones
	 * @uml.property name="observaciones"
	 */
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	/**
	 * @return
	 * @uml.property name="idhorario"
	 */
	public Horario getIdhorario() {
		return idhorario;
	}

	/**
	 * @param idhorario
	 * @uml.property name="idhorario"
	 */
	public void setIdhorario(Horario idhorario) {
		this.idhorario = idhorario;
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
	 * @uml.property name="asistenciaCollection"
	 */
	public Set<Asistencia> getAsistenciaCollection() {
		return asistenciaCollection;
	}

	/**
	 * @param asistenciaCollection
	 * @uml.property name="asistenciaCollection"
	 */
	public void setAsistenciaCollection(Set<Asistencia> asistenciaCollection) {
		this.asistenciaCollection = asistenciaCollection;
	}

}
