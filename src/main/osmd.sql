-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.1.43-community


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema arth_osmd
--

CREATE DATABASE IF NOT EXISTS arth_osmd;
USE arth_osmd;

--
-- Definition of table `apartments`
--

DROP TABLE IF EXISTS `apartments`;
CREATE TABLE `apartments` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Active` tinyint(1) NOT NULL,
  `HouseID` int(11) NOT NULL,
  `ApartNum` smallint(6) NOT NULL,
  `SupervisorId` int(11) DEFAULT NULL,
  `TotalArea` decimal(5,2) DEFAULT NULL,
  `HeatedArea` decimal(5,2) DEFAULT NULL,
  `UsefulArea` decimal(5,2) DEFAULT NULL,
  `Privacy` tinyint(1) DEFAULT NULL,
  `CellPhone` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL,
  `RegTenantsQty` tinyint(3) unsigned DEFAULT NULL,
  `ActTenantsQty` tinyint(3) unsigned DEFAULT NULL,
  `ResidentialFund` tinyint(1) DEFAULT NULL,
  `Remark` longtext COLLATE utf8_unicode_ci,
  `LastUpdate` date NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_Apartments_Houses` (`HouseID`),
  KEY `FK_apartments_People` (`SupervisorId`),
  CONSTRAINT `FK_apartments_People` FOREIGN KEY (`SupervisorId`) REFERENCES `people` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_Apartments_Houses` FOREIGN KEY (`HouseID`) REFERENCES `houses` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `apartments`
--

/*!40000 ALTER TABLE `apartments` DISABLE KEYS */;
INSERT INTO `apartments` (`ID`,`Active`,`HouseID`,`ApartNum`,`SupervisorId`,`TotalArea`,`HeatedArea`,`UsefulArea`,`Privacy`,`CellPhone`,`RegTenantsQty`,`ActTenantsQty`,`ResidentialFund`,`Remark`,`LastUpdate`) VALUES 
 (1,1,3,43,0,'125.54','115.24','97.57',1,'0487662454',3,2,1,'Каммент','2017-09-18'),
 (8,1,3,43,0,'125.54','115.24','97.57',1,'0487662454',3,2,1,'Каммент','2017-09-18'),
 (9,1,3,43,0,'125.54','115.24','97.57',1,'0487662454',3,2,1,'Каммент','2017-09-18'),
 (11,1,3,43,0,'125.54','115.24','97.57',1,'0487662454',3,2,1,'Каммент','2017-09-18');
/*!40000 ALTER TABLE `apartments` ENABLE KEYS */;


--
-- Definition of table `benefits`
--

DROP TABLE IF EXISTS `benefits`;
CREATE TABLE `benefits` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Active` tinyint(1) NOT NULL,
  `TypeID` int(11) NOT NULL,
  `PeopleID` int(11) NOT NULL,
  `BenefitPercent` decimal(5,2) DEFAULT NULL,
  `ServiceID` int(11) DEFAULT NULL,
  `Name` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `Remark` longtext COLLATE utf8_unicode_ci,
  `LastUpdate` date NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_Benefits_BenefitsTypes` (`TypeID`),
  KEY `FK_Benefits_Services` (`ServiceID`),
  KEY `FK_Benefits_People` (`PeopleID`),
  CONSTRAINT `FK_Benefits_BenefitsTypes` FOREIGN KEY (`TypeID`) REFERENCES `benefitstypes` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_Benefits_People` FOREIGN KEY (`PeopleID`) REFERENCES `people` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_Benefits_Services` FOREIGN KEY (`ServiceID`) REFERENCES `services` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `benefits`
--

/*!40000 ALTER TABLE `benefits` DISABLE KEYS */;
INSERT INTO `benefits` (`ID`,`Active`,`TypeID`,`PeopleID`,`BenefitPercent`,`ServiceID`,`Name`,`Remark`,`LastUpdate`) VALUES 
 (0,0,0,0,'0.00',0,'Default','Default','2017-09-17'),
 (3,1,0,0,'54.21',0,'name','Remark','2017-09-18'),
 (4,1,0,0,'54.21',0,'name','Remark','2017-09-19'),
 (6,1,0,0,'54.21',0,'name','Remark','2017-09-18'),
 (7,1,0,0,'54.21',0,'name','Remark','2017-09-19'),
 (8,1,0,0,'54.21',0,'name','Remark','2017-09-19'),
 (9,1,0,0,'54.21',0,'name','Remark','2017-09-19');
/*!40000 ALTER TABLE `benefits` ENABLE KEYS */;


--
-- Definition of table `benefitstypes`
--

DROP TABLE IF EXISTS `benefitstypes`;
CREATE TABLE `benefitstypes` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Active` tinyint(1) NOT NULL,
  `Name` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `Remark` longtext COLLATE utf8_unicode_ci,
  `LastUpdate` date NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `benefitstypes`
