package edu.ues.jhard.beans;

import edu.ues.jhard.jpa.*;
import java.util.Collection;
import javax.persistence.*;

/**
 *
 * @author Rodrigo
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
     * Metodo para obtener una entrada especifica
     * @param identrada id de la entada que se desea
     * @return
     */
    public Entrada getEntrada(int identrada) {
        EntityManager em = this.getEntityManager();
        Query q = em.createNamedQuery("Entrada.findByIdentrada");
        q.setParameter("identrada", identrada);
        Entrada[] e = (Entrada[]) q.getResultList().toArray(new Entrada[0]);
        if (e.length != 1) return null;
        em.refresh(e[0]); //se supone que solo es una.
        return e[0];
    }

//    public Tag[] getEtiquetasEntrada(Entrada e) {
//        EntityManager em = this.getEntityManager();
//        Query q = em.createNamedQuery("TagEntrada.findByIdentrada");
//        q.setParameter("identrada", e.getIdentrada());
//        TagEntrada[] te = (TagEntrada[]) q.getResultList().toArray(new TagEntrada[0]);
//        Tag[] t = new Tag[te.length];
//        for (int i = 0; i < te.length; i++) {
//            em.refresh(te);
//            t[i] = te[i].getIdtag();
//        }
//        return t;
//    }

     /**
     * Metodo para obtener todos los ULTIMOS Tags asociados con el ID de una Entrada
     * @param idEntrada
     * @return
     */
    public Tag[] getEtiquetasEntrada(Entrada entrada) {
        EntityManager em = this.getEntityManager();
        Query q = em.createNamedQuery("Entrada.findByIdentrada");
        q.setParameter("identrada", entrada.getIdentrada());

        Entrada[] e = (Entrada[]) q.getResultList().toArray(new Entrada[0]);
        if(e.length!=1) return null;

        em.refresh(e);

        Tag[] tt = new Tag[0];
        TagEntrada[] te = (TagEntrada[]) e[0].getTagEntradaCollection().toArray(new TagEntrada[0]);
        for (int i = 0; i < te.length; i++) {
            tt[i] = te[i].getIdtag();
        }

        return tt;
    }

    /**
     * Este metodo recibe una entrada y retorna el arreglo de Tags de esa entrada, sin consultar a la BD
     * @param e
     * @return
     */
    public Tag[] getEtiquetas(Entrada e) {
        //if() return null; //alguna validacion?
        TagEntrada[] te = (TagEntrada[]) e.getTagEntradaCollection().toArray(new TagEntrada[0]);
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

        //List<Comentarios> lc = q.getResultList();
        //Comentarios[] c = (Comentarios[]) q.getResultList().toArray(new Comentarios[0]);
        //Comentarios[] c = (Comentarios[]) lc.toArray(new Comentarios[0]);

        Comentarios[] c = (Comentarios[]) q.getResultList().toArray(new Comentarios[0]);
        Collection<Comentarios> cc = null;

        for (int i = 0; i < c.length; i++) {
            cc.add(c[i]);
        }

        entrada.setComentariosCollection(cc);
        em.refresh(entrada);
        return c;
    }
    /**
     * Metodo para obtener las ultimas N entradas en jhard.entradas.
     * @param N
     * @return
     */
//    public Entrada[] getUltimasNEntradas(int N){
//        EntityManager em=this.getEntityManager();
//        Query q = em.createNamedQuery("Entrada.findLastN");
//        q.setParameter("numero", new Integer(N).toString());
//
//        Entrada[] e = (Entrada[]) q.getResultList().toArray(new Entrada[N]);
//        for (Entrada entrada : e)
//            em.refresh(entrada);
//
//        return e;
//    }

//     public void registrarReserva(Reserva r) {
//        EntityManager em=this.getEntityManager();
//        em.getTransaction().begin();
//        em.persist(r);
//        em.getTransaction().commit();
//
//    }
//
//
//     public Estadoreserva[] getEstadoReserva() {
//        EntityManager em=this.getEntityManager();
//
//        Query q=em.createNamedQuery("Estadoreserva.findAll");
//
//        Estadoreserva[] er=(Estadoreserva[])q.getResultList().toArray(new Estadoreserva[0]);
//
//        for(int i=0;i<er.length;i++)
//            em.refresh(er[i]);
//        return er;
//    }
//
//     public void registrarEstadoReserva(Estadoreserva er) {
//        EntityManager em=this.getEntityManager();
//        em.getTransaction().begin();
//        em.persist(er);
//        em.getTransaction().commit();
//
//    }
//
//    public Responsable[] getResponsable() {
//        EntityManager em=this.getEntityManager();
//
//        Query q=em.createNamedQuery("Responsable.findAll");
//
//        Responsable[] r=(Responsable[])q.getResultList().toArray(new Responsable[0]);
//
//        for(int i=0;i<r.length;i++)
//            em.refresh(r[i]);
//        return r;
//    }
//
//     public void registrarResponsable(Responsable r) {
//        EntityManager em=this.getEntityManager();
//        em.getTransaction().begin();
//        em.persist(r);
//        em.getTransaction().commit();
//
//    }
//
//
//      public Solicitante[] getSolicitante() {
//        EntityManager em=this.getEntityManager();
//
//        Query q=em.createNamedQuery("Solicitante.findAll");
//
//        Solicitante[] s=(Solicitante[])q.getResultList().toArray(new Solicitante[0]);
//
//        for(int i=0;i<s.length;i++)
//            em.refresh(s[i]);
//        return s;
//    }
//
//     public void registrarSolicitante(Solicitante s) {
//        EntityManager em=this.getEntityManager();
//        em.getTransaction().begin();
//        em.persist(s);
//        em.getTransaction().commit();
//
//    }
}
