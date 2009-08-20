/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.ues.jhard.jhardmin;

import edu.ues.jhard.jpa.Rol;
import java.util.Date;

/**
 * Representa a un usuario que ha iniciaod sesion en JHard
 * @author robertux
 */
public class LoggedUser {
    /**
     * ID del usuario logueado
     */
    private Integer uid;
    /**
     * Nombre del usuario logueado
     */
    private String userName;
    /**
     * URL del host donde se encuentra el usuario logueado
     */
    private String loggedUrl;
    /**
     * fecha/hora a la que el usuario inicio sesion
     */
    private Date loggedTime;
    /**
     * Rol del usuario logueado
     */
    private Rol userRole;

    /**
     * Crea una nueva instancia de la clase LoggedUser en base a los parametros introducidos
     * @param uid id del nuevo LoggedUser a crear
     * @param userName nombre del nuevo LoggedUser a crear
     * @param userRole rol del nuevo LoggedUser a crear
     * @param loggedUrl url origen del nuevo LoggedUser a crear
     */
    public LoggedUser(Integer uid, String userName, Rol userRole, String loggedUrl){
        this.uid = uid;
        this.userName = userName;
        this.userRole = userRole;
        this.loggedUrl = loggedUrl;
        this.loggedTime = new Date();
    }

    /**
     * @return the uid
     */
    public Integer getUid() {
        return uid;
    }

    /**
     * @param uid the uid to set
     */
    public void setUid(Integer uid) {
        this.uid = uid;
    }

    /**
     * @return the userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param userName the userName to set
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * @return the loggedUrl
     */
    public String getLoggedUrl() {
        return loggedUrl;
    }

    /**
     * @param loggedUrl the loggedUrl to set
     */
    public void setLoggedUrl(String loggedUrl) {
        this.loggedUrl = loggedUrl;
    }

    /**
     * @return the loggedTime
     */
    public Date getLoggedTime() {
        return loggedTime;
    }

    /**
     * @param loggedTime the loggedTime to set
     */
    public void setLoggedTime(Date loggedTime) {
        this.loggedTime = loggedTime;
    }

    /**
     * @return the userRole
     */
    public Rol getUserRole() {
        return userRole;
    }

    /**
     * @param userRole the userRole to set
     */
    public void setUserRole(Rol userRole) {
        this.userRole = userRole;
    }
}
