/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.ues.jhard.jpa;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author rodrigo
 */
@Entity
@Table(name = "curso")
@NamedQueries({
    @NamedQuery(name = "Curso.findAll", query = "SELECT c FROM Curso c"),
    @NamedQuery(name = "Curso.findByIdcurso", query = "SELECT c FROM Curso c WHERE c.idcurso = :idcurso"),
    @NamedQuery(name = "Curso.findByNombre", query = "SELECT c FROM Curso c WHERE c.nombre = :nombre"),
    /*@NamedQuery(name = "Curso.findByCupomax", query = "SELECT c FROM Curso c WHERE c.cupomax = :cupomax"),*/
    @NamedQuery(name = "Curso.findByDocente", query = "SELECT c FROM Curso c WHERE c.iddocente = :iddocente"),
    @NamedQuery(name = "Curso.findByInstructor", query = "SELECT c FROM Curso c WHERE c.idinstructor = :idinstructor"),

    @NamedQuery(name = "Curso.findByDocenteCiclo", query = "SELECT c FROM Curso c WHERE c.iddocente = :iddocente AND c.idcicloanio = :idcicloanyo"),
    @NamedQuery(name = "Curso.findByInstructorCiclo", query = "SELECT c FROM Curso c WHERE c.idinstructor = :idinstructor AND c.idcicloanio = :idcicloanyo"),

    @NamedQuery(name = "Curso.findByCiclo", query = "SELECT c FROM Curso c WHERE c.idcicloanio = :idcicloanyo"),
    @NamedQuery(name = "Curso.findByCicloHabilitado", query = "SELECT c FROM Curso c WHERE c.idcicloanio = :idcicloanyo AND c.habilinscrip = 1"),

    @NamedQuery(name = "Curso.findByFechainicio", query = "SELECT c FROM Curso c WHERE c.fechainicio = :fechainicio"),
    /*@NamedQuery(name = "Curso.findByCiclo", query = "SELECT c FROM Curso c WHERE c.ciclo = :ciclo"),
    @NamedQuery(name = "Curso.findByAnio", query = "SELECT c FROM Curso c WHERE c.anio = :anio"),*/
    @NamedQuery(name = "Curso.findByHabilinscrip", query = "SELECT c FROM Curso c WHERE c.habilinscrip = :habilinscrip")})
public class Curso implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idcurso")
    private Integer idcurso;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "cupomax")
    private int cupomax;
    @Basic(optional = false)
    @Column(name = "fechainicio")
    @Temporal(TemporalType.DATE)
    private Date fechainicio;
    @Column(name = "ciclo")
    private Integer ciclo;
    @Column(name = "anio")
    private Integer anio;
    @Basic(optional = false)
    @Column(name = "habilinscrip")
    private boolean habilinscrip;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idcurso")
    private List<Inscripcion> inscripcionCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idcurso")
    private List<Horario> horarioCollection;
    @JoinColumn(name = "idcicloanio", referencedColumnName = "idcicloanyo")
    @ManyToOne(optional = false)
    private Cicloanyo idcicloanio;
    @JoinColumn(name = "iddocente", referencedColumnName = "iddocente")
    @ManyToOne(optional = false)
    private Docente iddocente;
    @JoinColumn(name = "idestado", referencedColumnName = "idestadocurso")
    @ManyToOne
    private Estadocurso idestado;
    @JoinColumn(name = "idinstructor", referencedColumnName = "idinstructor")
    @ManyToOne(optional = false)
    private Instructor idinstructor;
    @JoinColumn(name = "idmateria", referencedColumnName = "idmateria")
    @ManyToOne
    private Materia idmateria;

    public Curso() {
    }

    public Curso(Integer idcurso) {
        this.idcurso = idcurso;
    }

    public Curso(Integer idcurso, String nombre, int cupomax, Date fechainicio, boolean habilinscrip) {
        this.idcurso = idcurso;
        this.nombre = nombre;
        this.cupomax = cupomax;
        this.fechainicio = fechainicio;
        this.habilinscrip = habilinscrip;
    }

    public Integer getIdcurso() {
        return idcurso;
    }

    public void setIdcurso(Integer idcurso) {
        this.idcurso = idcurso;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCupomax() {
        return cupomax;
    }

    public void setCupomax(int cupomax) {
        this.cupomax = cupomax;
    }

    public Date getFechainicio() {
        return fechainicio;
    }

    public void setFechainicio(Date fechainicio) {
        this.fechainicio = fechainicio;
    }

    public Integer getCiclo() {
        return ciclo;
    }

    public void setCiclo(Integer ciclo) {
        this.ciclo = ciclo;
    }

    public Integer getAnio() {
        return anio;
    }

    public void setAnio(Integer anio) {
        this.anio = anio;
    }

    public boolean getHabilinscrip() {
        return habilinscrip;
    }

    public void setHabilinscrip(boolean habilinscrip) {
        this.habilinscrip = habilinscrip;
    }

    public List<Inscripcion> getInscripcionCollection() {
        return inscripcionCollection;
    }

    public void setInscripcionCollection(List<Inscripcion> inscripcionCollection) {
        this.inscripcionCollection = inscripcionCollection;
    }

    public List<Horario> getHorarioCollection() {
        return horarioCollection;
    }

    public void setHorarioCollection(List<Horario> horarioCollection) {
        this.horarioCollection = horarioCollection;
    }

    public Cicloanyo getIdcicloanio() {
        return idcicloanio;
    }

    public void setIdcicloanio(Cicloanyo idcicloanio) {
        this.idcicloanio = idcicloanio;
    }

    public Docente getIddocente() {
        return iddocente;
    }

    public void setIddocente(Docente iddocente) {
        this.iddocente = iddocente;
    }

    public Estadocurso getIdestado() {
        return idestado;
    }

    public void setIdestado(Estadocurso idestado) {
        this.idestado = idestado;
    }

    public Instructor getIdinstructor() {
        return idinstructor;
    }

    public void setIdinstructor(Instructor idinstructor) {
        this.idinstructor = idinstructor;
    }

    public Materia getIdmateria() {
        return idmateria;
    }

    public void setIdmateria(Materia idmateria) {
        this.idmateria = idmateria;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcurso != null ? idcurso.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Curso)) {
            return false;
        }
        Curso other = (Curso) object;
        if ((this.idcurso == null && other.idcurso != null) || (this.idcurso != null && !this.idcurso.equals(other.idcurso))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.ues.jhard.jpa.Curso[idcurso=" + idcurso + "]";
    }

}
