/*
 * jrequestUser.java
 *
 * Created on 05-29-2009, 10:56:59 AM
 * Copyright ramayac
 */
package jhard;

import edu.ues.jhard.beans.BeanBaseJWiki;
import edu.ues.jhard.jhardmin.LoginManager;
import edu.ues.jhard.jpa.Articulos;
import java.util.ArrayList;
import java.util.List;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

/**
 * <p>Page bean that corresponds to a similarly named JSP page.  This
 * class contains component definitions (and initialization code) for
 * all components that you have defined on this page, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 */
public class jwikiUser extends BeanBaseJHard {
    static final int MAX_COMENTARIOS = 10;
    static final int MAX_ENTRADAS = 5;

    private Articulos articuloActual = null;

    private List<Articulos> listaArticulos = new ArrayList<Articulos>();
    private Boolean soloUna = new Boolean(false);

    private String criteriosBusqueda = EMPTY_STRING;
    
    private int __placeholder;

    private BeanBaseJWiki jwikiInstance = new BeanBaseJWiki();

    /**
     * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    private void _init() throws Exception {
    }

    public  BeanBaseJWiki getJWikiInstance() {
        return this.jwikiInstance;
    }

    public Articulos getArticuloActual() {
        return articuloActual;
    }

    public void setArticuloActual(Articulos articuloActual) {
        this.articuloActual = articuloActual;
    }

    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public jwikiUser() {
        lu= getJHardminInstance().getCurrentUser();
        if(lu!=null){
            U = LoginManager.getInstance().getUsuario(lu);
            this.lblUser.setValue((String)U.getNombre());
//            switch(U.getIdrol().getIdrol()){
//                case ROL_ADMINISTRADOR:
//                case ROL_EDITORCONTENIDO:
//                default:
//                    break;
//            }
        } else this.lblUser.setValue(INVITADO);

        String wikiId = ((HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest()).getParameter("wkid");
        //System.out.println("Wiki ID: "+ wikiId);
        if((wikiId == null) || (wikiId.isEmpty())){
            this.listaArticulos = this.getJWikiInstance().getAllArticulos();
            if(this.listaArticulos.size()>0) this.articuloActual = this.listaArticulos.get(0);
        } else {
            Integer wkid = new Integer(wikiId);
            this.articuloActual = this.getJWikiInstance().getArticulo(wkid);
            this.listaArticulos = new ArrayList<Articulos>();
            this.listaArticulos.add(articuloActual);//hack
            //this.setSoloUna(true);
        }
    }

    public String getCriteriosBusqueda() {
        return criteriosBusqueda;
    }

    public void setCriteriosBusqueda(String criteriosBusqueda) {
        this.criteriosBusqueda = criteriosBusqueda;
    }

    public List<Articulos> getListaArticulos() {
        return this.listaArticulos;
    }

    public void setListaArticulos(List<Articulos> listaArticulos) {
        this.listaArticulos = listaArticulos;
    }

    /**
     * Metodo para saber si se ve una o varias Articulos
     * @param varias
     */
    public Boolean getSoloUna() {
        return this.soloUna;
    }

    /**
     * Metodo para establecer si se ve una o varias Articulos
     * @param varias
     */
    public void setSoloUna(Boolean varias) {
        this.soloUna = varias;
    }

    /**
     * Metodo para obtener una entrada por su ID
     * @param identrada id de la entada que se desea
     * @return
     */
    public String elegirArticuloActual() {
        String idSeleccionado = ((HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest()).getParameter("idSeleccionado");
        Integer id = new Integer(idSeleccionado);
        this.articuloActual = this.jwikiInstance.getArticulo(id.intValue());
        this.setSoloUna(true);
        return EMPTY_STRING;
    }

    public boolean getHayArticulos(){
        if(this.listaArticulos==null) return false;
        if(this.listaArticulos.size()==NONE) return false;
        return true;
    }

    public boolean getShowPagArticulos(){
        if(this.listaArticulos==null) return false;
        if(this.listaArticulos.size()>MAX_ENTRADAS) return true;
        return false;
    }

    public boolean getPermisoBorrarComentario(){
        switch(this.getRolUsuarioConectado()){
            case -1:
                return false; //no hay informacion de usuario
            case ROL_ADMINISTRADOR:
            case ROL_EDITORCONTENIDO:
                return true; //tengo los permisos para borrar los comentarios POR MI ROL
            //default:
                //break;
        }
        return false;
    }

    public String busquedaArticulos(){
       //TODO: convertir esto en filtrado real...
       this.criteriosBusqueda = criteriosBusqueda.replaceAll("'", EMPTY_STRING);
       this.criteriosBusqueda = criteriosBusqueda.replaceAll("\"", EMPTY_STRING);
       this.listaArticulos = this.jwikiInstance.searchPalabrasEnArticulo(criteriosBusqueda);
       return EMPTY_STRING;
    }

    /**
     * Metodo para establecer hacer toggle a la vista de entradas (Unica o Multiple)
     */
    public String toggleVista() {
        this.setSoloUna(false);
        return EMPTY_STRING;
    }
}
