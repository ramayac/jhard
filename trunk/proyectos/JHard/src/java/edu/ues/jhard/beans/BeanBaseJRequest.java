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

     public void modificarBitacoraEstados(Bitacoraestados b){

         EntityManager em = this.getEntityManager();
         Bitacoraestados be= em.find(Bitacoraestados.class, b.getIdbitacora());
         
         be.setDescripcion(b.getDescripcion());
         be.setIdestado(b.getIdestado());

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

     public void modificarMantenimiento(Mantenimiento m, String value){

         EntityManager em = this.getEntityManager();
         Mantenimiento M= em.find(Mantenimiento.class, m.getIdmantenimiento());
         M.setEstado(value);
         //System.out.println(be.getIdbitacora());
         em.getTransaction().begin();
         em.persist(M);
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
        Bitacoraestados b = new Bitacoraestados();
        b.setDescripcion(s.getDescripcion());
        b.setFecha(s.getFecha());

        if(s.getIdequiposimple()==null){
            b.setIdequipoexistente(s.getIdequipoexistente());
            b.setIdestado(s.getIdequipoexistente().getIdestado());
        }
            
        else{
            b.setIdequiposimple(s.getIdequiposimple());
            b.setIdestado(s.getIdequiposimple().getIdestado());
        }
        
        EntityManager em=this.getEntityManager();
        em.getTransaction().begin();
        em.persist(s);
        em.getTransaction().commit();

        em.getTransaction().begin();
        em.persist(b);
        em.getTransaction().commit();
    }

     public void eliminarSolicitud(Solicitud s){

         EntityManager em = this.getEntityManager();
         Solicitud S= em.find(Solicitud.class, s.getIdsolicitud());
         em.getTransaction().begin();
         em.remove(S);
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

    public Existencia[] getExistencia() {
        EntityManager em=this.getEntityManager();
        String codigo ="%labcom1%";

        Query q=em.createNamedQuery("Existencia.findByCodigo");
        
        q.setParameter("codigo", codigo);

        Existencia[] ex=(Existencia[])q.getResultList().toArray(new Existencia[0]);

        for(int i=0;i<ex.length;i++)
            em.refresh(ex[i]);
        return ex;
    }


    public void registrarEquipoSimple(Equiposimple eqs) {
        EntityManager em=this.getEntityManager();
        em.getTransaction().begin();
        em.persist(eqs);
        em.getTransaction().commit();

    }

    public void modificarEquipoSImple(Equiposimple e){

         EntityManager em = this.getEntityManager();
         Equiposimple EQ= em.find(Equiposimple.class, e.getIdEquipoSimple());

         System.out.println(e.getIdEquipoSimple());
         System.out.println(e.getDescripcion());
         System.out.println(e.getPropietario());
         System.out.println(e.getIdestado().getIdestado());

         EQ.setDescripcion(e.getDescripcion());
         EQ.setIdestado(e.getIdestado());
         EQ.setPropietario(e.getPropietario());

         System.out.println(EQ.getIdEquipoSimple());
         System.out.println(EQ.getDescripcion());
         System.out.println(EQ.getPropietario());
         System.out.println(EQ.getIdestado().getIdestado());

         em.getTransaction().begin();
         em.persist(EQ);
         em.getTransaction().commit();
     }

    public void eliminarEquipoSimple(Equiposimple e){

         EntityManager em = this.getEntityManager();
         Equiposimple EQ= em.find(Equiposimple.class, e.getIdEquipoSimple());
         em.getTransaction().begin();
         em.remove(EQ);
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



    public Bitacoraestados[] getBitacoraEstadosByIdExistencia(Existencia e) {
        EntityManager em=this.getEntityManager();

        Query q=em.createNamedQuery("Bitacoraestados.findoByIdExistencia");

        q.setParameter("idequipoexistente", e);

        Bitacoraestados[] be=(Bitacoraestados[])q.getResultList().toArray(new Bitacoraestados[0]);

        for(int i=0;i<be.length;i++)
            em.refresh(be[i]);
        return be;
    }

    public Mantenimiento[] getMantenimientoByEstado(String estado) {
        EntityManager em=this.getEntityManager();

        Query q=em.createNamedQuery("Mantenimiento.findByEstado");

        q.setParameter("estado", estado);

        Mantenimiento[] be=(Mantenimiento[])q.getResultList().toArray(new Mantenimiento[0]);

        for(int i=0;i<be.length;i++)
            em.refresh(be[i]);
        return be;
    }

}
