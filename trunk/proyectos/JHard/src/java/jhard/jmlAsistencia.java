/*
 * jmlClase.java
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
import edu.ues.jhard.jpa.Existencia;
import edu.ues.jhard.jpa.Horario;
import edu.ues.jhard.util.Utilidades;
import edu.ues.jhard.util.popUp;
import java.util.ArrayList;
import java.util.List;
import javax.faces.context.FacesContext;

/**
 * <p></p>
 */
public class jmlAsistencia extends BeanBaseJHard {
    // <editor-fold defaultstate="collapsed" desc="Managed Component Definition">

    private int __placeholder;

    /**
     * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    private void _init() throws Exception {
    }

    // </editor-fold>

    private popUp popup = new popUp("jManLab", "", false);

    public popUp getPopup() {
        return popup;
    }

    public void setPopup(popUp popup) {
        this.popup = popup;
    }

    private List<Clase> listaClases = new ArrayList<Clase>();
    private List<Curso> listaCursos = new ArrayList<Curso>();
    private List<Horario> listaHorario = new ArrayList<Horario>();
    private List<Existencia> listaExistencia = new ArrayList<Existencia>();

    private Boolean paso1 = new Boolean(false);
    private Boolean paso2 = new Boolean(false);
    private Boolean paso3 = new Boolean(false);

    private Curso cursoSeleccionado = new Curso();
    private Clase claseSeleccionada = new Clase();
    private Existencia existenciaSeleccionada = new Existencia();
    private BeanBaseJManLab jmanLabInstance = new BeanBaseJManLab();

    public List<Existencia> getListaExistencia() {
        return listaExistencia;
    }

    public void setListaExistencia(List<Existencia> listaExistencia) {
        this.listaExistencia = listaExistencia;
    }

    public List<Clase> getListaClases() {
        return listaClases;
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

    public Boolean getPaso3() {
        return paso3;
    }

    public void setPaso3(Boolean paso3) {
        this.paso3 = paso3;
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
        List<Existencia> lstExistencia = new ArrayList<Existencia>();

        for (Horario horario : listaHorario) {
            List<Clase>lstClase = (List<Clase>)horario.getClaseCollection();
            for (Clase clase : lstClase)
                if(!clase.getFinalizada())
                    if(Utilidades.EsAntesDeHora(clase.getHorafin())){
                        this.listaClases.add(clase);
                        lstExistencia.addAll(horario.getIdaula().getExistenciaCollection());
                    }
        }

        this.listaExistencia = lstExistencia;

        this.paso(2);
        return EMPTY_STRING;
    }

    public String elegirExistencia() {
        String idS = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("idExistencia");
        Integer id = Integer.parseInt(idS);

        this.existenciaSeleccionada = this.jmanLabInstance.getExistencia(id);
        
        this.paso(3);
        return EMPTY_STRING;
    }


    public String marcaAsistenciaClase() {
        String idS = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("idCurso");
        Integer id = Integer.parseInt(idS);
        this.claseSeleccionada = this.jmanLabInstance.getClase(id.intValue());

        Asistencia nuevaAsistencia = new Asistencia();
        nuevaAsistencia.setIdclase(claseSeleccionada);
        nuevaAsistencia.setIdequipoexistente(existenciaSeleccionada);
        nuevaAsistencia.setIdestudiante(this.getEstudianteUsuario());

        if(this.jmanLabInstance.createAsistencia(nuevaAsistencia)){
            popup.setMensaje("Asistencia confirmada.");
        } else {
            popup.setMensaje("No se pudo confirmar la asistencia.");
        }
        popup.setVisible(false);

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
        System.out.println("BARFOOOOOOOOOOOOOO " + hayusuariologueado );
        if (hayusuariologueado) {
            System.out.println("hay un usuario logueado!");
            if (this.esEstudiante()) {
                Estudiante est = this.getEstudianteUsuario();
                this.listaCursos = jmanLabInstance.getCursosCicloEstudiante(est);
                System.out.println("Es estudiante, y los cursos que puede ver el estudiante son: " + this.listaCursos.size());
            }
        }
    }

    private void paso(int i) {
        switch (i) {
            case 1:
                this.setPaso1(true);
                this.setPaso2(false);
                this.setPaso3(false);
                break;
            case 2:
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
                this.setPaso1(true);
                this.setPaso2(false);
                break;
        }
    }

    public jmlAsistencia() {
        System.out.println("FOOOOOOOOOBAAAAAAAAR!");
        cargaCursosDeEstudiante();
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