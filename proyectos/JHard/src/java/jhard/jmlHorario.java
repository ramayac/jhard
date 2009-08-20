/*
 * jmlHorario.java
 *
 * Created on 28-jul-2009, 15:26:26
 * Copyright Hugol
 */
package jhard;

import com.icesoft.faces.component.ext.HtmlCommandButton;
import com.icesoft.faces.component.ext.HtmlSelectOneListbox;
import com.icesoft.faces.component.ext.HtmlSelectOneMenu;
import com.icesoft.faces.component.jsfcl.data.DefaultSelectionItems;
import com.sun.rave.web.ui.appbase.AbstractPageBean;
import edu.ues.jhard.beans.BeanBaseJManLab;
import edu.ues.jhard.jpa.Curso;
import edu.ues.jhard.jpa.Horario;
import edu.ues.jhard.jpa.Ubicacion;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import javax.faces.FacesException;
import javax.faces.component.UISelectItems;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;



/**
 * Bean para página de jmlHorario, que muestra los horarios y agrega nuevos a la manta de horarios
 * del Labcom-1 para el módulo de ManLab
 */
public class jmlHorario extends AbstractPageBean {
    // <editor-fold defaultstate="collapsed" desc="Managed Component Definition">
    private int __placeholder;

    /**
     * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    private void _init() throws Exception {
        horaFin.setItems(new String[]{});
        horaInicio.setItems(new String[]{});
        curso.setItems(new String[]{});
    }
    public DefaultSelectionItems getCurso() {
        return curso;
    }

    public void setCurso(DefaultSelectionItems dsi) {
        this.curso = dsi;
    }
    private HtmlSelectOneMenu comboCurso = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getComboCurso() {
        return comboCurso;
    }

    public void setComboCurso(HtmlSelectOneMenu hsom) {
        this.comboCurso = hsom;
    }
    private HtmlCommandButton btnInscribirCurso = new HtmlCommandButton();

    public HtmlCommandButton getBtnInscribirCurso() {
        return btnInscribirCurso;
    }

    public void setBtnInscribirCurso(HtmlCommandButton hcb) {
        this.btnInscribirCurso = hcb;
    }

    private DefaultSelectionItems horaFin = new DefaultSelectionItems();

    public DefaultSelectionItems getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(DefaultSelectionItems dsi) {
        this.horaFin = dsi;
    }
    private DefaultSelectionItems diaSemana = new DefaultSelectionItems();

    public DefaultSelectionItems getDiaSemana() {
        return diaSemana;
    }

    public void setDiaSemana(DefaultSelectionItems dsi) {
        this.diaSemana = dsi;
    }
    private DefaultSelectionItems horaInicio = new DefaultSelectionItems();

    public DefaultSelectionItems getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(DefaultSelectionItems dsi) {
        this.horaInicio = dsi;
    }
    private HtmlSelectOneListbox listaDiaSemana = new HtmlSelectOneListbox();

    public HtmlSelectOneListbox getListaDiaSemana() {
        return listaDiaSemana;
    }

    public void setListaDiaSemana(HtmlSelectOneListbox hsol) {
        this.listaDiaSemana = hsol;
    }
    private HtmlSelectOneMenu comboHoraInicio = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getComboHoraInicio() {
        return comboHoraInicio;
    }

    public void setComboHoraInicio(HtmlSelectOneMenu hsom) {
        this.comboHoraInicio = hsom;
    }
    private HtmlSelectOneMenu comboHoraFin = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getComboHoraFin() {
        return comboHoraFin;
    }

    public void setComboHoraFin(HtmlSelectOneMenu hsom) {
        this.comboHoraFin = hsom;
    }

    // </editor-fold>

    private String [] hours;
    private String horaSeleccionada="7:35";
    private int diaSeleccionado;
    private DefaultSelectionItems curso = new DefaultSelectionItems();
    private List cur = new ArrayList();
    private boolean noInscripcion;
    private boolean renderPop;


    

    /**
     * <p>Constructor.</p>
     */
    public jmlHorario() {

        this.diaSemana.clear();
        diaSemana.setItems(new String[]{"Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado"});
        this.horaInicio.clear();
        this.horaFin.clear();
        this.comboHoraFin.setDisabled(true);
        this.comboHoraInicio.setDisabled(true);
        this.llenarCursos();
        this.renderPop=false;
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
            
        // <editor-fold defaultstate="collapsed" desc="Managed Component Initialization">
        // Initialize automatically managed components
        // *Note* - this logic should NOT be modified
        try {
            _init();
        } catch (Exception e) {
            log("jmlHorario Initialization Failure", e);
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
     * Método para llenar los comoboboxes con las horas disponbiles para horarios en LABCOM-1
     * @param inicioFin
     */
    public void LlenarHora(int inicioFin){

        String [] horas=null;
        
        this.comboHoraFin.getChildren().clear();

        if(inicioFin==1){
            this.comboHoraInicio.getChildren().clear();

            hours = new String []  {"7:35","8:25","9:15","10:05","10:55","11:45","12:35","13:00","13:50","14:40","15:30","16:20","17:10","18:00"};

            ArrayList h = new ArrayList();

            for(int i=0;i<hours.length;i++){

                String label = hours[i];
                h.add(new SelectItem(hours[i],label));
            }

            UISelectItems itemsHI = new UISelectItems();
            itemsHI.setValue(h);
            this.comboHoraInicio.getChildren().add(itemsHI);

        }
        if (inicioFin==2){
            this.horaFin.clear();
            System.out.println("Tamaño  "+ this.hours.length);
            for (int i = 0; i < this.hours.length; i++) {

                if(horaSeleccionada.equals(this.hours[i])){

                    System.out.println("Tamaño del otro vector  "+ (this.hours.length-i));

                    horas = new String[this.hours.length-i-1];

                    ArrayList hf = new ArrayList();

                    for (int j = 0; j < (this.hours.length-i-1); j++) {

                        System.out.println("Mete la hora  "+ this.hours[j+i+1]);
                        horas[j]=this.hours[j+i+1];

                        String label = horas[j];
                        hf.add(new SelectItem(horas[j],label));

                    }

                    this.comboHoraFin.setDisabled(false);
                    UISelectItems itemsHF = new UISelectItems();
                    itemsHF.setValue(hf);
                    this.comboHoraFin.getChildren().add(itemsHF);

                    continue;
                }
            }
        }

    }

    public void comboHoraInicio_processValueChange(ValueChangeEvent vce) {
        this.horaSeleccionada=this.comboHoraInicio.getValue().toString();
//        if(new BeanBaseJManLab().getAllHorariosUnDia(this.horaSeleccionada, this.diaSeleccionado)==1){
//            this.noInscripcion=true;
//            this.btnInscribirCurso.setDisabled(true);
//        }else{
            LlenarHora(2);
//            this.noInscripcion=false;
//            this.btnInscribirCurso.setDisabled(false);
//        }
    }

    /**
     * @return the cur
     */
    public List getCur() {
        return cur;
    }

    /**
     * @param cur the cur to set
     */
    public void setCur(List cur) {
        this.cur = cur;
    }

    private void llenarCursos(){
        List<Curso> cursos =new BeanBaseJManLab().getAllCursos();
        
        for(int i=0;i<cursos.size();i++){
            String label = cursos.get(i).getIdmateria().getNombre()+" - "+cursos.get(i).getNombre();
            getCur().add(new SelectItem(cursos.get(i).getIdcurso(),label));
        }


    }

    /**
     * Método para inscribir un nuevo curso en un horario elegido
     * @return
     */
    public String btnInscribirCurso_action() {
        Horario r = new Horario();
        BeanBaseJManLab instance = new BeanBaseJManLab();
        Ubicacion u =  instance.getEntityManager().find(Ubicacion.class, 1);
        String tmp = this.comboCurso.getValue().toString();
        Integer id = Integer.parseInt(tmp);
        Curso c = instance.getEntityManager().find(Curso.class, id);

        String [] tiempoI = this.comboHoraInicio.getValue().toString().split("\\:");
        String [] tiempoF = this.comboHoraFin.getValue().toString().split("\\:");
        int hourI = Integer.parseInt(tiempoI[0]);
        int minuteI = Integer.parseInt(tiempoI[1]);
        int hourF = Integer.parseInt(tiempoF[0]);
        int minuteF = Integer.parseInt(tiempoF[1]);
        int seconds = 00;
        Time ti = new Time(hourI, minuteI, seconds);
        Time tf = new Time(hourF, minuteF, seconds);


        r.setDiasemana(diaSeleccionado);
        r.setHorainicio(ti);
        r.setHorafin(tf);
        r.setIdcurso(c);
        r.setIdaula(u);
        
        instance.createHorario(r);
        
        this.renderPop=true;

        return null;
    }

    

    public void listaDiaSemana_processValueChange(ValueChangeEvent vce) {
        this.comboHoraInicio.setDisabled(false);
        this.LlenarHora(1);
        this.LlenarHora(2);
        String dia=this.listaDiaSemana.getValue().toString();

        if(dia.equals("Lunes"))
            this.diaSeleccionado=1;
        if(dia.equals("Martes"))
            this.diaSeleccionado=2;
        if(dia.equals("Miércoles"))
            this.diaSeleccionado=3;
        if(dia.equals("Jueves"))
            this.diaSeleccionado=4;
        if(dia.equals("Viernes"))
            this.diaSeleccionado=5;
        if(dia.equals("Sábado"))
            this.diaSeleccionado=6;
    }

    /**
     * @return the noInscripcion
     */
    public boolean isNoInscripcion() {
        return noInscripcion;
    }

    /**
     * @param noInscripcion the noInscripcion to set
     */
    public void setNoInscripcion(boolean noInscripcion) {
        this.noInscripcion = noInscripcion;
    }

    /**
     * @return the renderPop
     */
    public boolean isRenderPop() {
        return renderPop;
    }

    /**
     * @param renderPop the renderPop to set
     */
    public void setRenderPop(boolean renderPop) {
        this.renderPop = renderPop;
    }

    public String btnOk_action(){
        this.renderPop=false;
        return "done";
    }
}

