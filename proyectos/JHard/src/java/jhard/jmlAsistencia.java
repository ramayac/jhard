/*
 * jmlAsistencia.java
 *
 * Created on 08-02-2009, 02:19:12 PM
 * Copyright rodrigo
 */
package jhard;

import edu.ues.jhard.beans.BeanBaseJManLab;
import edu.ues.jhard.jpa.Asistencia;
import edu.ues.jhard.jpa.Clase;
import edu.ues.jhard.jpa.Curso;
import edu.ues.jhard.jpa.Estudiante;
import edu.ues.jhard.jpa.Horario;
import edu.ues.jhard.util.Utilidades;
import edu.ues.jhard.util.popUp;
import java.util.ArrayList;
import java.util.List;
import javax.faces.FacesException;
import javax.faces.context.FacesContext;

/**
 * <p></p>
 */
public class jmlAsistencia extends BeanBaseJHard {

    private popUp popup = new popUp("Aviso", "", false);

    public popUp getPopup() {
        return popup;
    }

    public void setPopup(popUp popup) {
        this.popup = popup;
    }

    private List<Clase> listaClases = new ArrayList<Clase>();
    private List<Curso> listaCursos = new ArrayList<Curso>();
    private List<Horario> listaHorario = new ArrayList<Horario>();
    //private List<Existencia> listaExistencia = new ArrayList<Existencia>();

    private Boolean paso1 = new Boolean(false);
    private Boolean paso2 = new Boolean(false);

    private Curso cursoSeleccionado = new Curso();
    private Clase claseSeleccionada = new Clase();
    //private Existencia existenciaSeleccionada = new Existencia();
    private BeanBaseJManLab jmanLabInstance = new BeanBaseJManLab();

//    public List<Existencia> getListaExistencia() {
//        return listaExistencia;
//    }
//
//    public void setListaExistencia(List<Existencia> listaExistencia) {
//        this.listaExistencia = listaExistencia;
//    }

    public Clase getClaseSeleccionada() {
        return claseSeleccionada;
    }

    public void setClaseSeleccionada(Clase claseSeleccionada) {
        this.claseSeleccionada = claseSeleccionada;
    }

    public Curso getCursoSeleccionado() {
        return cursoSeleccionado;
    }

    public void setCursoSeleccionado(Curso cursoSeleccionado) {
        this.cursoSeleccionado = cursoSeleccionado;
    }

    public List<Clase> getListaClases() {
        return listaClases;
    }

    public Boolean getHayClases(){
        if(this.listaClases.size()>0) return true;
        return false;
    }

    public void setListaClases(List<Clase> listaClases) {
        this.listaClases = listaClases;
    }

    public List<Curso> getListaCursos() {
        return listaCursos;
    }

    public void setListaCursos(List<Curso> listaCursos) {
        this.listaCursos = listaCursos;
    }

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

    public List<Horario> getListaHorario() {
        return listaHorario;
    }

    public void setListaHorario(List<Horario> listaHorario) {
        this.listaHorario = listaHorario;
    }

    public BeanBaseJManLab getJmanLabInstance() {
        return jmanLabInstance;
    }

    public String elegirCurso() {
        String idS = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("idCurso");
        Integer id = Integer.parseInt(idS);

        this.listaClases.clear();
        this.listaHorario.clear();

        this.cursoSeleccionado = this.jmanLabInstance.getCurso(id.intValue());
        this.listaHorario = this.jmanLabInstance.getHorariosCurso(cursoSeleccionado);
        //List<Existencia> lstExistencia = new ArrayList<Existencia>();

        for (Horario horario : listaHorario) {
            List<Clase>lstClase = (List<Clase>)horario.getClaseCollection();
            for (Clase clase : lstClase)
                if(!clase.getFinalizada())
                    if(Utilidades.EsDeHoy(clase.getFecha())){
                        if(Utilidades.EsAntesDeHora(clase.getHorafin())){
                            this.listaClases.add(clase);
                            //lstExistencia.addAll(horario.getIdaula().getExistenciaCollection());
                        }
                    }
        }
        
        this.paso(2);
        return EMPTY_STRING;
    }

//    public String elegirExistencia() {
//        String idS = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("idExistencia");
//        Integer id = Integer.parseInt(idS);
//
//        this.existenciaSeleccionada = this.jmanLabInstance.getExistencia(id);
//
//        this.paso(3);
//        return EMPTY_STRING;
//    }


    public String marcaAsistenciaClase() {
        String idS = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("idClase");
        Integer id = Integer.parseInt(idS);
        this.claseSeleccionada = this.jmanLabInstance.getClase(id.intValue());

        Asistencia nuevaAsistencia = new Asistencia();
        nuevaAsistencia.setIdclase(claseSeleccionada);
        //nuevaAsistencia.setIdequipoexistente(existenciaSeleccionada);
        nuevaAsistencia.setIdestudiante(this.getEstudianteUsuario());

        List<Asistencia> lstAsistencia = new ArrayList<Asistencia>();
        lstAsistencia = this.jmanLabInstance.getAsistenciasClaseEstudiante(claseSeleccionada, this.getEstudianteUsuario());

        if(lstAsistencia.size()>0){
            popup.setMensaje("Ya esta marcada la existencia.");
        } else {
            if(this.jmanLabInstance.createAsistencia(nuevaAsistencia)){
                popup.setMensaje("Asistencia confirmada.");
            } else {
                popup.setMensaje("No se pudo confirmar la asistencia.");
            }    
        }

        popup.setVisible(true);
        return EMPTY_STRING;
    }

