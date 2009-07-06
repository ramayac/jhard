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
 * @author robertux
 */
@Entity
@Table(name = "comentarios", catalog = "jhard", schema = "")
@NamedQueries({@NamedQuery(name = "Comentarios.findAll", query = "SELECT c FROM Comentarios c"),
@NamedQuery(name = "Comentarios.findByIdcoment", query = "SELECT c FROM Comentarios c WHERE c.idcoment = :idcoment"), 
@NamedQuery(name = "Comentarios.findByIdEntrada", query = "SELECT c FROM Comentarios c WHERE c.identrada = :identrada"),
@NamedQuery(name = "Comentarios.findByComentario", query = "SELECT c FROM Comentarios c WHERE c.comentario = :comentario"),
@NamedQuery(name = "Comentarios.findByFechahorara", query = "SELECT c FROM Comentarios c WHERE c.fechahorara = :fechahorara")})
public class Comentarios implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idcoment", nullable = false)
    private Integer idcoment;
    @Basic(optional = false)
    @Column(name = "comentario", nullable = false, length = 250)
    private String comentario;
    @Basic(optional = false)
    @Column(name = "fechahorara", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechahorara;
    @JoinColumn(name = "identrada", referencedColumnName = "identrada", nullable = false)
    @ManyToOne(optional = false)
    private Entrada identrada;

    public Comentarios() {
    }

    public Comentarios(Integer idcoment) {
        this.idcoment = idcoment;
    }

    public Comentarios(Integer idcoment, String comentario, Date fechahorara) {
        this.idcoment = idcoment;
        this.comentario = comentario;
        this.fechahorara = fechahorara;
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
