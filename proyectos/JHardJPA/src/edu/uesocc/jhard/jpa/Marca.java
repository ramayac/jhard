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
public class Marca implements Serializable {
	public Marca(int idmarca, String nombre, Set<Equipo> equipoCollection,
			Set<Accesorio> accesorioCollection, Set<Pieza> piezaCollection) {
		super();
		this.idmarca = idmarca;
		this.nombre = nombre;
		this.equipoCollection = equipoCollection;
		this.accesorioCollection = accesorioCollection;
		this.piezaCollection = piezaCollection;
	}

	/**
	 * @uml.property name="idmarca"
	 */
	@Id
	private int idmarca;

	/**
	 * @uml.property name="nombre"
	 */
	private String nombre;

	/**
	 * @uml.property name="equipoCollection"
	 */
	@OneToMany(mappedBy = "idmarca")
	private Set<Equipo> equipoCollection;

	/**
	 * @uml.property name="accesorioCollection"
	 */
	@OneToMany(mappedBy = "idmarca")
	private Set<Accesorio> accesorioCollection;

	/**
	 * @uml.property name="piezaCollection"
	 */
	@OneToMany(mappedBy = "idmarca")
	private Set<Pieza> piezaCollection;

	private static final long serialVersionUID = 1L;

	public Marca() {
		super();
	}

	/**
	 * @return
	 * @uml.property name="idmarca"
	 */
	public int getIdmarca() {
		return idmarca;
	}

	/**
	 * @param idmarca
	 * @uml.property name="idmarca"
	 */
	public void setIdmarca(int idmarca) {
		this.idmarca = idmarca;
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
