package edu.ues.jhard.beans;

import edu.ues.jhard.jpa.Entrada;
import edu.ues.jhard.jpa.Comentarios;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Vector;
import javax.persistence.*;


/**
 * @author ramayac
 * BeanBase con los metodos necesarios para manejar los entity manager
 * utilizados por jprocrUser y jprocurAdmin.
 * Este bean es como una capa intermedia entre dichas clases y
 * el entity manager de la aplicacion.
 */
public class BeanBaseJProcur extends BeanBase {
    private final static String ESPACIO = " ";
    static final String EMPTY_STRING = "";
    private final static int MIN_CRITERIO = 3;
    private final static int MAX_ENTRADAS = 10;

    /**
     * Metodo para obtener uno o varios objeto entrada por UNA etiqueta, se asume que la entrada es nueva, asi que se hace
     * un em.persist sobre la misma.
     */
    public List<Entrada> searchEntradaPorEtiqueta(String criterios){
        if(criterios.length()<MIN_CRITERIO) return null;
        EntityManager em = this.getEntityManager();
        String[] arr = criterios.trim().split(ESPACIO);

        String sql = BuildSQLSearchEntradas(arr);

        //System.out.println(sql);
        Query q = em.createNativeQuery(sql); //sin clase, retorna un Vector
        Vector resultado = (Vector) q.getResultList();

        List<Integer> listaIds = new ArrayList();
        for (Object o: resultado) {
            Vector v = (Vector)o;
            BigDecimal numero = (BigDecimal)v.get(1);
            if(numero.intValue()>0) listaIds.add(Math.round((Long)v.get(0)));
        }

        List<Entrada> listEntradas = new ArrayList();
        int limite = (listaIds.size()>MAX_ENTRADAS)?MAX_ENTRADAS:listaIds.size();
        for (int i = 0; i < limite; i++) { //ni modo, asi es la vida. tengo que pedir uno por uno :S
            Entrada ent = new Entrada();
            ent = em.find(Entrada.class, listaIds.get(i));
            listEntradas.add(ent);
        }

        return listEntradas;
    }

//    /**
//     * Metodo para obtener uno o varios objeto entrada por un array de etiquetas, se asume que la entrada es nueva, asi que se hace
//     * un em.persist sobre la misma.
//     */
//    public Entrada[] searchEntradaPorEtiquetas(String[] etiquetas){
//        EntityManager em = this.getEntityManager();
//
//        String sql = "SELECT DISTINCT(e.identrada), e.titulo, e.descripcion, e.fechahora, e.idusuario FROM entrada e, tag_entrada te, tag t WHERE";
//        for (int i = 0; i < etiquetas.length; i++) {
//            sql += "( t.descripcion LIKE ?"+i+" )";
//            if((i+1)<etiquetas.length) sql += " OR ";
//        }
//        sql += " AND te.idtag=t.idtag  AND te.identrada=e.identrada ORDER BY e.fechahora DESC";
//
//        Query q = em.createNativeQuery(sql, Entrada.class);
//
//        for (int i = 0; i < etiquetas.length; i++) {
//            String etiqueta = etiquetas[i];
//            q.setParameter(i, etiqueta);
//        }
//
//        Entrada[] entradas = (Entrada[])q.getResultList().toArray(new Entrada[0]);
//
////        em.getTransaction().begin();
////        for (Entrada entrada : entradas) {
////            em.persist(entrada);
////        }
////        em.getTransaction().commit();
//        return entradas;
//    }

//    /**
//     * Metodo para obtener uno o varios objeto entrada por un array de etiquetas, se asume que la entrada es nueva, asi que se hace
//     * un em.persist sobre la misma.
//     */
//    public List<Entrada> searchListaEntradaPorEtiquetas(String[] etiquetas){
//        EntityManager em = this.getEntityManager();
//
//        /*SQL ADHOC*/
//        String sql = "SELECT DISTINCT(e.identrada), e.titulo, e.descripcion, e.fechahora, e.idusuario FROM entrada e, tag_entrada te, tag t WHERE";
//        for (int i = 0; i < etiquetas.length; i++) {
//            sql += "( t.descripcion LIKE ?"+i+" )";
//            if((i+1)<etiquetas.length) sql += " OR ";
//        }
//        sql += " AND te.idtag=t.idtag  AND te.identrada=e.identrada ORDER BY e.fechahora DESC";
//
//        System.out.println(sql);
//        Query q = em.createNativeQuery(sql, Entrada.class);
//
//        for (int i = 0; i < etiquetas.length; i++) {
//            String etiqueta = etiquetas[i];
//            q.setParameter(i, etiqueta);
//        }
//
//        List<Entrada> entradas = q.getResultList();
//
////        em.getTransaction().begin();
////        for (Entrada entrada : entradas) {
////            em.persist(entrada);
////        }
////        em.getTransaction().commit();
//        return entradas;
//    }

