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
@Table(name = "marca")
@NamedQueries({@NamedQuery(name = "Marca.findAll", query = "SELECT m FROM Marca m"), @NamedQuery(name = "Marca.findByIdmarca", query = "SELECT m FROM Marca m WHERE m.idmarca = :idmarca"), @NamedQuery(name = "Marca.findByNombre", query = "SELECT m FROM Marca m WHERE m.nombre = :nombre")})
public class Marca implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idmarca")
    private Integer idmarca;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idmarca")
    private List<Accesorio> accesorioCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idmarca")
    private List<Equipo> equipoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idmarca")
    private List<Pieza> piezaCollection;

    public Marca() {
    }

    public Marca(Integer idmarca) {
        this.idmarca = idmarca;
    }

    public Marca(Integer idmarca, String nombre) {
        this.idmarca = idmarca;
        this.nombre = nombre;
    }

    public Integer getIdmarca() {
        return idmarca;
    }

    public void setIdmarca(Integer idmarca) {
        this.idmarca = idmarca;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Accesorio> getAccesorioCollection() {
        return accesorioCollection;
    }

    public void setAccesorioCollection(List<Accesorio> accesorioCollection) {
        this.accesorioCollection = accesorioCollection;
    }

    public List<Equipo> getEquipoCollection() {
        return equipoCollection;
    }

    public void setEquipoCollection(List<Equipo> equipoCollection) {
        this.equipoCollection = equipoCollection;
    }

    public List<Pieza> getPiezaCollection() {
        return piezaCollection;
    }

    public void setPiezaCollection(List<Pieza> piezaCollection) {
        this.piezaCollection = piezaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idmarca != null ? idmarca.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Marca)) {
            return false;
        }
        Marca other = (Marca) object;
        if ((this.idmarca == null && other.idmarca != null) || (this.idmarca != null && !this.idmarca.equals(other.idmarca))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "JPA.Marca[idmarca=" + idmarca + "]";
    }

}
