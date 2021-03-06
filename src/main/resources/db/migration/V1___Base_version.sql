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
  `TotalArea` decimal(7,2) DEFAULT NULL,
  `HeatedArea` decimal(7,2) DEFAULT NULL,
  `UsefulArea` decimal(7,2) DEFAULT NULL,
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
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `apartments`
--

/*!40000 ALTER TABLE `apartments` DISABLE KEYS */;
INSERT INTO `apartments` (`ID`,`Active`,`HouseID`,`ApartNum`,`SupervisorId`,`TotalArea`,`HeatedArea`,`UsefulArea`,`Privacy`,`CellPhone`,`RegTenantsQty`,`ActTenantsQty`,`ResidentialFund`,`Remark`,`LastUpdate`) VALUES 
 (0,0,0,0,0,'0.00','0.00','0.00',0,'0',0,0,0,'0','2017-09-17'),
 (1,1,3,43,0,'125.54','115.24','97.57',1,'0487662454',3,2,1,'Каммент','2017-09-18'),
 (2,1,1,43,0,'125.54','115.24','97.57',1,'0487662454',3,2,1,'Каммент','2017-09-26'),
 (3,1,5,43,0,'125.54','115.24','97.57',1,'0487662454',3,2,1,'Каммент','2017-09-18'),
 (4,1,2,43,0,'125.54','115.24','97.57',1,'0487662454',3,2,1,'Каммент','2017-09-18'),
 (5,1,3,43,0,'125.54','115.24','97.57',1,'0487662454',3,2,1,'Каммент','2017-09-26');
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
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `benefits`
--

/*!40000 ALTER TABLE `benefits` DISABLE KEYS */;
INSERT INTO `benefits` (`ID`,`Active`,`TypeID`,`PeopleID`,`BenefitPercent`,`ServiceID`,`Name`,`Remark`,`LastUpdate`) VALUES
 (0,0,0,0,'0.00',0,'Default','Default','1970-01-01'),
 (3,1,0,0,'54.21',0,'name','Remark','2017-09-18'),
 (6,1,0,0,'54.21',0,'name','Remark','2017-09-18'),
 (7,1,0,0,'54.21',0,'name','Remark','2017-09-26'),
 (8,1,0,0,'54.21',0,'name','Remark','2017-09-19'),
 (9,1,0,0,'54.21',0,'name','Remark','2017-09-19'),
 (10,1,0,0,'54.21',0,'name','Remark','2017-09-26'),
 (11,1,0,0,'54.21',0,'name','Remark','2017-09-26'),
 (12,1,0,0,'54.21',0,'name','Remark','2017-09-26');
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
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `benefitstypes`
--

/*!40000 ALTER TABLE `benefitstypes` DISABLE KEYS */;
INSERT INTO `benefitstypes` (`ID`,`Active`,`Name`,`Remark`,`LastUpdate`) VALUES
 (0,0,'Default','Default','1970-01-01'),
 (1,1,'Льгота','акт','2017-09-20'),
 (2,1,'Субсидия','акт','2017-09-26'),
 (4,1,'Льгота','акт','2017-09-20'),
 (5,1,'Субсидия','акт','2017-09-26');
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
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `companyinfo`
--

/*!40000 ALTER TABLE `companyinfo` DISABLE KEYS */;
INSERT INTO `companyinfo` (`ID`,`Active`,`Name`,`Address`,`Phone`,`Email`,`ManagerID`,`TaxIdNum`,`TaxNum`,`BankCode`,`BankName`,`AccountNum`,`Remark`,`LastUpdate`) VALUES
 (0,0,'Default','Default','Default','Default',0,'Default','Default','0','Default','Default','Default','1970-01-01'),
 (1,1,'Наше ОСМД','Враненская,5/3','0677004016','osmd@ukr.net',0,'1234567890','242342534','3545475','АТ Ощадбанк','26003453453534','Комментарий','2017-09-26'),
 (3,1,'Наше ОСМД','Враненская,5/3','0677004016','osmd@ukr.net',0,'1234567890','242342534','3545475','АТ Ощадбанк','26003453453534','Комментарий','2017-09-26'),
 (4,1,'Наше ОСМД','Враненская,5/3','0677004016','osmd@ukr.net',0,'1234567890','242342534','3545475','АТ Ощадбанк','26003453453534','Комментарий','2017-09-26');
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
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `dimensions`
--

