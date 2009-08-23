package edu.ues.jhard.beans;

import edu.ues.jhard.jpa.Articulos;
import edu.ues.jhard.jwiki.JreqArticulo;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.persistence.*;

/**
 * @author ramayac
 * BeanBase con los metodos necesarios para manejar los entity manager
 * utilizados por jwikiUser y jwikiAdmin.
 * Este bean es como una capa intermedia entre dichas clases y
 * el entity manager de la aplicacion.
 */
public class BeanBaseJWiki extends BeanBase {

    //private final static String MAX_PALABRAS = "200";
    private final static String ESPACIO = " ";
    static final String EMPTY_STRING = "";
    private final static int MIN_CRITERIO = 3;
    private final static int MAX_ARTICULOS = 10;

    /**
     * Metodo para obtener uno o varios objetos Articulos que coincidan con el criterio de busqueda.
     * Este metodo busca sobre el campo titulo de las Articulos.
     */
    public List<Articulos> searchArticuloPorTitulo(String criterio){
        EntityManager em = this.getEntityManager();
        //SUBstring(a.descripcion,1,"+MAX_PALABRAS+") descripcion,
        //SUBstring_INDEX(a.descripcion,' ',"+MAX_PALABRAS+") descripcion
        String sql = "SELECT a.idarticulo, a.titulo, a.descripcion, a.fechahora, a.idusuario " +
                "FROM articulos a WHERE a.titulo LIKE ?0 ORDER BY a.fechahora DESC";
        criterio = "%"+criterio+"%";
        Query q = em.createNativeQuery(sql, Articulos.class);
        q.setParameter(0, criterio);
        List<Articulos> la = q.getResultList();
        return la;
    }

    /**
     * Metodo de busqueda de articulos... 1 palabra: GENIAL.
     * @param criterio
     * @return
     */
    public List<Articulos> searchPalabrasEnArticulo(String criterios){
        if(criterios.length()<MIN_CRITERIO) return null;
        EntityManager em = this.getEntityManager();
        String[] arr = criterios.trim().split(ESPACIO);

        String sql = BuildSQLSearchArticulos(arr);

        //System.out.println(sql);
        Query q = em.createNativeQuery(sql); //sin clase, retorna un Vector
        Vector resultado = (Vector) q.getResultList();

        List<Integer> listaIds = new ArrayList();
        for (Object o: resultado) {
            Vector v = (Vector)o;
            BigDecimal numero = (BigDecimal)v.get(1);
            if(numero.intValue()>0) listaIds.add(Math.round((Long)v.get(0)));
        }

        List<Articulos> listArticulos = new ArrayList();
        int limite = (listaIds.size()>MAX_ARTICULOS)?MAX_ARTICULOS:listaIds.size();
        for (int i = 0; i < limite; i++) { //ni modo, asi es la vida. tengo que pedir uno por uno :S
            Articulos a = new Articulos();
            //a = this.getArticulo(listaIds.get(i));
            a = em.find(Articulos.class, listaIds.get(i));
            System.out.println(a.getIdarticulo()+", "+a.getDescripcion().substring(0, 50));
            listArticulos.add(a);
        }

        return listArticulos;
    }

    /**
     * Metodo de busqueda de articulos para ser usado en JRequest
     * @param criterio
     * @return
     */
    public List<JreqArticulo> searchEnWiki(String criterios){
        if(criterios.length()<MIN_CRITERIO) return null;
        EntityManager em = this.getEntityManager();
        String[] arr = criterios.trim().split(ESPACIO);

        String sql = BuildSQLSearchArticulos(arr);

        System.out.println(sql);
        Query q = em.createNativeQuery(sql);
        Vector vectorArticulos = (Vector) q.getResultList();

        List<JreqArticulo> resultado =  new ArrayList<JreqArticulo>();

        for (Object o : vectorArticulos) {
            Vector v = (Vector)o;
            JreqArticulo ja = new JreqArticulo();
            ja.setVector(v);
            if(ja.TieneOcurrencias()) resultado.add(ja);
        }
        
        return resultado;
    }


    /**
     * Metodo para obtener uno o varios objetos Articulos que coincidan con el criterio de busqueda.
     * Este metodo busca sobre el campo titulo de las Articulos.
     */
    public List<Articulos> getAllArticulos(){
        EntityManager em = this.getEntityManager();
        String sql = "SELECT a.idarticulo, a.titulo, a.descripcion, a.fechahora, a.idusuario " +
                "FROM articulos a ORDER BY a.fechahora DESC";
        Query q = em.createNativeQuery(sql, Articulos.class);
        List<Articulos> la = q.getResultList();
        return la;
    }

