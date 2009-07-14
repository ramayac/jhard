package edu.ues.jhard.beans;

import edu.ues.jhard.jpa.Comentarios;
import edu.ues.jhard.jpa.Entrada;
import edu.ues.jhard.jpa.Tag;
import edu.ues.jhard.jpa.Usuario;
import java.sql.Date;
import java.util.Collection;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;
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

    @Test
    public void testGetEntrada() {
        System.out.println("getEntrada");
        BeanBaseJWiki instance = new BeanBaseJWiki();
        Entrada expResult = null;
        Entrada result = instance.getEntrada(-1);
        assertEquals(expResult, result);
        System.out.println("Exito en la prueba!");
    }

    @Test
    public void testNEntradas() {
        int n = 3;
        //System.out.println("testNEntradas");
        BeanBaseJWiki instance = new BeanBaseJWiki();
        Entrada[] resultado = new Entrada[n];
        resultado = instance.getUltimasNEntradas(n);
        if(resultado.length==n)
            assertNotNull(resultado[0]); //por lo menos, que la primera NO sea null
        else
            fail("resultado menor que el esperado ("+n+")");
    }

    @Test
    public void testComentariosDeEntrada() {
        int n = 1;
        //System.out.println("testComentariosDeEntrada");
        BeanBaseJWiki instance = new BeanBaseJWiki();
        Entrada resultado = instance.getEntrada(n);
        Collection<Comentarios> comentarios = resultado.getComentariosCollection();
        System.out.println("Comentarios asociados con la Entrada: " + resultado.getTitulo());
        for (Comentarios c : comentarios) {
            System.out.println(c.getComentario());
        }
        //comentarios.toArray(new Comentarios[0]); <--ridiculo, esto seria el colmo...
        assertTrue(comentarios.size()>0);
    }
    
    @Test
    public void testEtiquetasDeEntrada() {
        int n = 1;
        System.out.println("getEtiquetasDeEntrada");
        BeanBaseJWiki instance = new BeanBaseJWiki();
        Entrada entrada = instance.getEntrada(n);
        Tag[] resultado = new Tag[0];
        resultado = instance.getEtiquetas(entrada);
        System.out.println("Tags asociados con la Entrada: " + entrada.getTitulo());
        for (Tag t : resultado) {
            System.out.println(t.getDescripcion());
        }
        assertNotNull(resultado);
    }

    @Test
    public void testRegistrarTag() {
        System.out.println("testRegistrarTag");
        Tag tag = new Tag(0, "Tag9999");
        BeanBaseJWiki instance = new BeanBaseJWiki();
        if(!instance.createTag(tag)) fail("fallo en REGISTRAR TAG");
    }

    @Test
    public void testSearchEntradaPorTag() {
        System.out.println("testSearchEntradaPorTag");
        BeanBaseJWiki instance = new BeanBaseJWiki();
        Entrada e = instance.searchEntradaPorEtiqueta("wiki"); //se busca por esta descripcion
        assertNotNull(e);
        System.out.println("Titulo de la entrada: " + e.getTitulo());
    }

    @Test
    public void testSearchEntradaPorTags() {
        System.out.println("testSearchEntradaPorTags");
        BeanBaseJWiki instance = new BeanBaseJWiki();
        String[] etiquetas = {"portada", "wiki"};
        Entrada[] entradas = instance.searchEntradaPorEtiquetas(etiquetas);
        for (Entrada entrada : entradas) {
            assertNotNull(entrada);
            System.out.println("Titulo de la entrada: " + entrada.getTitulo());
        }
    }

    @Test
    public void testRegistrarEntrada() {
        System.out.println("testRegistrarEntrada");
        BeanBaseJHardmin hardmin = new BeanBaseJHardmin();
        Usuario usuario = hardmin.getUsuario(1);
        Entrada entrada = new Entrada(9999, "La entrada 9999", "nain, nine, nueve, 9, iiiiiiii, etc etc etc", new Date(2009, 9, 9), usuario);
        BeanBaseJWiki instance = new BeanBaseJWiki();
        if(!instance.createEntrada(entrada)) fail("fallo en REGISTRAR ENTRADA");
    }

    @Test
    public void testRegistrarComentario() {
        System.out.println("testRegistrarComentario");
        Comentarios comentario = new Comentarios(9999, "Oh!!! esta es el comentario para la entrada 9999!!!", new Date(2009, 9, 9));
        BeanBaseJWiki instance = new BeanBaseJWiki();
        if(!instance.createComentario(9999, comentario)) fail("fallo en REGISTRAR COMENTARIO");
    }

//    @Test
//    public void testAsociarTag() {
//        System.out.println("testAsociarTag");
//        BeanBaseJWiki instance = new BeanBaseJWiki();
//        if(!instance.) fail("fallo en REGISTRAR COMENTARIO");
//    }
   
    @Test
    public void testEliminarTag() {
        System.out.println("testEliminarTag");
        BeanBaseJWiki instance = new BeanBaseJWiki();
        instance.deleteTag(0);
        Tag t = instance.getEtiqueta(0);
        if(!(t==null)) fail("fallo en ELIMINAR TAG");
    }
    
    @Test
    public void testEliminarComentario() {
        System.out.println("testEliminarComentario");
        BeanBaseJWiki instance = new BeanBaseJWiki();
        Entrada entrada = instance.getEntrada(9999);
        if(entrada==null) fail("fallo en ELIMINAR COMENTARIO (no hay entradas con comentarios)");
        Comentarios[] com = instance.getComentarios(entrada);
        instance.deleteComentario(com[0]);
        Comentarios c = instance.getComentario(com[0].getIdcoment());
        if(!(c==null)) fail("fallo en ELIMINAR COMENTARIO (encontre un comentario que tendria que estar eliminado)");
    }
    
    @Test
    public void testEliminarEntrada() {
        System.out.println("testEliminarEntrada");
        BeanBaseJWiki instance = new BeanBaseJWiki();
        instance.deleteEntrada(9999);
        Entrada entrada = instance.getEntrada(9999);
        if(!(entrada==null)) fail("fallo en ELIMINAR ENTRADA");
    }

}