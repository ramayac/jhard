/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.ues.jhard.beans;

import edu.ues.jhard.jhardmin.LoggedUser;
import edu.ues.jhard.jhardmin.LoginManager;
import edu.ues.jhard.jpa.Rol;
import edu.ues.jhard.jpa.Usuario;
import edu.ues.jhard.util.ActionMessage;
import java.util.List;
import javax.faces.context.FacesContext;
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
    private ActionMessage msg;

    public BeanBaseJHardmin(){
        this.loginFail = false;
        this.setInputUsrName("");
        this.setInputUsrPassword("");
        this.roleList = this.getEntityManager().createNamedQuery("Rol.findAll").getResultList();
        this.userList = this.getEntityManager().createNamedQuery("Usuario.findAll").getResultList();
        this.msg = new ActionMessage();
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
            if(usr.getClave().equalsIgnoreCase(LoginManager.getInstance().encrypt(this.getInputChOldPwd()))){
                if(this.getInputChNewPwd().equalsIgnoreCase(this.getInputChNewPwdConfirm())){                    
                    //this.getEntityManager().merge(usr);
                    //this.getEntityManager().getTransaction().begin();
                    usr = new Usuario(usr.getIdusuario(), usr.getNombre(), LoginManager.getInstance().encrypt(this.getInputChNewPwd()));
                    //usr.setClave(LoginManager.getInstance().encrypt(this.getInputChNewPwd()));
                    this.getEntityManager().merge(usr);
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
}
