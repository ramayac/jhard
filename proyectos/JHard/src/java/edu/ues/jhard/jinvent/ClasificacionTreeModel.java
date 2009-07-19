/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.ues.jhard.jinvent;

import edu.ues.jhard.jpa.Clasificacion;
import edu.ues.jhard.jpa.Equipo;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
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
        Clasificacion cl = (Clasificacion)this.em.createQuery("SELECT c FROM Clasificacion c WHERE c.idsuperior IS NULL").getSingleResult();
        DefaultMutableTreeNode nodo = this.agregarNodo(null, cl);
        this.modelo = new DefaultTreeModel(nodo);
        this.currentUserObject = (ClasificacionUserObject)nodo.getUserObject();
        this.generarNodosHijos(nodo);
    }

    public DefaultMutableTreeNode agregarNodo(DefaultMutableTreeNode nodoPadre, Clasificacion cl){
        DefaultMutableTreeNode nodo = new DefaultMutableTreeNode();
        ClasificacionUserObject clUsrObj = new ClasificacionUserObject(nodo);
        nodo.setUserObject(clUsrObj);
        clUsrObj.setClasificacion(cl);
        int totalExistencias = 0;
        Iterator it = cl.getEquipoCollection().iterator();
        while(it.hasNext()){
            Equipo eq = (Equipo)it.next();
            totalExistencias += eq.getExistenciaSize();
        }
        clUsrObj.setText(cl.getNombre() + " (" + (totalExistencias + cl.getSoftwareCollection().size() + cl.getAccesorioCollection().size() + cl.getPiezaCollection().size()) + ")");
        clUsrObj.setLeaf(false);
        clUsrObj.setExpanded(true);
        if(nodoPadre != null)
            nodoPadre.add(nodo);
        return nodo;
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

    public void generarNodosHijos(DefaultMutableTreeNode nodo){
        Clasificacion cl = ((ClasificacionUserObject)nodo.getUserObject()).getClasificacion();
        try{
            List<Clasificacion> hijas = (List<Clasificacion>)this.em.createQuery("SELECT c FROM Clasificacion c WHERE c.idsuperior = " + cl.getIdclasificacion().toString()).getResultList();
            for(Clasificacion hija: hijas){
                DefaultMutableTreeNode nodoHijo = this.agregarNodo(nodo, hija);
                generarNodosHijos(nodoHijo);                
            }            
        }
        catch(Exception ex){
            //pass
        }
    }

    public DefaultMutableTreeNode seleccionarNodo(String idClasificacion){
        DefaultMutableTreeNode nodoRaiz = (DefaultMutableTreeNode)this.modelo.getRoot();
        Enumeration nodos = nodoRaiz.depthFirstEnumeration();
        while(nodos.hasMoreElements()){
            DefaultMutableTreeNode nodo = (DefaultMutableTreeNode)nodos.nextElement();
            Clasificacion cl = ((ClasificacionUserObject)nodo.getUserObject()).getClasificacion();
            if(cl.getIdclasificacion().toString().equalsIgnoreCase(idClasificacion)){
                this.setCurrentUserObject((ClasificacionUserObject)nodo.getUserObject());
                return nodo;
            }
        }
        return null;
    }
}
