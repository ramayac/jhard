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
import com.icesoft.faces.component.jsfcl.data.SelectInputDateBean;
import com.icesoft.faces.component.panelpopup.PanelPopup;
import com.icesoft.faces.component.selectinputdate.SelectInputDate;
import com.sun.rave.web.ui.appbase.AbstractPageBean;
import edu.ues.jhard.beans.BeanBaseJCanon;
import edu.ues.jhard.beans.BeanBaseJHardmin;
import edu.ues.jhard.beans.BeanBaseJInvent;
import edu.ues.jhard.beans.BeanBaseJManLab;
import edu.ues.jhard.jhardmin.LoggedUser;
import edu.ues.jhard.jhardmin.LoginManager;
import edu.ues.jhard.jpa.Docente;
import edu.ues.jhard.jpa.Equipo;
import edu.ues.jhard.jpa.Estadoequipo;
import edu.ues.jhard.jpa.Estadoreserva;
import edu.ues.jhard.jpa.Existencia;
import edu.ues.jhard.jpa.Reserva;
import edu.ues.jhard.jpa.Ubicacion;
import edu.ues.jhard.jpa.Usuario;
import java.util.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.faces.FacesException;
import javax.faces.component.UISelectItems;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;


/**
 *
 * Bean para la página JSP de jcanon, que muestra las reservas de equipo multimedia existentes y
 * sirve para ingresar nuevas reservas
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
//        fakeCLaptop.setItems(new String[]{});
//        fakeCCan.setItems(new String[]{});
//        fakeDocente.setItems(new String[]{});
//        fakeHoraFin.setItems(new String[]{});
//        fakeHoraInicio.setItems(new String[]{});
        selectOneMenu1DefaultItems.setItems(new String[]{"Cañon","Laptop"});
//        selectOneMenu2DefaultItems.setItems(new String[]{});
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
//    private DefaultSelectionItems fakeCCan = new DefaultSelectionItems();
//
//    public DefaultSelectionItems getFakeCCan() {
//        return fakeCCan;
//    }
//
//    public void setFakeCCan(DefaultSelectionItems dsi) {
//        this.fakeCCan = dsi;
//    }
//    private DefaultSelectionItems fakeCLaptop = new DefaultSelectionItems();
//
//    public DefaultSelectionItems getFakeCLaptop() {
//        return fakeCLaptop;
//    }
//
//    public void setFakeCLaptop(DefaultSelectionItems dsi) {
//        this.fakeCLaptop = dsi;
//    }
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
//    private DefaultSelectionItems fakeDocente = new DefaultSelectionItems();
//
//    public DefaultSelectionItems getFakeDocente() {
//        return fakeDocente;
//    }
//
//    public void setFakeDocente(DefaultSelectionItems dsi) {
//        this.fakeDocente = dsi;
//    }
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
    private DefaultSelectionItems selectOneMenu1DefaultItems = new DefaultSelectionItems();

    public DefaultSelectionItems getSelectOneMenu1DefaultItems() {
        return selectOneMenu1DefaultItems;
    }

    public void setSelectOneMenu1DefaultItems(DefaultSelectionItems dsi) {
        this.selectOneMenu1DefaultItems = dsi;
    }
//    private DefaultSelectionItems selectOneMenu2DefaultItems = new DefaultSelectionItems();
//
//    public DefaultSelectionItems getSelectOneMenu2DefaultItems() {
//        return selectOneMenu2DefaultItems;
//    }
//
//    public void setSelectOneMenu2DefaultItems(DefaultSelectionItems dsi) {
//        this.selectOneMenu2DefaultItems = dsi;
//    }
    private PanelPopup panelAddMultimedia = new PanelPopup();

    public PanelPopup getPanelAddMultimedia() {
        return panelAddMultimedia;
    }

    public void setPanelAddMultimedia(PanelPopup pp) {
        this.panelAddMultimedia = pp;
    }
    private HtmlSelectOneMenu comboEqAdd = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getComboEqAdd() {
        return comboEqAdd;
    }

    public void setComboEqAdd(HtmlSelectOneMenu hsom) {
        this.comboEqAdd = hsom;
    }
    private HtmlSelectOneMenu comboTipoEq = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getComboTipoEq() {
        return comboTipoEq;
    }

    public void setComboTipoEq(HtmlSelectOneMenu hsom) {
        this.comboTipoEq = hsom;
    }
    private HtmlCommandButton btnAddEQ = new HtmlCommandButton();

    public HtmlCommandButton getBtnAddEQ() {
        return btnAddEQ;
    }

    public void setBtnAddEQ(HtmlCommandButton hcb) {
        this.btnAddEQ = hcb;
    }
    private HtmlInputText txtCodigoExistencia = new HtmlInputText();

    public HtmlInputText getTxtCodigoExistencia() {
        return txtCodigoExistencia;
    }

    public void setTxtCodigoExistencia(HtmlInputText hit) {
        this.txtCodigoExistencia = hit;
    }
    private HtmlCommandButton btnAceptarAdd = new HtmlCommandButton();

    public HtmlCommandButton getBtnAceptarAdd() {
        return btnAceptarAdd;
    }

    public void setBtnAceptarAdd(HtmlCommandButton hcb) {
        this.btnAceptarAdd = hcb;
    }
    private HtmlCommandButton btnCancelarAdd = new HtmlCommandButton();

    public HtmlCommandButton getBtnCancelarAdd() {
        return btnCancelarAdd;
    }

    public void setBtnCancelarAdd(HtmlCommandButton hcb) {
        this.btnCancelarAdd = hcb;
    }
    // </editor-fold>


    private boolean renderer;
    private boolean rendererMultimedia;
    private boolean rendererAddEq;
    private boolean visibleMultimedia;
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

    public  BeanBaseJInvent getJInventInstance() {
        return (BeanBaseJInvent) getBean("JInventInstance");
    }

    private String ElementoElegido;
    /**
     * <p>Constructor.</p>
     */
    public jcanon() {
        fakeHoraFin.clear();
        fakeHoraInicio.clear();
        selectOneMenu1DefaultItems.clear();
        selectOneMenu1DefaultItems.setItems(new String[]{"Cañon","Laptop"});

        this.comboCan.setDisabled(true);
        this.comboLaptop.setDisabled(true);
        this.horaFin.setDisabled(true);

        this.LlenarHora(1);

        this.ElementoElegido="Cañon";
        LlenarComboTipoEquipo(2);

        lu= getJHardminInstance().getCurrentUser();

        if(lu!=null){
            U = LoginManager.getInstance().getUsuario(lu);

            this.lblUser.setValue((String)U.getNombre());

            switch(U.getIdrol().getIdrol()){
            case 3:
                Ing = new BeanBaseJManLab().getDocenteByUsuario(U.getIdusuario());
                this.comboDocente.setDisabled(true);
                break;
            default:
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
        this.renderer=false;
        this.rendererMultimedia=false;

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

private List exc = new ArrayList();

    public void LlenarComboCanon(){
        //Llenar Combo de existencias

        Existencia [] existencias = new edu.ues.jhard.beans.BeanBaseJCanon().getEquipoMultimedia(16);

        if(existencias.length!=0){
            this.mostrarError=false;
            this.btnCrearReserva.setDisabled(false);

        canonElegido = existencias[0];


        for(int i=0;i<existencias.length;i++){

            String label = existencias[i].getIdhardware().getNombre() +"  "+existencias[i].getIdhardware().getModelo();
            getExc().add(new SelectItem(existencias[i].getIdexistencia(),label));
        }

        }else{
            this.btnCrearReserva.setDisabled(true);
            this.mensajeError="No se encuentran existencias disponibles.";
            this.mostrarError=true;
        }
    }

private List exl = new ArrayList();
private String mensajeError;
private boolean mostrarError;

    public void LlenarComboLaptop(){

        Existencia [] existencias = new edu.ues.jhard.beans.BeanBaseJCanon().getEquipoMultimedia(14);

        if(existencias.length!=0){
            this.mostrarError=false;
            this.btnCrearReserva.setDisabled(false);

            laptopElegida = existencias[0];


        for(int i=0;i<existencias.length;i++){

            String label = existencias[i].getIdhardware().getNombre() +"  "+existencias[i].getIdhardware().getModelo();
            getExl().add(new SelectItem(existencias[i].getIdexistencia(),label));
        }

//        UISelectItems itemsEx = new UISelectItems();
//        itemsEx.setValue(ex);
//        this.comboLaptop.getChildren().add(itemsEx);
        }else{
            this.btnCrearReserva.setDisabled(true);
            this.mensajeError="No se encuentran existencias disponibles.";
            this.mostrarError=true;
        }
        
    }

private List in = new ArrayList();

    public void LlenarComboDocentes(){

        Docente [] docentes = new edu.ues.jhard.beans.BeanBaseJManLab().getDocentes();

        Ing = docentes[0];

        for(int i=0;i<docentes.length;i++){

            String label = docentes[i].getNombres()+"  "+docentes[i].getApellidos();
            getIn().add(new SelectItem(docentes[i].getIddocente(),label));
        }

    }

    /**
     * Método para llenar los comboboxes con las horas disponibles para reservas, según los horarios
     * que se manejan en la Universidad
     * @param Integer inicioFin
     */
    public void LlenarHora(int inicioFin){

        String [] horas=null;
        this.horaFin.getChildren().clear();

        if(inicioFin==1){
            hours = new String []  {"6:45","7:35","8:25","9:15","10:05","10:55","11:45","12:35","13:00","13:50","14:40","15:30","16:20","17:10","18:00","18:50","19:40","20:30"};

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

    /**
     * Método para manejar la acción para crear una nueva reserva de equipo multimedia
     */
    public String btnCrearReserva_action() {

            BeanBaseJCanon instance = new BeanBaseJCanon();
            List<Reserva>  mismoDia;
            Estadoreserva er = new BeanBaseJCanon().getEntityManager().find(Estadoreserva.class, 1);
            Calendar c = Calendar.getInstance();

            if(this.checkCan.isSelected()){
                Reserva reservaCanon = new Reserva();

                String tmp=(String)this.comboCan.getValue();
                if(tmp!=null){
                    System.out.println("TODO BIEN--> "+ tmp);
                    Integer id=Integer.parseInt(tmp);
                    System.out.println("TODO BIEN--> "+ id);
                    canonElegido=new BeanBaseJCanon().getEntityManager().find(Existencia.class, id);
                }


                reservaCanon.setFechareserva(new Date((c.get(Calendar.YEAR))-1900, c.get(Calendar.MONTH), c.get(Calendar.DATE)));
                
                Date fechaI = (Date)this.selectFecha.getValue();
                String [] tiempoI = this.horaInicio.getValue().toString().split("\\:");
                int hourI = Integer.parseInt(tiempoI[0]);
                int minuteI = Integer.parseInt(tiempoI[1]);
                int secondI = 00;


                reservaCanon.setFechahorainicioprestamo(new Date(fechaI.getYear(),fechaI.getMonth(),(fechaI.getDate()+1),hourI,minuteI,secondI));

                String [] tiempoF = this.horaFin.getValue().toString().split("\\:");
                int hourF = Integer.parseInt(tiempoF[0]);
                int minuteF = Integer.parseInt(tiempoF[1]);
                int secondF = 00;

                reservaCanon.setFechahorafinprestamo(new Date(fechaI.getYear(),fechaI.getMonth(),(fechaI.getDate()+1),hourF,minuteF,secondF));


                mismoDia=instance.getReservasMismoDia((fechaI.getDate()+1), (fechaI.getMonth()+1), (fechaI.getYear()+1900));
                
                System.out.println("tamaño lista:---> "+ mismoDia.size());
                int reservas =0;
                
                for (int i=0; i<mismoDia.size();i++) {
                    
                    Reserva r = mismoDia.get(i);

                    if(reservaCanon.getFechahorainicioprestamo().getTime()>=r.getFechahorainicioprestamo().getTime() && reservaCanon.getFechahorafinprestamo().getTime()<=r.getFechahorafinprestamo().getTime())
                    {   reservas++;
                        System.out.println("ENTRA--> "+ reservas);
                    }
                        //reservas += Integer.parseInt(instance.getReservasDeUnaMismaHoraFecha(r.getFechahorainicioprestamo()));
                }

                int equipos = Integer.parseInt(instance.getNumeroEquipoMultimedia(canonElegido.getIdhardware().getIdclasificacion().getIdclasificacion()));

                System.out.println("RESERVAS--->>>>" + reservas);
                if(reservas>=equipos){
                    this.lblMensajes.setValue("No se puede realizar la reserva. Equipo multimedia insuficiente");
                    this.renderer=true;

                }else{
                    reservaCanon.setDescripcion("Prestamo de "+this.canonElegido.getIdhardware().getNombre() +" "+this.canonElegido.getIdhardware().getIdmarca().getNombre()+"  "+this.canonElegido.getIdhardware().getModelo());
                    reservaCanon.setIdequipoexistente(canonElegido);
                    reservaCanon.setIdubicacion(canonElegido.getIdubicacion());
                    reservaCanon.setIdusuario(U);
                    reservaCanon.setIdestado(er);
                    reservaCanon.setIddocente(Ing);

                    instance.registrarReserva(reservaCanon);

                    this.lblMensajes.setValue("Reserva hecha con éxito");
                    this.renderer=true;
                }

            }

            if(this.checkLaptop.isSelected()){
                Reserva reservaLaptop = new Reserva();

                String tmp=(String)this.comboLaptop.getValue();
                if(tmp!=null){
                    System.out.println("TODO BIEN--> "+ tmp);
                    Integer id=Integer.parseInt(tmp);
                    System.out.println("TODO BIEN--> "+ id);
                    laptopElegida=new BeanBaseJCanon().getEntityManager().find(Existencia.class, id);
                }
                reservaLaptop.setFechareserva(new Date((c.get(Calendar.YEAR))-1900, c.get(Calendar.MONTH), c.get(Calendar.DATE)));
                
                Date fechaI = (Date)this.selectFecha.getValue();
                String [] tiempoI = this.horaInicio.getValue().toString().split("\\:");
                int hourI = Integer.parseInt(tiempoI[0]);
                int minuteI = Integer.parseInt(tiempoI[1]);
                int secondI = 00;

                reservaLaptop.setFechahorainicioprestamo(new Date(fechaI.getYear(),fechaI.getMonth(),(fechaI.getDate()+1),hourI,minuteI,secondI));

                String [] tiempoF = this.horaFin.getValue().toString().split("\\:");
                int hourF = Integer.parseInt(tiempoF[0]);
                int minuteF = Integer.parseInt(tiempoF[1]);
                int secondF = 00;

                reservaLaptop.setFechahorafinprestamo(new Date(fechaI.getYear(),fechaI.getMonth(),(fechaI.getDate()+1),hourF,minuteF,secondF));

                //int reservas = Integer.parseInt(instance.getReservasDeUnaMismaHoraFecha(reservaLaptop.getFechahorainicioprestamo()));
                mismoDia=null;
                mismoDia=instance.getReservasMismoDia((fechaI.getDate()+1), (fechaI.getMonth()+1), (fechaI.getYear()+1900));

                System.out.println("tamaño lista:---> "+ mismoDia.size());
                int reservas =0;

                for (int i=0; i<mismoDia.size();i++) {

                    Reserva r = mismoDia.get(i);

                    if(reservaLaptop.getFechahorainicioprestamo().getTime()>=r.getFechahorainicioprestamo().getTime() && reservaLaptop.getFechahorafinprestamo().getTime()<=r.getFechahorafinprestamo().getTime())
                    {   reservas++;
                        System.out.println("ENTRA--> "+ reservas);
                    }
                        //reservas += Integer.parseInt(instance.getReservasDeUnaMismaHoraFecha(r.getFechahorainicioprestamo()));
                }

                int equipos = Integer.parseInt(instance.getNumeroEquipoMultimedia(laptopElegida.getIdhardware().getIdclasificacion().getIdclasificacion()));

                if(reservas>=equipos){
                    this.lblMensajes.setValue("No se puede realizar la reserva. Equipo multimedia insuficiente");
                    this.renderer=true;

                }else{
                    reservaLaptop.setDescripcion("Prestamo de "+this.laptopElegida.getIdhardware().getNombre() +" "+this.laptopElegida.getIdhardware().getIdmarca().getNombre()+" "+this.laptopElegida.getIdhardware().getModelo());
                    reservaLaptop.setIdequipoexistente(laptopElegida);
                    reservaLaptop.setIdubicacion(laptopElegida.getIdubicacion());
                    reservaLaptop.setIdusuario(U);
                    reservaLaptop.setIdestado(er);
                    reservaLaptop.setIddocente(Ing);

                    instance.registrarReserva(reservaLaptop);

                    this.lblMensajes.setValue("Reserva hecha con éxito");
                    this.renderer=true;

                }
                
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
        this.renderer=false;
        return null;
    }

    /**
     * @return the renderer
     */
    public boolean isRenderer() {
        return renderer;
    }

    /**
     * @param renderer the renderer to set
     */
    public void setRenderer(boolean renderer) {
        this.renderer = renderer;
    }

    public String addMultimedia(){

        this.rendererMultimedia=true;
        this.visibleMultimedia=true;
        return "";
    }

    public String btnCancelarAdd_action() {

        this.rendererMultimedia=false;
        this.visibleMultimedia=false;
        return null;
    }

private List equ = new ArrayList();

    public void LlenarComboTipoEquipo(int tipo){
        this.equ.clear();
        
        Equipo []equipos;
        if(tipo==2){
            equipos = new edu.ues.jhard.beans.BeanBaseJCanon().getEquipoClasificado(16);
        }
        else{
            equipos = new edu.ues.jhard.beans.BeanBaseJCanon().getEquipoClasificado(14);
        }


        for(int i=0;i<equipos.length;i++){

            String label = equipos[i].getNombre()+"  "+equipos[i].getModelo();
            getEqu().add(new SelectItem(equipos[i].getIdequipo(),label));
        }

//        UISelectItems itemsEq = new UISelectItems();
//        itemsEq.setValue(eq);
//        this.comboTipoEq.getChildren().add(itemsEq);
    }

    public void comboEqAdd_processValueChange(ValueChangeEvent vce) {
        if(this.comboEqAdd.getValue().equals("Cañon")){
            LlenarComboTipoEquipo(2);
        }
        else{
            LlenarComboTipoEquipo(3);
        }
    }

    /**
     * Método para agregar un nuevo Equipo Multimedia
     * @return
     */
    public String btnAceptarAdd_action() {
        Existencia e = new Existencia();
        Equipo eq = new Equipo();
        BeanBaseJCanon instance = new BeanBaseJCanon();
        Ubicacion u = instance.getEntityManager().find(Ubicacion.class, 1);
        //Adquisicion a = instance.getEntityManager().find(Adquisicion.class, 1);
        Estadoequipo ee = instance.getEntityManager().find(Estadoequipo.class, 1);

         String tmp=(String)this.comboTipoEq.getValue();
         if(tmp!=null){
            System.out.println("TODO BIEN--> "+ tmp);
            Integer id=Integer.parseInt(tmp);
            System.out.println("TODO BIEN--> "+ id);
            eq = instance.getEntityManager().find(Equipo.class, id);
         }
        e.setCodigo(this.txtCodigoExistencia.getValue().toString());
        //e.setIdadquisicion(a);
        e.setIdestado(ee);
        e.setIdhardware(eq);
        e.setIdubicacion(u);

        instance.registrarExistencia(e);


        this.rendererMultimedia=false;
        this.visibleMultimedia=false;
        this.lblMensajes.setValue("Reserva hecha con éxito");
        this.renderer=true;

        return null;
    }

    /**
     * @return the rendererMultimedia
     */
    public boolean isRendererMultimedia() {
        return rendererMultimedia;
    }

    /**
     * @param rendererMultimedia the rendererMultimedia to set
     */
    public void setRendererMultimedia(boolean rendererMultimedia) {
        this.rendererMultimedia = rendererMultimedia;
    }

    /**
     * @return the rendererAddEq
     */
    public boolean isRendererAddEq() {
        return rendererAddEq;
    }

    /**
     * @param rendererAddEq the rendererAddEq to set
     */
    public void setRendererAddEq(boolean rendererAddEq) {
        this.rendererAddEq = rendererAddEq;
    }

    /**
     * @return the visibleMultimedia
     */
    public boolean isVisibleMultimedia() {
        return visibleMultimedia;
    }

    /**
     * @param visibleMultimedia the visibleMultimedia to set
     */
    public void setVisibleMultimedia(boolean visibleMultimedia) {
        this.visibleMultimedia = visibleMultimedia;
    }

    public String addEqJInvent(){

        this.getJInventInstance().addEquipo();
        this.LlenarComboTipoEquipo(2);
        this.rendererAddEq=false;

        this.rendererMultimedia=true;


        return "";
    }
    public String cancelEqJInvent(){
        this.rendererAddEq=false;

        this.rendererMultimedia=true;
        return"";
    }

    public String mostrarAddEq(){
        
        setearClasificacion();
        System.out.println("ENTRA A MOSTRAR EL POPUP?");
        this.rendererMultimedia=false;
        this.rendererAddEq=true;

        return "";
    }

    /**
     * @return the exc
     */
    public List getExc() {
        return exc;
    }

    /**
     * @return the exl
     */
    public List getExl() {
        return exl;
    }

    /**
     * @return the in
     */
    public List getIn() {
        return in;
    }

    /**
     * @return the eq
     */
    public List getEqu() {
        return equ;
    }

    /**
     * Método para colocar la clasificación específica con respecto al nuevo equipo multimedia que se desea agregar.
     * Pueden ser cañones o laptops
     */
    public void setearClasificacion(){

        String idClasificacion="";
        if(this.comboEqAdd.getValue().equals("Cañon")){
            idClasificacion="16";
        }else{
            idClasificacion="14";
        }
        System.out.println("la disque clasificacion a mostrar es -->" + idClasificacion);
        getJInventInstance().getClasificaciontm().seleccionarNodo(idClasificacion);

    }

    /**
     * @return the mensajeError
     */
    public String getMensajeError() {
        return mensajeError;
    }

    /**
     * @param mensajeError the mensajeError to set
     */
    public void setMensajeError(String mensajeError) {
        this.mensajeError = mensajeError;
    }

    /**
     * @return the mostrarError
     */
    public boolean isMostrarError() {
        return mostrarError;
    }

    /**
     * @param mostrarError the mostrarError to set
     */
    public void setMostrarError(boolean mostrarError) {
        this.mostrarError = mostrarError;
    }

}

