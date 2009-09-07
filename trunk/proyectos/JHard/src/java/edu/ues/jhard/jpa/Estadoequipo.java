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
@Table(name = "estadoequipo", catalog = "jhard", schema = "")
@NamedQueries({@NamedQuery(name = "Estadoequipo.findAll", query = "SELECT e FROM Estadoequipo e"), 
               @NamedQuery(name = "Estadoequipo.findByIdestado", query = "SELECT e FROM Estadoequipo e WHERE e.idestado = :idestado"),
               @NamedQuery(name = "Estadoequipo.findByNombre", query = "SELECT e FROM Estadoequipo e WHERE e.nombre = :nombre")})
public class Estadoequipo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idestado", nullable = false)
    private Integer idestado;
    @Basic(optional = false)
    @Column(name = "nombre", nullable = false, length = 45)
    private String nombre;
    @Lob
    @Column(name = "descripcion", length = 65535)
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idestado")
    private Collection<Equiposimple> equiposimpleCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idestado")
    private Collection<Existencia> existenciaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idestado")
    private Collection<Bitacoraestados> bitacoraestadosCollection;

    public Estadoequipo() {
    }

    public Estadoequipo(Integer idestado) {
        this.idestado = idestado;
    }

    public Estadoequipo(Integer idestado, String nombre) {
        this.idestado = idestado;
        this.nombre = nombre;
    }

    public Integer getIdestado() {
        return idestado;
    }

    public void setIdestado(Integer idestado) {
        this.idestado = idestado;
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

    public Collection<Equiposimple> getEquiposimpleCollection() {
        return equiposimpleCollection;
    }

    public void setEquiposimpleCollection(Collection<Equiposimple> equiposimpleCollection) {
        this.equiposimpleCollection = equiposimpleCollection;
    }

    public Collection<Existencia> getExistenciaCollection() {
        return existenciaCollection;
    }

    public void setExistenciaCollection(Collection<Existencia> existenciaCollection) {
        this.existenciaCollection = existenciaCollection;
    }

    public Collection<Bitacoraestados> getBitacoraestadosCollection() {
        return bitacoraestadosCollection;
    }

    public void setBitacoraestadosCollection(Collection<Bitacoraestados> bitacoraestadosCollection) {
        this.bitacoraestadosCollection = bitacoraestadosCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idestado != null ? idestado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Estadoequipo)) {
            return false;
        }
        Estadoequipo other = (Estadoequipo) object;
        if ((this.idestado == null && other.idestado != null) || (this.idestado != null && !this.idestado.equals(other.idestado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.ues.jhard.jpa.Estadoequipo[idestado=" + idestado + "]";
    }

    public String getImagenEstado(){
        String imgEstado = "";
        if(this.getIdestado() == 1)
            return "imgEstable.png";
        if(this.getIdestado() == 2)
            return "imgFallido.png";
        if(this.getIdestado() == 3)
            return "imgEnReparacion.png";
        if(this.getIdestado() == 4)
            return "imgDeteriorado.png";
        return imgEstado;
    }

}