--

/*!40000 ALTER TABLE `benefitstypes` DISABLE KEYS */;
INSERT INTO `benefitstypes` (`ID`,`Active`,`Name`,`Remark`,`LastUpdate`) VALUES 
 (0,0,'Default',NULL,'2017-09-17'),
 (1,1,'Льгота','акт','2017-09-20'),
 (2,1,'Субсидия','акт','2017-09-18'),
 (4,1,'Льгота','акт','2017-09-20');
/*!40000 ALTER TABLE `benefitstypes` ENABLE KEYS */;


--
-- Definition of table `companyinfo`
--

DROP TABLE IF EXISTS `companyinfo`;
CREATE TABLE `companyinfo` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Active` tinyint(1) NOT NULL,
  `Name` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `Address` longtext COLLATE utf8_unicode_ci,
  `Phone` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL,
  `Email` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `ManagerID` int(11) NOT NULL,
  `TaxIdNum` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL,
  `TaxNum` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `BankCode` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL,
  `BankName` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `AccountNum` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `Remark` longtext COLLATE utf8_unicode_ci,
  `LastUpdate` date NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_CompanyInfo_People` (`ManagerID`),
  CONSTRAINT `FK_CompanyInfo_People` FOREIGN KEY (`ManagerID`) REFERENCES `people` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `companyinfo`
--

/*!40000 ALTER TABLE `companyinfo` DISABLE KEYS */;
/*!40000 ALTER TABLE `companyinfo` ENABLE KEYS */;


--
-- Definition of table `dimensions`
--

DROP TABLE IF EXISTS `dimensions`;
CREATE TABLE `dimensions` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Active` tinyint(1) NOT NULL,
  `Name` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `Remark` longtext COLLATE utf8_unicode_ci,
  `LastUpdate` date NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `dimensions`
--

/*!40000 ALTER TABLE `dimensions` DISABLE KEYS */;
INSERT INTO `dimensions` (`ID`,`Active`,`Name`,`Remark`,`LastUpdate`) VALUES 
 (0,0,'Default',NULL,'2017-09-17');
/*!40000 ALTER TABLE `dimensions` ENABLE KEYS */;


--
-- Definition of table `employees`
--

DROP TABLE IF EXISTS `employees`;
CREATE TABLE `employees` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Active` tinyint(1) NOT NULL,
  `PeopleID` int(11) DEFAULT NULL,
  `PositionID` int(11) NOT NULL,
  `HireDate` date DEFAULT NULL,
  `FireDate` date DEFAULT NULL,
  `Salary` decimal(5,2) DEFAULT NULL,
  `Remark` longtext COLLATE utf8_unicode_ci,
  `LastUpdate` date NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_Employees_Positions` (`PositionID`),
  KEY `FK_Employees_People` (`PeopleID`),
  CONSTRAINT `FK_Employees_People` FOREIGN KEY (`PeopleID`) REFERENCES `people` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_Employees_Positions` FOREIGN KEY (`PositionID`) REFERENCES `positions` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `employees`
--

/*!40000 ALTER TABLE `employees` DISABLE KEYS */;
/*!40000 ALTER TABLE `employees` ENABLE KEYS */;


--
-- Definition of table `houses`
--

