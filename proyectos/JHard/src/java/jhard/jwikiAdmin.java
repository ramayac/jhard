/*
 * jrequestUser.java
 *
 * Created on 05-29-2009, 10:56:59 AM
 * Copyright ramayac
 */
package jhard;

import com.icesoft.faces.component.ext.HtmlOutputLabel;
import com.icesoft.faces.component.ext.HtmlOutputText;
import com.sun.rave.web.ui.appbase.AbstractPageBean;
import edu.ues.jhard.beans.BeanBaseJHardmin;
import edu.ues.jhard.beans.BeanBaseJWiki;
import edu.ues.jhard.jhardmin.LoggedUser;
import edu.ues.jhard.jhardmin.LoginManager;
import edu.ues.jhard.jpa.Articulos;
import edu.ues.jhard.jpa.Usuario;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;
import javax.faces.FacesException;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;


/**
 * <p>Page bean that corresponds to a similarly named JSP page.  This
 * class contains component definitions (and initialization code) for
 * all components that you have defined on this page, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 */
public class jwikiAdmin extends AbstractPageBean {
    static final String INVITADO = "Invitado";
    static final int MAX_ARTICULOS = 30;
    static final int MAX_COMENTARIOS = 30;
    static final String EMPTY_STRING = new String();
    static final int ROL_EDITORCONTENIDO = 4;
    static final int ROL_ADMINISTRADOR = 1;

    private Integer tabIndex = new Integer(0);

    private int __placeholder;

    private HtmlOutputLabel lblUser = new HtmlOutputLabel();

    public HtmlOutputLabel getLblUser() {
        return lblUser;
    }

    public void setLblUser(HtmlOutputLabel hol) {
        this.lblUser = hol;
    }

    /**
     * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    private void _init() throws Exception {
    }

    // </editor-fold>

    private LoggedUser lu;
    private Usuario U;

    public LoggedUser getLu() {
        return this.lu;
    }

    //what the fuck?
//    public void setLu(LoggedUser lu) {
//        this.lu = lu;
//    }

    public Usuario getUser(){
        return this.U;
    }

    public String getCurrentUserName(){
        if(this.lu == null) return INVITADO;
        if(this.U == null) return INVITADO;
        this.lu= getJHardminInstance().getCurrentUser();
        if(this.lu == null) {
            this.U = null;
            return INVITADO;
        } else {
            this.U = LoginManager.getInstance().getUsuario(this.lu);
        }
        return this.U.getNombre();
    }


//    public void setU(Usuario u){
//        this.U=u;
//    }

    public  BeanBaseJHardmin getJHardminInstance() {
        return (BeanBaseJHardmin) getBean("JHardminInstance");
    }

    private BeanBaseJWiki jwikiInstance = new BeanBaseJWiki(); //sera mejor como jWikiInstance en el faces-config? revisar el rednimiento.

    public  BeanBaseJWiki getjwikiInstance() {
        return this.jwikiInstance;
    }

    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public jwikiAdmin() {

        this.lu= getJHardminInstance().getCurrentUser();
        
        this.listaArticulos = this.getjwikiInstance().getAllArticulos();
        if(this.listaArticulos.size()>0) this.articuloActual = this.listaArticulos.get(0);
        
        if(this.lu!=null){
            this.U = LoginManager.getInstance().getUsuario(lu);
            this.lblUser.setValue(U.getNombre());

            switch(this.U.getIdrol().getIdrol()){
                case ROL_ADMINISTRADOR:
                case ROL_EDITORCONTENIDO:
                default:
                    break;
                }
        }else
            this.lblUser.setValue(INVITADO);
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

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected SessionBean1 getSessionBean1() {
        return (SessionBean1) getBean("SessionBean1");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected RequestBean1 getRequestBean1() {
        return (RequestBean1) getBean("RequestBean1");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected ApplicationBean1 getApplicationBean1() {
        return (ApplicationBean1) getBean("ApplicationBean1");
    }

    /*----------------------------------------------------------------------------------*/

    private Articulos articuloActual = null;
    private Articulos articuloNuevo = new Articulos();
    private List<Articulos> listaArticulos = new ArrayList<Articulos>();
    private Integer idArticuloEliminar = new Integer(-1);

    //private Comentarios comentarioActual = null;
    private Boolean editandoArticulo = new Boolean(false);
    private Boolean popupElimArticulo = new Boolean(false);
    private Boolean showPPMesaje = new Boolean(false);

    private HtmlOutputText lblMensajesArticulos = new HtmlOutputText();
    private HtmlOutputText lblPPMesajes = new HtmlOutputText();

    public HtmlOutputText getLblPPMesajes() {
        return lblPPMesajes;
    }

    public void setLblPPMesajes(HtmlOutputText lblPPMesajes) {
        this.lblPPMesajes = lblPPMesajes;
    }

    public Boolean getShowPPMesaje() {
        return showPPMesaje;
    }

    public void setShowPPMesaje(Boolean showPPMesaje) {
        this.showPPMesaje = showPPMesaje;
    }
    
    public Articulos getArticuloActual() {
        return articuloActual;
    }

    public void setArticuloActual(Articulos articuloActual) {
        this.articuloActual = articuloActual;
    }

    public Articulos getArticuloNuevo() {
        return articuloNuevo;
    }

    public void setArticuloNuevo(Articulos articuloNuevo) {
        this.articuloNuevo = articuloNuevo;
    }

    public Boolean getEditandoArticulo() {
        return editandoArticulo;
    }

    public void setEditandoArticulo(Boolean editandoArticulo) {
        this.editandoArticulo = editandoArticulo;
    }

