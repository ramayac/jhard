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
import javax.persistence.Lob;
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
@Table(name = "equiposimple", catalog = "jhard", schema = "")
@NamedQueries({@NamedQuery(name = "Equiposimple.findAll", query = "SELECT e FROM Equiposimple e"), @NamedQuery(name = "Equiposimple.findByIdEquipoSimple", query = "SELECT e FROM Equiposimple e WHERE e.idEquipoSimple = :idEquipoSimple"), @NamedQuery(name = "Equiposimple.findByPropietario", query = "SELECT e FROM Equiposimple e WHERE e.propietario = :propietario")})
public class Equiposimple implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idEquipoSimple", nullable = false)
    private Integer idEquipoSimple;
    @Basic(optional = false)
    @Lob
    @Column(name = "descripcion", nullable = false, length = 65535)
    private String descripcion;
    @Basic(optional = false)
    @Column(name = "propietario", nullable = false, length = 200)
    private String propietario;
    @JoinColumn(name = "idestado", referencedColumnName = "idestado", nullable = false)
    @ManyToOne(optional = false)
    private Estadoequipo idestado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idequipoexistente1")
    private List<Solicitud> solicitudCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idequipoexistente1")
    private List<Bitacoraestados> bitacoraestadosCollection;

    public Equiposimple() {
    }

    public Equiposimple(Integer idEquipoSimple) {
        this.idEquipoSimple = idEquipoSimple;
    }

    public Equiposimple(Integer idEquipoSimple, String descripcion, String propietario) {
        this.idEquipoSimple = idEquipoSimple;
        this.descripcion = descripcion;
        this.propietario = propietario;
    }

    public Integer getIdEquipoSimple() {
        return idEquipoSimple;
    }

    public void setIdEquipoSimple(Integer idEquipoSimple) {
        this.idEquipoSimple = idEquipoSimple;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getPropietario() {
        return propietario;
    }

    public void setPropietario(String propietario) {
        this.propietario = propietario;
    }

    public Estadoequipo getIdestado() {
        return idestado;
    }

    public void setIdestado(Estadoequipo idestado) {
        this.idestado = idestado;
    }

    public List<Solicitud> getSolicitudCollection() {
        return solicitudCollection;
    }

    public void setSolicitudCollection(List<Solicitud> solicitudCollection) {
        this.solicitudCollection = solicitudCollection;
    }

    public List<Bitacoraestados> getBitacoraestadosCollection() {
        return bitacoraestadosCollection;
    }

    public void setBitacoraestadosCollection(List<Bitacoraestados> bitacoraestadosCollection) {
        this.bitacoraestadosCollection = bitacoraestadosCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEquipoSimple != null ? idEquipoSimple.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Equiposimple)) {
            return false;
        }
        Equiposimple other = (Equiposimple) object;
        if ((this.idEquipoSimple == null && other.idEquipoSimple != null) || (this.idEquipoSimple != null && !this.idEquipoSimple.equals(other.idEquipoSimple))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.ues.jhard.jpa.Equiposimple[idEquipoSimple=" + idEquipoSimple + "]";
    }

}
