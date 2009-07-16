/*
 * jrequestAdmin.java
 *
 * Created on 18-jun-2009, 14:18:50
 * Copyright Hugol
 */
package jhard;

import com.icesoft.faces.component.ext.HtmlCommandButton;
import com.icesoft.faces.component.ext.HtmlInputText;
import com.icesoft.faces.component.ext.HtmlInputTextarea;
import com.icesoft.faces.component.ext.HtmlOutputLabel;
import com.icesoft.faces.component.ext.HtmlOutputText;
import com.icesoft.faces.component.ext.HtmlSelectBooleanCheckbox;
import com.icesoft.faces.component.ext.HtmlSelectOneListbox;
import com.icesoft.faces.component.ext.HtmlSelectOneMenu;
import com.icesoft.faces.component.jsfcl.data.DefaultSelectedData;
import com.icesoft.faces.component.jsfcl.data.DefaultSelectionItems;
import com.icesoft.faces.component.jsfcl.data.PopupBean;
import com.icesoft.faces.component.panelpopup.PanelPopup;
import com.icesoft.faces.component.paneltabset.TabChangeEvent;
import com.icesoft.faces.component.selectinputtext.SelectInputText;
import com.sun.rave.faces.data.DefaultSelectItemsArray;
import com.sun.rave.web.ui.appbase.AbstractPageBean;
import edu.ues.jhard.beans.BeanBaseJHardmin;
import edu.ues.jhard.beans.BeanBaseJRequest;
import edu.ues.jhard.jpa.Equiposimple;
import edu.ues.jhard.jpa.Mantenimiento;
import edu.ues.jhard.jpa.Solicitud;
import edu.ues.jhard.jpa.Tecnico;
import edu.ues.jhard.jpa.Usuario;
import edu.ues.jhard.jpa.Bitacoraestados;
import edu.ues.jhard.jpa.Estadoequipo;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
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
public class jrequestAdmin extends AbstractPageBean {
    // <editor-fold defaultstate="collapsed" desc="Managed Component Definition">
    private int __placeholder;

    /**
     * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */


    private void _init() throws Exception {
//        fakeSol.setItems(new String[]{});
//        fakeMan.setItems(new String[]{});
//        fakeBit.setItems(new String[]{});

//        fakeComboPrioridad.setItems(new String[]{"Alta", "Media", "Baja"});
//        fakeComboEstado1.setItems(new String[]{});
//        fakeComboTecnico1.setItems(new String[]{});


    }

//    private DefaultSelectItemsArray fakeComboEstado1 = new DefaultSelectItemsArray();
//
//    public DefaultSelectItemsArray getFakeComboEstado1() {
//        return fakeComboEstado1;
//    }
//
//    public void setFakeComboEstado1(DefaultSelectItemsArray dsia) {
//        this.fakeComboEstado1 = dsia;
//    }
//    private DefaultSelectItemsArray fakeComboTecnico1 = new DefaultSelectItemsArray();
//
//    public DefaultSelectItemsArray getFakeComboTecnico1() {
//        return fakeComboTecnico1;
//    }
//
//    public void setFakeComboTecnico1(DefaultSelectItemsArray dsia) {
//        this.fakeComboTecnico1 = dsia;
//    }
    private HtmlOutputLabel lblNombre = new HtmlOutputLabel();

    public HtmlOutputLabel getLblNombre() {
        return lblNombre;
    }

    public void setLblNombre(HtmlOutputLabel hol) {
        this.lblNombre = hol;
    }
    private HtmlOutputLabel lblPersona = new HtmlOutputLabel();

    public HtmlOutputLabel getLblPersona() {
        return lblPersona;
    }

    public void setLblPersona(HtmlOutputLabel hol) {
        this.lblPersona = hol;
    }
    private HtmlSelectOneMenu comboPrioridad = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getComboPrioridad() {
        return comboPrioridad;
    }

    public void setComboPrioridad(HtmlSelectOneMenu hsom) {
        this.comboPrioridad = hsom;
    }
    private HtmlSelectOneMenu comboTecnicos = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getComboTecnicos() {
        return comboTecnicos;
    }

    public void setComboTecnicos(HtmlSelectOneMenu hsom) {
        this.comboTecnicos = hsom;
    }
    private HtmlCommandButton btnProceder = new HtmlCommandButton();

    public HtmlCommandButton getBtnProceder() {
        return btnProceder;
    }

    public void setBtnProceder(HtmlCommandButton hcb) {
        this.btnProceder = hcb;
    }
    private HtmlSelectOneListbox listaSol = new HtmlSelectOneListbox();

    public HtmlSelectOneListbox getListaSol() {
        return listaSol;
    }

    public void setListaSol(HtmlSelectOneListbox hsol) {
        this.listaSol = hsol;
    }
    private PanelPopup popUpMensajes = new PanelPopup();

    public PanelPopup getPopUpMensajes() {
        return popUpMensajes;
    }

    public void setPopUpMensajes(PanelPopup pp) {
        this.popUpMensajes = pp;
    }
    private HtmlOutputText lblMensajes = new HtmlOutputText();

    public HtmlOutputText getLblMensajes() {
        return lblMensajes;
    }

