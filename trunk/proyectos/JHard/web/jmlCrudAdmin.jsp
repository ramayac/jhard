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
                                    <ice:panelTab id="panelCarrera" label="Gestionar Carrera">
                                        <!-- panel de para Agregar, Modificar y Eliminar Carrera -->
                                        <ice:panelGroup>
                                            <ice:dataTable id="tablaCarrera" rendered="#{jmlCrudAdmin.hayCarrera}" rows="30" styleClass="mitablacarrera"
                                            value="#{jmlCrudAdmin.listaCarrera}" var="indiceCarrera" resizable="true"
                                            width="100%">
                                                <ice:column>
                                                    <f:facet name="header"><ice:outputText value="Código del curso"/></f:facet>
                                                    <ice:outputLabel style="font-weight:bold; " value="#{indiceCarrera.codigo}"/>
                                                </ice:column>
                                                <ice:column>
                                                    <f:facet name="header"><ice:outputText value="Nombre de la carrera"/></f:facet>
                                                    <ice:outputLabel style="font-weight:bold; " value="#{indiceCarrera.nombre}"/>
                                                </ice:column>
                                                <ice:column>
                                                    <f:facet name="header"><ice:outputText value="Editar carrera"/></f:facet>
                                                    <ice:commandLink action="#{jmlCrudAdmin.editarCarrera}" value="Editar">
                                                        <f:param name="idCarrera" value="#{indiceCarrera.idcarrera}"/>
                                                    </ice:commandLink>
                                                </ice:column>
                                                <ice:column>
                                                    <f:facet name="header"><ice:outputText value="Eliminar carrera"/></f:facet>
                                                    <ice:commandLink action="#{jmlCrudAdmin.eliminarCarrera}" value="Eliminar">
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
                                            </div><br/>
                                            <ice:commandButton action="#{jmlCrudAdmin.btnNuevaCarrera_action}" value="Nueva carrera" styleClass="btnAccion2"/>
                                            <br/><br/>
                                            <ice:panelCollapsible expanded="#{jmlCrudAdmin.addModCarrera}">
                                                <f:facet name="header"><ice:panelGroup><ice:outputText value="Agregar/Editar Carrera" /></ice:panelGroup></f:facet>
                                                <ice:panelGroup>
                                                Código: <ice:inputText id="itCarrCode" title="Código de la carrera"
                                                value="#{jmlCrudAdmin.nuevaCarrera.codigo}"
                                                partialSubmit="true"/>
                                                Nombre: <ice:inputText id="itCarrNombre" title="Nombre de la carrera"
                                                value="#{jmlCrudAdmin.nuevaCarrera.nombre}"
                                                partialSubmit="true"/><br/><ice:commandButton action="#{jmlCrudAdmin.btnCarrera_action}" value="Guardar"  styleClass="btnAccion2"/><ice:commandButton action="#{jmlCrudAdmin.btnCarreraClean_action}" value="Limpiar"  styleClass="btnAccion2"/>
                                                </ice:panelGroup>
                                            </ice:panelCollapsible>
                                        </ice:panelGroup>
                                        <!-- FIN panel -->
                                    </ice:panelTab>
                                    <ice:panelTab id="panelMateria" label="Gestionar Materia">
                                        <!-- panel de para Agregar, Modificar y Eliminar Materias -->
                                        <ice:panelGroup>
                                            <ice:dataTable id="tablaMaterias" rendered="#{jmlCrudAdmin.hayMateria}" rows="30" styleClass="mitablamaterias"
                                            value="#{jmlCrudAdmin.listaMateria}" var="indiceMateria" resizable="true"
                                            width="100%">
                                                <ice:column>
                                                    <f:facet name="header"><ice:outputText value="Código del curso"/></f:facet>
                                                    <ice:outputLabel style="font-weight:bold; " value="#{indiceMateria.codigo}"/>
                                                </ice:column>
                                                <ice:column>
                                                    <f:facet name="header"><ice:outputText value="Nombre de la materia"/></f:facet>
                                                    <ice:outputLabel style="font-weight:bold; " value="#{indiceMateria.nombre}"/>
                                                </ice:column>
                                                <ice:column>
                                                    <f:facet name="header"><ice:outputText value="Editar materia"/></f:facet>
                                                    <ice:commandLink action="#{jmlCrudAdmin.editarMateria}" value="Editar">
                                                        <f:param name="idMateria" value="#{indiceMateria.idmateria}"/>
                                                    </ice:commandLink>
                                                </ice:column>
                                                <ice:column>
                                                    <f:facet name="header"><ice:outputText value="Eliminar materia"/></f:facet>
                                                    <ice:commandLink action="#{jmlCrudAdmin.eliminarMateria}" value="Eliminar">
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
                                            </div><br/>
                                            <ice:commandButton action="#{jmlCrudAdmin.btnNuevaMateria_action}" value="Nueva materia" styleClass="btnAccion2"/>
                                            <br/><br/>
                                            <ice:panelCollapsible expanded="#{jmlCrudAdmin.addModMateria}">
                                                <f:facet name="header"><ice:panelGroup><ice:outputText value="Agregar/Editar Materia"/></ice:panelGroup></f:facet>
                                            <ice:panelGroup>
                                                Seleccione la carrera a la que pertenece la materia:<br/>
                                                <ice:selectOneMenu id="idSelCarr" partialSubmit="true"
                                                value="#{jmlCrudAdmin.carreraSelStr}"
                                                valueChangeListener="#{jmlCrudAdmin.selCarrera}">
                                                    <f:selectItems id="carrSel" value="#{jmlCrudAdmin.listaCarreraSel}"/>
                                                </ice:selectOneMenu><br/>
                                                Código: <ice:inputText id="itMatCode" title="Código de la materia" maxlength="7"
                                                value="#{jmlCrudAdmin.nuevaMateria.codigo}" partialSubmit="true"/>
                                                Nombre: <ice:inputText id="itMatNombre" title="Nombre de la asignatura" maxlength="200"
                                                value="#{jmlCrudAdmin.nuevaMateria.nombre}" partialSubmit="true"/>
                                                <br/><ice:commandButton action="#{jmlCrudAdmin.btnMateria_action}" value="Guardar" styleClass="btnAccion2"/><ice:commandButton action="#{jmlCrudAdmin.btnMateriaClean_action}" value="Limpiar"  styleClass="btnAccion2"/>
                                            </ice:panelGroup>
                                            </ice:panelCollapsible>
                                        </ice:panelGroup>
                                        <!-- FIN panel -->
                                    </ice:panelTab>
                                    <ice:panelTab id="panelCurso" label="Gestionar Curso">
                                        <!-- panel de para Agregar, Modificar y Eliminar Cursos -->
                                        <ice:panelGroup>
                                            <ice:dataTable id="tablaCurso" rendered="#{jmlCrudAdmin.hayCurso}" rows="30" styleClass="mitablacurso"
                                            value="#{jmlCrudAdmin.listaCurso}" var="indiceCurso" resizable="true"
                                            width="100%">
                                                <ice:column>
                                                    <f:facet name="header"><ice:outputText value="Nombre del curso"/></f:facet>
                                                    <ice:outputLabel style="font-weight:bold; " value="#{indiceCurso.nombre}"/>
                                                </ice:column>
                                                <ice:column>
                                                    <f:facet name="header"><ice:outputText value="Editar curso"/></f:facet>
                                                    <ice:commandLink action="#{jmlCrudAdmin.editarCurso}" value="Editar">
                                                        <f:param name="idCurso" value="#{indiceCurso.idcurso}"/>
                                                    </ice:commandLink>
                                                </ice:column>
                                                <ice:column>
                                                    <f:facet name="header"><ice:outputText value="Eliminar curso"/></f:facet>
                                                    <ice:commandLink action="#{jmlCrudAdmin.eliminarCurso}" value="Eliminar">
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
                                            </div><br/>
                                            <ice:commandButton action="#{jmlCrudAdmin.btnNuevoCurso_action}" value="Nuevo curso" styleClass="btnAccion2"/>
                                            <br/><br/>
                                            <ice:panelCollapsible expanded="#{jmlCrudAdmin.addModCurso}">
                                                <f:facet name="header"><ice:panelGroup><ice:outputText value="Agregar/Editar Curso"/></ice:panelGroup></f:facet>
                                            <ice:panelGroup>
                                                <table border="0">
                                                    <tr>
                                                        <td>Nombre:</td>
                                                        <td><ice:inputText id="itCursoNombre" title="Nombre del curso" value="#{jmlCrudAdmin.nuevoCurso.nombre}"
                                                        maxlength="200" partialSubmit="true"/></td>
                                                    </tr>
                                                    <tr>
                                                        <td>Cupo:</td>
                                                        <td><ice:inputText id="itCupoMax" title="Cupo máximo" value="#{jmlCrudAdmin.nuevoCurso.cupomax}"
                                                        maxlength="2" partialSubmit="true"/></td>
                                                    </tr>
                                                    <tr>
                                                        <td>Fecha de Inicio del Curso:</td>
                                                        <td><ice:selectInputDate id="popfecha" renderMonthAsDropdown="true" renderYearAsDropdown="true"
                                                value="#{jmlCrudAdmin.nuevoCurso.fechainicio}" title="Fecha de inicio" renderAsPopup="true">
                                                    <f:convertDateTime pattern="dd/MM/yyyy" timeZone="#{jmlCrudAdmin.timeZone}"/>
                                                </ice:selectInputDate></td>
                                                    </tr>
                                                    <tr>
                                                        <td>Ciclo:</td>
                                                        <td><ice:selectOneMenu id="idSelCiclo" value="#{jmlCrudAdmin.nuevoCurso.ciclo}" partialSubmit="true">
                                                    <f:selectItem itemLabel="Impar" itemValue="1" />
                                                    <f:selectItem itemLabel="Par" itemValue="2" />
                                                </ice:selectOneMenu></td>
                                                    </tr>
                                                    <tr>
                                                        <td>Habilitar inscripcion:</td>
                                                        <td><ice:selectOneRadio partialSubmit="true" value="#{jmlCrudAdmin.nuevoCurso.habilinscrip}">
                                                    <f:selectItem itemLabel="Habilitar" itemValue="false"/>
                                                    <f:selectItem itemLabel="Deshabilitar" itemValue="true"/>
                                                </ice:selectOneRadio></td>
                                                    </tr>
                                                    <tr>
                                                        <td>Docentes:</td>
                                                        <td><ice:selectOneMenu id="idSelDoc" partialSubmit="true" value="#{jmlCrudAdmin.docenteSelStr}" valueChangeListener="#{jmlCrudAdmin.selDocente}">
                                                    <f:selectItems id="docSel" value="#{jmlCrudAdmin.listaDocenteSel}"/>
                                                </ice:selectOneMenu></td>
                                                    </tr>
                                                    <tr>
                                                        <td>Instructor:</td>
                                                        <td><ice:selectOneMenu id="idSelInst" partialSubmit="true" value="#{jmlCrudAdmin.instructorSelStr}" valueChangeListener="#{jmlCrudAdmin.selInstructor}">
                                                    <f:selectItems id="instSel" value="#{jmlCrudAdmin.listaInstructorSel}"/>
                                                </ice:selectOneMenu></td>
                                                    </tr>
                                                    <tr>
                                                        <td>Materia:</td>
                                                        <td><ice:selectOneMenu id="idSelMat" partialSubmit="true" value="#{jmlCrudAdmin.materiaSelStr}" valueChangeListener="#{jmlCrudAdmin.selMateria}">
                                                    <f:selectItems id="matSel" value="#{jmlCrudAdmin.listaMateriaSel}"/>
                                                </ice:selectOneMenu></td>
                                                    </tr>    
                                                </table>
                                                <div align="left">
                                                <ice:commandButton action="#{jmlCrudAdmin.btnCurso_action}" value="Guardar" styleClass="btnAccion2"/><ice:commandButton action="#{jmlCrudAdmin.btnCursoClean_action}" value="Limpiar"  styleClass="btnAccion2"/>
                                                </div>
                                            </ice:panelGroup>
                                            </ice:panelCollapsible>
                                        </ice:panelGroup>
                                        <!-- FIN panel -->
                                    </ice:panelTab>
                                </ice:panelTabSet>
                                <ice:panelGroup rendered="#{!jmlCrudAdmin.permisos}">
                                    <jsp:directive.include file="/jspf/nologin.jspx"/>
                                </ice:panelGroup>
                                <!-- panel de mensajes de avisos...-->
                                <ice:panelPopup autoCentre="true" id="ppmsj" modal="true" rendered="#{jmlCrudAdmin.popup.visible}">
                                    <f:facet name="header">
                                        <ice:panelGrid><ice:outputText id="pptit" value="#{jmlCrudAdmin.popup.titulo}"/></ice:panelGrid>
                                    </f:facet>
                                    <f:facet name="body">
                                    <div class="post">
                                        <ice:panelGroup>
                                            <ice:outputText id="lblppmsj" value="#{jmlCrudAdmin.popup.mensaje}"/>
                                            <br/>
                                            <br/>
                                            <div align="center">
                                                <ice:commandButton action="#{jmlCrudAdmin.btnOK_action}" id="ppok" value="OK"  styleClass="btnAccion2"/>
                                            </div>
                                        </ice:panelGroup>
                                        </div>
                                    </f:facet>
                                </ice:panelPopup>
                                <!-- panel de mensajes -->
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
