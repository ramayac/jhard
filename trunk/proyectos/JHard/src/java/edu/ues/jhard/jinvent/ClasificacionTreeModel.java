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
 * Modelo jerarquico de arbol para mostrar la jerarquia de clasificaciones de los elementos del inventario
 * @author robertux
 */
public class ClasificacionTreeModel {

    /**
     * Modelo base de las clasificaiones
     */
    private DefaultTreeModel modelo;
    /**
     * EntityManager para manejar la persistencia
     */
    private EntityManager em;
    /**
     * UserObject como representaciones de los nodos del treeModel, que al mismo tiempo se asocian con una clasificacion
     */
    private ClasificacionUserObject currentUserObject;

    /**
     * Crea una nueva instancia de la clase ClasificacionTreeModel en base al parametro introducido
     * @param emgr EntityManager para manejar la persistencia
     */
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

    /**
     * Genera la jerarquia inical de los nodos del modelo en base a las clasificaciones existentes en la base de datos
     */
    public void generarNodosModelo(){
        Clasificacion cl = (Clasificacion)this.em.createQuery("SELECT c FROM Clasificacion c WHERE c.idsuperior IS NULL").getSingleResult();
        DefaultMutableTreeNode nodo = this.agregarNodo(null, cl);
        this.modelo = new DefaultTreeModel(nodo);
        this.currentUserObject = (ClasificacionUserObject)nodo.getUserObject();
        this.generarNodosHijos(nodo);
        this.generarNodoBusqueda(nodo);
    }

    /**
     * Agrega un nuevo nodo al modelo actual, debajo del nodoPadre y asociado a la clasificacion cl
     * @param nodoPadre nodo del cual dependera, en caso de ser null, se agrega como nodo raiz
     * @param cl clasificacion a la cual estara asociado este nuevo nodo del modelo
     * @return el nuevo nodo agregado al modelo
     */
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

    /**
     * Genera los nodos hijos, en base a las clasificaciones dependientes de la clasificacion asociada al nodo recibido como parametro
     * @param nodo nodo que contiene la clasificacion de la cual se tomaran las hijas para generar nuevos nodos
     */
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

    /**
     * Asigna como nodo actual al nodo asociado con la clasificacion cuyo id es recibido como parametro
     * @param idClasificacion id de la clasificacion asociada al nodo que se convertira en el nodo actual
     * @return el nodo actual
     */
    public DefaultMutableTreeNode seleccionarNodo(String idClasificacion){
        DefaultMutableTreeNode nodo = this.buscarNodo(idClasificacion);
        if(nodo != null)
            this.setCurrentUserObject((ClasificacionUserObject)nodo.getUserObject());
        return nodo;        
    }

    /**
     * Busca dentro del modelo el nodo cuya clasificacion asociada posee el id recibido como parametro
     * @param idClasificacion id de la clasificacion cuyo nodo asociado se desea encontrar
     * @return el nodo encontrado o null en caso de no haberlo encontrado
     */
    public DefaultMutableTreeNode buscarNodo(String idClasificacion){
        DefaultMutableTreeNode nodoRaiz = (DefaultMutableTreeNode)this.modelo.getRoot();
        Enumeration nodos = nodoRaiz.depthFirstEnumeration();
        while(nodos.hasMoreElements()){
            DefaultMutableTreeNode nodo = (DefaultMutableTreeNode)nodos.nextElement();
            Clasificacion cl = ((ClasificacionUserObject)nodo.getUserObject()).getClasificacion();
            if(cl.getIdclasificacion().toString().equalsIgnoreCase(idClasificacion)){
                return nodo;
            }
        }
        return null;
    }

    /**
     * Actualiza la clasificacion asociada a un nodo del modelo
     * @param nuevaCl nueva clasificacion a asociar
     */
    public void actualizarNodo(Clasificacion nuevaCl){
        DefaultMutableTreeNode nodo = this.buscarNodo(nuevaCl.getIdclasificacion().toString());
        ClasificacionUserObject clUsrObj = new ClasificacionUserObject(nodo);
        nodo.setUserObject(clUsrObj);
        clUsrObj.setClasificacion(nuevaCl);
        int totalExistencias = 0;
        Iterator it = nuevaCl.getEquipoCollection().iterator();
        while(it.hasNext()){
            Equipo eq = (Equipo)it.next();
            totalExistencias += eq.getExistenciaSize();
        }
        clUsrObj.setText(nuevaCl.getNombre() + " (" + (totalExistencias + nuevaCl.getSoftwareCollection().size() + nuevaCl.getAccesorioCollection().size() + nuevaCl.getPiezaCollection().size()) + ")");
    }

    /**
     * Genera un nodo en el modelo que no representa ninguna clasificacion de la jerarquia sino que nada mas sirve para activar el modo de busqueda de existencias
     * @param nodoPadre nodo que sera el padre del nodo de busqueda
     */
    private void generarNodoBusqueda(DefaultMutableTreeNode nodoPadre) {
        DefaultMutableTreeNode nodo = new DefaultMutableTreeNode();
        ClasificacionUserObject clUsrObj = new ClasificacionUserObject(nodo);
        Clasificacion cl = new Clasificacion();
        cl.setIdclasificacion(-1);
        cl.setNombre("Búsquedas");
        cl.setDescripcion("Búsquedas");
        nodo.setUserObject(clUsrObj);
        clUsrObj.setClasificacion(cl);
        int totalExistencias = 0;

        clUsrObj.setText("Búsquedas");
        clUsrObj.setLeaf(false);
        clUsrObj.setExpanded(true);
        clUsrObj.setLeafIcon("imgBusqueda.png");
        clUsrObj.setBranchContractedIcon("imgBusqueda.png");
        clUsrObj.setBranchExpandedIcon("imgBusqueda.png");
        if(nodoPadre != null)
            nodoPadre.add(nodo);
    }
}
