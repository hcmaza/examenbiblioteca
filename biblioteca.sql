/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 5.6.32-log : Database - biblioteca
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`biblioteca` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `biblioteca`;

/*Table structure for table `libro` */

DROP TABLE IF EXISTS `libro`;

CREATE TABLE `libro` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `titulo` varchar(60) DEFAULT NULL,
  `cantidadpaginas` int(11) DEFAULT NULL,
  `fechapublicacion` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Data for the table `libro` */

insert  into `libro`(`id`,`titulo`,`cantidadpaginas`,`fechapublicacion`) values (1,'SpringBoot',1000,'2018-11-05'),(2,'Ionic',700,'2018-07-02'),(3,'El Principito',200,'2018-03-05');

/*Table structure for table `persona` */

DROP TABLE IF EXISTS `persona`;

CREATE TABLE `persona` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `apellido` varchar(30) DEFAULT NULL,
  `nombre` varchar(60) DEFAULT NULL,
  `direccion` varchar(80) DEFAULT NULL,
  `telefono` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `persona` */

insert  into `persona`(`id`,`apellido`,`nombre`,`direccion`,`telefono`) values (1,'Perez','Juan','9 de Julio','351878787'),(2,'Mercado','Jose','San Martin','34527899');

/*Table structure for table `prestamo` */

DROP TABLE IF EXISTS `prestamo`;

CREATE TABLE `prestamo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `fechainicio` datetime DEFAULT NULL,
  `fechafin` datetime DEFAULT NULL,
  `personaid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `personaid` (`personaid`),
  CONSTRAINT `prestamo_ibfk_1` FOREIGN KEY (`personaid`) REFERENCES `persona` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `prestamo` */

insert  into `prestamo`(`id`,`fechainicio`,`fechafin`,`personaid`) values (1,'2019-09-09 19:19:00',NULL,1),(2,'2019-09-17 19:19:15',NULL,1),(3,'2019-09-18 19:19:31',NULL,2);

/*Table structure for table `prestamoxlibro` */

DROP TABLE IF EXISTS `prestamoxlibro`;

CREATE TABLE `prestamoxlibro` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `libroid` int(11) DEFAULT NULL,
  `prestamoid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `libroid` (`libroid`),
  KEY `prestamoid` (`prestamoid`),
  CONSTRAINT `prestamoxlibro_ibfk_1` FOREIGN KEY (`libroid`) REFERENCES `libro` (`id`),
  CONSTRAINT `prestamoxlibro_ibfk_2` FOREIGN KEY (`prestamoid`) REFERENCES `prestamo` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `prestamoxlibro` */

insert  into `prestamoxlibro`(`id`,`libroid`,`prestamoid`) values (1,1,1),(2,1,2),(3,2,2);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
