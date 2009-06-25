/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.ues.jhard.beans;

import edu.ues.jhard.jpa.*;
import java.util.Date;
import javax.persistence.*;

/**
 *
 * @author Hugol
 */
public class BeanBaseJRequest extends BeanBase{


    //CRUD

    public Estadoequipo[] getEstadoEquipo() {
        EntityManager em=this.getEntityManager();
        
        Query q=em.createNamedQuery("Estadoequipo.findAll");
        
        Estadoequipo[] eeq=(Estadoequipo[])q.getResultList().toArray(new Estadoequipo[0]);
        
        for(int i=0;i<eeq.length;i++)
            em.refresh(eeq[i]);
        return eeq;
    }

     public void registrarEstadoEquipo(Estadoequipo eeq) {
        EntityManager em=this.getEntityManager();
        em.getTransaction().begin();
        em.persist(eeq);
        em.getTransaction().commit();

    }


     public Bitacoraestados[] getBitacoraEstados() {
        EntityManager em=this.getEntityManager();

        Query q=em.createNamedQuery("Bitacoraestados.findAll");

        Bitacoraestados[] be=(Bitacoraestados[])q.getResultList().toArray(new Bitacoraestados[0]);

        for(int i=0;i<be.length;i++)
            em.refresh(be[i]);
        return be;
    }

     public void registrarBitacoraEstados(Bitacoraestados be) {
        EntityManager em=this.getEntityManager();
        em.getTransaction().begin();
        em.persist(be);
        em.getTransaction().commit();

    }

     public void modificarBitacoraEstados(Bitacoraestados b, String value){

         EntityManager em = this.getEntityManager();
         Bitacoraestados be= em.find(Bitacoraestados.class, b.getIdbitacora());
         be.setDescripcion(value);
         System.out.println(be.getIdbitacora());
         em.getTransaction().begin();
         em.persist(be);
         em.getTransaction().commit();
     }


     public Mantenimiento[] getMantenimiento() {
        EntityManager em=this.getEntityManager();

        Query q=em.createNamedQuery("Mantenimiento.findAll");

        Mantenimiento[] m=(Mantenimiento[])q.getResultList().toArray(new Mantenimiento[0]);

        for(int i=0;i<m.length;i++)
            em.refresh(m[i]);
        return m;
    }

     public void registrarMantenimiento(Mantenimiento m) {
        EntityManager em=this.getEntityManager();
        em.getTransaction().begin();
        em.persist(m);
        em.getTransaction().commit();

    }


    public Tecnico[] getTecnico() {
        EntityManager em=this.getEntityManager();

        Query q=em.createNamedQuery("Tecnico.findAll");

        Tecnico[] t=(Tecnico[])q.getResultList().toArray(new Tecnico[0]);

        for(int i=0;i<t.length;i++)
            em.refresh(t[i]);
        return t;
    }

     public void registrarTecnico(Tecnico t) {
        EntityManager em=this.getEntityManager();
        em.getTransaction().begin();
        em.persist(t);
        em.getTransaction().commit();

    }

     public void eliminarTecnico(Tecnico t){
         
         EntityManager em = this.getEntityManager();
         Tecnico T= em.find(Tecnico.class, t.getIdtecnico());
         System.out.println(T.getIdtecnico());
         em.getTransaction().begin();
         em.remove(T);
         em.getTransaction().commit();
     }


        public Solicitud[] getSolicitud() {
        EntityManager em=this.getEntityManager();

        Query q=em.createNamedQuery("Solicitud.findAll");

        Solicitud[] s=(Solicitud[])q.getResultList().toArray(new Solicitud[0]);

        for(int i=0;i<s.length;i++)
            em.refresh(s[i]);
        return s;
    }

     public void registrarSolicitud(Solicitud s) {
        EntityManager em=this.getEntityManager();
        em.getTransaction().begin();
        em.persist(s);
        em.getTransaction().commit();

    }

    public Equiposimple[] getEquipoSimple() {
        EntityManager em=this.getEntityManager();

        Query q=em.createNamedQuery("Equiposimple.findAll");

        Equiposimple[] eqs=(Equiposimple[])q.getResultList().toArray(new Equiposimple[0]);

        for(int i=0;i<eqs.length;i++)
            em.refresh(eqs[i]);
        return eqs;
    }


    public void registrarEquipoSimple(Equiposimple eqs) {
        EntityManager em=this.getEntityManager();
        em.getTransaction().begin();
        em.persist(eqs);
        em.getTransaction().commit();

    }


//REGLAS DE NEGOCIO
    public Equiposimple[] getEquipoSimpleByPropietario(String propietario) {
        EntityManager em=this.getEntityManager();

        Query q=em.createNamedQuery("Equiposimple.findByPropietario");

        q.setParameter("propietario", propietario);

        Equiposimple[] eqs=(Equiposimple[])q.getResultList().toArray(new Equiposimple[0]);

        for(int i=0;i<eqs.length;i++)
            em.refresh(eqs[i]);
        return eqs;
    }

    public Equiposimple getEquipoSimpleByID(Integer idEquiposimple) {
        EntityManager em=this.getEntityManager();

        Query q=em.createNamedQuery("Equiposimple.findByIdEquipoSimple");

        q.setParameter("idEquipoSimple", idEquiposimple);

        Equiposimple eqs=(Equiposimple)q.getSingleResult();

        em.refresh(eqs);
        return eqs;
    }

    public Solicitud[] getSolicitudesByPrioridad(String prioridad) {
        EntityManager em=this.getEntityManager();

        Query q=em.createNamedQuery("Solicitud.findByPrioridad");

        q.setParameter("prioridad", prioridad);

        Solicitud[] s=(Solicitud[])q.getResultList().toArray(new Solicitud[0]);

        for(int i=0;i<s.length;i++)
        em.refresh(s[i]);
        return s;
    }


    public Estadoequipo getEstadoEquipoByID(Integer idEstado) {
        EntityManager em=this.getEntityManager();

        Query q=em.createNamedQuery("Estadoequipo.findByIdestado");

        q.setParameter("idestado", idEstado);

        Estadoequipo eeq=(Estadoequipo)q.getSingleResult();

       em.refresh(eeq);
        return eeq;
    }


    public Solicitud getSolicitudByFecha(Date fecha ) {
        EntityManager em=this.getEntityManager();

        Query q=em.createNamedQuery("Solicitud.findByFecha");

        q.setParameter("fecha", fecha);

        Solicitud s=(Solicitud)q.getSingleResult();

        em.refresh(s);
        return s;
    }

    public Solicitud getSolicitudByPrioridad(String prioridad) {
        EntityManager em=this.getEntityManager();


        Query q=em.createNamedQuery("Solicitud.findByPrioridad");

        q.setParameter("prioridad", prioridad);

        Solicitud s=(Solicitud)q.getSingleResult();

        em.refresh(s);
        return s;
    }

    public Bitacoraestados[] getBitacoraEstadosByIdEquipoSimple(Equiposimple e) {
        EntityManager em=this.getEntityManager();

        Query q=em.createNamedQuery("Bitacoraestados.findoByIdEquipoSimple");

        q.setParameter("idequiposimple", e);

        Bitacoraestados[] be=(Bitacoraestados[])q.getResultList().toArray(new Bitacoraestados[0]);

        for(int i=0;i<be.length;i++)
            em.refresh(be[i]);
        return be;
    }

}