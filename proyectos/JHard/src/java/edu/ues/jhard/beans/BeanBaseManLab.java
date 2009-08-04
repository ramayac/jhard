package edu.ues.jhard.beans;

import edu.ues.jhard.jpa.Docente;
import edu.ues.jhard.jpa.Instructor;
import edu.ues.jhard.jpa.Estudiante;
import edu.ues.jhard.jpa.Facultad;
import edu.ues.jhard.jpa.Carrera;
import edu.ues.jhard.jpa.Materia;
import edu.ues.jhard.jpa.Estadocurso;
import edu.ues.jhard.jpa.Curso;
import edu.ues.jhard.jpa.Clase;
import edu.ues.jhard.jpa.Asistencia;
import edu.ues.jhard.jpa.Cicloanyo;
import edu.ues.jhard.jpa.Inscripcion;
import edu.ues.jhard.jpa.Horario;
import java.sql.Time;
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

    /**
     * Metodo para obtener una Inscripcion por su ID
     * @param idInscripcion id de la inscripcion que se desea
     * @return
     */
    public Inscripcion getInscripcion(int idInscripcion) {
        EntityManager em = this.getEntityManager();
        Inscripcion i = em.find(Inscripcion.class, idInscripcion);
        return i;
    }

    /**
     * Metodo para obtener una Inscripcion por su ID
     * @param idInscripcion id de la inscripcion que se desea
     * @return
     */
    public List<Inscripcion> getAllInscripcions() {
        EntityManager em = this.getEntityManager();
        Query q = em.createNamedQuery("Inscripcion.findAll");
        return (List<Inscripcion>)q.getResultList();
    }

    /**
     * Metodo para añadir un objeto Inscripcion
     * @param Inscripcion
     */
    public boolean createInscripcion(Inscripcion inscripcion){
        try {
            EntityManager em = this.getEntityManager();
            em.getTransaction().begin();
            em.persist(inscripcion);
            em.getTransaction().commit();
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    /**
     * Metodo para eliminar una Inscripcion por su ID
     * @param idInscripcion
     */
    public void deleteInscripcion(int idInscripcion) {
        EntityManager em = this.getEntityManager();
        Inscripcion i = (Inscripcion)em.find(Inscripcion.class, idInscripcion);
        em.getTransaction().begin();
        em.remove(i);
        em.getTransaction().commit();
    }

    /**
     * Metodo para eliminar un objeto Inscripcion
     * @param Inscripcion
     */
    public void deleteInscripcion(Inscripcion inscripcion){
        EntityManager em = this.getEntityManager();
        Inscripcion i = em.find(Inscripcion.class, inscripcion.getIdinscripcion());
        if(i==null) return;
        em.getTransaction().begin();
        em.remove(i);
        em.getTransaction().commit();
    }

    /**
     * Metodo para actualizar un objeto Inscripcion
     * @param Inscripcion
     */
    public void updateInscripcion(Inscripcion inscripcion){
        EntityManager em = this.getEntityManager();
        Inscripcion i = em.find(Inscripcion.class, inscripcion.getIdinscripcion());
        i = inscripcion;
        em.getTransaction().begin();
        em.merge(i);
        em.getTransaction().commit();
    }

    /**
     * Metodo para recargar una Inscripcion por demanda, por su ID
     * @param Inscripcion
     */
    public Inscripcion recargarInscripcion(Integer idInscripcion){
        EntityManager em = this.getEntityManager();
        Inscripcion i = em.find(Inscripcion.class, idInscripcion);
        em.getTransaction().begin();
        em.refresh(i);
        em.getTransaction().commit();
        return i;
    }

    /**
     * Metodo para recargar una Inscripcion por demanda
     * @param Inscripcion
     */
    public Inscripcion recargarInscripcion(Inscripcion inscripcion){
        EntityManager em = this.getEntityManager();
        Inscripcion i = em.find(Inscripcion.class, inscripcion.getIdinscripcion());
        i = inscripcion;
        em.getTransaction().begin();
        em.refresh(i);
        em.getTransaction().commit();
        return i;
    }

    /**
     * Metodo para obtener un Curso por su ID
     * @param idCurso id del curso que se desea
     * @return
     */
    public Curso getCurso(int idCurso) {
        EntityManager em = this.getEntityManager();
        Curso c = em.find(Curso.class, idCurso);
        return c;
    }

    /**
     * Metodo para obtener un Curso por su ID
     * @param idCurso id del curso que se desea
     * @return
     */
    public List<Curso> getAllCursos() {
        EntityManager em = this.getEntityManager();
        Query q = em.createNamedQuery("Curso.findAll");

        List<Curso> c = (List<Curso>)q.getResultList();

        for(int i=0;i<c.size();i++)
            em.refresh(c.get(i));
        
        return c;
    }


    /**
     * Metodo para obtener los cursos, asociado siempre del ciclo y año actual
     * @param docente
     * @param cicloanyo
     * @return
     */
    public List<Curso> getCursosCiclo() {
        EntityManager em = this.getEntityManager();
        Query q = em.createNamedQuery("Cicloanyo.findAll");
        List<Cicloanyo> cicloanyo = q.getResultList();

        q = em.createNamedQuery("Curso.findByCiclo");
        q.setParameter("idcicloanyo", cicloanyo.get(cicloanyo.size()-1));

        List<Curso> c = (List<Curso>)q.getResultList();

        for(int i=0;i<c.size();i++)
            em.refresh(c.get(i));

        return c;
    }


    /**
     * Metodo para obtener los cursos, asociados con un docente, siempre del ciclo y año actual
     * @param docente
     * @param cicloanyo
     * @return
     */
    public List<Curso> getCursosDocenteCiclo(Docente docente) {
        EntityManager em = this.getEntityManager();
        Query q = em.createNamedQuery("Cicloanyo.findAll");
        List<Cicloanyo> cicloanyo = q.getResultList();

        q = em.createNamedQuery("Curso.findByDocenteCiclo");
        q.setParameter("iddocente", docente);
        q.setParameter("idcicloanyo", cicloanyo.get(cicloanyo.size()-1));

        List<Curso> c = (List<Curso>)q.getResultList();

        for(int i=0;i<c.size();i++)
            em.refresh(c.get(i));

        return c;
    }

    /**
     * Metodos para obtener los cursos asociados con un instructor, siempre del ciclo y año actual
     * @param instructor
     * @param cicloanyo
     * @return
     */
    public List<Curso> getCursosInstructorCiclo(Instructor instructor) {
        EntityManager em = this.getEntityManager();
        Query q = em.createNamedQuery("Cicloanyo.findAll");
        List<Cicloanyo> cicloanyo = q.getResultList();

        q = em.createNamedQuery("Curso.findByInstructorCiclo");
        q.setParameter("idinstructor", instructor);
        q.setParameter("idcicloanyo", cicloanyo.get(cicloanyo.size()-1));

        List<Curso> c = (List<Curso>)q.getResultList();

        for(int i=0;i<c.size();i++)
            em.refresh(c.get(i));

        return c;
    }

    /**
     * Metodo para añadir un objeto Curso
     * @param Curso
     */
    public boolean createCurso(Curso curso){
        try {
            EntityManager em = this.getEntityManager();
            em.getTransaction().begin();
            em.persist(curso);
            em.getTransaction().commit();
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    /**
     * Metodo para eliminar un Curso por su ID
     * @param idCurso
     */
    public void deleteCurso(int idCurso) {
        EntityManager em = this.getEntityManager();
        Curso c = (Curso)em.find(Curso.class, idCurso);
        em.getTransaction().begin();
        em.remove(c);
        em.getTransaction().commit();
    }

    /**
     * Metodo para eliminar un objeto Curso
     * @param Curso
     */
    public void deleteCurso(Curso curso){
        EntityManager em = this.getEntityManager();
        Curso c = em.find(Curso.class, curso.getIdcurso());
        if(c==null) return;
        em.getTransaction().begin();
        em.remove(c);
        em.getTransaction().commit();
    }

    /**
     * Metodo para actualizar un objeto Curso
     * @param Curso
     */
    public void updateCurso(Curso curso){
        EntityManager em = this.getEntityManager();
        Curso c = em.find(Curso.class, curso.getIdcurso());
        c = curso;
        em.getTransaction().begin();
        em.merge(c);
        em.getTransaction().commit();
    }

    /**
     * Metodo para recargar un Curso por demanda, por su ID
     * @param Curso
     */
    public Curso recargarCurso(Integer idCurso){
        EntityManager em = this.getEntityManager();
        Curso c = em.find(Curso.class, idCurso);
        em.getTransaction().begin();
        em.refresh(c);
        em.getTransaction().commit();
        return c;
    }

    /**
     * Metodo para recargar un Curso por demanda
     * @param Curso
     */
    public Curso recargarCurso(Curso curso){
        EntityManager em = this.getEntityManager();
        Curso c = em.find(Curso.class, curso.getIdcurso());
        c = curso;
        em.getTransaction().begin();
        em.refresh(c);
        em.getTransaction().commit();
        return c;
    }

    /**
     * Metodo para obtener una Clase por su ID
     * @param idClase id de la clase que se desea
     * @return
     */
    public Clase getClase(int idClase) {
        EntityManager em = this.getEntityManager();
        Clase c = em.find(Clase.class, idClase);
        return c;
    }

    /**
     * Metodo para obtener una Clase por su ID
     * @param idClase id de la clase que se desea
     * @return
     */
    public List<Clase> getAllClases() {
        EntityManager em = this.getEntityManager();
        Query q = em.createNamedQuery("Clase.findAll");
        return (List<Clase>)q.getResultList();
    }

    /**
     * Metodo para añadir un objeto Clase
     * @param Clase
     */
    public boolean createClase(Clase clase){
        try {
            EntityManager em = this.getEntityManager();
            em.getTransaction().begin();
            em.persist(clase);
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    /**
     * Metodo para eliminar una Clase por su ID
     * @param idClase
     */
    public void deleteClase(int idClase) {
        EntityManager em = this.getEntityManager();
        Clase c = (Clase)em.find(Clase.class, idClase);
        em.getTransaction().begin();
        em.remove(c);
        em.getTransaction().commit();
    }

    /**
     * Metodo para eliminar un objeto Clase
     * @param Clase
     */
    public void deleteClase(Clase clase){
        EntityManager em = this.getEntityManager();
        Clase c = em.find(Clase.class, clase.getIdclase());
        if(c==null) return;
        em.getTransaction().begin();
        em.remove(c);
        em.getTransaction().commit();
    }

    /**
     * Metodo para actualizar un objeto Clase
     * @param Clase
     */
    public void updateClase(Clase clase){
        EntityManager em = this.getEntityManager();
        Clase c = em.find(Clase.class, clase.getIdclase());
        c = clase;
        em.getTransaction().begin();
        em.merge(c);
        em.getTransaction().commit();
    }

    /**
     * Metodo para recargar una Clase por demanda, por su ID
     * @param Clase
     */
    public Clase recargarClase(Integer idClase){
        EntityManager em = this.getEntityManager();
        Clase c = em.find(Clase.class, idClase);
        em.getTransaction().begin();
        em.refresh(c);
        em.getTransaction().commit();
        return c;
    }

    /**
     * Metodo para recargar una Clase por demanda
     * @param Clase
     */
    public Clase recargarClase(Clase clase){
        EntityManager em = this.getEntityManager();
        Clase c = em.find(Clase.class, clase.getIdclase());
        c = clase;
        em.getTransaction().begin();
        em.refresh(c);
        em.getTransaction().commit();
        return c;
    }

    /**
     * Metodo para obtener una Asistencia por su ID
     * @param idAsistencia id de la asistencia que se desea
     * @return
     */
    public Asistencia getAsistencia(int idAsistencia) {
        EntityManager em = this.getEntityManager();
        Asistencia a = em.find(Asistencia.class, idAsistencia);
        return a;
    }

    /**
     * Metodo para obtener una Asistencia por su ID
     * @param idAsistencia id de la asistencia que se desea
     * @return
     */
    public List<Asistencia> getAllAsistencias() {
        EntityManager em = this.getEntityManager();
        Query q = em.createNamedQuery("Asistencia.findAll");
        return (List<Asistencia>)q.getResultList();
    }

    /**
     * Metodo para añadir un objeto Asistencia
     * @param Asistencia
     */
    public boolean createAsistencia(Asistencia clase){
        try {
            EntityManager em = this.getEntityManager();
            em.getTransaction().begin();
            em.persist(clase);
            em.getTransaction().commit();
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    /**
     * Metodo para eliminar una Asistencia por su ID
     * @param idAsistencia
     */
    public void deleteAsistencia(int idAsistencia) {
        EntityManager em = this.getEntityManager();
        Asistencia a = (Asistencia)em.find(Asistencia.class, idAsistencia);
        em.getTransaction().begin();
        em.remove(a);
        em.getTransaction().commit();
    }

    /**
     * Metodo para eliminar un objeto Asistencia
     * @param Asistencia
     */
    public void deleteAsistencia(Asistencia asistencia){
        EntityManager em = this.getEntityManager();
        Asistencia a = em.find(Asistencia.class, asistencia.getIdasistencia());
        if(a==null) return;
        em.getTransaction().begin();
        em.remove(a);
        em.getTransaction().commit();
    }

    /**
     * Metodo para actualizar un objeto Asistencia
     * @param Asistencia
     */
    public void updateAsistencia(Asistencia clase){
        EntityManager em = this.getEntityManager();
        Asistencia a = em.find(Asistencia.class, clase.getIdasistencia());
        a = clase;
        em.getTransaction().begin();
        em.merge(a);
        em.getTransaction().commit();
    }

    /**
     * Metodo para recargar una Asistencia por demanda, por su ID
     * @param Asistencia
     */
    public Asistencia recargarAsistencia(Integer idAsistencia){
        EntityManager em = this.getEntityManager();
        Asistencia a = em.find(Asistencia.class, idAsistencia);
        em.getTransaction().begin();
        em.refresh(a);
        em.getTransaction().commit();
        return a;
    }

    /**
     * Metodo para recargar una Asistencia por demanda
     * @param Asistencia
     */
    public Asistencia recargarAsistencia(Asistencia clase){
        EntityManager em = this.getEntityManager();
        Asistencia a = em.find(Asistencia.class, clase.getIdasistencia());
        a = clase;
        em.getTransaction().begin();
        em.refresh(a);
        em.getTransaction().commit();
        return a;
    }

    /**
     * Metodo para obtener un Horario por su ID
     * @param idHorario id del horario que se desea
     * @return
     */
    public Horario getHorario(int idHorario) {
        EntityManager em = this.getEntityManager();
        Horario h = em.find(Horario.class, idHorario);
        return h;
    }

    /**
     * Metodo para obtener un Horario por su ID
     * @param idHorario id del horario que se desea
     * @return
     */
    public List<Horario> getAllHorarios() {
        EntityManager em = this.getEntityManager();
        Query q = em.createNamedQuery("Horario.findAll");
        return (List<Horario>)q.getResultList();
    }

    /**
     * Metodo para obtener una lista Horarios asociado con un curso
     */
    public List<Horario> getHorariosCurso(Curso curso) {
        EntityManager em = this.getEntityManager();
        Query q = em.createNamedQuery("Horario.findByIdCurso");
        q.setParameter("idcurso", curso);
        return (List<Horario>)q.getResultList();
    }

    public int getAllHorariosUnDia(String hora, int dia) {
        int cant;

        String [] time = hora.split("\\:");
        int hour = Integer.parseInt(time[0]);
        int minute = Integer.parseInt(time[1]);
        int seconds = 00;
        Time t = new Time(hour, minute, seconds);

        EntityManager em = this.getEntityManager();
        Query q = em.createNamedQuery("Horario.findByHoraDia");
        q.setParameter("diasemana", dia);
        q.setParameter("horainicio", t);

        List<Horario> h = (List<Horario>)q.getResultList();

        if(h.size()>0)
            cant=1;
        else
            cant=0;
        return cant;
    }

    /**
     * Metodo para añadir un objeto Horario
     * @param Horario
     */
    public boolean createHorario(Horario horario){
        try {
            EntityManager em = this.getEntityManager();
            em.getTransaction().begin();
            em.persist(horario);
            em.getTransaction().commit();
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    /**
     * Metodo para eliminar un Horario por su ID
     * @param idHorario
     */
    public void deleteHorario(int idHorario) {
        EntityManager em = this.getEntityManager();
        Horario h = (Horario)em.find(Horario.class, idHorario);
        em.getTransaction().begin();
        em.remove(h);
        em.getTransaction().commit();
    }

    /**
     * Metodo para eliminar un objeto Horario
     * @param Horario
     */
    public void deleteHorario(Horario horario){
        EntityManager em = this.getEntityManager();
        Horario h = em.find(Horario.class, horario.getIdhorario());
        if(h==null) return;
        em.getTransaction().begin();
        em.remove(h);
        em.getTransaction().commit();
    }

    /**
     * Metodo para actualizar un objeto Horario
     * @param Horario
     */
    public void updateHorario(Horario horario){
        EntityManager em = this.getEntityManager();
        Horario h = em.find(Horario.class, horario.getIdhorario());
        h = horario;
        em.getTransaction().begin();
        em.merge(h);
        em.getTransaction().commit();
    }

    /**
     * Metodo para recargar un Horario por demanda, por su ID
     * @param Horario
     */
    public Horario recargarHorario(Integer idHorario){
        EntityManager em = this.getEntityManager();
        Horario h = em.find(Horario.class, idHorario);
        em.getTransaction().begin();
        em.refresh(h);
        em.getTransaction().commit();
        return h;
    }

    /**
     * Metodo para recargar un Horario por demanda
     * @param Horario
     */
    public Horario recargarHorario(Horario horario){
        EntityManager em = this.getEntityManager();
        Horario h = em.find(Horario.class, horario.getIdhorario());
        h = horario;
        em.getTransaction().begin();
        em.refresh(h);
        em.getTransaction().commit();
        return h;
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

