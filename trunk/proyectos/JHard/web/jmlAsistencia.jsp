<?xml version="1.0" encoding="UTF-8"?>
<!-- 
    Document   : jmlAsistencia
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
                <title>Cursos del Laboratorio</title>
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
                        <ice:form id="formAsistencia">
                            <ice:panelGroup>
                                <div class="post">
                                    <h2>Asistencia a una Clase</h2><br/>
                                    <ice:panelGroup id="panel1" rendered="#{jmlAsistencia.paso1}">
                                        Seleccione a que curso (materia) pertenece la clase ó practica:
                                        <ice:dataTable value="#{jmlAsistencia.listaCursos}" var="indiceCurso" width="100%">
                                            <ice:column id="columnaCursos">
                                                <f:facet name="header">Lista de Cursos</f:facet>
                                                <ice:commandLink action="#{jmlAsistencia.elegirCurso}">
                                                    <ice:outputLabel id="lblTituloCurso" style="font-weight:bold; " value="#{indiceCurso.nombre}"/>
                                                    <f:param name="idCurso" value="#{indiceCurso.idcurso}"/>
                                                </ice:commandLink>
                                            </ice:column>
                                         </ice:dataTable>
                                    </ice:panelGroup>
                                    <ice:panelGroup id="panel2" rendered="#{jmlAsistencia.paso2}">
                                        <ice:panelGroup rendered="#{jmlAsistencia.hayClases}">
                                        Confirme su asistencia a la clase del curso: <ice:outputLabel style="font-weight:bold; " value="#{jmlAsistencia.cursoSeleccionado.nombre}"/>
                                        <ice:dataTable value="#{jmlAsistencia.listaClases}" var="indiceClase" width="100%">
                                            <ice:column id="columnaClases">
                                                <f:facet name="header">Lista de Clases activas</f:facet>
                                                <ice:outputLabel id="lblTema" value="#{indiceClase.tema}"/>
                                            </ice:column>
                                            <ice:column id="columnaAsistencia">
                                                <f:facet name="header">Marca Asistencia</f:facet>
                                                <ice:commandLink action="#{jmlAsistencia.marcaAsistenciaClase}">
                                                    Asistencia<f:param name="idClase" value="#{indiceClase.idclase}"/>
                                                </ice:commandLink>
                                            </ice:column>
                                        </ice:dataTable>
                                    </ice:panelGroup>
                                    <ice:panelGroup rendered="#{!jmlAsistencia.hayClases}">
                                        <h2 class="title">Aviso:</h2>
                                            <div align="center">
                                                <ul>
                                                    <li>No hay clases para esta hora.</li>
                                                    <li>La clase ha concluido.</li>
                                                </ul>
                                                <br/>
                                                <ice:commandButton action="#{jmlAsistencia.cancelar}" styleClass="btnAccion2" value="Cancelar"/>
                                            </div>
                                   </ice:panelGroup>
                                </ice:panelGroup>
                                </div>
                            </ice:panelGroup>
                            <!-- panel de mensajes de avisos...-->
                            <ice:panelPopup autoCentre="true" id="ppmsj" modal="true" rendered="#{jmlAsistencia.popup.visible}">
                                <f:facet name="header">
                                    <ice:panelGrid><ice:outputText id="pptit" value="#{jmlAsistencia.popup.titulo}"/></ice:panelGrid>
                                </f:facet>
                                <f:facet name="body">
                                <div class="post">
                                    <ice:panelGroup>
                                        <ice:outputText id="lblppmsj" value="#{jmlAsistencia.popup.mensaje}"/>
                                        <br/>
                                        <br/>
                                        <div align="center">
                                        <ice:commandButton action="#{jmlAsistencia.btnGoBegin_action}" id="ppok" value="OK"/>
                                        </div>
                                    </ice:panelGroup>
                                    </div>
                                </f:facet>
                            </ice:panelPopup>
                            <!-- panel de mensajes -->
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
                                <h2>Otros Vinculos</h2>
                                <ul>
                                    <li>
                                        <a href="#">Nec metus sed donec</a>
                                    </li>
                                </ul>
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
