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
public class BeanBaseJRequest extends BeanBase{


    /**
     * Método para obtener todos los Estadoequipo de JHard
     * @return Estadoequipo[] eeq
     *
     */
    public Estadoequipo[] getEstadoEquipo() {
        EntityManager em=this.getEntityManager();
        
        Query q=em.createNamedQuery("Estadoequipo.findAll");
        
        Estadoequipo[] eeq=(Estadoequipo[])q.getResultList().toArray(new Estadoequipo[0]);
        
        for(int i=0;i<eeq.length;i++)
            em.refresh(eeq[i]);
        return eeq;
    }

    /**
     * Método para agregar un nuevo Estadoequipo
     * @param Estadoequipo eeq
     */
     public void registrarEstadoEquipo(Estadoequipo eeq) {
        EntityManager em=this.getEntityManager();
        em.getTransaction().begin();
        em.persist(eeq);
        em.getTransaction().commit();

    }


     /**
      * Método para obtener todos las Bitacoraestados de JHard
      * @return Bitacoraestados[] be
      */
     public Bitacoraestados[] getBitacoraEstados() {
        EntityManager em=this.getEntityManager();

        Query q=em.createNamedQuery("Bitacoraestados.findAll");

        Bitacoraestados[] be=(Bitacoraestados[])q.getResultList().toArray(new Bitacoraestados[0]);

        for(int i=0;i<be.length;i++)
            em.refresh(be[i]);
        return be;
    }

     /**
      * Método para registrar una nueva Bitacoraestados
      * @param Bitacoraestados be
      */
     public void registrarBitacoraEstados(Bitacoraestados be) {
        EntityManager em=this.getEntityManager();
        em.getTransaction().begin();
        em.persist(be);
        em.getTransaction().commit();

    }

     /**
      * Método para modificar una Bitacoraestado existente en JHard
      * @param Bitacoraestados b
      */
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

     /**
      * Método para modificar una Existencia de la base de datos de JHard
      * @param Existencia e
      */
     public void modificarExistencia(Existencia e){

         EntityManager em = this.getEntityManager();
         Existencia E= em.find(Existencia.class, e.getIdexistencia());

         //SOLO CAMBIO EL ESTADO
         E.setIdestado(e.getIdestado());

         em.getTransaction().begin();
         em.persist(E);
         em.getTransaction().commit();
     }


     /**
      * Método para obtener todos los Mantenimientos de JHard
      * @return Mantenimiento[] m;
      */
     public Mantenimiento[] getMantenimiento() {
        EntityManager em=this.getEntityManager();

        Query q=em.createNamedQuery("Mantenimiento.findAll");

        Mantenimiento[] m=(Mantenimiento[])q.getResultList().toArray(new Mantenimiento[0]);

        for(int i=0;i<m.length;i++)
            em.refresh(m[i]);
        return m;
    }

     /**
      * Método para registrar un nuevo mantenimiento
      * @param Mantenimiento m
      */
     public void registrarMantenimiento(Mantenimiento m) {
        EntityManager em=this.getEntityManager();
        
        Bitacoraestados b = new Bitacoraestados();
        b.setDescripcion("Se ha enviado a Mantenimiento y será revisado por el Técnico "+m.getIdtecnico().getNombres() +" "+m.getIdtecnico().getApellidos());
        b.setFecha(m.getFecha());

        if(m.getIdequiposimple()==null){
            Existencia e = this.getEntityManager().find(Existencia.class, m.getIdequipoexistente().getIdexistencia());
            Estadoequipo ee = this.getEntityManager().find(Estadoequipo.class, 2);
            e.setIdestado(ee);
            this.modificarExistencia(e);
            b.setIdequipoexistente(m.getIdequipoexistente());
            b.setIdestado(ee);
        }
            
        else{
            Equiposimple e = this.getEntityManager().find(Equiposimple.class, m.getIdequiposimple().getIdEquipoSimple());
            Estadoequipo ee = this.getEntityManager().find(Estadoequipo.class, 2);
            e.setIdestado(ee);
            this.modificarEquipoSImple(e);
            b.setIdequiposimple(m.getIdequiposimple());
            b.setIdestado(ee);
        }

        em.getTransaction().begin();
        em.persist(m);
        em.getTransaction().commit();

        em.getTransaction().begin();
        em.persist(b);
        em.getTransaction().commit();

    }

     /**
      * Método para modificar un mantenimiento, en el estado en el que se encuentra, donde el parámetro value puede ser "Pendiente" o "Finalizado"
      * @param Mantenimiento m
      * @param String value
      */
     public void modificarMantenimiento(Mantenimiento m, String value){

         EntityManager em = this.getEntityManager();
         Mantenimiento M= em.find(Mantenimiento.class, m.getIdmantenimiento());
         M.setEstado(value);
         //System.out.println(be.getIdbitacora());
         em.getTransaction().begin();
         em.persist(M);
         em.getTransaction().commit();
     }


