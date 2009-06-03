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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author robertux
 */
@Entity
@Table(name = "atributohardware", catalog = "jhard", schema = "")
@NamedQueries({@NamedQuery(name = "Atributohardware.findAll", query = "SELECT a FROM Atributohardware a"), @NamedQuery(name = "Atributohardware.findByIdatributohardware", query = "SELECT a FROM Atributohardware a WHERE a.idatributohardware = :idatributohardware"), @NamedQuery(name = "Atributohardware.findByNombre", query = "SELECT a FROM Atributohardware a WHERE a.nombre = :nombre"), @NamedQuery(name = "Atributohardware.findByValor", query = "SELECT a FROM Atributohardware a WHERE a.valor = :valor"), @NamedQuery(name = "Atributohardware.findByUnidadmedida", query = "SELECT a FROM Atributohardware a WHERE a.unidadmedida = :unidadmedida")})
public class Atributohardware implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idatributohardware", nullable = false)
    private Integer idatributohardware;
    @Basic(optional = false)
    @Column(name = "nombre", nullable = false, length = 45)
    private String nombre;
    @Basic(optional = false)
    @Column(name = "valor", nullable = false, length = 45)
    private String valor;
    @Basic(optional = false)
    @Column(name = "unidadmedida", nullable = false, length = 45)
    private String unidadmedida;
    @JoinColumn(name = "idhardware", referencedColumnName = "idequipo")
    @ManyToOne
    private Equipo idhardware;
    @JoinColumn(name = "idpieza", referencedColumnName = "idpieza")
    @ManyToOne
    private Pieza idpieza;
    @JoinColumn(name = "idaccesorio", referencedColumnName = "idaccesorio")
    @ManyToOne
    private Accesorio idaccesorio;

    public Atributohardware() {
    }

    public Atributohardware(Integer idatributohardware) {
        this.idatributohardware = idatributohardware;
    }

    public Atributohardware(Integer idatributohardware, String nombre, String valor, String unidadmedida) {
        this.idatributohardware = idatributohardware;
        this.nombre = nombre;
        this.valor = valor;
        this.unidadmedida = unidadmedida;
    }

    public Integer getIdatributohardware() {
        return idatributohardware;
    }

    public void setIdatributohardware(Integer idatributohardware) {
        this.idatributohardware = idatributohardware;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getUnidadmedida() {
        return unidadmedida;
    }

    public void setUnidadmedida(String unidadmedida) {
        this.unidadmedida = unidadmedida;
    }

    public Equipo getIdhardware() {
        return idhardware;
    }

    public void setIdhardware(Equipo idhardware) {
        this.idhardware = idhardware;
    }

    public Pieza getIdpieza() {
        return idpieza;
    }

    public void setIdpieza(Pieza idpieza) {
        this.idpieza = idpieza;
    }

    public Accesorio getIdaccesorio() {
        return idaccesorio;
    }

    public void setIdaccesorio(Accesorio idaccesorio) {
        this.idaccesorio = idaccesorio;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idatributohardware != null ? idatributohardware.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Atributohardware)) {
            return false;
        }
        Atributohardware other = (Atributohardware) object;
        if ((this.idatributohardware == null && other.idatributohardware != null) || (this.idatributohardware != null && !this.idatributohardware.equals(other.idatributohardware))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.ues.jhard.jpa.Atributohardware[idatributohardware=" + idatributohardware + "]";
    }

}
