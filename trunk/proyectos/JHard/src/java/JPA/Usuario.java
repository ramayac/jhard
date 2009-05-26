/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package JPA;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Hugol
 */
@Entity
@Table(name = "usuario")
@NamedQueries({@NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u"), @NamedQuery(name = "Usuario.findByIdusuario", query = "SELECT u FROM Usuario u WHERE u.idusuario = :idusuario"), @NamedQuery(name = "Usuario.findByNombre", query = "SELECT u FROM Usuario u WHERE u.nombre = :nombre"), @NamedQuery(name = "Usuario.findByClave", query = "SELECT u FROM Usuario u WHERE u.clave = :clave")})
public class Usuario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idusuario")
    private Integer idusuario;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "clave")
    private String clave;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idusuario")
    private List<Instructor> instructorCollection;
    @JoinColumn(name = "idrol", referencedColumnName = "idrol")
    @ManyToOne
    private Rol idrol;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idusuario")
    private List<Administrador> administradorCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idusuario")
    private List<Estudiante> estudianteCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idusuario")
    private List<Solicitud> solicitudCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idusuario")
    private List<Bitacoracambiosusuario> bitacoracambiosusuarioCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idusuario")
    private List<Reserva> reservaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idusuario")
    private List<Docente> docenteCollection;

    public Usuario() {
    }

    public Usuario(Integer idusuario) {
        this.idusuario = idusuario;
    }

    public Usuario(Integer idusuario, String nombre, String clave) {
        this.idusuario = idusuario;
        this.nombre = nombre;
        this.clave = clave;
    }

    public Integer getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(Integer idusuario) {
        this.idusuario = idusuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public List<Instructor> getInstructorCollection() {
        return instructorCollection;
    }

    public void setInstructorCollection(List<Instructor> instructorCollection) {
        this.instructorCollection = instructorCollection;
    }

    public Rol getIdrol() {
        return idrol;
    }

    public void setIdrol(Rol idrol) {
        this.idrol = idrol;
    }

    public List<Administrador> getAdministradorCollection() {
        return administradorCollection;
    }

    public void setAdministradorCollection(List<Administrador> administradorCollection) {
        this.administradorCollection = administradorCollection;
    }

    public List<Estudiante> getEstudianteCollection() {
        return estudianteCollection;
    }

    public void setEstudianteCollection(List<Estudiante> estudianteCollection) {
        this.estudianteCollection = estudianteCollection;
    }

    public List<Solicitud> getSolicitudCollection() {
        return solicitudCollection;
    }

    public void setSolicitudCollection(List<Solicitud> solicitudCollection) {
        this.solicitudCollection = solicitudCollection;
    }

    public List<Bitacoracambiosusuario> getBitacoracambiosusuarioCollection() {
        return bitacoracambiosusuarioCollection;
    }

    public void setBitacoracambiosusuarioCollection(List<Bitacoracambiosusuario> bitacoracambiosusuarioCollection) {
        this.bitacoracambiosusuarioCollection = bitacoracambiosusuarioCollection;
    }

    public List<Reserva> getReservaCollection() {
        return reservaCollection;
    }

    public void setReservaCollection(List<Reserva> reservaCollection) {
        this.reservaCollection = reservaCollection;
    }

    public List<Docente> getDocenteCollection() {
        return docenteCollection;
    }

    public void setDocenteCollection(List<Docente> docenteCollection) {
        this.docenteCollection = docenteCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idusuario != null ? idusuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.idusuario == null && other.idusuario != null) || (this.idusuario != null && !this.idusuario.equals(other.idusuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "JPA.Usuario[idusuario=" + idusuario + "]";
    }

}