    /**
     * Metodo para obtener uno o varios objetos Entrada que coincidan con el criterio de busqueda.
     * Este metodo busca sobre el campo titulo de las entradas.
     */
    public List<Entrada> searchEntradaPorTitulo(String criterio){
        EntityManager em = this.getEntityManager();
        String sql = "SELECT DISTINCT(e.identrada), e.titulo, e.descripcion, e.fechahora, e.idusuario " +
                "FROM entrada e WHERE e.titulo LIKE ?0 ORDER BY e.fechahora DESC";

        criterio = "%"+criterio+"%";
        Query q = em.createNativeQuery(sql, Entrada.class);
        q.setParameter(0, criterio);

        List<Entrada> e = q.getResultList();

//        em.getTransaction().begin();
//        for (Entrada entrada : e) {
//            em.persist(entrada);
//        }
//        em.getTransaction().commit();
        return e;
    }

    /**
     * Metodo para obtener uno o varios objetos Entrada que coincidan con el criterio de busqueda.
     * Este metodo busca sobre el campo titulo de las entradas.
     */
    public List<Entrada> getAllEntradas(){
        EntityManager em = this.getEntityManager();
        String sql = "SELECT DISTINCT(e.identrada), e.titulo, e.descripcion, e.fechahora, e.idusuario " +
                "FROM entrada e ORDER BY e.fechahora DESC";

        Query q = em.createNativeQuery(sql, Entrada.class);

        List<Entrada> e = q.getResultList();
        return e;
    }

    /**
     * Metodo para obtener las ultimas N entradas en jhard.entradas.
     * @return numero Numero de entradas que se desean
     */
    public List<Entrada> getUltimasNEntradas(int numero) {
        EntityManager em = this.getEntityManager();
        String sql = "SELECT DISTINCT(e.identrada), e.titulo, e.descripcion, e.fechahora, e.idusuario " +
                "FROM entrada e ORDER BY e.fechahora DESC";

        Query q = em.createNativeQuery(sql, Entrada.class);
        q.setFirstResult(0);
        q.setMaxResults(numero);
        List<Entrada> e = q.getResultList();
        return e;
    }

    /**
     * Metodo para obtener una entrada por su ID
     * @param identrada id de la entada que se desea
     * @return
     */
    public Entrada getEntrada(int identrada) {
        EntityManager em = this.getEntityManager();
        Entrada e = em.find(Entrada.class, identrada);
        return e;
    }

    /**
     * Metodo para obtener los comentarios de un objeto Entrada, sin consultar a la BD
     * @param e
     * @return
     */
    public List<Comentarios> getComentarios(Entrada e) {
        List<Comentarios> c = (List<Comentarios>)e.getComentariosCollection();
        return c;
    }

    /**
     * Metodo para obtener un comentario por su ID
     * @param idEntrada
     * @return
     */
    public Comentarios getComentario(Integer idcomentario) {
        EntityManager em = this.getEntityManager();
        Comentarios c = em.find(Comentarios.class, idcomentario);
        return c;
    }

    /**
     * Metodo para obtener la lista de TODOS los comentarios NO aprobados
     * @param idEntrada
     * @return
     */
    public List<Comentarios> getComentariosNoAprobados() {
        EntityManager em = this.getEntityManager();
        Query q = em.createNamedQuery("Comentarios.findNOAprobado");
        List<Comentarios> listaCom = q.getResultList();
        return listaCom;
    }

    /**
     * Metodo para obtener la lista de TODOS los comentarios aprobados
     * @param idEntrada
     * @return
     */
    public List<Comentarios> getComentariosAprobados() {
        EntityManager em = this.getEntityManager();
        Query q = em.createNamedQuery("Comentarios.findAprobado");
        List<Comentarios> listaCom = q.getResultList();
        return listaCom;
    }

