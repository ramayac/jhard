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
                <title>Administración de Promoción de Cursos</title>
                <meta content="" name="keywords"/>
                <meta content="" name="description"/>
                <link href="css/default.css" rel="stylesheet" type="text/css"/>
                <link href="img/favicon.ico" rel="shortcut icon" type="image/x-icon"/>
                <script charset="utf-8" src="js/jquery-1.2.3.js" type="text/javascript"></script>
                <script charset="utf-8" src="js/jquery.uitablefilter.js" type="text/javascript"></script>
                <script charset="utf-8" type="text/javascript">
                    jQuery.noConflict();
                    jQuery(document).ready(function() {
                        var tabla1 = jQuery("form table.mitablaentradas");
                        jQuery("#filtroTablaEntrada").keyup(function() {
                            jQuery.uiTableFilter(tabla1, this.value );
                        })
                        var tabla2 = jQuery("form table.mitablacomentarios");
                        jQuery("#filtroTablaComentarios").keyup(function() {
                            jQuery.uiTableFilter(tabla2, this.value );
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
                                <a href="jprocurUser.iface">Wiki y Cursos</a>
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
                            <ice:form id="formEntrada">
                                <ice:panelTabSet id="panelAdmin" tabPlacement="Top">
                                    <ice:panelTab id="panelEntradas" label="Administrar Entradas">
                                        <!-- panel de para EDITAR UNA ENTRADAS -->
                                        <ice:panelGroup id="panelEditarEntrada" rendered="#{jprocurAdmin.editandoEntrada}">
                                        <div class="post">
                                            Título: <ice:inputText id="itTitulo" title="Título de la entrada"
                                            value="#{jprocurAdmin.entradaActual.titulo}"
                                            partialSubmit="true"/>
                                            <br/>
                                            <ice:inputRichText id="richDescripcion"
                                            value="#{jprocurAdmin.entradaActual.descripcion}"
                                            language="es" skin="silver" toolbar="Basic"/>
                                            <br/>
                                            <br/>
                                            Escrito por: <ice:outputLabel id="lblAutor" style="font-weight:bold; " title="Último usuario que guardó la entrada."
                                            value="#{jprocurAdmin.entradaActual.idusuario.nombre}"/><div align="right"><ice:outputLabel
                                            id="lblFechaHora" value="#{jprocurAdmin.entradaActual.fechahora}" title="Fecha y hora de la última modificacion en la entrada."/>
                                            </div>
                                            <br/>
                                            <br/>
                                            Etiquetas:<br/>
                                            __aqui un panel con las etiquetas que se pueden poner__
                                            <br/>
                                            <div align="center">
                                            <ice:commandButton action="#{jprocurAdmin.modificarEntrada}" id="btnGuardar" styleClass="btnAccion2" value="Guardar"/>
                                            <ice:commandButton action="#{jprocurAdmin.cancelarGuardarEntrada}" id="btnCancelar" styleClass="btnAccion2" value="Cancelar"/>
                                            </div>
                                        </div>
                                        </ice:panelGroup>
                                        <!-- END panel de para EDITAR UNA ENTRADAS -->
                                        <!-- panel de para administrar las ENTRADAS -->
                                        <ice:panelGroup id="panelVistaMultipleEntradas" rendered="#{!jprocurAdmin.editandoEntrada}">
                                            <div align="right">Filtro: <input id="filtroTablaEntrada"/></div>
                                            <ice:dataTable id="tablaEntradas" rows="30" 
                                            value="#{jprocurAdmin.listaEntradas}" var="indiceEntrada" styleClass="mitablaentradas"
                                            rendered="#{jprocurAdmin.hayEntradas}">
                                                <ice:column>
                                                    <f:facet name="header">
                                                        <ice:outputText value="Título de la Entrada"/>
                                                    </f:facet>
                                                    <ice:outputLabel id="lblTitulo" style="font-weight:bold; " value="#{indiceEntrada.titulo}"/>
                                                </ice:column>
                                                <ice:column>
                                                    <f:facet name="header">
                                                        <ice:outputText value="Autor"/>
                                                    </f:facet>
                                                    <ice:outputLabel id="lblAutor" style="font-weight:bold; " value="#{indiceEntrada.idusuario.nombre}"/>
                                                </ice:column>
                                                <ice:column>
                                                    <f:facet name="header">
                                                        <ice:outputText value="Fecha de publicación"/>
                                                    </f:facet>
                                                    <ice:outputLabel id="lblFecha" style="font-weight:bold; " value="#{indiceEntrada.fecha}"/>
                                                </ice:column>
                                                <ice:column>
                                                    <f:facet name="header">
                                                        <ice:outputText value="Editar entrada"/>
                                                    </f:facet>
                                                    <ice:commandLink action="#{jprocurAdmin.EditarEntrada}" value="Editar">
                                                        <f:param name="idEntrada" value="#{indiceEntrada.identrada}"/>
                                                    </ice:commandLink>
                                                </ice:column>
                                                <ice:column>
                                                    <f:facet name="header">
                                                        <ice:outputText value="Eliminar entrada"/>
                                                    </f:facet>
                                                    <ice:commandLink action="#{jprocurAdmin.EliminarEntrada}" value="Eliminar">
                                                        <f:param name="idEntrada" value="#{indiceEntrada.identrada}"/>
                                                    </ice:commandLink>
                                                </ice:column>
                                            </ice:dataTable>
                                            <div align="center">
                                                <ice:dataPaginator for="tablaEntradas" id="paginadorEntrada" paginator="true" rendered="#{jprocurAdmin.showPagEntradas}">
                                                    <f:facet name="first"><ice:graphicImage style="border:none;" title="First Page" url="./xmlhttp/css/rime/css-images/arrow-first.gif"/></f:facet>
                                                    <f:facet name="previous"><ice:graphicImage style="border:none;" title="Prev Page" url="./xmlhttp/css/rime/css-images/arrow-previous.gif"/></f:facet>
                                                    <f:facet name="next"><ice:graphicImage style="border:none;" title="Next Page" url="./xmlhttp/css/rime/css-images/arrow-next.gif"/></f:facet>
                                                    <f:facet name="last"><ice:graphicImage style="border:none;" title="Last Page" url="./xmlhttp/css/rime/css-images/arrow-last.gif"/></f:facet>
                                                </ice:dataPaginator>
                                            </div>
                                        </ice:panelGroup>
                                        <!-- FIN panel de para administrar las ENTRADAS -->
                                    </ice:panelTab>
                                    <ice:panelTab id="panelEntrada" label="Agregar Entrada">
                                        <!-- panel de para agregar las Entradas -->
                                        <ice:panelGroup>
                                            <ice:panelGroup id="panelAgregarEntrada" style="float:left;margin-top:10px; width:580px;">
                                                Título: <ice:inputText id="itTitulo2" title="Título de la entrada"
                                                value="#{jprocurAdmin.entradaNueva.titulo}"
                                                partialSubmit="true"/>
                                                <br/><br/>
                                                <ice:inputRichText id="richDescripcion2"
                                                value="#{jprocurAdmin.entradaNueva.descripcion}"
                                                language="es" skin="silver" toolbar="Basic" height="500"/>
                                                <br/>
                                                <br/>
                                                Escrito por: <ice:outputLabel id="lblAutor2" style="font-weight:bold; " title=""
                                                value="#{jprocurAdmin.currentUserName}"/><div align="right"><ice:outputLabel
                                                id="lblFechaHora2" value="#{jprocurAdmin.entradaActual.fechahora}" title="Fecha y hora de la creacion de la entrada."/></div>
                                            </ice:panelGroup>
                                            <ice:panelGroup id="addTags" style="float:left;margin-top:10px;margin-left:15px;">
                                                <ice:dataTable id="listaEtiquetasAdd"
                                                               var="etiqueta"
                                                               value="#{jprocurAdmin.listaSelTag}">
                                                    <ice:column>
                                                        <ice:rowSelector id="selected"
                                                                         value="#{etiqueta.seleccionada}"
                                                                         multiple="true"
                                                                         preStyleOnSelection="true"/>
                                                        <f:facet name="header"><ice:outputText id="etiqueta" value="Etiquetas"/></f:facet>
                                                        <ice:outputText id="tagDesc" value="#{etiqueta.descripcion}"/>
                                                    </ice:column>
                                                </ice:dataTable>
                                            </ice:panelGroup>
                                            <ice:panelGroup>
                                                <div align="center">
                                                <ice:commandButton action="#{jprocurAdmin.agregarEntrada}" id="btnGuardar2" styleClass="btnAccion2" value="Guardar"/>
                                                <ice:commandButton action="#{jprocurAdmin.cancelarGuardarEntrada}" id="btnCancelar2" styleClass="btnAccion2" value="Cancelar"/>
                                                </div>
                                            </ice:panelGroup>
                                        </ice:panelGroup>
                                    </ice:panelTab>
                                    <ice:panelTab id="panelComentarios" label="Moderar Comentarios">
                                        <!-- panel de para moderar los Comentarios -->
                                        <ice:panelGroup id="panelVistaMultipleComentarios">
                                            <div align="right">Filtro: <input id="filtroTablaComentarios"/></div>
                                            <ice:dataTable id="tablaComentarios" rows="30" value="#{jprocurAdmin.listaComentarios}" 
                                            var="indiceComentario" styleClass="mitablacomentarios"
                                            rendered="#{jprocurAdmin.hayComentarios}">
                                                <ice:column>
                                                    <f:facet name="header">
                                                        <ice:outputText value="Comentario"/>
                                                    </f:facet>
                                                    <ice:outputLabel id="lblTitulo" style="font-weight:bold; " value="#{indiceComentario.comentario}"/>
                                                </ice:column>
                                                <ice:column>
                                                    <f:facet name="header">
                                                        <ice:outputText value="Autor"/>
                                                    </f:facet>
                                                    <ice:outputLabel id="lblAutor" style="font-weight:bold; " value="#{indiceComentario.firma}"/>
                                                </ice:column>
                                                <ice:column>
                                                    <f:facet name="header">
                                                        <ice:outputText value="Fecha de Publicación"/>
                                                    </f:facet>
                                                    <ice:outputLabel id="lblFecha" value="#{indiceEntrada.fechahorara}"/>
                                                </ice:column>
                                                <ice:column>
                                                    <f:facet name="header">
                                                        <ice:outputText value="Aprobar comentario"/>
                                                    </f:facet>
                                                    <ice:commandLink action="#{jprocurAdmin.AprobarComentario}" value="Aprobar">
                                                        <f:param name="idComentario" value="#{indiceComentario.idcoment}"/>
                                                    </ice:commandLink>
                                                </ice:column>
                                                <ice:column>
                                                    <f:facet name="header">
                                                        <ice:outputText value="Eliminar comentario"/>
                                                    </f:facet>
                                                    <ice:commandLink action="#{jprocurAdmin.EliminarComentario}" value="Eliminar">
                                                        <f:param name="idComentario" value="#{indiceComentario.idcoment}"/>
                                                    </ice:commandLink>
                                                </ice:column>
                                            </ice:dataTable>
                                            <div align="center">
                                                <ice:dataPaginator for="tablaComentarios" id="paginadorComentarios" paginator="true" rendered="#{jprocurAdmin.showPagComentarios}">
                                                    <f:facet name="first"><ice:graphicImage style="border:none;" title="First Page" url="./xmlhttp/css/rime/css-images/arrow-first.gif"/></f:facet>
                                                    <f:facet name="previous"><ice:graphicImage style="border:none;" title="Prev Page" url="./xmlhttp/css/rime/css-images/arrow-previous.gif"/></f:facet>
                                                    <f:facet name="next"><ice:graphicImage style="border:none;" title="Next Page" url="./xmlhttp/css/rime/css-images/arrow-next.gif"/></f:facet>
                                                    <f:facet name="last"><ice:graphicImage style="border:none;" title="Last Page" url="./xmlhttp/css/rime/css-images/arrow-last.gif"/></f:facet>
                                                </ice:dataPaginator>
                                            </div>
                                        </ice:panelGroup>
                                        <!-- FIN panel de para moderar los Comentarios -->
                                    </ice:panelTab>
                                    <ice:panelTab id="panelEtiquetas" label="Administrar Etiquetas">
                                        <!-- panel de para administrar las Etiquetas -->
                                        <ice:panelGroup id="panelGroup3" style=""/>
                                        <!-- FIN panel de para administrar las Etiquetas -->
                                    </ice:panelTab>
                                </ice:panelTabSet>

                                <!-- panel de mensajes para viñeta de Entradas-->
                                <ice:panelPopup autoCentre="true" id="panelMensajeEntradas" modal="true"
                                rendered="#{jprocurAdmin.popupElimEntrada}">
                                <f:facet name="header">
                                    <ice:panelGrid id="ppEntrada">
                                        <ice:outputText id="otxtTituloEntrada" value="JProcur"/>
                                    </ice:panelGrid>
                                </f:facet>
                                <f:facet name="body">
                                <div class="post">
                                    <ice:panelGroup id="pgEntrada">
                                        <ice:outputText binding="#{jprocurAdmin.lblMensajesEntrada}" id="lblMensajesEntrada" value="Mensajes AQUI"/><br/><br/>
                                        <div align="center">
                                        <ice:panelGrid columns="2" id="panelBotonesEntrada">
                                            <ice:commandButton action="#{jprocurAdmin.btnAceptarElimEntr_action}" id="btnEliminarEntrada" value="Eliminar" rendered="#{jprocurAdmin.entradaValida}"/>
                                            <ice:commandButton action="#{jprocurAdmin.btnCancelarMensajes_action}" id="btnCancelarEntrada" value="Cancelar" rendered="#{jprocurAdmin.entradaValida}"/>
                                            <ice:commandButton action="#{jprocurAdmin.btnCancelarMensajes_action}" id="btnOKEntrada" value="OK" rendered="#{!jprocurAdmin.entradaValida}"/>
                                        </ice:panelGrid>
                                        </div>
                                    </ice:panelGroup>
                                </div>
                                </f:facet>
                                </ice:panelPopup>
                                <!-- panel de mensajes -->

                                <!-- panel de mensajes para viñeta de Comentarios-->
                                <ice:panelPopup autoCentre="true" id="panelMensajeComentarios" modal="true" rendered="#{jprocurAdmin.popupComentario}">
                                <f:facet name="header">
                                    <ice:panelGrid id="ppComentarios">
                                        <ice:outputText id="otxtTituloComentarios" value="JProcur"/>
                                    </ice:panelGrid>
                                </f:facet>
                                <f:facet name="body">
                                <div class="post">
                                    <ice:panelGroup id="pgComentarios">
                                        <ice:outputText binding="#{jprocurAdmin.lblMensajesComentarios}" id="lblMensajesComentarios" value="Mensajes AQUI"/><br/><br/>
                                        <div align="center">
                                        <ice:panelGrid columns="2" id="panelBotonesComentarios">
                                            <ice:commandButton action="#{jprocurAdmin.btnAprobarComentario_action}" id="btnAprobarComentarios" value="Aprobar" rendered="#{jprocurAdmin.aprobarComentario}"/>
                                            <ice:commandButton action="#{jprocurAdmin.btnEliminarComentario_action}" id="btnEliminarComentarios" value="Eliminar" rendered="#{jprocurAdmin.eliminarComentario}"/>
                                            <ice:commandButton action="#{jprocurAdmin.btnCancelarMensajes_action}" id="btnCancelarComentarios" value="Cancelar" rendered="#{jprocurAdmin.comentarioValido}"/>
                                            <ice:commandButton action="#{jprocurAdmin.btnCancelarMensajes_action}" id="btnOKComentarios" value="OK" rendered="#{!jprocurAdmin.comentarioValido}"/>
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
                                    <p><ice:outputLabel id="lblUser" value="Usuario:"/><ice:inputText id="txtUser" required="true" requiredMessage="El nombre de usuario es requerido" style="width: 120px" value="#{JHardminInstance.inputUsrName}"/><h:message for="txtUser" styleClass="errorText"/></p>
                                    <p><ice:outputLabel id="lblPass" value="Clave:"/><ice:inputSecret id="txtPass" required="true" requiredMessage="La clave de acceso es requerida" style="width: 120px" value="#{JHardminInstance.inputUsrPassword}"/><h:message for="txtPass" styleClass="errorText"/></p>
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
