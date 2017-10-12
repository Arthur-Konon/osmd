﻿

DROP TABLE IF EXISTS `u_column_names`;
CREATE TABLE `u_column_names` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `TABLE_NAME` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `English` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `Russian` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `Ukranian` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=310 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;




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





