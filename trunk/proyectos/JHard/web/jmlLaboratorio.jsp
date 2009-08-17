<?xml version="1.0" encoding="UTF-8"?>
<!-- 
    Document   : jmlLaboratorio
    Created on : 08-02-2009, 02:19:12 PM
    Author     : rodrigo 
-->
<jsp:root version="2.1" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:ice="http://www.icesoft.com/icefaces/component" xmlns:jsp="http://java.sun.com/JSP/Page">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
    <f:view>
        <html id="outputHtml1">
            <head id="outputHead1">
                <ice:outputStyle href="css/stylesheet.css" id="outputStyle1"/>
                <ice:outputStyle href="./xmlhttp/css/rime/rime.css" id="outputStyle2"/>
                <meta content="text/html; charset=utf-8" http-equiv="content-type"/>
                <title>Laboratorio</title>
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
                        <ice:form id="formLaboratorio">
                            <ice:panelGroup>
                                <div class="post">
                                    <h2>Actividades del Laboratorio</h2>
                                    <br/>
                                    Estas son las actividades que su usuario puede realizar en el Laboratorio...
                                    <div align="right"><ice:outputConnectionStatus binding="#{jmlLaboratorio.estatus}" id="estatus" styleClass="actionStatus"/></div>
                                    <div align="center">
                                      <ice:panelGrid id="panelbotones" columns="2" cellpadding="8">
                                          <ice:panelGroup rendered="#{jmlLaboratorio.esRolEstudiante}">
                                            <ice:commandLink action="#{Redireccion.jmlInscripcion}">
                                                <img src="img/inscribir.png"/><br/><ice:outputLabel value="Inscribirse a un Curso"/>
                                            </ice:commandLink>
                                        </ice:panelGroup>
                                        <ice:panelGroup rendered="#{jmlLaboratorio.esRolEstudiante}">
                                            <ice:commandLink action="#{Redireccion.jmlAsistencia}">
                                                <img src="img/asistencia.png"/><br/><ice:outputLabel value="Asistencia Clase/Materia"/>
                                            </ice:commandLink>
                                        </ice:panelGroup>
                                        <ice:panelGroup>
                                            <ice:commandLink action="#{Redireccion.jmlHorario}">
                                                <img src="img/horario.png"/><br/><ice:outputLabel value="Horarios del Laboratorio"/>
                                            </ice:commandLink>
                                        </ice:panelGroup>
                                        <ice:panelGroup rendered="#{jmlLaboratorio.permisos}">
                                            <ice:commandLink action="#{Redireccion.jmlGestionaClase}">
                                                <img src="img/clases.png"/><br/><ice:outputLabel value="Gestionar Clases"/>
                                            </ice:commandLink>
                                        </ice:panelGroup>
                                      </ice:panelGrid>
                                    </div>
                                </div>
                            </ice:panelGroup>
                        </ice:form>
                        <br/>
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
                            <!--login control -->
                            <jsp:directive.include file="/jspf/tareas.jspx"/>
                            <!--login control -->
                            </li>
                            <li>
                                <ice:form id="lameForm">
                                <ice:commandLink action="#{Redireccion.jmlCrudAdmin}"
                                rendered="#{JHardminInstance.currentUser.userRole.idrol == 1}" value="Administracion Laboratorio"/>
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
