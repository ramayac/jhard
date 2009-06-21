<?xml version="1.0" encoding="UTF-8"?>
<!-- 
    Document   : Page1
    Created on : Jun 4, 2009, 6:53:49 PM
    Author     : robertux 
-->
<jsp:root version="2.1" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:ice="http://www.icesoft.com/icefaces/component" xmlns:jsp="http://java.sun.com/JSP/Page">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
    <f:view>
        <html id="outputHtml1">
            <head id="outputHead1">
                <ice:outputStyle href="css/stylesheet.css" id="outputStyle1"/>
                <ice:outputStyle href="./xmlhttp/css/xp/xp.css" id="outputStyle2"/>
            </head>
            <body id="outputBody1" style="-rave-layout: grid">
                <ice:form id="form1">
                    <ice:dataTable id="dataTable1" style="left: 38px; top: 38px; position: absolute" value="#{Page1.dataTable1Model}" var="currentRow">
                        <ice:column id="column1">
                            <ice:outputText id="outputText1" value="#{currentRow['COLUMN1']}"/>
                            <f:facet name="header">
                                <ice:outputText id="outputText2" value="Table_Column1"/>
                            </f:facet>
                        </ice:column>
                        <ice:column id="column2">
                            <ice:outputText id="outputText3" value="#{currentRow['COLUMN2']}"/>
                            <f:facet name="header">
                                <ice:outputText id="outputText4" value="Table_Column2"/>
                            </f:facet>
                        </ice:column>
                        <ice:column id="column3">
                            <ice:outputText id="outputText5" value="#{currentRow['COLUMN3']}"/>
                            <f:facet name="header">
                                <ice:outputText id="outputText6" value="Table_Column3"/>
                            </f:facet>
                        </ice:column>
                    </ice:dataTable>
                </ice:form>
            </body>
        </html>
    </f:view>
</jsp:root>
