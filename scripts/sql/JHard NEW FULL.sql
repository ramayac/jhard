-- MySQL dump 10.13  Distrib 5.1.35, for Win32 (ia32)
--
-- Host: localhost    Database: jhard
-- ------------------------------------------------------
-- Server version	5.1.35-community

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

DROP DATABASE IF EXISTS jhard;
CREATE DATABASE jhard;
USE jhard;
--
-- Table structure for table `accesorio`
--

DROP TABLE IF EXISTS `accesorio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `accesorio` (
  `idaccesorio` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Id correlativo unico de cada accesorio',
  `nombre` varchar(100) NOT NULL COMMENT 'Nombre del accesorio',
  `idmarca` int(11) NOT NULL COMMENT 'Referencia a la marca del accesorio',
  `modelo` varchar(15) NOT NULL COMMENT 'Modelo del accesorio',
  `idclasificacion` int(11) NOT NULL COMMENT 'Referencia a la clasificacion en la que se encuentra este accesorio',
  `idexistencia` int(11) DEFAULT NULL,
  PRIMARY KEY (`idaccesorio`),
  KEY `fkidmarca_accesorio` (`idmarca`),
  KEY `fkidclasificacion_accesorio` (`idclasificacion`),
  KEY `fkidexistencia_accesorio` (`idexistencia`),
  CONSTRAINT `fkidclasificacion_accesorio` FOREIGN KEY (`idclasificacion`) REFERENCES `clasificacion` (`idclasificacion`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fkidexistencia_accesorio` FOREIGN KEY (`idexistencia`) REFERENCES `existencia` (`idexistencia`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fkidmarca_accesorio` FOREIGN KEY (`idmarca`) REFERENCES `marca` (`idmarca`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `accesorio`
--

LOCK TABLES `accesorio` WRITE;
/*!40000 ALTER TABLE `accesorio` DISABLE KEYS */;
/*!40000 ALTER TABLE `accesorio` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `administrador`
--

DROP TABLE IF EXISTS `administrador`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `administrador` (
  `idadministrador` int(11) NOT NULL COMMENT 'Id correlativo unico de cada administrador',
  `clave` varchar(45) NOT NULL COMMENT 'Clave del administrador',
  `idusuario` int(11) NOT NULL COMMENT 'referencia al usuario relacionado con este admnistrador',
  PRIMARY KEY (`idadministrador`),
  KEY `fkidusuario_administrador` (`idusuario`),
  CONSTRAINT `fkidusuario_administrador` FOREIGN KEY (`idusuario`) REFERENCES `usuario` (`idusuario`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `administrador`
--

LOCK TABLES `administrador` WRITE;
/*!40000 ALTER TABLE `administrador` DISABLE KEYS */;
INSERT INTO `administrador` VALUES (1,'21232F297A57A5A743894A0E4A801FC3',1),(2,'21232F297A57A5A743894A0E4A801FC3',2),(3,'CD82BE786DA71D1DD4EA68C0908AF6E6',9);
/*!40000 ALTER TABLE `administrador` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `adquisicion`
--

DROP TABLE IF EXISTS `adquisicion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `adquisicion` (
  `idadquisicion` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Id correlativo unico de la adquisicion',
  `fecha` date NOT NULL COMMENT 'Fecha en la que se adquirio el equipo o software',
  `precio` double NOT NULL COMMENT 'Precio de compra del equipo o software (dejar a cero si fue una donacion)',
  `descripcion` text COMMENT 'Detalles de la adquisicion',
  `proveedor` varchar(100) DEFAULT NULL COMMENT 'Nombre del proveedor o tienda donde se compro el equipo o software (en caso de haber sido comprado)',
  PRIMARY KEY (`idadquisicion`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `adquisicion`
--

LOCK TABLES `adquisicion` WRITE;
/*!40000 ALTER TABLE `adquisicion` DISABLE KEYS */;
INSERT INTO `adquisicion` VALUES (1,'2002-01-09',200,'Computadora Clon','Medicomp'),(2,'2009-03-04',400,'Dell Vostro','Dell'),(3,'2002-01-03',50,'Licencia Microsoft Windows','Microsoft'),(4,'2002-01-03',200,'Cañon Epson','Tecnoservice');
/*!40000 ALTER TABLE `adquisicion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `articulos`
--

DROP TABLE IF EXISTS `articulos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `articulos` (
  `idarticulo` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `titulo` varchar(50) NOT NULL,
  `descripcion` text NOT NULL,
  `fechahora` datetime NOT NULL,
  `idusuario` int(11) NOT NULL,
  PRIMARY KEY (`idarticulo`),
  KEY `fk_articulo_usuario` (`idusuario`),
  KEY `idxArtTitulo` (`titulo`),
  KEY `idxArtFecha` (`fechahora`),
  CONSTRAINT `fkarticulousuario` FOREIGN KEY (`idusuario`) REFERENCES `usuario` (`idusuario`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1 COMMENT='Articulos de jwiki';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `articulos`
--

LOCK TABLES `articulos` WRITE;
/*!40000 ALTER TABLE `articulos` DISABLE KEYS */;
INSERT INTO `articulos` VALUES (2,'¿Qué es un Wiki?','<p>Un <b>wiki</b>, o una <b>wiki</b>, es un <a title=\"Sitio web\" href=\"http://es.wikipedia.org/wiki/Sitio_web\">sitio web</a> cuyas p&aacute;ginas web pueden ser editadas por m&uacute;ltiples voluntarios a trav&eacute;s del <a title=\"Navegador web\" href=\"http://es.wikipedia.org/wiki/Navegador_web\">navegador web</a>. Los <a title=\"Usuario\" href=\"http://es.wikipedia.org/wiki/Usuario\">usuarios</a> pueden crear, modificar o borrar un mismo texto que comparten. Los textos o &quot;p&aacute;ginas wiki&quot; tienen t&iacute;tulos &uacute;nicos. Si se escribe el t&iacute;tulo de una &quot;p&aacute;gina-wiki&quot; en alg&uacute;n lugar del wiki, esta palabra se convierte en un &quot;enlace web&quot; (o &quot;<a title=\"Link\" href=\"http://es.wikipedia.org/wiki/Link\">link</a>&quot;) a la p&aacute;gina web.</p>\n<p>En una p&aacute;gina sobre &quot;alpinismo&quot; puede haber una palabra como &quot;piolet&quot; o &quot;br&uacute;jula&quot; que est&eacute; marcada como palabra perteneciente a un t&iacute;tulo de p&aacute;gina wiki. La mayor parte de las implementaciones de wikis indican en el <a class=\"mw-redirect\" title=\"URL\" href=\"http://es.wikipedia.org/wiki/URL\">URL</a> de la p&aacute;gina el propio t&iacute;tulo de la p&aacute;gina wiki (en Wikipedia ocurre as&iacute;: <a rel=\"nofollow\" title=\"http://es.wikipedia.org/wiki/Alpinismo\" class=\"external free\" href=\"http://es.wikipedia.org/wiki/Alpinismo\">http://es.wikipedia.org/wiki/Alpinismo</a>), facilitando el uso y comprensibilidad del link fuera del propio sitio web. Adem&aacute;s, esto permite formar en muchas ocasiones una coherencia terminol&oacute;gica, generando una ordenaci&oacute;n <i>natural</i> del contenido.</p>\n<p>La aplicaci&oacute;n de mayor peso y a la que le debe su mayor fama hasta el momento ha sido la creaci&oacute;n de enciclopedias colaborativas, g&eacute;nero al que pertenece la <a title=\"Wikipedia\" href=\"http://es.wikipedia.org/wiki/Wikipedia\">Wikipedia</a>. Existen muchas otras aplicaciones m&aacute;s cercanas a la coordinaci&oacute;n de informaciones y acciones, o la puesta en com&uacute;n de conocimientos o textos dentro de grupos.</p>\n<p>La mayor parte de los wikis actuales conservan un historial de cambios que permite recuperar f&aacute;cilmente cualquier estado anterior y ver \'qui&eacute;n\' hizo cada cambio, lo cual facilita enormemente el mantenimiento conjunto y el control de usuarios destructivos. Habitualmente, sin necesidad de una revisi&oacute;n previa, se actualiza el contenido que muestra la p&aacute;gina wiki editada.</p>','2009-07-25 18:59:20',13),(3,'¿Qué es JHard?','<p>\n<meta content=\"text/html; charset=utf-8\" http-equiv=\"CONTENT-TYPE\">\n<title></title>\n<meta content=\"OpenOffice.org 3.1  (Linux)\" name=\"GENERATOR\"> 	<style type=\"text/css\">\n	<!--\n		@page { margin: 2cm }\n		P { margin-bottom: 0.21cm }\n	-->\n	</style>   </meta>\n</meta>\n</p>\n<p>El sistema <strong>JHard</strong>, es una solucion informatica creada para el Laboratorio de Hardware y Software de la <a href=\"http://www.uesocc.edu.sv\">Universidad de El Salvador - Facultad Multidisciplinaria de Occidente</a>.<br />\n<br />\nEst&aacute; compuesto por seis m&oacute;dulos robustos a los que tienen acceso los usuarios de todo tipo, sin embargo est&aacute; compuesto de otra gran cantidad de subcomponentes que a&ntilde;aden caracter&iacute;sticas adicionales, necesarias para el funcionamiento interno del mismo. A continuaci&oacute;n,&nbsp; se listan los&nbsp; seis m&oacute;dulos principales con los que tendr&aacute; interacci&oacute;n los usuarios finales, y las necesidades que cada uno pretenden solventar:</p>\n<ol>\n    <li>JInvent: Manejo de Inventario del Laboratorio de Hardware (No consumibles)</li>\n    <li>JRequest: Solicitud de servicio al laboratorio.</li>\n    <li>JWiki: Modulo colaborativo de conocimiento, con soluciones a problemas comunes.</li>\n    <li>ProCur: Modulo de Manejo de Contenidos (CMS) para la promoci&oacute;n de cursos del Laboratorio de Hardware</li>\n    <li>ManLab: Modulo de para la gesti&oacute;n de inscripci&oacute;n de laboratorios pr&aacute;cticos en el Laboratorio de Hardware.</li>\n    <li>JCanon: Modulo para la gesti&oacute;n de reserva de ca&ntilde;ones y/o laptops.</li>\n</ol>\n<p>El sistema JHard tendr&aacute; adem&aacute;s, una interfaz administrativa (JHardmin) con la que se podr&aacute; dar mantenimiento al sitio, y administrar los perfiles/roles de los usuarios.</p>\n<p>&nbsp;</p>','2009-07-26 09:18:43',13);
/*!40000 ALTER TABLE `articulos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `asistencia`
--

DROP TABLE IF EXISTS `asistencia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `asistencia` (
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
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `asistencia`
--

LOCK TABLES `asistencia` WRITE;
/*!40000 ALTER TABLE `asistencia` DISABLE KEYS */;
/*!40000 ALTER TABLE `asistencia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `atributohardware`
--

DROP TABLE IF EXISTS `atributohardware`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `atributohardware` (
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
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `atributohardware`
--

LOCK TABLES `atributohardware` WRITE;
/*!40000 ALTER TABLE `atributohardware` DISABLE KEYS */;
INSERT INTO `atributohardware` VALUES (1,'Reservable','1','null',3,NULL,NULL),(2,'Reservable','1','null',5,NULL,NULL);
/*!40000 ALTER TABLE `atributohardware` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `autorizacion`
--

DROP TABLE IF EXISTS `autorizacion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `autorizacion` (
  `idautorizacion` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `codigo` varchar(10) DEFAULT NULL,
  `cantmaxima` int(10) unsigned DEFAULT NULL,
  PRIMARY KEY (`idautorizacion`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `autorizacion`
--

LOCK TABLES `autorizacion` WRITE;
/*!40000 ALTER TABLE `autorizacion` DISABLE KEYS */;
/*!40000 ALTER TABLE `autorizacion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bitacoracambiosusuario`
--

DROP TABLE IF EXISTS `bitacoracambiosusuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bitacoracambiosusuario` (
  `idbitacora` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Id correlativo unico de cada bitacora',
  `idusuario` int(11) NOT NULL COMMENT 'Referencia al usuario que realizo el cambio',
  `descripcion` text NOT NULL COMMENT 'Descripcion del cambio que realizo el usuario',
  `fechahora` datetime NOT NULL COMMENT 'Fecha y hora a la que el usuario realizo el cambio',
  PRIMARY KEY (`idbitacora`),
  KEY `fkidusuario_bitacoracambiosusuario` (`idusuario`),
  CONSTRAINT `fkidusuario_bitacoracambiosusuario` FOREIGN KEY (`idusuario`) REFERENCES `usuario` (`idusuario`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bitacoracambiosusuario`
--

LOCK TABLES `bitacoracambiosusuario` WRITE;
/*!40000 ALTER TABLE `bitacoracambiosusuario` DISABLE KEYS */;
/*!40000 ALTER TABLE `bitacoracambiosusuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bitacoraestados`
--

DROP TABLE IF EXISTS `bitacoraestados`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bitacoraestados` (
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
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bitacoraestados`
--

LOCK TABLES `bitacoraestados` WRITE;
/*!40000 ALTER TABLE `bitacoraestados` DISABLE KEYS */;
INSERT INTO `bitacoraestados` VALUES (1,'2009-06-22',2,'Virus',NULL,4),(2,'2009-06-22',2,'Virus',NULL,4),(3,'2009-06-23',2,'No sirve el monitor porque lo jodi si lo jodi',NULL,13),(4,'2009-06-24',2,'aja si como no',NULL,13),(5,'2009-06-26',2,'Se reinstalo Office 2003, se hizo limpieza con CCleaner y se instalo Office 2007. También se instalo Avast 4.8 professional',NULL,11),(6,'2009-06-26',3,'Se desinstalo NOD 32 y se instalo Avast 4.8',NULL,12),(7,'2009-06-28',2,'Se reinstalo el NERO PORQUE SE JODIO',NULL,10),(8,'2009-06-29',2,'Se reinstalo el ubuntu y se le puso XP',NULL,14),(9,'2009-06-29',2,'Le dieron verga a EEUU',NULL,12),(10,'2009-07-30',2,'Se le kito todo software para chatear, unicamente se dejo el Skype',NULL,2),(11,'2009-08-02',1,'No tira audio',8,NULL),(12,'2009-08-02',1,'Se le cambio la tarjeta de audio',8,NULL),(13,'2009-08-02',1,'No enciende',14,NULL),(14,'2009-08-02',1,'No estaba conectada.',14,NULL),(15,'2009-08-02',1,'No enciende la pantalla',15,NULL);
/*!40000 ALTER TABLE `bitacoraestados` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `carrera`
--

DROP TABLE IF EXISTS `carrera`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `carrera` (
  `idcarrera` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Id correlativo unico de cada carrera',
  `codigo` varchar(7) NOT NULL COMMENT 'Codigo de la carrera, distintivo en el sistema adacad',
  `nombre` varchar(200) NOT NULL COMMENT 'Nombre de la carrera',
  `idfacultad` int(11) NOT NULL COMMENT 'Referencia a la facultad a la cual pertenece esta carrera',
  PRIMARY KEY (`idcarrera`),
  KEY `fkidfacultad_carrera` (`idfacultad`),
  CONSTRAINT `fkidfacultad_carrera` FOREIGN KEY (`idfacultad`) REFERENCES `facultad` (`idfacultad`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `carrera`
--

LOCK TABLES `carrera` WRITE;
/*!40000 ALTER TABLE `carrera` DISABLE KEYS */;
INSERT INTO `carrera` VALUES (1,'I30515','Ingeniería de Sistemas Informáticos',1);
/*!40000 ALTER TABLE `carrera` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cicloanyo`
--

DROP TABLE IF EXISTS `cicloanyo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cicloanyo` (
  `idcicloanyo` int(10) unsigned NOT NULL COMMENT 'Id del ciclo año',
  `descripcion` varchar(10) NOT NULL COMMENT 'Descripcion del ciclo y año ( I - 2009 )',
  PRIMARY KEY (`idcicloanyo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Tabla con lista de ciclo y año';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cicloanyo`
--

LOCK TABLES `cicloanyo` WRITE;
/*!40000 ALTER TABLE `cicloanyo` DISABLE KEYS */;
INSERT INTO `cicloanyo` VALUES (1,'I - 2009'),(2,'II - 2009');
/*!40000 ALTER TABLE `cicloanyo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `clase`
--

DROP TABLE IF EXISTS `clase`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `clase` (
  `idclase` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Id correlativo unico para cada clase',
  `fecha` date NOT NULL COMMENT 'Fecha en la que se llevo a cabo esta clase',
  `idhorario` int(11) NOT NULL COMMENT 'Referencia al horario en el que se recibio esta clase',
  `idinstructor` int(11) DEFAULT NULL COMMENT 'Referencia al instructor encargado de dar esta clase (en caso que haya sido un instructor)',
  `tema` varchar(45) NOT NULL COMMENT 'Tema visto en esta clase',
  `observaciones` text COMMENT 'Observaciones obtenidas segun el resultado general de la clase',
  `iddocente` int(11) DEFAULT NULL COMMENT 'Referencia al docente encargado de dar esta clase (en caso que haya sido un docente)',
  `horainicio` time NOT NULL COMMENT 'Hora de inicio de la clase (hora real)',
  `horafin` time NOT NULL COMMENT 'Hora "marcada" como fin de la clase',
  PRIMARY KEY (`idclase`),
  KEY `fkidhorario_clase` (`idhorario`),
  KEY `fkidinstructor_clase` (`idinstructor`),
  KEY `fkiddocente_clase` (`iddocente`),
  CONSTRAINT `fkiddocente_clase` FOREIGN KEY (`iddocente`) REFERENCES `docente` (`iddocente`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fkidhorario_clase` FOREIGN KEY (`idhorario`) REFERENCES `horario` (`idhorario`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fkidinstructor_clase` FOREIGN KEY (`idinstructor`) REFERENCES `instructor` (`idinstructor`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clase`
--

LOCK TABLES `clase` WRITE;
/*!40000 ALTER TABLE `clase` DISABLE KEYS */;
INSERT INTO `clase` VALUES (1,'2009-03-05',1,2,'Herencia en Java','N/A',1,'00:00:00','00:00:00');
/*!40000 ALTER TABLE `clase` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `clasificacion`
--

DROP TABLE IF EXISTS `clasificacion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `clasificacion` (
  `idclasificacion` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Id correlativo unico de cada clasificacion',
  `nombre` varchar(100) NOT NULL COMMENT 'Nombre de la clasificacion',
  `descripcion` text COMMENT 'Descripcion de la clasificacion',
  `idsuperior` int(11) DEFAULT NULL COMMENT 'Referencia a la clasificacion padre. Si este campo es nulo, indica que esta es una clasificacion raiz',
  PRIMARY KEY (`idclasificacion`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clasificacion`
--

LOCK TABLES `clasificacion` WRITE;
/*!40000 ALTER TABLE `clasificacion` DISABLE KEYS */;
INSERT INTO `clasificacion` VALUES (1,'General','Clasificacion general',NULL),(2,'Hardware','Hardware',1),(3,'Software','Software',1),(4,'Equipos','Equipos',2),(5,'Accesorios','Accesorios',2),(6,'Piezas','Piezas',2),(7,'Herramientas de mantenimiento','Herramientas de mantenimiento',2),(8,'Dispositivos de red','Dispositivos de red',2),(9,'Sistemas operativos','Sistemas operativos',3),(10,'Utilerías','Utilerías',3),(12,'Herramientas didácticas','Herramientas didácticas',3),(13,'Desktops','Desktops',4),(14,'Laptops','Laptops',4),(15,'Impresoras','Impresoras',5),(16,'Cañones','Proyectores',5),(17,'IDEs de software','',12),(18,'Antivirus','',10);
/*!40000 ALTER TABLE `clasificacion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `comentarios`
--

DROP TABLE IF EXISTS `comentarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `comentarios` (
  `idcoment` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `comentario` varchar(250) NOT NULL,
  `fechahorara` datetime NOT NULL,
  `identrada` int(11) unsigned NOT NULL,
  `firma` varchar(25) NOT NULL,
  `aprobado` tinyint(1) unsigned NOT NULL,
  PRIMARY KEY (`idcoment`),
  KEY `fk_comentarios_entrada` (`identrada`),
  CONSTRAINT `fk_comentarios_entrada` FOREIGN KEY (`identrada`) REFERENCES `entrada` (`identrada`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comentarios`
--

LOCK TABLES `comentarios` WRITE;
/*!40000 ALTER TABLE `comentarios` DISABLE KEYS */;
INSERT INTO `comentarios` VALUES (8,'¿Alguien tiene alguna duda?','2009-07-25 19:09:26',9,'ramayac',1);
/*!40000 ALTER TABLE `comentarios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `curso`
--

DROP TABLE IF EXISTS `curso`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `curso` (
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
  `idcicloanio` int(10) unsigned NOT NULL COMMENT 'fk al ciclo año al que pertenece el curso',
  `habilinscrip` tinyint(1) NOT NULL COMMENT 'esta habilitado el curso para inscripcion de alumnos?',
  PRIMARY KEY (`idcurso`),
  KEY `fkidmateria_curso` (`idmateria`),
  KEY `fkidinstructor_curso` (`idinstructor`),
  KEY `fkiddocente_curso` (`iddocente`),
  KEY `fkidestado_curso` (`idestado`),
  KEY `fkciclo_curso` (`idcicloanio`),
  CONSTRAINT `fkciclo_curso` FOREIGN KEY (`idcicloanio`) REFERENCES `cicloanyo` (`idcicloanyo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fkiddocente_curso` FOREIGN KEY (`iddocente`) REFERENCES `docente` (`iddocente`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fkidestado_curso` FOREIGN KEY (`idestado`) REFERENCES `estadocurso` (`idestadocurso`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fkidinstructor_curso` FOREIGN KEY (`idinstructor`) REFERENCES `instructor` (`idinstructor`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fkidmateria_curso` FOREIGN KEY (`idmateria`) REFERENCES `materia` (`idmateria`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `curso`
--

LOCK TABLES `curso` WRITE;
/*!40000 ALTER TABLE `curso` DISABLE KEYS */;
INSERT INTO `curso` VALUES (1,'Grupo 1 ',20,2,2,'2009-03-03',1,2009,1,NULL,2,0);
/*!40000 ALTER TABLE `curso` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `docente`
--

DROP TABLE IF EXISTS `docente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `docente` (
  `iddocente` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Id correlativo unico para cada docente',
  `apellidos` varchar(200) NOT NULL COMMENT 'Apellidos del docente',
  `nombres` varchar(200) NOT NULL COMMENT 'Nombres del docente',
  `idusuario` int(11) NOT NULL COMMENT 'Referencia al usuario con el que el docente ingresa al sistema',
  `visible` int(11) NOT NULL COMMENT 'Es 1 por defecto. Indica que el usuario esta activo. Al momento de borrar usuarios del sistema, nada mas cambiar este estado a 0.',
  PRIMARY KEY (`iddocente`),
  KEY `fkidusuario_docente` (`idusuario`),
  CONSTRAINT `fkidusuario_docente` FOREIGN KEY (`idusuario`) REFERENCES `usuario` (`idusuario`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `docente`
--

LOCK TABLES `docente` WRITE;
/*!40000 ALTER TABLE `docente` DISABLE KEYS */;
INSERT INTO `docente` VALUES (1,'Linares Paula','Carlos Stanley',4,1),(2,'Barrera','Luis Alonso',1,1);
/*!40000 ALTER TABLE `docente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `entrada`
--

DROP TABLE IF EXISTS `entrada`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `entrada` (
  `identrada` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `titulo` varchar(50) NOT NULL,
  `descripcion` text NOT NULL,
  `fechahora` datetime NOT NULL,
  `idusuario` int(11) NOT NULL,
  PRIMARY KEY (`identrada`),
  KEY `fk_entrada_usuario` (`idusuario`),
  KEY `idxEntrTitulo` (`titulo`),
  KEY `idxEntrFecha` (`fechahora`),
  CONSTRAINT `fk_entrada_usuario` FOREIGN KEY (`idusuario`) REFERENCES `usuario` (`idusuario`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `entrada`
--

LOCK TABLES `entrada` WRITE;
/*!40000 ALTER TABLE `entrada` DISABLE KEYS */;
INSERT INTO `entrada` VALUES (9,'Cursos de Linux','<p>Linux es un sistema operativo de descarga gratuita que se creo a principios de los a&ntilde;os noventa para competir con Windows. Se caracteriza por ser libre y por venir acompa&ntilde;ado de un c&oacute;digo fuente. Este curso gratis le ense&ntilde;ar&aacute; una serie de pautas para que empiece a manejar Linux.</p>\n<p>El curso comienza el Sabado 31 de Febrero de 2009.</p>','2009-07-25 19:08:15',13),(10,'Curso Ejemplo','<p>Este curso se realizara los <strong>Domingos, de 6 a.m. - 6 p.m.</strong> por los proximos <strong>3 a&ntilde;os</strong>.</p>\n<p>En el curso de ejemplo se impartira:</p>\n<ul>\n    <li>Instalacion de sistema operativo Windows XP en 100 maquinas</li>\n    <li>Limpieza de equipo del laboratorio en 4 horas</li>\n    <li>Preparar comida para los docentes que imparten el curso</li>\n    <li>Colaboracion para la compra de bebidas &quot;espirituosas&quot;</li>\n</ul>\n<p>Esperamos sus comentarios para hacer los preparativos necesarios.</p>','2009-07-26 09:56:37',13);
/*!40000 ALTER TABLE `entrada` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `equipo`
--

DROP TABLE IF EXISTS `equipo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `equipo` (
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
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `equipo`
--

LOCK TABLES `equipo` WRITE;
/*!40000 ALTER TABLE `equipo` DISABLE KEYS */;
INSERT INTO `equipo` VALUES (1,9,'PC','PC',13),(2,1,'DellPC','Vostro',13),(3,12,'Cañon','Epson',16),(4,3,'Laptop','Satellite',14),(5,12,'Cañon','ProView',16),(6,2,'Laptop','VGN',14);
/*!40000 ALTER TABLE `equipo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `equiposimple`
--

DROP TABLE IF EXISTS `equiposimple`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `equiposimple` (
  `idEquipoSimple` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Id correlativo unico de cada equipo simple',
  `descripcion` text NOT NULL COMMENT 'Descripcion del equipo simple',
  `propietario` varchar(200) NOT NULL COMMENT 'Nombre del propietario del equipo simple',
  `idestado` int(11) NOT NULL COMMENT 'Referencia al estado en el que se encuentra el equipo simple',
  PRIMARY KEY (`idEquipoSimple`),
  KEY `fkidestado_equiposimple` (`idestado`),
  CONSTRAINT `fkidestado_equiposimple` FOREIGN KEY (`idestado`) REFERENCES `estadoequipo` (`idestado`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `equiposimple`
--

LOCK TABLES `equiposimple` WRITE;
/*!40000 ALTER TABLE `equiposimple` DISABLE KEYS */;
INSERT INTO `equiposimple` VALUES (1,'Computadora Oficina Jurídica','Carmencita',1),(2,'Computadora Secretaria Matemáticas','Karlita',1),(3,'Computadora Docentes Matemática','rosario',1),(4,'Computadora Carmencita','Carmencita',2),(5,'Compu Medicina','Carmencita',2),(6,'Compu cacasa ','Carmencita',3),(7,'Compu de Reyes','Carmencita',3),(8,'Compu del Bunker','Carmencita',3),(9,'bunker 2','Carmencita',3),(10,'Compu Italia','Carmencita',3),(11,'Compu Egipto','Carmencita',3),(12,'Compu Brasil','Carmencita',1),(13,'Computadora Arq Centeno','Carmencita',2),(14,'Laptop Luis','Luis Barrera',1),(19,'Big Boss','Daddy Yankee',2);
/*!40000 ALTER TABLE `equiposimple` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `estadocurso`
--

DROP TABLE IF EXISTS `estadocurso`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `estadocurso` (
  `idestadocurso` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Id correlativo unico para cada estado del curso',
  `nombre` varchar(100) NOT NULL COMMENT 'Nombre del estado del curso',
  PRIMARY KEY (`idestadocurso`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `estadocurso`
--

LOCK TABLES `estadocurso` WRITE;
/*!40000 ALTER TABLE `estadocurso` DISABLE KEYS */;
/*!40000 ALTER TABLE `estadocurso` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `estadoequipo`
--

DROP TABLE IF EXISTS `estadoequipo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `estadoequipo` (
  `idestado` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Id correlativo unico de cada estado',
  `nombre` varchar(45) NOT NULL COMMENT 'Nombre del estado',
  `descripcion` text COMMENT 'Descripcion del estado',
  PRIMARY KEY (`idestado`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `estadoequipo`
--

LOCK TABLES `estadoequipo` WRITE;
/*!40000 ALTER TABLE `estadoequipo` DISABLE KEYS */;
INSERT INTO `estadoequipo` VALUES (1,'Excelente','Óptimas condiciones'),(2,'Fallido','El equipo reporta fallas'),(3,'En mantenimiento','El equipo esta siendo reparado');
/*!40000 ALTER TABLE `estadoequipo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `estadoreserva`
--

DROP TABLE IF EXISTS `estadoreserva`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `estadoreserva` (
  `idestadoreserva` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Id correlativo unico de cada reserva',
  `nombre` varchar(100) NOT NULL COMMENT 'Nombre del estado de la reserva',
  PRIMARY KEY (`idestadoreserva`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `estadoreserva`
--

LOCK TABLES `estadoreserva` WRITE;
/*!40000 ALTER TABLE `estadoreserva` DISABLE KEYS */;
INSERT INTO `estadoreserva` VALUES (1,'Pendiente'),(2,'En uso'),(3,'Despachada');
/*!40000 ALTER TABLE `estadoreserva` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `estudiante`
--

DROP TABLE IF EXISTS `estudiante`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `estudiante` (
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
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `estudiante`
--

LOCK TABLES `estudiante` WRITE;
/*!40000 ALTER TABLE `estudiante` DISABLE KEYS */;
INSERT INTO `estudiante` VALUES (1,'SM08003','Salgado Martínez','Rebeca Marcela',7,1);
/*!40000 ALTER TABLE `estudiante` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `existencia`
--

DROP TABLE IF EXISTS `existencia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `existencia` (
  `idexistencia` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Id correlativo unico para cada existencia',
  `idhardware` int(11) NOT NULL COMMENT 'Referencia al hardware al cual pertenece esta existencia',
  `idubicacion` int(11) NOT NULL COMMENT 'Referencia a la ubicacion donde se encuentra localizada esta existencia',
  `idestado` int(11) NOT NULL COMMENT 'Referencia al estado en el que se encuentra esta existencia',
  `codigo` varchar(45) NOT NULL COMMENT 'Codigo con el cual clasificar esta existencia en el inventario',
  PRIMARY KEY (`idexistencia`),
  KEY `fkidhardware_existencia` (`idhardware`),
  KEY `fkidubicacion_existencia` (`idubicacion`),
  KEY `fkidestado_existencia` (`idestado`),
  CONSTRAINT `fkidestado_existencia` FOREIGN KEY (`idestado`) REFERENCES `estadoequipo` (`idestado`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fkidhardware_existencia` FOREIGN KEY (`idhardware`) REFERENCES `equipo` (`idequipo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fkidubicacion_existencia` FOREIGN KEY (`idubicacion`) REFERENCES `ubicacion` (`idubicacion`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `existencia`
--

LOCK TABLES `existencia` WRITE;
/*!40000 ALTER TABLE `existencia` DISABLE KEYS */;
INSERT INTO `existencia` VALUES (1,1,1,1,'cantidad de barras'),(2,1,1,1,'codificado de barras'),(3,1,1,1,'codigo de barcode'),(4,2,1,1,'codigo de barras'),(5,2,1,1,'codigo de barras'),(6,3,1,2,'codigo de barras'),(7,3,1,2,'codigo de barras'),(8,4,1,2,'codigo de barras'),(9,4,1,1,'codigo de barras'),(10,5,1,2,'codigo de barras'),(11,5,1,2,'codigo de barras'),(12,6,1,1,'codigo de barras'),(13,6,1,1,'codigo de barras'),(14,1,1,2,'labcom1-1'),(15,1,1,2,'labcom1-2'),(16,1,1,1,'labcom1-3'),(17,1,1,1,'labcom1-4'),(18,1,1,1,'labcom1-5'),(19,1,1,1,'labcom1-6'),(20,1,1,1,'labcom1-7'),(21,1,1,1,'labcom1-8'),(22,1,1,1,'labcom1-9'),(23,1,1,1,'labcom1-10'),(24,1,1,1,'labcom1-11'),(25,1,1,1,'labcom1-12'),(26,1,1,1,'labcom1-13'),(27,1,1,1,'labcom1-14'),(28,1,1,1,'labcom1-15'),(29,1,1,1,'labcom1-16'),(30,1,1,1,'labcom1-17'),(31,1,1,1,'labcom1-18'),(32,1,1,1,'labcom1-19'),(33,1,1,1,'labcom1-20'),(34,1,1,1,'labcom1-21'),(35,1,1,1,'labcom1-22'),(36,1,1,1,'labcom1-23'),(37,1,1,1,'labcom1-24'),(38,1,1,1,'labcom1-25');
/*!40000 ALTER TABLE `existencia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `facultad`
--

DROP TABLE IF EXISTS `facultad`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `facultad` (
  `idfacultad` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Id correlativo unico de cada facultad',
  `nombre` varchar(200) NOT NULL COMMENT 'Nombre de la facultad',
  PRIMARY KEY (`idfacultad`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `facultad`
--

LOCK TABLES `facultad` WRITE;
/*!40000 ALTER TABLE `facultad` DISABLE KEYS */;
INSERT INTO `facultad` VALUES (1,'Facultad Multidisciplinaria de Occidente');
/*!40000 ALTER TABLE `facultad` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `horario`
--

DROP TABLE IF EXISTS `horario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `horario` (
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
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `horario`
--

LOCK TABLES `horario` WRITE;
/*!40000 ALTER TABLE `horario` DISABLE KEYS */;
INSERT INTO `horario` VALUES (1,1,'10:05:00','10:55:00',1,1),(2,3,'10:00:00','10:55:00',1,1),(3,5,'10:00:00','10:55:00',1,1),(4,1,'10:55:00','11:45:00',1,1),(5,2,'10:05:00','10:55:00',1,1),(6,2,'07:35:00','08:25:00',1,1),(7,3,'07:35:00','09:15:00',1,1);
/*!40000 ALTER TABLE `horario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `inscripcion`
--

DROP TABLE IF EXISTS `inscripcion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `inscripcion` (
  `idinscripcion` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Id correlativo unico para cada inscripcion',
  `idcurso` int(11) NOT NULL COMMENT 'Referencia al curso al cual se inscribio el estudiante',
  `idestudiante` int(11) NOT NULL COMMENT 'Referencia al estudiante inscrito en este curso',
  PRIMARY KEY (`idinscripcion`),
  KEY `fkidcurso_inscripcion` (`idcurso`),
  KEY `fkidestudiante_inscripcion` (`idestudiante`),
  CONSTRAINT `fkidcurso_inscripcion` FOREIGN KEY (`idcurso`) REFERENCES `curso` (`idcurso`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fkidestudiante_inscripcion` FOREIGN KEY (`idestudiante`) REFERENCES `estudiante` (`idestudiante`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `inscripcion`
--

LOCK TABLES `inscripcion` WRITE;
/*!40000 ALTER TABLE `inscripcion` DISABLE KEYS */;
/*!40000 ALTER TABLE `inscripcion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `instalacion`
--

DROP TABLE IF EXISTS `instalacion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `instalacion` (
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
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `instalacion`
--

LOCK TABLES `instalacion` WRITE;
/*!40000 ALTER TABLE `instalacion` DISABLE KEYS */;
INSERT INTO `instalacion` VALUES (1,1,'2009-04-03',2);
/*!40000 ALTER TABLE `instalacion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `instructor`
--

DROP TABLE IF EXISTS `instructor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `instructor` (
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
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `instructor`
--

LOCK TABLES `instructor` WRITE;
/*!40000 ALTER TABLE `instructor` DISABLE KEYS */;
INSERT INTO `instructor` VALUES (1,'CC02043','Cerna','Fredy',8,1),(2,'BP04004','Barrientos Padilla','Hugo Alejandro',9,1);
/*!40000 ALTER TABLE `instructor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mantenimiento`
--

DROP TABLE IF EXISTS `mantenimiento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mantenimiento` (
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
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mantenimiento`
--

LOCK TABLES `mantenimiento` WRITE;
/*!40000 ALTER TABLE `mantenimiento` DISABLE KEYS */;
INSERT INTO `mantenimiento` VALUES (2,'3909-06-21','Virus',3,7,NULL,4,'Finalizado'),(3,'3909-06-21','VIRUS MIERDA',4,3,NULL,1,'Pendiente'),(4,'3909-06-23','No sirve el monitor',4,8,NULL,13,'Finalizado'),(5,'3909-06-26','No abre el Office 2003 y necesitamos el Office 2007',14,10,NULL,11,'Finalizado'),(7,'3909-06-28','q jodo vaaaaaaaa',4,13,NULL,3,'Pendiente'),(8,'3909-06-28','Se frego el NERO',14,11,NULL,10,'Finalizado'),(9,'2009-06-29','jajajaja',4,14,NULL,8,'Pendiente'),(10,'2009-06-29','JODIO EL UBUNTU',14,16,NULL,14,'Finalizado'),(11,'2009-06-29','Brasil campeon de la confederaciones',4,15,NULL,12,'Finalizado'),(13,'2009-07-01','Virus',3,2,NULL,1,'Pendiente'),(14,'2009-07-30','No sirve el Chat',4,12,NULL,2,'Finalizado'),(15,'2009-08-02','No tira audio',14,17,8,NULL,'Finalizado'),(16,'2009-08-02','No enciende',3,18,14,NULL,'Finalizado');
/*!40000 ALTER TABLE `mantenimiento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `marca`
--

DROP TABLE IF EXISTS `marca`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `marca` (
  `idmarca` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Id correlativo unico de cada marca',
  `nombre` varchar(100) NOT NULL COMMENT 'Nombre de la marca',
  PRIMARY KEY (`idmarca`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `marca`
--

LOCK TABLES `marca` WRITE;
/*!40000 ALTER TABLE `marca` DISABLE KEYS */;
INSERT INTO `marca` VALUES (0,'Generica'),(1,'Dell'),(2,'Sony'),(3,'Toshiba'),(4,'Compaq'),(5,'HP'),(6,'Acer'),(7,'Canon'),(8,'Kyocera-Mita'),(9,'Clon'),(10,'Kingston'),(11,'Seagate'),(12,'Epson');
/*!40000 ALTER TABLE `marca` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `materia`
--

DROP TABLE IF EXISTS `materia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `materia` (
  `idmateria` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Id correlativo unico de cada materia',
  `codigo` varchar(7) NOT NULL COMMENT 'Codigo de la materia, con el cual se identifica en adacad',
  `nombre` varchar(200) NOT NULL COMMENT 'Nombre de la materia',
  `idcarrera` int(11) NOT NULL COMMENT 'Referencia a la carrera a la cual pertenece esta materia',
  PRIMARY KEY (`idmateria`),
  KEY `fkidcarrera_materia` (`idcarrera`),
  CONSTRAINT `fkidcarrera_materia` FOREIGN KEY (`idcarrera`) REFERENCES `carrera` (`idcarrera`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `materia`
--

LOCK TABLES `materia` WRITE;
/*!40000 ALTER TABLE `materia` DISABLE KEYS */;
INSERT INTO `materia` VALUES (1,'ALG-135','Algoritmos Gráficos',1),(2,'PRN-235','Programación II',1);
/*!40000 ALTER TABLE `materia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pieza`
--

DROP TABLE IF EXISTS `pieza`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pieza` (
  `idpieza` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Id correlativo unico de cada pieza',
  `nombre` varchar(100) NOT NULL COMMENT 'Nombre de la pieza',
  `idmarca` int(11) NOT NULL COMMENT 'Referencia a la marca de la pieza',
  `modelo` varchar(15) NOT NULL COMMENT 'Modelo de la pieza',
  `idclasificacion` int(11) NOT NULL COMMENT 'Referencia a la clasificacion en la que se encuentra la pieza',
  `idexistencia` int(11) DEFAULT NULL,
  PRIMARY KEY (`idpieza`),
  KEY `fkidclasificacion_pieza` (`idclasificacion`),
  KEY `fkidmarca_pieza` (`idmarca`),
  KEY `fkidexistencia_pieza` (`idexistencia`),
  CONSTRAINT `fkidclasificacion_pieza` FOREIGN KEY (`idclasificacion`) REFERENCES `clasificacion` (`idclasificacion`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fkidexistencia_pieza` FOREIGN KEY (`idexistencia`) REFERENCES `existencia` (`idexistencia`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fkidmarca_pieza` FOREIGN KEY (`idmarca`) REFERENCES `marca` (`idmarca`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pieza`
--

LOCK TABLES `pieza` WRITE;
/*!40000 ALTER TABLE `pieza` DISABLE KEYS */;
INSERT INTO `pieza` VALUES (1,'memoria RAM',10,'kingston',6,NULL),(2,'disco duro',11,'seagate',6,NULL);
/*!40000 ALTER TABLE `pieza` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reserva`
--

DROP TABLE IF EXISTS `reserva`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `reserva` (
  `idreserva` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Id correlativo unico de cada reserva',
  `fechareserva` date NOT NULL COMMENT 'fecha en la que se reservo el equipo',
  `fechahorainicioprestamo` datetime NOT NULL COMMENT 'Fecha y hora inicial a la que se utilizara el equipo',
  `fechahorafinprestamo` datetime NOT NULL COMMENT 'Fecha y hora final a la que se utilizara el equipo',
  `idubicacion` int(11) NOT NULL COMMENT 'Referencia al aula donde se utilizara el equipo',
  `idequipoexistente` int(11) NOT NULL COMMENT 'Referencia al equipo que se utilizara',
  `idusuario` int(11) NOT NULL COMMENT 'Referencia al usuario que registro la reserva',
  `idestado` int(11) NOT NULL COMMENT 'Referencia al estado en el que se encuentra esta reserva',
  `descripcion` text NOT NULL COMMENT 'Descripcion y justificacion de la reserva',
  `iddocente` int(11) NOT NULL,
  PRIMARY KEY (`idreserva`),
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
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reserva`
--

LOCK TABLES `reserva` WRITE;
/*!40000 ALTER TABLE `reserva` DISABLE KEYS */;
INSERT INTO `reserva` VALUES (1,'2009-07-08','2009-07-15 15:55:00','2009-07-15 17:15:00',1,6,9,3,'Prestamo de Cañon Epson Epson',1),(2,'2009-07-09','2009-07-16 10:05:00','2009-07-16 11:45:00',1,6,9,1,'Prestamo de Cañon Epson a Stanley',1),(3,'2009-07-10','2009-07-10 10:05:00','2009-07-10 11:45:00',1,6,9,1,'Prestamo de Cañon Epson  Epson',2),(4,'2009-07-10','2009-07-09 17:10:00','2009-07-09 18:50:00',1,6,8,1,'Prestamo de Cañon Epson  Epson',2),(6,'2009-07-10','2009-07-07 10:05:00','2009-07-07 12:35:00',1,6,9,1,'Prestamo de Cañon Epson  Epson',2),(7,'2009-07-10','2009-07-07 18:00:00','2009-07-07 20:30:00',1,6,9,1,'Prestamo de Cañon Epson Epson',2),(8,'2009-07-10','2009-07-07 10:55:00','2009-07-07 12:35:00',1,10,9,1,'Prestamo de Cañon Epson  ProView',2),(9,'2009-07-10','2009-07-07 10:55:00','2009-07-07 12:35:00',1,12,9,3,'Prestamo de Laptop Sony VGN',2),(10,'2009-07-10','2009-07-08 13:00:00','2009-07-08 15:30:00',1,12,9,1,'Prestamo de Laptop Sony VGN',1),(11,'2009-07-10','2009-07-15 14:40:00','2009-07-15 16:20:00',1,12,9,1,'Prestamo de Laptop Sony VGN',1),(12,'2009-07-10','2009-07-06 06:45:00','2009-07-06 09:15:00',1,9,9,3,'Prestamo de Laptop Toshiba Satellite',1),(14,'2009-07-10','2009-07-08 08:25:00','2009-07-08 10:05:00',1,10,9,3,'Prestamo de Cañon Epson  ProView',1),(15,'2009-07-11','2009-07-11 13:00:00','2009-07-11 17:10:00',1,10,9,3,'Prestamo de Cañon Epson  ProView',2),(16,'2009-07-11','2009-07-11 13:00:00','2009-07-11 17:10:00',1,12,9,3,'Prestamo de Laptop Sony VGN',2),(17,'2009-07-11','2009-07-07 10:05:00','2009-07-07 11:45:00',1,10,9,1,'Prestamo de Cañon Epson  ProView',1),(18,'2009-07-11','2009-07-06 10:05:00','2009-07-06 11:45:00',1,7,9,1,'Prestamo de Cañon Epson  Epson',1),(19,'2009-07-11','2009-07-06 10:05:00','2009-07-06 11:45:00',1,11,9,1,'Prestamo de Cañon Epson  ProView',2),(20,'2009-07-11','2009-07-06 10:05:00','2009-07-06 11:45:00',1,11,9,1,'Prestamo de Cañon Epson  ProView',2),(22,'2009-07-12','2009-07-12 10:05:00','2009-07-12 11:45:00',1,8,9,1,'Prestamo de Laptop Toshiba Satellite',2),(23,'2009-07-12','2009-07-12 10:05:00','2009-07-12 11:45:00',1,12,9,1,'Prestamo de Laptop Sony VGN',2),(24,'2009-07-12','2009-07-12 10:05:00','2009-07-12 11:45:00',1,12,9,1,'Prestamo de Laptop Sony VGN',2),(25,'2009-07-12','2009-07-12 10:05:00','2009-07-12 11:45:00',1,8,9,1,'Prestamo de Laptop Toshiba Satellite',2),(26,'2009-07-31','2009-07-31 10:05:00','2009-07-31 10:55:00',1,7,9,1,'Prestamo de Cañon Epson  Epson',1),(27,'2009-07-31','2009-07-31 10:05:00','2009-07-31 10:55:00',1,12,9,1,'Prestamo de Laptop Sony VGN',1);
/*!40000 ALTER TABLE `reserva` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `responsable`
--

DROP TABLE IF EXISTS `responsable`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `responsable` (
  `idresponsable` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Id correlativo unico para cada responsable',
  `apellidos` varchar(200) NOT NULL COMMENT 'Apellidos de la persona responsable',
  `nombres` varchar(200) NOT NULL COMMENT 'Nombres de la persona responsable',
  `tipodocumento` varchar(45) NOT NULL COMMENT 'Tipo de documento presentado para solicitar el equipo',
  `valordocumento` varchar(45) NOT NULL COMMENT 'Valor del documento presentado para solicitar el equipo',
  `visible` int(11) NOT NULL DEFAULT '1' COMMENT 'Es 1 por defecto. Indica que el usuario esta activo. Al momento de borrar usuarios del sistema, nada mas cambiar este estado a 0.',
  PRIMARY KEY (`idresponsable`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `responsable`
--

LOCK TABLES `responsable` WRITE;
/*!40000 ALTER TABLE `responsable` DISABLE KEYS */;
/*!40000 ALTER TABLE `responsable` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rol`
--

DROP TABLE IF EXISTS `rol`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `rol` (
  `idrol` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Id correlativo unico para cada rol',
  `nombre` varchar(100) NOT NULL COMMENT 'Nombre del rol',
  `descripcion` text NOT NULL COMMENT 'Descripcion del rol',
  PRIMARY KEY (`idrol`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rol`
--

LOCK TABLES `rol` WRITE;
/*!40000 ALTER TABLE `rol` DISABLE KEYS */;
INSERT INTO `rol` VALUES (1,'Administrador','Administrador de JHard'),(2,'Administrativo','Personal Administrativo UES-FMO'),(3,'Docente','Docente UES-FMO'),(4,'Editor de Contenido','Encargado de actualizar contenido de JHard'),(5,'Estudiante','Estudiante UES-FMO'),(6,'Instructor','Instructor de materia UES-FMO');
/*!40000 ALTER TABLE `rol` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `software`
--

DROP TABLE IF EXISTS `software`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `software` (
  `idsoftware` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Id correlativo unico de cada software',
  `nombre` varchar(100) NOT NULL COMMENT 'Nombre del software',
  `version` varchar(15) NOT NULL COMMENT 'Version del software',
  `codigolicencia` varchar(45) DEFAULT NULL COMMENT 'codigo de la licencia del software (en caso de poseer alguno)',
  `cantidadlicencias` int(11) DEFAULT NULL COMMENT 'Cantidad de licencias disponibles para instalar (en caso de poseer licencias)',
  `idclasificacion` int(11) NOT NULL COMMENT 'Referencia a la clasificacion que posee este software',
  PRIMARY KEY (`idsoftware`),
  KEY `fkidclasificacion_software` (`idclasificacion`),
  CONSTRAINT `fkidclasificacion_software` FOREIGN KEY (`idclasificacion`) REFERENCES `clasificacion` (`idclasificacion`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `software`
--

LOCK TABLES `software` WRITE;
/*!40000 ALTER TABLE `software` DISABLE KEYS */;
INSERT INTO `software` VALUES (1,'Microsoft Windows XP','Service Pack 2','JGOL-JGFL-KGJK.KJGF-O3JW-OLB3',20,9);
/*!40000 ALTER TABLE `software` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `solicitante`
--

DROP TABLE IF EXISTS `solicitante`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `solicitante` (
  `idsolicitante` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Id correlativo unico de cada persona solicitante',
  `apellidos` varchar(200) NOT NULL COMMENT 'Apellidos del solicitante',
  `nombres` varchar(200) NOT NULL COMMENT 'Nombres del solicitante',
  `tipodocumento` varchar(45) NOT NULL COMMENT 'Tipo de documento presentado para la solicitud',
  `valordocumento` varchar(45) NOT NULL COMMENT 'Valor del documento presentado para la solicitud',
  `visible` int(11) NOT NULL DEFAULT '1' COMMENT 'Es 1 por defecto. Indica que el usuario esta activo. Al momento de borrar usuarios del sistema, nada mas cambiar este estado a 0.',
  PRIMARY KEY (`idsolicitante`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `solicitante`
--

LOCK TABLES `solicitante` WRITE;
/*!40000 ALTER TABLE `solicitante` DISABLE KEYS */;
/*!40000 ALTER TABLE `solicitante` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `solicitud`
--

DROP TABLE IF EXISTS `solicitud`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `solicitud` (
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
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `solicitud`
--

LOCK TABLES `solicitud` WRITE;
/*!40000 ALTER TABLE `solicitud` DISABLE KEYS */;
INSERT INTO `solicitud` VALUES (1,'2009-06-06','Alta','Virus',1,1,1),(2,'2009-06-17','Media','Virus',1,NULL,1),(3,'2009-06-17','Media','VIRUS MIERDA',10,NULL,1),(4,'2009-06-17','Media','a veeeeer!',5,NULL,4),(5,'3909-06-17','Media','Esta compu la jode la maitra de derechoo',5,NULL,1),(6,'3909-06-17','Media','compu mas basuraaa',5,NULL,7),(7,'2009-06-19','Baja','Virus',5,NULL,4),(8,'3909-06-23','Media','No sirve el monitor',5,NULL,13),(9,'3909-06-26','Media','Caduco el antivirus tiene NOD 32',5,NULL,12),(10,'3909-06-26','Media','No abre el Office 2003 y necesitamos el Office 2007',5,NULL,11),(11,'3909-06-26','Media','Se frego el NERO',9,NULL,10),(12,'3909-06-26','Media','No sirve el Chat',10,NULL,2),(13,'3909-06-26','Media','q jodo vaaaaaaaa',10,NULL,3),(14,'3909-06-28','Media','jajajaja',9,NULL,8),(15,'2009-06-29','Media','Brasil campeon de la confederaciones',9,NULL,12),(16,'2009-06-29','Media','JODIO EL UBUNTU',9,NULL,14),(17,'2009-08-02','ALTA','No tira audio',12,8,NULL),(18,'2009-08-02','ALTA','No enciende',12,14,NULL),(19,'2009-08-02','ALTA','No enciende la pantalla',12,15,NULL);
/*!40000 ALTER TABLE `solicitud` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tag`
--

DROP TABLE IF EXISTS `tag`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tag` (
  `idtag` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(25) NOT NULL,
  PRIMARY KEY (`idtag`),
  KEY `idxTagDesc` (`descripcion`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tag`
--

LOCK TABLES `tag` WRITE;
/*!40000 ALTER TABLE `tag` DISABLE KEYS */;
INSERT INTO `tag` VALUES (2,'2009'),(7,'ayuda'),(1,'curso'),(5,'hardware'),(6,'internet'),(3,'linux'),(4,'software'),(8,'virus');
/*!40000 ALTER TABLE `tag` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tag_entrada`
--

DROP TABLE IF EXISTS `tag_entrada`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tag_entrada` (
  `idtagentrada` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `idtag` int(11) unsigned NOT NULL,
  `identrada` int(11) unsigned NOT NULL,
  PRIMARY KEY (`idtagentrada`,`identrada`,`idtag`),
  KEY `fk_tag_entrada_tag` (`idtag`),
  KEY `fk_tag_entrada_entrada` (`identrada`),
  KEY `idxTagEntrada` (`idtag`,`identrada`),
  CONSTRAINT `fk_tag_entrada_entrada` FOREIGN KEY (`identrada`) REFERENCES `entrada` (`identrada`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_tag_entrada_tag` FOREIGN KEY (`idtag`) REFERENCES `tag` (`idtag`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tag_entrada`
--

LOCK TABLES `tag_entrada` WRITE;
/*!40000 ALTER TABLE `tag_entrada` DISABLE KEYS */;
INSERT INTO `tag_entrada` VALUES (18,1,9),(23,1,10),(19,2,9),(20,3,9);
/*!40000 ALTER TABLE `tag_entrada` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tecnico`
--

DROP TABLE IF EXISTS `tecnico`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tecnico` (
  `idtecnico` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Id correlativo unico para cada tecnico',
  `apellidos` varchar(200) NOT NULL COMMENT 'Apellidos del tecnico',
  `nombres` varchar(200) NOT NULL COMMENT 'Nombres del tecnico',
  `cargo` varchar(200) NOT NULL COMMENT 'Cargo que desempenia el tecnico',
  PRIMARY KEY (`idtecnico`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tecnico`
--

LOCK TABLES `tecnico` WRITE;
/*!40000 ALTER TABLE `tecnico` DISABLE KEYS */;
INSERT INTO `tecnico` VALUES (3,'Aguirre','Gabriel','Tecnico'),(4,'Mineros','Roberto','Tecnico'),(14,'Villatoro','Ana Graciela','Tecnico'),(16,'Martinez','Diego','Tecnico');
/*!40000 ALTER TABLE `tecnico` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ubicacion`
--

DROP TABLE IF EXISTS `ubicacion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ubicacion` (
  `idubicacion` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Id correlativo unico de cada ubicacion',
  `nombre` varchar(45) DEFAULT NULL COMMENT 'Nombre de la ubicacion',
  PRIMARY KEY (`idubicacion`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ubicacion`
--

LOCK TABLES `ubicacion` WRITE;
/*!40000 ALTER TABLE `ubicacion` DISABLE KEYS */;
INSERT INTO `ubicacion` VALUES (0,'Generica'),(1,'LABCOM-1');
/*!40000 ALTER TABLE `ubicacion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuario` (
  `idusuario` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Id correlativo unico para cada usuario',
  `nombre` varchar(25) NOT NULL COMMENT 'Nombre del usuario',
  `clave` varchar(35) NOT NULL COMMENT 'Clave de acceso del usuario',
  `idrol` int(11) DEFAULT NULL COMMENT 'Referencia al rol que juega este usuario dentro del sistema, el cual define los modulos y acciones a las que tiene acceso',
  `idautorizacion` int(10) unsigned DEFAULT NULL,
  PRIMARY KEY (`idusuario`),
  KEY `fkidrol_usuario` (`idrol`),
  KEY `fkidautorizacion_usuario` (`idautorizacion`),
  CONSTRAINT `fkidautorizacion_usuario` FOREIGN KEY (`idautorizacion`) REFERENCES `autorizacion` (`idautorizacion`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fkidrol_usuario` FOREIGN KEY (`idrol`) REFERENCES `rol` (`idrol`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1,'LuisBarrera','21232F297A57A5A743894A0E4A801FC3',1,NULL),(2,'Madrid','21232F297A57A5A743894A0E4A801FC3',1,NULL),(3,'Claudia','9003D1DF22EB4D3820015070385194C8',2,NULL),(4,'Stanley','9003D1DF22EB4D3820015070385194C8',3,NULL),(5,'Carmencita','9003D1DF22EB4D3820015070385194C8',2,NULL),(6,'Gabriel','9003D1DF22EB4D3820015070385194C8',4,NULL),(7,'Rebekita','9003D1DF22EB4D3820015070385194C8',5,NULL),(8,'fredy','9003D1DF22EB4D3820015070385194C8',6,NULL),(9,'hugol','CD82BE786DA71D1DD4EA68C0908AF6E6',1,NULL),(10,'Karlita','9003D1DF22EB4D3820015070385194C8',2,NULL),(11,'rosario','9003D1DF22EB4D3820015070385194C8',3,NULL),(12,'robertux','3858F62230AC3C915F300C664312C63F',1,NULL),(13,'ramayac','21232F297A57A5A743894A0E4A801FC3',1,NULL);
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `valoracion`
--

DROP TABLE IF EXISTS `valoracion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `valoracion` (
  `fk_userid` int(11) NOT NULL,
  `fk_identrada` int(11) NOT NULL,
  KEY `entrada` (`fk_userid`,`fk_identrada`) USING BTREE
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `valoracion`
--

LOCK TABLES `valoracion` WRITE;
/*!40000 ALTER TABLE `valoracion` DISABLE KEYS */;
/*!40000 ALTER TABLE `valoracion` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2009-08-04 23:37:12
