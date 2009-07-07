/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.ues.jhard.beans;

import edu.ues.jhard.jinvent.ClasificacionTreeModel;
import edu.ues.jhard.jinvent.ClasificacionUserObject;
import edu.ues.jhard.jpa.Accesorio;
import edu.ues.jhard.jpa.Clasificacion;
import edu.ues.jhard.jpa.Equipo;
import edu.ues.jhard.jpa.Pieza;
import edu.ues.jhard.jpa.Software;
import java.util.ArrayList;
import java.util.List;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.http.HttpServletRequest;
import javax.swing.tree.DefaultMutableTreeNode;

/**
 *
 * @author robertux
 */
public class BeanBaseJInvent extends BeanBase {

    private ClasificacionTreeModel clasificaciontm;

    public BeanBaseJInvent(){
        this.clasificaciontm = new ClasificacionTreeModel(this.getEntityManager());
    }

    /**
     * @return the clasificaciontm
     */
    public ClasificacionTreeModel getClasificaciontm() {
        return clasificaciontm;
    }

    /**
     * @param clasificaciontm the clasificaciontm to set
     */
    public void setClasificaciontm(ClasificacionTreeModel clasificaciontm) {
        this.clasificaciontm = clasificaciontm;
    }

    public void clasificacionSelected(ActionEvent event){
        String idClasificacion = ((HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest()).getParameter("clId");
        DefaultMutableTreeNode nodo = this.clasificaciontm.seleccionarNodo(idClasificacion);
        /*if(((ClasificacionUserObject)nodo.getUserObject()).isExpanded())
            ((ClasificacionUserObject)nodo.getUserObject()).setExpanded(false);
        else
            ((ClasificacionUserObject)nodo.getUserObject()).setExpanded(true);*/

    }

    public Clasificacion getCurrentClasificacion(){
        return this.clasificaciontm.getCurrentUserObject().getClasificacion();
    }
}
