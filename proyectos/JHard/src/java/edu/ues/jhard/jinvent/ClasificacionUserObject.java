/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.ues.jhard.jinvent;

import com.icesoft.faces.component.tree.IceUserObject;
import edu.ues.jhard.jpa.Clasificacion;
import javax.swing.tree.DefaultMutableTreeNode;

/**
 *
 * @author robertux
 */
public class ClasificacionUserObject extends IceUserObject {

    private Clasificacion clasificacion;

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
