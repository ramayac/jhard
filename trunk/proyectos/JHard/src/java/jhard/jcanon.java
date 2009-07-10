/*
 * jcanon.java
 *
 * Created on 29-jun-2009, 1:15:11
 * Copyright Hugol
 */
package jhard;

import com.icesoft.faces.component.ext.HtmlCommandButton;
import com.icesoft.faces.component.ext.HtmlInputText;
import com.icesoft.faces.component.ext.HtmlOutputLabel;
import com.icesoft.faces.component.ext.HtmlOutputText;
import com.icesoft.faces.component.ext.HtmlSelectBooleanCheckbox;
import com.icesoft.faces.component.ext.HtmlSelectOneMenu;
import com.icesoft.faces.component.jsfcl.data.DefaultSelectedData;
import com.icesoft.faces.component.jsfcl.data.DefaultSelectionItems;
import com.icesoft.faces.component.jsfcl.data.PopupBean;
import com.icesoft.faces.component.jsfcl.data.SelectInputDateBean;
import com.icesoft.faces.component.panelpopup.PanelPopup;
import com.icesoft.faces.component.selectinputdate.SelectInputDate;
import com.sun.rave.web.ui.appbase.AbstractPageBean;
import edu.ues.jhard.beans.BeanBaseJCanon;
import edu.ues.jhard.beans.BeanBaseJHardmin;
import edu.ues.jhard.beans.BeanBaseManLab;
import edu.ues.jhard.jhardmin.LoggedUser;
import edu.ues.jhard.jhardmin.LoginManager;
import edu.ues.jhard.jpa.Docente;
import edu.ues.jhard.jpa.Estadoreserva;
import edu.ues.jhard.jpa.Existencia;
import edu.ues.jhard.jpa.Reserva;
import edu.ues.jhard.jpa.Usuario;
import java.util.Date;
import java.util.ArrayList;
import java.util.Calendar;
import javax.faces.FacesException;
import javax.faces.component.UISelectItems;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;


/**
 * <p>Page bean that corresponds to a similarly named JSP page.  This
 * class contains component definitions (and initialization code) for
 * all components that you have defined on this page, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 */
public class jcanon extends AbstractPageBean {
    // <editor-fold defaultstate="collapsed" desc="Managed Component Definition">
    private int __placeholder;

