<?xml version="1.0" encoding="UTF-8"?>
<!-- 
    Document   : jwikiUser
    Created on : 06-21-2009, 6:00:43 AM
    Author     : ramayac
-->
<jsp:root version="2.1" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:ice="http://www.icesoft.com/icefaces/component" xmlns:jsp="http://java.sun.com/JSP/Page">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
    <f:view>
        <html id="outputHtml1">
            <head id="outputHead1">
                <ice:outputStyle href="css/stylesheet.css" id="outputStyle1"/>
                <ice:outputStyle href="./xmlhttp/css/rime/rime.css" id="outputStyle2"/>
                <meta content="text/html; charset=utf-8" http-equiv="content-type"/>
                <title>Wiki</title>
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
                            <li>
                                <a href="Index.iface">Principal</a>
                            </li>
                            <li>
                                <a href="jrequest.iface">Mantenimientos</a>
                            </li>
                            <li>
                                <a href="#">Grupos de Laboratorio</a>
                            </li>
                            <li>
                                <a href="#">Inventario</a>
                            </li>
                            <li>
                                <a href="jprocurUser.iface">Cursos</a>
                            </li>
                            <li class="current_page_item">
                                <a href="jwikiUser.iface">Wiki</a>
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
                        <ice:form id="formArticulo">
                            <ice:panelGroup rendered="#{!jwikiUser.hayArticulos}">
                                <div class="post">
                                    <h2>Aviso</h2>
                                    <ul>
                                        <li>No existen criterios asociados con su búsqueda.</li>
                                        <li>No hay artículos que mostrar.</li>
                                    </ul>
                                </div>
                            </ice:panelGroup>
                            <ice:panelGroup id="panelVistaUnica" rendered="#{jwikiUser.soloUna}">
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
                            <ice:panelGroup id="panelVistaMultiple" rendered="#{!jwikiUser.soloUna}">
                                <ice:dataTable id="tablaArticulos" rows="5" value="#{jwikiUser.listaArticulos}" 
                                var="indiceArticulo" width="100%">
                                    <ice:column id="columnaArticulos">
                                        <div class="post">
                                            <h2>
                                                <ice:commandLink action="#{jwikiUser.elegirArticuloActual}">
                                                    <ice:outputLabel id="lblTitulo" style="font-weight:bold; " value="#{indiceArticulo.titulo}"/>
                                                    <f:param name="idSeleccionado" value="#{indiceArticulo.idarticulo}"/>
                                                </ice:commandLink>
                                            </h2>
                                            <br/>
                                            <div align="right">
                                                <small>
                                                    <ice:outputLabel id="lblArticuloFechaMultiple" value="#{indiceArticulo.fechahora}"/>
                                                </small>
                                            </div>
                                            <br/>
                                            <ice:outputLabel id="lblDescripcion" value="#{indiceArticulo.descripcion}"/>
                                            <br/>
                                        </div>
                                    </ice:column>
                                </ice:dataTable>
                                <div align="center">
                                    <ice:dataPaginator for="tablaArticulos" id="paginadorArticulo" paginator="true" rendered="#{jwikiUser.showPagArticulos}">
                                        <f:facet name="first">
                                            <ice:graphicImage style="border:none;" title="First Page" url="./xmlhttp/css/rime/css-images/arrow-first.gif"/>
                                        </f:facet>
                                        <f:facet name="previous">
                                            <ice:graphicImage style="border:none;" title="Prev Page" url="./xmlhttp/css/rime/css-images/arrow-previous.gif"/>
                                        </f:facet>
                                        <f:facet name="next">
                                            <ice:graphicImage style="border:none;" title="Next Page" url="./xmlhttp/css/rime/css-images/arrow-next.gif"/>
                                        </f:facet>
                                        <f:facet name="last">
                                            <ice:graphicImage style="border:none;" title="Last Page" url="./xmlhttp/css/rime/css-images/arrow-last.gif"/>
                                        </f:facet>
                                    </ice:dataPaginator>
                                </div>
                            </ice:panelGroup>
                        </ice:form>
                        <br/>
                    </div>
                    <!-- end content -->
                    <!-- start sidebar -->
                    <div id="sidebar">
                        <ul>
                            <li id="search">
                                <ice:form id="formBusqueda">
                                    <h2>Búsqueda</h2>
                                    <ice:inputText id="itBusqueda" partialSubmit="true" title="Búsqueda de artículos" value="#{jwikiUser.criteriosBusqueda}"/>
                                    <ice:commandButton action="#{jwikiUser.busquedaArticulos}" id="btnBusqueda" styleClass="btnAccion2" value="Buscar"/>
                                </ice:form>
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
                <div id="footer">
                    <div id="footer-wrap">
                        <p id="legal" style="line-height: 13px">Universidad de El Salvador Facultad Multidisciplinaria de Occidente <br/> Todos los Derechos (C) Reservados - Teléfonos:(503)2449-0349, Fax:(503)2449-0352 Apdo. 1908<br/>
                            <a href="#">Créditos</a> - <a href="http://www.uesocc.edu.sv">Pagina Principal de la UES FMOcc</a>
                        </p>
                    </div>
                </div>
                <!-- end footer -->
            </body>
        </html>
    </f:view>
</jsp:root>
