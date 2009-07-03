/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.ues.jhard.beans;

import edu.ues.jhard.jpa.Bitacoraestados;
import edu.ues.jhard.jpa.Equiposimple;
import edu.ues.jhard.jpa.Estadoequipo;
import edu.ues.jhard.jpa.Mantenimiento;
import edu.ues.jhard.jpa.Solicitud;
import edu.ues.jhard.jpa.Tecnico;
//import java.util.Date;
import java.sql.Date;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Hugol
 */
public class BeanBaseJRequestTest {

    public BeanBaseJRequestTest() {
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

    /**
     * Test of getEstadoEquipo method, of class BeanBaseJRequest.
     */
    //@Test
    public void testGetEstadoEquipo() {
        System.out.println("getEstadoEquipo");
        BeanBaseJRequest instance = new BeanBaseJRequest();
        Estadoequipo[] expResult = null;
        Estadoequipo[] result = instance.getEstadoEquipo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of registrarEstadoEquipo method, of class BeanBaseJRequest.
     */
    //@Test
    public void testRegistrarEstadoEquipo() {
        System.out.println("registrarEstadoEquipo");
        Estadoequipo eeq = null;
        BeanBaseJRequest instance = new BeanBaseJRequest();
        instance.registrarEstadoEquipo(eeq);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBitacoraEstados method, of class BeanBaseJRequest.
     */
    //@Test
    public void testGetBitacoraEstados() {
        System.out.println("getBitacoraEstados");
        BeanBaseJRequest instance = new BeanBaseJRequest();
        Bitacoraestados[] expResult = null;
        Bitacoraestados[] result = instance.getBitacoraEstados();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of registrarBitacoraEstados method, of class BeanBaseJRequest.
     */
    //@Test
    public void testRegistrarBitacoraEstados() {
        System.out.println("registrarBitacoraEstados");
        Bitacoraestados be = null;
        BeanBaseJRequest instance = new BeanBaseJRequest();
        instance.registrarBitacoraEstados(be);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMantenimiento method, of class BeanBaseJRequest.
     */
    //@Test
    public void testGetMantenimiento() {
        System.out.println("getMantenimiento");
        BeanBaseJRequest instance = new BeanBaseJRequest();
        Mantenimiento[] expResult = null;
        Mantenimiento[] result = instance.getMantenimiento();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of registrarMantenimiento method, of class BeanBaseJRequest.
     */
    //@Test
    public void testRegistrarMantenimiento() {
        System.out.println("registrarMantenimiento");
        Mantenimiento m = null;
        BeanBaseJRequest instance = new BeanBaseJRequest();
        instance.registrarMantenimiento(m);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTecnico method, of class BeanBaseJRequest.
     */
    //@Test
    public void testGetTecnico() {
        System.out.println("getTecnico");
        BeanBaseJRequest instance = new BeanBaseJRequest();
        Tecnico[] expResult = null;
        Tecnico[] result = instance.getTecnico();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of registrarTecnico method, of class BeanBaseJRequest.
     */
    //@Test
    public void testRegistrarTecnico() {
        System.out.println("registrarTecnico");
        Tecnico t = null;
        BeanBaseJRequest instance = new BeanBaseJRequest();
        instance.registrarTecnico(t);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSolicitud method, of class BeanBaseJRequest.
     */
    //@Test
    public void testGetSolicitud() {
        System.out.println("getSolicitud");
        BeanBaseJRequest instance = new BeanBaseJRequest();
        Solicitud[] expResult = null;
        Solicitud[] result = instance.getSolicitud();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of registrarSolicitud method, of class BeanBaseJRequest.
     */
    //@Test
    public void testRegistrarSolicitud() {
        System.out.println("registrarSolicitud");
        Solicitud s = null;
        BeanBaseJRequest instance = new BeanBaseJRequest();
        instance.registrarSolicitud(s);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEquipoSimple method, of class BeanBaseJRequest.
     */
    //@Test
    public void testGetEquipoSimple() {
        System.out.println("getEquipoSimple");
        BeanBaseJRequest instance = new BeanBaseJRequest();
        Equiposimple[] expResult = null;
        Equiposimple[] result = instance.getEquipoSimple();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of registrarEquipoSimple method, of class BeanBaseJRequest.
     */
    //@Test
    public void testRegistrarEquipoSimple() {
        System.out.println("registrarEquipoSimple");
        Equiposimple eqs = null;
        BeanBaseJRequest instance = new BeanBaseJRequest();
        instance.registrarEquipoSimple(eqs);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEquipoSimpleByPropietario method, of class BeanBaseJRequest.
     */
    //@Test
    public void testGetEquipoSimpleByPropietario() {
        System.out.println("getEquipoSimpleByPropietario");
        BeanBaseJRequest instance = new BeanBaseJRequest();
        Equiposimple expResult = null;
        //Equiposimple result = instance.getEquipoSimpleByPropietario();
        //assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
//    public void testGetEquipoSimpleByPropietario() {
//        System.out.println("getEquipoSimpleByPropietario");
//        BeanBaseJRequest instance = new BeanBaseJRequest();
//        Equiposimple expResult = null;
//        Equiposimple result = instance.getEquipoSimpleByPropietario();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of getEstadoEquipoByID method, of class BeanBaseJRequest.
     */
    //@Test
//    public void testGetEstadoEquipoByID() {
//        System.out.println("getEstadoEquipoByID");
//        BeanBaseJRequest instance = new BeanBaseJRequest();
//        Estadoequipo expResult = null;
//        Estadoequipo result = instance.getEstadoEquipoByID();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of getSolicitudByFecha method, of class BeanBaseJRequest.
     */
    //@Test
    public void testGetSolicitudByFecha() {
        System.out.println("getSolicitudByFecha");

        Date fecha = new Date(2009,6,6);

        
        System.out.println(fecha);
//        fecha.setYear(2009);
//        fecha.setMonth(06);
//        fecha.setDate(06);
        
        System.out.println(fecha);
        BeanBaseJRequest instance = new BeanBaseJRequest();
        //Solicitud expResult = null;
        Solicitud result = instance.getSolicitudByFecha(fecha);

        assertNotNull(result);
        //assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getSolicitudByPrioridad method, of class BeanBaseJRequest.
     */
    @Test
    public void testGetSolicitudByPrioridad() {
        System.out.println("getSolicitudByPrioridad");
        String prioridad = "Alta";
        BeanBaseJRequest instance = new BeanBaseJRequest();
        //Solicitud expResult = null;
        Solicitud result = instance.getSolicitudByPrioridad(prioridad);
        assertNotNull(result);
        System.out.println("EXISTE LA PRIORIDAD ALTA!!");

        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }


    @Test
    public void testGetSolicitudesByPrioridad() {
        
        System.out.println("getSolicitudesByPrioridad");

        BeanBaseJRequest instance = new BeanBaseJRequest();

        String prioridad="Media";
        
        Solicitud[] result = instance.getSolicitudesByPrioridad(prioridad);

        assertNotNull(result);

        System.out.println(result);
        System.out.println("OBTENGO TODAS LAS SOLICITUDES DE UNA PRIORIDAD ");

        
    }

}