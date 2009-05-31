/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.ues.jhard.jhardmin;

import edu.ues.jhard.beans.BeanBaseJHardmin;
import edu.ues.jhard.jpa.Usuario;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author hugol
 */
public class LoginManagerTest {
    private LoginManager lMgr = null;
    private LoggedUser usuarioReal = null;
    private LoggedUser usuarioFalso = null;

    public LoginManagerTest() {
        
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
        this.lMgr = LoginManager.getInstance();
        this.usuarioReal = new LoggedUser(0, "hugol", "localhost");
        this.usuarioFalso = new LoggedUser(-1, "nomUsuarioFalso", "localhost");
    }

    @After
    public void tearDown() {
        this.usuarioReal = null;
        this.usuarioFalso = null;
    }

    /**
     * Prueba que se pueda realzar un login exitoso con un usuario existente
     */
    
    public void testLoginSuccess() {
        System.out.println("LoginSuccess");        
        assertFalse(this.lMgr.isLogged(this.usuarioReal.getUserName()));
        int result = this.lMgr.Login(this.usuarioReal.getUserName(), "firpomadrid", this.usuarioReal.getLoggedUrl());
        this.usuarioReal.setUid(result);
        assertTrue(this.lMgr.isLogged(this.usuarioReal.getUserName()));        
    }

    /*
     * Prueba que no se pueda realizar un login con un usuario inexistente
     */
    public void testLoginFail(){
        System.out.println("LoginSuccess");        
        int result = this.lMgr.Login(this.usuarioFalso.getUserName(), "claveusuarioFalsa", this.usuarioFalso.getLoggedUrl());
        assertEquals(-1, result);
    }

    /**
     * Prueba que un usuario logueado en el sistema pueda desloguearse exitosamente
     */
    
    public void testLogoutSuccess() {
        System.out.println("Logout");
        testLoginSuccess();
        assertTrue(this.lMgr.isLogged(this.usuarioReal.getUid()));
        boolean result = this.lMgr.Logout(this.usuarioReal.getUid());
        assertTrue(result);
    }

    /**
     * Test of isLogged method, of class LoginManager.
     */
    
    public void testIsLogged_Integer() {
        System.out.println("isLogged");        
        this.testLoginSuccess();
        assertTrue(this.lMgr.isLogged(this.usuarioReal.getUid()));
    }

    /**
     * Test of isLogged method, of class LoginManager.
     */
    
    public void testIsLogged_String() {
        System.out.println("isLogged");
        this.testLoginSuccess();
        assertTrue(this.lMgr.isLogged(this.usuarioReal.getUserName()));
    }


    
    public void testExistsInBD(){
        System.out.println("existsInBD");
        assertTrue(this.lMgr.existsInBD(this.usuarioReal.getUserName(), "firpomadrid"));
    }

    @Test
    public void testGetUsuarioFromId(){
        BeanBaseJHardmin bbase = new BeanBaseJHardmin();
        Usuario u = bbase.getUsuario("hugol","firpomadrid");
        assertNotNull(u);
    }
}