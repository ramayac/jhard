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
@Table(name = "software", catalog = "jhard", schema = "")
@NamedQueries({@NamedQuery(name = "Software.findAll", query = "SELECT s FROM Software s"), @NamedQuery(name = "Software.findByIdsoftware", query = "SELECT s FROM Software s WHERE s.idsoftware = :idsoftware"), @NamedQuery(name = "Software.findByNombre", query = "SELECT s FROM Software s WHERE s.nombre = :nombre"), @NamedQuery(name = "Software.findByVersion", query = "SELECT s FROM Software s WHERE s.version = :version"), @NamedQuery(name = "Software.findByCodigolicencia", query = "SELECT s FROM Software s WHERE s.codigolicencia = :codigolicencia"), @NamedQuery(name = "Software.findByCantidadlicencias", query = "SELECT s FROM Software s WHERE s.cantidadlicencias = :cantidadlicencias")})
public class Software implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idsoftware", nullable = false)
    private Integer idsoftware;
    @Basic(optional = false)
    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;
    @Basic(optional = false)
    @Column(name = "version", nullable = false, length = 15)
    private String version;
    @Column(name = "codigolicencia", length = 45)
    private String codigolicencia;
    @Column(name = "cantidadlicencias")
    private Integer cantidadlicencias;
    @JoinColumn(name = "idclasificacion", referencedColumnName = "idclasificacion", nullable = false)
    @ManyToOne(optional = false)
    private Clasificacion idclasificacion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idsoftware")
    private Collection<Instalacion> instalacionCollection;

    public Software() {
    }

    public Software(Integer idsoftware) {
        this.idsoftware = idsoftware;
    }

    public Software(Integer idsoftware, String nombre, String version) {
        this.idsoftware = idsoftware;
        this.nombre = nombre;
        this.version = version;
    }

    public Integer getIdsoftware() {
        return idsoftware;
    }

    public void setIdsoftware(Integer idsoftware) {
        this.idsoftware = idsoftware;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getCodigolicencia() {
        return codigolicencia;
    }

    public void setCodigolicencia(String codigolicencia) {
        this.codigolicencia = codigolicencia;
    }

    public Integer getCantidadlicencias() {
        return cantidadlicencias;
    }

    public void setCantidadlicencias(Integer cantidadlicencias) {
        this.cantidadlicencias = cantidadlicencias;
    }

    public Clasificacion getIdclasificacion() {
        return idclasificacion;
    }

    public void setIdclasificacion(Clasificacion idclasificacion) {
        this.idclasificacion = idclasificacion;
    }

    public Collection<Instalacion> getInstalacionCollection() {
        return instalacionCollection;
    }

    public void setInstalacionCollection(Collection<Instalacion> instalacionCollection) {
        this.instalacionCollection = instalacionCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idsoftware != null ? idsoftware.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Software)) {
            return false;
        }
        Software other = (Software) object;
        if ((this.idsoftware == null && other.idsoftware != null) || (this.idsoftware != null && !this.idsoftware.equals(other.idsoftware))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.ues.jhard.jpa.Software[idsoftware=" + idsoftware + "]";
    }

}
