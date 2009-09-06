<?xml version="1.0" encoding="UTF-8"?>
<!-- 
    Document   : reportes
    Created on : 08-ago-2009, 13:48:14
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
                <title>.::Reportes::.</title>
                <meta content="" name="keywords"/>
                <meta content="" name="description"/>
                <link href="css/default.css" rel="stylesheet" type="text/css"/>
                <link href="img/favicon.ico" rel="shortcut icon" type="image/x-icon"/>
                <link href="feed?opt=2" rel="alternate" title="jHard - Ultimos Articulos" type="application/rss+xml"/>
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
                            <h2 class="title">Reportes de JHard</h2>
                        </div>
                        <ice:form id="formArticulo">
                            <ice:panelGroup rendered="#{JHardminInstance.currentUser == null}">
                                <jsp:directive.include file="/jspf/nologin.jspx"/>
                            </ice:panelGroup>
                            <ice:panelGroup id="panelReportes" rendered="#{JHardminInstance.currentUser != null}" styleClass="entry">
                                <ice:panelCollapsible expanded="false" id="asistenciaAlumnos" style="width: 600px">
                                    <f:facet name="header">
                                        <ice:panelGroup id="panelTitAsistenciaAlumnos">
                                            <ice:outputText id="titAsistenciaAlumnos" value="Asistencia de Alumnos a Prácticas de Laboratorio"/>
                                        </ice:panelGroup>
                                    </f:facet>
                                    <ice:panelGroup id="fechaClase" style="">
                                        <ice:outputLabel id="outputLabel2" value="Nombre de Grupo de practica"/>
                                        <br/>
                                        <ice:selectInputText action="#{reportes.comboClases_action}" binding="#{reportes.comboClases}" id="comboClases"
                                            partialSubmit="true" value="#{reportes.selectOneMenu1Bean.selectedObject}" valueChangeListener="#{reportes.comboClases_processValueChange}">
                                            <f:selectItems id="selectOneMenu1selectItems" value="#{reportes.cur}"/>
                                        </ice:selectInputText>
                                        <br/>
                                        <ice:selectInputDate binding="#{reportes.fechaClases}" id="fechaClases" style="height:212px; width: 190px" value="#{reportes.selectInputDateBean1.date1}"/>
                                        <br/>
                                        <ice:commandButton action="#{reportes.btnAsistenciaAlumno_action}" id="btnAsistenciaAlumno" styleClass="btnAccion2" value="Generar Reporte"/>
                                    </ice:panelGroup>
                                </ice:panelCollapsible>
                                <ice:panelCollapsible expanded="false" id="asistenciaInstructores" style="width: 600px">
                                <f:facet name="header">
                                <ice:panelGroup id="panelTitAsistenciaInstructores">
                                <ice:outputText id="titAsistenciaInstructores" value="Asistencia de Instructores a Prácticas de Laboratorio"/>
                                </ice:panelGroup>
                                </f:facet>
                                <ice:panelGroup id="panelAsistenciaInstructores" style="">
                                <ice:selectInputText action="#{reportes.comboInstructores_action}" binding="#{reportes.comboInstructores}" id="comboInstructores"
                                valueChangeListener="#{reportes.comboInstructores_processValueChange}" width="216">
                                <f:selectItems id="selectInputText99selectedItems" value="#{reportes.ins}"/>
                                </ice:selectInputText>
                                <br/>
                                <ice:commandButton action="#{reportes.btnReportIns_action}" id="btnReportIns"
                                styleClass="btnAccion2" value="Generar Reporte"/>
                                </ice:panelGroup>
                                </ice:panelCollapsible>
                                <ice:panelCollapsible expanded="false" id="bitacoraServicio" style="width: 600px">
                                    <f:facet name="header">
                                        <ice:panelGroup id="panelTitBitacoraServicio">
                                            <ice:outputText id="titBitacoraServicio" value="Bitácoras de Servicio"/>
                                        </ice:panelGroup>
                                    </f:facet>
                                    <ice:panelGroup id="panelBitacoraServicio" style="">
                                        <ice:outputLabel id="etEq" value="Equipos Simples"/>
                                        <ice:selectBooleanCheckbox binding="#{reportes.checkEQ}" id="checkEQ" partialSubmit="true"
                                            value="#{reportes.selectBooleanCheckbox1Bean.selectedBoolean}" valueChangeListener="#{reportes.checkEQ_processValueChange}"/>
                                        <ice:outputLabel id="etLAB" value="LABCOM-1"/>
                                        <ice:selectBooleanCheckbox binding="#{reportes.checkEX}" id="checkEX" partialSubmit="true"
                                            value="#{reportes.selectBooleanCheckbox2Bean.selectedBoolean}" valueChangeListener="#{reportes.checkEX_processValueChange}"/>
                                        <br/>
                                        <br/>
                                        <ice:selectInputText action="#{reportes.txtBit_action}" binding="#{reportes.txtBit}" id="txtBit"
                                            valueChangeListener="#{reportes.txtBit_processValueChange}" width="216">
                                            <f:selectItems id="selectInputText1selectedItems" value="#{reportes.eqs}"/>
                                        </ice:selectInputText>
                                        <br/>
                                        <br/>
                                        <ice:commandButton action="#{reportes.btnReportBit_action}" binding="#{reportes.btnReportBit}" id="btnReportBit"
                                            styleClass="btnAccion2" value="Generar Reporte"/>
                                        <br/>
                                    </ice:panelGroup>
                                </ice:panelCollapsible>
                                <ice:panelCollapsible expanded="false" id="reservaEquipo" style="width: 600px">
                                    <f:facet name="header">
                                        <ice:panelGroup id="panelTitReservaEquipo">
                                            <ice:outputText id="titReservaEquipo" value="Reservas de Equipo Multimedia por Fechas"/>
                                        </ice:panelGroup>
                                    </f:facet>
                                    <ice:panelGroup id="panelReservaEquipo" style="">
                                        <ice:outputLabel id="fechaInicial" value="Fecha Inicial"/>
                                        <br/>
                                        <ice:selectInputDate binding="#{reportes.selectFechaInicial}" id="selectFechaInicial" style="height:212px; width: 190px" value="#{reportes.selectInputDate1Bean.date1}"/>
                                        <br/>
                                        <ice:outputLabel id="fechaFinal" value="Fecha Final"/>
                                        <br/>
                                        <ice:selectInputDate binding="#{reportes.selectFechaFinal}" id="selectFechaFinal" style="height: 212px; width: 190px" value="#{reportes.selectInputDate2Bean.date1}"/>
                                        <br/>
                                        <ice:commandButton action="#{reportes.btnReportReserva_action}" binding="#{reportes.btnReportReserva}"
                                            id="btnReportReserva" styleClass="btnAccion2" value="Generar Reporte"/>
                                    </ice:panelGroup>
                                </ice:panelCollapsible>
                                <ice:panelCollapsible expanded="false" id="reservaEquipoDoc" style="width: 600px">
                                    <f:facet name="header">
                                        <ice:panelGroup id="panelTitReservaEquipoDoc">
                                            <ice:outputText id="titReservaEquipoDoc" value="Reservas de Equipo Multimedia por Docente"/>
                                        </ice:panelGroup>
                                    </f:facet>
                                    <ice:panelGroup id="panelReservaEquipoDoc" style="">
                                        <ice:selectInputText action="#{reportes.txtDocs_action}" binding="#{reportes.txtDocs}" id="txtDocs" valueChangeListener="#{reportes.txtDocs_processValueChange}">
                                            <f:selectItems id="selectInputText1selectedItems1" value="#{reportes.doc}"/>
                                        </ice:selectInputText>
                                        <ice:commandButton action="#{reportes.btnReservaDoc_action}" binding="#{reportes.btnReservaDoc}" id="btnReservaDoc" value="Generar Reporte"/>
                                    </ice:panelGroup>
                                </ice:panelCollapsible>
                                <!--ice:panelCollapsible expanded="false" id="gruposLab" style="width: 600px"-->
                                <!--f:facet name="header"-->
                                <!--ice:panelGroup id="panelTitGruposLab"-->
                                <!--ice:outputText id="titGruposLab" value="Grupos de Laboratorio"/-->
                                <!--/ice:panelGroup-->
                                <!--/f:facet-->
                                <!--ice:panelGroup id="panelGruposLab" style=""/-->
                                <!--/ice:panelCollapsible-->
                                <ice:panelCollapsible expanded="false" id="listadoPiezas" style="width: 600px">
                                    <f:facet name="header">
                                        <ice:panelGroup id="panelTitListadoPiezas">
                                            <ice:outputText id="titListadoPiezas" value="Piezas no asignadas a existencias"/>
                                        </ice:panelGroup>
                                    </f:facet>
                                    <ice:panelGroup id="panelListadoPiezas" style="">
                                        <ice:commandButton action="#{reportes.btnListadoPiezas_action}" binding="#{reportes.btnListadoPiezas}"
                                            id="btnListadoPiezas" styleClass="btnAccion2" value="Generar Reporte"/>
                                    </ice:panelGroup>
                                </ice:panelCollapsible>
                                <ice:panelCollapsible expanded="false" id="listadoAccesorios" style="width: 600px">
                                    <f:facet name="header">
                                        <ice:panelGroup id="panelTitListadoAccesorios">
                                            <ice:outputText id="titListadoAccesorios" value="Accesorios no asignados a existencias"/>
                                        </ice:panelGroup>
                                    </f:facet>
                                    <ice:panelGroup id="panelListadoAccesorios" style="">
                                        <ice:commandButton action="#{reportes.btnListadoAccesorios_action}" binding="#{reportes.btnListadoAccesorios}"
                                            id="btnListadoAccesorios" styleClass="btnAccion2" value="Generar Reporte"/>
                                    </ice:panelGroup>
                                </ice:panelCollapsible>
                                <ice:panelCollapsible expanded="false" id="InventarioBueno" style="width: 600px">
                                    <f:facet name="header">
                                        <ice:panelGroup id="panelTitInventarioBueno">
                                            <ice:outputText id="titInventarioBueno" value="Inventario LABCOM-1"/>
                                        </ice:panelGroup>
                                    </f:facet>
                                    <ice:panelGroup id="panelInventarioBueno" style="">
                                        <ice:commandButton action="#{reportes.btnInventarioBueno_action}" binding="#{reportes.btnInventarioBueno}"
                                            id="btnInventarioBueno" styleClass="btnAccion2" value="Generar Reporte"/>
                                    </ice:panelGroup>
                                </ice:panelCollapsible>
                                <ice:panelCollapsible expanded="false" id="InventarioDeteriorado" style="width: 600px">
                                    <f:facet name="header">
                                        <ice:panelGroup id="panelTitInventarioDeteriorado">
                                            <ice:outputText id="titInventarioDeteriorado" value="Inventario Deteriorado de LABCOM-1"/>
                                        </ice:panelGroup>
                                    </f:facet>
                                    <ice:panelGroup id="panelInventarioDeteriorado" style="">
                                        <ice:commandButton action="#{reportes.btnInventarioMalo_action}" binding="#{reportes.btnInventarioMalo}"
                                            id="btnInventarioMalo" styleClass="btnAccion2" value="Generar Reporte"/>
                                    </ice:panelGroup>
                                </ice:panelCollapsible>
                            </ice:panelGroup>
                        </ice:form>
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
                                    <ice:panelPopup clientOnly="true" draggable="true" modal="true" rendered="#{JHardminInstance.msg.visible}"
                                        styleClass="panelPopup" visible="#{JHardminInstance.msg.visible}">
                                        <f:facet name="header">
                                            <ice:outputText styleClass="popupHeader" value="Mensaje"/>
                                        </f:facet>
                                        <f:facet name="body">
                                            <ice:panelGroup>
                                                <p>
                                                    <ice:outputText styleClass="#{JHardminInstance.msg.type}" value="#{JHardminInstance.msg.text}"/>
                                                </p>
                                                <p class="actionSection">
                                                    <ice:commandButton action="#{JHardminInstance.closePopup}" id="btnCerrar" value="OK"/>
                                                </p>
                                            </ice:panelGroup>
                                        </f:facet>
                                    </ice:panelPopup>
                                    <h2>Tareas Comunes</h2>
                                    <ul>
                                        <li>
                                            <ice:commandLink action="#{Redireccion.admin}" rendered="#{JHardminInstance.currentUser != null}" value="Cambiar clave de acceso"/>
                                        </li>
                                        <li>
                                            <ice:commandLink action="#{Redireccion.reportes}" rendered="#{JHardminInstance.currentUser != null}" value="Ver Reportes de JHard"/>
                                        </li>
                                        <li>
                                            <ice:commandLink action="#{JHardminInstance.showPopupRegistrarUsuario}"
                                                rendered="#{JHardminInstance.currentUser == null}" value="Crear usuario del sistema"/>
                                        </li>
                                    </ul>
                                    <ice:panelPopup draggable="true" id="pupCrearUsuario" modal="true" rendered="#{JHardminInstance.popupRegistrarUsuarioVisible}">
                                        <f:facet name="header">
                                            <ice:outputText value="Agregar nuevo usuario"/>
                                        </f:facet>
                                        <f:facet name="body">
                                            <ice:panelGroup styleClass="frmElementList">
                                                <p>
                                                    <ice:outputLabel for="txtCarnetUsuario" id="lblCarnetUsuario" value="Carnet:"/>
                                                    <ice:inputText id="txtCarnetUsuario" value="#{JHardminInstance.estudianteUsuarioRegistrado.carnet}"/>
                                                </p>
                                                <p>
                                                    <ice:outputLabel for="txtApellidosUsuario" id="lblApellidosUsuario" value="Apellidos:"/>
                                                    <ice:inputText id="txtApellidosUsuario" value="#{JHardminInstance.estudianteUsuarioRegistrado.apellidos}"/>
                                                </p>
                                                <p>
                                                    <ice:outputLabel for="txtNombresUsuario" id="lblNombresUsuario" value="Nombres:"/>
                                                    <ice:inputText id="txtNombresUsuario" value="#{JHardminInstance.estudianteUsuarioRegistrado.nombres}"/>
                                                </p>
                                                <p>
                                                    <ice:outputLabel for="TxtClaveUsuario" id="lblClaveUsuario" value="Clave:"/>
                                                    <ice:inputSecret id="txtClaveUsuario" value="#{JHardminInstance.usuarioRegistrado.clave}"/>
                                                </p>
                                                <p>
                                                    <ice:outputLabel for="txtClaveUsuarioConfirm" id="lblClaveUsuarioConfirm" value="Confirmar clave:"/>
                                                    <ice:inputSecret id="txtClaveUsuarioConfirm" value="#{JHardminInstance.claveUsuarioConfirmacion}"/>
                                                </p>
                                                <p>
                                                    <ice:outputLabel for="txtAutorizacionUsuario" id="lblAutorizacionUsuario" value="Codigo de autorizacion:"/>
                                                    <ice:inputText id="txtAutorizacionUsuario" value="#{JHardminInstance.autorizacionUsuario}"/>
                                                </p>
                                                <p class="actionSection">
                                                    <ice:commandButton action="#{JHardminInstance.registrarUsuario}" id="cmdConfirmRegistrarUsuario" value="Agregar"/>
                                                    <ice:commandButton action="#{JHardminInstance.hidePopupRegistrarUsuario}" id="cmdCancelRegistrarUsuario" value="Cancelar"/>
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
