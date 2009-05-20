package edu.uesocc.jhard.jpa;

import java.io.Serializable;
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
public class Accesorio implements Serializable {
	public Accesorio(int idaccesorio, String nombre, String modelo,
			Marca idmarca, Clasificacion idclasificacion, Equipo idequipo,
			Set<Atributohardware> atributohardwareCollection) {
		super();
		this.idaccesorio = idaccesorio;
		this.nombre = nombre;
		this.modelo = modelo;
		this.idmarca = idmarca;
		this.idclasificacion = idclasificacion;
		this.idequipo = idequipo;
		this.atributohardwareCollection = atributohardwareCollection;
	}

	/**
	 * @uml.property name="idaccesorio"
	 */
	@Id
	private int idaccesorio;

	/**
	 * @uml.property name="nombre"
	 */
	private String nombre;

	/**
	 * @uml.property name="modelo"
	 */
	private String modelo;

	/**
	 * @uml.property name="idmarca"
	 * @uml.associationEnd
	 */
	@ManyToOne
	@JoinColumn(name = "idmarca")
	private Marca idmarca;

	/**
	 * @uml.property name="idclasificacion"
	 * @uml.associationEnd
	 */
	@ManyToOne
	@JoinColumn(name = "idclasificacion")
	private Clasificacion idclasificacion;

	/**
	 * @uml.property name="idequipo"
	 * @uml.associationEnd
	 */
	@ManyToOne
	@JoinColumn(name = "idequipo")
	private Equipo idequipo;

	/**
	 * @uml.property name="atributohardwareCollection"
	 */
	@OneToMany(mappedBy = "idhardware3")
	private Set<Atributohardware> atributohardwareCollection;

	private static final long serialVersionUID = 1L;

	public Accesorio() {
		super();
	}

	/**
	 * @return
	 * @uml.property name="idaccesorio"
	 */
	public int getIdaccesorio() {
		return idaccesorio;
	}

	/**
	 * @param idaccesorio
	 * @uml.property name="idaccesorio"
	 */
	public void setIdaccesorio(int idaccesorio) {
		this.idaccesorio = idaccesorio;
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
	 * @uml.property name="modelo"
	 */
	public String getModelo() {
		return modelo;
	}

	/**
	 * @param modelo
	 * @uml.property name="modelo"
	 */
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	/**
	 * @return
	 * @uml.property name="idmarca"
	 */
	public Marca getIdmarca() {
		return idmarca;
	}

	/**
	 * @param idmarca
	 * @uml.property name="idmarca"
	 */
	public void setIdmarca(Marca idmarca) {
		this.idmarca = idmarca;
	}

	/**
	 * @return
	 * @uml.property name="idclasificacion"
	 */
	public Clasificacion getIdclasificacion() {
		return idclasificacion;
	}

	/**
	 * @param idclasificacion
	 * @uml.property name="idclasificacion"
	 */
	public void setIdclasificacion(Clasificacion idclasificacion) {
		this.idclasificacion = idclasificacion;
	}

	/**
	 * @return
	 * @uml.property name="idequipo"
	 */
	public Equipo getIdequipo() {
		return idequipo;
	}

	/**
	 * @param idequipo
	 * @uml.property name="idequipo"
	 */
	public void setIdequipo(Equipo idequipo) {
		this.idequipo = idequipo;
	}

	/**
	 * @return
	 * @uml.property name="atributohardwareCollection"
	 */
	public Set<Atributohardware> getAtributohardwareCollection() {
		return atributohardwareCollection;
	}

	/**
	 * @param atributohardwareCollection
	 * @uml.property name="atributohardwareCollection"
	 */
	public void setAtributohardwareCollection(
			Set<Atributohardware> atributohardwareCollection) {
		this.atributohardwareCollection = atributohardwareCollection;
	}

}
