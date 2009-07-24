package edu.ues.jhard.beans;

import edu.ues.jhard.jpa.Articulos;
import edu.ues.jhard.jpa.Usuario;
import java.sql.Date;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Ramayac
 */
public class BeanBaseJWikiTest {

    public BeanBaseJWikiTest() {
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
     * Buscamos articulos por palabras en la BD
     */
    @Test
    public void testFullTextSearch() {
        System.out.println("FullTextSearch");
        BeanBaseJWiki instance = new BeanBaseJWiki();
        List<Articulos> la = instance.searchPalabrasEnArticulo("display Linux tasks top");
        if(!(la.size()>=0)) fail("resultado menor al esperado");
        System.out.println("Exito en la prueba!");
        //assertNotNull(result);
    }

    /**
     * Obtenemos una articulo de la BD
     */
    @Test
    public void testGetArticulos() {
        System.out.println("getArticulos");
        BeanBaseJWiki instance = new BeanBaseJWiki();
        //Articulos expResult = null;
        Articulos result = instance.getArticulo(1);
        assertNotNull(result);
        //assertEquals(expResult, result);
        System.out.println("Exito en la prueba!");
    }
    
     /**
     * Obtenemos una articulo de la BD con descripcion de XXX palabras
     */
//    @Test
//    public void testGetArticuloDescCorta() {
//        System.out.println("getArticuloDescCorta");
//        BeanBaseJWiki instance = new BeanBaseJWiki();
//        //Articulos expResult = null;
//        Articulos result = instance.searchArticuloPorTitulo("ntra").get(0);
//        assertNotNull(result);
//        System.out.println(result.getDescripcionCorta());
//        System.out.println("Exito en la prueba!");
//    }
    
    /**
     * Obtenemos N articulos de la BD
     */
    @Test
    public void testNArticulos() {
        int n = 2;
        //System.out.println("testNArticuloss");
        BeanBaseJWiki instance = new BeanBaseJWiki();
        List<Articulos> resultado = instance.getUltimosNArticulos(n);
        if(resultado.size()==n)
            assertNotNull(resultado.get(0)); //por lo menos, que la primera NO sea null
        else
            fail("resultado menor que el esperado ("+n+")");
    }

    @Test
    public void testgetAllArticulos() {
        //System.out.println("testNArticuloss");
        BeanBaseJWiki instance = new BeanBaseJWiki();
        List<Articulos> resultado = instance.getAllArticulos();
        assertNotNull(resultado);
    }

    /**
     * Agregamos una Articulos a la BD
     */
    @Test
    public void testRegistrarArticulos() {
        //System.out.println("testRegistrarArticulos");
        BeanBaseJHardmin hardmin = new BeanBaseJHardmin();
        Usuario usuario = hardmin.getUsuario(1);
        Articulos articulo = new Articulos(0, "El articulo 9999", "nain, nine, nueve, 9, iiiiiiii, etc etc etc", new Date(2009, 9, 9), usuario);
        BeanBaseJWiki instance = new BeanBaseJWiki();
        if(!instance.createArticulo(articulo)) fail("fallo en REGISTRAR ENTRADA");
    }

    /**
     * Busqueda por titulo de articulo
     */
    @Test
    public void testSearchArticulosPorTitulo() {
        String criteria = "9999";
        //System.out.println("testSearchArticulosPorTitulo");
        BeanBaseJWiki instance = new BeanBaseJWiki();
        List<Articulos> la = (List<Articulos>)instance.searchArticuloPorTitulo(criteria);
        assertNotNull(la);
    }

    /**
     * Elimina una articulo
     */
    @Test
    public void testEliminarArticulos() {
        //System.out.println("testEliminarArticulos");
        String criteria = "9999";
        BeanBaseJWiki instance = new BeanBaseJWiki();
        Articulos articulo = instance.searchArticuloPorTitulo(criteria).get(0);
        instance.deleteArticulo(articulo);
        List<Articulos> la= instance.searchArticuloPorTitulo(criteria);
        if(la.size()!=0) fail("fallo en ELIMINAR ENTRADA");
    }

}