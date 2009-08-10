<?xml version="1.0" encoding="UTF-8"?>
<!-- 
    Document   : jrequestUser
    Created on : 05-29-2009, 10:56:59 AM
    Author     : hugol 
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
                            <h2 class="title">Mantenimiento de Hardware y Software</h2>
                            <div class="entry">
                                <p class="text">Este es el sitio si requiere Soporte Técnico ya sea en Hardware o Software en la UES-FMOcc</p>
                                <ice:form id="form1">
                                    <ice:panelGroup id="grupo2" style="width: 100%; ">
                                        <ice:panelCollapsible expanded="true" id="panelCollapsible1" style="width: 576px">
                                            <f:facet name="header">
                                                <ice:panelGroup id="panelGroup1" styleClass="">
                                                    <ice:outputText id="outputText1" value="Busquedas JWiki"/>
                                                </ice:panelGroup>
                                            </f:facet>
                                            <ice:panelGroup id="panelGroup13" style="height: 350px">
                                                <p>
                                                    <h3 styleClass="tituloSeccion">
                                                        <ice:outputLabel binding="#{jrequestUser.txtMensajeWiki}" id="txtMensajeWiki" value="Ingrese palabras clave separadas por espacios para realizar una búsqueda de soluciones"/>
                                                    </h3>
                                                    <ice:outputConnectionStatus binding="#{jrequestUser.estatus}" id="estatus" styleClass="actionStatus"/>
                                                    
                                                </p>
                                                <p>
                                                    <ice:inputTextarea binding="#{jrequestUser.txtProblemas}" id="txtProblemas" style="width: 502px"/>
                                                </p>
                                                <p>
                                                    <ice:commandButton action="#{jrequestUser.btnBuscar_action}" binding="#{jrequestUser.btnBuscar}"
                                                        id="btnBuscar" styleClass="btnAccion2" value="Buscar"/>
                                                </p>
                                                <p>
                                                    <ice:dataTable id="tblListaPost" rows="5" style="" title="Lista de Posts"
                                                        value="#{jrequestUser.listaArticulos}" var="art">
                                                        <ice:column>
                                                            <f:facet name="header">
                                                                <ice:outputText value="Nombre"/>
                                                            </f:facet>
                                                            <ice:commandLink action="#{jrequestUser.irWiki}" value="#{art.titulo}">
                                                                    <f:param name="idarticulo" value="#{art.idarticulo}"/>
                                                            </ice:commandLink>

                                                        </ice:column>
                                                    </ice:dataTable>
                                                    <ice:dataPaginator for="tblListaPost" id="pgrListaPosts" paginator="true" style="">
                                                        <f:facet name="first">
                                                            <ice:graphicImage style="border:none;" title="Primera" url="./xmlhttp/css/rime/css-images/arrow-first.gif"/>
                                                        </f:facet>
                                                        <f:facet name="previous">
                                                            <ice:graphicImage style="border:none;" title="Previa" url="./xmlhttp/css/rime/css-images/arrow-previous.gif"/>
                                                        </f:facet>
                                                        <f:facet name="next">
                                                            <ice:graphicImage style="border:none;" title="Siguiente" url="./xmlhttp/css/rime/css-images/arrow-next.gif"/>
                                                        </f:facet>
                                                        <f:facet name="last">
                                                            <ice:graphicImage style="border:none;" title="Última" url="./xmlhttp/css/rime/css-images/arrow-last.gif"/>
                                                        </f:facet>
                                                    </ice:dataPaginator>
                                                </p>
                                            </ice:panelGroup>
                                        </ice:panelCollapsible>
                                        <ice:panelCollapsible id="panelCollapsible2" style="width: 576px">
                                            <f:facet name="header">
                                                <ice:panelGroup id="panelGroup2" styleClass="">
                                                    <ice:outputText id="lblTitulo" value="Envio de Solicitudes de Mantenimiento"/>
                                                </ice:panelGroup>
                                            </f:facet>
                                            <ice:panelGrid id="panelGrid2" style="height: 72px">
                                                <ice:outputLabel id="lblSolicitud" value="En cambio, si desea enviar una solicitud de Mantenimiento, pulse el siguiente botón"/>
                                                <ice:commandButton action="#{jrequestUser.btnSolicitud_action}" binding="#{jrequestUser.btnSolicitud}"
                                                    id="btnSolicitud" styleClass="btnAccion2" value="Enviar Solicitud"/>
                                            </ice:panelGrid>
                                        </ice:panelCollapsible>
                                    </ice:panelGroup>
                                    <ice:panelPopup autoCentre="true" binding="#{jrequestUser.popUpRegister}" draggable="true" id="popUpRegister" modal="true"
                                        rendered="#{jrequestUser.renderer}" style="height: 46; width: 381px" visible="#{jrequestUser.panelPopup1Bean.showModalPanel}">
                                        <f:facet name="header">
                                            <ice:panelGrid id="panelGrid1" style="display: block; height: 20px" width="360">
                                                <ice:outputText id="lblTit" value="Usted no es un usuario registrado"/>
                                            </ice:panelGrid>
                                        </f:facet>
                                        <f:facet name="body">
                                            <div class="post">
                                            <ice:panelGrid id="panelGrid3" style="display: block; height: 80px" width="350">
                                                <ice:outputText id="mensaje" value="Debe registrarse para poder acceder a esta opción"/>
                                                <ice:commandButton action="#{jrequestUser.btnOk_action}" binding="#{jrequestUser.btnOk}" id="btnOk" value="Aceptar"/>
                                            </ice:panelGrid>
                                            </div>
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
                                        <div class="post">
                                        <ice:panelGroup>
                                            <p><ice:outputText value="#{JHardminInstance.msg.text}" styleClass="#{JHardminInstance.msg.type}" /></p>
                                            <p class="actionSection"><ice:commandButton action="#{JHardminInstance.closePopup}" id="btnCerrar" value="OK" /></p>
                                        </ice:panelGroup>
                                        </div>
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
                                            <ice:commandLink action="" rendered="#{JHardminInstance.currentUser == null}" value="Solo para usuarios registrados"/>
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
                                            <div class="post">
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
                                            </div>
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