/*!40000 ALTER TABLE `dimensions` DISABLE KEYS */;
INSERT INTO `dimensions` (`ID`,`Active`,`Name`,`Remark`,`LastUpdate`) VALUES
 (0,0,'Default','Default','1970-01-01'),
 (1,1,'Конь/м2','Каммент','2017-09-26'),
 (2,1,'Конь/м2','Каммент','2017-09-26'),
 (3,1,'Конь/м2','Каммент','2017-09-26');
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
  `Salary` decimal(7,2) DEFAULT NULL,
  `Remark` longtext COLLATE utf8_unicode_ci,
  `LastUpdate` date NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_Employees_Positions` (`PositionID`),
  KEY `FK_Employees_People` (`PeopleID`),
  CONSTRAINT `FK_Employees_People` FOREIGN KEY (`PeopleID`) REFERENCES `people` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_Employees_Positions` FOREIGN KEY (`PositionID`) REFERENCES `positions` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `employees`
--

/*!40000 ALTER TABLE `employees` DISABLE KEYS */;
INSERT INTO `employees` (`ID`,`Active`,`PeopleID`,`PositionID`,`HireDate`,`FireDate`,`Salary`,`Remark`,`LastUpdate`) VALUES
 (0,0,0,0,'1970-01-01','1970-01-01','0.00','Default','2017-09-26'),
 (1,1,0,1,'2017-09-18',NULL,'1200.00','Каммент','2017-09-26'),
 (3,1,0,1,NULL,NULL,'1200.00','Каммент','2017-09-26'),
 (4,1,0,1,NULL,NULL,'1200.00','Каммент','2017-09-26');
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
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `houses`
--

/*!40000 ALTER TABLE `houses` DISABLE KEYS */;
INSERT INTO `houses` (`ID`,`Active`,`Address`,`Year`,`QtyOfStoreys`,`QtyOfAllApart`,`TotalArea`,`AreaOfAllApart`,`Remark`,`LastUpdate`) VALUES
 (0,0,'Default',1970,0,0,'0.00','0.00','Default','1970-01-01'),
 (1,1,'Варненская,5/3',1970,5,70,'4587.23','3495.65','Комментарий','2017-09-28'),
 (2,1,'Варненская,5/3',1970,5,70,'4587.23','3495.65','Комментарий','2017-09-25'),
 (3,1,'Варненская,5/3',1970,5,70,'4587.23','3495.65','Комментарий','2017-09-28'),
 (4,0,'Терешковой,2/3',1969,5,70,'4454.23','3542.32','Каммент 2','2017-09-13'),
 (5,1,'Варненская,5/3',1970,5,70,'4587.23','3495.65','Комментарий','2017-09-12'),
 (6,0,'Варненская,2/3',1969,5,70,'4454.23','3542.32','Каммент 2','2017-09-18'),
 (11,0,'Терешковой,2/3',1969,5,70,'4454.23','3542.32','Каммент 2','2017-09-13'),
 (12,1,'kOSOMOVATOV,23',1968,5,90,'6548.11','5821.54','REMAAAAAAAARK','2017-09-05'),
 (13,1,'Варненская,,5/3',1970,5,70,'4587.23','3495.65','Каммммммент 3','2017-09-14'),
 (14,1,'??????????,5/3',1970,5,70,'4587.23','3495.65','???????????','2017-09-25'),
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
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `owndocuments`
--

/*!40000 ALTER TABLE `owndocuments` DISABLE KEYS */;
INSERT INTO `owndocuments` (`ID`,`Active`,`Name`,`Number`,`StartDate`,`Remark`,`LastUpdate`) VALUES
 (0,0,'Default','0','2017-09-17','Default','1970-01-01'),
 (1,1,'Свидетельство о браке','2342342','2017-09-18',NULL,'2017-09-26'),
 (2,1,'Свидетельство о браке','2342342','2017-09-18',NULL,'2017-09-26'),
 (3,1,'Свидетельство о браке','2342342','2017-09-18',NULL,'2017-09-26');
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
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `owners`
--

