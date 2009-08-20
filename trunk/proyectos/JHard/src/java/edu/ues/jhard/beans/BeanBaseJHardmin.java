/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.ues.jhard.beans;

import edu.ues.jhard.jhardmin.LoggedUser;
import edu.ues.jhard.jhardmin.LoginManager;
import edu.ues.jhard.jinvent.CrudManager;
import edu.ues.jhard.jpa.Autorizacion;
import edu.ues.jhard.jpa.Docente;
import edu.ues.jhard.jpa.Estudiante;
import edu.ues.jhard.jpa.Instructor;
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
 * Backing bean con toda la funcionalidad de eventos y manejo de objetos persistentes para ser usados en la pagina Admin.jspx
 * @author Robertux
 */
public class BeanBaseJHardmin extends BeanBase {

    /**
     * Representa al usuario actualmente logueado en esta sesion
     */
    private LoggedUser currentUser;
    /**
     * Nombre del usuario. Asociado al campo en pantalla para iniciar sesion
     */
    private String inputUsrName;
    /**
     * Clave del usuario. Asociado al campo en pantalla para iniciar sesion
     */
    private String inputUsrPassword;
    /**
     * Clave anterior del usuario. Asociado al campo en pantalla para cambiar clave
     */
    private String inputChOldPwd;
    /**
     * Nueva clave del usuario. Asociado al campo en pantalla para cambiar clave
     */
    private String inputChNewPwd;
    /**
     * Confirmacion de la nueva clave del usuario. Asoaciado al campo en pantalla para pedir la confirmacion de la nueva clave
     */
    private String inputChNewPwdConfirm;
    /**
     * Representa el estado del ultimo intento de inicio de sesion: False = exitoso, True = fallido
     */
    private Boolean loginFail;
    /**
     * Contiene la lista de todos los roles existentes en la base de datos
     */
    private List<Rol> roleList;
    /**
     * Contiene la lista de todos los usuarios existentes en la base de datos
     */
    private List<Usuario> userList;
    /**
     * Contiene la lista de todas las autorizaciones existentes en la base de datos
     */
    private List<Autorizacion> listaAutorizaciones;
    /**
     * Contiene la lista de todos los estudiantes existentes en la base de datos
     */
    private List<Estudiante> listaEstudiantes;
    /**
     * Contiene la lista de todos los instructores existentes en la base de datos
     */
    private List<Instructor> listaInstructores;
    /**
     * Contiene la lista de todos los docentes existentes en la base de datos
     */
    private List<Docente> listaDocentes;
    /**
     * Representa el mensaje en pantalla a mostrar, en una ventana de popUp generica
     */
    private ActionMessage msg;
    /**
     * Representa la visibilidad de la popUp de mensajes genericos
     */
    private Boolean popUpAddUserVisible;
    /**
     * Representa la visibilidad del popUp que muestra el formulario para editar usuarios
     */
    private Boolean popUpEditUserVisible;
    /**
     * Representa a un nuevo usuario que se esta agregando al sistema
     */
    private Usuario newUser;
    /**
     * Representa la confirmacion de la clave del nuevo usuario que se esta agregando al sistema
     */
    private String newUserPwdConfirm;
    /**
     * Representa el id del rol seleccionado en el comboBox que lista todos los roles existentes
     */
    private String rolSelected;
    /**
     * Representa todos los roles existentes en la base de datos en forma de objetos SelectItem para poder ser renderizados como un comboBox
     */
    private SelectItemGroup roleItemList;
    /**
     * Representa la visibilidad del popUp que muestra una confirmacion al momento de intentar eliminar un usuario
     */
    private Boolean popUpConfirmDelUserVisible;
    /**
     * Representa el mensaje de texto a mostrar en el popUp de confrimacion al momento de intentar eliminar un usuario
     */
    private String popUpConfirmDelUserMessage;
    /**
     * Representa a un usuario que esta siendo editado en el sistema o al usuario que se desea eliminar
     */
    private Usuario editDelUser;
    /**
     * Representa a un CrudManager para el manejo de eventos de agregacion/modificacion/eliminacion de autorizaciones
     */
    private CrudManager crdAutorizaciones;
    /**
     * Representa a un CrudManager para el manejo de eventos de agregacion/modificacion/eliminacion de estudiantes
     */
    private CrudManager crdEstudiantes;
    /**
     * Representa a un CrudManager para el manejo de eventos de agregacion/modificacion/eliminacion de instructores
     */
    private CrudManager crdInstructores;
    /**
     * Representa a un crudManager para el manejo de eventos de agregacion/modificacion/eliminacion de docentes
     */
    private CrudManager crdDocentes;
    /**
     * Representa a la autorizacion que actualmente esta siendo creada/editada o eliminada
     */
    private Autorizacion currentAutorizacion;
    /**
     * Representa al usuario que actualmente se esta registrando en el sistema
     */
    private Usuario usuarioRegistrado;
    /**
     * Representa al estudiante asociado al usuario que actualmente se esta registrando al sistema
     */
    private Estudiante estudianteUsuarioRegistrado;
    /**
     * Representa la confirmacion de la clave del usuario que actualmente se esta registrando al sistema
     */
    private String claveUsuarioConfirmacion;
    /**
     * Representa el codigo de autorizacion del usuario que actualmente se esta registrando al sistema
     */
    private String autorizacionUsuario;
    /**
     * Representa la visibilidad del popUp que muestra el formulario para registrar nuevos usuarios en el sistema
     */
    private boolean popupRegistrarUsuarioVisible;
    /**
     * Representa al estudiante que actualmente esta siendo agregado/modificado/eliminado
     */
    private Estudiante currentEstudiante;
    /**
     * Representa al instructor que actualmente esta siendo agregado/modificado/eliminado
     */
    private Instructor currentInstructor;
    /**
     * Representa al docente que actualmente esta siendo agregado/modificado/eliminado
     */
    private Docente currentDocente;


