/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.ues.jhard.jpa;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Rodrigo
 */
@Entity
@Table(name = "tag_entrada", catalog = "jhard", schema = "")
@NamedQueries({
    @NamedQuery(name = "TagEntrada.findAll", query = "SELECT t FROM TagEntrada t"),
    @NamedQuery(name = "TagEntrada.findByIdtagentrada",
        query = "SELECT t FROM TagEntrada t WHERE t.idtagentrada = :idtagentrada"),
    @NamedQuery(name = "TagEntrada.findByIdentrada", 
        query = "SELECT t FROM TagEntrada t WHERE t.identrada = :identrada"),
    @NamedQuery(name = "TagEntrada.findByIdtag", 
        query = "SELECT t FROM TagEntrada t WHERE t.idtag = :idtag"),
    @NamedQuery(name = "TagEntrada.findByIdentradaAndIdtag",
        query = "SELECT t FROM TagEntrada t WHERE t.identrada = :identrada AND  t.idtag = :idtag")
})
public class TagEntrada implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idtagentrada", nullable = false)
    private Integer idtagentrada;
    @JoinColumn(name = "idtag", referencedColumnName = "idtag", nullable = false)
    @ManyToOne(optional = false)
    private Tag idtag;
    @JoinColumn(name = "identrada", referencedColumnName = "identrada", nullable = false)
    @ManyToOne(optional = false)
    private Entrada identrada;

    public TagEntrada() {
    }

    public TagEntrada(Integer idtagentrada) {
        this.idtagentrada = idtagentrada;
    }

    public TagEntrada(Integer idtagentrada, Tag tag, Entrada entrada) {
        this.idtagentrada = idtagentrada;
        this.idtag = tag;
        this.identrada = entrada;
    }

    public Integer getIdtagentrada() {
        return idtagentrada;
    }

    public void setIdtagentrada(Integer idtagentrada) {
        this.idtagentrada = idtagentrada;
    }

    public Tag getIdtag() {
        return idtag;
    }

    public void setIdtag(Tag idtag) {
        this.idtag = idtag;
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
        hash += (idtagentrada != null ? idtagentrada.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TagEntrada)) {
            return false;
        }
        TagEntrada other = (TagEntrada) object;
        if ((this.idtagentrada == null && other.idtagentrada != null) || (this.idtagentrada != null && !this.idtagentrada.equals(other.idtagentrada))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.ues.jhard.jpa.TagEntrada[idtagentrada=" + idtagentrada + "]";
    }

}
