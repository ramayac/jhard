# Introduction #

Esta guia resume los pasos necesarios para instalar los paquetes relacionados con y poder realizar diagramas UML usando Eclipse Ganymede.


# Details #

Para poder realizar diagramas UML2 en Eclipse Ganymede se requieren los siguientes paquetes:

  * Model Development Tools - MDT (el cual incluye los paquetes UML2 y OCL, el cual es requerido) Update site: [Eclipse MDT](http://www.eclipse.org/modeling/mdt/updates/)
  * Ecilpse Modeling Framework - EMF (el cual incluye los paquetes Query, Transaction y Validation que tambien so requeridos) Update site: [Eclipse EMF](http://download.eclipse.org/modeling/emf/updates/releases/)
  * Graphical Editing Framework - GEF. Update site: [Eclipse GEF](http://download.eclipse.org/tools/gef/updates/releases/)
  * Graphical Modeling Framework - GMF. Update site: [Eclipse GMF](http://download.eclipse.org/modeling/gmf/updates/releases/)

Hay que agregar estos repositorios (update sites) al site manager de Eclpise para poder descargarlos e instalarlos. Para ello, abrir el menu Help -> Software Updates...

Aparecera el cuadro de dialogo de Software Updtes. Seleccionar la pestania Available Software y hacer clic en el boton Add site... en el nuevo cuadro de dialogo que aparece, insertar la URL del repositorio o tambien llamado update site.

<a href='http://img142.imageshack.us/my.php?image=imgeclipse1.png'><img src='http://img142.imageshack.us/img142/3826/imgeclipse1.th.png' border='0' /></a><br />
Imagen del cuadro de dialogo donde agregar las URL de los repositorios a instalar.

Una vez agregados los repositorios, hay que seleccionar los paquetes a para luego hacer clic en el boton Install... y seguir los pasos del asistente de la instalacion.

<a href='http://img104.imageshack.us/my.php?image=eclipseuml2.png'><img src='http://img104.imageshack.us/img104/6935/eclipseuml2.th.png' border='0' /></a><br />Imagen de los paquetes necesarios, seleccionados y listos para instalarse.

Una vez instalados los paquetes, es posible crear diagramas UML2 en eclipse. Para ello, se debe crear un nuevo proyecto Java (o de cualquier otro tipo relacionado), un nuevo paquete. Teniendo el nuevo paquete seleccionado, clic en File (o clic derecho sobre el paquete) -> New -> Other. Aparecera el siguiente cuadro de dialogo, en el cual seleccionamos la seccion UML 2.1 Diagrams en la cual aparecen todos los tipos de diagramas UML disponibles:

<a href='http://img168.imageshack.us/my.php?image=eclipseuml3.png'><img src='http://img168.imageshack.us/img168/7641/eclipseuml3.th.png' border='0' /></a><br />

Ahora aparece un cuadro de herramientas con los dibujos que se pueden arrastrar y soltar al area de trabajo para crear los diagramas.

<a href='http://img378.imageshack.us/my.php?image=eclipseuml3.png'><img src='http://img378.imageshack.us/img378/7641/eclipseuml3.th.png' border='0' /></a><br />