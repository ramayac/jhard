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
public class Tecnico implements Serializable {
	public Tecnico(int idtecnico, String apellidos, String nombres,
			String cargo, Set<Mantenimiento> mantenimientoCollection) {
		super();
		this.idtecnico = idtecnico;
		this.apellidos = apellidos;
		this.nombres = nombres;
		this.cargo = cargo;
		this.mantenimientoCollection = mantenimientoCollection;
	}

	/**
	 * @uml.property name="idtecnico"
	 */
	@Id
	private int idtecnico;

	/**
	 * @uml.property name="apellidos"
	 */
	private String apellidos;

	/**
	 * @uml.property name="nombres"
	 */
	private String nombres;

	/**
	 * @uml.property name="cargo"
	 */
	private String cargo;

	/**
	 * @uml.property name="mantenimientoCollection"
	 */
	@OneToMany(mappedBy = "idtecnico")
	private Set<Mantenimiento> mantenimientoCollection;

	private static final long serialVersionUID = 1L;

	public Tecnico() {
		super();
	}

	/**
	 * @return
	 * @uml.property name="idtecnico"
	 */
	public int getIdtecnico() {
		return idtecnico;
	}

	/**
	 * @param idtecnico
	 * @uml.property name="idtecnico"
	 */
	public void setIdtecnico(int idtecnico) {
		this.idtecnico = idtecnico;
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
	 * @uml.property name="cargo"
	 */
	public String getCargo() {
		return cargo;
	}

	/**
	 * @param cargo
	 * @uml.property name="cargo"
	 */
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	/**
	 * @return
	 * @uml.property name="mantenimientoCollection"
	 */
	public Set<Mantenimiento> getMantenimientoCollection() {
		return mantenimientoCollection;
	}

	/**
	 * @param mantenimientoCollection
	 * @uml.property name="mantenimientoCollection"
	 */
	public void setMantenimientoCollection(
			Set<Mantenimiento> mantenimientoCollection) {
		this.mantenimientoCollection = mantenimientoCollection;
	}

}
