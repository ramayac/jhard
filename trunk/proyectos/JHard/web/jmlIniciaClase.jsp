<?xml version="1.0" encoding="UTF-8"?>
<!-- 
    Document   : jmlIniciaClase
    Created on : 08-02-2009, 03:07:30 PM
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
                        <div class="post">
                            <h2 class="title">Iniciar Clase</h2>
                        </div>
                        <ice:form id="formIniciarClase">
                            <ice:panelGroup id="panel1">
                                <div class="post">
                                    <h2>Lista de Cursos</h2>
                                    <ice:dataTable id="tabla" rows="10" value="#{jmlIniciaClase.listaCursos}" var="indiceCurso" width="100%">
                                    <ice:column id="columnaArticulos">
                                        <ice:commandLink action="#{jmlIniciaClase.elegirCurso}">
                                            <ice:outputLabel id="lblTituloCurso" style="font-weight:bold; " value="#{indiceCurso.titulo}"/>
                                                <f:param name="idCurso" value="#{indiceCurso.idcurso}"/>
                                            </ice:commandLink>
                                    </ice:column>
                                    </ice:dataTable>
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
