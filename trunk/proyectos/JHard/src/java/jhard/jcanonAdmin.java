/*
 * jcanonAdmin.java
 *
 * Created on 09-jul-2009, 12:16:38
 * Copyright Hugol
 */
package jhard;

import com.icesoft.faces.component.ext.HtmlCommandButton;
import com.icesoft.faces.component.ext.HtmlOutputText;
import com.icesoft.faces.component.ext.HtmlSelectBooleanCheckbox;
import com.icesoft.faces.component.ext.HtmlSelectOneMenu;
import com.icesoft.faces.component.jsfcl.data.DefaultSelectedData;
import com.icesoft.faces.component.jsfcl.data.DefaultSelectionItems;
import com.icesoft.faces.component.jsfcl.data.DefaultTableDataModel;
import com.icesoft.faces.component.jsfcl.data.PopupBean;
import com.icesoft.faces.component.jsfcl.data.SelectInputDateBean;
import com.icesoft.faces.component.panelpopup.PanelPopup;
import com.icesoft.faces.component.selectinputdate.SelectInputDate;
import com.sun.rave.web.ui.appbase.AbstractPageBean;
import edu.ues.jhard.beans.BeanBaseJCanon;
import edu.ues.jhard.jpa.Estadoreserva;
import edu.ues.jhard.jpa.Reserva;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.FacesException;
import javax.faces.component.UISelectItems;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;


/**
 * <p>Page bean that corresponds to a similarly named JSP page.  This
 * class contains component definitions (and initialization code) for
 * all components that you have defined on this page, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 */
public class jcanonAdmin extends AbstractPageBean {
    // <editor-fold defaultstate="collapsed" desc="Managed Component Definition">
    private int __placeholder;

