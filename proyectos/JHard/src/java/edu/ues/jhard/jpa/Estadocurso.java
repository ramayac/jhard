/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.ues.jhard.jpa;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
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
@Table(name = "estadocurso", catalog = "jhard", schema = "")
@NamedQueries({@NamedQuery(name = "Estadocurso.findAll", query = "SELECT e FROM Estadocurso e"), @NamedQuery(name = "Estadocurso.findByIdestadocurso", query = "SELECT e FROM Estadocurso e WHERE e.idestadocurso = :idestadocurso"), @NamedQuery(name = "Estadocurso.findByNombre", query = "SELECT e FROM Estadocurso e WHERE e.nombre = :nombre")})
public class Estadocurso implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idestadocurso", nullable = false)
    private Integer idestadocurso;
    @Basic(optional = false)
    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;
    @OneToMany(mappedBy = "idestado")
    private List<Curso> cursoCollection;

    public Estadocurso() {
    }

    public Estadocurso(Integer idestadocurso) {
        this.idestadocurso = idestadocurso;
    }

    public Estadocurso(Integer idestadocurso, String nombre) {
        this.idestadocurso = idestadocurso;
        this.nombre = nombre;
    }

    public Integer getIdestadocurso() {
        return idestadocurso;
    }

    public void setIdestadocurso(Integer idestadocurso) {
        this.idestadocurso = idestadocurso;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Curso> getCursoCollection() {
        return cursoCollection;
    }

    public void setCursoCollection(List<Curso> cursoCollection) {
        this.cursoCollection = cursoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idestadocurso != null ? idestadocurso.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Estadocurso)) {
            return false;
        }
        Estadocurso other = (Estadocurso) object;
        if ((this.idestadocurso == null && other.idestadocurso != null) || (this.idestadocurso != null && !this.idestadocurso.equals(other.idestadocurso))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.ues.jhard.jpa.Estadocurso[idestadocurso=" + idestadocurso + "]";
    }

}
