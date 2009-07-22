/*
 * jrequestUser.java
 *
 * Created on 05-29-2009, 10:56:59 AM
 * Copyright hugol
 */
package jhard;

import com.icesoft.faces.component.ext.HtmlOutputLabel;
import com.icesoft.faces.component.ext.HtmlOutputText;
import com.icesoft.faces.component.jsfcl.data.DefaultSelectedData;
import com.sun.rave.faces.data.DefaultSelectItemsArray;
import com.sun.rave.web.ui.appbase.AbstractPageBean;
import edu.ues.jhard.beans.BeanBaseJHardmin;
import edu.ues.jhard.beans.BeanBaseJProcur;
import edu.ues.jhard.jhardmin.LoggedUser;
import edu.ues.jhard.jhardmin.LoginManager;
import edu.ues.jhard.jpa.Comentarios;
import edu.ues.jhard.jpa.Entrada;
import edu.ues.jhard.jpa.Tag;
import edu.ues.jhard.jpa.TagEntrada;
import edu.ues.jhard.jpa.Usuario;
import java.util.ArrayList;
import java.util.List;
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
public class jprocurAdmin extends AbstractPageBean {
    public static final int MAX_ENTRADAS = 30;
    static final int ROL_EDITORCONTENIDO = 4;
    static final int ROL_ADMINISTRADOR = 1;

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
        return lu;
    }

    public void setLu(LoggedUser lu) {
        this.lu = lu;
    }

    public Usuario getU(){
        return U;
    }

    public void setU(Usuario u){
        this.U=u;
    }

    public  BeanBaseJHardmin getJHardminInstance() {
        return (BeanBaseJHardmin) getBean("JHardminInstance");
    }

    private BeanBaseJProcur jprocurInstance = new BeanBaseJProcur(); //sera mejor como jWikiInstance en el faces-config? revisar el rednimiento.

    public  BeanBaseJProcur getJProcurInstance() {
        return this.jprocurInstance;
    }
    private DefaultSelectedData selectOneRadio1DataBean = new DefaultSelectedData();

    public DefaultSelectedData getSelectOneRadio1DataBean() {
        return selectOneRadio1DataBean;
    }

    public void setSelectOneRadio1DataBean(DefaultSelectedData dsd) {
        this.selectOneRadio1DataBean = dsd;
    }
    private DefaultSelectItemsArray selectOneRadio1DefaultItems1 = new DefaultSelectItemsArray();

    public DefaultSelectItemsArray getSelectOneRadio1DefaultItems1() {
        return selectOneRadio1DefaultItems1;
    }

    public void setSelectOneRadio1DefaultItems1(DefaultSelectItemsArray dsia) {
        this.selectOneRadio1DefaultItems1 = dsia;
    }
    private DefaultSelectItemsArray selectOneRadio1DefaultItems = new DefaultSelectItemsArray();

    public DefaultSelectItemsArray getSelectOneRadio1DefaultItems() {
        return selectOneRadio1DefaultItems;
    }

    public void setSelectOneRadio1DefaultItems(DefaultSelectItemsArray dsia) {
        this.selectOneRadio1DefaultItems = dsia;
    }
    private DefaultSelectedData selectOneMenu1DataBean = new DefaultSelectedData();

    public DefaultSelectedData getSelectOneMenu1DataBean() {
        return selectOneMenu1DataBean;
    }

    public void setSelectOneMenu1DataBean(DefaultSelectedData dsd) {
        this.selectOneMenu1DataBean = dsd;
    }

    private DefaultSelectItemsArray selectOneMenu1DefaultItems1 = new DefaultSelectItemsArray();

    public DefaultSelectItemsArray getSelectOneMenu1DefaultItems1() {
        return selectOneMenu1DefaultItems1;
    }

    public void setSelectOneMenu1DefaultItems1(DefaultSelectItemsArray dsia) {
        this.selectOneMenu1DefaultItems1 = dsia;
    }
    private DefaultSelectItemsArray selectOneMenu1DefaultItems = new DefaultSelectItemsArray();

    public DefaultSelectItemsArray getSelectOneMenu1DefaultItems() {
        return selectOneMenu1DefaultItems;
    }

    public void setSelectOneMenu1DefaultItems(DefaultSelectItemsArray dsia) {
        this.selectOneMenu1DefaultItems = dsia;
    }

    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public jprocurAdmin() {

        lu= getJHardminInstance().getCurrentUser();
        
        this.listaEntradas = this.getJProcurInstance().getAllEntradas();
        this.listaComentarios = this.getJProcurInstance().getComentariosNoAprobados();
        if(this.listaEntradas.size()>0) this.entradaActual = this.listaEntradas.get(0);
        
        if(lu!=null){
            U = LoginManager.getInstance().getUsuario(lu);

            this.lblUser.setValue((String)U.getNombre());

            switch(U.getIdrol().getIdrol()){
                case ROL_ADMINISTRADOR:
                case ROL_EDITORCONTENIDO:
                default:
                    break;
                }
        }
        else
            this.lblUser.setValue("Invitado");
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

    private Entrada entradaActual = null;
    private List<Entrada> listaEntradas = new ArrayList<Entrada>();
    private Comentarios comentarioActual = null;
    private List<Comentarios> listaComentarios = new ArrayList<Comentarios>();

    public List<Comentarios> getListaComentarios() {
        return listaComentarios;
    }

    public void setListaComentarios(List<Comentarios> listaComentarios) {
        this.listaComentarios = listaComentarios;
    }
    private Boolean soloUna = new Boolean(false);

    public List<Entrada> getListaEntradas() {
        return listaEntradas;
    }

    public void setListaEntradas(List<Entrada> listaEntradas) {
        this.listaEntradas = listaEntradas;
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
        this.entradaActual = this.jprocurInstance.getEntrada(id.intValue());
        this.setSoloUna(true);
        return "exito";
    }

    /**
     * Metodo para obtener todos las Etiquetas asociados con la EntradaActual
     * @param idEntrada
     * @return
     */
    public List<Tag> getEtiquetas() {
        List<TagEntrada> te = (List<TagEntrada>)this.entradaActual.getTagEntradaCollection();
        List<Tag> tag = new ArrayList<Tag>();
        for (TagEntrada tagEntrada : te) {
            tag.add(tagEntrada.getIdtag());
        }
        return tag;
    }

//    public boolean getShowPagComentarios(){
//        if(this.entradaActual.getComentariosCollection().size()>10) return true;
//        return false;
//    }

    public boolean getShowPagEntradas(){
        if(this.listaEntradas.size()>MAX_ENTRADAS) return true;
        return false;
    }

    public String EliminarEntrada(){
        this.setPopupElimEntrada(true);
        this.lblMensajesEntrada.setValue("¿Seguro que desea Eliminar la entrada seleccionada?");
        String idEntrada = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("idEntrada");
        Integer id = Integer.parseInt(idEntrada);
        if(id>0) this.idEntradaEliminar = id;
        return "";
    }

    public String EliminarComentario(){
        this.setPopupAprobarComentario(true);
        this.lblMensajesComentarios.setValue("¿Seguro que desea Eliminar el comentario seleccionado?");
        String idComent = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("idComentario");
        Integer id = Integer.parseInt(idComent);
        if(id>0) this.idComentario = id;
        return "";
    }
    
   public String btnEliminarEntrada_action(){
       try {
            if(this.idEntradaEliminar>0){
                this.jprocurInstance.deleteEntrada(this.idEntradaEliminar);
                this.listaEntradas = this.jprocurInstance.getAllEntradas();
                this.lblMensajesEntrada.setValue("Entrada eliminada con éxito.");
            } 
       } catch (Exception e) {
            this.lblMensajesEntrada.setValue("Ocurrió un error al intentar borrar la Entrada.");
       } finally {
           this.idEntradaEliminar = -1;
       }
       return "";
    }

    public String btnAprobarComentario_action(){
       try {
            if(this.idComentario>0){
                this.jprocurInstance.aprobarComentario(this.idComentario);
                this.listaComentarios = this.jprocurInstance.getComentariosNoAprobados();
                this.lblMensajesComentarios.setValue("El comentario fué aprobado.");
            }
       } catch (Exception e) {
            this.lblMensajesComentarios.setValue("Ocurrió un error al intentar moderar el comentario.");
       } finally {
           this.idComentario = -1;
       }
       return "";
    }

    public String btnEliminarComentario_action(){
       try {
            if(this.idComentario>0){
                this.jprocurInstance.deleteComentario(this.idComentario);
                this.listaComentarios = this.jprocurInstance.getComentariosNoAprobados();
                this.lblMensajesComentarios.setValue("El comentario fué aprobado.");
            }
       } catch (Exception e) {
            this.lblMensajesComentarios.setValue("Ocurrió un error al intentar moderar el comentario.");
       } finally {
           this.idComentario = -1;
       }
       return "";
    }

    private HtmlOutputText lblMensajesEntrada = new HtmlOutputText();
    private HtmlOutputText lblMensajesComentarios = new HtmlOutputText();

    public HtmlOutputText getLblMensajesComentarios() {
        return lblMensajesComentarios;
    }

    public void setLblMensajesComentarios(HtmlOutputText lblMensajesComentarios) {
        this.lblMensajesComentarios = lblMensajesComentarios;
    }

    public HtmlOutputText getLblMensajesEntrada() {
        return lblMensajesEntrada;
    }

    public void setLblMensajesEntrada(HtmlOutputText hot) {
        this.lblMensajesEntrada = hot;
    }

    private Boolean popupElimEntrada = new Boolean(false);
    private Boolean popupAprobarComentario = new Boolean(false);

    public Boolean getPopupAprobarComentario() {
        return popupAprobarComentario;
    }

    public void setPopupAprobarComentario(Boolean popupAprobarComentario) {
        this.popupAprobarComentario = popupAprobarComentario;
    }

    public Boolean getPopupElimEntrada() {
        return popupElimEntrada;
    }

    public void setPopupElimEntrada(Boolean popupElimEntrada) {
        this.popupElimEntrada = popupElimEntrada;
    }


    public String btnAceptarElimEntr_action() {
        return this.btnEliminarEntrada_action();
    }

    public String btnCancelarMensajes_action() {
        this.setPopupElimEntrada(false);
        this.setPopupAprobarComentario(false);
        this.idEntradaEliminar = -1;
        this.idComentario = -1;
        return null;
    }

    private Integer idEntradaEliminar = new Integer(-1);
    private Integer idComentario = new Integer(-1);

    public Integer getIdComentarioAprobar() {
        return idComentario;
    }

    public void setIdComentarioAprobar(Integer idComentarioAprobar) {
        this.idComentario = idComentarioAprobar;
    }

    public Boolean getEntradaValida(){
        return (this.idEntradaEliminar>0);
    }

}