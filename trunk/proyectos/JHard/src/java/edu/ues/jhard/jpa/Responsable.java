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
@Table(name = "responsable", catalog = "jhard", schema = "")
@NamedQueries({@NamedQuery(name = "Responsable.findAll", query = "SELECT r FROM Responsable r"), @NamedQuery(name = "Responsable.findByIdresponsable", query = "SELECT r FROM Responsable r WHERE r.idresponsable = :idresponsable"), @NamedQuery(name = "Responsable.findByApellidos", query = "SELECT r FROM Responsable r WHERE r.apellidos = :apellidos"), @NamedQuery(name = "Responsable.findByNombres", query = "SELECT r FROM Responsable r WHERE r.nombres = :nombres"), @NamedQuery(name = "Responsable.findByTipodocumento", query = "SELECT r FROM Responsable r WHERE r.tipodocumento = :tipodocumento"), @NamedQuery(name = "Responsable.findByValordocumento", query = "SELECT r FROM Responsable r WHERE r.valordocumento = :valordocumento"), @NamedQuery(name = "Responsable.findByVisible", query = "SELECT r FROM Responsable r WHERE r.visible = :visible")})
public class Responsable implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idresponsable", nullable = false)
    private Integer idresponsable;
    @Basic(optional = false)
    @Column(name = "apellidos", nullable = false, length = 200)
    private String apellidos;
    @Basic(optional = false)
    @Column(name = "nombres", nullable = false, length = 200)
    private String nombres;
    @Basic(optional = false)
    @Column(name = "tipodocumento", nullable = false, length = 45)
    private String tipodocumento;
    @Basic(optional = false)
    @Column(name = "valordocumento", nullable = false, length = 45)
    private String valordocumento;
    @Basic(optional = false)
    @Column(name = "visible", nullable = false)
    private int visible;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idresponsable")
    private List<Reserva> reservaCollection;

    public Responsable() {
    }

    public Responsable(Integer idresponsable) {
        this.idresponsable = idresponsable;
    }

    public Responsable(Integer idresponsable, String apellidos, String nombres, String tipodocumento, String valordocumento, int visible) {
        this.idresponsable = idresponsable;
        this.apellidos = apellidos;
        this.nombres = nombres;
        this.tipodocumento = tipodocumento;
        this.valordocumento = valordocumento;
        this.visible = visible;
    }

    public Integer getIdresponsable() {
        return idresponsable;
    }

    public void setIdresponsable(Integer idresponsable) {
        this.idresponsable = idresponsable;
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
        hash += (idresponsable != null ? idresponsable.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Responsable)) {
            return false;
        }
        Responsable other = (Responsable) object;
        if ((this.idresponsable == null && other.idresponsable != null) || (this.idresponsable != null && !this.idresponsable.equals(other.idresponsable))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.ues.jhard.jpa.Responsable[idresponsable=" + idresponsable + "]";
    }

}
