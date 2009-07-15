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
import javax.persistence.Table;

/**
 *
 * @author Hugol
 */
@Entity
@Table(name = "autorizacion", catalog = "jhard", schema = "")
public class Autorizacion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idautorizacion", nullable = false)
    private Integer idautorizacion;
    @Basic(optional = false)
    @Column(name = "codigo", nullable = false, length = 10)
    private String codigo;
    @Basic(optional = false)
    @Column(name = "cantmaxima")
    private Integer cantmaxima;

    public Autorizacion() {
    }

    public Autorizacion(Integer idautorizacion) {
        this.idautorizacion = idautorizacion;
    }

    public Integer getIdautorizacion() {
        return idautorizacion;
    }

    public void setIdautorizacion(Integer idautorizacion) {
        this.idautorizacion = idautorizacion;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Integer getCantmaxima() {
        return cantmaxima;
    }

    public void setCantmaxima(Integer cantmaxima) {
        this.cantmaxima = cantmaxima;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idautorizacion != null ? idautorizacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pieza)) {
            return false;
        }
        Autorizacion other = (Autorizacion) object;
        if ((this.idautorizacion == null && other.idautorizacion != null) || (this.idautorizacion != null && !this.idautorizacion.equals(other.idautorizacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.ues.jhard.jpa.Pieza[idpieza=" + idautorizacion + "]";
    }
}
