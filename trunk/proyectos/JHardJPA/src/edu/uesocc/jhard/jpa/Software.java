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
public class Software implements Serializable {
	public Software(int idsoftware, String nombre, String version,
			String codigolicencia, int cantidadlicencias,
			Adquisicion idadquisicion, Clasificacion idclasificacion,
			Set<Instalacion> instalacionCollection) {
		super();
		this.idsoftware = idsoftware;
		this.nombre = nombre;
		this.version = version;
		this.codigolicencia = codigolicencia;
		this.cantidadlicencias = cantidadlicencias;
		this.idadquisicion = idadquisicion;
		this.idclasificacion = idclasificacion;
		this.instalacionCollection = instalacionCollection;
	}

	/**
	 * @uml.property name="idsoftware"
	 */
	@Id
	private int idsoftware;

	/**
	 * @uml.property name="nombre"
	 */
	private String nombre;

	/**
	 * @uml.property name="version"
	 */
	private String version;

	/**
	 * @uml.property name="codigolicencia"
	 */
	private String codigolicencia;

	/**
	 * @uml.property name="cantidadlicencias"
	 */
	private int cantidadlicencias;

	/**
	 * @uml.property name="idadquisicion"
	 * @uml.associationEnd
	 */
	@ManyToOne
	@JoinColumn(name = "idadquisicion")
	private Adquisicion idadquisicion;

	/**
	 * @uml.property name="idclasificacion"
	 * @uml.associationEnd
	 */
	@ManyToOne
	@JoinColumn(name = "idclasificacion")
	private Clasificacion idclasificacion;

	/**
	 * @uml.property name="instalacionCollection"
	 */
	@OneToMany(mappedBy = "idsoftware")
	private Set<Instalacion> instalacionCollection;

	private static final long serialVersionUID = 1L;

	public Software() {
		super();
	}

	/**
	 * @return
	 * @uml.property name="idsoftware"
	 */
	public int getIdsoftware() {
		return idsoftware;
	}

	/**
	 * @param idsoftware
	 * @uml.property name="idsoftware"
	 */
	public void setIdsoftware(int idsoftware) {
		this.idsoftware = idsoftware;
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
	 * @uml.property name="version"
	 */
	public String getVersion() {
		return version;
	}

	/**
	 * @param version
	 * @uml.property name="version"
	 */
	public void setVersion(String version) {
		this.version = version;
	}

	/**
	 * @return
	 * @uml.property name="codigolicencia"
	 */
	public String getCodigolicencia() {
		return codigolicencia;
	}

	/**
	 * @param codigolicencia
	 * @uml.property name="codigolicencia"
	 */
	public void setCodigolicencia(String codigolicencia) {
		this.codigolicencia = codigolicencia;
	}

	/**
	 * @return
	 * @uml.property name="cantidadlicencias"
	 */
	public int getCantidadlicencias() {
		return cantidadlicencias;
	}

	/**
	 * @param cantidadlicencias
	 * @uml.property name="cantidadlicencias"
	 */
	public void setCantidadlicencias(int cantidadlicencias) {
		this.cantidadlicencias = cantidadlicencias;
	}

	/**
	 * @return
	 * @uml.property name="idadquisicion"
	 */
	public Adquisicion getIdadquisicion() {
		return idadquisicion;
	}

	/**
	 * @param idadquisicion
	 * @uml.property name="idadquisicion"
	 */
	public void setIdadquisicion(Adquisicion idadquisicion) {
		this.idadquisicion = idadquisicion;
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
	 * @uml.property name="instalacionCollection"
	 */
	public Set<Instalacion> getInstalacionCollection() {
		return instalacionCollection;
	}

	/**
	 * @param instalacionCollection
	 * @uml.property name="instalacionCollection"
	 */
	public void setInstalacionCollection(Set<Instalacion> instalacionCollection) {
		this.instalacionCollection = instalacionCollection;
	}

}
