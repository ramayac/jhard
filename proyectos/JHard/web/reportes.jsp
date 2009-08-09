<?xml version="1.0" encoding="UTF-8"?>
<!-- 
    Document   : reportes
    Created on : 08-ago-2009, 13:48:14
    Author     : Hugol 
-->
<jsp:root version="2.1" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:jsp="http://java.sun.com/JSP/Page" xmlns:ice="http://www.icesoft.com/icefaces/component">
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
                <link rel="alternate" type="application/rss+xml" title="jHard - Ultimos Articulos" href="feed?opt=2"/>
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
                        <ice:panelGroup id="panelReportes" styleClass="entry">
                            <ice:panelCollapsible expanded="false" id="asistenciaAlumnos" style="width: 600px">
                                <f:facet name="header">
                                    <ice:panelGroup id="panelTitAsistenciaAlumnos">
                                        <ice:outputText id="titAsistenciaAlumnos" value="Asistencia de Alumnos a Prácticas de Laboratorio"/>
                                     </ice:panelGroup>
                                </f:facet>
                                <ice:panelGroup id="panelAsistenciaAlumnos" style="">
                            
                                </ice:panelGroup>
                            </ice:panelCollapsible>
                            <ice:panelCollapsible expanded="false" id="asistenciaInstructores" style="width: 600px">
                                <f:facet name="header">
                                    <ice:panelGroup id="panelTitAsistenciaInstructores">
                                        <ice:outputText id="titAsistenciaInstructores" value="Asistencia de Instructores a Prácticas de Laboratorio"/>
                                     </ice:panelGroup>
                                </f:facet>
                                <ice:panelGroup id="panelAsistenciaInstructores" style="">
                            
                                </ice:panelGroup>
                            </ice:panelCollapsible>
                            <ice:panelCollapsible expanded="false" id="bitacoraServicio" style="width: 600px">
                                <f:facet name="header">
                                    <ice:panelGroup id="panelTitBitacoraServicio">
                                        <ice:outputText id="titBitacoraServicio" value="Bitácoras de Servicio"/>
                                     </ice:panelGroup>
                                </f:facet>
                                <ice:panelGroup id="panelBitacoraServicio" style="">
                            
                                </ice:panelGroup>
                            </ice:panelCollapsible>
                            <ice:panelCollapsible expanded="false" id="reservaEquipo" style="width: 600px">
                                <f:facet name="header">
                                    <ice:panelGroup id="panelTitReservaEquipo">
                                        <ice:outputText id="titReservaEquipo" value="Reservas de Equipo Multimedia"/>
                                     </ice:panelGroup>
                                </f:facet>
                                <ice:panelGroup id="panelReservaEquipo" style="">
                            
                                </ice:panelGroup>
                            </ice:panelCollapsible>
                            <ice:panelCollapsible expanded="false" id="gruposLab" style="width: 600px">
                                <f:facet name="header">
                                    <ice:panelGroup id="panelTitGruposLab">
                                        <ice:outputText id="titGruposLab" value="Grupos de Laboratorio"/>
                                     </ice:panelGroup>
                                </f:facet>
                                <ice:panelGroup id="panelGruposLab" style="">
                            
                                </ice:panelGroup>
                            </ice:panelCollapsible>
                            <ice:panelCollapsible expanded="false" id="estudiantesByCarrera" style="width: 600px">
                                <f:facet name="header">
                                    <ice:panelGroup id="panelTitEstudiantesByCarrera">
                                        <ice:outputText id="titEstudiantesByCarrera" value="Estudiantes por Carrera en Grupos de Laboratorio"/>
                                     </ice:panelGroup>
                                </f:facet>
                                <ice:panelGroup id="panelEstudiantesByCarrera" style="">

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
                                            <ice:commandLink value="Ver Reportes de JHard" action="#{Redireccion.reportes}" rendered="#{JHardminInstance.currentUser != null}"></ice:commandLink>
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
