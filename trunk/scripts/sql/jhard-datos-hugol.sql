-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.0.51b-community-nt


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema jhard
--

USE jhard;



INSERT INTO `adquisicion` (`idadquisicion`,`fecha`,`precio`,`descripcion`,`proveedor`) VALUES 
 (1,'2002-01-09',200,'Computadora Clon','Medicomp'),
 (2,'2009-03-04',400,'Dell Vostro','Dell'),
 (3,'2002-01-03',50,'Licencia Microsoft Windows','Microsoft');


INSERT INTO `carrera` (`idcarrera`,`codigo`,`nombre`,`idfacultad`) VALUES 
 (1,'I30515','Ingeniería de Sistemas Informáticos',1);


INSERT INTO `clase` (`idclase`,`fecha`,`idhorario`,`idinstructor`,`tema`,`observaciones`,`iddocente`) VALUES 
 (1,'2009-03-05',1,2,'Herencia en Java','N/A',1);


INSERT INTO `clasificacion` (`idclasificacion`,`nombre`,`descripcion`,`idsuperior`) VALUES 
 (1,'PC','PC',1);


INSERT INTO `curso` (`idcurso`,`nombre`,`cupomax`,`idmateria`,`idinstructor`,`fechainicio`,`ciclo`,`anio`,`iddocente`) VALUES 
 (1,'Grupo 1 ',20,2,2,'2009-03-03',1,2009,1);


INSERT INTO `docente` (`iddocente`,`Apellidos`,`Nombres`,`idusuario`,`visible`) VALUES 
 (1,'Linares Paula','Carlos Stanley',4,1);


INSERT INTO `equipo` (`idequipo`,`idmarca`,`nombre`,`modelo`,`idclasificacion`) VALUES 
 (1,9,'PC','PC',1),
 (2,1,'DellPC','Vostro',1);


 
 INSERT INTO `entrada` VALUES   (1,'Titulo 1','Lorem ipsum dolor sit amet, \nconsectetur adipiscing elit. \nSed cursus dictum cursus. \nCras nibh augue, pharetra tempor hendrerit at,\nconvallis id nunc. Maecenas felis lorem,\nfeugiat nec mollis id, rhoncus pharetra enim.\nSed quis libero porttitor odio accumsan imperdiet ac iaculis nisl. Maecenas diam orci, porta sit amet ornare a, cursus sit amet massa. Cras a posuere eros. Donec sodales luctus purus. Etiam nibh ante, mollis ac condimentum in, convallis egestas nisi. Integer imperdiet lectus eget velit aliquet rutrum. \nProin ligula tellus, viverra vitae tincidunt ut, venenatis nec justo. In ut nisl urna. Aliquam erat volutpat. Nam quis sem ut magna fermentum tempus vitae at eros. Vivamus fermentum sem eget nunc viverra vitae consequat diam tempus.','2009-06-01 00:00:00',1);
