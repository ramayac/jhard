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
import com.sun.data.provider.impl.ObjectArrayDataProvider;
import com.sun.data.provider.impl.ObjectListDataProvider;
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
        arrayEqSimples.setArray((java.lang.Object[]) getValue("#{jrequestAdmin.eqs}"));
        

        selectOneMenu1DefaultItems1.setItems(new String[]{"Alta", "Media", "Baja"});
        selectOneMenu2DefaultItems.setItems(new String[]{"Alta", "Media","Baja"});


        selectOneListbox1DefaultItems1.setItems(new String[]{});
        selectOneListbox1DefaultItems2.setItems(new String[]{});
        selectOneListbox1DefaultItems3.setItems(new String[]{});
        selectOneListbox1DefaultItems5.setItems(new String[]{});
        selectOneListbox1DefaultItems6.setItems(new String[]{});
        listaSolDefaultItems.setItems(new String[]{});
        selectOneListbox1DefaultItems4.setItems(new String[]{});
        selectOneRadio1DefaultItems1.setItems(new String[]{});
        listaMantenimientosDefaultItems.setItems(new String[]{});
        selectOneListbox1DefaultItems.setItems(new String[]{});
        selectOneMenu1DefaultItems4.setItems(new String[]{});
        selectOneMenu1DefaultItems3.setItems(new String[]{});

        comboPrioridadDefaultItems.setItems(new String[]{"Alta", "Media", "Baja"});
        selectOneMenu1DefaultItems2.setItems(new String[]{});


    }

    // </editor-fold>



    //ESTE METODO DEBE DE IR EN EL NEGOCIO
    public void llenarLista(){

        //Limpio las listas si están llenas
        limpiarListas();


        //LISTA DE SOLICITUDES ORDENADAS POR PRIORIDAD
        
        //Array que se metera en la selectonelistbox
        soc=new ArrayList();

        //Para comparar cuales solicitudes ya tienen mantenimientos relacionados
        mantenimientos = new edu.ues.jhard.beans.BeanBaseJRequest().getMantenimiento();

        //Consulta de solicitudes por prioridad ALTA
        solicitudes = new edu.ues.jhard.beans.BeanBaseJRequest().getSolicitudesByPrioridad("Alta");

        //contador
        int cont=0;

        //Bucle para meter las solicitudes en el ArrayList
        for(int i=0;i<solicitudes.length;i++){

            cont=0;

            //Comparo y cuento si ya existe un mantenimiento que contenga el ID de la solicitud,
            //si ya existe, aumento el contador y dicha solicitud ya no se debe de mostrar

            for(int j=0;j<mantenimientos.length;j++){
                System.out.println(mantenimientos[j].getIdsolicitud().getIdsolicitud()+"  "+solicitudes[i].getIdsolicitud());
                if (mantenimientos[j].getIdsolicitud().getIdsolicitud().equals(solicitudes[i].getIdsolicitud())){
                    System.out.println("ENTRO!!!");
                    cont++;
                    System.out.println(cont);
                }
            }

            if(cont==0){
                System.out.println("SI ESTO NO ES CERO NO DEBE DE ENTRAR..."+cont);
                Usuario u = new BeanBaseJHardmin().getUsuario(solicitudes[i].getIdusuario().getIdusuario());
                String label = u.getNombre()+"  "+solicitudes[i].getDescripcion();
                soc.add(new SelectItem(solicitudes[i].getIdsolicitud(), label));
            }
            
        }

        

        //Consulta de solicitudes por prioridad MEDIA
        solicitudes = new edu.ues.jhard.beans.BeanBaseJRequest().getSolicitudesByPrioridad("Media");

        //contador
        cont=0;

        //Bucle para meter las solicitudes en el ArrayList
        for(int i=0;i<solicitudes.length;i++){

            cont=0;

            for(int j=0;j<mantenimientos.length;j++){
                if (mantenimientos[j].getIdsolicitud().getIdsolicitud().equals(solicitudes[i].getIdsolicitud())){
                    cont++;
                }
            }

            if(cont==0){
                Usuario u = new BeanBaseJHardmin().getUsuario(solicitudes[i].getIdusuario().getIdusuario());
                String label = u.getNombre()+"  "+solicitudes[i].getDescripcion();
                soc.add(new SelectItem(solicitudes[i].getIdsolicitud(), label));
            }

        }

        //Consulta de solicitudes por prioridad BAJA
        solicitudes = new edu.ues.jhard.beans.BeanBaseJRequest().getSolicitudesByPrioridad("Baja");

        //contador
        cont=0;

        for(int i=0;i<solicitudes.length;i++){

            cont=0;

            for(int j=0;j<mantenimientos.length;j++)
                if (mantenimientos[j].getIdsolicitud().getIdsolicitud().equals(solicitudes[i].getIdsolicitud()))
                    cont++;

            if(cont==0){

                Usuario u = new BeanBaseJHardmin().getUsuario(solicitudes[i].getIdusuario().getIdusuario());
                String label = u.getNombre()+"  "+solicitudes[i].getDescripcion();
                soc.add(new SelectItem(solicitudes[i].getIdsolicitud(), label));
            }
        }


        //Creo una UISelecItems
        UISelectItems items = new UISelectItems();
        //Le añado como valor el ArrayList
        items.setValue(soc);
        //Le meto las UISelectItems como hijos de la selectonelistbox
        this.listaSol.getChildren().add(items);


        //LISTA DE MANTENIMIENTOS

        //Agarro todos los mantenimientos
        mantenimientos = new edu.ues.jhard.beans.BeanBaseJRequest().getMantenimientoByEstado("Pendiente");

        //Creo e instancio el ArrayList que contendrá el selectlistonebox
        man= new ArrayList();


        for(int i=0;i<mantenimientos.length;i++){

            Equiposimple eq = new BeanBaseJRequest().getEquipoSimpleByID(mantenimientos[i].getIdequiposimple().getIdEquipoSimple());

            String label = eq.getDescripcion() +"  "+ mantenimientos[i].getDescripcion();

            man.add(new SelectItem(mantenimientos[i].getIdmantenimiento(), label));
        }

        UISelectItems itemsMan = new UISelectItems();
        itemsMan.setValue(man);
        
        this.listaMantenimientos.getChildren().add(itemsMan);




        //LISTA DE TECNICOS
         
        tecnicos = new edu.ues.jhard.beans.BeanBaseJRequest().getTecnico();

        tec = new ArrayList();

        for(int i=0;i<tecnicos.length;i++){
            
            String label = tecnicos[i].getNombres()+" "+tecnicos[i].getApellidos();
            tec.add(new SelectItem(tecnicos[i].getIdtecnico(),label));
        }

        UISelectItems itemsTec = new UISelectItems();
        itemsTec.setValue(tec);
        this.listaTecnicos.getChildren().add(itemsTec);

    }

    private void limpiarListas(){
        this.listaTecnicos.getChildren().clear();
        this.listaSol.getChildren().clear();
        this.listaMantenimientos.getChildren().clear();
    }


    private void llenarCombo(){

        //Combo de Estados

        setEEquipo(new edu.ues.jhard.beans.BeanBaseJRequest().getEstadoEquipo());

        eeq = new ArrayList();

        for(int i=0;i<getEEquipo().length;i++){

            String label = getEEquipo()[i].getDescripcion();
            eeq.add(new SelectItem(getEEquipo()[i].getIdestado(),label));
        }

        UISelectItems itemsEeq = new UISelectItems();
        itemsEeq.setValue(eeq);
        this.comboEstado.getChildren().add(itemsEeq);

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
    private Mantenimiento[] mantenimientos;
    private Estadoequipo[] eEquipo = new edu.ues.jhard.beans.BeanBaseJRequest().getEstadoEquipo();
    private Tecnico[] tecnicos = new edu.ues.jhard.beans.BeanBaseJRequest().getTecnico();
    private Equiposimple[] eqs = new edu.ues.jhard.beans.BeanBaseJRequest().getEquipoSimple();
    private Bitacoraestados[] bitacoras;
    private Tecnico tecnicoElegido=tecnicos[0];
    private Estadoequipo estadoElegido=getEEquipo()[0];
    private Tecnico tecElegidoLista=null;
    private Solicitud solicitudElegida=null;
    private Mantenimiento mantenimientoElegido=null;
    private Bitacoraestados bitacoraElegida=null;
    private Equiposimple eqSimpleElegido=null;

    private ArrayList soc;
    private ArrayList man;
    private ArrayList tec;
    private ArrayList bit;
    private ArrayList eeq;


    public Estadoequipo[] getEEquipo() {
        return eEquipo;
    }

    public void setEEquipo(Estadoequipo[] eEquipo) {
        this.eEquipo = eEquipo;
    }

    public Equiposimple[] getEqs() {
        return eqs;
    }

    public void setEqs(Equiposimple[] eqs) {
        this.eqs = eqs;
    }


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
    private HtmlSelectOneListbox listaMantenimientos = new HtmlSelectOneListbox();

    public HtmlSelectOneListbox getListaMantenimientos() {
        return listaMantenimientos;
    }

    public void setListaMantenimientos(HtmlSelectOneListbox hsol) {
        this.listaMantenimientos = hsol;
    }
    private DefaultSelectedData selectBooleanCheckbox1Bean = new DefaultSelectedData();

    public DefaultSelectedData getSelectBooleanCheckbox1Bean() {
        return selectBooleanCheckbox1Bean;
    }

    public void setSelectBooleanCheckbox1Bean(DefaultSelectedData dsd) {
        this.selectBooleanCheckbox1Bean = dsd;
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
    private PopupBean panelPopup1Bean = new PopupBean();

    public PopupBean getPanelPopup1Bean() {
        return panelPopup1Bean;
    }

    public void setPanelPopup1Bean(PopupBean pb) {
        this.panelPopup1Bean = pb;
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
    private DefaultSelectedData defaultSelectedData7 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData7() {
        return defaultSelectedData7;
    }

    public void setDefaultSelectedData7(DefaultSelectedData dsd) {
        this.defaultSelectedData7 = dsd;
    }
    private DefaultSelectionItems selectOneListbox1DefaultItems4 = new DefaultSelectionItems();

    public DefaultSelectionItems getSelectOneListbox1DefaultItems4() {
        return selectOneListbox1DefaultItems4;
    }

    public void setSelectOneListbox1DefaultItems4(DefaultSelectionItems dsi) {
        this.selectOneListbox1DefaultItems4 = dsi;
    }
    private DefaultSelectItemsArray listaSolDefaultItems = new DefaultSelectItemsArray();

    public DefaultSelectItemsArray getListaSolDefaultItems() {
        return listaSolDefaultItems;
    }

    public void setListaSolDefaultItems(DefaultSelectItemsArray dsia) {
        this.listaSolDefaultItems = dsia;
    }
    private DefaultSelectItemsArray listaMantenimientosDefaultItems = new DefaultSelectItemsArray();

    public DefaultSelectItemsArray getListaMantenimientosDefaultItems() {
        return listaMantenimientosDefaultItems;
    }

    public void setListaMantenimientosDefaultItems(DefaultSelectItemsArray dsia) {
        this.listaMantenimientosDefaultItems = dsia;
    }
    private DefaultSelectItemsArray selectOneListbox1DefaultItems5 = new DefaultSelectItemsArray();

    public DefaultSelectItemsArray getSelectOneListbox1DefaultItems5() {
        return selectOneListbox1DefaultItems5;
    }

    public void setSelectOneListbox1DefaultItems5(DefaultSelectItemsArray dsia) {
        this.selectOneListbox1DefaultItems5 = dsia;
    }
    private DefaultSelectItemsArray selectOneListbox1DefaultItems6 = new DefaultSelectItemsArray();

    public DefaultSelectItemsArray getSelectOneListbox1DefaultItems6() {
        return selectOneListbox1DefaultItems6;
    }

    public void setSelectOneListbox1DefaultItems6(DefaultSelectItemsArray dsia) {
        this.selectOneListbox1DefaultItems6 = dsia;
    }
    private HtmlSelectOneListbox listaTecnicos = new HtmlSelectOneListbox();

    public HtmlSelectOneListbox getListaTecnicos() {
        return listaTecnicos;
    }

    public void setListaTecnicos(HtmlSelectOneListbox hsol) {
        this.listaTecnicos = hsol;
    }
    private HtmlCommandButton btnEliminarTec = new HtmlCommandButton();

    public HtmlCommandButton getBtnEliminarTec() {
        return btnEliminarTec;
    }

    public void setBtnEliminarTec(HtmlCommandButton hcb) {
        this.btnEliminarTec = hcb;
    }
    private HtmlCommandButton btnAgregarTec = new HtmlCommandButton();

    public HtmlCommandButton getBtnAgregarTec() {
        return btnAgregarTec;
    }

    public void setBtnAgregarTec(HtmlCommandButton hcb) {
        this.btnAgregarTec = hcb;
    }
    private HtmlOutputLabel lblNombreTec = new HtmlOutputLabel();

    public HtmlOutputLabel getLblNombreTec() {
        return lblNombreTec;
    }

    public void setLblNombreTec(HtmlOutputLabel hol) {
        this.lblNombreTec = hol;
    }
    private ObjectArrayDataProvider arrayEqSimples = new ObjectArrayDataProvider();

    public ObjectArrayDataProvider getArrayEqSimples() {
        return arrayEqSimples;
    }

    public void setArrayEqSimples(ObjectArrayDataProvider oadp) {
        this.arrayEqSimples = oadp;
    }
    private DefaultSelectedData defaultSelectedData8 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData8() {
        return defaultSelectedData8;
    }

    public void setDefaultSelectedData8(DefaultSelectedData dsd) {
        this.defaultSelectedData8 = dsd;
    }
    private DefaultSelectionItems selectOneListbox1DefaultItems = new DefaultSelectionItems();

    public DefaultSelectionItems getSelectOneListbox1DefaultItems() {
        return selectOneListbox1DefaultItems;
    }

    public void setSelectOneListbox1DefaultItems(DefaultSelectionItems dsi) {
        this.selectOneListbox1DefaultItems = dsi;
    }
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
    private DefaultSelectedData defaultSelectedData9 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData9() {
        return defaultSelectedData9;
    }

    public void setDefaultSelectedData9(DefaultSelectedData dsd) {
        this.defaultSelectedData9 = dsd;
    }
    private DefaultSelectionItems selectOneMenu1DefaultItems2 = new DefaultSelectionItems();

    public DefaultSelectionItems getSelectOneMenu1DefaultItems2() {
        return selectOneMenu1DefaultItems2;
    }

    public void setSelectOneMenu1DefaultItems2(DefaultSelectionItems dsi) {
        this.selectOneMenu1DefaultItems2 = dsi;
    }
    private DefaultSelectItemsArray comboPrioridadDefaultItems = new DefaultSelectItemsArray();

    public DefaultSelectItemsArray getComboPrioridadDefaultItems() {
        return comboPrioridadDefaultItems;
    }

    public void setComboPrioridadDefaultItems(DefaultSelectItemsArray dsia) {
        this.comboPrioridadDefaultItems = dsia;
    }
    private DefaultSelectItemsArray selectOneMenu1DefaultItems3 = new DefaultSelectItemsArray();

    public DefaultSelectItemsArray getSelectOneMenu1DefaultItems3() {
        return selectOneMenu1DefaultItems3;
    }

    public void setSelectOneMenu1DefaultItems3(DefaultSelectItemsArray dsia) {
        this.selectOneMenu1DefaultItems3 = dsia;
    }
    private DefaultSelectItemsArray selectOneMenu1DefaultItems4 = new DefaultSelectItemsArray();

    public DefaultSelectItemsArray getSelectOneMenu1DefaultItems4() {
        return selectOneMenu1DefaultItems4;
    }

    public void setSelectOneMenu1DefaultItems4(DefaultSelectItemsArray dsia) {
        this.selectOneMenu1DefaultItems4 = dsia;
    }
    private HtmlSelectOneMenu comboEstado = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getComboEstado() {
        return comboEstado;
    }

    public void setComboEstado(HtmlSelectOneMenu hsom) {
        this.comboEstado = hsom;
    }
    private ObjectArrayDataProvider arrayEstado = new ObjectArrayDataProvider();

    public ObjectArrayDataProvider getArrayEstado() {
        return arrayEstado;
    }

    public void setArrayEstado(ObjectArrayDataProvider oadp) {
        this.arrayEstado = oadp;
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
        this.popUpAgregarTec .setVisible(false);
        this.popUpAgregarTec.setRendered(false);
        this.popUpModBitacora .setVisible(false);
        this.popUpModBitacora.setRendered(false);

        // Perform initializations inherited from our superclass
        this.llenarLista();
        this.llenarCombo();
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

            m.setEstado("Pendiente");

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

        llenarLista();
        
        return null;
    }

    public void tabJrequestAdmin_processTabChange(TabChangeEvent tce) {

        
    }

    public void listaMantenimientos_processValueChange(ValueChangeEvent vce) {
        String tmp=(String)this.listaMantenimientos.getValue();
        Integer id=Integer.parseInt(tmp);
        Mantenimiento m=new BeanBaseJRequest().getEntityManager().find(Mantenimiento.class, id);

        this.mantenimientoElegido=m;

        Equiposimple eq= new BeanBaseJRequest().getEquipoSimpleByID(this.mantenimientoElegido.getIdequiposimple().getIdEquipoSimple());

        this.lblMantenimiento.setValue("¿Finalizado el Mantenimiento de " +this.mantenimientoElegido.getDescripcion() +" al Equipo "+ eq.getDescripcion() +" ?");
        this.popUpBitacora.setRendered(true);
        System.out.println("RENDERICE");
        this.popUpBitacora.setVisible(true);
        System.out.println("PUSE VISIBLE");
        this.popUpBitacora.setModal(true);
        System.out.println("SOLO EL ES MODIFICABLE");


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

            this.popUpBitacora.setRendered(false);
            System.out.println("RENDERICE");
            this.popUpBitacora.setVisible(false);
            System.out.println("PUSE VISIBLE");
            this.popUpBitacora.setModal(false);
            System.out.println("SOLO EL ES MODIFICABLE");

            this.lblMensajes.setValue("Mantenimiento realizado con éxito. Se ha ingresado a la bitácora del equipo");
            this.popUpMensajes.setRendered(true);
            System.out.println("RENDERICE");
            this.popUpMensajes.setVisible(true);
            System.out.println("PUSE VISIBLE");
            this.popUpMensajes.setModal(true);
            System.out.println("SOLO EL ES MODIFICABLE");

        }
        if(!this.checkFIn.isSelected()){
            this.lblMantenimiento.setValue("Si ha terminado ya el mantenimiento, seleccione la casilla apropiada");
        }
        if(this.txtDescripcion.getValue().equals("")){
            this.lblMantenimiento.setValue("La descripción del mantenimiento no debe quedar en blanco");
        }

        return null;
    }

    public String btnCerrar_action() {

        this.popUpBitacora.setRendered(false);
        System.out.println("RENDERICE");
        this.popUpBitacora.setVisible(false);
        System.out.println("PUSE VISIBLE");
        this.popUpBitacora.setModal(false);
        System.out.println("SOLO EL ES MODIFICABLE");

        return null;
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

    public void listaTecnicos_processValueChange(ValueChangeEvent vce) {

        String tmp=(String)this.listaTecnicos.getValue();
        Integer id=Integer.parseInt(tmp);
        Tecnico T=new BeanBaseJRequest().getEntityManager().find(Tecnico.class, id);

        this.tecElegidoLista=T;

        this.lblNombreTec.setValue(T.getNombres()+" "+T.getApellidos());


    }

    public String btnEliminarTec_action() {
        if(tecElegidoLista!=null){
            new BeanBaseJRequest().eliminarTecnico(this.tecElegidoLista);

            this.lblMensajes.setValue("Técnico eliminado con éxito");
            this.popUpMensajes.setRendered(true);
            System.out.println("RENDERICE");
            this.popUpMensajes.setVisible(true);
            System.out.println("PUSE VISIBLE");
            this.popUpMensajes.setModal(true);
            System.out.println("SOLO EL ES MODIFICABLE");


        }
        else{
            System.out.println("TECNICO NULL");
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

    public String btnCerrarTec_action() {
        this.popUpAgregarTec.setRendered(false);
        System.out.println("RENDERICE");
        this.popUpAgregarTec.setVisible(false);
        System.out.println("PUSE VISIBLE");
        this.popUpAgregarTec.setModal(false);
        System.out.println("SOLO EL ES MODIFICABLE");
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

        this.lblMensajes.setValue("Técnico agregado con éxito");
        this.popUpMensajes.setRendered(true);
        System.out.println("RENDERICE");
        this.popUpMensajes.setVisible(true);
        System.out.println("PUSE VISIBLE");
        this.popUpMensajes.setModal(true);
        System.out.println("SOLO EL ES MODIFICABLE");

        
        
        return null;
    }

    public String btnLimpiar_action() {
        return null;
    }

    public void txtEqSimples_processValueChange(ValueChangeEvent vce) {

        
    }

    private void llenarListaBitacoras(Equiposimple e){
        //LISTA DE BITACORAS
        bitacoras = new edu.ues.jhard.beans.BeanBaseJRequest().getBitacoraEstadosByIdEquipoSimple(e);

        bit= new ArrayList();

        for(int i=0;i<bitacoras.length;i++){

            String label = bitacoras[i].getDescripcion()  +"  "+ bitacoras[i].getFecha().toString();

            bit.add(new SelectItem(bitacoras[i].getIdbitacora(), label));
        }

        UISelectItems itemsBit = new UISelectItems();
        itemsBit.setValue(bit);

        this.listaBitacoras.getChildren().add(itemsBit);

    }

    private void limpiarListaBitacoras(){
        this.listaBitacoras.getChildren().clear();
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
        Integer id=Integer.parseInt(tmp);
        Bitacoraestados be=new BeanBaseJRequest().getEntityManager().find(Bitacoraestados.class, id);

        this.bitacoraElegida=be;
        
        this.txtModBitacora.setValue(this.bitacoraElegida.getDescripcion());

        this.popUpModBitacora.setRendered(true);
        System.out.println("RENDERICE");
        this.popUpModBitacora.setVisible(true);
        System.out.println("PUSE VISIBLE");
        this.popUpModBitacora.setModal(true);
        System.out.println("SOLO EL ES MODIFICABLE");


    }

    public String btnCancelarModBitacora_action() {
        this.popUpModBitacora.setRendered(false);
        System.out.println("RENDERICE");
        this.popUpModBitacora.setVisible(false);
        System.out.println("PUSE VISIBLE");
        this.popUpModBitacora.setModal(false);
        System.out.println("SOLO EL ES MODIFICABLE");
        return null;
    }

    public String btnAceptarModBitacora_action() {
        this.bitacoraElegida.setDescripcion((String)this.txtModBitacora.getValue());
        System.out.println(bitacoraElegida.getDescripcion());
        
        new BeanBaseJRequest().modificarBitacoraEstados(bitacoraElegida);

        this.popUpModBitacora.setRendered(false);
        System.out.println("RENDERICE");
        this.popUpModBitacora.setVisible(false);
        System.out.println("PUSE VISIBLE");
        this.popUpModBitacora.setModal(false);
        System.out.println("SOLO EL ES MODIFICABLE");

        this.lblMensajes.setValue("Bitácora modificada con éxito");
        this.popUpMensajes.setRendered(true);
        System.out.println("RENDERICE");
        this.popUpMensajes.setVisible(true);
        System.out.println("PUSE VISIBLE");
        this.popUpMensajes.setModal(true);
        System.out.println("SOLO EL ES MODIFICABLE");
        llenarListaBitacoras(eqSimpleElegido);

        return null;
    }

    public String btnSolicitudAdmin_action() {

        return "case2";
    }

    
}

