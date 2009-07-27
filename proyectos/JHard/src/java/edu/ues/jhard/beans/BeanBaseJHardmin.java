/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.ues.jhard.beans;

import edu.ues.jhard.jhardmin.LoggedUser;
import edu.ues.jhard.jhardmin.LoginManager;
import edu.ues.jhard.jinvent.CrudManager;
import edu.ues.jhard.jpa.Autorizacion;
import edu.ues.jhard.jpa.Rol;
import edu.ues.jhard.jpa.Usuario;
import edu.ues.jhard.util.ActionMessage;
import java.util.ArrayList;
import java.util.List;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.faces.model.SelectItemGroup;
import javax.persistence.*;
import javax.servlet.http.HttpServletRequest;


/**
 *
 * @author Robertux
 */
public class BeanBaseJHardmin extends BeanBase {

    private LoggedUser currentUser;
    private String inputUsrName;
    private String inputUsrPassword;
    private String inputChOldPwd;
    private String inputChNewPwd;
    private String inputChNewPwdConfirm;
    private Boolean loginFail;
    private List<Rol> roleList;
    private List<Usuario> userList;
    private List<Autorizacion> listaAutorizaciones;
    private ActionMessage msg;
    private Boolean popUpAddUserVisible;
    private Boolean popUpEditUserVisible;
    private Usuario newUser;
    private String newUserPwdConfirm;    
    private String rolSelected;
    private SelectItemGroup roleItemList;
    private int userListSize;
    private Boolean popUpConfirmDelUserVisible;
    private String popUpConfirmDelUserMessage;
    private Usuario editDelUser;
    private CrudManager crdAutorizaciones;
    private Autorizacion currentAutorizacion;
    private Usuario usuarioRegistrado;
    private String claveUsuarioConfirmacion;
    private String autorizacionUsuario;
    private boolean popupRegistrarUsuarioVisible;

    public BeanBaseJHardmin(){
        this.loginFail = false;
        this.setInputUsrName("");
        this.setInputUsrPassword("");
        this.roleList = this.getEntityManager().createNamedQuery("Rol.findAll").getResultList();
        this.userList = this.getEntityManager().createNamedQuery("Usuario.findAll").getResultList();
        this.listaAutorizaciones = this.getEntityManager().createQuery("SELECT a FROM Autorizacion a").getResultList();
        this.currentAutorizacion = new Autorizacion();
        this.crdAutorizaciones = new CrudManager();
        this.msg = new ActionMessage();
        this.setPopUpAddUserVisible(false);
        this.setPopUpEditUserVisible(false);
        this.setPopUpConfirmDelUserVisible(false);
        this.setPopUpConfirmDelUserMessage("");
        this.newUser = new Usuario();
        this.initSelectItems();
        this.editDelUser = new Usuario();
        this.usuarioRegistrado = new Usuario();
    }

    public Usuario getUsuario(String userName, String userPwd){
        Usuario u = null;
        try{            
            EntityManager eMgr = this.getEntityManager();            
            String strSql = "SELECT u FROM Usuario u WHERE u.nombre = '"+userName+"' AND u.clave = '"+userPwd+"'";            
            Query q = eMgr.createQuery(strSql);            
            u = (Usuario)q.getSingleResult();            
        }
        catch(Exception ex){
            ex.printStackTrace();
        }        
        return u;
    }

    public Usuario getUsuario(int id){
        Usuario u = null;
        try{            
            EntityManager eMgr = this.getEntityManager();            
            Query q = eMgr.createNamedQuery("Usuario.findByIdusuario");
            q.setParameter("idusuario", id);

            u=(Usuario)q.getSingleResult();
        }
        catch(Exception ex){
            ex.printStackTrace();
        }        
        return u;
    }

    /**
     * @return the currentUser
     */
    public LoggedUser getCurrentUser() {
        return currentUser;
    }

    /**
     * @param currentUser the currentUser to set
     */
    public void setCurrentUser(LoggedUser currentUser) {
        this.currentUser = currentUser;
    }

