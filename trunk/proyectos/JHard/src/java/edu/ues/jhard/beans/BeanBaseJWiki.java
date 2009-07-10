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
     * Metodo para obtener una entrada por su ID
     * @param identrada id de la entada que se desea
     * @return
     */
    public Entrada getEntrada(int identrada) {
        EntityManager em = this.getEntityManager();
        Query q = em.createNamedQuery("Entrada.findByIdentrada");
        q.setParameter("identrada", identrada);
        Entrada e = (Entrada)q.getSingleResult();
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
        if(e==null) return getEntrada(entrada.getIdentrada()); //genial :)
        return e;
    }

    /**
     * Metodo para añadir un objeto entrada
     * @param entrada
     */
    public void addEntrada(Entrada entrada){
        EntityManager em = this.getEntityManager();
        em.persist(entrada);
    }

    /**
     * Metodo para eliminar una Entrada por su ID
     * @param identrada
     */
    public void deleteEntrada(int identrada) {
        EntityManager em = this.getEntityManager();
        Entrada e = (Entrada)em.find(Entrada.class, identrada);
        em.remove(e);
    }

    /**
     * Metodo para eliminar un objeto Entrada
     * @param entrada
     */
    public void deleteEntrada(Entrada entrada){
        EntityManager em = this.getEntityManager();
        em.remove(entrada);
    }

     /**
     * Metodo para obtener todos los ULTIMOS Tags asociados con el ID de una Entrada
     * @param idEntrada
     * @return
     */
    public Tag[] getEtiquetasEntrada(Entrada entrada) {
        EntityManager em = this.getEntityManager();
        Query q = em.createNamedQuery("Entrada.findByIdentrada");
        q.setParameter("identrada", entrada.getIdentrada());
        Entrada e = (Entrada) q.getSingleResult();
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
     * Metodo para obtener los comentarios de un objeto Entrada, sin consultar a la BD
     * @param e
     * @return
     */
    public Comentarios[] getComentarios(Entrada e) {
        Comentarios[] c = (Comentarios[]) e.getComentariosCollection().toArray(new Comentarios[0]);
        return c;
    }

    /**
     * Metodo para obtener los comentarios de la BD mediante el id de una Entrada
     * @param idEntrada
     * @return
     */
    public Comentarios[] getComentariosEntrada(Entrada entrada) {
        EntityManager em = this.getEntityManager();
        Query q = em.createNamedQuery("Comentarios.findByIdEntrada");
        q.setParameter("identrada", entrada.getIdentrada());

        Comentarios[] c = (Comentarios[]) q.getResultList().toArray(new Comentarios[0]);

        Collection<Comentarios> cc = null;
        for (int i = 0; i < c.length; i++) cc.add(c[i]);

        entrada.setComentariosCollection(cc);
        return c;
    }

    /**
     * Metodo para agregar un comentario a un objeto entrada
     * @param e
     * @param c
     * @return
     */
    public Entrada addComentario(Entrada entrada, Comentarios comentario){
        EntityManager em = this.getEntityManager();
        Query q = em.createNamedQuery("Comentarios.findByIdEntrada");
        q.setParameter("identrada", entrada.getIdentrada());

        Comentarios[] c = (Comentarios[]) q.getResultList().toArray(new Comentarios[0]);
        Collection<Comentarios> cc = null;

        for (int i = 0; i < c.length; i++) cc.add(c[i]);

        entrada.setComentariosCollection(cc);
        em.flush();
        return entrada;
    }
    
    /**
     * Metodo para agregar un comentario a un objeto entrada
     * @param e
     * @param c
     * @return
     */
    public Comentarios[] addComentarioEntrada(Entrada entrada, Comentarios comentario){
        EntityManager em = this.getEntityManager();
        Entrada e = (Entrada)em.find(Entrada.class, entrada.getIdentrada());
        Collection<Comentarios> colcom = e.getComentariosCollection();
        colcom.add(comentario);
        e.setComentariosCollection(colcom);
        entrada = e;
        em.flush(); //flush to bd.
        return getComentarios(entrada);
    }

}