     /**
      * Método para obtener todos los Técnicos de JHard
      * @return Tecnico[] t
      */
    public Tecnico[] getTecnico() {
        EntityManager em=this.getEntityManager();

        Query q=em.createNamedQuery("Tecnico.findAll");

        Tecnico[] t=(Tecnico[])q.getResultList().toArray(new Tecnico[0]);

        for(int i=0;i<t.length;i++)
            em.refresh(t[i]);
        return t;
    }

    /**
     * Método para agregar un nuevo Técnico
     * @param Tecnico t
     */
     public void registrarTecnico(Tecnico t) {
        EntityManager em=this.getEntityManager();
        em.getTransaction().begin();
        em.persist(t);
        em.getTransaction().commit();

    }

     public boolean eliminarTecnico(Tecnico t){
         boolean sePudo=false;
         try{
            EntityManager em = this.getEntityManager();
             Tecnico T= em.find(Tecnico.class, t.getIdtecnico());
             System.out.println(T.getIdtecnico());
             em.getTransaction().begin();
             em.remove(T);
             em.getTransaction().commit();
             sePudo=true;
         }
         catch(Exception ex){
             ex.printStackTrace();
         }
         return sePudo;
     }


        public Solicitud[] getSolicitud() {
        EntityManager em=this.getEntityManager();

        Query q=em.createNamedQuery("Solicitud.findAll");

        Solicitud[] s=(Solicitud[])q.getResultList().toArray(new Solicitud[0]);

        for(int i=0;i<s.length;i++)
            em.refresh(s[i]);
        return s;
    }

     /**
      * Método para agregar una nueva solicitud a JHard. Coloca en estado de mantenimiento el equipo asociado a dicha solicitud y
      * crea además un registro en Bitacoraestados con la orden que se extiende que el equipo ha fallado
      *
      * @param Solicitud s
      */
     public void registrarSolicitud(Solicitud s) {
        Bitacoraestados b = new Bitacoraestados();
        b.setDescripcion(s.getDescripcion());
        b.setFecha(s.getFecha());

        if(s.getIdequiposimple()==null){
            Existencia e = this.getEntityManager().find(Existencia.class, s.getIdequipoexistente().getIdexistencia());
            Estadoequipo ee = this.getEntityManager().find(Estadoequipo.class, 2);
            e.setIdestado(ee);
            this.modificarExistencia(e);
            b.setIdequipoexistente(s.getIdequipoexistente());
            b.setIdestado(ee);
        }
            
        else{
            Equiposimple e = this.getEntityManager().find(Equiposimple.class, s.getIdequiposimple().getIdEquipoSimple());
            Estadoequipo ee = this.getEntityManager().find(Estadoequipo.class, 2);
            e.setIdestado(ee);
            this.modificarEquipoSImple(e);
            b.setIdequiposimple(s.getIdequiposimple());
            b.setIdestado(ee);
        }
        
        EntityManager em=this.getEntityManager();
        em.getTransaction().begin();
        em.persist(s);
        em.getTransaction().commit();

        em.getTransaction().begin();
        em.persist(b);
        em.getTransaction().commit();
    }

     /**
      * Método para eliminar una solicitud de JHard
      * @param Solicitud s
      */
     public void eliminarSolicitud(Solicitud s){

         EntityManager em = this.getEntityManager();
         Solicitud S= em.find(Solicitud.class, s.getIdsolicitud());
         Estadoequipo ee = this.getEntityManager().find(Estadoequipo.class, 1);
         if(S.getIdequiposimple()!=null){
             Equiposimple eq = this.getEntityManager().find(Equiposimple.class, S.getIdequiposimple().getIdEquipoSimple());
             eq.setIdestado(ee);
             this.modificarEquipoSImple(eq);
         }else{
             Existencia ex = this.getEntityManager().find(Existencia.class, S.getIdequipoexistente().getIdexistencia());
             ex.setIdestado(ee);
             this.modificarExistencia(ex);
         }
         
         em.getTransaction().begin();
         em.remove(S);
         em.getTransaction().commit();
     }

     /**
      * Método para obtener todo el Equiposimple que se encuentre funcionando con estado "Excelente"
      * @return Equiposimple[] eqs
      */
     public Equiposimple[] getEquipoSimpleFuncionando() {
        EntityManager em=this.getEntityManager();

        Query q=em.createNamedQuery("Equiposimple.findByEstado");
        Estadoequipo e = this.getEntityManager().find(Estadoequipo.class, 1);
        q.setParameter("idestado", e);
        Equiposimple[] eqs=(Equiposimple[])q.getResultList().toArray(new Equiposimple[0]);

        for(int i=0;i<eqs.length;i++)
            em.refresh(eqs[i]);
        return eqs;
    }

