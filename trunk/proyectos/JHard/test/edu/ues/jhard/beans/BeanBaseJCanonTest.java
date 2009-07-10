/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.ues.jhard.beans;

import edu.ues.jhard.jpa.Clasificacion;
import edu.ues.jhard.jpa.Estadoreserva;
import edu.ues.jhard.jpa.Existencia;
import edu.ues.jhard.jpa.Reserva;
//import edu.ues.jhard.jpa.Responsable;
//import edu.ues.jhard.jpa.Solicitante;
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
public class BeanBaseJCanonTest {

    public BeanBaseJCanonTest() {
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
     * Test of getReserva method, of class BeanBaseJCanon.
     */
    //@Test
    public void testGetReserva() {
        System.out.println("getReserva");
        BeanBaseJCanon instance = new BeanBaseJCanon();
        Reserva[] expResult = null;
        Reserva[] result = instance.getReserva();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of registrarReserva method, of class BeanBaseJCanon.
     */
    //@Test
    public void testRegistrarReserva() {
        System.out.println("registrarReserva");
        Reserva r = null;
        BeanBaseJCanon instance = new BeanBaseJCanon();
        instance.registrarReserva(r);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEstadoReserva method, of class BeanBaseJCanon.
     */
    //@Test
    public void testGetEstadoReserva() {
        System.out.println("getEstadoReserva");
        BeanBaseJCanon instance = new BeanBaseJCanon();
        Estadoreserva[] expResult = null;
        Estadoreserva[] result = instance.getEstadoReserva();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of registrarEstadoReserva method, of class BeanBaseJCanon.
     */
    //@Test
    public void testRegistrarEstadoReserva() {
        System.out.println("registrarEstadoReserva");
        Estadoreserva er = null;
        BeanBaseJCanon instance = new BeanBaseJCanon();
        instance.registrarEstadoReserva(er);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getResponsable method, of class BeanBaseJCanon.
     */
    //@Test
    public void testGetResponsable() {
/*        System.out.println("getResponsable");
        BeanBaseJCanon instance = new BeanBaseJCanon();
        Responsable[] expResult = null;
        Responsable[] result = instance.getResponsable();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");*/
    }

    /**
     * Test of registrarResponsable method, of class BeanBaseJCanon.
     */
    //@Test
    public void testRegistrarResponsable() {
        System.out.println("registrarResponsable");
/*        Responsable r = null;
        BeanBaseJCanon instance = new BeanBaseJCanon();
        instance.registrarResponsable(r);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");*/
    }

    /**
     * Test of getSolicitante method, of class BeanBaseJCanon.
     */
    //@Test
    public void testGetSolicitante() {
/*        System.out.println("getSolicitante");
        BeanBaseJCanon instance = new BeanBaseJCanon();
        Solicitante[] expResult = null;
        Solicitante[] result = instance.getSolicitante();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");*/
    }

    /**
     * Test of registrarSolicitante method, of class BeanBaseJCanon.
     */
    //@Test
    public void testRegistrarSolicitante() {
        System.out.println("registrarSolicitante");
/*        Solicitante s = null;
        BeanBaseJCanon instance = new BeanBaseJCanon();
        instance.registrarSolicitante(s);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");*/
    }

    @Test
    public void testObtenerEquipoMultimedia(){
        System.out.println("obtenerEquipoMultimedia");

        BeanBaseJCanon instance = new BeanBaseJCanon();

        Existencia [] e = instance.getEquipoMultimedia(2);

        assertNotNull(e);

        System.out.println(e[0].getIdhardware().getNombre());

        System.out.println("Se obtienen los equipos que se pueden prestar");
    }

}