    /**
     * Crea una nueva instancia de la clase JHardmin inicializando los componentes que se usan desde el principio que carga la pagina asociada a este bean
     */
    public BeanBaseJHardmin(){
        this.loginFail = false;
        //Se limpian las variables asociadas a los inputText para que estos no muestren ningun valor al inicio
        this.setInputUsrName("");
        this.setInputUsrPassword("");
        //Se inicializan las listas asociadas a comboBoxes.
        this.roleList = this.getEntityManager().createNamedQuery("Rol.findAll").getResultList();
        this.userList = this.getEntityManager().createNamedQuery("Usuario.findAll").getResultList();
        this.listaAutorizaciones = this.getEntityManager().createQuery("SELECT a FROM Autorizacion a").getResultList();
        this.listaEstudiantes = this.getEntityManager().createNamedQuery("Estudiante.findAllVisible").getResultList();
        this.listaInstructores = this.getEntityManager().createNamedQuery("Instructor.findAllVisible").getResultList();
        this.listaDocentes = this.getEntityManager().createNamedQuery("Docente.findAllVisible").getResultList();
        this.currentAutorizacion = new Autorizacion();
        this.crdAutorizaciones = new CrudManager();
        this.crdEstudiantes = new CrudManager();
        this.crdInstructores = new CrudManager();
        this.crdDocentes = new CrudManager();
        this.msg = new ActionMessage();
        this.setPopUpAddUserVisible(false);
        this.setPopUpEditUserVisible(false);
        this.setPopUpConfirmDelUserVisible(false);
        this.setPopUpConfirmDelUserMessage("");
        this.newUser = new Usuario();
        this.initSelectItems();
        this.editDelUser = new Usuario();
        this.usuarioRegistrado = new Usuario();
        this.estudianteUsuarioRegistrado = new Estudiante();
        this.currentEstudiante = new Estudiante();
        this.currentInstructor = new Instructor();
        this.currentDocente = new Docente();
    }

    /**
     * Obtiene un usuario de la bas de datos segun su nombre y contraseña encriptada
     * @param userName Nombre del usuario a obtener
     * @param userPwd Clave encriptada del usuario a obtener
     * @return un objeto Usuario correspondiente al nombre y clave recibidos como parametro o null
     */
    public Usuario getUsuario(String userName, String userPwd){
        Usuario u = null;
        EntityManager eMgr = this.getEntityManager();
        System.out.println("nombre: " + userName);
        System.out.println("clave: " + userPwd);
        String strSql = "SELECT u FROM Usuario u WHERE u.nombre = '"+userName+"' AND u.clave = '"+userPwd+"'";
        Query q = eMgr.createQuery(strSql);
        try{                        
            u = (Usuario)q.getSingleResult();            
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
            try{
                u = (Usuario)q.getResultList().get(0);
            }
            catch(Exception innerEx){
                System.out.println(ex.getMessage());
                //pass
            }
        }        
        return u;
    }

    /**
     * Obtiene un usuario de la base de datos en baes a su ID
     * @param id el ID del usuario a obtener de la base
     * @return un objeto usuario correspondiente al ID recibido como parametro o null
     */
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

    /**
     * Realiza la autenticacion de un usuario en el sistema permitiendole, en caso exitoso, tener acceso a secciones del sistema basadas en el rol que este posee
     * @return Una cadena vacia. Para saber el resultado del login verificar el estado de la variable loginFail
     */
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

