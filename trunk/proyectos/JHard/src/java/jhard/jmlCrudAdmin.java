/*
 * jmlCrudAdmin.java
 *
 * Created on 09-9-2009, 10:56:59 AM
 * Copyright ramayac
 */
package jhard;

import edu.ues.jhard.beans.BeanBaseJManLab;
import edu.ues.jhard.jhardmin.LoginManager;
import edu.ues.jhard.jpa.Carrera;
import edu.ues.jhard.jpa.Curso;
import edu.ues.jhard.jpa.Materia;
import edu.ues.jhard.util.popUp;
import java.util.ArrayList;
import java.util.List;
import javax.faces.FacesException;

/**
 * <p>Page bean that corresponds to a similarly named JSP page.  This
 * class contains component definitions (and initialization code) for
 * all components that you have defined on this page, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 */
public class jmlCrudAdmin extends BeanBaseJHard {

    private int MAX_MATERIA = 30;
    private int MAX_CARRERA = 30;
    private int MAX_CURSO = 30;
    
    private popUp popup = new popUp("Aviso", "", false);

    private BeanBaseJManLab jml = new BeanBaseJManLab();

    private List<Materia> listaMateria = new ArrayList<Materia>();
    private List<Carrera> listaCarrera = new ArrayList<Carrera>();
    private List<Curso> listaCurso = new ArrayList<Curso>();

    public BeanBaseJManLab getJml() {
        return jml;
    }

    public void setJml(BeanBaseJManLab jml) {
        this.jml = jml;
    }
    
    public popUp getPopup() {
        return popup;
    }

    public void setPopup(popUp popup) {
        this.popup = popup;
    }

    public List<Carrera> getListaCarrera() {
        return listaCarrera;
    }

    public void setListaCarrera(List<Carrera> listaCarrera) {
        this.listaCarrera = listaCarrera;
    }

    public List<Curso> getListaCurso() {
        return listaCurso;
    }

    public void setListaCurso(List<Curso> listaCurso) {
        this.listaCurso = listaCurso;
    }

    public List<Materia> getListaMateria() {
        return listaMateria;
    }

    public void setListaMateria(List<Materia> listaMateria) {
        this.listaMateria = listaMateria;
    }

    public Boolean getHayMateria(){
        if(this.listaMateria.size()>0) return true;
        return false;
    }

    public Boolean getHayCarrera(){
        if(this.listaCarrera.size()>0) return true;
        return false;
    }

    public Boolean getHayCurso(){
        if(this.listaCurso.size()>0) return true;
        return false;
    }

    public boolean getShowPagMateria(){
        if(this.listaMateria.size()>MAX_MATERIA) return true;
        return false;
    }

    public boolean getShowPagCarrera(){
        if(this.listaCarrera.size()>MAX_CARRERA) return true;
        return false;
    }

    public boolean getShowPagCurso(){
        if(this.listaCurso.size()>MAX_CURSO) return true;
        return false;
    }

    public String btnOK_action() {
        this.popup.setVisible(false);
        return EMPTY_STRING;
    }

    public String EditarMateria(){
        //String idS = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("idMateria");
        //Integer id = Integer.parseInt(idArticulo);
        return EMPTY_STRING;
    }

    public String EliminarMateria(){
        //String idS = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("idMateria");
        //Integer id = Integer.parseInt(idArticulo);
        return EMPTY_STRING;
    }

    public String EditarCurso(){
        //String idS = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("idCurso");
        //Integer id = Integer.parseInt(idArticulo);
        return EMPTY_STRING;
    }

    public String EliminarCurso(){
        //String idS = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("idCurso");
        //Integer id = Integer.parseInt(idArticulo);
        return EMPTY_STRING;
    }

    public String EditarCarrera(){
        //String idS = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("idCarrera");
        //Integer id = Integer.parseInt(idArticulo);
        return EMPTY_STRING;
    }

    public String EliminarCarrera(){
        //String idS = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("idCarrera");
        //Integer id = Integer.parseInt(idArticulo);
        return EMPTY_STRING;
    }

    public boolean getPermisos(){
        switch(this.getRolUsuarioConectado()){
            case INVALIDO:
                return false; //no hay informacion de usuario
            case ROL_ADMINISTRADOR:
            //case ROL_*: //mas roles?
                return true; //tengo los permisos
            //default:
                //break;
        }
        return false;
    }

    /**
     * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    private void _init() throws Exception {
    }

    public  BeanBaseJManLab getJManLabInstance() {
        return this.jml;
    }

    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public jmlCrudAdmin() {
        this.lu= getJHardminInstance().getCurrentUser();

        this.listaCarrera = this.getJManLabInstance().getAllCarreras();
        this.listaMateria = this.getJManLabInstance().getAllMaterias();
        this.listaCurso = this.getJManLabInstance().getAllCursos();
        //if(this.listaCarrera.size()>0) this.articuloActual = this.listaArticulos.get(0);

        if(this.lu!=null){
            this.U = LoginManager.getInstance().getUsuario(lu);
            this.lblUser.setValue(U.getNombre());

            switch(this.U.getIdrol().getIdrol()){
                case ROL_ADMINISTRADOR:
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
    public void init() {
        // Perform initializations inherited from our superclass
        super.init();
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
