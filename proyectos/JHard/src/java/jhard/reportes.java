/*
 * reportes.java
 *
 * Created on 08-ago-2009, 13:48:15
 * Copyright Hugol
 */
package jhard;

import com.icesoft.faces.component.ext.HtmlCommandButton;
import com.icesoft.faces.component.ext.HtmlSelectBooleanCheckbox;
import com.icesoft.faces.component.jsfcl.data.DefaultSelectedData;
import com.icesoft.faces.component.jsfcl.data.DefaultSelectionItems;
import com.icesoft.faces.component.jsfcl.data.SelectInputDateBean;
import com.icesoft.faces.component.selectinputdate.SelectInputDate;
import com.icesoft.faces.component.selectinputtext.SelectInputText;
import com.icesoft.faces.context.effects.JavascriptContext;
import com.sun.rave.web.ui.appbase.AbstractPageBean;
import edu.ues.jhard.beans.BeanBaseJManLab;
import edu.ues.jhard.beans.BeanBaseJRequest;
import edu.ues.jhard.jpa.Curso;
import edu.ues.jhard.jpa.Docente;
import edu.ues.jhard.jpa.Equiposimple;
import edu.ues.jhard.jpa.Existencia;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.FacesException;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;
import javax.servlet.ServletContext;

/**
 * <p>Page bean that corresponds to a similarly named JSP page.  This
 * class contains component definitions (and initialization code) for
 * all components that you have defined on this page, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 */
public class reportes extends AbstractPageBean {
    // <editor-fold defaultstate="collapsed" desc="Managed Component Definition">
    private int __placeholder;

