package edu.uesocc.jhard.jpa;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;

/**
 * @author robertux
 */
@Entity
public class Clasificacion implements Serializable {
	public Clasificacion(int idclasificacion, String nombre,
			String descripcion, int idsuperior,
			Set<Software> softwareCollection, Set<Equipo> equipoCollection,
			Set<Accesorio> accesorioCollection, Set<Pieza> piezaCollection) {
		super();
		this.idclasificacion = idclasificacion;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.idsuperior = idsuperior;
		this.softwareCollection = softwareCollection;
		this.equipoCollection = equipoCollection;
		this.accesorioCollection = accesorioCollection;
		this.piezaCollection = piezaCollection;
	}

	/**
	 * @uml.property name="idclasificacion"
	 */
	@Id
	private int idclasificacion;

	/**
	 * @uml.property name="nombre"
	 */
	private String nombre;

	/**
	 * @uml.property name="descripcion"
	 */
	@Lob
	private String descripcion;

	/**
	 * @uml.property name="idsuperior"
	 */
	private int idsuperior;

	/**
	 * @uml.property name="softwareCollection"
	 */
	@OneToMany(mappedBy = "idclasificacion")
	private Set<Software> softwareCollection;

	/**
	 * @uml.property name="equipoCollection"
	 */
	@OneToMany(mappedBy = "idclasificacion")
	private Set<Equipo> equipoCollection;

	/**
	 * @uml.property name="accesorioCollection"
	 */
	@OneToMany(mappedBy = "idclasificacion")
	private Set<Accesorio> accesorioCollection;

	/**
	 * @uml.property name="piezaCollection"
	 */
	@OneToMany(mappedBy = "idclasificacion")
	private Set<Pieza> piezaCollection;

	private static final long serialVersionUID = 1L;

	public Clasificacion() {
		super();
	}

	/**
	 * @return
	 * @uml.property name="idclasificacion"
	 */
	public int getIdclasificacion() {
		return idclasificacion;
	}

	/**
	 * @param idclasificacion
	 * @uml.property name="idclasificacion"
	 */
	public void setIdclasificacion(int idclasificacion) {
		this.idclasificacion = idclasificacion;
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
	 * @uml.property name="descripcion"
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * @param descripcion
	 * @uml.property name="descripcion"
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * @return
	 * @uml.property name="idsuperior"
	 */
	public int getIdsuperior() {
		return idsuperior;
	}

	/**
	 * @param idsuperior
	 * @uml.property name="idsuperior"
	 */
	public void setIdsuperior(int idsuperior) {
		this.idsuperior = idsuperior;
	}

	/**
	 * @return
	 * @uml.property name="softwareCollection"
	 */
	public Set<Software> getSoftwareCollection() {
		return softwareCollection;
	}

	/**
	 * @param softwareCollection
	 * @uml.property name="softwareCollection"
	 */
	public void setSoftwareCollection(Set<Software> softwareCollection) {
		this.softwareCollection = softwareCollection;
	}

	/**
	 * @return
	 * @uml.property name="equipoCollection"
	 */
	public Set<Equipo> getEquipoCollection() {
		return equipoCollection;
	}

	/**
	 * @param equipoCollection
	 * @uml.property name="equipoCollection"
	 */
	public void setEquipoCollection(Set<Equipo> equipoCollection) {
		this.equipoCollection = equipoCollection;
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
