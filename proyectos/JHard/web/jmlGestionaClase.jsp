<?xml version="1.0" encoding="UTF-8"?>
<!-- 
    Document   : jmlGestionaClase
    Created on : 08-02-2009, 03:07:30 PM
    Author     : rodrigo
-->
<jsp:root version="2.1" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:ice="http://www.icesoft.com/icefaces/component" xmlns:jsp="http://java.sun.com/JSP/Page">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
    <f:view>
        <html id="outputHtml1">
            <head id="outputHead1">
                <ice:outputStyle href="css/stylesheet.css" id="outputStyle1"/>
                <ice:outputStyle href="./xmlhttp/css/rime/rime.css" id="outputStyle2"/>
                <meta content="text/html; charset=utf-8" http-equiv="content-type"/>
                <title>Cursos del Laboratorio</title>
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
                        <ice:form id="formGestionarClases">
                            <ice:panelGroup id="panelAccion" rendered="#{jmlGestionaClase.mostrarAcciones}">
                                <div class="post">
                                    <h2>Gestiona Clase/Practica</h2>
                                    Seleccione la acción que desea realizar...<br/><br/>
                                    <div align="center">
                                        <ice:commandButton action="#{jmlGestionaClase.btnGoPaso1_action}" id="btnGoPaso1" styleClass="btnAccion2" value="Iniciar una Clase/Practica"/>
                                        <br/>
                                        <ice:commandButton action="#{jmlGestionaClase.btnGoPaso4_action}" id="btnGoPaso4" styleClass="btnAccion2" value="Terminar una Clase/Practica"/>
                                    </div>
                                </div>
                            </ice:panelGroup>
                            <!-- Seccion de Inicio de la Clase -->
                            <ice:panelGroup id="panel1" rendered="#{jmlGestionaClase.paso1}">
                                <div class="post">
                                    <h2>1. Seleccion de un Curso</h2>
                                    Seleccione de la siguiente lista el curso al que pertenece esta clase o practica a realizar en el laboratorio...
                                    <ice:dataTable
                                        id="tabla1" rows="10" value="#{jmlGestionaClase.listaCursos}" var="indiceCurso" width="100%">
                                        <ice:column id="columnaCursos">
                                            <f:facet name="header">Lista de Cursos</f:facet>
                                            <ice:commandLink action="#{jmlGestionaClase.elegirCurso}">
                                                <ice:outputLabel id="lblTituloCurso" style="font-weight:bold; " value="#{indiceCurso.nombre}"/>
                                                <f:param name="idCurso" value="#{indiceCurso.idcurso}"/>
                                            </ice:commandLink>
                                        </ice:column>
                                    </ice:dataTable>
                                </div>
                            </ice:panelGroup>
                            <ice:panelGroup id="panel2" rendered="#{jmlGestionaClase.paso2}">
                                <div class="post">
                                    <ice:panelGroup rendered="#{jmlGestionaClase.hayHorariosValidos}">
                                        <h2>2. Confirma el horario</h2>
                                        Confirme el horario asignado para esta clase o practica para el Curso: <ice:outputLabel
                                        id="lblTituloCurso2" style="font-weight:bold; " value="#{jmlGestionaClase.cursoSeleccionado.nombre}"/>
                                        <ice:dataTable id="tabla2" value="#{jmlGestionaClase.listaHorariosValidos}" var="indiceHorario" width="100%">
                                            <ice:column id="columnaHorarios">
                                                <f:facet name="header">Lista de Horarios Programados para este día</f:facet>
                                                <ice:commandLink action="#{jmlGestionaClase.elegirHorario}">
                                                    <ice:outputLabel id="lblDiaSemana" style="font-weight:bold; "
                                                        value="#{indiceHorario.nombrediasemana}"/>-<ice:outputLabel id="lblHoraInicio" style="font-weight:bold; "
                                                        value="#{indiceHorario.horainicioformated}"/>-<ice:outputLabel id="lblHoraFin" style="font-weight:bold; "
                                                        value="#{indiceHorario.horafinformated}"/>-<ice:outputLabel id="lblAula" style="font-weight:bold; " value="#{indiceHorario.idaula.nombre}"/>
                                                    <f:param name="idHorario" value="#{indiceHorario.idhorario}"/>
                                                </ice:commandLink>
                                            </ice:column>
                                        </ice:dataTable>
                                    </ice:panelGroup>
                                    <ice:panelGroup rendered="#{!jmlGestionaClase.hayHorariosValidos}">
                                        <h2 class="title">Aviso:</h2>
                                        <div align="center">
                                            <ul><li>No hay un horario asignable para este instante.</li></ul>
                                        <br/>
                                        <ice:commandButton action="#{jmlGestionaClase.cancelar}" styleClass="btnAccion2" value="Cancelar"/>
                                        </div>
                                    </ice:panelGroup>
                                </div>
                            </ice:panelGroup>
                            <ice:panelGroup id="panel3" rendered="#{jmlGestionaClase.paso3}">
                                <div class="post">
                                    <h2>3. Inicia la clase</h2>
                                    Introduzca el Tema de la Clase, y luego de clic en el boton "Iniciar Clase".
                                    Si cometio algun error, o eligio un horario incorrecto, de clic en el boton Cancelar.
                                    <br/>
                                    <br/>
                                    <div align="center">
                                    Tema de la clase/practica: <ice:inputText id="txtTema" partialSubmit="true" maxlength="45"
                                        required="true" title="Tema de la clase/practica." value="#{jmlGestionaClase.nuevaClase.tema}"/>
                                    <br/><br/>
                                    Observaciones: <br/><ice:inputTextarea id="txtObservaciones" partialSubmit="true"
                                            title="Observaciones" value="#{jmlGestionaClase.nuevaClase.observaciones}"/>
                                    <br/><br/>
                                        <ice:commandButton action="#{jmlGestionaClase.iniciarClase}" id="btnComenzar" styleClass="btnAccion2" value="Iniciar Clase"/>
                                        <ice:commandButton action="#{jmlGestionaClase.cancelar}" id="btnCancelar" styleClass="btnAccion2" value="Cancelar"/>
                                    </div>
                                </div>
                            </ice:panelGroup>
                            <ice:panelGroup rendered="#{jmlGestionaClase.yaHayClase}">
                                <div class="post">
                                <h2 class="title">Aviso:</h2>
                                <div align="center">
                                <ul><li>Ya existe una clase con ese horario asignado.</li></ul>
                                <br/>
                                <ice:commandButton action="#{jmlGestionaClase.cancelar}" styleClass="btnAccion2" value="Regresar"/>
                                </div>
                                </div>
                            </ice:panelGroup>
                            <!-- Fin de Seccion de Inicio de la Clase -->

                            <!-- Seccion de Terminar la Clase -->
                            <ice:panelGroup id="panel4" rendered="#{jmlGestionaClase.paso4}">
                                <div class="post">
                                    <ice:panelGroup rendered="#{!jmlGestionaClase.haylistaClaseVacia}">
                                    <h2>Terminar una Clase/Practica</h2>
                                    Seleccione de la siguiente lista, la clase/practica que desea dar por "Terminada".
                                    <ice:dataTable id="tablaClases" value="#{jmlGestionaClase.listaClases}" var="indiceClase" width="100%">
                                        <ice:column id="columnaClase">
                                            <f:facet name="header">Lista de Clases/Practicas</f:facet>
                                            <ice:outputLabel style="font-weight:bold; " value="#{indiceClase.tema}"/>
                                        </ice:column>
                                        <ice:column id="columnaAccion">
                                            <f:facet name="header">Terminar Clase/Practica</f:facet>
                                            <ice:commandLink action="#{jmlGestionaClase.terminarClase}">
                                                <ice:outputLabel value="Terminar"/>
                                                <f:param name="idClaseTerminar" value="#{indiceClase.idclase}"/>
                                            </ice:commandLink>
                                        </ice:column>
                                    </ice:dataTable>
                                    <br/>
                                    <div align="center"><ice:commandButton action="#{jmlGestionaClase.cancelar}" styleClass="btnAccion2" value="Regresar"/></div>
                                    </ice:panelGroup>
                                    <ice:panelGroup rendered="#{jmlGestionaClase.haylistaClaseVacia}">
                                        <h2 class="title">Aviso:</h2>
                                        <div align="center">
                                        <ul><li>No hay clases/practicas que se puedan marcar como "terminadas" en este momento.</li></ul>
                                        <br/>
                                        <ice:commandButton action="#{jmlGestionaClase.cancelar}" styleClass="btnAccion2" value="Regresar"/>
                                        </div>
                                    </ice:panelGroup>
                                </div>
                            </ice:panelGroup>
                            <!-- Fin Seccion de Terminar la Clase -->

                            <!-- panel de mensajes de avisos...-->
                            <ice:panelPopup autoCentre="true" id="ppmsj" modal="true" rendered="#{jmlGestionaClase.popup.visible}">
                                <f:facet name="header">
                                    <ice:panelGrid><ice:outputText id="pptit" value="#{jmlGestionaClase.popup.titulo}"/></ice:panelGrid>
                                </f:facet>
                                <f:facet name="body">
                                <div class="post">
                                    <ice:panelGroup>
                                        <ice:outputText id="lblppmsj" value="#{jmlGestionaClase.popup.mensaje}"/>
                                        <br/>
                                        <br/>
                                        <div align="center">
                                        <ice:commandButton action="#{jmlGestionaClase.btnGoBegin_action}" id="ppok" value="OK"/>
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
                <jsp:directive.include file="/jspf/bottom.jspx"/>
                <!-- end footer -->
            </body>
        </html>
    </f:view>
</jsp:root>
