<?xml version="1.0" encoding="UTF-8"?>
<!-- 
    Document   : jcanon
    Created on : 29-jun-2009, 1:15:10
    Author     : Hugol 
-->
<jsp:root version="2.1" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:ice="http://www.icesoft.com/icefaces/component" xmlns:jsp="http://java.sun.com/JSP/Page">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
    <f:view>
        <html id="outputHtml1">
            <head id="outputHead1">
                <ice:outputStyle href="css/stylesheet.css" id="outputStyle1"/>
                <ice:outputStyle href="./xmlhttp/css/xp/xp.css" id="outputStyle2"/>
                <meta content="text/html; charset=utf-8" http-equiv="content-type"/>
                <title>.:: JCanon ::.</title>
                <meta content="" name="keywords"/>
                <meta content="" name="description"/>
                <link href="css/defaultJCanon.css" rel="stylesheet" type="text/css"/>
                <link href="img/favicon.ico" rel="shortcut icon" type="image/x-icon"/>
                <!--Scheduler-->
                <script charset="utf-8" src="js/dhtmlxscheduler.js" type="text/javascript"></script>
                <link charset="utf-8" href="js/dhtmlxscheduler.css" media="screen" rel="stylesheet" title="no title" type="text/css"/>
                <script charset="utf-8" type="text/javascript">
                    function init() {

                    scheduler.config.xml_date="%Y-%m-%d %H:%i";
                    scheduler.init('scheduler_here',null,"week");
                    scheduler.load("/JHard/reservas");

                    }

                    function doLoad(){
                        setTimeout( "refresh()", 1*1000 );

                    }

                    function refresh(){
                        location.reload(true);
                    }
                </script>
            </head>
            <body id="outputBody1" onload="init();" style="-rave-layout: grid">
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
                            <h2 class="title">Reserva de Equipo Multimedia</h2>
                            <ice:form id="jCanon">
                                <ice:panelGroup id="grupo1" style="margin:0px;" styleClass="entry">
                                    <ice:panelGroup id="grupoReservaScheduler" style="height: 450px; width: 800px" visible="true">
                                        <div class="dhx_cal_container" id="scheduler_here" style="position: absolute; width:71%; height:74%;">
                                            <div class="dhx_cal_navline">
                                                <div class="dhx_cal_prev_button"></div>
                                                <div class="dhx_cal_next_button"></div>
                                                <div class="dhx_cal_today_button"></div>
                                                <div class="dhx_cal_date"></div>
                                                <div class="dhx_cal_tab" name="day_tab" style="right:204px;"></div>
                                                <div class="dhx_cal_tab" name="week_tab" style="right:140px;"></div>
                                                <div class="dhx_cal_tab" name="month_tab" style="right:76px;"></div>
                                            </div>
                                            <div class="dhx_cal_header"></div>
                                            <div class="dhx_cal_data"></div>
                                        </div>
                                    </ice:panelGroup>
                                    <ice:panelCollapsible expanded="true" id="panelReservas" rendered="#{JHardminInstance.currentUser != null}" style="width: 600px">
                                        <f:facet name="header">
                                            <ice:panelGroup id="panelGroup1">
                                                <ice:outputText id="lblTitulo2" value="Realizar una nueva reserva"/>
                                            </ice:panelGroup>
                                        </f:facet>
                                        <ice:panelGroup id="grupoReserva" style="height: 750px">
                                            <p>
                                                <ice:outputLabel id="lblTextUser" style="font-weight:bold; font-size:14px; " value="Solicitante"/>
                                                <br/>
                                                <ice:outputLabel binding="#{jcanon.lblUser}" id="lblUser" style="font-weight:bold; "/>
                                            </p>
                                            <p>
                                                <ice:outputLabel id="outputLabel2" style="font-weight:bold; font-size:14px; " value="Responsable"/>
                                            </p>
                                            <p>
                                                <ice:outputLabel id="lblSolicitanteNombre" value="Nombres:   "/>
                                                <ice:inputText binding="#{jcanon.txtSolicitante}" id="txtSolicitante"/>
                                            </p>
                                            <p>
                                                <ice:outputLabel id="lblSolicitanteApellido" value="Apellidos:  "/>
                                                <ice:inputText binding="#{jcanon.txtSolicitanteApellidos}" id="txtSolicitanteApellidos"/>
                                            </p>
                                            <p>
                                                <table border="1" id="tabla">
                                                    <thead>
                                                        <tr>
                                                            <th>Cañones</th>
                                                            <th>Laptops</th>
                                                        </tr>
                                                    </thead>
                                                    <tbody>
                                                        <tr>
                                                            <td>Reservar Cañon   <ice:selectBooleanCheckbox binding="#{jcanon.checkCan}" id="checkCan"
                                                                    partialSubmit="true" value="#{jcanon.fakeCan.selectedBoolean}" valueChangeListener="#{jcanon.checkCan_processValueChange}"/>
                                                            </td>
                                                            <td>Reservar Laptop  <ice:selectBooleanCheckbox binding="#{jcanon.checkLaptop}" id="checkLaptop"
                                                                    partialSubmit="true" value="#{jcanon.fakeLaptop.selectedBoolean}" valueChangeListener="#{jcanon.checkLaptop_processValueChange}"/>
                                                            </td>
                                                        </tr>
                                                        <tr>
                                                            <td>
                                                                <ice:selectOneMenu binding="#{jcanon.comboCan}" id="comboCan" partialSubmit="true">
                                                                    <f:selectItems id="selectOneMenu1selectItems" value="#{jcanon.fakeCCan}"/>
                                                                </ice:selectOneMenu>
                                                            </td>
                                                            <td>
                                                                <ice:selectOneMenu binding="#{jcanon.comboLaptop}" id="comboLaptop" partialSubmit="true">
                                                                    <f:selectItems id="selectOneMenu2selectItems" value="#{jcanon.fakeCLaptop}"/>
                                                                </ice:selectOneMenu>
                                                            </td>
                                                        </tr>
                                                    </tbody>
                                                </table>
                                            </p>
                                            <p>
                                                <ice:outputLabel id="lblFecha" style="font-weight:bold; font-size:14px; " value="Seleccione una fecha"/>
                                                <br/>
                                                <ice:selectInputDate binding="#{jcanon.selectFecha}" id="selectFecha" style="height: 188px; width: 190px" value="#{jcanon.fecha.date1}"/>
                                            </p>
                                            <p>
                                                <ice:outputLabel id="lblHora1" value="Hora Inicio"/>
                                                <ice:selectOneMenu binding="#{jcanon.horaInicio}" id="horaInicio" partialSubmit="true" valueChangeListener="#{jcanon.horaInicio_processValueChange}">
                                                    <f:selectItems id="selectOneMenu1selectItems1" value="#{jcanon.fakeHoraInicio}"/>
                                                </ice:selectOneMenu>
                                                <ice:outputLabel id="lblHora2" value="Hora Finalización"/>
                                                <ice:selectOneMenu binding="#{jcanon.horaFin}" id="horaFin" partialSubmit="true">
                                                    <f:selectItems id="selectOneMenu2selectItems1" value="#{jcanon.fakeHoraFin}"/>
                                                </ice:selectOneMenu>
                                            </p>
                                            <p>
                                                <ice:outputLabel id="outputLabel1" value="Docente Responsable"/>
                                                <ice:selectOneMenu binding="#{jcanon.comboDocente}" id="comboDocente" partialSubmit="true" valueChangeListener="#{jcanon.comboDocente_processValueChange}">
                                                    <f:selectItems id="selectOneMenu1selectItems2" value="#{jcanon.fakeDocente}"/>
                                                </ice:selectOneMenu>
                                            </p>
                                            <ice:commandButton action="#{jcanon.btnCrearReserva_action}" binding="#{jcanon.btnCrearReserva}"
                                                id="btnCrearReserva" value="Crear Reserva"/>
                                        </ice:panelGroup>
                                    </ice:panelCollapsible>
                                    <ice:panelCollapsible expanded="true" id="panelAdmin" rendered="#{JHardminInstance.currentUser != null}" style="width: 600px">
                                        <f:facet name="header">
                                            <ice:panelGroup id="panelGroup3">
                                                <ice:outputText id="lblTitulo3" value="Administración"/>
                                            </ice:panelGroup>
                                        </f:facet>
                                        <ice:panelGroup id="grupoAdmin" style="height: 100px">
                                            <ice:outputLabel id="lblAdmin" value="Panel Administrativo"/>
                                            <ice:commandButton binding="#{jcanon.btnAgregarMultimedia}" id="btnAgregarMultimedia" value="Agregar Equipo Multimedia"/>
                                            <ice:commandButton binding="#{jcanon.btnVerReservas}" id="btnVerReservas" value="Ver Reservas"/>
                                        </ice:panelGroup>
                                    </ice:panelCollapsible>
                                    <ice:outputLabel id="labelError" rendered="#{JHardminInstance.currentUser == null}"
                                        style="font-size: 14px; font-weight: bold" value="Debe de permanecer con sesión activa para realizar una reserva de Equipo Multimedia"/>
                                </ice:panelGroup>
                            </ice:form>
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
                                    <ice:commandButton action="#{JHardminInstance.login}" id="btnLogin" onclick="doLoad();" styleClass="btnAccion" value="Login"/>
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
                                            <a href="#">Magna lacus bibendum mauris</a>
                                        </li>
                                        <li>
                                            <a href="#">Velit semper nisi molestie</a>
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
