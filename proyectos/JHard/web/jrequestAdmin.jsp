<?xml version="1.0" encoding="UTF-8"?>
<!-- 
    Document   : jrequestAdmin
    Created on : 18-jun-2009, 14:18:49
    Author     : Hugol
-->
<jsp:root version="2.1" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:ice="http://www.icesoft.com/icefaces/component" xmlns:jsp="http://java.sun.com/JSP/Page">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
    <f:view>
        <html id="outputHtml1">
            <head id="outputHead1">
                <ice:outputStyle href="css/stylesheet.css" id="outputStyle1"/>
                <ice:outputStyle href="./xmlhttp/css/xp/xp.css" id="outputStyle2"/>
                <meta content="text/html; charset=utf-8" http-equiv="content-type"/>
                <title>.:: JRequest ::.</title>
                <meta content="" name="keywords"/>
                <meta content="" name="description"/>
                <link href="css/default.css" rel="stylesheet" type="text/css"/>
                <link href="img/favicon.ico" rel="shortcut icon" type="image/x-icon"/>
            </head>
            <body id="outputBody1" style="-rave-layout: grid">
                <!--start header -->
                <div id="header">
                    <div id="menu">
                        <ul>
                            <li class="current_page_item">
                                <a href="Index.iface">Principal</a>
                            </li>
                            <li>
                                <a href="jrequestAdmin.iface">Mantenimientos</a>
                            </li>
                            <li>
                                <a href="#">Grupos de Laboratorio</a>
                            </li>
                            <li>
                                <a href="#">Inventario</a>
                            </li>
                            <li>
                                <a href="#">Wiki y Cursos</a>
                            </li>
                            <li class="last">
                                <a href="#">Cañones</a>
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
                            <h2 class="title">Mantenimiento de Hardware y Software</h2>
                            <div class="entry">
                                <p class="text">Administración de Solicitudes de Mantenimiento UES-FMOcc</p>
                                <ice:form id="form1">
                                    <ice:panelTabSet height="648" id="tabJrequestAdmin" selectedIndex="1"
                                        tabChangeListener="#{jrequestAdmin.tabJrequestAdmin_processTabChange}" tabPlacement="Top" width="720">
                                        <ice:panelTab id="tabSolicitudes" label="Solicitudes" style="vertical-align: bottom; width: 72px">
                                            <ice:panelLayout id="panelLayout1" layout="flow" style="height: 576px; position: inherit; width: 100%; -rave-layout: grid">
                                                <ice:selectOneListbox binding="#{jrequestAdmin.listaSol}" id="listaSol" partialSubmit="true" size="2"
                                                    style="height: 360px; left: 298px; top: 426px; position: absolute; width: 252px" value="" valueChangeListener="#{jrequestAdmin.listaSol_processValueChange}">
                                                    <f:selectItems id="selectOneListbox1selectItems" value="#{jrequestAdmin.selectOneListbox1DefaultItems}"/>
                                                </ice:selectOneListbox>
                                                <ice:selectOneMenu binding="#{jrequestAdmin.comboTecnicos}" id="comboTecnicos" partialSubmit="true"
                                                    style="left: 598px; top: 694px; position: absolute; width: 192px" value="" valueChangeListener="#{jrequestAdmin.comboTecnicos_processValueChange}">
                                                    <f:selectItems id="selectOneMenu2selectItems" value="#{jrequestAdmin.arrayTecnicos.options['idtecnico,nombres']}"/>
                                                </ice:selectOneMenu>
                                                <ice:outputLabel id="outputLabel1"
                                                    style="font-weight: bold; left: 600px; top: 432px; position: absolute; width: 144px" value="NOMBRE SOLICITUD"/>
                                                <ice:outputLabel id="outputLabel2"
                                                    style="font-weight: bold; left: 600px; top: 528px; position: absolute; width: 190px" value="NOMBRE PERSONA ENCARGADA"/>
                                                <ice:outputLabel id="outputLabel3" style="font-weight: bold; left: 600px; top: 600px; position: absolute" value="PRIORIDAD"/>
                                                <ice:commandButton action="#{jrequestAdmin.btnProceder_action}" id="btnProceder"
                                                    style="left: 624px; top: 744px; position: absolute" value="Proceder a Mantenimiento"/>
                                                <ice:outputLabel binding="#{jrequestAdmin.lblNombre}" id="lblNombre"
                                                    style="left: 600px; top: 456px; position: absolute" value="NOMBRE"/>
                                                <ice:outputLabel binding="#{jrequestAdmin.lblPersona}" id="lblPersona"
                                                    style="left: 600px; top: 552px; position: absolute" value="PERSONA"/>
                                                <ice:selectOneMenu binding="#{jrequestAdmin.comboPrioridad}" id="comboPrioridad" partialSubmit="true"
                                                    style="left: 598px; top: 622px; position: absolute; width: 192px" value="#{jrequestAdmin.selectOneMenu1Bean.selectedObject}">
                                                    <f:selectItems id="selectOneMenu1selectItems" value="#{jrequestAdmin.selectOneMenu1DefaultItems}"/>
                                                </ice:selectOneMenu>
                                                <ice:outputLabel id="outputLabel5"
                                                    style="font-weight: bold; left: 600px; top: 672px; position: absolute; width: 144px" value="TÉCNICO A ASIGNAR"/>
                                                <ice:outputLabel id="outputLabel6"
                                                    style="font-size: 15px; font-weight: bold; left: 288px; top: 360px; position: relative; width: 550px" value="Seleccione un a solicitud de la lista de la derecha y asígnela a Mantenimiento"/>
                                            </ice:panelLayout>
                                        </ice:panelTab>
                                        <ice:panelTab id="tabMantenimientos" label="Mantenimientos">
                                            <ice:panelLayout id="panelLayout2" layout="flow" style="height: 555px; position: inherit; width: 100%; -rave-layout: grid">
                                                <ice:selectOneListbox binding="#{jrequestAdmin.listaMantenimientos}" id="listaMantenimientos"
                                                    partialSubmit="true" size="2"
                                                    style="height: 360px; left: 334px; top: 406px; position: absolute; width: 456px"
                                                    value="#{jrequestAdmin.defaultSelectedData5.selectedObject}" valueChangeListener="#{jrequestAdmin.listaMantenimientos_processValueChange}">
                                                    <f:selectItems id="selectOneListbox1selectItems1" value="#{jrequestAdmin.selectOneListbox1DefaultItems3}"/>
                                                </ice:selectOneListbox>
                                                <ice:outputLabel id="outputLabel4" style="left: 360px; top: 360px; position: absolute; width: 406px" value="Seleccione un Trabajo de mantenimiento, e indique si ya ha finalizado"/>
                                            </ice:panelLayout>
                                        </ice:panelTab>
                                        <ice:panelTab id="tadAdministracion" label="Administracion">
                                            <ice:panelLayout id="panelLayout3" layout="flow" style="height: 576px; position: inherit; width: 100%; -rave-layout: grid"/>
                                        </ice:panelTab>
                                        <ice:panelTab id="tabReportes" label="Reportes" style="">
                                            <ice:panelLayout id="panelLayout4" layout="flow" style="height: 552px; position: inherit; width: 100%; -rave-layout: grid"/>
                                        </ice:panelTab>
                                    </ice:panelTabSet>
                                    <ice:panelPopup binding="#{jrequestAdmin.popUpBitacora}" draggable="true" id="popUpBitacora"
                                        rendered="#{jrequestAdmin.panelPopup2Bean.showDraggablePanel}" style="display: block; height: 189px; width: 357px" visible="#{jrequestAdmin.panelPopup2Bean.showModalPanel}">
                                        <f:facet name="header">
                                            <ice:panelGrid id="panelGrid3" style="display:block;width:180px;height:20px;">
                                                <ice:outputText id="lblTituloMan" value="Mantenimientos JRequest"/>
                                            </ice:panelGrid>
                                        </f:facet>
                                        <f:facet name="body">
                                            <ice:panelGrid id="panelGrid4" style="display: block; height: 134px" width="326">
                                                <ice:outputText binding="#{jrequestAdmin.lblMantenimiento}" id="lblMantenimiento" value="MANTENIMIENTO QUE ESTARA FINALIZADO"/>
                                                <ice:outputLabel id="lblFin" value="Finalizado"/>
                                                <ice:selectBooleanCheckbox binding="#{jrequestAdmin.checkFIn}" id="checkFIn" partialSubmit="true" value="#{jrequestAdmin.selectBooleanCheckbox1Bean.selectedBoolean}"/>
                                                <ice:commandButton action="#{jrequestAdmin.btnAceptarFinalizado_action}"
                                                    binding="#{jrequestAdmin.btnAceptarFinalizado}" id="btnAceptarFinalizado" value="OK"/>
                                                <ice:commandButton action="#{jrequestAdmin.btnCerrar_action}" binding="#{jrequestAdmin.btnCerrar}"
                                                    id="btnCerrar" value="Cerrar"/>
                                            </ice:panelGrid>
                                        </f:facet>
                                    </ice:panelPopup>
                                    <ice:panelPopup binding="#{jrequestAdmin.popUpMensajes}" draggable="true" id="popUpMensajes"
                                        rendered="#{jrequestAdmin.panelPopup1Bean.showDraggablePanel}" style="display: block; width: 214px" visible="#{jrequestAdmin.panelPopup1Bean.showModalPanel}">
                                        <f:facet name="header">
                                            <ice:panelGrid id="panelGrid1" style="display:block;width:180px;height:20px;">
                                                <ice:outputText id="lblJText" value="JRequest"/>
                                            </ice:panelGrid>
                                        </f:facet>
                                        <f:facet name="body">
                                            <ice:panelGrid id="panelGrid2" style="display:block;width:180px;height:80px;">
                                                <ice:outputText binding="#{jrequestAdmin.lblMensajes}" id="lblMensajes" value="Texto de Mensajes"/>
                                                <ice:commandButton action="#{jrequestAdmin.btnOK_action}" binding="#{jrequestAdmin.btnOK}" id="btnOK" value="OK"/>
                                            </ice:panelGrid>
                                        </f:facet>
                                    </ice:panelPopup>
                                </ice:form>
                                <br/>
                            </div>
                        </div>
                    </div>
                    <!-- end content -->
                    <!-- start sidebar -->
                    <div id="sidebar">
                        <ul>
                            <li id="search">
                                <h2>Búsqueda Wiki</h2>
                                <form action="" method="get">
                                    <fieldset>
                                        <input class="inputTexto" name="s" type="text" value=""/>
                                        <input class="inputBoton" type="submit" value="Buscar"/>
                                    </fieldset>
                                </form>
                            </li>
                            <li>
                                <h2>Usuarios</h2>
                AQUI VA EL LOGIN
	</li>
                            <li>
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
                            </li>
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
