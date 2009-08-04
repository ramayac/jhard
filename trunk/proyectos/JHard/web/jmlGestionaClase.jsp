<?xml version="1.0" encoding="UTF-8"?>
<!-- 
    Document   : jmlIniciaClase
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
                        <ice:form id="formIniciarClase">
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
                                    <h2>2. Confirma el horario</h2>
                                    Confirme el horario asignado para esta clase o practica para el Curso: <ice:outputLabel
                                        id="lblTituloCurso2" style="font-weight:bold; " value="#{jmlGestionaClase.cursoSeleccionado.nombre}"/>
                                    <ice:dataTable id="tabla2" rendered="#{jmlGestionaClase.hayHorariosValidos}" rows="10"
                                        value="#{jmlGestionaClase.listaHorariosValidos}" var="indiceHorario" width="100%">
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
                                    <ice:panelGroup rendered="#{!jmlIniciaClase.hayHorariosValidos}">
                                        <br/>
                                        <br/>
                                        <div align="center">
                                            <h2 class="title">Aviso:</h2>
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
                                    Tema de la clase/practica: <ice:inputText id="txtTema" partialSubmit="true"
                                        required="true" title="Tema de la clase/practica." value="#{jmlGestionaClase.nuevaClase.tema}"/>
                                    <br/>
                                    <br/>
                                    <div align="center">
                                        <ice:commandButton action="#{jmlGestionaClase.iniciarClase}" id="btnComenzar" styleClass="btnAccion2" value="Iniciar Clase"/>
                                        <ice:commandButton action="#{jmlGestionaClase.cancelar}" id="btnCancelar" styleClass="btnAccion2" value="Cancelar"/>
                                    </div>
                                </div>
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
