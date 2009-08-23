/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ues.jhard.beans;

import edu.ues.jhard.jpa.Configuracion;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Sencillo bean, con el unico objetivo de facilitar la obtencion de los valores
 * que se encuentran en la tabla "configuracion" de la base de datos.
 * @author rodrigo
 */
public class BeanBaseConfig {

    static List<Configuracion> listaConfiguracion = new ArrayList<Configuracion>();
    static Map<String, String> variablesConfiguracion = new HashMap<String, String>();
    static protected EntityManagerFactory emf;

    private static EntityManager getEntityManager() {
        if (emf == null) {
            emf = Persistence.createEntityManagerFactory("JHardPU");
        }
        return emf.createEntityManager();
    }

    static public String getValor(String clave) {
        return BeanBaseConfig.variablesConfiguracion.get(clave);
    }

    static public void recargaConfiguracion() {
        listaConfiguracion.clear();
        listaConfiguracion = getAllConfiguracion();
        for (Configuracion configuracion : listaConfiguracion) {
            variablesConfiguracion.put(configuracion.getClave(), configuracion.getValor());
        }
    }

    static List<Configuracion> getAllConfiguracion() {
        EntityManager em = getEntityManager();
        return em.createNamedQuery("Configuracion.findAll").getResultList();
    }
}
