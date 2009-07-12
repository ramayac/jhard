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
                <script src="js/js/jquery.js" type="text/javascript"></script>
                <script src="js/js/jquery-ui.js" type="text/javascript"></script>
                <link href="img/favicon.ico" rel="shortcut icon" type="image/x-icon"/>
            </head>
            <body id="outputBody1" style="-rave-layout: grid">
                <!--start header -->
                <div id="header">
                    <div id="menu">
                        <ul>
                            <li>
                                <a href="Index.iface">Principal</a>
                            </li>
                            <li class="current_page_item">
                                <a href="jrequestUser.iface">Mantenimientos</a>
                            </li>
                            <li>
                                <a href="#">Grupos de Laboratorio</a>
                            </li>
                            <li>
                                <a href="#">Inventario</a>
                            </li>
                            <li>
                                <a href="#">Wiki y Cursos</a>
                            </li>
                            <li class="last">
                                <a href="jcanon.iface">Cañones</a>
                            </li>
                        </ul>
                    </div>
                </div>
                <div id="logo">
                    <h1>Laboratorio de Hardware</h1>
                    <h2>Universidad de El Salvador, Facultad Multidisciplinaria de Occidente</h2>
                </div>
                <!-- end header -->
                <!-- start page -->
                <div id="page">
                    <!-- start content -->
                    <div id="content">
                        <div class="post">
                            <h2 class="title">Solicitud de Mantenimiento de Hardware y Software</h2>
                            <div class="entry" style="height: 507px">
                                <ice:form id="form1" style="height: 200px">
                                    <ice:panelPopup autoCentre="true" binding="#{jrequestUserSolicitud.panelPopup1}" draggable="true" id="panelPopup1"
                                        modal="true" rendered="#{jrequestUserSolicitud.panelPopup1Bean.showDraggablePanel}"
                                        style="height: 261px; left: 576px; top: 288px; position: absolute; width: 261px" visible="#{jrequestUserSolicitud.panelPopup1Bean.showModalPanel}">
                                        <f:facet name="header">
                                            <ice:panelGrid id="panelGrid1" style="display:block;width:180px;height:20px;">
                                                <ice:outputText id="outputText1" value="Agregar Nuevo Equipo"/>
                                            </ice:panelGrid>
                                        </f:facet>
                                        <f:facet name="body">
                                            <ice:panelGrid id="panelGrid2" style="display: block; height: 206px; width: 180px">
                                                <ice:outputLabel id="lblNombreEq" value="Nombre de Equipo"/>
                                                <ice:inputText binding="#{jrequestUserSolicitud.txtNombreEq}" id="txtNombreEq"/>
                                                <ice:outputLabel id="lblPropietario" value="Propietario del Equipo"/>
                                                <ice:inputText binding="#{jrequestUserSolicitud.txtPropietario}" id="txtPropietario"/>
                                                <ice:outputLabel id="lblEstadoEq" value="Estado del Equipo"/>
                                                <ice:selectOneMenu binding="#{jrequestUserSolicitud.comboEstados}" id="comboEstados" partialSubmit="true">
                                                    <f:selectItems id="selectOneMenu1selectItems1" value="#{jrequestUserSolicitud.arrayEstados.options['idestado,nombre']}"/>
                                                </ice:selectOneMenu>
                                                <ice:commandButton action="#{jrequestUserSolicitud.btnAgregar_action}"
                                                    binding="#{jrequestUserSolicitud.btnAgregar}" id="btnAgregar" value="Agregar"/>
                                                <ice:commandButton action="#{jrequestUserSolicitud.btnCerrar_action}"
                                                    binding="#{jrequestUserSolicitud.btnCerrar}" id="btnCerrar" value="Cerrar"/>
                                            </ice:panelGrid>
                                        </f:facet>
                                    </ice:panelPopup>
                                    <ice:outputLabel id="labelError" style="font-size: 14px; font-weight: bold" value="Debe de permanecer con sesión activa para realizar una petición de Soporte técnico" rendered="#{JHardminInstance.currentUser == null}"></ice:outputLabel>
                                    <ice:panelCollapsible id="colap" style="width:576" expanded="true">
                                <f:facet name="header">
                                    <ice:outputText value="Ingrese una nueva solicitud"/>
                                </f:facet>
                                    <ice:panelGroup id="grupoSolicitud" rendered="#{JHardminInstance.currentUser != null}" style="height:400px;">

                                    <h3 styleClass="tituloSeccion"><ice:outputLabel id="lblNombre" value="Usuario que realiza la petición"/>
                                    </h3><br/>
                                    <ice:outputLabel binding="#{jrequestUserSolicitud.lblUsuario}" id="lblUsuario" style="font-size: 14px; font-weight: bold"/>
                                    <br/>
                                    <br/>
                                    <br/>
                                    <h3 styleClass="tituloSeccion"><ice:outputLabel id="lbldescripcion" value="Descripción"/>
                                    </h3>><br/>
                                    <ice:inputTextarea binding="#{jrequestUserSolicitud.txtDescripcion}" id="txtDescripcion" style="height: 72px; width: 286px"/>
                                    <br/>
                                    <br/>
                                    <br/>
                                    <h3 styleClass="tituloSeccion"><ice:outputLabel id="lblEqSimple" value="Nombre Equipo"/>
                                    </h3><br/>
                                    <br/>
                                    <ice:selectOneMenu binding="#{jrequestUserSolicitud.comboEqSimple}" id="comboEqSimple" partialSubmit="true"
                                        style="width: 286px" valueChangeListener="#{jrequestUserSolicitud.comboEqSimple_processValueChange}">
                                        <f:selectItems id="selectOneMenu1selectItems" value="#{jrequestUserSolicitud.arrayEqSimple.options['idEquipoSimple,descripcion']}"/>
                                    </ice:selectOneMenu>
                                    <ice:commandButton action="#{jrequestUserSolicitud.btnAgregarEqSimple_action}"
                                    binding="#{jrequestUserSolicitud.btnAgregarEqSimple}" styleClass="btnAccion2" id="btnAgregarEqSimple" value="Agregar Equipo"/>
                                    <br/>
                                    <br/>
                                    <br/>
                                    <ice:commandButton action="#{jrequestUserSolicitud.btnEnviar_action}" binding="#{jrequestUserSolicitud.btnEnviar}"
                                    id="btnEnviar" styleClass="btnAccion2" value="Enviar"/>
                                    <br/>
                                    <br/>
                                    <br/>
                                    </ice:panelGroup>
                                </ice:panelCollapsible>
                                    
                                    <ice:panelPopup autoCentre="true" binding="#{jrequestUserSolicitud.panelPopup2}" draggable="true" id="panelPopup2"
                                        modal="true" rendered="#{jrequestUserSolicitud.panelPopup2Bean.showDraggablePanel}" style="height: 130px; width: 261px" visible="#{jrequestUserSolicitud.panelPopup2Bean.showModalPanel}">
                                        <f:facet name="header">
                                            <ice:panelGrid id="panelGrid3" style="display:block;width:180px;height:20px;">
                                                <ice:outputText id="outputText2" value="JRequest"/>
                                            </ice:panelGrid>
                                        </f:facet>
                                        <f:facet name="body">
                                            <ice:panelGrid id="panelGrid4" style="display: block; height: 80px" width="206">
                                                <ice:outputLabel binding="#{jrequestUserSolicitud.lblEstadoSolicitud}" id="lblEstadoSolicitud" value="Estado de la Solicitud"/>
                                                <ice:commandButton action="#{jrequestUserSolicitud.btnAceptar_action}"
                                                    binding="#{jrequestUserSolicitud.btnAceptar}" id="btnAceptar" value="Aceptar"/>
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
                            <li id="search">
                                <h2>Búsqueda Wiki</h2>
                                <form action="" method="get">
                                    <fieldset>
                                        <input class="inputTexto" name="s" type="text" value=""/>
                                        <input class="inputBoton" type="submit" value="Buscar"/>
                                    </fieldset>
                                </form>
                            </li>
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
                                    <ice:commandButton action="#{JHardminInstance.login}" id="btnLogin" styleClass="btnAccion" value="Login"/>
                                </ice:form>
                                <ice:form id="frmLogout" rendered="#{JHardminInstance.currentUser != null}">
                                    <p>
                                        <ice:outputLabel id="lblBienvenido" value="Bienvenido usuario"/>
                                        <ice:outputLabel id="lblNomUsuario" styleClass="formValue" value="#{JHardminInstance.currentUser.userName}"/>
                                    </p>
                                    <ice:commandButton action="#{JHardminInstance.logout}" id="btnLogout" styleClass="btnAccion" value="Logout"/>
                                </ice:form>
                            </li>
                            <li>
                                <ice:form id="frmCommonTasks">
                                <h2>Tareas Comunes</h2>
                                    <ul>
                                        <li>
                                            <ice:commandLink value="Cambiar clave de acceso" action="#{Redireccion.admin}" rendered="#{JHardminInstance.currentUser != null}"  />
                                        </li>
                                        <li>
                                            <ice:commandLink value="Administrar Solicitudes de JRequest" action="#{Redireccion.jrequestAdmin}" rendered="#{JHardminInstance.currentUser.userRole.idrol == 1}"  />
                                        </li>
                                        <li>
                                            <ice:commandLink value="Tareas Administrativas de JRequest" action="#{Redireccion.jrequestAdministracion}" rendered="#{JHardminInstance.currentUser.userRole.idrol == 1}"></ice:commandLink>
                                        </li>
                                        <li>
                                            <ice:commandLink value="Emitir Solicitud de Soporte Técnico" action="#{Redireccion.jrequestUserSolicitud}" rendered="#{JHardminInstance.currentUser != null}"></ice:commandLink>
                                        </li>
                                        <li>
                                            <a href="#">Otras Opciones</a>
                                        </li>
                                        <li>
                                            <a href="#">Otras Opciones</a>
                                        </li>
                                        <li>
                                            <a href="#">Otras Opciones</a>
                                        </li>
                                    </ul>
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
