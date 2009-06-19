<?xml version="1.0" encoding="UTF-8"?>
<!-- 
    Document   : jrequestUserSolicitud
    Created on : 16-jun-2009, 20:39:56
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
                            <h2 class="title">Solicitud de Mantenimiento de Hardware y Software</h2>
                            <div class="entry">
                                <p class="text">Ingrese su solicitud:</p>
                                <ice:form id="form1" style="height: 200px">
                                    <ice:panelPopup autoCentre="true" binding="#{jrequestUserSolicitud.panelPopup1}" draggable="true" id="panelPopup1"
                                        modal="true" rendered="#{jrequestUserSolicitud.panelPopup1Bean.showDraggablePanel}"
                                        style="height: 300px; left: 576px; top: 336px; position: absolute; width: 300px" visible="#{jrequestUserSolicitud.panelPopup1Bean.showModalPanel}">
                                        <f:facet name="header">
                                            <ice:panelGrid id="panelGrid1" style="display:block;width:180px;height:20px;">
                                                <ice:outputText id="outputText1" value="Agregar Nuevo Equipo"/>
                                            </ice:panelGrid>
                                        </f:facet>
                                        <f:facet name="body">
                                            <ice:panelGrid id="panelGrid2" style="display: block; height: 254px; width: 180px">
                                                <ice:outputLabel id="lblNombreEq" value="Nombre de Equipo"/>
                                                <ice:inputText binding="#{jrequestUserSolicitud.txtNombreEq}" id="txtNombreEq"/>
                                                <ice:outputLabel id="lblEstadoEq" value="Estado del Equipo"/>
                                                <ice:selectOneMenu binding="#{jrequestUserSolicitud.comboEstados}" id="comboEstados" partialSubmit="true">
                                                    <f:selectItems id="selectOneMenu1selectItems1" value="#{jrequestUserSolicitud.arrayEstados.options['idestado,nombre']}"/>
                                                </ice:selectOneMenu>
                                                <ice:commandButton action="#{jrequestUserSolicitud.btnAgregar_action}"
                                                    binding="#{jrequestUserSolicitud.btnAgregar}" id="btnAgregar" value="Agregar"/>
                                                <ice:commandButton action="#{jrequestUserSolicitud.btnCerrar_action}"
                                                    binding="#{jrequestUserSolicitud.btnCerrar}" id="btnCerrar" value="Cerrar"/>
                                                <ice:message binding="#{jrequestUserSolicitud.mensaje}" errorClass="errorMessage" fatalClass="fatalMessage"
                                                    for="" id="mensaje" infoClass="infoMessage" showSummary="true" warnClass="warnMessage"/>
                                            </ice:panelGrid>
                                        </f:facet>
                                    </ice:panelPopup>
                                    <ice:outputLabel id="lblNombre" value="Nombre Usuario"/>
                                    <br/>
                                    <br/>
                                    <ice:inputText binding="#{jrequestUserSolicitud.txtUsuario}" id="txtUsuario" style="width: 190px"/>
                                    <br/>
                                    <br/>
                                    <br/>
                                    <ice:outputLabel id="lbldescripcion" value="Descripción"/>
                                    <br/>
                                    <br/>
                                    <ice:inputTextarea binding="#{jrequestUserSolicitud.txtDescripcion}" id="txtDescripcion" style="height: 72px; width: 190px"/>
                                    <br/>
                                    <br/>
                                    <br/>
                                    <ice:outputLabel id="lblEqSimple" value="Nombre Equipo"/>
                                    <br/>
                                    <br/>
                                    <ice:selectOneMenu binding="#{jrequestUserSolicitud.comboEqSimple}" id="comboEqSimple" partialSubmit="true"
                                        style="width: 190px" valueChangeListener="#{jrequestUserSolicitud.comboEqSimple_processValueChange}">
                                        <f:selectItems id="selectOneMenu1selectItems" value="#{jrequestUserSolicitud.arrayEqSimple.options['idEquipoSimple,descripcion']}"/>
                                    </ice:selectOneMenu>
                                    <ice:commandButton action="#{jrequestUserSolicitud.btnAgregarEqSimple_action}"
                                        binding="#{jrequestUserSolicitud.btnAgregarEqSimple}" id="btnAgregarEqSimple" value="Agregar Equipo"/>
                                    <br/>
                                    <br/>
                                    <br/>
                                    <ice:commandButton action="#{jrequestUserSolicitud.btnEnviar_action}" binding="#{jrequestUserSolicitud.btnEnviar}"
                                        id="btnEnviar" value="Enviar"/>
                                    <br/>
                                    <br/>
                                    <br/>
                                    <ice:outputLabel binding="#{jrequestUserSolicitud.lblEstadoSolicitud}" id="lblEstadoSolicitud" value="Estado de la Solicitud"/>
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
                                <h2>Usuarios</h2>
                AQUI VA EL LOGIN
	</li>
                            <li>
                                <h2>Otros Vinculos</h2>
                                <ul>
                                    <li>
                                        <a href="#">Nec metus sed donec</a>
                                    </li>
                                    <li>
                                        <a href="#">Magna lacus bibendum mauris</a>
                                    </li>
                                    <li>
                                        <a href="#">Velit semper nisi molestie</a>
                                    </li>
                                    <li>
                                        <a href="#">Eget tempor eget nonummy</a>
                                    </li>
                                    <li>
                                        <a href="#">Nec metus sed donec</a>
                                    </li>
                                    <li>
                                        <a href="#">Magna lacus bibendum mauris</a>
                                    </li>
                                    <li>
                                        <a href="#">Velit semper nisi molestie</a>
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
