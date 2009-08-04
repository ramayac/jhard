/*
 * jmlGestionaClase.java
 *
 * Created on 08-02-2009, 03:07:30 PM
 * Copyright rodrigo
 */
package jhard;

import edu.ues.jhard.beans.BeanBaseManLab;
import edu.ues.jhard.jpa.Clase;
import edu.ues.jhard.jpa.Curso;
import edu.ues.jhard.jpa.Docente;
import edu.ues.jhard.jpa.Horario;
import edu.ues.jhard.jpa.Instructor;
import edu.ues.jhard.util.Utilidades;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.FacesException;
import javax.faces.context.FacesContext;


public class jmlGestionaClase extends BeanBaseJHard {

    private BeanBaseManLab jmanLabInstance = new BeanBaseManLab();
    private List<Horario> listaHorario = new ArrayList<Horario>();
    private List<Curso> listaCursos = new ArrayList<Curso>();

    private Boolean paso1 = new Boolean(true);
    private Boolean paso2 = new Boolean(false);
    private Boolean paso3 = new Boolean(false);

    private Boolean iniciarClase = new Boolean(false);
    private Boolean terminarClase = new Boolean(false);

    private Horario horarioSeleccionado = new Horario();
    private Clase nuevaClase = new Clase();
    private Curso cursoSeleccionado = new Curso();

    public Boolean getPaso1() {
        return paso1;
    }

    public void setPaso1(Boolean paso1) {
        this.paso1 = paso1;
    }

    public Boolean getPaso2() {
        return paso2;
    }

    public void setPaso2(Boolean paso2) {
        this.paso2 = paso2;
    }

    public Boolean getPaso3() {
        return paso3;
    }

    public void setPaso3(Boolean paso3) {
        this.paso3 = paso3;
    }

    public Curso getCursoSeleccionado() {
        return cursoSeleccionado;
    }

    public void setCursoSeleccionado(Curso cursoSeleccionado) {
        this.cursoSeleccionado = cursoSeleccionado;
    }

    public Horario getHorarioSeleccionado() {
        return horarioSeleccionado;
    }

    public Boolean getHayHorariosValidos(){
        if (this.getListaHorariosValidos().isEmpty()) return false;
        return true;
    }

    public void setHorarioSeleccionado(Horario horarioSeleccionado) {
        this.horarioSeleccionado = horarioSeleccionado;
    }

    public BeanBaseManLab getJmanLabInstance() {
        return jmanLabInstance;
    }

    public List<Curso> getListaCursos() {
        return listaCursos;
    }

    public void setListaCursos(List<Curso> listaCursos) {
        this.listaCursos = listaCursos;
    }

    public List<Horario> getListaHorario() {
        return listaHorario;
    }

    public List<Horario> getListaHorariosValidos(){
        List<Horario> listaHorariosValidos = new ArrayList<Horario>();
        for (Horario horario : this.listaHorario) {
            if (horario.getDiasemana() == Utilidades.DiaHoyEntero()){
                if (Utilidades.EsAntesDeHora(horario.getHorafin())) {
                    listaHorariosValidos.add(horario);
                }
            }
        }
        return listaHorariosValidos;
    }

    public void setListaHorario(List<Horario> listaHorario) {
        this.listaHorario = listaHorario;
    }

    public Clase getNuevaClase() {
        return nuevaClase;
    }

    public void setNuevaClase(Clase nuevaClase) {
        this.nuevaClase = nuevaClase;
    }

    public jmlGestionaClase() {
        llenarListaCursos();
    }

   public String elegirCurso(){
        String idS = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("idCurso");
        Integer id = Integer.parseInt(idS);
        this.cursoSeleccionado = this.jmanLabInstance.getCurso(id.intValue());

        this.listaHorario = this.jmanLabInstance.getHorariosCurso(cursoSeleccionado);

        this.paso(2);
        return EMPTY_STRING;
    }

    public String elegirHorario(){
        String idS = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("idHorario");
        Integer id = Integer.parseInt(idS);
        this.horarioSeleccionado = this.jmanLabInstance.getHorario(id.intValue());

        this.nuevaClase = new Clase(NONE, new Date(), "", false);
        this.nuevaClase.setIdhorario(horarioSeleccionado);
        
        this.paso(3);
        return EMPTY_STRING;
    }

    public String iniciarClase() {
        this.nuevaClase.setHorainicio(new Date());
        this.nuevaClase.setHorafin(this.horarioSeleccionado.getHorafin()); //por defecto, se pone la hora de finalizacion segun el horario.
        this.nuevaClase.setObservaciones(EMPTY_STRING);

        Docente userDocente = getDocenteUsuario();
        Instructor userInstructor = getInstructorUsuario();
        if ((userDocente == null) && (userInstructor == null)) {
            //...
        }
        if (userDocente != null) {
            this.nuevaClase.setIddocente(userDocente);
        }
        if (userInstructor != null) {
            this.nuevaClase.setIdinstructor(userInstructor);
        }

        if(this.jmanLabInstance.createClase(nuevaClase)){
            //exito al crear la clase
            this.paso(-1);
        } else {
            //ups!
        }

        
        return EMPTY_STRING;
    }

    public String cancelar(){
        this.paso(1);
        return EMPTY_STRING;
    }

    private void llenarListaCursos() {
        try {
            Docente userDocente = getDocenteUsuario();
            Instructor userInstructor = getInstructorUsuario();
            if ((userDocente == null) && (userInstructor == null)) {
                //algo salio terriblemente mal
                this.listaCursos = getJmanLabInstance().getCursosCiclo();
                System.out.println("No es docente ni instructor");
            }
            if (userDocente != null) {
                this.listaCursos = getJmanLabInstance().getCursosDocenteCiclo(userDocente);
                System.out.println("es Docente");
            }
            if (userInstructor != null) {
                this.listaCursos = getJmanLabInstance().getCursosInstructorCiclo(userInstructor);
                System.out.println("es Instructor");
            }
            System.out.println("Tamaño listaCursos: " + this.listaCursos.size());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void paso(int i) {
        switch (i) {
            case 1:
                this.listaHorario = new ArrayList<Horario>();
                this.nuevaClase = new Clase();
                this.setPaso1(true);
                this.setPaso2(false);
                this.setPaso3(false);
                break;
            case 2:
                this.nuevaClase = new Clase();
                this.setPaso1(false);
                this.setPaso2(true);
                this.setPaso3(false);
                break;
            case 3:
                this.setPaso1(false);
                this.setPaso2(false);
                this.setPaso3(true);
                break;
            default:
                llenarListaCursos();
                this.listaHorario = new ArrayList<Horario>();
                this.nuevaClase = new Clase();
                this.setPaso1(true);
                this.setPaso2(false);
                this.setPaso3(false);
                break;
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
