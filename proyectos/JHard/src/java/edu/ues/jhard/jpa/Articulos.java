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
import javax.persistence.Lob;
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
@Table(name = "articulos")
@NamedQueries({@NamedQuery(name = "Articulos.findAll", query = "SELECT a FROM Articulos a"), @NamedQuery(name = "Articulos.findByIdarticulo", query = "SELECT a FROM Articulos a WHERE a.idarticulo = :idarticulo"), @NamedQuery(name = "Articulos.findByTitulo", query = "SELECT a FROM Articulos a WHERE a.titulo = :titulo"), @NamedQuery(name = "Articulos.findByFechahora", query = "SELECT a FROM Articulos a WHERE a.fechahora = :fechahora"), @NamedQuery(name = "Articulos.findByIdusuario", query = "SELECT a FROM Articulos a WHERE a.idusuario = :idusuario")})
public class Articulos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idarticulo")
    private Integer idarticulo;
    @Basic(optional = false)
    @Column(name = "titulo")
    private String titulo;
    @Basic(optional = false)
    @Lob
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @Column(name = "fechahora")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechahora;
    @Basic(optional = false)
    @Column(name = "idusuario")
    private int idusuario;

    public Articulos() {
    }

    public Articulos(Integer idarticulo) {
        this.idarticulo = idarticulo;
    }

    public Articulos(Integer idarticulo, String titulo, String descripcion, Date fechahora, int idusuario) {
        this.idarticulo = idarticulo;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.fechahora = fechahora;
        this.idusuario = idusuario;
    }

    public Integer getIdarticulo() {
        return idarticulo;
    }

    public void setIdarticulo(Integer idarticulo) {
        this.idarticulo = idarticulo;
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

    public int getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idarticulo != null ? idarticulo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Articulos)) {
            return false;
        }
        Articulos other = (Articulos) object;
        if ((this.idarticulo == null && other.idarticulo != null) || (this.idarticulo != null && !this.idarticulo.equals(other.idarticulo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.ues.jhard.jpa.Articulos[idarticulo=" + idarticulo + "]";
    }

}
