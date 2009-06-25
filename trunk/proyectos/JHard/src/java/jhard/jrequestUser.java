/*
 * jrequestUser.java
 *
 * Created on 05-29-2009, 10:56:59 AM
 * Copyright hugol
 */
package jhard;

import com.icesoft.faces.component.ext.HtmlCommandButton;
import com.icesoft.faces.component.ext.HtmlOutputLabel;
import com.icesoft.faces.component.ext.HtmlSelectOneMenu;
import com.icesoft.faces.component.jsfcl.data.DefaultSelectedData;
import com.icesoft.faces.component.jsfcl.data.DefaultSelectionItems;

import com.sun.data.provider.impl.ObjectArrayDataProvider;
import com.sun.rave.web.ui.appbase.AbstractPageBean;


import edu.ues.jhard.beans.BeanBaseJRequest;
import edu.ues.jhard.jpa.Tecnico;
import java.util.ArrayList;
import javax.faces.FacesException;
import javax.faces.event.ValueChangeEvent;


/**
 * <p>Page bean that corresponds to a similarly named JSP page.  This
 * class contains component definitions (and initialization code) for
 * all components that you have defined on this page, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 */
public class jrequestUser extends AbstractPageBean {
    // <editor-fold defaultstate="collapsed" desc="Managed Component Definition">
    private int __placeholder;

    /**
     * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    private void _init() throws Exception {
        
    arrayTecnico.setArray((java.lang.Object[]) getValue("#{jrequestUser.tecnicos}"));
    }


    private ObjectArrayDataProvider arrayTecnico = new ObjectArrayDataProvider();

    public ObjectArrayDataProvider getArrayTecnico() {
        return arrayTecnico;
    }

    public void setArrayTecnido(ObjectArrayDataProvider oadt) {
        this.arrayTecnico = oadt;
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
    private HtmlCommandButton btnBuscar = new HtmlCommandButton();

    public HtmlCommandButton getBtnBuscar() {
        return btnBuscar;
    }

    public void setBtnBuscar(HtmlCommandButton hcb) {
        this.btnBuscar = hcb;
    }

    // </editor-fold>


    private Tecnico[] tecnicos = new edu.ues.jhard.beans.BeanBaseJRequest().getTecnico();
    private Tecnico tecnicoElegido=tecnicos[0];



    public Tecnico getTecnicoElegido(){
        return tecnicoElegido;
    }

    public void setTecnicoElegido(Tecnico tec){
        this.tecnicoElegido=tec;
    }

    public Tecnico[] getTecnicos(){
        return tecnicos;
    }

    public void setTecnicos(Tecnico[] tec){
        this.tecnicos=tec;
    }
    private HtmlCommandButton btnSolicitud = new HtmlCommandButton();

    public HtmlCommandButton getBtnSolicitud() {
        return btnSolicitud;
    }

    public void setBtnSolicitud(HtmlCommandButton hcb) {
        this.btnSolicitud = hcb;
    }

    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public jrequestUser() {
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

//    public void comboProblemas_processValueChange(ValueChangeEvent vce) {
//
//        String tmp=(String)this.comboProblemas.getValue();
//        Integer id=Integer.valueOf(tmp);
//        Tecnico t=new BeanBaseJRequest().getEntityManager().find(Tecnico.class, id);
//
//        this.tecnicoElegido= t;
//
//        this.select.setValue(this.tecnicoElegido.getNombres() + this.tecnicoElegido.getApellidos());
//    }

    public String btnBuscar_action() {
        //return null means stay on the same page
        return null;
    }

    public String btnSolicitud_action() {
        //return null means stay on the same page
        return "case1";
    }




}

