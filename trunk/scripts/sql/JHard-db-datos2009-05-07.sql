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

CREATE DATABASE IF NOT EXISTS jhard;
USE jhard;

--
-- Definition of table `accesorio`
--

DROP TABLE IF EXISTS `accesorio`;
CREATE TABLE `accesorio` (
  `idaccesorio` int(11) NOT NULL COMMENT 'Id correlativo unico de cada accesorio',
  `nombre` varchar(100) NOT NULL COMMENT 'Nombre del accesorio',
  `idmarca` int(11) NOT NULL COMMENT 'Referencia a la marca del accesorio',
  `modelo` varchar(15) NOT NULL COMMENT 'Modelo del accesorio',
  `idclasificacion` int(11) NOT NULL COMMENT 'Referencia a la clasificacion en la que se encuentra este accesorio',
  `idequipo` int(11) default NULL COMMENT 'Referencia al equipo al que se encuentra conectado este accesorio, en caso de estar conectado a uno',
  PRIMARY KEY  (`idaccesorio`),
  KEY `fkidmarca_accesorio` (`idmarca`),
  KEY `fkidclasificacion_accesorio` (`idclasificacion`),
  KEY `fkidequipo_accesorio` (`idequipo`),
  CONSTRAINT `fkidclasificacion_accesorio` FOREIGN KEY (`idclasificacion`) REFERENCES `clasificacion` (`idclasificacion`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fkidequipo_accesorio` FOREIGN KEY (`idequipo`) REFERENCES `equipo` (`idequipo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fkidmarca_accesorio` FOREIGN KEY (`idmarca`) REFERENCES `marca` (`idmarca`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `administrador`
--

/*!40000 ALTER TABLE `administrador` DISABLE KEYS */;
INSERT INTO `administrador` (`idadministrador`,`clave`,`idusuario`) VALUES 
 (1,'admin',1),
 (2,'admin',2),
 (3,'firpomadrid',9);
/*!40000 ALTER TABLE `administrador` ENABLE KEYS */;


--
-- Definition of table `adquisicion`
--

DROP TABLE IF EXISTS `adquisicion`;
CREATE TABLE `adquisicion` (
  `idadquisicion` int(11) NOT NULL COMMENT 'Id correlativo unico de la adquisicion',
  `fecha` date NOT NULL COMMENT 'Fecha en la que se adquirio el equipo o software',
  `precio` double NOT NULL COMMENT 'Precio de compra del equipo o software (dejar a cero si fue una donacion)',
  `descripcion` text COMMENT 'Detalles de la adquisicion',
  `proveedor` varchar(100) default NULL COMMENT 'Nombre del proveedor o tienda donde se compro el equipo o software (en caso de haber sido comprado)',
  PRIMARY KEY  (`idadquisicion`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `adquisicion`
--

/*!40000 ALTER TABLE `adquisicion` DISABLE KEYS */;
INSERT INTO `adquisicion` (`idadquisicion`,`fecha`,`precio`,`descripcion`,`proveedor`) VALUES 
 (1,'2002-01-09',200,'Computadora Clon','Medicomp'),
 (2,'2009-03-04',400,'Dell Vostro','Dell'),
 (3,'2002-01-03',50,'Licencia Microsoft Windows','Microsoft');
/*!40000 ALTER TABLE `adquisicion` ENABLE KEYS */;


--
-- Definition of table `asistencia`
--

DROP TABLE IF EXISTS `asistencia`;
CREATE TABLE `asistencia` (
  `idasistencia` int(11) NOT NULL COMMENT 'Id correlativo unico para cada asistencia',
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

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
  `idatributohardware` int(11) NOT NULL COMMENT 'Id correlativo unico del atributo de hardware',
  `nombre` varchar(45) NOT NULL COMMENT 'Nombre del atributo',
  `valor` varchar(45) NOT NULL COMMENT 'Valor del atributo',
  `unidadmedida` varchar(45) NOT NULL COMMENT 'Unidad de medida del atributo',
  `idhardware` int(11) NOT NULL COMMENT 'Referencia al elemento de hardware (equipo, pieza o accesorio) al que pertenece el atributo',
  PRIMARY KEY  (`idatributohardware`),
  KEY `fkidequipo_atributohardware` (`idhardware`),
  KEY `fkidpieza_atributohardware` (`idhardware`),
  KEY `fkidaccesorio_atributohardware` (`idhardware`),
  CONSTRAINT `fkidaccesorio_atributohardware` FOREIGN KEY (`idhardware`) REFERENCES `accesorio` (`idaccesorio`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fkidequipo_atributohardware` FOREIGN KEY (`idhardware`) REFERENCES `equipo` (`idequipo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fkidpieza_atributohardware` FOREIGN KEY (`idhardware`) REFERENCES `pieza` (`idpieza`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `atributohardware`
--

/*!40000 ALTER TABLE `atributohardware` DISABLE KEYS */;
/*!40000 ALTER TABLE `atributohardware` ENABLE KEYS */;


--
-- Definition of table `bitacoracambiosusuario`
--

DROP TABLE IF EXISTS `bitacoracambiosusuario`;
CREATE TABLE `bitacoracambiosusuario` (
  `idbitacora` int(11) NOT NULL COMMENT 'Id correlativo unico de cada bitacora',
  `idusuario` int(11) NOT NULL COMMENT 'Referencia al usuario que realizo el cambio',
  `descripcion` text NOT NULL COMMENT 'Descripcion del cambio que realizo el usuario',
  `fechahora` datetime NOT NULL COMMENT 'Fecha y hora a la que el usuario realizo el cambio',
  PRIMARY KEY  (`idbitacora`),
  KEY `fkidusuario_bitacoracambiosusuario` (`idusuario`),
  CONSTRAINT `fkidusuario_bitacoracambiosusuario` FOREIGN KEY (`idusuario`) REFERENCES `usuario` (`idusuario`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

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
  `idbitacora` int(11) NOT NULL COMMENT 'Id correlativo unico de cada bitacora',
  `fecha` date NOT NULL COMMENT 'Fecha en la que ocurrio el cambio de estado',
  `idestado` int(11) NOT NULL COMMENT 'Referencia al estado al cual cambio el equipo',
  `descripcion` text NOT NULL COMMENT 'Descripcion del cambio realizado',
  `idequipoexistente` int(11) NOT NULL COMMENT 'Referencia al equipo que sufrio el cambio de estado',
  PRIMARY KEY  (`idbitacora`),
  KEY `fkidestado_bitacoraestados` (`idestado`),
  KEY `fkidequipoexistente_bitacoraestados` (`idequipoexistente`),
  KEY `fkidequiposimple_bitacoraestados` (`idequipoexistente`),
  CONSTRAINT `fkidequipoexistente_bitacoraestados` FOREIGN KEY (`idequipoexistente`) REFERENCES `existencia` (`idexistencia`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fkidequiposimple_bitacoraestados` FOREIGN KEY (`idequipoexistente`) REFERENCES `equiposimple` (`idEquipoSimple`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fkidestado_bitacoraestados` FOREIGN KEY (`idestado`) REFERENCES `estadoequipo` (`idestado`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `bitacoraestados`
--

/*!40000 ALTER TABLE `bitacoraestados` DISABLE KEYS */;
/*!40000 ALTER TABLE `bitacoraestados` ENABLE KEYS */;


--
-- Definition of table `carrera`
--

DROP TABLE IF EXISTS `carrera`;
CREATE TABLE `carrera` (
  `idcarrera` int(11) NOT NULL COMMENT 'Id correlativo unico de cada carrera',
  `codigo` varchar(7) NOT NULL COMMENT 'Codigo de la carrera, distintivo en el sistema adacad',
  `nombre` varchar(200) NOT NULL COMMENT 'Nombre de la carrera',
  `idfacultad` int(11) NOT NULL COMMENT 'Referencia a la facultad a la cual pertenece esta carrera',
  PRIMARY KEY  (`idcarrera`),
  KEY `fkidfacultad_carrera` (`idfacultad`),
  CONSTRAINT `fkidfacultad_carrera` FOREIGN KEY (`idfacultad`) REFERENCES `facultad` (`idfacultad`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

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
  `idclase` int(11) NOT NULL COMMENT 'Id correlativo unico para cada clase',
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

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
  `idclasificacion` int(11) NOT NULL COMMENT 'Id correlativo unico de cada clasificacion',
  `nombre` varchar(100) NOT NULL COMMENT 'Nombre de la clasificacion',
  `descripcion` text COMMENT 'Descripcion de la clasificacion',
  `idsuperior` int(11) default NULL COMMENT 'Referencia a la clasificacion padre. Si este campo es nulo, indica que esta es una clasificacion raiz',
  PRIMARY KEY  (`idclasificacion`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `clasificacion`
--

/*!40000 ALTER TABLE `clasificacion` DISABLE KEYS */;
INSERT INTO `clasificacion` (`idclasificacion`,`nombre`,`descripcion`,`idsuperior`) VALUES 
 (1,'PC','PC',1);
/*!40000 ALTER TABLE `clasificacion` ENABLE KEYS */;


--
-- Definition of table `curso`
--

DROP TABLE IF EXISTS `curso`;
CREATE TABLE `curso` (
  `idcurso` int(11) NOT NULL COMMENT 'Id correlativo unico de cada curso',
  `nombre` varchar(200) NOT NULL COMMENT 'Nombre del curso (por si este difiere del nombre de la materia o por si no esta relacionado con una materia especifica)',
  `cupomax` int(11) NOT NULL COMMENT 'Cantidad maxima de alumnos que pueden inscribirse a este curso',
  `idmateria` int(11) default NULL COMMENT 'Referencia a la materia relacionada con este curso (en caso que este relacionado con alguna)',
  `idinstructor` int(11) NOT NULL COMMENT 'Referencia al instructor asignado a impartir este curso',
  `fechainicio` date NOT NULL COMMENT 'Fecha de inicio del curso',
  `ciclo` int(11) default NULL COMMENT 'Ciclo en el que se imparte este curso (1=ciclo impar, 2=ciclo par)',
  `anio` int(11) default NULL COMMENT 'anio en el que se imparte este curso',
  `iddocente` int(11) NOT NULL COMMENT 'Referencia al docente encargado de impartir este curso',
  PRIMARY KEY  (`idcurso`),
  KEY `fkidmateria_curso` (`idmateria`),
  KEY `fkidinstructor_curso` (`idinstructor`),
  KEY `fkiddocente_curso` (`iddocente`),
  CONSTRAINT `fkiddocente_curso` FOREIGN KEY (`iddocente`) REFERENCES `docente` (`iddocente`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fkidinstructor_curso` FOREIGN KEY (`idinstructor`) REFERENCES `instructor` (`idinstructor`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fkidmateria_curso` FOREIGN KEY (`idmateria`) REFERENCES `materia` (`idmateria`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `curso`
--

/*!40000 ALTER TABLE `curso` DISABLE KEYS */;
INSERT INTO `curso` (`idcurso`,`nombre`,`cupomax`,`idmateria`,`idinstructor`,`fechainicio`,`ciclo`,`anio`,`iddocente`) VALUES 
 (1,'Grupo 1 ',20,2,2,'2009-03-03',1,2009,1);
/*!40000 ALTER TABLE `curso` ENABLE KEYS */;


--
-- Definition of table `docente`
--

DROP TABLE IF EXISTS `docente`;
CREATE TABLE `docente` (
  `iddocente` int(11) NOT NULL COMMENT 'Id correlativo unico para cada docente',
  `Apellidos` varchar(200) NOT NULL COMMENT 'Apellidos del docente',
  `Nombres` varchar(200) NOT NULL COMMENT 'Nombres del docente',
  `idusuario` int(11) NOT NULL COMMENT 'Referencia al usuario con el que el docente ingresa al sistema',
  `visible` int(11) NOT NULL COMMENT 'Es 1 por defecto. Indica que el usuario esta activo. Al momento de borrar usuarios del sistema, nada mas cambiar este estado a 0.',
  PRIMARY KEY  (`iddocente`),
  KEY `fkidusuario_docente` (`idusuario`),
  CONSTRAINT `fkidusuario_docente` FOREIGN KEY (`idusuario`) REFERENCES `usuario` (`idusuario`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `docente`
--

/*!40000 ALTER TABLE `docente` DISABLE KEYS */;
INSERT INTO `docente` (`iddocente`,`Apellidos`,`Nombres`,`idusuario`,`visible`) VALUES 
 (1,'Linares Paula','Carlos Stanley',4,1);
/*!40000 ALTER TABLE `docente` ENABLE KEYS */;


--
-- Definition of table `equipo`
--

DROP TABLE IF EXISTS `equipo`;
CREATE TABLE `equipo` (
  `idequipo` int(11) NOT NULL COMMENT 'Id correlativo unico de cada equipo',
  `idmarca` int(11) NOT NULL COMMENT 'Referencia a la marca que posee este equipo',
  `nombre` varchar(45) NOT NULL COMMENT 'Nombre del equipo',
  `modelo` varchar(15) NOT NULL COMMENT 'Modelo al cual pertenece el equipo',
  `idclasificacion` int(11) NOT NULL COMMENT 'Referencia a la clasificacion a la cual esta relacionado este equipo',
  PRIMARY KEY  (`idequipo`),
  KEY `fkidmarca_equipo` (`idmarca`),
  KEY `fkidclasificacion_equipo` (`idclasificacion`),
  CONSTRAINT `fkidclasificacion_equipo` FOREIGN KEY (`idclasificacion`) REFERENCES `clasificacion` (`idclasificacion`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fkidmarca_equipo` FOREIGN KEY (`idmarca`) REFERENCES `marca` (`idmarca`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `equipo`
--

/*!40000 ALTER TABLE `equipo` DISABLE KEYS */;
INSERT INTO `equipo` (`idequipo`,`idmarca`,`nombre`,`modelo`,`idclasificacion`) VALUES 
 (1,9,'PC','PC',1),
 (2,1,'DellPC','Vostro',1);
/*!40000 ALTER TABLE `equipo` ENABLE KEYS */;


--
-- Definition of table `equiposimple`
--

DROP TABLE IF EXISTS `equiposimple`;
CREATE TABLE `equiposimple` (
  `idEquipoSimple` int(11) NOT NULL COMMENT 'Id correlativo unico de cada equipo simple',
  `descripcion` text NOT NULL COMMENT 'Descripcion del equipo simple',
  `propietario` varchar(200) NOT NULL COMMENT 'Nombre del propietario del equipo simple',
  `idestado` int(11) NOT NULL COMMENT 'Referencia al estado en el que se encuentra el equipo simple',
  PRIMARY KEY  (`idEquipoSimple`),
  KEY `fkidestado_equiposimple` (`idestado`),
  CONSTRAINT `fkidestado_equiposimple` FOREIGN KEY (`idestado`) REFERENCES `estadoequipo` (`idestado`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `equiposimple`
--

/*!40000 ALTER TABLE `equiposimple` DISABLE KEYS */;
INSERT INTO `equiposimple` (`idEquipoSimple`,`descripcion`,`propietario`,`idestado`) VALUES 
 (1,'Computadora Oficina Jurídica','Lic. Sonia',1),
 (2,'Computadora Secretaria Matemáticas','Karlita',1),
 (3,'Computadora Docentes Matemática','Docentes Matemática',1);
/*!40000 ALTER TABLE `equiposimple` ENABLE KEYS */;


--
-- Definition of table `estadoequipo`
--

DROP TABLE IF EXISTS `estadoequipo`;
CREATE TABLE `estadoequipo` (
  `idestado` int(11) NOT NULL COMMENT 'Id correlativo unico de cada estado',
  `nombre` varchar(45) NOT NULL COMMENT 'Nombre del estado',
  `descripcion` text COMMENT 'Descripcion del estado',
  PRIMARY KEY  (`idestado`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

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
  `idestadoreserva` int(11) NOT NULL COMMENT 'Id correlativo unico de cada reserva',
  `nombre` varchar(100) NOT NULL COMMENT 'Nombre del estado de la reserva',
  PRIMARY KEY  (`idestadoreserva`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `estadoreserva`
--

/*!40000 ALTER TABLE `estadoreserva` DISABLE KEYS */;
/*!40000 ALTER TABLE `estadoreserva` ENABLE KEYS */;


--
-- Definition of table `estudiante`
--

DROP TABLE IF EXISTS `estudiante`;
CREATE TABLE `estudiante` (
  `idestudiante` int(11) NOT NULL COMMENT 'Id correlativo unico para cada estudiante',
  `carnet` varchar(7) NOT NULL COMMENT 'Carnet del estudiante, representativo y distintivo en el registro de la facultad',
  `apellidos` varchar(200) NOT NULL COMMENT 'Apellidos del estudiante',
  `nombres` varchar(200) NOT NULL COMMENT 'Nombres del estudiante',
  `idusuario` int(11) NOT NULL COMMENT 'Referencia con la que el usuario ingresa al sistema',
  `visible` int(11) NOT NULL default '1' COMMENT 'Indica el estado de este estudiante. Es 1 por defecto. Indica que el usuario esta activo. Al momento de borrar usuarios del sistema, nada mas cambiar este estado a 0.',
  PRIMARY KEY  (`idestudiante`),
  KEY `fkidusuario_estudiante` (`idusuario`),
  CONSTRAINT `fkidusuario_estudiante` FOREIGN KEY (`idusuario`) REFERENCES `usuario` (`idusuario`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

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
  `idexistencia` int(11) NOT NULL COMMENT 'Id correlativo unico para cada existencia',
  `idhardware` int(11) NOT NULL COMMENT 'Referencia al hardware al cual pertenece esta existencia',
  `idubicacion` int(11) NOT NULL COMMENT 'Referencia a la ubicacion donde se encuentra localizada esta existencia',
  `idestado` int(11) NOT NULL COMMENT 'Referencia al estado en el que se encuentra esta existencia',
  `idadquisicion` int(11) default NULL COMMENT 'Referencia a los datos de la adquisicion (compra) de esta existencia',
  `codigo` varchar(45) NOT NULL COMMENT 'Codigo con el cual clasificar esta existencia en el inventario',
  PRIMARY KEY  (`idexistencia`),
  KEY `fkidhardware_existencia` (`idhardware`),
  KEY `fkidubicacion_existencia` (`idubicacion`),
  KEY `fkidestado_existencia` (`idestado`),
  KEY `fkidadquisicion_existencia` (`idadquisicion`),
  CONSTRAINT `fkidadquisicion_existencia` FOREIGN KEY (`idadquisicion`) REFERENCES `adquisicion` (`idadquisicion`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fkidestado_existencia` FOREIGN KEY (`idestado`) REFERENCES `estadoequipo` (`idestado`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fkidhardware_existencia` FOREIGN KEY (`idhardware`) REFERENCES `equipo` (`idequipo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fkidubicacion_existencia` FOREIGN KEY (`idubicacion`) REFERENCES `ubicacion` (`idubicacion`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `existencia`
--

/*!40000 ALTER TABLE `existencia` DISABLE KEYS */;
INSERT INTO `existencia` (`idexistencia`,`idhardware`,`idubicacion`,`idestado`,`idadquisicion`,`codigo`) VALUES 
 (1,1,1,1,1,'labcom1'),
 (2,1,1,1,1,'labcom2'),
 (3,1,1,1,1,'labcom3'),
 (4,2,1,1,1,'labcom4'),
 (5,2,1,1,1,'labcom5');
/*!40000 ALTER TABLE `existencia` ENABLE KEYS */;


--
-- Definition of table `facultad`
--

DROP TABLE IF EXISTS `facultad`;
CREATE TABLE `facultad` (
  `idfacultad` int(11) NOT NULL COMMENT 'Id correlativo unico de cada facultad',
  `nombre` varchar(200) NOT NULL COMMENT 'Nombre de la facultad',
  PRIMARY KEY  (`idfacultad`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

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
  `idhorario` int(11) NOT NULL COMMENT 'Id correlativo unico para cada horario',
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

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
  `idinscripcion` int(11) NOT NULL COMMENT 'Id correlativo unico para cada inscripcion',
  `idcurso` int(11) NOT NULL COMMENT 'Referencia al curso al cual se inscribio el estudiante',
  `idestudiante` int(11) NOT NULL COMMENT 'Referencia al estudiante inscrito en este curso',
  PRIMARY KEY  (`idinscripcion`),
  KEY `fkidcurso_inscripcion` (`idcurso`),
  KEY `fkidestudiante_inscripcion` (`idestudiante`),
  CONSTRAINT `fkidcurso_inscripcion` FOREIGN KEY (`idcurso`) REFERENCES `curso` (`idcurso`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fkidestudiante_inscripcion` FOREIGN KEY (`idestudiante`) REFERENCES `estudiante` (`idestudiante`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

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
  `idinstalacion` int(11) NOT NULL COMMENT 'Id correlativo unico de cada instalacion',
  `idsoftware` int(11) NOT NULL COMMENT 'Referencia al software instalado',
  `fechainstalacion` date NOT NULL COMMENT 'Fecha en la que se realizo la instalacion',
  `idequipoexistente` int(11) NOT NULL COMMENT 'Referencia al equipo donde se instalo el software',
  PRIMARY KEY  (`idinstalacion`),
  KEY `fkidsoftware_instalacion` (`idsoftware`),
  KEY `fkidequipoexistente_instalacion` (`idequipoexistente`),
  CONSTRAINT `fkidequipoexistente_instalacion` FOREIGN KEY (`idequipoexistente`) REFERENCES `existencia` (`idexistencia`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fkidsoftware_instalacion` FOREIGN KEY (`idsoftware`) REFERENCES `software` (`idsoftware`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

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
  `idinstructor` int(11) NOT NULL COMMENT 'Id correlativo unico para cada instructor',
  `carnet` varchar(7) NOT NULL COMMENT 'Carnet con el cual se encuentra registrado en adacad',
  `apellidos` varchar(200) NOT NULL COMMENT 'Apellidos del instructor',
  `nombres` varchar(200) NOT NULL COMMENT 'Nombres del instructor',
  `idusuario` int(11) NOT NULL COMMENT 'Referencia al usuario con el que instructor accede al sistema',
  `visible` int(11) NOT NULL default '1' COMMENT 'Estado del instructor. Por defecto es 1, lo cual significa que esta en uso. Al momento de borrar un instructor, nada mas se cambia este campo a 0.',
  PRIMARY KEY  (`idinstructor`),
  KEY `fkidusuario_instructor` (`idusuario`),
  CONSTRAINT `fkidusuario_instructor` FOREIGN KEY (`idusuario`) REFERENCES `usuario` (`idusuario`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

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
  `idmantenimiento` int(11) NOT NULL COMMENT 'Id correlativo unico de cada mantenimiento',
  `fecha` date NOT NULL COMMENT 'Fecha en la que se efectuo el mantenimiento',
  `descripcion` text NOT NULL COMMENT 'Descripcion del mantenimiento',
  `idtecnico` int(11) NOT NULL COMMENT 'Referencia al tecnico que efectuo el mantenimiento',
  `idsolicitud` int(11) default NULL COMMENT 'Referencia a la solicitud de mantenimiento realizada, en caso de existir una',
  `idequipoexistente` int(11) NOT NULL COMMENT 'Referencia al equipo al cual se efectuo el mantenimiento',
  PRIMARY KEY  (`idmantenimiento`),
  KEY `fkidtecnico_mantenimiento` (`idtecnico`),
  KEY `fkidsolicitud_mantenimiento` (`idsolicitud`),
  KEY `fkidequipoexistente_mantenimiento` (`idequipoexistente`),
  CONSTRAINT `fkidequipoexistente_mantenimiento` FOREIGN KEY (`idequipoexistente`) REFERENCES `existencia` (`idexistencia`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fkidsolicitud_mantenimiento` FOREIGN KEY (`idsolicitud`) REFERENCES `solicitud` (`idsolicitud`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fkidtecnico_mantenimiento` FOREIGN KEY (`idtecnico`) REFERENCES `tecnico` (`idtecnico`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `mantenimiento`
--

/*!40000 ALTER TABLE `mantenimiento` DISABLE KEYS */;
/*!40000 ALTER TABLE `mantenimiento` ENABLE KEYS */;


--
-- Definition of table `marca`
--

DROP TABLE IF EXISTS `marca`;
CREATE TABLE `marca` (
  `idmarca` int(11) NOT NULL COMMENT 'Id correlativo unico de cada marca',
  `nombre` varchar(100) NOT NULL COMMENT 'Nombre de la marca',
  PRIMARY KEY  (`idmarca`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

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
 (11,'Seagate');
/*!40000 ALTER TABLE `marca` ENABLE KEYS */;


--
-- Definition of table `materia`
--

DROP TABLE IF EXISTS `materia`;
CREATE TABLE `materia` (
  `idmateria` int(11) NOT NULL COMMENT 'Id correlativo unico de cada materia',
  `codigo` varchar(7) NOT NULL COMMENT 'Codigo de la materia, con el cual se identifica en adacad',
  `nombre` varchar(200) NOT NULL COMMENT 'Nombre de la materia',
  `idcarrera` int(11) NOT NULL COMMENT 'Referencia a la carrera a la cual pertenece esta materia',
  PRIMARY KEY  (`idmateria`),
  KEY `fkidcarrera_materia` (`idcarrera`),
  CONSTRAINT `fkidcarrera_materia` FOREIGN KEY (`idcarrera`) REFERENCES `carrera` (`idcarrera`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

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
  `idpieza` int(11) NOT NULL COMMENT 'Id correlativo unico de cada pieza',
  `nombre` varchar(100) NOT NULL COMMENT 'Nombre de la pieza',
  `idmarca` int(11) NOT NULL COMMENT 'Referencia a la marca de la pieza',
  `modelo` varchar(15) NOT NULL COMMENT 'Modelo de la pieza',
  `idclasificacion` int(11) NOT NULL COMMENT 'Referencia a la clasificacion en la que se encuentra la pieza',
  `idequipo` int(11) default NULL COMMENT 'Referencia al equipo donde se encuentra instalada la pieza (en caso de estar instalada en uno)',
  PRIMARY KEY  (`idpieza`),
  KEY `fkidclasificacion_pieza` (`idclasificacion`),
  KEY `fkidequipo_pieza` (`idequipo`),
  KEY `fkidmarca_pieza` (`idmarca`),
  CONSTRAINT `fkidclasificacion_pieza` FOREIGN KEY (`idclasificacion`) REFERENCES `clasificacion` (`idclasificacion`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fkidequipo_pieza` FOREIGN KEY (`idequipo`) REFERENCES `equipo` (`idequipo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fkidmarca_pieza` FOREIGN KEY (`idmarca`) REFERENCES `marca` (`idmarca`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `pieza`
--

/*!40000 ALTER TABLE `pieza` DISABLE KEYS */;
INSERT INTO `pieza` (`idpieza`,`nombre`,`idmarca`,`modelo`,`idclasificacion`,`idequipo`) VALUES 
 (1,'memoria RAM',10,'kingston',1,1),
 (2,'disco duro',11,'seagate',1,1);
/*!40000 ALTER TABLE `pieza` ENABLE KEYS */;


--
-- Definition of table `reserva`
--

DROP TABLE IF EXISTS `reserva`;
CREATE TABLE `reserva` (
  `idreserva` int(11) NOT NULL COMMENT 'Id correlativo unico de cada reserva',
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
  PRIMARY KEY  (`idreserva`),
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `reserva`
--

/*!40000 ALTER TABLE `reserva` DISABLE KEYS */;
/*!40000 ALTER TABLE `reserva` ENABLE KEYS */;


--
-- Definition of table `responsable`
--

DROP TABLE IF EXISTS `responsable`;
CREATE TABLE `responsable` (
  `idresponsable` int(11) NOT NULL COMMENT 'Id correlativo unico para cada responsable',
  `apellidos` varchar(200) NOT NULL COMMENT 'Apellidos de la persona responsable',
  `nombres` varchar(200) NOT NULL COMMENT 'Nombres de la persona responsable',
  `tipodocumento` varchar(45) NOT NULL COMMENT 'Tipo de documento presentado para solicitar el equipo',
  `valordocumento` varchar(45) NOT NULL COMMENT 'Valor del documento presentado para solicitar el equipo',
  `visible` int(11) NOT NULL default '1' COMMENT 'Es 1 por defecto. Indica que el usuario esta activo. Al momento de borrar usuarios del sistema, nada mas cambiar este estado a 0.',
  PRIMARY KEY  (`idresponsable`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `responsable`
--

/*!40000 ALTER TABLE `responsable` DISABLE KEYS */;
/*!40000 ALTER TABLE `responsable` ENABLE KEYS */;


--
-- Definition of table `software`
--

DROP TABLE IF EXISTS `software`;
CREATE TABLE `software` (
  `idsoftware` int(11) NOT NULL COMMENT 'Id correlativo unico de cada software',
  `nombre` varchar(100) NOT NULL COMMENT 'Nombre del software',
  `version` varchar(15) NOT NULL COMMENT 'Version del software',
  `idadquisicion` int(11) default NULL COMMENT 'Referencia a los datos de adquisicion del software (en caso de poseerlos)',
  `codigolicencia` varchar(45) default NULL COMMENT 'codigo de la licencia del software (en caso de poseer alguno)',
  `cantidadlicencias` int(11) default NULL COMMENT 'Cantidad de licencias disponibles para instalar (en caso de poseer licencias)',
  `idclasificacion` int(11) NOT NULL COMMENT 'Referencia a la clasificacion que posee este software',
  PRIMARY KEY  (`idsoftware`),
  KEY `fkidadquisicion_software` (`idadquisicion`),
  KEY `fkidclasificacion_software` (`idclasificacion`),
  CONSTRAINT `fkidadquisicion_software` FOREIGN KEY (`idadquisicion`) REFERENCES `adquisicion` (`idadquisicion`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fkidclasificacion_software` FOREIGN KEY (`idclasificacion`) REFERENCES `clasificacion` (`idclasificacion`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `software`
--

/*!40000 ALTER TABLE `software` DISABLE KEYS */;
INSERT INTO `software` (`idsoftware`,`nombre`,`version`,`idadquisicion`,`codigolicencia`,`cantidadlicencias`,`idclasificacion`) VALUES 
 (1,'Microsoft Windows XP','Service Pack 2',3,'JGOL-JGFL-KGJK.KJGF-O3JW-OLB3',20,1);
/*!40000 ALTER TABLE `software` ENABLE KEYS */;


--
-- Definition of table `solicitante`
--

DROP TABLE IF EXISTS `solicitante`;
CREATE TABLE `solicitante` (
  `idsolicitante` int(11) NOT NULL COMMENT 'Id correlativo unico de cada persona solicitante',
  `apellidos` varchar(200) NOT NULL COMMENT 'Apellidos del solicitante',
  `nombres` varchar(200) NOT NULL COMMENT 'Nombres del solicitante',
  `tipodocumento` varchar(45) NOT NULL COMMENT 'Tipo de documento presentado para la solicitud',
  `valordocumento` varchar(45) NOT NULL COMMENT 'Valor del documento presentado para la solicitud',
  `visible` int(11) NOT NULL default '1' COMMENT 'Es 1 por defecto. Indica que el usuario esta activo. Al momento de borrar usuarios del sistema, nada mas cambiar este estado a 0.',
  PRIMARY KEY  (`idsolicitante`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `solicitante`
--

/*!40000 ALTER TABLE `solicitante` DISABLE KEYS */;
/*!40000 ALTER TABLE `solicitante` ENABLE KEYS */;


--
-- Definition of table `solicitud`
--

DROP TABLE IF EXISTS `solicitud`;
CREATE TABLE `solicitud` (
  `idsolicitud` int(11) NOT NULL COMMENT 'Id correlativo unico de cada solicitud',
  `fecha` date NOT NULL COMMENT 'Fecha en la que se registro la solicitud',
  `descripcion` text NOT NULL COMMENT 'Descripcion de la solicitud',
  `idusuario` int(11) NOT NULL COMMENT 'Usuario que registro la solicitud',
  `idequipoexistente` int(11) NOT NULL COMMENT 'Equipo al cual se desea efectuar un mantenimiento',
  PRIMARY KEY  (`idsolicitud`),
  KEY `fkidequipoexistente_solicitud` (`idequipoexistente`),
  KEY `fkidequiposimple_solicitud` (`idequipoexistente`),
  KEY `fkidusuario_solicitud` (`idusuario`),
  CONSTRAINT `fkidequipoexistente_solicitud` FOREIGN KEY (`idequipoexistente`) REFERENCES `existencia` (`idexistencia`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fkidequiposimple_solicitud` FOREIGN KEY (`idequipoexistente`) REFERENCES `equiposimple` (`idEquipoSimple`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fkidusuario_solicitud` FOREIGN KEY (`idusuario`) REFERENCES `usuario` (`idusuario`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `solicitud`
--

/*!40000 ALTER TABLE `solicitud` DISABLE KEYS */;
/*!40000 ALTER TABLE `solicitud` ENABLE KEYS */;


--
-- Definition of table `tecnico`
--

DROP TABLE IF EXISTS `tecnico`;
CREATE TABLE `tecnico` (
  `idtecnico` int(11) NOT NULL COMMENT 'Id correlativo unico para cada tecnico',
  `apellidos` varchar(200) NOT NULL COMMENT 'Apellidos del tecnico',
  `nombres` varchar(200) NOT NULL COMMENT 'Nombres del tecnico',
  `cargo` varchar(200) NOT NULL COMMENT 'Cargo que desempenia el tecnico',
  PRIMARY KEY  (`idtecnico`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `tecnico`
--

/*!40000 ALTER TABLE `tecnico` DISABLE KEYS */;
/*!40000 ALTER TABLE `tecnico` ENABLE KEYS */;


--
-- Definition of table `ubicacion`
--

DROP TABLE IF EXISTS `ubicacion`;
CREATE TABLE `ubicacion` (
  `idubicacion` int(11) NOT NULL COMMENT 'Id correlativo unico de cada ubicacion',
  `nombre` varchar(45) default NULL COMMENT 'Nombre de la ubicacion',
  PRIMARY KEY  (`idubicacion`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

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
  `idusuario` int(11) NOT NULL COMMENT 'Id correlativo unico para cada usuario',
  `nombre` varchar(25) NOT NULL COMMENT 'Nombre del usuario',
  `clave` varchar(15) NOT NULL COMMENT 'Clave de acceso del usuario',
  `rol` varchar(45) default NULL COMMENT 'Rol que juega este usuario dentro del sistema, el cual define los modulos y acciones a las que tiene acceso',
  PRIMARY KEY  (`idusuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `usuario`
--

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
