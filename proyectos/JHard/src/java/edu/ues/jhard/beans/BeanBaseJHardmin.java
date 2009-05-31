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
            System.out.println("Creando el entity manager...");
            EntityManager eMgr = this.getEntityManager();
            System.out.println("Entity manager creado. Generando el query...");
            //String strSql = "SELECT * FROM Usuario WHERE nombre = '"+userName+"' AND clave = '"+userPwd+"'";
            //System.out.println("String sql generado: " + strSql);
            //Query q = eMgr.createQuery(strSql);
            Query q = eMgr.createNamedQuery("Usuario.findByUser");
            q.setParameter("nombre", userName);
            q.setParameter("clave", userPwd);
            u = (Usuario)q.getSingleResult();
            System.out.println("Usuario creado.");
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        System.out.println("Usuario devuelto: " + u);
        return u;
    }

    public Usuario getUsuario(int id){
        Usuario u = null;
        try{
            System.out.println("Creando el entity manager...");
            EntityManager eMgr = this.getEntityManager();
            System.out.println("Entity manager creado. Generando el query...");
            //String strSql = "SELECT u FROM usuario u WHERE u.idusuario = " + String.valueOf(id);
            //System.out.println("String sql generado: " + strSql);
            //Query q = eMgr.createQuery(strSql);
            //Query q = eMgr.createNativeQuery("Select * from usuario limit 1");
            Query q = eMgr.createNamedQuery("Usuario.findByIdusuario");
            q.setParameter(id, "idusuario");

            u=(Usuario)q.getSingleResult();
            //Vector v = (Vector)q.getSingleResult();
            //System.out.println("Vector obtenido: " + v.toString());
            //u = (Usuario)v.get(0);

            System.out.println("Usuario creado.");
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        System.out.println("Usuario devuelto: " + u);
        return u;
    }
}