    /**
     * Termina la sesion del usuario actualmente logueado al sistema.
     * @return Una cadena vacia. Para saber si se termino la sesion exitosamente verificar si la variable currentUser es igual a null
     */
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

    /**
     * Cambia la clave de acceso del usuario actualmente logueado al sistema
     * @return una cadena con la palabra "success" en caso de exito o la palabra "fail" en caso de falla
     */
    public String changePassword(){
        try{
            Usuario usr = LoginManager.getInstance().getUsuario(this.currentUser);
            EntityManager em = this.getEntityManager();
            //Verifica si el valor introducido como claveAnterior, coincide con la clave actual del usuario
            if(usr.getClave().equalsIgnoreCase(LoginManager.getInstance().encrypt(this.getInputChOldPwd()))){
                //Verifica si la nueva clave ingresada coincide con su confirmacion
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

    /**
     * Cierra la popup utilizada para mostrar mensajes genericos en pantalla
     * @return una cadena vacia
     */
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

    /**
     * Muestra el popUp para agregar usuarios. Ademas, inicializa la variable newUser y sus atributos
     * @return la palabra "success" si todo funciono exitosamente
     */
    public String showPopupAddUser(){
        this.setPopUpAddUserVisible(true);
        this.newUser = new Usuario();
        this.newUser.setNombre("");
        this.newUser.setClave("");
        this.setNewUserPwdConfirm("");
        return "success!";
    }

    /**
     * Agrega un nuevo usuario al sistema segun los datos contenidos en la variable newUser.
     * @return la palabra "Done" si todo funciono exitosamente o "fail" en caso contrario
     */
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

    /**
     * Oculta el popUp para agregar usuarios
     * @return la palabra "Done" si todo funciono exitosamente
     */
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

    /**
     * Inicializa la lista de SelectItems para la lista de roles, los cuales tienen valueBinding con un comboBox para poder seleccionar un rol en pantalla y asignarselo a un usuario
     */
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

    /**
     * Muestra el popUp para editar un usuario de la lista de usuarios
     * @returnla palabra "Done" si todo funciono exitosamente
     */
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

   /**
    * Guarda los cambios realizados al usuario actual mostrado en el popUp de editar usuario. Luego, cierra este popUp
    * @return la palabra "done" si todo funciono exitosamente o "fail" en caso contrario
    */
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

   /**
    * Cierra el popUp de editar usuario
    * @return la palabra "done" si todo funciono exitosamente
    */
   public String closePopupEditUsuario(){
       this.setPopUpEditUserVisible(false);
       return "done";
   }

   /**
    * Elimina un usuario de la base de datos
    * @return la palabra "done" si todo funciono exitosamente
    */
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

   /**
    * Muestra un popUp con un mensaje de confirmacion al usuario acerca de la eliminacion de un usuario
    * @return la palabra "done" si todo funciono exitosamente
    */
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

   /**
    * Oculta el popUp de confirmacion de eliminacion del usuario
    * @return la palabra "done" si todo funciono exitosamente
    */
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

    /**
     * Devuelve la cantidad de autorizaciones que posee la lista
     * @return la cantidad de autorizaciones que posee la lista
     */
    public int getListaAutorizacionesSize(){
        return this.listaAutorizaciones.size();
    }

    /**
     * Agrega una nueva autorizacion a la base de datos
     * @return "done" si la operacion fue exitosa
     */
    public String addAutorizacion(){
        EntityManager emgr = this.getEntityManager();
        emgr.getTransaction().begin();
        emgr.persist(this.currentAutorizacion);
        emgr.getTransaction().commit();
        this.listaAutorizaciones.add(this.currentAutorizacion);
        this.crdAutorizaciones.hidePopupAdd();
        this.msg.setText("Nueva autorización agregada satisfactoriamente");
        this.msg.setVisible(true);
        this.currentAutorizacion = new Autorizacion();
        this.currentAutorizacion.setUsuarioCollection(new ArrayList<Usuario>());
        return "done";
    }

    /**
     * Elimina de la base de datos la autorizacion actual
     * @return "done" si la operacion fue exitosa
     */
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
                this.listaAutorizaciones.remove(i);
                break;
            }
        }        
        this.msg.setText("Autorización eliminada satisfactoriamente. Los usuarios creados a partir de esta autorizacion continuaran existiendo en el sistema.");
        this.msg.setVisible(true);
        this.currentAutorizacion = new Autorizacion();
        this.currentAutorizacion.setUsuarioCollection(new ArrayList<Usuario>());
        return "done";
    }

    /**
     * Hace visible el popUp que contiene el formulario para registrar usuarios
     * @return "done" si la operacion fue exitosa
     */
    public String showPopupRegistrarUsuario(){
        this.setPopupRegistrarUsuarioVisible(true);
        return "done";
    }

