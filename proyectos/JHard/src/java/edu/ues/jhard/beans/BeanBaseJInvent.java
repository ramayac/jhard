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
 * Backing bean con toda la funcionalidad de eventos y manejo de objetos persistentes para ser usados en la pagina jinvent.jspx
 * @author robertux
 */
public class BeanBaseJInvent extends BeanBase {

    /**
     * Modelo de arbol para mostrar en pantalla un treeView con la jerarquia de clasificaciones de elementos del inventario
     */
    private ClasificacionTreeModel clasificaciontm;
    /**
     * El equipo que esta actualmente siendo modificado o eliminado
     */
    private Equipo currentEquipo;
    /**
     * La existencia que esta actualmente siendo modificada o eliminada
     */
    private Existencia currentExistencia;
    /**
     * El software que esta actualmente siendo modificado o eliminado
     */
    private Software currentSoftware;
    /**
     * El accesorio que esta actualmente siendo modificado o eliminado
     */
    private Accesorio currentAccesorio;
    /**
     * Representa a una clasificacion que se agregara a la base de datos
     */
    private Clasificacion nuevaClasificacion;
    /**
     * La pieza que esta actualmente siendo modificada o eliminada
     */
    private Pieza currentPieza;
    /**
     * La marca que esta actualmente siendo modificada o eliminada
     */
    private Marca currentMarca;
    /**
     * La ubicacion que esta actualmente siendo modificada o eliminada
     */
    private Ubicacion currentUbicacion;
    /**
     * CrudManager para administrar la visibilidad y eventos de los popUps de agregar/modificar/eliminar equipos
     */
    private CrudManager crdEquipo;
    /**
     * CrudManager para administrar la visibilidad y eventos de los popUps de agregar/modificar/eliminar software
     */
    private CrudManager crdSoftware;
    /**
     * CrudManager para administrar la visibilidad y eventos de los popUps de agregar/modificar/eliminar piezas
     */
    private CrudManager crdPieza;
    /**
     * CrudManager para administrar la visibilidad y eventos de los popUps de agregar/modificar/eliminar accesorios
     */
    private CrudManager crdAccesorio;
    /**
     * CrudManager para administrar la visibilidad y eventos de los popUps de agregar/modificar/eliminar clasificaciones
     */
    private CrudManager crdClasificacion;
    /**
     * CrudManager para administrar la visibilidad y eventos de los popUps de agregar/modificar/eliminar existencias
     */
    private CrudManager crdExistencia;
    /**
     * CrudManager para administrar la visibilidad y eventos de los popUps de agregar/modificar/eliminar marcas
     */
    private CrudManager crdMarcas;
    /**
     * CrudManager para administrar la visibilidad y eventos de los popUps de agregar/modificar/eliminar ubicaciones
     */
    private CrudManager crdUbicaciones;
    /**
     * Lista de todas las marcas existentes en la base de datos
     */
    private List<Marca> listaMarcas;
    /**
     * Lista de todos los equipos existentes en la base de datos
     */
    private List<Equipo> listaTodosEquipos;
    /**
     * Lista de todos los accesorios existentes en la base de datos
     */
    private List<Accesorio> listaTodosAccesorios;
    /**
     * Lista de todas las piezas existentes en la base de datos
     */
    private List<Pieza> listaTodasPiezas;
    /**
     * Lista de todos los elementos de software existentes en la base de datos
     */
    private List<Software> listaTodosSoftware;
    /**
     * Lista de todos los posibles estados en los que se encuentra un equipo
     */
    private List<Estadoequipo> listaEstados;
    /**
     * Lista de todas las ubicaciones existentes en la base de datos
     */
    private List<Ubicacion> listaUbicaciones;
    /**
     * Lista de todas las bitacoras de estados pertenecientes a una existencia
     */
    private List<Bitacoraestados> listaEstadosExistencia;
    /**
     * Objeto que permite mostrar la lista de marcas en un comboBox
     */
    private SelectItemGroup listaItemsMarcas;
    /**
     * Objeto que permite mostrar la lista de equipos en un comboBox
     */
    private SelectItemGroup listaItemsEquipos;
    /**
     * Objeto que permite mostrar la lista de ubicaciones en un comboBox
     */
    private SelectItemGroup listaItemsUbicaciones;
    /**
     * Objeto que permite mostrar la lista de accesorios en un comboBox
     */
    private SelectItemGroup listaItemsAccesorios;
    /**
     * Objeto que permite mostrar la lista de piezas en un comboBox
     */
    private SelectItemGroup listaItemsPiezas;
    /**
     * Objeto que permite mostrar la lista de elementos de software en un comboBox
     */
    private SelectItemGroup listaItemsSoftware;
    /**
     * Lista que contiene los resultados de una busqueda de existencias, para mostrarlas en un autocompleteInputBox
     */
    private List listaResultadosBusqueda;
    /**
     * Lista que contiene los nombres que poseen todos los atributos de hardware existentes en el sistema
     */
    private List listaNombresAtributos;
    /**
     * Contiene el id de la marca seleccionada en un comboBox
     */
    private String marcaSelected;
    /**
     * Contiene el id de un estado (estadoEquipo) seleccionado en un comboBox
     */
    private String estadoSelected;
    /**
     * Contiene el id de un equipo seleccionado en un comboBox
     */
    private String equipoSelected;
    /**
     * Contiene el id de un accesorio seleccionado en un comboBox
     */
    private String accesorioSelected;
    /**
     * Contiene el id de una pieza seleccionada en un comboBox
     */
    private String piezaSelected;
    /**
     * Contiene el id de un software seleccionado en un comboBox
     */
    private String softwareSelected;
    /**
     * contiene el id de una ubicacion seleccionada en un comboBox
     */
    private String ubicacionSelected;
    /**
     * Valor booleano que define si un formulario de equipos esta siendo utilizado para agregar un nuevo equipo (false) o para editar un equipo existente (true)
     */
    private boolean existenciaEditMode;
    /**
     * Valor booleano que define si el popUp que muestra las opciones de mantenimiento para una existencia, esta visible o no
     */
    private boolean popupMantenimientoVisible;
    /**
     * Valor booleano que define si se esta en modo de busqueda (en el cual se muestra un cuadro de texto para buscar y seleccionar existencias) o en modo normal (en el cual se muestran los items, como existencias, accesorios, piezas, etc. pertenecientes a la clasificacion seleccionada en el treeView)
     */
    private boolean searchMode;
    /**
     * Almacena la descripcion de una solicitud de mantenimiento de existencia de inventario
     */
    private String descripcionSolicitud;
    /**
     * Representa la cadena de busqueda ingresada con un usuario
     */
    private String valorBusqueda;
    /**
     * Representa el mensaje a mostrar en popUps que aparecen al fallar las validaciones
     */
    private ActionMessage msg;
    /**
     * Representa al control paginador de la tabla de existencias
     */
    private DataPaginator pgr;
    /**
     * Representa la existencia seleccionada por el usuario como el resultado de la busqueda, luego que se le mostraran todas las existencias que coincidieran con los criterios que el ingresara
     */
    private Existencia searchResult;    

