/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.ues.jhard.beans;

import com.icesoft.faces.component.tree.TreeNode;
import edu.ues.jhard.jinvent.ClasificacionTreeModel;
import edu.ues.jhard.jinvent.ClasificacionUserObject;
import edu.ues.jhard.jinvent.CrudManager;
import edu.ues.jhard.jpa.Accesorio;
import edu.ues.jhard.jpa.Clasificacion;
import edu.ues.jhard.jpa.Equipo;
import edu.ues.jhard.jpa.Marca;
import edu.ues.jhard.jpa.Pieza;
import edu.ues.jhard.jpa.Software;
import edu.ues.jhard.util.ActionMessage;
import java.util.ArrayList;
import java.util.List;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;
import javax.faces.model.SelectItemGroup;
import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;
import javax.swing.tree.DefaultMutableTreeNode;

/**
 *
 * @author robertux
 */
public class BeanBaseJInvent extends BeanBase {

    private ClasificacionTreeModel clasificaciontm;
    private Equipo currentEquipo;
    private Software currentSoftware;
    private Accesorio currentAccesorio;
    private Clasificacion nuevaClasificacion;
    private Pieza currentPieza;
    private CrudManager crdEquipo;
    private CrudManager crdSoftware;
    private CrudManager crdPieza;
    private CrudManager crdAccesorio;
    private CrudManager crdClasificacion;
    private List<Marca> listaMarcas;
    private SelectItemGroup listaItemsMarcas;
    private String marcaSelected;
    private ActionMessage msg;

    public BeanBaseJInvent(){
        this.clasificaciontm = new ClasificacionTreeModel(this.getEntityManager());
        this.currentEquipo = new Equipo();
        this.currentSoftware = new Software();
        this.currentAccesorio = new Accesorio();
        this.currentPieza = new Pieza();
        this.nuevaClasificacion = new Clasificacion();
        this.crdEquipo = new CrudManager();
        this.crdSoftware = new CrudManager();
        this.crdAccesorio = new CrudManager();
        this.crdPieza = new CrudManager();
        this.crdClasificacion = new CrudManager();
        this.msg = new ActionMessage();
        this.listaMarcas = this.getEntityManager().createNamedQuery("Marca.findAll").getResultList();
        this.initItemsMarcas();
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
        DefaultMutableTreeNode nodo = this.getClasificaciontm().seleccionarNodo(idClasificacion);
        /*if(((ClasificacionUserObject)nodo.getUserObject()).isExpanded())
            ((ClasificacionUserObject)nodo.getUserObject()).setExpanded(false);
        else
            ((ClasificacionUserObject)nodo.getUserObject()).setExpanded(true);*/

    }

    public Clasificacion getCurrentClasificacion(){
        return this.getClasificaciontm().getCurrentUserObject().getClasificacion();
    }

    public int getCurrentClasificacionEquipoCollectionSize(){
        return this.getCurrentClasificacion().getEquipoCollection().size();
    }

    public int getCurrentClasificacionSoftwareCollectionSize(){
        return this.getCurrentClasificacion().getSoftwareCollection().size();
    }

    public int getCurrentClasificacionAccesorioCollectionSize(){
        return this.getCurrentClasificacion().getAccesorioCollection().size();
    }

    public int getCurrentClasificacionPiezaCollectionSize(){
        return this.getCurrentClasificacion().getPiezaCollection().size();
    }

    public int getSizeListaEquipos(){
        return this.getCurrentClasificacion().getEquipoCollection().size();
    }

    public int getSizeListaSoftware(){
        return this.getCurrentClasificacion().getSoftwareCollection().size();
    }

    public int getSizeListaAccesorios(){
        return this.getCurrentClasificacion().getAccesorioCollection().size();
    }

    public int getSizeListaPiezas(){
        return this.getCurrentClasificacion().getPiezaCollection().size();
    }

    /**
     * @return the currentEquipo
     */
    public Equipo getCurrentEquipo() {
        return currentEquipo;
    }

    /**
     * @param currentEquipo the currentEquipo to set
     */
    public void setCurrentEquipo(Equipo currentEquipo) {
        this.currentEquipo = currentEquipo;
    }

    /**
     * @return the currentSoftware
     */
    public Software getCurrentSoftware() {
        return currentSoftware;
    }

    /**
     * @param currentSoftware the currentSoftware to set
     */
    public void setCurrentSoftware(Software currentSoftware) {
        this.currentSoftware = currentSoftware;
    }

