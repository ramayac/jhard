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
public class Estadoreserva implements Serializable {
	public Estadoreserva(int idestadoreserva, String nombre,
			Set<Reserva> reservaCollection) {
		super();
		this.idestadoreserva = idestadoreserva;
		this.nombre = nombre;
		this.reservaCollection = reservaCollection;
	}

	/**
	 * @uml.property name="idestadoreserva"
	 */
	@Id
	private int idestadoreserva;

	/**
	 * @uml.property name="nombre"
	 */
	private String nombre;

	/**
	 * @uml.property name="reservaCollection"
	 */
	@OneToMany(mappedBy = "idestado")
	private Set<Reserva> reservaCollection;

	private static final long serialVersionUID = 1L;

	public Estadoreserva() {
		super();
	}

	/**
	 * @return
	 * @uml.property name="idestadoreserva"
	 */
	public int getIdestadoreserva() {
		return idestadoreserva;
	}

	/**
	 * @param idestadoreserva
	 * @uml.property name="idestadoreserva"
	 */
	public void setIdestadoreserva(int idestadoreserva) {
		this.idestadoreserva = idestadoreserva;
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
