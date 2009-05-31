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
@Table(name = "tecnico", catalog = "jhard", schema = "")
@NamedQueries({@NamedQuery(name = "Tecnico.findAll", query = "SELECT t FROM Tecnico t"), @NamedQuery(name = "Tecnico.findByIdtecnico", query = "SELECT t FROM Tecnico t WHERE t.idtecnico = :idtecnico"), @NamedQuery(name = "Tecnico.findByApellidos", query = "SELECT t FROM Tecnico t WHERE t.apellidos = :apellidos"), @NamedQuery(name = "Tecnico.findByNombres", query = "SELECT t FROM Tecnico t WHERE t.nombres = :nombres"), @NamedQuery(name = "Tecnico.findByCargo", query = "SELECT t FROM Tecnico t WHERE t.cargo = :cargo")})
public class Tecnico implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idtecnico", nullable = false)
    private Integer idtecnico;
    @Basic(optional = false)
    @Column(name = "apellidos", nullable = false, length = 200)
    private String apellidos;
    @Basic(optional = false)
    @Column(name = "nombres", nullable = false, length = 200)
    private String nombres;
    @Basic(optional = false)
    @Column(name = "cargo", nullable = false, length = 200)
    private String cargo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idtecnico")
    private List<Mantenimiento> mantenimientoCollection;

    public Tecnico() {
    }

    public Tecnico(Integer idtecnico) {
        this.idtecnico = idtecnico;
    }

    public Tecnico(Integer idtecnico, String apellidos, String nombres, String cargo) {
        this.idtecnico = idtecnico;
        this.apellidos = apellidos;
        this.nombres = nombres;
        this.cargo = cargo;
    }

    public Integer getIdtecnico() {
        return idtecnico;
    }

    public void setIdtecnico(Integer idtecnico) {
        this.idtecnico = idtecnico;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public List<Mantenimiento> getMantenimientoCollection() {
        return mantenimientoCollection;
    }

    public void setMantenimientoCollection(List<Mantenimiento> mantenimientoCollection) {
        this.mantenimientoCollection = mantenimientoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtecnico != null ? idtecnico.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tecnico)) {
            return false;
        }
        Tecnico other = (Tecnico) object;
        if ((this.idtecnico == null && other.idtecnico != null) || (this.idtecnico != null && !this.idtecnico.equals(other.idtecnico))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.ues.jhard.jpa.Tecnico[idtecnico=" + idtecnico + "]";
    }

}
