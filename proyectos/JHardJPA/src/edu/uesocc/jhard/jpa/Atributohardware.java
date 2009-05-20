package edu.uesocc.jhard.jpa;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * @author robertux
 */
@Entity
public class Atributohardware implements Serializable {
	public Atributohardware(int idatributohardware, String nombre,
			String valor, String unidadmedida, Equipo idhardware,
			Pieza idhardware2, Accesorio idhardware3) {
		super();
		this.idatributohardware = idatributohardware;
		this.nombre = nombre;
		this.valor = valor;
		this.unidadmedida = unidadmedida;
		this.idhardware = idhardware;
		this.idhardware2 = idhardware2;
		this.idhardware3 = idhardware3;
	}

	/**
	 * @uml.property name="idatributohardware"
	 */
	@Id
	private int idatributohardware;

	/**
	 * @uml.property name="nombre"
	 */
	private String nombre;

	/**
	 * @uml.property name="valor"
	 */
	private String valor;

	/**
	 * @uml.property name="unidadmedida"
	 */
	private String unidadmedida;

	/**
	 * @uml.property name="idhardware"
	 * @uml.associationEnd
	 */
	@ManyToOne
	@JoinColumn(name = "idhardware")
	private Equipo idhardware;

	/**
	 * @uml.property name="idhardware2"
	 * @uml.associationEnd
	 */
	@ManyToOne
	@JoinColumn(name = "idhardware")
	private Pieza idhardware2;

	/**
	 * @uml.property name="idhardware3"
	 * @uml.associationEnd
	 */
	@ManyToOne
	@JoinColumn(name = "idhardware")
	private Accesorio idhardware3;

	private static final long serialVersionUID = 1L;

	public Atributohardware() {
		super();
	}

	/**
	 * @return
	 * @uml.property name="idatributohardware"
	 */
	public int getIdatributohardware() {
		return idatributohardware;
	}

	/**
	 * @param idatributohardware
	 * @uml.property name="idatributohardware"
	 */
	public void setIdatributohardware(int idatributohardware) {
		this.idatributohardware = idatributohardware;
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
	 * @uml.property name="valor"
	 */
	public String getValor() {
		return valor;
	}

	/**
	 * @param valor
	 * @uml.property name="valor"
	 */
	public void setValor(String valor) {
		this.valor = valor;
	}

	/**
	 * @return
	 * @uml.property name="unidadmedida"
	 */
	public String getUnidadmedida() {
		return unidadmedida;
	}

	/**
	 * @param unidadmedida
	 * @uml.property name="unidadmedida"
	 */
	public void setUnidadmedida(String unidadmedida) {
		this.unidadmedida = unidadmedida;
	}

	/**
	 * @return
	 * @uml.property name="idhardware"
	 */
	public Equipo getIdhardware() {
		return idhardware;
	}

	/**
	 * @param idhardware
	 * @uml.property name="idhardware"
	 */
	public void setIdhardware(Equipo idhardware) {
		this.idhardware = idhardware;
	}

	/**
	 * @return
	 * @uml.property name="idhardware2"
	 */
	public Pieza getIdhardware2() {
		return idhardware2;
	}

	/**
	 * @param idhardware2
	 * @uml.property name="idhardware2"
	 */
	public void setIdhardware2(Pieza idhardware2) {
		this.idhardware2 = idhardware2;
	}

	/**
	 * @return
	 * @uml.property name="idhardware3"
	 */
	public Accesorio getIdhardware3() {
		return idhardware3;
	}

	/**
	 * @param idhardware3
	 * @uml.property name="idhardware3"
	 */
	public void setIdhardware3(Accesorio idhardware3) {
		this.idhardware3 = idhardware3;
	}

}