    /**
     * @return the inputUsrName
     */
    public String getInputUsrName() {
        return inputUsrName;
    }

    /**
     * @param inputUsrName the inputUsrName to set
     */
    public void setInputUsrName(String inputUsrName) {
        this.inputUsrName = inputUsrName;
    }

    /**
     * @return the inputUsrPassword
     */
    public String getInputUsrPassword() {
        return inputUsrPassword;
    }

    /**
     * @param inputUsrPassword the inputUsrPassword to set
     */
    public void setInputUsrPassword(String inputUsrPassword) {
        this.inputUsrPassword = inputUsrPassword;
    }

    public String login(){
        String remoteAddr = ((HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest()).getRemoteAddr();
        int uid =LoginManager.getInstance().Login(this.inputUsrName, this.inputUsrPassword, remoteAddr);
        if(uid == -1)
            this.setLoginFail(true);
        else{
            this.setCurrentUser(LoginManager.getInstance().getUser(uid));
            this.setLoginFail(false);            
        }
        this.setInputUsrName("");
        this.setInputUsrPassword("");
        return "";
    }

    public String logout(){
        LoginManager.getInstance().Logout(this.currentUser.getUid());
        this.setCurrentUser(null);
        this.setInputUsrName("");
        this.setInputUsrPassword("");
        return "";
    }

    /**
     * @return the loginFail
     */
    public Boolean getLoginFail() {
        return loginFail;
    }

    /**
     * @param loginFail the loginFail to set
     */
    public void setLoginFail(Boolean loginFail) {
        this.loginFail = loginFail;
    }

    /**
     * @return the roleList
     */
    public List<Rol> getRoleList() {
        return roleList;
    }

    public String changePassword(){
        try{
            Usuario usr = LoginManager.getInstance().getUsuario(this.currentUser);
            EntityManager em = this.getEntityManager();
            if(usr.getClave().equalsIgnoreCase(LoginManager.getInstance().encrypt(this.getInputChOldPwd()))){
                if(this.getInputChNewPwd().equalsIgnoreCase(this.getInputChNewPwdConfirm())){                    
                    //this.getEntityManager().merge(usr);
                    //this.getEntityManager().getTransaction().begin();                    
                    usr.setClave(LoginManager.getInstance().encrypt(this.getInputChNewPwd()));
                    em.getTransaction().begin();
                    em.merge(usr);
                    em.getTransaction().commit();
                    //this.getEntityManager().getTransaction().commit();
                    System.out.println("Nueva clave: " + usr.getClave());                    
                    this.setInputChOldPwd("");
                    this.setInputChNewPwd("");
                    this.setInputChNewPwdConfirm("");
                    this.msg.setText("Clave cambiada exitosamente");
                    this.msg.setType("success");
                }
                else{
                    this.msg.setText("Nuevas claves no coinciden");
                    this.msg.setType("fail");
                }
            }
            else{
                this.msg.setText("Clave anterior no coincide");
                this.msg.setType("fail");
            }
            this.msg.setVisible(true);
            return "success! :-)";
        }
        catch(Exception ex){            
            System.out.println(ex.getMessage());
            ex.printStackTrace();
            return "fail  :-(";
        }
    }

    public String closePopup(){
        System.out.println("closePopup invocado.");
        this.msg.setVisible(false);
        return "";
    }

    /**
     * @return the msg
     */
    public ActionMessage getMsg() {
        return msg;
    }

    /**
     * @param msg the msg to set
     */
    public void setMsg(ActionMessage msg) {
        this.msg = msg;
    }

    /**
     * @return the inputChOldPwd
     */
    public String getInputChOldPwd() {
        return inputChOldPwd;
    }

    /**
     * @param inputChOldPwd the inputChOldPwd to set
     */
    public void setInputChOldPwd(String inputChOldPwd) {
        this.inputChOldPwd = inputChOldPwd;
    }

    /**
     * @return the inputChNewPwd
     */
    public String getInputChNewPwd() {
        return inputChNewPwd;
    }

    /**
     * @param inputChNewPwd the inputChNewPwd to set
     */
    public void setInputChNewPwd(String inputChNewPwd) {
        this.inputChNewPwd = inputChNewPwd;
    }

    /**
     * @return the inputChNewPwdConfirm
     */
    public String getInputChNewPwdConfirm() {
        return inputChNewPwdConfirm;
    }

    /**
     * @param inputChNewPwdConfirm the inputChNewPwdConfirm to set
     */
    public void setInputChNewPwdConfirm(String inputChNewPwdConfirm) {
        this.inputChNewPwdConfirm = inputChNewPwdConfirm;
    }

    /**
     * @return the userList
     */
    public List<Usuario> getUserList() {
        return userList;
    }

    /**
     * @param userList the userList to set
     */
    public void setUserList(List<Usuario> userList) {
        this.userList = userList;
    }
    
    /**
     * @return the popUpAddUserVisible
     */
    public Boolean getPopUpAddUserVisible() {
        return popUpAddUserVisible;
    }

    /**
     * @param popUpAddUserVisible the popUpAddUserVisible to set
     */
    public void setPopUpAddUserVisible(Boolean popUpAddUserVisible) {
        this.popUpAddUserVisible = popUpAddUserVisible;        
    }

    public String showPopupAddUser(){
        this.setPopUpAddUserVisible(true);
        this.newUser = new Usuario();
        this.newUser.setNombre("");
        this.newUser.setClave("");
        this.setNewUserPwdConfirm("");
        return "success!";
    }

    public String commitAddUser(){
        this.setPopUpAddUserVisible(false);
        if(!this.newUser.getClave().equalsIgnoreCase(this.newUserPwdConfirm)){            
            this.msg.setText("Las claves no coinciden");
            this.msg.setVisible(true);
            return "fail";
        }
        
        String idSelectedRol = this.rolSelected;
        EntityManager em = this.getEntityManager();
        Rol r = (Rol)em.createQuery("SELECT r FROM Rol r WHERE r.idrol=" + idSelectedRol).getSingleResult();
        em.getTransaction().begin();
        this.newUser.setIdrol(r);
        this.newUser.setClave(LoginManager.getInstance().encrypt(this.newUser.getClave()));
        em.persist(this.newUser);
        em.getTransaction().commit();

        this.msg.setText("Usuario " + this.newUser.getNombre()  + " agregado exitosamente");
        this.msg.setVisible(true);                
        this.popUpAddUserVisible = false;
        this.userList = em.createNamedQuery("Usuario.findAll").getResultList();
        return "Done.";
    }

    public String cancelAddUser(){
        this.setPopUpAddUserVisible(false);
        this.newUser = new Usuario();
        this.newUser.setNombre("");
        this.newUser.setClave("");
        return "Done.";
    }

    /**
     * @return the newUser
     */
    public Usuario getNewUser() {
        return newUser;
    }

    /**
     * @param newUser the newUser to set
     */
    public void setNewUser(Usuario newUser) {
        this.newUser = newUser;
    }

    /**
     * @return the newUserPwdConfirm
     */
    public String getNewUserPwdConfirm() {
        return newUserPwdConfirm;
    }

    /**
     * @param newUserPwdConfirm the newUserPwdConfirm to set
     */
    public void setNewUserPwdConfirm(String newUserPwdConfirm) {
        this.newUserPwdConfirm = newUserPwdConfirm;
    }    

    /**
     * @return the rolSelected
     */
    public String getRolSelected() {
        return rolSelected;
    }

    /**
     * @param rolSelected the rolSelected to set
     */
    public void setRolSelected(String rolSelected) {
        this.rolSelected = rolSelected;
    }

    /**
     * @return the roleItemList
     */
    public SelectItemGroup getRoleItemList() {
        return roleItemList;
    }

    /**
     * @param roleItemList the roleItemList to set
     */
    public void setRoleItemList(SelectItemGroup roleItemList) {
        this.roleItemList = roleItemList;
    }

    private void initSelectItems() {
        this.roleItemList = new SelectItemGroup();
        SelectItem[] itemArray = new SelectItem[this.roleList.size()];
        for(int i=0; i<this.roleList.size(); i++){
            itemArray[i] = new SelectItem(this.roleList.get(i).getIdrol(), this.roleList.get(i).getNombre());
        }
        this.roleItemList.setSelectItems(itemArray);
    }

    public int getUserListSize(){
        return this.userList.size();
    }

   public String showPopupEditUsuario(){
       String idUsuario = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("idUsuario");
       System.out.println("idUsuario: " + idUsuario);
       for(Usuario u: this.userList){
           if(u.getIdusuario().toString().equalsIgnoreCase(idUsuario)){
               this.editDelUser = u;
               this.setRolSelected(u.getIdrol().getIdrol().toString());
               //this.roleItemList.setValue(u.getIdrol().getNombre());
               break;
           }
       }
       this.setPopUpEditUserVisible(true);
       return "done";
   }

   public String editUsuario(){
       this.setPopUpEditUserVisible(false);
       if(!(this.editDelUser.getClave().isEmpty() && this.newUserPwdConfirm.isEmpty())){
           if(!this.editDelUser.getClave().equalsIgnoreCase(this.newUserPwdConfirm)){
               this.msg.setText("Las claves no coinciden");
               this.msg.setVisible(true);
               return "fail";
           }
       }
       EntityManager em = this.getEntityManager();
       Usuario boundUser = (Usuario)em.createQuery("SELECT u FROM Usuario u WHERE u.idusuario = " + this.editDelUser.getIdusuario().toString()).getSingleResult();
       Rol r = (Rol)em.createQuery("SELECT r FROM Rol r WHERE r.idrol=" + this.rolSelected).getSingleResult();
       if(!(this.editDelUser.getClave().isEmpty() && this.newUserPwdConfirm.isEmpty())){
           boundUser.setClave(LoginManager.getInstance().encrypt(this.editDelUser.getClave()));
       }
       boundUser.setIdrol(r);
       em.getTransaction().begin();
       em.merge(boundUser);
       em.getTransaction().commit();
       this.userList = em.createNamedQuery("Usuario.findAll").getResultList();
       return "done";
   }

   public String closePopupEditUsuario(){
       this.setPopUpEditUserVisible(false);
       return "done";
   }

   public String delUsuario(){
       EntityManager em = this.getEntityManager();       
       this.editDelUser = (Usuario)em.createQuery("SELECT u FROM Usuario u WHERE u.idusuario = " + this.editDelUser.getIdusuario().toString()).getSingleResult();
       em.getTransaction().begin();
       em.remove(this.editDelUser);
       em.getTransaction().commit();

       this.setPopUpConfirmDelUserVisible(false);
       this.msg.setText("Usuario " + this.editDelUser.getNombre() + " eliminado exitosamente");
       this.msg.setVisible(true);
       this.userList = em.createNamedQuery("Usuario.findAll").getResultList();
       return "done";
   }

   public String showPopupConfirmDeleteUser(){
       this.setPopUpConfirmDelUserVisible(true);
       String idUsuario = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("idUsuario");
       System.out.println("idUsuario: " + idUsuario);
       for(Usuario u: this.userList){
           if(u.getIdusuario().toString().equalsIgnoreCase(idUsuario)){
               this.editDelUser = u;
               break;
           }
       }
       this.setPopUpConfirmDelUserMessage("Esta seguro que desea eliminar al usuario " + this.editDelUser.getNombre() + "?");
       return "done";
   }

   public String hidePopupConfirmDeleteUser(){
       this.setPopUpConfirmDelUserVisible(false);
       return "done";
   }

    /**
     * @return the popUpConfirmDelUserVisible
     */
    public Boolean getPopUpConfirmDelUserVisible() {
        return popUpConfirmDelUserVisible;
    }

    /**
     * @param popUpConfirmDelUserVisible the popUpConfirmDelUserVisible to set
     */
    public void setPopUpConfirmDelUserVisible(Boolean popUpConfirmDelUserVisible) {
        this.popUpConfirmDelUserVisible = popUpConfirmDelUserVisible;
    }

    /**
     * @return the popUpConfirmDelUserMessage
     */
    public String getPopUpConfirmDelUserMessage() {
        return popUpConfirmDelUserMessage;
    }

    /**
     * @param popUpConfirmDelUserMessage the popUpConfirmDelUserMessage to set
     */
    public void setPopUpConfirmDelUserMessage(String popUpConfirmDelUserMessage) {
        this.popUpConfirmDelUserMessage = popUpConfirmDelUserMessage;
    }

    /**
     * @return the editDelUser
     */
    public Usuario getEditDelUser() {
        return editDelUser;
    }

    /**
     * @param editDelUser the editDelUser to set
     */
    public void setEditDelUser(Usuario editDelUser) {
        this.editDelUser = editDelUser;
    }

    /**
     * @return the popUpEditUserVisible
     */
    public Boolean getPopUpEditUserVisible() {
        return popUpEditUserVisible;
    }

    /**
     * @param popUpEditUserVisible the popUpEditUserVisible to set
     */
    public void setPopUpEditUserVisible(Boolean popUpEditUserVisible) {
        this.popUpEditUserVisible = popUpEditUserVisible;
    }

    /**
     * @return the listaAutorizaciones
     */
    public List<Autorizacion> getListaAutorizaciones() {
        return listaAutorizaciones;
    }

    /**
     * @param listaAutorizaciones the listaAutorizaciones to set
     */
    public void setListaAutorizaciones(List<Autorizacion> listaAutorizaciones) {
        this.listaAutorizaciones = listaAutorizaciones;
    }

    /**
     * @return the crdAutorizaciones
     */
    public CrudManager getCrdAutorizaciones() {
        return crdAutorizaciones;
    }

    /**
     * @param crdAutorizaciones the crdAutorizaciones to set
     */
    public void setCrdAutorizaciones(CrudManager crdAutorizaciones) {
        this.crdAutorizaciones = crdAutorizaciones;
    }

    /**
     * @return the currentAutorizacion
     */
    public Autorizacion getCurrentAutorizacion() {
        return currentAutorizacion;
    }

    /**
     * @param currentAutorizacion the currentAutorizacion to set
     */
    public void setCurrentAutorizacion(Autorizacion currentAutorizacion) {
        this.currentAutorizacion = currentAutorizacion;
    }
        
    public int getListaAutorizacionesSize(){
        return this.listaAutorizaciones.size();
    }

    public String addAutorizacion(){
        EntityManager emgr = this.getEntityManager();
        emgr.getTransaction().begin();
        emgr.persist(this.currentAutorizacion);
        emgr.getTransaction().commit();
        this.listaAutorizaciones.add(this.currentAutorizacion);
        this.crdAutorizaciones.hidePopupAdd();
        this.msg.setText("Nueva autorizacion agregada satisfactoriamente");
        this.msg.setVisible(true);
        this.currentAutorizacion = new Autorizacion();
        this.currentAutorizacion.setUsuarioCollection(new ArrayList<Usuario>());
        return "done";
    }

    public String delAutorizacion(){
        EntityManager emgr = this.getEntityManager();
        this.currentAutorizacion = (Autorizacion)emgr.createQuery("SELECT a FROM Autorizacion a WHERE a.idautorizacion=" + this.crdAutorizaciones.getCurrentId()).getSingleResult();

        emgr.getTransaction().begin();
        for(Usuario u: this.currentAutorizacion.getUsuarioCollection()){
            u.setIdautorizacion(null);
            emgr.merge(u);
        }
        emgr.remove(this.currentAutorizacion);
        emgr.getTransaction().commit();

        this.crdAutorizaciones.hidePopupDel();
        for(int i=0; i<this.listaAutorizaciones.size(); i++){            
            if(this.listaAutorizaciones.get(i).getIdautorizacion() == this.currentAutorizacion.getIdautorizacion()){                
                break;
            }
        }        
        this.msg.setText("Autorizacion eliminada satisfactoriamente. Los usuarios creados a partir de esta autorizacion continuaran existiendo en el sistema.");
        this.msg.setVisible(true);
        this.currentAutorizacion = new Autorizacion();
        this.currentAutorizacion.setUsuarioCollection(new ArrayList<Usuario>());
        return "done";
    }

    public String showPopupRegistrarUsuario(){
        this.setPopupRegistrarUsuarioVisible(true);
        return "done";
    }

    public String hidePopupRegistrarUsuario(){
        this.setPopupRegistrarUsuarioVisible(false);
        return "done";
    }

    public String registrarUsuario(){
        EntityManager emgr = this.getEntityManager();
        Rol rolEstudiante = (Rol)emgr.createQuery("SELECT r FROM Rol r WHERE r.idrol=5").getSingleResult();
        this.usuarioRegistrado.setIdrol(rolEstudiante);
        Autorizacion autRegistro = null;
        try{
            autRegistro = (Autorizacion)emgr.createQuery("SELECT a FROM Autorizacion a WHERE a.codigo=" + this.autorizacionUsuario).getSingleResult();
        }
        catch(Exception ex){
            //pass
        }
        if(autRegistro == null){
            this.msg.setText("Codigo de autorizacion inexistente");
            this.msg.setVisible(true);
            return "fail";
        }
        if(autRegistro.getCantmaxima() == autRegistro.getUsuarioCollection().size()){
            this.msg.setText("No se pueden crear mas usuarios con este codigo de autorizacion");
            this.msg.setVisible(true);
            return "fail";
        }
        if(!this.usuarioRegistrado.getClave().equalsIgnoreCase(this.claveUsuarioConfirmacion)){
            this.msg.setText("Clave no coincide con su confirmacion");
            this.msg.setVisible(true);
            return "fail";
        }
        autRegistro.getUsuarioCollection().add(this.usuarioRegistrado);

        emgr.getTransaction().begin();
        emgr.persist(this.usuarioRegistrado);
        emgr.merge(autRegistro);
        emgr.getTransaction().commit();

        this.hidePopupRegistrarUsuario();
        this.msg.setText("Usuario registrado satisfactoriamente");
        this.msg.setVisible(true);
        for(Autorizacion aut: this.listaAutorizaciones){
            if(aut.getIdautorizacion() == autRegistro.getIdautorizacion()){
                aut.getUsuarioCollection().add(this.usuarioRegistrado);
            }
        }
        this.usuarioRegistrado = new Usuario();
        return "done";
    }

    /**
     * @return the usuarioRegistardo
     */
    public Usuario getUsuarioRegistrado() {
        return usuarioRegistrado;
    }

    /**
     * @param usuarioRegistardo the usuarioRegistardo to set
     */
    public void setUsuarioRegistrado(Usuario usuarioRegistrado) {
        this.usuarioRegistrado = usuarioRegistrado;
    }

    /**
     * @return the claveUsuarioConfirmacion
     */
    public String getClaveUsuarioConfirmacion() {
        return claveUsuarioConfirmacion;
    }

    /**
     * @param claveUsuarioConfirmacion the claveUsuarioConfirmacion to set
     */
    public void setClaveUsuarioConfirmacion(String claveUsuarioConfirmacion) {
        this.claveUsuarioConfirmacion = claveUsuarioConfirmacion;
    }

    /**
     * @return the autorizacionUsuario
     */
    public String getAutorizacionUsuario() {
        return autorizacionUsuario;
    }

    /**
     * @param autorizacionUsuario the autorizacionUsuario to set
     */
    public void setAutorizacionUsuario(String autorizacionUsuario) {
        this.autorizacionUsuario = autorizacionUsuario;
    }

    /**
     * @return the popupRegistrarUsuarioVisible
     */
    public boolean getPopupRegistrarUsuarioVisible() {
        return popupRegistrarUsuarioVisible;
    }

    /**
     * @param popupRegistrarUsuarioVisible the popupRegistrarUsuarioVisible to set
     */
    public void setPopupRegistrarUsuarioVisible(boolean popupRegistrarUsuarioVisible) {
        this.popupRegistrarUsuarioVisible = popupRegistrarUsuarioVisible;
    }
}