    /**
     * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    private void _init() throws Exception {
        clasesFake.setItems(new String[]{});
    }
    private SelectInputDateBean selectInputDate1Bean = new SelectInputDateBean();

    private DefaultSelectedData selectBooleanCheckbox1Bean = new DefaultSelectedData();

    public DefaultSelectedData getSelectBooleanCheckbox1Bean() {
        return selectBooleanCheckbox1Bean;
    }

    public void setSelectBooleanCheckbox1Bean(DefaultSelectedData dsd) {
        this.selectBooleanCheckbox1Bean = dsd;
    }
    private DefaultSelectedData selectBooleanCheckbox2Bean = new DefaultSelectedData();

    public DefaultSelectedData getSelectBooleanCheckbox2Bean() {
        return selectBooleanCheckbox2Bean;
    }

    public void setSelectBooleanCheckbox2Bean(DefaultSelectedData dsd) {
        this.selectBooleanCheckbox2Bean = dsd;
    }
    private HtmlSelectBooleanCheckbox checkEQ = new HtmlSelectBooleanCheckbox();

    public HtmlSelectBooleanCheckbox getCheckEQ() {
        return checkEQ;
    }

    public void setCheckEQ(HtmlSelectBooleanCheckbox hsbc) {
        this.checkEQ = hsbc;
    }
    private HtmlSelectBooleanCheckbox checkEX = new HtmlSelectBooleanCheckbox();

    public HtmlSelectBooleanCheckbox getCheckEX() {
        return checkEX;
    }

    public void setCheckEX(HtmlSelectBooleanCheckbox hsbc) {
        this.checkEX = hsbc;
    }
    private HtmlCommandButton btnReportBit = new HtmlCommandButton();

    public HtmlCommandButton getBtnReportBit() {
        return btnReportBit;
    }

    public void setBtnReportBit(HtmlCommandButton hcb) {
        this.btnReportBit = hcb;
    }
    private SelectInputText txtBit = new SelectInputText();

    public SelectInputText getTxtBit() {
        return txtBit;
    }

    public void setTxtBit(SelectInputText sit) {
        this.txtBit = sit;
    }
    public SelectInputDateBean getSelectInputDate1Bean() {
        return selectInputDate1Bean;
    }

    public void setSelectInputDate1Bean(SelectInputDateBean sidb) {
        this.selectInputDate1Bean = sidb;
    }
    private SelectInputDateBean selectInputDate2Bean = new SelectInputDateBean();

    public SelectInputDateBean getSelectInputDate2Bean() {
        return selectInputDate2Bean;
    }

    public void setSelectInputDate2Bean(SelectInputDateBean sidb) {
        this.selectInputDate2Bean = sidb;
    }
    private HtmlCommandButton btnReportReserva = new HtmlCommandButton();

    public HtmlCommandButton getBtnReportReserva() {
        return btnReportReserva;
    }

    public void setBtnReportReserva(HtmlCommandButton hcb) {
        this.btnReportReserva = hcb;
    }
    private SelectInputDate selectFechaInicial = new SelectInputDate();

    public SelectInputDate getSelectFechaInicial() {
        return selectFechaInicial;
    }

    public void setSelectFechaInicial(SelectInputDate sid) {
        this.selectFechaInicial = sid;
    }
    private SelectInputDate selectFechaFinal = new SelectInputDate();

    public SelectInputDate getSelectFechaFinal() {
        return selectFechaFinal;
    }

    public void setSelectFechaFinal(SelectInputDate sid) {
        this.selectFechaFinal = sid;
    }
    private HtmlCommandButton btnListadoAccesorios = new HtmlCommandButton();

    public HtmlCommandButton getBtnListadoAccesorios() {
        return btnListadoAccesorios;
    }

    public void setBtnListadoAccesorios(HtmlCommandButton hcb) {
        this.btnListadoAccesorios = hcb;
    }
    private HtmlCommandButton btnListadoPiezas = new HtmlCommandButton();

    public HtmlCommandButton getBtnListadoPiezas() {
        return btnListadoPiezas;
    }

    public void setBtnListadoPiezas(HtmlCommandButton hcb) {
        this.btnListadoPiezas = hcb;
    }
    private HtmlCommandButton btnReservaDoc = new HtmlCommandButton();

    public HtmlCommandButton getBtnReservaDoc() {
        return btnReservaDoc;
    }

    public void setBtnReservaDoc(HtmlCommandButton hcb) {
        this.btnReservaDoc = hcb;
    }
    private SelectInputText txtDocs = new SelectInputText();

    public SelectInputText getTxtDocs() {
        return txtDocs;
    }

    public void setTxtDocs(SelectInputText sit) {
        this.txtDocs = sit;
    }
    private HtmlCommandButton btnInventarioBueno = new HtmlCommandButton();

    public HtmlCommandButton getBtnInventarioBueno() {
        return btnInventarioBueno;
    }

    public void setBtnInventarioBueno(HtmlCommandButton hcb) {
        this.btnInventarioBueno = hcb;
    }
    private HtmlCommandButton btnInventarioMalo = new HtmlCommandButton();

    public HtmlCommandButton getBtnInventarioMalo() {
        return btnInventarioMalo;
    }

    public void setBtnInventarioMalo(HtmlCommandButton hcb) {
        this.btnInventarioMalo = hcb;
    }
    private DefaultSelectedData selectOneMenu1Bean = new DefaultSelectedData();

    public DefaultSelectedData getSelectOneMenu1Bean() {
        return selectOneMenu1Bean;
    }

    public void setSelectOneMenu1Bean(DefaultSelectedData dsd) {
        this.selectOneMenu1Bean = dsd;
    }
    private DefaultSelectionItems clasesFake = new DefaultSelectionItems();

    public DefaultSelectionItems getClasesFake() {
        return clasesFake;
    }

    public void setClasesFake(DefaultSelectionItems dsi) {
        this.clasesFake = dsi;
    }
    private SelectInputDateBean selectInputDateBean1 = new SelectInputDateBean();

    public SelectInputDateBean getSelectInputDateBean1() {
        return selectInputDateBean1;
    }

    public void setSelectInputDateBean1(SelectInputDateBean sidb) {
        this.selectInputDateBean1 = sidb;
    }



    // </editor-fold>

    private List eqs = new ArrayList();
    private List doc = new ArrayList();
    private List cur = new ArrayList();
    private List<Equiposimple> listaTodosEquipos;
    private List<Existencia> listaTodasExistencias;
    private List<Docente> listaTodosDocentes;
    private List<Curso> listaTodosCursos;
    private Equiposimple EquipoElegido;
    private Docente DocenteElegido;
    private Existencia ExistenciaElegida;
    private Curso CursoElegido;
    private SelectInputText comboClases = new SelectInputText();

    public SelectInputText getComboClases() {
        return comboClases;
    }

    public void setComboClases(SelectInputText sit) {
        this.comboClases = sit;
    }
    private SelectInputDate fechaClases = new SelectInputDate();

    public SelectInputDate getFechaClases() {
        return fechaClases;
    }

    public void setFechaClases(SelectInputDate sid) {
        this.fechaClases = sid;
    }
    

    
    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public reportes() {
        BeanBaseJRequest instance = new BeanBaseJRequest();
        BeanBaseJManLab instance2 = new BeanBaseJManLab();
        this.listaTodosEquipos= instance.getListaEquipoSimple();
        this.listaTodasExistencias= instance.getListaExistencia();
        this.listaTodosDocentes=instance2.getAllDocentes();
        this.listaTodosCursos=instance2.getAllCursos();
        this.clasesFake.clear();
        //String path = ((ServletContext)FacesContext.getCurrentInstance().getExternalContext().getContext()).getRealPath("/") + "reportes/";
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
            log("reportes Initialization Failure", e);
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
     * @return the eqs
     */
    public List getEqs() {
        return eqs;
    }

    /**
     * @param eqs the eqs to set
     */
    public void setEqs(List eqs) {
        this.eqs = eqs;
    }

