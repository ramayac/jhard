/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.ues.jhard.jpa;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author robertux
 */
@Entity
@Table(name = "tag", catalog = "jhard", schema = "")
@NamedQueries({@NamedQuery(name = "Tag.findAll", query = "SELECT t FROM Tag t"), @NamedQuery(name = "Tag.findByIdtag", query = "SELECT t FROM Tag t WHERE t.idtag = :idtag"), @NamedQuery(name = "Tag.findByDescripcion", query = "SELECT t FROM Tag t WHERE t.descripcion = :descripcion")})
public class Tag implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idtag", nullable = false)
    private Integer idtag;
    @Basic(optional = false)
    @Column(name = "descripcion", nullable = false, length = 25)
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idtag")
    private Collection<TagEntrada> tagEntradaCollection;

    public Tag() {
    }

    public Tag(Integer idtag) {
        this.idtag = idtag;
    }

    public Tag(Integer idtag, String descripcion) {
        this.idtag = idtag;
        this.descripcion = descripcion;
    }

    public Integer getIdtag() {
        return idtag;
    }

    public void setIdtag(Integer idtag) {
        this.idtag = idtag;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Collection<TagEntrada> getTagEntradaCollection() {
        return tagEntradaCollection;
    }

    public void setTagEntradaCollection(Collection<TagEntrada> tagEntradaCollection) {
        this.tagEntradaCollection = tagEntradaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtag != null ? idtag.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tag)) {
            return false;
        }
        Tag other = (Tag) object;
        if ((this.idtag == null && other.idtag != null) || (this.idtag != null && !this.idtag.equals(other.idtag))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.ues.jhard.jpa.Tag[idtag=" + idtag + "]";
    }

}
