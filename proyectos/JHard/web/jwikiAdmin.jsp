<?xml version="1.0" encoding="UTF-8"?>
<!-- 
    Document   : jwikiAdmin
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
                <title>Administración Wiki</title>
                <meta content="" name="keywords"/>
                <meta content="" name="description"/>
                <link href="css/default.css" rel="stylesheet" type="text/css"/>
                <link href="img/favicon.ico" rel="shortcut icon" type="image/x-icon"/>
                <script charset="utf-8" src="js/jquery-1.2.3.js" type="text/javascript"></script>
                <script charset="utf-8" src="js/jquery.uitablefilter.js" type="text/javascript"></script>
                <script charset="utf-8" type="text/javascript">
                    jQuery.noConflict();
                    jQuery(document).ready(function() {
                        var tabla = jQuery("form table.mitablaarticulos");
                        jQuery("#filtroTablaArticulos").keyup(function() {
                            jQuery.uiTableFilter(tabla, this.value );
                        })
                    });
                </script>
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
                            <li class="current_page_item">
                                <a href="JWikiUser.iface">Wiki y Cursos</a>
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
                            <ice:form id="formArticulo">
                                <ice:panelTabSet id="panelAdmin" tabPlacement="Top">
                                    <ice:panelTab id="panelArticulos" label="Administrar Artículos">
                                        <!-- panel de para EDITAR UN ARTICULO -->
                                        <ice:panelGroup id="panelEditarArticulo" rendered="#{jwikiAdmin.editandoArticulo}">
                                            <div class="post">
                                            Título: <ice:inputText id="itTitulo"
                                                    partialSubmit="true" title="Título del artículo" value="#{jwikiAdmin.articuloActual.titulo}"/>
                                                <br/>
                                                <ice:inputRichText id="richDescripcion" language="es" skin="silver" toolbar="Default" value="#{jwikiAdmin.articuloActual.descripcion}"/>
                                                <br/>
                                                <br/>
                                            Escrito por: <ice:outputLabel id="lblAutor"
                                                    style="font-weight:bold; " title="Último usuario que guardó el artículo." value="#{jwikiAdmin.articuloActual.idusuario.nombre}"/>
                                                <div align="right">
                                                    <ice:outputLabel id="lblFechaHora" title="Fecha y hora de la última modificacion en el artículo." value="#{jwikiAdmin.articuloActual.fechahora}"/>
                                                </div>
                                                <br/>
                                                <br/>
                                                <div align="center">
                                                    <ice:commandButton action="#{jwikiAdmin.modificarArticulo}" id="btnGuardar" styleClass="btnAccion2" value="Guardar"/>
                                                    <ice:commandButton action="#{jwikiAdmin.cancelarGuardarArticulo}" id="btnCancelar"
                                                        styleClass="btnAccion2" value="Cancelar"/>
                                                </div>
                                            </div>
                                        </ice:panelGroup>
                                        <!-- END panel de para EDITAR UN ARTICULO -->
                                        <!-- panel de para administrar los ARTICULOS -->
                                        <ice:panelGroup id="panelVistaMultipleArticulos" rendered="#{!jwikiAdmin.editandoArticulo}">
                                            <div align="right">Filtro: <input id="filtroTablaArticulos"/>
                                            </div>
                                            <ice:dataTable id="tablaArticulos" rendered="#{jwikiAdmin.hayArticulos}" rows="30" styleClass="mitablaarticulos"
                                                value="#{jwikiAdmin.listaArticulos}" var="indiceArticulo">
                                                <ice:column>
                                                    <f:facet name="header">
                                                        <ice:outputText value="Título de la Articulo"/>
                                                    </f:facet>
                                                    <ice:outputLabel id="lblTitulo" style="font-weight:bold; " value="#{indiceArticulo.titulo}"/>
                                                </ice:column>
                                                <ice:column>
                                                    <f:facet name="header">
                                                        <ice:outputText value="Autor"/>
                                                    </f:facet>
                                                    <ice:outputLabel id="lblAutor" style="font-weight:bold; " value="#{indiceArticulo.idusuario.nombre}"/>
                                                </ice:column>
                                                <ice:column>
                                                    <f:facet name="header">
                                                        <ice:outputText value="Fecha de publicación"/>
                                                    </f:facet>
                                                    <ice:outputLabel id="lblFecha" style="font-weight:bold; " value="#{indiceArticulo.fechahora}"/>
                                                </ice:column>
                                                <ice:column>
                                                    <f:facet name="header">
                                                        <ice:outputText value="Editar artículo"/>
                                                    </f:facet>
                                                    <ice:commandLink action="#{jwikiAdmin.EditarArticulo}" value="Editar">
                                                        <f:param name="idArticulo" value="#{indiceArticulo.idarticulo}"/>
                                                    </ice:commandLink>
                                                </ice:column>
                                                <ice:column>
                                                    <f:facet name="header">
                                                        <ice:outputText value="Eliminar artículo"/>
                                                    </f:facet>
                                                    <ice:commandLink action="#{jwikiAdmin.EliminarArticulo}" value="Eliminar">
                                                        <f:param name="idArticulo" value="#{indiceArticulo.idarticulo}"/>
                                                    </ice:commandLink>
                                                </ice:column>
                                            </ice:dataTable>
                                            <div align="center">
                                                <ice:dataPaginator for="tablaArticulos" id="paginadorArticulo" paginator="true" rendered="#{jwikiAdmin.showPagArticulos}">
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
                                        <!-- FIN panel de para administrar los ARTICULOS -->
                                    </ice:panelTab>
                                    <ice:panelTab id="panelArticulo" label="Agregar Articulo">
                                        <!-- panel de para agregar los Articulos -->
                                        <ice:panelGroup id="panelAgregarArticulo">
                                            <div closs="post">
                                            Título: <ice:inputText id="itTitulo2"
                                                    partialSubmit="true" title="Título de la artículo" value="#{jwikiAdmin.articuloNuevo.titulo}"/>
                                                <br/>
                                                <ice:inputRichText id="richDescripcion2" language="es" skin="silver" toolbar="Default" value="#{jwikiAdmin.articuloNuevo.descripcion}"/>
                                                <br/>
                                                <br/>
                                            Escrito por: <ice:outputLabel id="lblAutor2"
                                                    style="font-weight:bold; " title="" value="#{jwikiAdmin.currentUserName}"/>
                                                <div align="right">
                                                    <ice:outputLabel id="lblFechaHora2" title="Fecha y hora de la creacion de la artículo." value="#{jwikiAdmin.articuloActual.fechahora}"/>
                                                </div>
                                                <br/>
                                                <br/>
                                                <br/>
                                                <div align="center">
                                                    <ice:commandButton action="#{jwikiAdmin.agregarArticulo}" id="btnGuardar2" styleClass="btnAccion2" value="Guardar"/>
                                                    <ice:commandButton action="#{jwikiAdmin.cancelarGuardarArticulo}" id="btnCancelar2"
                                                        styleClass="btnAccion2" value="Cancelar"/>
                                                </div>
                                            </div>
                                        </ice:panelGroup>
                                    </ice:panelTab>
                                </ice:panelTabSet>
                                <!-- panel de mensajes para viñeta de Articulos-->
                                <ice:panelPopup autoCentre="true" id="panelMensajeArticulos" modal="true" rendered="#{jwikiAdmin.popupElimArticulo}">
                                    <f:facet name="header">
                                        <ice:panelGrid id="ppArticulo">
                                            <ice:outputText id="otxtTituloArticulo" value="JWiki"/>
                                        </ice:panelGrid>
                                    </f:facet>
                                    <f:facet name="body">
                                        <div class="post">
                                            <ice:panelGroup id="pgArticulo">
                                                <ice:outputText binding="#{jwikiAdmin.lblMensajesArticulos}" id="lblMensajesArticulo" value="Mensajes AQUI"/>
                                                <br/>
                                                <br/>
                                                <div align="center">
                                                    <ice:panelGrid columns="2" id="panelBotonesArticulo">
                                                        <ice:commandButton action="#{jwikiAdmin.btnAceptarElimArt_action}" id="btnEliminarArticulo"
                                                            rendered="#{jwikiAdmin.articuloValido}" value="Eliminar"/>
                                                        <ice:commandButton action="#{jwikiAdmin.btnCancelarMensajes_action}" id="btnCancelarArticulo"
                                                            rendered="#{jwikiAdmin.articuloValido}" value="Cancelar"/>
                                                        <ice:commandButton action="#{jwikiAdmin.btnCancelarMensajes_action}" id="btnOKArticulo"
                                                            rendered="#{!jwikiAdmin.articuloValido}" value="OK"/>
                                                    </ice:panelGrid>
                                                </div>
                                            </ice:panelGroup>
                                        </div>
                                    </f:facet>
                                </ice:panelPopup>
                                <!-- panel de mensajes -->
                            </ice:form>
                        </div>
                    </div>
                    <!-- end content -->
                    <!-- start sidebar -->
                    <div id="sidebar">
                        <ul>
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
                            <!--<li>
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
                            </li>-->
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