    /**
     * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    private void _init() throws Exception {
        horaInicioFake.setItems(new String[]{});
        horaFinFake.setItems(new String[]{});
    }
    private DefaultTableDataModel listaReservas = new DefaultTableDataModel();

    public DefaultTableDataModel getListaReservas() {
        return listaReservas;
    }

    public void setListaReservas(DefaultTableDataModel dtdm) {
        this.listaReservas = dtdm;
    }

    private PopupBean panelPopup1Bean = new PopupBean();

    public PopupBean getPanelPopup1Bean() {
        return panelPopup1Bean;
    }

    public void setPanelPopup1Bean(PopupBean pb) {
        this.panelPopup1Bean = pb;
    }
    private PopupBean panelPopup2Bean = new PopupBean();

    public PopupBean getPanelPopup2Bean() {
        return panelPopup2Bean;
    }

    public void setPanelPopup2Bean(PopupBean pb) {
        this.panelPopup2Bean = pb;
    }
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
    private DefaultSelectedData selectBooleanCheckbox3Bean = new DefaultSelectedData();

    public DefaultSelectedData getSelectBooleanCheckbox3Bean() {
        return selectBooleanCheckbox3Bean;
    }

    public void setSelectBooleanCheckbox3Bean(DefaultSelectedData dsd) {
        this.selectBooleanCheckbox3Bean = dsd;
    }
    private PanelPopup panelModEstado = new PanelPopup();

    public PanelPopup getPanelModEstado() {
        return panelModEstado;
    }

    public void setPanelModEstado(PanelPopup pp) {
        this.panelModEstado = pp;
    }
    private HtmlOutputText lblMensajeModEstado = new HtmlOutputText();

    public HtmlOutputText getLblMensajeModEstado() {
        return lblMensajeModEstado;
    }

    public void setLblMensajeModEstado(HtmlOutputText hot) {
        this.lblMensajeModEstado = hot;
    }
    private HtmlSelectBooleanCheckbox checkPendiente = new HtmlSelectBooleanCheckbox();

    public HtmlSelectBooleanCheckbox getCheckPendiente() {
        return checkPendiente;
    }

    public void setCheckPendiente(HtmlSelectBooleanCheckbox hsbc) {
        this.checkPendiente = hsbc;
    }
    private HtmlSelectBooleanCheckbox checkUso = new HtmlSelectBooleanCheckbox();

    public HtmlSelectBooleanCheckbox getCheckUso() {
        return checkUso;
    }

    public void setCheckUso(HtmlSelectBooleanCheckbox hsbc) {
        this.checkUso = hsbc;
    }
    private HtmlSelectBooleanCheckbox checkDespachada = new HtmlSelectBooleanCheckbox();

    public HtmlSelectBooleanCheckbox getCheckDespachada() {
        return checkDespachada;
    }

    public void setCheckDespachada(HtmlSelectBooleanCheckbox hsbc) {
        this.checkDespachada = hsbc;
    }
    private HtmlCommandButton btnModEstadoAceptar = new HtmlCommandButton();

    public HtmlCommandButton getBtnModEstadoAceptar() {
        return btnModEstadoAceptar;
    }

    public void setBtnModEstadoAceptar(HtmlCommandButton hcb) {
        this.btnModEstadoAceptar = hcb;
    }
    private HtmlCommandButton btnModEstadoCancelar = new HtmlCommandButton();

    public HtmlCommandButton getBtnModEstadoCancelar() {
        return btnModEstadoCancelar;
    }

    public void setBtnModEstadoCancelar(HtmlCommandButton hcb) {
        this.btnModEstadoCancelar = hcb;
    }
    private HtmlOutputText lblMensajes = new HtmlOutputText();

    public HtmlOutputText getLblMensajes() {
        return lblMensajes;
    }

    public void setLblMensajes(HtmlOutputText hot) {
        this.lblMensajes = hot;
    }
    private HtmlCommandButton btnAceptarMensajes = new HtmlCommandButton();

    public HtmlCommandButton getBtnAceptarMensajes() {
        return btnAceptarMensajes;
    }

    public void setBtnAceptarMensajes(HtmlCommandButton hcb) {
        this.btnAceptarMensajes = hcb;
    }
    private HtmlCommandButton btnCancelarMensajes = new HtmlCommandButton();

    public HtmlCommandButton getBtnCancelarMensajes() {
        return btnCancelarMensajes;
    }

    public void setBtnCancelarMensajes(HtmlCommandButton hcb) {
        this.btnCancelarMensajes = hcb;
    }
    private PanelPopup panelMensajes = new PanelPopup();

    public PanelPopup getPanelMensajes() {
        return panelMensajes;
    }

    public void setPanelMensajes(PanelPopup pp) {
        this.panelMensajes = pp;
    }
    private PopupBean panelPopup1Bean1 = new PopupBean();

    public PopupBean getPanelPopup1Bean1() {
        return panelPopup1Bean1;
    }

    public void setPanelPopup1Bean1(PopupBean pb) {
        this.panelPopup1Bean1 = pb;
    }
    private SelectInputDateBean selectInputDate1Bean = new SelectInputDateBean();

    public SelectInputDateBean getSelectInputDate1Bean() {
        return selectInputDate1Bean;
    }

    public void setSelectInputDate1Bean(SelectInputDateBean sidb) {
        this.selectInputDate1Bean = sidb;
    }
    private DefaultSelectionItems horaInicioFake = new DefaultSelectionItems();

    public DefaultSelectionItems getHoraInicioFake() {
        return horaInicioFake;
    }

    public void setHoraInicioFake(DefaultSelectionItems dsi) {
        this.horaInicioFake = dsi;
    }
    private DefaultSelectionItems horaFinFake = new DefaultSelectionItems();

    public DefaultSelectionItems getHoraFinFake() {
        return horaFinFake;
    }

    public void setHoraFinFake(DefaultSelectionItems dsi) {
        this.horaFinFake = dsi;
    }
    private PanelPopup panelPosponer = new PanelPopup();

    public PanelPopup getPanelPosponer() {
        return panelPosponer;
    }

    public void setPanelPosponer(PanelPopup pp) {
        this.panelPosponer = pp;
    }
    private HtmlOutputText lblTextMod = new HtmlOutputText();

    public HtmlOutputText getLblTextMod() {
        return lblTextMod;
    }

    public void setLblTextMod(HtmlOutputText hot) {
        this.lblTextMod = hot;
    }
    private SelectInputDate fechaMod = new SelectInputDate();

    public SelectInputDate getFechaMod() {
        return fechaMod;
    }

    public void setFechaMod(SelectInputDate sid) {
        this.fechaMod = sid;
    }
    private HtmlSelectOneMenu horaInicioMod = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getHoraInicioMod() {
        return horaInicioMod;
    }

    public void setHoraInicioMod(HtmlSelectOneMenu hsom) {
        this.horaInicioMod = hsom;
    }
    private HtmlSelectOneMenu horaFinMod = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getHoraFinMod() {
        return horaFinMod;
    }

    public void setHoraFinMod(HtmlSelectOneMenu hsom) {
        this.horaFinMod = hsom;
    }
    private HtmlCommandButton btnAceptarMod = new HtmlCommandButton();

    public HtmlCommandButton getBtnAceptarMod() {
        return btnAceptarMod;
    }

    public void setBtnAceptarMod(HtmlCommandButton hcb) {
        this.btnAceptarMod = hcb;
    }
    private HtmlCommandButton btnCancelarMod = new HtmlCommandButton();

    public HtmlCommandButton getBtnCancelarMod() {
        return btnCancelarMod;
    }

    public void setBtnCancelarMod(HtmlCommandButton hcb) {
        this.btnCancelarMod = hcb;
    }
    // </editor-fold>

    private List<Reserva> listaReservasPendientes;
        /**
     * <p>Construct a new Page bean instance.</p>
     */
    public jcanonAdmin() {
        horaInicioFake.clear();
        horaFinFake.clear();
        listaReservasPendientes=new BeanBaseJCanon().getReservasPendientesEnUso();
        this.panelMensajes.setRendered(false);
        this.panelModEstado.setRendered(false);
        this.panelPosponer.setRendered(false);

        this.horaFinMod.setDisabled(true);
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
            log("jcanonAdmin Initialization Failure", e);
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
     * @return the listaReservasPendientes
     */
    public List<Reserva> getListaReservasPendientes() {
        return listaReservasPendientes;
    }

    /**
     * @param listaReservasPendientes the userList to set
     */
    public void setListaReservasPendientes(List<Reserva> listaReservas) {
        this.listaReservasPendientes = listaReservas;
    }
    
    private Reserva reservaMod;

    public String modificarEstadoReserva(){
        String idUsuario = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("idReserva");
        System.out.println(idUsuario);
        Integer id = Integer.parseInt(idUsuario);

        this.checkDespachada.setSelected(false);
        this.checkPendiente.setSelected(false);
        this.checkUso.setSelected(false);

        reservaMod = new BeanBaseJCanon().getEntityManager().find(Reserva.class, id);

        switch(reservaMod.getIdestado().getIdestadoreserva()){
            case 1:
                System.out.println("Pendiente");
                this.checkPendiente.setSelected(true);
                break;
            case 2:
                System.out.println("En Uso");
                this.checkUso.setSelected(true);
                break;
            case 3:
                System.out.println("Despachada");
                this.checkDespachada.setSelected(true);
                break;
        }

        this.lblMensajeModEstado.setValue("Seleccione el estado actual de "+reservaMod.getDescripcion());

        this.panelModEstado.setRendered(true);
        this.panelModEstado.setVisible(true);
        this.panelModEstado.setModal(true);


        return "";
    }

//    public String cambiarEstado(){
//
//        this.panelModEstado.setRendered(true);
//        this.panelModEstado.setVisible(true);
//        this.panelModEstado.setModal(true);
//        return "";
//
//    }

    public String btnModEstadoAceptar_action() {

        Estadoreserva er=null;

        BeanBaseJCanon instance = new BeanBaseJCanon();

        if(this.checkPendiente.isSelected()){
            er = instance.getEntityManager().find(Estadoreserva.class, 1);
        }

        if(this.checkDespachada.isSelected()){
            er = instance.getEntityManager().find(Estadoreserva.class, 3);
        }

        if(this.checkUso.isSelected()){
            er = instance.getEntityManager().find(Estadoreserva.class, 2);
        }

        reservaMod.setIdestado(er);
        instance.modificarEstadoReserva(reservaMod);
        listaReservasPendientes=new BeanBaseJCanon().getReservasPendientesEnUso();
        
        this.panelModEstado.setRendered(false);
        this.panelModEstado.setVisible(false);
        this.panelModEstado.setModal(false);

        this.lblMensajes.setValue("Reserva modificada exitosamente");
        this.panelMensajes.setRendered(true);
        this.panelMensajes.setVisible(true);
        this.panelMensajes.setModal(true);

        return "done";
    }

    public String btnModEstadoCancelar_action() {
        this.panelModEstado.setRendered(false);
        this.panelModEstado.setVisible(false);
        this.panelModEstado.setModal(false);
        return null;
    }

    public void checkPendiente_processValueChange(ValueChangeEvent vce) {
        if(this.checkPendiente.isSelected()){
            this.checkDespachada.setSelected(false);
            this.checkUso.setSelected(false);
        }
    }

    public void checkUso_processValueChange(ValueChangeEvent vce) {
        if(this.checkUso.isSelected()){
            this.checkPendiente.setSelected(false);
            this.checkDespachada.setSelected(false);
        }
    }

    public void checkDespachada_processValueChange(ValueChangeEvent vce) {
        if(this.checkDespachada.isSelected()){
            this.checkPendiente.setSelected(false);
            this.checkUso.setSelected(false);
        }
    }

    public String btnAceptarMensajes_action() {
        this.panelMensajes.setRendered(false);
        this.panelMensajes.setVisible(false);
        this.panelMensajes.setModal(false);
        return null;
    }


    private String [] hours;
    private String horaSeleccionada="6:45";

    public String posponerReserva(){
        String idUsuario = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("idReserva");
        System.out.println(idUsuario);
        Integer id = Integer.parseInt(idUsuario);
        reservaMod = new BeanBaseJCanon().getEntityManager().find(Reserva.class, id);

        LlenarHora(1);

        this.lblTextMod.setValue("Cambie fecha y hora para: "+this.reservaMod.getDescripcion());


        this.fechaMod.setValue(this.reservaMod.getFechahorainicioprestamo());
        
        this.panelPosponer.setRendered(true);
        this.panelPosponer.setVisible(true);
        this.panelPosponer.setModal(true);


        return "";
    }

    public void LlenarHora(int inicioFin){
        this.horaFinMod.getChildren().clear();
        
         String [] horas=null;

        if(inicioFin==1){
            hours = new String []  {"6:45","7:35","8:25","9:15","10:05","10:55","11:45","12:35","13:00","13:50","14:40","15:30","16:20","17:10","18:00","18:50","19:40","20:30"};

            ArrayList h = new ArrayList();

            for(int i=0;i<hours.length;i++){

                String label = hours[i];
                h.add(new SelectItem(hours[i],label));
            }

            UISelectItems itemsHI = new UISelectItems();
            itemsHI.setValue(h);
            this.horaInicioMod.getChildren().add(itemsHI);

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

                    this.horaFinMod.setDisabled(false);
                    UISelectItems itemsHF = new UISelectItems();
                    itemsHF.setValue(hf);
                    this.horaFinMod.getChildren().add(itemsHF);

                    continue;
                }
            }
        }
    }

    public String btnAceptarMod_action() {
        
        Date fechaI = (Date)this.fechaMod.getValue();
        String [] tiempoI = this.horaInicioMod.getValue().toString().split("\\:");
        int hourI = Integer.parseInt(tiempoI[0]);
        int minuteI = Integer.parseInt(tiempoI[1]);
        int secondI = 00;

        reservaMod.setFechahorainicioprestamo(new Date(fechaI.getYear(),fechaI.getMonth(),(fechaI.getDate()+1),hourI,minuteI,secondI));


        String [] tiempoF = this.horaFinMod.getValue().toString().split("\\:");
        int hourF = Integer.parseInt(tiempoF[0]);
        int minuteF = Integer.parseInt(tiempoF[1]);
        int secondF = 00;

        reservaMod.setFechahorafinprestamo(new Date(fechaI.getYear(),fechaI.getMonth(),(fechaI.getDate()+1),hourF,minuteF,secondF));
        
        new BeanBaseJCanon().modificarEstadoReserva(reservaMod);
        listaReservasPendientes=new BeanBaseJCanon().getReservasPendientesEnUso();
        
        this.panelPosponer.setRendered(false);
        this.panelPosponer.setVisible(false);
        this.panelPosponer.setModal(false);

        this.lblMensajes.setValue("Reserva modificada con éxito");

        this.panelMensajes.setRendered(true);
        this.panelMensajes.setVisible(true);
        this.panelMensajes.setModal(true);

        return null;
    }

    public String btnCancelarMod_action() {

        this.panelPosponer.setRendered(false);
        this.panelPosponer.setVisible(false);
        this.panelPosponer.setModal(false);

        return null;
    }


    public String Eliminar(){
        String idUsuario = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("idReserva");
        System.out.println(idUsuario);
        Integer id = Integer.parseInt(idUsuario);
        reservaMod = new BeanBaseJCanon().getEntityManager().find(Reserva.class, id);

        new BeanBaseJCanon().eliminarReserva(reservaMod);
        listaReservasPendientes=new BeanBaseJCanon().getReservasPendientesEnUso();

        this.lblMensajes.setValue("Reserva eliminada con éxito");
        
        this.panelMensajes.setRendered(true);
        this.panelMensajes.setVisible(true);
        this.panelMensajes.setModal(true);

        return "";
    }

    public void horaInicioMod_processValueChange(ValueChangeEvent vce) {
        this.horaSeleccionada=this.horaInicioMod.getValue().toString();

        LlenarHora(2);
    }

}
