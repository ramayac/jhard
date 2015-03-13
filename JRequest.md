# Introducción #

JRequest es el módulo para el manejo de peticiones de soporte técnico que hace la UES-FMO a la Unidad de Hardware y Software de dicha facultad.

Los usuarios hacen peticiones de servicio para cualquier equipo de la UES.

Los administradores de la Unidad las atienden, las administran y las solucionan. Se lleva un control estricto de cada una de ellas.

# Detalles #

El módulo fue mostrado a Luis (Administrador) con un grado de funcionalidad bastante avanzado. Luis se encargó de hacer algunas observaciones que se tomaron en cuenta y fueron agregadas al trabajo, las cuales fueron:

# Solicitudes de Luis #

Cuando se termina un mantenimiento, se debe de colocar el trabajo q se le realizo para arreglar dicho equipo **--->Realizada con éxito**

Administrador debe ingresar solicitudes también **--->Realizada con éxito**

Mostrar bitácoras de Equipos. Modificar la descripción **--->Realizada con éxito**

También hubo algunos problemas que se tuvieron durante el desarrollo de este módulo, sin embargo fueron solucionados con bastante rapidez. Los cuales fueron:

Filtrar Solicitudes que ya tienen un Mantenimiento, es decir, ya estan siendo trabajadas **---> YA!**

Filtrar Mantenimientos que ya tienen registro en la bitácora, es decir, ya fueron terminadas.  **---> YA!**

Integracion con el módulo de Login, siempre autoría de Robertux **---> YA!**

Limpiar listas cuando se agrega o elimina un nuevo registro **---> YA!**

Agregar el textField Descripcion a la inclusion de un nuevo equipo simple **---> YA!**

Cuando se realiza un mantenimiento... cambiar el estado del equipo simple **---> YA!**

Manejo de las peticiones de los usuarios por medio del LoggedUser de Roberto **---> YA!**


A pesar de eso, al módulo le quedan aun algunos puntos por finalizarse, los cuales son:

# Por Finalizar #

Manejo de Roles

Posicionamiento relativo dentro del paneltabSet

Consumir los posts de JWiki

Integración de Hab.la


Incluyo también discusiones con Roberto acerca del mejor desempeño de este módulo y su estado actual:

# Discusiones con Roberto #

El equipo simple no debe ser ligado a un usuario... Deben aparecer todos los equipos simples habidos y por haber al momento de hacer una nueva solicitud  **--->Tomado en cuenta y se ha realizado de esta manera**

Disponibilidad de Tecnicos. ¿Se le pueden ligar todas las solicitudes que se quieran o debería de tener algún tipo de restricción?  **---> Aun en discusión**

Seguimiento de la solicitud???? No tiene sentido **---> No fue tomado en cuenta**

Seguimiento del caso de mantenimiento? **---> No tiene cabida en la practica real. Poco práctico**

Seguimiento de la bitacora? **---> Ha sido pedido por Luis, se incluyó y está realizado de esa forma. La bitácora puede ser vista y modificada, aparte del respectivo reporte que se realizará cuando se llegue el momento**


Además, listo los posibles problemas que se pueden tener en el futuro y algunos problemas conocidos:

# Posibles problemas en el futuro y problemas conocidos #

Aun no esta contemplado las bitacoras para equipos del LABCOM-1. Es de facil implementacion solamente hay q agregarle la consulta JPQL del equipo existente :) Lo he dejado de lado a propósito para simplificarlo lo más que pueda y no complicarme la existencia. Luis no es muy exigente, y si se sabe defender la idea, se puede hacer un trabajo bastante bonito y SENCILLO

Cuando un mantenimiento se finaliza y se ingresa a la bitacora no se sabe cual tupla de la bitacora pertenece a un mantenimiento especifico. La bitacora no se relaciona con el mantenimiento. ¿Hacerlo por fecha? ¿El ultimo de cada uno de un equipo determinado? Posibles soluciones SI LLEGA A SALIR EL TEMA DE PARTE DE LUIS

El SelectInputText para las bitacoras no filtra cuando se le escribe :(

Hay problema con la fecha del año de la Clase Calendar cuando ingreso solicitud... le suma 1900 años.