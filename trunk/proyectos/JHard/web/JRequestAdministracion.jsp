<?xml version="1.0" encoding="UTF-8"?>
<!-- 
    Document   : jrequestAdminitracion
    Created on : 01-jul-2009, 23:39:20
    Author     : Hugol 
-->
<jsp:root version="2.1" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:ice="http://www.icesoft.com/icefaces/component" xmlns:jsp="http://java.sun.com/JSP/Page">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
    <f:view>
        <html id="outputHtml1">
            <head id="outputHead1">
                <ice:outputStyle href="css/stylesheet.css" id="outputStyle1"/>
                <ice:outputStyle href="./xmlhttp/css/rime/rime.css" id="outputStyle2"/>
                <meta content="text/html; charset=utf-8" http-equiv="content-type"/>
                <title>.:: JRequest ::.</title>
                <meta content="" name="keywords"/>
                <meta content="" name="description"/>
                <link href="css/default.css" rel="stylesheet" type="text/css"/>
                <link href="img/favicon.ico" rel="shortcut icon" type="image/x-icon"/>
            </head>
            <body id="outputBody1" style="-rave-layout: grid">
                <!--start header -->
                    <jsp:directive.include file="/jspf/menu.jspx"/>
                <!-- end header -->
                <!-- start page -->
                <div id="page">
                    <!-- start content -->
                    <div id="content">
                        <div class="post">
                            <h2 class="title">Administracion de JRequest</h2>
                            <div class="entry">
                                <ice:form id="form1" style="">
                                    <ice:panelGroup id="admin" style="width: 100%; ">
                                        <p></p>
                                        <ice:panelCollapsible expanded="true" id="panelCollapsible2" style="width: 520px">
                                            <f:facet name="header">
                                                <ice:panelGroup id="titulo1" styleClass="">
                                                    <ice:outputText id="lblTitulo2" value="Administración de Equipos Simples"/>
                                                </ice:panelGroup>
                                            </f:facet>
                                            <ice:panelGroup id="grupoEqs" style="height: 350px">
                                                <p>
                                                    <h3 styleClass="tituloSeccion"><ice:outputLabel id="tituloMod"  value="Agregue, elimine o modifique Equipos Simples. "/>
                                                    </h3>
                                                </p>
                                                <p>
                                                    <ice:selectOneListbox binding="#{JRequestAdministracion.listaEqS}" id="listaEqS" partialSubmit="true"
                                                        size="10" valueChangeListener="#{JRequestAdministracion.listaEqS_processValueChange}">
                                                            <f:selectItems id="selectOneListbox1selectItems1" value="#{JRequestAdministracion.equipoSimple}"/>
                                                    </ice:selectOneListbox>
                                                </p>
                                                <p>
                                                    <ice:commandButton action="#{JRequestAdministracion.btnAgregarEqS_action}" id="btnAgregarEqS"
                                                    style="width: 150px" styleClass="btnAccion2" value="Agregar Equipo Simple"/>
                                                </p>
                                                <p>
                                                    <ice:commandButton action="#{JRequestAdministracion.btnModEqS_action}" styleClass="btnAccion2" id="btnModEqS" style="width: 150px" value="Modificar Equipo Simple"/>
                                                </p>
                                                <p>
                                                    <ice:commandButton action="#{JRequestAdministracion.btnEliminarEqS_action}" styleClass="btnAccion2" id="btnEliminarEqS"
                                                        style="width: 150px" value="Eliminar Equipo Simple"/>
                                                </p>
                                            </ice:panelGroup>
                                        </ice:panelCollapsible>
                                        <ice:panelCollapsible expanded="true" id="panelCollapsible1" style="width: 520px">
                                            <f:facet name="header">
                                                <ice:panelGroup id="titulo2" styleClass="">
                                                    <ice:outputText id="lblTitulo1" value="Administración de Técnicos"/>
                                                </ice:panelGroup>
                                            </f:facet>
                                            <ice:panelGrid id="grupoTec" style="height: 410px">
                                                <p>
                                                    <h3 styleClass="tituloSeccion">
                                                        <ice:outputText id="lbtTec3232" value="Agregue o elimine Técnicos"/>
                                                    </h3>
                                                </p>
                                                <ice:selectOneListbox binding="#{JRequestAdministracion.listaTecnicos}" id="listaTecnicos" partialSubmit="true"
                                                    size="10" valueChangeListener="#{JRequestAdministracion.listaTecnicos_processValueChange}">
                                                        <f:selectItems id="selectOneListbox1selectItems" value="#{JRequestAdministracion.tec}"/>
                                                </ice:selectOneListbox>
                                                <p><h3 styleClass="tituloSeccion"><ice:outputLabel id="outputLabel10" style="" value="Nombre Completo"/>
                                                <br/>
                                                </h3>
                                                <ice:outputLabel binding="#{JRequestAdministracion.lblNombreTec}" effect="#{jcanon.efecto}" id="lblNombreTec" style="font-size:12px;" value="Nombre del tecnico"/>
                                                </p>
                                                <ice:commandButton action="#{JRequestAdministracion.btnAgregarTec_action}" styleClass="btnAccion2" id="btnAgregarTec"
                                                    style="width: 168px" value="Agregar Nuevo Técnico"/>
                                                <ice:commandButton action="#{JRequestAdministracion.btnEliminarTec_action}" styleClass="btnAccion2" id="btnEliminarTec"
                                                    style="width: 168px" value="Eliminar Técnico"/>
                                            </ice:panelGrid>
                                        </ice:panelCollapsible>
                                    </ice:panelGroup>
                                    <ice:panelPopup autoCentre="true" binding="#{JRequestAdministracion.popUpEqSimple}" draggable="true" id="popUpEqSimple"
                                        style="height: 213px; left: 264px; top: 144px; position: absolute; width: 381px" visible="#{jrequestAdmin.panelPopup3Bean.showModalPanel}">
                                        <f:facet name="header">
                                            <ice:panelGrid id="panelGrid12" style="display:block;width:180px;height:20px;">
                                                <ice:outputText id="lblTitulo3" value="JRequest Equipo Simple"/>
                                            </ice:panelGrid>
                                        </f:facet>
                                        <f:facet name="body">
                                            <ice:panelGrid columns="2" id="panelGrid13" style="display:block;width:180px;height:80px;">
                                                <ice:outputText id="lblNomEq" value="Nombre Equipo Simple"/>
                                                <ice:inputText binding="#{JRequestAdministracion.txtNomEQ}" id="txtNomEQ"/>
                                                <ice:outputLabel id="lblPropietario" value="Propietario del Equipo"/>
                                                <ice:inputText binding="#{JRequestAdministracion.txtPropietarioEQ}" id="txtPropietarioEQ"/>
                                                <ice:outputLabel id="lblEstadoEQ" value="Estado del Equipo"/>
                                                <ice:selectOneMenu binding="#{JRequestAdministracion.comboEstadosEQ}" id="comboEstadosEQ" partialSubmit="true">
                                                    <f:selectItems id="selectOneMenu1selectItems" value="#{JRequestAdministracion.eeq}"/>
                                                </ice:selectOneMenu>
                                                <ice:commandButton action="#{JRequestAdministracion.btnAceptarEQ_action}"
                                                    binding="#{JRequestAdministracion.btnAceptarEQ}" id="btnAceptarEQ" value="Aceptar"/>
                                                <ice:commandButton action="#{JRequestAdministracion.btnCancelarEQ_action}"
                                                    binding="#{JRequestAdministracion.btnCancelarEQ}" id="btnCancelarEQ" value="Cancelar"/>
                                            </ice:panelGrid>
                                        </f:facet>
                                    </ice:panelPopup>
                                    <ice:panelPopup autoCentre="true" binding="#{JRequestAdministracion.popUpAgregarTec}" draggable="true" id="popUpAgregarTec"
                                        modal="true" style="display: block; height: 172px; left: 276px; top: 665px; position: absolute; width: 285px;visibility: hidden;visibility: hidden;">
                                        <f:facet name="header">
                                            <ice:panelGrid id="lblTituloTec" style="display:block;width:180px;height:20px;">
                                                <ice:outputText id="lblTituloAddTecnico" value="Agregar Técnico"/>
                                            </ice:panelGrid>
                                        </f:facet>
                                        <f:facet name="body">
                                            <ice:panelGrid columns="2" id="panelAddTec" style="display: block; height: 134px" width="278">
                                                <ice:outputLabel id="outputLabel7" value="Nombres"/>
                                                <ice:inputText binding="#{JRequestAdministracion.txtNomTec}" id="txtNomTec"/>
                                                <ice:outputLabel id="outputLabel8" value="Apellidos"/>
                                                <ice:inputText binding="#{JRequestAdministracion.txtApeTec}" id="txtApeTec"/>
                                                <ice:commandButton action="#{JRequestAdministracion.btnOkTec_action}"
                                                    binding="#{JRequestAdministracion.btnOkTec}" id="btnOkTec" value="Agregar"/>
                                                <ice:commandButton action="#{JRequestAdministracion.btnCerrarTec_action}"
                                                    binding="#{JRequestAdministracion.btnCerrarTec}" id="btnCerrarTec" value="Cerrar"/>
                                            </ice:panelGrid>
                                        </f:facet>
                                    </ice:panelPopup>
                                    <ice:panelPopup autoCentre="true" binding="#{JRequestAdministracion.popUpMensajes}" draggable="true" id="popUpMensajes"
                                        modal="true" rendered="#{JRequestAdministracion.panelPopup1Bean.showDraggablePanel}" style="height: 46; width: 214px" visible="#{JRequestAdministracion.panelPopup1Bean.showModalPanel}">
                                        <f:facet name="header">
                                            <ice:panelGrid id="tituloMensajes" style="display:block;width:180px;height:20px;">
                                                <ice:outputText id="lblMensajesTitulo" value="JRequest"/>
                                            </ice:panelGrid>
                                        </f:facet>
                                        <f:facet name="body">
                                            <ice:panelGrid id="contenidoMensajes" style="display:block;width:180px;height:80px;">
                                                <ice:outputText binding="#{JRequestAdministracion.lblMensajes}" id="lblMensajes" value="Mensajes"/>
                                                <ice:commandButton action="#{JRequestAdministracion.btnOk_action}" binding="#{JRequestAdministracion.btnOk}"
                                                    id="btnOk" value="OK"/>
                                            </ice:panelGrid>
                                        </f:facet>
                                    </ice:panelPopup>
                                </ice:form>
                            </div>
                        </div>
                    </div>
                    <!-- end content -->
                    <!-- start sidebar -->
                    <div id="sidebar">
                        <ul>
                            <li>
                                <h2>
                                    <ice:outputLabel id="txtUserLogin" value="Sesión"/>
                                </h2>
                                <ice:form id="frmLogin" rendered="#{JHardminInstance.currentUser == null}">
                                    <ice:outputText id="lblLoginFail" rendered="#{JHardminInstance.loginFail}" styleClass="errorText" value="Datos incorrectos"/>
                                    <p>
                                        <ice:outputLabel id="lblUser" value="Usuario:"/>
                                        <ice:inputText id="txtUser" required="true" requiredMessage="El nombre de usuario es requerido" style="width: 120px" value="#{JHardminInstance.inputUsrName}"/>
                                        <h:message for="txtUser" styleClass="errorText"/>
                                    </p>
                                    <p>
                                        <ice:outputLabel id="lblPass" value="Clave:"/>
                                        <ice:inputSecret id="txtPass" required="true" requiredMessage="La clave de acceso es requerida" style="width: 120px" value="#{JHardminInstance.inputUsrPassword}"/>
                                        <h:message for="txtPass" styleClass="errorText"/>
                                    </p>
                                    <ice:commandButton action="#{JHardminInstance.login}" id="btnLogin" styleClass="btnAccion2" value="Login"/>
                                </ice:form>
                                <ice:form id="frmLogout" rendered="#{JHardminInstance.currentUser != null}">
                                    <p>
                                        <ice:outputLabel id="lblBienvenido" value="Bienvenido usuario"/>
                                        <ice:outputLabel id="lblNomUsuario" styleClass="formValue" value="#{JHardminInstance.currentUser.userName}"/>
                                    </p>
                                    <ice:commandButton action="#{JHardminInstance.logout}" id="btnLogout" styleClass="btnAccion2" value="Logout"/>
                                </ice:form>
                            </li>
                            <li>
                                <ice:form id="frmCommonTasks">
                                 <ice:panelPopup styleClass="panelPopup" draggable="true" modal="true" rendered="#{JHardminInstance.msg.visible}" visible="#{JHardminInstance.msg.visible}" clientOnly="true" >
                                    <f:facet name="header" >
                                        <ice:outputText value="Mensaje" styleClass="popupHeader" />
                                    </f:facet>
                                    <f:facet name="body">
                                        <ice:panelGroup>
                                            <p><ice:outputText value="#{JHardminInstance.msg.text}" styleClass="#{JHardminInstance.msg.type}" /></p>
                                            <p class="actionSection"><ice:commandButton action="#{JHardminInstance.closePopup}" id="btnCerrar" value="OK" /></p>
                                        </ice:panelGroup>
                                    </f:facet>
                                    </ice:panelPopup>
                                <h2>Tareas Comunes</h2>
                                <ul>
                                        <li>
                                            <ice:commandLink action="#{JHardminInstance.showPopupRegistrarUsuario}" rendered="#{JHardminInstance.currentUser == null}" value="Crear usuario del sistema"/>
                                        </li>
                                        <li>
                                            <ice:commandLink action="#{Redireccion.admin}" rendered="#{JHardminInstance.currentUser != null}" value="Cambiar clave de acceso"/>
                                        </li>
                                        <li>
                                            <ice:commandLink value="Ver Reportes de JHard" action="#{Redireccion.reportes}" rendered="#{JHardminInstance.currentUser != null}"></ice:commandLink>
                                        </li>
                                        <li>
                                            <ice:commandLink action="#{Redireccion.jrequestAdmin}"
                                                rendered="#{JHardminInstance.currentUser.userRole.idrol == 1}" value="Administrar Solicitudes de JRequest"/>
                                        </li>
                                        <li>
                                            <ice:commandLink action="#{Redireccion.jrequestAdministracion}"
                                                rendered="#{JHardminInstance.currentUser.userRole.idrol == 1}" value="Tareas Administrativas de JRequest"/>
                                        </li>
                                        <li>
                                            <ice:commandLink action="#{Redireccion.jrequestUserSolicitud}" rendered="#{JHardminInstance.currentUser != null}" value="Emitir Solicitud de Soporte Técnico"/>
                                        </li>
                                    </ul>
                                    <ice:panelPopup id="pupCrearUsuario" draggable="true" modal="true" rendered="#{JHardminInstance.popupRegistrarUsuarioVisible}">
                                        <f:facet name="header"><ice:outputText value="Agregar nuevo usuario" /></f:facet>
                                        <f:facet name="body">
                                            <ice:panelGroup styleClass="frmElementList">
                                                <p>
                                                    <ice:outputLabel id="lblCarnetUsuario" for="txtCarnetUsuario" value="Carnet:" />
                                                    <ice:inputText id="txtCarnetUsuario" value="#{JHardminInstance.estudianteUsuarioRegistrado.carnet}" />
                                                </p>
                                                <p>
                                                    <ice:outputLabel id="lblApellidosUsuario" for="txtApellidosUsuario" value="Apellidos:" />
                                                    <ice:inputText id="txtApellidosUsuario" value="#{JHardminInstance.estudianteUsuarioRegistrado.apellidos}" />
                                                </p>
                                                <p>
                                                    <ice:outputLabel id="lblNombresUsuario" for="txtNombresUsuario" value="Nombres:" />
                                                    <ice:inputText id="txtNombresUsuario" value="#{JHardminInstance.estudianteUsuarioRegistrado.nombres}" />
                                                </p>

                                                <p>
                                                    <ice:outputLabel id="lblClaveUsuario" for="TxtClaveUsuario" value="Clave:" />
                                                    <ice:inputSecret id="txtClaveUsuario" value="#{JHardminInstance.usuarioRegistrado.clave}" />
                                                </p>
                                                <p>
                                                    <ice:outputLabel id="lblClaveUsuarioConfirm" for="txtClaveUsuarioConfirm" value="Confirmar clave:" />
                                                    <ice:inputSecret id="txtClaveUsuarioConfirm" value="#{JHardminInstance.claveUsuarioConfirmacion}" />
                                                </p>
                                                <p>
                                                    <ice:outputLabel id="lblAutorizacionUsuario" for="txtAutorizacionUsuario" value="Codigo de autorizacion:" />
                                                    <ice:inputText id="txtAutorizacionUsuario" value="#{JHardminInstance.autorizacionUsuario}" />
                                                </p>
                                                <p class="actionSection">
                                                    <ice:commandButton id="cmdConfirmRegistrarUsuario" value="Agregar" action="#{JHardminInstance.registrarUsuario}" />
                                                    <ice:commandButton id="cmdCancelRegistrarUsuario" value="Cancelar" action="#{JHardminInstance.hidePopupRegistrarUsuario}" />
                                                </p>
                                            </ice:panelGroup>
                                        </f:facet>
                                    </ice:panelPopup>
                                </ice:form>
                            </li>
                        </ul>
                    </div>
                    <!-- end sidebar -->
                    <div style="clear: both;"></div>
                </div>
                <!-- end page -->
                <!-- start footer -->
                <div id="footer">
                    <div id="footer-wrap">
                        <p id="legal" style="line-height: 13px">Universidad de El Salvador Facultad Multidisciplinaria de Occidente <br/>
	Todos los Derechos (C) Reservados - Teléfonos:(503)2449-0349, Fax:(503)2449-0352 Apdo. 1908<br/>
                            <a href="#">Créditos</a> - <a href="http://www.uesocc.edu.sv">Pagina Principal de la UES FMOcc</a>
                        </p>
                    </div>
                </div>
                <!-- end footer -->
            </body>
        </html>
    </f:view>
</jsp:root>