INSERT INTO `entrada` VALUES   (2,'Titulo 2','Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed cursus dictum cursus. Cras nibh augue, pharetra tempor hendrerit at, convallis id nunc. Maecenas felis lorem, feugiat nec mollis id, rhoncus pharetra enim. Sed quis libero porttitor odio accumsan imperdiet ac iaculis nisl. Maecenas diam orci, porta sit amet ornare a, cursus sit amet massa. Cras a posuere eros. Donec sodales luctus purus. Etiam nibh ante, mollis ac condimentum in, convallis egestas nisi. Integer imperdiet lectus eget velit aliquet rutrum. Proin ligula tellus, viverra vitae tincidunt ut, venenatis nec justo. In ut nisl urna. Aliquam erat volutpat. Nam quis sem ut magna fermentum tempus vitae at eros. Vivamus fermentum sem eget nunc viverra vitae consequat diam tempus.','2009-05-30 00:00:00',9);
INSERT INTO `entrada` VALUES   (3,'Titulo 3','Donec a diam nec turpis varius imperdiet quis et erat. \nDuis pellentesque libero sagittis sem venenatis lobortis. \nIn porttitor vestibulum enim quis ullamcorper. \nVivamus facilisis ligula id lorem aliquet sodales at in ligula. \nSuspendisse potenti. \nPellentesque venenatis mi sit amet justo ullamcorper at pharetra felis pellentesque. \nAenean imperdiet mattis turpis, sollicitudin interdum enim ultrices et. \nCurabitur at augue a neque tristique consectetur. \nSed nulla nunc, consequat eu faucibus eget, mattis id erat. \nMauris gravida commodo odio eget molestie. \nVestibulum viverra risus vel quam bibendum viverra id nec nunc. \nVivamus aliquet urna ut nulla auctor hendrerit. \nVivamus ut lacus libero. ','2009-05-29 00:00:00',1);
INSERT INTO `entrada` VALUES   (4,'Titulo 4','Pellentesque vestibulum tincidunt justo rutrum egestas. Mauris nisl ligula, egestas ac hendrerit quis, volutpat quis neque. Nullam felis velit, laoreet eu blandit id, tristique et velit. Nam a felis ut libero suscipit hendrerit. Nam ante enim, dignissim quis tincidunt nec, lacinia quis felis. Nunc ac lorem lacus. In hac habitasse platea dictumst. Morbi eget quam eget ipsum vestibulum posuere ut eu mauris. In quis turpis dolor, quis hendrerit odio. Maecenas gravida sapien varius magna rutrum dictum. Nullam a tellus nisl, quis laoreet turpis. Morbi lobortis libero et leo dignissim facilisis. Praesent id nulla risus, id faucibus erat. Morbi pulvinar neque vel dui aliquet quis placerat dui cursus','2009-06-06 00:00:00',1);
INSERT INTO `entrada` VALUES   (5,'Titulo 5','Ut eu neque at ante lacinia tempor ac a ante. Ut pretium, est non accumsan feugiat, tortor neque viverra arcu, a tempor ligula nisl condimentum neque. Ut varius sollicitudin volutpat. Mauris vulputate mollis nunc at faucibus. Duis nec turpis id nisi tincidunt rutrum. Ut et dolor risus. Sed sed malesuada justo. In fermentum aliquam augue, quis pretium erat rhoncus quis. Sed suscipit sem et dolor ornare lobortis. Phasellus ullamcorper euismod lorem sit amet adipiscing. Mauris in risus urna. Etiam sodales fermentum ante, dignissim ultricies augue malesuada ac. Nulla sem diam, tincidunt eget aliquet ac, imperdiet sed libero.','2009-05-05 00:00:00',9);
INSERT INTO `entrada` VALUES   (6,'Lorem','Nam consectetur bibendum justo, vel dapibus justo lobortis et. Vestibulum libero metus, convallis vitae ultricies sit amet, pharetra in lacus. Aliquam erat volutpat. Vivamus ultricies magna sed nisi bibendum egestas. Sed porta leo in neque condimentum malesuada. Proin quis congue libero. Cras rhoncus pellentesque ultrices. In felis nibh, posuere ut imperdiet ac, pellentesque eget turpis. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed eget sapien massa, at porta elit. Duis lacinia dignissim massa, at egestas dui condimentum ut. Praesent eu augue nisi, non porta nisl. Sed id lacus tortor. Integer at suscipit nisi. Morbi egestas scelerisque eros ac laoreet. Pellentesque sollicitudin ante eget quam aliquam luctus. Maecenas eu arcu ante, sagittis sagittis mauris. ','2009-01-01 00:00:00',1);

 
INSERT INTO `equiposimple` (`idEquipoSimple`,`descripcion`,`propietario`,`idestado`) VALUES 
 (1,'Computadora Oficina Jurídica','Carmencita',1),
 (2,'Computadora Secretaria Matemáticas','Karlita',1),
 (3,'Computadora Docentes Matemática','rosario',1),
 (4,'Computadora Carmencita','Carmencita',2),
 (5,'Compu Medicina','Carmencita',2),
 (6,'Compu cacasa ','Carmencita',3),
 (7,'Compu de Reyes','Carmencita',4),
 (8,'Compu del Bunker','Carmencita',3),
 (9,'bunker 2','Carmencita',3),
 (10,'Compu Italia','Carmencita',4),
 (11,'Compu Egipto','Carmencita',3),
 (12,'Compu Brasil','Carmencita',1),
 (13,'Computadora Arq Centeno','Carmencita',2);


INSERT INTO `estadoequipo` (`idestado`,`nombre`,`descripcion`) VALUES 
 (1,'Excelente','Óptimas condiciones'),
 (2,'Muy Bueno','Condiciones aceptables'),
 (3,'Bueno','Condiciones estables'),
 (4,'Malo','Falla por ciertos períodos de tiempo'),
 (5,'Muy Malo','Falla casi siempre'),
 (6,'Pésimo','Imposible de utilizar');


INSERT INTO `estudiante` (`idestudiante`,`carnet`,`apellidos`,`nombres`,`idusuario`,`visible`) VALUES 
 (1,'SM08003','Salgado Martínez','Rebeca Marcela',7,1);


INSERT INTO `existencia` (`idexistencia`,`idhardware`,`idubicacion`,`idestado`,`idadquisicion`,`codigo`) VALUES 
 (1,1,1,1,1,'labcom1'),
 (2,1,1,1,1,'labcom2'),
 (3,1,1,1,1,'labcom3'),
 (4,2,1,1,1,'labcom4'),
 (5,2,1,1,1,'labcom5');


INSERT INTO `facultad` (`idfacultad`,`nombre`) VALUES 
 (1,'Facultad Multidisciplinaria de Occidente');


INSERT INTO `horario` (`idhorario`,`diasemana`,`horainicio`,`horafin`,`idcurso`,`idaula`) VALUES 
 (1,1,'10:00:00','10:55:00',1,1);


INSERT INTO `instalacion` (`idinstalacion`,`idsoftware`,`fechainstalacion`,`idequipoexistente`) VALUES 
 (1,1,'2009-04-03',2);