    public void setLblMensajes(HtmlOutputText hot) {
        this.lblMensajes = hot;
    }
    private HtmlCommandButton btnOK = new HtmlCommandButton();

    public HtmlCommandButton getBtnOK() {
        return btnOK;
    }

    public void setBtnOK(HtmlCommandButton hcb) {
        this.btnOK = hcb;
    }
    private PanelPopup popUpBitacora = new PanelPopup();

    public PanelPopup getPopUpBitacora() {
        return popUpBitacora;
    }

    public void setPopUpBitacora(PanelPopup pp) {
        this.popUpBitacora = pp;
    }
    private HtmlSelectOneListbox listaMantenimientos = new HtmlSelectOneListbox();

    public HtmlSelectOneListbox getListaMantenimientos() {
        return listaMantenimientos;
    }

    public void setListaMantenimientos(HtmlSelectOneListbox hsol) {
        this.listaMantenimientos = hsol;
    }
    private DefaultSelectedData fakeFin = new DefaultSelectedData();

    public DefaultSelectedData getFakeFin() {
        return fakeFin;
    }

    public void setFakeFin(DefaultSelectedData dsd) {
        this.fakeFin = dsd;
    }
    private HtmlOutputText lblMantenimiento = new HtmlOutputText();

    public HtmlOutputText getLblMantenimiento() {
        return lblMantenimiento;
    }

    public void setLblMantenimiento(HtmlOutputText hot) {
        this.lblMantenimiento = hot;
    }
    private HtmlCommandButton btnAceptarFinalizado = new HtmlCommandButton();

    public HtmlCommandButton getBtnAceptarFinalizado() {
        return btnAceptarFinalizado;
    }

    public void setBtnAceptarFinalizado(HtmlCommandButton hcb) {
        this.btnAceptarFinalizado = hcb;
    }
    private HtmlSelectBooleanCheckbox checkFIn = new HtmlSelectBooleanCheckbox();

    public HtmlSelectBooleanCheckbox getCheckFIn() {
        return checkFIn;
    }

    public void setCheckFIn(HtmlSelectBooleanCheckbox hsbc) {
        this.checkFIn = hsbc;
    }
    private HtmlCommandButton btnCerrar = new HtmlCommandButton();

    public HtmlCommandButton getBtnCerrar() {
        return btnCerrar;
    }

    public void setBtnCerrar(HtmlCommandButton hcb) {
        this.btnCerrar = hcb;
    }
    private PopupBean panelPopup1Bean1 = new PopupBean();

    public PopupBean getPanelPopup1Bean1() {
        return panelPopup1Bean1;
    }

    public void setPanelPopup1Bean1(PopupBean pb) {
        this.panelPopup1Bean1 = pb;
    }
    private HtmlInputText txtApeTec = new HtmlInputText();

    public HtmlInputText getTxtApeTec() {
        return txtApeTec;
    }

    public void setTxtApeTec(HtmlInputText hit) {
        this.txtApeTec = hit;
    }
    private HtmlInputText txtNomTec = new HtmlInputText();

    public HtmlInputText getTxtNomTec() {
        return txtNomTec;
    }

    public void setTxtNomTec(HtmlInputText hit) {
        this.txtNomTec = hit;
    }
    private HtmlCommandButton btnOkTec = new HtmlCommandButton();

    public HtmlCommandButton getBtnOkTec() {
        return btnOkTec;
    }

    public void setBtnOkTec(HtmlCommandButton hcb) {
        this.btnOkTec = hcb;
    }
    private HtmlCommandButton btnCerrarTec = new HtmlCommandButton();

    public HtmlCommandButton getBtnCerrarTec() {
        return btnCerrarTec;
    }

    public void setBtnCerrarTec(HtmlCommandButton hcb) {
        this.btnCerrarTec = hcb;
    }
    private PanelPopup popUpAgregarTec = new PanelPopup();

    public PanelPopup getPopUpAgregarTec() {
        return popUpAgregarTec;
    }

    public void setPopUpAgregarTec(PanelPopup pp) {
        this.popUpAgregarTec = pp;
    }
//    private DefaultSelectItemsArray fakeSol = new DefaultSelectItemsArray();
//
//    public DefaultSelectItemsArray getFakeSol() {
//        return fakeSol;
//    }
//
//    public void setFakeSol(DefaultSelectItemsArray dsia) {
//        this.fakeSol = dsia;
//    }
//    private DefaultSelectItemsArray fakeMan = new DefaultSelectItemsArray();
//
//    public DefaultSelectItemsArray getFakeMan() {
//        return fakeMan;
//    }
//
//    public void setFakeMan(DefaultSelectItemsArray dsia) {
//        this.fakeMan = dsia;
//    }
//    private DefaultSelectionItems fakeBit = new DefaultSelectionItems();
//
//    public DefaultSelectionItems getFakeBit() {
//        return fakeBit;
//    }
//
//    public void setFakeBit(DefaultSelectionItems dsi) {
//        this.fakeBit = dsi;
//    }
    private HtmlSelectOneListbox listaBitacoras = new HtmlSelectOneListbox();

    public HtmlSelectOneListbox getListaBitacoras() {
        return listaBitacoras;
    }

