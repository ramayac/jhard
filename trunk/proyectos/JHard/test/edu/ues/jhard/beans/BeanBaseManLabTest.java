/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.ues.jhard.beans;

import edu.ues.jhard.jpa.Asistencia;
import edu.ues.jhard.jpa.Carrera;
import edu.ues.jhard.jpa.Clase;
import edu.ues.jhard.jpa.Curso;
import edu.ues.jhard.jpa.Docente;
import edu.ues.jhard.jpa.Estadocurso;
import edu.ues.jhard.jpa.Estudiante;
import edu.ues.jhard.jpa.Facultad;
import edu.ues.jhard.jpa.Horario;
import edu.ues.jhard.jpa.Inscripcion;
import edu.ues.jhard.jpa.Instructor;
import edu.ues.jhard.jpa.Materia;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author rodrigo
 */
public class BeanBaseManLabTest {

    public BeanBaseManLabTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testGetFacultad() {
        System.out.println("getFacultad");
        int idFacultad = 0;
        BeanBaseJManLab instance = new BeanBaseJManLab();
        Facultad expResult = null;
        Facultad result = instance.getFacultad(idFacultad);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetAllFacultades() {
        System.out.println("getAllFacultades");
        BeanBaseJManLab instance = new BeanBaseJManLab();
        List<Facultad> expResult = null;
        List<Facultad> result = instance.getAllFacultades();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testCreateFacultad() {
        System.out.println("createFacultad");
        Facultad Facultad = null;
        BeanBaseJManLab instance = new BeanBaseJManLab();
        boolean expResult = false;
        boolean result = instance.createFacultad(Facultad);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testDeleteFacultad_int() {
        System.out.println("deleteFacultad");
        int idFacultad = 0;
        BeanBaseJManLab instance = new BeanBaseJManLab();
        instance.deleteFacultad(idFacultad);
        fail("The test case is a prototype.");
    }

    @Test
    public void testDeleteFacultad_Facultad() {
        System.out.println("deleteFacultad");
        Facultad Facultad = null;
        BeanBaseJManLab instance = new BeanBaseJManLab();
        instance.deleteFacultad(Facultad);
        fail("The test case is a prototype.");
    }

    @Test
    public void testUpdateFacultad() {
        System.out.println("updateFacultad");
        Facultad Facultad = null;
        BeanBaseJManLab instance = new BeanBaseJManLab();
        instance.updateFacultad(Facultad);
        fail("The test case is a prototype.");
    }

    @Test
    public void testRecargarFacultad_Integer() {
        System.out.println("recargarFacultad");
        Integer idFacultad = null;
        BeanBaseJManLab instance = new BeanBaseJManLab();
        Facultad expResult = null;
        Facultad result = instance.recargarFacultad(idFacultad);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testRecargarFacultad_Facultad() {
        System.out.println("recargarFacultad");
        Facultad Facultad = null;
        BeanBaseJManLab instance = new BeanBaseJManLab();
        Facultad expResult = null;
        Facultad result = instance.recargarFacultad(Facultad);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetCarrera() {
        System.out.println("getCarrera");
        int idCarrera = 0;
        BeanBaseJManLab instance = new BeanBaseJManLab();
        Carrera expResult = null;
        Carrera result = instance.getCarrera(idCarrera);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetAllCarreras() {
        System.out.println("getAllCarreras");
        BeanBaseJManLab instance = new BeanBaseJManLab();
        List<Carrera> expResult = null;
        List<Carrera> result = instance.getAllCarreras();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testCreateCarrera() {
        System.out.println("createCarrera");
        Carrera carrera = null;
        BeanBaseJManLab instance = new BeanBaseJManLab();
        boolean expResult = false;
        boolean result = instance.createCarrera(carrera);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testDeleteCarrera_int() {
        System.out.println("deleteCarrera");
        int idCarrera = 0;
        BeanBaseJManLab instance = new BeanBaseJManLab();
        instance.deleteCarrera(idCarrera);
        fail("The test case is a prototype.");
    }

    @Test
    public void testDeleteCarrera_Carrera() {
        System.out.println("deleteCarrera");
        Carrera carrera = null;
        BeanBaseJManLab instance = new BeanBaseJManLab();
        instance.deleteCarrera(carrera);
        fail("The test case is a prototype.");
    }

    @Test
    public void testUpdateCarrera() {
        System.out.println("updateCarrera");
        Carrera carrera = null;
        BeanBaseJManLab instance = new BeanBaseJManLab();
        instance.updateCarrera(carrera);
        fail("The test case is a prototype.");
    }

    @Test
    public void testRecargarCarrera_Integer() {
        System.out.println("recargarCarrera");
        Integer idCarrera = null;
        BeanBaseJManLab instance = new BeanBaseJManLab();
        Carrera expResult = null;
        Carrera result = instance.recargarCarrera(idCarrera);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testRecargarCarrera_Carrera() {
        System.out.println("recargarCarrera");
        Carrera carrera = null;
        BeanBaseJManLab instance = new BeanBaseJManLab();
        Carrera expResult = null;
        Carrera result = instance.recargarCarrera(carrera);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetMateria() {
        System.out.println("getMateria");
        int idMateria = 0;
        BeanBaseJManLab instance = new BeanBaseJManLab();
        Materia expResult = null;
        Materia result = instance.getMateria(idMateria);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetAllMaterias() {
        System.out.println("getAllMaterias");
        BeanBaseJManLab instance = new BeanBaseJManLab();
        List<Materia> expResult = null;
        List<Materia> result = instance.getAllMaterias();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testCreateMateria() {
        System.out.println("createMateria");
        Materia Materia = null;
        BeanBaseJManLab instance = new BeanBaseJManLab();
        boolean expResult = false;
        boolean result = instance.createMateria(Materia);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testDeleteMateria_int() {
        System.out.println("deleteMateria");
        int idMateria = 0;
        BeanBaseJManLab instance = new BeanBaseJManLab();
        instance.deleteMateria(idMateria);
        fail("The test case is a prototype.");
    }

    @Test
    public void testDeleteMateria_Materia() {
        System.out.println("deleteMateria");
        Materia Materia = null;
        BeanBaseJManLab instance = new BeanBaseJManLab();
        instance.deleteMateria(Materia);
        fail("The test case is a prototype.");
    }

    @Test
    public void testUpdateMateria() {
        System.out.println("updateMateria");
        Materia Materia = null;
        BeanBaseJManLab instance = new BeanBaseJManLab();
        instance.updateMateria(Materia);
        fail("The test case is a prototype.");
    }

    @Test
    public void testRecargarMateria_Integer() {
        System.out.println("recargarMateria");
        Integer idMateria = null;
        BeanBaseJManLab instance = new BeanBaseJManLab();
        Materia expResult = null;
        Materia result = instance.recargarMateria(idMateria);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testRecargarMateria_Materia() {
        System.out.println("recargarMateria");
        Materia Materia = null;
        BeanBaseJManLab instance = new BeanBaseJManLab();
        Materia expResult = null;
        Materia result = instance.recargarMateria(Materia);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetEstadocurso() {
        System.out.println("getEstadocurso");
        int idEstadocurso = 0;
        BeanBaseJManLab instance = new BeanBaseJManLab();
        Estadocurso expResult = null;
        Estadocurso result = instance.getEstadocurso(idEstadocurso);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetAllEstadocursos() {
        System.out.println("getAllEstadocursos");
        BeanBaseJManLab instance = new BeanBaseJManLab();
        List<Estadocurso> expResult = null;
        List<Estadocurso> result = instance.getAllEstadocursos();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testCreateEstadocurso() {
        System.out.println("createEstadocurso");
        Estadocurso estadoCurso = null;
        BeanBaseJManLab instance = new BeanBaseJManLab();
        boolean expResult = false;
        boolean result = instance.createEstadocurso(estadoCurso);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testDeleteEstadocurso_int() {
        System.out.println("deleteEstadocurso");
        int idEstadocurso = 0;
        BeanBaseJManLab instance = new BeanBaseJManLab();
        instance.deleteEstadocurso(idEstadocurso);
        fail("The test case is a prototype.");
    }

    @Test
    public void testDeleteEstadocurso_Estadocurso() {
        System.out.println("deleteEstadocurso");
        Estadocurso estadoCurso = null;
        BeanBaseJManLab instance = new BeanBaseJManLab();
        instance.deleteEstadocurso(estadoCurso);
        fail("The test case is a prototype.");
    }

    @Test
    public void testUpdateEstadocurso() {
        System.out.println("updateEstadocurso");
        Estadocurso estadoCurso = null;
        BeanBaseJManLab instance = new BeanBaseJManLab();
        instance.updateEstadocurso(estadoCurso);
        fail("The test case is a prototype.");
    }

    @Test
    public void testRecargarEstadocurso_Integer() {
        System.out.println("recargarEstadocurso");
        Integer idEstadocurso = null;
        BeanBaseJManLab instance = new BeanBaseJManLab();
        Estadocurso expResult = null;
        Estadocurso result = instance.recargarEstadocurso(idEstadocurso);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testRecargarEstadocurso_Estadocurso() {
        System.out.println("recargarEstadocurso");
        Estadocurso estadoCurso = null;
        BeanBaseJManLab instance = new BeanBaseJManLab();
        Estadocurso expResult = null;
        Estadocurso result = instance.recargarEstadocurso(estadoCurso);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetDocente() {
        System.out.println("getDocente");
        int idDocente = 0;
        BeanBaseJManLab instance = new BeanBaseJManLab();
        Docente expResult = null;
        Docente result = instance.getDocente(idDocente);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetAllDocentes() {
        System.out.println("getAllDocentes");
        BeanBaseJManLab instance = new BeanBaseJManLab();
        List<Docente> expResult = null;
        List<Docente> result = instance.getAllDocentes();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testCreateDocente() {
        System.out.println("createDocente");
        Docente docente = null;
        BeanBaseJManLab instance = new BeanBaseJManLab();
        boolean expResult = false;
        boolean result = instance.createDocente(docente);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testDeleteDocente_int() {
        System.out.println("deleteDocente");
        int idDocente = 0;
        BeanBaseJManLab instance = new BeanBaseJManLab();
        instance.deleteDocente(idDocente);
        fail("The test case is a prototype.");
    }

    @Test
    public void testDeleteDocente_Docente() {
        System.out.println("deleteDocente");
        Docente docente = null;
        BeanBaseJManLab instance = new BeanBaseJManLab();
        instance.deleteDocente(docente);
        fail("The test case is a prototype.");
    }

    @Test
    public void testUpdateDocente() {
        System.out.println("updateDocente");
        Docente docente = null;
        BeanBaseJManLab instance = new BeanBaseJManLab();
        instance.updateDocente(docente);
        fail("The test case is a prototype.");
    }

    @Test
    public void testRecargarDocente_Integer() {
        System.out.println("recargarDocente");
        Integer idDocente = null;
        BeanBaseJManLab instance = new BeanBaseJManLab();
        Docente expResult = null;
        Docente result = instance.recargarDocente(idDocente);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testRecargarDocente_Docente() {
        System.out.println("recargarDocente");
        Docente docente = null;
        BeanBaseJManLab instance = new BeanBaseJManLab();
        Docente expResult = null;
        Docente result = instance.recargarDocente(docente);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetEstudiante() {
        System.out.println("getEstudiante");
        int idEstudiante = 0;
        BeanBaseJManLab instance = new BeanBaseJManLab();
        Estudiante expResult = null;
        Estudiante result = instance.getEstudiante(idEstudiante);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetAllEstudiantes() {
        System.out.println("getAllEstudiantes");
        BeanBaseJManLab instance = new BeanBaseJManLab();
        List<Estudiante> expResult = null;
        List<Estudiante> result = instance.getAllEstudiantes();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testCreateEstudiante() {
        System.out.println("createEstudiante");
        Estudiante estudiante = null;
        BeanBaseJManLab instance = new BeanBaseJManLab();
        boolean expResult = false;
        boolean result = instance.createEstudiante(estudiante);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testDeleteEstudiante_int() {
        System.out.println("deleteEstudiante");
        int idEstudiante = 0;
        BeanBaseJManLab instance = new BeanBaseJManLab();
        instance.deleteEstudiante(idEstudiante);
        fail("The test case is a prototype.");
    }

    @Test
    public void testDeleteEstudiante_Estudiante() {
        System.out.println("deleteEstudiante");
        Estudiante estudiante = null;
        BeanBaseJManLab instance = new BeanBaseJManLab();
        instance.deleteEstudiante(estudiante);
        fail("The test case is a prototype.");
    }

    @Test
    public void testUpdateEstudiante() {
        System.out.println("updateEstudiante");
        Estudiante estudiante = null;
        BeanBaseJManLab instance = new BeanBaseJManLab();
        instance.updateEstudiante(estudiante);
        fail("The test case is a prototype.");
    }

    @Test
    public void testRecargarEstudiante_Integer() {
        System.out.println("recargarEstudiante");
        Integer idEstudiante = null;
        BeanBaseJManLab instance = new BeanBaseJManLab();
        Estudiante expResult = null;
        Estudiante result = instance.recargarEstudiante(idEstudiante);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testRecargarEstudiante_Estudiante() {
        System.out.println("recargarEstudiante");
        Estudiante estudiante = null;
        BeanBaseJManLab instance = new BeanBaseJManLab();
        Estudiante expResult = null;
        Estudiante result = instance.recargarEstudiante(estudiante);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetInstructor() {
        System.out.println("getInstructor");
        int idInstructor = 0;
        BeanBaseJManLab instance = new BeanBaseJManLab();
        Instructor expResult = null;
        Instructor result = instance.getInstructor(idInstructor);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetAllInstructors() {
        System.out.println("getAllInstructors");
        BeanBaseJManLab instance = new BeanBaseJManLab();
        List<Instructor> expResult = null;
        List<Instructor> result = instance.getAllInstructors();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testCreateInstructor() {
        System.out.println("createInstructor");
        Instructor instructor = null;
        BeanBaseJManLab instance = new BeanBaseJManLab();
        boolean expResult = false;
        boolean result = instance.createInstructor(instructor);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testDeleteInstructor_int() {
        System.out.println("deleteInstructor");
        int idInstructor = 0;
        BeanBaseJManLab instance = new BeanBaseJManLab();
        instance.deleteInstructor(idInstructor);
        fail("The test case is a prototype.");
    }

    @Test
    public void testDeleteInstructor_Instructor() {
        System.out.println("deleteInstructor");
        Instructor instructor = null;
        BeanBaseJManLab instance = new BeanBaseJManLab();
        instance.deleteInstructor(instructor);
        fail("The test case is a prototype.");
    }

    @Test
    public void testUpdateInstructor() {
        System.out.println("updateInstructor");
        Instructor instructor = null;
        BeanBaseJManLab instance = new BeanBaseJManLab();
        instance.updateInstructor(instructor);
        fail("The test case is a prototype.");
    }

    @Test
    public void testRecargarInstructor_Integer() {
        System.out.println("recargarInstructor");
        Integer idInstructor = null;
        BeanBaseJManLab instance = new BeanBaseJManLab();
        Instructor expResult = null;
        Instructor result = instance.recargarInstructor(idInstructor);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testRecargarInstructor_Instructor() {
        System.out.println("recargarInstructor");
        Instructor instructor = null;
        BeanBaseJManLab instance = new BeanBaseJManLab();
        Instructor expResult = null;
        Instructor result = instance.recargarInstructor(instructor);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetInscripcion() {
        System.out.println("getInscripcion");
        int idInscripcion = 0;
        BeanBaseJManLab instance = new BeanBaseJManLab();
        Inscripcion expResult = null;
        Inscripcion result = instance.getInscripcion(idInscripcion);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetAllInscripcions() {
        System.out.println("getAllInscripcions");
        BeanBaseJManLab instance = new BeanBaseJManLab();
        List<Inscripcion> expResult = null;
        List<Inscripcion> result = instance.getAllInscripcions();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testCreateInscripcion() {
        System.out.println("createInscripcion");
        Inscripcion inscripcion = null;
        BeanBaseJManLab instance = new BeanBaseJManLab();
        boolean expResult = false;
        boolean result = instance.createInscripcion(inscripcion);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testDeleteInscripcion_int() {
        System.out.println("deleteInscripcion");
        int idInscripcion = 0;
        BeanBaseJManLab instance = new BeanBaseJManLab();
        instance.deleteInscripcion(idInscripcion);
        fail("The test case is a prototype.");
    }

    @Test
    public void testDeleteInscripcion_Inscripcion() {
        System.out.println("deleteInscripcion");
        Inscripcion inscripcion = null;
        BeanBaseJManLab instance = new BeanBaseJManLab();
        instance.deleteInscripcion(inscripcion);
        fail("The test case is a prototype.");
    }

    @Test
    public void testUpdateInscripcion() {
        System.out.println("updateInscripcion");
        Inscripcion inscripcion = null;
        BeanBaseJManLab instance = new BeanBaseJManLab();
        instance.updateInscripcion(inscripcion);
        fail("The test case is a prototype.");
    }

    @Test
    public void testRecargarInscripcion_Integer() {
        System.out.println("recargarInscripcion");
        Integer idInscripcion = null;
        BeanBaseJManLab instance = new BeanBaseJManLab();
        Inscripcion expResult = null;
        Inscripcion result = instance.recargarInscripcion(idInscripcion);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testRecargarInscripcion_Inscripcion() {
        System.out.println("recargarInscripcion");
        Inscripcion inscripcion = null;
        BeanBaseJManLab instance = new BeanBaseJManLab();
        Inscripcion expResult = null;
        Inscripcion result = instance.recargarInscripcion(inscripcion);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetCurso() {
        System.out.println("getCurso");
        int idCurso = 0;
        BeanBaseJManLab instance = new BeanBaseJManLab();
        Curso expResult = null;
        Curso result = instance.getCurso(idCurso);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetAllCursos() {
        System.out.println("getAllCursos");
        BeanBaseJManLab instance = new BeanBaseJManLab();
        List<Curso> expResult = null;
        List<Curso> result = instance.getAllCursos();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetCursosCiclo() {
        System.out.println("getCursosCiclo");
        BeanBaseJManLab instance = new BeanBaseJManLab();
        List<Curso> expResult = null;
        List<Curso> result = instance.getCursosCiclo();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetCursosDocenteCiclo() {
        System.out.println("getCursosDocenteCiclo");
        Docente docente = null;
        BeanBaseJManLab instance = new BeanBaseJManLab();
        List<Curso> expResult = null;
        List<Curso> result = instance.getCursosDocenteCiclo(docente);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetCursosInstructorCiclo() {
        System.out.println("getCursosInstructorCiclo");
        Instructor instructor = null;
        BeanBaseJManLab instance = new BeanBaseJManLab();
        List<Curso> expResult = null;
        List<Curso> result = instance.getCursosInstructorCiclo(instructor);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testCreateCurso() {
        System.out.println("createCurso");
        Curso curso = null;
        BeanBaseJManLab instance = new BeanBaseJManLab();
        boolean expResult = false;
        boolean result = instance.createCurso(curso);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testDeleteCurso_int() {
        System.out.println("deleteCurso");
        int idCurso = 0;
        BeanBaseJManLab instance = new BeanBaseJManLab();
        instance.deleteCurso(idCurso);
        fail("The test case is a prototype.");
    }

    @Test
    public void testDeleteCurso_Curso() {
        System.out.println("deleteCurso");
        Curso curso = null;
        BeanBaseJManLab instance = new BeanBaseJManLab();
        instance.deleteCurso(curso);
        fail("The test case is a prototype.");
    }

    @Test
    public void testUpdateCurso() {
        System.out.println("updateCurso");
        Curso curso = null;
        BeanBaseJManLab instance = new BeanBaseJManLab();
        instance.updateCurso(curso);
        fail("The test case is a prototype.");
    }

    @Test
    public void testRecargarCurso_Integer() {
        System.out.println("recargarCurso");
        Integer idCurso = null;
        BeanBaseJManLab instance = new BeanBaseJManLab();
        Curso expResult = null;
        Curso result = instance.recargarCurso(idCurso);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testRecargarCurso_Curso() {
        System.out.println("recargarCurso");
        Curso curso = null;
        BeanBaseJManLab instance = new BeanBaseJManLab();
        Curso expResult = null;
        Curso result = instance.recargarCurso(curso);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetClase() {
        System.out.println("getClase");
        int idClase = 0;
        BeanBaseJManLab instance = new BeanBaseJManLab();
        Clase expResult = null;
        Clase result = instance.getClase(idClase);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetAllClases() {
        System.out.println("getAllClases");
        BeanBaseJManLab instance = new BeanBaseJManLab();
        List<Clase> expResult = null;
        List<Clase> result = instance.getAllClases();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testCreateClase() {
        System.out.println("createClase");
        Clase clase = null;
        BeanBaseJManLab instance = new BeanBaseJManLab();
        boolean expResult = false;
        boolean result = instance.createClase(clase);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testDeleteClase_int() {
        System.out.println("deleteClase");
        int idClase = 0;
        BeanBaseJManLab instance = new BeanBaseJManLab();
        instance.deleteClase(idClase);
        fail("The test case is a prototype.");
    }

    @Test
    public void testDeleteClase_Clase() {
        System.out.println("deleteClase");
        Clase clase = null;
        BeanBaseJManLab instance = new BeanBaseJManLab();
        instance.deleteClase(clase);
        fail("The test case is a prototype.");
    }

    @Test
    public void testUpdateClase() {
        System.out.println("updateClase");
        Clase clase = null;
        BeanBaseJManLab instance = new BeanBaseJManLab();
        instance.updateClase(clase);
        fail("The test case is a prototype.");
    }

    @Test
    public void testRecargarClase_Integer() {
        System.out.println("recargarClase");
        Integer idClase = null;
        BeanBaseJManLab instance = new BeanBaseJManLab();
        Clase expResult = null;
        Clase result = instance.recargarClase(idClase);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testRecargarClase_Clase() {
        System.out.println("recargarClase");
        Clase clase = null;
        BeanBaseJManLab instance = new BeanBaseJManLab();
        Clase expResult = null;
        Clase result = instance.recargarClase(clase);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetAsistencia() {
        System.out.println("getAsistencia");
        int idAsistencia = 0;
        BeanBaseJManLab instance = new BeanBaseJManLab();
        Asistencia expResult = null;
        Asistencia result = instance.getAsistencia(idAsistencia);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetAllAsistencias() {
        System.out.println("getAllAsistencias");
        BeanBaseJManLab instance = new BeanBaseJManLab();
        List<Asistencia> expResult = null;
        List<Asistencia> result = instance.getAllAsistencias();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testCreateAsistencia() {
        System.out.println("createAsistencia");
        Asistencia clase = null;
        BeanBaseJManLab instance = new BeanBaseJManLab();
        boolean expResult = false;
        boolean result = instance.createAsistencia(clase);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testDeleteAsistencia_int() {
        System.out.println("deleteAsistencia");
        int idAsistencia = 0;
        BeanBaseJManLab instance = new BeanBaseJManLab();
        instance.deleteAsistencia(idAsistencia);
        fail("The test case is a prototype.");
    }

    @Test
    public void testDeleteAsistencia_Asistencia() {
        System.out.println("deleteAsistencia");
        Asistencia asistencia = null;
        BeanBaseJManLab instance = new BeanBaseJManLab();
        instance.deleteAsistencia(asistencia);
        fail("The test case is a prototype.");
    }

    @Test
    public void testUpdateAsistencia() {
        System.out.println("updateAsistencia");
        Asistencia clase = null;
        BeanBaseJManLab instance = new BeanBaseJManLab();
        instance.updateAsistencia(clase);
        fail("The test case is a prototype.");
    }

    @Test
    public void testRecargarAsistencia_Integer() {
        System.out.println("recargarAsistencia");
        Integer idAsistencia = null;
        BeanBaseJManLab instance = new BeanBaseJManLab();
        Asistencia expResult = null;
        Asistencia result = instance.recargarAsistencia(idAsistencia);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testRecargarAsistencia_Asistencia() {
        System.out.println("recargarAsistencia");
        Asistencia clase = null;
        BeanBaseJManLab instance = new BeanBaseJManLab();
        Asistencia expResult = null;
        Asistencia result = instance.recargarAsistencia(clase);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetHorario() {
        System.out.println("getHorario");
        int idHorario = 0;
        BeanBaseJManLab instance = new BeanBaseJManLab();
        Horario expResult = null;
        Horario result = instance.getHorario(idHorario);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetAllHorarios() {
        System.out.println("getAllHorarios");
        BeanBaseJManLab instance = new BeanBaseJManLab();
        List<Horario> expResult = null;
        List<Horario> result = instance.getAllHorarios();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetHorariosCurso() {
        System.out.println("getHorariosCurso");
        Curso curso = null;
        BeanBaseJManLab instance = new BeanBaseJManLab();
        List<Horario> expResult = null;
        List<Horario> result = instance.getHorariosCurso(curso);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetAllHorariosUnDia() {
        System.out.println("getAllHorariosUnDia");
        String hora = "";
        int dia = 0;
        BeanBaseJManLab instance = new BeanBaseJManLab();
        int expResult = 0;
        int result = instance.getAllHorariosUnDia(hora, dia);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testCreateHorario() {
        System.out.println("createHorario");
        Horario horario = null;
        BeanBaseJManLab instance = new BeanBaseJManLab();
        boolean expResult = false;
        boolean result = instance.createHorario(horario);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testDeleteHorario_int() {
        System.out.println("deleteHorario");
        int idHorario = 0;
        BeanBaseJManLab instance = new BeanBaseJManLab();
        instance.deleteHorario(idHorario);
        fail("The test case is a prototype.");
    }

    @Test
    public void testDeleteHorario_Horario() {
        System.out.println("deleteHorario");
        Horario horario = null;
        BeanBaseJManLab instance = new BeanBaseJManLab();
        instance.deleteHorario(horario);
        fail("The test case is a prototype.");
    }

    @Test
    public void testUpdateHorario() {
        System.out.println("updateHorario");
        Horario horario = null;
        BeanBaseJManLab instance = new BeanBaseJManLab();
        instance.updateHorario(horario);
        fail("The test case is a prototype.");
    }

    @Test
    public void testRecargarHorario_Integer() {
        System.out.println("recargarHorario");
        Integer idHorario = null;
        BeanBaseJManLab instance = new BeanBaseJManLab();
        Horario expResult = null;
        Horario result = instance.recargarHorario(idHorario);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testRecargarHorario_Horario() {
        System.out.println("recargarHorario");
        Horario horario = null;
        BeanBaseJManLab instance = new BeanBaseJManLab();
        Horario expResult = null;
        Horario result = instance.recargarHorario(horario);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

}