package edu.ues.jhard.beans;

import edu.ues.jhard.jpa.*;
import java.util.Collection;
import javax.persistence.*;

/**
 * @author Rodrigo
 * Notas personales:
 * - Only use EntityManager method persist on a new entity.
 * - Only Refresh para obtener los ultimos datos de la BD
 * - remove to delete an entity from the database.
 * - method flush to send updates to the database within a transaction before the transaction is committed. (unicamente en el mismo contexto)
 * - Por que diablos usan arrays? :S
 * - Nueva logica a partir del 10 de Julio, mejor uso del EM context.
 */
public class BeanBaseJWiki extends BeanBase {

    /**
     * Metodo para obtener un objeto entrada por una etiqueta, se asume que la entrada es nueva, asi que se hace
     * un em.persist sobre la misma.
     */
    public Entrada[] searchEntradaPorEtiqueta(String etiqueta){
        EntityManager em = this.getEntityManager();
        //SELECT DISTINCT(e.identrada), e.titulo, e.descripcion, e.fechahora, e.idusuario FROM entrada e, tag_entrada te, tag t
        //WHERE(t.descripcion LIKE 'wiki') AND te.idtag=t.idtag  AND te.idtagentrada=e.identrada;
        String sql = "SELECT DISTINCT(e.identrada), e.titulo, e.descripcion, e.fechahora, e.idusuario FROM entrada e, tag_entrada te, tag t WHERE" +
                "(t.descripcion LIKE ?1 ) AND te.idtag=t.idtag  AND te.idtagentrada=e.identrada ORDER BY e.fechahora DESC";

        Query q = em.createNativeQuery(sql, Entrada.class);
        q.setParameter(1, etiqueta);

        //TODO: Esto puede retornar más de una entrada.... hay que cambiarlo
        Entrada[] e = (Entrada [])q.getResultList().toArray(new Entrada[0]);

        em.getTransaction().begin();
        for (Entrada entrada : e) {
            em.persist(entrada);
        }
        em.getTransaction().commit();
        return e;
    }

    /**
     * Metodo para obtener un objeto entrada por una etiqueta, se asume que la entrada es nueva, asi que se hace
     * un em.persist sobre la misma.
     */
    public Entrada[] searchEntradaPorEtiquetas(String[] etiquetas){
        EntityManager em = this.getEntityManager();

        String sql = "SELECT DISTINCT(e.identrada), e.titulo, e.descripcion, e.fechahora, e.idusuario FROM entrada e, tag_entrada te, tag t WHERE";

        for (int i = 0; i < etiquetas.length; i++) {
            sql += "( t.descripcion LIKE ?"+i+" )";
            if((i+1)<etiquetas.length) sql += " OR ";
        }

        sql += " AND te.idtag=t.idtag  AND te.idtagentrada=e.identrada ORDER BY e.fechahora DESC";

        Query q = em.createNativeQuery(sql, Entrada.class);

        for (int i = 0; i < etiquetas.length; i++) {
            String etiqueta = etiquetas[i];
            q.setParameter(i, etiqueta);
        }

        Entrada[] entradas = (Entrada[])q.getResultList().toArray(new Entrada[0]);
        em.getTransaction().begin();
        for (Entrada entrada : entradas) {
            em.persist(entrada);
        }
        em.getTransaction().commit();
        return entradas;
    }

    /**
     * Metodo para obtener uno o varios objetos Entrada que coincidan con el titulo que tengan
     */
    public Entrada[] searchEntradaPorTitulo(String titulo){
        EntityManager em = this.getEntityManager();
        String sql = "SELECT DISTINCT(e.identrada), e.titulo, e.descripcion, e.fechahora, e.idusuario " +
                "FROM entrada e WHERE e.titulo LIKE ?0 ORDER BY e.fechahora DESC";

        titulo = "%"+titulo+"%";
        Query q = em.createNativeQuery(sql, Entrada.class);
        q.setParameter(0, titulo);

        Entrada[] e = (Entrada [])q.getResultList().toArray(new Entrada[0]);

        em.getTransaction().begin();
        for (Entrada entrada : e) {
            em.persist(entrada);
        }
        em.getTransaction().commit();
        return e;
    }

