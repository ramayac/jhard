<?xml version="1.0" encoding="UTF-8"?>
<!-- 
    Document   : jcanonAdmin
    Created on : 09-jul-2009, 12:16:38
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
                <title>.:: JCanon ::.</title>
                <meta content="" name="keywords"/>
                <meta content="" name="description"/>
                <link href="css/default.css" rel="stylesheet" type="text/css"/>
                <link href="img/favicon.ico" rel="shortcut icon" type="image/x-icon"/>
                <script charset="utf-8" type="text/javascript">
                   var win=null;
                   function calendar(mypage,myname,w,h,scroll,pos)
                   {
                        if(pos=="random"){LeftPosition=(screen.width)?Math.floor(Math.random()*(screen.width-w)):100;TopPosition=(screen.height)?Math.floor(Math.random()*((screen.height-h)-75)):100;}
                        if(pos=="center"){LeftPosition=(screen.width)?(screen.width-w)/2:100;TopPosition=(screen.height)?(screen.height-h)/2:100;}
                        else if((pos!="center") || pos==null){LeftPosition=0;TopPosition=20}
                        settings='width='+w+',height='+h+',top='+TopPosition+',left='+LeftPosition+',scrollbars='+scroll+',location=no,directories=no,status=no,menubar=no,toolbar=no,resizable=no';
                        win=window.open(mypage,myname,settings);
                   }
                </script>

            </head>
            <body id="outputBody1" style="-rave-layout: grid">
                <!--start header -->
                <div id="header">
                    <div id="menu">
                        <ul>
                            <li>
                                <a href="Index.iface">Principal</a>
                            </li>
                            <li>
                                <a href="jrequestUser.iface">Mantenimientos</a>
                            </li>
                            <li>
                                <a href="#">Grupos de Laboratorio</a>
                            </li>
                            <li>
                                <a href="jinvent.jspx">Inventario</a>
                            </li>
                            <li>
                                <a href="#">Wiki y Cursos</a>
                            </li>
                            <li class="current_page_item last">
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
                            <h2 class="title">Mantenimiento de Hardware y Software</h2>
                            <div class="entry">
                                <ice:form id="form1">
                                    <ice:panelGroup id="grupoJCanonAdmin" style="width: 100%; ">
                                        <ice:panelCollapsible expanded="true" id="panelCollapsible1" style="width: 576px; margin-top:0px; margin-bottom:0px;">
                                            <f:facet name="header">
                                                <ice:panelGroup id="panelGroup1" styleClass="">
                                                    <ice:outputText id="outputText1" value="Reservas de Equipo Multimedia"/>
                                                </ice:panelGroup>
                                            </f:facet>
                                            <ice:panelGroup id="grupoContenido" style=" margin-top:0px; margin-bottom:0px; overflow-x: auto;">
                                                <ice:dataTable id="tblListaReservas" rows="10" style="margin-top: 0px; margin-bottom: 0px;"
                                                    title="Lista de Reservas Pendientes" value="#{jcanonAdmin.listaReservasPendientes}" var="reserva">
                                                    <ice:column>
                                                        <f:facet name="header">
                                                            <ice:outputText value="Descripción"/>
                                                        </f:facet>
                                                        <ice:outputText value="#{reserva.descripcion}"/>
                                                    </ice:column>
                                                    <ice:column>
                                                        <f:facet name="header">
                                                            <ice:outputText value="Equipo reservado"/>
                                                        </f:facet>
                                                        <ice:outputText value="#{reserva.idequipoexistente.idhardware.nombre}"/>
                                                    </ice:column>
                                                    <ice:column>
                                                        <f:facet name="header">
                                                            <ice:outputText value="Responsable"/>
                                                        </f:facet>
                                                        <ice:outputText value="#{reserva.iddocente.nombres} #{reserva.iddocente.apellidos}"/>
                                                    </ice:column>
                                                    <ice:column>
                                                        <f:facet name="header">
                                                            <ice:outputText value="Fecha de la reserva"/>
                                                        </f:facet>
                                                        <ice:outputText value="#{reserva.fechaReserva}"/>
                                                    </ice:column>
                                                    <ice:column>
                                                        <f:facet name="header">
                                                            <ice:outputText value="Hora Inicio"/>
                                                        </f:facet>
                                                        <ice:outputText value="#{reserva.horaInicio}"/>
                                                    </ice:column>
                                                    <ice:column>
                                                        <f:facet name="header">
                                                            <ice:outputText value="Hora Fin"/>
                                                        </f:facet>
                                                        <ice:outputText value="#{reserva.horaFinal}"/>
                                                    </ice:column>
                                                    <ice:column>
                                                        <f:facet name="header">
                                                            <ice:outputText value="Estado"/>
                                                        </f:facet>
                                                        <ice:outputText value="#{reserva.idestado.nombre}"/>
                                                    </ice:column>
                                                    <ice:column>
                                                        <ice:commandLink action="#{jcanonAdmin.posponerReserva}" value="Posponer reserva">
                                                            <f:param name="idReserva" value="#{reserva.idreserva}"/>
                                                        </ice:commandLink>
                                                    </ice:column>
                                                    <ice:column>
                                                        <ice:commandLink action="#{jcanonAdmin.modificarEstadoReserva}" value="Cambiar estado">
                                                            <f:param name="idReserva" value="#{reserva.idreserva}"/>
                                                        </ice:commandLink>
                                                    </ice:column>
                                                    <ice:column>
                                                        <ice:commandLink action="#{jcanonAdmin.Eliminar}" value="Eliminar">
                                                            <f:param name="idReserva" value="#{reserva.idreserva}"/>
                                                        </ice:commandLink>
                                                    </ice:column>
                                                </ice:dataTable>
                                                <ice:dataPaginator for="tblListaReservas" id="pgrListaReservas" paginator="true" paginatorMaxPages="4" style="margin: 0px 10px 10px">
                                                    <f:facet name="first">
                                                        <ice:graphicImage style="border:none;" title="First Page" url="./xmlhttp/css/rime/css-images/arrow-first.gif"/>
                                                    </f:facet>
                                                    <f:facet name="previous">
                                                        <ice:graphicImage style="border:none;" title="Prev Page" url="./xmlhttp/css/rime/css-images/arrow-previous.gif"/>
                                                    </f:facet>
                                                    <f:facet name="next">
                                                        <ice:graphicImage style="border:none;" title="Next Page" url="./xmlhttp/css/rime/css-images/arrow-next.gif"/>
                                                    </f:facet>
                                                    <f:facet name="last">
                                                        <ice:graphicImage style="border:none;" title="Last Page" url="./xmlhttp/css/rime/css-images/arrow-last.gif"/>
                                                    </f:facet>
                                                </ice:dataPaginator>
                                                <ice:panelPopup autoCentre="true" binding="#{jcanonAdmin.panelModEstado}" draggable="true" id="panelModEstado"
                                                    modal="true" rendered="#{jcanonAdmin.panelPopup1Bean.showDraggablePanel}"
                                                    style="height: 189px; left: 336px; top: 984px; position: absolute; width: 405px" visible="#{jcanonAdmin.panelPopup1Bean.showModalPanel}">
                                                    <f:facet name="header">
                                                        <ice:panelGrid id="panelGrid1" style="display:block;width:180px;height:20px;">
                                                            <ice:outputText id="outputText2" value="JCanon"/>
                                                        </ice:panelGrid>
                                                    </f:facet>
                                                    <f:facet name="body">
                                                        <ice:panelGroup id="grupoModEstado" style="display: block; height: 134px">
                                                            <ice:outputText binding="#{jcanonAdmin.lblMensajeModEstado}" id="lblMensajeModEstado" value="Coloque el nuevo estado para esta reserva"/>
                                                            <ice:panelGrid columns="6" id="grupoChecks" style="display: block; height: 80px" width="360">
                                                                <ice:outputLabel id="outputLabel1" value="Pendiente"/>
                                                                <ice:selectBooleanCheckbox binding="#{jcanonAdmin.checkPendiente}" id="checkPendiente"
                                                                    partialSubmit="true" value="#{jcanonAdmin.selectBooleanCheckbox1Bean.selectedBoolean}" valueChangeListener="#{jcanonAdmin.checkPendiente_processValueChange}"/>
                                                                <ice:outputLabel id="outputLabel2" value="En Uso"/>
                                                                <ice:selectBooleanCheckbox binding="#{jcanonAdmin.checkUso}" id="checkUso" partialSubmit="true"
                                                                    value="#{jcanonAdmin.selectBooleanCheckbox2Bean.selectedBoolean}" valueChangeListener="#{jcanonAdmin.checkUso_processValueChange}"/>
                                                                <ice:outputLabel id="outputLabel3" value="Despachada"/>
                                                                <ice:selectBooleanCheckbox binding="#{jcanonAdmin.checkDespachada}" id="checkDespachada"
                                                                    partialSubmit="true" value="#{jcanonAdmin.selectBooleanCheckbox3Bean.selectedBoolean}" valueChangeListener="#{jcanonAdmin.checkDespachada_processValueChange}"/>
                                                            </ice:panelGrid>
                                                            <ice:commandButton action="#{jcanonAdmin.btnModEstadoAceptar_action}"
                                                                binding="#{jcanonAdmin.btnModEstadoAceptar}" id="btnModEstadoAceptar" value="Aceptar"/>
                                                            <ice:commandButton action="#{jcanonAdmin.btnModEstadoCancelar_action}"
                                                                binding="#{jcanonAdmin.btnModEstadoCancelar}" id="btnModEstadoCancelar" value="Cancelar"/>
                                                        </ice:panelGroup>
                                                    </f:facet>
                                                    <ice:commandButton id="button2" value="submit"/>
                                                </ice:panelPopup>
                                                <ice:panelPopup autoCentre="true" binding="#{jcanonAdmin.panelMensajes}" draggable="true" id="panelMensajes"
                                                    modal="true" rendered="#{jcanonAdmin.panelPopup2Bean.showDraggablePanel}"
                                                    style="height: 141px; left: 336px; top: 816px; position: absolute; width: 285px" visible="#{jcanonAdmin.panelPopup2Bean.showModalPanel}">
                                                    <f:facet name="header">
                                                        <ice:panelGrid id="panelGrid3" style="display:block;width:180px;height:20px;">
                                                            <ice:outputText id="outputText4" value="JCanon"/>
                                                        </ice:panelGrid>
                                                    </f:facet>
                                                    <f:facet name="body">
                                                        <ice:panelGroup id="grupoMensajes" style="display: block; height: 86px; width: 230px">
                                                            <ice:outputText binding="#{jcanonAdmin.lblMensajes}" id="lblMensajes" value="Mensajes AQUI"/>
                                                            <ice:panelGrid columns="2" id="panelGrid4" style="display: block; height: 79px; width: 180px">
                                                                <ice:commandButton action="#{jcanonAdmin.btnAceptarMensajes_action}"
                                                                    binding="#{jcanonAdmin.btnAceptarMensajes}" id="btnAceptarMensajes" value="Aceptar"/>
                                                                <ice:commandButton binding="#{jcanonAdmin.btnCancelarMensajes}" id="btnCancelarMensajes" value="Cancelar"/>
                                                            </ice:panelGrid>
                                                        </ice:panelGroup>
                                                    </f:facet>
                                                </ice:panelPopup>
                                                <ice:panelPopup autoCentre="true" binding="#{jcanonAdmin.panelPosponer}" draggable="true" id="panelPosponer"
                                                    modal="true" rendered="#{jcanonAdmin.panelPopup1Bean1.showDraggablePanel}"
                                                    style="height: 403px; width: 405px" visible="#{jcanonAdmin.panelPopup1Bean1.showModalPanel}">
                                                    <f:facet name="header">
                                                        <ice:panelGrid id="panelGrid2" style="display:block;width:180px;height:20px;">
                                                            <ice:outputText id="outputText3" value="JCanon"/>
                                                        </ice:panelGrid>
                                                    </f:facet>
                                                    <f:facet name="body">
                                                        <ice:panelGroup id="panelGrid5" style="display: block; height: 326px">
                                                            <ice:outputText binding="#{jcanonAdmin.lblTextMod}" id="lblTextMod" value="Reserva a modificar"/>
                                                            <br/>
                                                            <br/>
                                                            <ice:selectInputDate binding="#{jcanonAdmin.fechaMod}" id="fechaMod"
                                                                style="height:180px; width: 190px" value="#{jcanonAdmin.selectInputDate1Bean.date1}"/>
                                                            <br/>
                                                            <table border="0">
                                                                <tr>
                                                                    <td>
                                                                        <ice:outputLabel id="lblHoraInicio" value="Nueva Hora de Inicio"/>
                                                                    </td>
                                                                    <td>
                                                                        <ice:selectOneMenu binding="#{jcanonAdmin.horaInicioMod}" id="horaInicioMod"
                                                                            partialSubmit="true" valueChangeListener="#{jcanonAdmin.horaInicioMod_processValueChange}">
                                                                            <f:selectItems id="selectOneMenu1selectItems" value="#{jcanonAdmin.horaInicioFake}"/>
                                                                        </ice:selectOneMenu>
                                                                    </td>
                                                                </tr>
                                                                <tr>
                                                                    <td>
                                                                        <ice:outputLabel id="lblHoraFin" value="Nueva Hora de Finalización"/>
                                                                    </td>
                                                                    <td>
                                                                        <ice:selectOneMenu binding="#{jcanonAdmin.horaFinMod}" id="horaFinMod" partialSubmit="true">
                                                                            <f:selectItems id="selectOneMenu2selectItems" value="#{jcanonAdmin.horaFinFake}"/>
                                                                        </ice:selectOneMenu>
                                                                    </td>
                                                                </tr>
                                                            </table>
                                                            <br/>
                                                            <ice:commandButton action="#{jcanonAdmin.btnAceptarMod_action}"
                                                                binding="#{jcanonAdmin.btnAceptarMod}" id="btnAceptarMod" value="Aceptar"/>
                                                            <ice:commandButton action="#{jcanonAdmin.btnCancelarMod_action}"
                                                                binding="#{jcanonAdmin.btnCancelarMod}" id="btnCancelarMod" value="Cancelar"/>
                                                        </ice:panelGroup>
                                                    </f:facet>
                                                </ice:panelPopup>
                                            </ice:panelGroup>
                                        </ice:panelCollapsible>
                                    </ice:panelGroup>
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
                                    <h2>Tareas Comunes</h2>
                                    <ul>
                                        <li>
                                            <ice:commandLink action="#{Redireccion.admin}" rendered="#{JHardminInstance.currentUser != null}" value="Cambiar clave de acceso"/>
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
                                        <li>
                                            <ice:commandLink action="" rendered="#{JHardminInstance.currentUser == null}" value="Solo para usuarios registrados"/>
                                        </li>
                                        <li>
                                            <ice:commandLink action="#{Redireccion.jrequestAdmin}"
                                                rendered="#{JHardminInstance.currentUser.userRole.idrol == 1}" value="Administrar Solicitudes de JRequest"/>
                                        </li>
                                        <li>
                                            <ice:commandLink rendered="#{JHardminInstance.currentUser.userRole.idrol == 1}" onclick="calendar('scheduler.html','mywin','800','600','no','center');" value="Ver calendario de reservas "/>
                                        </li>
                                        <li>
                                            <ice:commandLink action="#{Redireccion.jcanon}" rendered="#{JHardminInstance.currentUser.userRole.idrol == 1}" value="Ir a página principal de JCanon"/>
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
