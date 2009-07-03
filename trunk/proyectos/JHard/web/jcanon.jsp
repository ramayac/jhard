<?xml version="1.0" encoding="UTF-8"?>
<!-- 
    Document   : jcanon
    Created on : 29-jun-2009, 1:15:10
    Author     : Hugol 
-->
<jsp:root version="2.1" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:jsp="http://java.sun.com/JSP/Page" xmlns:ice="http://www.icesoft.com/icefaces/component">
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

                <link href="css/default.css" rel="stylesheet" type="text/css"/>
                <link href="img/favicon.ico" rel="shortcut icon" type="image/x-icon"/>

                <!--Scheduler-->
                <script src="js/dhtmlxscheduler.js" type="text/javascript" charset="utf-8"></script>
                <link rel="stylesheet" href="js/dhtmlxscheduler.css" type="text/css" media="screen" title="no title" charset="utf-8"/>

                <script type="text/javascript" charset="utf-8">
                    function init() {

                    scheduler.config.xml_date="%Y-%m-%d %H:%i";
                    scheduler.init('scheduler_here',null,"week");
                    scheduler.load("events.xml");

                    }
                </script>

            </head>
            <body id="outputBody1" style="-rave-layout: grid" onload="init();">
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
                            <ice:panelGroup styleClass="entry" style="margin:0px;" id="grupo1">
                                <p></p>
                                <div id="scheduler_here" class="dhx_cal_container" style='position: absolute; width:50%; height:75%;'>
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
                                    <ice:commandButton action="#{JHardminInstance.login}" id="btnLogin" styleClass="btnAccion" value="Login"/>
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
                                            <ice:commandLink value="Cambiar clave de acceso" action="chpwd" rendered="#{JHardminInstance.currentUser != null}"  />
                                        </li>
                                        <li>
                                            <a href="#">Administrar usuarios</a>
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
