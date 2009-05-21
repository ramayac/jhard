-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.0.51a-community-nt


SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL';

CREATE SCHEMA IF NOT EXISTS `jhard` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci ;
USE `jhard`;

-- -----------------------------------------------------
-- Table `jhard`.`facultad`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `jhard`.`facultad` ;

CREATE  TABLE IF NOT EXISTS `jhard`.`facultad` (
  `idfacultad` INT NOT NULL AUTO_INCREMENT COMMENT 'Id correlativo unico de cada facultad' ,
  `nombre` VARCHAR(200) NOT NULL COMMENT 'Nombre de la facultad' ,
  PRIMARY KEY (`idfacultad`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `jhard`.`carrera`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `jhard`.`carrera` ;

CREATE  TABLE IF NOT EXISTS `jhard`.`carrera` (
  `idcarrera` INT NOT NULL AUTO_INCREMENT COMMENT 'Id correlativo unico de cada carrera' ,
  `codigo` VARCHAR(7) NOT NULL COMMENT 'Codigo de la carrera, distintivo en el sistema adacad' ,
  `nombre` VARCHAR(200) NOT NULL COMMENT 'Nombre de la carrera' ,
  `idfacultad` INT NOT NULL COMMENT 'Referencia a la facultad a la cual pertenece esta carrera' ,
  PRIMARY KEY (`idcarrera`) ,
  INDEX `fkidfacultad_carrera` (`idfacultad` ASC) ,
  CONSTRAINT `fkidfacultad_carrera`
    FOREIGN KEY (`idfacultad` )
    REFERENCES `jhard`.`facultad` (`idfacultad` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `jhard`.`materia`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `jhard`.`materia` ;

CREATE  TABLE IF NOT EXISTS `jhard`.`materia` (
  `idmateria` INT NOT NULL AUTO_INCREMENT COMMENT 'Id correlativo unico de cada materia' ,
  `codigo` VARCHAR(7) NOT NULL COMMENT 'Codigo de la materia, con el cual se identifica en adacad' ,
  `nombre` VARCHAR(200) NOT NULL COMMENT 'Nombre de la materia' ,
  `idcarrera` INT NOT NULL COMMENT 'Referencia a la carrera a la cual pertenece esta materia' ,
  PRIMARY KEY (`idmateria`) ,
  INDEX `fkidcarrera_materia` (`idcarrera` ASC) ,
  CONSTRAINT `fkidcarrera_materia`
    FOREIGN KEY (`idcarrera` )
    REFERENCES `jhard`.`carrera` (`idcarrera` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `jhard`.`rol`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `jhard`.`rol` ;

CREATE  TABLE IF NOT EXISTS `jhard`.`rol` (
  `idrol` INT NOT NULL AUTO_INCREMENT COMMENT 'Id correlativo unico para cada rol' ,
  `nombre` VARCHAR(100) NOT NULL COMMENT 'Nombre del rol' ,
  `descripcion` TEXT NOT NULL COMMENT 'Descripcion del rol' ,
  PRIMARY KEY (`idrol`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `jhard`.`usuario`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `jhard`.`usuario` ;

CREATE  TABLE IF NOT EXISTS `jhard`.`usuario` (
  `idusuario` INT NOT NULL AUTO_INCREMENT COMMENT 'Id correlativo unico para cada usuario' ,
  `nombre` VARCHAR(25) NOT NULL COMMENT 'Nombre del usuario' ,
  `clave` VARCHAR(15) NOT NULL COMMENT 'Clave de acceso del usuario' ,
  `idrol` INT NULL COMMENT 'Referencia al rol que juega este usuario dentro del sistema, el cual define los modulos y acciones a las que tiene acceso' ,
  PRIMARY KEY (`idusuario`) ,
  INDEX `fkidrol_usuario` (`idrol` ASC) ,
  CONSTRAINT `fkidrol_usuario`
    FOREIGN KEY (`idrol` )
    REFERENCES `jhard`.`rol` (`idrol` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `jhard`.`instructor`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `jhard`.`instructor` ;

CREATE  TABLE IF NOT EXISTS `jhard`.`instructor` (
  `idinstructor` INT NOT NULL AUTO_INCREMENT COMMENT 'Id correlativo unico para cada instructor' ,
  `carnet` VARCHAR(7) NOT NULL COMMENT 'Carnet con el cual se encuentra registrado en adacad' ,
  `apellidos` VARCHAR(200) NOT NULL COMMENT 'Apellidos del instructor' ,
  `nombres` VARCHAR(200) NOT NULL COMMENT 'Nombres del instructor' ,
  `idusuario` INT NOT NULL COMMENT 'Referencia al usuario con el que instructor accede al sistema' ,
  `visible` INT NOT NULL DEFAULT 1 COMMENT 'Estado del instructor. Por defecto es 1, lo cual significa que esta en uso. Al momento de borrar un instructor, nada mas se cambia este campo a 0.' ,
  PRIMARY KEY (`idinstructor`) ,
  INDEX `fkidusuario_instructor` (`idusuario` ASC) ,
  CONSTRAINT `fkidusuario_instructor`
    FOREIGN KEY (`idusuario` )
    REFERENCES `jhard`.`usuario` (`idusuario` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `jhard`.`docente`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `jhard`.`docente` ;

CREATE  TABLE IF NOT EXISTS `jhard`.`docente` (
  `iddocente` INT NOT NULL AUTO_INCREMENT COMMENT 'Id correlativo unico para cada docente' ,
  `Apellidos` VARCHAR(200) NOT NULL COMMENT 'Apellidos del docente' ,
  `Nombres` VARCHAR(200) NOT NULL COMMENT 'Nombres del docente' ,
  `idusuario` INT NOT NULL COMMENT 'Referencia al usuario con el que el docente ingresa al sistema' ,
  `visible` INT NOT NULL COMMENT 'Es 1 por defecto. Indica que el usuario esta activo. Al momento de borrar usuarios del sistema, nada mas cambiar este estado a 0.' ,
  PRIMARY KEY (`iddocente`) ,
  INDEX `fkidusuario_docente` (`idusuario` ASC) ,
  CONSTRAINT `fkidusuario_docente`
    FOREIGN KEY (`idusuario` )
    REFERENCES `jhard`.`usuario` (`idusuario` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `jhard`.`estadocurso`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `jhard`.`estadocurso` ;

CREATE  TABLE IF NOT EXISTS `jhard`.`estadocurso` (
  `idestadocurso` INT NOT NULL AUTO_INCREMENT COMMENT 'Id correlativo unico para cada estado del curso' ,
  `nombre` VARCHAR(100) NOT NULL COMMENT 'Nombre del estado del curso' ,
  PRIMARY KEY (`idestadocurso`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `jhard`.`curso`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `jhard`.`curso` ;

CREATE  TABLE IF NOT EXISTS `jhard`.`curso` (
  `idcurso` INT NOT NULL AUTO_INCREMENT COMMENT 'Id correlativo unico de cada curso' ,
  `nombre` VARCHAR(200) NOT NULL COMMENT 'Nombre del curso (por si este difiere del nombre de la materia o por si no esta relacionado con una materia especifica)' ,
  `cupomax` INT NOT NULL COMMENT 'Cantidad maxima de alumnos que pueden inscribirse a este curso' ,
  `idmateria` INT NULL COMMENT 'Referencia a la materia relacionada con este curso (en caso que este relacionado con alguna)' ,
  `idinstructor` INT NOT NULL COMMENT 'Referencia al instructor asignado a impartir este curso' ,
  `fechainicio` DATE NOT NULL COMMENT 'Fecha de inicio del curso' ,
  `ciclo` INT NULL COMMENT 'Ciclo en el que se imparte este curso (1=ciclo impar, 2=ciclo par)' ,
  `anio` INT NULL COMMENT 'anio en el que se imparte este curso' ,
  `iddocente` INT NOT NULL COMMENT 'Referencia al docente encargado de impartir este curso' ,
  `idestado` INT NULL ,
  PRIMARY KEY (`idcurso`) ,
  INDEX `fkidmateria_curso` (`idmateria` ASC) ,
  INDEX `fkidinstructor_curso` (`idinstructor` ASC) ,
  INDEX `fkiddocente_curso` (`iddocente` ASC) ,
  INDEX `fkidestado_curso` (`idestado` ASC) ,
  CONSTRAINT `fkidmateria_curso`
    FOREIGN KEY (`idmateria` )
    REFERENCES `jhard`.`materia` (`idmateria` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fkidinstructor_curso`
    FOREIGN KEY (`idinstructor` )
    REFERENCES `jhard`.`instructor` (`idinstructor` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fkiddocente_curso`
    FOREIGN KEY (`iddocente` )
    REFERENCES `jhard`.`docente` (`iddocente` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fkidestado_curso`
    FOREIGN KEY (`idestado` )
    REFERENCES `jhard`.`estadocurso` (`idestadocurso` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `jhard`.`estudiante`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `jhard`.`estudiante` ;

CREATE  TABLE IF NOT EXISTS `jhard`.`estudiante` (
  `idestudiante` INT NOT NULL AUTO_INCREMENT COMMENT 'Id correlativo unico para cada estudiante' ,
  `carnet` VARCHAR(7) NOT NULL COMMENT 'Carnet del estudiante, representativo y distintivo en el registro de la facultad' ,
  `apellidos` VARCHAR(200) NOT NULL COMMENT 'Apellidos del estudiante' ,
  `nombres` VARCHAR(200) NOT NULL COMMENT 'Nombres del estudiante' ,
  `idusuario` INT NOT NULL COMMENT 'Referencia con la que el usuario ingresa al sistema' ,
  `visible` INT NOT NULL DEFAULT 1 COMMENT 'Indica el estado de este estudiante. Es 1 por defecto. Indica que el usuario esta activo. Al momento de borrar usuarios del sistema, nada mas cambiar este estado a 0.' ,
  PRIMARY KEY (`idestudiante`) ,
  INDEX `fkidusuario_estudiante` (`idusuario` ASC) ,
  CONSTRAINT `fkidusuario_estudiante`
    FOREIGN KEY (`idusuario` )
    REFERENCES `jhard`.`usuario` (`idusuario` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `jhard`.`inscripcion`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `jhard`.`inscripcion` ;

CREATE  TABLE IF NOT EXISTS `jhard`.`inscripcion` (
  `idinscripcion` INT NOT NULL AUTO_INCREMENT COMMENT 'Id correlativo unico para cada inscripcion' ,
  `idcurso` INT NOT NULL COMMENT 'Referencia al curso al cual se inscribio el estudiante' ,
  `idestudiante` INT NOT NULL COMMENT 'Referencia al estudiante inscrito en este curso' ,
  PRIMARY KEY (`idinscripcion`) ,
  INDEX `fkidcurso_inscripcion` (`idcurso` ASC) ,
  INDEX `fkidestudiante_inscripcion` (`idestudiante` ASC) ,
  CONSTRAINT `fkidcurso_inscripcion`
    FOREIGN KEY (`idcurso` )
    REFERENCES `jhard`.`curso` (`idcurso` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fkidestudiante_inscripcion`
    FOREIGN KEY (`idestudiante` )
    REFERENCES `jhard`.`estudiante` (`idestudiante` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `jhard`.`ubicacion`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `jhard`.`ubicacion` ;

CREATE  TABLE IF NOT EXISTS `jhard`.`ubicacion` (
  `idubicacion` INT NOT NULL AUTO_INCREMENT COMMENT 'Id correlativo unico de cada ubicacion' ,
  `nombre` VARCHAR(45) NULL COMMENT 'Nombre de la ubicacion' ,
  PRIMARY KEY (`idubicacion`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `jhard`.`horario`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `jhard`.`horario` ;

CREATE  TABLE IF NOT EXISTS `jhard`.`horario` (
  `idhorario` INT NOT NULL AUTO_INCREMENT COMMENT 'Id correlativo unico para cada horario' ,
  `diasemana` INT NOT NULL COMMENT 'Dia de la semana que se brinda el curso (1= lunes, 7= domingo)' ,
  `horainicio` TIME NOT NULL COMMENT 'Hora a la que da inicio el curso' ,
  `horafin` TIME NOT NULL COMMENT 'Hora a la que finaliza el curso' ,
  `idcurso` INT NOT NULL COMMENT 'Referencia al curso relacionado con este horario' ,
  `idaula` INT NOT NULL COMMENT 'Aula en la que se imparte este curso en este horario' ,
  PRIMARY KEY (`idhorario`) ,
  INDEX `fkidcurso_horario` (`idcurso` ASC) ,
  INDEX `fkidaula_horario` (`idaula` ASC) ,
  CONSTRAINT `fkidcurso_horario`
    FOREIGN KEY (`idcurso` )
    REFERENCES `jhard`.`curso` (`idcurso` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fkidaula_horario`
    FOREIGN KEY (`idaula` )
    REFERENCES `jhard`.`ubicacion` (`idubicacion` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `jhard`.`clase`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `jhard`.`clase` ;

CREATE  TABLE IF NOT EXISTS `jhard`.`clase` (
  `idclase` INT NOT NULL AUTO_INCREMENT COMMENT 'Id correlativo unico para cada clase' ,
  `fecha` DATE NOT NULL COMMENT 'Fecha en la que se llevo a cabo esta clase' ,
  `idhorario` INT NOT NULL COMMENT 'Referencia al horario en el que se recibio esta clase' ,
  `idinstructor` INT NULL COMMENT 'Referencia al instructor encargado de dar esta clase (en caso que haya sido un instructor)' ,
  `tema` VARCHAR(45) NOT NULL COMMENT 'Tema visto en esta clase' ,
  `observaciones` TEXT NULL COMMENT 'Observaciones obtenidas segun el resultado general de la clase' ,
  `iddocente` INT NULL COMMENT 'Referencia al docente encargado de dar esta clase (en caso que haya sido un docente)' ,
  PRIMARY KEY (`idclase`) ,
  INDEX `fkidhorario_clase` (`idhorario` ASC) ,
  INDEX `fkidinstructor_clase` (`idinstructor` ASC) ,
  INDEX `fkiddocente_clase` (`iddocente` ASC) ,
  CONSTRAINT `fkidhorario_clase`
    FOREIGN KEY (`idhorario` )
    REFERENCES `jhard`.`horario` (`idhorario` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fkidinstructor_clase`
    FOREIGN KEY (`idinstructor` )
    REFERENCES `jhard`.`instructor` (`idinstructor` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fkiddocente_clase`
    FOREIGN KEY (`iddocente` )
    REFERENCES `jhard`.`docente` (`iddocente` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `jhard`.`marca`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `jhard`.`marca` ;

CREATE  TABLE IF NOT EXISTS `jhard`.`marca` (
  `idmarca` INT NOT NULL AUTO_INCREMENT COMMENT 'Id correlativo unico de cada marca' ,
  `nombre` VARCHAR(100) NOT NULL COMMENT 'Nombre de la marca' ,
  PRIMARY KEY (`idmarca`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `jhard`.`clasificacion`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `jhard`.`clasificacion` ;

CREATE  TABLE IF NOT EXISTS `jhard`.`clasificacion` (
  `idclasificacion` INT NOT NULL AUTO_INCREMENT COMMENT 'Id correlativo unico de cada clasificacion' ,
  `nombre` VARCHAR(100) NOT NULL COMMENT 'Nombre de la clasificacion' ,
  `descripcion` TEXT NULL COMMENT 'Descripcion de la clasificacion' ,
  `idsuperior` INT NULL COMMENT 'Referencia a la clasificacion padre. Si este campo es nulo, indica que esta es una clasificacion raiz' ,
  PRIMARY KEY (`idclasificacion`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `jhard`.`equipo`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `jhard`.`equipo` ;

CREATE  TABLE IF NOT EXISTS `jhard`.`equipo` (
  `idequipo` INT NOT NULL AUTO_INCREMENT COMMENT 'Id correlativo unico de cada equipo' ,
  `idmarca` INT NOT NULL COMMENT 'Referencia a la marca que posee este equipo' ,
  `nombre` VARCHAR(45) NOT NULL COMMENT 'Nombre del equipo' ,
  `modelo` VARCHAR(15) NOT NULL COMMENT 'Modelo al cual pertenece el equipo' ,
  `idclasificacion` INT NOT NULL COMMENT 'Referencia a la clasificacion a la cual esta relacionado este equipo' ,
  PRIMARY KEY (`idequipo`) ,
  INDEX `fkidmarca_equipo` (`idmarca` ASC) ,
  INDEX `fkidclasificacion_equipo` (`idclasificacion` ASC) ,
  CONSTRAINT `fkidmarca_equipo`
    FOREIGN KEY (`idmarca` )
    REFERENCES `jhard`.`marca` (`idmarca` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fkidclasificacion_equipo`
    FOREIGN KEY (`idclasificacion` )
    REFERENCES `jhard`.`clasificacion` (`idclasificacion` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `jhard`.`estadoequipo`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `jhard`.`estadoequipo` ;

CREATE  TABLE IF NOT EXISTS `jhard`.`estadoequipo` (
  `idestado` INT NOT NULL AUTO_INCREMENT COMMENT 'Id correlativo unico de cada estado' ,
  `nombre` VARCHAR(45) NOT NULL COMMENT 'Nombre del estado' ,
  `descripcion` TEXT NULL COMMENT 'Descripcion del estado' ,
  PRIMARY KEY (`idestado`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `jhard`.`adquisicion`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `jhard`.`adquisicion` ;

CREATE  TABLE IF NOT EXISTS `jhard`.`adquisicion` (
  `idadquisicion` INT NOT NULL AUTO_INCREMENT COMMENT 'Id correlativo unico de la adquisicion' ,
  `fecha` DATE NOT NULL COMMENT 'Fecha en la que se adquirio el equipo o software' ,
  `precio` DOUBLE NOT NULL COMMENT 'Precio de compra del equipo o software (dejar a cero si fue una donacion)' ,
  `descripcion` TEXT NULL COMMENT 'Detalles de la adquisicion' ,
  `proveedor` VARCHAR(100) NULL COMMENT 'Nombre del proveedor o tienda donde se compro el equipo o software (en caso de haber sido comprado)' ,
  PRIMARY KEY (`idadquisicion`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `jhard`.`existencia`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `jhard`.`existencia` ;

CREATE  TABLE IF NOT EXISTS `jhard`.`existencia` (
  `idexistencia` INT NOT NULL AUTO_INCREMENT COMMENT 'Id correlativo unico para cada existencia' ,
  `idhardware` INT NOT NULL COMMENT 'Referencia al hardware al cual pertenece esta existencia' ,
  `idubicacion` INT NOT NULL COMMENT 'Referencia a la ubicacion donde se encuentra localizada esta existencia' ,
  `idestado` INT NOT NULL COMMENT 'Referencia al estado en el que se encuentra esta existencia' ,
  `idadquisicion` INT NULL COMMENT 'Referencia a los datos de la adquisicion (compra) de esta existencia' ,
  `codigo` VARCHAR(45) NOT NULL COMMENT 'Codigo con el cual clasificar esta existencia en el inventario' ,
  PRIMARY KEY (`idexistencia`) ,
  INDEX `fkidhardware_existencia` (`idhardware` ASC) ,
  INDEX `fkidubicacion_existencia` (`idubicacion` ASC) ,
  INDEX `fkidestado_existencia` (`idestado` ASC) ,
  INDEX `fkidadquisicion_existencia` (`idadquisicion` ASC) ,
  CONSTRAINT `fkidhardware_existencia`
    FOREIGN KEY (`idhardware` )
    REFERENCES `jhard`.`equipo` (`idequipo` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fkidubicacion_existencia`
    FOREIGN KEY (`idubicacion` )
    REFERENCES `jhard`.`ubicacion` (`idubicacion` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fkidestado_existencia`
    FOREIGN KEY (`idestado` )
    REFERENCES `jhard`.`estadoequipo` (`idestado` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fkidadquisicion_existencia`
    FOREIGN KEY (`idadquisicion` )
    REFERENCES `jhard`.`adquisicion` (`idadquisicion` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `jhard`.`asistencia`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `jhard`.`asistencia` ;

CREATE  TABLE IF NOT EXISTS `jhard`.`asistencia` (
  `idasistencia` INT NOT NULL AUTO_INCREMENT COMMENT 'Id correlativo unico para cada asistencia' ,
  `idestudiante` INT NOT NULL COMMENT 'Referencia al estudiante que asistio al curso' ,
  `idclase` INT NOT NULL COMMENT 'Referencia a la clase a la cual pertenece esta asistencia' ,
  `idequipoexistente` INT NOT NULL COMMENT 'Referencia al equipo de hardware que se utilizo en dicha asistencia a la clase' ,
  PRIMARY KEY (`idasistencia`) ,
  INDEX `fkidestudiante_asistencia` (`idestudiante` ASC) ,
  INDEX `fkidclase_asistencia` (`idclase` ASC) ,
  INDEX `fkidequipoexistente_asistencia` (`idequipoexistente` ASC) ,
  CONSTRAINT `fkidestudiante_asistencia`
    FOREIGN KEY (`idestudiante` )
    REFERENCES `jhard`.`estudiante` (`idestudiante` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fkidclase_asistencia`
    FOREIGN KEY (`idclase` )
    REFERENCES `jhard`.`clase` (`idclase` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fkidequipoexistente_asistencia`
    FOREIGN KEY (`idequipoexistente` )
    REFERENCES `jhard`.`existencia` (`idexistencia` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `jhard`.`software`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `jhard`.`software` ;

CREATE  TABLE IF NOT EXISTS `jhard`.`software` (
  `idsoftware` INT NOT NULL AUTO_INCREMENT COMMENT 'Id correlativo unico de cada software' ,
  `nombre` VARCHAR(100) NOT NULL COMMENT 'Nombre del software' ,
  `version` VARCHAR(15) NOT NULL COMMENT 'Version del software' ,
  `idadquisicion` INT NULL COMMENT 'Referencia a los datos de adquisicion del software (en caso de poseerlos)' ,
  `codigolicencia` VARCHAR(45) NULL COMMENT 'codigo de la licencia del software (en caso de poseer alguno)' ,
  `cantidadlicencias` INT NULL COMMENT 'Cantidad de licencias disponibles para instalar (en caso de poseer licencias)' ,
  `idclasificacion` INT NOT NULL COMMENT 'Referencia a la clasificacion que posee este software' ,
  PRIMARY KEY (`idsoftware`) ,
  INDEX `fkidadquisicion_software` (`idadquisicion` ASC) ,
  INDEX `fkidclasificacion_software` (`idclasificacion` ASC) ,
  CONSTRAINT `fkidadquisicion_software`
    FOREIGN KEY (`idadquisicion` )
    REFERENCES `jhard`.`adquisicion` (`idadquisicion` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fkidclasificacion_software`
    FOREIGN KEY (`idclasificacion` )
    REFERENCES `jhard`.`clasificacion` (`idclasificacion` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `jhard`.`instalacion`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `jhard`.`instalacion` ;

CREATE  TABLE IF NOT EXISTS `jhard`.`instalacion` (
  `idinstalacion` INT NOT NULL AUTO_INCREMENT COMMENT 'Id correlativo unico de cada instalacion' ,
  `idsoftware` INT NOT NULL COMMENT 'Referencia al software instalado' ,
  `fechainstalacion` DATE NOT NULL COMMENT 'Fecha en la que se realizo la instalacion' ,
  `idequipoexistente` INT NOT NULL COMMENT 'Referencia al equipo donde se instalo el software' ,
  PRIMARY KEY (`idinstalacion`) ,
  INDEX `fkidsoftware_instalacion` (`idsoftware` ASC) ,
  INDEX `fkidequipoexistente_instalacion` (`idequipoexistente` ASC) ,
  CONSTRAINT `fkidsoftware_instalacion`
    FOREIGN KEY (`idsoftware` )
    REFERENCES `jhard`.`software` (`idsoftware` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fkidequipoexistente_instalacion`
    FOREIGN KEY (`idequipoexistente` )
    REFERENCES `jhard`.`existencia` (`idexistencia` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `jhard`.`equiposimple`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `jhard`.`equiposimple` ;

CREATE  TABLE IF NOT EXISTS `jhard`.`equiposimple` (
  `idEquipoSimple` INT NOT NULL AUTO_INCREMENT COMMENT 'Id correlativo unico de cada equipo simple' ,
  `descripcion` TEXT NOT NULL COMMENT 'Descripcion del equipo simple' ,
  `propietario` VARCHAR(200) NOT NULL COMMENT 'Nombre del propietario del equipo simple' ,
  `idestado` INT NOT NULL COMMENT 'Referencia al estado en el que se encuentra el equipo simple' ,
  PRIMARY KEY (`idEquipoSimple`) ,
  INDEX `fkidestado_equiposimple` (`idestado` ASC) ,
  CONSTRAINT `fkidestado_equiposimple`
    FOREIGN KEY (`idestado` )
    REFERENCES `jhard`.`estadoequipo` (`idestado` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `jhard`.`bitacoraestados`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `jhard`.`bitacoraestados` ;

CREATE  TABLE IF NOT EXISTS `jhard`.`bitacoraestados` (
  `idbitacora` INT NOT NULL AUTO_INCREMENT COMMENT 'Id correlativo unico de cada bitacora' ,
  `fecha` DATE NOT NULL COMMENT 'Fecha en la que ocurrio el cambio de estado' ,
  `idestado` INT NOT NULL COMMENT 'Referencia al estado al cual cambio el equipo' ,
  `descripcion` TEXT NOT NULL COMMENT 'Descripcion del cambio realizado' ,
  `idequipoexistente` INT NOT NULL COMMENT 'Referencia al equipo que sufrio el cambio de estado' ,
  PRIMARY KEY (`idbitacora`) ,
  INDEX `fkidestado_bitacoraestados` (`idestado` ASC) ,
  INDEX `fkidequipoexistente_bitacoraestados` (`idequipoexistente` ASC) ,
  INDEX `fkidequiposimple_bitacoraestados` (`idequipoexistente` ASC) ,
  CONSTRAINT `fkidestado_bitacoraestados`
    FOREIGN KEY (`idestado` )
    REFERENCES `jhard`.`estadoequipo` (`idestado` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fkidequipoexistente_bitacoraestados`
    FOREIGN KEY (`idequipoexistente` )
    REFERENCES `jhard`.`existencia` (`idexistencia` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fkidequiposimple_bitacoraestados`
    FOREIGN KEY (`idequipoexistente` )
    REFERENCES `jhard`.`equiposimple` (`idEquipoSimple` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `jhard`.`tecnico`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `jhard`.`tecnico` ;

CREATE  TABLE IF NOT EXISTS `jhard`.`tecnico` (
  `idtecnico` INT NOT NULL AUTO_INCREMENT COMMENT 'Id correlativo unico para cada tecnico' ,
  `apellidos` VARCHAR(200) NOT NULL COMMENT 'Apellidos del tecnico' ,
  `nombres` VARCHAR(200) NOT NULL COMMENT 'Nombres del tecnico' ,
  `cargo` VARCHAR(200) NOT NULL COMMENT 'Cargo que desempenia el tecnico' ,
  PRIMARY KEY (`idtecnico`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `jhard`.`solicitud`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `jhard`.`solicitud` ;

CREATE  TABLE IF NOT EXISTS `jhard`.`solicitud` (
  `idsolicitud` INT NOT NULL AUTO_INCREMENT COMMENT 'Id correlativo unico de cada solicitud' ,
  `fecha` DATE NOT NULL COMMENT 'Fecha en la que se registro la solicitud' ,
  `prioridad` VARCHAR(25) NOT NULL COMMENT 'Tipo de prioridad en la cual se clasifican las solicitudes de mantenimiento. Sus posibles valores son: Alta, Media y Baja' ,
  `descripcion` TEXT NOT NULL COMMENT 'Descripcion de la solicitud' ,
  `idusuario` INT NOT NULL COMMENT 'Usuario que registro la solicitud' ,
  `idequipoexistente` INT NOT NULL COMMENT 'Equipo al cual se desea efectuar un mantenimiento' ,
  PRIMARY KEY (`idsolicitud`) ,
  INDEX `fkidequipoexistente_solicitud` (`idequipoexistente` ASC) ,
  INDEX `fkidequiposimple_solicitud` (`idequipoexistente` ASC) ,
  INDEX `fkidusuario_solicitud` (`idusuario` ASC) ,
  CONSTRAINT `fkidequipoexistente_solicitud`
    FOREIGN KEY (`idequipoexistente` )
    REFERENCES `jhard`.`existencia` (`idexistencia` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fkidequiposimple_solicitud`
    FOREIGN KEY (`idequipoexistente` )
    REFERENCES `jhard`.`equiposimple` (`idEquipoSimple` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fkidusuario_solicitud`
    FOREIGN KEY (`idusuario` )
    REFERENCES `jhard`.`usuario` (`idusuario` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `jhard`.`mantenimiento`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `jhard`.`mantenimiento` ;

CREATE  TABLE IF NOT EXISTS `jhard`.`mantenimiento` (
  `idmantenimiento` INT NOT NULL AUTO_INCREMENT COMMENT 'Id correlativo unico de cada mantenimiento' ,
  `fecha` DATE NOT NULL COMMENT 'Fecha en la que se efectuo el mantenimiento' ,
  `descripcion` TEXT NOT NULL COMMENT 'Descripcion del mantenimiento' ,
  `idtecnico` INT NOT NULL COMMENT 'Referencia al tecnico que efectuo el mantenimiento' ,
  `idsolicitud` INT NULL COMMENT 'Referencia a la solicitud de mantenimiento realizada, en caso de existir una' ,
  `idequipoexistente` INT NOT NULL COMMENT 'Referencia al equipo al cual se efectuo el mantenimiento' ,
  PRIMARY KEY (`idmantenimiento`) ,
  INDEX `fkidtecnico_mantenimiento` (`idtecnico` ASC) ,
  INDEX `fkidsolicitud_mantenimiento` (`idsolicitud` ASC) ,
  INDEX `fkidequipoexistente_mantenimiento` (`idequipoexistente` ASC) ,
  CONSTRAINT `fkidtecnico_mantenimiento`
    FOREIGN KEY (`idtecnico` )
    REFERENCES `jhard`.`tecnico` (`idtecnico` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fkidsolicitud_mantenimiento`
    FOREIGN KEY (`idsolicitud` )
    REFERENCES `jhard`.`solicitud` (`idsolicitud` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fkidequipoexistente_mantenimiento`
    FOREIGN KEY (`idequipoexistente` )
    REFERENCES `jhard`.`existencia` (`idexistencia` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `jhard`.`pieza`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `jhard`.`pieza` ;

CREATE  TABLE IF NOT EXISTS `jhard`.`pieza` (
  `idpieza` INT NOT NULL AUTO_INCREMENT COMMENT 'Id correlativo unico de cada pieza' ,
  `nombre` VARCHAR(100) NOT NULL COMMENT 'Nombre de la pieza' ,
  `idmarca` INT NOT NULL COMMENT 'Referencia a la marca de la pieza' ,
  `modelo` VARCHAR(15) NOT NULL COMMENT 'Modelo de la pieza' ,
  `idclasificacion` INT NOT NULL COMMENT 'Referencia a la clasificacion en la que se encuentra la pieza' ,
  `idequipo` INT NULL COMMENT 'Referencia al equipo donde se encuentra instalada la pieza (en caso de estar instalada en uno)' ,
  PRIMARY KEY (`idpieza`) ,
  INDEX `fkidclasificacion_pieza` (`idclasificacion` ASC) ,
  INDEX `fkidequipo_pieza` (`idequipo` ASC) ,
  INDEX `fkidmarca_pieza` (`idmarca` ASC) ,
  CONSTRAINT `fkidclasificacion_pieza`
    FOREIGN KEY (`idclasificacion` )
    REFERENCES `jhard`.`clasificacion` (`idclasificacion` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fkidequipo_pieza`
    FOREIGN KEY (`idequipo` )
    REFERENCES `jhard`.`equipo` (`idequipo` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fkidmarca_pieza`
    FOREIGN KEY (`idmarca` )
    REFERENCES `jhard`.`marca` (`idmarca` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `jhard`.`accesorio`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `jhard`.`accesorio` ;

CREATE  TABLE IF NOT EXISTS `jhard`.`accesorio` (
  `idaccesorio` INT NOT NULL AUTO_INCREMENT COMMENT 'Id correlativo unico de cada accesorio' ,
  `nombre` VARCHAR(100) NOT NULL COMMENT 'Nombre del accesorio' ,
  `idmarca` INT NOT NULL COMMENT 'Referencia a la marca del accesorio' ,
  `modelo` VARCHAR(15) NOT NULL COMMENT 'Modelo del accesorio' ,
  `idclasificacion` INT NOT NULL COMMENT 'Referencia a la clasificacion en la que se encuentra este accesorio' ,
  `idequipo` INT NULL COMMENT 'Referencia al equipo al que se encuentra conectado este accesorio, en caso de estar conectado a uno' ,
  PRIMARY KEY (`idaccesorio`) ,
  INDEX `fkidmarca_accesorio` (`idmarca` ASC) ,
  INDEX `fkidclasificacion_accesorio` (`idclasificacion` ASC) ,
  INDEX `fkidequipo_accesorio` (`idequipo` ASC) ,
  CONSTRAINT `fkidmarca_accesorio`
    FOREIGN KEY (`idmarca` )
    REFERENCES `jhard`.`marca` (`idmarca` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fkidclasificacion_accesorio`
    FOREIGN KEY (`idclasificacion` )
    REFERENCES `jhard`.`clasificacion` (`idclasificacion` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fkidequipo_accesorio`
    FOREIGN KEY (`idequipo` )
    REFERENCES `jhard`.`equipo` (`idequipo` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `jhard`.`atributohardware`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `jhard`.`atributohardware` ;

CREATE  TABLE IF NOT EXISTS `jhard`.`atributohardware` (
  `idatributohardware` INT NOT NULL AUTO_INCREMENT COMMENT 'Id correlativo unico del atributo de hardware' ,
  `nombre` VARCHAR(45) NOT NULL COMMENT 'Nombre del atributo' ,
  `valor` VARCHAR(45) NOT NULL COMMENT 'Valor del atributo' ,
  `unidadmedida` VARCHAR(45) NOT NULL COMMENT 'Unidad de medida del atributo' ,
  `idhardware` INT NOT NULL COMMENT 'Referencia al elemento de hardware (equipo, pieza o accesorio) al que pertenece el atributo' ,
  PRIMARY KEY (`idatributohardware`) ,
  INDEX `fkidequipo_atributohardware` (`idhardware` ASC) ,
  INDEX `fkidpieza_atributohardware` (`idhardware` ASC) ,
  INDEX `fkidaccesorio_atributohardware` (`idhardware` ASC) ,
  CONSTRAINT `fkidequipo_atributohardware`
    FOREIGN KEY (`idhardware` )
    REFERENCES `jhard`.`equipo` (`idequipo` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fkidpieza_atributohardware`
    FOREIGN KEY (`idhardware` )
    REFERENCES `jhard`.`pieza` (`idpieza` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fkidaccesorio_atributohardware`
    FOREIGN KEY (`idhardware` )
    REFERENCES `jhard`.`accesorio` (`idaccesorio` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `jhard`.`estadoreserva`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `jhard`.`estadoreserva` ;

CREATE  TABLE IF NOT EXISTS `jhard`.`estadoreserva` (
  `idestadoreserva` INT NOT NULL AUTO_INCREMENT COMMENT 'Id correlativo unico de cada reserva' ,
  `nombre` VARCHAR(100) NOT NULL COMMENT 'Nombre del estado de la reserva' ,
  PRIMARY KEY (`idestadoreserva`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `jhard`.`solicitante`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `jhard`.`solicitante` ;

CREATE  TABLE IF NOT EXISTS `jhard`.`solicitante` (
  `idsolicitante` INT NOT NULL AUTO_INCREMENT COMMENT 'Id correlativo unico de cada persona solicitante' ,
  `apellidos` VARCHAR(200) NOT NULL COMMENT 'Apellidos del solicitante' ,
  `nombres` VARCHAR(200) NOT NULL COMMENT 'Nombres del solicitante' ,
  `tipodocumento` VARCHAR(45) NOT NULL COMMENT 'Tipo de documento presentado para la solicitud' ,
  `valordocumento` VARCHAR(45) NOT NULL COMMENT 'Valor del documento presentado para la solicitud' ,
  `visible` INT NOT NULL DEFAULT 1 COMMENT 'Es 1 por defecto. Indica que el usuario esta activo. Al momento de borrar usuarios del sistema, nada mas cambiar este estado a 0.' ,
  PRIMARY KEY (`idsolicitante`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `jhard`.`responsable`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `jhard`.`responsable` ;

CREATE  TABLE IF NOT EXISTS `jhard`.`responsable` (
  `idresponsable` INT NOT NULL AUTO_INCREMENT COMMENT 'Id correlativo unico para cada responsable' ,
  `apellidos` VARCHAR(200) NOT NULL COMMENT 'Apellidos de la persona responsable' ,
  `nombres` VARCHAR(200) NOT NULL COMMENT 'Nombres de la persona responsable' ,
  `tipodocumento` VARCHAR(45) NOT NULL COMMENT 'Tipo de documento presentado para solicitar el equipo' ,
  `valordocumento` VARCHAR(45) NOT NULL COMMENT 'Valor del documento presentado para solicitar el equipo' ,
  `visible` INT NOT NULL DEFAULT 1 COMMENT 'Es 1 por defecto. Indica que el usuario esta activo. Al momento de borrar usuarios del sistema, nada mas cambiar este estado a 0.' ,
  PRIMARY KEY (`idresponsable`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `jhard`.`reserva`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `jhard`.`reserva` ;

CREATE  TABLE IF NOT EXISTS `jhard`.`reserva` (
  `idreserva` INT NOT NULL AUTO_INCREMENT COMMENT 'Id correlativo unico de cada reserva' ,
  `fechareserva` DATE NOT NULL COMMENT 'fecha en la que se reservo el equipo' ,
  `fechahorainicioprestamo` DATETIME NOT NULL COMMENT 'Fecha y hora inicial a la que se utilizara el equipo' ,
  `fechahorafinprestamo` DATETIME NOT NULL COMMENT 'Fecha y hora final a la que se utilizara el equipo' ,
  `idubicacion` INT NOT NULL COMMENT 'Referencia al aula donde se utilizara el equipo' ,
  `idequipoexistente` INT NOT NULL COMMENT 'Referencia al equipo que se utilizara' ,
  `idusuario` INT NOT NULL COMMENT 'Referencia al usuario que registro la reserva' ,
  `idestado` INT NOT NULL COMMENT 'Referencia al estado en el que se encuentra esta reserva' ,
  `descripcion` TEXT NOT NULL COMMENT 'Descripcion y justificacion de la reserva' ,
  `idsolicitante` INT NOT NULL COMMENT 'Referencia a la persona solicitante del equipo' ,
  `idresponsable` INT NOT NULL COMMENT 'Referencia al (docente)responsable del prestamo de este equipo' ,
  PRIMARY KEY (`idreserva`) ,
  INDEX `fkidestado_reserva` (`idestado` ASC) ,
  INDEX `fkidequipoexistente_reserva` (`idequipoexistente` ASC) ,
  INDEX `fkidubicacion_reserva` (`idubicacion` ASC) ,
  INDEX `fkidsolicitante_reserva` (`idsolicitante` ASC) ,
  INDEX `fkidresponsable_reserva` (`idresponsable` ASC) ,
  INDEX `fkidusuario_reserva` (`idusuario` ASC) ,
  CONSTRAINT `fkidestado_reserva`
    FOREIGN KEY (`idestado` )
    REFERENCES `jhard`.`estadoreserva` (`idestadoreserva` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fkidequipoexistente_reserva`
    FOREIGN KEY (`idequipoexistente` )
    REFERENCES `jhard`.`existencia` (`idexistencia` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fkidubicacion_reserva`
    FOREIGN KEY (`idubicacion` )
    REFERENCES `jhard`.`ubicacion` (`idubicacion` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fkidsolicitante_reserva`
    FOREIGN KEY (`idsolicitante` )
    REFERENCES `jhard`.`solicitante` (`idsolicitante` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fkidresponsable_reserva`
    FOREIGN KEY (`idresponsable` )
    REFERENCES `jhard`.`responsable` (`idresponsable` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fkidusuario_reserva`
    FOREIGN KEY (`idusuario` )
    REFERENCES `jhard`.`usuario` (`idusuario` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `jhard`.`administrador`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `jhard`.`administrador` ;

CREATE  TABLE IF NOT EXISTS `jhard`.`administrador` (
  `idadministrador` INT NOT NULL COMMENT 'Id correlativo unico de cada administrador' ,
  `clave` VARCHAR(45) NOT NULL COMMENT 'Clave del administrador' ,
  `idusuario` INT NOT NULL COMMENT 'referencia al usuario relacionado con este admnistrador' ,
  PRIMARY KEY (`idadministrador`) ,
  INDEX `fkidusuario_administrador` (`idusuario` ASC) ,
  CONSTRAINT `fkidusuario_administrador`
    FOREIGN KEY (`idusuario` )
    REFERENCES `jhard`.`usuario` (`idusuario` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `jhard`.`bitacoracambiosusuario`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `jhard`.`bitacoracambiosusuario` ;

CREATE  TABLE IF NOT EXISTS `jhard`.`bitacoracambiosusuario` (
  `idbitacora` INT NOT NULL AUTO_INCREMENT COMMENT 'Id correlativo unico de cada bitacora' ,
  `idusuario` INT NOT NULL COMMENT 'Referencia al usuario que realizo el cambio' ,
  `descripcion` TEXT NOT NULL COMMENT 'Descripcion del cambio que realizo el usuario' ,
  `fechahora` DATETIME NOT NULL COMMENT 'Fecha y hora a la que el usuario realizo el cambio' ,
  PRIMARY KEY (`idbitacora`) ,
  INDEX `fkidusuario_bitacoracambiosusuario` (`idusuario` ASC) ,
  CONSTRAINT `fkidusuario_bitacoracambiosusuario`
    FOREIGN KEY (`idusuario` )
    REFERENCES `jhard`.`usuario` (`idusuario` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;



SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