/*!40000 ALTER TABLE `owners` DISABLE KEYS */;
INSERT INTO `owners` (`ID`,`Active`,`PeopleID`,`OwnApartID`,`OwnPart`,`OwnDocID`,`Senior`,`Remark`,`LastUpdate`) VALUES
 (0,0,0,0,1,0,0,'Default','1970-01-01'),
 (1,1,0,0,2,0,1,'Камент','2017-09-26'),
 (3,0,0,0,1,0,0,NULL,'2017-09-17'),
 (4,0,0,0,1,0,0,NULL,'2017-09-17'),
 (5,1,0,0,2,0,1,'Камент','2017-09-26'),
 (6,1,0,0,2,0,1,'Камент','2017-09-26');
/*!40000 ALTER TABLE `owners` ENABLE KEYS */;


--
-- Definition of table `people`
--

DROP TABLE IF EXISTS `people`;
CREATE TABLE `people` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Active` tinyint(1) NOT NULL,
  `FirstName` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `LastName` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `Patronymic` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `ResidApartID` int(11) DEFAULT NULL,
  `RegApartID` int(11) DEFAULT NULL,
  `BirthDate` date DEFAULT NULL,
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
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `people`
--

/*!40000 ALTER TABLE `people` DISABLE KEYS */;
INSERT INTO `people` (`ID`,`Active`,`FirstName`,`LastName`,`Patronymic`,`ResidApartID`,`RegApartID`,`BirthDate`,`Phone`,`TaxNum`,`PassportSeries`,`PassportNum`,`IssuedBy`,`IssuedDate`,`Remark`,`LastUpdate`) VALUES
 (0,0,'Defailt','Default','Default',0,0,'1970-01-01','0','0','0','0','0','1970-01-01','0','2017-09-17'),
 (1,1,'Евсеев','Юрий','Михайлович',1,1,'1949-08-05','0679894512','1234567890','ке','694887','Красноокнянским РОВД','1998-08-11','Каммент','2017-09-28'),
 (2,1,'Евсеев','Юрий','Михайлович',1,1,'1949-08-05','0679894512','1234567890','ке','694887','Красноокнянским РОВД','1998-08-11','Каммент','2017-09-27');
/*!40000 ALTER TABLE `people` ENABLE KEYS */;


--
-- Definition of table `positions`
--

DROP TABLE IF EXISTS `positions`;
CREATE TABLE `positions` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Active` tinyint(1) NOT NULL,
  `Name` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `Paid` tinyint(1) DEFAULT NULL,
  `Stated` tinyint(1) DEFAULT NULL,
  `Remark` longtext COLLATE utf8_unicode_ci,
  `LastUpdate` date NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `positions`
--

/*!40000 ALTER TABLE `positions` DISABLE KEYS */;
INSERT INTO `positions` (`ID`,`Active`,`Name`,`Paid`,`Stated`,`Remark`,`LastUpdate`) VALUES
 (0,0,'Default',NULL,NULL,NULL,'2017-09-17'),
 (1,0,'Дворник',1,1,'Каммент','2017-09-18');
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
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `services`
--

/*!40000 ALTER TABLE `services` DISABLE KEYS */;
INSERT INTO `services` (`ID`,`Active`,`Name`,`Price`,`DimensionID`,`Remark`,`LastUpdate`) VALUES
 (0,0,'Default','0.00',0,'Default','1970-01-01'),
 (1,1,'Воздух','54.87',0,'Каммент','2017-09-18'),
 (2,1,'Вода','158.87',0,'павпапкепрк','2017-09-25'),
 (4,1,'Вода','158.87',0,'павпапкепрк','2017-09-25'),
 (5,1,'Вода','158.87',0,'павпапкепрк','2017-09-25');
/*!40000 ALTER TABLE `services` ENABLE KEYS */;


--
-- Definition of table `u_column_names`
--

DROP TABLE IF EXISTS `u_column_names`;
CREATE TABLE `u_column_names` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `TABLE_NAME` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `English` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `Russian` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `Ukranian` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=310 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `u_column_names`
--

