/*
 * jrequestUser.java
 *
 * Created on 05-29-2009, 10:56:59 AM
 * Copyright ramayac
 */
package jhard;

import edu.ues.jhard.beans.BeanBaseJWiki;
import edu.ues.jhard.jhardmin.LoginManager;
import edu.ues.jhard.jpa.Articulos;
import java.util.ArrayList;
import java.util.List;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.faces.FacesException;

/**
 * <p> Page Bean que corresponde a la pagina JSP de igual nombre.
 * Esta clase contiene la definicion e inicializacion para todos
 * los componentes que se usan en la pagina.
 * Este bean hereda su funcionalidad de autenticacion de BeanBaseJHard.
 * En este bean esta la logica para mostrar los articulos en el Wiki.
 * </p>
 */
public class jwikiUser extends BeanBaseJHard {
    public static final String WIKI_ID = "wkid";
    static final int MAX_COMENTARIOS = 10;
    static final int MAX_ENTRADAS = 5;

    private Articulos articuloActual = null;

    private List<Articulos> listaArticulos = new ArrayList<Articulos>();
    private Boolean soloUna = new Boolean(false);

    private String criteriosBusqueda = EMPTY_STRING;
    
    private int __placeholder;

    private BeanBaseJWiki jwikiInstance = new BeanBaseJWiki();

    /**
     * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    private void _init() throws Exception {
    }

    public  BeanBaseJWiki getJWikiInstance() {
        return this.jwikiInstance;
    }

    public Articulos getArticuloActual() {
        return articuloActual;
    }

    public void setArticuloActual(Articulos articuloActual) {
        this.articuloActual = articuloActual;
    }

    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public jwikiUser() {
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

        String wikiId = ((HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest()).getParameter(WIKI_ID);
        //System.out.println("Wiki ID: "+ wikiId);
        if((wikiId == null) || (wikiId.isEmpty())){
            this.listaArticulos = this.getJWikiInstance().getAllArticulos();
            if(this.listaArticulos.size()>0) this.articuloActual = this.listaArticulos.get(0);
        } else {
            Integer wkid = new Integer(wikiId);
            this.articuloActual = this.getJWikiInstance().getArticulo(wkid);
            this.listaArticulos = new ArrayList<Articulos>();
            this.listaArticulos.add(articuloActual);//hack
            //this.setSoloUna(true);
        }
    }

    public String getCriteriosBusqueda() {
        return criteriosBusqueda;
    }

    public void setCriteriosBusqueda(String criteriosBusqueda) {
        this.criteriosBusqueda = criteriosBusqueda;
    }

    public List<Articulos> getListaArticulos() {
        return this.listaArticulos;
    }

    public void setListaArticulos(List<Articulos> listaArticulos) {
        this.listaArticulos = listaArticulos;
    }

    /**
     * Metodo para saber si se ve una o varias Articulos
     * @param varias
     */
    public Boolean getSoloUna() {
        return this.soloUna;
    }

    /**
     * Metodo para establecer si se ve una o varias Articulos
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
    public String elegirArticuloActual() {
        String idSeleccionado = ((HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest()).getParameter("idSeleccionado");
        Integer id = new Integer(idSeleccionado);
        this.articuloActual = this.jwikiInstance.getArticulo(id.intValue());
        this.setSoloUna(true);
        return EMPTY_STRING;
    }

    public boolean getHayArticulos(){
        if(this.listaArticulos==null) return false;
        if(this.listaArticulos.size()==NONE) return false;
        return true;
    }

    public boolean getShowPagArticulos(){
        if(this.listaArticulos==null) return false;
        if(this.listaArticulos.size()>MAX_ENTRADAS) return true;
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

    public String busquedaArticulos(){
       //TODO: convertir esto en filtrado real...
       this.criteriosBusqueda = criteriosBusqueda.replaceAll("'", EMPTY_STRING);
       this.criteriosBusqueda = criteriosBusqueda.replaceAll("\"", EMPTY_STRING);
       this.articuloActual = new Articulos();
       this.listaArticulos.clear();
       this.listaArticulos = this.jwikiInstance.searchPalabrasEnArticulo(criteriosBusqueda);
       //if(!this.listaArticulos.isEmpty()) this.articuloActual = this.listaArticulos.get(0);
       //else this.articuloActual = new Articulos();
       return EMPTY_STRING;
    }

    /**
     * Metodo para establecer hacer toggle a la vista de entradas (Unica o Multiple)
     */
    public String toggleVista() {
        this.setSoloUna(false);
        return EMPTY_STRING;
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
    public void init() {
        // Perform initializations inherited from our superclass
        super.init();
// Perform application initialization that must complete
        // *before* managed components are initialized
        // TODO - add your own initialiation code here
// <editor-fold defaultstate="collapsed" desc="Visual-Web-managed Component Initialization">
// Initialize automatically managed components
        // *Note* - this logic should NOT be modified
        try {
            _init();
        } catch (Exception e) {
            log("Page1 Initialization Failure", e);
            throw e instanceof FacesException ? (FacesException) e : new FacesException(e);
        }
    }

    /**
     * <p>Callback method that is called after the component tree has been
     * restored, but before any event processing takes place.  This method
     * will <strong>only</strong> be called on a postback request that
     * is processing a form submit.  Customize this method to allocate
     * resources that will be required in your event handlers.</p>
     */
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
    public void destroy() {
    }
}
