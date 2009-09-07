<?xml version="1.0" encoding="UTF-8"?>
<!-- 
    Document   : jrequestUserSolicitud
    Created on : 16-jun-2009, 20:39:56
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
                <script charset="utf-8" type="text/javascript">
                    function doLoad(){
                        setTimeout( "refresh()", 1*1000 );
                    }

                    function refresh(){
                        window.location = "jrequestUserSolicitud.iface"
                    }
                    </script>
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
                            <h2 class="title">Solicitud de Mantenimiento de Hardware y Software</h2>
                            <div class="entry" style="">
                                <ice:form id="form1" style="">
                                    <div align="right"><img src="img/help.png" onclick="window.open('videos/solicitudMantenimiento.swf','Ayuda','status=no,menubar=no,toolbar=no,location=no,width=900,height=620')"/></div>
                                    <ice:panelGroup rendered="#{JHardminInstance.currentUser == null}">
                                        <jsp:directive.include file="/jspf/nologin.jspx"/>
                                    </ice:panelGroup>
                                    <ice:panelPopup autoCentre="true" binding="#{jrequestUserSolicitud.panelPopup1}" rendered="#{jrequestUserSolicitud.renderPop1}" draggable="true" id="panelPopup1"
                                        modal="true" style="height: 261px; left: 576px; top: 288px; position: absolute; width: 261px;visibility: hidden;visibility: hidden;">
                                        <f:facet name="header">
                                            <ice:panelGrid id="panelGrid1" style="display:block;width:180px;height:20px;">
                                                <ice:outputText id="outputText1" value="Agregar Nuevo Equipo"/>
                                            </ice:panelGrid>
                                        </f:facet>
                                        <f:facet name="body">
                                            <div class="post">
                                            <ice:panelGrid id="panelGrid2" style="display: block; height: 206px; width: 180px">
                                                <ice:outputLabel id="lblNombreEq" value="Nombre de Equipo"/>
                                                <ice:inputText binding="#{jrequestUserSolicitud.txtNombreEq}" id="txtNombreEq"/>
                                                <ice:outputLabel id="lblPropietario" value="Propietario del Equipo"/>
                                                <ice:inputText binding="#{jrequestUserSolicitud.txtPropietario}" id="txtPropietario"/>
                                                <ice:commandButton styleClass="btnAccion2" action="#{jrequestUserSolicitud.btnAgregar_action}"
                                                binding="#{jrequestUserSolicitud.btnAgregar}" onclick="doLoad();" id="btnAgregar" value="Agregar"/>
                                                <ice:commandButton styleClass="btnAccion2" action="#{jrequestUserSolicitud.btnCerrar_action}"
                                                    binding="#{jrequestUserSolicitud.btnCerrar}" id="btnCerrar" value="Cerrar"/>
                                            </ice:panelGrid>
                                            </div>
                                        </f:facet>
                                    </ice:panelPopup>
                                    <ice:panelCollapsible rendered="#{JHardminInstance.currentUser.userRole.idrol == 1}" expanded="true" id="colap" style="width:576px">
                                        <f:facet name="header">
                                            <ice:outputText value="Ingrese una nueva solicitud"/>
                                        </f:facet>
                                        <ice:panelGroup id="grupoSolicitud" rendered="#{JHardminInstance.currentUser != null}" style="">
                                            <h3 styleClass="tituloSeccion">
                                                <ice:outputLabel id="lblNombre" value="Usuario que realiza la petición"/>
                                            </h3>
                                            <br/>
                                            <ice:outputLabel binding="#{jrequestUserSolicitud.lblUsuario}" value="#{JHardminInstance.currentUser.userName}" id="lblUsuario" style="font-size: 14px; font-weight: bold"/>
                                            <br/>
                                            <br/>
                                            <br/>
                                            <h3 styleClass="tituloSeccion">
                                                <ice:outputLabel id="lbldescripcion" value="Descripción"/>
                                            </h3>
                                            <br/>
                                            <ice:inputTextarea binding="#{jrequestUserSolicitud.txtDescripcion}" id="txtDescripcion" style="height: 72px; width: 286px"/>
                                            <br/>
                                            <br/>
                                            <br/>
                                            <h3 styleClass="tituloSeccion">
                                                <ice:outputLabel id="lblEqSimple" value="Nombre Equipo"/>
                                            </h3>
                                            <br/>
                                            <br/>
                                            <ice:selectInputText binding="#{jrequestUserSolicitud.comboEqSimple}" action="#{jrequestUserSolicitud.selectAction}" id="comboEqSimple" partialSubmit="true"
                                            width="276px" rows="5" valueChangeListener="#{jrequestUserSolicitud.comboEqSimple_processValueChange}">
                                                <f:selectItems id="selectOneMenu1selectItems" value="#{jrequestUserSolicitud.eqs}"/>
                                            </ice:selectInputText>
                                            <ice:commandButton action="#{jrequestUserSolicitud.btnAgregarEqSimple_action}"
                                                binding="#{jrequestUserSolicitud.btnAgregarEqSimple}" id="btnAgregarEqSimple" styleClass="btnAccion2" value="Agregar Equipo"/>
                                            <br/>
                                            <br/>
                                            <br/>
                                            <ice:commandButton action="#{jrequestUserSolicitud.btnEnviar_action}" binding="#{jrequestUserSolicitud.btnEnviar}"
                                            id="btnEnviar" styleClass="btnAccion2" style="250px;"  value="Enviar"/>
                                            <br/>
                                            <br/>
                                            <br/>
                                        </ice:panelGroup>
                                    </ice:panelCollapsible>
                                    <ice:panelPopup autoCentre="true" binding="#{jrequestUserSolicitud.panelPopup2}" rendered="#{jrequestUserSolicitud.renderPop2}" draggable="true" id="panelPopup2"
                                        modal="true" style="height: 130px; width: 261px;visibility: hidden;visibility: hidden;">
                                        <f:facet name="header">
                                            <ice:panelGrid id="panelGrid3" style="display:block;width:180px;height:20px;">
                                                <ice:outputText id="outputText2" value="Mensaje"/>
                                            </ice:panelGrid>
                                        </f:facet>
                                        <f:facet name="body">
                                            <div class="post">
                                            <ice:panelGrid id="panelGrid4" style="display: block; height: 80px" width="206">
                                                <ice:outputLabel binding="#{jrequestUserSolicitud.lblEstadoSolicitud}" id="lblEstadoSolicitud" value="Estado de la Solicitud"/>
                                                <ice:commandButton action="#{jrequestUserSolicitud.btnAceptar_action}"
                                                    binding="#{jrequestUserSolicitud.btnAceptar}" id="btnAceptar" value="Aceptar"/>
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
                                <!--login control -->
                                <jsp:directive.include file="/jspf/login.jspx"/>
                                <!--login control -->
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
                    <jsp:directive.include file="/jspf/bottom.jspx"/>
                <!-- end footer -->
            </body>
        </html>
    </f:view>
</jsp:root>