/*!40000 ALTER TABLE `u_column_names` DISABLE KEYS */;
INSERT INTO `u_column_names` (`ID`,`TABLE_NAME`,`English`,`Russian`,`Ukranian`) VALUES
 (1,'apartments','ID','ID',NULL),
 (2,'apartments','Active','Активно',NULL),
 (3,'apartments','HouseID','Адрес',NULL),
 (4,'apartments','ApartNum','№ квартиры',NULL),
 (5,'apartments','SupervisorId','Зарегистрирована на',NULL),
 (6,'apartments','TotalArea','Общая площадь',NULL),
 (7,'apartments','HeatedArea','Отпл. площадь',NULL),
 (8,'apartments','UsefulArea','Полезная площадь',NULL),
 (9,'apartments','Privacy','Приватизирована',NULL),
 (10,'apartments','CellPhone','Городской телефон',NULL),
 (11,'apartments','RegTenantsQty','Прописано жильцов',NULL),
 (12,'apartments','ActTenantsQty','Проживает жильцов',NULL),
 (13,'apartments','ResidentialFund','Жилой фонд',NULL),
 (14,'apartments','Remark','Примечания',NULL),
 (15,'apartments','LastUpdate','Дата изменения',NULL),
 (16,'benefits','ID',NULL,NULL),
 (17,'benefits','Active',NULL,NULL),
 (18,'benefits','TypeID',NULL,NULL),
 (19,'benefits','PeopleID',NULL,NULL),
 (20,'benefits','BenefitPercent',NULL,NULL),
 (21,'benefits','ServiceID',NULL,NULL),
 (22,'benefits','Name',NULL,NULL),
 (23,'benefits','Remark',NULL,NULL),
 (24,'benefits','LastUpdate',NULL,NULL),
 (25,'benefitstypes','ID',NULL,NULL),
 (26,'benefitstypes','Active',NULL,NULL),
 (27,'benefitstypes','Name',NULL,NULL),
 (28,'benefitstypes','Remark',NULL,NULL),
 (29,'benefitstypes','LastUpdate',NULL,NULL),
 (30,'companyinfo','ID',NULL,NULL),
 (31,'companyinfo','Active',NULL,NULL),
 (32,'companyinfo','Name',NULL,NULL),
 (33,'companyinfo','Address',NULL,NULL),
 (34,'companyinfo','Phone',NULL,NULL),
 (35,'companyinfo','Email',NULL,NULL),
 (36,'companyinfo','ManagerID',NULL,NULL),
 (37,'companyinfo','TaxIdNum',NULL,NULL),
 (38,'companyinfo','TaxNum',NULL,NULL),
 (39,'companyinfo','BankCode',NULL,NULL),
 (40,'companyinfo','BankName',NULL,NULL),
 (41,'companyinfo','AccountNum',NULL,NULL),
 (42,'companyinfo','Remark',NULL,NULL),
 (43,'companyinfo','LastUpdate',NULL,NULL),
 (44,'dimensions','ID',NULL,NULL),
 (45,'dimensions','Active',NULL,NULL),
 (46,'dimensions','Name',NULL,NULL),
 (47,'dimensions','Remark',NULL,NULL),
 (48,'dimensions','LastUpdate',NULL,NULL),
 (49,'employees','ID',NULL,NULL),
 (50,'employees','Active',NULL,NULL),
 (51,'employees','PeopleID',NULL,NULL),
 (52,'employees','PositionID',NULL,NULL),
 (53,'employees','HireDate',NULL,NULL),
 (54,'employees','FireDate',NULL,NULL),
 (55,'employees','Salary',NULL,NULL),
 (56,'employees','Remark',NULL,NULL),
 (57,'employees','LastUpdate',NULL,NULL),
 (58,'houses','ID',NULL,NULL),
 (59,'houses','Active',NULL,NULL),
 (60,'houses','Address',NULL,NULL),
 (61,'houses','Year',NULL,NULL),
 (62,'houses','QtyOfStoreys',NULL,NULL),
 (63,'houses','QtyOfAllApart',NULL,NULL),
 (64,'houses','TotalArea',NULL,NULL),
 (65,'houses','AreaOfAllApart',NULL,NULL),
 (66,'houses','Remark',NULL,NULL),
 (67,'houses','LastUpdate',NULL,NULL),
 (68,'owndocuments','ID',NULL,NULL),
 (69,'owndocuments','Active',NULL,NULL),
 (70,'owndocuments','Name',NULL,NULL),
 (71,'owndocuments','Number',NULL,NULL),
 (72,'owndocuments','StartDate',NULL,NULL),
 (73,'owndocuments','Remark',NULL,NULL),
 (74,'owndocuments','LastUpdate',NULL,NULL),
 (75,'owners','ID',NULL,NULL),
 (76,'owners','Active',NULL,NULL),
 (77,'owners','PeopleID',NULL,NULL),
 (78,'owners','OwnApartID',NULL,NULL),
 (79,'owners','OwnPart',NULL,NULL),
 (80,'owners','OwnDocID',NULL,NULL),
 (81,'owners','Senior',NULL,NULL),
 (82,'owners','Remark',NULL,NULL),
 (83,'owners','LastUpdate',NULL,NULL),
 (84,'people','ID','ID',NULL),
 (85,'people','Active','Активно',NULL),
 (86,'people','FirstName','Имя',NULL),
 (87,'people','LastName','Фамилия',NULL),
 (88,'people','Patronymic','Отчество',NULL),
 (89,'people','ResidApartID','Прописан в квартире',NULL),
 (90,'people','RegApartID','Проживет в квартире',NULL),
 (91,'people','BirthDate','Дата рождения',NULL),
 (92,'people','Phone','Телефон',NULL),
 (93,'people','TaxNum','ИНН',NULL),
 (94,'people','PassportSeries','Серия паспорта',NULL),
 (95,'people','PassportNum','Номер паспорта',NULL),
 (96,'people','IssuedBy','Выдан органом',NULL),
 (97,'people','IssuedDate','Выдан дата',NULL),
 (98,'people','Remark','Примечание',NULL),
 (99,'people','LastUpdate','Дата изменения',NULL),
 (100,'positions','ID',NULL,NULL),
 (101,'positions','Active',NULL,NULL),
 (102,'positions','Name',NULL,NULL),
 (103,'positions','Paid',NULL,NULL),
 (104,'positions','Stated',NULL,NULL),
 (105,'positions','Remark',NULL,NULL),
 (106,'positions','LastUpdate',NULL,NULL),
 (107,'services','ID',NULL,NULL),
 (108,'services','Active',NULL,NULL),
 (109,'services','Name',NULL,NULL),
 (110,'services','Price',NULL,NULL),
 (111,'services','DimensionID',NULL,NULL),
 (112,'services','Remark',NULL,NULL),
 (113,'services','LastUpdate',NULL,NULL),
 (114,'users','ID',NULL,NULL),
 (115,'users','Active',NULL,NULL),
 (116,'users','Login',NULL,NULL),
 (117,'users','Password',NULL,NULL),
 (118,'users','PeopleID',NULL,NULL),
 (119,'users','AccessLevel',NULL,NULL),
 (120,'users','Remark',NULL,NULL),
 (121,'users','LastUpdate',NULL,NULL);