    public void setListaBitacoras(HtmlSelectOneListbox hsol) {
        this.listaBitacoras = hsol;
    }
    private SelectInputText txtEqSimples = new SelectInputText();

    public SelectInputText getTxtEqSimples() {
        return txtEqSimples;
    }

    public void setTxtEqSimples(SelectInputText sit) {
        this.txtEqSimples = sit;
    }
    private PopupBean panelPopup1Bean2 = new PopupBean();

    public PopupBean getPanelPopup1Bean2() {
        return panelPopup1Bean2;
    }

    public void setPanelPopup1Bean2(PopupBean pb) {
        this.panelPopup1Bean2 = pb;
    }
    private PanelPopup popUpModBitacora = new PanelPopup();

    public PanelPopup getPopUpModBitacora() {
        return popUpModBitacora;
    }

    public void setPopUpModBitacora(PanelPopup pp) {
        this.popUpModBitacora = pp;
    }
    private HtmlInputTextarea txtModBitacora = new HtmlInputTextarea();

    public HtmlInputTextarea getTxtModBitacora() {
        return txtModBitacora;
    }

    public void setTxtModBitacora(HtmlInputTextarea hit) {
        this.txtModBitacora = hit;
    }
    private HtmlCommandButton btnAceptarModBitacora = new HtmlCommandButton();

    public HtmlCommandButton getBtnAceptarModBitacora() {
        return btnAceptarModBitacora;
    }

    public void setBtnAceptarModBitacora(HtmlCommandButton hcb) {
        this.btnAceptarModBitacora = hcb;
    }
    private HtmlCommandButton btnCancelarModBitacora = new HtmlCommandButton();

    public HtmlCommandButton getBtnCancelarModBitacora() {
        return btnCancelarModBitacora;
    }

    public void setBtnCancelarModBitacora(HtmlCommandButton hcb) {
        this.btnCancelarModBitacora = hcb;
    }
    private HtmlInputTextarea txtDescripcion = new HtmlInputTextarea();

    public HtmlInputTextarea getTxtDescripcion() {
        return txtDescripcion;
    }

    public void setTxtDescripcion(HtmlInputTextarea hit) {
        this.txtDescripcion = hit;
    }
    private HtmlCommandButton btnSolicitudAdmin = new HtmlCommandButton();

    public HtmlCommandButton getBtnSolicitudAdmin() {
        return btnSolicitudAdmin;
    }

    public void setBtnSolicitudAdmin(HtmlCommandButton hcb) {
        this.btnSolicitudAdmin = hcb;
    }
    private DefaultSelectItemsArray fakeComboPrioridad = new DefaultSelectItemsArray();

    public DefaultSelectItemsArray getFakeComboPrioridad() {
        return fakeComboPrioridad;
    }

    public void setFakeComboPrioridad(DefaultSelectItemsArray dsia) {
        this.fakeComboPrioridad = dsia;
    }
    private HtmlSelectOneMenu comboEstado = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getComboEstado() {
        return comboEstado;
    }

    public void setComboEstado(HtmlSelectOneMenu hsom) {
        this.comboEstado = hsom;
    }
    private PopupBean panelPopup1Bean3 = new PopupBean();

    public PopupBean getPanelPopup1Bean3() {
        return panelPopup1Bean3;
    }

    public void setPanelPopup1Bean3(PopupBean pb) {
        this.panelPopup1Bean3 = pb;
    }
    private PopupBean panelPopup2Bean1 = new PopupBean();

    public PopupBean getPanelPopup2Bean1() {
        return panelPopup2Bean1;
    }

    public void setPanelPopup2Bean1(PopupBean pb) {
        this.panelPopup2Bean1 = pb;
    }
    private PopupBean panelPopup3Bean = new PopupBean();

    public PopupBean getPanelPopup3Bean() {
        return panelPopup3Bean;
    }

    public void setPanelPopup3Bean(PopupBean pb) {
        this.panelPopup3Bean = pb;
    }
//    private HtmlSelectOneMenu comboEstadosEQ = new HtmlSelectOneMenu();
//
//    public HtmlSelectOneMenu getComboEstadosEQ() {
//        return comboEstadosEQ;
//    }
//
//    public void setComboEstadosEQ(HtmlSelectOneMenu hsom) {
//        this.comboEstadosEQ = hsom;
//    }
    // </editor-fold>

private List soc=new ArrayList();
private List man= new ArrayList();

