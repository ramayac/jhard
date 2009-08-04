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
import javax.persistence.Lob;
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
@Table(name = "clase")
@NamedQueries({
    @NamedQuery(name = "Clase.findAll", query = "SELECT c FROM Clase c"),
    @NamedQuery(name = "Clase.findByIdclase", query = "SELECT c FROM Clase c WHERE c.idclase = :idclase"),
    @NamedQuery(name = "Clase.findByFecha", query = "SELECT c FROM Clase c WHERE c.fecha = :fecha"),
    @NamedQuery(name = "Clase.findbyMismaFecha", query = "SELECT COUNT(c) FROM Clase c WHERE c.fecha = :fecha AND c.idhorario = :idhorario"),
    @NamedQuery(name = "Clase.findByTema", query = "SELECT c FROM Clase c WHERE c.tema = :tema"),
    @NamedQuery(name = "Clase.findByHorainicio", query = "SELECT c FROM Clase c WHERE c.horainicio = :horainicio"),
    @NamedQuery(name = "Clase.findByHorafin", query = "SELECT c FROM Clase c WHERE c.horafin = :horafin"),
    @NamedQuery(name = "Clase.findByFinalizada", query = "SELECT c FROM Clase c WHERE c.finalizada = :finalizada"),
    @NamedQuery(name = "Clase.findByFechaMarcaFinal", query = "SELECT c FROM Clase c WHERE c.fecha = :fecha AND c.finalizada = :finalizada")
})
public class Clase implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idclase")
    private Integer idclase;
    @Basic(optional = false)
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Basic(optional = false)
    @Column(name = "tema")
    private String tema;
    @Lob
    @Column(name = "observaciones")
    private String observaciones;
    @Basic(optional = false)
    @Column(name = "horainicio")
    @Temporal(TemporalType.TIME)
    private Date horainicio;
    @Basic(optional = false)
    @Column(name = "horafin")
    @Temporal(TemporalType.TIME)
    private Date horafin;
    @Basic(optional = false)
    @Column(name = "finalizada")
    private boolean finalizada;
    @JoinColumn(name = "iddocente", referencedColumnName = "iddocente")
    @ManyToOne
    private Docente iddocente;
    @JoinColumn(name = "idhorario", referencedColumnName = "idhorario")
    @ManyToOne(optional = false)
    private Horario idhorario;
    @JoinColumn(name = "idinstructor", referencedColumnName = "idinstructor")
    @ManyToOne
    private Instructor idinstructor;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idclase")
    private List<Asistencia> asistenciaCollection;

    public Clase() {
    }

    public Clase(Integer idclase) {
        this.idclase = idclase;
    }

    public Clase(Integer idclase, Date fecha, String tema, boolean finalizada) {
        this.idclase = idclase;
        this.fecha = fecha;
        this.tema = tema;
        this.finalizada = finalizada;
    }

    public Clase(Integer idclase, Date fecha, String tema, Date horainicio, Date horafin, boolean finalizada) {
        this.idclase = idclase;
        this.fecha = fecha;
        this.tema = tema;
        this.horainicio = horainicio;
        this.horafin = horafin;
        this.finalizada = finalizada;
    }

    public Integer getIdclase() {
        return idclase;
    }

    public void setIdclase(Integer idclase) {
        this.idclase = idclase;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
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

    public boolean getFinalizada() {
        return finalizada;
    }

    public void setFinalizada(boolean finalizada) {
        this.finalizada = finalizada;
    }

    public Docente getIddocente() {
        return iddocente;
    }

    public void setIddocente(Docente iddocente) {
        this.iddocente = iddocente;
    }

    public Horario getIdhorario() {
        return idhorario;
    }

    public void setIdhorario(Horario idhorario) {
        this.idhorario = idhorario;
    }

    public Instructor getIdinstructor() {
        return idinstructor;
    }

    public void setIdinstructor(Instructor idinstructor) {
        this.idinstructor = idinstructor;
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
        hash += (idclase != null ? idclase.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Clase)) {
            return false;
        }
        Clase other = (Clase) object;
        if ((this.idclase == null && other.idclase != null) || (this.idclase != null && !this.idclase.equals(other.idclase))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.ues.jhard.jpa.Clase[idclase=" + idclase + "]";
    }

}
