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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Hugol
 */
@Entity
@Table(name = "pieza")
@NamedQueries({@NamedQuery(name = "Pieza.findAll", query = "SELECT p FROM Pieza p"), @NamedQuery(name = "Pieza.findByIdpieza", query = "SELECT p FROM Pieza p WHERE p.idpieza = :idpieza"), @NamedQuery(name = "Pieza.findByNombre", query = "SELECT p FROM Pieza p WHERE p.nombre = :nombre"), @NamedQuery(name = "Pieza.findByModelo", query = "SELECT p FROM Pieza p WHERE p.modelo = :modelo")})
public class Pieza implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idpieza")
    private Integer idpieza;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "modelo")
    private String modelo;
    @JoinColumn(name = "idclasificacion", referencedColumnName = "idclasificacion")
    @ManyToOne(optional = false)
    private Clasificacion idclasificacion;
    @JoinColumn(name = "idequipo", referencedColumnName = "idequipo")
    @ManyToOne
    private Equipo idequipo;
    @JoinColumn(name = "idmarca", referencedColumnName = "idmarca")
    @ManyToOne(optional = false)
    private Marca idmarca;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idhardware2")
    private List<Atributohardware> atributohardwareCollection;

    public Pieza() {
    }

    public Pieza(Integer idpieza) {
        this.idpieza = idpieza;
    }

    public Pieza(Integer idpieza, String nombre, String modelo) {
        this.idpieza = idpieza;
        this.nombre = nombre;
        this.modelo = modelo;
    }

    public Integer getIdpieza() {
        return idpieza;
    }

    public void setIdpieza(Integer idpieza) {
        this.idpieza = idpieza;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Clasificacion getIdclasificacion() {
        return idclasificacion;
    }

    public void setIdclasificacion(Clasificacion idclasificacion) {
        this.idclasificacion = idclasificacion;
    }

    public Equipo getIdequipo() {
        return idequipo;
    }

    public void setIdequipo(Equipo idequipo) {
        this.idequipo = idequipo;
    }

    public Marca getIdmarca() {
        return idmarca;
    }

    public void setIdmarca(Marca idmarca) {
        this.idmarca = idmarca;
    }

    public List<Atributohardware> getAtributohardwareCollection() {
        return atributohardwareCollection;
    }

    public void setAtributohardwareCollection(List<Atributohardware> atributohardwareCollection) {
        this.atributohardwareCollection = atributohardwareCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idpieza != null ? idpieza.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pieza)) {
            return false;
        }
        Pieza other = (Pieza) object;
        if ((this.idpieza == null && other.idpieza != null) || (this.idpieza != null && !this.idpieza.equals(other.idpieza))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "JPA.Pieza[idpieza=" + idpieza + "]";
    }

}