    //ESTE METODO DEBE DE IR EN EL NEGOCIO
    public void llenarLista(){

        //Limpio las listas si están llenas
        limpiarListas();


        //LISTA DE SOLICITUDES 
        //Array que se metera en la selectonelistbox
        //Para comparar cuales solicitudes ya tienen mantenimientos relacionados
        Mantenimiento [] mantenimientos = new edu.ues.jhard.beans.BeanBaseJRequest().getMantenimiento();
        Solicitud [] solicitudes = new edu.ues.jhard.beans.BeanBaseJRequest().getSolicitud();

        //contador
        int cont=0;

        //Bucle para meter las solicitudes en el ArrayList
        for(int i=0;i<solicitudes.length;i++){
            cont=0;
            //Comparo y cuento si ya existe un mantenimiento que contenga el ID de la solicitud,
            //si ya existe, aumento el contador y dicha solicitud ya no se debe de mostrar
            for(int j=0;j<mantenimientos.length;j++){
                //System.out.println(mantenimientos[j].getIdsolicitud().getIdsolicitud()+"  "+solicitudes[i].getIdsolicitud());
                if (mantenimientos[j].getIdsolicitud().getIdsolicitud().equals(solicitudes[i].getIdsolicitud())){
                    cont++;
                }
            }

            if(cont==0){
                Usuario u = new BeanBaseJHardmin().getUsuario(solicitudes[i].getIdusuario().getIdusuario());
                String label = u.getNombre()+" - "+solicitudes[i].getDescripcion();
                getSoc().add(new SelectItem(solicitudes[i].getIdsolicitud(), label));
            }
        }

//        //Creo una UISelecItems
//        UISelectItems items = new UISelectItems();
//        //Le añado como valor el ArrayList
//        items.setValue(soc);
//        //Le meto las UISelectItems como hijos de la selectonelistbox
//        this.listaSol.getChildren().add(items);


        //LISTA DE MANTENIMIENTOS

        //Agarro todos los mantenimientos
        mantenimientos = new edu.ues.jhard.beans.BeanBaseJRequest().getMantenimientoByEstado("Pendiente");

        //Creo e instancio el ArrayList que contendrá el selectlistonebox
        for(int i=0;i<mantenimientos.length;i++){
            Equiposimple eq = new BeanBaseJRequest().getEquipoSimpleByID(mantenimientos[i].getIdequiposimple().getIdEquipoSimple());
            String label = eq.getDescripcion() +" - "+ mantenimientos[i].getDescripcion();
            getMan().add(new SelectItem(mantenimientos[i].getIdmantenimiento(), label));
        }

//        UISelectItems itemsMan = new UISelectItems();
//        itemsMan.setValue(man);
//        this.listaMantenimientos.getChildren().add(itemsMan);
    }


    private void limpiarListas(){
        this.soc.clear();
        this.man.clear();
    }

private List tec = new ArrayList();
private List eqs = new ArrayList();
private List eeq = new ArrayList();

    private void llenarCombo(){
        //COMBO DE TECNICOS
        Tecnico [] tecnicos = new edu.ues.jhard.beans.BeanBaseJRequest().getTecnico();
        for(int i=0;i<tecnicos.length;i++){
            String label = tecnicos[i].getNombres()+" "+tecnicos[i].getApellidos();
            getTec().add(new SelectItem(tecnicos[i].getIdtecnico(),label));
        }
//        UISelectItems itemsTec = new UISelectItems();
//        itemsTec.setValue(getTec());
//        this.comboTecnicos.getChildren().add(itemsTec);


        //SELECTINPUT DE EQUIPOS SIMPLES
        Equiposimple [] eqsimple = new edu.ues.jhard.beans.BeanBaseJRequest().getEquipoSimple();
        for(int i=0;i<eqsimple.length;i++){
            String label = eqsimple[i].getPropietario()+" "+eqsimple[i].getDescripcion();
            getEqs().add(new SelectItem(eqsimple[i].getIdEquipoSimple(),label));
        }
//        UISelectItems itemsEq = new UISelectItems();
//        itemsEq.setValue(getEqs());
//        this.txtEqSimples.getChildren().add(itemsEq);


        //COMBO DE ESTADOS DE EQUIPOS
        Estadoequipo [] estado = new edu.ues.jhard.beans.BeanBaseJRequest().getEstadoEquipo();
        for(int i=0;i<estado.length;i++){
            String label = estado[i].getNombre();
            getEeq().add(new SelectItem(estado[i].getIdestado(),label));
        }
//        UISelectItems itemsEstad = new UISelectItems();
//        itemsEstad.setValue(getEeq());
//        this.comboEstado.getChildren().add(itemsEstad);
    }
    
    private Tecnico tecnicoElegido=null;
    private Estadoequipo estadoElegido=null;
    private Solicitud solicitudElegida=null;
    private Mantenimiento mantenimientoElegido=null;
    private Bitacoraestados bitacoraElegida=null;
    private Equiposimple eqSimpleElegido=null;
    private boolean render;

    /**
     * <p>Construct a new Page bean instance.</p>
     */

    private boolean renderBitacoras;
    private boolean renderMantenimientos;

