/*
 * JRequestAdministracion.java
 *
 * Created on 01-jul-2009, 23:39:22
 * Copyright Hugol
 */
package jhard;

import com.icesoft.faces.component.ext.HtmlCommandButton;
import com.icesoft.faces.component.ext.HtmlInputText;
import com.icesoft.faces.component.ext.HtmlOutputLabel;
import com.icesoft.faces.component.ext.HtmlOutputText;
import com.icesoft.faces.component.ext.HtmlSelectOneListbox;
import com.icesoft.faces.component.ext.HtmlSelectOneMenu;
import com.icesoft.faces.component.jsfcl.data.DefaultSelectionItems;
import com.icesoft.faces.component.jsfcl.data.PopupBean;
import com.icesoft.faces.component.panelpopup.PanelPopup;
import com.sun.rave.web.ui.appbase.AbstractPageBean;
import edu.ues.jhard.beans.BeanBaseJRequest;
import edu.ues.jhard.jpa.Equiposimple;
import edu.ues.jhard.jpa.Estadoequipo;
import edu.ues.jhard.jpa.Tecnico;
import java.util.ArrayList;
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
public class JRequestAdministracion extends AbstractPageBean {
    // <editor-fold defaultstate="collapsed" desc="Managed Component Definition">
    private int __placeholder;

