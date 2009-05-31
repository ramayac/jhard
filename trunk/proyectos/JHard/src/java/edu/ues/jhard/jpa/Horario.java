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
 * @author Hugol
 */
@Entity
@Table(name = "horario", catalog = "jhard", schema = "")
@NamedQueries({@NamedQuery(name = "Horario.findAll", query = "SELECT h FROM Horario h"), @NamedQuery(name = "Horario.findByIdhorario", query = "SELECT h FROM Horario h WHERE h.idhorario = :idhorario"), @NamedQuery(name = "Horario.findByDiasemana", query = "SELECT h FROM Horario h WHERE h.diasemana = :diasemana"), @NamedQuery(name = "Horario.findByHorainicio", query = "SELECT h FROM Horario h WHERE h.horainicio = :horainicio"), @NamedQuery(name = "Horario.findByHorafin", query = "SELECT h FROM Horario h WHERE h.horafin = :horafin")})
public class Horario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idhorario", nullable = false)
    private Integer idhorario;
    @Basic(optional = false)
    @Column(name = "diasemana", nullable = false)
    private int diasemana;
    @Basic(optional = false)
    @Column(name = "horainicio", nullable = false)
    @Temporal(TemporalType.TIME)
    private Date horainicio;
    @Basic(optional = false)
    @Column(name = "horafin", nullable = false)
    @Temporal(TemporalType.TIME)
    private Date horafin;
    @JoinColumn(name = "idaula", referencedColumnName = "idubicacion", nullable = false)
    @ManyToOne(optional = false)
    private Ubicacion idaula;
    @JoinColumn(name = "idcurso", referencedColumnName = "idcurso", nullable = false)
    @ManyToOne(optional = false)
    private Curso idcurso;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idhorario")
    private List<Clase> claseCollection;

    public Horario() {
    }

    public Horario(Integer idhorario) {
        this.idhorario = idhorario;
    }

    public Horario(Integer idhorario, int diasemana, Date horainicio, Date horafin) {
        this.idhorario = idhorario;
        this.diasemana = diasemana;
        this.horainicio = horainicio;
        this.horafin = horafin;
    }

    public Integer getIdhorario() {
        return idhorario;
    }

    public void setIdhorario(Integer idhorario) {
        this.idhorario = idhorario;
    }

    public int getDiasemana() {
        return diasemana;
    }

    public void setDiasemana(int diasemana) {
        this.diasemana = diasemana;
    }

    public Date getHorainicio() {
        return horainicio;
    }

    public void setHorainicio(Date horainicio) {
        this.horainicio = horainicio;
    }

    public Date getHorafin() {
        return horafin;
    }

    public void setHorafin(Date horafin) {
        this.horafin = horafin;
    }

    public Ubicacion getIdaula() {
        return idaula;
    }

    public void setIdaula(Ubicacion idaula) {
        this.idaula = idaula;
    }

    public Curso getIdcurso() {
        return idcurso;
    }

    public void setIdcurso(Curso idcurso) {
        this.idcurso = idcurso;
    }

    public List<Clase> getClaseCollection() {
        return claseCollection;
    }

    public void setClaseCollection(List<Clase> claseCollection) {
        this.claseCollection = claseCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idhorario != null ? idhorario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Horario)) {
            return false;
        }
        Horario other = (Horario) object;
        if ((this.idhorario == null && other.idhorario != null) || (this.idhorario != null && !this.idhorario.equals(other.idhorario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.ues.jhard.jpa.Horario[idhorario=" + idhorario + "]";
    }

}
