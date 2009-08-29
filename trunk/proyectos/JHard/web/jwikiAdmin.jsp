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
                            <h2 class="title">Administración Wiki</h2>
                        </div>
                        <div class="post">
                            <ice:form id="formArticulo">
                                <ice:panelTabSet id="panelAdmin" tabPlacement="Top" selectedIndex="#{jwikiAdmin.tabIndex}" rendered="#{jwikiAdmin.permisos}">
                                    <ice:panelTab id="panelArticulos" label="Administrar Artículos">
                                        <!-- panel de para EDITAR UN ARTICULO -->
                                        <ice:panelGroup id="panelEditarArticulo" rendered="#{jwikiAdmin.editandoArticulo}">
                                            <div class="post">
                                            Título: <ice:inputText id="itTitulo"
                                                    partialSubmit="true" title="Título del artículo" value="#{jwikiAdmin.articuloActual.titulo}"
                                                    maxlength="50"/>
                                                <br/>
                                                <ice:inputRichText id="richDescripcion"
                                                language="es" skin="silver" toolbar="Default"
                                                value="#{jwikiAdmin.articuloActual.descripcion}"
                                                height="600" saveOnSubmit="true"/>
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
                                            <ice:dataTable id="tablaArticulos" rendered="#{jwikiAdmin.hayArticulos}" rows="30" styleClass="mitablaarticulos"
                                            value="#{jwikiAdmin.listaArticulos}" var="indiceArticulo" resizable="true">
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
                                                    partialSubmit="true" title="Título de la artículo" value="#{jwikiAdmin.articuloNuevo.titulo}"
                                                    maxlength="50"/>
                                                <br/>
                                                <ice:inputRichText id="richDescripcion2" language="es" skin="silver" toolbar="Default" 
                                                value="#{jwikiAdmin.articuloNuevo.descripcion}" height="600"/>
                                            </div>
                                            <br/><br/>
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
                                        </ice:panelGroup>
                                    </ice:panelTab>
                                </ice:panelTabSet>
                                <ice:panelGroup rendered="#{!jwikiAdmin.permisos}">
                                    <jsp:directive.include file="/jspf/nologin.jspx"/>
                                </ice:panelGroup>
                                <!-- panel de mensajes para viñeta de Articulos-->
                                <ice:panelPopup autoCentre="true" id="panelMensajeArticulos" modal="true" rendered="#{jwikiAdmin.popupElimArticulo}">
                                    <f:facet name="header">
                                        <ice:panelGrid id="ppArticulo">
                                            <ice:outputText id="otxtTituloArticulo" value="Aviso:"/>
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
                                                            rendered="#{jwikiAdmin.articuloValido}" value="Eliminar" styleClass="btnAccion2"/>
                                                        <ice:commandButton action="#{jwikiAdmin.btnCancelarMensajes_action}" id="btnCancelarArticulo"
                                                            rendered="#{jwikiAdmin.articuloValido}" value="Cancelar" styleClass="btnAccion2"/>
                                                        <ice:commandButton action="#{jwikiAdmin.btnCancelarMensajes_action}" id="btnOKArticulo"
                                                            rendered="#{!jwikiAdmin.articuloValido}" value="OK"  styleClass="btnAccion2"/>
                                                    </ice:panelGrid>
                                                </div>
                                            </ice:panelGroup>
                                        </div>
                                    </f:facet>
                                </ice:panelPopup>
                                <!-- panel de mensajes -->
                                <!-- panel de mensajes de avisos...-->
                                <ice:panelPopup autoCentre="true" id="ppmsj" modal="true" rendered="#{jwikiAdmin.showPPMesaje}">
                                    <f:facet name="header">
                                        <ice:panelGrid><ice:outputText id="pptit" value="Aviso:"/></ice:panelGrid>
                                    </f:facet>
                                    <f:facet name="body">
                                        <div class="post">
                                        <ice:panelGroup>
                                            <ice:outputText binding="#{jwikiAdmin.lblPPMesajes}" id="lblppmsj" value="Mensajes AQUI"/>
                                            <br/>
                                            <br/>
                                            <div align="center">
                                            <ice:commandButton action="#{jwikiAdmin.btnOK_action}" id="ppok" value="OK" styleClass="btnAccion2"/>
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
                            <!--login control -->
                            <jsp:directive.include file="/jspf/login.jspx"/>
                            <!--login control -->
                            </li>
                            <li>
                            <!--login control -->
                            <jsp:directive.include file="/jspf/tareas.jspx"/>
                            <!--login control -->
                            <ul>
                                <ice:form id="anotherForm">
                                <li>
                                    <ice:commandLink action="#{Redireccion.jWikiUser}"
                                                rendered="#{JHardminInstance.currentUser.userRole.idrol == 1}" value="Ir a Wiki"/>
                                </li>
                                <li>
                                    <ice:commandLink action="#{Redireccion.jProCurUser}"
                                                rendered="#{JHardminInstance.currentUser.userRole.idrol == 1}" value="Ir a Promoción de Cursos"/>
                                </li>
                                </ice:form>
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
