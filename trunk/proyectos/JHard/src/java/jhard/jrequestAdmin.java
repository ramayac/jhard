/*
 * jrequestAdmin.java
 *
 * Created on 18-jun-2009, 14:18:50
 * Copyright Hugol
 */
package jhard;

import com.icesoft.faces.component.ext.HtmlCommandButton;
import com.icesoft.faces.component.ext.HtmlOutputLabel;
import com.icesoft.faces.component.ext.HtmlOutputText;
import com.icesoft.faces.component.ext.HtmlSelectOneListbox;
import com.icesoft.faces.component.ext.HtmlSelectOneMenu;
import com.icesoft.faces.component.jsfcl.data.DefaultSelectedData;
import com.icesoft.faces.component.jsfcl.data.DefaultSelectionItems;
import com.icesoft.faces.component.jsfcl.data.PopupBean;
import com.icesoft.faces.component.panelpopup.PanelPopup;
import com.sun.data.provider.impl.ObjectArrayDataProvider;
import com.sun.data.provider.impl.ObjectListDataProvider;
import com.sun.rave.faces.data.DefaultSelectItemsArray;
import com.sun.rave.web.ui.appbase.AbstractPageBean;
import edu.ues.jhard.beans.BeanBaseJHardmin;
import edu.ues.jhard.beans.BeanBaseJRequest;
import edu.ues.jhard.jpa.Mantenimiento;
import edu.ues.jhard.jpa.Solicitud;
import edu.ues.jhard.jpa.Tecnico;
import edu.ues.jhard.jpa.Usuario;
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
        arrayTecnicos.setArray((java.lang.Object[]) getValue("#{jrequestAdmin.tecnicos}"));
        selectOneListbox1DefaultItems.setItems(new String[]{});
        selectOneMenu1DefaultItems1.setItems(new String[]{"Alta", "Media", "Baja"});
        selectOneMenu2DefaultItems.setItems(new String[]{"Media", "Baja"});
        selectOneMenu1DefaultItems.setItems(new String[]{"Alta", "Media", "Baja"});

        

    }

    // </editor-fold>




    public void llenarLista(){
        solicitudes = new edu.ues.jhard.beans.BeanBaseJRequest().getSolicitudesByPrioridad("Alta");

        for(int i=0;i<solicitudes.length;i++){
            Usuario u = new BeanBaseJHardmin().getUsuario(solicitudes[i].getIdusuario().getIdusuario());
            String label = u.getNombre()+"  "+solicitudes[i].getDescripcion();
            soc.add(new SelectItem(solicitudes[i].getIdsolicitud(), label));
        }

        solicitudes = new edu.ues.jhard.beans.BeanBaseJRequest().getSolicitudesByPrioridad("Media");

        for(int i=0;i<solicitudes.length;i++){
            Usuario u = new BeanBaseJHardmin().getUsuario(solicitudes[i].getIdusuario().getIdusuario());
            String label = u.getNombre()+"  "+solicitudes[i].getDescripcion();
            soc.add(new SelectItem(solicitudes[i].getIdsolicitud(), label));
        }
        solicitudes = new edu.ues.jhard.beans.BeanBaseJRequest().getSolicitudesByPrioridad("Baja");

        for(int i=0;i<solicitudes.length;i++){
            Usuario u = new BeanBaseJHardmin().getUsuario(solicitudes[i].getIdusuario().getIdusuario());
            String label = u.getNombre()+"  "+solicitudes[i].getDescripcion();
            soc.add(new SelectItem(solicitudes[i].getIdsolicitud(), label));
        }


        items = new UISelectItems();
        items.setValue(soc);
        this.listaSol.getChildren().clear();
        this.listaSol.getChildren().add(items);

        
    }


    private boolean verControlx=false;
    /**
     * @return the verControlx
     */
    public boolean isVerControlx() {
        return verControlx;
    }
    /**
     * @param verControlx the verControlx to set
     */
    public void setVerControlx(boolean verControlx) {
        this.verControlx = verControlx;
    }


    private Solicitud[] solicitudes;
    private Solicitud solicitudElegida=null;
    private Tecnico[] tecnicos = new edu.ues.jhard.beans.BeanBaseJRequest().getTecnico();
    private Tecnico tecnicoElegido=tecnicos[0];

    private ArrayList soc=new ArrayList();
    private UISelectItems items;

    public ArrayList getSolicitudes() {
        return soc;
    }

    public void setSolicitudes(ArrayList s) {
        this.soc = s;
    }

    public Tecnico getTecnicoElegido(){
        return tecnicoElegido;
    }

    public void setTecnicoElegido(Tecnico tec){
        this.tecnicoElegido=tec;
    }

    public Tecnico[] getTecnicos(){
        return tecnicos;
    }

    public void setTecnicos(Tecnico[] tec){
        this.tecnicos=tec;
    }



    private DefaultSelectedData selectOneRadio1DataBean = new DefaultSelectedData();

    public DefaultSelectedData getSelectOneRadio1DataBean() {
        return selectOneRadio1DataBean;
    }

    public void setSelectOneRadio1DataBean(DefaultSelectedData dsd) {
        this.selectOneRadio1DataBean = dsd;
    }
    private DefaultSelectItemsArray selectOneRadio1DefaultItems1 = new DefaultSelectItemsArray();

    public DefaultSelectItemsArray getSelectOneRadio1DefaultItems1() {
        return selectOneRadio1DefaultItems1;
    }

    public void setSelectOneRadio1DefaultItems1(DefaultSelectItemsArray dsia) {
        this.selectOneRadio1DefaultItems1 = dsia;
    }
    private DefaultSelectedData selectOneMenu1DataBean = new DefaultSelectedData();

    public DefaultSelectedData getSelectOneMenu1DataBean() {
        return selectOneMenu1DataBean;
    }

    public void setSelectOneMenu1DataBean(DefaultSelectedData dsd) {
        this.selectOneMenu1DataBean = dsd;
    }
    private DefaultSelectItemsArray selectOneMenu1DefaultItems1 = new DefaultSelectItemsArray();

    public DefaultSelectItemsArray getSelectOneMenu1DefaultItems1() {
        return selectOneMenu1DefaultItems1;
    }

    public void setSelectOneMenu1DefaultItems1(DefaultSelectItemsArray dsia) {
        this.selectOneMenu1DefaultItems1 = dsia;
    }
    private DefaultSelectedData selectOneListbox1Bean = new DefaultSelectedData();

    public DefaultSelectedData getSelectOneListbox1Bean() {
        return selectOneListbox1Bean;
    }

    public void setSelectOneListbox1Bean(DefaultSelectedData dsd) {
        this.selectOneListbox1Bean = dsd;
    }
    private DefaultSelectedData selectOneMenu2Bean = new DefaultSelectedData();

    public DefaultSelectedData getSelectOneMenu2Bean() {
        return selectOneMenu2Bean;
    }

    public void setSelectOneMenu2Bean(DefaultSelectedData dsd) {
        this.selectOneMenu2Bean = dsd;
    }
    private DefaultSelectionItems selectOneMenu2DefaultItems = new DefaultSelectionItems();

    public DefaultSelectionItems getSelectOneMenu2DefaultItems() {
        return selectOneMenu2DefaultItems;
    }

    public void setSelectOneMenu2DefaultItems(DefaultSelectionItems dsi) {
        this.selectOneMenu2DefaultItems = dsi;
    }
    private DefaultSelectedData defaultSelectedData5 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData5() {
        return defaultSelectedData5;
    }

    public void setDefaultSelectedData5(DefaultSelectedData dsd) {
        this.defaultSelectedData5 = dsd;
    }
    private DefaultSelectionItems selectOneListbox1DefaultItems1 = new DefaultSelectionItems();

    public DefaultSelectionItems getSelectOneListbox1DefaultItems1() {
        return selectOneListbox1DefaultItems1;
    }

    public void setSelectOneListbox1DefaultItems1(DefaultSelectionItems dsi) {
        this.selectOneListbox1DefaultItems1 = dsi;
    }
    private DefaultSelectItemsArray selectOneListbox1DefaultItems2 = new DefaultSelectItemsArray();

    public DefaultSelectItemsArray getSelectOneListbox1DefaultItems2() {
        return selectOneListbox1DefaultItems2;
    }

    public void setSelectOneListbox1DefaultItems2(DefaultSelectItemsArray dsia) {
        this.selectOneListbox1DefaultItems2 = dsia;
    }
    private DefaultSelectItemsArray selectOneListbox1DefaultItems3 = new DefaultSelectItemsArray();

    public DefaultSelectItemsArray getSelectOneListbox1DefaultItems3() {
        return selectOneListbox1DefaultItems3;
    }

    public void setSelectOneListbox1DefaultItems3(DefaultSelectItemsArray dsia) {
        this.selectOneListbox1DefaultItems3 = dsia;
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
    private DefaultSelectedData selectOneMenu1Bean = new DefaultSelectedData();

    public DefaultSelectedData getSelectOneMenu1Bean() {
        return selectOneMenu1Bean;
    }

    public void setSelectOneMenu1Bean(DefaultSelectedData dsd) {
        this.selectOneMenu1Bean = dsd;
    }
    private DefaultSelectionItems selectOneMenu1DefaultItems = new DefaultSelectionItems();

    public DefaultSelectionItems getSelectOneMenu1DefaultItems() {
        return selectOneMenu1DefaultItems;
    }

    public void setSelectOneMenu1DefaultItems(DefaultSelectionItems dsi) {
        this.selectOneMenu1DefaultItems = dsi;
    }
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
    private ObjectArrayDataProvider arrayTecnicos = new ObjectArrayDataProvider();

    public ObjectArrayDataProvider getArrayTecnicos() {
        return arrayTecnicos;
    }

    public void setArrayTecnicos(ObjectArrayDataProvider oadp) {
        this.arrayTecnicos = oadp;
    }
    private ObjectListDataProvider listSolicitudes = new ObjectListDataProvider();

    public ObjectListDataProvider getListSolicitudes() {
        return listSolicitudes;
    }

    public void setListSolicitudes(ObjectListDataProvider oldp) {
        this.listSolicitudes = oldp;
    }
    private DefaultSelectedData defaultSelectedData6 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData6() {
        return defaultSelectedData6;
    }

    public void setDefaultSelectedData6(DefaultSelectedData dsd) {
        this.defaultSelectedData6 = dsd;
    }
    private DefaultSelectionItems selectOneListbox1DefaultItems = new DefaultSelectionItems();

    public DefaultSelectionItems getSelectOneListbox1DefaultItems() {
        return selectOneListbox1DefaultItems;
    }

    public void setSelectOneListbox1DefaultItems(DefaultSelectionItems dsi) {
        this.selectOneListbox1DefaultItems = dsi;
    }
    private HtmlSelectOneListbox listaSol = new HtmlSelectOneListbox();

    public HtmlSelectOneListbox getListaSol() {
        return listaSol;
    }

    public void setListaSol(HtmlSelectOneListbox hsol) {
        this.listaSol = hsol;
    }
    private ObjectArrayDataProvider arraySolicitudes = new ObjectArrayDataProvider();

    public ObjectArrayDataProvider getArraySolicitudes() {
        return arraySolicitudes;
    }

    public void setArraySolicitudes(ObjectArrayDataProvider oadp) {
        this.arraySolicitudes = oadp;
    }
    private ArrayList solicitudes1 = new ArrayList();

    public ArrayList getSolicitudes1() {
        return solicitudes1;
    }

    public void setSolicitudes1(ArrayList al) {
        this.solicitudes1 = al;
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


    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public jrequestAdmin() {
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
        this.popUpBitacora.setVisible(false);
        this.popUpBitacora.setRendered(false);
        this.popUpMensajes.setVisible(false);
        this.popUpMensajes.setRendered(false);

        // Perform initializations inherited from our superclass
        this.llenarLista();
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
        Integer id=Integer.parseInt(tmp);
        Solicitud s=new BeanBaseJRequest().getEntityManager().find(Solicitud.class, id);

        this.solicitudElegida=s;

        Usuario u = new BeanBaseJHardmin().getUsuario(s.getIdusuario().getIdusuario());

        this.lblNombre.setValue(s.getDescripcion());
        this.lblPersona.setValue(u.getNombre());

        this.comboPrioridad.setValue(s.getPrioridad());

        System.out.println(solicitudElegida.getDescripcion());

    }

    public String btnProceder_action() {

        if(this.solicitudElegida==null){

            System.out.println("SOLICITUD NULL");
            this.lblMensajes.setValue("Seleccione una Solicitud de Mantenimiento");
            this.popUpMensajes.setRendered(true);
            System.out.println("RENDERICE");
            this.popUpMensajes.setVisible(true);
            System.out.println("PUSE VISIBLE");
            this.popUpMensajes.setModal(true);
            System.out.println("SOLO EL ES MODIFICABLE");

        }
        else{
            System.out.println("ARMAMOS EL MANTENIMIENTO");

            Mantenimiento m = new Mantenimiento();

            m.setDescripcion(this.solicitudElegida.getDescripcion());

            Calendar c = Calendar.getInstance();

            m.setFecha(new Date(c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DATE)));


            m.setIdtecnico(tecnicoElegido);

            m.setIdequiposimple(this.solicitudElegida.getIdequiposimple());

            m.setIdsolicitud(this.solicitudElegida);

            new BeanBaseJRequest().registrarMantenimiento(m);

            this.lblMensajes.setValue("Solicitud procesada con éxito. Los técnicos se encargarán de satisfacerla");
            this.popUpMensajes.setRendered(true);
            System.out.println("RENDERICE");
            this.popUpMensajes.setVisible(true);
            System.out.println("PUSE VISIBLE");
            this.popUpMensajes.setModal(true);
            System.out.println("SOLO EL ES MODIFICABLE");

        }
        

        return null;
    }

    public void comboTecnicos_processValueChange(ValueChangeEvent vce) {
        String tmp=(String)this.comboTecnicos.getValue();
        Integer id=Integer.parseInt(tmp);
        Tecnico e=new BeanBaseJRequest().getEntityManager().find(Tecnico.class, id);

        this.tecnicoElegido=e;

        System.out.println(e.getNombres());
    }

    public String btnOK_action() {
        this.popUpMensajes.setVisible(false);
        this.popUpMensajes.setRendered(false);
        this.popUpMensajes.setModal(false);


        return null;
    }




}