    public String btnGoBegin_action() {
        cargaCursosDeEstudiante();
        this.paso(1);
        return EMPTY_STRING;
    }

    public String cancelar(){
        this.paso(1);
        return EMPTY_STRING;
    }

    private void cargaCursosDeEstudiante() {
        boolean hayusuariologueado = this.getHayUsuarioLogueado();
        if (hayusuariologueado) {
            Estudiante est = this.getEstudianteUsuario();
            if (est!=null) {
                this.listaCursos = jmanLabInstance.getCursosCicloEstudiante(est);
                System.out.println("Es estudiante, y los cursos que puede ver el estudiante son: " + this.listaCursos.size());
            }
        }
    }

    private void paso(int i) {
        switch (i) {
            case 1:
                this.popup.setVisible(false);
                this.setPaso1(true);
                this.setPaso2(false);
                break;
            case 2:
                this.popup.setVisible(false);
                this.setPaso1(false);
                this.setPaso2(true);
                break;
            default:
                this.popup.setVisible(false);
                this.setPaso1(true);
                this.setPaso2(false);
                break;
        }
    }

    public boolean getPermisos(){
        switch(this.getRolUsuarioConectado()){
            case -1:
                return false; //no hay informacion de usuario
            case ROL_ESTUDIANTE:
                return true; //tengo los permisos
            //default:
                //break;
        }
        return false;
    }

    public jmlAsistencia() {
        //this.lu= getJHardminInstance().getCurrentUser();
        cargaCursosDeEstudiante();
        this.paso(1);
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


    //    private List dictionary;
//    private Clase currentClase = new Clase();
//    private List matchesList = new ArrayList();
//
//
//    public static final Comparator LABEL_COMPARATOR = new Comparator() {
//        String s1;
//        String s2;
//
//        // compare method for city entries.
//        public int compare(Object o1, Object o2) {
//
//            if (o1 instanceof SelectItem) {
//                s1 = ((SelectItem) o1).getLabel();
//            } else {
//                s1 = o1.toString();
//            }
//
//            if (o2 instanceof SelectItem) {
//                s2 = ((SelectItem) o2).getLabel();
//            } else {
//                s2 = o2.toString();
//            }
//            // compare ingnoring case, give the user a more automated feel when typing
//            return s1.compareToIgnoreCase(s2);
//        }
//    };
//
//    /**
//     * Called when a user has modifed the SelectInputText value.  This method
//     * call causes the match list to be updated.
//     *
//     * @param event
//     */
//    public void updateList(ValueChangeEvent event) {
//
//        // get a new list of matches.
//        setMatches(event);
//
//        // Get the auto complete component from the event and assing
//        if (event.getComponent() instanceof SelectInputText) {
//            SelectInputText autoComplete = (SelectInputText) event.getComponent();
//            // if no selected item then return the previously selected item.
//            if (autoComplete.getSelectedItem() != null) {
//                currentClase = (Clase) autoComplete.getSelectedItem().getValue();
//            }
//            // otherwise if there is a selected item get the value from the match list
//            else {
//                Clase temp = getMatch(autoComplete.getValue().toString());
//                if (temp != null) {
//                    currentClase = temp;
//                }
//            }
//        }
//    }
//
//    /**
//     * Utility method for building the match list given the current value of the
//     * SelectInputText component.
//     *
//     * @param event
//     */
//    private void setMatches(ValueChangeEvent event) {
//        Object searchWord = event.getNewValue();
//        int maxMatches = ((SelectInputText) event.getComponent()).getRows();
//        List matchList = new ArrayList(maxMatches);
//
//        try {
//            int insert = Collections.binarySearch(dictionary, searchWord, jmlAsistencia.LABEL_COMPARATOR);
//
//            if (insert < 0) { // less then zero if wer have a partial match
//                insert = Math.abs(insert) - 1;
//            }
//
//            for (int i = 0; i < maxMatches; i++) {
//                // quit the match list creation if the index is larger then
//                // max entries in the dictionary if we have added maxMatches.
//                if ((insert + i) >= dictionary.size() ||
//                    i >= maxMatches) {
//                    break;
//                }
//                matchList.add(dictionary.get(insert + i));
//            }
//        } catch (Throwable e) {
//           // log.error("Erorr finding autocomplete matches", e);
//        }
//        // assign new matchList
//        if (this.matchesList != null) {
//            this.matchesList.clear();
//            this.matchesList = null;
//        }
//        this.matchesList = matchList;
//    }
//
//    private Clase getMatch(String value) {
//        Clase result = null;
//        if (matchesList != null) {
//            SelectItem si;
//            Iterator iter = matchesList.iterator();
//            while (iter.hasNext()) {
//                si = (SelectItem) iter.next();
//                if (value.equals(si.getLabel())) {
//                    result = (Clase) si.getValue();
//                }
//            }
//        }
//        return result;
//    }

}