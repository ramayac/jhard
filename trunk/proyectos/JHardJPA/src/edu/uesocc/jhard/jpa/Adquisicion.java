package edu.uesocc.jhard.jpa;

import java.io.Serializable;
import java.sql.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;

/**
 * @author robertux
 */
@Entity
public class Adquisicion implements Serializable {
	public Adquisicion(int idadquisicion, Date fecha, double precio,
			String descripcion, String proveedor,
			Set<Software> softwareCollection,
			Set<Existencia> existenciaCollection) {
		super();
		this.idadquisicion = idadquisicion;
		this.fecha = fecha;
		this.precio = precio;
		this.descripcion = descripcion;
		this.proveedor = proveedor;
		this.softwareCollection = softwareCollection;
		this.existenciaCollection = existenciaCollection;
	}

	/**
	 * @uml.property name="idadquisicion"
	 */
	@Id
	private int idadquisicion;

	/**
	 * @uml.property name="fecha"
	 */
	private Date fecha;

	/**
	 * @uml.property name="precio"
	 */
	private double precio;

	/**
	 * @uml.property name="descripcion"
	 */
	@Lob
	private String descripcion;

	/**
	 * @uml.property name="proveedor"
	 */
	private String proveedor;

	/**
	 * @uml.property name="softwareCollection"
	 */
	@OneToMany(mappedBy = "idadquisicion")
	private Set<Software> softwareCollection;

	/**
	 * @uml.property name="existenciaCollection"
	 */
	@OneToMany(mappedBy = "idadquisicion")
	private Set<Existencia> existenciaCollection;

	private static final long serialVersionUID = 1L;

	public Adquisicion() {
		super();
	}

	/**
	 * @return
	 * @uml.property name="idadquisicion"
	 */
	public int getIdadquisicion() {
		return idadquisicion;
	}

	/**
	 * @param idadquisicion
	 * @uml.property name="idadquisicion"
	 */
	public void setIdadquisicion(int idadquisicion) {
		this.idadquisicion = idadquisicion;
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
	 * @uml.property name="precio"
	 */
	public double getPrecio() {
		return precio;
	}

	/**
	 * @param precio
	 * @uml.property name="precio"
	 */
	public void setPrecio(double precio) {
		this.precio = precio;
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
	 * @uml.property name="proveedor"
	 */
	public String getProveedor() {
		return proveedor;
	}

	/**
	 * @param proveedor
	 * @uml.property name="proveedor"
	 */
	public void setProveedor(String proveedor) {
		this.proveedor = proveedor;
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

}
