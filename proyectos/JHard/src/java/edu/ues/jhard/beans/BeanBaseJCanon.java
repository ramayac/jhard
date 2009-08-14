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

    /**
     * Método para obtener todas las reservas de equipo multimedia de JHard
     *
     * @return Reserva[] r
     */
    public Reserva[] getReserva() {
        EntityManager em=this.getEntityManager();

        Query q=em.createNamedQuery("Reserva.findAll");

        Reserva[] r=(Reserva[])q.getResultList().toArray(new Reserva[0]);

        for(int i=0;i<r.length;i++)
            em.refresh(r[i]);
        return r;
    }


    /**
     * Método para obtener todo el equipo de una clasificación en particular, por medio del ID de Clasificacion
     * @param Integer idclasificacion
     * @return Equipo [] eq
     */
    public Equipo[] getEquipoClasificado(int idclasificacion) {
        EntityManager em=this.getEntityManager();

        Query q=em.createNamedQuery("Equipo.findByClasificacion");
        
        q.setParameter("idclasificacion", idclasificacion);

        Equipo[] e=(Equipo[])q.getResultList().toArray(new Equipo[0]);

        for(int i=0;i<e.length;i++)
            em.refresh(e[i]);
        return e;
    }

    /**
     * Método para agregar una nueva Existencia en la base de datos
     * @param Existencia e
     */
    public void registrarExistencia(Existencia e) {
        EntityManager em=this.getEntityManager();
        em.getTransaction().begin();
        em.persist(e);
        em.getTransaction().commit();

    }

    /**
     * Método para modificar el estado de una reserva de la base de datos
     * @param Reserva r
     */
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

    /**
     * Método para eliminar una Reserva de la base de datos
     * @param Reserva r
     */
    public void eliminarReserva(Reserva r){

         EntityManager em = this.getEntityManager();
         Reserva R= em.find(Reserva.class, r.getIdreserva());
         em.getTransaction().begin();
         em.remove(R);
         em.getTransaction().commit();
     }


     /**
      * Método para obtener reservas de equipo multimedia por su estado, tomando en cuenta que los estados pueden ser
      * "Pendiente", "En Uso" y "Despachada"
      * @param Integer estado
      * @return Reserva[] r
      */
     public Reserva[] getReservaByEstado(Integer estado) {
        EntityManager em=this.getEntityManager();

        Query q=em.createNamedQuery("Reserva.findByEstadoReserva");

        q.setParameter("idestadoreserva", estado);

        Reserva[] r=(Reserva[])q.getResultList().toArray(new Reserva[0]);

        for(int i=0;i<r.length;i++)
            em.refresh(r[i]);
        return r;
    }

     /**
      * Método para agregar una nueva reserva de equipo multimedia
      * @param Reserva r
      */
     public void registrarReserva(Reserva r) {
        EntityManager em=this.getEntityManager();
        em.getTransaction().begin();
        em.persist(r);
        em.getTransaction().commit();
     }

     /**
      * Método para obtener todos los Estadoreserva de JHard
      * @return Estadoreserva[] er
      */
     public Estadoreserva[] getEstadoReserva() {
        EntityManager em=this.getEntityManager();

        Query q=em.createNamedQuery("Estadoreserva.findAll");

        Estadoreserva[] er=(Estadoreserva[])q.getResultList().toArray(new Estadoreserva[0]);

        for(int i=0;i<er.length;i++)
            em.refresh(er[i]);
        return er;
    }

     /**
      * Método para agregar un nuevo Estadoreserva, de modo que JHard pueda ser extensible en todo momento
      * @param Estadoreserva er
      */
     public void registrarEstadoReserva(Estadoreserva er) {
        EntityManager em=this.getEntityManager();
        em.getTransaction().begin();
        em.persist(er);
        em.getTransaction().commit();
    }

     /**
      * Método para obtener todas las reservas de una hora y día específicos. Se envía la fecha con hora completa y devuelve
      * el número de reservas en formato String pendientes para ese día y hora
      * @param Date r
      * @return String count
      */
     public String getReservasDeUnaMismaHoraFecha(Date r){
         String count;

         EntityManager em = this.getEntityManager();

         Query q = em.createNamedQuery("Reserva.findMismaHora");

         q.setParameter("fechahorainicioprestamo", r);

         count = q.getSingleResult().toString();

         return count;
     }


     /**
      * Método para obtener el número de equipos multimedia disponibles para realizar una reserva, es decir que unicamente
      * toma en cuenta los equipos que están en dicha clasificación y que se encuentra en estado "Excelente"
      * @param Integer clasificacionEquipo
      * @return String count
      */
     public String getNumeroEquipoMultimedia(Integer clasificacionEquipo){
         String count="";

         EntityManager em = this.getEntityManager();

         Query q = em.createNamedQuery("Existencia.contarEquipos");

         q.setParameter("idclasificacion", clasificacionEquipo);

         count = q.getSingleResult().toString();

         return count;
     }

     /**
      * Método para obtener todo el equipo multimedia registrado en JHard, sin importar su estado
      *
      * @param Integer clasificacionEquipo
      * @return Existencia[] e
      */
     public Existencia [] getEquipoMultimedia(Integer clasificacionEquipo){

         EntityManager em = this.getEntityManager();

         Query q = em.createNamedQuery("Existencia.findEquipoMultimedia");

         q.setParameter("idclasificacion", clasificacionEquipo);

         Existencia[] e = (Existencia[])q.getResultList().toArray(new Existencia[0]);

         if(e.length>0){
            for (int i = 0; i < e.length; i++) {
             em.refresh(e[i]);
         }
         }
         
         return e;
     }

     /**
      * Método para obtener todas las reservas de equipo multimedia que se encuentra con estado "pendiente" y "en uso",
      * descartando las que se encuentran despachadas
      * @return List<Reserva> listaReservasPendientesEnUso
      */
     public List<Reserva> getReservasPendientesEnUso(){

         List<Reserva> listaReservasPendientesEnUso;

         EntityManager em = this.getEntityManager();

         listaReservasPendientesEnUso =  em.createNamedQuery("Reserva.findEnUso").getResultList();
         
         listaReservasPendientesEnUso.addAll(em.createNamedQuery("Reserva.findPendientes").getResultList());
        
         return listaReservasPendientesEnUso;
     }

     /**
      * Método para obtener una lista con todas las reservas realizadas, sin importar el estado en el que se encuentren
      * @return List<Reserva> r
      */
     public List<Reserva> getReservas(){

         EntityManager em = this.getEntityManager();

         return em.createNamedQuery("Reserva.findAll").getResultList();

     }

     /**
      * Método para obtener todas las reservas de un mismo día
      * @param Integer dia
      * @param Integer mes
      * @param Integer anio
      * @return List<Reserva> lista
      */
      public List<Reserva> getReservasMismoDia(int dia, int mes, int anio){

          List<Reserva> lista;

          EntityManager em = this.getEntityManager();

          String sql = "SELECT idreserva, fechareserva, fechahorainicioprestamo, fechahorafinprestamo, idubicacion, idequipoexistente, idusuario, idestado, descripcion, iddocente FROM reserva WHERE MONTH(fechahorainicioprestamo) = "+mes+" AND DAY(fechahorainicioprestamo)= "+dia+" AND YEAR(fechahorainicioprestamo)= "+anio;

          System.out.println(sql);

          Query q = em.createNativeQuery(sql,Reserva.class);

          lista = q.getResultList();

          return lista;
      }
}
