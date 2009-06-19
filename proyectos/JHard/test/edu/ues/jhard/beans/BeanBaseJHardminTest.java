/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.ues.jhard.beans;

import edu.ues.jhard.jpa.Usuario;
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
public class BeanBaseJHardminTest {

    public BeanBaseJHardminTest() {
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
     * Test of getUsuario method, of class BeanBaseJHardmin.
     */
    //@Test
    public void testGetUsuario_String_String() {
        System.out.println("getUsuario");
        String userName = "";
        String userPwd = "";
        BeanBaseJHardmin instance = new BeanBaseJHardmin();
        Usuario expResult = null;
        Usuario result = instance.getUsuario(userName, userPwd);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUsuario method, of class BeanBaseJHardmin.
     */
    @Test
    public void testGetUsuario_int() {
        System.out.println("getUsuario");
        int id = 10;
        BeanBaseJHardmin instance = new BeanBaseJHardmin();
        //Usuario expResult = null;
        Usuario result = instance.getUsuario(id);
        assertNotNull(result);
        System.out.println(result.getNombre());
        
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

}