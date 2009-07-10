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
                <ice:outputStyle href="./xmlhttp/css/xp/xp.css" id="outputStyle2"/>
                <meta content="text/html; charset=utf-8" http-equiv="content-type"/>
                <title>.:: JRequest ::.</title>
                <meta content="" name="keywords"/>
                <meta content="" name="description"/>
                <link href="css/default.css" rel="stylesheet" type="text/css"/>
                <link href="img/favicon.ico" rel="shortcut icon" type="image/x-icon"/>
            </head>
            <body id="outputBody1" style="-rave-layout: grid">
                <!--start header -->
                <div id="header">
                    <div id="menu">
                        <ul>
                            <li class="current_page_item">
                                <a href="Index.iface">Principal</a>
                            </li>
                            <li>
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
                                <a href="#">Cañones</a>
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
                                                    <ice:outputLabel id="outputLabel2" value="Ingrese palabras clave para realizar una búsqueda de soluciones"/>
                                                </p>
                                                <p>
                                                    <ice:inputTextarea id="txtProblemas" style="width: 300px"/>
                                                </p>
                                                <p>
                                                    <ice:commandButton action="#{jrequestUser.btnBuscar_action}" binding="#{jrequestUser.btnBuscar}"
                                                        id="btnBuscar" value="Buscar"/>
                                                </p>
                                                <p>
                                                    <ice:dataTable id="tblListaPost" rows="5" style="" title="Lista de Posts" value="" var="">
                                                        <ice:column>
                                                            <f:facet name="header">
                                                                <ice:outputText value="Nombre"/>
                                                            </f:facet>
                                                            <ice:commandLink value="Nombre del Post"/>
                                                        </ice:column>
                                                        <ice:column>
                                                            <f:facet name="header">
                                                                <ice:outputText value="Descripción"/>
                                                            </f:facet>
                                                            <ice:outputText value="Descripción del Post"/>
                                                        </ice:column>
                                                    </ice:dataTable>
                                                    <ice:dataPaginator for="tblListaPost" id="pgrListaPosts" paginator="true" style="">
                                                        <f:facet name="first">
                                                            <ice:graphicImage style="border:none;" title="Primera" url="./xmlhttp/css/xp/css-images/arrow-first.gif"/>
                                                        </f:facet>
                                                        <f:facet name="previous">
                                                            <ice:graphicImage style="border:none;" title="Previa" url="./xmlhttp/css/xp/css-images/arrow-previous.gif"/>
                                                        </f:facet>
                                                        <f:facet name="next">
                                                            <ice:graphicImage style="border:none;" title="Siguiente" url="./xmlhttp/css/xp/css-images/arrow-next.gif"/>
                                                        </f:facet>
                                                        <f:facet name="last">
                                                            <ice:graphicImage style="border:none;" title="Última" url="./xmlhttp/css/xp/css-images/arrow-last.gif"/>
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
                                                    id="btnSolicitud" value="Enviar Solicitud"/>
                                            </ice:panelGrid>
                                        </ice:panelCollapsible>
                                    </ice:panelGroup>
                                    <ice:panelPopup autoCentre="true" binding="#{jrequestUser.popUpRegister}" draggable="true" id="popUpRegister" modal="true"
                                        rendered="#{jrequestUser.panelPopup1Bean.showDraggablePanel}" style="height: 46; width: 381px" visible="#{jrequestUser.panelPopup1Bean.showModalPanel}">
                                        <f:facet name="header">
                                            <ice:panelGrid id="panelGrid1" style="display: block; height: 20px" width="360">
                                                <ice:outputText id="lblTit" value="Usted no es un usuario registrado"/>
                                            </ice:panelGrid>
                                        </f:facet>
                                        <f:facet name="body">
                                            <ice:panelGrid id="panelGrid3" style="display: block; height: 80px" width="350">
                                                <ice:outputText id="mensaje" value="Debe registrarse para poder acceder a esta opción"/>
                                                <ice:commandButton action="#{jrequestUser.btnOk_action}" binding="#{jrequestUser.btnOk}" id="btnOk" value="Aceptar"/>
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
                                            <ice:commandLink action="#{Redireccion.admin}" rendered="#{JHardminInstance.currentUser != null}" value="Cambiar clave de acceso"/>
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