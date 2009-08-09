<?xml version="1.0" encoding="UTF-8"?>
<!-- 
    Document   : Page1
    Created on : 25-may-2009, 23:02:54
    Author     : Hugol
    Modificado por: Ramayac, para incluir menu y botton jspx.
-->
<jsp:root version="2.0" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:ice="http://www.icesoft.com/icefaces/component" xmlns:jsp="http://java.sun.com/JSP/Page">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
    <f:view>
        <html id="outputHtml1">
            <head id="outputHead1">
                <!--ice:outputStyle href="./resources/stylesheet.css" id="outputStyle1"/-->                
                <ice:outputStyle href="css/stylesheet.css" id="outputStyle1"/>
                <ice:outputStyle href="./xmlhttp/css/rime/rime.css" id="outputStyle2"/>
                <meta content="text/html; charset=utf-8" http-equiv="content-type"/>
                <title>.:: JHard ::.</title>
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
                            <h2 class="title">Página Principal</h2>
                            <div class="entry">
                                <ice:form id="frmMain">                                    
                                    <ice:panelCollapsible expanded="true">
                                        <f:facet name="header"><ice:panelGroup><ice:outputText value="Wiki" /></ice:panelGroup></f:facet>
                                        <ice:panelGroup>
                                            <h3 class="title" style="margin-bottom: 5px;">Últimos 5 artículos del wiki</h3>
                                            <ice:panelSeries id="srsJWiki" var="entrada" value="#{Index.listaUltimasEntradas}">
                                                <ice:panelGroup>
                                                    <div style="margin: 5px 2px;">
                                                        <ice:commandLink value="#{entrada.titulo}" action="#{Redireccion.jWikiUserParam}" styleClass="lnkItemDashboard">
                                                            <f:param name="wikiId" value="#{entrada.idarticulo}" />
                                                        </ice:commandLink>
                                                    </div>
                                                </ice:panelGroup>
                                            </ice:panelSeries>
                                        </ice:panelGroup>                                        
                                    </ice:panelCollapsible>
                                    <ice:panelCollapsible expanded="true" rendered="#{JHardminInstance.currentUser.userRole.idrol == 1}">
                                        <f:facet name="header"><ice:panelGroup><ice:outputText value="Existencias en estado fallido" /></ice:panelGroup></f:facet>
                                        <h3 class="title" style="margin-bottom: 5px;"><ice:outputText value="Existencias del inventario [total: #{Index.listaExistenciasFallidasSize}]" /> <ice:commandLink value="Administrar inventario" action="#{Redireccion.jinvent}" rendered="#{JHardminInstance.currentUser.userRole.idrol == 1}" style="margin-left: 20px;" /></h3>
                                        <ice:panelSeries id="srsJInventExistencias" var="existencia" value="#{Index.listaExistenciasFallidas}">
                                            <ice:panelGroup>
                                                <div style="margin: 5px 2px;">
                                                    <ice:outputText value="#{existencia.codigo} - #{existencia.idhardware.nombre} #{existencia.idhardware.idmarca.nombre} #{existencia.idhardware.modelo}" styleClass="lblItemDashboard" />
                                                </div>
                                            </ice:panelGroup>
                                        </ice:panelSeries>
                                        <h3 class="title" style="margin-bottom: 5px;"><ice:outputText value="Equipos simples [total: #{Index.listaEquiposFallidosSize}]" /><ice:commandLink value="Administrar equipos simples" action="#{Redireccion.jrequestAdministracion}" rendered="#{JHardminInstance.currentUser.userRole.idrol == 1}" style="margin-left: 20px;" /></h3>
                                        <ice:panelSeries id="srsJInventEqSimples" var="eqsimple" value="#{Index.listaEquiposFallidos}">
                                            <ice:panelGroup>
                                                <div style="margin: 5px 2px;">
                                                    <ice:outputText value="#{eqsimple.descripcion} - #{eqsimple.propietario}: #{eqsimple.descUltimaSolicitud}" styleClass="lblItemDashboard" style="width: 500px" />
                                                </div>
                                            </ice:panelGroup>
                                        </ice:panelSeries>
                                    </ice:panelCollapsible>
                                    <ice:panelCollapsible expanded="true" rendered="#{JHardminInstance.currentUser.userRole.idrol == 1}">
                                        <f:facet name="header"><ice:panelGroup><ice:outputText value="Equipos en mantenimiento" /></ice:panelGroup></f:facet>
                                        <h3 class="title" style="margin-bottom: 5px;"><ice:outputText value="Existencias del inventario y equipos simples [total: #{Index.listaExistenciasMantenimientoSize + Index.listaEquiposMantenimientoSize}]" /><ice:commandLink value="Administrar mantenimientos" action="#{Redireccion.jrequestAdmin}" rendered="#{JHardminInstance.currentUser.userRole.idrol == 1}" style="margin-left: 20px;" /></h3>
                                        <ice:panelSeries id="srsJRequestExistencias" var="existencia" value="#{Index.listaExistenciasMantenimiento}">
                                            <ice:panelGroup>
                                                <div style="margin: 5px 2px;">
                                                    <ice:outputText value="#{existencia.codigo} - #{existencia.idhardware.nombre} #{existencia.idhardware.idmarca.nombre} #{existencia.idhardware.modelo}. Tecnico: #{existencia.nombreTecnicoActualMnto}" styleClass="lblItemDashboard" style="width: 500px;" />
                                                </div>
                                            </ice:panelGroup>
                                        </ice:panelSeries>                                        
                                        <ice:panelSeries id="srsJRequestEqSimples" var="eqsimple" value="#{Index.listaEquiposMantenimiento}">
                                            <ice:panelGroup>
                                                <div style="margin: 5px 2px;">
                                                    <ice:outputText value="#{eqsimple.descripcion} - #{eqsimple.propietario}. Tecnico: #{eqsimple.nombreTecnicoActualMnto}" styleClass="lblItemDashboard" style="width: 500px;" />
                                                </div>
                                            </ice:panelGroup>
                                        </ice:panelSeries>
                                    </ice:panelCollapsible>
                                    <ice:panelCollapsible expanded="true">
                                        <f:facet name="header"><ice:panelGroup><ice:outputText value="Reservas para el dia de hoy" /></ice:panelGroup></f:facet>
                                        <ice:panelSeries id="srsJCanon" var="reserva" value="#{Index.listaReservasHoy}">
                                            <ice:panelGroup>
                                                <div style="margin: 5px 2px;">
                                                    <ice:commandLink value="#{reserva.descripcion} desde #{reserva.horaInicio} hasta #{reserva.horaFinal} por #{reserva.idusuario.nombre}" action="#{Redireccion.jcanon}" styleClass="lnkItemDashboard" style="width: 500px;" />
                                                </div>
                                            </ice:panelGroup>
                                        </ice:panelSeries>
                                    </ice:panelCollapsible>
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
                                    <ice:outputText id="lblLoginFail" rendered="#{JHardminInstance.loginFail}" styleClass="errorText" value="Datos incorrectos" effect="Highlight" />
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
                                            <ice:commandLink value="Cambiar clave de acceso" action="#{Redireccion.admin}" rendered="#{JHardminInstance.currentUser != null}"></ice:commandLink>
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
                                            <ice:commandLink action="#{Redireccion.jcanonAdmin}" rendered="#{JHardminInstance.currentUser.userRole.idrol == 1}" value="Administrar Reserva de Equipo Multimedia"/>
                                        </li>
                                        <li>
                                            <ice:commandLink action="#{JHardminInstance.showPopupRegistrarUsuario}" rendered="#{JHardminInstance.currentUser == null}" value="Crear usuario del sistema"/>
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
                    <jsp:directive.include file="/jspf/bottom.jspx"/>
                <!-- end footer -->
            </body>
        </html>
    </f:view>
</jsp:root>
