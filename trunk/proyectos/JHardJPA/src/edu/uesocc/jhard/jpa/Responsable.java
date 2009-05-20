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
public class Responsable implements Serializable {
	public Responsable(int idresponsable, String apellidos, String nombres,
			String tipodocumento, String valordocumento, int visible,
			Set<Reserva> reservaCollection) {
		super();
		this.idresponsable = idresponsable;
		this.apellidos = apellidos;
		this.nombres = nombres;
		this.tipodocumento = tipodocumento;
		this.valordocumento = valordocumento;
		this.visible = visible;
		this.reservaCollection = reservaCollection;
	}

	/**
	 * @uml.property name="idresponsable"
	 */
	@Id
	private int idresponsable;

	/**
	 * @uml.property name="apellidos"
	 */
	private String apellidos;

	/**
	 * @uml.property name="nombres"
	 */
	private String nombres;

	/**
	 * @uml.property name="tipodocumento"
	 */
	private String tipodocumento;

	/**
	 * @uml.property name="valordocumento"
	 */
	private String valordocumento;

	/**
	 * @uml.property name="visible"
	 */
	private int visible;

	/**
	 * @uml.property name="reservaCollection"
	 */
	@OneToMany(mappedBy = "idresponsable")
	private Set<Reserva> reservaCollection;

	private static final long serialVersionUID = 1L;

	public Responsable() {
		super();
	}

	/**
	 * @return
	 * @uml.property name="idresponsable"
	 */
	public int getIdresponsable() {
		return idresponsable;
	}

	/**
	 * @param idresponsable
	 * @uml.property name="idresponsable"
	 */
	public void setIdresponsable(int idresponsable) {
		this.idresponsable = idresponsable;
	}

	/**
	 * @return
	 * @uml.property name="apellidos"
	 */
	public String getApellidos() {
		return apellidos;
	}

	/**
	 * @param apellidos
	 * @uml.property name="apellidos"
	 */
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	/**
	 * @return
	 * @uml.property name="nombres"
	 */
	public String getNombres() {
		return nombres;
	}

	/**
	 * @param nombres
	 * @uml.property name="nombres"
	 */
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	/**
	 * @return
	 * @uml.property name="tipodocumento"
	 */
	public String getTipodocumento() {
		return tipodocumento;
	}

	/**
	 * @param tipodocumento
	 * @uml.property name="tipodocumento"
	 */
	public void setTipodocumento(String tipodocumento) {
		this.tipodocumento = tipodocumento;
	}

	/**
	 * @return
	 * @uml.property name="valordocumento"
	 */
	public String getValordocumento() {
		return valordocumento;
	}

	/**
	 * @param valordocumento
	 * @uml.property name="valordocumento"
	 */
	public void setValordocumento(String valordocumento) {
		this.valordocumento = valordocumento;
	}

	/**
	 * @return
	 * @uml.property name="visible"
	 */
	public int getVisible() {
		return visible;
	}

	/**
	 * @param visible
	 * @uml.property name="visible"
	 */
	public void setVisible(int visible) {
		this.visible = visible;
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
