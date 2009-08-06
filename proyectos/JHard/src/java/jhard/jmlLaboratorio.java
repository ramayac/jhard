/*
 * jmlLaboratorio.java
 *
 * Created on 08-02-2009, 02:19:12 PM
 * Copyright rodrigo
 */
package jhard;

import com.icesoft.faces.component.outputconnectionstatus.OutputConnectionStatus;
import edu.ues.jhard.beans.BeanBaseJManLab;
import javax.faces.FacesException;

/**
 * <p></p>
 */
public class jmlLaboratorio extends BeanBaseJHard {

    //private popUp popup = new popUp("Aviso", "", false);

    private BeanBaseJManLab jmanLabInstance = new BeanBaseJManLab();

    public BeanBaseJManLab getJmanLabInstance() {
        return jmanLabInstance;
    }

    public String cancelar(){
        return EMPTY_STRING;
    }

    private OutputConnectionStatus estatus = new OutputConnectionStatus();

    public OutputConnectionStatus getEstatus() {
        return estatus;
    }

    public void setEstatus(OutputConnectionStatus ocs) {
        this.estatus = ocs;
    }

    public boolean getPermisos(){
        switch(this.getRolUsuarioConectado()){
            case -1:
                return false; //no hay informacion de usuario
            case ROL_INSTRUCTOR:
            case ROL_DOCENTE:
            case ROL_ADMINISTRADOR:
                return true; //tengo los permisos
            //default:
                //break;
        }
        return false;
    }

    public jmlLaboratorio() {

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
     * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    private void _init() {
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
}