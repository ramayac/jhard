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


INSERT INTO `equiposimple` (`idEquipoSimple`,`descripcion`,`propietario`,`idestado`) VALUES 
 (1,'Computadora Oficina Jurídica','Lic. Sonia',1),
 (2,'Computadora Secretaria Matemáticas','Karlita',1),
 (3,'Computadora Docentes Matemática','Docentes Matemática',1);


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
