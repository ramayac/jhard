/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.ues.jhard.jpa;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idautorizacion")
    private Collection<Usuario> usuarioCollection;

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

    public String getDescListaUsuarios(){
        String descListaUsuarios = "(Total: " + this.usuarioCollection.size() + ") ";
        for(Usuario u: this.usuarioCollection)
            descListaUsuarios += u.getNombre() + ", ";

        if(this.usuarioCollection.size() > 0)
            descListaUsuarios = descListaUsuarios.substring(0, descListaUsuarios.length() - 2);
        if(descListaUsuarios.length() > 25)
            descListaUsuarios = descListaUsuarios.substring(0, 24);
        
        return descListaUsuarios;
    }

    /**
     * @return the usuarioCollection
     */
    public Collection<Usuario> getUsuarioCollection() {
        return usuarioCollection;
    }

    /**
     * @param usuarioCollection the usuarioCollection to set
     */
    public void setUsuarioCollection(Collection<Usuario> usuarioCollection) {
        this.usuarioCollection = usuarioCollection;
    }
}
