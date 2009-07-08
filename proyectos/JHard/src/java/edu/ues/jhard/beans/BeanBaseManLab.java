/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.ues.jhard.beans;

import edu.ues.jhard.jpa.Docente;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Hugol
 */
public class BeanBaseManLab extends BeanBase{

    public Docente getDocenteByUsuario(Integer idUsuario) {
        EntityManager em=this.getEntityManager();

        Query q=em.createNamedQuery("Docente.findByIdUsuario");

        q.setParameter("idusuario", idUsuario);

        Docente d=(Docente)q.getSingleResult();

        em.refresh(d);

        return d;
    }

    public Docente[] getDocentes() {
        EntityManager em=this.getEntityManager();

        Query q=em.createNamedQuery("Docente.findAll");

        Docente[] d=(Docente[])q.getResultList().toArray(new Docente[0]);

        for(int i=0;i<d.length;i++)
            em.refresh(d[i]);
        return d;
    }



}

