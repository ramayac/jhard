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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author robertux
 */
@Entity
@Table(name = "equipo", catalog = "jhard", schema = "")
@NamedQueries({@NamedQuery(name = "Equipo.findAll", query = "SELECT e FROM Equipo e"), @NamedQuery(name = "Equipo.findByIdequipo", query = "SELECT e FROM Equipo e WHERE e.idequipo = :idequipo"), @NamedQuery(name = "Equipo.findByNombre", query = "SELECT e FROM Equipo e WHERE e.nombre = :nombre"), @NamedQuery(name = "Equipo.findByModelo", query = "SELECT e FROM Equipo e WHERE e.modelo = :modelo")})
public class Equipo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idequipo", nullable = false)
    private Integer idequipo;
    @Basic(optional = false)
    @Column(name = "nombre", nullable = false, length = 45)
    private String nombre;
    @Basic(optional = false)
    @Column(name = "modelo", nullable = false, length = 15)
    private String modelo;
    @OneToMany(mappedBy = "idequipo")
    private Collection<Accesorio> accesorioCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idhardware")
    private Collection<Existencia> existenciaCollection;
    @JoinColumn(name = "idmarca", referencedColumnName = "idmarca", nullable = false)
    @ManyToOne(optional = false)
    private Marca idmarca;
    @JoinColumn(name = "idclasificacion", referencedColumnName = "idclasificacion", nullable = false)
    @ManyToOne(optional = false)
    private Clasificacion idclasificacion;
    @OneToMany(mappedBy = "idequipo")
    private Collection<Pieza> piezaCollection;
    @OneToMany(mappedBy = "idhardware")
    private Collection<Atributohardware> atributohardwareCollection;

    public Equipo() {
    }

    public Equipo(Integer idequipo) {
        this.idequipo = idequipo;
    }

    public Equipo(Integer idequipo, String nombre, String modelo) {
        this.idequipo = idequipo;
        this.nombre = nombre;
        this.modelo = modelo;
    }

    public Integer getIdequipo() {
        return idequipo;
    }

    public void setIdequipo(Integer idequipo) {
        this.idequipo = idequipo;
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

    public Collection<Accesorio> getAccesorioCollection() {
        return accesorioCollection;
    }

    public void setAccesorioCollection(Collection<Accesorio> accesorioCollection) {
        this.accesorioCollection = accesorioCollection;
    }

    public Collection<Existencia> getExistenciaCollection() {
        return existenciaCollection;
    }

    public void setExistenciaCollection(Collection<Existencia> existenciaCollection) {
        this.existenciaCollection = existenciaCollection;
    }

    public Marca getIdmarca() {
        return idmarca;
    }

    public void setIdmarca(Marca idmarca) {
        this.idmarca = idmarca;
    }

    public Clasificacion getIdclasificacion() {
        return idclasificacion;
    }

    public void setIdclasificacion(Clasificacion idclasificacion) {
        this.idclasificacion = idclasificacion;
    }

    public Collection<Pieza> getPiezaCollection() {
        return piezaCollection;
    }

    public void setPiezaCollection(Collection<Pieza> piezaCollection) {
        this.piezaCollection = piezaCollection;
    }

    public Collection<Atributohardware> getAtributohardwareCollection() {
        return atributohardwareCollection;
    }

    public void setAtributohardwareCollection(Collection<Atributohardware> atributohardwareCollection) {
        this.atributohardwareCollection = atributohardwareCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idequipo != null ? idequipo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Equipo)) {
            return false;
        }
        Equipo other = (Equipo) object;
        if ((this.idequipo == null && other.idequipo != null) || (this.idequipo != null && !this.idequipo.equals(other.idequipo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.ues.jhard.jpa.Equipo[idequipo=" + idequipo + "]";
    }

    public int getExistenciaSize(){
        return this.getExistenciaCollection().size();
    }

}
