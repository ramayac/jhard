/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.ues.jhard.jpa;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author robertux
 */
@Entity
@Table(name = "inscripcion", catalog = "jhard", schema = "")
@NamedQueries({@NamedQuery(name = "Inscripcion.findAll", query = "SELECT i FROM Inscripcion i"),
@NamedQuery(name = "Inscripcion.findByIdinscripcion", query = "SELECT i FROM Inscripcion i WHERE i.idinscripcion = :idinscripcion"),
@NamedQuery(name = "Inscripcion.findByCursoEstudiante", query = "SELECT i FROM Inscripcion i WHERE i.idcurso = :idcurso AND i.idestudiante = :idestudiante")})
public class Inscripcion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idinscripcion", nullable = false)
    private Integer idinscripcion;
    @JoinColumn(name = "idcurso", referencedColumnName = "idcurso", nullable = false)
    @ManyToOne(optional = false)
    private Curso idcurso;
    @JoinColumn(name = "idestudiante", referencedColumnName = "idestudiante", nullable = false)
    @ManyToOne(optional = false)
    private Estudiante idestudiante;

    public Inscripcion() {
    }

    public Inscripcion(Integer idinscripcion) {
        this.idinscripcion = idinscripcion;
    }

    public Integer getIdinscripcion() {
        return idinscripcion;
    }

    public void setIdinscripcion(Integer idinscripcion) {
        this.idinscripcion = idinscripcion;
    }

    public Curso getIdcurso() {
        return idcurso;
    }

    public void setIdcurso(Curso idcurso) {
        this.idcurso = idcurso;
    }

    public Estudiante getIdestudiante() {
        return idestudiante;
    }

    public void setIdestudiante(Estudiante idestudiante) {
        this.idestudiante = idestudiante;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idinscripcion != null ? idinscripcion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Inscripcion)) {
            return false;
        }
        Inscripcion other = (Inscripcion) object;
        if ((this.idinscripcion == null && other.idinscripcion != null) || (this.idinscripcion != null && !this.idinscripcion.equals(other.idinscripcion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.ues.jhard.jpa.Inscripcion[idinscripcion=" + idinscripcion + "]";
    }

}
