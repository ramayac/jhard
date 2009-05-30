/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.ues.jhard.jpa;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Hugol
 */
@Entity
@Table(name = "adquisicion")
@NamedQueries({@NamedQuery(name = "Adquisicion.findAll", query = "SELECT a FROM Adquisicion a"), @NamedQuery(name = "Adquisicion.findByIdadquisicion", query = "SELECT a FROM Adquisicion a WHERE a.idadquisicion = :idadquisicion"), @NamedQuery(name = "Adquisicion.findByFecha", query = "SELECT a FROM Adquisicion a WHERE a.fecha = :fecha"), @NamedQuery(name = "Adquisicion.findByPrecio", query = "SELECT a FROM Adquisicion a WHERE a.precio = :precio"), @NamedQuery(name = "Adquisicion.findByProveedor", query = "SELECT a FROM Adquisicion a WHERE a.proveedor = :proveedor")})
public class Adquisicion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idadquisicion")
    private Integer idadquisicion;
    @Basic(optional = false)
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Basic(optional = false)
    @Column(name = "precio")
    private double precio;
    @Lob
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "proveedor")
    private String proveedor;
    @OneToMany(mappedBy = "idadquisicion")
    private List<Software> softwareCollection;
    @OneToMany(mappedBy = "idadquisicion")
    private List<Existencia> existenciaCollection;

    public Adquisicion() {
    }

    public Adquisicion(Integer idadquisicion) {
        this.idadquisicion = idadquisicion;
    }

    public Adquisicion(Integer idadquisicion, Date fecha, double precio) {
        this.idadquisicion = idadquisicion;
        this.fecha = fecha;
        this.precio = precio;
    }

    public Integer getIdadquisicion() {
        return idadquisicion;
    }

    public void setIdadquisicion(Integer idadquisicion) {
        this.idadquisicion = idadquisicion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    public List<Software> getSoftwareCollection() {
        return softwareCollection;
    }

    public void setSoftwareCollection(List<Software> softwareCollection) {
        this.softwareCollection = softwareCollection;
    }

    public List<Existencia> getExistenciaCollection() {
        return existenciaCollection;
    }

    public void setExistenciaCollection(List<Existencia> existenciaCollection) {
        this.existenciaCollection = existenciaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idadquisicion != null ? idadquisicion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Adquisicion)) {
            return false;
        }
        Adquisicion other = (Adquisicion) object;
        if ((this.idadquisicion == null && other.idadquisicion != null) || (this.idadquisicion != null && !this.idadquisicion.equals(other.idadquisicion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "JPA.Adquisicion[idadquisicion=" + idadquisicion + "]";
    }

}
