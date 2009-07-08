/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.ues.jhard.beans;

import edu.ues.jhard.jpa.*;
import javax.persistence.*;


/**
 *
 * @author Hugol
 */
public class BeanBaseJCanon extends BeanBase {

    public Reserva[] getReserva() {
        EntityManager em=this.getEntityManager();

        Query q=em.createNamedQuery("Reserva.findAll");

        Reserva[] r=(Reserva[])q.getResultList().toArray(new Reserva[0]);

        for(int i=0;i<r.length;i++)
            em.refresh(r[i]);
        return r;
    }

     public void registrarReserva(Reserva r) {
        EntityManager em=this.getEntityManager();
        em.getTransaction().begin();
        em.persist(r);
        em.getTransaction().commit();

    }


     public Estadoreserva[] getEstadoReserva() {
        EntityManager em=this.getEntityManager();

        Query q=em.createNamedQuery("Estadoreserva.findAll");

        Estadoreserva[] er=(Estadoreserva[])q.getResultList().toArray(new Estadoreserva[0]);

        for(int i=0;i<er.length;i++)
            em.refresh(er[i]);
        return er;
    }

     public void registrarEstadoReserva(Estadoreserva er) {
        EntityManager em=this.getEntityManager();
        em.getTransaction().begin();
        em.persist(er);
        em.getTransaction().commit();

    }


     public Existencia [] getEquipoMultimedia(Integer clasificacionEquipo){

         EntityManager em = this.getEntityManager();

         Query q = em.createNamedQuery("Existencia.findEquipoMultimedia");

         q.setParameter("idclasificacion", clasificacionEquipo);

         Existencia[] e = (Existencia[])q.getResultList().toArray(new Existencia[0]);

         for (int i = 0; i < e.length; i++) {
             em.refresh(e[i]);
         }
         return e;
     }



}