    /**
     * Metodo para obtener los comentarios de la BD mediante el id de una Entrada
     * @param idEntrada
     * @return
     */
    public List<Comentarios> getComentariosEntrada(Entrada entrada) {
        EntityManager em = this.getEntityManager();
        Entrada e = em.find(Entrada.class, entrada.getIdentrada());
        Query q = em.createNamedQuery("Comentarios.findAprobadoByIdentrada");
        q.setParameter("identrada", e);
        List<Comentarios> listaCom = q.getResultList();
        return listaCom;
    }

    /**
     * Metodo para aprobar un comentario
     * @param comentario
     * @return
     */
    public Comentarios aprobarComentario(Comentarios comentario){
        EntityManager em = this.getEntityManager();
        comentario.setAprobado(true);
        em.getTransaction().begin();
        em.merge(comentario);
        em.getTransaction().commit();
        return comentario;
    }

    /**
     * Metodo para aprobar un comentario por su ID
     * @param comentario
     * @return
     */
    public Comentarios aprobarComentario(Integer idcomentario){
        EntityManager em = this.getEntityManager();
        Comentarios comentario = em.find(Comentarios.class, idcomentario);
        comentario.setAprobado(true);
        em.getTransaction().begin();
        em.merge(comentario);
        em.getTransaction().commit();
        return comentario;
    }

    /**
     * Metodo para revertir el estado de aprobacion de un comentario
     * más que todo, este metodo se usa en el Test.
     * @param comentario
     * @return
     */
    public Comentarios desaprobarComentario(Comentarios comentario){
        EntityManager em = this.getEntityManager();
        comentario.setAprobado(false);
        em.getTransaction().begin();
        em.merge(comentario);
        em.getTransaction().commit();
        return comentario;
    }

    /**
     * Metodo para añadir un objeto entrada
     * @param entrada
     */
    public boolean createEntrada(Entrada entrada){
        try {
            EntityManager em = this.getEntityManager();
            em.getTransaction().begin();
            em.persist(entrada);
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("(createEntrada) "+e.getMessage());
            return false;
        }
        return true;
    }

