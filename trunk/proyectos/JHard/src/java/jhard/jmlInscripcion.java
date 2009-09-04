/*
 * jmlInscripcion.java
 *
 * Created on 08-02-2009, 02:19:12 PM
 * Copyright rodrigo
 */
package jhard;

import edu.ues.jhard.beans.BeanBaseJManLab;
import edu.ues.jhard.jpa.Curso;
import edu.ues.jhard.jpa.Estudiante;
import edu.ues.jhard.jpa.Inscripcion;
import edu.ues.jhard.util.popUp;
import java.util.ArrayList;
import java.util.List;
import javax.faces.FacesException;
import javax.faces.context.FacesContext;

/**
 * <p></p>
 */
public class jmlInscripcion extends BeanBaseJHard {

    private popUp popup = new popUp("Aviso", "", false);

    public popUp getPopup() {
        return popup;
    }

    public void setPopup(popUp popup) {
        this.popup = popup;
    }
    private List<Curso> listaCursos = new ArrayList<Curso>();
    private Curso cursoSeleccionado = new Curso();
    private BeanBaseJManLab jmanLabInstance = new BeanBaseJManLab();

    public Curso getCursoSeleccionado() {
        return cursoSeleccionado;
    }

    public void setCursoSeleccionado(Curso cursoSeleccionado) {
        this.cursoSeleccionado = cursoSeleccionado;
    }

    public List<Curso> getListaCursos() {
        return listaCursos;
    }

    public void setListaCursos(List<Curso> listaCursos) {
        this.listaCursos = listaCursos;
    }

    public BeanBaseJManLab getJmanLabInstance() {
        return jmanLabInstance;
    }

    public String btnGoBegin_action() {
        cargaCursosDeEstudiante();
        this.popup.setVisible(false);
        return EMPTY_STRING;
    }

    public String cancelar() {
        this.paso(0);
        return EMPTY_STRING;
    }

    public String inscribirCurso() {
        String idS = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("idCurso");
        Integer id = Integer.parseInt(idS);

        this.cursoSeleccionado = this.getJmanLabInstance().getCurso(id.intValue());

        Integer inscritos = this.getJmanLabInstance().getInscripcionCurso(cursoSeleccionado);
        System.out.println("Alumnos inscritos a este curso: " + inscritos + ", max: " + this.cursoSeleccionado.getCupomax());

        if (inscritos <= this.cursoSeleccionado.getCupomax()) {
            List<Inscripcion> lstInscripciones = this.getJmanLabInstance().getInscripcionCursoEstudiante(cursoSeleccionado, this.getEstudianteUsuario());

            if (lstInscripciones.size() > 0) {
                popup.setMensaje("Usted ya está inscrito en este curso.");
            } else {
                Inscripcion nuevaInscripcion = new Inscripcion();
                nuevaInscripcion.setIdestudiante(this.getEstudianteUsuario());
                nuevaInscripcion.setIdcurso(cursoSeleccionado);

                if (this.jmanLabInstance.createInscripcion(nuevaInscripcion)) {
                    popup.setMensaje("Inscripción confirmada.");
                } else {
                    popup.setMensaje("No se pudo realizar la inscripción.");
                }
            }
        } else {
            popup.setMensaje("El curso llegó a su cupo máximo.");
        }
        popup.setVisible(true);

        return EMPTY_STRING;
    }

    private void cargaCursosDeEstudiante() {
        boolean hayusuariologueado = this.getHayUsuarioLogueado();
        if (hayusuariologueado) {
            Estudiante est = this.getEstudianteUsuario();
            if (est != null) {
                this.listaCursos = jmanLabInstance.getCursosCicloEstudianteHabilitado(est);
                //System.out.println("Es estudiante, y los cursos que puede ver el estudiante son: " + this.listaCursos.size());
            }
        }
    }

    private void paso(int i) {
        switch (i) {
            default:
                this.popup.setVisible(false);
                break;
        }
    }

    public boolean getPermisos() {
        switch (this.getRolUsuarioConectado()) {
            case -1:
                return false; //no hay informacion de usuario
            case ROL_ESTUDIANTE:
                return true; //tengo los permisos
            //default:
            //break;
        }
        return false;
    }

    public jmlInscripcion() {
        cargaCursosDeEstudiante();
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
}