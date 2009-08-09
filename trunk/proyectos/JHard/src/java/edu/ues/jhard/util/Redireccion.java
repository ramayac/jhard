/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.ues.jhard.util;

import com.sun.jsfcl.app.AbstractPageBean;
import java.io.IOException;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Hugol
 */
public class Redireccion extends AbstractPageBean{

    private static final String EMPTY_STRING = "";
    private static final String BEAN_NAME = "Navegacion";
    private Navegacion n;

    public String index(){
        try {
            n = (Navegacion)getBean(BEAN_NAME);
            n.setModuloActual("Index");
            FacesContext.getCurrentInstance().getExternalContext().redirect("Index.iface");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return EMPTY_STRING;
    }

    public String jrequestAdmin(){
        try {
            n= (Navegacion)getBean(BEAN_NAME);
            n.setModuloActual("JRequest");
            FacesContext.getCurrentInstance().getExternalContext().redirect("jrequestAdmin.iface");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return EMPTY_STRING;
    }

    public String jrequestUser(){
        try {
            n= (Navegacion)getBean(BEAN_NAME);
            n.setModuloActual("JRequest");
            FacesContext.getCurrentInstance().getExternalContext().redirect("jrequestUser.iface");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return EMPTY_STRING;
    }

    public String jrequestAdministracion(){
        try {
            n= (Navegacion)getBean(BEAN_NAME);
            n.setModuloActual("JRequest");
            FacesContext.getCurrentInstance().getExternalContext().redirect("JRequestAdministracion.iface");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return EMPTY_STRING;
    }

    public String jrequestUserSolicitud(){
        try {
            n= (Navegacion)getBean(BEAN_NAME);
            n.setModuloActual("JRequest");
            FacesContext.getCurrentInstance().getExternalContext().redirect("jrequestUserSolicitud.iface");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return EMPTY_STRING;
    }

    public String admin(){
        try {
            n= (Navegacion)getBean(BEAN_NAME);
            n.setModuloActual("Index");
            FacesContext.getCurrentInstance().getExternalContext().redirect("Admin.jspx");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return EMPTY_STRING;
    }

    public String jinvent(){
        try {
            n = (Navegacion)getBean(BEAN_NAME);
            n.setModuloActual("JInvent");
            FacesContext.getCurrentInstance().getExternalContext().redirect("jinvent.jspx");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return EMPTY_STRING;
    }

    public String jcanon(){
        try {
            n= (Navegacion)getBean(BEAN_NAME);
            n.setModuloActual("JCanon");
            FacesContext.getCurrentInstance().getExternalContext().redirect("jcanon.iface");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return EMPTY_STRING;
    }

    public String jcanonAdmin(){
        try {
            n= (Navegacion)getBean(BEAN_NAME);
            n.setModuloActual("JCanon");
            FacesContext.getCurrentInstance().getExternalContext().redirect("jcanonAdmin.iface");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return EMPTY_STRING;
    }

    public String jmlLaboratorio(){
        try {
            n= (Navegacion)getBean(BEAN_NAME);
            n.setModuloActual("ManLab");
            FacesContext.getCurrentInstance().getExternalContext().redirect("jmlLaboratorio.iface");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return EMPTY_STRING;
    }

    public String jmlGestionaClase(){
        try {
            n= (Navegacion)getBean(BEAN_NAME);
            n.setModuloActual("ManLab");
            FacesContext.getCurrentInstance().getExternalContext().redirect("jmlGestionaClase.iface");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return EMPTY_STRING;
    }

    public String jmlAsistencia(){
        try {
            n= (Navegacion)getBean(BEAN_NAME);
            n.setModuloActual("ManLab");
            FacesContext.getCurrentInstance().getExternalContext().redirect("jmlAsistencia.iface");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return EMPTY_STRING;
    }

    public String jmlInscripcion(){
        try {
            n= (Navegacion)getBean(BEAN_NAME);
            n.setModuloActual("ManLab");
            FacesContext.getCurrentInstance().getExternalContext().redirect("jmlInscripcion.iface");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return EMPTY_STRING;
    }

    public String jmlHorario(){
        try {
            n= (Navegacion)getBean(BEAN_NAME);
            n.setModuloActual("ManLab");
            FacesContext.getCurrentInstance().getExternalContext().redirect("jmlHorario.iface");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return EMPTY_STRING;
    }

    public String jmlHorarioAdmin(){
        try {
            n= (Navegacion)getBean(BEAN_NAME);
            n.setModuloActual("ManLab");
            FacesContext.getCurrentInstance().getExternalContext().redirect("jmlHorarioAdmin.iface");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return EMPTY_STRING;
    }

    public String jWikiUser(){
        try {
            n= (Navegacion)getBean(BEAN_NAME);
            n.setModuloActual("JWiki");
            FacesContext.getCurrentInstance().getExternalContext().redirect("jwikiUser.iface");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return EMPTY_STRING;
    }

    public String jWikiUserParam(){
        try {
            n= (Navegacion)getBean(BEAN_NAME);
            n.setModuloActual("JWiki");
            String wikiId = ((HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest()).getParameter("wikiId");
            FacesContext.getCurrentInstance().getExternalContext().redirect("jwikiUser.iface?wkid=" + wikiId);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return EMPTY_STRING;
    }

    public String jProCurUser(){
        try {
            n= (Navegacion)getBean(BEAN_NAME);
            n.setModuloActual("JProCur");
            FacesContext.getCurrentInstance().getExternalContext().redirect("jprocurUser.iface");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return EMPTY_STRING;
    }

    public String reportes(){
        try {
            n= (Navegacion)getBean(BEAN_NAME);
            n.setModuloActual("Index");
            FacesContext.getCurrentInstance().getExternalContext().redirect("reportes.iface");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return EMPTY_STRING;
    }

}