    /**
     * Crea una nueva instancia del bean BeanBaseJInvent, inicializando las entity beans, las listas y los selectItemGroup usados al momento de cargar la pagina asociada a este bean
     */
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
        this.pgr = new DataPaginator();
        this.pgr.setFor("tblListaExistencias");
        this.searchResult = new Existencia();
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

    /**
     * Evento que responde al click del raton sobre un elemento del treeView de clasificaciones. Este configura la clasificacion seteada como la currentClasificacion, al mismo tiempo que se actualizan las tablas de equipos, existencias, accesorios, software, etc. para mostrar los items asociados a esta nueva clasificacion seleccionada
     * @param event Evento que contiene metadatos de la accion realizada y el objeto sobre el cual se realizo la accion
     */
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

    /**
     * Devuelve la clasificacion actualmente seleccionada en el treeView de clasificaciones
     * @return la clasificacion actualmente seleccionada en el treeView de clasificaciones
     */
    public Clasificacion getCurrentClasificacion(){
        return this.getClasificaciontm().getCurrentUserObject().getClasificacion();
    }

    /**
     * Devuelve la cantidad de existencias que posee la clasificacion actual
     * @return la cantidad de existencias que posee la clasificacion actual
     */
    public int getCurrentClasificacionExistenciaCollectionSize(){
        try{
            return this.getCurrentClasificacion().getExistenciaCollection().size();
        }
        catch(Exception ex){
            //pass
        }
        return 0;
    }