DROP TABLE IF EXISTS `houses`;
CREATE TABLE `houses` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Active` tinyint(1) NOT NULL,
  `Address` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `Year` smallint(6) DEFAULT NULL,
  `QtyOfStoreys` smallint(6) DEFAULT NULL,
  `QtyOfAllApart` smallint(6) DEFAULT NULL,
  `TotalArea` decimal(10,2) DEFAULT NULL,
  `AreaOfAllApart` decimal(10,2) DEFAULT NULL,
  `Remark` longtext COLLATE utf8_unicode_ci,
  `LastUpdate` date NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `houses`
--

/*!40000 ALTER TABLE `houses` DISABLE KEYS */;
INSERT INTO `houses` (`ID`,`Active`,`Address`,`Year`,`QtyOfStoreys`,`QtyOfAllApart`,`TotalArea`,`AreaOfAllApart`,`Remark`,`LastUpdate`) VALUES 
 (3,1,'Варненская,5/3',1970,5,70,'4587.23','3495.65','Комментарий','2017-09-12'),
 (4,0,'Терешковой,2/3',1969,5,70,'4454.23','3542.32','Каммент 2','2017-09-13'),
 (5,1,'Варненская,5/3',1970,5,70,'4587.23','3495.65','Комментарий','2017-09-12'),
 (6,0,'Варненская,2/3',1969,5,70,'4454.23','3542.32','Каммент 2','2017-09-18'),
 (11,0,'Терешковой,2/3',1969,5,70,'4454.23','3542.32','Каммент 2','2017-09-13'),
 (12,1,'kOSOMOVATOV,23',1968,5,90,'6548.11','5821.54','REMAAAAAAAARK','2017-09-05'),
 (13,1,'Варненская,,5/3',1970,5,70,'4587.23','3495.65','Каммммммент 3','2017-09-14'),
 (14,1,'??????????,5/3',1970,5,70,'4587.23','3495.65','???????????','2017-09-24'),
 (15,1,'Варненская,5/3',1970,5,70,'4587.23','3495.65','Комментарий','2017-09-14'),
 (17,1,'Варненская,5/3',1970,5,70,'4587.23','3495.65','Комментарий','2017-09-14'),
 (18,1,'Варненская,5/3',1970,5,70,'4587.23','3495.65','Комментарий','2017-09-14'),
 (19,1,'Терешковой,2/3',1969,5,70,'4454.23','3542.32','Каммент 2','2017-09-18'),
 (22,1,'Варненская,5/3',1970,5,70,'4587.23','3495.65','Комментарий','2017-09-24'),
 (23,1,'Варненская,5/3',1970,5,70,'4587.23','3495.65','Комментарий','2017-09-24'),
 (24,1,'Варненская,5/3',1970,5,70,'4587.23','3495.65','Комментарий','2017-09-24'),
 (25,1,'Варненская,5/3',1970,5,70,'4587.23','3495.65','Комментарий','2017-09-24');
/*!40000 ALTER TABLE `houses` ENABLE KEYS */;


--
-- Definition of table `owndocuments`
--

DROP TABLE IF EXISTS `owndocuments`;
CREATE TABLE `owndocuments` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Active` tinyint(1) NOT NULL,
  `Name` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `Number` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `StartDate` date NOT NULL,
  `Remark` longtext COLLATE utf8_unicode_ci,
  `LastUpdate` date NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `owndocuments`
--

/*!40000 ALTER TABLE `owndocuments` DISABLE KEYS */;
/*!40000 ALTER TABLE `owndocuments` ENABLE KEYS */;


--
-- Definition of table `owners`
--

DROP TABLE IF EXISTS `owners`;
CREATE TABLE `owners` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Active` tinyint(1) NOT NULL,
  `PeopleID` int(11) NOT NULL,
  `OwnApartID` int(11) NOT NULL,
  `OwnPart` tinyint(3) unsigned DEFAULT NULL,
  `OwnDocID` int(11) DEFAULT NULL,
  `Senior` tinyint(1) DEFAULT NULL,
  `Remark` longtext COLLATE utf8_unicode_ci,
  `LastUpdate` date NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_Owners_Apartments` (`OwnApartID`),
  KEY `FK_Owners_OwnDocuments` (`OwnDocID`),
  KEY `FK_Owners_People` (`PeopleID`),
  CONSTRAINT `FK_Owners_Apartments` FOREIGN KEY (`OwnApartID`) REFERENCES `apartments` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_Owners_OwnDocuments` FOREIGN KEY (`OwnDocID`) REFERENCES `owndocuments` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_Owners_People` FOREIGN KEY (`PeopleID`) REFERENCES `people` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `owners`
--

/*!40000 ALTER TABLE `owners` DISABLE KEYS */;
/*!40000 ALTER TABLE `owners` ENABLE KEYS */;


--
-- Definition of table `people`
--