     /**
      * Método para obtener todo el Equiposimple que se encuentre funcionando con estado "Excelente"
      * @return List<Equiposimple> eqs
      */
    public List<Equiposimple> getListaEquipoSimpleFuncionando() {
        EntityManager em=this.getEntityManager();

        Query q=em.createNamedQuery("Equiposimple.findByEstado");
        Estadoequipo e = this.getEntityManager().find(Estadoequipo.class, 1);
        q.setParameter("idestado", e);

        List<Equiposimple> eqs=(List<Equiposimple>)q.getResultList();

        for(int i=0;i<eqs.size();i++)
            em.refresh(eqs.get(i));
        return eqs;
    }

    /**
     * Método para obtener todos los Equipos Simples de JHard
     * @return Equiposimple[] eqs
     */
    public Equiposimple[] getEquipoSimple() {
        EntityManager em=this.getEntityManager();

        Query q=em.createNamedQuery("Equiposimple.findAll");

        Equiposimple[] eqs=(Equiposimple[])q.getResultList().toArray(new Equiposimple[0]);

        for(int i=0;i<eqs.length;i++)
            em.refresh(eqs[i]);
        return eqs;
    }

    /**
     * Método para obtener una lista de todos los Equipos Simples de JHard
     * @return List<Equiposimple> eqs
     */
    public List<Equiposimple> getListaEquipoSimple() {
        EntityManager em=this.getEntityManager();

        Query q=em.createNamedQuery("Equiposimple.findAll");
        
        List<Equiposimple> eqs=(List<Equiposimple>)q.getResultList();

        for(int i=0;i<eqs.size();i++)
            em.refresh(eqs.get(i));
        return eqs;
    }

    /**
     * Método para obtener una lista de todas las Existencias de JHard
     * @return List<Existencia> e
     */
    public List<Existencia> getListaExistencia() {
        EntityManager em=this.getEntityManager();

        Query q=em.createNamedQuery("Existencia.findAll");

        List<Existencia> e=(List<Existencia>)q.getResultList();

        for(int i=0;i<e.size();i++)
            em.refresh(e.get(i));
        return e;
    }

    /**
     * Método para obtener una lista de Existencias con estado "Excelente"
     * @return List<Existencia> e
     */
    public List<Existencia> getListaExistenciaFuncionando() {
        EntityManager em=this.getEntityManager();

        Query q=em.createNamedQuery("Existencia.findByEstado");

        Estadoequipo ee = this.getEntityManager().find(Estadoequipo.class, 2);
        q.setParameter("idestado", ee);

        List<Existencia> e=(List<Existencia>)q.getResultList();

        for(int i=0;i<e.size();i++)
            em.refresh(e.get(i));
        return e;
    }

    /**
     * Método para obtener todas las Existencias de JHard
     * @return Existencia[] ex
     */
    public Existencia[] getExistencia() {
        EntityManager em=this.getEntityManager();
        //String codigo ="%labcom1%";

        Query q=em.createNamedQuery("Existencia.findAll");
        
        //q.setParameter("codigo", codigo);

        Existencia[] ex=(Existencia[])q.getResultList().toArray(new Existencia[0]);

        for(int i=0;i<ex.length;i++)
            em.refresh(ex[i]);
        return ex;
    }


    /**
     * Método para agregar un nuevo Equipo Simple
     * @param Equiposimple eqs
     */
    public void registrarEquipoSimple(Equiposimple eqs) {
        EntityManager em=this.getEntityManager();
        em.getTransaction().begin();
        em.persist(eqs);
        em.getTransaction().commit();

    }

    /**
     * Método para modificar un Equipo Simple en la base de datos de JHard
     * @param Equiposimple e
     */
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

