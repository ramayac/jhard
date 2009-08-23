/*
 * jrequestUser.java
 *
 * Created on 05-29-2009, 10:56:59 AM
 * Copyright ramayac
 */
package jhard;

import edu.ues.jhard.beans.BeanBaseJProcur;
import edu.ues.jhard.jhardmin.LoginManager;
import edu.ues.jhard.jpa.Comentarios;
import edu.ues.jhard.jpa.Entrada;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.FacesException;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;


/**
 * <p> Page Bean que corresponde a la pagina JSP de igual nombre.
 * Esta clase contiene la definicion e inicializacion para todos
 * los componentes que se usan en la pagina.
 * Este bean hereda su funcionalidad de autenticacion de BeanBaseJHard.
 * En este bean esta la logica para mostrar las entradas en el mini CMS de jhard.
 * </p>
 */
public class jprocurUser extends BeanBaseJHard {
    public static final String ART_ID = "artid";

    private Entrada entradaActual = null;
    private Comentarios comentarioNuevo = new Comentarios();
    private List<Entrada> listaEntradas = new ArrayList<Entrada>();
    private Boolean soloUna = new Boolean(false);
    private Boolean agregandoComentario = new Boolean(false);
    //private Integer indice = new Integer(0);

    private String criteriosBusqueda = EMPTY_STRING;
    
    private int __placeholder;
 
    private BeanBaseJProcur jprocurInstance = new BeanBaseJProcur();

    /**
     * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    private void _init() throws Exception {
    }

    // </editor-fold>

    public  BeanBaseJProcur getJProcurInstance() {
        return this.jprocurInstance;
    }

    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public jprocurUser() {
        lu= getJHardminInstance().getCurrentUser();

        if(lu!=null){
            U = LoginManager.getInstance().getUsuario(lu);
            this.lblUser.setValue((String)U.getNombre());
//            switch(U.getIdrol().getIdrol()){
//                case ROL_ADMINISTRADOR:
//                case ROL_EDITORCONTENIDO:
//                default:
//                    break;
//            }
        } else this.lblUser.setValue(INVITADO);

        String sId = ((HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest()).getParameter(ART_ID);
        //System.out.println("Articulo ID: "+ sId);
        if((sId == null) || (sId.isEmpty())){
            this.listaEntradas = this.getJProcurInstance().getAllEntradas();
            if(this.listaEntradas.size()>0) this.entradaActual = this.listaEntradas.get(0);
        } else {
            Integer id = new Integer(sId);
            this.entradaActual = this.getJProcurInstance().getEntrada(id);
            this.listaEntradas = new ArrayList<Entrada>();
            this.listaEntradas.add(entradaActual);
        }
        //this.listaEntradas = this.getJProcurInstance().getAllEntradas();
        //if(this.listaEntradas.size()>0) this.entradaActual = this.listaEntradas.get(0);
    }

    public String getCriteriosBusqueda() {
        return criteriosBusqueda;
    }

    public void setCriteriosBusqueda(String criteriosBusqueda) {
        this.criteriosBusqueda = criteriosBusqueda;
    }

    /**
     * <p>Callback method that is called whenever a page is navigated to,
     * either directly via a URL, or indirectly via page navigation.
     * Customize this method to acquire resources that will be needed
     * for event handlers and lifecycle methods, whether or not this
     * page is performing post back processing.</p>
     * 
     * <p>Note that, if the current request is a postback, the property
     * values of the components do <strong>not</strong> represent any
     * values submitted with this request.  Instead, they represent the
     * property values that were saved for this view when it was rendered.</p>
     */
    @Override
    public void init() {
        // Perform initializations inherited from our superclass
        super.init();
        // Perform application initialization that must complete
        // *before* managed components are initialized
        // TODO - add your own initialiation code here
            
        // <editor-fold defaultstate="collapsed" desc="Managed Component Initialization">
        // Initialize automatically managed components
        // *Note* - this logic should NOT be modified
        try {
            _init();
        } catch (Exception e) {
            log("jrequestUser Initialization Failure", e);
            throw e instanceof FacesException ? (FacesException) e: new FacesException(e);
        }
        
        // </editor-fold>
        // Perform application initialization that must complete
        // *after* managed components are initialized
        // TODO - add your own initialization code here
    }

    /**
     * <p>Callback method that is called after the component tree has been
     * restored, but before any event processing takes place.  This method
     * will <strong>only</strong> be called on a postback request that
     * is processing a form submit.  Customize this method to allocate
     * resources that will be required in your event handlers.</p>
     */
    @Override
    public void preprocess() {
    }

    /**
     * <p>Callback method that is called just before rendering takes place.
     * This method will <strong>only</strong> be called for the page that
     * will actually be rendered (and not, for example, on a page that
     * handled a postback and then navigated to a different page).  Customize
     * this method to allocate resources that will be required for rendering
     * this page.</p>
     */
    @Override
    public void prerender() {
    }

    /**
     * <p>Callback method that is called after rendering is completed for
     * this request, if <code>init()</code> was called (regardless of whether
     * or not this was the page that was actually rendered).  Customize this
     * method to release resources acquired in the <code>init()</code>,
     * <code>preprocess()</code>, or <code>prerender()</code> methods (or
     * acquired during execution of an event handler).</p>
     */
    @Override
    public void destroy() {
    }

    public List<Entrada> getListaEntradas() {
        return listaEntradas;
    }

    public void setListaEntradas(List<Entrada> listaEntradas) {
        this.listaEntradas = listaEntradas;
    }

    public Comentarios getComentarioNuevo() {
        return comentarioNuevo;
    }

