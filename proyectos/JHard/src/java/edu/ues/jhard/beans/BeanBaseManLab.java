package edu.ues.jhard.beans;

import edu.ues.jhard.jpa.Docente;
import edu.ues.jhard.jpa.Instructor;
import edu.ues.jhard.jpa.Estudiante;
import edu.ues.jhard.jpa.Facultad;
import edu.ues.jhard.jpa.Carrera;
import edu.ues.jhard.jpa.Materia;
import edu.ues.jhard.jpa.Estadocurso;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 * @author Rodrigo Ramayac
 * @author Hugol
 */
public class BeanBaseManLab extends BeanBase{

    /*De lo mas facil a lo mas dificil: Facultad -> Carrera -> Materia y EstadoCurso
     metodos: create, delete, get, getAll, recargar, update, NO search.
     */

    /**
     * Metodo para obtener una Facultad por su ID
     * @param idFacultad id de la facultad que se desea
     * @return
     */
    public Facultad getFacultad(int idFacultad) {
        EntityManager em = this.getEntityManager();
        Facultad f = em.find(Facultad.class, idFacultad);
        return f;
    }

    /**
     * Metodo para obtener una Facultad por su ID
     * @param idFacultad id de la facultad que se desea
     * @return
     */
    public List<Facultad> getAllFacultades() {
        EntityManager em = this.getEntityManager();
        Query q = em.createNamedQuery("Facultad.findAll");
        return (List<Facultad>)q.getResultList();
    }

