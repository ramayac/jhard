package jhard;

import edu.ues.jhard.beans.BeanBaseJHardmin;
import com.icesoft.faces.component.ext.HtmlOutputLabel;
import com.sun.rave.web.ui.appbase.AbstractPageBean;
import edu.ues.jhard.jhardmin.LoggedUser;
import edu.ues.jhard.jhardmin.LoginManager;
import edu.ues.jhard.jpa.Docente;
import edu.ues.jhard.jpa.Estudiante;
import edu.ues.jhard.jpa.Instructor;
import edu.ues.jhard.jpa.Usuario;
import javax.faces.FacesException;

/**
 * @author ramayac
 * Bean con funcionalidad de autenticacion comunes a todas las paginas
 * que implementen el control login.jspx.
 */
public class BeanBaseJHard extends AbstractPageBean {

    static final int NONE = 0;
    static final int INVALIDO = -1;
    static final int ROL_INSTRUCTOR = 6;
    static final int ROL_ESTUDIANTE = 5;
    static final int ROL_EDITORCONTENIDO = 4;
    static final int ROL_DOCENTE = 3;
    static final int ROL_ADMINISTRATIVO = 2;
    static final int ROL_ADMINISTRADOR = 1;

    static final int MAX_COMENTARIOS = 10;
    static final int MAX_ENTRADAS = 5;
    
    static final String EMPTY_STRING = "";
    static final String INVITADO = "Invitado";

    protected LoggedUser lu;
    protected Usuario U;

    protected HtmlOutputLabel lblUser = new HtmlOutputLabel();

    public HtmlOutputLabel getLblUser() {
        return lblUser;
    }

    public void setLblUser(HtmlOutputLabel hol) {
        this.lblUser = hol;
    }

    public LoggedUser getLu() {
        return lu;
    }

    public Boolean getHayUsuarioLogueado() {
        if (lu == null) return false;
        return true;
    }

    public void setLu(LoggedUser lu) {
        this.lu = lu;
    }

    public Usuario getU() {
        return U;
    }

    public void setU(Usuario u) {
        this.U = u;
    }

    public BeanBaseJHardmin getJHardminInstance() {
        return (BeanBaseJHardmin) getBean("JHardminInstance");
    }

    public String getCurrentUserName() {
        if (this.lu == null) {
            return INVITADO;
        }
        if (this.U == null) {
            return INVITADO;
        }
        this.lu = getJHardminInstance().getCurrentUser();
        if (this.lu == null) {
            this.U = null;
            return INVITADO;
        } else {
            this.U = LoginManager.getInstance().getUsuario(this.lu);
        }
        return this.U.getNombre();
    }

    /**
     * Obtiene el rol del usuario conectado
     * @return
     */
    public Integer getRolUsuarioConectado() {
        if (this.U == null) {
            return INVALIDO;
        }
        //System.out.println(this.U.getIdrol().getIdrol());
        return this.U.getIdrol().getIdrol();
    }

    /**
     * Verificamos si el usuario actual tiene Rol Administrador
     * @return
     */
    public Boolean getEsRolAdministrador(){
        if(getRolUsuarioConectado()==ROL_ADMINISTRADOR) return true;
        return false;
    }

    /**
     * Verificamos si el usuario actual tiene Rol Administrativo
     * @return
     */
    public Boolean getEsRolAdministrativo(){
        if(getRolUsuarioConectado()==ROL_ADMINISTRADOR) return true;
        return false;
    }

    /**
     * Verificamos si el usuario actual tiene Rol Docente
     * @return
     */
    public Boolean getEsRolDocente(){
        if(getRolUsuarioConectado()==ROL_DOCENTE) return true;
        return false;
    }

    /**
     * Verificamos si el usuario actual tiene Rol Instructor
     * @return
     */
    public Boolean getEsRolInstructor(){
        if(getRolUsuarioConectado()==ROL_INSTRUCTOR) return true;
        return false;
    }

    /**
     * Verificamos si el usuario actual tiene Rol Estudiante
     * @return
     */
    public Boolean getEsRolEstudiante(){
        if(getRolUsuarioConectado()==ROL_ESTUDIANTE) return true;
        return false;
    }

    /**
     * Verificamos si el usuario actual tiene Rol de Editor de Contenidos
     * @return
     */
    public Boolean getEsRolEditor(){
        if(getRolUsuarioConectado()==ROL_EDITORCONTENIDO) return true;
        return false;
    }

    /**
     * Obtiene el objeto Usuario, a partir del LoggedUser actual en el sistema.
     * @return
     */
    public Usuario getUsuario(){
        if (this.lu == null) {
            return null;
        }
        /*if (this.U == null) {
            return null;
        }*/
        this.lu = getJHardminInstance().getCurrentUser();
        if (this.lu == null) {
            this.U = null;
            return null;
        } else {
            this.U = LoginManager.getInstance().getUsuario(this.lu);
        }
        return this.U;
    }

    /**
     * Obtiene el objeto Docente, a partir de un Usuario de sistema
     * @return
     */
    public Docente getDocenteUsuario(){
        try {
            return this.getUsuario().getDocenteList().get(0);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * Obtiene el objeto Estudiante, a partir de un Usuario de sistema
     * @return
     */
    public Estudiante getEstudianteUsuario(){
        try {
            return this.getUsuario().getEstudianteList().get(0);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    /**
     * Obtiene el objeto Instructor, a partir de un Usuario de sistema
     * @return
     */
    public Instructor getInstructorUsuario(){
        try {
            return this.getUsuario().getInstructorList().get(0);
        } catch (Exception e) {
            return null;
        }
    }

    public BeanBaseJHard(){
        this.lu= getJHardminInstance().getCurrentUser();
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
            log("BeanBaseJHard Initialization Failure", e);
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
     * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    private void _init() {
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
}
