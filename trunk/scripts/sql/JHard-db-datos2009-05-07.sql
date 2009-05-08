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


/*!40000 ALTER TABLE `administrador` DISABLE KEYS */;
INSERT INTO `administrador` (`idadministrador`,`clave`,`idusuario`) VALUES 
 (1,'admin',1),
 (2,'admin',2),
 (3,'firpomadrid',9);
/*!40000 ALTER TABLE `administrador` ENABLE KEYS */;


/*!40000 ALTER TABLE `adquisicion` DISABLE KEYS */;
INSERT INTO `adquisicion` (`idadquisicion`,`fecha`,`precio`,`descripcion`,`proveedor`) VALUES 
 (1,'2002-01-09',200,'Computadora Clon','Medicomp'),
 (2,'2009-03-04',400,'Dell Vostro','Dell'),
 (3,'2002-01-03',50,'Licencia Microsoft Windows','Microsoft');
/*!40000 ALTER TABLE `adquisicion` ENABLE KEYS */;


/*!40000 ALTER TABLE `carrera` DISABLE KEYS */;
INSERT INTO `carrera` (`idcarrera`,`codigo`,`nombre`,`idfacultad`) VALUES 
 (1,'I30515','Ingeniería de Sistemas Informáticos',1);
/*!40000 ALTER TABLE `carrera` ENABLE KEYS */;


/*!40000 ALTER TABLE `clase` DISABLE KEYS */;
INSERT INTO `clase` (`idclase`,`fecha`,`idhorario`,`idinstructor`,`tema`,`observaciones`,`iddocente`) VALUES 
 (1,'2009-03-05',1,2,'Herencia en Java','N/A',1);
/*!40000 ALTER TABLE `clase` ENABLE KEYS */;


/*!40000 ALTER TABLE `clasificacion` DISABLE KEYS */;
INSERT INTO `clasificacion` (`idclasificacion`,`nombre`,`descripcion`,`idsuperior`) VALUES 
 (1,'PC','PC',1);
/*!40000 ALTER TABLE `clasificacion` ENABLE KEYS */;


/*!40000 ALTER TABLE `curso` DISABLE KEYS */;
INSERT INTO `curso` (`idcurso`,`nombre`,`cupomax`,`idmateria`,`idinstructor`,`fechainicio`,`ciclo`,`anio`,`iddocente`) VALUES 
 (1,'Grupo 1 ',20,2,2,'2009-03-03',1,2009,1);
/*!40000 ALTER TABLE `curso` ENABLE KEYS */;


/*!40000 ALTER TABLE `docente` DISABLE KEYS */;
INSERT INTO `docente` (`iddocente`,`Apellidos`,`Nombres`,`idusuario`,`visible`) VALUES 
 (1,'Linares Paula','Carlos Stanley',4,1);
/*!40000 ALTER TABLE `docente` ENABLE KEYS */;


/*!40000 ALTER TABLE `equipo` DISABLE KEYS */;
INSERT INTO `equipo` (`idequipo`,`idmarca`,`nombre`,`modelo`,`idclasificacion`) VALUES 
 (1,9,'PC','PC',1),
 (2,1,'DellPC','Vostro',1);
/*!40000 ALTER TABLE `equipo` ENABLE KEYS */;


/*!40000 ALTER TABLE `equiposimple` DISABLE KEYS */;
INSERT INTO `equiposimple` (`idEquipoSimple`,`descripcion`,`propietario`,`idestado`) VALUES 
 (1,'Computadora Oficina Jurídica','Lic. Sonia',1),
 (2,'Computadora Secretaria Matemáticas','Karlita',1),
 (3,'Computadora Docentes Matemática','Docentes Matemática',1);
/*!40000 ALTER TABLE `equiposimple` ENABLE KEYS */;


/*!40000 ALTER TABLE `estadoequipo` DISABLE KEYS */;
INSERT INTO `estadoequipo` (`idestado`,`nombre`,`descripcion`) VALUES 
 (1,'Excelente','Óptimas condiciones'),
 (2,'Muy Bueno','Condiciones aceptables'),
 (3,'Bueno','Condiciones estables'),
 (4,'Malo','Falla por ciertos períodos de tiempo'),
 (5,'Muy Malo','Falla casi siempre'),
 (6,'Pésimo','Imposible de utilizar');
/*!40000 ALTER TABLE `estadoequipo` ENABLE KEYS */;


/*!40000 ALTER TABLE `estudiante` DISABLE KEYS */;
INSERT INTO `estudiante` (`idestudiante`,`carnet`,`apellidos`,`nombres`,`idusuario`,`visible`) VALUES 
 (1,'SM08003','Salgado Martínez','Rebeca Marcela',7,1);
