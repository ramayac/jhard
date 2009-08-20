/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.ues.jhard.jinvent;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

/**
 * Clase de utileria pasa manejar la visibilidad de los cuadros de dialogo del CRUD de una entity
 * @author robertux
 */
public class CrudManager {

    /**
     * Define la visibilidad de un popUp para agregar una entity
     */
    private boolean popupAddVisible;
    /**
     * Define la visibilidad de un popUp para editar una entity
     */
    private boolean popupEditVisible;
    /**
     * Define la visibilidad de un popUp para mostrar la confirmacion al eliminar una entity
     */
    private boolean popupDelVisible;
    /**
     * Representa la eleccion del usuario en la confirmacion de la eliminacion de una entity
     */
    private String popupDelChoice;
    /**
     * Representa el id actual de la entity que se esta editando o eliminando
     */
    private String currentId;

    /**
     * Crea una nueva instancia de la clase CrudManager inicializando sus miembros con valores por defecto
     */
    public CrudManager(){
        this.hidePopupAdd();
        this.hidePopupEdit();
        this.hidePopupDel();
    }

    /**
     * @return the popupAddVisible
     */
    public boolean getPopupAddVisible() {
        return popupAddVisible;
    }

    /**
     * @param popupAddVisible the popupAddVisible to set
     */
    public void setPopupAddVisible(boolean popupAddVisible) {
        this.popupAddVisible = popupAddVisible;
    }

    /**
     * @return the popupEditVisible
     */
    public boolean getPopupEditVisible() {
        return popupEditVisible;
    }

    /**
     * @param popupEditVisible the popupEditVisible to set
     */
    public void setPopupEditVisible(boolean popupEditVisible) {
        this.popupEditVisible = popupEditVisible;
    }

    /**
     * @return the popupDelVisible
     */
    public boolean getPopupDelVisible() {
        return popupDelVisible;
    }

    /**
     * @param popupDelVisible the popupDelVisible to set
     */
    public void setPopupDelVisible(boolean popupDelVisible) {
        this.popupDelVisible = popupDelVisible;
    }

    /**
     * @return the popupDelChoice
     */
    public String getPopupDelChoice() {
        return popupDelChoice;
    }

    /**
     * @param popupDelChoice the popupDelChoice to set
     */
    public void setPopupDelChoice(String popupDelChoice) {
        this.popupDelChoice = popupDelChoice;
    }

    /**
     * Cambia a true la variable que define la visibilidad del popUp para agregar una nueva entity
     * @return "done" si la accion fue exitosa
     */
    public String showPopupAdd(){
        this.setPopupAddVisible(true);
        return "done";
    }

    /**
     * Cambia a true la variable que define la visibilidad del popUp para editar la entity actual
     * @return "done" si la accion fue exitosa
     */
    public String showPopupEdit(){
        this.setPopupEditVisible(true);
        this.setCurrentId(((HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest()).getParameter("currentId"));
        return "done";
    }

    /**
     * Cambia a true la variable que define la visibilidad del popUp para confirmar la eliminacion de la entity actual
     * @return "done" si la accion fue exitosa
     */
    public String showPopupDel(){
        this.setPopupDelVisible(true);
        this.setCurrentId(((HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest()).getParameter("currentId"));
        return "done";
    }

    /**
     * Cambia a false la variable que define la visibilidad del popUp para agregar una nueva entity
     * @return "done" si la accion fue exitosa
     */
    public String hidePopupAdd(){
        this.setPopupAddVisible(false);
        return "done";
    }

    /**
     * Cambia a false la variable que define la visibilidad del popUp para agregar editar la entity actual
     * @return "done" si la accion fue exitosa
     */
    public String hidePopupEdit(){
        this.setPopupEditVisible(false);
        return "done";
    }

    /**
     * Cambia a true la variable que define la visibilidad del popUp para agregar una nueva entity
     * @return "done" si la accion fue exitosa
     */
    public String hidePopupDel(){
        this.setPopupDelVisible(false);
        return "done";
    }

    /**
     * @return the currentId
     */
    public String getCurrentId() {
        return currentId;
    }

    /**
     * @param currentId the currentId to set
     */
    public void setCurrentId(String currentId) {
        this.currentId = currentId;
    }
}
