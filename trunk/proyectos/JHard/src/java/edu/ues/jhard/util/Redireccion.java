/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.ues.jhard.util;

import java.io.IOException;
import javax.faces.context.FacesContext;

/**
 *
 * @author Hugol
 */
public class Redireccion {

    public String jrequestAdmin(){
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("jrequestAdmin.iface");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return "";
    }

    public String jrequestAdministracion(){
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("JRequestAdministracion.iface");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return "";
    }

    public String jrequestUserSolicitud(){
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("jrequestUserSolicitud.iface");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return "";
    }

    public String admin(){
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("Admin.jspx");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return "";
    }

    public String jinvent(){
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("jinvent.jspx");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return "";
    }

    public String jcanonAdmin(){
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("jcanonAdmin.iface");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return "";
    }
}