    /**
     * @return the currentAccesorio
     */
    public Accesorio getCurrentAccesorio() {
        return currentAccesorio;
    }

    /**
     * @param currentAccesorio the currentAccesorio to set
     */
    public void setCurrentAccesorio(Accesorio currentAccesorio) {
        this.currentAccesorio = currentAccesorio;
    }

    /**
     * @return the currentPieza
     */
    public Pieza getCurrentPieza() {
        return currentPieza;
    }

    /**
     * @param currentPieza the currentPieza to set
     */
    public void setCurrentPieza(Pieza currentPieza) {
        this.currentPieza = currentPieza;
    }

    /**
     * @return the crdEquipo
     */
    public CrudManager getCrdEquipo() {
        return crdEquipo;
    }

    /**
     * @param crdEquipo the crdEquipo to set
     */
    public void setCrdEquipo(CrudManager crdEquipo) {
        this.crdEquipo = crdEquipo;
    }

    /**
     * @return the crdSoftware
     */
    public CrudManager getCrdSoftware() {
        return crdSoftware;
    }

    /**
     * @param crdSoftware the crdSoftware to set
     */
    public void setCrdSoftware(CrudManager crdSoftware) {
        this.crdSoftware = crdSoftware;
    }

    /**
     * @return the crdPieza
     */
    public CrudManager getCrdPieza() {
        return crdPieza;
    }

    /**
     * @param crdPieza the crdPieza to set
     */
    public void setCrdPieza(CrudManager crdPieza) {
        this.crdPieza = crdPieza;
    }

    /**
     * @return the crdAccesorio
     */
    public CrudManager getCrdAccesorio() {
        return crdAccesorio;
    }

    /**
     * @param crdAccesorio the crdAccesorio to set
     */
    public void setCrdAccesorio(CrudManager crdAccesorio) {
        this.crdAccesorio = crdAccesorio;
    }

    private void initItemsMarcas() {
        this.setListaItemsMarcas(new SelectItemGroup());
       SelectItem[] items = new SelectItem[this.listaMarcas.size()];
       for(int i=0; i<this.listaMarcas.size(); i++){
           items[i] = new SelectItem(this.listaMarcas.get(i).getIdmarca(), this.listaMarcas.get(i).getNombre());
       }
        this.getListaItemsMarcas().setSelectItems(items);
    }

    /**
     * @return the listaItemsMarcas
     */
    public SelectItemGroup getListaItemsMarcas() {
        return listaItemsMarcas;
    }

    /**
     * @param listaItemsMarcas the listaItemsMarcas to set
     */
    public void setListaItemsMarcas(SelectItemGroup listaItemsMarcas) {
        this.listaItemsMarcas = listaItemsMarcas;
    }

    /**
     * @return the marcaSelected
     */
    public String getMarcaSelected() {
        return marcaSelected;
    }

    /**
     * @param marcaSelected the marcaSelected to set
     */
    public void setMarcaSelected(String marcaSelected) {
        this.marcaSelected = marcaSelected;
    }

    public String addEquipo(){
        for(Marca m: this.listaMarcas){            
            if(m.getIdmarca().toString().equalsIgnoreCase(this.getMarcaSelected())){                
                this.currentEquipo.setIdmarca(m);
                this.currentEquipo.setIdclasificacion(this.getCurrentClasificacion());
                this.getCurrentClasificacion().getEquipoCollection().add(this.currentEquipo);
                EntityManager emgr = this.getEntityManager();
                emgr.getTransaction().begin();
                emgr.persist(this.currentEquipo);
                emgr.getTransaction().commit();
                this.msg.setText("Nuevo equipo " + this.currentEquipo.getNombre() + " agregado exitosamente.");
                this.msg.setVisible(true);
                this.currentEquipo = new Equipo();
                this.actualizarNodoClasificacion();
                break;
            }
        }
        this.crdEquipo.hidePopupAdd();
        return "done";
    }

    public String cancelAddEditEquipo(){
        this.currentEquipo = new Equipo();
        this.crdEquipo.hidePopupAdd();
        this.crdEquipo.hidePopupEdit();
        return "done";
    }

