<?xml version="1.0" encoding="UTF-8"?>
<!-- 
    Document   : jmlClase
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
                        <div class="post">
                            <h2 class="title">Cursos del Laboratorio</h2>
                        </div>
                        <ice:form id="formArticulo">
                            <ice:panelGroup id="panelVistaUnica">
                                <div class="post">
                                    <h2>
                                        <ice:outputLabel id="lblArticuloTituloUnico" style="font-weight:bold; " value="#{jwikiUser.articuloActual.titulo}"/>
                                    </h2>
                                    <br/>
                                    <ice:outputLabel id="lblArticuloDescripcionUnico" value="#{jwikiUser.articuloActual.descripcion}"/>
                                    <br/>
                                    <br/>
                                    Escrito por: <ice:outputText id="lblArticuloUsuarioUnico"
                                        value="#{jwikiUser.articuloActual.idusuario.nombre}"/>, en: <ice:outputText id="lblArticuloFechaUnico" value="#{jwikiUser.articuloActual.fechahora}"/>
                                </div>
                                <br/>
                                <ice:commandButton action="#{jwikiUser.toggleVista}" id="btnToggle" styleClass="btnAccion2" value="Regresar"/>
                                <br/>
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