/*!40000 ALTER TABLE `u_column_names` ENABLE KEYS */;


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
  `AccessLevel` tinyint(1) NOT NULL,
  `Remark` longtext COLLATE utf8_unicode_ci,
  `LastUpdate` date NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_Users_People` (`PeopleID`),
  CONSTRAINT `FK_Users_People` FOREIGN KEY (`PeopleID`) REFERENCES `people` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `users`
--

/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` (`ID`,`Active`,`Login`,`Password`,`PeopleID`,`AccessLevel`,`Remark`,`LastUpdate`) VALUES
 (0,0,'Default','Default',0,0,'Default','1970-01-01'),
 (1,1,'Arthur','1111',0,0,'dfregre','2017-09-19'),
 (9,1,'Arthur','1111',0,0,'dfregre','2017-09-25'),
 (10,1,'Arthur','1111',0,0,'dfregre','2017-09-22'),
 (11,1,'Arthur','1111',0,0,'dfregre','2017-09-22'),
 (12,1,'Arthur','1111',0,0,'dfregre','2017-09-22'),
 (14,1,'Arthur','1111',0,0,'dfregre','2017-09-22'),
 (15,1,'Arthur','1111',0,0,'dfregre','2017-09-22'),
 (16,1,'Arthur','1111',0,0,'dfregre','2017-09-22'),
 (17,1,'Arthur','1111',0,0,'dfregre','2017-09-22'),
 (18,1,'Arthur','1111',0,0,'dfregre','2017-09-25'),
 (19,1,'Arthur','1111',0,0,'dfregre','2017-09-25'),
 (20,1,'Arthur','1111',0,0,'dfregre','2017-09-25'),
 (21,1,'Arthur','1111',0,0,'dfregre','2017-09-25'),
 (22,1,'Arthur','1111',0,0,'dfregre','2017-09-25');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
