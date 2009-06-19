/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.ues.jhard.beans;

import edu.ues.jhard.jpa.Usuario;
import javax.persistence.*;


/**
 *
 * @author Hugol
 */
public class BeanBaseJHardmin extends BeanBase {

    public Usuario getUsuario(String userName, String userPwd){
        Usuario u = null;
        try{            
            EntityManager eMgr = this.getEntityManager();            
            String strSql = "SELECT u FROM Usuario u WHERE u.nombre = '"+userName+"' AND u.clave = '"+userPwd+"'";            
            Query q = eMgr.createQuery(strSql);            
            u = (Usuario)q.getSingleResult();            
        }
        catch(Exception ex){
            ex.printStackTrace();
        }        
        return u;
    }

    public Usuario getUsuario(int id){
        Usuario u = null;
        try{            
            EntityManager eMgr = this.getEntityManager();            
            Query q = eMgr.createNamedQuery("Usuario.findByIdusuario");
            q.setParameter("idusuario", id);

            u=(Usuario)q.getSingleResult();
        }
        catch(Exception ex){
            ex.printStackTrace();
        }        
        return u;
    }
}
