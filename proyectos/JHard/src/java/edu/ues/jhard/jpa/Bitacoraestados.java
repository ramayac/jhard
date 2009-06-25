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
 * @author robertux
 */
@Entity
@Table(name = "bitacoraestados", catalog = "jhard", schema = "")
@NamedQueries({@NamedQuery(name = "Bitacoraestados.findAll", query = "SELECT b FROM Bitacoraestados b"), 
               @NamedQuery(name = "Bitacoraestados.findByIdbitacora", query = "SELECT b FROM Bitacoraestados b WHERE b.idbitacora = :idbitacora"),
               @NamedQuery(name = "Bitacoraestados.findoByIdEquipoSimple", query = "SELECT b FROM Bitacoraestados b WHERE b.idequiposimple = :idequiposimple ORDER BY b.fecha DESC"),
               @NamedQuery(name = "Bitacoraestados.findByFecha", query = "SELECT b FROM Bitacoraestados b WHERE b.fecha = :fecha")})

public class Bitacoraestados implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idbitacora", nullable = false)
    private Integer idbitacora;
    @Basic(optional = false)
    @Column(name = "fecha", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Basic(optional = false)
    @Lob
    @Column(name = "descripcion", nullable = false, length = 65535)
    private String descripcion;
    @JoinColumn(name = "idestado", referencedColumnName = "idestado", nullable = false)
    @ManyToOne(optional = false)
    private Estadoequipo idestado;
    @JoinColumn(name = "idequipoexistente", referencedColumnName = "idexistencia")
    @ManyToOne
    private Existencia idequipoexistente;
    @JoinColumn(name = "idequiposimple", referencedColumnName = "idEquipoSimple")
    @ManyToOne
    private Equiposimple idequiposimple;

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

    public Estadoequipo getIdestado() {
        return idestado;
    }

    public void setIdestado(Estadoequipo idestado) {
        this.idestado = idestado;
    }

    public Existencia getIdequipoexistente() {
        return idequipoexistente;
    }

    public void setIdequipoexistente(Existencia idequipoexistente) {
        this.idequipoexistente = idequipoexistente;
    }

    public Equiposimple getIdequiposimple() {
        return idequiposimple;
    }

    public void setIdequiposimple(Equiposimple idequiposimple) {
        this.idequiposimple = idequiposimple;
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
        return "edu.ues.jhard.jpa.Bitacoraestados[idbitacora=" + idbitacora + "]";
    }

}
