/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.ues.jhard.jinvent;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author robertux
 */
public class CrudManager {

    private boolean popupAddVisible;
    private boolean popupEditVisible;
    private boolean popupDelVisible;
    private String popupDelChoice;
    private String currentId;

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

    public String showPopupAdd(){
        this.setPopupAddVisible(true);
        return "done";
    }

    public String showPopupEdit(){
        this.setPopupEditVisible(true);
        this.setCurrentId(((HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest()).getParameter("currentId"));
        return "done";
    }

    public String showPopupDel(){
        this.setPopupDelVisible(true);
        this.setCurrentId(((HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest()).getParameter("currentId"));
        return "done";
    }

    public String hidePopupAdd(){
        this.setPopupAddVisible(false);
        return "done";
    }

    public String hidePopupEdit(){
        this.setPopupEditVisible(false);
        return "done";
    }

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
