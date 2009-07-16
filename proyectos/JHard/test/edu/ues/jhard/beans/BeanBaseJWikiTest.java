package edu.ues.jhard.beans;

import edu.ues.jhard.jpa.Comentarios;
import edu.ues.jhard.jpa.Entrada;
import edu.ues.jhard.jpa.Tag;
import edu.ues.jhard.jpa.TagEntrada;
import edu.ues.jhard.jpa.Usuario;
import java.sql.Date;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
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
     * Obtenemos una entrada de la BD
     */
    @Test
    public void testGetEntrada() {
        System.out.println("getEntrada");
        BeanBaseJWiki instance = new BeanBaseJWiki();
        //Entrada expResult = null;
        Entrada result = instance.getEntrada(1);
        assertNotNull(result);
        //assertEquals(expResult, result);
        System.out.println("Exito en la prueba!");
    }

    /**
     * Obtejemos N entradas de la BD
     */
    @Test
    public void testNEntradas() {
        int n = 2;
        //System.out.println("testNEntradas");
        BeanBaseJWiki instance = new BeanBaseJWiki();
        Entrada[] resultado = new Entrada[n];
        resultado = instance.getUltimasNEntradas(n);
        if(resultado.length==n)
            assertNotNull(resultado[0]); //por lo menos, que la primera NO sea null
        else
            fail("resultado menor que el esperado ("+n+")");
    }

    /**
     * Obtenemos los comentarios asociados a una entrada
     */
    @Test
    public void testComentariosDeEntrada() {
        int identrada = 1;
        //System.out.println("testComentariosDeEntrada");
        BeanBaseJWiki instance = new BeanBaseJWiki();
        Entrada resultado = instance.getEntrada(identrada);
        Collection<Comentarios> comentarios = resultado.getComentariosCollection();
        System.out.println("Comentarios asociados con la Entrada: " + resultado.getTitulo());
        for (Comentarios c : comentarios) {
            System.out.println(c.getComentario());
        }
        assertTrue(comentarios.size()>0);
    }

    /**
     * Obtiene las etiquetas asociadas a una entrada
     */
    @Test
    public void testEtiquetasDeEntrada() {
        int identrada = 1;
        //System.out.println("getEtiquetasDeEntrada");
        BeanBaseJWiki instance = new BeanBaseJWiki();
        Entrada entrada = instance.getEntrada(identrada);
        Tag[] resultado = new Tag[0];
        resultado = instance.getEtiquetas(entrada);
        System.out.println("Tags asociados con la Entrada: " + entrada.getTitulo());
        for (Tag t : resultado) {
            System.out.println(t.getDescripcion());
        }
        assertNotNull(resultado);
    }

    /**
     * Agregamos un Tag a la BD
     */
    @Test
    public void testRegistrarTag() {
        //System.out.println("testRegistrarTag");
        Tag tag = new Tag(0, "Tag9999");
        BeanBaseJWiki instance = new BeanBaseJWiki();
        if(!instance.createTag(tag)) fail("fallo en REGISTRAR TAG");
    }

    /**
     * Buscamos entradas asociadas a un tag
     */
    @Test
    public void testSearchEntradaPorTag() {
        String tag1 = "latin";
        //System.out.println("testSearchEntradaPorTag");
        BeanBaseJWiki instance = new BeanBaseJWiki();
        Entrada[] e = instance.searchEntradaPorEtiqueta(tag1); //se busca por esta descripcion
        assertTrue(e.length>0);
        //System.out.println("Titulo de la entrada: " + e.getTitulo());
    }

    /**
     * Buscamos entradas asociadas a N tags
     */
    @Test
    public void testSearchEntradaPorTagsSegundaForma() {
        String tag1 = "latin";
        String tag2 = "wiki";
        //System.out.println("testSearchEntradaPorTagsSegundaForma");
        BeanBaseJWiki instance = new BeanBaseJWiki();
        String[] etiquetas = {tag1, tag2};
        Set<Tag> coletiquetas = new HashSet(); //puede ser un SET, MAP, etc... media vez el tata sea collection, no problemo!
        coletiquetas.add(instance.getEtiqueta(tag1));
        coletiquetas.add(instance.getEtiqueta(tag2));

        //Buscamos de dos formas distintas, para ver si obtenemos los mismos resultados ;)
        Collection<Entrada> colentradas = instance.searchEntradaPorEtiquetas(coletiquetas);
        Entrada[] entradas = instance.searchEntradaPorEtiquetas(etiquetas);

        if(colentradas.size() != entradas.length) fail("fallo en la cantidad de datos obtenidos, no concuerdan.");
    }

    /**
     * Busqueda por titulo de entrada
     */
    @Test
    public void testSearchEntradaPorTitulo() {
        String criteria = "ulo 4";
        //System.out.println("testSearchEntradaPorTitulo");
        BeanBaseJWiki instance = new BeanBaseJWiki();
        Entrada[] e = instance.searchEntradaPorTitulo(criteria);
        assertNotNull(e);
    }


    /**
     * Agregamos una Entrada a la BD
     */
    @Test
    public void testRegistrarEntrada() {
        //System.out.println("testRegistrarEntrada");
        BeanBaseJHardmin hardmin = new BeanBaseJHardmin();
        Usuario usuario = hardmin.getUsuario(1);
        Entrada entrada = new Entrada(9999, "La entrada 9999", "nain, nine, nueve, 9, iiiiiiii, etc etc etc", new Date(2009, 9, 9), usuario);
        BeanBaseJWiki instance = new BeanBaseJWiki();
        if(!instance.createEntrada(entrada)) fail("fallo en REGISTRAR ENTRADA");
    }

    /**
     * Agregamos un comentario a la BD
     */
    @Test
    public void testRegistrarComentario() {
        //System.out.println("testRegistrarComentario");
        Comentarios comentario = new Comentarios(9999, "Oh!!! esta es el comentario para la entrada 9999!!!", new Date(2009, 9, 9));
        BeanBaseJWiki instance = new BeanBaseJWiki();
        if(!instance.createComentario(9999, comentario)) fail("fallo en REGISTRAR COMENTARIO");
    }

    /**
     * Agrega el "vinculo" entra una etiqueta y una entrada
     * agregando un nuevo TAG al vuelo, on the fly... tengo sueño.
     * this is a tricky one.
     */
    @Test
    public void testRegistrarTagEntrada() {
        Integer idtag = 777;
        Integer identrada = 9999;
        //System.out.println("");
        BeanBaseJWiki instance = new BeanBaseJWiki();
        Tag tag = new Tag(idtag, "TagTest"); //nuevo tag agregado "al vuelo"
        Entrada e = instance.getEntrada(identrada); //obtenemos la entrada vieja
        TagEntrada te = new TagEntrada(identrada, tag, e); //creamos el vinculo
        e.getTagEntradaCollection().add(te); //agregamos el vinculo al objeto

        instance.updateEntrada(e);

        TagEntrada teclone = instance.searchTagEntrada(e, tag);
        assertEquals(teclone, te);
    }

    /**
     * Elimina el "vinculo" entra una etiqueta y una entrada
     */
    @Test
    public void testEliminarTagEntrada() {
        Integer idtag = 777;
        Integer identrada = 9999;
        //System.out.println("");
        BeanBaseJWiki instance = new BeanBaseJWiki();
        Entrada e = instance.getEntrada(identrada); //obtenemos la entrada vieja
        Tag t = instance.getEtiqueta(idtag); //obtenemos la etiqueta vieja
        TagEntrada te = instance.searchTagEntrada(e, t); //obtenemos la TagEntrada
        //borramos la TagEntrada
        instance.deleteTagEntrada(e, t);
        TagEntrada tenull = instance.searchTagEntrada(e, t); //se supone que seria null
        assertNotSame(tenull, te);
    }

    /**
     * Elimina una etiqueta
     */
    @Test
    public void testEliminarTag() {
        //System.out.println("testEliminarTag");
        BeanBaseJWiki instance = new BeanBaseJWiki();
        instance.deleteTag(0);
        Tag t = instance.getEtiqueta(0);
        if(!(t==null)) fail("fallo en ELIMINAR TAG");
    }

    /**
     * Elimina un comentario
     */
    @Test
    public void testEliminarComentario() {
        //System.out.println("testEliminarComentario");
        BeanBaseJWiki instance = new BeanBaseJWiki();
        Entrada entrada = instance.getEntrada(9999);
        if(entrada==null) fail("fallo en ELIMINAR COMENTARIO (no hay entradas con comentarios)");
        Comentarios[] com = instance.getComentarios(entrada);
        instance.deleteComentario(com[0]);
        Comentarios c = instance.getComentario(com[0].getIdcoment());
        if(!(c==null)) fail("fallo en ELIMINAR COMENTARIO (encontre un comentario que tendria que estar eliminado)");
    }

    /**
     * Elimina una entrada
     */
    @Test
    public void testEliminarEntrada() {
        //System.out.println("testEliminarEntrada");
        BeanBaseJWiki instance = new BeanBaseJWiki();
        instance.deleteEntrada(9999);
        Entrada entrada = instance.getEntrada(9999);
        if(!(entrada==null)) fail("fallo en ELIMINAR ENTRADA");
    }

}