    /**
     * Hace invisible el popUp que contiene el formulario para registrar usuarios
     * @return "done" si la operacion fue exitosa
     */
    public String hidePopupRegistrarUsuario(){
        this.setPopupRegistrarUsuarioVisible(false);
        return "done";
    }

    /**
     * Agrega un nuevo usuario al sistema en base a un codigo de autorizacion asignandole automaticamente el rol de estudiante
     * @return "done" si la operacion fue exitosa o "fail" en caso contrario
     */
    public String registrarUsuario(){
        EntityManager emgr = this.getEntityManager();
        Rol rolEstudiante = (Rol)emgr.createQuery("SELECT r FROM Rol r WHERE r.idrol=5").getSingleResult();
        this.usuarioRegistrado.setIdrol(rolEstudiante);
        Autorizacion autRegistro = null;
        try{
            autRegistro = (Autorizacion)emgr.createQuery("SELECT a FROM Autorizacion a WHERE a.codigo='" + this.autorizacionUsuario + "'").getSingleResult();            
        }
        catch(Exception ex){
            //pass
        }
        if(autRegistro == null){
            this.hidePopupRegistrarUsuario();
            this.msg.setText("Código de autorización inexistente");
            this.msg.setVisible(true);
            return "fail";
        }
        if(autRegistro.getCantmaxima() == autRegistro.getUsuarioCollection().size()){
            this.hidePopupRegistrarUsuario();
            this.msg.setText("No se pueden crear mas usuarios con este codigo de autorización");
            this.msg.setVisible(true);
            return "fail";
        }
        if(!this.usuarioRegistrado.getClave().equalsIgnoreCase(this.claveUsuarioConfirmacion)){
            this.hidePopupRegistrarUsuario();
            this.msg.setText("Clave no coincide con su confirmación");
            this.msg.setVisible(true);
            return "fail";
        }
        for(Usuario u: this.userList){
            if(u.getNombre().equalsIgnoreCase(this.usuarioRegistrado.getNombre())){
                this.hidePopupRegistrarUsuario();
                this.msg.setText("Ya existe en el sistema un usuario con este nombre");
                this.msg.setVisible(true);
                return "fail";
            }
        }
        autRegistro.getUsuarioCollection().add(this.usuarioRegistrado);
        this.inputUsrName = this.usuarioRegistrado.getNombre();
        this.inputUsrPassword = this.usuarioRegistrado.getClave();

        this.usuarioRegistrado.setClave(LoginManager.getInstance().encrypt(this.usuarioRegistrado.getClave()));
        this.usuarioRegistrado.setIdautorizacion(autRegistro);
        this.usuarioRegistrado.setNombre(this.estudianteUsuarioRegistrado.getCarnet());

        emgr.getTransaction().begin();
        emgr.persist(this.usuarioRegistrado);
        emgr.merge(autRegistro);
        emgr.getTransaction().commit();

        this.usuarioRegistrado.getEstudianteCollection().add(this.estudianteUsuarioRegistrado);
        this.estudianteUsuarioRegistrado.setIdusuario(this.usuarioRegistrado);
        this.estudianteUsuarioRegistrado.setVisible(1);
        emgr.getTransaction().begin();
        emgr.persist(this.estudianteUsuarioRegistrado);
        emgr.merge(this.usuarioRegistrado);
        emgr.getTransaction().commit();
        this.listaEstudiantes.add(this.estudianteUsuarioRegistrado);

        this.hidePopupRegistrarUsuario();
        this.msg.setText("Usuario registrado satisfactoriamente");
        this.msg.setVisible(true);
        for(Autorizacion aut: this.listaAutorizaciones){
            if(aut.getIdautorizacion() == autRegistro.getIdautorizacion()){
                this.usuarioRegistrado.setIdautorizacion(aut);
                aut.getUsuarioCollection().add(this.usuarioRegistrado);                
                break;
            }
        }
        this.userList.add(this.usuarioRegistrado);
        this.login();
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

    /**
     * @return the listaEstudiantes
     */
    public List<Estudiante> getListaEstudiantes() {
        return listaEstudiantes;
    }

    /**
     * @param listaEstudiantes the listaEstudiantes to set
     */
    public void setListaEstudiantes(List<Estudiante> listaEstudiantes) {
        this.listaEstudiantes = listaEstudiantes;
    }

    /**
     * @return the listaInstructores
     */
    public List<Instructor> getListaInstructores() {
        return listaInstructores;
    }

    /**
     * @param listaInstructores the listaInstructores to set
     */
    public void setListaInstructores(List<Instructor> listaInstructores) {
        this.listaInstructores = listaInstructores;
    }

    /**
     * @return the listaDocentes
     */
    public List<Docente> getListaDocentes() {
        return listaDocentes;
    }

    /**
     * @param listaDocentes the listaDocentes to set
     */
    public void setListaDocentes(List<Docente> listaDocentes) {
        this.listaDocentes = listaDocentes;
    }

    /**
     * @return the crdEstudiantes
     */
    public CrudManager getCrdEstudiantes() {
        return crdEstudiantes;
    }

    /**
     * @param crdEstudiantes the crdEstudiantes to set
     */
    public void setCrdEstudiantes(CrudManager crdEstudiantes) {
        this.crdEstudiantes = crdEstudiantes;
    }

    /**
     * @return the crdInstructores
     */
    public CrudManager getCrdInstructores() {
        return crdInstructores;
    }

    /**
     * @param crdInstructores the crdInstructores to set
     */
    public void setCrdInstructores(CrudManager crdInstructores) {
        this.crdInstructores = crdInstructores;
    }

    /**
     * @return the crdDocentes
     */
    public CrudManager getCrdDocentes() {
        return crdDocentes;
    }

    /**
     * @param crdDocentes the crdDocentes to set
     */
    public void setCrdDocentes(CrudManager crdDocentes) {
        this.crdDocentes = crdDocentes;
    }

    /**
     * @return the currentEstudiante
     */
    public Estudiante getCurrentEstudiante() {
        return currentEstudiante;
    }

    /**
     * @param currentEstudiante the currentEstudiante to set
     */
    public void setCurrentEstudiante(Estudiante currentEstudiante) {
        this.currentEstudiante = currentEstudiante;
    }

    /**
     * @return the currentInstructor
     */
    public Instructor getCurrentInstructor() {
        return currentInstructor;
    }

    /**
     * @param currentInstructor the currentInstructor to set
     */
    public void setCurrentInstructor(Instructor currentInstructor) {
        this.currentInstructor = currentInstructor;
    }

    /**
     * @return the currentDocente
     */
    public Docente getCurrentDocente() {
        return currentDocente;
    }

    /**
     * @param currentDocente the currentDocente to set
     */
    public void setCurrentDocente(Docente currentDocente) {
        this.currentDocente = currentDocente;
    }

    /**
     * Devuelve la cantidad de estudiantes que posee la lista
     * @return la cantidad de estudiantes que posee la lista
     */
    public int getSizeListaEstudiantes(){
        return this.listaEstudiantes.size();
    }

    /**
     * Devuelve la cantidad de instructores que posee la lista
     * @return la cantidad de instructores que posee la lista
     */
    public int getSizeListaInstructores(){
        return this.listaInstructores.size();
    }

    /**
     * Devuelve la cantidad de docentes que posee la lista
     * @return la cantidad de docentes que posee la lista
     */
    public int getSizeListaDocentes(){
        return this.listaDocentes.size();
    }

    /**
     * Agrega un nuevo estudiante al sistema, agregando y asociando tambien un nuevo usuario con el rol de estudiante y cuyo nombre y clave son el carnet del estudiante
     * @return "done" si la operacion fue exitosa o "fail" en caso contrario
     */
    public String addEstudiante(){
        EntityManager emgr = this.getEntityManager();
        if(emgr.createQuery("SELECT e FROM Estudiante e WHERE e.carnet='" + this.currentEstudiante.getCarnet() + "'").getResultList().size() > 0){
            this.crdEstudiantes.hidePopupAdd();
            this.msg.setText("Ya existe registrado un estudiante con este carnet.");
            this.msg.setVisible(true);
            this.currentEstudiante = new Estudiante();
            return "fail";
        }

        Rol rolEstudiante = (Rol)emgr.createQuery("SELECT r FROM Rol r WHERE r.idrol=5").getSingleResult();        
        String nombreUsuario = this.currentEstudiante.getCarnet();
        int contador = 1;        
        while(LoginManager.getInstance().existsInBD(nombreUsuario, nombreUsuario)){
            nombreUsuario = this.currentEstudiante.getCarnet() + String.valueOf(contador++);
        }
        Usuario usr = new Usuario();
        usr.setNombre(nombreUsuario);
        usr.setClave(LoginManager.getInstance().encrypt(nombreUsuario));
        usr.setIdrol(rolEstudiante);
        emgr.getTransaction().begin();
        emgr.persist(usr);
        emgr.getTransaction().commit();
        this.userList.add(usr);

        emgr.getTransaction().begin();
        this.currentEstudiante.setIdusuario(usr);
        this.currentEstudiante.setVisible(1);
        emgr.persist(this.currentEstudiante);
        emgr.getTransaction().commit();
        this.crdEstudiantes.hidePopupAdd();
        this.listaEstudiantes.add(this.currentEstudiante);
        this.msg.setText("Nuevo estudiante " + this.currentEstudiante.getNombres() + " agregado satisfactoriamente");
        this.msg.setVisible(true);
        this.currentEstudiante = new Estudiante();
        this.currentEstudiante.setIdusuario(null);
        return "done";
    }

    /**
     * Muestra el popUp con el formulario de editar estudiante, inicializando primeramente el estudiante actualmente seleccionado
     * @return "done" si la operacion fue exitosa
     */
    public String beforeEditEstudiante(){
        String idEstudiante = ((HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest()).getParameter("currentId");
        this.currentEstudiante = (Estudiante)this.getEntityManager().createQuery("SELECT e FROM Estudiante e WHERE e.idestudiante=" + idEstudiante).getSingleResult();
        this.crdEstudiantes.showPopupEdit();
        return "done";
    }

    /**
     * Guarda los cambios del estudiante que estaba siendo editado
     * @return "done" si la operacion fue exitosa
     */
    public String editEstudiante(){
        EntityManager emgr = this.getEntityManager();
        emgr.getTransaction().begin();
        emgr.merge(this.currentEstudiante);
        emgr.getTransaction().commit();
        this.crdEstudiantes.hidePopupEdit();

        for(Estudiante e: this.listaEstudiantes){
            if(e.getIdestudiante() == this.currentEstudiante.getIdestudiante()){
                e.setCarnet(this.currentEstudiante.getCarnet());
                e.setNombres(this.currentEstudiante.getNombres());
                e.setApellidos(this.currentEstudiante.getApellidos());
                break;
            }
        }

        this.msg.setText("Estudiante actualizado satisfactoriamente");
        this.msg.setVisible(true);
        return "done";
    }

    /**
     * Elimina un estudiante de la base de datos, inactivando tambien el usuario asignado a el
     * @return "done" si la operacion fue exitosa
     */
    public String delEstudiante(){
        EntityManager emgr = this.getEntityManager();
        this.currentEstudiante = (Estudiante)emgr.createQuery("SELECT e FROM Estudiante e WHERE e.idestudiante=" + this.crdEstudiantes.getCurrentId()).getSingleResult();
        this.currentEstudiante.setVisible(0);
        emgr.getTransaction().begin();
        emgr.merge(this.currentEstudiante);
        emgr.remove(this.currentEstudiante.getIdusuario());
        emgr.getTransaction().commit();
        this.crdEstudiantes.hidePopupDel();

        for(Estudiante e: this.listaEstudiantes){
            if(e.getIdestudiante() == this.currentEstudiante.getIdestudiante()){
                this.listaEstudiantes.remove(e);
                break;
            }
        }

        for(Usuario u: this.userList){
            if(u.getIdusuario() == this.currentEstudiante.getIdusuario().getIdusuario()){
                this.userList.remove(u);
                break;
            }
        }

        this.msg.setText("Estudiante " + this.currentEstudiante.getNombres() + " " + this.currentEstudiante.getApellidos() + " eliminado satisfactoriamente");
        this.msg.setVisible(true);
        return "done";
    }

    /**
     * Agrega un nuevo instructor al sistema, agregando y asociando tambien un nuevo usuario con el rol de instructor y cuyo nombre y clave son el carnet del instructor
     * @return "done" si la operacion fue exitosa o "fail" en caso contrario
     */
    public String addInstructor(){
        EntityManager emgr = this.getEntityManager();
        if(emgr.createQuery("SELECT i FROM Instructor i WHERE i.carnet='" + this.currentInstructor.getCarnet() + "'").getResultList().size() > 0){
            this.crdInstructores.hidePopupAdd();
            this.msg.setText("Ya existe registrado un instructor con este carnet.");
            this.msg.setVisible(true);
            this.currentInstructor = new Instructor();
            return "fail";
        }

        Rol rolInstructor = (Rol)emgr.createQuery("SELECT r FROM Rol r WHERE r.idrol=6").getSingleResult();
        String nombreUsuario = this.currentInstructor.getCarnet();
        int contador = 1;
        while(LoginManager.getInstance().existsInBD(nombreUsuario, nombreUsuario)){
            nombreUsuario = this.currentInstructor.getCarnet() + String.valueOf(contador++);
        }
        Usuario usr = new Usuario();
        usr.setNombre(nombreUsuario);
        usr.setClave(LoginManager.getInstance().encrypt(nombreUsuario));
        usr.setIdrol(rolInstructor);
        emgr.getTransaction().begin();
        emgr.persist(usr);
        emgr.getTransaction().commit();
        this.userList.add(usr);

        emgr.getTransaction().begin();
        this.currentInstructor.setIdusuario(usr);
        this.currentInstructor.setVisible(1);
        emgr.persist(this.currentInstructor);
        emgr.getTransaction().commit();
        this.crdInstructores.hidePopupAdd();
        this.listaInstructores.add(this.currentInstructor);
        this.msg.setText("Nuevo instructor " + this.currentInstructor.getNombres() + " agregado satisfactoriamente");
        this.msg.setVisible(true);
        this.currentInstructor = new Instructor();
        this.currentInstructor.setIdusuario(null);
        return "done";
    }

    /**
     * Muestra el popUp con el formulario de editar instructor, inicializando primeramente el estudiante actualmente seleccionado
     * @return "done" si la operacion fue exitosa
     */
    public String beforeEditInstructor(){
        String idInstructor = ((HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest()).getParameter("currentId");
        this.currentInstructor = (Instructor)this.getEntityManager().createQuery("SELECT i FROM Instructor i WHERE i.idinstructor=" + idInstructor).getSingleResult();
        this.crdInstructores.showPopupEdit();
        return "done";
    }

    /**
     * Guarda los cambios del instructor que estaba siendo editado
     * @return "done" si la operacion fue exitosa
     */
    public String editInstructor(){
        EntityManager emgr = this.getEntityManager();
        emgr.getTransaction().begin();
        emgr.merge(this.currentInstructor);
        emgr.getTransaction().commit();
        this.crdInstructores.hidePopupEdit();

        for(Instructor i: this.listaInstructores){
            if(i.getIdinstructor() == this.currentInstructor.getIdinstructor()){
                i.setCarnet(this.currentInstructor.getCarnet());
                i.setNombres(this.currentInstructor.getNombres());
                i.setApellidos(this.currentInstructor.getApellidos());
                break;
            }
        }

        this.msg.setText("Instructor actualizado satisfactoriamente");
        this.msg.setVisible(true);
        return "done";
    }

    /**
     * Elimina un instructor de la base de datos, inactivando tambien el usuario asignado a el
     * @return "done" si la operacion fue exitosa
     */
    public String delInstructor(){
        EntityManager emgr = this.getEntityManager();
        this.currentInstructor = (Instructor)emgr.createQuery("SELECT i FROM Instructor i WHERE i.idinstructor=" + this.crdInstructores.getCurrentId()).getSingleResult();
        this.currentInstructor.setVisible(0);
        emgr.getTransaction().begin();
        emgr.merge(this.currentInstructor);
        emgr.remove(this.currentInstructor.getIdusuario());
        emgr.getTransaction().commit();
        this.crdInstructores.hidePopupDel();

        for(Instructor i: this.listaInstructores){
            if(i.getIdinstructor() == this.currentInstructor.getIdinstructor()){
                this.listaInstructores.remove(i);
                break;
            }
        }

        for(Usuario u: this.userList){
            if(u.getIdusuario() == this.currentInstructor.getIdusuario().getIdusuario()){
                this.userList.remove(u);
                break;
            }
        }

        this.msg.setText("Instructor " + this.currentInstructor.getNombres() + " " + this.currentInstructor.getApellidos() + " eliminado satisfactoriamente");
        this.msg.setVisible(true);
        return "done";
    }

    /**
     * Agrega un nuevo docente al sistema, agregando y asociando tambien un nuevo usuario con el rol de docente y cuyo nombre y clave son el primer nombre del docente
     * @return "done" si la operacion fue exitosa o "fail" en caso contrario
     */
    public String addDocente(){
        EntityManager emgr = this.getEntityManager();

        Rol rolDocente = (Rol)emgr.createQuery("SELECT r FROM Rol r WHERE r.idrol=3").getSingleResult();
        String nombreUsuario = this.currentDocente.getNombres().split(" ")[0];
        int contador = 1;
        while(LoginManager.getInstance().existsInBD(nombreUsuario, nombreUsuario)){
            nombreUsuario = this.currentDocente.getNombres().split(" ")[0] + String.valueOf(contador++);
        }
        Usuario usr = new Usuario();
        usr.setNombre(nombreUsuario);
        usr.setClave(LoginManager.getInstance().encrypt(nombreUsuario));
        usr.setIdrol(rolDocente);
        emgr.getTransaction().begin();
        emgr.persist(usr);
        emgr.getTransaction().commit();
        this.userList.add(usr);

        emgr.getTransaction().begin();
        this.currentDocente.setIdusuario(usr);
        this.currentDocente.setVisible(1);
        emgr.persist(this.currentDocente);
        emgr.getTransaction().commit();
        this.crdDocentes.hidePopupAdd();
        this.listaDocentes.add(this.currentDocente);
        this.msg.setText("Nuevo docente " + this.currentDocente.getNombres() + " agregado satisfactoriamente");
        this.msg.setVisible(true);
        this.currentDocente = new Docente();
        this.currentDocente.setIdusuario(null);
        return "done";
    }

    /**
     * Muestra el popUp con el formulario de editar docente, inicializando primeramente el estudiante actualmente seleccionado
     * @return "done" si la operacion fue exitosa
     */
    public String beforeEditDocente(){
        String idDocente = ((HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest()).getParameter("currentId");
        this.currentDocente = (Docente)this.getEntityManager().createQuery("SELECT d FROM Docente d WHERE d.iddocente=" + idDocente).getSingleResult();
        this.crdDocentes.showPopupEdit();
        return "done";
    }

    /**
     * Guarda los cambios del docente que estaba siendo editado
     * @return "done" si la operacion fue exitosa
     */
    public String editDocente(){
        EntityManager emgr = this.getEntityManager();
        emgr.getTransaction().begin();
        emgr.merge(this.currentDocente);
        emgr.getTransaction().commit();
        this.crdDocentes.hidePopupEdit();

        for(Docente d: this.listaDocentes){
            if(d.getIddocente() == this.currentDocente.getIddocente()){
                d.setNombres(this.currentDocente.getNombres());
                d.setApellidos(this.currentDocente.getApellidos());
                break;
            }
        }

        this.msg.setText("Docente actualizado satisfactoriamente");
        this.msg.setVisible(true);
        return "done";
    }

    /**
     * Elimina un docente de la base de datos, inactivando tambien el usuario asignado a el
     * @return "done" si la operacion fue exitosa
     */
    public String delDocente(){
        EntityManager emgr = this.getEntityManager();
        this.currentDocente = (Docente)emgr.createQuery("SELECT d FROM Docente d WHERE d.iddocente=" + this.crdDocentes.getCurrentId()).getSingleResult();
        this.currentDocente.setVisible(0);
        emgr.getTransaction().begin();
        emgr.merge(this.currentDocente);
        emgr.remove(this.currentDocente.getIdusuario());
        emgr.getTransaction().commit();
        this.crdDocentes.hidePopupDel();

        for(Docente d: this.listaDocentes){
            if(d.getIddocente() == this.currentDocente.getIddocente()){
                this.listaDocentes.remove(d);
                break;
            }
        }

        for(Usuario u: this.userList){
            if(u.getIdusuario() == this.currentDocente.getIdusuario().getIdusuario()){
                this.userList.remove(u);
                break;
            }
        }

        this.msg.setText("Docente " + this.currentDocente.getNombres() + " " + this.currentDocente.getApellidos() + " eliminado satisfactoriamente");
        this.msg.setVisible(true);
        return "done";
    }

    /**
     * Devuelve el estudiante asociado al usuario que actualmente se encuentra en sesion
     * @return el estudiante asociado o null en caso que no tenga ninguno
     */
    public Estudiante getEstudianteFromUser(){
        try{
            Usuario usr = (Usuario)this.getEntityManager().createQuery("SELECT u FROM Usuario u WHERE u.idusuario=" + this.currentUser.getUid()).getSingleResult();
            return (Estudiante)usr.getEstudianteCollection().toArray()[0];
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
    }

    /**
     * Devuelve el instructor asociado al usuario que actualmente se encuentra en sesion
     * @return el instructor asociado o null en caso que no tenga ninguno
     */
    public Instructor getInstructorFromUser(){
        try{
            Usuario usr = (Usuario)this.getEntityManager().createQuery("SELECT u FROM Usuario u WHERE u.idusuario=" + this.currentUser.getUid()).getSingleResult();
            return (Instructor)usr.getInstructorCollection().toArray()[0];
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
    }

    /**
     * Devuelve el docente asociado al usuario que actualmente se encuentra en sesion
     * @return el docente asociado o null en caso que no tenga ninguno
     */
    public Docente getDocenteFromUser(){
        try{
            Usuario usr = (Usuario)this.getEntityManager().createQuery("SELECT u FROM Usuario u WHERE u.idusuario=" + this.currentUser.getUid()).getSingleResult();
            return (Docente)usr.getDocenteCollection().toArray()[0];
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
    }

    /**
     * @return the estudianteUsuarioRegistrado
     */
    public Estudiante getEstudianteUsuarioRegistrado() {
        return estudianteUsuarioRegistrado;
    }

    /**
     * @param estudianteUsuarioRegistrado the estudianteUsuarioRegistrado to set
     */
    public void setEstudianteUsuarioRegistrado(Estudiante estudianteUsuarioRegistrado) {
        this.estudianteUsuarioRegistrado = estudianteUsuarioRegistrado;
    }

}
