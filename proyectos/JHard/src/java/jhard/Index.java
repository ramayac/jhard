/*
 * Page1.java
 *
 * Created on 25-may-2009, 23:02:55
 * Copyright Hugol
 */
package jhard;

import com.icesoft.faces.component.ext.HtmlCommandButton;
import com.icesoft.faces.component.ext.HtmlInputSecret;
import com.icesoft.faces.component.ext.HtmlInputText;
import com.icesoft.faces.component.ext.HtmlOutputLabel;
import com.sun.rave.web.ui.appbase.AbstractPageBean;
import edu.ues.jhard.beans.BeanBase;
import edu.ues.jhard.beans.BeanBaseJCanon;
import edu.ues.jhard.beans.BeanBaseJWiki;
import edu.ues.jhard.jhardmin.LoggedUser;
import edu.ues.jhard.jhardmin.LoginManager;
import edu.ues.jhard.jpa.Equiposimple;
import edu.ues.jhard.jpa.Existencia;
import edu.ues.jhard.jpa.Reserva;
import edu.ues.jhard.jwiki.JreqArticulo;
import java.util.Calendar;
import java.util.List;
import javax.faces.FacesException;
import javax.persistence.EntityManager;

/**
 * <p>Page bean that corresponds to a similarly named JSP page.  This
 * class contains component definitions (and initialization code) for
 * all components that you have defined on this page, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 */
public class Index extends AbstractPageBean {
    // <editor-fold defaultstate="collapsed" desc="Managed Component Definition">
    private int __placeholder;

    /**
     * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    private void _init() throws Exception {
    }
    private HtmlInputText txtUser = new HtmlInputText();

    public HtmlInputText getTxtUser() {
        return txtUser;
    }

    public void setTxtUser(HtmlInputText hit) {
        this.txtUser = hit;
    }
    private HtmlInputSecret txtPass = new HtmlInputSecret();

    public HtmlInputSecret getTxtPass() {
        return txtPass;
    }

    public void setTxtPass(HtmlInputSecret his) {
        this.txtPass = his;
    }
    private HtmlCommandButton btnLogin = new HtmlCommandButton();

    public HtmlCommandButton getBtnLogin() {
        return btnLogin;
    }

    public void setBtnLogin(HtmlCommandButton hcb) {
        this.btnLogin = hcb;
    }
    private HtmlOutputLabel txtUserLogin = new HtmlOutputLabel();

    public HtmlOutputLabel getTxtUserLogin() {
        return txtUserLogin;
    }

    public void setTxtUserLogin(HtmlOutputLabel hol) {
        this.txtUserLogin = hol;
    }

    // </editor-fold>

    private List<JreqArticulo> listaUltimasEntradas;
    private List<Existencia> listaExistenciasFallidas;
    private List<Existencia> listaExistenciasMantenimiento;
    private List<Equiposimple> listaEquiposFallidos;
    private List<Equiposimple> listaEquiposMantenimiento;
    private List<Reserva> listaReservasHoy;    

    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public Index() {
        EntityManager emgr = new BeanBase().getEntityManager();
        this.listaUltimasEntradas = new BeanBaseJWiki().getUltimosCincoArticulosSmall();
        this.listaExistenciasFallidas = emgr.createQuery("SELECT e FROM Existencia e WHERE e.idestado.idestado=2").getResultList();
        this.listaExistenciasMantenimiento = emgr.createQuery("SELECT e FROM Existencia e WHERE e.idestado.idestado=3").getResultList();
        this.listaEquiposFallidos = emgr.createQuery("SELECT e FROM Equiposimple e WHERE e.idestado.idestado=2").getResultList();
        this.listaEquiposMantenimiento = emgr.createQuery("SELECT e FROM Equiposimple e WHERE e.idestado.idestado=3").getResultList();

        Calendar cal = Calendar.getInstance();        
        this.listaReservasHoy = new BeanBaseJCanon().getReservasMismoDia(cal.get(Calendar.DAY_OF_MONTH), cal.get(Calendar.MONTH) + 1, cal.get(Calendar.YEAR));

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
            
        // <editor-fold defaultstate="collapsed" desc="Managed Component Initialization">
        // Initialize automatically managed components
        // *Note* - this logic should NOT be modified
        try {
            _init();
        } catch (Exception e) {
            log("Page1 Initialization Failure", e);
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

    public String btnLogin_action() {

        String nomUser = (String) this.txtUser.getValue();
        String nomPass = (String) this.txtPass.getValue();
        System.out.println(nomUser);
        System.out.println(nomPass);

        LoginManager lmgr = LoginManager.getInstance();
        Integer uid = lmgr.Login(nomUser, nomPass, "localhost");
        if(uid != -1){
        //if (bb.getUsuario(nomUser, nomPass)!=null){
            //this.txtUserLogin.setValue(bb.getUsuario(nomUser, nomPass).getNombre());
            LoggedUser user = lmgr.getUser(uid);
            this.txtUserLogin.setValue("Bienvenido "+user.getUserName());

        }
        else{
            this.txtUserLogin.setValue("Usuario Incorrecto");
        }


        return null;
    }

    /**
     * @return the listaUltimasEntradas
     */
    public List<JreqArticulo> getListaUltimasEntradas() {
        return listaUltimasEntradas;
    }

