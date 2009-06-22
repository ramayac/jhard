package edu.ues.jhard.beans;

import edu.ues.jhard.jpa.*;
import javax.persistence.*;

/**
 *
 * @author Rodrigo
 */
public class BeanBaseJWiki extends BeanBase {

    /**
     * Metodo para obtener las ultimas cinco entradas en jhard.entradas.
     * @return
     */
//    public Entrada[] getUltimasCincoEntradas(){
//        EntityManager em=this.getEntityManager();
//        Query q = em.createNamedQuery("Entrada.findLastFive");
//
//        Entrada[] e = (Entrada[]) q.getResultList().toArray(new Entrada[5]);
//        for (Entrada entrada : e)
//            em.refresh(entrada);
//
//        return e;
//    }

    /**
     * Metodo para obtener una entrada especifica
     * @param identrada id de la entada que se desea
     * @return
     */
    public Entrada getEntrada(int identrada){
        EntityManager em=this.getEntityManager();
        Query q = em.createNamedQuery("Entrada.findByIdentrada");
        q.setParameter("identrada", identrada);

        Entrada[] e = (Entrada[]) q.getResultList().toArray(new Entrada[0]);
        if(e.length<=0){
            return null;
        } else {
            em.refresh(e[0]); //se supone que solo es uno.
            return e[0];
        }
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
