# Introduction #

Esta guia demostrara los pasos necesarios para configurar Eclipse ganymede y poder realizar mappings desde bases de datos relacionales a java beans utilizando la implementacion de JPA Eclipselink.


# Details #

Descargar la implementacion de JPA llamada eclipselink del sitio: [Eclipselink sitio de descarga](http://www.eclipse.org/eclipselink/downloads/index.php#1.1.0) De preferencia, descargar la version Zip Installer.

Luego, descomprimir este zip y en la carpeta descomprimida, buscar los jars llamados eclipselink.jar (en la carpeta ~/jlib/) y javax.persistence.x.jar (en la carpeta ~/jlib/jpa/) y copiarlos a una ruta absoluta de la computadora.


El plugin Dali viene instalado por defecto en el Web Platform Tools, incluido en Eclipse Ganymede por lo que no es necesario instalar plugins extra.

Dentro de eclipse, clic en el menu Window -> Preferences...

En el cuadro de dialogo que aparece, navegar hasta la opcion Java -> Build Path -> User Libraries. Clic en el boton New...

Escribir un nombre en el cuadro que aparece (de preferencia, llamarla 'eclipselinklib') y clic en OK:

<a href='http://img26.imageshack.us/my.php?image=eclipsejpa3.png'><img src='http://img26.imageshack.us/img26/5644/eclipsejpa3.th.png' border='0' /></a><br />

Luego de crear esta libreria, seleccionarla y hacer clic en el boton Add Jars... seleccionar los jars llamados eclipselink.jar y javax.persistence.x.jar (x es un numero de version). Luego dar clic en el boton ok para cerrar las preferencias.

**NOTA IMPORTANTE:** Para bases de datos de MySql, el esquema por defecto que se utiliza se llama **database**. Tomarlo en cuenta cada vez que se pida este dato durante los pasos siguientes.

Ahora, crear un nuevo proyecto de tipo JPA (File -> New -> JPA -> JPA Project). En el primer paso del asistente: escribir el nombre del proyecto, seleccionar el runtime, la configuracion y dar clic en el boton Next. En el segundo paso del asistente: seleccionar la plataforma a utilizar (eclipselink), seleccionar la conexion a utilizar (crear la conexion a la base de datos si esta no existe. Junto a la opcion aparece un vinculo para hacerlo), el esquema de la conexion (en caso que el gestor de bases de datos lo soporte) y la implementacion de JPA a utilizar, que en nuestro caso nada mas aparecera disponible la User Library que acabamos de crear con el nombre de eclipselinklib. Clic en el boton Finish.

<a href='http://img133.imageshack.us/my.php?image=eclipsejpa2.png'><img src='http://img133.imageshack.us/img133/6224/eclipsejpa2.th.png' border='0' /></a><br />

En la vista ProjectExplorer, hacer clic derecho sobre el nuevo proyecto creado y seleccionar la opcion JPA Tools -> Generate Entities. En el cuadro de dialogo que aparece, seleccionar la conexion a la base de datos y el esquema a generar (en caso que el gestor de bases de datos lo soporte). Click en el boton Next. En el siguiente paso del asistente, seleccionar el folder y el paquete donde crear las entidades (de preferencia, crear previamente un paquete en lugar de usar el paquete default), seleccionar las tablas a generar y clic en el boton Finish.

<a href='http://img209.imageshack.us/my.php?image=eclipsejpa4.png'><img src='http://img209.imageshack.us/img209/6815/eclipsejpa4.th.png' border='0' /></a><br />

Ahora Eclipse ha generado automaticamente los java beans y la configuracion para hacer el mapping entre estas clases y las tablas de la base de datos, como se puede observar en el workbench:

<a href='http://img141.imageshack.us/my.php?image=eclipsejpa5.png'><img src='http://img141.imageshack.us/img141/5628/eclipsejpa5.th.png' border='0' /></a><br />