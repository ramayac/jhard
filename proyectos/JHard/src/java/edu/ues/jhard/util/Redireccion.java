/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.ues.jhard.util;

import com.sun.jsfcl.app.AbstractPageBean;
import java.io.IOException;
import javax.faces.context.FacesContext;

/**
 *
 * @author Hugol
 */
public class Redireccion extends AbstractPageBean{

    private Navegacion n;

    public String index(){
        try {
            n = (Navegacion)getBean("Navegacion");
            n.setModuloActual("Index");
            FacesContext.getCurrentInstance().getExternalContext().redirect("Index.iface");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return "";
    }

    public String jrequestAdmin(){
        try {
            n= (Navegacion)getBean("Navegacion");
            n.setModuloActual("JRequest");
            FacesContext.getCurrentInstance().getExternalContext().redirect("jrequestAdmin.iface");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return "";
    }

    public String jrequestUser(){
        try {
            n= (Navegacion)getBean("Navegacion");
            n.setModuloActual("JRequest");
            FacesContext.getCurrentInstance().getExternalContext().redirect("jrequestUser.iface");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return "";
    }

    public String jrequestAdministracion(){
        try {
            n= (Navegacion)getBean("Navegacion");
            n.setModuloActual("JRequest");
            FacesContext.getCurrentInstance().getExternalContext().redirect("JRequestAdministracion.iface");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return "";
    }

    public String jrequestUserSolicitud(){
        try {
            n= (Navegacion)getBean("Navegacion");
            n.setModuloActual("JRequest");
            FacesContext.getCurrentInstance().getExternalContext().redirect("jrequestUserSolicitud.iface");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return "";
    }

    public String admin(){
        try {
            n= (Navegacion)getBean("Navegacion");
            n.setModuloActual("Index");
            FacesContext.getCurrentInstance().getExternalContext().redirect("Admin.jspx");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return "";
    }

    public String jinvent(){
        try {
            n = (Navegacion)getBean("Navegacion");
            n.setModuloActual("JInvent");
            FacesContext.getCurrentInstance().getExternalContext().redirect("jinvent.jspx");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return "";
    }

    public String jcanon(){
        try {
            n= (Navegacion)getBean("Navegacion");
            n.setModuloActual("JCanon");
            FacesContext.getCurrentInstance().getExternalContext().redirect("jcanon.iface");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return "";
    }

    public String jcanonAdmin(){
        try {
            n= (Navegacion)getBean("Navegacion");
            n.setModuloActual("JCanon");
            FacesContext.getCurrentInstance().getExternalContext().redirect("jcanonAdmin.iface");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return "";
    }

    public String jmlHorario(){
        try {
            n= (Navegacion)getBean("Navegacion");
            n.setModuloActual("ManLab");
            FacesContext.getCurrentInstance().getExternalContext().redirect("jmlHorario.iface");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return "";
    }

    public String jmlHorarioAdmin(){
        try {
            n= (Navegacion)getBean("Navegacion");
            n.setModuloActual("ManLab");
            FacesContext.getCurrentInstance().getExternalContext().redirect("jmlHorarioAdmin.iface");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return "";
    }

    public String jWikiUser(){
        try {
            n= (Navegacion)getBean("Navegacion");
            n.setModuloActual("JWiki");
            FacesContext.getCurrentInstance().getExternalContext().redirect("jwikiUser.iface");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return "";
    }

    public String jProCurUser(){
        try {
            n= (Navegacion)getBean("Navegacion");
            n.setModuloActual("JProCur");
            FacesContext.getCurrentInstance().getExternalContext().redirect("jprocurUser.iface");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return "";
    }

}