    /**
     * Creamos un comentario a un objeto entrada y hacemos merge de la nueva entity
     * @param entrada
     * @param comentario
     */
    public boolean createComentario(Entrada entrada, Comentarios comentario){
        try {
            EntityManager em = this.getEntityManager();
            Entrada e = (Entrada) em.find(Entrada.class, entrada.getIdentrada());

            comentario.setIdentrada(e); //por cualquier cosa.

            List<Comentarios> colcom = (List<Comentarios>)e.getComentariosCollection();
            colcom.add(comentario);
            e.setComentariosCollection(colcom);
            em.getTransaction().begin();
            em.merge(e);
            em.getTransaction().commit();
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    /**
     * creamos un comentario a un ID de entrada y le hacemos merge a la nueva entity
     * @param identrada
     * @param comentario
     */
    public boolean createComentario(Integer identrada, Comentarios comentario){
        try {
            EntityManager em = this.getEntityManager();
            Entrada e = (Entrada) em.find(Entrada.class, identrada);
            if(e==null) return false;

            comentario.setIdentrada(e); //por cualquier cosa.

            List<Comentarios> colcom = (List<Comentarios>)e.getComentariosCollection();
            colcom.add(comentario);
            e.setComentariosCollection(colcom);
            em.getTransaction().begin();
            em.merge(e);
            em.getTransaction().commit();
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    /**
     * Metodo para eliminar una Entrada por su ID
     * @param identrada
     */
    public void deleteEntrada(int identrada) {
        EntityManager em = this.getEntityManager();
        Entrada e = (Entrada)em.find(Entrada.class, identrada);
        em.getTransaction().begin();
        em.remove(e);
        em.getTransaction().commit();
    }

    /**
     * Metodo para eliminar un objeto Entrada
     * @param entrada
     */
    public void deleteEntrada(Entrada entrada){
        EntityManager em = this.getEntityManager();
        em.getTransaction().begin();
        em.remove(entrada);
        em.getTransaction().commit();
    }

    /**
     * Metodo para eliminar un comentario de una entrada
     * @param entrada
     * @param comentario
     */
    public void deleteComentario(Comentarios comentario){
        EntityManager em = this.getEntityManager();
        Comentarios c = (Comentarios)em.find(Comentarios.class, comentario.getIdcoment());
        em.getTransaction().begin();
        em.remove(c);
        em.getTransaction().commit();
    }

    /**
     * Metodo para eliminar un comentario de una entrada por su ID
     * @param entrada
     * @param comentario
     */
    public void deleteComentario(Integer idcomentario){
        EntityManager em = this.getEntityManager();
        Comentarios c = (Comentarios)em.find(Comentarios.class, idcomentario);
        if(c==null) return;
        em.getTransaction().begin();
        em.remove(c);
        em.getTransaction().commit();
    }

    /**
     * Metodo para actualizar un objeto entrada
     * @param entrada
     */
    public Entrada updateEntrada(Entrada entrada){
        try {
            EntityManager em = this.getEntityManager();
            Entrada e = em.find(Entrada.class, entrada.getIdentrada());
            e = entrada;
            em.getTransaction().begin();
            em.merge(e);
            em.getTransaction().commit();
            return e;
        } catch (Exception ex) {
            System.out.println("(updateEntrada) "+ex.getMessage());
        }
        return null;
    }

    /**
     * Metodo para añadirle un comentario a una entrada
     * @param entrada
     */
    public void updateComentarioEntrada(Entrada entrada, Comentarios comentario){
        EntityManager em = this.getEntityManager();
        Entrada e = em.find(Entrada.class, entrada.getIdentrada());
        e.getComentariosCollection().add(comentario);
        em.getTransaction().begin();
        em.merge(e);
        em.getTransaction().commit();
    }

    /**
     * Metodo para recargar una Entrada por demanda, por su ID
     * @param entrada
     */
    public Entrada recargarEntrada(Integer identrada){
        EntityManager em = this.getEntityManager();
        Entrada e = em.find(Entrada.class, identrada);
        em.getTransaction().begin();
        em.refresh(e);
        em.getTransaction().commit();
        return e;
    }

    /**
     * Metodo para recargar una Entrada por demanda
     * @param entrada
     */
    public Entrada recargarEntrada(Entrada entrada){
        EntityManager em = this.getEntityManager();
        Entrada e = em.find(Entrada.class, entrada.getIdentrada());
        e = entrada;
        em.getTransaction().begin();
        em.refresh(e);
        em.getTransaction().commit();
        return e;
    }

//    public void mergeTagsEntrada(List<TagEntrada> listaTagEntradas){
//        EntityManager em = this.getEntityManager();
//        em.getTransaction().begin();
//        em.merge(listaTagEntradas);
//        em.getTransaction().commit();
//    }

//    /**
//     * Metodo para añadirle una lista de etiquetas a una entrada
//     * @param entrada
//     */
//    public void updateTagsEntrada(Entrada entrada, Collection<Tag> etiquetas){
//        EntityManager em = this.getEntityManager();
//        Entrada e = em.find(Entrada.class, entrada.getIdentrada());
//        e.getTagEntradaCollection().
//        e.getTagEntradaCollection().add(tagentrada);
//        em.getTransaction().begin();
//        em.merge(e);
//        em.getTransaction().commit();
//    }

    /**
     * Metodo para añadirle una etiqueta a la entradaActual
     * @param entrada
     */
//    public void addTagEntrada(TagEntrada tagentrada){
//        EntityManager em = this.getEntityManager();
//        this.entradaActual.getTagEntradaCollection().add(tagentrada);
//        em.getTransaction().begin();
//        em.merge(this.entradaActual);
//        em.getTransaction().commit();
//    }

        /**
     * Metodo para agregar un comentario a una entradaActual
     * @param entrada
     */
//    public void addComentario(Comentarios comentario){
//        EntityManager em = this.getEntityManager();
//        this.entradaActual.getComentariosCollection().add(comentario);
//        em.getTransaction().begin();
//        em.merge(this.entradaActual); //a merge, I hope.
//        em.getTransaction().commit();
//    }


    private String BuildSQLSearchEntradas(String[] arr) {
        //TODO: pasar a SQL parametrizado y filtrar arr[0]<3
        String sql = "SELECT a.identrada, ( ";
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
        sql += " ) ocurrencias, a.titulo FROM entrada a GROUP BY a.identrada ORDER BY 2 DESC";
        return sql;
    }
}