    /**
     * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    private void _init() throws Exception {
        fakeCLaptop.setItems(new String[]{});
        fakeCCan.setItems(new String[]{});
        fakeDocente.setItems(new String[]{});
        fakeHoraFin.setItems(new String[]{});
        fakeHoraInicio.setItems(new String[]{});
    }
    private DefaultSelectedData fakeCan = new DefaultSelectedData();

    public DefaultSelectedData getFakeCan() {
        return fakeCan;
    }

    public void setFakeCan(DefaultSelectedData dsd) {
        this.fakeCan = dsd;
    }
    private DefaultSelectedData fakeLaptop = new DefaultSelectedData();

    public DefaultSelectedData getFakeLaptop() {
        return fakeLaptop;
    }

    public void setFakeLaptop(DefaultSelectedData dsd) {
        this.fakeLaptop = dsd;
    }
    private DefaultSelectionItems fakeCCan = new DefaultSelectionItems();

    public DefaultSelectionItems getFakeCCan() {
        return fakeCCan;
    }

    public void setFakeCCan(DefaultSelectionItems dsi) {
        this.fakeCCan = dsi;
    }
    private DefaultSelectionItems fakeCLaptop = new DefaultSelectionItems();

    public DefaultSelectionItems getFakeCLaptop() {
        return fakeCLaptop;
    }

    public void setFakeCLaptop(DefaultSelectionItems dsi) {
        this.fakeCLaptop = dsi;
    }
    private SelectInputDateBean fecha = new SelectInputDateBean();

    public SelectInputDateBean getFecha() {
        return fecha;
    }

    public void setFecha(SelectInputDateBean sidb) {
        this.fecha = sidb;
    }
    private DefaultSelectionItems fakeHoraInicio = new DefaultSelectionItems();

    public DefaultSelectionItems getFakeHoraInicio() {
        return fakeHoraInicio;
    }

    public void setFakeHoraInicio(DefaultSelectionItems dsi) {
        this.fakeHoraInicio = dsi;
    }
    private DefaultSelectionItems fakeHoraFin = new DefaultSelectionItems();

    public DefaultSelectionItems getFakeHoraFin() {
        return fakeHoraFin;
    }

    public void setFakeHoraFin(DefaultSelectionItems dsi) {
        this.fakeHoraFin = dsi;
    }
    private DefaultSelectionItems fakeDocente = new DefaultSelectionItems();

    public DefaultSelectionItems getFakeDocente() {
        return fakeDocente;
    }

    public void setFakeDocente(DefaultSelectionItems dsi) {
        this.fakeDocente = dsi;
    }
    private HtmlSelectOneMenu comboCan = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getComboCan() {
        return comboCan;
    }

    public void setComboCan(HtmlSelectOneMenu hsom) {
        this.comboCan = hsom;
    }
    private HtmlSelectOneMenu comboLaptop = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getComboLaptop() {
        return comboLaptop;
    }

    public void setComboLaptop(HtmlSelectOneMenu hsom) {
        this.comboLaptop = hsom;
    }
    private HtmlOutputLabel lblUser = new HtmlOutputLabel();

    public HtmlOutputLabel getLblUser() {
        return lblUser;
    }

    public void setLblUser(HtmlOutputLabel hol) {
        this.lblUser = hol;
    }
    private HtmlSelectBooleanCheckbox checkCan = new HtmlSelectBooleanCheckbox();

    public HtmlSelectBooleanCheckbox getCheckCan() {
        return checkCan;
    }

    public void setCheckCan(HtmlSelectBooleanCheckbox hsbc) {
        this.checkCan = hsbc;
    }
    private HtmlSelectBooleanCheckbox checkLaptop = new HtmlSelectBooleanCheckbox();

    public HtmlSelectBooleanCheckbox getCheckLaptop() {
        return checkLaptop;
    }

    public void setCheckLaptop(HtmlSelectBooleanCheckbox hsbc) {
        this.checkLaptop = hsbc;
    }
    private SelectInputDate selectFecha = new SelectInputDate();

    public SelectInputDate getSelectFecha() {
        return selectFecha;
    }

    public void setSelectFecha(SelectInputDate sid) {
        this.selectFecha = sid;
    }
    private HtmlSelectOneMenu horaInicio = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(HtmlSelectOneMenu hsom) {
        this.horaInicio = hsom;
    }
    private HtmlSelectOneMenu horaFin = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(HtmlSelectOneMenu hsom) {
        this.horaFin = hsom;
    }
    private HtmlSelectOneMenu comboDocente = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getComboDocente() {
        return comboDocente;
    }

    public void setComboDocente(HtmlSelectOneMenu hsom) {
        this.comboDocente = hsom;
    }
    private HtmlCommandButton btnCrearReserva = new HtmlCommandButton();

    public HtmlCommandButton getBtnCrearReserva() {
        return btnCrearReserva;
    }

    public void setBtnCrearReserva(HtmlCommandButton hcb) {
        this.btnCrearReserva = hcb;
    }
    private HtmlCommandButton btnAgregarMultimedia = new HtmlCommandButton();

    public HtmlCommandButton getBtnAgregarMultimedia() {
        return btnAgregarMultimedia;
    }

    public void setBtnAgregarMultimedia(HtmlCommandButton hcb) {
        this.btnAgregarMultimedia = hcb;
    }
    private HtmlCommandButton btnVerReservas = new HtmlCommandButton();

    public HtmlCommandButton getBtnVerReservas() {
        return btnVerReservas;
    }

    public void setBtnVerReservas(HtmlCommandButton hcb) {
        this.btnVerReservas = hcb;
    }
    private HtmlCommandButton btnVerSoloReservas = new HtmlCommandButton();

    public HtmlCommandButton getBtnVerSoloReservas() {
        return btnVerSoloReservas;
    }

    public void setBtnVerSoloReservas(HtmlCommandButton hcb) {
        this.btnVerSoloReservas = hcb;
    }
    private HtmlInputText txtSolicitante = new HtmlInputText();

    public HtmlInputText getTxtSolicitante() {
        return txtSolicitante;
    }

    public void setTxtSolicitante(HtmlInputText hit) {
        this.txtSolicitante = hit;
    }

    // </editor-fold>


    private LoggedUser lu;
    private Usuario U;

    public LoggedUser getLu() {
        return lu;
    }

    public void setLu(LoggedUser lu) {
        this.lu = lu;
    }

    public Usuario getU(){
        return U;
    }

    public void setU(Usuario u){
        this.U=u;
    }

    public  BeanBaseJHardmin getJHardminInstance() {
        return (BeanBaseJHardmin) getBean("JHardminInstance");
    }
    private HtmlInputText txtSolicitanteApellidos = new HtmlInputText();

    public HtmlInputText getTxtSolicitanteApellidos() {
        return txtSolicitanteApellidos;
    }

    public void setTxtSolicitanteApellidos(HtmlInputText hit) {
        this.txtSolicitanteApellidos = hit;
    }
    private PopupBean panelPopup1Bean = new PopupBean();

    public PopupBean getPanelPopup1Bean() {
        return panelPopup1Bean;
    }

    public void setPanelPopup1Bean(PopupBean pb) {
        this.panelPopup1Bean = pb;
    }
    private HtmlOutputText lblMensajes = new HtmlOutputText();

    public HtmlOutputText getLblMensajes() {
        return lblMensajes;
    }

    public void setLblMensajes(HtmlOutputText hot) {
        this.lblMensajes = hot;
    }
    private PanelPopup panelMensajes = new PanelPopup();

    public PanelPopup getPanelMensajes() {
        return panelMensajes;
    }

    public void setPanelMensajes(PanelPopup pp) {
        this.panelMensajes = pp;
    }
    private HtmlCommandButton btnOk = new HtmlCommandButton();

    public HtmlCommandButton getBtnOk() {
        return btnOk;
    }

    public void setBtnOk(HtmlCommandButton hcb) {
        this.btnOk = hcb;
    }


    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public jcanon() {
        this.comboCan.setDisabled(true);
        this.comboLaptop.setDisabled(true);
        this.horaFin.setDisabled(true);
        this.LlenarHora(1);

        lu= getJHardminInstance().getCurrentUser();

        if(lu!=null){
            U = LoginManager.getInstance().getUsuario(lu);

            this.lblUser.setValue((String)U.getNombre());

            switch(U.getIdrol().getIdrol()){
            case 3:
                Ing = new BeanBaseManLab().getDocenteByUsuario(U.getIdusuario());
                this.txtSolicitante.setValue((String)Ing.getNombres());
                this.txtSolicitanteApellidos.setValue((String)Ing.getApellidos());
                this.txtSolicitante.setDisabled(true);
                this.txtSolicitanteApellidos.setDisabled(true);
                this.comboDocente.setDisabled(true);
                break;
            default:
                this.txtSolicitante.setValue((String)U.getNombre());
                this.txtSolicitante.setDisabled(true);
                this.txtSolicitanteApellidos.setDisabled(true);
                LlenarComboDocentes();
                break;

            }
        }
        else
            this.lblUser.setValue("Invitado");
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
        this.panelMensajes.setRendered(false);
        this.panelMensajes.setVisible(false);
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
            log("jcanon Initialization Failure", e);
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

    private Existencia canonElegido;
    private Existencia laptopElegida;
    private String horaSeleccionada="6:45";
    private String [] hours;
    private Docente Ing;


    public void checkCan_processValueChange(ValueChangeEvent vce) {
        if(this.checkCan.isSelected())
            this.comboCan.setDisabled(false);
        else
            this.comboCan.setDisabled(true);

        LlenarComboCanon();
    }

    public void checkLaptop_processValueChange(ValueChangeEvent vce) {
        if(this.checkLaptop.isSelected())
            this.comboLaptop.setDisabled(false);
        else
            this.comboLaptop.setDisabled(true);

        LlenarComboLaptop();
    }

    public void LlenarComboCanon(){
        //Llenar Combo de Estados de equipos para la Administracion

        Existencia [] existencias = new edu.ues.jhard.beans.BeanBaseJCanon().getEquipoMultimedia(2);

        canonElegido = existencias[0];

        ArrayList ex = new ArrayList();

        for(int i=0;i<existencias.length;i++){

            String label = existencias[i].getIdhardware().getNombre() +"  "+existencias[i].getIdhardware().getModelo();
            ex.add(new SelectItem(existencias[i].getIdexistencia(),label));
        }

        UISelectItems itemsEx = new UISelectItems();
        itemsEx.setValue(ex);
        this.comboCan.getChildren().add(itemsEx);

    }

    public void LlenarComboLaptop(){

        Existencia [] existencias = new edu.ues.jhard.beans.BeanBaseJCanon().getEquipoMultimedia(3);

        laptopElegida = existencias[0];

        ArrayList ex = new ArrayList();

        for(int i=0;i<existencias.length;i++){

            String label = existencias[i].getIdhardware().getNombre() +"  "+existencias[i].getIdhardware().getModelo();
            ex.add(new SelectItem(existencias[i].getIdexistencia(),label));
        }

        UISelectItems itemsEx = new UISelectItems();
        itemsEx.setValue(ex);
        this.comboLaptop.getChildren().add(itemsEx);

    }

    public void LlenarComboDocentes(){

        Docente [] docentes = new edu.ues.jhard.beans.BeanBaseManLab().getDocentes();

        Ing = docentes[0];

        ArrayList in = new ArrayList();

        for(int i=0;i<docentes.length;i++){

            String label = docentes[i].getNombres()+"  "+docentes[i].getApellidos();
            in.add(new SelectItem(docentes[i].getIddocente(),label));
        }

        UISelectItems itemsDoc = new UISelectItems();
        itemsDoc.setValue(in);
        this.comboDocente.getChildren().add(itemsDoc);

    }
//    fakeHoraFin.setItems(new String[]{});
//    fakeHoraInicio.setItems(new String[]{});

    public void LlenarHora(int inicioFin){

        String [] horas=null;
        this.horaFin.getChildren().clear();

        if(inicioFin==1){
            hours = new String []  {"6:45","7:35","8:25","9:15","10:05","10:55","11:45","12:35","1:00","1:50","2:40","3:30","4:20","5:10","6:00","6:50","7:40","8:30"};

            ArrayList h = new ArrayList();

            for(int i=0;i<hours.length;i++){

                String label = hours[i];
                h.add(new SelectItem(hours[i],label));
            }

            UISelectItems itemsHI = new UISelectItems();
            itemsHI.setValue(h);
            this.horaInicio.getChildren().add(itemsHI);

        }
        if (inicioFin==2){
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

                    this.horaFin.setDisabled(false);
                    UISelectItems itemsHF = new UISelectItems();
                    itemsHF.setValue(hf);
                    this.horaFin.getChildren().add(itemsHF);

                    continue;
                }
            }
        }

    }

    public void horaInicio_processValueChange(ValueChangeEvent vce) {
        this.horaSeleccionada=this.horaInicio.getValue().toString();

        LlenarHora(2);
    }

    public String btnCrearReserva_action() {

//            switch(U.getIdrol().getIdrol()){
//            case 1:
//                    s.setNombres(U.getNombre());
//                    s.setApellidos("");
//                    s.setTipodocumento("DUI");
//                    s.setValordocumento("DUI");
//                    s.setVisible(1);
//
//
//                    break;
//            case 3:
//                s.setNombres(this.txtSolicitante.getValue().toString());
//                s.setApellidos(this.txtSolicitanteApellidos.getValue().toString());
//                s.setTipodocumento("No Necesita");
//                s.setValordocumento("No Necesita");
//                s.setVisible(1);
//
//                break;
//
//            default:
//
//                break;
//
//            }
//            r.setNombres(Ing.getNombres());
//            r.setApellidos(Ing.getApellidos());
//            r.setTipodocumento("No Necesita");
//            r.setValordocumento("No Necesita");
//            r.setVisible(1);

            BeanBaseJCanon instance = new BeanBaseJCanon();
           
            Estadoreserva er = new BeanBaseJCanon().getEntityManager().find(Estadoreserva.class, 1);
            Calendar c = Calendar.getInstance();

            if(this.checkCan.isSelected()){
                Reserva reservaCanon = new Reserva();


                reservaCanon.setFechareserva(new Date((c.get(Calendar.YEAR))-1900, c.get(Calendar.MONTH), c.get(Calendar.DATE)));
                
                Date fechaI = (Date)this.selectFecha.getValue();
                String [] tiempoI = this.horaInicio.getValue().toString().split("\\:");
                int hourI = Integer.parseInt(tiempoI[0]);
                int minuteI = Integer.parseInt(tiempoI[1]);
                int secondI = 00;

                reservaCanon.setFechahorainicioprestamo(new Date(fechaI.getYear(),fechaI.getMonth(),fechaI.getDate(),hourI,minuteI,secondI));


                String [] tiempoF = this.horaFin.getValue().toString().split("\\:");
                int hourF = Integer.parseInt(tiempoF[0]);
                int minuteF = Integer.parseInt(tiempoF[1]);
                int secondF = 00;

                reservaCanon.setFechahorafinprestamo(new Date(fechaI.getYear(),fechaI.getMonth(),fechaI.getDate(),hourF,minuteF,secondF));

                reservaCanon.setDescripcion("Prestamo de "+this.canonElegido.getIdhardware().getNombre() +" "+this.canonElegido.getIdhardware().getIdmarca().getNombre()+"  "+this.canonElegido.getIdhardware().getModelo());
                reservaCanon.setIdequipoexistente(canonElegido);
                reservaCanon.setIdubicacion(canonElegido.getIdubicacion());
                reservaCanon.setIdusuario(U);
                reservaCanon.setIdestado(er);
                reservaCanon.setIddocente(Ing);

                instance.registrarReserva(reservaCanon);

                this.lblMensajes.setValue("Reserva de Cañon hecha con éxito");
                this.panelMensajes.setRendered(true);
                this.panelMensajes.setVisible(true);
                this.panelMensajes.setModal(true);

            }

            if(this.checkLaptop.isSelected()){
                Reserva reservaLaptop = new Reserva();
                reservaLaptop.setFechareserva(new Date((c.get(Calendar.YEAR))-1900, c.get(Calendar.MONTH), c.get(Calendar.DATE)));
                reservaLaptop.setFechahorainicioprestamo((Date)this.selectFecha.getValue());
                reservaLaptop.setFechahorafinprestamo((Date)this.selectFecha.getValue());
                reservaLaptop.setDescripcion("Prestamo de "+this.canonElegido.getIdhardware().getNombre() +" "+this.canonElegido.getIdhardware().getIdmarca().getNombre()+this.canonElegido.getIdhardware().getModelo());
                reservaLaptop.setIdequipoexistente(canonElegido);
                reservaLaptop.setIdubicacion(canonElegido.getIdubicacion());
                reservaLaptop.setIdusuario(U);
                reservaLaptop.setIdestado(er);
                reservaLaptop.setIddocente(Ing);

                instance.registrarReserva(reservaLaptop);

                this.lblMensajes.setValue("Reserva de Laptop hecha con éxito");
                this.panelMensajes.setRendered(true);
                this.panelMensajes.setVisible(true);
                this.panelMensajes.setModal(true);

            }
        return null;
    }

    public void comboDocente_processValueChange(ValueChangeEvent vce) {
        String tmp=(String)this.comboDocente.getValue();
        if(tmp!=null){
            Integer id=Integer.parseInt(tmp);
            Ing=new BeanBaseJCanon().getEntityManager().find(Docente.class, id);
       }
    }

    public String btnOk_action() {
        this.panelMensajes.setRendered(false);
        this.panelMensajes.setVisible(false);
        this.panelMensajes.setModal(false);
        return null;
    }
}
