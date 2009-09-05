<?xml version="1.0" encoding="UTF-8"?>
<!-- 
    Document   : jmlHorario
    Created on : 28-jul-2009, 15:26:24
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
                <link href="css/defaultJCanon.css" rel="stylesheet" type="text/css"/>
                <link href="img/favicon.ico" rel="shortcut icon" type="image/x-icon"/>
                <!--Scheduler-->
                <script charset="utf-8" src="js/dhtmlxscheduleManLab.js" type="text/javascript"></script>
                <link charset="utf-8" href="js/dhtmlxscheduler.css" media="screen" rel="stylesheet" title="no title" type="text/css"/>
                <script charset="utf-8" type="text/javascript">
                    function Error500() {

                    scheduler.config.xml_date="%Y-%m-%d %H:%i";
                    scheduler.Error500('scheduler_here',null,"week");
                    scheduler.load("/JHard/horarios");

                    }
                    function doLoad(){
                        setTimeout( "refresh()", 1*1000 );

                    }
                    function refresh(){
                        location.reload(true);
                    }

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
            <body id="outputBody1" onload="Error500();" style="-rave-layout: grid">
                <!--start header -->
                <jsp:directive.include file="/jspf/menu.jspx"/>
                <!-- end header -->
                <!-- start page -->
                <div id="page">
                    <!-- start content -->
                    <div id="content">
                        <div class="post">
                            <h2 class="title">Horarios de Grupos de Laboratorio</h2>
                            <ice:form id="jmlHorario">
                                <ice:panelGroup id="grupo1" style="margin:0px;" styleClass="entry">
                                    <ice:panelGroup id="grupoHorarioScheduler" style="height: 460px; width: 800px" visible="true">
                                        <div class="dhx_cal_container" id="scheduler_here" style="position: absolute; width:71%; height:74%;">
                                            <div class="dhx_cal_navline">
                                                <div class="dhx_cal_today_button"></div>
                                                <div class="dhx_cal_date"></div>
                                                <div class="dhx_cal_tab" name="day_tab" style="right:204px;"></div>
                                                <div class="dhx_cal_tab" name="week_tab" style="right:140px;"></div>
                                                <div class="dhx_cal_tab" name="month_tab" style="right:76px;"></div>
                                            </div>
                                            <div class="dhx_cal_header"></div>
                                            <div class="dhx_cal_data"></div>
                                        </div>
                                    </ice:panelGroup>
                                    <ice:panelGroup rendered="#{JHardminInstance.currentUser == null}">
                                        <jsp:directive.include file="/jspf/nologin.jspx"/>
                                    </ice:panelGroup>
                                    <ice:panelCollapsible rendered="#{JHardminInstance.currentUser.userRole.idrol == 1}" expanded="true" id="panelHorarios" style=" width: 500px" styleClass="entry">
                                        <f:facet name="header">
                                            <ice:panelGroup id="panelGroup1">
                                                <ice:outputText id="lblTitulo2" value="Agregar nuevo Horario"/>
                                            </ice:panelGroup>
                                        </f:facet>
                                        <ice:panelGroup id="grupoHorario" style="height: 450x">
                                            <h3>
                                                <ice:outputLabel id="outputLabel4" style="font-size:12px;" value="Grupo de Laboratorio o curso a inscribir"/>
                                            </h3>
                                            <br/>
                                            <ice:selectOneMenu binding="#{jmlHorario.comboCurso}" id="comboCurso" partialSubmit="true">
                                                <f:selectItems id="selectOneMenu1selectItems1" value="#{jmlHorario.cur}"/>
                                            </ice:selectOneMenu>
                                            <br/>
                                            <br/>
                                            <ice:outputLabel value="No se puede inscribir grupo en ese horario. No se encuentra disponible" style="font-size:14px" rendered="#{jmlHorario.noInscripcion}"/>
                                            <table border="1" cellpadding="4">
                                                <tr>
                                                    <td rowspan="2">
                                                        <ice:outputLabel id="outputLabel1" style="font-size:12px;" value="Día"/>
                                                        <br/>
                                                        <br/>
                                                        <ice:selectOneListbox binding="#{jmlHorario.listaDiaSemana}" id="listaDiaSemana" partialSubmit="true"
                                                            size="6" style="width: 100px" valueChangeListener="#{jmlHorario.listaDiaSemana_processValueChange}">
                                                            <f:selectItems id="selectOneListbox1selectItems" value="#{jmlHorario.diaSemana}"/>
                                                        </ice:selectOneListbox>
                                                    </td>
                                                    <td valign="TOP">
                                                        <ice:outputLabel id="outputLabel2" style="font-size:12px;" value="Hora de Inicio"/>
                                                        <br/>
                                                        <br/>
                                                        <ice:selectOneMenu binding="#{jmlHorario.comboHoraInicio}" id="comboHoraInicio" partialSubmit="true" valueChangeListener="#{jmlHorario.comboHoraInicio_processValueChange}">
                                                            <f:selectItems id="selectOneMenu1selectItems" value="#{jmlHorario.horaInicio}"/>
                                                        </ice:selectOneMenu>
                                                    </td>
                                                    <td valign="TOP">
                                                        <ice:outputLabel id="outputLabel3" style="font-size:12px;" value="Hora de Finalización"/>
                                                        <br/>
                                                        <br/>
                                                        <ice:selectOneMenu binding="#{jmlHorario.comboHoraFin}" id="comboHoraFin" partialSubmit="true">
                                                            <f:selectItems id="selectOneMenu2selectItems" value="#{jmlHorario.horaFin}"/>
                                                        </ice:selectOneMenu>
                                                    </td>
                                                </tr>
                                            </table>
                                            <br/>
                                            <br/>
                                            <ice:commandButton action="#{jmlHorario.btnInscribirCurso_action}" binding="#{jmlHorario.btnInscribirCurso}"
                                                id="btnInscribirCurso" styleClass="btnAccion2" value="Agregar Horario"/>
                                            
                                            <ice:commandButton style="right: 0px; padding: 2px;" id="btnAdmin" action="#{Redireccion.jmlHorarioAdmin}" styleClass="btnAccion2" value="Administrar Horarios" />
                                            
                                        </ice:panelGroup>
                                    </ice:panelCollapsible>
                                </ice:panelGroup>
                                <ice:panelPopup autoCentre="true" draggable="true" id="panelMensajes" modal="true"
                                rendered="#{jmlHorario.renderPop}" style="height: 141px; left: 264px; top: 144px; position: absolute; width: 333px;visibility: hidden;visibility: hidden;">
                                            <f:facet name="header">
                                                <ice:panelGrid id="panelGrid1" style="display:block;width:180px;height:20px;">
                                                    <ice:outputText id="lblTitMensajes" value="ManLab"/>
                                                </ice:panelGrid>
                                            </f:facet>
                                            <f:facet name="body">
                                                <ice:panelGroup id="panelGrid2" style="display: block; height: 80px">
                                                    <center>
                                                        <ice:outputText id="lblMensajes" style="font-size:14px;" value="Horario ingresado con éxito"/>
                                                        <br/><br/>
                                                            <ice:commandButton action="#{jmlHorario.btnOk_action}" style="width:60px;" id="btnOk" onclick="doLoad();" value="Ok"/>
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
                                        <ice:inputText id="txtUser" required="true" requiredMessage="El nombre de usuario es requerido" style="width: 120px" value="#{JHardminInstance.inputUsrName}" maxlength="25" />
                                        <h:message for="txtUser" styleClass="errorText"/>
                                    </p>
                                    <p>
                                        <ice:outputLabel id="lblPass" value="Clave:"/>
                                        <ice:inputSecret id="txtPass" required="true" requiredMessage="La clave de acceso es requerida" style="width: 120px" value="#{JHardminInstance.inputUsrPassword}" maxlength="35" />
                                        <h:message for="txtPass" styleClass="errorText"/>
                                    </p>
                                    <ice:commandButton action="#{JHardminInstance.login}" onclick="doLoad();" id="btnLogin" styleClass="btnAccion2" value="Login"/>
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
                                            <ice:commandLink onclick="calendar('horario.html','mywin','800','600','no','center');"
                                                rendered="#{JHardminInstance.currentUser.userRole.idrol == 1}" value="Ver calendario de Horarios "/>
                                        </li>
                                        <li>
                                            <ice:commandLink action="#{Redireccion.admin}" rendered="#{JHardminInstance.currentUser != null}" value="Cambiar clave de acceso"/>
                                        </li>
                                        <li>
                                            <ice:commandLink value="Ver Reportes de JHard" action="#{Redireccion.reportes}" rendered="#{JHardminInstance.currentUser != null}"></ice:commandLink>
                                        </li>
                                        <li>
                                            <ice:commandLink action="#{Redireccion.jmlHorarioAdmin}" rendered="#{JHardminInstance.currentUser.userRole.idrol == 1}" value="Administrar Horarios"/>
                                        </li>
                                        <li>
                                            <ice:commandLink action="#{Redireccion.jmlLaboratorio}" value="ir a Actividades del Laboratorio"/>
                                        </li>
                                        <li>
                                            <ice:commandLink action="" rendered="#{JHardminInstance.currentUser == null}" value="Solo para usuarios registrados"/>
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
