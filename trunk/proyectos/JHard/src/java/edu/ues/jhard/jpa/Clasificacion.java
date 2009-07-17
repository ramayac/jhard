/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.ues.jhard.jpa;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author robertux
 */
@Entity
@Table(name = "clasificacion", catalog = "jhard", schema = "")
@NamedQueries({@NamedQuery(name = "Clasificacion.findAll", query = "SELECT c FROM Clasificacion c"), @NamedQuery(name = "Clasificacion.findByIdclasificacion", query = "SELECT c FROM Clasificacion c WHERE c.idclasificacion = :idclasificacion"), @NamedQuery(name = "Clasificacion.findByNombre", query = "SELECT c FROM Clasificacion c WHERE c.nombre = :nombre"), @NamedQuery(name = "Clasificacion.findByIdsuperior", query = "SELECT c FROM Clasificacion c WHERE c.idsuperior = :idsuperior")})
public class Clasificacion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idclasificacion", nullable = false)
    private Integer idclasificacion;
    @Basic(optional = false)
    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;
    @Lob
    @Column(name = "descripcion", length = 65535)
    private String descripcion;
    @Column(name = "idsuperior")
    private Integer idsuperior;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idclasificacion")
    private Collection<Accesorio> accesorioCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idclasificacion")
    private Collection<Software> softwareCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idclasificacion")
    private Collection<Equipo> equipoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idclasificacion")
    private Collection<Pieza> piezaCollection;

    public Clasificacion() {
    }

    public Clasificacion(Integer idclasificacion) {
        this.idclasificacion = idclasificacion;
    }

    public Clasificacion(Integer idclasificacion, String nombre) {
        this.idclasificacion = idclasificacion;
        this.nombre = nombre;
    }

    public Integer getIdclasificacion() {
        return idclasificacion;
    }

    public void setIdclasificacion(Integer idclasificacion) {
        this.idclasificacion = idclasificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getIdsuperior() {
        return idsuperior;
    }

    public void setIdsuperior(Integer idsuperior) {
        this.idsuperior = idsuperior;
    }

    public Collection<Accesorio> getAccesorioCollection() {
        return accesorioCollection;
    }

    public void setAccesorioCollection(Collection<Accesorio> accesorioCollection) {
        this.accesorioCollection = accesorioCollection;
    }

    public Collection<Software> getSoftwareCollection() {
        return softwareCollection;
    }

    public void setSoftwareCollection(Collection<Software> softwareCollection) {
        this.softwareCollection = softwareCollection;
    }

    public Collection<Equipo> getEquipoCollection() {
        return equipoCollection;
    }

    public void setEquipoCollection(Collection<Equipo> equipoCollection) {
        this.equipoCollection = equipoCollection;
    }

    public Collection<Pieza> getPiezaCollection() {
        return piezaCollection;
    }

    public void setPiezaCollection(Collection<Pieza> piezaCollection) {
        this.piezaCollection = piezaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idclasificacion != null ? idclasificacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Clasificacion)) {
            return false;
        }
        Clasificacion other = (Clasificacion) object;
        if ((this.idclasificacion == null && other.idclasificacion != null) || (this.idclasificacion != null && !this.idclasificacion.equals(other.idclasificacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.ues.jhard.jpa.Clasificacion[idclasificacion=" + idclasificacion + "]";
    }

    public List<Existencia> getExistenciaCollection(){
        List<Existencia> listaExistenciaTodosEquipos = new ArrayList<Existencia>();
        for(Equipo eq: this.equipoCollection){
            listaExistenciaTodosEquipos.addAll(eq.getExistenciaCollection());
        }
        return listaExistenciaTodosEquipos;
    }

}
