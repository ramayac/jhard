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


     public Responsable[] getResponsable() {
        EntityManager em=this.getEntityManager();

        Query q=em.createNamedQuery("Responsable.findAll");

        Responsable[] r=(Responsable[])q.getResultList().toArray(new Responsable[0]);

        for(int i=0;i<r.length;i++)
            em.refresh(r[i]);
        return r;
    }

     public void registrarResponsable(Responsable r) {
        EntityManager em=this.getEntityManager();
        em.getTransaction().begin();
        em.persist(r);
        em.getTransaction().commit();

    }


      public Solicitante[] getSolicitante() {
        EntityManager em=this.getEntityManager();

        Query q=em.createNamedQuery("Solicitante.findAll");

        Solicitante[] s=(Solicitante[])q.getResultList().toArray(new Solicitante[0]);

        for(int i=0;i<s.length;i++)
            em.refresh(s[i]);
        return s;
    }

     public void registrarSolicitante(Solicitante s) {
        EntityManager em=this.getEntityManager();
        em.getTransaction().begin();
        em.persist(s);
        em.getTransaction().commit();

    }



}
