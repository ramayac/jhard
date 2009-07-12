/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.ues.jhard.jpa;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
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
 * @author Rodrigo
 */
@Entity
@Table(name = "entrada", catalog = "jhard", schema = "")
@NamedQueries({
    @NamedQuery(name = "Entrada.findAll", query = "SELECT e FROM Entrada e"),
    //SELECT * FROM `jhard`.`entrada` ORDER BY 1 DESC LIMIT 5
    //@NamedQuery(name = "Entrada.findLastFive", query = "SELECT e FROM Entrada e ORDER BY 1 DESC LIMIT 5"),
    //@NamedQuery(name = "Entrada.findLastN",query = "SELECT e FROM Entrada e ORDER BY 1 DESC LIMIT :numero"),
    @NamedQuery(name = "Entrada.findByIdentrada",
        query = "SELECT e FROM Entrada e WHERE e.identrada = :identrada"),
    //@NamedQuery(name = "Entrada.findByTitulo", query = "SELECT e FROM Entrada e WHERE e.titulo = :titulo"), //what for?
    @NamedQuery(name = "Entrada.findByFechahora", 
        query = "SELECT e FROM Entrada e WHERE e.fechahora = :fechahora")
    //@NamedQuery(name = "Entrada.findByRangoFechahora", query = "SELECT e FROM Entrada e WHERE e.fechahora IN BETWEEN :defecha AND :hastafecha")
})

public class Entrada implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "identrada", nullable = false)
    private Integer identrada;
    @Basic(optional = false)
    @Column(name = "titulo", nullable = false, length = 50)
    private String titulo;
    @Basic(optional = false)
    @Lob
    @Column(name = "descripcion", nullable = false, length = 65535)
    private String descripcion;
    @Basic(optional = false)
    @Column(name = "fechahora", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechahora;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "identrada")
    private Collection<Comentarios> comentariosCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "identrada")
    private Collection<TagEntrada> tagEntradaCollection;
    @JoinColumn(name = "idusuario", referencedColumnName = "idusuario", nullable = false)
    //@ManyToOne(optional = true)
    //@Column(name = "idusuario", nullable = false)
    private Usuario idusuario;

    public Entrada() {
    }

    public Entrada(Integer identrada) {
        this.identrada = identrada;
    }

    public Entrada(Integer identrada, String titulo, String descripcion, Date fechahora, Usuario usuario) {
        this.identrada = identrada;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.fechahora = fechahora;
        this.idusuario = usuario;
    }

    public Integer getIdentrada() {
        return identrada;
    }

    public void setIdentrada(Integer identrada) {
        this.identrada = identrada;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
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

    public Collection<Comentarios> getComentariosCollection() {
        return comentariosCollection;
    }

    public void setComentariosCollection(Collection<Comentarios> comentariosCollection) {
        this.comentariosCollection = comentariosCollection;
    }

    public Collection<TagEntrada> getTagEntradaCollection() {
        return tagEntradaCollection;
    }

    public void setTagEntradaCollection(Collection<TagEntrada> tagEntradaCollection) {
        this.tagEntradaCollection = tagEntradaCollection;
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
        hash += (identrada != null ? identrada.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Entrada)) {
            return false;
        }
        Entrada other = (Entrada) object;
        if ((this.identrada == null && other.identrada != null) || (this.identrada != null && !this.identrada.equals(other.identrada))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.ues.jhard.jpa.Entrada[identrada=" + identrada + "]";
    }

}