    public void txtBit_processValueChange(ValueChangeEvent vce) {
        String valorBusqueda = vce.getNewValue().toString().toUpperCase();
        if(valorBusqueda.equalsIgnoreCase("")){
            this.eqs.clear();
            return;
        }
        List<SelectItem> listaItemsBusqueda = new ArrayList<SelectItem>();

        if(this.checkEQ.isSelected()){
            for(Equiposimple eq: this.getListaTodosEquipos()){
                if(eq.getDescripcion().toUpperCase().contains(valorBusqueda) ||
                        eq.getPropietario().toUpperCase().contains(valorBusqueda)){
                    this.eqs.add(eq);
                    listaItemsBusqueda.add(new SelectItem(eq.getIdEquipoSimple(), eq.getPropietario() + " - " + eq.getDescripcion()));
                }
            }
        }else{
            for(Existencia eq: this.getListaTodasExistencias()){
                if(eq.getCodigo().toUpperCase().contains(valorBusqueda) ||
                        eq.getIdhardware().getIdmarca().getNombre().toUpperCase().contains(valorBusqueda) ||
                        eq.getIdhardware().getModelo().toUpperCase().contains(valorBusqueda) ||
                        eq.getIdhardware().getNombre().toUpperCase().contains(valorBusqueda)){
                    this.eqs.add(eq);
                    listaItemsBusqueda.add(new SelectItem(eq.getIdexistencia(), eq.getIdhardware().getNombre() + " - " + eq.getCodigo()));
                }
            }
        }
        this.eqs = listaItemsBusqueda;
    }

    /**
     * @return the listaTodosEquipos
     */
    public List<Equiposimple> getListaTodosEquipos() {
        return listaTodosEquipos;
    }

    /**
     * @param listaTodosEquipos the listaTodosEquipos to set
     */
    public void setListaTodosEquipos(List<Equiposimple> listaTodosEquipos) {
        this.listaTodosEquipos = listaTodosEquipos;
    }

    /**
     * @return the listaTodasExistencias
     */
    public List<Existencia> getListaTodasExistencias() {
        return listaTodasExistencias;
    }

    /**
     * @param listaTodasExistencias the listaTodasExistencias to set
     */
    public void setListaTodasExistencias(List<Existencia> listaTodasExistencias) {
        this.listaTodasExistencias = listaTodasExistencias;
    }

    public String txtBit_action() {
        Integer id= (Integer) this.txtBit.getSelectedItem().getValue();

        if(this.checkEQ.isSelected()){
            Equiposimple e=new BeanBaseJRequest().getEntityManager().find(Equiposimple.class, id);
            EquipoElegido=e;
        }else{
            Existencia ex=new BeanBaseJRequest().getEntityManager().find(Existencia.class, id);
            ExistenciaElegida=ex;
        }
        return null;
    }

    public void llamarReporte(ActionEvent e) {
        JavascriptContext.addJavascriptCall(FacesContext.getCurrentInstance(), "window.open (\"Reporte?rpid=1&idcarrera=1\",\"Reporte\");");
    }

    public String btnReportBit_action() {
        if(this.checkEQ.isSelected()){
            JavascriptContext.addJavascriptCall(FacesContext.getCurrentInstance(), "window.open (\"Reporte?rpid=2&idEquipoSimple="+EquipoElegido.getIdEquipoSimple()+"\",\"Reporte\");");
        }
        else
            JavascriptContext.addJavascriptCall(FacesContext.getCurrentInstance(), "window.open (\"Reporte?rpid=3&idequipoexistente="+ExistenciaElegida.getIdexistencia()+"\",\"Reporte\");");
        return null;
    }

    public void checkEQ_processValueChange(ValueChangeEvent vce) {
        if(this.checkEQ.isSelected())
            this.checkEX.setSelected(false);
        this.txtBit.setValue("");
    }

    public void checkEX_processValueChange(ValueChangeEvent vce) {
        if(this.checkEX.isSelected())
            this.checkEQ.setSelected(false);
        this.txtBit.setValue("");
    }

    public String btnReportReserva_action() {

        Date fechaI = (Date)this.selectFechaInicial.getValue();
        Date fechaF = (Date)this.selectFechaFinal.getValue();
        System.out.println((fechaI.getDate()+1)+"-"+(fechaI.getMonth()+1)+"-"+fechaI.getYear());
        System.out.println((fechaF.getDate()+1)+"-"+(fechaF.getMonth()+1)+"-"+fechaF.getYear());
        JavascriptContext.addJavascriptCall(FacesContext.getCurrentInstance(), "window.open (\"Reporte?rpid=4&diaI="+(fechaI.getDate()+1)+"&mesI="+fechaI.getMonth()+"&anioI="+fechaI.getYear()+"&diaF="+(fechaF.getDate()+1)+"&mesF="+fechaF.getMonth()+"&anioF="+fechaI.getYear()+" \",\"Reporte\");");

        return null;
    }

