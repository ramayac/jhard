/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.ues.jhard.jinvent;

import javax.persistence.EntityManager;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

/**
 *
 * @author robertux
 */
public class ClasificacionTreeModel {

    private DefaultTreeModel modelo;
    private EntityManager em;
    private ClasificacionUserObject currentUserObject;

    public ClasificacionTreeModel(EntityManager emgr){
        this.em = emgr;
        this.generarNodosModelo();
    }

    /**
     * @return the modelo
     */
    public DefaultTreeModel getModelo() {
        return modelo;
    }

    /**
     * @param modelo the modelo to set
     */
    public void setModelo(DefaultTreeModel modelo) {
        this.modelo = modelo;
    }

    public void generarNodosModelo(){
        //DefaultMutableTreeNode nodoRaiz = new DefaultMutableTreeNode(currentUserObject);
    }

    /**
     * @return the currentUserObject
     */
    public ClasificacionUserObject getCurrentUserObject() {
        return currentUserObject;
    }

    /**
     * @param currentUserObject the currentUserObject to set
     */
    public void setCurrentUserObject(ClasificacionUserObject currentUserObject) {
        this.currentUserObject = currentUserObject;
    }


}
