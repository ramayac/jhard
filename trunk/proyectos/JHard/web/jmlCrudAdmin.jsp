<?xml version="1.0" encoding="UTF-8"?>
<!-- 
    Document   : jmlCrudAdmin
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
                <title>Administración del Laboratorio</title>
                <meta content="" name="keywords"/>
                <meta content="" name="description"/>
                <link href="css/default.css" rel="stylesheet" type="text/css"/>
                <link href="img/favicon.ico" rel="shortcut icon" type="image/x-icon"/>
                <script charset="utf-8" src="js/jquery-1.2.3.js" type="text/javascript"></script>
                <script charset="utf-8" src="js/jquery.uitablefilter.js" type="text/javascript"></script>
                <script charset="utf-8" type="text/javascript">
                    jQuery.noConflict();
                    jQuery(document).ready(function() {
                        var tabla = jQuery("form table.mitablamaterias");
                        jQuery("#filtroTablaMaterias").keyup(function() {
                            jQuery.uiTableFilter(tabla, this.value );
                        })
                        var tabla = jQuery("form table.mitablacurso");
                        jQuery("#filtroTablaCurso").keyup(function() {
                            jQuery.uiTableFilter(tabla, this.value );
                        })
                        var tabla = jQuery("form table.mitablacarrera");
                        jQuery("#filtroTablaCarrera").keyup(function() {
                            jQuery.uiTableFilter(tabla, this.value );
                        })
                    });
                </script>
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
                            <h2 class="title">Administración del Laboratorio</h2>
                        </div>
                        <ice:form id="formAdmLab">
                            <ice:panelTabSet tabPlacement="Top" rendered="#{jmlCrudAdmin.permisos}">
                                    <ice:panelTab id="panelMateria" label="Gestionar Materia">
                                        <!-- panel de para Agregar, Modificar y Eliminar Materias -->
                                        <ice:panelGroup>
                                            <div align="right">Filtro: <input id="filtroTablaMaterias"/></div>
                                            <ice:dataTable id="tablaMaterias" rendered="#{jmlCrudAdmin.hayMateria}" rows="30" styleClass="mitablamaterias"
                                            value="#{jmlCrudAdmin.listaMateria}" var="indiceMateria" resizable="true">
                                                <ice:column>
                                                    <f:facet name="header"><ice:outputText value="Nombre de la materia"/></f:facet>
                                                    <ice:outputLabel style="font-weight:bold; " value="#{indiceMateria.nombre}"/>
                                                </ice:column>
                                                <ice:column>
                                                    <f:facet name="header"><ice:outputText value="Editar materia"/></f:facet>
                                                    <ice:commandLink action="#{indiceMateria.EditarMateria}" value="Editar">
                                                        <f:param name="idMateria" value="#{indiceMateria.idmateria}"/>
                                                    </ice:commandLink>
                                                </ice:column>
                                                <ice:column>
                                                    <f:facet name="header"><ice:outputText value="Eliminar materia"/></f:facet>
                                                    <ice:commandLink action="#{indiceMateria.EliminarMateria}" value="Eliminar">
                                                        <f:param name="idMateria" value="#{indiceMateria.idmateria}"/>
                                                    </ice:commandLink>
                                                </ice:column>
                                            </ice:dataTable>
                                            <div align="center">
                                                <ice:dataPaginator for="tablaMaterias" id="paginadorMaterias" paginator="true"
                                                rendered="#{jmlCrudAdmin.showPagMateria}">
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
                                        <!-- FIN panel -->
                                    </ice:panelTab>
                                    <ice:panelTab id="panelCurso" label="Gestionar Curso">
                                        <!-- panel de para Agregar, Modificar y Eliminar Cursos -->
                                        <ice:panelGroup>
                                            <div align="right">Filtro: <input id="filtroTablaCursos"/></div>
                                            <ice:dataTable id="tablaCurso" rendered="#{jmlCrudAdmin.hayCurso}" rows="30" styleClass="mitablacurso"
                                            value="#{jmlCrudAdmin.listaCurso}" var="indiceCurso" resizable="true">
                                                <ice:column>
                                                    <f:facet name="header"><ice:outputText value="Nombre del curso"/></f:facet>
                                                    <ice:outputLabel style="font-weight:bold; " value="#{indiceCurso.nombre}"/>
                                                </ice:column>
                                                <ice:column>
                                                    <f:facet name="header"><ice:outputText value="Editar curso"/></f:facet>
                                                    <ice:commandLink action="#{indiceCurso.EditarCurso}" value="Editar">
                                                        <f:param name="idCurso" value="#{indiceCurso.idcurso}"/>
                                                    </ice:commandLink>
                                                </ice:column>
                                                <ice:column>
                                                    <f:facet name="header"><ice:outputText value="Eliminar curso"/></f:facet>
                                                    <ice:commandLink action="#{indiceCurso.EliminarCurso}" value="Eliminar">
                                                        <f:param name="idCurso" value="#{indiceCurso.idcurso}"/>
                                                    </ice:commandLink>
                                                </ice:column>
                                            </ice:dataTable>
                                            <div align="center">
                                                <ice:dataPaginator for="tablaCurso" id="paginadorCurso" paginator="true"
                                                rendered="#{jmlCrudAdmin.showPagCurso}">
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
                                        <!-- FIN panel -->
                                    </ice:panelTab>
                                    <ice:panelTab id="panelCarrera" label="Gestionar Carrera">
                                        <!-- panel de para Agregar, Modificar y Eliminar Carrera -->
                                        <ice:panelGroup>
                                            <div align="right">Filtro: <input id="filtroTablaCarrera"/></div>
                                            <ice:dataTable id="tablaCarrera" rendered="#{jmlCrudAdmin.hayCurso}" rows="30" styleClass="mitablacarrera"
                                            value="#{jmlCrudAdmin.listaCarrera}" var="indiceCarrera" resizable="true">
                                                <ice:column>
                                                    <f:facet name="header"><ice:outputText value="Nombre de la carrera"/></f:facet>
                                                    <ice:outputLabel style="font-weight:bold; " value="#{indiceCarrera.nombre}"/>
                                                </ice:column>
                                                <ice:column>
                                                    <f:facet name="header"><ice:outputText value="Editar carrera"/></f:facet>
                                                    <ice:commandLink action="#{indiceCarrera.EditarCarrera}" value="Editar">
                                                        <f:param name="idCarrera" value="#{indiceCarrera.idcarrera}"/>
                                                    </ice:commandLink>
                                                </ice:column>
                                                <ice:column>
                                                    <f:facet name="header"><ice:outputText value="Eliminar carrera"/></f:facet>
                                                    <ice:commandLink action="#{indiceCarrera.EliminarCarrera}" value="Eliminar">
                                                        <f:param name="idCarrera" value="#{indiceCarrera.idcarrera}"/>
                                                    </ice:commandLink>
                                                </ice:column>
                                            </ice:dataTable>
                                            <div align="center">
                                                <ice:dataPaginator for="tablaCarrera" id="paginadorCarrera" paginator="true"
                                                rendered="#{jmlCrudAdmin.showPagCarrera}">
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
                                        <!-- FIN panel -->
                                    </ice:panelTab>
                                </ice:panelTabSet>
                                <ice:panelGroup rendered="#{!jmlCrudAdmin.permisos}">
                                    <jsp:directive.include file="/jspf/nologin.jspx"/>
                                </ice:panelGroup>
                        </ice:form>
                        <br/>
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
