/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package JPA;

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
 * @author Hugol
 */
@Entity
@Table(name = "atributohardware")
@NamedQueries({@NamedQuery(name = "Atributohardware.findAll", query = "SELECT a FROM Atributohardware a"), @NamedQuery(name = "Atributohardware.findByIdatributohardware", query = "SELECT a FROM Atributohardware a WHERE a.idatributohardware = :idatributohardware"), @NamedQuery(name = "Atributohardware.findByNombre", query = "SELECT a FROM Atributohardware a WHERE a.nombre = :nombre"), @NamedQuery(name = "Atributohardware.findByValor", query = "SELECT a FROM Atributohardware a WHERE a.valor = :valor"), @NamedQuery(name = "Atributohardware.findByUnidadmedida", query = "SELECT a FROM Atributohardware a WHERE a.unidadmedida = :unidadmedida")})
public class Atributohardware implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idatributohardware")
    private Integer idatributohardware;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "valor")
    private String valor;
    @Basic(optional = false)
    @Column(name = "unidadmedida")
    private String unidadmedida;
    @JoinColumn(name = "idhardware", referencedColumnName = "idaccesorio")
    @ManyToOne(optional = false)
    private Accesorio idhardware;
    @JoinColumn(name = "idhardware", referencedColumnName = "idequipo")
    @ManyToOne(optional = false)
    private Equipo idhardware1;
    @JoinColumn(name = "idhardware", referencedColumnName = "idpieza")
    @ManyToOne(optional = false)
    private Pieza idhardware2;

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

    public Accesorio getIdhardware() {
        return idhardware;
    }

    public void setIdhardware(Accesorio idhardware) {
        this.idhardware = idhardware;
    }

    public Equipo getIdhardware1() {
        return idhardware1;
    }

    public void setIdhardware1(Equipo idhardware1) {
        this.idhardware1 = idhardware1;
    }

    public Pieza getIdhardware2() {
        return idhardware2;
    }

    public void setIdhardware2(Pieza idhardware2) {
        this.idhardware2 = idhardware2;
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
        return "JPA.Atributohardware[idatributohardware=" + idatributohardware + "]";
    }

}
