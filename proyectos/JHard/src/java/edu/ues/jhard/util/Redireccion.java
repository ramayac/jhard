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
 * Clase para realizar redirecciones hacia todas las páginas disponibles en JHard
 * Cada página disponible de JHard tiene un método, que se nombre idénticamente a la página hacia la que
 * redirecciona
 *
 * Cada método también posiciona el bean de Navegacion en su respectivo módulo
 *
 * @author Hugol
 */
public class Redireccion extends AbstractPageBean{

    private static final String EMPTY_STRING = "";
    private static final String BEAN_NAME = "Navegacion";
    private Navegacion n;

    /**
     * Método para redireccionar hacia Index.iface
     * @return
     */
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

    /**
     * Método para redireccionar hacia jrequestAdmin.iface
     * @return
     */
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

    /**
     * Método para redireccionar hacia jrequestUser.iface
     * @return
     */
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

    /**
     * Método para redireccionar hacia JRequestAdministracion.iface
     * @return
     */
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

    /**
     * Método para redireccionar hacia jrequestUserSolicitud.iface
     * @return
     */
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

    /**
     * Método para redireccionar hacia Admin.jspx
     * @return
     */
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

    /**
     * Método para redireccionar hacia jinvent.jspx
     * @return
     */
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

    /**
     * Método para redireccionar hacia jcanon.iface
     * @return
     */
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

    /**
     * Método para redireccionar hacia jcanonAdmin.iface
     * @return
     */
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

    /**
     * Método para redireccionar hacia jmlLaboratorio.iface
     * @return
     */
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

    /**
     * Método para redireccionar hacia jmlGestionaClase.iface
     * @return
     */
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

    /**
     * Método para redireccionar hacia jmlAsistencia.iface
     * @return
     */
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

    /**
     * Método para redireccionar hacia jmlInscripcion.iface
     * @return
     */
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

    /**
     * Método para redireccionar hacia jmlHorario.iface
     * @return
     */
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

    /**
     * Método para redireccionar hacia jmlHorarioAdmin.iface
     * @return
     */
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

    /**
     * Método para redireccionar hacia jwikiUser.iface
     * @return
     */
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

    /**
     * Método para redireccionar hacia jwikiAdmin.iface
     * @return
     */
    public String jWikiAdmin(){
        try {
            n= (Navegacion)getBean(BEAN_NAME);
            n.setModuloActual("JWiki");
            FacesContext.getCurrentInstance().getExternalContext().redirect("jwikiAdmin.iface");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return EMPTY_STRING;
    }

    /**
     * Método para redireccionar hacia un artículo determinado de la WIki, según el ID de artículo enviado desde la JSP
     * @return
     */
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

    /**
     * Método para redireccionar hacia jprocurUser.iface
     * @return
     */
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

    /**
     * Método para redireccionar hacia jprocurAdmin.iface
     * @return
     */
    public String jProCurAdmin(){
        try {
            n= (Navegacion)getBean(BEAN_NAME);
            n.setModuloActual("JProCur");
            FacesContext.getCurrentInstance().getExternalContext().redirect("jprocurAdmin.iface");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return EMPTY_STRING;
    }

    /**
     * Método para redireccionar hacia reportes.iface
     * @return
     */
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