    public String editEquipo(){
        String idEquipo = ((HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest()).getParameter("currentId");
        this.crdEquipo.setCurrentId(idEquipo);
        EntityManager emgr = this.getEntityManager();
        this.currentEquipo = (Equipo)emgr.createQuery("SELECT e FROM Equipo e WHERE e.idequipo=" + idEquipo).getSingleResult();
        this.crdEquipo.showPopupEdit();
        return "done";
    }

    public String commitEditEquipo(){
        EntityManager emgr = this.getEntityManager();
        Marca mrk = (Marca)emgr.createQuery("SELECT m FROM Marca m WHERE m.idmarca=" + this.marcaSelected).getSingleResult();
        this.currentEquipo.setIdmarca(mrk);
        emgr.getTransaction().begin();
        emgr.merge(this.currentEquipo);
        emgr.getTransaction().commit();
        this.crdEquipo.hidePopupEdit();
        for(Equipo eq: this.getCurrentClasificacion().getEquipoCollection()){            
            if(eq.getIdequipo() == this.currentEquipo.getIdequipo()){                
                eq.setNombre(this.currentEquipo.getNombre());
                eq.setIdmarca(mrk);
                eq.setModelo(this.currentEquipo.getModelo());
                break;
            }
        }
        this.msg.setText("Equipo modificado satisfactoriamente");
        this.msg.setVisible(true);
        this.currentEquipo = new Equipo();
        return "done";
    }

    public String delEquipo(){                
        String idEquipo = this.crdEquipo.getCurrentId();
        EntityManager emgr = this.getEntityManager();
        Equipo eq = (Equipo)emgr.createQuery("SELECT e FROM Equipo e WHERE e.idequipo=" + idEquipo).getSingleResult();
        emgr.getTransaction().begin();
        emgr.remove(eq);
        emgr.getTransaction().commit();
        this.crdEquipo.hidePopupDel();
        this.getCurrentClasificacion().getEquipoCollection().remove(eq);
        this.msg.setText("Equipo " + eq.getNombre() + " eliminado satisfactoriamente.");
        this.msg.setVisible(true);
        this.actualizarNodoClasificacion();
        return "done";
    }

    public String addSoftware(){
        this.currentSoftware.setIdclasificacion(this.getCurrentClasificacion());
        this.getCurrentClasificacion().getSoftwareCollection().add(this.currentSoftware);
        EntityManager emgr = this.getEntityManager();
        emgr.getTransaction().begin();
        emgr.persist(this.currentSoftware);
        emgr.getTransaction().commit();
        this.crdSoftware.hidePopupAdd();
        this.msg.setText("Nuevo software " + this.currentSoftware.getNombre() + " agregado exitosamente");
        this.msg.setVisible(true);
        this.currentSoftware = new Software();
        this.actualizarNodoClasificacion();
        return "done";
    }

    public String cancelAddEditSoftware(){
        this.currentSoftware = new Software();
        this.crdSoftware.hidePopupAdd();
        this.crdSoftware.hidePopupEdit();
        return "done";
    }

    public String editSoftware(){
        String idSoftware = ((HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest()).getParameter("currentId");        
        Software soft = (Software)this.getEntityManager().createQuery("SELECT s FROM Software s WHERE s.idsoftware=" + idSoftware).getSingleResult();
        this.currentSoftware = soft;
        this.crdSoftware.setCurrentId(idSoftware);
        this.crdSoftware.showPopupEdit();
        return "done";
    }

    public String commitEditSoftware(){
        EntityManager emgr = this.getEntityManager();
        emgr.getTransaction().begin();
        emgr.merge(this.currentSoftware);
        emgr.getTransaction().commit();
        this.crdSoftware.hidePopupEdit();
        for(Software soft: this.getCurrentClasificacion().getSoftwareCollection()){
            if(soft.getIdsoftware() == this.currentSoftware.getIdsoftware()){
                soft.setNombre(this.currentSoftware.getNombre());
                soft.setVersion(this.currentSoftware.getVersion());
                soft.setCodigolicencia(this.currentSoftware.getCodigolicencia());
                soft.setCantidadlicencias(this.currentSoftware.getCantidadlicencias());
                break;
            }
        }
        this.msg.setText("Software modificado satisfactoriamente");
        this.msg.setVisible(true);
        this.currentSoftware = new Software();
        return "done";
    }

    public String delSoftware(){
        String idSoftware = this.crdSoftware.getCurrentId();
        EntityManager emgr = this.getEntityManager();
        Software soft = (Software)emgr.createQuery("SELECT s FROM Software s WHERE s.idsoftware=" + idSoftware).getSingleResult();
        emgr.getTransaction().begin();
        emgr.remove(soft);
        emgr.getTransaction().commit();
        this.crdSoftware.hidePopupDel();
        this.getCurrentClasificacion().getSoftwareCollection().remove(soft);
        this.msg.setText("Software " + soft.getNombre() + " eliminado satisfactoriamente.");
        this.msg.setVisible(true);
        this.actualizarNodoClasificacion();
        return "done";
    }

    public String addAccesorio(){
        for(Marca m: this.listaMarcas){
            if(m.getIdmarca().toString().equalsIgnoreCase(this.marcaSelected)){
                this.currentAccesorio.setIdmarca(m);
                this.currentAccesorio.setIdclasificacion(this.getCurrentClasificacion());
                this.getCurrentClasificacion().getAccesorioCollection().add(this.currentAccesorio);
                EntityManager emgr = this.getEntityManager();
                emgr.getTransaction().begin();
                emgr.persist(this.currentAccesorio);
                emgr.getTransaction().commit();
                this.crdAccesorio.hidePopupAdd();
                this.msg.setText("Nuevo accesorio " + this.currentAccesorio.getNombre() + " agregado exitosamente");
                this.msg.setVisible(true);
                this.currentAccesorio = new Accesorio();
                this.actualizarNodoClasificacion();
                break;
            }
        }
        return "done";
    }

    public String cancelAddEditAccesorio(){
        this.currentAccesorio = new Accesorio();
        this.crdAccesorio.hidePopupAdd();
        this.crdAccesorio.hidePopupEdit();
        return "done";
    }

    public String editAccesorio(){
        String idAccesorio = ((HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest()).getParameter("currentId");
        Accesorio acc = (Accesorio)this.getEntityManager().createQuery("SELECT a FROM Accesorio a WHERE a.idaccesorio=" + idAccesorio).getSingleResult();
        this.crdAccesorio.setCurrentId(idAccesorio);
        this.setCurrentAccesorio(acc);
        this.crdAccesorio.showPopupEdit();
        return "done";
    }

    public String commitEditAccesorio(){
        EntityManager emgr = this.getEntityManager();
        Marca mrk = (Marca)emgr.createQuery("SELECT m FROM Marca m WHERE m.idmarca=" + this.marcaSelected).getSingleResult();
        this.currentAccesorio.setIdmarca(mrk);
        emgr.getTransaction().begin();
        emgr.merge(this.currentAccesorio);
        emgr.getTransaction().commit();
        this.crdAccesorio.hidePopupEdit();
        for(Accesorio acc: this.getCurrentClasificacion().getAccesorioCollection()){
            if(acc.getIdaccesorio() == this.currentAccesorio.getIdaccesorio()){
                acc.setNombre(this.currentAccesorio.getNombre());
                acc.setIdmarca(mrk);
                acc.setModelo(this.currentAccesorio.getModelo());
                break;
            }
        }
        this.msg.setText("Accesorio modificado satisfactoriamente");
        this.msg.setVisible(true);
        this.currentAccesorio = new Accesorio();
        return "done";
    }
    
    public String delAccesorio(){
        String idAccesorio = this.crdAccesorio.getCurrentId();
        EntityManager emgr = this.getEntityManager();
        Accesorio acc = (Accesorio)emgr.createQuery("SELECT a FROM Accesorio a WHERE a.idaccesorio=" + idAccesorio).getSingleResult();
        emgr.getTransaction().begin();
        emgr.remove(acc);
        emgr.getTransaction().commit();
        this.crdAccesorio.hidePopupDel();
        this.getCurrentClasificacion().getAccesorioCollection().remove(acc);
        this.msg.setText("Accesorio " + acc.getNombre() + " eliminado satisfactoriamente.");
        this.msg.setVisible(true);
        this.actualizarNodoClasificacion();
        return "done";
    }

    public String addPieza(){
        for(Marca m: this.listaMarcas){
            if(m.getIdmarca().toString().equalsIgnoreCase(this.marcaSelected)){
                this.currentPieza.setIdmarca(m);
                this.currentPieza.setIdclasificacion(this.getCurrentClasificacion());
                this.getCurrentClasificacion().getPiezaCollection().add(this.currentPieza);
                EntityManager emgr = this.getEntityManager();
                emgr.getTransaction().begin();
                emgr.persist(this.currentPieza);
                emgr.getTransaction().commit();
                this.crdPieza.hidePopupAdd();
                this.msg.setText("Nueva pieza " + this.currentPieza.getNombre() + " agregada exitosamente");
                this.msg.setVisible(true);
                this.currentPieza = new Pieza();
                this.actualizarNodoClasificacion();
                break;
            }
        }
        return "done";
    }

    public String cancelAddEditPieza(){
        this.currentPieza = new Pieza();
        this.crdPieza.hidePopupAdd();
        this.crdPieza.hidePopupEdit();
        return "done";
    }

    public String editPieza(){
        String idPieza = ((HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest()).getParameter("currentId");
        Pieza pz = (Pieza)this.getEntityManager().createQuery("SELECT p FROM Pieza p WHERE p.idpieza=" + idPieza).getSingleResult();
        this.setCurrentPieza(pz);
        this.crdPieza.setCurrentId(idPieza);
        this.crdPieza.showPopupEdit();
        return "done";
    }

    public String commitEditPieza(){
        EntityManager emgr = this.getEntityManager();
        Marca mrk = (Marca)emgr.createQuery("SELECT m FROM Marca m WHERE m.idmarca=" + this.marcaSelected).getSingleResult();
        this.currentPieza.setIdmarca(mrk);
        emgr.getTransaction().begin();
        emgr.merge(this.currentPieza);
        emgr.getTransaction().commit();
        this.crdPieza.hidePopupEdit();
        for(Pieza pz: this.getCurrentClasificacion().getPiezaCollection()){
            if(pz.getIdpieza() == this.currentPieza.getIdpieza()){
                pz.setNombre(this.currentPieza.getNombre());
                pz.setIdmarca(mrk);
                pz.setModelo(this.currentPieza.getModelo());
            }
        }
        this.msg.setText("Pieza modificada satisfactoriamente");
        this.msg.setVisible(true);        
        return "done";
    }

    public String delPieza(){
        String idPieza = this.crdPieza.getCurrentId();
        EntityManager emgr = this.getEntityManager();
        Pieza pz = (Pieza)emgr.createQuery("SELECT p FROM Pieza p WHERE p.idpieza=" + idPieza).getSingleResult();
        emgr.getTransaction().begin();
        emgr.remove(pz);
        emgr.getTransaction().commit();
        this.crdPieza.hidePopupDel();
        this.getCurrentClasificacion().getPiezaCollection().remove(pz);
        this.msg.setText("Pieza " + pz.getNombre() + " eliminada satisfactoriamente.");
        this.msg.setVisible(true);
        this.actualizarNodoClasificacion();
        return "done";
    }

    public String addClasificaicon(){
        EntityManager emgr = this.getEntityManager();
        this.nuevaClasificacion.setIdsuperior(this.getCurrentClasificacion().getIdclasificacion());
        emgr.getTransaction().begin();
        emgr.persist(this.nuevaClasificacion);
        emgr.getTransaction().commit();
        this.crdClasificacion.hidePopupAdd();

        DefaultMutableTreeNode currentNodo = this.clasificaciontm.seleccionarNodo(this.getCurrentClasificacion().getIdclasificacion().toString());
        this.clasificaciontm.agregarNodo(currentNodo, nuevaClasificacion);

        this.msg.setText("Nueva clasificación agregada satisfactoriamente");
        this.msg.setVisible(true);
        this.nuevaClasificacion = new Clasificacion();
        return "done";
    }

    public String beforeShowPopupEditClasificacion(){
        if(!this.getCurrentClasificacionIsEditable()){
            this.crdClasificacion.hidePopupEdit();
            this.msg.setText("No se puede editar esta clasificación. Solamente se pueden editar las clasificaciones de color azul.");
            this.msg.setVisible(true);
            return "fail";
        }
        this.crdClasificacion.showPopupEdit();
        return "done";
    }

    public String editClasificacion(){        
        EntityManager emgr = this.getEntityManager();
        emgr.getTransaction().begin();
        emgr.merge(this.getCurrentClasificacion());
        emgr.getTransaction().commit();
        this.crdClasificacion.hidePopupEdit();
        Clasificacion current = this.getCurrentClasificacion();
        this.clasificaciontm.getCurrentUserObject().setText(current.getNombre() + "(" + (current.getEquipoCollection().size() + current.getAccesorioCollection().size() + current.getPiezaCollection().size() + current.getSoftwareCollection().size()) + ")");

        this.msg.setText("Clasificación modificada exitosamente");
        this.msg.setVisible(true);
        return "done";
    }

    public String beforeShowPopupDelClasificacion(){
        if(!this.getCurrentClasificacionIsEditable()){
            this.msg.setText("No se puede eliminar esta clasificación. Solamente se pueden eliminar las clasificaciones de color azul.");
            this.msg.setVisible(true);
            return "fail";
        }
        this.crdClasificacion.showPopupDel();
        return "done";
    }

    public String delClasificacion(){        
        EntityManager emgr = this.getEntityManager();
        DefaultMutableTreeNode currentNodo = this.clasificaciontm.seleccionarNodo(this.getCurrentClasificacion().getIdclasificacion().toString());
        Clasificacion clRemover = (Clasificacion)emgr.createQuery("SELECT c FROM Clasificacion c WHERE c.idclasificacion=" + this.getCurrentClasificacion().getIdclasificacion()).getSingleResult();
        if(!currentNodo.isLeaf()){
            this.crdClasificacion.hidePopupDel();
            this.msg.setText("Solamente se pueden eliminar las clasificaciones que no posean hijas");
            this.msg.setVisible(true);
            return "fail";
        }

        DefaultMutableTreeNode nodoPadre = this.clasificaciontm.seleccionarNodo(((ClasificacionUserObject)((DefaultMutableTreeNode)currentNodo.getParent()).getUserObject()).getClasificacion().getIdclasificacion().toString());
        Clasificacion clPadre = ((ClasificacionUserObject)nodoPadre.getUserObject()).getClasificacion();

        for(Equipo eq: clRemover.getEquipoCollection())
            eq.setIdclasificacion(clPadre);
        clPadre.getEquipoCollection().addAll(clRemover.getEquipoCollection());
        clRemover.getEquipoCollection().clear();

        for(Software sw: clRemover.getSoftwareCollection())
            sw.setIdclasificacion(clPadre);
        clPadre.getSoftwareCollection().addAll(clRemover.getSoftwareCollection());
        clRemover.getSoftwareCollection().clear();

        for(Accesorio ac: clRemover.getAccesorioCollection())
            ac.setIdclasificacion(clPadre);
        clPadre.getAccesorioCollection().addAll(clRemover.getAccesorioCollection());
        clRemover.getAccesorioCollection().clear();

        for(Pieza pz: clRemover.getPiezaCollection())
            pz.setIdclasificacion(clPadre);
        clPadre.getPiezaCollection().addAll(clRemover.getPiezaCollection());
        clRemover.getPiezaCollection().clear();

        emgr.getTransaction().begin();
        emgr.remove(clRemover);
        emgr.merge(clPadre);
        emgr.getTransaction().commit();
        this.crdClasificacion.hidePopupDel();

        Clasificacion current = this.getCurrentClasificacion();
        this.clasificaciontm.getCurrentUserObject().setText(current.getNombre() + "(" + (current.getEquipoCollection().size() + current.getAccesorioCollection().size() + current.getPiezaCollection().size() + current.getSoftwareCollection().size()) + ")");

        nodoPadre.remove(currentNodo);
        this.msg.setText("Clasificación eliminada satisfactoriamente. Los items asociados a esta clasificación fueron trasladados a la clasificación padre");
        this.msg.setVisible(true);
        return "done";
    }

    /**
     * @return the msg
     */
    public ActionMessage getMsg() {
        return msg;
    }

    /**
     * @param msg the msg to set
     */
    public void setMsg(ActionMessage msg) {
        this.msg = msg;
    }

    public void actualizarNodoClasificacion(){
        Clasificacion cl = this.getCurrentClasificacion();
        this.clasificaciontm.getCurrentUserObject().setText(cl.getNombre() + " (" + (cl.getEquipoCollection().size() + cl.getSoftwareCollection().size() + cl.getAccesorioCollection().size() + cl.getPiezaCollection().size()) +  ")");
    }

    /**
     * @return the crdClasificacion
     */
    public CrudManager getCrdClasificacion() {
        return crdClasificacion;
    }

    /**
     * @param crdClasificacion the crdClasificacion to set
     */
    public void setCrdClasificacion(CrudManager crdClasificacion) {
        this.crdClasificacion = crdClasificacion;
    }

    public Clasificacion getNuevaClasificacion(){
        return this.nuevaClasificacion;
    }

    /**
     * @param currentClasificacion the currentClasificacion to set
     */
    public void setNuevaClasificacion(Clasificacion currentClasificacion) {
        this.nuevaClasificacion = currentClasificacion;
    }

    public boolean getCurrentClasificacionIsEditable(){
        return this.getCurrentClasificacion().getIdclasificacion() > 16;
    }
}