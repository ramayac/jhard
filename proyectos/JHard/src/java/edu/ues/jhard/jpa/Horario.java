/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.ues.jhard.jpa;

import edu.ues.jhard.util.Utilidades;
import java.io.Serializable;

import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
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
 * @author robertux
 */
@Entity
@Table(name = "horario", catalog = "jhard", schema = "")
@NamedQueries({@NamedQuery(name = "Horario.findAll", query = "SELECT h FROM Horario h ORDER BY h.diasemana, h.horainicio"),
               @NamedQuery(name = "Horario.findByIdhorario", query = "SELECT h FROM Horario h WHERE h.idhorario = :idhorario"),
               @NamedQuery(name = "Horario.findByIdCurso", query = "SELECT h FROM Horario h WHERE h.idcurso = :idcurso"),
               @NamedQuery(name = "Horario.findByDiasemana", query = "SELECT h FROM Horario h WHERE h.diasemana = :diasemana"),
               @NamedQuery(name = "Horario.findByHorainicio", query = "SELECT h FROM Horario h WHERE h.horainicio = :horainicio"),
               @NamedQuery(name = "Horario.findByHoraDia", query = "SELECT h FROM Horario h WHERE h.horainicio = :horainicio AND h.diasemana = :diasemana"),
               @NamedQuery(name = "Horario.findByHorafin", query = "SELECT h FROM Horario h WHERE h.horafin = :horafin")})
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
    @JoinColumn(name = "idcurso", referencedColumnName = "idcurso", nullable = false)
    @ManyToOne(optional = false)
    private Curso idcurso;
    @JoinColumn(name = "idaula", referencedColumnName = "idubicacion", nullable = false)
    @ManyToOne(optional = false)
    private Ubicacion idaula;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idhorario")
    private Collection<Clase> claseCollection;

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

    public String getNombrediasemana(){
        return Utilidades.DiaNombre(this.diasemana);
    }

    public void setDiasemana(int diasemana) {
        this.diasemana = diasemana;
    }

    public Date getHorainicio() {
        return horainicio;
    }

    public String getHorainicioformated() {
        SimpleDateFormat sdf = new SimpleDateFormat("h:mm a");
        return sdf.format(horainicio);
    }

    public void setHorainicio(Date horainicio) {
        this.horainicio = horainicio;
    }

    public Date getHorafin() {
        return horafin;
    }

    public String getHorafinformated() {
        SimpleDateFormat sdf = new SimpleDateFormat("h:mm a");
        return sdf.format(horafin);
    }

    public void setHorafin(Date horafin) {
        this.horafin = horafin;
    }

    public Curso getIdcurso() {
        return idcurso;
    }

    public void setIdcurso(Curso idcurso) {
        this.idcurso = idcurso;
    }

    public Ubicacion getIdaula() {
        return idaula;
    }

    public void setIdaula(Ubicacion idaula) {
        this.idaula = idaula;
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

    public String getdiaSemanal(){
        String dia="";
        switch(this.diasemana){
            case 1: dia = "Lunes";
                    break;
            case 2: dia = "Martes";
                    break;
            case 3: dia = "Miércoles";
                    break;
            case 4: dia = "Jueves";
                    break;
            case 5: dia = "Viernes";
                    break;
            case 6: dia = "Sábado";
                    break;
        }
        return dia;
    }

    public String getstart(){

        return Utilidades.FormateaHora(this.horainicio);
        //return String.valueOf(this.horainicio.getHours())+":"+String.valueOf(this.horainicio.getMinutes());
    }

    public String getend(){

        return Utilidades.FormateaHora(this.horafin);
        //return String.valueOf(this.horafin.getHours())+":"+String.valueOf(this.horafin.getMinutes());
    }
}