INSERT INTO `instructor` (`idinstructor`,`carnet`,`apellidos`,`nombres`,`idusuario`,`visible`) VALUES 
 (1,'CC02043','Cerna','Fredy',8,1),
 (2,'BP04004','Barrientos Padilla','Hugo Alejandro',9,1);


 INSERT INTO `mantenimiento` (`idmantenimiento`,`fecha`,`descripcion`,`idtecnico`,`idsolicitud`,`idequipoexistente`,`idequiposimple`,`estado`) VALUES 
 (1,'3909-06-21','VIRUS MIERDA',5,3,NULL,1,'Pendiente'),
 (2,'3909-06-21','Virus',3,7,NULL,4,'Finalizado'),
 (3,'3909-06-21','VIRUS MIERDA',4,3,NULL,1,'Pendiente'),
 (4,'3909-06-23','No sirve el monitor',4,8,NULL,13,'Finalizado');

 
 
INSERT INTO `marca` (`idmarca`,`nombre`) VALUES 
 (1,'Dell'),
 (2,'Sony'),
 (3,'Toshiba'),
 (4,'Compaq'),
 (5,'HP'),
 (6,'Acer'),
 (7,'Canon'),
 (8,'Kyocera-Mita'),
 (9,'Clon'),
 (10,'Kingston'),
 (11,'Seagate');


INSERT INTO `materia` (`idmateria`,`codigo`,`nombre`,`idcarrera`) VALUES 
 (1,'ALG-135','Algoritmos Gráficos',1),
 (2,'PRN-235','Programación II',1);


INSERT INTO `pieza` (`idpieza`,`nombre`,`idmarca`,`modelo`,`idclasificacion`,`idequipo`) VALUES 
 (1,'memoria RAM',10,'kingston',1,1),
 (2,'disco duro',11,'seagate',1,1);


INSERT INTO `software` (`idsoftware`,`nombre`,`version`,`idadquisicion`,`codigolicencia`,`cantidadlicencias`,`idclasificacion`) VALUES 
 (1,'Microsoft Windows XP','Service Pack 2',3,'JGOL-JGFL-KGJK.KJGF-O3JW-OLB3',20,1);

 INSERT INTO `solicitud` (`idsolicitud`,`fecha`,`prioridad`,`descripcion`,`idusuario`,`idequipoexistente`,`idequiposimple`) VALUES 
 (1,'2009-06-06','Alta','Virus',1,1,1),
 (2,'2009-06-17','Media','Virus',1,NULL,1),
 (3,'2009-06-17','Media','VIRUS MIERDA',10,NULL,1),
 (4,'2009-06-17','Media','a veeeeer!',5,NULL,4),
 (5,'3909-06-17','Media','Esta compu la jode la maitra de derechoo',5,NULL,1),
 (6,'3909-06-17','Media','compu mas basuraaa',5,NULL,7),
 (7,'2009-06-19','Baja','Virus',5,NULL,4),
 (8,'3909-06-23','Media','No sirve el monitor',5,NULL,13);


INSERT INTO `ubicacion` (`idubicacion`,`nombre`) VALUES 
 (1,'LABCOM-1');

INSERT INTO `rol` (`idrol`,`nombre`,`descripcion`) VALUES
(1,'Administrador','Administrador de JHard'),
(2,'Administrativo','Personal Administrativo UES-FMO'),
(3,'Docente','Docente UES-FMO'),
(4,'Editor de Contenido','Encargado de actualizar contenido de JHard'),
(5,'Estudiante','Estudiante UES-FMO'),
(6,'Instructor','Instructor de materia UES-FMO');

INSERT INTO `usuario` (`idusuario`,`nombre`,`clave`,`idrol`) VALUES 
 (1,'LuisBarrera','21232F297A57A5A743894A0E4A801FC3',1),
 (2,'Madrid','21232F297A57A5A743894A0E4A801FC3',1),
 (3,'Claudia','9003D1DF22EB4D3820015070385194C8',2),
 (4,'Stanley','9003D1DF22EB4D3820015070385194C8',3),
 (5,'Carmencita','9003D1DF22EB4D3820015070385194C8',2),
 (6,'Gabriel','9003D1DF22EB4D3820015070385194C8',4),
 (7,'Rebekita','9003D1DF22EB4D3820015070385194C8',5),
 (8,'fredy','9003D1DF22EB4D3820015070385194C8',6),
 (9,'hugol','CD82BE786DA71D1DD4EA68C0908AF6E6',6);


INSERT INTO `administrador` (`idadministrador`,`clave`,`idusuario`) VALUES 
 (1,'21232F297A57A5A743894A0E4A801FC3',1),
 (2,'21232F297A57A5A743894A0E4A801FC3',2),
 (3,'CD82BE786DA71D1DD4EA68C0908AF6E6',9);

 
/*DROP USER IF EXISTS jharduser;*/

/*GRANT ALL PRIVILEGES ON jhard.* TO 'jharduser'@'localhost' IDENTIFIED BY 'jhardpwd' WITH GRANT OPTION;*/
 
 
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
