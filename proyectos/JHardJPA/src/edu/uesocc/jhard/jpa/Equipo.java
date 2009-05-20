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
public class Equipo implements Serializable {
	public Equipo(int idequipo, String nombre, String modelo, Marca idmarca,
			Clasificacion idclasificacion,
			Set<Existencia> existenciaCollection,
			Set<Atributohardware> atributohardwareCollection,
			Set<Accesorio> accesorioCollection, Set<Pieza> piezaCollection) {
		super();
		this.idequipo = idequipo;
		this.nombre = nombre;
		this.modelo = modelo;
		this.idmarca = idmarca;
		this.idclasificacion = idclasificacion;
		this.existenciaCollection = existenciaCollection;
		this.atributohardwareCollection = atributohardwareCollection;
		this.accesorioCollection = accesorioCollection;
		this.piezaCollection = piezaCollection;
	}

	/**
	 * @uml.property name="idequipo"
	 */
	@Id
	private int idequipo;

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
	 * @uml.property name="existenciaCollection"
	 */
	@OneToMany(mappedBy = "idhardware")
	private Set<Existencia> existenciaCollection;

	/**
	 * @uml.property name="atributohardwareCollection"
	 */
	@OneToMany(mappedBy = "idhardware")
	private Set<Atributohardware> atributohardwareCollection;

	/**
	 * @uml.property name="accesorioCollection"
	 */
	@OneToMany(mappedBy = "idequipo")
	private Set<Accesorio> accesorioCollection;

	/**
	 * @uml.property name="piezaCollection"
	 */
	@OneToMany(mappedBy = "idequipo")
	private Set<Pieza> piezaCollection;

	private static final long serialVersionUID = 1L;

	public Equipo() {
		super();
	}

	/**
	 * @return
	 * @uml.property name="idequipo"
	 */
	public int getIdequipo() {
		return idequipo;
	}

	/**
	 * @param idequipo
	 * @uml.property name="idequipo"
	 */
	public void setIdequipo(int idequipo) {
		this.idequipo = idequipo;
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

	/**
	 * @return
	 * @uml.property name="accesorioCollection"
	 */
	public Set<Accesorio> getAccesorioCollection() {
		return accesorioCollection;
	}

	/**
	 * @param accesorioCollection
	 * @uml.property name="accesorioCollection"
	 */
	public void setAccesorioCollection(Set<Accesorio> accesorioCollection) {
		this.accesorioCollection = accesorioCollection;
	}

	/**
	 * @return
	 * @uml.property name="piezaCollection"
	 */
	public Set<Pieza> getPiezaCollection() {
		return piezaCollection;
	}

	/**
	 * @param piezaCollection
	 * @uml.property name="piezaCollection"
	 */
	public void setPiezaCollection(Set<Pieza> piezaCollection) {
		this.piezaCollection = piezaCollection;
	}

}