    public void setComentarioNuevo(Comentarios comentarioNuevo) {
        this.comentarioNuevo = comentarioNuevo;
    }

    /**
     * Metodo para saber si se ve una o varias Entradas
     * @param varias
     */
    public Boolean getSoloUna() {
        return this.soloUna;
    }

    /**
     * Metodo para establecer si se ve una o varias Entradas
     * @param varias
     */
    public void setSoloUna(Boolean varias) {
        this.soloUna = varias;
    }

    /**
     * Metodo para obtener una entrada por su ID
     * @param identrada id de la entada que se desea
     * @return
     */
    public Entrada getEntradaActual() {
        return this.entradaActual;
    }

    /**
     * Metodo para obtener una entrada por su ID
     * @param identrada id de la entada que se desea
     * @return
     */
    public String elegirEntradaActual() {
        String idSeleccionado = ((HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest()).getParameter("idSeleccionado");
        Integer id = new Integer(idSeleccionado);
        //System.out.println(idSeleccionado);
        this.entradaActual = this.jprocurInstance.getEntrada(id.intValue());
        this.setSoloUna(true);
        return EMPTY_STRING;
    }

//    /**
//     * Metodo para obtener todos las Etiquetas asociados con la EntradaActual
//     * @param idEntrada
//     * @return
//     */
//    public List<Tag> getEtiquetas() {
//        List<TagEntrada> te = (List<TagEntrada>)this.entradaActual.getTagEntradaCollection();
//        List<Tag> tag = new ArrayList<Tag>();
//        for (TagEntrada tagEntrada : te) {
//            tag.add(tagEntrada.getIdtag());
//        }
//        return tag;
//    }

//    /**
//     * Metodo para obtener todos las Etiquetas como un VIL STRING asociados con la EntradaActual
//     * @param idEntrada
//     * @return
//     */
//    public String getEtiquetasString() {
//        List<TagEntrada> te = (List<TagEntrada>)this.entradaActual.getTagEntradaCollection();
//        String resultado = new String();
//        switch (te.size()){
//            case 0:
//                return "No hay Etiquetas asociadas.";
//            case 1:
//                resultado = te.get(0).getIdtag().getDescripcion() + ".";
//                break;
//            case 2:
//                resultado = te.get(0).getIdtag().getDescripcion() + ", " + te.get(1).getIdtag().getDescripcion() + ".";
//                break;
//            default: //para los > de 2.
//                for (TagEntrada tagEntrada : te)
//                    resultado += tagEntrada.getIdtag().getDescripcion() + " ";
//                break;
//        }
//        return resultado;
//    }

    /**
     * Metodo para obtener los comentarios de un objeto Entrada, sin consultar a la BD
     * @param e
     * @return
     */
    public List<Comentarios> getComentarios() {
        List<Comentarios> c = (List<Comentarios>)this.entradaActual.getComentariosCollection();
        return c;
    }

    public boolean getHayComentarios(){
        if(this.entradaActual.getComentariosCollection().size()==NONE) return false;
        return true;
    }

    public boolean getHayEntradas(){
        if(this.listaEntradas.size()==NONE) return false;
        return true;
    }

    public boolean getShowPagComentarios(){
        if(this.entradaActual.getComentariosCollection().size()>MAX_COMENTARIOS) return true;
        return false;
    }

    public boolean getShowPagEntradas(){
        if(this.listaEntradas.size()>MAX_ENTRADAS) return true;
        return false;
    }

    public boolean getPermisoBorrarComentario(){
        switch(this.getRolUsuarioConectado()){
            case -1:
                return false; //no hay informacion de usuario
            case ROL_ADMINISTRADOR:
            case ROL_EDITORCONTENIDO:
                return true; //tengo los permisos para borrar los comentarios POR MI ROL
            //default:
                //break;
        }
        return false;
    }

    public boolean getAgregandoUnComentario(){
        return this.agregandoComentario;
    }

    public String agregandoComentario(){
        this.agregandoComentario = true;
        return EMPTY_STRING;
    }

    public String agregarComentario(){
        this.comentarioNuevo.setFechahora(new Date());

        if(!this.getHayUsuarioLogueado()){
            if(this.comentarioNuevo.getFirma().isEmpty())
                this.comentarioNuevo.setFirma(INVITADO);
            this.comentarioNuevo.setAprobado(false);
        } else {
            this.comentarioNuevo.setFirma(this.getCurrentUserName());
            this.comentarioNuevo.setAprobado(true);
        }

        this.jprocurInstance.createComentario(entradaActual, comentarioNuevo);

        this.entradaActual = this.jprocurInstance.getEntrada(this.entradaActual.getIdentrada());
        
        this.comentarioNuevo = new Comentarios();
        this.agregandoComentario = false;
        return EMPTY_STRING;
    }

    public String busquedaEntradas(){
       this.listaEntradas = this.jprocurInstance.searchEntradaPorEtiqueta(this.criteriosBusqueda);
       return EMPTY_STRING;
    }

    public String eliminarComentario(){
        String idSel = ((HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest()).getParameter("idSelComent");
        //System.out.println("id comentario: " + idSel);
        Integer id = new Integer(idSel);
        this.jprocurInstance.deleteComentario(id);
        this.entradaActual.setComentariosCollection(this.jprocurInstance.getComentariosEntrada(entradaActual));
        return EMPTY_STRING;
    }
    
    /**
     * Metodo para establecer hacer toggle a la vista de entradas (Unica o Multiple)
     */
    public String toggleVista() {
        this.setSoloUna(false);
        this.agregandoComentario = false;
        return EMPTY_STRING;
    }
}
