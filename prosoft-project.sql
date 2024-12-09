/*
SQLyog Community v13.3.0 (64 bit)
MySQL - 10.4.32-MariaDB : Database - prosoft-project
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`prosoft-project` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci */;

USE `prosoft-project`;

/*Table structure for table `mesto` */

DROP TABLE IF EXISTS `mesto`;

CREATE TABLE `mesto` (
  `idMesto` bigint(20) NOT NULL AUTO_INCREMENT,
  `location` varchar(50) DEFAULT NULL,
  `zipcode` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`idMesto`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

/*Data for the table `mesto` */

insert  into `mesto`(`idMesto`,`location`,`zipcode`) values 
(1,'Beograd',11000),
(2,'Novi Beograd',11070),
(3,'Zemun',11080),
(4,'Kraljevo',36000),
(5,'Novi Sad',21000),
(6,'Nis',18000);

/*Table structure for table `narucilac_usluge` */

DROP TABLE IF EXISTS `narucilac_usluge`;

CREATE TABLE `narucilac_usluge` (
  `idNarucilacUsluge` bigint(20) NOT NULL AUTO_INCREMENT,
  `idMesto` bigint(20) NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  `lastName` varchar(50) DEFAULT NULL,
  `adress` varchar(100) DEFAULT NULL,
  `phone` varchar(13) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`idNarucilacUsluge`,`idMesto`),
  KEY `idMesto` (`idMesto`),
  CONSTRAINT `narucilac_usluge_ibfk_1` FOREIGN KEY (`idMesto`) REFERENCES `mesto` (`idMesto`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

/*Data for the table `narucilac_usluge` */

insert  into `narucilac_usluge`(`idNarucilacUsluge`,`idMesto`,`name`,`lastName`,`adress`,`phone`,`email`) values 
(1,3,'Marko','Ciric','Klare Cetkin 3','0692697586','marko@gmail.com'),
(2,2,'Ana','Anic','anaadresa','+381691234567','ana@gmail.com');

/*Table structure for table `otpremnica` */

DROP TABLE IF EXISTS `otpremnica`;

CREATE TABLE `otpremnica` (
  `idOtpremnica` bigint(20) NOT NULL AUTO_INCREMENT,
  `idVozac` bigint(20) NOT NULL,
  `idNarucilacUsluge` bigint(20) NOT NULL,
  `date` date DEFAULT NULL,
  `stavkaOtpremnice` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`idOtpremnica`,`idVozac`,`idNarucilacUsluge`),
  KEY `idVozac` (`idVozac`),
  KEY `idNarucilacUsluge` (`idNarucilacUsluge`),
  KEY `stavkaOtpremnice` (`stavkaOtpremnice`),
  CONSTRAINT `otpremnica_ibfk_1` FOREIGN KEY (`idVozac`) REFERENCES `vozac` (`idVozac`),
  CONSTRAINT `otpremnica_ibfk_2` FOREIGN KEY (`idNarucilacUsluge`) REFERENCES `narucilac_usluge` (`idNarucilacUsluge`),
  CONSTRAINT `otpremnica_ibfk_3` FOREIGN KEY (`stavkaOtpremnice`) REFERENCES `stavka_otpremnice` (`idOtpremnica`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

/*Data for the table `otpremnica` */

insert  into `otpremnica`(`idOtpremnica`,`idVozac`,`idNarucilacUsluge`,`date`,`stavkaOtpremnice`) values 
(1,3,1,'2024-12-18',NULL),
(2,12,2,'2024-12-24',NULL);

/*Table structure for table `roba` */

DROP TABLE IF EXISTS `roba`;

CREATE TABLE `roba` (
  `idRoba` bigint(20) NOT NULL AUTO_INCREMENT,
  `nameRoba` varchar(50) DEFAULT NULL,
  `qty` double DEFAULT NULL,
  PRIMARY KEY (`idRoba`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

/*Data for the table `roba` */

insert  into `roba`(`idRoba`,`nameRoba`,`qty`) values 
(1,'Troska',546400),
(2,'Šljunak',94120),
(3,'Gips',630000),
(4,'Beton',122231.15),
(5,'Armatura',45845.21);

/*Table structure for table `stavka_otpremnice` */

DROP TABLE IF EXISTS `stavka_otpremnice`;

CREATE TABLE `stavka_otpremnice` (
  `idOtpremnica` bigint(20) NOT NULL,
  `rb` bigint(20) NOT NULL AUTO_INCREMENT,
  `idRoba` bigint(20) NOT NULL,
  `nameStavka` varchar(100) DEFAULT NULL,
  `qtyStavka` double DEFAULT NULL,
  `priceStavka` double DEFAULT NULL,
  PRIMARY KEY (`idOtpremnica`,`rb`,`idRoba`),
  KEY `rb` (`rb`),
  KEY `idRoba` (`idRoba`),
  CONSTRAINT `stavka_otpremnice_ibfk_1` FOREIGN KEY (`idOtpremnica`) REFERENCES `otpremnica` (`idOtpremnica`),
  CONSTRAINT `stavka_otpremnice_ibfk_2` FOREIGN KEY (`idRoba`) REFERENCES `roba` (`idRoba`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

/*Data for the table `stavka_otpremnice` */

/*Table structure for table `vozac` */

DROP TABLE IF EXISTS `vozac`;

CREATE TABLE `vozac` (
  `idVozac` bigint(20) NOT NULL AUTO_INCREMENT,
  `nameVozac` varchar(50) DEFAULT NULL,
  `lastNameVozac` varchar(50) DEFAULT NULL,
  `phoneNumber` varchar(13) DEFAULT NULL,
  `mail` varchar(100) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`idVozac`)
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

/*Data for the table `vozac` */

insert  into `vozac`(`idVozac`,`nameVozac`,`lastNameVozac`,`phoneNumber`,`mail`,`password`) values 
(1,'Marko','Ciric','0691234567','marko@gmail.com','marko'),
(2,'Ana','Stojanovic','069876543','ana@gmail.com','ana'),
(3,'Dusan','Bjelogrlic','+38163333333','dusan@gmail.com','dusan'),
(10,'Nikola','Nikolic','0696749303','nikola@nikola.com','nikola'),
(12,'Marko','Markovic','+38162141232','mm@gmail.com','kerefeka'),
(19,'Zika','Zikic','+38169254575','zika@gmail.com','zika'),
(32,'Marko','Markobic','069123456','mdsad@dasd.vasd','sadsad'),
(35,'Marko','Ciric','0677258369','ciric.m2002@gmail.com','markicparkic'),
(40,'Ana','Stojanovic','+381605505058','ana.stojanovic003@gmail.com','ananana'),
(41,'Katarina','Ciric','0652697586','cirickatarina004@gmail.com','buca2004');

/*Table structure for table `vrsta_vozaca` */

DROP TABLE IF EXISTS `vrsta_vozaca`;

CREATE TABLE `vrsta_vozaca` (
  `idVrstaVozaca` bigint(20) NOT NULL AUTO_INCREMENT,
  `driverLicence` varchar(50) DEFAULT NULL,
  `vehicle` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`idVrstaVozaca`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

/*Data for the table `vrsta_vozaca` */

insert  into `vrsta_vozaca`(`idVrstaVozaca`,`driverLicence`,`vehicle`) values 
(1,'B','auto'),
(2,'B','kombi'),
(3,'C ','kamion'),
(4,'avioDozvola','avion'),
(6,'D','autobus');

/*Table structure for table `vzvv` */

DROP TABLE IF EXISTS `vzvv`;

CREATE TABLE `vzvv` (
  `idVozac` bigint(20) NOT NULL,
  `idVrstaVozaca` bigint(20) NOT NULL,
  `expireDateLicence` date DEFAULT NULL,
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`idVozac`,`idVrstaVozaca`,`id`),
  KEY `idVrstaVozaca` (`idVrstaVozaca`),
  KEY `id` (`id`),
  CONSTRAINT `vzvv_ibfk_1` FOREIGN KEY (`idVozac`) REFERENCES `vozac` (`idVozac`),
  CONSTRAINT `vzvv_ibfk_2` FOREIGN KEY (`idVrstaVozaca`) REFERENCES `vrsta_vozaca` (`idVrstaVozaca`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

/*Data for the table `vzvv` */

insert  into `vzvv`(`idVozac`,`idVrstaVozaca`,`expireDateLicence`,`id`) values 
(1,1,'2025-07-10',1),
(1,3,'2032-10-12',10),
(1,4,'2024-12-12',11),
(3,1,'2030-10-18',2),
(3,2,'2028-05-02',3),
(10,3,'2029-01-02',4),
(12,4,'2028-05-18',5),
(40,1,'2030-11-29',6),
(40,4,'2030-07-10',7);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
