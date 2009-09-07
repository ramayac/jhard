<?xml version="1.0" encoding="UTF-8"?>
<!-- 
    Document   : Error 500
    Created on : 08-02-2009, 02:19:12 PM
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
                <title>Laboratorio de Hardware</title>
                <link href="css/default.css" rel="stylesheet" type="text/css"/>
                <link href="img/favicon.ico" rel="shortcut icon" type="image/x-icon"/>
            </head>
            <body id="outputBody1" style="-rave-layout: grid">
                <!--start header -->
                <jsp:directive.include file="/jspf/menu.jspx"/>
                <!-- end header -->
                <div align="center">
                    <br/><br/>
                    <h2 class="title">Acerca de</h2>
                    <br/>                    
                        Universidad de El Salvador<br/>
                        Facultad Multidisciplinaria de Occidente
                        <br/><br/>
                        Proyecto llevado a cabo como trabajo de grado para obtener el título de Ingeniero en Sistemas Informáticos,
                        en la Universidad de El Salvador.
                        <br/>
                        JHard es el codename del proyecto el cual consiste en un acumulado de servicios que automatizan las labores
                        llevadas a cabo en la Unidad de Hardware y Software de esta facultad.
                        <br/>
                        <h4>Desarrolladores:</h4>
                        <ul>
                            <li>Amaya Centeno, Rodrigo</li>
                            <li>Barrientos Padilla, Hugo Alejandro</li>
                            <li>Linares Melara, Roberto Carlos</li>
                        </ul>
                </div>
                <div style="clear: both;"><br/><br/><br/><br/><br/><br/><br/><br/></div>
                <!-- end page -->
                <!-- start footer -->
                <jsp:directive.include file="/jspf/bottom.jspx"/>
                <!-- end footer -->
            </body>
        </html>
    </f:view>
</jsp:root>
