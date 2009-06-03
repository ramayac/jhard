/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.ues.jhard.jpa;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author robertux
 */
@Entity
@Table(name = "estadoreserva", catalog = "jhard", schema = "")
@NamedQueries({@NamedQuery(name = "Estadoreserva.findAll", query = "SELECT e FROM Estadoreserva e"), @NamedQuery(name = "Estadoreserva.findByIdestadoreserva", query = "SELECT e FROM Estadoreserva e WHERE e.idestadoreserva = :idestadoreserva"), @NamedQuery(name = "Estadoreserva.findByNombre", query = "SELECT e FROM Estadoreserva e WHERE e.nombre = :nombre")})
public class Estadoreserva implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idestadoreserva", nullable = false)
    private Integer idestadoreserva;
    @Basic(optional = false)
    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idestado")
    private Collection<Reserva> reservaCollection;

    public Estadoreserva() {
    }

    public Estadoreserva(Integer idestadoreserva) {
        this.idestadoreserva = idestadoreserva;
    }

    public Estadoreserva(Integer idestadoreserva, String nombre) {
        this.idestadoreserva = idestadoreserva;
        this.nombre = nombre;
    }

    public Integer getIdestadoreserva() {
        return idestadoreserva;
    }

    public void setIdestadoreserva(Integer idestadoreserva) {
        this.idestadoreserva = idestadoreserva;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Collection<Reserva> getReservaCollection() {
        return reservaCollection;
    }

    public void setReservaCollection(Collection<Reserva> reservaCollection) {
        this.reservaCollection = reservaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idestadoreserva != null ? idestadoreserva.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Estadoreserva)) {
            return false;
        }
        Estadoreserva other = (Estadoreserva) object;
        if ((this.idestadoreserva == null && other.idestadoreserva != null) || (this.idestadoreserva != null && !this.idestadoreserva.equals(other.idestadoreserva))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.ues.jhard.jpa.Estadoreserva[idestadoreserva=" + idestadoreserva + "]";
    }

}
