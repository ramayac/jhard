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
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Hugol
 */
@Entity
@Table(name = "bitacoracambiosusuario", catalog = "jhard", schema = "")
@NamedQueries({@NamedQuery(name = "Bitacoracambiosusuario.findAll", query = "SELECT b FROM Bitacoracambiosusuario b"), @NamedQuery(name = "Bitacoracambiosusuario.findByIdbitacora", query = "SELECT b FROM Bitacoracambiosusuario b WHERE b.idbitacora = :idbitacora"), @NamedQuery(name = "Bitacoracambiosusuario.findByFechahora", query = "SELECT b FROM Bitacoracambiosusuario b WHERE b.fechahora = :fechahora")})
public class Bitacoracambiosusuario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idbitacora", nullable = false)
    private Integer idbitacora;
    @Basic(optional = false)
    @Lob
    @Column(name = "descripcion", nullable = false, length = 65535)
    private String descripcion;
    @Basic(optional = false)
    @Column(name = "fechahora", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechahora;
    @JoinColumn(name = "idusuario", referencedColumnName = "idusuario", nullable = false)
    @ManyToOne(optional = false)
    private Usuario idusuario;

    public Bitacoracambiosusuario() {
    }

    public Bitacoracambiosusuario(Integer idbitacora) {
        this.idbitacora = idbitacora;
    }

    public Bitacoracambiosusuario(Integer idbitacora, String descripcion, Date fechahora) {
        this.idbitacora = idbitacora;
        this.descripcion = descripcion;
        this.fechahora = fechahora;
    }

    public Integer getIdbitacora() {
        return idbitacora;
    }

    public void setIdbitacora(Integer idbitacora) {
        this.idbitacora = idbitacora;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFechahora() {
        return fechahora;
    }

    public void setFechahora(Date fechahora) {
        this.fechahora = fechahora;
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
        hash += (idbitacora != null ? idbitacora.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Bitacoracambiosusuario)) {
            return false;
        }
        Bitacoracambiosusuario other = (Bitacoracambiosusuario) object;
        if ((this.idbitacora == null && other.idbitacora != null) || (this.idbitacora != null && !this.idbitacora.equals(other.idbitacora))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.ues.jhard.jpa.Bitacoracambiosusuario[idbitacora=" + idbitacora + "]";
    }

}