    /**
     * @param listaUltimasEntradas the listaUltimasEntradas to set
     */
    public void setListaUltimasEntradas(List<JreqArticulo> listaUltimasEntradas) {
        this.setListaUltimasEntradas(listaUltimasEntradas);

    }

    /**
     * @return the listaExistenciasFallidas
     */
    public List<Existencia> getListaExistenciasFallidas() {
        if(listaExistenciasFallidas.size() > 5)
            return listaExistenciasFallidas.subList(0, 4);

        return listaExistenciasFallidas;
    }

    /**
     * @param listaExistenciasFallidas the listaExistenciasFallidas to set
     */
    public void setListaExistenciasFallidas(List<Existencia> listaExistenciasFallidas) {
        this.listaExistenciasFallidas = listaExistenciasFallidas;
    }

    /**
     * @return the listaExistenciasMantenimiento
     */
    public List<Existencia> getListaExistenciasMantenimiento() {
        if(listaExistenciasMantenimiento.size() > 5)
            return listaExistenciasMantenimiento.subList(0, 4);

        return listaExistenciasMantenimiento;
    }

    /**
     * @param listaExistenciasMantenimiento the listaExistenciasMantenimiento to set
     */
    public void setListaExistenciasMantenimiento(List<Existencia> listaExistenciasMantenimiento) {
        this.listaExistenciasMantenimiento = listaExistenciasMantenimiento;
    }

    /**
     * @return the equiposFallidos
     */
    public List<Equiposimple> getListaEquiposFallidos() {
        if(listaEquiposFallidos.size() > 5)
            return listaEquiposFallidos.subList(0, 4);

        return listaEquiposFallidos;
    }

    /**
     * @param equiposFallidos the equiposFallidos to set
     */
    public void setListaEquiposFallidos(List<Equiposimple> listaEquiposFallidos) {
        this.listaEquiposFallidos = listaEquiposFallidos;
    }

    /**
     * @return the equiposMantenimiento
     */
    public List<Equiposimple> getListaEquiposMantenimiento() {
        if(listaEquiposMantenimiento.size() > 5)
            return listaEquiposMantenimiento.subList(0, 4);

        return listaEquiposMantenimiento;
    }

    /**
     * @param equiposMantenimiento the equiposMantenimiento to set
     */
    public void setListaEquiposMantenimiento(List<Equiposimple> listaEquiposMantenimiento) {
        this.listaEquiposMantenimiento = listaEquiposMantenimiento;
    }

    /**
     * @return the reservasHoy
     */
    public List<Reserva> getListaReservasHoy() {
        if(listaReservasHoy.size() > 5)
            return listaReservasHoy.subList(0, 4);

        return listaReservasHoy;
    }

    /**
     * @param reservasHoy the reservasHoy to set
     */
    public void setListaReservasHoy(List<Reserva> listaReservasHoy) {
        this.listaReservasHoy = listaReservasHoy;
    }

    public int getListaExistenciasFallidasSize(){
        return this.listaExistenciasFallidas.size();
    }

    public int getListaExistenciasMantenimientoSize(){
        return this.listaExistenciasMantenimiento.size();
    }

    public int getListaEquiposFallidosSize(){
        return this.listaEquiposFallidos.size();
    }

    public int getListaEquiposMantenimientoSize(){
        return this.listaEquiposMantenimiento.size();
    }

    public int getListaReservasHoySize(){
        return this.listaReservasHoy.size();
    }
}

