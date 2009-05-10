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

USE JHard;


INSERT INTO `Administrador` (`idadministrador`,`clave`,`idusuario`) VALUES 
 (1,'admin',1),
 (2,'admin',2),
 (3,'firpomadrid',9);


INSERT INTO `Adquisicion` (`idadquisicion`,`fecha`,`precio`,`descripcion`,`proveedor`) VALUES 
 (1,'2002-01-09',200,'Computadora Clon','Medicomp'),
 (2,'2009-03-04',400,'Dell Vostro','Dell'),
 (3,'2002-01-03',50,'Licencia Microsoft Windows','Microsoft');


INSERT INTO `Carrera` (`idcarrera`,`codigo`,`nombre`,`idfacultad`) VALUES 
 (1,'I30515','Ingeniería de Sistemas Informáticos',1);


INSERT INTO `Clase` (`idclase`,`fecha`,`idhorario`,`idinstructor`,`tema`,`observaciones`,`iddocente`) VALUES 
 (1,'2009-03-05',1,2,'Herencia en Java','N/A',1);


INSERT INTO `Clasificacion` (`idclasificacion`,`nombre`,`descripcion`,`idsuperior`) VALUES 
 (1,'PC','PC',1);


INSERT INTO `Curso` (`idcurso`,`nombre`,`cupomax`,`idmateria`,`idinstructor`,`fechainicio`,`ciclo`,`anio`,`iddocente`) VALUES 
 (1,'Grupo 1 ',20,2,2,'2009-03-03',1,2009,1);


INSERT INTO `Docente` (`iddocente`,`Apellidos`,`Nombres`,`idusuario`,`visible`) VALUES 
 (1,'Linares Paula','Carlos Stanley',4,1);


INSERT INTO `Equipo` (`idequipo`,`idmarca`,`nombre`,`modelo`,`idclasificacion`) VALUES 
 (1,9,'PC','PC',1),
 (2,1,'DellPC','Vostro',1);


INSERT INTO `EquipoSimple` (`idEquipoSimple`,`descripcion`,`propietario`,`idestado`) VALUES 
 (1,'Computadora Oficina Jurídica','Lic. Sonia',1),
 (2,'Computadora Secretaria Matemáticas','Karlita',1),
 (3,'Computadora Docentes Matemática','Docentes Matemática',1);


INSERT INTO `EstadoEquipo` (`idestado`,`nombre`,`descripcion`) VALUES 
 (1,'Excelente','Óptimas condiciones'),
 (2,'Muy Bueno','Condiciones aceptables'),
 (3,'Bueno','Condiciones estables'),
 (4,'Malo','Falla por ciertos períodos de tiempo'),
 (5,'Muy Malo','Falla casi siempre'),
 (6,'Pésimo','Imposible de utilizar');


INSERT INTO `Estudiante` (`idestudiante`,`carnet`,`apellidos`,`nombres`,`idusuario`,`visible`) VALUES 
 (1,'SM08003','Salgado Martínez','Rebeca Marcela',7,1);


INSERT INTO `Existencia` (`idexistencia`,`idhardware`,`idubicacion`,`idestado`,`idadquisicion`,`codigo`) VALUES 
 (1,1,1,1,1,'labcom1'),
 (2,1,1,1,1,'labcom2'),
 (3,1,1,1,1,'labcom3'),
 (4,2,1,1,1,'labcom4'),
 (5,2,1,1,1,'labcom5');


INSERT INTO `Facultad` (`idfacultad`,`nombre`) VALUES 
 (1,'Facultad Multidisciplinaria de Occidente');


INSERT INTO `Horario` (`idhorario`,`diasemana`,`horainicio`,`horafin`,`idcurso`,`idaula`) VALUES 
 (1,1,'10:00:00','10:55:00',1,1);


INSERT INTO `Instalacion` (`idinstalacion`,`idsoftware`,`fechainstalacion`,`idequipoexistente`) VALUES 
 (1,1,'2009-04-03',2);


INSERT INTO `Instructor` (`idinstructor`,`carnet`,`apellidos`,`nombres`,`idusuario`,`visible`) VALUES 
 (1,'CC02043','Cerna','Fredy',8,1),
 (2,'BP04004','Barrientos Padilla','Hugo Alejandro',9,1);


INSERT INTO `Marca` (`idmarca`,`nombre`) VALUES 
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


INSERT INTO `Materia` (`idmateria`,`codigo`,`nombre`,`idcarrera`) VALUES 
 (1,'ALG-135','Algoritmos Gráficos',1),
 (2,'PRN-235','Programación II',1);


INSERT INTO `Pieza` (`idpieza`,`nombre`,`idmarca`,`modelo`,`idclasificacion`,`idequipo`) VALUES 
 (1,'memoria RAM',10,'kingston',1,1),
 (2,'disco duro',11,'seagate',1,1);


INSERT INTO `Software` (`idsoftware`,`nombre`,`version`,`idadquisicion`,`codigolicencia`,`cantidadlicencias`,`idclasificacion`) VALUES 
 (1,'Microsoft Windows XP','Service Pack 2',3,'JGOL-JGFL-KGJK.KJGF-O3JW-OLB3',20,1);


INSERT INTO `Ubicacion` (`idubicacion`,`nombre`) VALUES 
 (1,'LABCOM-1');


INSERT INTO `Usuario` (`idusuario`,`nombre`,`clave`,`rol`) VALUES 
 (1,'LuisBarrera','admin','Administrador'),
 (2,'Madrid','admin','Administrador'),
 (3,'Claudia','canon','Administrativo'),
 (4,'Stanley','doc','Docente'),
 (5,'Carmencita','derecho','Administrativo'),
 (6,'Gabriel','editor','Editor de Contenido'),
 (7,'Rebekita','rbk','Estudiante'),
 (8,'fredy','instructor','Instructor'),
 (9,'hugol','firpomadrid','Instructor');


/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
