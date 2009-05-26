/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package JPA;

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
@Table(name = "accesorio")
@NamedQueries({@NamedQuery(name = "Accesorio.findAll", query = "SELECT a FROM Accesorio a"), @NamedQuery(name = "Accesorio.findByIdaccesorio", query = "SELECT a FROM Accesorio a WHERE a.idaccesorio = :idaccesorio"), @NamedQuery(name = "Accesorio.findByNombre", query = "SELECT a FROM Accesorio a WHERE a.nombre = :nombre"), @NamedQuery(name = "Accesorio.findByModelo", query = "SELECT a FROM Accesorio a WHERE a.modelo = :modelo")})
public class Accesorio implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idaccesorio")
    private Integer idaccesorio;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idhardware")
    private List<Atributohardware> atributohardwareCollection;

    public Accesorio() {
    }

    public Accesorio(Integer idaccesorio) {
        this.idaccesorio = idaccesorio;
    }

    public Accesorio(Integer idaccesorio, String nombre, String modelo) {
        this.idaccesorio = idaccesorio;
        this.nombre = nombre;
        this.modelo = modelo;
    }

    public Integer getIdaccesorio() {
        return idaccesorio;
    }

    public void setIdaccesorio(Integer idaccesorio) {
        this.idaccesorio = idaccesorio;
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
        hash += (idaccesorio != null ? idaccesorio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Accesorio)) {
            return false;
        }
        Accesorio other = (Accesorio) object;
        if ((this.idaccesorio == null && other.idaccesorio != null) || (this.idaccesorio != null && !this.idaccesorio.equals(other.idaccesorio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "JPA.Accesorio[idaccesorio=" + idaccesorio + "]";
    }

}