    /**
     * Metodo para obtener las ultimas N Articulos en jhard.Articulos.
     * @return numero Numero de Articulos que se desean
     */
    public List<Articulos> getUltimosNArticulos(int numero) {
        EntityManager em = this.getEntityManager();
        String sql = "SELECT a.idarticulo, a.titulo, a.descripcion, a.fechahora, a.idusuario " +
                "FROM articulos a ORDER BY a.fechahora DESC";
        Query q = em.createNativeQuery(sql, Articulos.class);
        q.setFirstResult(0);
        q.setMaxResults(numero);
        List<Articulos> la = q.getResultList();
        return la;
    }

    public List<JreqArticulo> getUltimosCincoArticulosSmall(){
        EntityManager em = this.getEntityManager();

        String sql = "SELECT a.idarticulo, a.titulo FROM articulos a GROUP BY a.idarticulo ORDER BY a.fechahora DESC";

        //System.out.println(sql);
        Query q = em.createNativeQuery(sql);
        q.setMaxResults(5);
        Vector vectorArticulos = (Vector) q.getResultList();

        List<JreqArticulo> resultado =  new ArrayList<JreqArticulo>();

        for (Object o : vectorArticulos) {
            Vector v = (Vector)o;
            JreqArticulo ja = new JreqArticulo();
            ja.setVector(v);
            resultado.add(ja);
        }

        return resultado;
    }

    /**
     * Metodo para obtener una Articulos por su ID
     * @param idArticulos id de la entada que se desea
     * @return
     */
    public Articulos getArticulo(int idArticulo) {
        EntityManager em = this.getEntityManager();
        Articulos a = em.find(Articulos.class, idArticulo);
        return a;
    }

    /**
     * Metodo para añadir un objeto Articulos
     * @param Articulos
     */
    public boolean createArticulo(Articulos articulo){
        try {
            EntityManager em = this.getEntityManager();
            em.getTransaction().begin();
            em.persist(articulo);
            em.getTransaction().commit();
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    /**
     * Metodo para eliminar una Articulos por su ID
     * @param idArticulos
     */
    public void deleteArticulo(int idArticulo) {
        EntityManager em = this.getEntityManager();
        Articulos a = (Articulos)em.find(Articulos.class, idArticulo);
        em.getTransaction().begin();
        em.remove(a);
        em.getTransaction().commit();
    }

    /**
     * Metodo para eliminar un objeto Articulos
     * @param Articulos
     */
    public void deleteArticulo(Articulos articulo){
        EntityManager em = this.getEntityManager();
        Articulos a = em.find(Articulos.class, articulo.getIdarticulo());
        if(a==null) return;
        em.getTransaction().begin();
        em.remove(a);
        em.getTransaction().commit();
    }

    /**
     * Metodo para actualizar un objeto Articulos
     * @param Articulos
     */
    public void updateArticulos(Articulos articulo){
        EntityManager em = this.getEntityManager();
        Articulos a = em.find(Articulos.class, articulo.getIdarticulo());
        a = articulo;
        em.getTransaction().begin();
        em.merge(a);
        em.getTransaction().commit();
    }

    /**
     * Metodo para recargar una Articulos por demanda, por su ID
     * @param Articulos
     */
    public Articulos recargarArticulos(Integer idArticulo){
        EntityManager em = this.getEntityManager();
        Articulos a = em.find(Articulos.class, idArticulo);
        em.getTransaction().begin();
        em.refresh(a);
        em.getTransaction().commit();
        return a;
    }

    /**
     * Metodo para recargar una Articulos por demanda
     * @param Articulos
     */
    public Articulos recargarArticulo(Articulos articulo){
        EntityManager em = this.getEntityManager();
        Articulos a = em.find(Articulos.class, articulo.getIdarticulo());
        a = articulo;
        em.getTransaction().begin();
        em.refresh(a);
        em.getTransaction().commit();
        return a;
    }

    private String BuildSQLSearchArticulos(String[] arr) {
        //TODO: pasar a SQL parametrizado y filtrar arr[0]<3
        String sql = "SELECT a.idarticulo, ( ";
        if (arr.length == 1)
            sql += "(LENGTH(a.descripcion) - LENGTH(REPLACE(a.descripcion, '" + arr[0] + "', '')))/" + arr[0].length();
        if (arr.length > 1) {
            for (int i = 0; i < arr.length; i++) {
                String s = arr[i];
                sql += "(LENGTH(a.descripcion) - LENGTH(REPLACE(a.descripcion, '" + s + "', '')))/" + s.length();
                if (i + 1 >= arr.length) {
                    break;
                }
                sql += " + ";
            }
        }
        sql += " ) ocurrencias, a.titulo FROM articulos a GROUP BY a.idarticulo ORDER BY 2 DESC";
        return sql;
    }
}
