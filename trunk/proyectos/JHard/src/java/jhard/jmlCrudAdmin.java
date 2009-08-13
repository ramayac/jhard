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
import edu.ues.jhard.jpa.Cicloanyo;
import edu.ues.jhard.jpa.Curso;
import edu.ues.jhard.jpa.Docente;
import edu.ues.jhard.jpa.Facultad;
import edu.ues.jhard.jpa.Instructor;
import edu.ues.jhard.jpa.Materia;
import edu.ues.jhard.util.Utilidades;
import edu.ues.jhard.util.popUp;
import java.util.ArrayList;
import java.util.List;
import java.util.TimeZone;
import javax.faces.FacesException;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;
import javax.servlet.http.HttpServletRequest;

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
    private List<Facultad> listaFacultad = new ArrayList<Facultad>();
    private List<Docente> listaDocente = new ArrayList<Docente>();
    private List<Instructor> listaInstructor = new ArrayList<Instructor>();

    private Materia nuevaMateria = new Materia();
    private Carrera nuevaCarrera = new Carrera();
    private Curso nuevoCurso = new Curso();

    private Carrera selectedCarrera = new Carrera();
    private List<SelectItem> listaCarreraSel = new ArrayList<SelectItem>();

    private Materia selectedMateria = new Materia();
    private List<SelectItem> listaMateriaSel = new ArrayList<SelectItem>();
    private Docente selectedDocente = new Docente();
    private List<SelectItem> listaDocenteSel = new ArrayList<SelectItem>();
    private Instructor selectedInstructor = new Instructor();
    private List<SelectItem> listaInstructorSel = new ArrayList<SelectItem>();

    public List<Docente> getListaDocente() {
        return listaDocente;
    }

    public void setListaDocente(List<Docente> listaDocente) {
        this.listaDocente = listaDocente;
    }

    public List<Instructor> getListaInstructor() {
        return listaInstructor;
    }

    public void setListaInstructor(List<Instructor> listaInstructor) {
        this.listaInstructor = listaInstructor;
    }

    public Instructor getSelectedInstructor() {
        return selectedInstructor;
    }

    public void setSelectedInstructor(Instructor selectedInstructor) {
        this.selectedInstructor = selectedInstructor;
    }

    public void setListaDocenteSel(List<SelectItem> listaDocenteSel) {
        this.listaDocenteSel = listaDocenteSel;
    }

    public void setListaInstructorSel(List<SelectItem> listaInstructorSel) {
        this.listaInstructorSel = listaInstructorSel;
    }

    public void setListaMateriaSel(List<SelectItem> listaMateriaSel) {
        this.listaMateriaSel = listaMateriaSel;
    }

    public Carrera getSelectedCarrera() {
        return selectedCarrera;
    }

    public void setSelectedCarrera(Carrera selectedCarrera) {
        this.selectedCarrera = selectedCarrera;
    }

    public Docente getSelectedDocente() {
        return selectedDocente;
    }

    public void setSelectedDocente(Docente selectedDocente) {
        this.selectedDocente = selectedDocente;
    }

    public Materia getSelectedMateria() {
        return selectedMateria;
    }

    public void setListaCarreraSel(List listaCarreraSel) {
        this.listaCarreraSel = listaCarreraSel;
    }

    public void setSelectedMateria(Materia selectedMateria) {
        this.selectedMateria = selectedMateria;
    }

    public void selDocente(ValueChangeEvent event) {
        //System.out.println("se ejecuto valueChange >>>>>>"+event.getNewValue().toString());
        Integer id = Integer.parseInt(event.getNewValue().toString());
        this.selectedDocente = this.getJManLabInstance().getDocente(id);
        //this.mySelCarreraItem = new SelectItem(this.selectedCarrera.getIdcarrera(), this.selectedCarrera.getCodigo()+"-"+this.selectedCarrera.getNombre());
    }

    public void selInstructor(ValueChangeEvent event) {
        //System.out.println("se ejecuto valueChange >>>>>>"+event.getNewValue().toString());
        Integer id = Integer.parseInt(event.getNewValue().toString());
        this.selectedInstructor = this.getJManLabInstance().getInstructor(id);
        //this.mySelCarreraItem = new SelectItem(this.selectedCarrera.getIdcarrera(), this.selectedCarrera.getCodigo()+"-"+this.selectedCarrera.getNombre());
    }

    public void selMateria(ValueChangeEvent event) {
        //System.out.println("se ejecuto valueChange >>>>>>"+event.getNewValue().toString());
        Integer id = Integer.parseInt(event.getNewValue().toString());
        this.selectedMateria = this.getJManLabInstance().getMateria(id);
        //this.mySelCarreraItem = new SelectItem(this.selectedCarrera.getIdcarrera(), this.selectedCarrera.getCodigo()+"-"+this.selectedCarrera.getNombre());
    }

    public void selCarrera(ValueChangeEvent event) {
        //System.out.println("se ejecuto valueChange >>>>>>"+event.getNewValue().toString());
        Integer id = Integer.parseInt(event.getNewValue().toString());
        this.selectedCarrera = this.getJManLabInstance().getCarrera(id);
        //this.mySelCarreraItem = new SelectItem(this.selectedCarrera.getIdcarrera(), this.selectedCarrera.getCodigo()+"-"+this.selectedCarrera.getNombre());
    }

    public List getListaCarreraSel() {
        listaCarreraSel.clear();
        for (Carrera c : listaCarrera) {
            listaCarreraSel.add(new SelectItem(c.getIdcarrera(), c.getCodigo()+"-"+c.getNombre()));
        }
        return listaCarreraSel;
    }

    public List<SelectItem> getListaDocenteSel() {
        listaDocenteSel.clear();
        for (Docente d : listaDocente) {
            listaDocenteSel.add(new SelectItem(d.getIddocente(), d.getApellidos()+", "+d.getNombres()));
        }
        return listaDocenteSel;
    }

    public List<SelectItem> getListaInstructorSel() {
        listaInstructorSel.clear();
        for (Instructor i : listaInstructor) {
            listaInstructorSel.add(new SelectItem(i.getIdusuario(), i.getApellidos()+", "+i.getNombres()));
        }
        return listaInstructorSel;
    }

    public List<SelectItem> getListaMateriaSel() {
        listaMateriaSel.clear();
        for (Materia m : listaMateria) {
            listaMateriaSel.add(new SelectItem(m.getIdmateria(), m.getNombre()));
        }
        return listaMateriaSel;
    }

    //private SelectItem mySelCarreraItem = new SelectItem();

    //public SelectItem getMySelCarreraItem() {
    //    return mySelCarreraItem;
    //}

    //public void setMySelCarreraItem() {
        //System.out.println("se ejecuto setMySelCarreraItem");
        //Integer id = Integer.parseInt(mySelCarreraItem);
        //this.selectedCarrera = this.getJManLabInstance().getCarrera(id);
        //this.mySelCarreraItem = new SelectItem(this.selectedCarrera.getIdcarrera(), this.selectedCarrera.getCodigo()+"-"+this.selectedCarrera.getNombre());
    //}

    //public void setMySelCarreraItem(SelectItem mySelCarreraItem) {
    //    this.mySelCarreraItem = mySelCarreraItem;
    //    System.out.println("se ejecuto setMySelCarreraItem con SelectItem");
    //}

    //public void setMySelCarreraItem(String mySelCarreraItem) {
        //this.mySelCarreraItem = mySelCarreraItem;
        //System.out.println("se ejecuto setMySelCarreraItem con STRING!");
    //}

    public Carrera getNuevaCarrera() {
        return nuevaCarrera;
    }

    public void setNuevaCarrera(Carrera nuevaCarrera) {
        this.nuevaCarrera = nuevaCarrera;
    }

    public Materia getNuevaMateria() {
        return nuevaMateria;
    }

    public void setNuevaMateria(Materia nuevaMateria) {
        this.nuevaMateria = nuevaMateria;
    }

    public Curso getNuevoCurso() {
        return nuevoCurso;
    }

    public void setNuevoCurso(Curso nuevoCurso) {
        this.nuevoCurso = nuevoCurso;
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

    public String editarCurso(){
       String idS = ((HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest()).getParameter("idCurso");
       Integer id = new Integer(idS);
       this.nuevoCurso = this.getJManLabInstance().getCurso(id.intValue());
       return EMPTY_STRING;
    }

    public String eliminarCurso(){
       String idS = ((HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest()).getParameter("idCurso");
       Integer id = new Integer(idS);
       Curso curso = this.getJManLabInstance().getCurso(id.intValue());
       try {
            this.getJManLabInstance().deleteCurso(curso.getIdcurso());
            this.popup.setMensaje("El curso fué eliminado.");
            this.listaCurso.clear();
            this.listaCurso = this.getJManLabInstance().getAllCursos();
       } catch (Exception e) {
            this.popup.setMensaje("Ocurrió un error al intentar eliminar la carrera.");
       } finally {
           this.popup.setVisible(true);
       }
       return EMPTY_STRING;
    }

    public String btnCurso_action() {
        Integer id = this.nuevoCurso.getIdcurso();
        if(id==null) id = 0;

        //TODO: Validaciones aqui... REM que docente e instructor pueden ir null
        //this.nuevoCurso.setIddocente(selectedDocente);
        //this.nuevoCurso.setIdinstructor(selectedInstructor);
        this.nuevoCurso.setIdmateria(selectedMateria);
        this.nuevoCurso.setAnio(Utilidades.EsteAnyo());

        String strCiclo = new String();
        switch(this.nuevoCurso.getCiclo()){
            case 1: strCiclo = "I";
                break;
            case 2: strCiclo = "II";
                break;
            default:
                break;
        }

        System.out.println(strCiclo+" - "+this.nuevoCurso.getAnio());
        Cicloanyo cay = this.getJManLabInstance().searchCicloAnyoByDesc(strCiclo+" - "+this.nuevoCurso.getAnio());
        System.out.println(cay.getDescripcion());
        
        this.nuevoCurso.setIdcicloanio(cay); //SHIIIIT! ;(
        this.nuevoCurso.setAnio(Utilidades.EsteAnyo());
        this.nuevoCurso.setIddocente(selectedDocente);

        if(id>0){
            if (this.getJManLabInstance().updateCurso(this.nuevoCurso)) {
                this.popup.setMensaje("Curso modificado con éxito.");
                this.popup.setVisible(true);
                this.listaCurso.clear();
                this.listaCurso = this.getJManLabInstance().getAllCursos();
            } else {
                this.popup.setMensaje("Ocurrió un error al intentar modificar el curso");
                this.popup.setVisible(true);
            }
        } else {
            if (this.getJManLabInstance().createCurso(this.nuevoCurso)) {
                this.popup.setMensaje("Curso agregado con éxito.");
                this.popup.setVisible(true);
                this.listaCurso.clear();
                this.listaCurso = this.getJManLabInstance().getAllCursos();
            } else {
                this.popup.setMensaje("Ocurrió un error al intentar agregar el curso.");
                this.popup.setVisible(true);
            }
        }
        this.nuevoCurso = new Curso();
        return EMPTY_STRING;
    }

    public String btnCursoClean_action() {
        this.nuevoCurso = new Curso();
        return EMPTY_STRING;
    }

    public String btnMateriaClean_action() {
        this.nuevaMateria = new Materia();
        return EMPTY_STRING;
    }

    public String btnCarreraClean_action() {
        this.nuevaCarrera = new Carrera();
        return EMPTY_STRING;
    }

    public String btnOK_action() {
        this.popup.setVisible(false);
        return EMPTY_STRING;
    }

    public String btnCarrera_action() {
        Integer id = this.nuevaCarrera.getIdcarrera();
        if(id==null) id = 0;

        this.nuevaCarrera.setIdfacultad(this.listaFacultad.get(0));

        if(id>0){
            if (this.getJManLabInstance().updateCarrera(this.nuevaCarrera)) {
                this.popup.setMensaje("Carrera modificada con éxito.");
                this.popup.setVisible(true);
                this.listaCarrera.clear();
                this.listaCarrera = this.getJManLabInstance().getAllCarreras();
            } else {
                this.popup.setMensaje("Ocurrió un error al intentar modificar la carrera.");
                this.popup.setVisible(true);
            }
        } else {
            if (this.getJManLabInstance().createCarrera(this.nuevaCarrera)) {
                this.popup.setMensaje("Carrera agregada con éxito.");
                this.popup.setVisible(true);
                this.listaCarrera.clear();
                this.listaCarrera = this.getJManLabInstance().getAllCarreras();
            } else {
                this.popup.setMensaje("Ocurrió un error al intentar agregar la carrera.");
                this.popup.setVisible(true);
            }
        }
        this.nuevaCarrera = new Carrera();
        return EMPTY_STRING;
    }

    public String editarCarrera(){
       String idS = ((HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest()).getParameter("idCarrera");
       Integer id = new Integer(idS);
       this.nuevaCarrera = this.getJManLabInstance().getCarrera(id.intValue());
       return EMPTY_STRING;
    }

    public String eliminarCarrera(){
       String idS = ((HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest()).getParameter("idCarrera");
       Integer id = new Integer(idS);
       Carrera carrera = this.getJManLabInstance().getCarrera(id.intValue());
       try {
            this.getJManLabInstance().deleteCarrera(carrera.getIdcarrera());
            this.popup.setMensaje("La Carrera fué eliminada.");
            this.listaCarrera.clear();
            this.listaCarrera = this.getJManLabInstance().getAllCarreras();
       } catch (Exception e) {
            this.popup.setMensaje("Ocurrió un error al intentar eliminar la carrera.");
       } finally {
           this.popup.setVisible(true);
       }
       return EMPTY_STRING;
    }

     public String btnMateria_action() {
        Integer id = this.nuevaMateria.getIdmateria();
        this.nuevaMateria.setIdcarrera(this.selectedCarrera);
        if(id==null) id = 0;

        if(id>0){
            if (this.getJManLabInstance().updateMateria(this.nuevaMateria)) {
                this.popup.setMensaje("Materia modificada con éxito.");
                this.popup.setVisible(true);
                this.listaMateria.clear();
                this.listaMateria = this.getJManLabInstance().getAllMaterias();
                //this.mySelCarreraItem = new SelectItem();
            } else {
                this.popup.setMensaje("Ocurrió un error al intentar modificar la materia.");
                this.popup.setVisible(true);
            }
        } else {
            if (this.getJManLabInstance().createMateria(this.nuevaMateria)) {
                this.popup.setMensaje("Materia agregada con éxito.");
                this.popup.setVisible(true);
                this.listaMateria.clear();
                this.listaMateria = this.getJManLabInstance().getAllMaterias();
                //this.mySelCarreraItem = new SelectItem();
            } else {
                this.popup.setMensaje("Ocurrió un error al intentar agregar la materia.");
                this.popup.setVisible(true);
            }
        }
        this.nuevaMateria = new Materia();
        return EMPTY_STRING;
    }

    public String editarMateria(){
       //this.popup.setMensaje("U call?"); this.popup.setVisible(true);
       String idS = ((HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest()).getParameter("idMateria");
       Integer id = new Integer(idS);
       this.nuevaMateria = this.getJManLabInstance().getMateria(id.intValue());
       Carrera carr = this.nuevaMateria.getIdcarrera();
       System.out.println(carr.getCodigo()+"-"+carr.getNombre());
       //this.mySelCarreraItem = new SelectItem(carr.getIdcarrera(), carr.getCodigo()+"-"+carr.getNombre());
       return EMPTY_STRING;
    }

    public String eliminarMateria(){
       String idS = ((HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest()).getParameter("idMateria");
       Integer id = new Integer(idS);
       Materia materia = this.getJManLabInstance().getMateria(id.intValue());
       try {
            this.getJManLabInstance().deleteMateria(materia.getIdmateria());
            this.popup.setMensaje("La materia fué eliminada.");
            this.listaCarrera.clear();
            this.listaCarrera = this.getJManLabInstance().getAllCarreras();
       } catch (Exception e) {
            this.popup.setMensaje("Ocurrió un error al intentar eliminar la materia.");
       } finally {
           this.popup.setVisible(true);
       }
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

    public TimeZone getTimeZone() {
        return java.util.TimeZone.getDefault();
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

        this.listaCarrera = this.getJManLabInstance().getAllCarreras();
        this.listaMateria = this.getJManLabInstance().getAllMaterias();
        this.listaCurso = this.getJManLabInstance().getAllCursos();
        this.listaFacultad = this.getJManLabInstance().getAllFacultades();
        this.listaDocente = this.getJManLabInstance().getAllDocentes();
        //if(this.listaCarrera.size()>0) this.articuloActual = this.listaArticulos.get(0);
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