    /**
     * Metodo para obtener una collection de Entradas por sus etiquetas asociadas
     * un em.persist sobre la misma.
     */
    public Collection<Entrada> searchEntradaPorEtiquetas(Collection<Tag> etiquetas){
        EntityManager em = this.getEntityManager();

        String sql = "SELECT DISTINCT(e.identrada), e.titulo, e.descripcion, e.fechahora, e.idusuario FROM entrada e, tag_entrada te, tag t WHERE";

        for (int i = 0; i < etiquetas.size(); i++) {
            sql += "( t.descripcion LIKE ?"+i+" )";
            if((i+1)<etiquetas.size()) sql += " OR ";
        }

        sql += " AND te.idtag=t.idtag  AND te.idtagentrada=e.identrada ";

        Query q = em.createNativeQuery(sql, Entrada.class);

        int i = 0;
        for (Tag tag : etiquetas) {
            q.setParameter(i, tag.getDescripcion());
            i++;
        }

        Collection<Entrada> entradas = (Collection<Entrada>)q.getResultList();
        em.getTransaction().begin();
        for (Entrada entrada : entradas) {
            em.persist(entrada);
        }
        em.getTransaction().commit();
        return entradas;
    }

    /**
     * Metodo para obtener las ultimas N entradas en jhard.entradas.
     * @return numero Numero de entradas que se desean
     */
    public Entrada[] getUltimasNEntradas(int numero) {
        EntityManager em = this.getEntityManager();
        Query q = em.createNamedQuery("Entrada.findAll");
        q.setFirstResult(0);
        q.setMaxResults(numero);
        Entrada[] e = (Entrada[]) q.getResultList().toArray(new Entrada[0]);
        for (int i = 0; i < e.length; i++) {
            em.refresh(e[i]);
        }
        return e;
    }

