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
                                Etiquetas: <ice:outputLabel id="lblEtiquetas" style="font-weight:bold; " value="#{jprocurUser.etiquetasString}"/>
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
                                            <ice:outputLabel id="lblDescripcion" value="#{indiceEntrada.descripcion}"/>
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
                                <ice:inputText id="itBusqueda" title="Búsqueda por etiquetas"
                                value="#{jprocurUser.criteriosBusqueda}" partialSubmit="true"/><ice:commandButton action="#{jprocurUser.busquedaEntradas}"
                                id="btnBusquedaEtiquetas" styleClass="btnAccion2"
                                value="Buscar"/>
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
