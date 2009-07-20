/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.ues.jhard.jpa;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author rodrigo
 */
@Entity
@Table(name = "comentarios")
@NamedQueries({
@NamedQuery(name = "Comentarios.findAll", query = "SELECT c FROM Comentarios c"),
@NamedQuery(name = "Comentarios.findAprobado", query = "SELECT c FROM Comentarios c WHERE c.aprobado = 1"),
@NamedQuery(name = "Comentarios.findAprobadoByIdentrada", query = "SELECT c FROM Comentarios c WHERE c.identrada = :identrada AND c.aprobado = 1"),
@NamedQuery(name = "Comentarios.findNOAprobado", query = "SELECT c FROM Comentarios c WHERE c.aprobado = 0"),
@NamedQuery(name = "Comentarios.findByIdcoment", query = "SELECT c FROM Comentarios c WHERE c.idcoment = :idcoment"),
@NamedQuery(name = "Comentarios.findByComentario", query = "SELECT c FROM Comentarios c WHERE c.comentario = :comentario"),
@NamedQuery(name = "Comentarios.findByFechahorara", query = "SELECT c FROM Comentarios c WHERE c.fechahorara = :fechahorara"),
@NamedQuery(name = "Comentarios.findByFirma", query = "SELECT c FROM Comentarios c WHERE c.firma = :firma"),
@NamedQuery(name = "Comentarios.findByAprobado", query = "SELECT c FROM Comentarios c WHERE c.aprobado = :aprobado")})
public class Comentarios implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idcoment")
    private Integer idcoment;
    @Basic(optional = false)
    @Column(name = "comentario")
    private String comentario;
    @Basic(optional = false)
    @Column(name = "fechahorara")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechahorara;
    @Basic(optional = false)
    @Column(name = "firma")
    private String firma;
    @Basic(optional = false)
    @Column(name = "aprobado")
    private boolean aprobado;
    @JoinColumn(name = "identrada", referencedColumnName = "identrada")
    @ManyToOne(optional = false)
    private Entrada identrada;

    public Comentarios() {
    }

    public Comentarios(Integer idcoment) {
        this.idcoment = idcoment;
    }

    public Comentarios(Integer idcoment, String comentario, Date fechahorara, String firma, boolean aprobado) {
        this.idcoment = idcoment;
        this.comentario = comentario;
        this.fechahorara = fechahorara;
        this.firma = firma;
        this.aprobado = aprobado;
    }

    public Integer getIdcoment() {
        return idcoment;
    }

    public void setIdcoment(Integer idcoment) {
        this.idcoment = idcoment;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Date getFechahorara() {
        return fechahorara;
    }

    public void setFechahorara(Date fechahorara) {
        this.fechahorara = fechahorara;
    }

    public String getFirma() {
        return firma;
    }

    public void setFirma(String firma) {
        this.firma = firma;
    }

    public boolean getAprobado() {
        return aprobado;
    }

    public void setAprobado(boolean aprobado) {
        this.aprobado = aprobado;
    }

    public Entrada getIdentrada() {
        return identrada;
    }

    public void setIdentrada(Entrada identrada) {
        this.identrada = identrada;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcoment != null ? idcoment.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Comentarios)) {
            return false;
        }
        Comentarios other = (Comentarios) object;
        if ((this.idcoment == null && other.idcoment != null) || (this.idcoment != null && !this.idcoment.equals(other.idcoment))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.ues.jhard.jpa.Comentarios[idcoment=" + idcoment + "]";
    }

}
