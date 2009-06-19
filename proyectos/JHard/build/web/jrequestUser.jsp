<?xml version="1.0" encoding="UTF-8"?>
<!-- 
    Document   : jrequestUser
    Created on : 05-29-2009, 10:56:59 AM
    Author     : hugol 
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
                                <a href="#">Principal</a>
                            </li>
                            <li>
                                <a href="jrquest.iface">Mantenimientos</a>
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
                            <h2 class="title">Mantenimiento de Hardware y Software</h2>
                            <div class="entry">
                                <p class="text">Este es el sitio si requiere Soporte Técnico ya sea en Hardware o Software en la UES-FMOcc</p>
                                <ice:form id="form1">
                                    <ice:outputLabel id="lblInstruccion" value="Si su problema se encuentra en la siguiente lista, escoja para ver su solución"/>
                                    <br/>
                                    <br/>
                                    <ice:selectOneMenu binding="#{jrequestUser.comboProblemas}" id="comboProblemas" partialSubmit="true" style="width: 142px" valueChangeListener="#{jrequestUser.comboProblemas_processValueChange}">
                                        <f:selectItems id="selectOneMenu1selectItems" value="#{jrequestUser.arrayTecnico.options['idtecnico,apellidos']}"/>
                                    </ice:selectOneMenu>
                                    <br/>
                                    <br/>
                                    <br/>
                                    <ice:outputLabel id="outputLabel2" value="Si su problema no está en la lista anterior, ingrese palabras clave para realizar una búsqueda"/>
                                    <br/>
                                    <br/>
                                    <ice:inputText id="inputText1" style=""/>
                                    <br/>
                                    <br/>
                                    <ice:commandButton action="#{jrequestUser.btnBuscar_action}" binding="#{jrequestUser.btnBuscar}" id="btnBuscar" style="" value="Buscar"/>
                                </ice:form>
                                <ice:outputLabel binding="#{jrequestUser.select}" id="select" value="outputLabel"/>
                                <br/>
                                <br/>
                                <br/>
                                <br/>
                                <br/>
                                <ice:form id="form2">
                                    <ice:outputLabel id="lblSolicitud" value="En cambio, si desea enviar una solicitud de Mantenimiento, pulse el siguiente botón"/>
                                    <ice:commandButton action="#{jrequestUser.btnSolicitud_action}" binding="#{jrequestUser.btnSolicitud}" id="btnSolicitud" value="Enviar Solicitud"/>
                                </ice:form>
                                <br/>
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