    public jrequestAdmin() {
//        fakeSol.clear();
//        fakeMan.clear();
//        fakeBit.clear();
//
//        fakeComboEstado1.clear();
//        fakeComboTecnico1.clear();
        fakeComboPrioridad.clear();
        fakeComboPrioridad.setItems(new String[]{"Alta", "Media", "Baja"});

        llenarLista();
        llenarCombo();
        
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
        this.render=false;
        this.renderBitacoras=false;
        this.renderMantenimientos=false;
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
            log("jrequestAdmin Initialization Failure", e);
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

    public void listaSol_processValueChange(ValueChangeEvent vce) {
        //Solicitud s = (Solicitud) this.listaSol.getValue();
        
        String tmp=(String)this.listaSol.getValue();
        if(tmp!=null){
        System.out.println("TODO BIEN--> "+ tmp);
        Integer id=Integer.parseInt(tmp);
        System.out.println("TODO BIEN--> "+ id);
        Solicitud s=new BeanBaseJRequest().getEntityManager().find(Solicitud.class, id);

        this.solicitudElegida=s;

        System.out.println("TODO BIEN--> "+ solicitudElegida.getIdsolicitud());

        Usuario u = new BeanBaseJHardmin().getUsuario(s.getIdusuario().getIdusuario());

        System.out.println("TODO BIEN--> "+ u.getIdusuario());

        this.lblNombre.setValue(s.getDescripcion());
        this.lblPersona.setValue(u.getNombre());

        this.comboPrioridad.setValue(s.getPrioridad());

        System.out.println(solicitudElegida.getDescripcion());

        }
    }

    public String btnProceder_action() {

        if(this.solicitudElegida==null){

            System.out.println("SOLICITUD NULL");
            this.lblMensajes.setValue("Seleccione una Solicitud de Mantenimiento");
            this.render=true;

        }
        else{
            System.out.println("ARMAMOS EL MANTENIMIENTO");

            Mantenimiento m = new Mantenimiento();

            m.setDescripcion(this.solicitudElegida.getDescripcion());

            Calendar c = Calendar.getInstance();

            m.setFecha(new Date((c.get(Calendar.YEAR))-1900, c.get(Calendar.MONTH), c.get(Calendar.DATE)));


            m.setIdtecnico(tecnicoElegido);

            m.setIdequiposimple(this.solicitudElegida.getIdequiposimple());

            m.setIdsolicitud(this.solicitudElegida);

            m.setEstado("Pendiente");

            new BeanBaseJRequest().registrarMantenimiento(m);

            this.lblMensajes.setValue("Solicitud procesada con éxito. Los técnicos se encargarán de satisfacerla");
            this.render=true;

        }
        

        return null;
    }

    public void comboTecnicos_processValueChange(ValueChangeEvent vce) {
        String tmp=(String)this.comboTecnicos.getValue();
        if (tmp!=null){
        System.out.println("TODO BIEN--> "+ tmp);
        Integer id=Integer.parseInt(tmp);
        System.out.println("TODO BIEN--> "+ id);
        Tecnico e=new BeanBaseJRequest().getEntityManager().find(Tecnico.class, id);

        this.tecnicoElegido=e;

        System.out.println("TODO BIEN--> "+ tecnicoElegido.getIdtecnico());

        System.out.println(e.getNombres());
    }
    }

    public String btnOK_action() {
        this.render=false;

        llenarLista();
        
        return null;
    }

    public void tabJrequestAdmin_processTabChange(TabChangeEvent tce) {
        limpiarListaBitacoras();
        this.renderMantenimientos=false;
        this.renderBitacoras=false;
    }

    public void listaMantenimientos_processValueChange(ValueChangeEvent vce) {
        String tmp=(String)this.listaMantenimientos.getValue();
        Integer id=Integer.parseInt(tmp);
        Mantenimiento m=new BeanBaseJRequest().getEntityManager().find(Mantenimiento.class, id);

        this.mantenimientoElegido=m;

        Equiposimple eq= new BeanBaseJRequest().getEquipoSimpleByID(this.mantenimientoElegido.getIdequiposimple().getIdEquipoSimple());

        this.lblMantenimiento.setValue("¿Finalizado el Mantenimiento de " +this.mantenimientoElegido.getDescripcion() +" al Equipo "+ eq.getDescripcion() +" ?");
        this.renderMantenimientos=true;


    }

    public String btnAceptarFinalizado_action() {

        if(this.checkFIn.isSelected()&& (!this.txtDescripcion.getValue().equals(""))){
            Bitacoraestados be = new Bitacoraestados();

            Calendar c = Calendar.getInstance();

            int year = (c.get(Calendar.YEAR))-1900;
            System.out.println(year);

            be.setFecha(new Date(year, c.get(Calendar.MONTH), c.get(Calendar.DATE)));

            String tmp=(String)this.comboEstado.getValue();
            Integer id=Integer.parseInt(tmp);
            Estadoequipo e=new BeanBaseJRequest().getEntityManager().find(Estadoequipo.class, id);
            this.estadoElegido= e;

            be.setIdestado(this.estadoElegido);

            be.setDescripcion((String)this.txtDescripcion.getValue());

            be.setIdequiposimple(this.mantenimientoElegido.getIdequiposimple());

            new BeanBaseJRequest().modificarMantenimiento(mantenimientoElegido, "Finalizado");
            
            new BeanBaseJRequest().registrarBitacoraEstados(be);


            this.renderMantenimientos=false;
            this.checkFIn.setSelected(false);
            this.txtDescripcion.setValue("");

            this.lblMensajes.setValue("Mantenimiento realizado con éxito. Se ha ingresado a la bitácora del equipo");
            this.render=true;

        }
        if(!this.checkFIn.isSelected()){
            this.lblMantenimiento.setValue("Si ha terminado ya el mantenimiento, seleccione la casilla apropiada");
        }
        if(this.txtDescripcion.getValue().equals("")){
            this.lblMantenimiento.setValue("La descripción del mantenimiento no debe quedar en blanco");
        }

        return "";
    }

    public String btnCerrar_action() {
        this.checkFIn.setSelected(false);
        this.txtDescripcion.setValue("");
        this.renderMantenimientos=false;

        return null;
    }

//    public String btnAgregarTec_action() {
//            this.popUpAgregarTec.setRendered(true);
//            System.out.println("RENDERICE");
//            this.popUpAgregarTec.setVisible(true);
//            System.out.println("PUSE VISIBLE");
//            this.popUpAgregarTec.setModal(true);
//            System.out.println("SOLO EL ES MODIFICABLE");
//
//        return null;
//    }

//    public void listaTecnicos_processValueChange(ValueChangeEvent vce) {
//
//        String tmp=(String)this.listaTecnicos.getValue();
//        Integer id=Integer.parseInt(tmp);
//        Tecnico T=new BeanBaseJRequest().getEntityManager().find(Tecnico.class, id);
//
//        this.tecElegidoLista=T;
//
//        this.lblNombreTec.setValue(T.getNombres()+" "+T.getApellidos());
//
//
//    }

//    public String btnEliminarTec_action() {
//        if(tecElegidoLista!=null){
//            new BeanBaseJRequest().eliminarTecnico(this.tecElegidoLista);
//
//            this.lblMensajes.setValue("Técnico eliminado con éxito");
//            this.popUpMensajes.setRendered(true);
//            System.out.println("RENDERICE");
//            this.popUpMensajes.setVisible(true);
//            System.out.println("PUSE VISIBLE");
//            this.popUpMensajes.setModal(true);
//            System.out.println("SOLO EL ES MODIFICABLE");
//
//
//        }
//        else{
//            System.out.println("TECNICO NULL");
//            this.lblMensajes.setValue("Seleccione un Tecnico de la Lista");
//            this.popUpMensajes.setRendered(true);
//            System.out.println("RENDERICE");
//            this.popUpMensajes.setVisible(true);
//            System.out.println("PUSE VISIBLE");
//            this.popUpMensajes.setModal(true);
//            System.out.println("SOLO EL ES MODIFICABLE");
//        }
//
//        return null;
//    }
//
//    public String btnCerrarTec_action() {
//        this.popUpAgregarTec.setRendered(false);
//        System.out.println("RENDERICE");
//        this.popUpAgregarTec.setVisible(false);
//        System.out.println("PUSE VISIBLE");
//        this.popUpAgregarTec.setModal(false);
//        System.out.println("SOLO EL ES MODIFICABLE");
//        return null;
//    }
//
//    public String btnOkTec_action() {
//
//        Tecnico t = new Tecnico();
//        t.setNombres(this.txtNomTec.getValue().toString());
//        t.setApellidos(this.txtApeTec.getValue().toString());
//        t.setCargo("Tecnico");
//
//        new BeanBaseJRequest().registrarTecnico(t);
//
//        this.popUpAgregarTec.setRendered(false);
//        System.out.println("RENDERICE");
//        this.popUpAgregarTec.setVisible(false);
//        System.out.println("PUSE VISIBLE");
//        this.popUpAgregarTec.setModal(false);
//        System.out.println("SOLO EL ES MODIFICABLE");
//
//        this.lblMensajes.setValue("Técnico agregado con éxito");
//        this.popUpMensajes.setRendered(true);
//        System.out.println("RENDERICE");
//        this.popUpMensajes.setVisible(true);
//        System.out.println("PUSE VISIBLE");
//        this.popUpMensajes.setModal(true);
//        System.out.println("SOLO EL ES MODIFICABLE");
//
//
//
//        return null;
//    }
//
//    public String btnLimpiar_action() {
//        return null;
//    }

    public void txtEqSimples_processValueChange(ValueChangeEvent vce) {

        
    }

private List bit= new ArrayList();

    private void llenarListaBitacoras(Equiposimple e){
        //LISTA DE BITACORAS
        Bitacoraestados [] bitacoras = new edu.ues.jhard.beans.BeanBaseJRequest().getBitacoraEstadosByIdEquipoSimple(e);
        for(int i=0;i<bitacoras.length;i++){
            String label = bitacoras[i].getDescripcion()  +" - "+ bitacoras[i].getFecha().toString();
            getBit().add(new SelectItem(bitacoras[i].getIdbitacora(), label));
        }
//        UISelectItems itemsBit = new UISelectItems();
//        itemsBit.setValue(bit);
//        this.listaBitacoras.getChildren().add(itemsBit);
    }

    private void limpiarListaBitacoras(){
        this.bit.clear();
    }

    public String txtEqSimples_action() {

        limpiarListaBitacoras();
        System.out.println("AGARRO EL VALUE DEL TXTEQSIMPLE");
        System.out.println(this.txtEqSimples.getSelectedItem().getValue());
        Integer id= (Integer) this.txtEqSimples.getSelectedItem().getValue();
        System.out.println("LO CONVIERTO A INTEGER");
        System.out.println(id);
        System.out.println("HAGO LA INSTANCIA DEL EQUIPO");
        Equiposimple e=new BeanBaseJRequest().getEntityManager().find(Equiposimple.class, id);
        eqSimpleElegido=e;
        llenarListaBitacoras(e);
        return null;
    }

    public void listaBitacoras_processValueChange(ValueChangeEvent vce) {

        String tmp=(String)this.listaBitacoras.getValue();
        if(tmp!=null){
        Integer id=Integer.parseInt(tmp);
        Bitacoraestados be=new BeanBaseJRequest().getEntityManager().find(Bitacoraestados.class, id);

        this.bitacoraElegida=be;
        
        this.txtModBitacora.setValue(this.bitacoraElegida.getDescripcion());

        this.renderBitacoras=true;


        }
    }

    public String btnCancelarModBitacora_action() {
        this.renderBitacoras=false;
        this.txtModBitacora.setValue("");
        return null;
    }

    public String btnAceptarModBitacora_action() {
        this.bitacoraElegida.setDescripcion((String)this.txtModBitacora.getValue());
        System.out.println(bitacoraElegida.getDescripcion());
        
        new BeanBaseJRequest().modificarBitacoraEstados(bitacoraElegida);

        this.renderBitacoras=false;
        this.txtModBitacora.setValue("");

        this.lblMensajes.setValue("Bitácora modificada con éxito");
        this.render=true;
        limpiarListaBitacoras();

        llenarListaBitacoras(eqSimpleElegido);

        return "";
    }

    public String btnSolicitudAdmin_action() {

        return "case2";
    }

    public String btnEliminarSolicitud_action() {
        if(this.solicitudElegida==null){

            System.out.println("SOLICITUD NULL");
            this.lblMensajes.setValue("Seleccione una Solicitud de Mantenimiento");
            this.render=true;
            System.out.println("SOLO EL ES MODIFICABLE");

        }
        else{
            new BeanBaseJRequest().eliminarSolicitud(solicitudElegida);

            this.lblMensajes.setValue("Solicitud Eliminada con éxito");
            this.render=true;
            System.out.println("SOLO EL ES MODIFICABLE");
            llenarLista();
        }
        return null;
    }

    /**
     * @return the render
     */
    public boolean isRender() {
        return render;
    }

    /**
     * @param render the render to set
     */
    public void setRender(boolean render) {
        this.render = render;
    }

    /**
     * @return the renderBitacoras
     */
    public boolean isRenderBitacoras() {
        return renderBitacoras;
    }

    /**
     * @param renderBitacoras the renderBitacoras to set
     */
    public void setRenderBitacoras(boolean renderBitacoras) {
        this.renderBitacoras = renderBitacoras;
    }

    /**
     * @return the renderMantenimientos
     */
    public boolean isRenderMantenimientos() {
        return renderMantenimientos;
    }

    /**
     * @param renderMantenimientos the renderMantenimientos to set
     */
    public void setRenderMantenimientos(boolean renderMantenimientos) {
        this.renderMantenimientos = renderMantenimientos;
    }

    /**
     * @return the tec
     */
    public List getTec() {
        return tec;
    }

    /**
     * @return the eqs
     */
    public List getEqs() {
        return eqs;
    }

    /**
     * @return the eeq
     */
    public List getEeq() {
        return eeq;
    }

    /**
     * @return the soc
     */
    public List getSoc() {
        return soc;
    }

    /**
     * @return the man
     */
    public List getMan() {
        return man;
    }

    /**
     * @return the bit
     */
    public List getBit() {
        return bit;
    }

//    public void comboEstado_processValueChange(ValueChangeEvent vce) {
//    }
//
//
//    public void listaEqSimple_processValueChange(ValueChangeEvent vce) {
//        String tmp=(String)this.listaEqS.getValue();
//        if(tmp!=null){
//        Integer id=Integer.parseInt(tmp);
//        Equiposimple e=new BeanBaseJRequest().getEntityManager().find(Equiposimple.class, id);
//
//        this.eqSimpleElegidoAdmin=e;
//
//        System.out.println("ENTRA O Q PUTAS-->"+eqSimpleElegidoAdmin.getDescripcion());
//
//        }
//    }

//    private int opcionElegida=0;
//    private Estadoequipo estadoElegidoEQ;
//    private Equiposimple eqSimpleElegidoAdmin;
//
//
//    public String btnAceptarEQ_action() {
//        if (opcionElegida==1){
//            Equiposimple eq = new Equiposimple();
//
//            eq.setDescripcion((String)this.txtNomEQ.getValue());
//
//            eq.setPropietario((String)this.txtPropietarioEQ.getValue());
//
//            String tmp=(String)this.comboEstadosEQ.getValue();
//            if(tmp!=null){
//
//                Integer id=Integer.parseInt(tmp);
//                Estadoequipo e=new BeanBaseJRequest().getEntityManager().find(Estadoequipo.class, id);
//                this.estadoElegidoEQ= e;
//
//                eq.setIdestado(estadoElegidoEQ);
//
//                new BeanBaseJRequest().registrarEquipoSimple(eq);
//
//                this.popUpEqSimple.setRendered(false);
//                System.out.println("RENDERICE");
//                this.popUpEqSimple.setVisible(false);
//                System.out.println("PUSE VISIBLE");
//                this.popUpEqSimple.setModal(false);
//                System.out.println("SOLO EL ES MODIFICABLE");
//
//
//                this.lblMensajes.setValue("Equipo Simple Agregado con éxito");
//                this.popUpMensajes.setRendered(true);
//                System.out.println("RENDERICE");
//                this.popUpMensajes.setVisible(true);
//                System.out.println("PUSE VISIBLE");
//                this.popUpMensajes.setModal(true);
//                System.out.println("SOLO EL ES MODIFICABLE");
//
//         }
//        }
//        if(opcionElegida==2){
//
//
//
//
//                new BeanBaseJRequest().modificarEquipoSImple(eqSimpleElegidoAdmin);
//
//                this.popUpEqSimple.setRendered(false);
//                System.out.println("RENDERICE");
//                this.popUpEqSimple.setVisible(false);
//                System.out.println("PUSE VISIBLE");
//                this.popUpEqSimple.setModal(false);
//                System.out.println("SOLO EL ES MODIFICABLE");
//
//
//                this.lblMensajes.setValue("Equipo Simple Modificado con éxito");
//                this.popUpMensajes.setRendered(true);
//                System.out.println("RENDERICE");
//                this.popUpMensajes.setVisible(true);
//                System.out.println("PUSE VISIBLE");
//                this.popUpMensajes.setModal(true);
//                System.out.println("SOLO EL ES MODIFICABLE");
//
//
//        }
//
//        this.txtNomEQ.setValue("");
//        this.txtPropietarioEQ.setValue("");
//        this.llenarLista();
//        this.opcionElegida=0;
////        this.eqSimpleElegidoAdmin=null;
////        this.estadoElegidoEQ=null;
//        return null;
//    }
//
//    public String btnCancelarEQ_action() {
//        this.popUpEqSimple.setRendered(false);
//        System.out.println("RENDERICE");
//        this.popUpEqSimple.setVisible(false);
//        System.out.println("PUSE VISIBLE");
//        this.popUpEqSimple.setModal(false);
//        System.out.println("SOLO EL ES MODIFICABLE");
//        return null;
//    }
//
//
//
//    public void listaEqS_processValueChange(ValueChangeEvent vce) {
//        String tmp=(String)this.listaEqS.getValue();
//        System.out.println("tmp-->"+tmp);
//        if(tmp!=null){
//            Integer id=Integer.parseInt(tmp);
//            System.out.println("id-->"+id);
//            Equiposimple e=new BeanBaseJRequest().getEntityManager().find(Equiposimple.class, id);
//
//            this.eqSimpleElegidoAdmin=e;
//
//            System.out.println("eqSimpleElegidoAdmin-->"+eqSimpleElegidoAdmin.getDescripcion());
//
//        }
//    }
//
//    public String btnEliminarEqS_action() {
//        System.out.println("ENTRA A BORRAR");
//        if(eqSimpleElegidoAdmin!=null){
//            this.opcionElegida=3;
//            System.out.println("SE METE A ELIMINAR...");
//            new BeanBaseJRequest().eliminarEquipoSimple(eqSimpleElegidoAdmin);
//
//            this.lblMensajes.setValue("Equipo Simple eliminado con éxito");
//            this.popUpMensajes.setRendered(true);
//            System.out.println("RENDERICE");
//            this.popUpMensajes.setVisible(true);
//            System.out.println("PUSE VISIBLE");
//            this.popUpMensajes.setModal(true);
//            System.out.println("SOLO EL ES MODIFICABLE");
//
//
//        }
//        else{
//            this.lblMensajes.setValue("Seleccione primero un Equipo Simple");
//            this.popUpMensajes.setRendered(true);
//            System.out.println("RENDERICE");
//            this.popUpMensajes.setVisible(true);
//            System.out.println("PUSE VISIBLE");
//            this.popUpMensajes.setModal(true);
//            System.out.println("SOLO EL ES MODIFICABLE");
//
//        }
//        return null;
//    }
//
//    public String btnModEqS_action() {
//        if(eqSimpleElegidoAdmin!=null){
//
//            this.txtNomEQ.setValue(this.eqSimpleElegidoAdmin.getDescripcion());
//            this.txtPropietarioEQ.setValue(this.eqSimpleElegidoAdmin.getPropietario());
//
//            this.opcionElegida=2;
//            System.out.println("SE METE A MODIFICAR");
//            this.popUpEqSimple.setRendered(true);
//            System.out.println("RENDERICE");
//            this.popUpEqSimple.setVisible(true);
//            System.out.println("PUSE VISIBLE");
//            this.popUpEqSimple.setModal(true);
//            System.out.println("SOLO EL ES MODIFICABLE");
//
//        }
//        else{
//            this.lblMensajes.setValue("Seleccione primero un Equipo Simple");
//            this.popUpMensajes.setRendered(true);
//            System.out.println("RENDERICE");
//            this.popUpMensajes.setVisible(true);
//            System.out.println("PUSE VISIBLE");
//            this.popUpMensajes.setModal(true);
//            System.out.println("SOLO EL ES MODIFICABLE");
//
//        }
//        return null;
//    }
//
//    public String btnAgregarEqS_action() {
//        this.opcionElegida=1;
//
//        this.popUpEqSimple.setRendered(true);
//        System.out.println("RENDERICE");
//        this.popUpEqSimple.setVisible(true);
//        System.out.println("PUSE VISIBLE");
//        this.popUpEqSimple.setModal(true);
//        System.out.println("SOLO EL ES MODIFICABLE");
//
//        return null;
//    }


    
}

