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
                                <ice:form id="form1" style="">
                                    <ice:panelTabSet height="528" id="tabJrequestAdmin" selectedIndex="3"
                                        tabChangeListener="#{jrequestAdmin.tabJrequestAdmin_processTabChange}" tabPlacement="Top" width="600">
                                        <ice:panelTab id="tabSolicitudes" label="Solicitudes" style="vertical-align: top; width: 72px">
                                            <ice:panelGroup id="grupo1" style="position: inherit; width: 100%; ">
                                                <ice:outputLabel id="outputLabel6" style="font-size: 15px; font-weight: bold; width: 550px" value="Seleccione una solicitud de la lista de la derecha y asígnela a Mantenimiento"/>
                                            </ice:panelGroup>
                                            <ice:panelDivider id="divisor1" orientation="vertical" style="height: 500px; position: inherit; width: 100%">
                                                <f:facet name="first">
                                                    <ice:panelGroup id="panelGroup1" style=" position: inherit; width: 100%; ">
                                                        <ice:selectOneListbox binding="#{jrequestAdmin.listaSol}" id="listaSol" partialSubmit="true" size="2"
                                                            style="height: 360px; width: 252px" value="" valueChangeListener="#{jrequestAdmin.listaSol_processValueChange}">
                                                            <f:selectItems id="selectOneListbox1selectItems" value="#{jrequestAdmin.listaSolDefaultItems}"/>
                                                        </ice:selectOneListbox>
                                                    </ice:panelGroup>
                                                </f:facet>
                                                <f:facet name="second">
                                                    <ice:panelGroup id="grupo2" style="position: inherit; width: 100%; ">
                                                        <p>
                                                            <ice:outputLabel id="outputLabel2" style="font-weight: bold; width: 190px" value="NOMBRE PERSONA ENCARGADA"/>
                                                        </p>
                                                        <p>
                                                            <ice:outputLabel binding="#{jrequestAdmin.lblPersona}" id="lblPersona" style="" value="PERSONA"/>
                                                        </p>
                                                        <p>
                                                            <ice:outputLabel id="outputLabel1" style="font-weight: bold; width: 144px" value="NOMBRE SOLICITUD"/>
                                                        </p>
                                                        <p>
                                                            <ice:outputLabel binding="#{jrequestAdmin.lblNombre}" id="lblNombre" style="" value="NOMBRE"/>
                                                        </p>
                                                        <p>
                                                            <ice:outputLabel id="outputLabel3" style="font-weight: bold; " value="PRIORIDAD"/>
                                                        </p>
                                                        <p>
                                                            <ice:selectOneMenu binding="#{jrequestAdmin.comboPrioridad}" id="comboPrioridad"
                                                                partialSubmit="true" style="width: 192px" value="#{jrequestAdmin.selectOneMenu1Bean.selectedObject}">
                                                                <f:selectItems id="selectOneMenu1selectItems" value="#{jrequestAdmin.comboPrioridadDefaultItems}"/>
                                                            </ice:selectOneMenu>
                                                        </p>
                                                        <p>
                                                            <ice:outputLabel id="outputLabel5" style="font-weight: bold; width: 144px" value="TÉCNICO A ASIGNAR"/>
                                                        </p>
                                                        <p>
                                                            <ice:selectOneMenu binding="#{jrequestAdmin.comboTecnicos}" id="comboTecnicos" partialSubmit="true"
                                                                style="width: 192px" value="" valueChangeListener="#{jrequestAdmin.comboTecnicos_processValueChange}">
                                                                <f:selectItems id="selectOneMenu2selectItems" value="#{jrequestAdmin.arrayTecnicos.options['idtecnico,nombres']}"/>
                                                            </ice:selectOneMenu>
                                                        </p>
                                                        <p>
                                                            <ice:commandButton action="#{jrequestAdmin.btnProceder_action}" id="btnProceder" style="" value="Proceder a Mantenimiento"/>
                                                        </p>
                                                        <p>
                                                            <ice:commandButton action="#{jrequestAdmin.btnSolicitudAdmin_action}"
                                                                binding="#{jrequestAdmin.btnSolicitudAdmin}" id="btnSolicitudAdmin" style="width: 168px" value="Realizar una Solicitud"/>
                                                        </p>
                                                    </ice:panelGroup>
                                                </f:facet>
                                            </ice:panelDivider>
                                        </ice:panelTab>
                                        <ice:panelTab id="tabMantenimientos" label="Mantenimientos">
                                            <ice:panelGroup id="panelGroup2" style="height: 504px; position: inherit; width: 100%; ">
                                                <p>
                                                    <ice:outputLabel id="outputLabel4" style="width: 406px" value="Seleccione un Trabajo de mantenimiento, e indique si ya ha finalizado"/>
                                                    <br/>
                                                    <br/>
                                                </p>
                                                <p>
                                                    <ice:selectOneListbox binding="#{jrequestAdmin.listaMantenimientos}" id="listaMantenimientos"
                                                        partialSubmit="true" size="2" style="height: 360px; width: 500px"
                                                        value="#{jrequestAdmin.defaultSelectedData5.selectedObject}" valueChangeListener="#{jrequestAdmin.listaMantenimientos_processValueChange}">
                                                        <f:selectItems id="selectOneListbox1selectItems1" value="#{jrequestAdmin.listaMantenimientosDefaultItems}"/>
                                                    </ice:selectOneListbox>
                                                </p>
                                                <ice:panelPopup autoCentre="true" binding="#{jrequestAdmin.popUpBitacora}" draggable="true" id="popUpBitacora"
                                                    modal="true" rendered="#{jrequestAdmin.panelPopup2Bean.showDraggablePanel}"
                                                    style="display: block; height: 309px; left: 288px; top: 552px; position: absolute; width: 381px" visible="#{jrequestAdmin.panelPopup2Bean.showModalPanel}">
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
                                                            <ice:outputLabel id="outputLabel13" value="Escriba el plan de Mantenimiento llevado a cabo:"/>
                                                            <ice:inputTextarea binding="#{jrequestAdmin.txtDescripcion}" id="txtDescripcion"/>
                                                            <ice:outputLabel id="outputLabel12" value="Nuevo Estado del Equipo"/>
                                                            <ice:selectOneMenu binding="#{jrequestAdmin.comboEstado}" id="comboEstado" partialSubmit="true"
                                                                value="#{jrequestAdmin.defaultSelectedData9.selectedObject}" valueChangeListener="#{jrequestAdmin.comboEstado_processValueChange}">
                                                                <f:selectItems id="selectOneMenu1selectItems1" value="#{jrequestAdmin.selectOneMenu1DefaultItems2}"/>
                                                            </ice:selectOneMenu>
                                                            <ice:commandButton action="#{jrequestAdmin.btnAceptarFinalizado_action}"
                                                                binding="#{jrequestAdmin.btnAceptarFinalizado}" id="btnAceptarFinalizado" value="OK"/>
                                                            <ice:commandButton action="#{jrequestAdmin.btnCerrar_action}" binding="#{jrequestAdmin.btnCerrar}"
                                                                id="btnCerrar" value="Cerrar"/>
                                                        </ice:panelGrid>
                                                    </f:facet>
                                                </ice:panelPopup>
                                            </ice:panelGroup>
                                        </ice:panelTab>
                                        <ice:panelTab id="tadAdministracion" label="Administracion">
                                            <p>
                                                <ice:outputLabel id="outputLabel9" style="font-size: 14px; font-weight: bold; width: 444px" value="Agregue o elimine Técnicos para servicio de Soporte Tecnico. "/>
                                                <br/>
                                                <br/>
                                            </p>
                                            <ice:panelDivider id="divisor2" orientation="vertical">
                                                <f:facet name="first">
                                                    <ice:panelGroup id="panelGroup3" style="position: inherit; width: 528px;">
                                                        <ice:selectOneListbox binding="#{jrequestAdmin.listaTecnicos}" id="listaTecnicos" partialSubmit="true"
                                                            size="2" style="height: 250px; width: 192px"
                                                            value="#{jrequestAdmin.defaultSelectedData7.selectedObject}" valueChangeListener="#{jrequestAdmin.listaTecnicos_processValueChange}">
                                                            <f:selectItems id="selectOneListbox1selectItems2" value="#{jrequestAdmin.selectOneListbox1DefaultItems6}"/>
                                                        </ice:selectOneListbox>
                                                    </ice:panelGroup>
                                                </f:facet>
                                                <f:facet name="second">
                                                    <ice:panelGroup id="grupo4" style="position: inherit; width: 528px;">
                                                        <p>
                                                            <ice:outputLabel id="outputLabel10" style="font-size: 16px; font-weight: bold; width: 142px" value="Nombre Completo"/>
                                                        </p>
                                                        <p>
                                                            <ice:outputLabel binding="#{jrequestAdmin.lblNombreTec}" id="lblNombreTec" style="width: 214px" value="Nombre del tecnico"/>
                                                        </p>
                                                        <p>
                                                            <ice:commandButton action="#{jrequestAdmin.btnAgregarTec_action}"
                                                                binding="#{jrequestAdmin.btnAgregarTec}" id="btnAgregarTec" style="width: 168px" value="Agregar Nuevo Técnico"/>
                                                        </p>
                                                        <p>
                                                            <ice:commandButton action="#{jrequestAdmin.btnEliminarTec_action}"
                                                                binding="#{jrequestAdmin.btnEliminarTec}" id="btnEliminarTec" style="width: 168px" value="Eliminar Técnico"/>
                                                        </p>
                                                    </ice:panelGroup>
                                                </f:facet>
                                            </ice:panelDivider>
                                            <ice:panelPopup autoCentre="true" binding="#{jrequestAdmin.popUpAgregarTec}" draggable="true" id="popUpAgregarTec"
                                                modal="true" rendered="#{jrequestAdmin.panelPopup1Bean.showDraggablePanel}"
                                                style="display: block; height: 172px; left: 276px; top: 665px; position: absolute; width: 285px" visible="#{jrequestAdmin.panelPopup1Bean.showModalPanel}">
                                                <f:facet name="header">
                                                    <ice:panelGrid id="panelGrid5" style="display:block;width:180px;height:20px;">
                                                        <ice:outputText id="outputText1" value="Agregar Técnico"/>
                                                    </ice:panelGrid>
                                                </f:facet>
                                                <f:facet name="body">
                                                    <ice:panelGrid columns="2" id="panelGrid6" style="display: block; height: 134px" width="278">
                                                        <ice:outputLabel id="outputLabel7" value="Nombres"/>
                                                        <ice:inputText binding="#{jrequestAdmin.txtNomTec}" id="txtNomTec"/>
                                                        <ice:outputLabel id="outputLabel8" value="Apellidos"/>
                                                        <ice:inputText binding="#{jrequestAdmin.txtApeTec}" id="txtApeTec"/>
                                                        <ice:commandButton action="#{jrequestAdmin.btnOkTec_action}" binding="#{jrequestAdmin.btnOkTec}"
                                                            id="btnOkTec" value="Agregar"/>
                                                        <ice:commandButton action="#{jrequestAdmin.btnCerrarTec_action}" binding="#{jrequestAdmin.btnCerrarTec}"
                                                            id="btnCerrarTec" value="Cerrar"/>
                                                    </ice:panelGrid>
                                                </f:facet>
                                            </ice:panelPopup>
                                        </ice:panelTab>
                                        <ice:panelTab id="tabBitacoras" label="Bitacoras" style="">
                                            <ice:panelGroup id="panelGroup4" style="height: 552px; position: inherit; width: 576px">
                                                        <p>
                                                <ice:outputLabel id="outputLabel11" style="font-weight:bold; font-size:14px;" value="Seleccione un equipo simple para visualizar y/o modificar su bitácora"/>
                                                </p>
                                                <p>
                                                <ice:selectInputText action="#{jrequestAdmin.txtEqSimples_action}" binding="#{jrequestAdmin.txtEqSimples}"
                                                    id="txtEqSimples" rows="50" style="visibility: visible;"
                                                    valueChangeListener="#{jrequestAdmin.txtEqSimples_processValueChange}" visible="true" width="300">
                                                    <f:selectItems id="selectInputText1selectedItems" value="#{jrequestAdmin.arrayEqSimples.options['idEquipoSimple,descripcion']}"/>
                                                </ice:selectInputText>
                                                </p>
                                                <p>
                                                <ice:selectOneListbox binding="#{jrequestAdmin.listaBitacoras}" id="listaBitacoras" partialSubmit="true"
                                                    size="2" style="height: 350px; width: 300px"
                                                    value="#{jrequestAdmin.defaultSelectedData8.selectedObject}" valueChangeListener="#{jrequestAdmin.listaBitacoras_processValueChange}">
                                                    <f:selectItems id="selectOneListbox1selectItems3" value="#{jrequestAdmin.selectOneListbox1DefaultItems}"/>
                                                </ice:selectOneListbox>
                                                </p>
                                                <ice:panelPopup autoCentre="true" binding="#{jrequestAdmin.popUpModBitacora}" draggable="true"
                                                    id="popUpModBitacora" modal="true" rendered="#{jrequestAdmin.panelPopup1Bean2.showDraggablePanel}"
                                                    style="display: block; height: 261px; left: 264px; top: 552px; position: absolute; width: 381px" visible="#{jrequestAdmin.panelPopup1Bean2.showModalPanel}">
                                                    <f:facet name="header">
                                                        <ice:panelGrid id="panelGrid7" style="display:block;width:180px;height:20px;">
                                                            <ice:outputText id="outputText2" value="Bitácora de Equipos"/>
                                                        </ice:panelGrid>
                                                    </f:facet>
                                                    <f:facet name="body">
                                                        <ice:panelGrid id="panelGrid99" style="display:block;width:340px;height:168px;">
                                                            <ice:outputText id="outputText3" style="width: 310px" value="Para actualizar esta bitácora, modifique en el cuadro de texto inferior"/>
                                                            <ice:inputTextarea binding="#{jrequestAdmin.txtModBitacora}" id="txtModBitacora" style="height: 119px; width: 287px"/>
                                                            <ice:commandButton action="#{jrequestAdmin.btnAceptarModBitacora_action}"
                                                                binding="#{jrequestAdmin.btnAceptarModBitacora}" id="btnAceptarModBitacora" value="Aceptar"/>
                                                            <ice:commandButton action="#{jrequestAdmin.btnCancelarModBitacora_action}"
                                                                binding="#{jrequestAdmin.btnCancelarModBitacora}" id="btnCancelarModBitacora" value="Cerrar"/>
                                                        </ice:panelGrid>
                                                    </f:facet>
                                                </ice:panelPopup>
                                            </ice:panelGroup>
                                        </ice:panelTab>
                                        <ice:panelTab id="tabReportes" label="Reportes" style="">
                                            <ice:panelGroup id="panelGroup5" style="height: 480px; position: inherit; width: 100%;"/>
                                        </ice:panelTab>
                                    </ice:panelTabSet>
                                    <ice:panelPopup autoCentre="true" binding="#{jrequestAdmin.popUpMensajes}" draggable="true" id="popUpMensajes" modal="true" style="display: block; width: 214px;visibility: hidden;visibility: hidden;">
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
                                <h2>
                                    <ice:outputLabel id="txtUserLogin" value="Sesión"/>
                                </h2>
                                <ice:form id="frmLogin" rendered="#{JHardminInstance.currentUser == null}">
                                    <ice:outputText id="lblLoginFail" rendered="#{JHardminInstance.loginFail}" styleClass="errorText" value="Datos incorrectos"/>
                                    <p>
                                        <ice:outputLabel id="lblUser" value="Usuario:"/>
                                        <ice:inputText id="txtUser" required="true" requiredMessage="El nombre de usuario es requerido" style="width: 120px" value="#{JHardminInstance.inputUsrName}"/>
                                        <h:message for="txtUser" styleClass="errorText"/>
                                    </p>
                                    <p>
                                        <ice:outputLabel id="lblPass" value="Clave:"/>
                                        <ice:inputSecret id="txtPass" required="true" requiredMessage="La clave de acceso es requerida" style="width: 120px" value="#{JHardminInstance.inputUsrPassword}"/>
                                        <h:message for="txtPass" styleClass="errorText"/>
                                    </p>
                                    <ice:commandButton action="#{JHardminInstance.login}" id="btnLogin" styleClass="btnAccion" value="Login"/>
                                </ice:form>
                                <ice:form id="frmLogout" rendered="#{JHardminInstance.currentUser != null}">
                                    <p>
                                        <ice:outputLabel id="lblBienvenido" value="Bienvenido usuario"/>
                                        <ice:outputLabel id="lblNomUsuario" styleClass="formValue" value="#{JHardminInstance.currentUser.userName}"/>
                                    </p>
                                    <ice:commandButton action="#{JHardminInstance.logout}" id="btnLogout" styleClass="btnAccion" value="Logout"/>
                                </ice:form>
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
