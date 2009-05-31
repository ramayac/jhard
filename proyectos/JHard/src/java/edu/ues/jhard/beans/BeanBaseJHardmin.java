/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.ues.jhard.beans;

import edu.ues.jhard.jpa.Usuario;
import javax.persistence.EntityManager;

/**
 *
 * @author Hugol
 */
public class BeanBaseJHardmin extends BeanBase {

    public Usuario getUsuario(String userName, String userPwd){
        Usuario u = null;
        try{
            System.out.println("Creando el entity manager...");
            EntityManager eMgr = this.getEntityManager();
            System.out.println("Entity manager creado. Generando el query...");
            String strSql = "SELECT u FROM usuario u WHERE u.nombre ='" + userName + "' and u.clave='" + userPwd + "'";
            System.out.println("String sql generado: " + strSql);
            u = (Usuario)eMgr.createQuery(strSql).getSingleResult();
            System.out.println("Usuario creado.");
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        System.out.println("Usuario devuelto: " + u);
        return u;
    }
}