    /**
     * Devuelve la cantidad de elementos de software que posee la clasificacion actual
     * @return la cantidad de elementos de software que posee la clasificacion actual
     */
    public int getCurrentClasificacionSoftwareCollectionSize(){
        try{
            return this.getCurrentClasificacion().getSoftwareCollection().size();
        }
        catch(Exception ex){
            //pass
        }
        return 0;
    }

    /**
     * Devuelve la cantidad de accesorios que posee la clasificacion actual
     * @return la cantidad de accesorios que posee la clasificacion actual
     */
    public int getCurrentClasificacionAccesorioCollectionSize(){
        try{
            return this.getCurrentClasificacion().getAccesorioCollection().size();
        }
        catch(Exception ex){
            //pass
        }
        return 0;
    }

    /**
     * Devuelve la cantidad de piezas que posee la clasificacion actual
     * @return la cantidad de piezas que posee la clasificacion actual
     */
    public int getCurrentClasificacionPiezaCollectionSize(){
        try{
            return this.getCurrentClasificacion().getPiezaCollection().size();
        }
        catch(Exception ex){
            //pass
        }
        return 0;
    }

    /**
     * Devuelve la cantidad de equipos que posee la clasificacion actual
     * @return la cantidad de equipos que posee la clasificacion actual
     */
    public int getSizeListaEquipos(){
        try{
            return this.getCurrentClasificacion().getEquipoCollection().size();
        }
        catch(Exception ex){
            return 0;
        }
    }

    /**
     * Devuelve la suma de todas las existencias asociadas a los equipos de la clasificacion actual
     * @return la suma de todas las existencias asociadas a los equipos de la clasificacion actual
     */
    public int getSizeListaExistencias(){
        int totalExistencias = 0;
        try{
            for(Equipo eq: this.getCurrentClasificacion().getEquipoCollection())
                totalExistencias += eq.getExistenciaSize();
        }
        catch(Exception ex){
            //pass
        }
        return totalExistencias;
    }

    /**
     * Devuelve la cantidad de elementos de software que posee la clasificacion actual
     * @return la cantidad de elementos de software que posee la clasificacion actual
     */
    public int getSizeListaSoftware(){
        try{
            return this.getCurrentClasificacion().getSoftwareCollection().size();
        }
        catch(Exception ex){
            return 0;
        }
    }

    /**
     * Devuelve la cantidad de accesorios que posee la clasificacion actual
     * @return la cantidad de accesorios que posee la clasificacion actual
     */
    public int getSizeListaAccesorios(){
        try{
            return this.getCurrentClasificacion().getAccesorioCollection().size();
        }
        catch(Exception ex){
            return 0;
        }
    }

    /**
     * Devuelve la cantidad de piezas que posee la clasificacion actual
     * @return la cantidad de piezas que posee la clasificacion actual
     */
    public int getSizeListaPiezas(){
        try{
            return this.getCurrentClasificacion().getPiezaCollection().size();
        }
        catch(Exception ex){
            return 0;
        }
    }

    /**
     * Devuelve la cantidad de marcas que posee la lista
     * @return la cantidad de marcas que posee la lista
     */
    public int getSizeListaMarcas(){
        return this.getListaMarcas().size();
    }

    /**
     * Devuelve la cantidad de ubicaciones que posee la lista
     * @return la cantidad de ubicaciones que posee la lista
     */
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

    /**
     * Inicializa el SelectItemGroup de accesorios en base a los que posee la listaTodosAccesorios
     */
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

    /**
     * Inicializa el SelectItemGroup de equipos en base a los que posee la listaTodosEquipos
     */
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

    /**
     * Inicializa el SelectItemGroup de marcas en base a las que posee la listaMarcas
     */
    private void initItemsMarcas() {
        this.setListaItemsMarcas(new SelectItemGroup());
       SelectItem[] items = new SelectItem[this.getListaMarcas().size()];
       for(int i=0; i<this.getListaMarcas().size(); i++){
           items[i] = new SelectItem(this.getListaMarcas().get(i).getIdmarca(), this.getListaMarcas().get(i).getNombre());
       }
        this.getListaItemsMarcas().setSelectItems(items);
    }

