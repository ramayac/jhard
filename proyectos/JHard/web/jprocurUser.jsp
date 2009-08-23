<?xml version="1.0" encoding="UTF-8"?>
<!-- 
    Document   : jprocurUser
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
                <title>Promoción de Cursos</title>
                <meta content="" name="keywords"/>
                <meta content="" name="description"/>
                <link href="css/default.css" rel="stylesheet" type="text/css"/>
                <link href="img/favicon.ico" rel="shortcut icon" type="image/x-icon"/>
                <link rel="alternate" type="application/rss+xml" title="jHard - Ultimos Articulos" href="feed?opt=1"/>
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
                            <h2 class="title">Promoción de Cursos</h2>
                        </div>
                        <ice:form id="formEntrada">
                            <ice:panelGroup rendered="#{!jprocurUser.hayEntradas}">
                                <div class="post">
                                <h2>Aviso</h2>
                                <ul>
                                    <li>No existen criterios asociados con su búsqueda.</li>
                                    <li>No hay entradas que mostrar.</li>
                                </ul>
                                </div>
                            </ice:panelGroup>
                            <ice:panelGroup id="panelVistaUnica" rendered="#{jprocurUser.soloUna}">
                                <div class="post">
                                    <h2>
                                        <ice:outputLabel id="lblEntradaTituloUnico" style="font-weight:bold; " value="#{jprocurUser.entradaActual.titulo}"/>
                                    </h2>
                                    <br/>
                                    <ice:outputLabel id="lblEntradaDescripcionUnico" value="#{jprocurUser.entradaActual.descripcion}"/>
                                    <br/>
                                    <br/>
                                    Escrito por: <ice:outputText id="lblEntradaUsuarioUnico"
                                                                 value="#{jprocurUser.entradaActual.idusuario.nombre}"/>, en: <ice:outputText id="lblEntradaFechaUnico" value="#{jprocurUser.entradaActual.fechahora}"/>
                                </div>
                                <br/>
                                <br/>
                                Comentarios:<br/>
                                <div class="post">
                                    <ice:dataTable id="tablaEntradaComentarios" rows="10"
                                    value="#{jprocurUser.entradaActual.comentariosList}"
                                    var="indiceComentario" width="100%"
                                    rendered="#{jprocurUser.hayComentarios}">
                                        <ice:column id="columnaComentarios">
                                            <ice:panelGroup id="pnlComent" rendered="#{indiceComentario.aprobado}">
                                                <ice:commandLink action="#{jprocurUser.eliminarComentario}" rendered="#{jprocurUser.permisoBorrarComentario}">
                                                    <ice:graphicImage style="border:none;" title="Eliminar este comentario" url="/img/img12.gif"/>
                                                        <f:param name="idSelComent" value="#{indiceComentario.idcoment}"/>
                                                </ice:commandLink>
                                                <ice:outputLabel id="lblComent" value="#{indiceComentario.comentario}"/>
                                                <div align="right"><ice:outputText id="lblFirma" value="#{indiceComentario.firma}"/></div>
                                            </ice:panelGroup>
                                            <ice:panelGroup rendered="#{!indiceComentario.aprobado}">Este comentario espera aprobación para ser mostrado.</ice:panelGroup>
                                        </ice:column>
                                    </ice:dataTable>
                                    <ice:panelGroup rendered="#{!jprocurUser.hayComentarios}">No hay comentarios para esta entrada.</ice:panelGroup>
                                </div>
                                <div align="center">
                                    <ice:dataPaginator for="tablaEntradaComentarios" id="paginadorComentarios" paginator="true" rendered="#{jprocurUser.showPagComentarios}">
                                        <f:facet name="first"><ice:graphicImage style="border:none;" title="First Page" url="./xmlhttp/css/rime/css-images/arrow-first.gif"/></f:facet>
                                        <f:facet name="previous"><ice:graphicImage style="border:none;" title="Prev Page" url="./xmlhttp/css/rime/css-images/arrow-previous.gif"/></f:facet>
                                        <f:facet name="next"><ice:graphicImage style="border:none;" title="Next Page" url="./xmlhttp/css/rime/css-images/arrow-next.gif"/></f:facet>
                                        <f:facet name="last"><ice:graphicImage style="border:none;" title="Last Page" url="./xmlhttp/css/rime/css-images/arrow-last.gif"/></f:facet>
                                    </ice:dataPaginator>
                                </div>
                                <br/>
                                    <ice:panelGroup id="pnlAddComent"
                                    rendered="#{jprocurUser.agregandoUnComentario}">
                                        Agrega un comentario a la entrada:<br/><ice:inputTextarea id="itComentario" title="Comentario"
                                        value="#{jprocurUser.comentarioNuevo.comentario}"
                                        partialSubmit="true"/><br/>
                                        Firma: <br/>
                                        <ice:inputText id="itC" title="Firma"
                                        value="#{jprocurUser.comentarioNuevo.firma}"
                                        partialSubmit="true" rendered="#{!jprocurUser.hayUsuarioLogueado}"/>
                                        <ice:outputLabel id="itC2" title="Firma"
                                        value="#{jprocurUser.currentUserName}"
                                        rendered="#{jprocurUser.hayUsuarioLogueado}"/>
                                    </ice:panelGroup>
                                <br/>
                                <ice:commandButton action="#{jprocurUser.toggleVista}" id="btnToggle" styleClass="btnAccion2" value="Regresar"/>
                                <ice:commandButton action="#{jprocurUser.agregandoComentario}"
                                id="btnAgregandoComentario" styleClass="btnAccion2"
                                value="Comentar" rendered="#{!jprocurUser.agregandoUnComentario}"/>
                                <ice:commandButton action="#{jprocurUser.agregarComentario}"
                                id="btnAgregarComentario" styleClass="btnAccion2"
                                value="Guardar Comentario" rendered="#{jprocurUser.agregandoUnComentario}"/>
                            </ice:panelGroup>
                            <ice:panelGroup id="panelVistaMultiple" rendered="#{!jprocurUser.soloUna}">
                                <ice:dataTable id="tablaEntradas" rows="5" value="#{jprocurUser.listaEntradas}" var="indiceEntrada">
                                    <ice:column id="columnaEntradas">
                                        <div class="post">
                                            <h2>
                                                <ice:commandLink action="#{jprocurUser.elegirEntradaActual}">
                                                    <ice:outputLabel id="lblTitulo" style="font-weight:bold; " value="#{indiceEntrada.titulo}"/>
                                                    <f:param name="idSeleccionado" value="#{indiceEntrada.identrada}"/>
                                                </ice:commandLink>
                                            </h2>
                                            <br/>
                                            <div align="right"><small><ice:outputLabel id="lblEntradaFechaMultiple" value="#{indiceEntrada.fechahora}"/></small></div>
                                            <br/>
                                            <ice:outputText id="lblDescripcion" value="#{indiceEntrada.descripcion}" escape="false"/>
                                            <br/>
                                        </div>
                                    </ice:column>
                                </ice:dataTable>
                                <div align="center">
                                    <ice:dataPaginator for="tablaEntradas" id="paginadorEntrada" paginator="true" rendered="#{jprocurUser.showPagEntradas}">
                                        <f:facet name="first"><ice:graphicImage style="border:none;" title="First Page" url="./xmlhttp/css/rime/css-images/arrow-first.gif"/></f:facet>
                                        <f:facet name="previous"><ice:graphicImage style="border:none;" title="Prev Page" url="./xmlhttp/css/rime/css-images/arrow-previous.gif"/></f:facet>
                                        <f:facet name="next"><ice:graphicImage style="border:none;" title="Next Page" url="./xmlhttp/css/rime/css-images/arrow-next.gif"/></f:facet>
                                        <f:facet name="last"><ice:graphicImage style="border:none;" title="Last Page" url="./xmlhttp/css/rime/css-images/arrow-last.gif"/></f:facet>
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
                                <ice:inputText id="itBusqueda" title="Búsqueda"
                                value="#{jprocurUser.criteriosBusqueda}" partialSubmit="true"/><ice:commandButton action="#{jprocurUser.busquedaEntradas}"
                                id="btnBusqueda" styleClass="btnAccion2"
                                value="Buscar"/>
                                </ice:form>
                            </li>
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
                                    <ice:commandLink action="#{Redireccion.jProCurAdmin}"
                                                rendered="#{JHardminInstance.currentUser.userRole.idrol == 1}" value="Administrar Cursos"/>
                                </li>
                                <li>
                                    <ice:commandLink action="#{Redireccion.jWikiAdmin}"
                                                rendered="#{JHardminInstance.currentUser.userRole.idrol == 1}" value="Administrar Wiki"/>
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
