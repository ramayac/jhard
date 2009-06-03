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
@Table(name = "instructor", catalog = "jhard", schema = "")
@NamedQueries({@NamedQuery(name = "Instructor.findAll", query = "SELECT i FROM Instructor i"), @NamedQuery(name = "Instructor.findByIdinstructor", query = "SELECT i FROM Instructor i WHERE i.idinstructor = :idinstructor"), @NamedQuery(name = "Instructor.findByCarnet", query = "SELECT i FROM Instructor i WHERE i.carnet = :carnet"), @NamedQuery(name = "Instructor.findByApellidos", query = "SELECT i FROM Instructor i WHERE i.apellidos = :apellidos"), @NamedQuery(name = "Instructor.findByNombres", query = "SELECT i FROM Instructor i WHERE i.nombres = :nombres"), @NamedQuery(name = "Instructor.findByVisible", query = "SELECT i FROM Instructor i WHERE i.visible = :visible")})
public class Instructor implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idinstructor", nullable = false)
    private Integer idinstructor;
    @Basic(optional = false)
    @Column(name = "carnet", nullable = false, length = 7)
    private String carnet;
    @Basic(optional = false)
    @Column(name = "apellidos", nullable = false, length = 200)
    private String apellidos;
    @Basic(optional = false)
    @Column(name = "nombres", nullable = false, length = 200)
    private String nombres;
    @Basic(optional = false)
    @Column(name = "visible", nullable = false)
    private int visible;
    @JoinColumn(name = "idusuario", referencedColumnName = "idusuario", nullable = false)
    @ManyToOne(optional = false)
    private Usuario idusuario;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idinstructor")
    private Collection<Curso> cursoCollection;
    @OneToMany(mappedBy = "idinstructor")
    private Collection<Clase> claseCollection;

    public Instructor() {
    }

    public Instructor(Integer idinstructor) {
        this.idinstructor = idinstructor;
    }

    public Instructor(Integer idinstructor, String carnet, String apellidos, String nombres, int visible) {
        this.idinstructor = idinstructor;
        this.carnet = carnet;
        this.apellidos = apellidos;
        this.nombres = nombres;
        this.visible = visible;
    }

    public Integer getIdinstructor() {
        return idinstructor;
    }

    public void setIdinstructor(Integer idinstructor) {
        this.idinstructor = idinstructor;
    }

    public String getCarnet() {
        return carnet;
    }

    public void setCarnet(String carnet) {
        this.carnet = carnet;
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

    public int getVisible() {
        return visible;
    }

    public void setVisible(int visible) {
        this.visible = visible;
    }

    public Usuario getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(Usuario idusuario) {
        this.idusuario = idusuario;
    }

    public Collection<Curso> getCursoCollection() {
        return cursoCollection;
    }

    public void setCursoCollection(Collection<Curso> cursoCollection) {
        this.cursoCollection = cursoCollection;
    }

    public Collection<Clase> getClaseCollection() {
        return claseCollection;
    }

    public void setClaseCollection(Collection<Clase> claseCollection) {
        this.claseCollection = claseCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idinstructor != null ? idinstructor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Instructor)) {
            return false;
        }
        Instructor other = (Instructor) object;
        if ((this.idinstructor == null && other.idinstructor != null) || (this.idinstructor != null && !this.idinstructor.equals(other.idinstructor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.ues.jhard.jpa.Instructor[idinstructor=" + idinstructor + "]";
    }

}