    /**
     * Inicializa el SelectItemGroup de piezas en base a las que posee la listaTodasPiezas
     */
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

    /**
     * Inicializa el SelectItemGroup de elementos de software en base a los que posee la listaTodosSoftware
     */
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

    /**
     * Inicializa el SelectItemGroup de ubicaciones en base a las que posee la listaUbicaciones
     */
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

    /**
     * Inicializa la lista de atributos de hardware
     */
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

    /**
     * Agrega una nueva existencia a la base de datos
     * @return "done" si la operacion fue exitosa
     */
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
        emgr.getTransaction().commit();

        emgr.getTransaction().begin();
        emgr.refresh(this.currentExistencia);
        emgr.getTransaction().commit();

        emgr.getTransaction().begin();        
        //this.currentExistencia = (Existencia)emgr.createQuery("SELECT e1 FROM Existencia e1 WHERE e1.idexistencia = (SELECT max(e2.idexistencia) FROM Existencia e2)").getSingleResult();
        emgr.merge(this.currentExistencia.getIdhardware());
        for(Accesorio acc: this.currentExistencia.getAccesorioCollection()){
            acc.setIdexistencia(currentExistencia);
            emgr.merge(acc);
        }
        
        for(Instalacion inst: this.currentExistencia.getInstalacionCollection()){
            inst.setIdequipoexistente(currentExistencia);
            emgr.persist(inst);
        }
        
        for(Pieza pz: this.currentExistencia.getPiezaCollection()){
            pz.setIdexistencia(currentExistencia);
            emgr.merge(pz);
        }

        emgr.merge(this.currentExistencia);
        emgr.getTransaction().commit();

