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
public class Estudiante implements Serializable {
	public Estudiante(int idestudiante, String carnet, String apellidos,
			String nombres, int visible, Usuario idusuario,
			Set<Inscripcion> inscripcionCollection,
			Set<Asistencia> asistenciaCollection) {
		super();
		this.idestudiante = idestudiante;
		this.carnet = carnet;
		this.apellidos = apellidos;
		this.nombres = nombres;
		this.visible = visible;
		this.idusuario = idusuario;
		this.inscripcionCollection = inscripcionCollection;
		this.asistenciaCollection = asistenciaCollection;
	}

	/**
	 * @uml.property name="idestudiante"
	 */
	@Id
	private int idestudiante;

	/**
	 * @uml.property name="carnet"
	 */
	private String carnet;

	/**
	 * @uml.property name="apellidos"
	 */
	private String apellidos;

	/**
	 * @uml.property name="nombres"
	 */
	private String nombres;

	/**
	 * @uml.property name="visible"
	 */
	private int visible;

	/**
	 * @uml.property name="idusuario"
	 * @uml.associationEnd
	 */
	@ManyToOne
	@JoinColumn(name = "idusuario")
	private Usuario idusuario;

	/**
	 * @uml.property name="inscripcionCollection"
	 */
	@OneToMany(mappedBy = "idestudiante")
	private Set<Inscripcion> inscripcionCollection;

	/**
	 * @uml.property name="asistenciaCollection"
	 */
	@OneToMany(mappedBy = "idestudiante")
	private Set<Asistencia> asistenciaCollection;

	private static final long serialVersionUID = 1L;

	public Estudiante() {
		super();
	}

	/**
	 * @return
	 * @uml.property name="idestudiante"
	 */
	public int getIdestudiante() {
		return idestudiante;
	}

	/**
	 * @param idestudiante
	 * @uml.property name="idestudiante"
	 */
	public void setIdestudiante(int idestudiante) {
		this.idestudiante = idestudiante;
	}

	/**
	 * @return
	 * @uml.property name="carnet"
	 */
	public String getCarnet() {
		return carnet;
	}

	/**
	 * @param carnet
	 * @uml.property name="carnet"
	 */
	public void setCarnet(String carnet) {
		this.carnet = carnet;
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
	 * @uml.property name="idusuario"
	 */
	public Usuario getIdusuario() {
		return idusuario;
	}

	/**
	 * @param idusuario
	 * @uml.property name="idusuario"
	 */
	public void setIdusuario(Usuario idusuario) {
		this.idusuario = idusuario;
	}

	/**
	 * @return
	 * @uml.property name="inscripcionCollection"
	 */
	public Set<Inscripcion> getInscripcionCollection() {
		return inscripcionCollection;
	}

	/**
	 * @param inscripcionCollection
	 * @uml.property name="inscripcionCollection"
	 */
	public void setInscripcionCollection(Set<Inscripcion> inscripcionCollection) {
		this.inscripcionCollection = inscripcionCollection;
	}

	/**
	 * @return
	 * @uml.property name="asistenciaCollection"
	 */
	public Set<Asistencia> getAsistenciaCollection() {
		return asistenciaCollection;
	}

	/**
	 * @param asistenciaCollection
	 * @uml.property name="asistenciaCollection"
	 */
	public void setAsistenciaCollection(Set<Asistencia> asistenciaCollection) {
		this.asistenciaCollection = asistenciaCollection;
	}

}
