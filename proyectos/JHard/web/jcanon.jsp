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
                <ice:outputStyle href="./xmlhttp/css/rime/rime.css" id="outputStyle2"/>
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

                    function loadAgain(){
                        scheduler.load("/JHard/reservas");
                    }

                    function refresh(){
                        location.reload(true);
                    }

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
            <body id="outputBody1" onload="init();" style="-rave-layout: grid">
                <!--start header -->
    <jsp:directive.include file="/jspf/menu.jspx"/>
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
                                        <ice:outputLabel id="labelError" rendered="#{JHardminInstance.currentUser == null}"
                                            style="font-size: 14px; font-weight: bold" value="Debe permanecer con sesión activa para realizar una reserva de Equipo Multimedia"/>
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
                                        <ice:panelPopup autoCentre="true" binding="#{jcanon.panelMensajes}" draggable="true" id="panelMensajes" modal="true"
                                            rendered="#{jcanon.renderer}" style="height: 141px; left: 264px; top: 144px; position: absolute; width: 333px;visibility: hidden;visibility: hidden;">
                                            <f:facet name="header">
                                                <ice:panelGrid id="panelGrid1" style="display:block;width:180px;height:20px;">
                                                    <ice:outputText id="lblTitMensajes" value="JCanon"/>
                                                </ice:panelGrid>
                                            </f:facet>
                                            <f:facet name="body">
                                                <ice:panelGrid id="panelGrid2" style="display: block; height: 80px" width="278">
                                                    <ice:outputText binding="#{jcanon.lblMensajes}" id="lblMensajes" value="body text"/>
                                                    <ice:commandButton action="#{jcanon.btnOk_action}" binding="#{jcanon.btnOk}" id="btnOk" onclick="doLoad();" value="Ok"/>
                                                </ice:panelGrid>
                                            </f:facet>
                                        </ice:panelPopup>
                                        <ice:panelPopup visible="#{jcanon.visibleMultimedia}" autoCentre="true" binding="#{jcanon.panelAddMultimedia}" draggable="true" id="panelAddMultimedia"
                                            modal="true" rendered="#{jcanon.rendererMultimedia}" style="height: 334px; left: 264px; top: 240px; position: absolute; width: 334px;visibility: hidden;visibility: hidden;">
                                            <f:facet name="header">
                                                <ice:panelGrid id="panelGrid3" style="display:block;width:180px;height:20px;">
                                                    <ice:outputText id="outputText1" value="JCanon"/>
                                                </ice:panelGrid>
                                            </f:facet>
                                            <f:facet name="body">
                                                <ice:panelGroup id="panelGrid4" style="display: block; height: 278px">
                                                    <ice:outputText id="outputText2" value="Tipo de Equipo a agregar"/>
                                                    <br/>
                                                    <br/>
                                                    <ice:selectOneMenu binding="#{jcanon.comboEqAdd}" id="comboEqAdd" partialSubmit="true" valueChangeListener="#{jcanon.comboEqAdd_processValueChange}">
                                                        <f:selectItems id="selectOneMenu1selectItems3" value="#{jcanon.selectOneMenu1DefaultItems}"/>
                                                    </ice:selectOneMenu>
                                                    <br/>
                                                    <br/>
                                                    <br/>
                                                    <ice:outputLabel id="outputLabel2" value="Tipo de Equipo"/>
                                                    <br/>
                                                    <br/>
                                                    <ice:selectOneMenu binding="#{jcanon.comboTipoEq}" id="comboTipoEq" partialSubmit="true">
                                                        <f:selectItems id="selectOneMenu2selectItems2" value="#{jcanon.equ}"/>
                                                    </ice:selectOneMenu>
                                                    <ice:commandButton binding="#{jcanon.btnAddEQ}" styleClass="btnAccion2" id="btnAddEQ" action="#{jcanon.mostrarAddEq}" value="Agregar Equipo"/>
                                                    <br/>
                                                    <br/>
                                                    <br/>
                                                    <ice:outputLabel id="outputLabel3" value="Código del equipo"/>
                                                    <br/>
                                                    <br/>
                                                    <ice:inputText binding="#{jcanon.txtCodigoExistencia}" id="txtCodigoExistencia"/>
                                                    <br/>
                                                    <br/>
                                                    <br/>
                                                    <ice:commandButton action="#{jcanon.btnAceptarAdd_action}" styleClass="btnAccion2" onclick="doLoad();" binding="#{jcanon.btnAceptarAdd}"
                                                        id="btnAceptarAdd" value="Aceptar"/>
                                                    <ice:commandButton action="#{jcanon.btnCancelarAdd_action}" styleClass="btnAccion2" onclick="doLoad();" binding="#{jcanon.btnCancelarAdd}"
                                                        id="btnCancelarAdd" value="Cancelar"/>
                                                </ice:panelGroup>
                                            </f:facet>
                                        </ice:panelPopup>
                                        <ice:panelPopup id="pupAgregarEquipo" modal="true" autoCentre="true" draggable="true" rendered="#{jcanon.rendererAddEq}">
                                            <f:facet name="header"><ice:outputText value="Agregar nuevo equipo" /></f:facet>
                                            <f:facet name="body">
                                                <ice:panelGroup styleClass="frmElementList" >
                                                    <p>
                                                        <ice:outputLabel id="lblNombreEquipo" for="txtNombreEquipo" value="Nombre:" />
                                                        <ice:inputText id="txtNombreEquipo" value="#{JInventInstance.currentEquipo.nombre}" />
                                                    </p>
                                                    <p>
                                                        <ice:outputLabel id="lblMarcaEquipo" for="cmbMarcaEquipo" value="Marca:" />
                                                        <ice:selectOneListbox id="cmbMarcaEquipo" size="1" value="#{JInventInstance.marcaSelected}">
                                                            <f:selectItems value="#{JInventInstance.listaItemsMarcas}" />
                                                         </ice:selectOneListbox>
                                                    </p>
                                                    <p>
                                                        <ice:outputLabel id="lmlModelo" for="txtModelo" value="Modelo:" />
                                                        <ice:inputText id="txtModelo" value="#{JInventInstance.currentEquipo.modelo}" />
                                                    </p>
                                                    <p>
                                                        <ice:outputLabel id="lblClasificacionEquipo" for="lblValorClasificaiconEquipo" value="Clasificacion:" />
                                                        <ice:outputText id="lblValorClasificacionEquipo" value="#{JInventInstance.currentClasificacion.nombre}" style="font-weight: bold;" />
                                                    </p>
                                                    <p class="actionSection">
                                                        <ice:commandButton id="cmdConfirmAgregarEquipo" value="Agregar" action="#{jcanon.addEqJInvent}" />
                                                        <ice:commandButton id="cmdCancelAgregarEquipo" value="Cancelar" action="#{jcanon.cancelEqJInvent}" />
                                                    </p>
                                                </ice:panelGroup>
                                             </f:facet>
                                        </ice:panelPopup>
                                    </ice:panelGroup>
                                    <ice:panelCollapsible expanded="true" id="panelReservas" rendered="#{JHardminInstance.currentUser != null}" style="width: 600px">
                                        <f:facet name="header">
                                            <ice:panelGroup id="panelGroup1">
                                                <ice:outputText id="lblTitulo2" value="Realizar una nueva reserva"/>
                                            </ice:panelGroup>
                                        </f:facet>
                                        <ice:panelGroup id="grupoReserva" style="height: 680px">
                                            <p>
                                                <h3 styleClass="tituloSeccion">
                                                    <ice:outputLabel id="lblTextUser" value="Solicitante"/>
                                                </h3>
                                                <br/>
                                                <ice:outputLabel binding="#{jcanon.lblUser}" id="lblUser" style="font-weight:bold; "/>
                                            </p>
                                            <p>
                                                <h3 styleClass="tituloSeccion">
                                                    <ice:outputLabel id="lblEq" value="Equipo a reservar"/>
                                                </h3>
                                                <br/>
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
                                                                    <f:selectItems id="selectOneMenu1selectItems" value="#{jcanon.exc}"/>
                                                                </ice:selectOneMenu>
                                                            </td>
                                                            <td>
                                                                <ice:selectOneMenu binding="#{jcanon.comboLaptop}" id="comboLaptop" partialSubmit="true">
                                                                    <f:selectItems id="selectOneMenu2selectItems" value="#{jcanon.exl}"/>
                                                                </ice:selectOneMenu>
                                                            </td>
                                                        </tr>
                                                    </tbody>
                                                </table>
                                            </p>
                                            <p>
                                                <h3>
                                                    <ice:outputLabel id="lblFecha" value="Seleccione una fecha"/>
                                                </h3>
                                                <br/>
                                                <ice:selectInputDate binding="#{jcanon.selectFecha}" id="selectFecha" style="height: 188px; width: 190px" value="#{jcanon.fecha.date1}"/>
                                            </p>
                                            <p>
                                                <h3 styleClass="tituloSeccion">
                                                    <ice:outputLabel id="lblHora1" value="Hora Inicio"/>
                                                </h3>
                                                <ice:selectOneMenu binding="#{jcanon.horaInicio}" id="horaInicio" partialSubmit="true" valueChangeListener="#{jcanon.horaInicio_processValueChange}">
                                                    <f:selectItems id="selectOneMenu1selectItems1" value="#{jcanon.fakeHoraInicio}"/>
                                                </ice:selectOneMenu>
                                                <h3 styleClass="tituloSeccion">
                                                    <ice:outputLabel id="lblHora2" value="Hora Finalización"/>
                                                </h3>
                                                <ice:selectOneMenu binding="#{jcanon.horaFin}" id="horaFin" partialSubmit="true">
                                                    <f:selectItems id="selectOneMenu2selectItems1" value="#{jcanon.fakeHoraFin}"/>
                                                </ice:selectOneMenu>
                                            </p>
                                            <p>
                                                <h3 styleClass="tituloSeccion">
                                                    <ice:outputLabel id="outputLabel1" value="Docente Responsable"/>
                                                </h3>
                                                <ice:selectOneMenu binding="#{jcanon.comboDocente}" id="comboDocente" partialSubmit="true" valueChangeListener="#{jcanon.comboDocente_processValueChange}">
                                                    <f:selectItems id="selectOneMenu1selectItems2" value="#{jcanon.in}"/>
                                                </ice:selectOneMenu>
                                            </p>
                                            <ice:commandButton action="#{jcanon.btnCrearReserva_action}" binding="#{jcanon.btnCrearReserva}"
                                                id="btnCrearReserva" style="width: 250px" styleClass="btnAccion2" value="Crear Reserva"/>
                                        </ice:panelGroup>
                                    </ice:panelCollapsible>
                                    <ice:panelCollapsible expanded="false" id="panelAdmin" rendered="#{JHardminInstance.currentUser.userRole.idrol == 1}" style="width: 600px">
                                        <f:facet name="header">
                                            <ice:panelGroup id="panelGroup3">
                                                <ice:outputText id="lblTitulo3" value="Administración"/>
                                            </ice:panelGroup>
                                        </f:facet>
                                        <ice:panelGroup id="grupoAdmin" style="height: 170px">
                                            <ice:outputLabel id="lblAdmin" style="font-weight:bold; font-size:14px;" value="Panel Administrativo"/>
                                            <br/>
                                            <br/>
                                            <p>
                                                <ice:commandButton action="#{jcanon.addMultimedia}" binding="#{jcanon.btnAgregarMultimedia}"
                                                    id="btnAgregarMultimedia" style="width: 250px" styleClass="btnAccion2" value="Agregar Equipo Multimedia"/>
                                            </p>
                                            <p>
                                                <ice:commandButton action="#{Redireccion.jcanonAdmin}" binding="#{jcanon.btnVerReservas}" id="btnVerReservas"
                                                    style="width: 250px" styleClass="btnAccion2" value="Administrar Reservas de Equipo"/>
                                            </p>
                                            <p>
                                                <ice:commandButton action="" binding="#{jcanon.btnVerSoloReservas}" id="btnVerSoloReservas" style="width: 250px"
                                                    styleClass="btnAccion2" value="Ver Reportes"/>
                                            </p>
                                        </ice:panelGroup>
                                    </ice:panelCollapsible>
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
                                    <ice:commandButton action="#{JHardminInstance.login}" id="btnLogin" onclick="doLoad();" styleClass="btnAccion2" value="Login"/>
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
                                            <ice:commandLink action="#{Redireccion.jcanonAdmin}" rendered="#{JHardminInstance.currentUser.userRole.idrol == 1}" value="Administrar Reserva de Equipo Multimedia"/>
                                        </li>
                                        <li>
                                            <ice:commandLink onclick="calendar('scheduler.html','mywin','800','600','no','center');"
                                                rendered="#{JHardminInstance.currentUser.userRole.idrol == 1}" value="Ver calendario de reservas "/>
                                        </li>
                                        <li>
                                            <ice:commandLink action="" rendered="#{JHardminInstance.currentUser == null}" value="Solo para usuarios registrados"/>
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
