/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.ues.jhard.jpa;

import java.io.Serializable;
import java.util.List;
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
 * @author Hugol
 */
@Entity
@Table(name = "ubicacion")
@NamedQueries({@NamedQuery(name = "Ubicacion.findAll", query = "SELECT u FROM Ubicacion u"), @NamedQuery(name = "Ubicacion.findByIdubicacion", query = "SELECT u FROM Ubicacion u WHERE u.idubicacion = :idubicacion"), @NamedQuery(name = "Ubicacion.findByNombre", query = "SELECT u FROM Ubicacion u WHERE u.nombre = :nombre")})
public class Ubicacion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idubicacion")
    private Integer idubicacion;
    @Column(name = "nombre")
    private String nombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idaula")
    private List<Horario> horarioCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idubicacion")
    private List<Existencia> existenciaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idubicacion")
    private List<Reserva> reservaCollection;

    public Ubicacion() {
    }

    public Ubicacion(Integer idubicacion) {
        this.idubicacion = idubicacion;
    }

    public Integer getIdubicacion() {
        return idubicacion;
    }

    public void setIdubicacion(Integer idubicacion) {
        this.idubicacion = idubicacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Horario> getHorarioCollection() {
        return horarioCollection;
    }

    public void setHorarioCollection(List<Horario> horarioCollection) {
        this.horarioCollection = horarioCollection;
    }

    public List<Existencia> getExistenciaCollection() {
        return existenciaCollection;
    }

    public void setExistenciaCollection(List<Existencia> existenciaCollection) {
        this.existenciaCollection = existenciaCollection;
    }

    public List<Reserva> getReservaCollection() {
        return reservaCollection;
    }

    public void setReservaCollection(List<Reserva> reservaCollection) {
        this.reservaCollection = reservaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idubicacion != null ? idubicacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ubicacion)) {
            return false;
        }
        Ubicacion other = (Ubicacion) object;
        if ((this.idubicacion == null && other.idubicacion != null) || (this.idubicacion != null && !this.idubicacion.equals(other.idubicacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "JPA.Ubicacion[idubicacion=" + idubicacion + "]";
    }

}
