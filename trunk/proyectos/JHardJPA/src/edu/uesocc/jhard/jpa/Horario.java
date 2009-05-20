package edu.uesocc.jhard.jpa;

import java.io.Serializable;
import java.sql.Time;
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
public class Horario implements Serializable {
	public Horario(int idhorario, int diasemana, Time horainicio, Time horafin,
			Curso idcurso, Ubicacion idaula, Set<Clase> claseCollection) {
		super();
		this.idhorario = idhorario;
		this.diasemana = diasemana;
		this.horainicio = horainicio;
		this.horafin = horafin;
		this.idcurso = idcurso;
		this.idaula = idaula;
		this.claseCollection = claseCollection;
	}

	/**
	 * @uml.property name="idhorario"
	 */
	@Id
	private int idhorario;

	/**
	 * @uml.property name="diasemana"
	 */
	private int diasemana;

	/**
	 * @uml.property name="horainicio"
	 */
	private Time horainicio;

	/**
	 * @uml.property name="horafin"
	 */
	private Time horafin;

	/**
	 * @uml.property name="idcurso"
	 * @uml.associationEnd
	 */
	@ManyToOne
	@JoinColumn(name = "idcurso")
	private Curso idcurso;

	/**
	 * @uml.property name="idaula"
	 * @uml.associationEnd
	 */
	@ManyToOne
	@JoinColumn(name = "idaula")
	private Ubicacion idaula;

	/**
	 * @uml.property name="claseCollection"
	 */
	@OneToMany(mappedBy = "idhorario")
	private Set<Clase> claseCollection;

	private static final long serialVersionUID = 1L;

	public Horario() {
		super();
	}

	/**
	 * @return
	 * @uml.property name="idhorario"
	 */
	public int getIdhorario() {
		return idhorario;
	}

	/**
	 * @param idhorario
	 * @uml.property name="idhorario"
	 */
	public void setIdhorario(int idhorario) {
		this.idhorario = idhorario;
	}

	/**
	 * @return
	 * @uml.property name="diasemana"
	 */
	public int getDiasemana() {
		return diasemana;
	}

	/**
	 * @param diasemana
	 * @uml.property name="diasemana"
	 */
	public void setDiasemana(int diasemana) {
		this.diasemana = diasemana;
	}

	/**
	 * @return
	 * @uml.property name="horainicio"
	 */
	public Time getHorainicio() {
		return horainicio;
	}

	/**
	 * @param horainicio
	 * @uml.property name="horainicio"
	 */
	public void setHorainicio(Time horainicio) {
		this.horainicio = horainicio;
	}

	/**
	 * @return
	 * @uml.property name="horafin"
	 */
	public Time getHorafin() {
		return horafin;
	}

	/**
	 * @param horafin
	 * @uml.property name="horafin"
	 */
	public void setHorafin(Time horafin) {
		this.horafin = horafin;
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
	 * @uml.property name="idaula"
	 */
	public Ubicacion getIdaula() {
		return idaula;
	}

	/**
	 * @param idaula
	 * @uml.property name="idaula"
	 */
	public void setIdaula(Ubicacion idaula) {
		this.idaula = idaula;
	}

	/**
	 * @return
	 * @uml.property name="claseCollection"
	 */
	public Set<Clase> getClaseCollection() {
		return claseCollection;
	}

	/**
	 * @param claseCollection
	 * @uml.property name="claseCollection"
	 */
	public void setClaseCollection(Set<Clase> claseCollection) {
		this.claseCollection = claseCollection;
	}

}
