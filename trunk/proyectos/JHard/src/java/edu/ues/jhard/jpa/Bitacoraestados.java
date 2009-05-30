/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.ues.jhard.jpa;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Hugol
 */
@Entity
@Table(name = "bitacoraestados")
@NamedQueries({@NamedQuery(name = "Bitacoraestados.findAll", query = "SELECT b FROM Bitacoraestados b"), @NamedQuery(name = "Bitacoraestados.findByIdbitacora", query = "SELECT b FROM Bitacoraestados b WHERE b.idbitacora = :idbitacora"), @NamedQuery(name = "Bitacoraestados.findByFecha", query = "SELECT b FROM Bitacoraestados b WHERE b.fecha = :fecha")})
public class Bitacoraestados implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idbitacora")
    private Integer idbitacora;
    @Basic(optional = false)
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Basic(optional = false)
    @Lob
    @Column(name = "descripcion")
    private String descripcion;
    @JoinColumn(name = "idequipoexistente", referencedColumnName = "idexistencia")
    @ManyToOne(optional = false)
    private Existencia idequipoexistente;
    @JoinColumn(name = "idequipoexistente", referencedColumnName = "idEquipoSimple")
    @ManyToOne(optional = false)
    private Equiposimple idequipoexistente1;
    @JoinColumn(name = "idestado", referencedColumnName = "idestado")
    @ManyToOne(optional = false)
    private Estadoequipo idestado;

    public Bitacoraestados() {
    }

    public Bitacoraestados(Integer idbitacora) {
        this.idbitacora = idbitacora;
    }

    public Bitacoraestados(Integer idbitacora, Date fecha, String descripcion) {
        this.idbitacora = idbitacora;
        this.fecha = fecha;
        this.descripcion = descripcion;
    }

    public Integer getIdbitacora() {
        return idbitacora;
    }

    public void setIdbitacora(Integer idbitacora) {
        this.idbitacora = idbitacora;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Existencia getIdequipoexistente() {
        return idequipoexistente;
    }

    public void setIdequipoexistente(Existencia idequipoexistente) {
        this.idequipoexistente = idequipoexistente;
    }

    public Equiposimple getIdequipoexistente1() {
        return idequipoexistente1;
    }

    public void setIdequipoexistente1(Equiposimple idequipoexistente1) {
        this.idequipoexistente1 = idequipoexistente1;
    }

    public Estadoequipo getIdestado() {
        return idestado;
    }

    public void setIdestado(Estadoequipo idestado) {
        this.idestado = idestado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idbitacora != null ? idbitacora.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Bitacoraestados)) {
            return false;
        }
        Bitacoraestados other = (Bitacoraestados) object;
        if ((this.idbitacora == null && other.idbitacora != null) || (this.idbitacora != null && !this.idbitacora.equals(other.idbitacora))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "JPA.Bitacoraestados[idbitacora=" + idbitacora + "]";
    }

}