    /**
     * Metodo para añadir un objeto Facultad
     * @param Facultad
     */
    public boolean createFacultad(Facultad Facultad){
        try {
            EntityManager em = this.getEntityManager();
            em.getTransaction().begin();
            em.persist(Facultad);
            em.getTransaction().commit();
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    /**
     * Metodo para eliminar una Facultad por su ID
     * @param idFacultad
     */
    public void deleteFacultad(int idFacultad) {
        EntityManager em = this.getEntityManager();
        Facultad f = (Facultad)em.find(Facultad.class, idFacultad);
        em.getTransaction().begin();
        em.remove(f);
        em.getTransaction().commit();
    }

    /**
     * Metodo para eliminar un objeto Facultad
     * @param Facultad
     */
    public void deleteFacultad(Facultad Facultad){
        EntityManager em = this.getEntityManager();
        Facultad f = em.find(Facultad.class, Facultad.getIdfacultad());
        if(f==null) return;
        em.getTransaction().begin();
        em.remove(f);
        em.getTransaction().commit();
    }

    /**
     * Metodo para actualizar un objeto Facultad
     * @param Facultad
     */
    public void updateFacultad(Facultad Facultad){
        EntityManager em = this.getEntityManager();
        Facultad f = em.find(Facultad.class, Facultad.getIdfacultad());
        f = Facultad;
        em.getTransaction().begin();
        em.merge(f);
        em.getTransaction().commit();
    }

    /**
     * Metodo para recargar una Facultad por demanda, por su ID
     * @param Facultad
     */
    public Facultad recargarFacultad(Integer idFacultad){
        EntityManager em = this.getEntityManager();
        Facultad f = em.find(Facultad.class, idFacultad);
        em.getTransaction().begin();
        em.refresh(f);
        em.getTransaction().commit();
        return f;
    }

    /**
     * Metodo para recargar una Facultad por demanda
     * @param Facultad
     */
    public Facultad recargarFacultad(Facultad Facultad){
        EntityManager em = this.getEntityManager();
        Facultad f = em.find(Facultad.class, Facultad.getIdfacultad());
        f = Facultad;
        em.getTransaction().begin();
        em.refresh(f);
        em.getTransaction().commit();
        return f;
    }

    //public Facultad searchFacultad(){}

    /**
     * Metodo para obtener una Carrera por su ID
     * @param idCarrera id de la facultad que se desea
     * @return
     */
    public Carrera getCarrera(int idCarrera) {
        EntityManager em = this.getEntityManager();
        Carrera c = em.find(Carrera.class, idCarrera);
        return c;
    }

    /**
     * Metodo para obtener una Carrera por su ID
     * @param idCarrera id de la facultad que se desea
     * @return
     */
    public List<Carrera> getAllCarreras() {
        EntityManager em = this.getEntityManager();
        Query q = em.createNamedQuery("Carrera.findAll");
        return (List<Carrera>)q.getResultList();
    }

    /**
     * Metodo para añadir un objeto Carrera
     * @param Carrera
     */
    public boolean createCarrera(Carrera carrera){
        try {
            EntityManager em = this.getEntityManager();
            em.getTransaction().begin();
            em.persist(carrera);
            em.getTransaction().commit();
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    /**
     * Metodo para eliminar una Carrera por su ID
     * @param idCarrera
     */
    public void deleteCarrera(int idCarrera) {
        EntityManager em = this.getEntityManager();
        Carrera c = (Carrera)em.find(Carrera.class, idCarrera);
        em.getTransaction().begin();
        em.remove(c);
        em.getTransaction().commit();
    }

    /**
     * Metodo para eliminar un objeto Carrera
     * @param Carrera
     */
    public void deleteCarrera(Carrera carrera){
        EntityManager em = this.getEntityManager();
        Carrera c = em.find(Carrera.class, carrera.getIdfacultad());
        if(c==null) return;
        em.getTransaction().begin();
        em.remove(c);
        em.getTransaction().commit();
    }

    /**
     * Metodo para actualizar un objeto Carrera
     * @param Carrera
     */
    public void updateCarrera(Carrera carrera){
        EntityManager em = this.getEntityManager();
        Carrera c = em.find(Carrera.class, carrera.getIdfacultad());
        c = carrera;
        em.getTransaction().begin();
        em.merge(c);
        em.getTransaction().commit();
    }

    /**
     * Metodo para recargar una Carrera por demanda, por su ID
     * @param Carrera
     */
    public Carrera recargarCarrera(Integer idCarrera){
        EntityManager em = this.getEntityManager();
        Carrera c = em.find(Carrera.class, idCarrera);
        em.getTransaction().begin();
        em.refresh(c);
        em.getTransaction().commit();
        return c;
    }

    /**
     * Metodo para recargar una Carrera por demanda
     * @param Carrera
     */
    public Carrera recargarCarrera(Carrera carrera){
        EntityManager em = this.getEntityManager();
        Carrera c = em.find(Carrera.class, carrera.getIdfacultad());
        c = carrera;
        em.getTransaction().begin();
        em.refresh(c);
        em.getTransaction().commit();
        return c;
    }

    /**
     * Metodo para obtener una Materia por su ID
     * @param idMateria id de la materia que se desea
     * @return
     */
    public Materia getMateria(int idMateria) {
        EntityManager em = this.getEntityManager();
        Materia m = em.find(Materia.class, idMateria);
        return m;
    }

    /**
     * Metodo para obtener una Materia por su ID
     * @param idMateria id de la materia que se desea
     * @return
     */
    public List<Materia> getAllMaterias() {
        EntityManager em = this.getEntityManager();
        Query q = em.createNamedQuery("Materia.findAll");
        return (List<Materia>)q.getResultList();
    }

    /**
     * Metodo para añadir un objeto Materia
     * @param Materia
     */
    public boolean createMateria(Materia Materia){
        try {
            EntityManager em = this.getEntityManager();
            em.getTransaction().begin();
            em.persist(Materia);
            em.getTransaction().commit();
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    /**
     * Metodo para eliminar una Materia por su ID
     * @param idMateria
     */
    public void deleteMateria(int idMateria) {
        EntityManager em = this.getEntityManager();
        Materia m = (Materia)em.find(Materia.class, idMateria);
        em.getTransaction().begin();
        em.remove(m);
        em.getTransaction().commit();
    }

    /**
     * Metodo para eliminar un objeto Materia
     * @param Materia
     */
    public void deleteMateria(Materia Materia){
        EntityManager em = this.getEntityManager();
        Materia m = em.find(Materia.class, Materia.getIdmateria());
        if(m==null) return;
        em.getTransaction().begin();
        em.remove(m);
        em.getTransaction().commit();
    }

    /**
     * Metodo para actualizar un objeto Materia
     * @param Materia
     */
    public void updateMateria(Materia Materia){
        EntityManager em = this.getEntityManager();
        Materia m = em.find(Materia.class, Materia.getIdmateria());
        m = Materia;
        em.getTransaction().begin();
        em.merge(m);
        em.getTransaction().commit();
    }

    /**
     * Metodo para recargar una Materia por demanda, por su ID
     * @param Materia
     */
    public Materia recargarMateria(Integer idMateria){
        EntityManager em = this.getEntityManager();
        Materia m = em.find(Materia.class, idMateria);
        em.getTransaction().begin();
        em.refresh(m);
        em.getTransaction().commit();
        return m;
    }

    /**
     * Metodo para recargar una Materia por demanda
     * @param Materia
     */
    public Materia recargarMateria(Materia Materia){
        EntityManager em = this.getEntityManager();
        Materia m = em.find(Materia.class, Materia.getIdmateria());
        m = Materia;
        em.getTransaction().begin();
        em.refresh(m);
        em.getTransaction().commit();
        return m;
    }

        /**
     * Metodo para obtener una Estadocurso por su ID
     * @param idEstadocurso id del curso que se desea
     * @return
     */
    public Estadocurso getEstadocurso(int idEstadocurso) {
        EntityManager em =this.getEntityManager();
        Estadocurso ec =em.find(Estadocurso.class, idEstadocurso);
        return ec;
    }

    /**
     * Metodo para obtener una Estadocurso por su ID
     * @param idEstadocurso id del curso que se desea
     * @return
     */
    public List<Estadocurso> getAllEstadocursos() {
        EntityManager em =this.getEntityManager();
        Query q = em.createNamedQuery("Estadocurso.findAll");
        return (List<Estadocurso>)q.getResultList();
    }

    /**
     * Metodo para añadir un objeto Estadocurso
     * @param estadoCurso
     */
    public boolean createEstadocurso(Estadocurso estadoCurso){
        try {
            EntityManager em =this.getEntityManager();
            em.getTransaction().begin();
            em.persist(estadoCurso);
            em.getTransaction().commit();
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    /**
     * Metodo para eliminar una Estadocurso por su ID
     * @param idEstadocurso
     */
    public void deleteEstadocurso(int idEstadocurso) {
        EntityManager em =this.getEntityManager();
        Estadocurso ec =(Estadocurso)em.find(Estadocurso.class, idEstadocurso);
        em.getTransaction().begin();
        em.remove(ec);
        em.getTransaction().commit();
    }

    /**
     * Metodo para eliminar un objeto Estadocurso
     * @param estadoCurso
     */
    public void deleteEstadocurso(Estadocurso estadoCurso){
        EntityManager em =this.getEntityManager();
        Estadocurso ec =em.find(Estadocurso.class, estadoCurso.getIdestadocurso());
        if(ec==null) return;
        em.getTransaction().begin();
        em.remove(ec);
        em.getTransaction().commit();
    }

    /**
     * Metodo para actualizar un objeto Estadocurso
     * @param Estadocurso
     */
    public void updateEstadocurso(Estadocurso estadoCurso){
        EntityManager em =this.getEntityManager();
        Estadocurso ec = em.find(Estadocurso.class, estadoCurso.getIdestadocurso());
        ec = estadoCurso;
        em.getTransaction().begin();
        em.merge(ec);
        em.getTransaction().commit();
    }

    /**
     * Metodo para recargar una Estadocurso por demanda, por su ID
     * @param idEstadocurso
     */
    public Estadocurso recargarEstadocurso(Integer idEstadocurso){
        EntityManager em =this.getEntityManager();
        Estadocurso ec = em.find(Estadocurso.class, idEstadocurso);
        em.getTransaction().begin();
        em.refresh(ec);
        em.getTransaction().commit();
        return ec;
    }

    /**
     * Metodo para recargar una Estadocurso por demanda
     * @param estadoCurso
     */
    public Estadocurso recargarEstadocurso(Estadocurso estadoCurso){
        EntityManager em =this.getEntityManager();
        Estadocurso ec =em.find(Estadocurso.class, estadoCurso.getIdestadocurso());
        ec = estadoCurso;
        em.getTransaction().begin();
        em.refresh(ec);
        em.getTransaction().commit();
        return ec;
    }

    /* Docente, Instructore y Estudiante*/


    /**
     * Metodo para obtener una Docente por su ID
     * @param idDocente id del docente que se desea
     * @return
     */
    public Docente getDocente(int idDocente) {
        EntityManager em = this.getEntityManager();
        Docente d = em.find(Docente.class, idDocente);
        return d;
    }

    /**
     * Metodo para obtener una Docente por su ID
     * @param idDocente id del docente que se desea
     * @return
     */
    public List<Docente> getAllDocentes() {
        EntityManager em = this.getEntityManager();
        Query q = em.createNamedQuery("Docente.findAll");
        return (List<Docente>)q.getResultList();
    }

    /**
     * Metodo para añadir un objeto Docente
     * @param Docente
     */
    public boolean createDocente(Docente docente){
        try {
            EntityManager em = this.getEntityManager();
            em.getTransaction().begin();
            em.persist(docente);
            em.getTransaction().commit();
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    /**
     * Metodo para eliminar una Docente por su ID
     * @param idDocente
     */
    public void deleteDocente(int idDocente) {
        EntityManager em = this.getEntityManager();
        Docente d = (Docente)em.find(Docente.class, idDocente);
        em.getTransaction().begin();
        em.remove(d);
        em.getTransaction().commit();
    }

    /**
     * Metodo para eliminar un objeto Docente
     * @param Docente
     */
    public void deleteDocente(Docente docente){
        EntityManager em = this.getEntityManager();
        Docente d = em.find(Docente.class, docente.getIddocente());
        if(d==null) return;
        em.getTransaction().begin();
        em.remove(d);
        em.getTransaction().commit();
    }

    /**
     * Metodo para actualizar un objeto Docente
     * @param Docente
     */
    public void updateDocente(Docente docente){
        EntityManager em = this.getEntityManager();
        Docente d = em.find(Docente.class, docente.getIddocente());
        d = docente;
        em.getTransaction().begin();
        em.merge(d);
        em.getTransaction().commit();
    }

    /**
     * Metodo para recargar una Docente por demanda, por su ID
     * @param Docente
     */
    public Docente recargarDocente(Integer idDocente){
        EntityManager em = this.getEntityManager();
        Docente d = em.find(Docente.class, idDocente);
        em.getTransaction().begin();
        em.refresh(d);
        em.getTransaction().commit();
        return d;
    }

    /**
     * Metodo para recargar una Docente por demanda
     * @param Docente
     */
    public Docente recargarDocente(Docente docente){
        EntityManager em = this.getEntityManager();
        Docente d = em.find(Docente.class, docente.getIddocente());
        d = docente;
        em.getTransaction().begin();
        em.refresh(d);
        em.getTransaction().commit();
        return d;
    }

    /**
     * Metodo para obtener una Estudiante por su ID
     * @param idEstudiante id del estudiante que se desea
     * @return
     */
    public Estudiante getEstudiante(int idEstudiante) {
        EntityManager em = this.getEntityManager();
        Estudiante est = em.find(Estudiante.class, idEstudiante);
        return est;
    }

    /**
     * Metodo para obtener una Estudiante por su ID
     * @param idEstudiante id del estudiante que se desea
     * @return
     */
    public List<Estudiante> getAllEstudiantes() {
        EntityManager em = this.getEntityManager();
        Query q = em.createNamedQuery("Estudiante.findAll");
        return (List<Estudiante>)q.getResultList();
    }

    /**
     * Metodo para añadir un objeto Estudiante
     * @param Estudiante
     */
    public boolean createEstudiante(Estudiante estudiante){
        try {
            EntityManager em = this.getEntityManager();
            em.getTransaction().begin();
            em.persist(estudiante);
            em.getTransaction().commit();
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    /**
     * Metodo para eliminar una Estudiante por su ID
     * @param idEstudiante
     */
    public void deleteEstudiante(int idEstudiante) {
        EntityManager em = this.getEntityManager();
        Estudiante est = (Estudiante)em.find(Estudiante.class, idEstudiante);
        em.getTransaction().begin();
        em.remove(est);
        em.getTransaction().commit();
    }

    /**
     * Metodo para eliminar un objeto Estudiante
     * @param Estudiante
     */
    public void deleteEstudiante(Estudiante estudiante){
        EntityManager em = this.getEntityManager();
        Estudiante est = em.find(Estudiante.class, estudiante.getIdestudiante());
        if(est==null) return;
        em.getTransaction().begin();
        em.remove(est);
        em.getTransaction().commit();
    }

    /**
     * Metodo para actualizar un objeto Estudiante
     * @param Estudiante
     */
    public void updateEstudiante(Estudiante estudiante){
        EntityManager em = this.getEntityManager();
        Estudiante est = em.find(Estudiante.class, estudiante.getIdestudiante());
        est = estudiante;
        em.getTransaction().begin();
        em.merge(est);
        em.getTransaction().commit();
    }

    /**
     * Metodo para recargar una Estudiante por demanda, por su ID
     * @param Estudiante
     */
    public Estudiante recargarEstudiante(Integer idEstudiante){
        EntityManager em = this.getEntityManager();
        Estudiante est = em.find(Estudiante.class, idEstudiante);
        em.getTransaction().begin();
        em.refresh(est);
        em.getTransaction().commit();
        return est;
    }

    /**
     * Metodo para recargar una Estudiante por demanda
     * @param Estudiante
     */
    public Estudiante recargarEstudiante(Estudiante estudiante){
        EntityManager em = this.getEntityManager();
        Estudiante est = em.find(Estudiante.class, estudiante.getIdestudiante());
        est = estudiante;
        em.getTransaction().begin();
        em.refresh(est);
        em.getTransaction().commit();
        return est;
    }

    /**
     * Metodo para obtener una Instructor por su ID
     * @param idInstructor id del instructor que se desea
     * @return
     */
    public Instructor getInstructor(int idInstructor) {
        EntityManager em = this.getEntityManager();
        Instructor i = em.find(Instructor.class, idInstructor);
        return i;
    }

    /**
     * Metodo para obtener una Instructor por su ID
     * @param idInstructor id del instructor que se desea
     * @return
     */
    public List<Instructor> getAllInstructors() {
        EntityManager em = this.getEntityManager();
        Query q = em.createNamedQuery("Instructor.findAll");
        return (List<Instructor>)q.getResultList();
    }

    /**
     * Metodo para añadir un objeto Instructor
     * @param Instructor
     */
    public boolean createInstructor(Instructor instructor){
        try {
            EntityManager em = this.getEntityManager();
            em.getTransaction().begin();
            em.persist(instructor);
            em.getTransaction().commit();
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    /**
     * Metodo para eliminar una Instructor por su ID
     * @param idInstructor
     */
    public void deleteInstructor(int idInstructor) {
        EntityManager em = this.getEntityManager();
        Instructor i = (Instructor)em.find(Instructor.class, idInstructor);
        em.getTransaction().begin();
        em.remove(i);
        em.getTransaction().commit();
    }

    /**
     * Metodo para eliminar un objeto Instructor
     * @param Instructor
     */
    public void deleteInstructor(Instructor instructor){
        EntityManager em = this.getEntityManager();
        Instructor i = em.find(Instructor.class, instructor.getIdinstructor());
        if(i==null) return;
        em.getTransaction().begin();
        em.remove(i);
        em.getTransaction().commit();
    }

    /**
     * Metodo para actualizar un objeto Instructor
     * @param Instructor
     */
    public void updateInstructor(Instructor instructor){
        EntityManager em = this.getEntityManager();
        Instructor i = em.find(Instructor.class, instructor.getIdinstructor());
        i = instructor;
        em.getTransaction().begin();
        em.merge(i);
        em.getTransaction().commit();
    }

    /**
     * Metodo para recargar una Instructor por demanda, por su ID
     * @param Instructor
     */
    public Instructor recargarInstructor(Integer idInstructor){
        EntityManager em = this.getEntityManager();
        Instructor i = em.find(Instructor.class, idInstructor);
        em.getTransaction().begin();
        em.refresh(i);
        em.getTransaction().commit();
        return i;
    }

    /**
     * Metodo para recargar una Instructor por demanda
     * @param Instructor
     */
    public Instructor recargarInstructor(Instructor instructor){
        EntityManager em = this.getEntityManager();
        Instructor i = em.find(Instructor.class, instructor.getIdinstructor());
        i = instructor;
        em.getTransaction().begin();
        em.refresh(i);
        em.getTransaction().commit();
        return i;
    }

    


    @Deprecated
    public Docente getDocenteByUsuario(Integer idUsuario) {
        EntityManager em=this.getEntityManager();
        Query q=em.createNamedQuery("Docente.findByIdUsuario");
        q.setParameter("idusuario", idUsuario);
        Docente d=(Docente)q.getSingleResult();
        em.refresh(d);
        return d;
    }

    @Deprecated
    public Docente[] getDocentes() {
        EntityManager em=this.getEntityManager();
        Query q=em.createNamedQuery("Docente.findAll");
        Docente[] d=(Docente[])q.getResultList().toArray(new Docente[0]);
        for(int i=0;i<d.length;i++)
            em.refresh(d[i]);
        return d;
    }
}

