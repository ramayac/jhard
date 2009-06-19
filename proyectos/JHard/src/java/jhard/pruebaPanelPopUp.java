/*
 * pruebaPanelPopUp.java
 *
 * Created on 17-jun-2009, 17:50:24
 * Copyright Hugol
 */
package jhard;

import com.icesoft.faces.component.ext.HtmlInputText;
import com.icesoft.faces.component.ext.HtmlPanelGrid;
import com.icesoft.faces.component.ext.HtmlSelectOneMenu;
import com.icesoft.faces.component.jsfcl.data.DefaultSelectedData;
import com.icesoft.faces.component.jsfcl.data.DefaultSelectionItems;
import com.icesoft.faces.component.jsfcl.data.PopupBean;
import com.icesoft.faces.component.panelpopup.PanelPopup;
import com.sun.data.provider.impl.ObjectArrayDataProvider;
import com.sun.rave.web.ui.appbase.AbstractPageBean;
import edu.ues.jhard.jpa.Estadoequipo;
import javax.faces.FacesException;


/**
 * <p>Page bean that corresponds to a similarly named JSP page.  This
 * class contains component definitions (and initialization code) for
 * all components that you have defined on this page, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 */
public class pruebaPanelPopUp extends AbstractPageBean {
    // <editor-fold defaultstate="collapsed" desc="Managed Component Definition">
    private int __placeholder;

    /**
     * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    private void _init() throws Exception {
    arrayEstados.setArray((java.lang.Object[]) getValue("#{pruebaPanelPopUp.estadoequipo}"));
    }
    private PopupBean panelPopup1Bean = new PopupBean();

    public PopupBean getPanelPopup1Bean() {
        return panelPopup1Bean;
    }

    public void setPanelPopup1Bean(PopupBean pb) {
        this.panelPopup1Bean = pb;
    }
    private PanelPopup panelEqSNuevo = new PanelPopup();

    public PanelPopup getPanelEqSNuevo() {
        return panelEqSNuevo;
    }

    public void setPanelEqSNuevo(PanelPopup pp) {
        this.panelEqSNuevo = pp;
    }
    private HtmlPanelGrid panelGrid2 = new HtmlPanelGrid();

    public HtmlPanelGrid getPanelGrid2() {
        return panelGrid2;
    }

    public void setPanelGrid2(HtmlPanelGrid hpg) {
        this.panelGrid2 = hpg;
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
    private HtmlInputText inputText1 = new HtmlInputText();

    public HtmlInputText getInputText1() {
        return inputText1;
    }

    public void setInputText1(HtmlInputText hit) {
        this.inputText1 = hit;
    }
    private HtmlSelectOneMenu comboEstados = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getComboEstados() {
        return comboEstados;
    }

    public void setComboEstados(HtmlSelectOneMenu hsom) {
        this.comboEstados = hsom;
    }
    private ObjectArrayDataProvider arrayEstados = new ObjectArrayDataProvider();

    public ObjectArrayDataProvider getArrayEstados() {
        return arrayEstados;
    }

    public void setArrayEstados(ObjectArrayDataProvider oadp) {
        this.arrayEstados = oadp;
    }

    // </editor-fold>



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
    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public pruebaPanelPopUp() {
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
        this.panelEqSNuevo.setVisible(false);
        this.panelEqSNuevo.setRendered(false);
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
            log("pruebaPanelPopUp Initialization Failure", e);
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
    protected ApplicationBean1 getApplicationBean1() {
        return (ApplicationBean1) getBean("ApplicationBean1");
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

    public String btnEq_action() {
        
        this.panelEqSNuevo.setRendered(true);
        System.out.println("RENDERICE");
        this.panelEqSNuevo.setVisible(true);
        System.out.println("PUSE VISIBLE");
        return null;
    }

}

