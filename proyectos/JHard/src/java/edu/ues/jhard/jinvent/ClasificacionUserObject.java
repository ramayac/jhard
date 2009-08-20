/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.ues.jhard.jinvent;

import com.icesoft.faces.component.tree.IceUserObject;
import edu.ues.jhard.jpa.Clasificacion;
import javax.swing.tree.DefaultMutableTreeNode;

/**
 * UserObject que representa a una clasificacion asociada a un nodo en el treeModel
 * @author robertux
 */
public class ClasificacionUserObject extends IceUserObject {

    /**
     * Clasificacion a mostrar en el treeModel
     */
    private Clasificacion clasificacion;

    /**
     * Crea una nueva instancia de la clase ClasificacionUserObject asociada al treeNode recibido como parametro
     * @param treeNode treeNode al cual asociar este userObject
     */
    public ClasificacionUserObject(DefaultMutableTreeNode treeNode){
        super(treeNode);
        this.setLeafIcon("tree_document.gif");
        this.setBranchContractedIcon("tree_folder_closed.gif");
        this.setBranchExpandedIcon("tree_folder_open.gif");
        this.setExpanded(true);
    }

    /**
     * @return the clasificacion
     */
    public Clasificacion getClasificacion() {
        return clasificacion;
    }

    /**
     * @param clasificacion the clasificacion to set
     */
    public void setClasificacion(Clasificacion clasificacion) {
        this.clasificacion = clasificacion;
    }


}
