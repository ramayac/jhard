/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.ues.jhard.jhardmin;

import edu.ues.jhard.beans.BeanBaseJHardmin;
import edu.ues.jhard.jpa.Usuario;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Administra el login, logout y el mantenimiento de la sesion de los usuarios que usan el sistema
 * @author robertux
 * @version 0.1
 */
public class LoginManager {
    private static LoginManager lmanager = null;
    private Map<Integer, LoggedUser> loggedUsers = null;

    /*
     * Agrega el usuario a la lista de usuarios logueados, si este existe en la base de datos y si no estaba logueado antes
     */
    public synchronized int Login(String userName, String userPwd, String url){        
        if(!this.isLogged(userName)){
            if(this.existsInBD(userName, userPwd)){
                Integer uid = this.generateUID();
                this.loggedUsers.put(uid, new LoggedUser(uid, userName, url));
                return uid;
            }
        }
        return -1;
    }

    /*
     * Elimina el usuario representado por su uid de la lista de usuarios logueados
     */
    public synchronized boolean Logout(int uid){
        if(this.isLogged(uid)){
            this.loggedUsers.remove(uid);
            return true;
        }
        return false;
    }

    /*
     *Constructor privado de la clase
     */
    private LoginManager(){
        //Evitamos que puedan crear nuevas instancias directamente
        this.loggedUsers = new HashMap();
    }

    /*
     * Verifica si un usuario ya se encuentra logueado, segun su id de usuario
     */
    public boolean isLogged(Integer uid){
        return this.loggedUsers.containsKey(uid);
    }

    /*
     * Verifica si un usuario ya se encuentra logueado, segun su nombre de usuario
     */
    public boolean isLogged(String userName){
        Iterator itUsers = this.loggedUsers.keySet().iterator();
        boolean userLogged = false;
        while(itUsers.hasNext()){
            Integer uid = (Integer)itUsers.next();
            if(this.loggedUsers.containsKey(uid))
                return true;
        }
        return userLogged;
    }

    /*
     * Devuelve la instancia unica del LoginManager
     */
    public static LoginManager getInstance(){
        if(lmanager == null)
            lmanager = new LoginManager();
        return lmanager;
    }

    /*
     * Genera un User ID aleatorio para asignar y administrar los usuarios logueados en el sistema
     */
    public Integer generateUID(){
        return Integer.valueOf(Double.valueOf(Math.random()*100).intValue());
    }

    public boolean existsInBD(String userName, String userPwd){
        System.out.println("Creando el bean base...");
        BeanBaseJHardmin bbase = new BeanBaseJHardmin();
        System.out.println("Obteniendo el usuario...");
        Usuario u = bbase.getUsuario(userName, userPwd);
        return (u != null);
    }
}
