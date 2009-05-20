package edu.uesocc.jhard.jpa;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * @author robertux
 */
@Entity
public class Ubicacion implements Serializable {
	public Ubicacion(int idubicacion, String nombre,
			Set<Horario> horarioCollection,
			Set<Existencia> existenciaCollection, Set<Reserva> reservaCollection) {
		super();
		this.idubicacion = idubicacion;
		this.nombre = nombre;
		this.horarioCollection = horarioCollection;
		this.existenciaCollection = existenciaCollection;
		this.reservaCollection = reservaCollection;
	}

	/**
	 * @uml.property name="idubicacion"
	 */
	@Id
	private int idubicacion;

	/**
	 * @uml.property name="nombre"
	 */
	private String nombre;

	/**
	 * @uml.property name="horarioCollection"
	 */
	@OneToMany(mappedBy = "idaula")
	private Set<Horario> horarioCollection;

	/**
	 * @uml.property name="existenciaCollection"
	 */
	@OneToMany(mappedBy = "idubicacion")
	private Set<Existencia> existenciaCollection;

	/**
	 * @uml.property name="reservaCollection"
	 */
	@OneToMany(mappedBy = "idubicacion")
	private Set<Reserva> reservaCollection;

	private static final long serialVersionUID = 1L;

	public Ubicacion() {
		super();
	}

	/**
	 * @return
	 * @uml.property name="idubicacion"
	 */
	public int getIdubicacion() {
		return idubicacion;
	}

	/**
	 * @param idubicacion
	 * @uml.property name="idubicacion"
	 */
	public void setIdubicacion(int idubicacion) {
		this.idubicacion = idubicacion;
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
	 * @uml.property name="existenciaCollection"
	 */
	public Set<Existencia> getExistenciaCollection() {
		return existenciaCollection;
	}

	/**
	 * @param existenciaCollection
	 * @uml.property name="existenciaCollection"
	 */
	public void setExistenciaCollection(Set<Existencia> existenciaCollection) {
		this.existenciaCollection = existenciaCollection;
	}

	/**
	 * @return
	 * @uml.property name="reservaCollection"
	 */
	public Set<Reserva> getReservaCollection() {
		return reservaCollection;
	}

	/**
	 * @param reservaCollection
	 * @uml.property name="reservaCollection"
	 */
	public void setReservaCollection(Set<Reserva> reservaCollection) {
		this.reservaCollection = reservaCollection;
	}

}