    /**
     * Obtiene TODAS las entradas, :O! use with care
     * @return
     */
    public Entrada[] getEntradas() {
        EntityManager em = this.getEntityManager();
        Query q = em.createNamedQuery("Entrada.findAll");
        Entrada[] e = (Entrada[]) q.getResultList().toArray(new Entrada[0]);
        for (int i = 0; i < e.length; i++) {
            em.refresh(e[i]);
        }
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
     * Metodo para obtener un objeto entrada en el contexto del EM, si no lo encuentra, le hace query.
     * @param entrada
     * @return
     */
    public Entrada getEntrada(Entrada entrada){
        EntityManager em = this.getEntityManager();
        Entrada e = (Entrada)em.find(Entrada.class, entrada.getIdentrada());
        return e;
    }

     /**
     * Metodo para obtener todos los ULTIMOS Tags asociados con el ID de una Entrada
     * @param idEntrada
     * @return
     */
    public Tag[] getEtiquetasEntrada(Entrada entrada) {
        EntityManager em = this.getEntityManager();
        Entrada e = em.find(Entrada.class, entrada.getIdentrada());
        return getEtiquetas(e);
    }

    /**
     * Este metodo recibe una entrada y retorna el arreglo de Tags de esa entrada, sin consultar a la BD
     * @param e
     * @return
     */
    public Tag[] getEtiquetas(Entrada entrada) {
        //alguna validacion?
        TagEntrada[] te = (TagEntrada[]) entrada.getTagEntradaCollection().toArray(new TagEntrada[0]);
        if(te.length <= 0) return null;
        Tag[] tt = new Tag[te.length];
        for (int i = 0; i < te.length; i++) {
            tt[i] = te[i].getIdtag();
        }
        return tt;
    }

    /**
     * Metodo para obtener una etiqueta (por su ID)
     * @param entrada
     * @return
     */
    public Tag getEtiqueta(Integer idetiqueta) {
        EntityManager em = this.getEntityManager();
        Tag t = em.find(Tag.class, idetiqueta);
        return t;
    }

    /**
     * Metodo para obtener una etiqueta (por su descripcion)
     * @param entrada
     * @return
     */
    public Tag getEtiqueta(String descripcion) {
        EntityManager em = this.getEntityManager();
        Query q = em.createNamedQuery("Tag.findByDescripcion");
        q.setParameter("descripcion", descripcion);
        Tag t = (Tag) q.getSingleResult();
        em.getTransaction().begin();
        em.persist(t);
        em.getTransaction().commit();
        return t;
    }

    /**
     * Metodo para obtener los comentarios de un objeto Entrada, sin consultar a la BD
     * @param e
     * @return
     */
    public Comentarios[] getComentarios(Entrada e) {
        Comentarios[] c = (Comentarios[]) e.getComentariosCollection().toArray(new Comentarios[0]);
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
     * Metodo para obtener los comentarios de la BD mediante el id de una Entrada
     * @param idEntrada
     * @return
     */
    public Comentarios[] getComentariosEntrada(Entrada entrada) {
        EntityManager em = this.getEntityManager();
        Entrada e = em.find(Entrada.class, entrada.getIdentrada());
        Comentarios[] c = e.getComentariosCollection().toArray(new Comentarios[0]);
        return c;
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
            return false;
        }
        return true;
    }

    /**
     * Agregamos un comentario a un objeto entrada y hacemos flush a la BD con los cambios
     * @param entrada
     * @param comentario
     */
    public boolean createComentario(Entrada entrada, Comentarios comentario){
        try {
            EntityManager em = this.getEntityManager();
            Entrada e = (Entrada) em.find(Entrada.class, entrada.getIdentrada());

            comentario.setIdentrada(e); //por cualquier cosa.

            Collection<Comentarios> colcom = e.getComentariosCollection();
            colcom.add(comentario);
            e.setComentariosCollection(colcom);
            em.getTransaction().begin();
            //em.merge(colcom);
            em.persist(comentario);
            em.getTransaction().commit();
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    /**
     * Agregamos un comentario a un ID de entrada
     * @param identrada
     * @param comentario
     */
    public boolean createComentario(Integer identrada, Comentarios comentario){
        try {
            EntityManager em = this.getEntityManager();
            Entrada e = (Entrada) em.find(Entrada.class, identrada);
            if(e==null) return false;

            comentario.setIdentrada(e); //por cualquier cosa.

            Collection<Comentarios> colcom = e.getComentariosCollection();
            colcom.add(comentario);
            e.setComentariosCollection(colcom);
            em.getTransaction().begin();
            //em.merge(comentario);
            em.persist(comentario);
            em.getTransaction().commit();
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    /**
     * Metodo para agregar etiquetas
     * @param identrada
     * @param comentario
     * @return
     */
    public boolean createTag(Tag tag){
        try {
            EntityManager em = this.getEntityManager();
            em.getTransaction().begin();
            em.persist(tag);
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
    public void deleteComentario(Entrada entrada, Comentarios comentario){
        EntityManager em = this.getEntityManager();
        Comentarios c = (Comentarios)em.find(Comentarios.class, comentario.getIdcoment());
        Collection<Comentarios> colcom = entrada.getComentariosCollection();
        colcom.remove(c);
        entrada.setComentariosCollection(colcom);
        em.getTransaction().begin();
        em.remove(c);
        em.getTransaction().commit();
    }

    /**
     * Elimina un comentario por su ID
     * @param identrada
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
     * Elimina un TAG indiscriminadamente por su ID de la BD
     * @param tag
     */
    public void deleteTag(Integer idtag){
        EntityManager em = this.getEntityManager();
        Tag t = (Tag)em.find(Tag.class, idtag);
        em.getTransaction().begin();
        em.remove(t);
        em.getTransaction().commit();
    }

    /**
     * Elimina un TAG indiscriminadamente por su ID de la BD
     * @param tag
     */
    public void deleteTagEntrada(Entrada entrada, Tag tag){
        EntityManager em = this.getEntityManager();
        Entrada e = (Entrada)em.find(Entrada.class, entrada.getIdentrada());
        Collection<TagEntrada> tagent = e.getTagEntradaCollection();

        em.getTransaction().begin();
        for (TagEntrada te : tagent) {
            if(te.getIdtag().getIdtag() == tag.getIdtag()) em.remove(te);
        }
        
        em.getTransaction().commit();
    }
    
}
