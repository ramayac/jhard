/*
 * jrequestUserSolicitud.java
 *
 * Created on 16-jun-2009, 20:39:56
 * Copyright Hugol
 */
package jhard;

import com.icesoft.faces.component.ext.HtmlCommandButton;
import com.icesoft.faces.component.ext.HtmlInputText;
import com.icesoft.faces.component.ext.HtmlInputTextarea;
import com.icesoft.faces.component.ext.HtmlOutputLabel;
import com.icesoft.faces.component.ext.HtmlSelectOneMenu;
import com.icesoft.faces.component.jsfcl.data.DefaultSelectedData;
import com.icesoft.faces.component.jsfcl.data.DefaultSelectionItems;
import com.icesoft.faces.component.jsfcl.data.PopupBean;
import com.icesoft.faces.component.panelpopup.PanelPopup;
import com.sun.data.provider.impl.ObjectArrayDataProvider;
import com.sun.rave.faces.data.DefaultSelectItemsArray;
import com.sun.rave.web.ui.appbase.AbstractPageBean;
import edu.ues.jhard.beans.BeanBaseJHardmin;
import edu.ues.jhard.beans.BeanBaseJRequest;
import edu.ues.jhard.jhardmin.LoggedUser;
import edu.ues.jhard.jhardmin.LoginManager;
import edu.ues.jhard.jpa.Equiposimple;
import edu.ues.jhard.jpa.Estadoequipo;
import edu.ues.jhard.jpa.Solicitud;
import edu.ues.jhard.jpa.Usuario;
import java.util.Calendar;
import java.sql.Date;
import javax.faces.FacesException;
import javax.faces.event.ValueChangeEvent;


/**
 * <p>Page bean that corresponds to a similarly named JSP page.  This
 * class contains component definitions (and initialization code) for
 * all components that you have defined on this page, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 */
public class jrequestUserSolicitud extends AbstractPageBean {
    // <editor-fold defaultstate="collapsed" desc="Managed Component Definition">
    private int __placeholder;


