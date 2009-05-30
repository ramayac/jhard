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
@Table(name = "docente")
@NamedQueries({@NamedQuery(name = "Docente.findAll", query = "SELECT d FROM Docente d"), @NamedQuery(name = "Docente.findByIddocente", query = "SELECT d FROM Docente d WHERE d.iddocente = :iddocente"), @NamedQuery(name = "Docente.findByApellidos", query = "SELECT d FROM Docente d WHERE d.apellidos = :apellidos"), @NamedQuery(name = "Docente.findByNombres", query = "SELECT d FROM Docente d WHERE d.nombres = :nombres"), @NamedQuery(name = "Docente.findByVisible", query = "SELECT d FROM Docente d WHERE d.visible = :visible")})
public class Docente implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "iddocente")
    private Integer iddocente;
    @Basic(optional = false)
    @Column(name = "Apellidos")
    private String apellidos;
    @Basic(optional = false)
    @Column(name = "Nombres")
    private String nombres;
    @Basic(optional = false)
    @Column(name = "visible")
    private int visible;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "iddocente")
    private List<Curso> cursoCollection;
    @OneToMany(mappedBy = "iddocente")
    private List<Clase> claseCollection;
    @JoinColumn(name = "idusuario", referencedColumnName = "idusuario")
    @ManyToOne(optional = false)
    private Usuario idusuario;

    public Docente() {
    }

    public Docente(Integer iddocente) {
        this.iddocente = iddocente;
    }

    public Docente(Integer iddocente, String apellidos, String nombres, int visible) {
        this.iddocente = iddocente;
        this.apellidos = apellidos;
        this.nombres = nombres;
        this.visible = visible;
    }

    public Integer getIddocente() {
        return iddocente;
    }

    public void setIddocente(Integer iddocente) {
        this.iddocente = iddocente;
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

    public List<Curso> getCursoCollection() {
        return cursoCollection;
    }

    public void setCursoCollection(List<Curso> cursoCollection) {
        this.cursoCollection = cursoCollection;
    }

    public List<Clase> getClaseCollection() {
        return claseCollection;
    }

    public void setClaseCollection(List<Clase> claseCollection) {
        this.claseCollection = claseCollection;
    }

    public Usuario getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(Usuario idusuario) {
        this.idusuario = idusuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iddocente != null ? iddocente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Docente)) {
            return false;
        }
        Docente other = (Docente) object;
        if ((this.iddocente == null && other.iddocente != null) || (this.iddocente != null && !this.iddocente.equals(other.iddocente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "JPA.Docente[iddocente=" + iddocente + "]";
    }

}
