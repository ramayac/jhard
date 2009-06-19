/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.ues.jhard.jhardmin;

import edu.ues.jhard.beans.BeanBaseJHardmin;
import edu.ues.jhard.jpa.Usuario;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import java.security.*;

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
           System.out.println("Encriptando...");
            if(this.existsInBD(userName, userPwd)){
                Integer uid = new BeanBaseJHardmin().getUsuario(userName, encrypt(userPwd)).getIdusuario();
                this.loggedUsers.put(uid, new LoggedUser(uid, userName, url));
                return uid;
            }
        }
        else{
            return this.getUser(userName).getUid();
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
     * Elimina el usuario representado por su uid de la lista de usuarios logueados
     */
    public synchronized boolean Logout(String userName) {
        if(this.isLogged(userName)){
            LoggedUser usr = this.getUser(userName);
            this.loggedUsers.remove(usr.getUid());
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
        return (this.getUser(uid) != null);
    }

    /*
     * Verifica si un usuario ya se encuentra logueado, segun su nombre de usuario
     */
    public boolean isLogged(String userName){        
        return (this.getUser(userName) != null);
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
        Usuario u = bbase.getUsuario(userName, encrypt(userPwd));
        return (u != null);
    }

    public LoggedUser getUser(Integer uid){
        return this.loggedUsers.get(uid);
    }

    public LoggedUser getUser(String userName){
        Iterator itUsers = this.loggedUsers.keySet().iterator();
        while(itUsers.hasNext()){
            LoggedUser usr = this.loggedUsers.get((Integer)itUsers.next());
            if(usr.getUserName().equalsIgnoreCase(userName))
                return usr;
        }
        return null;
    }

    public String encrypt(String plainText){
        String encripted = "";
//
//        System.out.println("Pass normal: " + plainText);
        
        
        try
         {

            MD5 md = MD5.getInstance();
            encripted = md.hashData(plainText.getBytes());
         
            
        }
         catch(NoSuchAlgorithmException e)
         {
             e.printStackTrace(System.out);
         }
        
        return encripted;
        
//        try{
//
//
//
//            MessageDigest digest = java.security.MessageDigest.getInstance("MD5");
//
//            System.out.println("ESTOS SON LOS BYTES "+plainText.getBytes());
//
//
//            digest.update(plainText.getBytes());
//
//            byte[] hash = digest.digest();
//
//            System.out.println("Este es el arreglo de bytes... "+hash);

//            MessageDigest mDig = MessageDigest.getInstance("MD5");
//            mDig.update(plainText.getBytes(), 0, plainText.length());
//            encripted = bytesToHex(hash);
//            System.out.println("Encripted: " + encripted);
//        }
//        catch(Exception ex){
//            ex.printStackTrace();
//        }
//        return encripted;
    }

    public String bytesToHex(byte[] bytes) throws IOException{
        ByteArrayOutputStream bas = new ByteArrayOutputStream(bytes.length + bytes.length / 4 + 1);
        bas.write(bytes);
        return bas.toString();
    }

    public Usuario getUsuario(LoggedUser usr){
        if(this.isLogged(usr.getUid())){
            return new BeanBaseJHardmin().getUsuario(usr.getUid());
        }
        else
            return null;
    }
}