    /**
     * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    private void _init() throws Exception {

    arrayEqSimple.setArray((java.lang.Object[]) getValue("#{jrequestUserSolicitud.EQS}"));
    arrayEstados.setArray((java.lang.Object[]) getValue("#{jrequestUserSolicitud.estadoequipo}"));

//    lu= getJHardminInstance().getCurrentUser();
//    //System.out.println("NOMBRE DEL USUARIO LOGGEADO" + lu.getUserName());
//
//
//    U = LoginManager.getInstance().getUsuario(lu);
//
//    //System.out.println(U.getNombre());

//    this.lblUsuario.setValue((String)U.getNombre());
//
//    if(U==null){
//        this.lblUsuario.setValue("Favor Logeese como usuario");
//    }
//    else{
//        this.lblUsuario.setValue(U.getNombre());
//    }

    }

    private ObjectArrayDataProvider arrayEqSimple = new ObjectArrayDataProvider();

    public ObjectArrayDataProvider getArrayEqSimple() {
        return arrayEqSimple;
    }

    public void setArrayEqSimple(ObjectArrayDataProvider oadp) {
        this.arrayEqSimple = oadp;
    }
    private HtmlInputTextarea txtDescripcion = new HtmlInputTextarea();

    public HtmlInputTextarea getTxtDescripcion() {
        return txtDescripcion;
    }

    public void setTxtDescripcion(HtmlInputTextarea hit) {
        this.txtDescripcion = hit;
    }
    private HtmlSelectOneMenu comboEqSimple = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getComboEqSimple() {
        return comboEqSimple;
    }

    public void setComboEqSimple(HtmlSelectOneMenu hsom) {
        this.comboEqSimple = hsom;
    }
    private HtmlCommandButton btnEnviar = new HtmlCommandButton();

    public HtmlCommandButton getBtnEnviar() {
        return btnEnviar;
    }

    public void setBtnEnviar(HtmlCommandButton hcb) {
        this.btnEnviar = hcb;
    }
   
    private HtmlCommandButton btnAgregarEqSimple = new HtmlCommandButton();

    public HtmlCommandButton getBtnAgregarEqSimple() {
        return btnAgregarEqSimple;
    }

    public void setBtnAgregarEqSimple(HtmlCommandButton hcb) {
        this.btnAgregarEqSimple = hcb;
    }

    // </editor-fold>


    private  Equiposimple[] EQS = new edu.ues.jhard.beans.BeanBaseJRequest().getEquipoSimple();

    private Equiposimple eqElegido = null;

    private Usuario user=null;


     public Equiposimple getEQSElegido(){
        return eqElegido;
    }

    public void setEQSElegido(Equiposimple eqs){
        this.eqElegido=eqs;
    }

    public Equiposimple[] getEQS(){
        return EQS;
    }

    public void setEQS(Equiposimple[] tec){
        this.EQS=tec;
    }
    private HtmlOutputLabel lblEstadoSolicitud = new HtmlOutputLabel();

    public HtmlOutputLabel getLblEstadoSolicitud() {
        return lblEstadoSolicitud;
    }

    public void setLblEstadoSolicitud(HtmlOutputLabel hol) {
        this.lblEstadoSolicitud = hol;
    }
    private PopupBean panelPopup1Bean = new PopupBean();

    public PopupBean getPanelPopup1Bean() {
        return panelPopup1Bean;
    }

    public void setPanelPopup1Bean(PopupBean pb) {
        this.panelPopup1Bean = pb;
    }
    private DefaultSelectedData defaultSelectedData1 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData1() {
        return defaultSelectedData1;
    }

    public void setDefaultSelectedData1(DefaultSelectedData dsd) {
        this.defaultSelectedData1 = dsd;
    }
    private DefaultSelectionItems selectOneMenu1DefaultItems1 = new DefaultSelectionItems();

    public DefaultSelectionItems getSelectOneMenu1DefaultItems1() {
        return selectOneMenu1DefaultItems1;
    }

    public void setSelectOneMenu1DefaultItems1(DefaultSelectionItems dsi) {
        this.selectOneMenu1DefaultItems1 = dsi;
    }
    private DefaultSelectItemsArray selectOneMenu1DefaultItems2 = new DefaultSelectItemsArray();

    public DefaultSelectItemsArray getSelectOneMenu1DefaultItems2() {
        return selectOneMenu1DefaultItems2;
    }

    public void setSelectOneMenu1DefaultItems2(DefaultSelectItemsArray dsia) {
        this.selectOneMenu1DefaultItems2 = dsia;
    }
    private DefaultSelectItemsArray selectOneMenu1DefaultItems3 = new DefaultSelectItemsArray();

    public DefaultSelectItemsArray getSelectOneMenu1DefaultItems3() {
        return selectOneMenu1DefaultItems3;
    }

    public void setSelectOneMenu1DefaultItems3(DefaultSelectItemsArray dsia) {
        this.selectOneMenu1DefaultItems3 = dsia;
    }
    private DefaultSelectedData selectOneMenu1Bean = new DefaultSelectedData();

    public DefaultSelectedData getSelectOneMenu1Bean() {
        return selectOneMenu1Bean;
    }

    public void setSelectOneMenu1Bean(DefaultSelectedData dsd) {
        this.selectOneMenu1Bean = dsd;
    }
    private DefaultSelectionItems selectOneMenu1DefaultItems = new DefaultSelectionItems();

    public DefaultSelectionItems getSelectOneMenu1DefaultItems() {
        return selectOneMenu1DefaultItems;
    }

    public void setSelectOneMenu1DefaultItems(DefaultSelectionItems dsi) {
        this.selectOneMenu1DefaultItems = dsi;
    }
    private ObjectArrayDataProvider arrayEstados = new ObjectArrayDataProvider();

    public ObjectArrayDataProvider getArrayEstados() {
        return arrayEstados;
    }

    public void setArrayEstados(ObjectArrayDataProvider oadp) {
        this.arrayEstados = oadp;
    }


    private Estadoequipo[] estados = new edu.ues.jhard.beans.BeanBaseJRequest().getEstadoEquipo();
    private Estadoequipo estadoElegido=estados[0];


    public Estadoequipo getEstadoElegido(){
        return estadoElegido;
    }

    public void setEstadoElegido(Estadoequipo ee){
        this.estadoElegido=ee;
    }

    public Estadoequipo[] getEstadoequipo(){
        return estados;
    }

    public void setEstadoequipo(Estadoequipo[] ee){
        this.estados=ee;
    }
    private HtmlInputText txtNombreEq = new HtmlInputText();

    public HtmlInputText getTxtNombreEq() {
        return txtNombreEq;
    }

    public void setTxtNombreEq(HtmlInputText hit) {
        this.txtNombreEq = hit;
    }
    private HtmlSelectOneMenu comboEstados = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getComboEstados() {
        return comboEstados;
    }

    public void setComboEstados(HtmlSelectOneMenu hsom) {
        this.comboEstados = hsom;
    }
    private HtmlCommandButton btnAgregar = new HtmlCommandButton();

    public HtmlCommandButton getBtnAgregar() {
        return btnAgregar;
    }

    public void setBtnAgregar(HtmlCommandButton hcb) {
        this.btnAgregar = hcb;
    }
    private PanelPopup panelPopup1 = new PanelPopup();

    public PanelPopup getPanelPopup1() {
        return panelPopup1;
    }

    public void setPanelPopup1(PanelPopup pp) {
        this.panelPopup1 = pp;
    }
    private HtmlCommandButton btnCerrar = new HtmlCommandButton();

    public HtmlCommandButton getBtnCerrar() {
        return btnCerrar;
    }

    public void setBtnCerrar(HtmlCommandButton hcb) {
        this.btnCerrar = hcb;
    }
    private HtmlInputText txtPropietario = new HtmlInputText();

    public HtmlInputText getTxtPropietario() {
        return txtPropietario;
    }

    public void setTxtPropietario(HtmlInputText hit) {
        this.txtPropietario = hit;
    }
    private PopupBean panelPopup2Bean = new PopupBean();

    public PopupBean getPanelPopup2Bean() {
        return panelPopup2Bean;
    }

    public void setPanelPopup2Bean(PopupBean pb) {
        this.panelPopup2Bean = pb;
    }
    private PanelPopup panelPopup2 = new PanelPopup();

    public PanelPopup getPanelPopup2() {
        return panelPopup2;
    }

    public void setPanelPopup2(PanelPopup pp) {
        this.panelPopup2 = pp;
    }
    private HtmlCommandButton btnAceptar = new HtmlCommandButton();

    public HtmlCommandButton getBtnAceptar() {
        return btnAceptar;
    }

    public void setBtnAceptar(HtmlCommandButton hcb) {
        this.btnAceptar = hcb;
    }


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



//    public JHardminInstance getJHardminInstance() {
//        return (JHardminInstance) getBean("JHardminInstance");
//    }

    public  BeanBaseJHardmin getJHardminInstance() {
        return (BeanBaseJHardmin) getBean("JHardminInstance");
    }

    private HtmlOutputLabel lblUsuario = new HtmlOutputLabel();

    public HtmlOutputLabel getLblUsuario() {
        return lblUsuario;
    }

    public void setLblUsuario(HtmlOutputLabel hol) {
        this.lblUsuario = hol;
    }

    /**
     * <p>Construct a new Page bean instance.</p>
     */