    /**
     * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    private void _init() throws Exception {
        fakeTec.setItems(new String[]{});
        fakeEqs.setItems(new String[]{});
        fakeEstadoEQ.setItems(new String[]{});
    }
    private DefaultSelectionItems fakeTec = new DefaultSelectionItems();

    public DefaultSelectionItems getFakeTec() {
        return fakeTec;
    }

    public void setFakeTec(DefaultSelectionItems dsi) {
        this.fakeTec = dsi;
    }
    private HtmlSelectOneListbox listaTecnicos = new HtmlSelectOneListbox();

    public HtmlSelectOneListbox getListaTecnicos() {
        return listaTecnicos;
    }

    public void setListaTecnicos(HtmlSelectOneListbox hsol) {
        this.listaTecnicos = hsol;
    }
    private DefaultSelectionItems fakeEqs = new DefaultSelectionItems();

    public DefaultSelectionItems getFakeEqs() {
        return fakeEqs;
    }

    public void setFakeEqs(DefaultSelectionItems dsi) {
        this.fakeEqs = dsi;
    }
    private HtmlSelectOneListbox listaEqS = new HtmlSelectOneListbox();

    public HtmlSelectOneListbox getListaEqS() {
        return listaEqS;
    }

    public void setListaEqS(HtmlSelectOneListbox hsol) {
        this.listaEqS = hsol;
    }
    private DefaultSelectionItems fakeEstadoEQ = new DefaultSelectionItems();

    public DefaultSelectionItems getFakeEstadoEQ() {
        return fakeEstadoEQ;
    }

    public void setFakeEstadoEQ(DefaultSelectionItems dsi) {
        this.fakeEstadoEQ = dsi;
    }
    private HtmlSelectOneMenu comboEstadosEQ = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getComboEstadosEQ() {
        return comboEstadosEQ;
    }

    public void setComboEstadosEQ(HtmlSelectOneMenu hsom) {
        this.comboEstadosEQ = hsom;
    }
    private HtmlOutputLabel lblNombreTec = new HtmlOutputLabel();

    public HtmlOutputLabel getLblNombreTec() {
        return lblNombreTec;
    }

    public void setLblNombreTec(HtmlOutputLabel hol) {
        this.lblNombreTec = hol;
    }
    private PanelPopup popUpEqSimple = new PanelPopup();

    public PanelPopup getPopUpEqSimple() {
        return popUpEqSimple;
    }

    public void setPopUpEqSimple(PanelPopup pp) {
        this.popUpEqSimple = pp;
    }
    private HtmlInputText txtNomTec = new HtmlInputText();

    public HtmlInputText getTxtNomTec() {
        return txtNomTec;
    }

    public void setTxtNomTec(HtmlInputText hit) {
        this.txtNomTec = hit;
    }
    private HtmlInputText txtApeTec = new HtmlInputText();

    public HtmlInputText getTxtApeTec() {
        return txtApeTec;
    }

    public void setTxtApeTec(HtmlInputText hit) {
        this.txtApeTec = hit;
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
    private HtmlInputText txtNomEQ = new HtmlInputText();

    public HtmlInputText getTxtNomEQ() {
        return txtNomEQ;
    }

    public void setTxtNomEQ(HtmlInputText hit) {
        this.txtNomEQ = hit;
    }
    private HtmlInputText txtPropietarioEQ = new HtmlInputText();

    public HtmlInputText getTxtPropietarioEQ() {
        return txtPropietarioEQ;
    }

    public void setTxtPropietarioEQ(HtmlInputText hit) {
        this.txtPropietarioEQ = hit;
    }
    private PopupBean panelPopup1Bean = new PopupBean();

    public PopupBean getPanelPopup1Bean() {
        return panelPopup1Bean;
    }

    public void setPanelPopup1Bean(PopupBean pb) {
        this.panelPopup1Bean = pb;
    }
    private HtmlCommandButton btnOk = new HtmlCommandButton();

    public HtmlCommandButton getBtnOk() {
        return btnOk;
    }

    public void setBtnOk(HtmlCommandButton hcb) {
        this.btnOk = hcb;
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
    private HtmlCommandButton btnAceptarEQ = new HtmlCommandButton();

    public HtmlCommandButton getBtnAceptarEQ() {
        return btnAceptarEQ;
    }

    public void setBtnAceptarEQ(HtmlCommandButton hcb) {
        this.btnAceptarEQ = hcb;
    }
    private HtmlCommandButton btnCancelarEQ = new HtmlCommandButton();

    public HtmlCommandButton getBtnCancelarEQ() {
        return btnCancelarEQ;
    }

    public void setBtnCancelarEQ(HtmlCommandButton hcb) {
        this.btnCancelarEQ = hcb;
    }

    // </editor-fold>

    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public JRequestAdministracion() {
        llenarListasCombos();
        this.popUpEqSimple.setRendered(false);
        this.popUpAgregarTec.setRendered(false);
        this.popUpMensajes.setRendered(false);


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
            log("jrequestAdminitracion Initialization Failure", e);
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
    protected ApplicationBean1 getApplicationBean1() {
        return (ApplicationBean1) getBean("ApplicationBean1");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected SessionBean1 getSessionBean1() {
        return (SessionBean1) getBean("SessionBean1");
    }

   private int opcionElegida=0;
   private Tecnico TecnicoElegido;
   private Equiposimple EquipoElegido;
   private Estadoequipo estadoElegido;

   private void llenarListasCombos(){
        //Llenar lista de Tecnicos para su Administracion

        Tecnico [] tecnicos = new edu.ues.jhard.beans.BeanBaseJRequest().getTecnico();

        TecnicoElegido = tecnicos[0];

        ArrayList tec = new ArrayList();

        for(int i=0;i<tecnicos.length;i++){

            String label = tecnicos[i].getNombres()+" "+tecnicos[i].getApellidos();
            tec.add(new SelectItem(tecnicos[i].getIdtecnico(),label));
        }

        UISelectItems itemsTec = new UISelectItems();
        itemsTec.setValue(tec);
        this.listaTecnicos.getChildren().add(itemsTec);


        //Llenar lista de Equipos simples para su Administracion


        Equiposimple [] eqs = new edu.ues.jhard.beans.BeanBaseJRequest().getEquipoSimple();

        EquipoElegido = eqs[0];

        ArrayList equipoSimple = new ArrayList();

        for(int i=0;i<eqs.length;i++){

            String label = eqs[i].getDescripcion();
            equipoSimple.add(new SelectItem(eqs[i].getIdEquipoSimple(),label));
        }

        UISelectItems itemsEQ = new UISelectItems();
        itemsEQ.setValue(equipoSimple);
        this.listaEqS.getChildren().add(itemsEQ);


        //Llenar Combo de Estados de equipos para la Administracion

        Estadoequipo [] estados = new edu.ues.jhard.beans.BeanBaseJRequest().getEstadoEquipo();

        estadoElegido = estados[0];

        ArrayList eeq = new ArrayList();

        for(int i=0;i<estados.length;i++){

            String label = estados[i].getDescripcion();
            eeq.add(new SelectItem(estados[i].getIdestado(),label));
        }

        UISelectItems itemsEeq = new UISelectItems();
        itemsEeq.setValue(eeq);
        this.comboEstadosEQ.getChildren().add(itemsEeq);


    }
    private String efecto="";

    public void listaTecnicos_processValueChange(ValueChangeEvent vce) {
        String tmp=(String)this.listaTecnicos.getValue();
        if(tmp!=null){
        Integer id=Integer.parseInt(tmp);
        Tecnico T=new BeanBaseJRequest().getEntityManager().find(Tecnico.class, id);

        this.TecnicoElegido=T;

        this.lblNombreTec.setValue(T.getNombres()+" "+T.getApellidos());

        setEfecto("highlight");
        System.out.println(getEfecto());
        System.out.println("eqSimpleElegidoAdmin-->"+TecnicoElegido.getNombres());
        }
    }


    public void listaEqS_processValueChange(ValueChangeEvent vce) {
        String tmp=(String)this.listaEqS.getValue();
        if(tmp!=null){
            Integer id=Integer.parseInt(tmp);
            System.out.println("id-->"+id);
            Equiposimple e=new BeanBaseJRequest().getEntityManager().find(Equiposimple.class, id);

            this.EquipoElegido=e;

            System.out.println("eqSimpleElegidoAdmin-->"+EquipoElegido.getDescripcion());
        }
    }

    public String btnAgregarTec_action() {
        this.popUpAgregarTec.setRendered(true);
        System.out.println("RENDERICE");
        this.popUpAgregarTec.setVisible(true);
        System.out.println("PUSE VISIBLE");
        this.popUpAgregarTec.setModal(true);
        System.out.println("SOLO EL ES MODIFICABLE");
        return null;
    }

    public String btnEliminarTec_action() {
        if(TecnicoElegido!=null){
            new BeanBaseJRequest().eliminarTecnico(this.TecnicoElegido);

            System.out.println("Técnico eliminado con éxito");
            this.lblMensajes.setValue("Técnico eliminado con éxito");
            this.popUpMensajes.setRendered(true);
            System.out.println("RENDERICE");
            this.popUpMensajes.setVisible(true);
            System.out.println("PUSE VISIBLE");
            this.popUpMensajes.setModal(true);
            System.out.println("SOLO EL ES MODIFICABLE");

            limpiarListasCombos();
            llenarListasCombos();
        }
        else{
            System.out.println("Seleccione un técnico");
            this.lblMensajes.setValue("Seleccione un Tecnico de la Lista");
            this.popUpMensajes.setRendered(true);
            System.out.println("RENDERICE");
            this.popUpMensajes.setVisible(true);
            System.out.println("PUSE VISIBLE");
            this.popUpMensajes.setModal(true);
            System.out.println("SOLO EL ES MODIFICABLE");
        }

        return null;
    }

    public String btnOkTec_action() {
        Tecnico t = new Tecnico();
        t.setNombres(this.txtNomTec.getValue().toString());
        t.setApellidos(this.txtApeTec.getValue().toString());
        t.setCargo("Tecnico");

        new BeanBaseJRequest().registrarTecnico(t);

        this.popUpAgregarTec.setRendered(false);
        System.out.println("RENDERICE");
        this.popUpAgregarTec.setVisible(false);
        System.out.println("PUSE VISIBLE");
        this.popUpAgregarTec.setModal(false);
        System.out.println("SOLO EL ES MODIFICABLE");

        System.out.println("Técnico agregado con éxito");
        this.lblMensajes.setValue("Técnico agregado con éxito");
        this.popUpMensajes.setRendered(true);
        System.out.println("RENDERICE");
        this.popUpMensajes.setVisible(true);
        System.out.println("PUSE VISIBLE");
        this.popUpMensajes.setModal(true);
        System.out.println("SOLO EL ES MODIFICABLE");

        limpiarListasCombos();
        llenarListasCombos();
        return null;
    }

    public String btnCerrarTec_action() {
        this.popUpAgregarTec.setRendered(false);
        System.out.println("RENDERICE");
        this.popUpAgregarTec.setVisible(false);
        System.out.println("PUSE VISIBLE");
        this.popUpAgregarTec.setModal(false);
        System.out.println("SOLO EL ES MODIFICABLE");
        return null;
    }

    public String btnAceptarEQ_action() {
        if (opcionElegida==1){
            Equiposimple eq = new Equiposimple();

            eq.setDescripcion((String)this.txtNomEQ.getValue());

            eq.setPropietario((String)this.txtPropietarioEQ.getValue());

            String tmp=(String)this.comboEstadosEQ.getValue();
            if(tmp!=null){

                Integer id=Integer.parseInt(tmp);
                Estadoequipo e=new BeanBaseJRequest().getEntityManager().find(Estadoequipo.class, id);
                this.estadoElegido= e;

                eq.setIdestado(estadoElegido);

                new BeanBaseJRequest().registrarEquipoSimple(eq);

                this.popUpEqSimple.setRendered(false);
                System.out.println("RENDERICE");
                this.popUpEqSimple.setVisible(false);
                System.out.println("PUSE VISIBLE");
                this.popUpEqSimple.setModal(false);
                System.out.println("SOLO EL ES MODIFICABLE");

                System.out.println("Equipo Simple Agregado con éxito");
                this.lblMensajes.setValue("Equipo Simple Agregado con éxito");
                this.popUpMensajes.setRendered(true);
                System.out.println("RENDERICE");
                this.popUpMensajes.setVisible(true);
                System.out.println("PUSE VISIBLE");
                this.popUpMensajes.setModal(true);
                System.out.println("SOLO EL ES MODIFICABLE");

         }
        }
        if(opcionElegida==2){
                this.EquipoElegido.setDescripcion((String)this.txtNomEQ.getValue());
                this.EquipoElegido.setPropietario((String)this.txtPropietarioEQ.getValue());

                String tmp=(String)this.comboEstadosEQ.getValue();
                if(tmp!=null){

                    Integer id=Integer.parseInt(tmp);
                    Estadoequipo e=new BeanBaseJRequest().getEntityManager().find(Estadoequipo.class, id);
                    this.estadoElegido= e;

                    EquipoElegido.setIdestado(estadoElegido);

                    new BeanBaseJRequest().modificarEquipoSImple(EquipoElegido);

                    this.popUpEqSimple.setRendered(false);
                    System.out.println("RENDERICE");
                    this.popUpEqSimple.setVisible(false);
                    System.out.println("PUSE VISIBLE");
                    this.popUpEqSimple.setModal(false);
                    System.out.println("SOLO EL ES MODIFICABLE");

                    System.out.println("Equipo Simple modificado con éxito");
                  this.lblMensajes.setValue("Equipo Simple Modificado con éxito");
                  this.popUpMensajes.setRendered(true);
                  System.out.println("RENDERICE");
                  this.popUpMensajes.setVisible(true);
                  System.out.println("PUSE VISIBLE");
                  this.popUpMensajes.setModal(true);
                  System.out.println("SOLO EL ES MODIFICABLE");

                }
        }

        this.txtNomEQ.setValue("");
        this.txtPropietarioEQ.setValue("");
        limpiarListasCombos();
        this.llenarListasCombos();
        this.opcionElegida=0;
        return null;
    }

    public String btnCancelarEQ_action() {
        this.popUpEqSimple.setRendered(false);
        System.out.println("RENDERICE");
        this.popUpEqSimple.setVisible(false);
        System.out.println("PUSE VISIBLE");
        this.popUpEqSimple.setModal(false);
        System.out.println("SOLO EL ES MODIFICABLE");
        return null;
    }

    public String btnAgregarEqS_action() {
        this.opcionElegida=1;

        this.popUpEqSimple.setRendered(true);
        System.out.println("RENDERICE");
        this.popUpEqSimple.setVisible(true);
        System.out.println("PUSE VISIBLE");
        this.popUpEqSimple.setModal(true);
        System.out.println("SOLO EL ES MODIFICABLE");
        return null;
    }

    public String btnModEqS_action() {
        if(EquipoElegido!=null){

            this.txtNomEQ.setValue(this.EquipoElegido.getDescripcion());
            this.txtPropietarioEQ.setValue(this.EquipoElegido.getPropietario());

            this.opcionElegida=2;
            System.out.println("SE METE A MODIFICAR");
            this.popUpEqSimple.setRendered(true);
            System.out.println("RENDERICE");
            this.popUpEqSimple.setVisible(true);
            System.out.println("PUSE VISIBLE");
            this.popUpEqSimple.setModal(true);
            System.out.println("SOLO EL ES MODIFICABLE");

        }
        else{
            System.out.println("Seleccione primero un Equipo Simple");
            this.lblMensajes.setValue("Seleccione primero un Equipo Simple");
            this.popUpMensajes.setRendered(true);
            System.out.println("RENDERICE");
            this.popUpMensajes.setVisible(true);
            System.out.println("PUSE VISIBLE");
            this.popUpMensajes.setModal(true);
            System.out.println("SOLO EL ES MODIFICABLE");

        }
        return null;
    }

    public String btnEliminarEqS_action() {
        if(EquipoElegido!=null){
            new BeanBaseJRequest().eliminarEquipoSimple(EquipoElegido);
            System.out.println("Equipo Simple eliminado con éxito");
            this.lblMensajes.setValue("Equipo Simple eliminado con éxito");
            this.popUpMensajes.setRendered(true);
            System.out.println("RENDERICE");
            this.popUpMensajes.setVisible(true);
            System.out.println("PUSE VISIBLE");
            this.popUpMensajes.setModal(true);
            System.out.println("SOLO EL ES MODIFICABLE");


        }
        else{
            System.out.println("Seleccione primero un Equipo Simple");
            this.lblMensajes.setValue("Seleccione primero un Equipo Simple");
            this.popUpMensajes.setRendered(true);
            System.out.println("RENDERICE");
            this.popUpMensajes.setVisible(true);
            System.out.println("PUSE VISIBLE");
            this.popUpMensajes.setModal(true);
            System.out.println("SOLO EL ES MODIFICABLE");

        }
        this.opcionElegida=0;
        this.EquipoElegido=null;
        limpiarListasCombos();
        llenarListasCombos();
        return null;
    }

    private void limpiarListasCombos(){
        this.listaTecnicos.getChildren().clear();
        this.listaEqS.getChildren().clear();
        this.comboEstadosEQ.getChildren().clear();
        this.lblNombreTec.setValue("");
    }

    public String btnOk_action() {
        this.popUpMensajes.setVisible(false);
        this.popUpMensajes.setRendered(false);
        this.popUpMensajes.setModal(false);


        return null;
    }

    /**
     * @return the efecto
     */
    public String getEfecto() {
        return efecto;
    }

    /**
     * @param efecto the efecto to set
     */
    public void setEfecto(String efecto) {
        this.efecto = efecto;
    }

}

