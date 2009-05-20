package edu.uesocc.jhard.jpa;

import java.io.Serializable;
import java.sql.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * @author robertux
 */
@Entity
public class Solicitud implements Serializable {
	public Solicitud(int idsolicitud, Date fecha, String prioridad,
			String descripcion, Existencia idequipoexistente,
			Equiposimple idequipoexistente2, Usuario idusuario,
			Set<Mantenimiento> mantenimientoCollection) {
		super();
		this.idsolicitud = idsolicitud;
		this.fecha = fecha;
		this.prioridad = prioridad;
		this.descripcion = descripcion;
		this.idequipoexistente = idequipoexistente;
		this.idequipoexistente2 = idequipoexistente2;
		this.idusuario = idusuario;
		this.mantenimientoCollection = mantenimientoCollection;
	}

	/**
	 * @uml.property name="idsolicitud"
	 */
	@Id
	private int idsolicitud;

	/**
	 * @uml.property name="fecha"
	 */
	private Date fecha;

	/**
	 * @uml.property name="prioridad"
	 */
	private String prioridad;

	/**
	 * @uml.property name="descripcion"
	 */
	@Lob
	private String descripcion;

	/**
	 * @uml.property name="idequipoexistente"
	 * @uml.associationEnd
	 */
	@ManyToOne
	@JoinColumn(name = "idequipoexistente")
	private Existencia idequipoexistente;

	/**
	 * @uml.property name="idequipoexistente2"
	 * @uml.associationEnd
	 */
	@ManyToOne
	@JoinColumn(name = "idequipoexistente")
	private Equiposimple idequipoexistente2;

	/**
	 * @uml.property name="idusuario"
	 * @uml.associationEnd
	 */
	@ManyToOne
	@JoinColumn(name = "idusuario")
	private Usuario idusuario;

	/**
	 * @uml.property name="mantenimientoCollection"
	 */
	@OneToMany(mappedBy = "idsolicitud")
	private Set<Mantenimiento> mantenimientoCollection;

	private static final long serialVersionUID = 1L;

	public Solicitud() {
		super();
	}

	/**
	 * @return
	 * @uml.property name="idsolicitud"
	 */
	public int getIdsolicitud() {
		return idsolicitud;
	}

	/**
	 * @param idsolicitud
	 * @uml.property name="idsolicitud"
	 */
	public void setIdsolicitud(int idsolicitud) {
		this.idsolicitud = idsolicitud;
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
	 * @uml.property name="prioridad"
	 */
	public String getPrioridad() {
		return prioridad;
	}

	/**
	 * @param prioridad
	 * @uml.property name="prioridad"
	 */
	public void setPrioridad(String prioridad) {
		this.prioridad = prioridad;
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
	 * @uml.property name="idequipoexistente"
	 */
	public Existencia getIdequipoexistente() {
		return idequipoexistente;
	}

	/**
	 * @param idequipoexistente
	 * @uml.property name="idequipoexistente"
	 */
	public void setIdequipoexistente(Existencia idequipoexistente) {
		this.idequipoexistente = idequipoexistente;
	}

	/**
	 * @return
	 * @uml.property name="idequipoexistente2"
	 */
	public Equiposimple getIdequipoexistente2() {
		return idequipoexistente2;
	}

	/**
	 * @param idequipoexistente2
	 * @uml.property name="idequipoexistente2"
	 */
	public void setIdequipoexistente2(Equiposimple idequipoexistente2) {
		this.idequipoexistente2 = idequipoexistente2;
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