DROP TABLE IF EXISTS `people`;
CREATE TABLE `people` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Active` tinyint(1) NOT NULL,
  `FirstName` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `LastName` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `Patronymic` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `ResidApartID` int(11) DEFAULT NULL,
  `RegApartID` int(11) DEFAULT NULL,
  `BithDate` date DEFAULT NULL,
  `Phone` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `TaxNum` char(10) COLLATE utf8_unicode_ci DEFAULT NULL,
  `PassportSeries` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL,
  `PassportNum` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `IssuedBy` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `IssuedDate` date DEFAULT NULL,
  `Remark` longtext COLLATE utf8_unicode_ci,
  `LastUpdate` date NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_People_Apartments` (`RegApartID`),
  KEY `FK_People_Apartments1` (`ResidApartID`),
  CONSTRAINT `FK_People_Apartments` FOREIGN KEY (`RegApartID`) REFERENCES `apartments` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_People_Apartments1` FOREIGN KEY (`ResidApartID`) REFERENCES `apartments` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `people`
--

/*!40000 ALTER TABLE `people` DISABLE KEYS */;
INSERT INTO `people` (`ID`,`Active`,`FirstName`,`LastName`,`Patronymic`,`ResidApartID`,`RegApartID`,`BithDate`,`Phone`,`TaxNum`,`PassportSeries`,`PassportNum`,`IssuedBy`,`IssuedDate`,`Remark`,`LastUpdate`) VALUES 
 (0,0,'Defailt','Default',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2017-09-17');
/*!40000 ALTER TABLE `people` ENABLE KEYS */;


--
-- Definition of table `positions`
--

DROP TABLE IF EXISTS `positions`;
CREATE TABLE `positions` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `IsPaid` tinyint(1) DEFAULT NULL,
  `IsStated` tinyint(1) DEFAULT NULL,
  `Remark` longtext COLLATE utf8_unicode_ci,
  `LastUpdate` date NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `positions`
--

/*!40000 ALTER TABLE `positions` DISABLE KEYS */;
/*!40000 ALTER TABLE `positions` ENABLE KEYS */;


--
-- Definition of table `services`
--

DROP TABLE IF EXISTS `services`;
CREATE TABLE `services` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Active` tinyint(1) NOT NULL,
  `Name` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `Price` decimal(5,2) NOT NULL,
  `DimensionID` int(11) NOT NULL,
  `Remark` longtext COLLATE utf8_unicode_ci,
  `LastUpdate` date NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_Services_Dimensions` (`DimensionID`),
  CONSTRAINT `FK_Services_Dimensions` FOREIGN KEY (`DimensionID`) REFERENCES `dimensions` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `services`
--

/*!40000 ALTER TABLE `services` DISABLE KEYS */;
INSERT INTO `services` (`ID`,`Active`,`Name`,`Price`,`DimensionID`,`Remark`,`LastUpdate`) VALUES 
 (0,0,'Default','0.00',0,NULL,'2017-09-17'),
 (1,1,'Воздух','54.87',0,'Каммент','2017-09-18'),
 (2,1,'Вода','158.87',0,'павпапкепрк','2017-09-20');
/*!40000 ALTER TABLE `services` ENABLE KEYS */;


--
-- Definition of table `users`
--

DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Active` tinyint(1) NOT NULL,
  `Login` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `Password` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `PeopleID` int(11) DEFAULT NULL,
  `Remark` longtext COLLATE utf8_unicode_ci,
  `LastUpdate` date NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_Users_People` (`PeopleID`),
  CONSTRAINT `FK_Users_People` FOREIGN KEY (`PeopleID`) REFERENCES `people` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `users`
--

/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` (`ID`,`Active`,`Login`,`Password`,`PeopleID`,`Remark`,`LastUpdate`) VALUES 
 (0,0,'Default','Default',0,'','2017-09-17'),
 (1,1,'Arthur','1111',0,'dfregre','2017-09-19'),
 (9,1,'Arthur','1111',0,'dfregre','2017-09-22'),
 (10,1,'Arthur','1111',0,'dfregre','2017-09-22'),
 (11,1,'Arthur','1111',0,'dfregre','2017-09-22'),
 (12,1,'Arthur','1111',0,'dfregre','2017-09-22'),
 (13,1,'Arthur','1111',0,'dfregre','2017-09-22'),
 (14,1,'Arthur','1111',0,'dfregre','2017-09-22'),
 (15,1,'Arthur','1111',0,'dfregre','2017-09-22'),
 (16,1,'Arthur','1111',0,'dfregre','2017-09-22'),
 (17,1,'Arthur','1111',0,'dfregre','2017-09-22');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