    public BeanBaseJWiki getJwikiInstance() {
        return jwikiInstance;
    }

    public void setJwikiInstance(BeanBaseJWiki jwikiInstance) {
        this.jwikiInstance = jwikiInstance;
    }

    public HtmlOutputText getLblMensajesArticulos() {
        return lblMensajesArticulos;
    }

    public void setLblMensajesArticulos(HtmlOutputText lblMensajesArticulos) {
        this.lblMensajesArticulos = lblMensajesArticulos;
    }

    public List<Articulos> getListaArticulos() {
        return listaArticulos;
    }

    public void setListaArticulos(List<Articulos> listaArticulos) {
        this.listaArticulos = listaArticulos;
    }

    public Boolean getPopupElimArticulo() {
        return popupElimArticulo;
    }

    public void setPopupElimArticulo(Boolean popupElimArticulo) {
        this.popupElimArticulo = popupElimArticulo;
    }

    /**
     * Metodo para obtener un articulo por su ID
     * @param idarticulo id de la entada que se desea
     * @return
     */
    public String elegirArticuloActual() {
        String idSeleccionado = ((HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest()).getParameter("idSeleccionado");
        Integer id = new Integer(idSeleccionado);
        this.articuloActual = this.jwikiInstance.getArticulo(id.intValue());
        this.setEditandoArticulo(true);
        return EMPTY_STRING;
    }

    public boolean getShowPagArticulos(){
        if(this.listaArticulos.size()>MAX_ARTICULOS) return true;
        return false;
    }

    public String EliminarArticulo(){
        this.setPopupElimArticulo(true);
        this.lblMensajesArticulos.setValue("¿Seguro que desea Eliminar el artículo seleccionado?");
        String idArticulo = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("idArticulo");
        Integer id = Integer.parseInt(idArticulo);
        if(id>0) this.idArticuloEliminar = id;
        return EMPTY_STRING;
    }
    
   public String btnEliminarArticulo_action(){
       try {
            if(this.idArticuloEliminar>0){
                this.jwikiInstance.deleteArticulo(this.idArticuloEliminar);
                this.listaArticulos = this.jwikiInstance.getAllArticulos();
                this.lblMensajesArticulos.setValue("Artículo eliminado con éxito.");
            } 
       } catch (Exception e) {
            this.lblMensajesArticulos.setValue("Ocurrió un error al intentar borrar el artículo.");
       } finally {
           this.idArticuloEliminar = -1;
       }
       return EMPTY_STRING;
    }

    public String btnAceptarElimArt_action() {
        return this.btnEliminarArticulo_action();
    }

    public String btnCancelarMensajes_action() {
        this.setPopupElimArticulo(false);
        this.idArticuloEliminar = -1;
        return EMPTY_STRING;
    }

    public String btnOK_action() {
        this.tabIndex = 0;
        this.idArticuloEliminar = -1;
        this.showPPMesaje = false;
        return EMPTY_STRING;
    }

    public boolean getArticuloValido(){
        return (this.idArticuloEliminar>0);
    }

    public Boolean getHayArticulos(){
        if(this.listaArticulos.size()>0) return true;
        return false;
    }

    public String EditarArticulo(){
        String idArticulo = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("idArticulo");
        Integer id = Integer.parseInt(idArticulo);
        this.articuloActual = this.jwikiInstance.getArticulo(id.intValue());
        this.setEditandoArticulo(true);
        return EMPTY_STRING;
    }

    public String cancelarGuardarArticulo() {
        this.articuloActual = null;
        this.articuloNuevo = new Articulos();
        this.setEditandoArticulo(false);
        this.tabIndex = 0;
        return EMPTY_STRING;
    }

    public String modificarArticulo(){
        this.articuloActual.setIdusuario(this.U);
        this.jwikiInstance.updateArticulos(this.articuloActual);
        this.listaArticulos = this.getjwikiInstance().getAllArticulos();
        this.setEditandoArticulo(false);
        return EMPTY_STRING;
    }

    public String agregarArticulo(){
        this.articuloNuevo.setIdusuario(this.U);
        this.articuloNuevo.setFechahora(new Date());
        if(this.jwikiInstance.createArticulo(this.articuloNuevo)){
            this.listaArticulos = this.getjwikiInstance().getAllArticulos();
            this.setEditandoArticulo(false);
            this.lblPPMesajes.setValue("Artículo agregado con éxito.");
        } else {
            this.setEditandoArticulo(false);
            this.lblPPMesajes.setValue("Ocurrió un error al intentar agregar el Artículo.");
        }
        this.showPPMesaje = true;
        return EMPTY_STRING;
    }

    public TimeZone getTimeZone() {
        return java.util.TimeZone.getDefault();
    }

    public Integer getTabIndex() {
        return tabIndex;
    }

    public void setTabIndex(int tabIndex) {
        this.tabIndex = tabIndex;
    }

    public void setTabIndex(Integer tabIndex) {
        this.tabIndex = tabIndex;
    }

    public void setTabIndex(String tabIndex) {
        this.tabIndex = Integer.parseInt(tabIndex);
    }

    public Integer getRolUsuarioConectado(){
        if(this.U==null) return -1;
        return this.U.getIdrol().getIdrol();
    }

    public boolean getPermisos(){
        switch(this.getRolUsuarioConectado()){
            case -1:
                return false; //no hay informacion de usuario
            case ROL_ADMINISTRADOR:
            case ROL_EDITORCONTENIDO:
                return true; //tengo los permisos
            //default:
                //break;
        }
        return false;
    }
}
