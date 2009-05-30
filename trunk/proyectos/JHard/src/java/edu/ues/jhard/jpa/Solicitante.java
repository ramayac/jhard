/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.ues.jhard.jpa;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Hugol
 */
@Entity
@Table(name = "solicitante")
@NamedQueries({@NamedQuery(name = "Solicitante.findAll", query = "SELECT s FROM Solicitante s"), @NamedQuery(name = "Solicitante.findByIdsolicitante", query = "SELECT s FROM Solicitante s WHERE s.idsolicitante = :idsolicitante"), @NamedQuery(name = "Solicitante.findByApellidos", query = "SELECT s FROM Solicitante s WHERE s.apellidos = :apellidos"), @NamedQuery(name = "Solicitante.findByNombres", query = "SELECT s FROM Solicitante s WHERE s.nombres = :nombres"), @NamedQuery(name = "Solicitante.findByTipodocumento", query = "SELECT s FROM Solicitante s WHERE s.tipodocumento = :tipodocumento"), @NamedQuery(name = "Solicitante.findByValordocumento", query = "SELECT s FROM Solicitante s WHERE s.valordocumento = :valordocumento"), @NamedQuery(name = "Solicitante.findByVisible", query = "SELECT s FROM Solicitante s WHERE s.visible = :visible")})
public class Solicitante implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idsolicitante")
    private Integer idsolicitante;
    @Basic(optional = false)
    @Column(name = "apellidos")
    private String apellidos;
    @Basic(optional = false)
    @Column(name = "nombres")
    private String nombres;
    @Basic(optional = false)
    @Column(name = "tipodocumento")
    private String tipodocumento;
    @Basic(optional = false)
    @Column(name = "valordocumento")
    private String valordocumento;
    @Basic(optional = false)
    @Column(name = "visible")
    private int visible;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idsolicitante")
    private List<Reserva> reservaCollection;

    public Solicitante() {
    }

    public Solicitante(Integer idsolicitante) {
        this.idsolicitante = idsolicitante;
    }

    public Solicitante(Integer idsolicitante, String apellidos, String nombres, String tipodocumento, String valordocumento, int visible) {
        this.idsolicitante = idsolicitante;
        this.apellidos = apellidos;
        this.nombres = nombres;
        this.tipodocumento = tipodocumento;
        this.valordocumento = valordocumento;
        this.visible = visible;
    }

    public Integer getIdsolicitante() {
        return idsolicitante;
    }

    public void setIdsolicitante(Integer idsolicitante) {
        this.idsolicitante = idsolicitante;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getTipodocumento() {
        return tipodocumento;
    }

    public void setTipodocumento(String tipodocumento) {
        this.tipodocumento = tipodocumento;
    }

    public String getValordocumento() {
        return valordocumento;
    }

    public void setValordocumento(String valordocumento) {
        this.valordocumento = valordocumento;
    }

    public int getVisible() {
        return visible;
    }

    public void setVisible(int visible) {
        this.visible = visible;
    }

    public List<Reserva> getReservaCollection() {
        return reservaCollection;
    }

    public void setReservaCollection(List<Reserva> reservaCollection) {
        this.reservaCollection = reservaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idsolicitante != null ? idsolicitante.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Solicitante)) {
            return false;
        }
        Solicitante other = (Solicitante) object;
        if ((this.idsolicitante == null && other.idsolicitante != null) || (this.idsolicitante != null && !this.idsolicitante.equals(other.idsolicitante))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "JPA.Solicitante[idsolicitante=" + idsolicitante + "]";
    }

}