    /**
     * Método para eliminar un Equipo simple en la base de datos de JHard
     * @param Equiposimple e
     */
    public boolean eliminarEquipoSimple(Equiposimple e){
        boolean sePudo=false;
        try{
            EntityManager em = this.getEntityManager();
            Equiposimple EQ= em.find(Equiposimple.class, e.getIdEquipoSimple());
            em.getTransaction().begin();
            em.remove(EQ);
            em.getTransaction().commit();
            sePudo=true;
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        return sePudo;
     }


     /**
      * Método para obtener los Equipos Simples pertenecientes a un propietario en común
      * @param String propietario
      * @return Equiposimple[] eqs
      */
    public Equiposimple[] getEquipoSimpleByPropietario(String propietario) {
        EntityManager em=this.getEntityManager();

        Query q=em.createNamedQuery("Equiposimple.findByPropietario");

        q.setParameter("propietario", propietario);

        Equiposimple[] eqs=(Equiposimple[])q.getResultList().toArray(new Equiposimple[0]);

        for(int i=0;i<eqs.length;i++)
            em.refresh(eqs[i]);
        return eqs;
    }

    /**
     * Método para obtener un Equipo Simple mediante su ID
     * @param Integer idEquiposimple
     * @return Equiposimple eqs
     */
    public Equiposimple getEquipoSimpleByID(Integer idEquiposimple) {
        EntityManager em=this.getEntityManager();

        Query q=em.createNamedQuery("Equiposimple.findByIdEquipoSimple");

        q.setParameter("idEquipoSimple", idEquiposimple);

        Equiposimple eqs=(Equiposimple)q.getSingleResult();

        em.refresh(eqs);
        return eqs;
    }

    /**
     * Método para obtener las solicitudes mediante una prioridad en específica, tomando en cuenta que las tres prioridades
     * posibles son "Alta", "Media" y "Baja"
     * @param String prioridad
     * @return Solicitud[] s
     */
    public Solicitud[] getSolicitudesByPrioridad(String prioridad) {
        EntityManager em=this.getEntityManager();

        Query q=em.createNamedQuery("Solicitud.findByPrioridad");

        q.setParameter("prioridad", prioridad);

        Solicitud[] s=(Solicitud[])q.getResultList().toArray(new Solicitud[0]);

        for(int i=0;i<s.length;i++)
        em.refresh(s[i]);
        return s;
    }


    /**
     * Método para obtener un Estadoequipo a través de su ID
     * @param Integer idEstado
     * @return Estadoequipo eeq
     */
    public Estadoequipo getEstadoEquipoByID(Integer idEstado) {
        EntityManager em=this.getEntityManager();

        Query q=em.createNamedQuery("Estadoequipo.findByIdestado");

        q.setParameter("idestado", idEstado);

        Estadoequipo eeq=(Estadoequipo)q.getSingleResult();

       em.refresh(eeq);
        return eeq;
    }


    /**
     * Método para obtener una solicitud por una fecha específica
     * @param Date fecha
     * @return Solicitud s
     */
    public Solicitud getSolicitudByFecha(Date fecha ) {
        EntityManager em=this.getEntityManager();

        Query q=em.createNamedQuery("Solicitud.findByFecha");

        q.setParameter("fecha", fecha);

        Solicitud s=(Solicitud)q.getSingleResult();

        em.refresh(s);
        return s;
    }

    /**
     * Método para obtener una solicitud por una prioridad específica
     * @param String prioridad
     * @return Solicitud s
     */
    public Solicitud getSolicitudByPrioridad(String prioridad) {
        EntityManager em=this.getEntityManager();


        Query q=em.createNamedQuery("Solicitud.findByPrioridad");

        q.setParameter("prioridad", prioridad);

        Solicitud s=(Solicitud)q.getSingleResult();

        em.refresh(s);
        return s;
    }

    /**
     * Método para obtener las Bitacoraestados de un Equipo Simple en particular
     * @param Equiposimple e
     * @return Bitacoraestados[] be
     */
    public Bitacoraestados[] getBitacoraEstadosByIdEquipoSimple(Equiposimple e) {
        EntityManager em=this.getEntityManager();

        Query q=em.createNamedQuery("Bitacoraestados.findoByIdEquipoSimple");

        q.setParameter("idequiposimple", e);

        Bitacoraestados[] be=(Bitacoraestados[])q.getResultList().toArray(new Bitacoraestados[0]);

        for(int i=0;i<be.length;i++)
            em.refresh(be[i]);
        return be;
    }


    /**
     * Método para obtener las Bitacoraestados de una Existencia en particular
     * @param Existencia e
     * @return Bitacoraestados[] be
     */
    public Bitacoraestados[] getBitacoraEstadosByIdExistencia(Existencia e) {
        EntityManager em=this.getEntityManager();

        Query q=em.createNamedQuery("Bitacoraestados.findoByIdExistencia");

        q.setParameter("idequipoexistente", e);

        Bitacoraestados[] be=(Bitacoraestados[])q.getResultList().toArray(new Bitacoraestados[0]);

        for(int i=0;i<be.length;i++)
            em.refresh(be[i]);
        return be;
    }

    /**
     * Método para obtener todos los Mantenimientos de acuerdo a un estado en particular, tomando en cuenta que los estados
     * posibles son "Pendiente" y "Finalizado"
     * @param String estado
     * @return Mantenimiento[] m
     */
    public Mantenimiento[] getMantenimientoByEstado(String estado) {
        EntityManager em=this.getEntityManager();

        Query q=em.createNamedQuery("Mantenimiento.findByEstado");

        q.setParameter("estado", estado);

        Mantenimiento[] m=(Mantenimiento[])q.getResultList().toArray(new Mantenimiento[0]);

        for(int i=0;i<m.length;i++)
            em.refresh(m[i]);
        return m;
    }

}
