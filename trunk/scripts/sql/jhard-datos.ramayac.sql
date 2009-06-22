-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.0.67-0ubuntu6


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


USE jhard;
INSERT INTO `jhard`.`administrador` VALUES   (1,'21232F297A57A5A743894A0E4A801FC3',1);
INSERT INTO `jhard`.`administrador` VALUES   (2,'21232F297A57A5A743894A0E4A801FC3',2);
INSERT INTO `jhard`.`administrador` VALUES   (3,'CD82BE786DA71D1DD4EA68C0908AF6E6',9);
INSERT INTO `jhard`.`adquisicion` VALUES   (1,'2002-01-09',200,'Computadora Clon','Medicomp');
INSERT INTO `jhard`.`adquisicion` VALUES   (2,'2009-03-04',400,'Dell Vostro','Dell');
INSERT INTO `jhard`.`adquisicion` VALUES   (3,'2002-01-03',50,'Licencia Microsoft Windows','Microsoft');
INSERT INTO `jhard`.`carrera` VALUES   (1,'I30515','Ingeniería de Sistemas Informáticos',1);
INSERT INTO `jhard`.`clase` VALUES   (1,'2009-03-05',1,2,'Herencia en Java','N/A',1);
INSERT INTO `jhard`.`clasificacion` VALUES   (1,'PC','PC',1);
INSERT INTO `jhard`.`curso` VALUES   (1,'Grupo 1 ',20,2,2,'2009-03-03',1,2009,1,NULL);
INSERT INTO `jhard`.`docente` VALUES   (1,'Linares Paula','Carlos Stanley',4,1);
INSERT INTO `jhard`.`entrada` VALUES   (1,'Titulo 1','Lorem ipsum dolor sit amet, \nconsectetur adipiscing elit. \nSed cursus dictum cursus. \nCras nibh augue, pharetra tempor hendrerit at,\nconvallis id nunc. Maecenas felis lorem,\nfeugiat nec mollis id, rhoncus pharetra enim.\nSed quis libero porttitor odio accumsan imperdiet ac iaculis nisl. Maecenas diam orci, porta sit amet ornare a, cursus sit amet massa. Cras a posuere eros. Donec sodales luctus purus. Etiam nibh ante, mollis ac condimentum in, convallis egestas nisi. Integer imperdiet lectus eget velit aliquet rutrum. \nProin ligula tellus, viverra vitae tincidunt ut, venenatis nec justo. In ut nisl urna. Aliquam erat volutpat. Nam quis sem ut magna fermentum tempus vitae at eros. Vivamus fermentum sem eget nunc viverra vitae consequat diam tempus.','2009-06-01 00:00:00',1);
INSERT INTO `jhard`.`entrada` VALUES   (2,'Titulo 2','Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed cursus dictum cursus. Cras nibh augue, pharetra tempor hendrerit at, convallis id nunc. Maecenas felis lorem, feugiat nec mollis id, rhoncus pharetra enim. Sed quis libero porttitor odio accumsan imperdiet ac iaculis nisl. Maecenas diam orci, porta sit amet ornare a, cursus sit amet massa. Cras a posuere eros. Donec sodales luctus purus. Etiam nibh ante, mollis ac condimentum in, convallis egestas nisi. Integer imperdiet lectus eget velit aliquet rutrum. Proin ligula tellus, viverra vitae tincidunt ut, venenatis nec justo. In ut nisl urna. Aliquam erat volutpat. Nam quis sem ut magna fermentum tempus vitae at eros. Vivamus fermentum sem eget nunc viverra vitae consequat diam tempus.','2009-05-30 00:00:00',9);
INSERT INTO `jhard`.`entrada` VALUES   (3,'Titulo 3','Donec a diam nec turpis varius imperdiet quis et erat. \nDuis pellentesque libero sagittis sem venenatis lobortis. \nIn porttitor vestibulum enim quis ullamcorper. \nVivamus facilisis ligula id lorem aliquet sodales at in ligula. \nSuspendisse potenti. \nPellentesque venenatis mi sit amet justo ullamcorper at pharetra felis pellentesque. \nAenean imperdiet mattis turpis, sollicitudin interdum enim ultrices et. \nCurabitur at augue a neque tristique consectetur. \nSed nulla nunc, consequat eu faucibus eget, mattis id erat. \nMauris gravida commodo odio eget molestie. \nVestibulum viverra risus vel quam bibendum viverra id nec nunc. \nVivamus aliquet urna ut nulla auctor hendrerit. \nVivamus ut lacus libero. ','2009-05-29 00:00:00',1);
INSERT INTO `jhard`.`entrada` VALUES   (4,'Titulo 4','Pellentesque vestibulum tincidunt justo rutrum egestas. Mauris nisl ligula, egestas ac hendrerit quis, volutpat quis neque. Nullam felis velit, laoreet eu blandit id, tristique et velit. Nam a felis ut libero suscipit hendrerit. Nam ante enim, dignissim quis tincidunt nec, lacinia quis felis. Nunc ac lorem lacus. In hac habitasse platea dictumst. Morbi eget quam eget ipsum vestibulum posuere ut eu mauris. In quis turpis dolor, quis hendrerit odio. Maecenas gravida sapien varius magna rutrum dictum. Nullam a tellus nisl, quis laoreet turpis. Morbi lobortis libero et leo dignissim facilisis. Praesent id nulla risus, id faucibus erat. Morbi pulvinar neque vel dui aliquet quis placerat dui cursus','2009-06-06 00:00:00',1);
INSERT INTO `jhard`.`entrada` VALUES   (5,'Titulo 5','Ut eu neque at ante lacinia tempor ac a ante. Ut pretium, est non accumsan feugiat, tortor neque viverra arcu, a tempor ligula nisl condimentum neque. Ut varius sollicitudin volutpat. Mauris vulputate mollis nunc at faucibus. Duis nec turpis id nisi tincidunt rutrum. Ut et dolor risus. Sed sed malesuada justo. In fermentum aliquam augue, quis pretium erat rhoncus quis. Sed suscipit sem et dolor ornare lobortis. Phasellus ullamcorper euismod lorem sit amet adipiscing. Mauris in risus urna. Etiam sodales fermentum ante, dignissim ultricies augue malesuada ac. Nulla sem diam, tincidunt eget aliquet ac, imperdiet sed libero.','2009-05-05 00:00:00',9);
INSERT INTO `jhard`.`entrada` VALUES   (6,'Lorem','Nam consectetur bibendum justo, vel dapibus justo lobortis et. Vestibulum libero metus, convallis vitae ultricies sit amet, pharetra in lacus. Aliquam erat volutpat. Vivamus ultricies magna sed nisi bibendum egestas. Sed porta leo in neque condimentum malesuada. Proin quis congue libero. Cras rhoncus pellentesque ultrices. In felis nibh, posuere ut imperdiet ac, pellentesque eget turpis. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed eget sapien massa, at porta elit. Duis lacinia dignissim massa, at egestas dui condimentum ut. Praesent eu augue nisi, non porta nisl. Sed id lacus tortor. Integer at suscipit nisi. Morbi egestas scelerisque eros ac laoreet. Pellentesque sollicitudin ante eget quam aliquam luctus. Maecenas eu arcu ante, sagittis sagittis mauris. ','2009-01-01 00:00:00',1);
INSERT INTO `jhard`.`equipo` VALUES   (1,9,'PC','PC',1);
INSERT INTO `jhard`.`equipo` VALUES   (2,1,'DellPC','Vostro',1);
INSERT INTO `jhard`.`equiposimple` VALUES   (1,'Computadora Oficina Jurídica','Lic. Sonia',1);
INSERT INTO `jhard`.`equiposimple` VALUES   (2,'Computadora Secretaria Matemáticas','Karlita',1);
INSERT INTO `jhard`.`equiposimple` VALUES   (3,'Computadora Docentes Matemática','Docentes Matemática',1);
INSERT INTO `jhard`.`estadoequipo` VALUES   (1,'Excelente','Óptimas condiciones');
INSERT INTO `jhard`.`estadoequipo` VALUES   (2,'Muy Bueno','Condiciones aceptables');
INSERT INTO `jhard`.`estadoequipo` VALUES   (3,'Bueno','Condiciones estables');
INSERT INTO `jhard`.`estadoequipo` VALUES   (4,'Malo','Falla por ciertos períodos de tiempo');
INSERT INTO `jhard`.`estadoequipo` VALUES   (5,'Muy Malo','Falla casi siempre');
INSERT INTO `jhard`.`estadoequipo` VALUES   (6,'Pésimo','Imposible de utilizar');
INSERT INTO `jhard`.`estudiante` VALUES   (1,'SM08003','Salgado Martínez','Rebeca Marcela',7,1);
INSERT INTO `jhard`.`existencia` VALUES   (1,1,1,1,1,'labcom1');
INSERT INTO `jhard`.`existencia` VALUES   (2,1,1,1,1,'labcom2');
INSERT INTO `jhard`.`existencia` VALUES   (3,1,1,1,1,'labcom3');
INSERT INTO `jhard`.`existencia` VALUES   (4,2,1,1,1,'labcom4');
INSERT INTO `jhard`.`existencia` VALUES   (5,2,1,1,1,'labcom5');
INSERT INTO `jhard`.`facultad` VALUES   (1,'Facultad Multidisciplinaria de Occidente');
INSERT INTO `jhard`.`horario` VALUES   (1,1,'10:00:00','10:55:00',1,1);
INSERT INTO `jhard`.`instalacion` VALUES   (1,1,'2009-04-03',2);
INSERT INTO `jhard`.`instructor` VALUES   (1,'CC02043','Cerna','Fredy',8,1);
INSERT INTO `jhard`.`instructor` VALUES   (2,'BP04004','Barrientos Padilla','Hugo Alejandro',9,1);
INSERT INTO `jhard`.`marca` VALUES   (1,'Dell');
INSERT INTO `jhard`.`marca` VALUES   (2,'Sony');
INSERT INTO `jhard`.`marca` VALUES   (3,'Toshiba');
INSERT INTO `jhard`.`marca` VALUES   (4,'Compaq');
INSERT INTO `jhard`.`marca` VALUES   (5,'HP');
INSERT INTO `jhard`.`marca` VALUES   (6,'Acer');
INSERT INTO `jhard`.`marca` VALUES   (7,'Canon');
INSERT INTO `jhard`.`marca` VALUES   (8,'Kyocera-Mita');
INSERT INTO `jhard`.`marca` VALUES   (9,'Clon');
INSERT INTO `jhard`.`marca` VALUES   (10,'Kingston');
INSERT INTO `jhard`.`marca` VALUES   (11,'Seagate');
INSERT INTO `jhard`.`materia` VALUES   (1,'ALG-135','Algoritmos Gráficos',1);
INSERT INTO `jhard`.`materia` VALUES   (2,'PRN-235','Programación II',1);
INSERT INTO `jhard`.`pieza` VALUES   (1,'memoria RAM',10,'kingston',1,1);
INSERT INTO `jhard`.`pieza` VALUES   (2,'disco duro',11,'seagate',1,1);
INSERT INTO `jhard`.`rol` VALUES   (1,'Administrador','Administrador de JHard');
INSERT INTO `jhard`.`rol` VALUES   (2,'Administrativo','Personal Administrativo UES-FMO');
INSERT INTO `jhard`.`rol` VALUES   (3,'Docente','Docente UES-FMO');
INSERT INTO `jhard`.`rol` VALUES   (4,'Editor de Contenido','Encargado de actualizar contenido de JHard');
INSERT INTO `jhard`.`rol` VALUES   (5,'Estudiante','Estudiante UES-FMO');
INSERT INTO `jhard`.`rol` VALUES   (6,'Instructor','Instructor de materia UES-FMO');
INSERT INTO `jhard`.`software` VALUES   (1,'Microsoft Windows XP','Service Pack 2',3,'JGOL-JGFL-KGJK.KJGF-O3JW-OLB3',20,1);
INSERT INTO `jhard`.`tag` VALUES   (0,'wiki');
INSERT INTO `jhard`.`tag` VALUES   (1,'mayo');
INSERT INTO `jhard`.`tag` VALUES   (2,'lorem');
INSERT INTO `jhard`.`tag` VALUES   (3,'titulo');
INSERT INTO `jhard`.`tag` VALUES   (4,'consecteur');
INSERT INTO `jhard`.`tag` VALUES   (5,'junio');
INSERT INTO `jhard`.`tag` VALUES   (6,'enero');
INSERT INTO `jhard`.`tag_entrada` VALUES   (0,4,6);
INSERT INTO `jhard`.`tag_entrada` VALUES   (1,2,6);
INSERT INTO `jhard`.`tag_entrada` VALUES   (2,6,6);
INSERT INTO `jhard`.`tag_entrada` VALUES   (3,1,2);
INSERT INTO `jhard`.`tag_entrada` VALUES   (4,1,3);
INSERT INTO `jhard`.`tag_entrada` VALUES   (5,1,5);
INSERT INTO `jhard`.`ubicacion` VALUES   (1,'LABCOM-1');
INSERT INTO `jhard`.`usuario` VALUES   (1,'LuisBarrera','21232F297A57A5A',1);
INSERT INTO `jhard`.`usuario` VALUES   (2,'Madrid','21232F297A57A5A',1);
INSERT INTO `jhard`.`usuario` VALUES   (3,'Claudia','9003D1DF22EB4D3',2);
INSERT INTO `jhard`.`usuario` VALUES   (4,'Stanley','9003D1DF22EB4D3',3);
INSERT INTO `jhard`.`usuario` VALUES   (5,'Carmencita','9003D1DF22EB4D3',2);
INSERT INTO `jhard`.`usuario` VALUES   (6,'Gabriel','9003D1DF22EB4D3',4);
INSERT INTO `jhard`.`usuario` VALUES   (7,'Rebekita','9003D1DF22EB4D3',5);
INSERT INTO `jhard`.`usuario` VALUES   (8,'fredy','9003D1DF22EB4D3',6);
INSERT INTO `jhard`.`usuario` VALUES   (9,'hugol','CD82BE786DA71D1',6);



/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
