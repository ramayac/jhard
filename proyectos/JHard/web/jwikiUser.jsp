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
                <title>Wiki del Laboratorio</title>
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
                            <h2 class="title">Wiki del Laboratorio</h2>
                        </div>
                        <ice:form id="formArticulo">
                            <ice:panelGroup rendered="#{!jwikiUser.hayArticulos}">
                                <div class="post">
                                    <br/>
                                    <h2 class="title">Aviso</h2>
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
