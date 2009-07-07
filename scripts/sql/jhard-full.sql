-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.1.31-1ubuntu2


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
-- Definition of table `jhard`.`accesorio`
--

DROP TABLE IF EXISTS `jhard`.`accesorio`;
CREATE TABLE  `jhard`.`accesorio` (
  `idaccesorio` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Id correlativo unico de cada accesorio',
  `nombre` varchar(100) NOT NULL COMMENT 'Nombre del accesorio',
  `idmarca` int(11) NOT NULL COMMENT 'Referencia a la marca del accesorio',
  `modelo` varchar(15) NOT NULL COMMENT 'Modelo del accesorio',
  `idclasificacion` int(11) NOT NULL COMMENT 'Referencia a la clasificacion en la que se encuentra este accesorio',
  `idequipo` int(11) DEFAULT NULL COMMENT 'Referencia al equipo al que se encuentra conectado este accesorio, en caso de estar conectado a uno',
  PRIMARY KEY (`idaccesorio`),
  KEY `fkidmarca_accesorio` (`idmarca`),
  KEY `fkidclasificacion_accesorio` (`idclasificacion`),
  KEY `fkidequipo_accesorio` (`idequipo`),
  CONSTRAINT `fkidclasificacion_accesorio` FOREIGN KEY (`idclasificacion`) REFERENCES `clasificacion` (`idclasificacion`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fkidequipo_accesorio` FOREIGN KEY (`idequipo`) REFERENCES `equipo` (`idequipo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fkidmarca_accesorio` FOREIGN KEY (`idmarca`) REFERENCES `marca` (`idmarca`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `jhard`.`accesorio`
--

/*!40000 ALTER TABLE `accesorio` DISABLE KEYS */;
LOCK TABLES `accesorio` WRITE;
UNLOCK TABLES;
/*!40000 ALTER TABLE `accesorio` ENABLE KEYS */;


--
-- Definition of table `jhard`.`administrador`
--

DROP TABLE IF EXISTS `jhard`.`administrador`;
CREATE TABLE  `jhard`.`administrador` (
  `idadministrador` int(11) NOT NULL COMMENT 'Id correlativo unico de cada administrador',
  `clave` varchar(45) NOT NULL COMMENT 'Clave del administrador',
  `idusuario` int(11) NOT NULL COMMENT 'referencia al usuario relacionado con este admnistrador',
  PRIMARY KEY (`idadministrador`),
  KEY `fkidusuario_administrador` (`idusuario`),
  CONSTRAINT `fkidusuario_administrador` FOREIGN KEY (`idusuario`) REFERENCES `usuario` (`idusuario`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `jhard`.`administrador`
--

/*!40000 ALTER TABLE `administrador` DISABLE KEYS */;
LOCK TABLES `administrador` WRITE;
INSERT INTO `jhard`.`administrador` VALUES  (1,'21232F297A57A5A743894A0E4A801FC3',1),
 (2,'21232F297A57A5A743894A0E4A801FC3',2),
 (3,'CD82BE786DA71D1DD4EA68C0908AF6E6',9);
UNLOCK TABLES;
/*!40000 ALTER TABLE `administrador` ENABLE KEYS */;


--
-- Definition of table `jhard`.`adquisicion`
--

DROP TABLE IF EXISTS `jhard`.`adquisicion`;
CREATE TABLE  `jhard`.`adquisicion` (
  `idadquisicion` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Id correlativo unico de la adquisicion',
  `fecha` date NOT NULL COMMENT 'Fecha en la que se adquirio el equipo o software',
  `precio` double NOT NULL COMMENT 'Precio de compra del equipo o software (dejar a cero si fue una donacion)',
  `descripcion` text COMMENT 'Detalles de la adquisicion',
  `proveedor` varchar(100) DEFAULT NULL COMMENT 'Nombre del proveedor o tienda donde se compro el equipo o software (en caso de haber sido comprado)',
  PRIMARY KEY (`idadquisicion`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `jhard`.`adquisicion`
--

/*!40000 ALTER TABLE `adquisicion` DISABLE KEYS */;
LOCK TABLES `adquisicion` WRITE;
INSERT INTO `jhard`.`adquisicion` VALUES  (1,'2002-01-09',200,'Computadora Clon','Medicomp'),
 (2,'2009-03-04',400,'Dell Vostro','Dell'),
 (3,'2002-01-03',50,'Licencia Microsoft Windows','Microsoft');
UNLOCK TABLES;
/*!40000 ALTER TABLE `adquisicion` ENABLE KEYS */;


--
-- Definition of table `jhard`.`asistencia`
--

DROP TABLE IF EXISTS `jhard`.`asistencia`;
CREATE TABLE  `jhard`.`asistencia` (
  `idasistencia` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Id correlativo unico para cada asistencia',
  `idestudiante` int(11) NOT NULL COMMENT 'Referencia al estudiante que asistio al curso',
  `idclase` int(11) NOT NULL COMMENT 'Referencia a la clase a la cual pertenece esta asistencia',
  `idequipoexistente` int(11) NOT NULL COMMENT 'Referencia al equipo de hardware que se utilizo en dicha asistencia a la clase',
  PRIMARY KEY (`idasistencia`),
  KEY `fkidestudiante_asistencia` (`idestudiante`),
  KEY `fkidclase_asistencia` (`idclase`),
  KEY `fkidequipoexistente_asistencia` (`idequipoexistente`),
  CONSTRAINT `fkidclase_asistencia` FOREIGN KEY (`idclase`) REFERENCES `clase` (`idclase`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fkidequipoexistente_asistencia` FOREIGN KEY (`idequipoexistente`) REFERENCES `existencia` (`idexistencia`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fkidestudiante_asistencia` FOREIGN KEY (`idestudiante`) REFERENCES `estudiante` (`idestudiante`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `jhard`.`asistencia`
--

/*!40000 ALTER TABLE `asistencia` DISABLE KEYS */;
LOCK TABLES `asistencia` WRITE;
UNLOCK TABLES;
/*!40000 ALTER TABLE `asistencia` ENABLE KEYS */;


--
-- Definition of table `jhard`.`atributohardware`
--

DROP TABLE IF EXISTS `jhard`.`atributohardware`;
CREATE TABLE  `jhard`.`atributohardware` (
  `idatributohardware` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Id correlativo unico del atributo de hardware',
  `nombre` varchar(45) NOT NULL COMMENT 'Nombre del atributo',
  `valor` varchar(45) NOT NULL COMMENT 'Valor del atributo',
  `unidadmedida` varchar(45) NOT NULL COMMENT 'Unidad de medida del atributo',
  `idhardware` int(11) DEFAULT NULL COMMENT 'Referencia al elemento de hardware (equipo, pieza o accesorio) al que pertenece el atributo',
  `idpieza` int(11) DEFAULT NULL,
  `idaccesorio` int(11) DEFAULT NULL,
  PRIMARY KEY (`idatributohardware`),
  KEY `fkidequipo_atributohardware` (`idhardware`),
  KEY `fkidpieza_atributohardware` (`idpieza`),
  KEY `fkidaccesorio_atributohardware` (`idaccesorio`),
  CONSTRAINT `fkidaccesorio_atributohardware` FOREIGN KEY (`idaccesorio`) REFERENCES `accesorio` (`idaccesorio`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fkidequipo_atributohardware` FOREIGN KEY (`idhardware`) REFERENCES `equipo` (`idequipo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fkidpieza_atributohardware` FOREIGN KEY (`idpieza`) REFERENCES `pieza` (`idpieza`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `jhard`.`atributohardware`
--

/*!40000 ALTER TABLE `atributohardware` DISABLE KEYS */;
LOCK TABLES `atributohardware` WRITE;
UNLOCK TABLES;
/*!40000 ALTER TABLE `atributohardware` ENABLE KEYS */;


--
-- Definition of table `jhard`.`bitacoracambiosusuario`
--

DROP TABLE IF EXISTS `jhard`.`bitacoracambiosusuario`;
CREATE TABLE  `jhard`.`bitacoracambiosusuario` (
  `idbitacora` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Id correlativo unico de cada bitacora',
  `idusuario` int(11) NOT NULL COMMENT 'Referencia al usuario que realizo el cambio',
  `descripcion` text NOT NULL COMMENT 'Descripcion del cambio que realizo el usuario',
  `fechahora` datetime NOT NULL COMMENT 'Fecha y hora a la que el usuario realizo el cambio',
  PRIMARY KEY (`idbitacora`),
  KEY `fkidusuario_bitacoracambiosusuario` (`idusuario`),
  CONSTRAINT `fkidusuario_bitacoracambiosusuario` FOREIGN KEY (`idusuario`) REFERENCES `usuario` (`idusuario`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `jhard`.`bitacoracambiosusuario`
--

/*!40000 ALTER TABLE `bitacoracambiosusuario` DISABLE KEYS */;
LOCK TABLES `bitacoracambiosusuario` WRITE;
UNLOCK TABLES;
/*!40000 ALTER TABLE `bitacoracambiosusuario` ENABLE KEYS */;


--
-- Definition of table `jhard`.`bitacoraestados`
--

DROP TABLE IF EXISTS `jhard`.`bitacoraestados`;
CREATE TABLE  `jhard`.`bitacoraestados` (
  `idbitacora` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Id correlativo unico de cada bitacora',
  `fecha` date NOT NULL COMMENT 'Fecha en la que ocurrio el cambio de estado',
  `idestado` int(11) NOT NULL COMMENT 'Referencia al estado al cual cambio el equipo',
  `descripcion` text NOT NULL COMMENT 'Descripcion del cambio realizado',
  `idequipoexistente` int(11) DEFAULT NULL COMMENT 'Referencia al equipo que sufrio el cambio de estado',
  `idequiposimple` int(11) DEFAULT NULL,
  PRIMARY KEY (`idbitacora`),
  KEY `fkidestado_bitacoraestados` (`idestado`),
  KEY `fkidequipoexistente_bitacoraestados` (`idequipoexistente`),
  KEY `fkidequiposimple_bitacoraestados` (`idequiposimple`),
  CONSTRAINT `fkidequipoexistente_bitacoraestados` FOREIGN KEY (`idequipoexistente`) REFERENCES `existencia` (`idexistencia`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fkidequiposimple_bitacoraestados` FOREIGN KEY (`idequiposimple`) REFERENCES `equiposimple` (`idEquipoSimple`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fkidestado_bitacoraestados` FOREIGN KEY (`idestado`) REFERENCES `estadoequipo` (`idestado`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `jhard`.`bitacoraestados`
--

/*!40000 ALTER TABLE `bitacoraestados` DISABLE KEYS */;
LOCK TABLES `bitacoraestados` WRITE;
INSERT INTO `jhard`.`bitacoraestados` VALUES  (1,'2009-06-22',2,'Virus',NULL,4),
 (2,'2009-06-22',2,'Virus',NULL,4),
 (3,'2009-06-23',2,'No sirve el monitor porque lo jodi si lo jodi',NULL,13),
 (4,'2009-06-24',2,'aja si como no',NULL,13);
UNLOCK TABLES;
/*!40000 ALTER TABLE `bitacoraestados` ENABLE KEYS */;


--
-- Definition of table `jhard`.`carrera`
--

DROP TABLE IF EXISTS `jhard`.`carrera`;
CREATE TABLE  `jhard`.`carrera` (
  `idcarrera` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Id correlativo unico de cada carrera',
  `codigo` varchar(7) NOT NULL COMMENT 'Codigo de la carrera, distintivo en el sistema adacad',
  `nombre` varchar(200) NOT NULL COMMENT 'Nombre de la carrera',
  `idfacultad` int(11) NOT NULL COMMENT 'Referencia a la facultad a la cual pertenece esta carrera',
  PRIMARY KEY (`idcarrera`),
  KEY `fkidfacultad_carrera` (`idfacultad`),
  CONSTRAINT `fkidfacultad_carrera` FOREIGN KEY (`idfacultad`) REFERENCES `facultad` (`idfacultad`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `jhard`.`carrera`
--

/*!40000 ALTER TABLE `carrera` DISABLE KEYS */;
LOCK TABLES `carrera` WRITE;
INSERT INTO `jhard`.`carrera` VALUES  (1,'I30515','Ingeniería de Sistemas Informáticos',1);
UNLOCK TABLES;
/*!40000 ALTER TABLE `carrera` ENABLE KEYS */;


--
-- Definition of table `jhard`.`clase`
--

DROP TABLE IF EXISTS `jhard`.`clase`;
CREATE TABLE  `jhard`.`clase` (
  `idclase` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Id correlativo unico para cada clase',
  `fecha` date NOT NULL COMMENT 'Fecha en la que se llevo a cabo esta clase',
  `idhorario` int(11) NOT NULL COMMENT 'Referencia al horario en el que se recibio esta clase',
  `idinstructor` int(11) DEFAULT NULL COMMENT 'Referencia al instructor encargado de dar esta clase (en caso que haya sido un instructor)',
  `tema` varchar(45) NOT NULL COMMENT 'Tema visto en esta clase',
  `observaciones` text COMMENT 'Observaciones obtenidas segun el resultado general de la clase',
  `iddocente` int(11) DEFAULT NULL COMMENT 'Referencia al docente encargado de dar esta clase (en caso que haya sido un docente)',
  PRIMARY KEY (`idclase`),
  KEY `fkidhorario_clase` (`idhorario`),
  KEY `fkidinstructor_clase` (`idinstructor`),
  KEY `fkiddocente_clase` (`iddocente`),
  CONSTRAINT `fkiddocente_clase` FOREIGN KEY (`iddocente`) REFERENCES `docente` (`iddocente`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fkidhorario_clase` FOREIGN KEY (`idhorario`) REFERENCES `horario` (`idhorario`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fkidinstructor_clase` FOREIGN KEY (`idinstructor`) REFERENCES `instructor` (`idinstructor`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `jhard`.`clase`
--

/*!40000 ALTER TABLE `clase` DISABLE KEYS */;
LOCK TABLES `clase` WRITE;
INSERT INTO `jhard`.`clase` VALUES  (1,'2009-03-05',1,2,'Herencia en Java','N/A',1);
UNLOCK TABLES;
/*!40000 ALTER TABLE `clase` ENABLE KEYS */;


--
-- Definition of table `jhard`.`clasificacion`
--

DROP TABLE IF EXISTS `jhard`.`clasificacion`;
CREATE TABLE  `jhard`.`clasificacion` (
  `idclasificacion` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Id correlativo unico de cada clasificacion',
  `nombre` varchar(100) NOT NULL COMMENT 'Nombre de la clasificacion',
  `descripcion` text COMMENT 'Descripcion de la clasificacion',
  `idsuperior` int(11) DEFAULT NULL COMMENT 'Referencia a la clasificacion padre. Si este campo es nulo, indica que esta es una clasificacion raiz',
  PRIMARY KEY (`idclasificacion`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `jhard`.`clasificacion`
--

/*!40000 ALTER TABLE `clasificacion` DISABLE KEYS */;
LOCK TABLES `clasificacion` WRITE;
INSERT INTO `clasificacion` VALUES (0,'General','Nodo raiz de las clasificaciones',NULL),(1,'Hardware','Hardware',0),(2,'Software','Software',0),(3,'Equipos','Equipos',1),(4,'Perifericos','Perifericos',1),(5,'Accesorios','Accesorios',1),(6,'Desktops','Desktops',3),(7,'Laptops','Laptops',3),(8,'Sistemas Operativos','Sistemas Operativos',2),(9,'Utilerias','Utilerias',2),(10,'Piezas','Piezas',1);
UNLOCK TABLES;
/*!40000 ALTER TABLE `clasificacion` ENABLE KEYS */;


--
-- Definition of table `jhard`.`comentarios`
--

DROP TABLE IF EXISTS `jhard`.`comentarios`;
CREATE TABLE  `jhard`.`comentarios` (
  `idcoment` int(11) NOT NULL,
  `comentario` varchar(250) NOT NULL,
  `fechahorara` datetime NOT NULL,
  `identrada` int(11) NOT NULL,
  PRIMARY KEY (`idcoment`),
  KEY `fk_comentarios_entrada` (`identrada`),
  CONSTRAINT `fk_comentarios_entrada` FOREIGN KEY (`identrada`) REFERENCES `entrada` (`identrada`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `jhard`.`comentarios`
--

/*!40000 ALTER TABLE `comentarios` DISABLE KEYS */;
LOCK TABLES `comentarios` WRITE;
INSERT INTO `jhard`.`comentarios` VALUES  (1,'Excelente, Lorem ipsum rulez!','2009-05-05 00:00:00',1),
 (2,'Lorem not dolores ipsum buu est','2009-01-01 00:00:00',2),
 (3,'Prueba Comentario Portada','2009-06-30 00:00:00',5),
 (4,'Comentario nuevo entrada 1','2009-07-01 00:00:00',1);
UNLOCK TABLES;
/*!40000 ALTER TABLE `comentarios` ENABLE KEYS */;


--
-- Definition of table `jhard`.`curso`
--

DROP TABLE IF EXISTS `jhard`.`curso`;
CREATE TABLE  `jhard`.`curso` (
  `idcurso` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Id correlativo unico de cada curso',
  `nombre` varchar(200) NOT NULL COMMENT 'Nombre del curso (por si este difiere del nombre de la materia o por si no esta relacionado con una materia especifica)',
  `cupomax` int(11) NOT NULL COMMENT 'Cantidad maxima de alumnos que pueden inscribirse a este curso',
  `idmateria` int(11) DEFAULT NULL COMMENT 'Referencia a la materia relacionada con este curso (en caso que este relacionado con alguna)',
  `idinstructor` int(11) NOT NULL COMMENT 'Referencia al instructor asignado a impartir este curso',
  `fechainicio` date NOT NULL COMMENT 'Fecha de inicio del curso',
  `ciclo` int(11) DEFAULT NULL COMMENT 'Ciclo en el que se imparte este curso (1=ciclo impar, 2=ciclo par)',
  `anio` int(11) DEFAULT NULL COMMENT 'anio en el que se imparte este curso',
  `iddocente` int(11) NOT NULL COMMENT 'Referencia al docente encargado de impartir este curso',
  `idestado` int(11) DEFAULT NULL,
  PRIMARY KEY (`idcurso`),
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
-- Dumping data for table `jhard`.`curso`
--

/*!40000 ALTER TABLE `curso` DISABLE KEYS */;
LOCK TABLES `curso` WRITE;
INSERT INTO `jhard`.`curso` VALUES  (1,'Grupo 1 ',20,2,2,'2009-03-03',1,2009,1,NULL);
UNLOCK TABLES;
/*!40000 ALTER TABLE `curso` ENABLE KEYS */;


--
-- Definition of table `jhard`.`docente`
--

DROP TABLE IF EXISTS `jhard`.`docente`;
CREATE TABLE  `jhard`.`docente` (
  `iddocente` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Id correlativo unico para cada docente',
  `Apellidos` varchar(200) NOT NULL COMMENT 'Apellidos del docente',
  `Nombres` varchar(200) NOT NULL COMMENT 'Nombres del docente',
  `idusuario` int(11) NOT NULL COMMENT 'Referencia al usuario con el que el docente ingresa al sistema',
  `visible` int(11) NOT NULL COMMENT 'Es 1 por defecto. Indica que el usuario esta activo. Al momento de borrar usuarios del sistema, nada mas cambiar este estado a 0.',
  PRIMARY KEY (`iddocente`),
  KEY `fkidusuario_docente` (`idusuario`),
  CONSTRAINT `fkidusuario_docente` FOREIGN KEY (`idusuario`) REFERENCES `usuario` (`idusuario`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `jhard`.`docente`
--

/*!40000 ALTER TABLE `docente` DISABLE KEYS */;
LOCK TABLES `docente` WRITE;
INSERT INTO `jhard`.`docente` VALUES  (1,'Linares Paula','Carlos Stanley',4,1);
UNLOCK TABLES;
/*!40000 ALTER TABLE `docente` ENABLE KEYS */;


--
-- Definition of table `jhard`.`entrada`
--

DROP TABLE IF EXISTS `jhard`.`entrada`;
CREATE TABLE  `jhard`.`entrada` (
  `identrada` int(11) NOT NULL,
  `titulo` varchar(50) NOT NULL,
  `descripcion` text NOT NULL,
  `fechahora` datetime NOT NULL,
  `idusuario` int(11) NOT NULL,
  PRIMARY KEY (`identrada`),
  KEY `fk_entrada_usuario` (`idusuario`),
  CONSTRAINT `fk_entrada_usuario` FOREIGN KEY (`idusuario`) REFERENCES `usuario` (`idusuario`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `jhard`.`entrada`
--

/*!40000 ALTER TABLE `entrada` DISABLE KEYS */;
LOCK TABLES `entrada` WRITE;
INSERT INTO `jhard`.`entrada` VALUES  (1,'Titulo 1','Lorem ipsum dolor sit amet, \\nconsectetur adipiscing elit. \\nSed cursus dictum cursus. \\nCras nibh augue, pharetra tempor hendrerit at,\\nconvallis id nunc. Maecenas felis lorem,\\nfeugiat nec mollis id, rhoncus pharetra enim.\\nSed quis libero porttitor odio accumsan imperdiet ac iaculis nisl. Maecenas diam orci, porta sit amet ornare a, cursus sit amet massa. Cras a posuere eros. Donec sodales luctus purus. Etiam nibh ante, mollis ac condimentum in, convallis egestas nisi. Integer imperdiet lectus eget velit aliquet rutrum. \\nProin ligula tellus, viverra vitae tincidunt ut, venenatis nec justo. In ut nisl urna. Aliquam erat volutpat. Nam quis sem ut magna fermentum tempus vitae at eros. Vivamus fermentum sem eget nunc viverra vitae consequat diam tempus.','2009-05-01 00:00:00',1),
 (2,'Titulo 2','Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed cursus dictum cursus. Cras nibh augue, pharetra tempor hendrerit at, convallis id nunc. Maecenas felis lorem, feugiat nec mollis id, rhoncus pharetra enim. Sed quis libero porttitor odio accumsan imperdiet ac iaculis nisl. Maecenas diam orci, porta sit amet ornare a, cursus sit amet massa. Cras a posuere eros. Donec sodales luctus purus. Etiam nibh ante, mollis ac condimentum in, convallis egestas nisi. Integer imperdiet lectus eget velit aliquet rutrum. Proin ligula tellus, viverra vitae tincidunt ut, venenatis nec justo. In ut nisl urna. Aliquam erat volutpat. Nam quis sem ut magna fermentum tempus vitae at eros. Vivamus fermentum sem eget nunc viverra vitae consequat diam tempus.','2009-05-30 00:00:00',1),
 (3,'Titulo 3','Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed cursus dictum cursus. Cras nibh augue, pharetra tempor hendrerit at, convallis id nunc. Maecenas felis lorem, feugiat nec mollis id, rhoncus pharetra enim. Sed quis libero porttitor odio accumsan imperdiet ac iaculis nisl. Maecenas diam orci, porta sit amet ornare a, cursus sit amet massa. Cras a posuere eros. Donec sodales luctus purus. Etiam nibh ante, mollis ac condimentum in, convallis egestas nisi. Integer imperdiet lectus eget velit aliquet rutrum. Proin ligula tellus, viverra vitae tincidunt ut, venenatis nec justo. In ut nisl urna. Aliquam erat volutpat. Nam quis sem ut magna fermentum tempus vitae at eros. Vivamus fermentum sem eget nunc viverra vitae consequat diam tempus.','2009-05-30 00:00:00',1);
INSERT INTO `jhard`.`entrada` VALUES  (4,'Titulo 4','Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed cursus dictum cursus. Cras nibh augue, pharetra tempor hendrerit at, convallis id nunc. Maecenas felis lorem, feugiat nec mollis id, rhoncus pharetra enim. Sed quis libero porttitor odio accumsan imperdiet ac iaculis nisl. Maecenas diam orci, porta sit amet ornare a, cursus sit amet massa. Cras a posuere eros. Donec sodales luctus purus. Etiam nibh ante, mollis ac condimentum in, convallis egestas nisi. Integer imperdiet lectus eget velit aliquet rutrum. Proin ligula tellus, viverra vitae tincidunt ut, venenatis nec justo. In ut nisl urna. Aliquam erat volutpat. Nam quis sem ut magna fermentum tempus vitae at eros. Vivamus fermentum sem eget nunc viverra vitae consequat diam tempus.','2009-06-30 00:00:00',9),
 (5,'Portada','Lorem ipsum dolor sit amet, consecteru adipiscin elit.\nPrueba Portada\nLorem ipsum dolor sit amet, consecteru adipiscin elit.','2009-07-01 00:00:00',1);
UNLOCK TABLES;
/*!40000 ALTER TABLE `entrada` ENABLE KEYS */;


--
-- Definition of table `jhard`.`equipo`
--

DROP TABLE IF EXISTS `jhard`.`equipo`;
CREATE TABLE  `jhard`.`equipo` (
  `idequipo` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Id correlativo unico de cada equipo',
  `idmarca` int(11) NOT NULL COMMENT 'Referencia a la marca que posee este equipo',
  `nombre` varchar(45) NOT NULL COMMENT 'Nombre del equipo',
  `modelo` varchar(15) NOT NULL COMMENT 'Modelo al cual pertenece el equipo',
  `idclasificacion` int(11) NOT NULL COMMENT 'Referencia a la clasificacion a la cual esta relacionado este equipo',
  PRIMARY KEY (`idequipo`),
  KEY `fkidmarca_equipo` (`idmarca`),
  KEY `fkidclasificacion_equipo` (`idclasificacion`),
  CONSTRAINT `fkidclasificacion_equipo` FOREIGN KEY (`idclasificacion`) REFERENCES `clasificacion` (`idclasificacion`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fkidmarca_equipo` FOREIGN KEY (`idmarca`) REFERENCES `marca` (`idmarca`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `jhard`.`equipo`
--

/*!40000 ALTER TABLE `equipo` DISABLE KEYS */;
LOCK TABLES `equipo` WRITE;
INSERT INTO `jhard`.`equipo` VALUES  (1,9,'PC','PC',1),
 (2,1,'DellPC','Vostro',1);
UNLOCK TABLES;
/*!40000 ALTER TABLE `equipo` ENABLE KEYS */;


--
-- Definition of table `jhard`.`equiposimple`
--

DROP TABLE IF EXISTS `jhard`.`equiposimple`;
CREATE TABLE  `jhard`.`equiposimple` (
  `idEquipoSimple` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Id correlativo unico de cada equipo simple',
  `descripcion` text NOT NULL COMMENT 'Descripcion del equipo simple',
  `propietario` varchar(200) NOT NULL COMMENT 'Nombre del propietario del equipo simple',
  `idestado` int(11) NOT NULL COMMENT 'Referencia al estado en el que se encuentra el equipo simple',
  PRIMARY KEY (`idEquipoSimple`),
  KEY `fkidestado_equiposimple` (`idestado`),
  CONSTRAINT `fkidestado_equiposimple` FOREIGN KEY (`idestado`) REFERENCES `estadoequipo` (`idestado`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `jhard`.`equiposimple`
--

/*!40000 ALTER TABLE `equiposimple` DISABLE KEYS */;
LOCK TABLES `equiposimple` WRITE;
INSERT INTO `jhard`.`equiposimple` VALUES  (1,'Computadora Oficina Jurídica','Carmencita',1),
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
UNLOCK TABLES;
/*!40000 ALTER TABLE `equiposimple` ENABLE KEYS */;


--
-- Definition of table `jhard`.`estadocurso`
--

DROP TABLE IF EXISTS `jhard`.`estadocurso`;
CREATE TABLE  `jhard`.`estadocurso` (
  `idestadocurso` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Id correlativo unico para cada estado del curso',
  `nombre` varchar(100) NOT NULL COMMENT 'Nombre del estado del curso',
  PRIMARY KEY (`idestadocurso`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `jhard`.`estadocurso`
--

/*!40000 ALTER TABLE `estadocurso` DISABLE KEYS */;
LOCK TABLES `estadocurso` WRITE;
UNLOCK TABLES;
/*!40000 ALTER TABLE `estadocurso` ENABLE KEYS */;


--
-- Definition of table `jhard`.`estadoequipo`
--

DROP TABLE IF EXISTS `jhard`.`estadoequipo`;
CREATE TABLE  `jhard`.`estadoequipo` (
  `idestado` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Id correlativo unico de cada estado',
  `nombre` varchar(45) NOT NULL COMMENT 'Nombre del estado',
  `descripcion` text COMMENT 'Descripcion del estado',
  PRIMARY KEY (`idestado`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `jhard`.`estadoequipo`
--

/*!40000 ALTER TABLE `estadoequipo` DISABLE KEYS */;
LOCK TABLES `estadoequipo` WRITE;
INSERT INTO `jhard`.`estadoequipo` VALUES  (1,'Excelente','Óptimas condiciones'),
 (2,'Muy Bueno','Condiciones aceptables'),
 (3,'Bueno','Condiciones estables'),
 (4,'Malo','Falla por ciertos períodos de tiempo'),
 (5,'Muy Malo','Falla casi siempre'),
 (6,'Pésimo','Imposible de utilizar');
UNLOCK TABLES;
/*!40000 ALTER TABLE `estadoequipo` ENABLE KEYS */;


--
-- Definition of table `jhard`.`estadoreserva`
--

DROP TABLE IF EXISTS `jhard`.`estadoreserva`;
CREATE TABLE  `jhard`.`estadoreserva` (
  `idestadoreserva` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Id correlativo unico de cada reserva',
  `nombre` varchar(100) NOT NULL COMMENT 'Nombre del estado de la reserva',
  PRIMARY KEY (`idestadoreserva`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `jhard`.`estadoreserva`
--

/*!40000 ALTER TABLE `estadoreserva` DISABLE KEYS */;
LOCK TABLES `estadoreserva` WRITE;
UNLOCK TABLES;
/*!40000 ALTER TABLE `estadoreserva` ENABLE KEYS */;


--
-- Definition of table `jhard`.`estudiante`
--

DROP TABLE IF EXISTS `jhard`.`estudiante`;
CREATE TABLE  `jhard`.`estudiante` (
  `idestudiante` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Id correlativo unico para cada estudiante',
  `carnet` varchar(7) NOT NULL COMMENT 'Carnet del estudiante, representativo y distintivo en el registro de la facultad',
  `apellidos` varchar(200) NOT NULL COMMENT 'Apellidos del estudiante',
  `nombres` varchar(200) NOT NULL COMMENT 'Nombres del estudiante',
  `idusuario` int(11) NOT NULL COMMENT 'Referencia con la que el usuario ingresa al sistema',
  `visible` int(11) NOT NULL DEFAULT '1' COMMENT 'Indica el estado de este estudiante. Es 1 por defecto. Indica que el usuario esta activo. Al momento de borrar usuarios del sistema, nada mas cambiar este estado a 0.',
  PRIMARY KEY (`idestudiante`),
  KEY `fkidusuario_estudiante` (`idusuario`),
  CONSTRAINT `fkidusuario_estudiante` FOREIGN KEY (`idusuario`) REFERENCES `usuario` (`idusuario`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `jhard`.`estudiante`
--

/*!40000 ALTER TABLE `estudiante` DISABLE KEYS */;
LOCK TABLES `estudiante` WRITE;
INSERT INTO `jhard`.`estudiante` VALUES  (1,'SM08003','Salgado Martínez','Rebeca Marcela',7,1);
UNLOCK TABLES;
/*!40000 ALTER TABLE `estudiante` ENABLE KEYS */;


--
-- Definition of table `jhard`.`existencia`
--

DROP TABLE IF EXISTS `jhard`.`existencia`;
CREATE TABLE  `jhard`.`existencia` (
  `idexistencia` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Id correlativo unico para cada existencia',
  `idhardware` int(11) NOT NULL COMMENT 'Referencia al hardware al cual pertenece esta existencia',
  `idubicacion` int(11) NOT NULL COMMENT 'Referencia a la ubicacion donde se encuentra localizada esta existencia',
  `idestado` int(11) NOT NULL COMMENT 'Referencia al estado en el que se encuentra esta existencia',
  `idadquisicion` int(11) DEFAULT NULL COMMENT 'Referencia a los datos de la adquisicion (compra) de esta existencia',
  `codigo` varchar(45) NOT NULL COMMENT 'Codigo con el cual clasificar esta existencia en el inventario',
  PRIMARY KEY (`idexistencia`),
  KEY `fkidhardware_existencia` (`idhardware`),
  KEY `fkidubicacion_existencia` (`idubicacion`),
  KEY `fkidestado_existencia` (`idestado`),
  KEY `fkidadquisicion_existencia` (`idadquisicion`),
  CONSTRAINT `fkidadquisicion_existencia` FOREIGN KEY (`idadquisicion`) REFERENCES `adquisicion` (`idadquisicion`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fkidestado_existencia` FOREIGN KEY (`idestado`) REFERENCES `estadoequipo` (`idestado`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fkidhardware_existencia` FOREIGN KEY (`idhardware`) REFERENCES `equipo` (`idequipo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fkidubicacion_existencia` FOREIGN KEY (`idubicacion`) REFERENCES `ubicacion` (`idubicacion`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `jhard`.`existencia`
--

/*!40000 ALTER TABLE `existencia` DISABLE KEYS */;
LOCK TABLES `existencia` WRITE;
INSERT INTO `jhard`.`existencia` VALUES  (1,1,1,1,1,'labcom1'),
 (2,1,1,1,1,'labcom2'),
 (3,1,1,1,1,'labcom3'),
 (4,2,1,1,1,'labcom4'),
 (5,2,1,1,1,'labcom5');
UNLOCK TABLES;
/*!40000 ALTER TABLE `existencia` ENABLE KEYS */;


--
-- Definition of table `jhard`.`facultad`
--

DROP TABLE IF EXISTS `jhard`.`facultad`;
CREATE TABLE  `jhard`.`facultad` (
  `idfacultad` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Id correlativo unico de cada facultad',
  `nombre` varchar(200) NOT NULL COMMENT 'Nombre de la facultad',
  PRIMARY KEY (`idfacultad`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `jhard`.`facultad`
--

/*!40000 ALTER TABLE `facultad` DISABLE KEYS */;
LOCK TABLES `facultad` WRITE;
INSERT INTO `jhard`.`facultad` VALUES  (1,'Facultad Multidisciplinaria de Occidente');
UNLOCK TABLES;
/*!40000 ALTER TABLE `facultad` ENABLE KEYS */;


--
-- Definition of table `jhard`.`horario`
--

DROP TABLE IF EXISTS `jhard`.`horario`;
CREATE TABLE  `jhard`.`horario` (
  `idhorario` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Id correlativo unico para cada horario',
  `diasemana` int(11) NOT NULL COMMENT 'Dia de la semana que se brinda el curso (1= lunes, 7= domingo)',
  `horainicio` time NOT NULL COMMENT 'Hora a la que da inicio el curso',
  `horafin` time NOT NULL COMMENT 'Hora a la que finaliza el curso',
  `idcurso` int(11) NOT NULL COMMENT 'Referencia al curso relacionado con este horario',
  `idaula` int(11) NOT NULL COMMENT 'Aula en la que se imparte este curso en este horario',
  PRIMARY KEY (`idhorario`),
  KEY `fkidcurso_horario` (`idcurso`),
  KEY `fkidaula_horario` (`idaula`),
  CONSTRAINT `fkidaula_horario` FOREIGN KEY (`idaula`) REFERENCES `ubicacion` (`idubicacion`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fkidcurso_horario` FOREIGN KEY (`idcurso`) REFERENCES `curso` (`idcurso`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `jhard`.`horario`
--

/*!40000 ALTER TABLE `horario` DISABLE KEYS */;
LOCK TABLES `horario` WRITE;
INSERT INTO `jhard`.`horario` VALUES  (1,1,'10:00:00','10:55:00',1,1);
UNLOCK TABLES;
/*!40000 ALTER TABLE `horario` ENABLE KEYS */;


--
-- Definition of table `jhard`.`inscripcion`
--

DROP TABLE IF EXISTS `jhard`.`inscripcion`;
CREATE TABLE  `jhard`.`inscripcion` (
  `idinscripcion` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Id correlativo unico para cada inscripcion',
  `idcurso` int(11) NOT NULL COMMENT 'Referencia al curso al cual se inscribio el estudiante',
  `idestudiante` int(11) NOT NULL COMMENT 'Referencia al estudiante inscrito en este curso',
  PRIMARY KEY (`idinscripcion`),
  KEY `fkidcurso_inscripcion` (`idcurso`),
  KEY `fkidestudiante_inscripcion` (`idestudiante`),
  CONSTRAINT `fkidcurso_inscripcion` FOREIGN KEY (`idcurso`) REFERENCES `curso` (`idcurso`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fkidestudiante_inscripcion` FOREIGN KEY (`idestudiante`) REFERENCES `estudiante` (`idestudiante`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `jhard`.`inscripcion`
--

/*!40000 ALTER TABLE `inscripcion` DISABLE KEYS */;
LOCK TABLES `inscripcion` WRITE;
UNLOCK TABLES;
/*!40000 ALTER TABLE `inscripcion` ENABLE KEYS */;


--
-- Definition of table `jhard`.`instalacion`
--

DROP TABLE IF EXISTS `jhard`.`instalacion`;
CREATE TABLE  `jhard`.`instalacion` (
  `idinstalacion` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Id correlativo unico de cada instalacion',
  `idsoftware` int(11) NOT NULL COMMENT 'Referencia al software instalado',
  `fechainstalacion` date NOT NULL COMMENT 'Fecha en la que se realizo la instalacion',
  `idequipoexistente` int(11) NOT NULL COMMENT 'Referencia al equipo donde se instalo el software',
  PRIMARY KEY (`idinstalacion`),
  KEY `fkidsoftware_instalacion` (`idsoftware`),
  KEY `fkidequipoexistente_instalacion` (`idequipoexistente`),
  CONSTRAINT `fkidequipoexistente_instalacion` FOREIGN KEY (`idequipoexistente`) REFERENCES `existencia` (`idexistencia`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fkidsoftware_instalacion` FOREIGN KEY (`idsoftware`) REFERENCES `software` (`idsoftware`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `jhard`.`instalacion`
--

/*!40000 ALTER TABLE `instalacion` DISABLE KEYS */;
LOCK TABLES `instalacion` WRITE;
INSERT INTO `jhard`.`instalacion` VALUES  (1,1,'2009-04-03',2);
UNLOCK TABLES;
/*!40000 ALTER TABLE `instalacion` ENABLE KEYS */;


--
-- Definition of table `jhard`.`instructor`
--

DROP TABLE IF EXISTS `jhard`.`instructor`;
CREATE TABLE  `jhard`.`instructor` (
  `idinstructor` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Id correlativo unico para cada instructor',
  `carnet` varchar(7) NOT NULL COMMENT 'Carnet con el cual se encuentra registrado en adacad',
  `apellidos` varchar(200) NOT NULL COMMENT 'Apellidos del instructor',
  `nombres` varchar(200) NOT NULL COMMENT 'Nombres del instructor',
  `idusuario` int(11) NOT NULL COMMENT 'Referencia al usuario con el que instructor accede al sistema',
  `visible` int(11) NOT NULL DEFAULT '1' COMMENT 'Estado del instructor. Por defecto es 1, lo cual significa que esta en uso. Al momento de borrar un instructor, nada mas se cambia este campo a 0.',
  PRIMARY KEY (`idinstructor`),
  KEY `fkidusuario_instructor` (`idusuario`),
  CONSTRAINT `fkidusuario_instructor` FOREIGN KEY (`idusuario`) REFERENCES `usuario` (`idusuario`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `jhard`.`instructor`
--

/*!40000 ALTER TABLE `instructor` DISABLE KEYS */;
LOCK TABLES `instructor` WRITE;
INSERT INTO `jhard`.`instructor` VALUES  (1,'CC02043','Cerna','Fredy',8,1),
 (2,'BP04004','Barrientos Padilla','Hugo Alejandro',9,1);
UNLOCK TABLES;
/*!40000 ALTER TABLE `instructor` ENABLE KEYS */;


--
-- Definition of table `jhard`.`mantenimiento`
--

DROP TABLE IF EXISTS `jhard`.`mantenimiento`;
CREATE TABLE  `jhard`.`mantenimiento` (
  `idmantenimiento` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Id correlativo unico de cada mantenimiento',
  `fecha` date NOT NULL COMMENT 'Fecha en la que se efectuo el mantenimiento',
  `descripcion` text NOT NULL COMMENT 'Descripcion del mantenimiento',
  `idtecnico` int(11) NOT NULL COMMENT 'Referencia al tecnico que efectuo el mantenimiento',
  `idsolicitud` int(11) DEFAULT NULL COMMENT 'Referencia a la solicitud de mantenimiento realizada, en caso de existir una',
  `idequipoexistente` int(11) DEFAULT NULL COMMENT 'Referencia al equipo al cual se efectuo el mantenimiento',
  `idequiposimple` int(11) DEFAULT NULL,
  `estado` text NOT NULL,
  PRIMARY KEY (`idmantenimiento`),
  KEY `fkidtecnico_mantenimiento` (`idtecnico`),
  KEY `fkidsolicitud_mantenimiento` (`idsolicitud`),
  KEY `fkidequipoexistente_mantenimiento` (`idequipoexistente`),
  KEY `fkidequiposimple_mantenimiento` (`idequiposimple`),
  CONSTRAINT `fkidequipoexistente_mantenimiento` FOREIGN KEY (`idequipoexistente`) REFERENCES `existencia` (`idexistencia`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fkidequiposimple_mantenimiento` FOREIGN KEY (`idequiposimple`) REFERENCES `equiposimple` (`idEquipoSimple`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fkidsolicitud_mantenimiento` FOREIGN KEY (`idsolicitud`) REFERENCES `solicitud` (`idsolicitud`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fkidtecnico_mantenimiento` FOREIGN KEY (`idtecnico`) REFERENCES `tecnico` (`idtecnico`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `jhard`.`mantenimiento`
--

/*!40000 ALTER TABLE `mantenimiento` DISABLE KEYS */;
LOCK TABLES `mantenimiento` WRITE;
INSERT INTO `jhard`.`mantenimiento` VALUES  (1,'3909-06-21','VIRUS MIERDA',5,3,NULL,1,'Pendiente'),
 (2,'3909-06-21','Virus',3,7,NULL,4,'Finalizado'),
 (3,'3909-06-21','VIRUS MIERDA',4,3,NULL,1,'Pendiente'),
 (4,'3909-06-23','No sirve el monitor',4,8,NULL,13,'Finalizado');
UNLOCK TABLES;
/*!40000 ALTER TABLE `mantenimiento` ENABLE KEYS */;


--
-- Definition of table `jhard`.`marca`
--

DROP TABLE IF EXISTS `jhard`.`marca`;
CREATE TABLE  `jhard`.`marca` (
  `idmarca` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Id correlativo unico de cada marca',
  `nombre` varchar(100) NOT NULL COMMENT 'Nombre de la marca',
  PRIMARY KEY (`idmarca`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `jhard`.`marca`
--

/*!40000 ALTER TABLE `marca` DISABLE KEYS */;
LOCK TABLES `marca` WRITE;
INSERT INTO `jhard`.`marca` VALUES  (1,'Dell'),
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
UNLOCK TABLES;
/*!40000 ALTER TABLE `marca` ENABLE KEYS */;


--
-- Definition of table `jhard`.`materia`
--

DROP TABLE IF EXISTS `jhard`.`materia`;
CREATE TABLE  `jhard`.`materia` (
  `idmateria` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Id correlativo unico de cada materia',
  `codigo` varchar(7) NOT NULL COMMENT 'Codigo de la materia, con el cual se identifica en adacad',
  `nombre` varchar(200) NOT NULL COMMENT 'Nombre de la materia',
  `idcarrera` int(11) NOT NULL COMMENT 'Referencia a la carrera a la cual pertenece esta materia',
  PRIMARY KEY (`idmateria`),
  KEY `fkidcarrera_materia` (`idcarrera`),
  CONSTRAINT `fkidcarrera_materia` FOREIGN KEY (`idcarrera`) REFERENCES `carrera` (`idcarrera`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `jhard`.`materia`
--

/*!40000 ALTER TABLE `materia` DISABLE KEYS */;
LOCK TABLES `materia` WRITE;
INSERT INTO `jhard`.`materia` VALUES  (1,'ALG-135','Algoritmos Gráficos',1),
 (2,'PRN-235','Programación II',1);
UNLOCK TABLES;
/*!40000 ALTER TABLE `materia` ENABLE KEYS */;


--
-- Definition of table `jhard`.`pieza`
--

DROP TABLE IF EXISTS `jhard`.`pieza`;
CREATE TABLE  `jhard`.`pieza` (
  `idpieza` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Id correlativo unico de cada pieza',
  `nombre` varchar(100) NOT NULL COMMENT 'Nombre de la pieza',
  `idmarca` int(11) NOT NULL COMMENT 'Referencia a la marca de la pieza',
  `modelo` varchar(15) NOT NULL COMMENT 'Modelo de la pieza',
  `idclasificacion` int(11) NOT NULL COMMENT 'Referencia a la clasificacion en la que se encuentra la pieza',
  `idequipo` int(11) DEFAULT NULL COMMENT 'Referencia al equipo donde se encuentra instalada la pieza (en caso de estar instalada en uno)',
  PRIMARY KEY (`idpieza`),
  KEY `fkidclasificacion_pieza` (`idclasificacion`),
  KEY `fkidequipo_pieza` (`idequipo`),
  KEY `fkidmarca_pieza` (`idmarca`),
  CONSTRAINT `fkidclasificacion_pieza` FOREIGN KEY (`idclasificacion`) REFERENCES `clasificacion` (`idclasificacion`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fkidequipo_pieza` FOREIGN KEY (`idequipo`) REFERENCES `equipo` (`idequipo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fkidmarca_pieza` FOREIGN KEY (`idmarca`) REFERENCES `marca` (`idmarca`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `jhard`.`pieza`
--

/*!40000 ALTER TABLE `pieza` DISABLE KEYS */;
LOCK TABLES `pieza` WRITE;
INSERT INTO `jhard`.`pieza` VALUES  (1,'memoria RAM',10,'kingston',1,1),
 (2,'disco duro',11,'seagate',1,1);
UNLOCK TABLES;
/*!40000 ALTER TABLE `pieza` ENABLE KEYS */;


--
-- Definition of table `jhard`.`reserva`
--

DROP TABLE IF EXISTS `jhard`.`reserva`;
CREATE TABLE  `jhard`.`reserva` (
  `idreserva` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Id correlativo unico de cada reserva',
  `fechareserva` date NOT NULL COMMENT 'fecha en la que se reservo el equipo',
  `fechahorainicioprestamo` datetime NOT NULL COMMENT 'Fecha y hora inicial a la que se utilizara el equipo',
  `fechahorafinprestamo` datetime NOT NULL COMMENT 'Fecha y hora final a la que se utilizara el equipo',
  `idubicacion` int(11) NOT NULL COMMENT 'Referencia al aula donde se utilizara el equipo',
  `idequipoexistente` int(11) NOT NULL COMMENT 'Referencia al equipo que se utilizara',
  `idusuario` int(11) NOT NULL COMMENT 'Referencia al usuario que registro la reserva',
  `idestado` int(11) NOT NULL COMMENT 'Referencia al estado en el que se encuentra esta reserva',
  `descripcion` text NOT NULL COMMENT 'Descripcion y justificacion de la reserva',
  `idsolicitante` int(11) NOT NULL COMMENT 'Referencia a la persona solicitante del equipo',
  `idresponsable` int(11) NOT NULL COMMENT 'Referencia al (docente)responsable del prestamo de este equipo',
  PRIMARY KEY (`idreserva`),
  KEY `fkidestado_reserva` (`idestado`),
  KEY `fkidequipoexistente_reserva` (`idequipoexistente`),
  KEY `fkidubicacion_reserva` (`idubicacion`),
  KEY `fkidsolicitante_reserva` (`idsolicitante`),
  KEY `fkidresponsable_reserva` (`idresponsable`),
  KEY `fkidusuario_reserva` (`idusuario`),
  CONSTRAINT `fkidequipoexistente_reserva` FOREIGN KEY (`idequipoexistente`) REFERENCES `existencia` (`idexistencia`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fkidestado_reserva` FOREIGN KEY (`idestado`) REFERENCES `estadoreserva` (`idestadoreserva`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fkidresponsable_reserva` FOREIGN KEY (`idresponsable`) REFERENCES `responsable` (`idresponsable`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fkidsolicitante_reserva` FOREIGN KEY (`idsolicitante`) REFERENCES `solicitante` (`idsolicitante`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fkidubicacion_reserva` FOREIGN KEY (`idubicacion`) REFERENCES `ubicacion` (`idubicacion`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fkidusuario_reserva` FOREIGN KEY (`idusuario`) REFERENCES `usuario` (`idusuario`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `jhard`.`reserva`
--

/*!40000 ALTER TABLE `reserva` DISABLE KEYS */;
LOCK TABLES `reserva` WRITE;
UNLOCK TABLES;
/*!40000 ALTER TABLE `reserva` ENABLE KEYS */;


--
-- Definition of table `jhard`.`responsable`
--

DROP TABLE IF EXISTS `jhard`.`responsable`;
CREATE TABLE  `jhard`.`responsable` (
  `idresponsable` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Id correlativo unico para cada responsable',
  `apellidos` varchar(200) NOT NULL COMMENT 'Apellidos de la persona responsable',
  `nombres` varchar(200) NOT NULL COMMENT 'Nombres de la persona responsable',
  `tipodocumento` varchar(45) NOT NULL COMMENT 'Tipo de documento presentado para solicitar el equipo',
  `valordocumento` varchar(45) NOT NULL COMMENT 'Valor del documento presentado para solicitar el equipo',
  `visible` int(11) NOT NULL DEFAULT '1' COMMENT 'Es 1 por defecto. Indica que el usuario esta activo. Al momento de borrar usuarios del sistema, nada mas cambiar este estado a 0.',
  PRIMARY KEY (`idresponsable`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `jhard`.`responsable`
--

/*!40000 ALTER TABLE `responsable` DISABLE KEYS */;
LOCK TABLES `responsable` WRITE;
UNLOCK TABLES;
/*!40000 ALTER TABLE `responsable` ENABLE KEYS */;


--
-- Definition of table `jhard`.`rol`
--

DROP TABLE IF EXISTS `jhard`.`rol`;
CREATE TABLE  `jhard`.`rol` (
  `idrol` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Id correlativo unico para cada rol',
  `nombre` varchar(100) NOT NULL COMMENT 'Nombre del rol',
  `descripcion` text NOT NULL COMMENT 'Descripcion del rol',
  PRIMARY KEY (`idrol`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `jhard`.`rol`
--

/*!40000 ALTER TABLE `rol` DISABLE KEYS */;
LOCK TABLES `rol` WRITE;
INSERT INTO `jhard`.`rol` VALUES  (1,'Administrador','Administrador de JHard'),
 (2,'Administrativo','Personal Administrativo UES-FMO'),
 (3,'Docente','Docente UES-FMO'),
 (4,'Editor de Contenido','Encargado de actualizar contenido de JHard'),
 (5,'Estudiante','Estudiante UES-FMO'),
 (6,'Instructor','Instructor de materia UES-FMO');
UNLOCK TABLES;
/*!40000 ALTER TABLE `rol` ENABLE KEYS */;


--
-- Definition of table `jhard`.`software`
--

DROP TABLE IF EXISTS `jhard`.`software`;
CREATE TABLE  `jhard`.`software` (
  `idsoftware` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Id correlativo unico de cada software',
  `nombre` varchar(100) NOT NULL COMMENT 'Nombre del software',
  `version` varchar(15) NOT NULL COMMENT 'Version del software',
  `idadquisicion` int(11) DEFAULT NULL COMMENT 'Referencia a los datos de adquisicion del software (en caso de poseerlos)',
  `codigolicencia` varchar(45) DEFAULT NULL COMMENT 'codigo de la licencia del software (en caso de poseer alguno)',
  `cantidadlicencias` int(11) DEFAULT NULL COMMENT 'Cantidad de licencias disponibles para instalar (en caso de poseer licencias)',
  `idclasificacion` int(11) NOT NULL COMMENT 'Referencia a la clasificacion que posee este software',
  PRIMARY KEY (`idsoftware`),
  KEY `fkidadquisicion_software` (`idadquisicion`),
  KEY `fkidclasificacion_software` (`idclasificacion`),
  CONSTRAINT `fkidadquisicion_software` FOREIGN KEY (`idadquisicion`) REFERENCES `adquisicion` (`idadquisicion`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fkidclasificacion_software` FOREIGN KEY (`idclasificacion`) REFERENCES `clasificacion` (`idclasificacion`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `jhard`.`software`
--

/*!40000 ALTER TABLE `software` DISABLE KEYS */;
LOCK TABLES `software` WRITE;
INSERT INTO `jhard`.`software` VALUES  (1,'Microsoft Windows XP','Service Pack 2',3,'JGOL-JGFL-KGJK.KJGF-O3JW-OLB3',20,1);
UNLOCK TABLES;
/*!40000 ALTER TABLE `software` ENABLE KEYS */;


--
-- Definition of table `jhard`.`solicitante`
--

DROP TABLE IF EXISTS `jhard`.`solicitante`;
CREATE TABLE  `jhard`.`solicitante` (
  `idsolicitante` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Id correlativo unico de cada persona solicitante',
  `apellidos` varchar(200) NOT NULL COMMENT 'Apellidos del solicitante',
  `nombres` varchar(200) NOT NULL COMMENT 'Nombres del solicitante',
  `tipodocumento` varchar(45) NOT NULL COMMENT 'Tipo de documento presentado para la solicitud',
  `valordocumento` varchar(45) NOT NULL COMMENT 'Valor del documento presentado para la solicitud',
  `visible` int(11) NOT NULL DEFAULT '1' COMMENT 'Es 1 por defecto. Indica que el usuario esta activo. Al momento de borrar usuarios del sistema, nada mas cambiar este estado a 0.',
  PRIMARY KEY (`idsolicitante`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `jhard`.`solicitante`
--

/*!40000 ALTER TABLE `solicitante` DISABLE KEYS */;
LOCK TABLES `solicitante` WRITE;
UNLOCK TABLES;
/*!40000 ALTER TABLE `solicitante` ENABLE KEYS */;


--
-- Definition of table `jhard`.`solicitud`
--

DROP TABLE IF EXISTS `jhard`.`solicitud`;
CREATE TABLE  `jhard`.`solicitud` (
  `idsolicitud` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Id correlativo unico de cada solicitud',
  `fecha` date NOT NULL COMMENT 'Fecha en la que se registro la solicitud',
  `prioridad` varchar(25) NOT NULL COMMENT 'Tipo de prioridad en la cual se clasifican las solicitudes de mantenimiento. Sus posibles valores son: Alta, Media y Baja',
  `descripcion` text NOT NULL COMMENT 'Descripcion de la solicitud',
  `idusuario` int(11) NOT NULL COMMENT 'Usuario que registro la solicitud',
  `idequipoexistente` int(11) DEFAULT NULL COMMENT 'Equipo al cual se desea efectuar un mantenimiento',
  `idequiposimple` int(11) DEFAULT NULL,
  PRIMARY KEY (`idsolicitud`),
  KEY `fkidequipoexistente_solicitud` (`idequipoexistente`),
  KEY `fkidequiposimple_solicitud` (`idequiposimple`),
  KEY `fkidusuario_solicitud` (`idusuario`),
  CONSTRAINT `fkidequipoexistente_solicitud` FOREIGN KEY (`idequipoexistente`) REFERENCES `existencia` (`idexistencia`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fkidequiposimple_solicitud` FOREIGN KEY (`idequiposimple`) REFERENCES `equiposimple` (`idEquipoSimple`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fkidusuario_solicitud` FOREIGN KEY (`idusuario`) REFERENCES `usuario` (`idusuario`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `jhard`.`solicitud`
--

/*!40000 ALTER TABLE `solicitud` DISABLE KEYS */;
LOCK TABLES `solicitud` WRITE;
INSERT INTO `jhard`.`solicitud` VALUES  (1,'2009-06-06','Alta','Virus',1,1,1),
 (2,'2009-06-17','Media','Virus',1,NULL,1),
 (3,'2009-06-17','Media','VIRUS MIERDA',10,NULL,1),
 (4,'2009-06-17','Media','a veeeeer!',5,NULL,4),
 (5,'3909-06-17','Media','Esta compu la jode la maitra de derechoo',5,NULL,1),
 (6,'3909-06-17','Media','compu mas basuraaa',5,NULL,7),
 (7,'2009-06-19','Baja','Virus',5,NULL,4),
 (8,'3909-06-23','Media','No sirve el monitor',5,NULL,13);
UNLOCK TABLES;
/*!40000 ALTER TABLE `solicitud` ENABLE KEYS */;


--
-- Definition of table `jhard`.`tag`
--

DROP TABLE IF EXISTS `jhard`.`tag`;
CREATE TABLE  `jhard`.`tag` (
  `idtag` int(11) NOT NULL,
  `descripcion` varchar(25) NOT NULL,
  PRIMARY KEY (`idtag`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `jhard`.`tag`
--

/*!40000 ALTER TABLE `tag` DISABLE KEYS */;
LOCK TABLES `tag` WRITE;
INSERT INTO `jhard`.`tag` VALUES  (1,'latin'),
 (2,'uno'),
 (3,'lorem'),
 (4,'mayo'),
 (5,'junio'),
 (6,'enero'),
 (7,'2008'),
 (8,'info'),
 (9,'portada'),
 (10,'2009');
UNLOCK TABLES;
/*!40000 ALTER TABLE `tag` ENABLE KEYS */;


--
-- Definition of table `jhard`.`tag_entrada`
--

DROP TABLE IF EXISTS `jhard`.`tag_entrada`;
CREATE TABLE  `jhard`.`tag_entrada` (
  `idtagentrada` int(11) NOT NULL,
  `idtag` int(11) NOT NULL,
  `identrada` int(11) NOT NULL,
  PRIMARY KEY (`idtagentrada`,`identrada`,`idtag`),
  KEY `fk_tag_entrada_tag` (`idtag`),
  KEY `fk_tag_entrada_entrada` (`identrada`),
  CONSTRAINT `fk_tag_entrada_entrada` FOREIGN KEY (`identrada`) REFERENCES `entrada` (`identrada`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_tag_entrada_tag` FOREIGN KEY (`idtag`) REFERENCES `tag` (`idtag`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `jhard`.`tag_entrada`
--

/*!40000 ALTER TABLE `tag_entrada` DISABLE KEYS */;
LOCK TABLES `tag_entrada` WRITE;
INSERT INTO `jhard`.`tag_entrada` VALUES  (3,1,1),
 (4,1,2),
 (5,1,3),
 (6,1,4),
 (7,1,5),
 (2,9,5),
 (1,10,5);
UNLOCK TABLES;
/*!40000 ALTER TABLE `tag_entrada` ENABLE KEYS */;


--
-- Definition of table `jhard`.`tecnico`
--

DROP TABLE IF EXISTS `jhard`.`tecnico`;
CREATE TABLE  `jhard`.`tecnico` (
  `idtecnico` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Id correlativo unico para cada tecnico',
  `apellidos` varchar(200) NOT NULL COMMENT 'Apellidos del tecnico',
  `nombres` varchar(200) NOT NULL COMMENT 'Nombres del tecnico',
  `cargo` varchar(200) NOT NULL COMMENT 'Cargo que desempenia el tecnico',
  PRIMARY KEY (`idtecnico`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `jhard`.`tecnico`
--

/*!40000 ALTER TABLE `tecnico` DISABLE KEYS */;
LOCK TABLES `tecnico` WRITE;
INSERT INTO `jhard`.`tecnico` VALUES  (3,'Aguirre','Gabriel','Tecnico'),
 (4,'Mineros','Roberto','Tecnico'),
 (5,'Titon','Diego','Tecnico'),
 (14,'Villatoro','Ana Graciela','Tecnico');
UNLOCK TABLES;
/*!40000 ALTER TABLE `tecnico` ENABLE KEYS */;


--
-- Definition of table `jhard`.`ubicacion`
--

DROP TABLE IF EXISTS `jhard`.`ubicacion`;
CREATE TABLE  `jhard`.`ubicacion` (
  `idubicacion` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Id correlativo unico de cada ubicacion',
  `nombre` varchar(45) DEFAULT NULL COMMENT 'Nombre de la ubicacion',
  PRIMARY KEY (`idubicacion`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `jhard`.`ubicacion`
--

/*!40000 ALTER TABLE `ubicacion` DISABLE KEYS */;
LOCK TABLES `ubicacion` WRITE;
INSERT INTO `jhard`.`ubicacion` VALUES  (1,'LABCOM-1');
UNLOCK TABLES;
/*!40000 ALTER TABLE `ubicacion` ENABLE KEYS */;


--
-- Definition of table `jhard`.`usuario`
--

DROP TABLE IF EXISTS `jhard`.`usuario`;
CREATE TABLE  `jhard`.`usuario` (
  `idusuario` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Id correlativo unico para cada usuario',
  `nombre` varchar(25) NOT NULL COMMENT 'Nombre del usuario',
  `clave` varchar(35) NOT NULL COMMENT 'Clave de acceso del usuario',
  `idrol` int(11) DEFAULT NULL COMMENT 'Referencia al rol que juega este usuario dentro del sistema, el cual define los modulos y acciones a las que tiene acceso',
  PRIMARY KEY (`idusuario`),
  KEY `fkidrol_usuario` (`idrol`),
  CONSTRAINT `fkidrol_usuario` FOREIGN KEY (`idrol`) REFERENCES `rol` (`idrol`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `jhard`.`usuario`
--

/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
LOCK TABLES `usuario` WRITE;
INSERT INTO `jhard`.`usuario` VALUES  (1,'LuisBarrera','21232F297A57A5A743894A0E4A801FC3',1),
 (2,'Madrid','21232F297A57A5A743894A0E4A801FC3',1),
 (3,'Claudia','9003D1DF22EB4D3820015070385194C8',2),
 (4,'Stanley','9003D1DF22EB4D3820015070385194C8',3),
 (5,'Carmencita','9003D1DF22EB4D3820015070385194C8',2),
 (6,'Gabriel','9003D1DF22EB4D3820015070385194C8',4),
 (7,'Rebekita','9003D1DF22EB4D3820015070385194C8',5),
 (8,'fredy','9003D1DF22EB4D3820015070385194C8',6),
 (9,'hugol','CD82BE786DA71D1DD4EA68C0908AF6E6',6),
 (10,'Karlita','9003D1DF22EB4D3820015070385194C8',2),
 (11,'rosario','9003D1DF22EB4D3820015070385194C8',3);
UNLOCK TABLES;
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;


--
-- Definition of table `jhard`.`valoracion`
--

DROP TABLE IF EXISTS `jhard`.`valoracion`;
CREATE TABLE  `jhard`.`valoracion` (
  `fk_userid` int(11) NOT NULL,
  `fk_identrada` int(11) NOT NULL,
  KEY `entrada` (`fk_userid`,`fk_identrada`) USING BTREE
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `jhard`.`valoracion`
--

/*!40000 ALTER TABLE `valoracion` DISABLE KEYS */;
LOCK TABLES `valoracion` WRITE;
UNLOCK TABLES;
/*!40000 ALTER TABLE `valoracion` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