    public String btnListadoPiezas_action() {
        JavascriptContext.addJavascriptCall(FacesContext.getCurrentInstance(), "window.open (\"Reporte?rpid=5\",\"Reporte\");");
        return null;
    }

    public String btnListadoAccesorios_action() {
        JavascriptContext.addJavascriptCall(FacesContext.getCurrentInstance(), "window.open (\"Reporte?rpid=6\",\"Reporte\");");
        return null;
    }

    /**
     * @return the listaTodosDocentes
     */
    public List<Docente> getListaTodosDocentes() {
        return listaTodosDocentes;
    }

    /**
     * @param listaTodosDocentes the listaTodosDocentes to set
     */
    public void setListaTodosDocentes(List<Docente> listaTodosDocentes) {
        this.listaTodosDocentes = listaTodosDocentes;
    }

    /**
     * @return the doc
     */
    public List getDoc() {
        return doc;
    }

    /**
     * @param doc the doc to set
     */
    public void setDoc(List doc) {
        this.doc = doc;
    }

    public void txtDocs_processValueChange(ValueChangeEvent vce) {
        String valorBusqueda = vce.getNewValue().toString().toUpperCase();
        if(valorBusqueda.equalsIgnoreCase("")){
            this.doc.clear();
            return;
        }
        List<SelectItem> listaItemsBusqueda = new ArrayList<SelectItem>();

        for(Docente d: this.getListaTodosDocentes()){
            if(d.getApellidos().toUpperCase().contains(valorBusqueda) ||
                d.getNombres().toUpperCase().contains(valorBusqueda)){
                    this.doc.add(d);
                    listaItemsBusqueda.add(new SelectItem(d.getIddocente(), d.getNombres() + " - " + d.getApellidos()));
            }
        }
        this.doc = listaItemsBusqueda;
    }

    public String txtDocs_action() {
        Integer id= (Integer) this.txtDocs.getSelectedItem().getValue();
        Docente e=new BeanBaseJRequest().getEntityManager().find(Docente.class, id);
        DocenteElegido=e;
        return null;
    }

    public String btnReservaDoc_action() {
        JavascriptContext.addJavascriptCall(FacesContext.getCurrentInstance(), "window.open (\"Reporte?rpid=7&iddocente="+DocenteElegido.getIddocente()+"\",\"Reporte\");");
        return null;
    }

    public String btnInventarioBueno_action() {
        JavascriptContext.addJavascriptCall(FacesContext.getCurrentInstance(), "window.open (\"Reporte?rpid=8\",\"Reporte\");");
        return null;
    }

    public String btnInventarioMalo_action() {
        JavascriptContext.addJavascriptCall(FacesContext.getCurrentInstance(), "window.open (\"Reporte?rpid=9\",\"Reporte\");");
        return null;
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


    public void comboClases_processValueChange(ValueChangeEvent vce) {
        String valorBusqueda = vce.getNewValue().toString().toUpperCase();
        if(valorBusqueda.equalsIgnoreCase("")){
            this.cur.clear();
            return;
        }
        List<SelectItem> listaItemsBusqueda = new ArrayList<SelectItem>();

        for(Curso c: this.getListaTodosCursos()){
            if(c.getNombre().toUpperCase().contains(valorBusqueda) ||
                c.getIdmateria().getNombre().toUpperCase().contains(valorBusqueda)){
                    this.cur.add(c);
                    listaItemsBusqueda.add(new SelectItem(c.getIdcurso(), c.getIdmateria().getNombre() + " - " + c.getNombre()));
            }
        }
        this.cur = listaItemsBusqueda;
    }

    /**
     * @return the listaTodosCursos
     */
    public List<Curso> getListaTodosCursos() {
        return listaTodosCursos;
    }

    /**
     * @param listaTodosCursos the listaTodosCursos to set
     */
    public void setListaTodosCursos(List<Curso> listaTodosCursos) {
        this.listaTodosCursos = listaTodosCursos;
    }

    public String comboClases_action() {
        Integer id= (Integer) this.comboClases.getSelectedItem().getValue();
        Curso c=new BeanBaseJRequest().getEntityManager().find(Curso.class, id);
        CursoElegido=c;
        return null;
    }

    public String btnAsistenciaAlumno_action() {
        Date fecha = (Date)this.fechaClases.getValue();
        JavascriptContext.addJavascriptCall(FacesContext.getCurrentInstance(), "window.open (\"Reporte?rpid=10&dia="+(fecha.getDate()+1)+"&mes="+fecha.getMonth()+"&anio="+fecha.getYear()+"&idcurso="+CursoElegido.getIdcurso()+"\",\"Reporte\");");
        return null;
    }
}
