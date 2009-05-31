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
@Table(name = "estudiante", catalog = "jhard", schema = "")
@NamedQueries({@NamedQuery(name = "Estudiante.findAll", query = "SELECT e FROM Estudiante e"), @NamedQuery(name = "Estudiante.findByIdestudiante", query = "SELECT e FROM Estudiante e WHERE e.idestudiante = :idestudiante"), @NamedQuery(name = "Estudiante.findByCarnet", query = "SELECT e FROM Estudiante e WHERE e.carnet = :carnet"), @NamedQuery(name = "Estudiante.findByApellidos", query = "SELECT e FROM Estudiante e WHERE e.apellidos = :apellidos"), @NamedQuery(name = "Estudiante.findByNombres", query = "SELECT e FROM Estudiante e WHERE e.nombres = :nombres"), @NamedQuery(name = "Estudiante.findByVisible", query = "SELECT e FROM Estudiante e WHERE e.visible = :visible")})
public class Estudiante implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idestudiante", nullable = false)
    private Integer idestudiante;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idestudiante")
    private List<Inscripcion> inscripcionCollection;
    @JoinColumn(name = "idusuario", referencedColumnName = "idusuario", nullable = false)
    @ManyToOne(optional = false)
    private Usuario idusuario;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idestudiante")
    private List<Asistencia> asistenciaCollection;

    public Estudiante() {
    }

    public Estudiante(Integer idestudiante) {
        this.idestudiante = idestudiante;
    }

    public Estudiante(Integer idestudiante, String carnet, String apellidos, String nombres, int visible) {
        this.idestudiante = idestudiante;
        this.carnet = carnet;
        this.apellidos = apellidos;
        this.nombres = nombres;
        this.visible = visible;
    }

    public Integer getIdestudiante() {
        return idestudiante;
    }

    public void setIdestudiante(Integer idestudiante) {
        this.idestudiante = idestudiante;
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

    public List<Inscripcion> getInscripcionCollection() {
        return inscripcionCollection;
    }

    public void setInscripcionCollection(List<Inscripcion> inscripcionCollection) {
        this.inscripcionCollection = inscripcionCollection;
    }

    public Usuario getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(Usuario idusuario) {
        this.idusuario = idusuario;
    }

    public List<Asistencia> getAsistenciaCollection() {
        return asistenciaCollection;
    }

    public void setAsistenciaCollection(List<Asistencia> asistenciaCollection) {
        this.asistenciaCollection = asistenciaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idestudiante != null ? idestudiante.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Estudiante)) {
            return false;
        }
        Estudiante other = (Estudiante) object;
        if ((this.idestudiante == null && other.idestudiante != null) || (this.idestudiante != null && !this.idestudiante.equals(other.idestudiante))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.ues.jhard.jpa.Estudiante[idestudiante=" + idestudiante + "]";
    }

}