/*!40000 ALTER TABLE `estudiante` ENABLE KEYS */;


/*!40000 ALTER TABLE `existencia` DISABLE KEYS */;
INSERT INTO `existencia` (`idexistencia`,`idhardware`,`idubicacion`,`idestado`,`idadquisicion`,`codigo`) VALUES 
 (1,1,1,1,1,'labcom1'),
 (2,1,1,1,1,'labcom2'),
 (3,1,1,1,1,'labcom3'),
 (4,2,1,1,1,'labcom4'),
 (5,2,1,1,1,'labcom5');
/*!40000 ALTER TABLE `existencia` ENABLE KEYS */;


/*!40000 ALTER TABLE `facultad` DISABLE KEYS */;
INSERT INTO `facultad` (`idfacultad`,`nombre`) VALUES 
 (1,'Facultad Multidisciplinaria de Occidente');
/*!40000 ALTER TABLE `facultad` ENABLE KEYS */;


/*!40000 ALTER TABLE `horario` DISABLE KEYS */;
INSERT INTO `horario` (`idhorario`,`diasemana`,`horainicio`,`horafin`,`idcurso`,`idaula`) VALUES 
 (1,1,'10:00:00','10:55:00',1,1);
/*!40000 ALTER TABLE `horario` ENABLE KEYS */;


/*!40000 ALTER TABLE `instalacion` DISABLE KEYS */;
INSERT INTO `instalacion` (`idinstalacion`,`idsoftware`,`fechainstalacion`,`idequipoexistente`) VALUES 
 (1,1,'2009-04-03',2);
/*!40000 ALTER TABLE `instalacion` ENABLE KEYS */;


/*!40000 ALTER TABLE `instructor` DISABLE KEYS */;
INSERT INTO `instructor` (`idinstructor`,`carnet`,`apellidos`,`nombres`,`idusuario`,`visible`) VALUES 
 (1,'CC02043','Cerna','Fredy',8,1),
 (2,'BP04004','Barrientos Padilla','Hugo Alejandro',9,1);
/*!40000 ALTER TABLE `instructor` ENABLE KEYS */;


/*!40000 ALTER TABLE `marca` DISABLE KEYS */;
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
/*!40000 ALTER TABLE `marca` ENABLE KEYS */;


/*!40000 ALTER TABLE `materia` DISABLE KEYS */;
INSERT INTO `materia` (`idmateria`,`codigo`,`nombre`,`idcarrera`) VALUES 
 (1,'ALG-135','Algoritmos Gráficos',1),
 (2,'PRN-235','Programación II',1);
/*!40000 ALTER TABLE `materia` ENABLE KEYS */;


/*!40000 ALTER TABLE `pieza` DISABLE KEYS */;
INSERT INTO `pieza` (`idpieza`,`nombre`,`idmarca`,`modelo`,`idclasificacion`,`idequipo`) VALUES 
 (1,'memoria RAM',10,'kingston',1,1),
 (2,'disco duro',11,'seagate',1,1);
/*!40000 ALTER TABLE `pieza` ENABLE KEYS */;


/*!40000 ALTER TABLE `software` DISABLE KEYS */;
INSERT INTO `software` (`idsoftware`,`nombre`,`version`,`idadquisicion`,`codigolicencia`,`cantidadlicencias`,`idclasificacion`) VALUES 
 (1,'Microsoft Windows XP','Service Pack 2',3,'JGOL-JGFL-KGJK.KJGF-O3JW-OLB3',20,1);
/*!40000 ALTER TABLE `software` ENABLE KEYS */;


/*!40000 ALTER TABLE `ubicacion` DISABLE KEYS */;
INSERT INTO `ubicacion` (`idubicacion`,`nombre`) VALUES 
 (1,'LABCOM-1');
/*!40000 ALTER TABLE `ubicacion` ENABLE KEYS */;


/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` (`idusuario`,`nombre`,`clave`,`rol`) VALUES 
 (1,'LuisBarrera','admin','Administrador'),
 (2,'Madrid','admin','Administrador'),
 (3,'Claudia','canon','Administrativo'),
 (4,'Stanley','doc','Docente'),
 (5,'Carmencita','derecho','Administrativo'),
 (6,'Gabriel','editor','Editor de Contenido'),
 (7,'Rebekita','rbk','Estudiante'),
 (8,'fredy','insctructor','Instructor'),
 (9,'hugol','firpomadrid','Instructor');
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
