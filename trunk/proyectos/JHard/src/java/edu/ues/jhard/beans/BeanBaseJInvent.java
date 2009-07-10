/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.ues.jhard.beans;

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
    private Pieza currentPieza;
    private CrudManager crdEquipo;
    private CrudManager crdSoftware;
    private CrudManager crdPieza;
    private CrudManager crdAccesorio;
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
        this.crdEquipo = new CrudManager();
        this.crdSoftware = new CrudManager();
        this.crdAccesorio = new CrudManager();
        this.crdPieza = new CrudManager();
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
                break;
            }
        }
        this.crdEquipo.hidePopupAdd();
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
                break;
            }
        }
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
                break;
            }
        }
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
}
