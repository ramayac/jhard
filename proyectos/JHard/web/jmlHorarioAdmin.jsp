<?xml version="1.0" encoding="UTF-8"?>
<!-- 
    Document   : jmlHorarioAdmin
    Created on : 01-ago-2009, 9:41:03
    Author     : Hugol 
-->
<jsp:root version="2.1" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:ice="http://www.icesoft.com/icefaces/component" xmlns:jsp="http://java.sun.com/JSP/Page">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
    <f:view>
        <html id="outputHtml1">
            <head id="outputHead1">
                <ice:outputStyle href="css/stylesheet.css" id="outputStyle1"/>
                <ice:outputStyle href="./xmlhttp/css/rime/rime.css" id="outputStyle2"/>
                <meta content="text/html; charset=utf-8" http-equiv="content-type"/>
                <title>.:: ManLab ::.</title>
                <meta content="" name="keywords"/>
                <meta content="" name="description"/>
                <link href="css/default.css" rel="stylesheet" type="text/css"/>
                <link href="img/favicon.ico" rel="shortcut icon" type="image/x-icon"/>
                <script charset="utf-8" type="text/javascript">
                   var win=null;
                   function calendar(mypage,myname,w,h,scroll,pos)
                   {
                        if(pos=="random"){LeftPosition=(screen.width)?Math.floor(Math.random()*(screen.width-w)):100;TopPosition=(screen.height)?Math.floor(Math.random()*((screen.height-h)-75)):100;}
                        if(pos=="center"){LeftPosition=(screen.width)?(screen.width-w)/2:100;TopPosition=(screen.height)?(screen.height-h)/2:100;}
                        else if((pos!="center") || pos==null){LeftPosition=0;TopPosition=20}
                        settings='width='+w+',height='+h+',top='+TopPosition+',left='+LeftPosition+',scrollbars='+scroll+',location=no,directories=no,status=no,menubar=no,toolbar=no,resizable=no';
                        win=window.open(mypage,myname,settings);
                        win.resizeTo(screen.width, screen.height);
                        win.moveTo(0, 0);
                   }
                </script>
            </head>
            <body id="outputBody1" onload="init();" style="-rave-layout: grid">
                <!--start header -->
                <jsp:directive.include file="/jspf/menu.jspx"/>
                <!-- end header -->
                <!-- start page -->
                <div id="page">
                    <!-- start content -->
                    <div id="content">
                        <div class="post">
                            <h2 class="title">Administración de Horarios</h2>
                            <ice:form id="jmlHorarioAds">
                                <ice:panelGroup id="grupoJCanonAdmin" style="width: 100%; ">
                                    <ice:panelCollapsible expanded="true" id="panelCollapsible1" style="width: 576px; margin-top:0px; margin-bottom:0px;">
                                        <f:facet name="header">
                                            <ice:panelGroup id="panelGroup1" styleClass="">
                                                <ice:outputText id="outputText1" value="Reservas de Equipo Multimedia"/>
                                            </ice:panelGroup>
                                        </f:facet>
                                        <ice:panelGroup id="grupoContenido" style="margin-top:0px; margin-bottom:0px; overflow-x: auto;">
                                            <ice:dataTable id="tblListaHorarios" rows="10" style="margin-top: 0px; margin-bottom: 0px;"
                                                title="Lista de Horarios de Grupos de Prácticas LABCOM-1" value="#{jmlHorarioAdmin.listaHorarios}" var="horario">
                                                <ice:column>
                                                    <f:facet name="header">
                                                        <ice:outputText value="Grupo de Práctica"/>
                                                    </f:facet>
                                                    <ice:outputText value="#{horario.idcurso.idmateria.nombre} - #{horario.idcurso.nombre}"/>
                                                </ice:column>
                                                <ice:column>
                                                    <f:facet name="header">
                                                        <ice:outputText value="Día"/>
                                                    </f:facet>
                                                    <ice:outputText value="#{horario.diaSemanal}"/>
                                                </ice:column>
                                                <ice:column>
                                                    <f:facet name="header">
                                                        <ice:outputText value="Hora Inico"/>
                                                    </f:facet>
                                                    <ice:outputText value="#{horario.start}"/>
                                                </ice:column>
                                                <ice:column>
                                                    <f:facet name="header">
                                                        <ice:outputText value="Hora Fin"/>
                                                    </f:facet>
                                                    <ice:outputText value="#{horario.end}"/>
                                                </ice:column>
                                                <ice:column>
                                                    <ice:commandLink action="#{jmlHorarioAdmin.modificarHorario}" value="Modificar Horario">
                                                        <f:param name="idHorario" value="#{horario.idhorario}"/>
                                                    </ice:commandLink>
                                                </ice:column>
                                                <ice:column>
                                                    <ice:commandLink action="#{jmlHorarioAdmin.EliminarHorario}" value="Eliminar">
                                                        <f:param name="idHorario" value="#{horario.idhorario}"/>
                                                    </ice:commandLink>
                                                </ice:column>
                                            </ice:dataTable>
                                            <ice:dataPaginator for="tblListaHorarios" id="pgrListaHorarios" paginator="true" paginatorMaxPages="4" style="margin: 0px 10px 10px">
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
                                            <br/>
                                            <br/>
                                            <h3>
                                                <ice:outputLabel value="Otras Tareas"/>
                                            </h3>
                                            <br/>
                                            <ice:commandLink action="#{jmlHorarioAdmin.EliminarHorarios}" value="Eliminar todos los horarios de este ciclo"/>
                                        </ice:panelGroup>
                                    </ice:panelCollapsible>
                                </ice:panelGroup>
                                <ice:panelPopup autoCentre="true" draggable="true" id="panelModHorario" modal="true" rendered="#{jmlHorarioAdmin.renderPop}" style="height: 141px; left: 264px; top: 144px; position: absolute; width: 333px;visibility: hidden;visibility: hidden;">
                                    <f:facet name="header">
                                        <ice:panelGrid id="panelGrid1" style="display:block;width:180px;height:20px;">
                                            <ice:outputText id="lblTitModHorario" value="ManLab"/>
                                        </ice:panelGrid>
                                    </f:facet>
                                    <f:facet name="body">
                                        <ice:panelGroup id="panelGrid2" style="display: block;">
                                            <ice:outputLabel value="#{jmlHorarioAdmin.horarioAmodificar}"/>
                                            <ice:outputLabel rendered="#{jmlHorarioAdmin.noInscripcion}" style="font-size:14px" value="No se puede inscribir grupo en ese horario. No se encuentra disponible"/>
                                            <table border="1" cellpadding="4">
                                                <tr>
                                                    <td rowspan="2">
                                                        <ice:outputLabel id="outputLabel1" style="font-size:12px;" value="Día"/>
                                                        <br/>
                                                        <br/>
                                                        <ice:selectOneListbox binding="#{jmlHorarioAdmin.listaDiaSemana}" id="listaDiaSemana"
                                                            partialSubmit="true" size="6" style="width: 100px" valueChangeListener="#{jmlHorarioAdmin.listaDiaSemana_processValueChange}">
                                                            <f:selectItems id="selectOneListbox1selectItems" value="#{jmlHorarioAdmin.diaSemana}"/>
                                                        </ice:selectOneListbox>
                                                    </td>
                                                    <td valign="TOP">
                                                        <ice:outputLabel id="outputLabel2" style="font-size:12px;" value="Hora de Inicio"/>
                                                        <br/>
                                                        <br/>
                                                        <ice:selectOneMenu binding="#{jmlHorarioAdmin.comboHoraInicio}" id="comboHoraInicio"
                                                            partialSubmit="true" valueChangeListener="#{jmlHorarioAdmin.comboHoraInicio_processValueChange}">
                                                            <f:selectItems id="selectOneMenu1selectItems" value="#{jmlHorarioAdmin.horaInicio}"/>
                                                        </ice:selectOneMenu>
                                                    </td>
                                                    <td valign="TOP">
                                                        <ice:outputLabel id="outputLabel3" style="font-size:12px;" value="Hora de Finalización"/>
                                                        <br/>
                                                        <br/>
                                                        <ice:selectOneMenu binding="#{jmlHorarioAdmin.comboHoraFin}" id="comboHoraFin" partialSubmit="true">
                                                            <f:selectItems id="selectOneMenu2selectItems" value="#{jmlHorarioAdmin.horaFin}"/>
                                                        </ice:selectOneMenu>
                                                    </td>
                                                </tr>
                                            </table>
                                            <ice:commandButton action="#{jmlHorarioAdmin.btnAceptarMod_action}" disabled="#{jmlHorarioAdmin.boton}" id="btnAceptarMod" styleClass="btnAccion2" value="Aceptar"/>
                                            <ice:commandButton action="#{jmlHorarioAdmin.btnCancelarMod_action}" id="btnCancelarMod" styleClass="btnAccion2" value="Cancelar"/>
                                        </ice:panelGroup>
                                    </f:facet>
                                </ice:panelPopup>
                                <ice:panelPopup autoCentre="true" draggable="true" id="panelMensajes" modal="true"
                                rendered="#{jmlHorarioAdmin.renderMensajes}" style="height: 141px; left: 264px; top: 144px; position: absolute; width: 333px;visibility: hidden;visibility: hidden;">
                                            <f:facet name="header">
                                                <ice:panelGrid id="panelGrid23" style="display:block;width:180px;height:20px;">
                                                    <ice:outputText id="lblTitMensajes" value="ManLab"/>
                                                </ice:panelGrid>
                                            </f:facet>
                                            <f:facet name="body">
                                                <ice:panelGroup id="panelGrid44" style="display: block; height: 80px">
                                                    <center>
                                                        <ice:outputText id="lblMensajes" style="font-size:14px;" value="#{jmlHorarioAdmin.mensajitos}"/>
                                                        <br/><br/>
                                                        <ice:commandButton action="#{jmlHorarioAdmin.btnOk_action}" style="width:60px;" id="btnOk" value="Ok"/>
                                                    </center>
                                                </ice:panelGroup>
                                            </f:facet>
                               </ice:panelPopup>
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
                                    <ice:commandButton action="#{JHardminInstance.login}" id="btnLogin" styleClass="btnAccion2" value="Login"/>
                                </ice:form>
                                <ice:form id="frmLogout" rendered="#{JHardminInstance.currentUser != null}">
                                    <p>
                                        <ice:outputLabel id="lblBienvenido" value="Bienvenido usuario"/>
                                        <ice:outputLabel id="lblNomUsuario" styleClass="formValue" value="#{JHardminInstance.currentUser.userName}"/>
                                    </p>
                                    <ice:commandButton action="#{JHardminInstance.logout}" id="btnLogout" styleClass="btnAccion2" value="Logout"/>
                                </ice:form>
                            </li>
                            <li>
                                <ice:form id="frmCommonTasks">
                                    <h2>Tareas Comunes</h2>
                                    <ul>
                                        <li>
                                            <ice:commandLink onclick="calendar('horario.html','mywin','800','600','no','center');"
                                                rendered="#{JHardminInstance.currentUser.userRole.idrol == 1}" value="Ver calendario de Horarios "/>
                                        </li>
                                        <li>
                                            <ice:commandLink action="#{Redireccion.admin}" rendered="#{JHardminInstance.currentUser != null}" value="Cambiar clave de acceso"/>
                                        </li>
                                        <li>
                                            <ice:commandLink action="#{Redireccion.jrequestAdmin}"
                                                rendered="#{JHardminInstance.currentUser.userRole.idrol == 1}" value="Ir a página principal de Inscripición de Horarios"/>
                                        </li>
                                        <li>
                                            <ice:commandLink action="#{Redireccion.jrequestAdministracion}"
                                                rendered="#{JHardminInstance.currentUser.userRole.idrol == 1}" value="Tareas Administrativas de JRequest"/>
                                        </li>
                                        <li>
                                            <ice:commandLink action="#{Redireccion.jrequestUserSolicitud}" rendered="#{JHardminInstance.currentUser != null}" value="Emitir Solicitud de Soporte Técnico"/>
                                        </li>
                                        <li>
                                            <ice:commandLink action="#{Redireccion.jcanonAdmin}" rendered="#{JHardminInstance.currentUser.userRole.idrol == 1}" value="Administrar Reserva de Equipo Multimedia"/>
                                        </li>
                                        <li>
                                            <ice:commandLink action="" rendered="#{JHardminInstance.currentUser == null}" value="Solo para usuarios registrados"/>
                                        </li>
                                    </ul>
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
