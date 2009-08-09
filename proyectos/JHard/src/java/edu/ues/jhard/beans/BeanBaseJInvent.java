/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.ues.jhard.beans;

import com.icesoft.faces.component.datapaginator.DataPaginator;
import com.icesoft.faces.component.tree.TreeNode;
import edu.ues.jhard.jinvent.ClasificacionTreeModel;
import edu.ues.jhard.jinvent.ClasificacionUserObject;
import edu.ues.jhard.jinvent.CrudManager;
import edu.ues.jhard.jpa.Accesorio;
import edu.ues.jhard.jpa.Bitacoraestados;
import edu.ues.jhard.jpa.Clasificacion;
import edu.ues.jhard.jpa.Equipo;
import edu.ues.jhard.jpa.Estadoequipo;
import edu.ues.jhard.jpa.Existencia;
import edu.ues.jhard.jpa.Horario;
import edu.ues.jhard.jpa.Instalacion;
import edu.ues.jhard.jpa.Marca;
import edu.ues.jhard.jpa.Pieza;
import edu.ues.jhard.jpa.Reserva;
import edu.ues.jhard.jpa.Software;
import edu.ues.jhard.jpa.Solicitud;
import edu.ues.jhard.jpa.Ubicacion;
import edu.ues.jhard.jpa.Usuario;
import edu.ues.jhard.util.ActionMessage;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;
import javax.faces.event.ValueChangeListener;
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
    private Existencia currentExistencia;
    private Software currentSoftware;
    private Accesorio currentAccesorio;
    private Clasificacion nuevaClasificacion;
    private Pieza currentPieza;
    private Marca currentMarca;
    private Ubicacion currentUbicacion;
    private CrudManager crdEquipo;
    private CrudManager crdSoftware;
    private CrudManager crdPieza;
    private CrudManager crdAccesorio;
    private CrudManager crdClasificacion;
    private CrudManager crdExistencia;
    private CrudManager crdMarcas;
    private CrudManager crdUbicaciones;
    private List<Marca> listaMarcas;
    private List<Equipo> listaTodosEquipos;
    private List<Accesorio> listaTodosAccesorios;
    private List<Pieza> listaTodasPiezas;
    private List<Software> listaTodosSoftware;
    private List<Estadoequipo> listaEstados;
    private List<Ubicacion> listaUbicaciones;
    private List<Bitacoraestados> listaEstadosExistencia;
    private SelectItemGroup listaItemsMarcas;
    private SelectItemGroup listaItemsEquipos;
    private SelectItemGroup listaItemsUbicaciones;
    private SelectItemGroup listaItemsAccesorios;
    private SelectItemGroup listaItemsPiezas;
    private SelectItemGroup listaItemsSoftware;
    private List listaResultadosBusqueda;
    private List listaNombresAtributos;
    private String marcaSelected;
    private String estadoSelected;
    private String equipoSelected;
    private String accesorioSelected;
    private String piezaSelected;
    private String softwareSelected;
    private String ubicacionSelected;
    private boolean existenciaEditMode;
    private boolean popupMantenimientoVisible;
    private boolean searchMode;
    private String descripcionSolicitud;
    private String valorBusqueda;
    private ActionMessage msg;
    private DataPaginator pgr;

    public BeanBaseJInvent(){
        this.clasificaciontm = new ClasificacionTreeModel(this.getEntityManager());
        this.currentEquipo = new Equipo();
        this.currentSoftware = new Software();
        this.currentAccesorio = new Accesorio();
        this.currentPieza = new Pieza();
        this.nuevaClasificacion = new Clasificacion();
        this.currentMarca = new Marca();
        this.currentUbicacion = new Ubicacion();
        this.crdEquipo = new CrudManager();
        this.crdSoftware = new CrudManager();
        this.crdAccesorio = new CrudManager();
        this.crdPieza = new CrudManager();
        this.crdClasificacion = new CrudManager();
        this.crdExistencia = new CrudManager();
        this.crdMarcas = new CrudManager();
        this.crdUbicaciones = new CrudManager();
        this.msg = new ActionMessage();
        this.listaEstados = this.getEntityManager().createNamedQuery("Estadoequipo.findAll").getResultList();
        this.listaMarcas = this.getEntityManager().createNamedQuery("Marca.findAll").getResultList();        
        this.listaTodosEquipos = this.getEntityManager().createNamedQuery("Equipo.findAll").getResultList();
        this.initItemsMarcas();
        this.initAtributos();
        this.listaUbicaciones = this.getEntityManager().createNamedQuery("Ubicacion.findAll").getResultList();
        this.listaResultadosBusqueda = new ArrayList();        
        this.valorBusqueda = "";
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
        this.getClasificaciontm().seleccionarNodo(idClasificacion);
        if(idClasificacion.equalsIgnoreCase("-1")){
            this.setSearchMode(true);
            this.valorBusqueda = "";
        }
        else            
            this.setSearchMode(false);

    }

    public Clasificacion getCurrentClasificacion(){
        return this.getClasificaciontm().getCurrentUserObject().getClasificacion();
    }

    public int getCurrentClasificacionExistenciaCollectionSize(){
        return this.getCurrentClasificacion().getExistenciaCollection().size();
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

    public int getSizeListaExistencias(){
        int totalExistencias = 0;
        for(Equipo eq: this.getCurrentClasificacion().getEquipoCollection())
            totalExistencias += eq.getExistenciaSize();
        return totalExistencias;
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

    public int getSizeListaMarcas(){
        return this.getListaMarcas().size();
    }

    public int getSizeListaUbicaciones(){
        return this.getListaUbicaciones().size();
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

    private void initItemsAccesorios() {
        this.setListaItemsAccesorios(new SelectItemGroup());
        SelectItem[] items = new SelectItem[this.getListaTodosAccesorios().size()];
        for(int i=0; i<this.getListaTodosAccesorios().size(); i++){
            items[i] = new SelectItem(this.getListaTodosAccesorios().get(i).getIdaccesorio(), this.getListaTodosAccesorios().get(i).getNombre() + " " + this.getListaTodosAccesorios().get(i).getIdmarca().getNombre() + " " + this.getListaTodosAccesorios().get(i).getModelo());
        }
        this.getListaItemsAccesorios().setSelectItems(items);
        if(this.getListaTodosAccesorios().size() > 0)
            this.setAccesorioSelected(this.getListaTodosAccesorios().get(0).getIdaccesorio().toString());
    }

    private void initItemsEquipos() {
        this.setListaItemsEquipos(new SelectItemGroup());
        SelectItem[] items = new SelectItem[this.listaTodosEquipos.size()];
        for(int i=0; i<this.listaTodosEquipos.size(); i++){
            items[i] = new SelectItem(this.listaTodosEquipos.get(i).getIdequipo(), this.listaTodosEquipos.get(i).getNombre() + " " + this.listaTodosEquipos.get(i).getIdmarca().getNombre() + " " + this.listaTodosEquipos.get(i).getModelo());
        }
        this.getListaItemsEquipos().setSelectItems(items);
        if(this.getListaTodosEquipos().size() > 0)
            this.setEquipoSelected(this.getListaTodosEquipos().get(0).getIdequipo().toString());
    }

    private void initItemsMarcas() {
        this.setListaItemsMarcas(new SelectItemGroup());
       SelectItem[] items = new SelectItem[this.getListaMarcas().size()];
       for(int i=0; i<this.getListaMarcas().size(); i++){
           items[i] = new SelectItem(this.getListaMarcas().get(i).getIdmarca(), this.getListaMarcas().get(i).getNombre());
       }
        this.getListaItemsMarcas().setSelectItems(items);
    }

    private void initItemsPiezas() {
        this.setListaItemsPiezas(new SelectItemGroup());
        SelectItem[] items = new SelectItem[this.getListaTodasPiezas().size()];
        for(int i=0; i<this.getListaTodasPiezas().size(); i++){
            items[i] = new SelectItem(this.getListaTodasPiezas().get(i).getIdpieza(), this.getListaTodasPiezas().get(i).getNombre() + " " + this.getListaTodasPiezas().get(i).getIdmarca().getNombre() + " " + this.listaTodasPiezas.get(i).getModelo());
        }
        this.getListaItemsPiezas().setSelectItems(items);
        if(this.getListaTodasPiezas().size() > 0)
            this.setMarcaSelected(this.getListaTodasPiezas().get(0).getIdmarca().toString());
    }

    private void initItemsSoftware() {
        this.setListaItemsSoftware(new SelectItemGroup());
        SelectItem[] items = new SelectItem[this.getListaTodosSoftware().size()];
        for(int i=0; i<this.getListaTodosSoftware().size(); i++){
            items[i] = new SelectItem(this.getListaTodosSoftware().get(i).getIdsoftware(), this.getListaTodosSoftware().get(i).getNombre() + " " + this.getListaTodosSoftware().get(i).getVersion());
        }
        this.getListaItemsSoftware().setSelectItems(items);
        if(this.getListaTodosSoftware().size() > 0)
            this.setSoftwareSelected(this.getListaTodosSoftware().get(0).getIdsoftware().toString());
    }

    private void initItemsUbicaciones() {
        this.setListaItemsUbicaciones(new SelectItemGroup());
        SelectItem[] items = new SelectItem[this.getListaUbicaciones().size()];
        for(int i=0; i<this.getListaUbicaciones().size(); i++){
            items[i] = new SelectItem(this.getListaUbicaciones().get(i).getIdubicacion(), this.getListaUbicaciones().get(i).getNombre());
        }
        this.getListaItemsUbicaciones().setSelectItems(items);
        if(this.getListaUbicaciones().size() > 0)
            this.setUbicacionSelected(this.getListaUbicaciones().get(0).getIdubicacion().toString());
    }

    private void initAtributos(){
        this.listaNombresAtributos = this.getEntityManager().createNamedQuery("Atributohardware.findAll").getResultList();
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

    public String addExistencia(){
        EntityManager emgr = this.getEntityManager();
        Equipo eq = (Equipo)emgr.createQuery("SELECT h FROM Equipo h WHERE h.idequipo=" + this.equipoSelected ).getSingleResult();
        Ubicacion ubc = (Ubicacion)emgr.createQuery("SELECT u FROM Ubicacion u WHERE u.idubicacion=" + this.ubicacionSelected).getSingleResult();
        eq.getExistenciaCollection().add(this.currentExistencia);
        ubc.getExistenciaCollection().add(this.currentExistencia);
        this.currentExistencia.setIdhardware(eq);
        this.currentExistencia.setIdubicacion(ubc);
        this.currentExistencia.setIdestado(this.getListaEstados().get(0));
        this.currentExistencia.setIdexistencia(null);
        for(Instalacion inst: this.currentExistencia.getInstalacionCollection())
            inst.setIdinstalacion(null);
        
        emgr.getTransaction().begin();
        emgr.persist(this.currentExistencia);
        emgr.merge(this.currentExistencia.getIdhardware());
        for(Accesorio acc: this.currentExistencia.getAccesorioCollection())
            emgr.merge(acc);
        
        for(Instalacion inst: this.currentExistencia.getInstalacionCollection())
            emgr.persist(inst);        
        
        for(Pieza pz: this.currentExistencia.getPiezaCollection())
            emgr.merge(pz);
        
        emgr.getTransaction().commit();

        for(Equipo eqEnClasificacion: this.getCurrentClasificacion().getEquipoCollection()){
            if(eqEnClasificacion.getIdequipo() == eq.getIdequipo()){
                eqEnClasificacion.getExistenciaCollection().add(this.currentExistencia);
                this.actualizarCurrentNodoClasificacion();
                break;
            }
        }
        this.clasificaciontm.actualizarNodo(this.currentExistencia.getIdhardware().getIdclasificacion());
        this.crdExistencia.hidePopupAdd();
        this.msg.setText("Existencia " + this.currentExistencia.getCodigo() + " agregada exitosamente");
        this.msg.setVisible(true);
        this.currentExistencia = null;
        this.actualizarCurrentNodoClasificacion();
        return "done";
    }

    public String cancelAddEditExistencia(){
        this.currentExistencia = new Existencia();
        this.crdExistencia.hidePopupAdd();
        this.crdExistencia.hidePopupEdit();
        return "done";
    }

    public String commitEditExistencia(){
        EntityManager emgr = this.getEntityManager();
        
        if(!this.currentExistencia.getIdhardware().getIdequipo().toString().equalsIgnoreCase(this.equipoSelected)){
            Equipo newAssignedEquipo = (Equipo)emgr.createQuery("SELECT e FROM Equipo e WHERE e.idequipo=" + this.equipoSelected).getSingleResult();
            Equipo oldAssignedEquipo = this.currentExistencia.getIdhardware();
            oldAssignedEquipo.getExistenciaCollection().remove(this.currentExistencia);
            newAssignedEquipo.getExistenciaCollection().add(currentExistencia);
            currentExistencia.setIdhardware(newAssignedEquipo);
            emgr.getTransaction().begin();
            emgr.merge(oldAssignedEquipo);
            emgr.merge(newAssignedEquipo);
            emgr.merge(currentExistencia);
            emgr.getTransaction().commit();
        }

        if(!this.currentExistencia.getIdubicacion().getIdubicacion().toString().equalsIgnoreCase(this.ubicacionSelected)){
            Ubicacion newAssignedUbicacion = (Ubicacion)emgr.createQuery("SELECT u FROM Ubicacion u WHERE u.idubicacion=" + this.ubicacionSelected).getSingleResult();
            Ubicacion oldAssignedUbicacion = this.currentExistencia.getIdubicacion();
            oldAssignedUbicacion.getExistenciaCollection().remove(this.currentExistencia);
            newAssignedUbicacion.getExistenciaCollection().add(this.currentExistencia);
            currentExistencia.setIdubicacion(newAssignedUbicacion);
            emgr.getTransaction().begin();
            emgr.merge(oldAssignedUbicacion);
            emgr.merge(newAssignedUbicacion);
            emgr.merge(this.currentExistencia);
            emgr.getTransaction().commit();
        }

        emgr.getTransaction().begin();
        for(Accesorio acc: this.currentExistencia.getAccesorioCollection())
            emgr.merge(acc);

        for(Instalacion inst: this.currentExistencia.getInstalacionCollection())
            emgr.merge(inst);

        for(Pieza pz: this.currentExistencia.getPiezaCollection())
            emgr.merge(pz);
        emgr.getTransaction().commit();

        emgr.getTransaction().begin();
        emgr.merge(this.currentExistencia);
        emgr.getTransaction().commit();

        for(Existencia ext: this.getCurrentClasificacion().getExistenciaCollection()){            
            if(ext.getIdexistencia() == this.currentExistencia.getIdexistencia()){                
                ext.setCodigo(this.currentExistencia.getCodigo());
                ext.setIdhardware(this.currentExistencia.getIdhardware());
                ext.setIdubicacion(this.currentExistencia.getIdubicacion());
                break;
            }
        }
        this.crdExistencia.hidePopupEdit();
        this.msg.setText("Existencia modificada satisfactoriamente");
        this.msg.setVisible(true);
        return "done";
    }

    public String beforeAddEquipo(){        
        this.currentEquipo = new Equipo();
        this.crdEquipo.showPopupAdd();
        return "done";
    }

    public String addEquipo(){
        for(Marca m: this.getListaMarcas()){
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
                this.actualizarCurrentNodoClasificacion();
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
        this.currentEquipo = (Equipo)this.getEntityManager().createQuery("SELECT e FROM Equipo e WHERE e.idequipo=" + idEquipo).getSingleResult();
        this.setMarcaSelected(this.currentEquipo.getIdmarca().getIdmarca().toString());
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
        this.actualizarCurrentNodoClasificacion();
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
        this.actualizarCurrentNodoClasificacion();
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
        this.actualizarCurrentNodoClasificacion();
        return "done";
    }

    public String addAccesorio(){
        for(Marca m: this.getListaMarcas()){
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
                this.actualizarCurrentNodoClasificacion();
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
        this.setMarcaSelected(acc.getIdmarca().getIdmarca().toString());
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
        this.actualizarCurrentNodoClasificacion();
        return "done";
    }

    public String addPieza(){
        for(Marca m: this.getListaMarcas()){
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
                this.actualizarCurrentNodoClasificacion();
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
        this.setMarcaSelected(pz.getIdmarca().toString());
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
        this.actualizarCurrentNodoClasificacion();
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
        actualizarCurrentNodoClasificacion();

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

        emgr.getTransaction().begin();

        for(Equipo eq: clRemover.getEquipoCollection()){
            eq.setIdclasificacion(clPadre);
            emgr.merge(eq);
        }
        clPadre.getEquipoCollection().addAll(clRemover.getEquipoCollection());
        clRemover.getEquipoCollection().clear();

        for(Software sw: clRemover.getSoftwareCollection()){
            sw.setIdclasificacion(clPadre);
            emgr.merge(sw);
        }
        clPadre.getSoftwareCollection().addAll(clRemover.getSoftwareCollection());
        clRemover.getSoftwareCollection().clear();

        for(Accesorio ac: clRemover.getAccesorioCollection()){
            ac.setIdclasificacion(clPadre);
            emgr.merge(ac);
        }
        clPadre.getAccesorioCollection().addAll(clRemover.getAccesorioCollection());
        clRemover.getAccesorioCollection().clear();

        for(Pieza pz: clRemover.getPiezaCollection()){
            pz.setIdclasificacion(clPadre);
            emgr.merge(pz);
        }
        clPadre.getPiezaCollection().addAll(clRemover.getPiezaCollection());
        clRemover.getPiezaCollection().clear();
        
        emgr.getTransaction().commit();

        emgr.getTransaction().begin();
        emgr.remove(clRemover);
        emgr.merge(clPadre);
        emgr.getTransaction().commit();
        this.crdClasificacion.hidePopupDel();

        Clasificacion current = this.getCurrentClasificacion();
        this.actualizarCurrentNodoClasificacion();

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

    public void actualizarCurrentNodoClasificacion(){
        Clasificacion cl = this.getCurrentClasificacion();
        int cantExistencias = 0;
        for(Equipo eq: cl.getEquipoCollection())
            cantExistencias += eq.getExistenciaSize();

        this.clasificaciontm.getCurrentUserObject().setText(cl.getNombre() + " (" + (cantExistencias + cl.getSoftwareCollection().size() + cl.getAccesorioCollection().size() + cl.getPiezaCollection().size()) +  ")");
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

    /**
     * @return the currentExistencia
     */
    public Existencia getCurrentExistencia() {
        return currentExistencia;
    }

    /**
     * @param currentExistencia the currentExistencia to set
     */
    public void setCurrentExistencia(Existencia currentExistencia) {
        this.currentExistencia = currentExistencia;
    }

    /**
     * @return the crdExistencia
     */
    public CrudManager getCrdExistencia() {
        return crdExistencia;
    }

    /**
     * @param crdExistencia the crdExistencia to set
     */
    public void setCrdExistencia(CrudManager crdExistencia) {
        this.crdExistencia = crdExistencia;
    }

    /**
     * @return the listaTodosEquipos
     */
    public List<Equipo> getListaTodosEquipos() {
        return listaTodosEquipos;
    }

    /**
     * @param listaTodosEquipos the listaTodosEquipos to set
     */
    public void setListaTodosEquipos(List<Equipo> listaTodosEquipos) {
        this.listaTodosEquipos = listaTodosEquipos;
    }

    /**
     * @return the estadoSelected
     */
    public String getEstadoSelected() {
        return estadoSelected;
    }

    /**
     * @param estadoSelected the estadoSelected to set
     */
    public void setEstadoSelected(String estadoSelected) {
        this.estadoSelected = estadoSelected;
    }

    /**
     * @return the equipoSelected
     */
    public String getEquipoSelected() {
        return equipoSelected;
    }

    /**
     * @param equipoSelected the equipoSelected to set
     */
    public void setEquipoSelected(String equipoSelected) {
        this.equipoSelected = equipoSelected;
    }

    /**
     * @return the ubicacionSelected
     */
    public String getUbicacionSelected() {
        return ubicacionSelected;
    }

    /**
     * @param ubicacionSelected the ubicacionSelected to set
     */
    public void setUbicacionSelected(String ubicacionSelected) {
        this.ubicacionSelected = ubicacionSelected;
    }

    /**
     * @return the listaUbicaciones
     */
    public List<Ubicacion> getListaUbicaciones() {
        return listaUbicaciones;
    }

    /**
     * @param listaUbicaciones the listaUbicaciones to set
     */
    public void setListaUbicaciones(List<Ubicacion> listaUbicaciones) {
        this.setListaUbicaciones(listaUbicaciones);
    }

    /**
     * @return the listaItemsEquipos
     */
    public SelectItemGroup getListaItemsEquipos() {
        return listaItemsEquipos;
    }

    /**
     * @param listaItemsEquipos the listaItemsEquipos to set
     */
    public void setListaItemsEquipos(SelectItemGroup listaItemsEquipos) {
        this.listaItemsEquipos = listaItemsEquipos;
    }

    /**
     * @return the listaItemsUbicaciones
     */
    public SelectItemGroup getListaItemsUbicaciones() {
        return listaItemsUbicaciones;
    }

    /**
     * @param listaItemsUbicaciones the listaItemsUbicaciones to set
     */
    public void setListaItemsUbicaciones(SelectItemGroup listaItemsUbicaciones) {
        this.listaItemsUbicaciones = listaItemsUbicaciones;
    }

    /**
     * @return the listaItemsAccesorios
     */
    public SelectItemGroup getListaItemsAccesorios() {
        return listaItemsAccesorios;
    }

    /**
     * @param listaItemsAccesorios the listaItemsAccesorios to set
     */
    public void setListaItemsAccesorios(SelectItemGroup listaItemsAccesorios) {
        this.listaItemsAccesorios = listaItemsAccesorios;
    }

    /**
     * @return the listaItemsPiezas
     */
    public SelectItemGroup getListaItemsPiezas() {
        return listaItemsPiezas;
    }

    /**
     * @param listaItemsPiezas the listaItemsPiezas to set
     */
    public void setListaItemsPiezas(SelectItemGroup listaItemsPiezas) {
        this.listaItemsPiezas = listaItemsPiezas;
    }

    /**
     * @return the listaItemsSoftware
     */
    public SelectItemGroup getListaItemsSoftware() {
        return listaItemsSoftware;
    }

    /**
     * @param listaItemsSoftware the listaItemsSoftware to set
     */
    public void setListaItemsSoftware(SelectItemGroup listaItemsSoftware) {
        this.listaItemsSoftware = listaItemsSoftware;
    }

    /**
     * @return the listaMarcas
     */
    public List<Marca> getListaMarcas() {
        return listaMarcas;
    }

    /**
     * @param listaMarcas the listaMarcas to set
     */
    public void setListaMarcas(List<Marca> listaMarcas) {
        this.listaMarcas = listaMarcas;
    }

    /**
     * @return the listaTodosAccesorios
     */
    public List<Accesorio> getListaTodosAccesorios() {
        return listaTodosAccesorios;
    }

    /**
     * @param listaTodosAccesorios the listaTodosAccesorios to set
     */
    public void setListaTodosAccesorios(List<Accesorio> listaTodosAccesorios) {
        this.listaTodosAccesorios = listaTodosAccesorios;
    }

    /**
     * @return the listaTodasPiezas
     */
    public List<Pieza> getListaTodasPiezas() {
        return listaTodasPiezas;
    }

    /**
     * @param listaTodasPiezas the listaTodasPiezas to set
     */
    public void setListaTodasPiezas(List<Pieza> listaTodasPiezas) {
        this.listaTodasPiezas = listaTodasPiezas;
    }

    /**
     * @return the listaTodosSoftware
     */
    public List<Software> getListaTodosSoftware() {
        return listaTodosSoftware;
    }

    /**
     * @param listaTodosSoftware the listaTodosSoftware to set
     */
    public void setListaTodosSoftware(List<Software> listaTodosSoftware) {
        this.listaTodosSoftware = listaTodosSoftware;
    }

    /**
     * @return the listaEstados
     */
    public List<Estadoequipo> getListaEstados() {
        return listaEstados;
    }

    /**
     * @param listaEstados the listaEstados to set
     */
    public void setListaEstados(List<Estadoequipo> listaEstados) {
        this.listaEstados = listaEstados;
    }

    /**
     * @return the accesorioSelected
     */
    public String getAccesorioSelected() {
        return accesorioSelected;
    }

    /**
     * @param accesorioSelected the accesorioSelected to set
     */
    public void setAccesorioSelected(String accesorioSelected) {
        this.accesorioSelected = accesorioSelected;
    }

    /**
     * @return the piezaSelected
     */
    public String getPiezaSelected() {
        return piezaSelected;
    }

    /**
     * @param piezaSelected the piezaSelected to set
     */
    public void setPiezaSelected(String piezaSelected) {
        this.piezaSelected = piezaSelected;
    }

    /**
     * @return the softwareSelected
     */
    public String getSoftwareSelected() {
        return softwareSelected;
    }

    /**
     * @param softwareSelected the softwareSelected to set
     */
    public void setSoftwareSelected(String softwareSelected) {
        this.softwareSelected = softwareSelected;
    }
    
    public void initItemsCombos(){
        this.listaTodosEquipos = this.getEntityManager().createNamedQuery("Equipo.findAll").getResultList();
        this.listaUbicaciones = this.getEntityManager().createNamedQuery("Ubicacion.findAll").getResultList();        
        this.listaTodosAccesorios = this.getEntityManager().createNamedQuery("Accesorio.findAllAvailable").getResultList();
        this.listaTodasPiezas = this.getEntityManager().createNamedQuery("Pieza.findAllAvailable").getResultList();
        this.listaTodosSoftware = this.getEntityManager().createNamedQuery("Software.findAllAvailable").getResultList();
        
        this.initItemsEquipos();
        this.initItemsUbicaciones();
        this.initItemsPiezas();
        this.initItemsAccesorios();
        this.initItemsSoftware();
    }

    public String beforeAddExistencia(){
        this.currentExistencia = new Existencia(-1);
        this.currentExistencia.setAccesorioCollection(new ArrayList<Accesorio>());
        this.currentExistencia.setInstalacionCollection(new ArrayList<Instalacion>());
        this.currentExistencia.setPiezaCollection(new ArrayList<Pieza>());
        this.initItemsCombos();
        this.existenciaEditMode = false;
        this.crdExistencia.showPopupAdd();
        return "done";
    }

    public String editExistencia(){
        String idExistencia = ((HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest()).getParameter("currentId");
        this.currentExistencia = (Existencia)this.getEntityManager().createQuery("SELECT e FROM Existencia e WHERE e.idexistencia=" + idExistencia).getSingleResult();
        this.initItemsCombos();
        this.equipoSelected = this.currentExistencia.getIdhardware().getIdequipo().toString();
        this.ubicacionSelected = this.currentExistencia.getIdubicacion().getIdubicacion().toString();
        
        this.existenciaEditMode = true;
        this.crdExistencia.showPopupEdit();
        return "done";
    }

    public String agregarInstalacionExistencia(){
        Software soft = (Software)this.getEntityManager().createQuery("SELECT s FROM Software s WHERE s.idsoftware=" + this.softwareSelected).getSingleResult();        
        Instalacion inst = new Instalacion();
        if(this.currentExistencia.getInstalacionCollection().size() > 0)
            inst.setIdinstalacion(((Instalacion)this.currentExistencia.getInstalacionCollection().toArray()[this.currentExistencia.getInstalacionCollection().size() - 1]).getIdinstalacion() + 1);
            //inst.setIdinstalacion(((ArrayList<Instalacion>)this.currentExistencia.getInstalacionCollection()).get(this.currentExistencia.getInstalacionCollection().size()-1).getIdinstalacion() + 1);
        else
            inst.setIdinstalacion(1);
        inst.setIdsoftware(soft);
        inst.setFechainstalacion(new Date());
        inst.setIdequipoexistente(this.currentExistencia);
        this.currentExistencia.getInstalacionCollection().add(inst);
        return "done";
    }

    public String eliminarInstalacionExistencia(){
        String idInstalacion = ((HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest()).getParameter("currentId");        
        Iterator it = this.currentExistencia.getInstalacionCollection().iterator();
        while(it.hasNext()){
            Instalacion inst = (Instalacion)it.next();            
            if(inst.getIdinstalacion().toString().equalsIgnoreCase(idInstalacion)){                
                this.currentExistencia.getInstalacionCollection().remove(inst);
                return "removed";
            }
        }
        return "done";
    }

    public String agregarAccesorioExistencia(){
        Accesorio acc = (Accesorio)this.getEntityManager().createQuery("SELECT a FROM Accesorio a WHERE a.idaccesorio=" + this.accesorioSelected).getSingleResult();
        acc.setIdexistencia(this.currentExistencia);
        this.currentExistencia.getAccesorioCollection().add(acc);
        this.listaTodosAccesorios.remove(acc);
        this.initItemsAccesorios();
        return "done";
    }

    public String eliminarAccesorioExistencia(){
        String idAccesorio = ((HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest()).getParameter("currentId");
        Iterator it = this.currentExistencia.getAccesorioCollection().iterator();
        while(it.hasNext()){
            Accesorio acc = (Accesorio)it.next();
            if(acc.getIdaccesorio().toString().equalsIgnoreCase(idAccesorio)){
                this.currentExistencia.getAccesorioCollection().remove(acc);
                this.listaTodosAccesorios.add(acc);
                this.initItemsAccesorios();
                return "removed";
            }
        }
        return "done";
    }

    public String agregarPiezaExistencia(){
        Pieza pz = (Pieza)this.getEntityManager().createQuery("SELECT p FROM Pieza p WHERE p.idpieza=" + this.piezaSelected).getSingleResult();
        pz.setIdexistencia(this.currentExistencia);
        this.currentExistencia.getPiezaCollection().add(pz);
        this.listaTodasPiezas.remove(pz);
        this.initItemsPiezas();
        return "done";
    }

    public String eliminarPiezaExistencia(){
        String idPieza = ((HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest()).getParameter("currentId");
        Iterator it = this.currentExistencia.getPiezaCollection().iterator();
        while(it.hasNext()){
            Pieza pz = (Pieza)it.next();
            if(pz.getIdpieza().toString().equalsIgnoreCase(idPieza)){
                this.currentExistencia.getPiezaCollection().remove(pz);
                this.listaTodasPiezas.add(pz);
                this.initItemsPiezas();
                return "removed";
            }
        }
        return "done";
    }   

    public String delExistencia(){
        String idExistencia = this.crdExistencia.getCurrentId();
        EntityManager emgr = this.getEntityManager();
        Existencia exst = (Existencia)emgr.createQuery("SELECT e FROM Existencia e WHERE e.idexistencia=" + idExistencia).getSingleResult();
        emgr.getTransaction().begin();

        for(Accesorio acc: exst.getAccesorioCollection()){
            acc.setIdexistencia(null);
            emgr.merge(acc);
        }

        for(Pieza pz: exst.getPiezaCollection()){
            pz.setIdexistencia(null);
            emgr.merge(pz);
        }

        for(Instalacion inst: exst.getInstalacionCollection()){
            emgr.remove(inst);
        }

        exst.getAccesorioCollection().clear();
        exst.getPiezaCollection().clear();
        exst.getInstalacionCollection().clear();
        emgr.remove(exst);
        emgr.getTransaction().commit();

        this.crdExistencia.hidePopupDel();
        for(Equipo eq: this.getCurrentClasificacion().getEquipoCollection()){
            if(eq.getExistenciaCollection().contains(exst)){
                eq.getExistenciaCollection().remove(exst);
            }
        }
        this.msg.setText("Existencia " + exst.getIdhardware().getNombre() + " - " + exst.getCodigo() + " eliminada satisfactoriamente.");
        this.msg.setVisible(true);
        this.actualizarCurrentNodoClasificacion();
        return "done";
    }

    /**
     * @return the existenciaEditMode
     */
    public boolean getExistenciaEditMode() {
        return existenciaEditMode;
    }

    /**
     * @param existenciaEditMode the existenciaEditMode to set
     */
    public void setExistenciaEditMode(boolean existenciaEditMode) {
        this.existenciaEditMode = existenciaEditMode;
    }

    public int getListaTodosAccesoriosSize(){
        return this.listaTodosAccesorios.size();
    }

    public int getListaTodasPiezasSize(){
        return this.listaTodasPiezas.size();
    }

    /**
     * @return the crdMarcas
     */
    public CrudManager getCrdMarcas() {
        return crdMarcas;
    }

    /**
     * @param crdMarcas the crdMarcas to set
     */
    public void setCrdMarcas(CrudManager crdMarcas) {
        this.crdMarcas = crdMarcas;
    }

    /**
     * @return the crdUbicaciones
     */
    public CrudManager getCrdUbicaciones() {
        return crdUbicaciones;
    }

    /**
     * @param crdUbicaciones the crdUbicaciones to set
     */
    public void setCrdUbicaciones(CrudManager crdUbicaciones) {
        this.crdUbicaciones = crdUbicaciones;
    }

    /**
     * @return the currentMarca
     */
    public Marca getCurrentMarca() {
        return currentMarca;
    }

    /**
     * @param currentMarca the currentMarca to set
     */
    public void setCurrentMarca(Marca currentMarca) {
        this.currentMarca = currentMarca;
    }

    /**
     * @return the currentUbicacion
     */
    public Ubicacion getCurrentUbicacion() {
        return currentUbicacion;
    }

    /**
     * @param currentUbicacion the currentUbicacion to set
     */
    public void setCurrentUbicacion(Ubicacion currentUbicacion) {
        this.currentUbicacion = currentUbicacion;
    }

    public String addMarca(){
        EntityManager emgr = this.getEntityManager();
        emgr.getTransaction().begin();
        emgr.persist(this.currentMarca);
        emgr.getTransaction().commit();
        this.listaMarcas.add(this.currentMarca);
        this.crdMarcas.hidePopupAdd();
        this.msg.setText("Marca " + this.currentMarca.getNombre() + " agregada exitosamente");
        this.msg.setVisible(true);
        this.initItemsMarcas();
        this.currentMarca = new Marca();
        this.currentMarca.setAccesorioCollection(new ArrayList<Accesorio>());
        this.currentMarca.setEquipoCollection(new ArrayList<Equipo>());
        this.currentMarca.setPiezaCollection(new ArrayList<Pieza>());
        return "done";
    }

    public String editMarca(){
        String idMarca = ((HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest()).getParameter("currentId");
        this.currentMarca = (Marca)this.getEntityManager().createQuery("SELECT m FROM Marca m WHERE m.idmarca=" + idMarca).getSingleResult();
        this.crdMarcas.showPopupEdit();
        return "done";
    }

    public String commitEditMarca(){
        EntityManager emgr = this.getEntityManager();
        emgr.getTransaction().begin();
        emgr.merge(this.currentMarca);
        emgr.getTransaction().commit();
        this.crdMarcas.hidePopupEdit();
        this.msg.setText("Marca editada exitosamente");
        this.msg.setVisible(true);

        for(Marca m: this.listaMarcas){
            if(m.getIdmarca() == this.currentMarca.getIdmarca()){
                m.setNombre(this.currentMarca.getNombre());
                break;
            }
        }
        this.initItemsMarcas();
        this.currentMarca = new Marca();
        this.currentMarca.setAccesorioCollection(new ArrayList<Accesorio>());
        this.currentMarca.setEquipoCollection(new ArrayList<Equipo>());
        this.currentMarca.setPiezaCollection(new ArrayList<Pieza>());
        return "done";
    }

    public String delMarca(){
        EntityManager emgr = this.getEntityManager();        
        this.currentMarca = (Marca)emgr.createQuery("SELECT m FROM Marca m WHERE m.idmarca=" + this.crdMarcas.getCurrentId()).getSingleResult();
        Marca mGenerica = (Marca)emgr.createQuery("SELECT m FROM Marca m WHERE m.idmarca=0").getSingleResult();
        emgr.getTransaction().begin();

        for(Equipo eq: this.currentMarca.getEquipoCollection()){
            eq.setIdmarca(mGenerica);
            emgr.merge(eq);
       }        

        for(Accesorio acc: this.currentMarca.getAccesorioCollection()){
            acc.setIdmarca(mGenerica);
            emgr.merge(acc);
        }
       
        for(Pieza pz: this.currentMarca.getPiezaCollection()){
            pz.setIdmarca(mGenerica);
            emgr.merge(pz);
        }
        
        emgr.remove(this.currentMarca);
        emgr.getTransaction().commit();
        for(Marca m: this.listaMarcas){
            if(m.getIdmarca() == this.currentMarca.getIdmarca()){
                this.listaMarcas.remove(m);
                break;
            }
        }
        this.initItemsMarcas();
        this.currentMarca = new Marca();
        this.currentMarca.setAccesorioCollection(new ArrayList<Accesorio>());
        this.currentMarca.setEquipoCollection(new ArrayList<Equipo>());
        this.currentMarca.setPiezaCollection(new ArrayList<Pieza>());

        this.crdMarcas.hidePopupDel();
        this.msg.setText("Marca eliminada exitosamente");
        this.msg.setVisible(true);
        return "done";
    }

    public String addUbicacion(){
        EntityManager emgr = this.getEntityManager();
        emgr.getTransaction().begin();
        emgr.persist(this.currentUbicacion);
        emgr.getTransaction().commit();
        this.listaUbicaciones.add(currentUbicacion);
        this.initItemsUbicaciones();
        this.crdUbicaciones.hidePopupAdd();
        this.msg.setText("Nueva ubicación agregada exitosamente");
        this.msg.setVisible(true);
        this.currentUbicacion = new Ubicacion();
        return "done";
    }

    public String editUbicacion(){
        String idUbicacion = ((HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest()).getParameter("currentId");
        this.currentUbicacion = (Ubicacion)this.getEntityManager().createQuery("SELECT u FROM Ubicacion u WHERE u.idubicacion=" + idUbicacion).getSingleResult();
        this.crdUbicaciones.showPopupEdit();
        return "done";
    }

    public String commitEditUbicacion(){
        EntityManager emgr = this.getEntityManager();
        emgr.getTransaction().begin();
        emgr.merge(this.currentUbicacion);
        emgr.getTransaction().commit();

        for(Ubicacion u: this.listaUbicaciones){
            if(u.getIdubicacion() == this.currentUbicacion.getIdubicacion()){
                u.setNombre(this.currentUbicacion.getNombre());
                break;
            }
        }
        this.initItemsUbicaciones();
        this.crdUbicaciones.hidePopupEdit();
        this.msg.setText("Ubicación modificada satisfactoriamente");
        this.msg.setVisible(true);
        this.currentUbicacion = new Ubicacion();
        return "done";
    }

    public String delUbicacion(){
        EntityManager emgr = this.getEntityManager();
        this.currentUbicacion = (Ubicacion)emgr.createQuery("SELECT u FROM Ubicacion u WHERE u.idubicacion=" + this.crdUbicaciones.getCurrentId()).getSingleResult();
        Ubicacion uGenerica = (Ubicacion)emgr.createQuery("SELECT u FROM Ubicacion u WHERE u.idubicacion=0").getSingleResult();
        emgr.getTransaction().begin();
        for(Existencia exst: this.currentUbicacion.getExistenciaCollection()){
            exst.setIdubicacion(uGenerica);
            emgr.merge(exst);
        }

        for(Reserva rsrv: this.currentUbicacion.getReservaCollection()){
            rsrv.setIdubicacion(uGenerica);
            emgr.merge(rsrv);
        }

        this.currentUbicacion.getExistenciaCollection().clear();
        this.currentUbicacion.getReservaCollection().clear();
        emgr.getTransaction().commit();

        emgr.getTransaction().begin();
        emgr.remove(this.currentUbicacion);
        emgr.getTransaction().commit();

        for(Ubicacion u: this.listaUbicaciones){
            if(u.getIdubicacion() == this.currentUbicacion.getIdubicacion()){
                this.listaUbicaciones.remove(u);
                break;
            }
        }
        this.initItemsUbicaciones();

        this.crdUbicaciones.hidePopupDel();
        this.msg.setText("Ubicación eliminada satisfactoriamente");
        this.msg.setVisible(true);
        this.currentUbicacion = new Ubicacion();
        return "done";
    }

    /**
     * @return the listaEstadosExistencia
     */
    public List<Bitacoraestados> getListaEstadosExistencia() {
        return listaEstadosExistencia;
    }

    /**
     * @param listaEstadosExistencia the listaEstadosExistencia to set
     */
    public void setListaEstadosExistencia(List<Bitacoraestados> listaEstadosExistencia) {
        this.listaEstadosExistencia = listaEstadosExistencia;
    }

    /**
     * @return the popupMantenimientoVisible
     */
    public boolean getPopupMantenimientoVisible() {
        return popupMantenimientoVisible;
    }

    /**
     * @param popupMantenimientoVisible the popupMantenimientoVisible to set
     */
    public void setPopupMantenimientoVisible(boolean popupMantenimientoVisible) {
        this.popupMantenimientoVisible = popupMantenimientoVisible;
    }

    public String showPopupMantenimiento(){
        String idExistencia = ((HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest()).getParameter("currentId");        
        this.listaEstadosExistencia = this.getEntityManager().createQuery("SELECT b FROM Bitacoraestados b WHERE b.idequipoexistente.idexistencia=" + idExistencia).getResultList();
        this.currentExistencia = (Existencia)this.getEntityManager().createQuery("SELECT e FROM Existencia e WHERE e.idexistencia=" + idExistencia).getSingleResult();
        this.popupMantenimientoVisible = true;
        return "done";
    }

    public String hidePopupMantenimiento(){
        this.popupMantenimientoVisible = false;
        return "done";
    }

    public int getListaBitacoraEstadosSize(){
        if(this.listaEstadosExistencia != null)
            return this.listaEstadosExistencia.size();
        else
            return 0;
    }

    public String enviarSolicitudMantenimiento(){
        EntityManager emgr = this.getEntityManager();
        String idUsuario = ((HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest()).getParameter("idusr");
        Usuario usr = (Usuario)emgr.createQuery("SELECT u FROM Usuario u WHERE u.idusuario=" + idUsuario).getSingleResult();
        Estadoequipo estadoFallido = (Estadoequipo)emgr.createQuery("SELECT e FROM Estadoequipo e WHERE e.idestado=2").getSingleResult();
        Solicitud sol = new Solicitud();

        sol.setDescripcion(this.descripcionSolicitud);
        sol.setFecha(Calendar.getInstance().getTime());
        sol.setIdequipoexistente(this.currentExistencia);
        sol.setIdusuario(usr);
        sol.setPrioridad("ALTA");
        new BeanBaseJRequest().registrarSolicitud(sol);
        this.currentExistencia.setIdestado(estadoFallido);
        emgr.getTransaction().begin();
        emgr.merge(this.currentExistencia);
        emgr.getTransaction().commit();
        for(Existencia ext: this.getCurrentClasificacion().getExistenciaCollection()){
            if(ext.getIdexistencia() == this.currentExistencia.getIdexistencia()){
                ext.setIdestado(this.currentExistencia.getIdestado());
                break;
            }
        }
        this.listaEstadosExistencia = this.getEntityManager().createQuery("SELECT b FROM Bitacoraestados b WHERE b.idequipoexistente.idexistencia=" + this.currentExistencia.getIdexistencia()).getResultList();
        return "done";
    }

    /**
     * @return the descripcionSolicitud
     */
    public String getDescripcionSolicitud() {
        return descripcionSolicitud;
    }

    /**
     * @param descripcionSolicitud the descripcionSolicitud to set
     */
    public void setDescripcionSolicitud(String descripcionSolicitud) {
        this.descripcionSolicitud = descripcionSolicitud;
    }

    /**
     * @return the searchMode
     */
    public boolean isSearchMode() {
        return searchMode;
    }

    /**
     * @param searchMode the searchMode to set
     */
    public void setSearchMode(boolean searchMode) {
        this.searchMode = searchMode;
    }

    /**
     * @return the listaResultadosBusqueda
     */
    public List getListaResultadosBusqueda() {
        return listaResultadosBusqueda;
    }

    /**
     * @param listaResultadosBusqueda the listaResultadosBusqueda to set
     */
    public void setListaResultadosBusqueda(List listaResultadosBusqueda) {
        this.listaResultadosBusqueda = listaResultadosBusqueda;
    }
   
    public void actualizarAutocompletado(ValueChangeEvent event){
        this.valorBusqueda = event.getNewValue().toString().toUpperCase();
        if(valorBusqueda.equalsIgnoreCase("")){
            this.listaResultadosBusqueda.clear();
            return;
        }        
        List<SelectItem> listaItemsBusqueda = new ArrayList<SelectItem>();
        for(Equipo eq: this.listaTodosEquipos){
            for(Existencia ext: eq.getExistenciaCollection()){
                if(ext.getCodigo().toUpperCase().contains(this.valorBusqueda) ||
                        ext.getIdhardware().getNombre().toUpperCase().contains(this.valorBusqueda) ||
                        ext.getIdhardware().getIdmarca().getNombre().toUpperCase().contains(this.valorBusqueda) ||
                        ext.getIdhardware().getModelo().toUpperCase().contains(this.valorBusqueda)){
                    this.listaResultadosBusqueda.add(ext);
                    listaItemsBusqueda.add(new SelectItem("[" + ext.getIdexistencia() + "]" +  ext.getCodigo() + " - " + ext.getIdhardware().getNombre() + " " + ext.getIdhardware().getIdmarca().getNombre() + " " + ext.getIdhardware().getModelo()));
                }
            }
        }        
        this.listaResultadosBusqueda = listaItemsBusqueda;        
    }

    public void seleccionarExistencia(){
        try{            
            String idExistencia = this.valorBusqueda.substring(this.valorBusqueda.indexOf("[")+1, this.valorBusqueda.indexOf("]"));            
            Existencia current = (Existencia)this.getEntityManager().createQuery("SELECT e FROM Existencia e WHERE e.idexistencia=" + idExistencia).getSingleResult();

            this.getClasificaciontm().seleccionarNodo(current.getIdhardware().getIdclasificacion().getIdclasificacion().toString());
            this.setSearchMode(false);
            int currentPage = (int)Math.ceil(this.getCurrentClasificacion().getExistenciaCollection().indexOf(current) / 5);
            System.out.println("currentPage: " + currentPage);
            
            System.out.println("pageCount" + this.pgr.getPageCount());
            System.out.println("lastPage?" + this.pgr.isLastPage());            

            if(this.pgr.getPageIndex()  > currentPage){
                int diff = this.pgr.getPageIndex() - currentPage;
                for(int i=0; i<=diff; i++){
                    this.pgr.gotoPreviousPage();
                    System.out.println("Going to prev page...");
                    System.out.println("pageIndex: " + this.pgr.getPageIndex());
                }
            }
            else{
                int diff = currentPage - this.pgr.getPageIndex();
                for(int i=0; i<=diff; i++){
                    this.pgr.gotoNextPage();
                    System.out.println("Going to next page...");
                    System.out.println("pageIndex: " + this.pgr.getPageIndex());
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
    }

    /**
     * @return the valorBusqueda
     */
    public String getValorBusqueda() {
        return valorBusqueda;
    }

    /**
     * @param valorBusqueda the valorBusqueda to set
     */
    public void setValorBusqueda(String valorBusqueda) {
        this.valorBusqueda = valorBusqueda;
    }

    /**
     * @return the pgr
     */
    public DataPaginator getPgr() {
        return pgr;
    }

    /**
     * @param pgr the pgr to set
     */
    public void setPgr(DataPaginator pgr) {
        this.pgr = pgr;
    }

    /**
     * @return the listaNombresAtributos
     */
    public List getListaNombresAtributos() {
        return listaNombresAtributos;
    }

    /**
     * @param listaNombresAtributos the listaNombresAtributos to set
     */
    public void setListaNombresAtributos(List listaNombresAtributos) {
        this.listaNombresAtributos = listaNombresAtributos;
    }

}