        for(Equipo eqEnClasificacion: this.getCurrentClasificacion().getEquipoCollection()){
            if(eqEnClasificacion.getIdequipo() == eq.getIdequipo()){
                eqEnClasificacion.getExistenciaCollection().add(this.currentExistencia);
                this.actualizarCurrentNodoClasificacion();
                break;
            }
        }
        Clasificacion currentNew = (Clasificacion)this.getEntityManager().createQuery("SELECT c FROM Clasificacion c WHERE c.idclasificacion=" + this.currentExistencia.getIdhardware().getIdclasificacion().getIdclasificacion()).getSingleResult();
        this.clasificaciontm.actualizarNodo(currentNew);
        this.clasificaciontm.seleccionarNodo(currentNew.getIdclasificacion().toString());
        this.crdExistencia.hidePopupAdd();
        this.msg.setText("Existencia " + this.currentExistencia.getCodigo() + " agregada exitosamente");
        this.msg.setVisible(true);
        this.currentExistencia = new Existencia();
        this.actualizarCurrentNodoClasificacion();
        return "done";
    }

    /**
     * Cierra el popUp de agregar/editar existencia, inicializando las variables utilizadas en dicha pantalla
     * @return "done" si la operacion fue exitosa
     */
    public String cancelAddEditExistencia(){
        this.currentExistencia = new Existencia();
        this.crdExistencia.hidePopupAdd();
        this.crdExistencia.hidePopupEdit();
        return "done";
    }

    /**
     * Guarda los cambios realizados en la edicion de una existencia
     * @return "done" si la operacion fue exitosa
     */
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

    /**
     * Inicializa la variable currentEquipo y muestra el popUp de agregar equipos
     * @return
     */
    public String beforeAddEquipo(){        
        this.currentEquipo = new Equipo();
        this.crdEquipo.showPopupAdd();
        return "done";
    }

    /**
     * Agrega un nuevo equipo a la base de datos
     * @return "done" si la operacion fue exitosa
     */
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

    /**
     * Cierra el popUp de agregar/editar equipo, inicializando las variables usadas en esta pantalla
     * @return "done" si la operacion fue exitosa
     */
    public String cancelAddEditEquipo(){
        this.currentEquipo = new Equipo();
        this.crdEquipo.hidePopupAdd();
        this.crdEquipo.hidePopupEdit();
        return "done";
    }

    /**
     * Muestra el popUp de eidtar equipos, junto con los datos del equipo actual
     * @return "done" si la operacion fue exitosa
     */
    public String editEquipo(){
        String idEquipo = ((HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest()).getParameter("currentId");
        this.currentEquipo = (Equipo)this.getEntityManager().createQuery("SELECT e FROM Equipo e WHERE e.idequipo=" + idEquipo).getSingleResult();
        this.setMarcaSelected(this.currentEquipo.getIdmarca().getIdmarca().toString());
        this.crdEquipo.showPopupEdit();
        return "done";
    }

    /**
     * Guarda los cambios hechos sobre el equipo que se estaba editando actualmente
     * @return "done" si la operacion fue exitosa
     */
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

    /**
     * Elimina el equipo actualmente seleccionado
     * @return "done" si la operacion fue exitosa
     */
    public String delEquipo(){
        String idEquipo = this.crdEquipo.getCurrentId();
        EntityManager emgr = this.getEntityManager();
        Equipo eq = (Equipo)emgr.createQuery("SELECT e FROM Equipo e WHERE e.idequipo=" + idEquipo).getSingleResult();
        emgr.getTransaction().begin();
        emgr.remove(eq);
        emgr.getTransaction().commit();
        this.crdEquipo.hidePopupDel();
        this.getCurrentClasificacion().getEquipoCollection().remove(eq);
        this.listaTodosEquipos = this.getEntityManager().createNamedQuery("Equipo.findAll").getResultList();
        this.msg.setText("Equipo " + eq.getNombre() + " eliminado satisfactoriamente.");
        this.msg.setVisible(true);
        this.actualizarCurrentNodoClasificacion();
        return "done";
    }

    /**
     * Agrega un nuevo elemento de software a la base de datos
     * @return "done" si la operacion fue exitosa
     */
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

    /**
     * Esconde el popUp de agregar/editar software, inicializando las variables utilizadas en esta pantalla
     * @return "done" si la operacion fue exitosa
     */
    public String cancelAddEditSoftware(){
        this.currentSoftware = new Software();
        this.crdSoftware.hidePopupAdd();
        this.crdSoftware.hidePopupEdit();
        return "done";
    }

    /**
     * Muestra el popUp de editar software, junto con los datos del software actualmente seleccionado
     * @return "done" si la operacion fue exitosa
     */
    public String editSoftware(){
        String idSoftware = ((HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest()).getParameter("currentId");        
        Software soft = (Software)this.getEntityManager().createQuery("SELECT s FROM Software s WHERE s.idsoftware=" + idSoftware).getSingleResult();
        this.currentSoftware = soft;
        this.crdSoftware.setCurrentId(idSoftware);
        this.crdSoftware.showPopupEdit();
        return "done";
    }

    /**
     * Guarda los cambios realizados sobre el software que actualmente se estaba editando
     * @return "done" si la operacion fue exitosa
     */
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

    /**
     * Elimina de la base de datos el software actualmente seleccionado
     * @return "done" si la operacion fue exitosa
     */
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

    /**
     * Agrega un nuevo accesorio a la base de datos
     * @return "done" si la operacion fue exitosa
     */
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

    /**
     * Esconde el popUp de agregar/editar accesorio e inicializa las variables usadas en esta pantalla
     * @return "done" si la operacion fue exitosa
     */
    public String cancelAddEditAccesorio(){
        this.currentAccesorio = new Accesorio();
        this.crdAccesorio.hidePopupAdd();
        this.crdAccesorio.hidePopupEdit();
        return "done";
    }

    /**
     * Muestra el popUp de editar accesorio, rellenando los campos con los datos del accesorio actualmente seleccionado
     * @return "done" si la operacion fue exitosa
     */
    public String editAccesorio(){
        String idAccesorio = ((HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest()).getParameter("currentId");
        Accesorio acc = (Accesorio)this.getEntityManager().createQuery("SELECT a FROM Accesorio a WHERE a.idaccesorio=" + idAccesorio).getSingleResult();
        this.crdAccesorio.setCurrentId(idAccesorio);
        this.setCurrentAccesorio(acc);
        this.setMarcaSelected(acc.getIdmarca().getIdmarca().toString());
        this.crdAccesorio.showPopupEdit();
        return "done";
    }

    /**
     * Guarda los cambios del accesorio que estaba siendo editado y esconde el popUp de editar accesorio
     * @return "done" si la operacion fue exitosa
     */
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

    /**
     *  Elimina de la base de datos el accesorio actual
     * @return "done" si la operacion fue exitosa
     */
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

    /**
     * Agrega una nueva pieza a la base de datos
     * @return "done" si la operacion fue exitosa
     */
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

    /**
     * Esconde el popUp de agregar piezas y luego inicializa las variables utilizadas en esta pantalla
     * @return "done" si la operacion fue exitosa
     */
    public String cancelAddEditPieza(){
        this.currentPieza = new Pieza();
        this.crdPieza.hidePopupAdd();
        this.crdPieza.hidePopupEdit();
        return "done";
    }

    /**
     * Muestra el popUp para editar piezas, rellenando los campos con los datos de la pieza actualmente seleccionada
     * @return "done" si la operacion fue exitosa
     */
    public String editPieza(){
        String idPieza = ((HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest()).getParameter("currentId");
        Pieza pz = (Pieza)this.getEntityManager().createQuery("SELECT p FROM Pieza p WHERE p.idpieza=" + idPieza).getSingleResult();
        this.setCurrentPieza(pz);
        this.crdPieza.setCurrentId(idPieza);
        this.setMarcaSelected(pz.getIdmarca().toString());
        this.crdPieza.showPopupEdit();
        return "done";
    }

    /**
     * Guarda los cambios de la pieza que se estaba editando
     * @return "done" si la operacion fue exitosa
     */
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

    /**
     * Elimina de la base de datos la pieza actual
     * @return "done" si la operacion fue exitosa
     */
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

    /**
     * Agrega una nueva clasificacion a la base de datos
     * @return "done" si la operacion fue exitosa
     */
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

    /**
     * Muestra el popUp de editar clasificaciones, con los campos de la clasificacion actual
     * @return "done" si la clasificacion actual es modificable(es una de las clasificaciones default) o "fail" en caso contrario (es una clasificacion agregada por un usuario)
     */
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

    /**
     * Guarda los cambios realizados en la edicion de la clasificacion actual
     * @return "done" si la operacion fue exitosa
     */
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

    /**
     * Muestra el popUp de confirmacion para la eliminacion de una clasificacion
     * @return "done" si la clasificacion es eliminable (pertenece a las clasificaciones default) o "fail" en caso contrario (es una clasificaciona agregada por un usuario)
     */
    public String beforeShowPopupDelClasificacion(){
        if(!this.getCurrentClasificacionIsEditable()){
            this.msg.setText("No se puede eliminar esta clasificación. Solamente se pueden eliminar las clasificaciones de color azul.");
            this.msg.setVisible(true);
            return "fail";
        }
        this.crdClasificacion.showPopupDel();
        return "done";
    }

    /**
     * Elimina de la base de datos la clasificacion actual
     * @return "done" si la operacion fue exitosa o "fail" en caso que la clasificacion actual posea asociadas clasificaciones hijas
     */
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

    /**
     * Actualiza el nombre y la descripcion (cantidad de elementos asociados) de la clasificacion actualmente seleccionada
     */
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

    /**
     * Define si la clasificacion actualmente seleccionada es editable, esto lo define en base a su id. JHard trae por defecto 16 clasificaciones para formar la estructura basica de clasificaciones del inventario. El resto de clasificaciones que se agreguen si podran editarse y eliminarse.
     * @return True si se determina que la clasificacion es editable o False en caso contrario
     */
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

    /**
     * Metodo facade que inicializa todas las listas e invoca a los metodos initItemsXXX de cada una de ellas, para inicializar tambien los comboBox en los que se utilizan
     */
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

    /**
     * Muestra el popUp de agregar existencia, inicializando las variables que se muestran en esta pantalla
     * @return "done" si la operacion fue exitosa
     */
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

    /**
     * Guarda los cambios realizados la existencia que se estaba modificando
     * @return "done" si la operacion fue exitosa
     */
    public String editExistencia(){
        String idExistencia = ((HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest()).getParameter("currentId");
        System.out.println("idExistencia: " + idExistencia);
        this.currentExistencia = (Existencia)this.getEntityManager().createQuery("SELECT e FROM Existencia e WHERE e.idexistencia=" + idExistencia).getSingleResult();
        this.initItemsCombos();
        this.equipoSelected = this.currentExistencia.getIdhardware().getIdequipo().toString();
        this.ubicacionSelected = this.currentExistencia.getIdubicacion().getIdubicacion().toString();
        
        this.existenciaEditMode = true;
        this.crdExistencia.showPopupEdit();
        return "done";
    }

    /**
     * Agrega una nueva asociacion (instalacion) entre el software seleccionado en el comboBox de elementos de software y la existencia actual que se esta creando/editando
     * @return "done" si la operacion fue exitosa
     */
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

    /**
     * Elimina una asociacion (instalacion) entre un elemento de software y la existencia actual
     * @return "done" si la operacion fue exitosa
     */
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

    /**
     * Agrega una asociacion entre el accesorio seleccionado en el comboBox de accesorios y la existencia que actualmente se esta creando/editando
     * @return "done" si la operacion fue exitosa
     */
    public String agregarAccesorioExistencia(){
        Accesorio acc = (Accesorio)this.getEntityManager().createQuery("SELECT a FROM Accesorio a WHERE a.idaccesorio=" + this.accesorioSelected).getSingleResult();
        acc.setIdexistencia(this.currentExistencia);
        this.currentExistencia.getAccesorioCollection().add(acc);
        this.listaTodosAccesorios.remove(acc);
        this.initItemsAccesorios();
        return "done";
    }

    /**
     * Elimina una asociacion creada entre una pieza y la existencia actual
     * @return "done" si la operacion fue exitosa
     */
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

    /**
     * Agrega una asociacion entre la pieza seleccionada en el comboBox de piezas y la existencia que actualmente se esta creando/editando
     * @return "done" si la operacion fue exitosa
     */
    public String agregarPiezaExistencia(){
        Pieza pz = (Pieza)this.getEntityManager().createQuery("SELECT p FROM Pieza p WHERE p.idpieza=" + this.piezaSelected).getSingleResult();
        pz.setIdexistencia(this.currentExistencia);
        this.currentExistencia.getPiezaCollection().add(pz);
        this.listaTodasPiezas.remove(pz);
        this.initItemsPiezas();
        return "done";
    }

    /**
     * Elimina una asociacion entre una pieza y la existencia actual
     * @return "done" si la operacion fue exitosa
     */
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

    /**
     * Elimina de la base de datos la existencia actual
     * @return "done" si la operacion fue exitosa
     */
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

    /**
     * Devuelve la cantidad de accesorios en la listaTodosAccesorios
     * @return la cantidad de accesorios de la listaTodosAccesorios
     */
    public int getListaTodosAccesoriosSize(){
        return this.listaTodosAccesorios.size();
    }

    /**
     * Devuelve la cantidad de piezas en la listaTodasPiezas
     * @return la cantidad de piezas en la listaTodasPiezas
     */
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

    /**
     * Agrega una nueva marca a la base de datos
     * @return "done" si la operacion fue exitosa
     */
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

    /**
     * Muestra el popUp de editar marca, rellenando los campos con los datos de la marca actualmente seleccionada
     * @return "done" si la operacion fue exitosa
     */
    public String editMarca(){
        String idMarca = ((HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest()).getParameter("currentId");
        this.currentMarca = (Marca)this.getEntityManager().createQuery("SELECT m FROM Marca m WHERE m.idmarca=" + idMarca).getSingleResult();
        this.crdMarcas.showPopupEdit();
        return "done";
    }

    /**
     * Guarda los cambios de la marca que estaba siendo editada
     * @return "done" si la operacion fue exitosa
     */
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

    /**
     * Elimina de la base de datos la marca actual
     * @return "done" si la operacion fue exitosa
     */
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

    /**
     * Agrega una nueva ubicacion a la base de datos
     * @return "done" si la operacion fue exitosa
     */
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

    /**
     * Muestra el popUp de editar ubicacion, rellena con los datos de la ubicacion actualmente seleccionada
     * @return "done" si la operacion fue exitosa
     */
    public String editUbicacion(){
        String idUbicacion = ((HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest()).getParameter("currentId");
        this.currentUbicacion = (Ubicacion)this.getEntityManager().createQuery("SELECT u FROM Ubicacion u WHERE u.idubicacion=" + idUbicacion).getSingleResult();
        this.crdUbicaciones.showPopupEdit();
        return "done";
    }

    /**
     * Guarda los cambios de la ubicacion que se estaba editando
     * @return "done" si la operacion fue exitosa
     */
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

    /**
     * Elimina de la base de datos la ubicacion seleccionada
     * @return "done" si la operacion fue exitosa
     */
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

    /**
     * Muestra el popUp con informacion referente al estado actual del equipo y la bitacora de cambios de estado. En caso que el estado sea 'En buenas condiciones', muestra el vínculo para enviar solicitud de mantenimiento, ingresando tambien una descripcion de la falla
     * @return "done" si la operacion fue exitosa
     */
    public String showPopupMantenimiento(){
        String idExistencia = ((HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest()).getParameter("currentId");        
        this.listaEstadosExistencia = this.getEntityManager().createQuery("SELECT b FROM Bitacoraestados b WHERE b.idequipoexistente.idexistencia=" + idExistencia).getResultList();
        this.currentExistencia = (Existencia)this.getEntityManager().createQuery("SELECT e FROM Existencia e WHERE e.idexistencia=" + idExistencia).getSingleResult();
        this.popupMantenimientoVisible = true;
        return "done";
    }

    /**
     * Esconde el popUp de mantenimiento
     * @return "done" si la operacion fue exitosa
     */
    public String hidePopupMantenimiento(){
        this.popupMantenimientoVisible = false;
        return "done";
    }

    /**
     * Devuelve la cantidad de bitacoras de cambios de estado que posee la existencia actual
     * @return la cantidad de bitacoras de cambios de estado que posee la existencia actual
     */
    public int getListaBitacoraEstadosSize(){
        if(this.listaEstadosExistencia != null)
            return this.listaEstadosExistencia.size();
        else
            return 0;
    }

    /**
     * Genera una nuevao solicitud de mantenimiento de la existencia actualmente seleccionada, adicionando el usuario que la genero y una descripcion de la falla
     * @return "done" si la operacion fue exitosa
     */
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

    /**
     * Actualiza la lista de resultados de la busqueda que se muestran en control autocompleteInputBox, segun los criterios de busqueda que ha ingresado el usuario en esta caja de texto
     * @param event Evento que contiene metadatos de la accion realizada por el usuario y el objeto sobre el cual se realizo la accion
     */
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

    /**
     * Al seleccionar una existencia del autocomplete, segun los parametros de la busqueda, cambia a searchMode = false, seleccionando la clasificacion donde se encuentra la clasificacion asociada con la existencia encontrada y ademas, se mueve hasta la pagina donde aparece dicha existencia mostrandosela asi al usuario
     */
    public void seleccionarExistencia(){
        try{            
            String idExistencia = this.valorBusqueda.substring(this.valorBusqueda.indexOf("[")+1, this.valorBusqueda.indexOf("]"));            
            this.searchResult = (Existencia)this.getEntityManager().createQuery("SELECT e FROM Existencia e WHERE e.idexistencia=" + idExistencia).getSingleResult();

            this.getClasificaciontm().seleccionarNodo(this.searchResult.getIdhardware().getIdclasificacion().getIdclasificacion().toString());            
            int currentPage = (int)Math.ceil(this.getCurrentClasificacion().getExistenciaCollection().indexOf(this.searchResult) / 5) + 1;            
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

    /**
     * Selecciona la pagina del paginador donde aparece la existencia actual, luego de haberla buscado en el sistema de busquedas
     * @return "done" si la operacion fue exitosa
     */
    public String selectPage(){
        int currentPage = (int)Math.ceil(this.getCurrentClasificacion().getExistenciaCollection().indexOf(this.searchResult) / 5) + 1;
        this.setSearchMode(false);                

        if(this.pgr.getPageIndex()  > currentPage){
            int diff = this.pgr.getPageIndex() - currentPage;
            for(int i=1; i<=diff; i++){
                this.pgr.gotoPreviousPage();                
            }
        }
        else{
            int diff = currentPage - this.pgr.getPageIndex();
            for(int i=1; i<=diff; i++){
                this.pgr.gotoNextPage();                
            }
        }
        return "done";
    }
   
}
