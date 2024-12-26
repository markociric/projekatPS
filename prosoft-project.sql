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
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

/*Data for the table `narucilac_usluge` */

insert  into `narucilac_usluge`(`idNarucilacUsluge`,`idMesto`,`name`,`lastName`,`adress`,`phone`,`email`) values 
(1,4,'Marko','Ciric','Klare Cetkin 3','0692697586','marko@gmail.com'),
(2,5,'Ana','Stojanovic','anaadresaad','+381651234567','ana@gmail.com'),
(3,3,'Isidora','Vrhovac','Negde u Zemunu','+381696969699','isidora@gmail.com'),
(5,2,'Katarina','Ciric','Klada','+381654849654','buca@gmail.com'),
(10,1,'Marko','Markoic','AA','+381654654654','marko@fas.da'),
(13,6,'Anastasija','Jovanovic','Miljakovac','+38165656565','anastasija@gmail.com'),
(14,1,'Aa','Aa','dsad','0654654641','asda@sdad.ds'),
(15,1,'Ad','Ad','Ad','065564654','tdsts@asra.rfee'),
(16,1,'Ss','Ss','Ss','+38156465465','asd@saf.fdf');

/*Table structure for table `otpremnica` */

DROP TABLE IF EXISTS `otpremnica`;

CREATE TABLE `otpremnica` (
  `idOtpremnica` bigint(20) NOT NULL AUTO_INCREMENT,
  `idVozac` bigint(20) NOT NULL,
  `idNarucilacUsluge` bigint(20) NOT NULL,
  `date` date DEFAULT NULL,
  PRIMARY KEY (`idOtpremnica`,`idVozac`,`idNarucilacUsluge`),
  KEY `idVozac` (`idVozac`),
  KEY `idNarucilacUsluge` (`idNarucilacUsluge`),
  CONSTRAINT `otpremnica_ibfk_1` FOREIGN KEY (`idVozac`) REFERENCES `vozac` (`idVozac`),
  CONSTRAINT `otpremnica_ibfk_2` FOREIGN KEY (`idNarucilacUsluge`) REFERENCES `narucilac_usluge` (`idNarucilacUsluge`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

/*Data for the table `otpremnica` */

insert  into `otpremnica`(`idOtpremnica`,`idVozac`,`idNarucilacUsluge`,`date`) values 
(1,12,1,'2024-12-18'),
(2,32,2,'2024-12-24'),
(12,1,10,'2024-12-17'),
(15,12,13,'2024-12-24');

/*Table structure for table `roba` */

DROP TABLE IF EXISTS `roba`;

CREATE TABLE `roba` (
  `idRoba` bigint(20) NOT NULL AUTO_INCREMENT,
  `nameRoba` varchar(50) DEFAULT NULL,
  `qty` double DEFAULT NULL,
  `unitOfMeasure` varchar(50) DEFAULT NULL,
  `price` double DEFAULT NULL,
  PRIMARY KEY (`idRoba`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

/*Data for the table `roba` */

insert  into `roba`(`idRoba`,`nameRoba`,`qty`,`unitOfMeasure`,`price`) values 
(1,'Troska',3902,'t',24.235),
(2,'Šljunak',1627.56,'t',45.264),
(3,'Gips',6850,'t',38),
(4,'Beton',10059.15,'t',77),
(5,'Armatura',4507.21,'m^3',32.01),
(11,'Behemot',685465,'m^3',NULL);

/*Table structure for table `stavka_otpremnice` */

DROP TABLE IF EXISTS `stavka_otpremnice`;

CREATE TABLE `stavka_otpremnice` (
  `idOtpremnica` bigint(20) NOT NULL,
  `rb` bigint(20) NOT NULL AUTO_INCREMENT,
  `idRoba` bigint(20) NOT NULL,
  `qtySO` double DEFAULT NULL,
  PRIMARY KEY (`idOtpremnica`,`rb`,`idRoba`),
  KEY `rb` (`rb`),
  KEY `idRoba` (`idRoba`),
  CONSTRAINT `stavka_otpremnice_ibfk_1` FOREIGN KEY (`idOtpremnica`) REFERENCES `otpremnica` (`idOtpremnica`) ON DELETE CASCADE,
  CONSTRAINT `stavka_otpremnice_ibfk_2` FOREIGN KEY (`idRoba`) REFERENCES `roba` (`idRoba`)
) ENGINE=InnoDB AUTO_INCREMENT=46 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

/*Data for the table `stavka_otpremnice` */

insert  into `stavka_otpremnice`(`idOtpremnica`,`rb`,`idRoba`,`qtySO`) values 
(1,1,1,78),
(1,2,3,54),
(1,20,2,1325),
(1,23,5,12),
(1,43,4,10),
(2,4,4,546.152),
(2,24,3,300),
(2,30,1,420),
(2,42,2,2),
(12,41,1,9),
(12,45,2,1),
(15,44,1,10);

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
) ENGINE=InnoDB AUTO_INCREMENT=72 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

/*Data for the table `vozac` */

insert  into `vozac`(`idVozac`,`nameVozac`,`lastNameVozac`,`phoneNumber`,`mail`,`password`) values 
(1,'Marko','Ciric','069123453','marko@gmail.com','marko'),
(3,'Dusan','Bjelogrlic','+38163333333','dusan@gmail.com','dusan'),
(10,'Nikola','Nikolic','0696749303','nikola@nikola.com','nikola'),
(12,'Marko','Markovic','+38162141232','mm@gmail.com','kerefeka'),
(19,'Zika','Zikic','+38169254575','zika@gmail.com','zika'),
(32,'Marko','Mirkovic','069123456','mdsad@dasd.vasd','sadsad'),
(40,'Ana','Stojanovic','+381605505058','ana.stojanovic003@gmail.com','ananana'),
(41,'Katarina','Ciric','0652697586','cirickatarina004@gmail.com','buca2004'),
(54,'Srećko','Tasić','+38164545665','sreckotasic@gmail.com','sreckosrecko'),
(71,'','',NULL,NULL,NULL);

/*Table structure for table `vrsta_vozaca` */

DROP TABLE IF EXISTS `vrsta_vozaca`;

CREATE TABLE `vrsta_vozaca` (
  `idVrstaVozaca` bigint(20) NOT NULL AUTO_INCREMENT,
  `driverLicence` varchar(50) DEFAULT NULL,
  `vehicle` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`idVrstaVozaca`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

/*Data for the table `vrsta_vozaca` */

insert  into `vrsta_vozaca`(`idVrstaVozaca`,`driverLicence`,`vehicle`) values 
(1,'B','auto'),
(2,'B','kombi'),
(3,'C ','kamion'),
(4,'avioDozvola','avion'),
(6,'D','autobus'),
(10,'w','tenk');

/*Table structure for table `vzvv` */

DROP TABLE IF EXISTS `vzvv`;

CREATE TABLE `vzvv` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `idVozac` bigint(20) NOT NULL,
  `idVrstaVozaca` bigint(20) NOT NULL,
  `startDateLicence` date DEFAULT NULL,
  `expireDateLicence` date DEFAULT NULL,
  PRIMARY KEY (`idVozac`,`idVrstaVozaca`,`id`),
  KEY `idVrstaVozaca` (`idVrstaVozaca`),
  KEY `id` (`id`),
  CONSTRAINT `vzvv_ibfk_1` FOREIGN KEY (`idVozac`) REFERENCES `vozac` (`idVozac`),
  CONSTRAINT `vzvv_ibfk_2` FOREIGN KEY (`idVrstaVozaca`) REFERENCES `vrsta_vozaca` (`idVrstaVozaca`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

/*Data for the table `vzvv` */

insert  into `vzvv`(`id`,`idVozac`,`idVrstaVozaca`,`startDateLicence`,`expireDateLicence`) values 
(22,1,1,'2021-12-12','2025-12-12'),
(16,1,2,'2024-12-14','2030-12-14'),
(10,1,3,'2024-05-23','2032-10-12'),
(11,1,4,'2024-12-15','2030-12-15'),
(17,1,6,'2031-12-12','2035-12-12'),
(2,3,1,'2024-05-27','2030-10-18'),
(3,3,2,'2022-12-15','2028-05-02'),
(4,10,3,'2008-09-26','2029-01-02'),
(5,12,4,'2023-10-28','2028-05-18'),
(6,40,1,'2019-06-29','2030-11-29'),
(7,40,4,'2015-11-20','2030-07-10');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
