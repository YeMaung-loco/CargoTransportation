-- MySQL dump 10.13  Distrib 8.0.29, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: cargotransportation
-- ------------------------------------------------------
-- Server version	8.0.29

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `authenticate`
--

DROP TABLE IF EXISTS `authenticate`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `authenticate` (
  `staff_id` int DEFAULT NULL,
  `username` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  UNIQUE KEY `password_UNIQUE` (`password`),
  UNIQUE KEY `username_UNIQUE` (`username`),
  KEY `authenticate_staffid_idx` (`staff_id`),
  CONSTRAINT `authenticate_staffid` FOREIGN KEY (`staff_id`) REFERENCES `staff` (`staff_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `authenticate`
--

LOCK TABLES `authenticate` WRITE;
/*!40000 ALTER TABLE `authenticate` DISABLE KEYS */;
INSERT INTO `authenticate` VALUES (8,'YeMaung','yemaung1234'),(2,'ThandarSoe','thandar1234'),(20,'minmin','minmin123');
/*!40000 ALTER TABLE `authenticate` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customer` (
  `customer_id` int NOT NULL AUTO_INCREMENT,
  `c_name` varchar(45) DEFAULT NULL,
  `c_phone` varchar(45) DEFAULT NULL,
  `c_address` varchar(150) DEFAULT NULL,
  PRIMARY KEY (`customer_id`)
) ENGINE=InnoDB AUTO_INCREMENT=176 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES (98,'Ni Hon','0909090','BoAung Kyaw'),(108,'ThandarSoe','09999999','Hledan'),(109,'ThandarSoe','09999999','Hledan'),(110,'Yar Zar Htun','0988888','South Dagon'),(111,'Yar Zar Htun','0988888','South Dagon'),(112,'Ye Maung','09763774399','Hostle'),(147,'Ko Chit Min Ko','0966574432','Ma Yan Kone'),(148,'Soe Thandar','09687745456','Hledan'),(154,'yemaung','097777','asdfas'),(164,'Htet Htet','09763774399','Hostel'),(165,'Ko Myo','09768899345','Hostel'),(166,'Ko Ko','09763774399','Hostel'),(167,'Ko Thein','0976377222','Hostel'),(168,'Myo Thandar','0976888343','Hostel'),(169,'Min Mni','09763774399','Hledan'),(170,'Ye Maung','09763774399','Hostel'),(171,'Mike Tee','09763774399','Hostel'),(173,'Thein Than Win','0967678890','Hostel'),(174,'Ei Ei','09778899004','House');
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `department`
--

DROP TABLE IF EXISTS `department`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `department` (
  `department_id` int NOT NULL AUTO_INCREMENT,
  `department_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`department_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `department`
--

LOCK TABLES `department` WRITE;
/*!40000 ALTER TABLE `department` DISABLE KEYS */;
INSERT INTO `department` VALUES (1,'KyalGaung'),(2,'Musal'),(3,'Mandalay'),(4,'Yangon');
/*!40000 ALTER TABLE `department` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `destination_price`
--

DROP TABLE IF EXISTS `destination_price`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `destination_price` (
  `destination_id` int NOT NULL AUTO_INCREMENT,
  `destination_name` varchar(45) DEFAULT NULL,
  `destination_price` int DEFAULT NULL,
  PRIMARY KEY (`destination_id`),
  UNIQUE KEY `destination_name_UNIQUE` (`destination_name`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `destination_price`
--

LOCK TABLES `destination_price` WRITE;
/*!40000 ALTER TABLE `destination_price` DISABLE KEYS */;
INSERT INTO `destination_price` VALUES (1,'HleDan',1000),(2,'BoTaHtaung',2000),(3,'EastDagon',3000),(4,'NorthDagon',2000),(8,'KaMarYout',2000);
/*!40000 ALTER TABLE `destination_price` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order`
--

DROP TABLE IF EXISTS `order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `order` (
  `order_id` int NOT NULL AUTO_INCREMENT,
  `order_no` varchar(45) DEFAULT NULL,
  `customer_id` int DEFAULT NULL,
  `destination_id` int DEFAULT NULL,
  `created_date` date DEFAULT NULL,
  `transportation_fees` int DEFAULT '0',
  `assign` bit(3) DEFAULT NULL,
  `status` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`order_id`),
  UNIQUE KEY `order_no_UNIQUE` (`order_no`),
  KEY `order_destinationid_idx` (`destination_id`),
  KEY `order_customerid_idx` (`customer_id`),
  CONSTRAINT `order_customer_id` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`customer_id`),
  CONSTRAINT `order_destinationid` FOREIGN KEY (`destination_id`) REFERENCES `destination_price` (`destination_id`)
) ENGINE=InnoDB AUTO_INCREMENT=132 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order`
--

LOCK TABLES `order` WRITE;
/*!40000 ALTER TABLE `order` DISABLE KEYS */;
INSERT INTO `order` VALUES (103,'CO-00000103',147,1,'2022-07-24',9000,_binary '','Requesting'),(104,'CO-00000104',148,1,'2022-07-24',3000,_binary '','Completed'),(110,'CO-00000110',154,1,'2022-07-25',4000,_binary '','Requesting'),(120,'CO-00000120',164,2,'2022-07-25',3000,_binary '','Requesting'),(121,'CO-00000121',165,2,'2022-07-25',21000,_binary '','Requesting'),(122,'CO-00000122',166,1,'2022-07-25',13000,_binary '','Requesting'),(123,'CO-00000123',167,3,'2022-07-25',5000,_binary '','Requesting'),(124,'CO-00000124',168,1,'2022-07-25',3000,_binary '','Requesting'),(125,'CO-00000125',169,2,'2022-07-25',3000,_binary '','Requesting'),(126,'CO-00000126',170,2,'2022-07-25',9000,_binary '','Requesting'),(127,'CO-00000127',171,2,'2022-07-25',6000,_binary '','Requesting'),(129,'CO-00000128',173,1,'2022-07-25',14000,_binary '','Requesting'),(130,'CO-00000130',174,3,'2022-07-25',13000,_binary '','Requesting');
/*!40000 ALTER TABLE `order` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order_staff`
--

DROP TABLE IF EXISTS `order_staff`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `order_staff` (
  `order_no` varchar(45) DEFAULT NULL,
  `staff_id` int DEFAULT NULL,
  KEY `dummystaffid_idx` (`staff_id`),
  KEY `order_staff_order_no_idx` (`order_no`),
  CONSTRAINT `dummystaffid` FOREIGN KEY (`staff_id`) REFERENCES `staff` (`staff_id`),
  CONSTRAINT `order_staff_order_no` FOREIGN KEY (`order_no`) REFERENCES `order` (`order_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_staff`
--

LOCK TABLES `order_staff` WRITE;
/*!40000 ALTER TABLE `order_staff` DISABLE KEYS */;
INSERT INTO `order_staff` VALUES ('CO-00000104',10),('CO-00000103',12),('CO-00000110',12),('CO-00000120',10),('CO-00000122',12),('CO-00000122',12),('CO-00000123',12),('CO-00000123',12),('CO-00000124',12),('CO-00000124',12),('CO-00000121',10),('CO-00000125',10),('CO-00000126',17),('CO-00000127',17),('CO-00000128',10),('CO-00000130',10);
/*!40000 ALTER TABLE `order_staff` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `package`
--

DROP TABLE IF EXISTS `package`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `package` (
  `package_id` int NOT NULL AUTO_INCREMENT,
  `package_no` varchar(45) DEFAULT NULL,
  `order_no` varchar(45) DEFAULT NULL,
  `weight_kg` int DEFAULT NULL,
  PRIMARY KEY (`package_id`),
  UNIQUE KEY `package_no_UNIQUE` (`package_no`),
  KEY `package_order_no_idx` (`order_no`),
  CONSTRAINT `package_order_no` FOREIGN KEY (`order_no`) REFERENCES `order` (`order_no`)
) ENGINE=InnoDB AUTO_INCREMENT=253 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `package`
--

LOCK TABLES `package` WRITE;
/*!40000 ALTER TABLE `package` DISABLE KEYS */;
INSERT INTO `package` VALUES (218,'CK-00000218','CO-00000103',12),(219,'CK-00000219','CO-00000104',2),(226,'CK-00000226','CO-00000110',3),(236,'CK-00000236','CO-00000120',1),(237,'CK-00000237','CO-00000121',23),(238,'CK-00000238','CO-00000121',12),(239,'CK-00000239','CO-00000122',23),(240,'CK-00000240','CO-00000123',2),(241,'CK-00000241','CO-00000124',2),(242,'CK-00000242','CO-00000125',2),(243,'CK-00000243','CO-00000126',12),(244,'CK-00000244','CO-00000127',3),(245,'CK-00000245','CO-00000127',2),(248,'CK-00000246','CO-00000128',100),(249,'CK-00000249','CO-00000130',20);
/*!40000 ALTER TABLE `package` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `payment`
--

DROP TABLE IF EXISTS `payment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `payment` (
  `payment_id` int NOT NULL AUTO_INCREMENT,
  `payment_date` date DEFAULT NULL,
  `payment_amount` int DEFAULT NULL,
  `description` varchar(45) DEFAULT NULL,
  `order_id` int DEFAULT NULL,
  `paymentChannel_id` int DEFAULT NULL,
  PRIMARY KEY (`payment_id`),
  KEY `payment_orderid_idx` (`order_id`),
  KEY `payment_channelid_idx` (`paymentChannel_id`),
  CONSTRAINT `payment_channelid` FOREIGN KEY (`paymentChannel_id`) REFERENCES `paymentchannel` (`paymentChannel_id`),
  CONSTRAINT `payment_orderid` FOREIGN KEY (`order_id`) REFERENCES `order` (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `payment`
--

LOCK TABLES `payment` WRITE;
/*!40000 ALTER TABLE `payment` DISABLE KEYS */;
/*!40000 ALTER TABLE `payment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `paymentchannel`
--

DROP TABLE IF EXISTS `paymentchannel`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `paymentchannel` (
  `paymentChannel_id` int NOT NULL AUTO_INCREMENT,
  `paymentChannel_name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`paymentChannel_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `paymentchannel`
--

LOCK TABLES `paymentchannel` WRITE;
/*!40000 ALTER TABLE `paymentchannel` DISABLE KEYS */;
/*!40000 ALTER TABLE `paymentchannel` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `role` (
  `role_id` int NOT NULL AUTO_INCREMENT,
  `role_name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,'Normal Staff'),(2,'Office Staff'),(3,'Admin'),(4,'Staff'),(5,'Delivery');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `staff`
--

DROP TABLE IF EXISTS `staff`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `staff` (
  `staff_id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `phone_number` varchar(45) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `nrc` varchar(45) DEFAULT NULL,
  `role_id` int DEFAULT NULL,
  `department_id` int DEFAULT NULL,
  `is_active` bit(3) DEFAULT NULL,
  `created_date` date DEFAULT NULL,
  PRIMARY KEY (`staff_id`),
  KEY `department_idx` (`department_id`),
  KEY `role_idx` (`role_id`),
  CONSTRAINT `department` FOREIGN KEY (`department_id`) REFERENCES `department` (`department_id`),
  CONSTRAINT `role` FOREIGN KEY (`role_id`) REFERENCES `role` (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `staff`
--

LOCK TABLES `staff` WRITE;
/*!40000 ALTER TABLE `staff` DISABLE KEYS */;
INSERT INTO `staff` VALUES (2,'Thandar Soe','0923424534','Hle Dan','1/t()23445',2,4,_binary '','2022-07-11'),(8,'Ye Maung','0867656','asdfas','1/wwe',3,1,_binary '','2022-07-14'),(10,'Nyi Nyi','234523','asdfas','asdf',5,4,_binary '\0','2022-07-20'),(12,'Moe Moe','123412','asdfas','1/asdfas',5,4,_binary '\0','2022-07-22'),(14,'Hnin Hnin','09767777777','Hledan','1/ttn(t)12345',4,4,_binary '','2022-07-24'),(17,'Ko Mike','09763774399','Hostel','1/tnn(n)018894',5,4,_binary '','2022-07-25'),(20,'Min Min','09123123','Hostel','1/tnn(n)018899',2,4,_binary '','2022-07-25');
/*!40000 ALTER TABLE `staff` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `weight_price`
--

DROP TABLE IF EXISTS `weight_price`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `weight_price` (
  `weightPrice_id` int NOT NULL AUTO_INCREMENT,
  `weight_kg` varchar(45) DEFAULT NULL,
  `weight_price` int DEFAULT NULL,
  PRIMARY KEY (`weightPrice_id`),
  UNIQUE KEY `weight_kg_UNIQUE` (`weight_kg`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `weight_price`
--

LOCK TABLES `weight_price` WRITE;
/*!40000 ALTER TABLE `weight_price` DISABLE KEYS */;
INSERT INTO `weight_price` VALUES (1,'2',2000),(2,'6',3000),(3,'10',5000),(4,'15',8000),(7,'20',10000),(8,'30',12000),(11,'35',13000);
/*!40000 ALTER TABLE `weight_price` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-08-08 15:17:17
