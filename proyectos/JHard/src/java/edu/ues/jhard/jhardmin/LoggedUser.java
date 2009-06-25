/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.ues.jhard.jhardmin;

import edu.ues.jhard.jpa.Rol;
import java.util.Date;

/**
 *
 * @author robertux
 */
public class LoggedUser {
    private Integer uid;
    private String userName;
    private String loggedUrl;
    private Date loggedTime;
    private Rol userRole;

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