    public jrequestUserSolicitud() {

        lu= getJHardminInstance().getCurrentUser();
        
        U = LoginManager.getInstance().getUsuario(lu);

        //System.out.println(U.getNombre());

        this.lblUsuario.setValue((String)U.getNombre());

        if(U==null){
            this.lblUsuario.setValue("Favor Logeese como usuario");
            this.btnEnviar.setDisabled(true);
        }
        else{
            this.lblUsuario.setValue(U.getNombre());
        }


              
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
        this.panelPopup1.setVisible(false);
        this.panelPopup1.setRendered(false);
        this.panelPopup2.setVisible(false);
        this.panelPopup2.setRendered(false);
        this.lblUsuario.setValue(U.getNombre());
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
            log("jrequestUserSolicitud Initialization Failure", e);
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
    protected ApplicationBean1 getApplicationBean1() {
        return (ApplicationBean1) getBean("ApplicationBean1");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected RequestBean1 getRequestBean1() {
        return (RequestBean1) getBean("RequestBean1");
    }

    public String btnAgregarEqSimple_action() {

        this.panelPopup1.setRendered(true);
        System.out.println("RENDERICE");
        this.panelPopup1.setVisible(true);
        System.out.println("PUSE VISIBLE");
        this.panelPopup1.setModal(true);
        System.out.println("SOLO EL ES MODIFICABLE");
        return null;
    }

    public String btnEnviar_action() {
        Solicitud s = new Solicitud();
        Calendar c = Calendar.getInstance();

        s.setFecha(new Date((c.get(Calendar.YEAR))-1900, c.get(Calendar.MONTH), c.get(Calendar.DATE)));

        System.out.println("COLOCA LA FECHA");
        s.setPrioridad("Media");
        System.out.println("COLOCA LA PRIORIDAD");
        s.setDescripcion((String)this.txtDescripcion.getValue());
        System.out.println("COLOCA LA DESCRIPCION");
        
        //AGARRO EL USUARIO LOGGEADO
        
        //Usuario u = new BeanBaseJHardmin().getUsuario(5);

        this.lblUsuario.setValue(U.getNombre());

        s.setIdusuario(U);
        System.out.println("COLOCA EL USUARIO");

        String tmp=(String)this.comboEqSimple.getValue();
        Integer id=Integer.parseInt(tmp);
        System.out.println("AGARRA EL VALOR DEL COMBO");
        Equiposimple e=new BeanBaseJRequest().getEntityManager().find(Equiposimple.class, id);
        System.out.println("BUSCA LA INSTANCIA");
        this.eqElegido= e;

        s.setIdequiposimple(eqElegido);
        System.out.println("COLOCA EL EQ SIMPLE");
        new BeanBaseJRequest().registrarSolicitud(s);
        System.out.println("REGISTRA LA SOLICITUD");
        
        this.lblEstadoSolicitud.setValue("Solicitud enviada con éxito. Nuestros técnicos se encargarán de resolverla a la brevedad posible");
        this.panelPopup2.setVisible(true);
        this.panelPopup2.setRendered(true);
        this.panelPopup2.setModal(true);

        return null;
    }

    public void comboEqSimple_processValueChange(ValueChangeEvent vce) {

        this.lblEstadoSolicitud.setValue(this.comboEqSimple.getValue().toString());
    }

    public String btnCerrar_action() {
        this.panelPopup1.setVisible(false);
        this.panelPopup1.setRendered(false);
        this.panelPopup1.setModal(false);
        return null;
    }

    public String btnAgregar_action() {
        Equiposimple eq = new Equiposimple();

        eq.setDescripcion((String)this.txtNombreEq.getValue());

        //Usuario u = new BeanBaseJHardmin().getUsuario(5);

        eq.setPropietario((String)this.txtPropietario.getValue());

        String tmp=(String)this.comboEstados.getValue();
        Integer id=Integer.parseInt(tmp);
        Estadoequipo e=new BeanBaseJRequest().getEntityManager().find(Estadoequipo.class, id);
        this.estadoElegido= e;

        eq.setIdestado(estadoElegido);

        new BeanBaseJRequest().registrarEquipoSimple(eq);

        this.EQS = new edu.ues.jhard.beans.BeanBaseJRequest().getEquipoSimple();
        this.eqElegido=this.EQS[this.EQS.length-1];

        arrayEqSimple.setArray((java.lang.Object[]) getValue("#{jrequestUserSolicitud.EQS}"));

        this.comboEqSimple.setValue(this.eqElegido);
        this.panelPopup1.setVisible(false);
        this.panelPopup1.setRendered(false);
        this.panelPopup1.setModal(false);

        return null;
    }

    public String btnAceptar_action() {
        this.panelPopup2.setVisible(false);
        this.panelPopup2.setRendered(false);
        this.panelPopup2.setModal(false);
        return null;
    }

}

