/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.ues.jhard.beans;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Método base y del cual heredan todos los demas Beans para cada uno de los módulos de JHard
 *
 * @author Hugol
 */
public class BeanBase {

    protected EntityManagerFactory emf;

    /**
     * Método para obtener el EntityManager y obtener así mapeados todos los objetos de la persistencia
     *
     * @return EntityManager
     */
    public EntityManager getEntityManager() {
        if (this.emf==null)
            this.emf=Persistence.createEntityManagerFactory("JHardPU");
        return emf.createEntityManager();
    }

}
