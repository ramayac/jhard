/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.ues.jhard.beans;

import edu.ues.jhard.jpa.*;
import java.util.Date;
import java.util.List;
import javax.persistence.*;


/**
 *
 * @author Hugol
 */
public class BeanBaseJCanon extends BeanBase {

    public BeanBaseJCanon(){
            }


    public Reserva[] getReserva() {
        EntityManager em=this.getEntityManager();

        Query q=em.createNamedQuery("Reserva.findAll");

        Reserva[] r=(Reserva[])q.getResultList().toArray(new Reserva[0]);

        for(int i=0;i<r.length;i++)
            em.refresh(r[i]);
        return r;
    }


    public Equipo[] getEquipoClasificado(int idclasificacion) {
        EntityManager em=this.getEntityManager();

        Query q=em.createNamedQuery("Equipo.findByClasificacion");
        
        q.setParameter("idclasificacion", idclasificacion);

        Equipo[] e=(Equipo[])q.getResultList().toArray(new Equipo[0]);

        for(int i=0;i<e.length;i++)
            em.refresh(e[i]);
        return e;
    }

    public void registrarExistencia(Existencia e) {
        EntityManager em=this.getEntityManager();
        em.getTransaction().begin();
        em.persist(e);
        em.getTransaction().commit();

    }
    public void modificarEstadoReserva(Reserva r){

         EntityManager em = this.getEntityManager();
         Reserva R= em.find(Reserva.class, r.getIdreserva());

         //be.setDescripcion(b.getDescripcion());
         //be.setIdestado(b.getIdestado());

         R.setFechahorainicioprestamo(r.getFechahorainicioprestamo());
         R.setFechahorafinprestamo(r.getFechahorafinprestamo());
         R.setIdestado(r.getIdestado());

         em.getTransaction().begin();
         em.persist(R);
         em.getTransaction().commit();
     }

    public void eliminarReserva(Reserva r){

         EntityManager em = this.getEntityManager();
         Reserva R= em.find(Reserva.class, r.getIdreserva());
         em.getTransaction().begin();
         em.remove(R);
         em.getTransaction().commit();
     }



     public Reserva[] getReservaByEstado(Integer estado) {
        EntityManager em=this.getEntityManager();

        Query q=em.createNamedQuery("Reserva.findByEstadoReserva");

        q.setParameter("idestadoreserva", estado);

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

     public String getReservasDeUnaMismaHoraFecha(Date r){
         String count;

         EntityManager em = this.getEntityManager();

         Query q = em.createNamedQuery("Reserva.findMismaHora");

         q.setParameter("fechahorainicioprestamo", r);

         count = q.getSingleResult().toString();

         return count;
     }



     public String getNumeroEquipoMultimedia(Integer clasificacionEquipo){
         String count="";

         EntityManager em = this.getEntityManager();

         Query q = em.createNamedQuery("Existencia.contarEquipos");

         q.setParameter("idclasificacion", clasificacionEquipo);

         count = q.getSingleResult().toString();

         return count;
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

     public List<Reserva> getReservasPendientesEnUso(){

         List<Reserva> listaReservasPendientesEnUso;

         EntityManager em = this.getEntityManager();

         listaReservasPendientesEnUso =  em.createNamedQuery("Reserva.findEnUso").getResultList();
         
         listaReservasPendientesEnUso.addAll(em.createNamedQuery("Reserva.findPendientes").getResultList());
        
         return listaReservasPendientesEnUso;
     }

      public List<Reserva> getReservas(){

         EntityManager em = this.getEntityManager();

         return em.createNamedQuery("Reserva.findAll").getResultList();

     }
}
