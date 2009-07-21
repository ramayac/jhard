/*
 * jrequestUser.java
 *
 * Created on 05-29-2009, 10:56:59 AM
 * Copyright hugol
 */
package jhard;

import com.icesoft.faces.component.ext.HtmlOutputLabel;
import com.icesoft.faces.component.jsfcl.data.DefaultTableDataModel;
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
public class jprocurUser extends AbstractPageBean {
    public static final int MAX_COMENTARIOS = 10;
    public static final int MAX_ENTRADAS = 5;
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
    private DefaultTableDataModel dataTable1Model = new DefaultTableDataModel();

    public DefaultTableDataModel getDataTable1Model() {
        return dataTable1Model;
    }

    public void setDataTable1Model(DefaultTableDataModel dtdm) {
        this.dataTable1Model = dtdm;
    }

    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public jprocurUser() {

        lu= getJHardminInstance().getCurrentUser();
        
        this.listaEntradas = this.getJProcurInstance().getAllEntradas();
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
    private Boolean soloUna = new Boolean(false);
    private Integer indice = new Integer(0);

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

//    /**
//     * Obtiene la siguienteEntrada
//     * @return
//     */
//    public String siguienteEntrada(){
//        if(!(this.indice>this.listaEntradas.size())) this.indice++;
//        this.entradaActual = this.listaEntradas.get(this.indice);
//        return "exito";
//    }
//
//    /**
//     * Obtiene la entrada anterior
//     * @return
//     */
//    public String anteriorEntrada(){
//        if(this.indice!=0) this.indice--;
//        this.entradaActual = this.listaEntradas.get(this.indice);
//        return "exito";
//    }

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

    /**
     * Metodo para obtener todos las Etiquetas como un VIL STRING asociados con la EntradaActual
     * @param idEntrada
     * @return
     */
    public String getEtiquetasString() {
        List<TagEntrada> te = (List<TagEntrada>)this.entradaActual.getTagEntradaCollection();
        String resultado = new String();
        switch (te.size()){
            case 0:
                return "No hay Etiquetas asociadas.";
            case 1:
                resultado = te.get(0).getIdtag().getDescripcion() + ".";
                break;
            case 2:
                resultado = te.get(0).getIdtag().getDescripcion() + ", " + te.get(1).getIdtag().getDescripcion() + ".";
                break;
            default: //para los > de 2.
                for (TagEntrada tagEntrada : te)
                    resultado += tagEntrada.getIdtag().getDescripcion() + ", ";
                resultado += ".";
                break;
        }
        return resultado;
    }

    /**
     * Metodo para obtener los comentarios de un objeto Entrada, sin consultar a la BD
     * @param e
     * @return
     */
    public List<Comentarios> getComentarios() {
        List<Comentarios> c = (List<Comentarios>)this.entradaActual.getComentariosCollection();
        return c;
    }

    public boolean getShowPagComentarios(){
        if(this.entradaActual.getComentariosCollection().size()>MAX_COMENTARIOS) return true;
        return false;
    }

    public boolean getShowPagEntradas(){
        if(this.listaEntradas.size()>MAX_ENTRADAS) return true;
        return false;
    }

    //idComentarioBorrar
    
    /**
     * Metodo para establecer hacer toggle a la vista de entradas (Unica o Multiple)
     */
    public String toggleVista() {
        this.setSoloUna(false);
        return "exito.";
    }
}
