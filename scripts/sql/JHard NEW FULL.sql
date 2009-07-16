-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.0.83-community-nt


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

CREATE DATABASE IF NOT EXISTS jhard;
USE jhard;

--
-- Definition of table `accesorio`
--

DROP TABLE IF EXISTS `accesorio`;
CREATE TABLE `accesorio` (
  `idaccesorio` int(11) NOT NULL auto_increment COMMENT 'Id correlativo unico de cada accesorio',
  `nombre` varchar(100) NOT NULL COMMENT 'Nombre del accesorio',
  `idmarca` int(11) NOT NULL COMMENT 'Referencia a la marca del accesorio',
  `modelo` varchar(15) NOT NULL COMMENT 'Modelo del accesorio',
  `idclasificacion` int(11) NOT NULL COMMENT 'Referencia a la clasificacion en la que se encuentra este accesorio',
  `idexistencia` int(11) default NULL,
  PRIMARY KEY  (`idaccesorio`),
  KEY `fkidmarca_accesorio` (`idmarca`),
  KEY `fkidclasificacion_accesorio` (`idclasificacion`),
  KEY `fkidexistencia_accesorio` (`idexistencia`),
  CONSTRAINT `fkidexistencia_accesorio` FOREIGN KEY (`idexistencia`) REFERENCES `existencia` (`idexistencia`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fkidclasificacion_accesorio` FOREIGN KEY (`idclasificacion`) REFERENCES `clasificacion` (`idclasificacion`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fkidmarca_accesorio` FOREIGN KEY (`idmarca`) REFERENCES `marca` (`idmarca`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `accesorio`
--

/*!40000 ALTER TABLE `accesorio` DISABLE KEYS */;
/*!40000 ALTER TABLE `accesorio` ENABLE KEYS */;


--
-- Definition of table `administrador`
--

DROP TABLE IF EXISTS `administrador`;
CREATE TABLE `administrador` (
  `idadministrador` int(11) NOT NULL COMMENT 'Id correlativo unico de cada administrador',
  `clave` varchar(45) NOT NULL COMMENT 'Clave del administrador',
  `idusuario` int(11) NOT NULL COMMENT 'referencia al usuario relacionado con este admnistrador',
  PRIMARY KEY  (`idadministrador`),
  KEY `fkidusuario_administrador` (`idusuario`),
  CONSTRAINT `fkidusuario_administrador` FOREIGN KEY (`idusuario`) REFERENCES `usuario` (`idusuario`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `administrador`
--

/*!40000 ALTER TABLE `administrador` DISABLE KEYS */;
INSERT INTO `administrador` (`idadministrador`,`clave`,`idusuario`) VALUES 
 (1,'21232F297A57A5A743894A0E4A801FC3',1),
 (2,'21232F297A57A5A743894A0E4A801FC3',2),
 (3,'CD82BE786DA71D1DD4EA68C0908AF6E6',9);
/*!40000 ALTER TABLE `administrador` ENABLE KEYS */;


--
-- Definition of table `adquisicion`
--

DROP TABLE IF EXISTS `adquisicion`;
CREATE TABLE `adquisicion` (
  `idadquisicion` int(11) NOT NULL auto_increment COMMENT 'Id correlativo unico de la adquisicion',
  `fecha` date NOT NULL COMMENT 'Fecha en la que se adquirio el equipo o software',
  `precio` double NOT NULL COMMENT 'Precio de compra del equipo o software (dejar a cero si fue una donacion)',
  `descripcion` text COMMENT 'Detalles de la adquisicion',
  `proveedor` varchar(100) default NULL COMMENT 'Nombre del proveedor o tienda donde se compro el equipo o software (en caso de haber sido comprado)',
  PRIMARY KEY  (`idadquisicion`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `adquisicion`
--

/*!40000 ALTER TABLE `adquisicion` DISABLE KEYS */;
INSERT INTO `adquisicion` (`idadquisicion`,`fecha`,`precio`,`descripcion`,`proveedor`) VALUES 
 (1,'2002-01-09',200,'Computadora Clon','Medicomp'),
 (2,'2009-03-04',400,'Dell Vostro','Dell'),
 (3,'2002-01-03',50,'Licencia Microsoft Windows','Microsoft'),
 (4,'2002-01-03',200,'Cañon Epson','Tecnoservice');
/*!40000 ALTER TABLE `adquisicion` ENABLE KEYS */;


--
-- Definition of table `asistencia`
--

DROP TABLE IF EXISTS `asistencia`;
CREATE TABLE `asistencia` (
  `idasistencia` int(11) NOT NULL auto_increment COMMENT 'Id correlativo unico para cada asistencia',
  `idestudiante` int(11) NOT NULL COMMENT 'Referencia al estudiante que asistio al curso',
  `idclase` int(11) NOT NULL COMMENT 'Referencia a la clase a la cual pertenece esta asistencia',
  `idequipoexistente` int(11) NOT NULL COMMENT 'Referencia al equipo de hardware que se utilizo en dicha asistencia a la clase',
  PRIMARY KEY  (`idasistencia`),
  KEY `fkidestudiante_asistencia` (`idestudiante`),
  KEY `fkidclase_asistencia` (`idclase`),
  KEY `fkidequipoexistente_asistencia` (`idequipoexistente`),
  CONSTRAINT `fkidclase_asistencia` FOREIGN KEY (`idclase`) REFERENCES `clase` (`idclase`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fkidequipoexistente_asistencia` FOREIGN KEY (`idequipoexistente`) REFERENCES `existencia` (`idexistencia`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fkidestudiante_asistencia` FOREIGN KEY (`idestudiante`) REFERENCES `estudiante` (`idestudiante`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `asistencia`
--

/*!40000 ALTER TABLE `asistencia` DISABLE KEYS */;
/*!40000 ALTER TABLE `asistencia` ENABLE KEYS */;


--
-- Definition of table `atributohardware`
--

DROP TABLE IF EXISTS `atributohardware`;
CREATE TABLE `atributohardware` (
  `idatributohardware` int(11) NOT NULL auto_increment COMMENT 'Id correlativo unico del atributo de hardware',
  `nombre` varchar(45) NOT NULL COMMENT 'Nombre del atributo',
  `valor` varchar(45) NOT NULL COMMENT 'Valor del atributo',
  `unidadmedida` varchar(45) NOT NULL COMMENT 'Unidad de medida del atributo',
  `idhardware` int(11) default NULL COMMENT 'Referencia al elemento de hardware (equipo, pieza o accesorio) al que pertenece el atributo',
  `idpieza` int(11) default NULL,
  `idaccesorio` int(11) default NULL,
  PRIMARY KEY  (`idatributohardware`),
  KEY `fkidequipo_atributohardware` (`idhardware`),
  KEY `fkidpieza_atributohardware` (`idpieza`),
  KEY `fkidaccesorio_atributohardware` (`idaccesorio`),
  CONSTRAINT `fkidaccesorio_atributohardware` FOREIGN KEY (`idaccesorio`) REFERENCES `accesorio` (`idaccesorio`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fkidequipo_atributohardware` FOREIGN KEY (`idhardware`) REFERENCES `equipo` (`idequipo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fkidpieza_atributohardware` FOREIGN KEY (`idpieza`) REFERENCES `pieza` (`idpieza`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `atributohardware`
--

/*!40000 ALTER TABLE `atributohardware` DISABLE KEYS */;
INSERT INTO `atributohardware` (`idatributohardware`,`nombre`,`valor`,`unidadmedida`,`idhardware`,`idpieza`,`idaccesorio`) VALUES 
 (1,'Reservable','1','null',3,NULL,NULL),
 (2,'Reservable','1','null',5,NULL,NULL);
/*!40000 ALTER TABLE `atributohardware` ENABLE KEYS */;


--
-- Definition of table `autorizacion`
--

DROP TABLE IF EXISTS `autorizacion`;
CREATE TABLE `autorizacion` (
  `idautorizacion` int(10) unsigned NOT NULL auto_increment,
  `codigo` varchar(10) default NULL,
  `cantmaxima` int(10) unsigned default NULL,
  PRIMARY KEY  (`idautorizacion`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `autorizacion`
--

/*!40000 ALTER TABLE `autorizacion` DISABLE KEYS */;
/*!40000 ALTER TABLE `autorizacion` ENABLE KEYS */;


--
-- Definition of table `bitacoracambiosusuario`
--

DROP TABLE IF EXISTS `bitacoracambiosusuario`;
CREATE TABLE `bitacoracambiosusuario` (
  `idbitacora` int(11) NOT NULL auto_increment COMMENT 'Id correlativo unico de cada bitacora',
  `idusuario` int(11) NOT NULL COMMENT 'Referencia al usuario que realizo el cambio',
  `descripcion` text NOT NULL COMMENT 'Descripcion del cambio que realizo el usuario',
  `fechahora` datetime NOT NULL COMMENT 'Fecha y hora a la que el usuario realizo el cambio',
  PRIMARY KEY  (`idbitacora`),
  KEY `fkidusuario_bitacoracambiosusuario` (`idusuario`),
  CONSTRAINT `fkidusuario_bitacoracambiosusuario` FOREIGN KEY (`idusuario`) REFERENCES `usuario` (`idusuario`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `bitacoracambiosusuario`
--

/*!40000 ALTER TABLE `bitacoracambiosusuario` DISABLE KEYS */;
/*!40000 ALTER TABLE `bitacoracambiosusuario` ENABLE KEYS */;


--
-- Definition of table `bitacoraestados`
--

DROP TABLE IF EXISTS `bitacoraestados`;
CREATE TABLE `bitacoraestados` (
  `idbitacora` int(11) NOT NULL auto_increment COMMENT 'Id correlativo unico de cada bitacora',
  `fecha` date NOT NULL COMMENT 'Fecha en la que ocurrio el cambio de estado',
  `idestado` int(11) NOT NULL COMMENT 'Referencia al estado al cual cambio el equipo',
  `descripcion` text NOT NULL COMMENT 'Descripcion del cambio realizado',
  `idequipoexistente` int(11) default NULL COMMENT 'Referencia al equipo que sufrio el cambio de estado',
  `idequiposimple` int(11) default NULL,
  PRIMARY KEY  (`idbitacora`),
  KEY `fkidestado_bitacoraestados` (`idestado`),
  KEY `fkidequipoexistente_bitacoraestados` (`idequipoexistente`),
  KEY `fkidequiposimple_bitacoraestados` (`idequiposimple`),
  CONSTRAINT `fkidequipoexistente_bitacoraestados` FOREIGN KEY (`idequipoexistente`) REFERENCES `existencia` (`idexistencia`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fkidequiposimple_bitacoraestados` FOREIGN KEY (`idequiposimple`) REFERENCES `equiposimple` (`idEquipoSimple`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fkidestado_bitacoraestados` FOREIGN KEY (`idestado`) REFERENCES `estadoequipo` (`idestado`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `bitacoraestados`
--

/*!40000 ALTER TABLE `bitacoraestados` DISABLE KEYS */;
INSERT INTO `bitacoraestados` (`idbitacora`,`fecha`,`idestado`,`descripcion`,`idequipoexistente`,`idequiposimple`) VALUES 
 (1,'2009-06-22',2,'Virus',NULL,4),
 (2,'2009-06-22',2,'Virus',NULL,4),
 (3,'2009-06-23',2,'No sirve el monitor porque lo jodi si lo jodi',NULL,13),
 (4,'2009-06-24',2,'aja si como no',NULL,13),
 (5,'2009-06-26',2,'Se reinstalo Office 2003, se hizo limpieza con CCleaner y se instalo Office 2007. También se instalo Avast 4.8 professional',NULL,11),
 (6,'2009-06-26',3,'Se desinstalo NOD 32 y se instalo Avast 4.8',NULL,12),
 (7,'2009-06-28',2,'Se reinstalo el NERO PORQUE SE JODIO',NULL,10),
 (8,'2009-06-29',2,'Se reinstalo el ubuntu y se le puso XP',NULL,14),
 (9,'2009-06-29',2,'Le dieron verga a EEUU',NULL,12);
/*!40000 ALTER TABLE `bitacoraestados` ENABLE KEYS */;


--
-- Definition of table `carrera`
--

DROP TABLE IF EXISTS `carrera`;
CREATE TABLE `carrera` (
  `idcarrera` int(11) NOT NULL auto_increment COMMENT 'Id correlativo unico de cada carrera',
  `codigo` varchar(7) NOT NULL COMMENT 'Codigo de la carrera, distintivo en el sistema adacad',
  `nombre` varchar(200) NOT NULL COMMENT 'Nombre de la carrera',
  `idfacultad` int(11) NOT NULL COMMENT 'Referencia a la facultad a la cual pertenece esta carrera',
  PRIMARY KEY  (`idcarrera`),
  KEY `fkidfacultad_carrera` (`idfacultad`),
  CONSTRAINT `fkidfacultad_carrera` FOREIGN KEY (`idfacultad`) REFERENCES `facultad` (`idfacultad`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `carrera`
--

/*!40000 ALTER TABLE `carrera` DISABLE KEYS */;
INSERT INTO `carrera` (`idcarrera`,`codigo`,`nombre`,`idfacultad`) VALUES 
 (1,'I30515','Ingeniería de Sistemas Informáticos',1);
/*!40000 ALTER TABLE `carrera` ENABLE KEYS */;


--
-- Definition of table `clase`
--

DROP TABLE IF EXISTS `clase`;
CREATE TABLE `clase` (
  `idclase` int(11) NOT NULL auto_increment COMMENT 'Id correlativo unico para cada clase',
  `fecha` date NOT NULL COMMENT 'Fecha en la que se llevo a cabo esta clase',
  `idhorario` int(11) NOT NULL COMMENT 'Referencia al horario en el que se recibio esta clase',
  `idinstructor` int(11) default NULL COMMENT 'Referencia al instructor encargado de dar esta clase (en caso que haya sido un instructor)',
  `tema` varchar(45) NOT NULL COMMENT 'Tema visto en esta clase',
  `observaciones` text COMMENT 'Observaciones obtenidas segun el resultado general de la clase',
  `iddocente` int(11) default NULL COMMENT 'Referencia al docente encargado de dar esta clase (en caso que haya sido un docente)',
  PRIMARY KEY  (`idclase`),
  KEY `fkidhorario_clase` (`idhorario`),
  KEY `fkidinstructor_clase` (`idinstructor`),
  KEY `fkiddocente_clase` (`iddocente`),
  CONSTRAINT `fkiddocente_clase` FOREIGN KEY (`iddocente`) REFERENCES `docente` (`iddocente`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fkidhorario_clase` FOREIGN KEY (`idhorario`) REFERENCES `horario` (`idhorario`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fkidinstructor_clase` FOREIGN KEY (`idinstructor`) REFERENCES `instructor` (`idinstructor`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `clase`
--

/*!40000 ALTER TABLE `clase` DISABLE KEYS */;
INSERT INTO `clase` (`idclase`,`fecha`,`idhorario`,`idinstructor`,`tema`,`observaciones`,`iddocente`) VALUES 
 (1,'2009-03-05',1,2,'Herencia en Java','N/A',1);
/*!40000 ALTER TABLE `clase` ENABLE KEYS */;


--
-- Definition of table `clasificacion`
--

DROP TABLE IF EXISTS `clasificacion`;
CREATE TABLE `clasificacion` (
  `idclasificacion` int(11) NOT NULL auto_increment COMMENT 'Id correlativo unico de cada clasificacion',
  `nombre` varchar(100) NOT NULL COMMENT 'Nombre de la clasificacion',
  `descripcion` text COMMENT 'Descripcion de la clasificacion',
  `idsuperior` int(11) default NULL COMMENT 'Referencia a la clasificacion padre. Si este campo es nulo, indica que esta es una clasificacion raiz',
  PRIMARY KEY  (`idclasificacion`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `clasificacion`
--

/*!40000 ALTER TABLE `clasificacion` DISABLE KEYS */;
INSERT INTO `clasificacion` (`idclasificacion`,`nombre`,`descripcion`,`idsuperior`) VALUES 
 (1,'General','Clasificacion general',NULL),
 (2,'Hardware','Hardware',1),
 (3,'Software','Software',1),
 (4,'Equipos','Equipos',2),
 (5,'Accesorios','Accesorios',2),
 (6,'Piezas','Piezas',2),
 (7,'Herramientas de mantenimiento','Herramientas de mantenimiento',2),
 (8,'Dispositivos de red','Dispositivos de red',2),
 (9,'Sistemas operativos','Sistemas operativos',3),
 (10,'Utilerías','Utilerías',3),
 (12,'Herramientas didácticas','Herramientas didácticas',3),
 (13,'Desktops','Desktops',4),
 (14,'Laptops','Laptops',4),
 (15,'Impresoras','Impresoras',5),
 (16,'Cañones','Proyectores',5);
/*!40000 ALTER TABLE `clasificacion` ENABLE KEYS */;


--
-- Definition of table `comentarios`
--

DROP TABLE IF EXISTS `comentarios`;
CREATE TABLE `comentarios` (
  `idcoment` int(11) NOT NULL,
  `comentario` varchar(250) NOT NULL,
  `fechahorara` datetime NOT NULL,
  `identrada` int(11) NOT NULL,
  PRIMARY KEY  (`idcoment`),
  KEY `fk_comentarios_entrada` (`identrada`),
  CONSTRAINT `fk_comentarios_entrada` FOREIGN KEY (`identrada`) REFERENCES `entrada` (`identrada`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `comentarios`
--

/*!40000 ALTER TABLE `comentarios` DISABLE KEYS */;
INSERT INTO `comentarios` (`idcoment`,`comentario`,`fechahorara`,`identrada`) VALUES 
 (1,'Lorem ipsum EST!','2009-06-06 00:00:00',1);
/*!40000 ALTER TABLE `comentarios` ENABLE KEYS */;


--
-- Definition of table `curso`
--

DROP TABLE IF EXISTS `curso`;
CREATE TABLE `curso` (
  `idcurso` int(11) NOT NULL auto_increment COMMENT 'Id correlativo unico de cada curso',
  `nombre` varchar(200) NOT NULL COMMENT 'Nombre del curso (por si este difiere del nombre de la materia o por si no esta relacionado con una materia especifica)',
  `cupomax` int(11) NOT NULL COMMENT 'Cantidad maxima de alumnos que pueden inscribirse a este curso',
  `idmateria` int(11) default NULL COMMENT 'Referencia a la materia relacionada con este curso (en caso que este relacionado con alguna)',
  `idinstructor` int(11) NOT NULL COMMENT 'Referencia al instructor asignado a impartir este curso',
  `fechainicio` date NOT NULL COMMENT 'Fecha de inicio del curso',
  `ciclo` int(11) default NULL COMMENT 'Ciclo en el que se imparte este curso (1=ciclo impar, 2=ciclo par)',
  `anio` int(11) default NULL COMMENT 'anio en el que se imparte este curso',
  `iddocente` int(11) NOT NULL COMMENT 'Referencia al docente encargado de impartir este curso',
  `idestado` int(11) default NULL,
  PRIMARY KEY  (`idcurso`),
  KEY `fkidmateria_curso` (`idmateria`),
  KEY `fkidinstructor_curso` (`idinstructor`),
  KEY `fkiddocente_curso` (`iddocente`),
  KEY `fkidestado_curso` (`idestado`),
  CONSTRAINT `fkiddocente_curso` FOREIGN KEY (`iddocente`) REFERENCES `docente` (`iddocente`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fkidestado_curso` FOREIGN KEY (`idestado`) REFERENCES `estadocurso` (`idestadocurso`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fkidinstructor_curso` FOREIGN KEY (`idinstructor`) REFERENCES `instructor` (`idinstructor`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fkidmateria_curso` FOREIGN KEY (`idmateria`) REFERENCES `materia` (`idmateria`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `curso`
--

/*!40000 ALTER TABLE `curso` DISABLE KEYS */;
INSERT INTO `curso` (`idcurso`,`nombre`,`cupomax`,`idmateria`,`idinstructor`,`fechainicio`,`ciclo`,`anio`,`iddocente`,`idestado`) VALUES 
 (1,'Grupo 1 ',20,2,2,'2009-03-03',1,2009,1,NULL);
/*!40000 ALTER TABLE `curso` ENABLE KEYS */;


--
-- Definition of table `docente`
--

DROP TABLE IF EXISTS `docente`;
CREATE TABLE `docente` (
  `iddocente` int(11) NOT NULL auto_increment COMMENT 'Id correlativo unico para cada docente',
  `Apellidos` varchar(200) NOT NULL COMMENT 'Apellidos del docente',
  `Nombres` varchar(200) NOT NULL COMMENT 'Nombres del docente',
  `idusuario` int(11) NOT NULL COMMENT 'Referencia al usuario con el que el docente ingresa al sistema',
  `visible` int(11) NOT NULL COMMENT 'Es 1 por defecto. Indica que el usuario esta activo. Al momento de borrar usuarios del sistema, nada mas cambiar este estado a 0.',
  PRIMARY KEY  (`iddocente`),
  KEY `fkidusuario_docente` (`idusuario`),
  CONSTRAINT `fkidusuario_docente` FOREIGN KEY (`idusuario`) REFERENCES `usuario` (`idusuario`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `docente`
--

/*!40000 ALTER TABLE `docente` DISABLE KEYS */;
INSERT INTO `docente` (`iddocente`,`Apellidos`,`Nombres`,`idusuario`,`visible`) VALUES 
 (1,'Linares Paula','Carlos Stanley',4,1),
 (2,'Barrera','Luis Alonso',1,1);
/*!40000 ALTER TABLE `docente` ENABLE KEYS */;


--
-- Definition of table `entrada`
--

DROP TABLE IF EXISTS `entrada`;
CREATE TABLE `entrada` (
  `identrada` int(11) NOT NULL,
  `titulo` varchar(50) NOT NULL,
  `descripcion` text NOT NULL,
  `fechahora` datetime NOT NULL,
  `idusuario` int(11) NOT NULL,
  PRIMARY KEY  (`identrada`),
  KEY `fk_entrada_usuario` (`idusuario`),
  CONSTRAINT `fk_entrada_usuario` FOREIGN KEY (`idusuario`) REFERENCES `usuario` (`idusuario`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `entrada`
--

/*!40000 ALTER TABLE `entrada` DISABLE KEYS */;
INSERT INTO `entrada` (`identrada`,`titulo`,`descripcion`,`fechahora`,`idusuario`) VALUES 
 (1,'Titulo 1','Lorem ipsum dolor sit amet, \\nconsectetur adipiscing elit. \\nSed cursus dictum cursus. \\nCras nibh augue, pharetra tempor hendrerit at,\\nconvallis id nunc. Maecenas felis lorem,\\nfeugiat nec mollis id, rhoncus pharetra enim.\\nSed quis libero porttitor odio accumsan imperdiet ac iaculis nisl. Maecenas diam orci, porta sit amet ornare a, cursus sit amet massa. Cras a posuere eros. Donec sodales luctus purus. Etiam nibh ante, mollis ac condimentum in, convallis egestas nisi. Integer imperdiet lectus eget velit aliquet rutrum. \\nProin ligula tellus, viverra vitae tincidunt ut, venenatis nec justo. In ut nisl urna. Aliquam erat volutpat. Nam quis sem ut magna fermentum tempus vitae at eros. Vivamus fermentum sem eget nunc viverra vitae consequat diam tempus.','2009-06-01 00:00:00',1),
 (2,'Titulo 2','Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed cursus dictum cursus. Cras nibh augue, pharetra tempor hendrerit at, convallis id nunc. Maecenas felis lorem, feugiat nec mollis id, rhoncus pharetra enim. Sed quis libero porttitor odio accumsan imperdiet ac iaculis nisl. Maecenas diam orci, porta sit amet ornare a, cursus sit amet massa. Cras a posuere eros. Donec sodales luctus purus. Etiam nibh ante, mollis ac condimentum in, convallis egestas nisi. Integer imperdiet lectus eget velit aliquet rutrum. Proin ligula tellus, viverra vitae tincidunt ut, venenatis nec justo. In ut nisl urna. Aliquam erat volutpat. Nam quis sem ut magna fermentum tempus vitae at eros. Vivamus fermentum sem eget nunc viverra vitae consequat diam tempus.','2009-05-30 00:00:00',1),
 (3,'Titulo 3','Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed cursus dictum cursus. Cras nibh augue, pharetra tempor hendrerit at, convallis id nunc. Maecenas felis lorem, feugiat nec mollis id, rhoncus pharetra enim. Sed quis libero porttitor odio accumsan imperdiet ac iaculis nisl. Maecenas diam orci, porta sit amet ornare a, cursus sit amet massa. Cras a posuere eros. Donec sodales luctus purus. Etiam nibh ante, mollis ac condimentum in, convallis egestas nisi. Integer imperdiet lectus eget velit aliquet rutrum. Proin ligula tellus, viverra vitae tincidunt ut, venenatis nec justo. In ut nisl urna. Aliquam erat volutpat. Nam quis sem ut magna fermentum tempus vitae at eros. Vivamus fermentum sem eget nunc viverra vitae consequat diam tempus.','2009-05-30 00:00:00',1),
 (4,'Titulo 4','Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed cursus dictum cursus. Cras nibh augue, pharetra tempor hendrerit at, convallis id nunc. Maecenas felis lorem, feugiat nec mollis id, rhoncus pharetra enim. Sed quis libero porttitor odio accumsan imperdiet ac iaculis nisl. Maecenas diam orci, porta sit amet ornare a, cursus sit amet massa. Cras a posuere eros. Donec sodales luctus purus. Etiam nibh ante, mollis ac condimentum in, convallis egestas nisi. Integer imperdiet lectus eget velit aliquet rutrum. Proin ligula tellus, viverra vitae tincidunt ut, venenatis nec justo. In ut nisl urna. Aliquam erat volutpat. Nam quis sem ut magna fermentum tempus vitae at eros. Vivamus fermentum sem eget nunc viverra vitae consequat diam tempus.','2009-05-30 00:00:00',9);
/*!40000 ALTER TABLE `entrada` ENABLE KEYS */;


--
-- Definition of table `equipo`
--

DROP TABLE IF EXISTS `equipo`;
CREATE TABLE `equipo` (
  `idequipo` int(11) NOT NULL auto_increment COMMENT 'Id correlativo unico de cada equipo',
  `idmarca` int(11) NOT NULL COMMENT 'Referencia a la marca que posee este equipo',
  `nombre` varchar(45) NOT NULL COMMENT 'Nombre del equipo',
  `modelo` varchar(15) NOT NULL COMMENT 'Modelo al cual pertenece el equipo',
  `idclasificacion` int(11) NOT NULL COMMENT 'Referencia a la clasificacion a la cual esta relacionado este equipo',
  PRIMARY KEY  (`idequipo`),
  KEY `fkidmarca_equipo` (`idmarca`),
  KEY `fkidclasificacion_equipo` (`idclasificacion`),
  CONSTRAINT `fkidclasificacion_equipo` FOREIGN KEY (`idclasificacion`) REFERENCES `clasificacion` (`idclasificacion`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fkidmarca_equipo` FOREIGN KEY (`idmarca`) REFERENCES `marca` (`idmarca`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `equipo`
--

/*!40000 ALTER TABLE `equipo` DISABLE KEYS */;
INSERT INTO `equipo` (`idequipo`,`idmarca`,`nombre`,`modelo`,`idclasificacion`) VALUES 
 (1,9,'PC','PC',13),
 (2,1,'DellPC','Vostro',13),
 (3,12,'Cañon','Epson',16),
 (4,3,'Laptop','Satellite',14),
 (5,12,'Cañon','ProView',16),
 (6,2,'Laptop','VGN',14);
/*!40000 ALTER TABLE `equipo` ENABLE KEYS */;


--
-- Definition of table `equiposimple`
--

DROP TABLE IF EXISTS `equiposimple`;
CREATE TABLE `equiposimple` (
  `idEquipoSimple` int(11) NOT NULL auto_increment COMMENT 'Id correlativo unico de cada equipo simple',
  `descripcion` text NOT NULL COMMENT 'Descripcion del equipo simple',
  `propietario` varchar(200) NOT NULL COMMENT 'Nombre del propietario del equipo simple',
  `idestado` int(11) NOT NULL COMMENT 'Referencia al estado en el que se encuentra el equipo simple',
  PRIMARY KEY  (`idEquipoSimple`),
  KEY `fkidestado_equiposimple` (`idestado`),
  CONSTRAINT `fkidestado_equiposimple` FOREIGN KEY (`idestado`) REFERENCES `estadoequipo` (`idestado`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `equiposimple`
--

/*!40000 ALTER TABLE `equiposimple` DISABLE KEYS */;
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
 (13,'Computadora Arq Centeno','Carmencita',2),
 (14,'Laptop Luis','Luis Barrera',1),
 (19,'Big Boss','Daddy Yankee',2);
/*!40000 ALTER TABLE `equiposimple` ENABLE KEYS */;


--
-- Definition of table `estadocurso`
--

DROP TABLE IF EXISTS `estadocurso`;
CREATE TABLE `estadocurso` (
  `idestadocurso` int(11) NOT NULL auto_increment COMMENT 'Id correlativo unico para cada estado del curso',
  `nombre` varchar(100) NOT NULL COMMENT 'Nombre del estado del curso',
  PRIMARY KEY  (`idestadocurso`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `estadocurso`
--

/*!40000 ALTER TABLE `estadocurso` DISABLE KEYS */;
/*!40000 ALTER TABLE `estadocurso` ENABLE KEYS */;


--
-- Definition of table `estadoequipo`
--

DROP TABLE IF EXISTS `estadoequipo`;
CREATE TABLE `estadoequipo` (
  `idestado` int(11) NOT NULL auto_increment COMMENT 'Id correlativo unico de cada estado',
  `nombre` varchar(45) NOT NULL COMMENT 'Nombre del estado',
  `descripcion` text COMMENT 'Descripcion del estado',
  PRIMARY KEY  (`idestado`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `estadoequipo`
--

/*!40000 ALTER TABLE `estadoequipo` DISABLE KEYS */;
INSERT INTO `estadoequipo` (`idestado`,`nombre`,`descripcion`) VALUES 
 (1,'Excelente','Óptimas condiciones'),
 (2,'Muy Bueno','Condiciones aceptables'),
 (3,'Bueno','Condiciones estables'),
 (4,'Malo','Falla por ciertos períodos de tiempo'),
 (5,'Muy Malo','Falla casi siempre'),
 (6,'Pésimo','Imposible de utilizar');
/*!40000 ALTER TABLE `estadoequipo` ENABLE KEYS */;


--
-- Definition of table `estadoreserva`
--

DROP TABLE IF EXISTS `estadoreserva`;
CREATE TABLE `estadoreserva` (
  `idestadoreserva` int(11) NOT NULL auto_increment COMMENT 'Id correlativo unico de cada reserva',
  `nombre` varchar(100) NOT NULL COMMENT 'Nombre del estado de la reserva',
  PRIMARY KEY  (`idestadoreserva`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `estadoreserva`
--

/*!40000 ALTER TABLE `estadoreserva` DISABLE KEYS */;
INSERT INTO `estadoreserva` (`idestadoreserva`,`nombre`) VALUES 
 (1,'Pendiente'),
 (2,'En uso'),
 (3,'Despachada');
/*!40000 ALTER TABLE `estadoreserva` ENABLE KEYS */;


--
-- Definition of table `estudiante`
--

DROP TABLE IF EXISTS `estudiante`;
CREATE TABLE `estudiante` (
  `idestudiante` int(11) NOT NULL auto_increment COMMENT 'Id correlativo unico para cada estudiante',
  `carnet` varchar(7) NOT NULL COMMENT 'Carnet del estudiante, representativo y distintivo en el registro de la facultad',
  `apellidos` varchar(200) NOT NULL COMMENT 'Apellidos del estudiante',
  `nombres` varchar(200) NOT NULL COMMENT 'Nombres del estudiante',
  `idusuario` int(11) NOT NULL COMMENT 'Referencia con la que el usuario ingresa al sistema',
  `visible` int(11) NOT NULL default '1' COMMENT 'Indica el estado de este estudiante. Es 1 por defecto. Indica que el usuario esta activo. Al momento de borrar usuarios del sistema, nada mas cambiar este estado a 0.',
  PRIMARY KEY  (`idestudiante`),
  KEY `fkidusuario_estudiante` (`idusuario`),
  CONSTRAINT `fkidusuario_estudiante` FOREIGN KEY (`idusuario`) REFERENCES `usuario` (`idusuario`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `estudiante`
--

/*!40000 ALTER TABLE `estudiante` DISABLE KEYS */;
INSERT INTO `estudiante` (`idestudiante`,`carnet`,`apellidos`,`nombres`,`idusuario`,`visible`) VALUES 
 (1,'SM08003','Salgado Martínez','Rebeca Marcela',7,1);
/*!40000 ALTER TABLE `estudiante` ENABLE KEYS */;


--
-- Definition of table `existencia`
--

DROP TABLE IF EXISTS `existencia`;
CREATE TABLE `existencia` (
  `idexistencia` int(11) NOT NULL auto_increment COMMENT 'Id correlativo unico para cada existencia',
  `idhardware` int(11) NOT NULL COMMENT 'Referencia al hardware al cual pertenece esta existencia',
  `idubicacion` int(11) NOT NULL COMMENT 'Referencia a la ubicacion donde se encuentra localizada esta existencia',
  `idestado` int(11) NOT NULL COMMENT 'Referencia al estado en el que se encuentra esta existencia',
  `codigo` varchar(45) NOT NULL COMMENT 'Codigo con el cual clasificar esta existencia en el inventario',
  PRIMARY KEY  (`idexistencia`),
  KEY `fkidhardware_existencia` (`idhardware`),
  KEY `fkidubicacion_existencia` (`idubicacion`),
  KEY `fkidestado_existencia` (`idestado`),
  CONSTRAINT `fkidestado_existencia` FOREIGN KEY (`idestado`) REFERENCES `estadoequipo` (`idestado`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fkidhardware_existencia` FOREIGN KEY (`idhardware`) REFERENCES `equipo` (`idequipo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fkidubicacion_existencia` FOREIGN KEY (`idubicacion`) REFERENCES `ubicacion` (`idubicacion`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `existencia`
--

/*!40000 ALTER TABLE `existencia` DISABLE KEYS */;
INSERT INTO `existencia` (`idexistencia`,`idhardware`,`idubicacion`,`idestado`,`codigo`) VALUES 
 (1,1,1,1,'codigo de barras'),
 (2,1,1,1,'codigo de barras'),
 (3,1,1,1,'codigo de barras'),
 (4,2,1,1,'codigo de barras'),
 (5,2,1,1,'codigo de barras'),
 (6,3,1,2,'codigo de barras'),
 (7,3,1,2,'codigo de barras'),
 (8,4,1,1,'codigo de barras'),
 (9,4,1,1,'codigo de barras'),
 (10,5,1,2,'codigo de barras'),
 (11,5,1,2,'codigo de barras'),
 (12,6,1,1,'codigo de barras'),
 (13,6,1,1,'codigo de barras');
/*!40000 ALTER TABLE `existencia` ENABLE KEYS */;


--
-- Definition of table `facultad`
--

DROP TABLE IF EXISTS `facultad`;
CREATE TABLE `facultad` (
  `idfacultad` int(11) NOT NULL auto_increment COMMENT 'Id correlativo unico de cada facultad',
  `nombre` varchar(200) NOT NULL COMMENT 'Nombre de la facultad',
  PRIMARY KEY  (`idfacultad`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `facultad`
--

/*!40000 ALTER TABLE `facultad` DISABLE KEYS */;
INSERT INTO `facultad` (`idfacultad`,`nombre`) VALUES 
 (1,'Facultad Multidisciplinaria de Occidente');
/*!40000 ALTER TABLE `facultad` ENABLE KEYS */;


--
-- Definition of table `horario`
--

DROP TABLE IF EXISTS `horario`;
CREATE TABLE `horario` (
  `idhorario` int(11) NOT NULL auto_increment COMMENT 'Id correlativo unico para cada horario',
  `diasemana` int(11) NOT NULL COMMENT 'Dia de la semana que se brinda el curso (1= lunes, 7= domingo)',
  `horainicio` time NOT NULL COMMENT 'Hora a la que da inicio el curso',
  `horafin` time NOT NULL COMMENT 'Hora a la que finaliza el curso',
  `idcurso` int(11) NOT NULL COMMENT 'Referencia al curso relacionado con este horario',
  `idaula` int(11) NOT NULL COMMENT 'Aula en la que se imparte este curso en este horario',
  PRIMARY KEY  (`idhorario`),
  KEY `fkidcurso_horario` (`idcurso`),
  KEY `fkidaula_horario` (`idaula`),
  CONSTRAINT `fkidaula_horario` FOREIGN KEY (`idaula`) REFERENCES `ubicacion` (`idubicacion`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fkidcurso_horario` FOREIGN KEY (`idcurso`) REFERENCES `curso` (`idcurso`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `horario`
--

/*!40000 ALTER TABLE `horario` DISABLE KEYS */;
INSERT INTO `horario` (`idhorario`,`diasemana`,`horainicio`,`horafin`,`idcurso`,`idaula`) VALUES 
 (1,1,'10:00:00','10:55:00',1,1);
/*!40000 ALTER TABLE `horario` ENABLE KEYS */;


--
-- Definition of table `inscripcion`
--

DROP TABLE IF EXISTS `inscripcion`;
CREATE TABLE `inscripcion` (
  `idinscripcion` int(11) NOT NULL auto_increment COMMENT 'Id correlativo unico para cada inscripcion',
  `idcurso` int(11) NOT NULL COMMENT 'Referencia al curso al cual se inscribio el estudiante',
  `idestudiante` int(11) NOT NULL COMMENT 'Referencia al estudiante inscrito en este curso',
  PRIMARY KEY  (`idinscripcion`),
  KEY `fkidcurso_inscripcion` (`idcurso`),
  KEY `fkidestudiante_inscripcion` (`idestudiante`),
  CONSTRAINT `fkidcurso_inscripcion` FOREIGN KEY (`idcurso`) REFERENCES `curso` (`idcurso`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fkidestudiante_inscripcion` FOREIGN KEY (`idestudiante`) REFERENCES `estudiante` (`idestudiante`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `inscripcion`
--

/*!40000 ALTER TABLE `inscripcion` DISABLE KEYS */;
/*!40000 ALTER TABLE `inscripcion` ENABLE KEYS */;


--
-- Definition of table `instalacion`
--

DROP TABLE IF EXISTS `instalacion`;
CREATE TABLE `instalacion` (
  `idinstalacion` int(11) NOT NULL auto_increment COMMENT 'Id correlativo unico de cada instalacion',
  `idsoftware` int(11) NOT NULL COMMENT 'Referencia al software instalado',
  `fechainstalacion` date NOT NULL COMMENT 'Fecha en la que se realizo la instalacion',
  `idequipoexistente` int(11) NOT NULL COMMENT 'Referencia al equipo donde se instalo el software',
  PRIMARY KEY  (`idinstalacion`),
  KEY `fkidsoftware_instalacion` (`idsoftware`),
  KEY `fkidequipoexistente_instalacion` (`idequipoexistente`),
  CONSTRAINT `fkidequipoexistente_instalacion` FOREIGN KEY (`idequipoexistente`) REFERENCES `existencia` (`idexistencia`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fkidsoftware_instalacion` FOREIGN KEY (`idsoftware`) REFERENCES `software` (`idsoftware`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `instalacion`
--

/*!40000 ALTER TABLE `instalacion` DISABLE KEYS */;
INSERT INTO `instalacion` (`idinstalacion`,`idsoftware`,`fechainstalacion`,`idequipoexistente`) VALUES 
 (1,1,'2009-04-03',2);
/*!40000 ALTER TABLE `instalacion` ENABLE KEYS */;


--
-- Definition of table `instructor`
--

DROP TABLE IF EXISTS `instructor`;
CREATE TABLE `instructor` (
  `idinstructor` int(11) NOT NULL auto_increment COMMENT 'Id correlativo unico para cada instructor',
  `carnet` varchar(7) NOT NULL COMMENT 'Carnet con el cual se encuentra registrado en adacad',
  `apellidos` varchar(200) NOT NULL COMMENT 'Apellidos del instructor',
  `nombres` varchar(200) NOT NULL COMMENT 'Nombres del instructor',
  `idusuario` int(11) NOT NULL COMMENT 'Referencia al usuario con el que instructor accede al sistema',
  `visible` int(11) NOT NULL default '1' COMMENT 'Estado del instructor. Por defecto es 1, lo cual significa que esta en uso. Al momento de borrar un instructor, nada mas se cambia este campo a 0.',
  PRIMARY KEY  (`idinstructor`),
  KEY `fkidusuario_instructor` (`idusuario`),
  CONSTRAINT `fkidusuario_instructor` FOREIGN KEY (`idusuario`) REFERENCES `usuario` (`idusuario`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `instructor`
--

/*!40000 ALTER TABLE `instructor` DISABLE KEYS */;
INSERT INTO `instructor` (`idinstructor`,`carnet`,`apellidos`,`nombres`,`idusuario`,`visible`) VALUES 
 (1,'CC02043','Cerna','Fredy',8,1),
 (2,'BP04004','Barrientos Padilla','Hugo Alejandro',9,1);
/*!40000 ALTER TABLE `instructor` ENABLE KEYS */;


--
-- Definition of table `mantenimiento`
--

DROP TABLE IF EXISTS `mantenimiento`;
CREATE TABLE `mantenimiento` (
  `idmantenimiento` int(11) NOT NULL auto_increment COMMENT 'Id correlativo unico de cada mantenimiento',
  `fecha` date NOT NULL COMMENT 'Fecha en la que se efectuo el mantenimiento',
  `descripcion` text NOT NULL COMMENT 'Descripcion del mantenimiento',
  `idtecnico` int(11) NOT NULL COMMENT 'Referencia al tecnico que efectuo el mantenimiento',
  `idsolicitud` int(11) default NULL COMMENT 'Referencia a la solicitud de mantenimiento realizada, en caso de existir una',
  `idequipoexistente` int(11) default NULL COMMENT 'Referencia al equipo al cual se efectuo el mantenimiento',
  `idequiposimple` int(11) default NULL,
  `estado` text NOT NULL,
  PRIMARY KEY  (`idmantenimiento`),
  KEY `fkidtecnico_mantenimiento` (`idtecnico`),
  KEY `fkidsolicitud_mantenimiento` (`idsolicitud`),
  KEY `fkidequipoexistente_mantenimiento` (`idequipoexistente`),
  KEY `fkidequiposimple_mantenimiento` (`idequiposimple`),
  CONSTRAINT `fkidequipoexistente_mantenimiento` FOREIGN KEY (`idequipoexistente`) REFERENCES `existencia` (`idexistencia`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fkidequiposimple_mantenimiento` FOREIGN KEY (`idequiposimple`) REFERENCES `equiposimple` (`idEquipoSimple`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fkidsolicitud_mantenimiento` FOREIGN KEY (`idsolicitud`) REFERENCES `solicitud` (`idsolicitud`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fkidtecnico_mantenimiento` FOREIGN KEY (`idtecnico`) REFERENCES `tecnico` (`idtecnico`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `mantenimiento`
--

/*!40000 ALTER TABLE `mantenimiento` DISABLE KEYS */;
INSERT INTO `mantenimiento` (`idmantenimiento`,`fecha`,`descripcion`,`idtecnico`,`idsolicitud`,`idequipoexistente`,`idequiposimple`,`estado`) VALUES 
 (2,'3909-06-21','Virus',3,7,NULL,4,'Finalizado'),
 (3,'3909-06-21','VIRUS MIERDA',4,3,NULL,1,'Pendiente'),
 (4,'3909-06-23','No sirve el monitor',4,8,NULL,13,'Finalizado'),
 (5,'3909-06-26','No abre el Office 2003 y necesitamos el Office 2007',14,10,NULL,11,'Finalizado'),
 (7,'3909-06-28','q jodo vaaaaaaaa',4,13,NULL,3,'Pendiente'),
 (8,'3909-06-28','Se frego el NERO',14,11,NULL,10,'Finalizado'),
 (9,'2009-06-29','jajajaja',4,14,NULL,8,'Pendiente'),
 (10,'2009-06-29','JODIO EL UBUNTU',14,16,NULL,14,'Finalizado'),
 (11,'2009-06-29','Brasil campeon de la confederaciones',4,15,NULL,12,'Finalizado'),
 (13,'2009-07-01','Virus',3,2,NULL,1,'Pendiente');
/*!40000 ALTER TABLE `mantenimiento` ENABLE KEYS */;


--
-- Definition of table `marca`
--

DROP TABLE IF EXISTS `marca`;
CREATE TABLE `marca` (
  `idmarca` int(11) NOT NULL auto_increment COMMENT 'Id correlativo unico de cada marca',
  `nombre` varchar(100) NOT NULL COMMENT 'Nombre de la marca',
  PRIMARY KEY  (`idmarca`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `marca`
--

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
 (11,'Seagate'),
 (12,'Epson');
/*!40000 ALTER TABLE `marca` ENABLE KEYS */;


--
-- Definition of table `materia`
--

DROP TABLE IF EXISTS `materia`;
CREATE TABLE `materia` (
  `idmateria` int(11) NOT NULL auto_increment COMMENT 'Id correlativo unico de cada materia',
  `codigo` varchar(7) NOT NULL COMMENT 'Codigo de la materia, con el cual se identifica en adacad',
  `nombre` varchar(200) NOT NULL COMMENT 'Nombre de la materia',
  `idcarrera` int(11) NOT NULL COMMENT 'Referencia a la carrera a la cual pertenece esta materia',
  PRIMARY KEY  (`idmateria`),
  KEY `fkidcarrera_materia` (`idcarrera`),
  CONSTRAINT `fkidcarrera_materia` FOREIGN KEY (`idcarrera`) REFERENCES `carrera` (`idcarrera`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `materia`
--

/*!40000 ALTER TABLE `materia` DISABLE KEYS */;
INSERT INTO `materia` (`idmateria`,`codigo`,`nombre`,`idcarrera`) VALUES 
 (1,'ALG-135','Algoritmos Gráficos',1),
 (2,'PRN-235','Programación II',1);
/*!40000 ALTER TABLE `materia` ENABLE KEYS */;


--
-- Definition of table `pieza`
--

DROP TABLE IF EXISTS `pieza`;
CREATE TABLE `pieza` (
  `idpieza` int(11) NOT NULL auto_increment COMMENT 'Id correlativo unico de cada pieza',
  `nombre` varchar(100) NOT NULL COMMENT 'Nombre de la pieza',
  `idmarca` int(11) NOT NULL COMMENT 'Referencia a la marca de la pieza',
  `modelo` varchar(15) NOT NULL COMMENT 'Modelo de la pieza',
  `idclasificacion` int(11) NOT NULL COMMENT 'Referencia a la clasificacion en la que se encuentra la pieza',
  `idexistencia` int(11) default NULL,
  PRIMARY KEY  (`idpieza`),
  KEY `fkidclasificacion_pieza` (`idclasificacion`),
  KEY `fkidmarca_pieza` (`idmarca`),
  KEY `fkidexistencia_pieza` (`idexistencia`),
  CONSTRAINT `fkidexistencia_pieza` FOREIGN KEY (`idexistencia`) REFERENCES `existencia` (`idexistencia`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fkidclasificacion_pieza` FOREIGN KEY (`idclasificacion`) REFERENCES `clasificacion` (`idclasificacion`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fkidmarca_pieza` FOREIGN KEY (`idmarca`) REFERENCES `marca` (`idmarca`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `pieza`
--

/*!40000 ALTER TABLE `pieza` DISABLE KEYS */;
INSERT INTO `pieza` (`idpieza`,`nombre`,`idmarca`,`modelo`,`idclasificacion`,`idexistencia`) VALUES 
 (1,'memoria RAM',10,'kingston',6,NULL),
 (2,'disco duro',11,'seagate',6,NULL);
/*!40000 ALTER TABLE `pieza` ENABLE KEYS */;


--
-- Definition of table `reserva`
--

DROP TABLE IF EXISTS `reserva`;
CREATE TABLE `reserva` (
  `idreserva` int(11) NOT NULL auto_increment COMMENT 'Id correlativo unico de cada reserva',
  `fechareserva` date NOT NULL COMMENT 'fecha en la que se reservo el equipo',
  `fechahorainicioprestamo` datetime NOT NULL COMMENT 'Fecha y hora inicial a la que se utilizara el equipo',
  `fechahorafinprestamo` datetime NOT NULL COMMENT 'Fecha y hora final a la que se utilizara el equipo',
  `idubicacion` int(11) NOT NULL COMMENT 'Referencia al aula donde se utilizara el equipo',
  `idequipoexistente` int(11) NOT NULL COMMENT 'Referencia al equipo que se utilizara',
  `idusuario` int(11) NOT NULL COMMENT 'Referencia al usuario que registro la reserva',
  `idestado` int(11) NOT NULL COMMENT 'Referencia al estado en el que se encuentra esta reserva',
  `descripcion` text NOT NULL COMMENT 'Descripcion y justificacion de la reserva',
  `iddocente` int(11) NOT NULL,
  PRIMARY KEY  (`idreserva`),
  KEY `fkidestado_reserva` (`idestado`),
  KEY `fkidequipoexistente_reserva` (`idequipoexistente`),
  KEY `fkidubicacion_reserva` (`idubicacion`),
  KEY `fkidusuario_reserva` (`idusuario`),
  KEY `fkiddocente_reserva` (`iddocente`),
  CONSTRAINT `fkiddocente_reserva` FOREIGN KEY (`iddocente`) REFERENCES `docente` (`iddocente`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fkidequipoexistente_reserva` FOREIGN KEY (`idequipoexistente`) REFERENCES `existencia` (`idexistencia`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fkidestado_reserva` FOREIGN KEY (`idestado`) REFERENCES `estadoreserva` (`idestadoreserva`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fkidubicacion_reserva` FOREIGN KEY (`idubicacion`) REFERENCES `ubicacion` (`idubicacion`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fkidusuario_reserva` FOREIGN KEY (`idusuario`) REFERENCES `usuario` (`idusuario`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `reserva`
--

/*!40000 ALTER TABLE `reserva` DISABLE KEYS */;
INSERT INTO `reserva` (`idreserva`,`fechareserva`,`fechahorainicioprestamo`,`fechahorafinprestamo`,`idubicacion`,`idequipoexistente`,`idusuario`,`idestado`,`descripcion`,`iddocente`) VALUES 
 (1,'2009-07-08','2009-07-15 15:55:00','2009-07-15 17:15:00',1,6,9,3,'Prestamo de Cañon Epson Epson',1),
 (2,'2009-07-09','2009-07-16 10:05:00','2009-07-16 11:45:00',1,6,9,1,'Prestamo de Cañon Epson a Stanley',1),
 (3,'2009-07-10','2009-07-10 10:05:00','2009-07-10 11:45:00',1,6,9,1,'Prestamo de Cañon Epson  Epson',2),
 (4,'2009-07-10','2009-07-09 17:10:00','2009-07-09 18:50:00',1,6,8,1,'Prestamo de Cañon Epson  Epson',2),
 (6,'2009-07-10','2009-07-07 10:05:00','2009-07-07 12:35:00',1,6,9,1,'Prestamo de Cañon Epson  Epson',2),
 (7,'2009-07-10','2009-07-07 18:00:00','2009-07-07 20:30:00',1,6,9,1,'Prestamo de Cañon Epson Epson',2),
 (8,'2009-07-10','2009-07-07 10:55:00','2009-07-07 12:35:00',1,10,9,1,'Prestamo de Cañon Epson  ProView',2),
 (9,'2009-07-10','2009-07-07 10:55:00','2009-07-07 12:35:00',1,12,9,3,'Prestamo de Laptop Sony VGN',2),
 (10,'2009-07-10','2009-07-08 13:00:00','2009-07-08 15:30:00',1,12,9,1,'Prestamo de Laptop Sony VGN',1),
 (11,'2009-07-10','2009-07-15 14:40:00','2009-07-15 16:20:00',1,12,9,1,'Prestamo de Laptop Sony VGN',1),
 (12,'2009-07-10','2009-07-06 06:45:00','2009-07-06 09:15:00',1,9,9,3,'Prestamo de Laptop Toshiba Satellite',1),
 (14,'2009-07-10','2009-07-08 08:25:00','2009-07-08 10:05:00',1,10,9,3,'Prestamo de Cañon Epson  ProView',1),
 (15,'2009-07-11','2009-07-11 13:00:00','2009-07-11 17:10:00',1,10,9,3,'Prestamo de Cañon Epson  ProView',2),
 (16,'2009-07-11','2009-07-11 13:00:00','2009-07-11 17:10:00',1,12,9,3,'Prestamo de Laptop Sony VGN',2),
 (17,'2009-07-11','2009-07-07 10:05:00','2009-07-07 11:45:00',1,10,9,1,'Prestamo de Cañon Epson  ProView',1),
 (18,'2009-07-11','2009-07-06 10:05:00','2009-07-06 11:45:00',1,7,9,1,'Prestamo de Cañon Epson  Epson',1),
 (19,'2009-07-11','2009-07-06 10:05:00','2009-07-06 11:45:00',1,11,9,1,'Prestamo de Cañon Epson  ProView',2),
 (20,'2009-07-11','2009-07-06 10:05:00','2009-07-06 11:45:00',1,11,9,1,'Prestamo de Cañon Epson  ProView',2),
 (22,'2009-07-12','2009-07-12 10:05:00','2009-07-12 11:45:00',1,8,9,1,'Prestamo de Laptop Toshiba Satellite',2),
 (23,'2009-07-12','2009-07-12 10:05:00','2009-07-12 11:45:00',1,12,9,1,'Prestamo de Laptop Sony VGN',2),
 (24,'2009-07-12','2009-07-12 10:05:00','2009-07-12 11:45:00',1,12,9,1,'Prestamo de Laptop Sony VGN',2),
 (25,'2009-07-12','2009-07-12 10:05:00','2009-07-12 11:45:00',1,8,9,1,'Prestamo de Laptop Toshiba Satellite',2);
/*!40000 ALTER TABLE `reserva` ENABLE KEYS */;


--
-- Definition of table `rol`
--

DROP TABLE IF EXISTS `rol`;
CREATE TABLE `rol` (
  `idrol` int(11) NOT NULL auto_increment COMMENT 'Id correlativo unico para cada rol',
  `nombre` varchar(100) NOT NULL COMMENT 'Nombre del rol',
  `descripcion` text NOT NULL COMMENT 'Descripcion del rol',
  PRIMARY KEY  (`idrol`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `rol`
--

/*!40000 ALTER TABLE `rol` DISABLE KEYS */;
INSERT INTO `rol` (`idrol`,`nombre`,`descripcion`) VALUES 
 (1,'Administrador','Administrador de JHard'),
 (2,'Administrativo','Personal Administrativo UES-FMO'),
 (3,'Docente','Docente UES-FMO'),
 (4,'Editor de Contenido','Encargado de actualizar contenido de JHard'),
 (5,'Estudiante','Estudiante UES-FMO'),
 (6,'Instructor','Instructor de materia UES-FMO');
/*!40000 ALTER TABLE `rol` ENABLE KEYS */;


--
-- Definition of table `software`
--

DROP TABLE IF EXISTS `software`;
CREATE TABLE `software` (
  `idsoftware` int(11) NOT NULL auto_increment COMMENT 'Id correlativo unico de cada software',
  `nombre` varchar(100) NOT NULL COMMENT 'Nombre del software',
  `version` varchar(15) NOT NULL COMMENT 'Version del software',
  `codigolicencia` varchar(45) default NULL COMMENT 'codigo de la licencia del software (en caso de poseer alguno)',
  `cantidadlicencias` int(11) default NULL COMMENT 'Cantidad de licencias disponibles para instalar (en caso de poseer licencias)',
  `idclasificacion` int(11) NOT NULL COMMENT 'Referencia a la clasificacion que posee este software',
  PRIMARY KEY  (`idsoftware`),
  KEY `fkidclasificacion_software` (`idclasificacion`),
  CONSTRAINT `fkidclasificacion_software` FOREIGN KEY (`idclasificacion`) REFERENCES `clasificacion` (`idclasificacion`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `software`
--

/*!40000 ALTER TABLE `software` DISABLE KEYS */;
INSERT INTO `software` (`idsoftware`,`nombre`,`version`,`codigolicencia`,`cantidadlicencias`,`idclasificacion`) VALUES 
 (1,'Microsoft Windows XP','Service Pack 2','JGOL-JGFL-KGJK.KJGF-O3JW-OLB3',20,9);
/*!40000 ALTER TABLE `software` ENABLE KEYS */;


--
-- Definition of table `solicitud`
--

DROP TABLE IF EXISTS `solicitud`;
CREATE TABLE `solicitud` (
  `idsolicitud` int(11) NOT NULL auto_increment COMMENT 'Id correlativo unico de cada solicitud',
  `fecha` date NOT NULL COMMENT 'Fecha en la que se registro la solicitud',
  `prioridad` varchar(25) NOT NULL COMMENT 'Tipo de prioridad en la cual se clasifican las solicitudes de mantenimiento. Sus posibles valores son: Alta, Media y Baja',
  `descripcion` text NOT NULL COMMENT 'Descripcion de la solicitud',
  `idusuario` int(11) NOT NULL COMMENT 'Usuario que registro la solicitud',
  `idequipoexistente` int(11) default NULL COMMENT 'Equipo al cual se desea efectuar un mantenimiento',
  `idequiposimple` int(11) default NULL,
  PRIMARY KEY  (`idsolicitud`),
  KEY `fkidequipoexistente_solicitud` (`idequipoexistente`),
  KEY `fkidequiposimple_solicitud` (`idequiposimple`),
  KEY `fkidusuario_solicitud` (`idusuario`),
  CONSTRAINT `fkidequipoexistente_solicitud` FOREIGN KEY (`idequipoexistente`) REFERENCES `existencia` (`idexistencia`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fkidequiposimple_solicitud` FOREIGN KEY (`idequiposimple`) REFERENCES `equiposimple` (`idEquipoSimple`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fkidusuario_solicitud` FOREIGN KEY (`idusuario`) REFERENCES `usuario` (`idusuario`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `solicitud`
--

/*!40000 ALTER TABLE `solicitud` DISABLE KEYS */;
INSERT INTO `solicitud` (`idsolicitud`,`fecha`,`prioridad`,`descripcion`,`idusuario`,`idequipoexistente`,`idequiposimple`) VALUES 
 (1,'2009-06-06','Alta','Virus',1,1,1),
 (2,'2009-06-17','Media','Virus',1,NULL,1),
 (3,'2009-06-17','Media','VIRUS MIERDA',10,NULL,1),
 (4,'2009-06-17','Media','a veeeeer!',5,NULL,4),
 (5,'3909-06-17','Media','Esta compu la jode la maitra de derechoo',5,NULL,1),
 (6,'3909-06-17','Media','compu mas basuraaa',5,NULL,7),
 (7,'2009-06-19','Baja','Virus',5,NULL,4),
 (8,'3909-06-23','Media','No sirve el monitor',5,NULL,13),
 (9,'3909-06-26','Media','Caduco el antivirus tiene NOD 32',5,NULL,12),
 (10,'3909-06-26','Media','No abre el Office 2003 y necesitamos el Office 2007',5,NULL,11),
 (11,'3909-06-26','Media','Se frego el NERO',9,NULL,10),
 (12,'3909-06-26','Media','No sirve el Chat',10,NULL,2),
 (13,'3909-06-26','Media','q jodo vaaaaaaaa',10,NULL,3),
 (14,'3909-06-28','Media','jajajaja',9,NULL,8),
 (15,'2009-06-29','Media','Brasil campeon de la confederaciones',9,NULL,12),
 (16,'2009-06-29','Media','JODIO EL UBUNTU',9,NULL,14);
/*!40000 ALTER TABLE `solicitud` ENABLE KEYS */;


--
-- Definition of table `tag`
--

DROP TABLE IF EXISTS `tag`;
CREATE TABLE `tag` (
  `idtag` int(11) NOT NULL,
  `descripcion` varchar(25) NOT NULL,
  PRIMARY KEY  (`idtag`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tag`
--

/*!40000 ALTER TABLE `tag` DISABLE KEYS */;
INSERT INTO `tag` (`idtag`,`descripcion`) VALUES 
 (1,'portada'),
 (2,'wiki'),
 (3,'hardware'),
 (4,'software'),
 (5,'red'),
 (6,'ip'),
 (7,'linux'),
 (8,'impresora'),
 (9,'latin'),
 (10,'lorem');
/*!40000 ALTER TABLE `tag` ENABLE KEYS */;


--
-- Definition of table `tag_entrada`
--

DROP TABLE IF EXISTS `tag_entrada`;
CREATE TABLE `tag_entrada` (
  `idtagentrada` int(11) NOT NULL,
  `idtag` int(11) NOT NULL,
  `identrada` int(11) NOT NULL,
  PRIMARY KEY  (`idtagentrada`,`identrada`,`idtag`),
  KEY `fk_tag_entrada_tag` (`idtag`),
  KEY `fk_tag_entrada_entrada` (`identrada`),
  CONSTRAINT `fk_tag_entrada_entrada` FOREIGN KEY (`identrada`) REFERENCES `entrada` (`identrada`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_tag_entrada_tag` FOREIGN KEY (`idtag`) REFERENCES `tag` (`idtag`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tag_entrada`
--

/*!40000 ALTER TABLE `tag_entrada` DISABLE KEYS */;
INSERT INTO `tag_entrada` (`idtagentrada`,`idtag`,`identrada`) VALUES 
 (1,1,1),
 (2,2,2),
 (3,9,3),
 (4,10,1),
 (5,10,2),
 (6,10,3),
 (7,10,4);
/*!40000 ALTER TABLE `tag_entrada` ENABLE KEYS */;


--
-- Definition of table `tecnico`
--

DROP TABLE IF EXISTS `tecnico`;
CREATE TABLE `tecnico` (
  `idtecnico` int(11) NOT NULL auto_increment COMMENT 'Id correlativo unico para cada tecnico',
  `apellidos` varchar(200) NOT NULL COMMENT 'Apellidos del tecnico',
  `nombres` varchar(200) NOT NULL COMMENT 'Nombres del tecnico',
  `cargo` varchar(200) NOT NULL COMMENT 'Cargo que desempenia el tecnico',
  PRIMARY KEY  (`idtecnico`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tecnico`
--

/*!40000 ALTER TABLE `tecnico` DISABLE KEYS */;
INSERT INTO `tecnico` (`idtecnico`,`apellidos`,`nombres`,`cargo`) VALUES 
 (3,'Aguirre','Gabriel','Tecnico'),
 (4,'Mineros','Roberto','Tecnico'),
 (14,'Villatoro','Ana Graciela','Tecnico'),
 (16,'Martinez','Diego','Tecnico');
/*!40000 ALTER TABLE `tecnico` ENABLE KEYS */;


--
-- Definition of table `ubicacion`
--

DROP TABLE IF EXISTS `ubicacion`;
CREATE TABLE `ubicacion` (
  `idubicacion` int(11) NOT NULL auto_increment COMMENT 'Id correlativo unico de cada ubicacion',
  `nombre` varchar(45) default NULL COMMENT 'Nombre de la ubicacion',
  PRIMARY KEY  (`idubicacion`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `ubicacion`
--

/*!40000 ALTER TABLE `ubicacion` DISABLE KEYS */;
INSERT INTO `ubicacion` (`idubicacion`,`nombre`) VALUES 
 (1,'LABCOM-1');
/*!40000 ALTER TABLE `ubicacion` ENABLE KEYS */;


--
-- Definition of table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
CREATE TABLE `usuario` (
  `idusuario` int(11) NOT NULL auto_increment COMMENT 'Id correlativo unico para cada usuario',
  `nombre` varchar(25) NOT NULL COMMENT 'Nombre del usuario',
  `clave` varchar(35) NOT NULL COMMENT 'Clave de acceso del usuario',
  `idrol` int(11) default NULL COMMENT 'Referencia al rol que juega este usuario dentro del sistema, el cual define los modulos y acciones a las que tiene acceso',
  `idautorizacion` int(10) unsigned default NULL,
  PRIMARY KEY  (`idusuario`),
  KEY `fkidrol_usuario` (`idrol`),
  KEY `fkidautorizacion_usuario` (`idautorizacion`),
  CONSTRAINT `fkidautorizacion_usuario` FOREIGN KEY (`idautorizacion`) REFERENCES `autorizacion` (`idautorizacion`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fkidrol_usuario` FOREIGN KEY (`idrol`) REFERENCES `rol` (`idrol`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `usuario`
--

/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` (`idusuario`,`nombre`,`clave`,`idrol`,`idautorizacion`) VALUES 
 (1,'LuisBarrera','21232F297A57A5A743894A0E4A801FC3',1,NULL),
 (2,'Madrid','21232F297A57A5A743894A0E4A801FC3',1,NULL),
 (3,'Claudia','9003D1DF22EB4D3820015070385194C8',2,NULL),
 (4,'Stanley','9003D1DF22EB4D3820015070385194C8',3,NULL),
 (5,'Carmencita','9003D1DF22EB4D3820015070385194C8',2,NULL),
 (6,'Gabriel','9003D1DF22EB4D3820015070385194C8',4,NULL),
 (7,'Rebekita','9003D1DF22EB4D3820015070385194C8',5,NULL),
 (8,'fredy','9003D1DF22EB4D3820015070385194C8',6,NULL),
 (9,'hugol','CD82BE786DA71D1DD4EA68C0908AF6E6',1,NULL),
 (10,'Karlita','9003D1DF22EB4D3820015070385194C8',2,NULL),
 (11,'rosario','9003D1DF22EB4D3820015070385194C8',3,NULL),
 (12,'robertux','3858F62230AC3C915F300C664312C63F',1,NULL);
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;


--
-- Definition of table `valoracion`
--

DROP TABLE IF EXISTS `valoracion`;
CREATE TABLE `valoracion` (
  `fk_userid` int(11) NOT NULL,
  `fk_identrada` int(11) NOT NULL,
  KEY `entrada` USING BTREE (`fk_userid`,`fk_identrada`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `valoracion`
--

/*!40000 ALTER TABLE `valoracion` DISABLE KEYS */;
/*!40000 ALTER TABLE `valoracion` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
