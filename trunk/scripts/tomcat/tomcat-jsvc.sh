#!/bin/sh
###############################################################################
# Pequeño script que muestra como inciar o detener Tomcat, usando jsvc
# para que este (Tomcat) no se ejecute con privilegios de super usuario (root).
# Si lo que se desea es que Tomcat se ejecute en el puerto 80, entonces
# modifique el archivo "$CATALINA_HOME/conf/server.xml", asi:
#
#    <!-- Define una conexion no segura HTTP/1.1 al puerto 80 para tomcat 6 -->
#    <Connector className="org.apache.catalina.connector.http.HttpConnector"
#               port="80" minProcessors="5" maxProcessors="75"
#               enableLookups="true" redirectPort="8443"
#               acceptCount="10" debug="0" connectionTimeout="60000"/>
#
#
# Adapte la siguiente seccion para su configuracion:
export JAVA_HOME=/usr/lib/jvm/java-6-sun
export PATH=$JAVA_HOME/bin:$PATH
CATALINA_HOME=/usr/local/tomcat/
TOMCAT_USER=usuario
PID_FILE=/var/run/jsvc.pid


case "$1" in
  start)
    #
    # Start Tomcat
    #
    echo "Iniciando Tomcat"
    jsvc -debug -wait 10 -user usuario -home /usr/lib/jvm/java-6-sun -Djava.endorsed.dirs=$CATALINA_HOME/common/endorsed -cp $CATALINA_HOME/bin/commons-daemon.jar:$CATALINA_HOME/bin/bootstrap.jar -outfile $CATALINA_HOME/logs/catalina.out -errfile $CATALINA_HOME/logs/catalina.err org.apache.catalina.startup.Bootstrap
    #
    # To get a verbose JVM
    #-verbose \
    # To get a debug of jsvc.
    #-debug \
    exit $?
    ;;

  stop)
    #
    # Stop Tomcat
    #
    echo "Deteniendo Tomcat"
    jsvc -stop -pidfile $PID_FILE org.apache.catalina.startup.Bootstrap
    exit $?
    ;;

  *)
    echo "Uso tomcat start ó stop"
    exit 1;;
esac

