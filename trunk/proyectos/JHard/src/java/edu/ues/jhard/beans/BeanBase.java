/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.ues.jhard.beans;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Hugol
 */
public class BeanBase {

    protected EntityManagerFactory emf;

    public EntityManager getEntityManager() {
        if (this.emf==null)
            this.emf=Persistence.createEntityManagerFactory("JHardPU");
        return emf.createEntityManager();
    }

}
