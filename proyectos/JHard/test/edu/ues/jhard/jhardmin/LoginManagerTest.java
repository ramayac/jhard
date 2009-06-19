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
    @Test
    public void testLoginSuccess() {
        System.out.println("LoginSuccess");
        this.lMgr.Logout(this.usuarioReal.getUserName());
        assertFalse(this.lMgr.isLogged(this.usuarioReal.getUserName()));
        int result = this.lMgr.Login(this.usuarioReal.getUserName(), "firpomadrid", this.usuarioReal.getLoggedUrl());
        assertNotSame(-1, result);
        this.usuarioReal.setUid(result);
        assertTrue(this.lMgr.isLogged(this.usuarioReal.getUserName()));        
    }

    /*
     * Prueba que no se pueda realizar un login con un usuario inexistente
     */
    @Test
    public void testLoginFail(){
        System.out.println("LoginSuccess");        
        int result = this.lMgr.Login(this.usuarioFalso.getUserName(), "claveusuarioFalsa", this.usuarioFalso.getLoggedUrl());
        assertEquals(-1, result);
    }

    /**
     * Prueba que un usuario logueado en el sistema pueda desloguearse exitosamente
     */
    @Test
    public void testLogoutSuccess() {
        System.out.println("Logout");
        this.lMgr.Login(this.usuarioReal.getUserName(), "firpomadrid", this.usuarioReal.getLoggedUrl());
        assertTrue(this.lMgr.isLogged(this.usuarioReal.getUserName()));
        boolean isLoggedOut = this.lMgr.Logout(this.usuarioReal.getUserName());
        assertTrue(isLoggedOut);
    }

    /**
     * Test of isLogged method, of class LoginManager.
     */
    @Test
    public void testIsLogged_Integer() {
        System.out.println("isLogged");        
        this.testLoginSuccess();
        assertTrue(this.lMgr.isLogged(this.usuarioReal.getUid()));
    }

    /**
     * Test of isLogged method, of class LoginManager.
     */
    @Test
    public void testIsLogged_String() {
        System.out.println("isLogged");
        this.testLoginSuccess();
        assertTrue(this.lMgr.isLogged(this.usuarioReal.getUserName()));
    }


    @Test
    public void testExistsInBD(){
        System.out.println("existsInBD");
        assertTrue(this.lMgr.existsInBD(this.usuarioReal.getUserName(), "firpomadrid"));
    }

    @Test
    public void testGetUsuarioFromId(){
        BeanBaseJHardmin bbase = new BeanBaseJHardmin();
        Usuario u = bbase.getUsuario("hugol",this.lMgr.encrypt("firpomadrid"));
        assertNotNull(u);
    }
}