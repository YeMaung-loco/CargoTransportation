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
INSERT INTO `authenticate` VALUES (8,'YeMaung','yemaung1234');
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
) ENGINE=InnoDB AUTO_INCREMENT=96 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES (75,'San San May','099999','mmmm'),(76,'Ye Maung Maung','09763774399','Hostle'),(77,'Min Min','099999','hostle'),(78,'Ko Ko ','0999999','jjjj'),(79,'Nyi Nyi','091111','hhh'),(80,'Moe Myint','09763774397','EastDagon'),(81,'Ei Ei San','09222222','MinGalar Taung Nyunt'),(82,'Myo Win','09900000','kkk'),(83,'Test','999','hostle'),(84,'yeye','9','kj'),(85,'k','9','as'),(86,'kk','33','kk'),(87,'Thein Than','0966666','hostel'),(88,'t','9','k'),(89,'Myint Myint','09999999','hostle'),(90,'U Ba','3333','house'),(91,'SaYar','091111','kmd'),(92,'Daw Mya','011111','asdjfskf'),(93,'moe moe','099999','hledan'),(94,'min moe','09999','asdfkj;j'),(95,'Hnin','9999','asdf');
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
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `destination_price`
--

LOCK TABLES `destination_price` WRITE;
/*!40000 ALTER TABLE `destination_price` DISABLE KEYS */;
INSERT INTO `destination_price` VALUES (1,'HleDan',1000),(2,'BoTaHtaung',1000),(3,'EastDagon',3000),(4,'NorthDagon',2000),(7,'Mingalar Taung Nyunt',2000);
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
) ENGINE=InnoDB AUTO_INCREMENT=52 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order`
--

LOCK TABLES `order` WRITE;
/*!40000 ALTER TABLE `order` DISABLE KEYS */;
INSERT INTO `order` VALUES (31,'CO-00000001',75,1,'2022-07-16',3000,_binary '','Delivering'),(32,'CO-00000032',76,4,'2022-07-16',5000,_binary '','Delivering'),(33,'CO-00000033',77,3,'2022-07-16',5000,_binary '','Delivering'),(34,'CO-00000034',78,2,'2022-07-16',4000,_binary '','Delivering'),(35,'CO-00000035',79,3,'2022-07-16',7000,_binary '','Delivering'),(36,'CO-00000036',80,3,'2022-07-18',18000,_binary '','Delivering'),(37,'CO-00000037',81,4,'2022-07-18',5000,_binary '','Delivering'),(38,'CO-00000038',82,1,'2022-07-18',6000,NULL,NULL),(39,'CO-00000039',83,1,'2022-07-18',0,NULL,NULL),(40,'CO-00000040',84,2,'2022-07-18',7000,NULL,NULL),(41,'CO-00000041',85,2,'2022-07-18',0,NULL,NULL),(42,'CO-00000042',86,1,'2022-07-18',0,NULL,NULL),(43,'CO-00000043',87,2,'2022-07-18',0,NULL,NULL),(44,'CO-00000044',88,2,'2022-07-18',0,NULL,NULL),(45,'CO-00000045',89,1,'2022-07-20',0,NULL,NULL),(46,'CO-00000046',90,1,'2022-07-20',17000,NULL,NULL),(47,'CO-00000047',91,1,'2022-07-21',6000,_binary '','Delivering'),(48,'CO-00000048',92,1,'2022-07-21',9000,_binary '','Delivering'),(49,'CO-00000049',93,1,'2022-07-22',9000,_binary '\0','Transporting'),(50,'CO-00000050',94,3,'2022-07-22',3000,_binary '\0','Transporting'),(51,'CO-00000051',95,3,'2022-07-22',15000,_binary '\0','Transporting');
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
INSERT INTO `order_staff` VALUES ('CO-00000032',11),('CO-00000035',11),('CO-00000037',11),('CO-00000040',11),('CO-00000034',10),('CO-00000037',10),('CO-00000041',10),('CO-00000043',10),('CO-00000001',11),('CO-00000032',11),('CO-00000033',11),('CO-00000034',11),('CO-00000035',11),('CO-00000036',11),('CO-00000037',11),('CO-00000047',10),('CO-00000048',10);
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
) ENGINE=InnoDB AUTO_INCREMENT=139 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `package`
--

LOCK TABLES `package` WRITE;
/*!40000 ALTER TABLE `package` DISABLE KEYS */;
INSERT INTO `package` VALUES (99,'CK-00000001','CO-00000001',NULL),(100,'CK-00000100','CO-00000032',NULL),(103,'CK-00000101','CO-00000033',NULL),(105,'CK-00000104','CO-00000034',NULL),(106,'CK-00000106','CO-00000035',NULL),(107,'CK-00000107','CO-00000036',NULL),(108,'CK-00000108','CO-00000036',NULL),(109,'CK-00000109','CO-00000036',NULL),(110,'CK-00000110','CO-00000037',NULL),(111,'CK-00000111','CO-00000038',NULL),(112,'CK-00000112','CO-00000039',NULL),(113,'CK-00000113','CO-00000039',NULL),(114,'CK-00000114','CO-00000040',NULL),(115,'CK-00000115','CO-00000040',NULL),(116,'CK-00000116','CO-00000041',NULL),(118,'CK-00000117','CO-00000042',NULL),(119,'CK-00000119','CO-00000042',NULL),(120,'CK-00000120','CO-00000043',NULL),(121,'CK-00000121','CO-00000043',NULL),(122,'CK-00000122','CO-00000044',NULL),(123,'CK-00000123','CO-00000044',NULL),(124,'CK-00000124','CO-00000045',3),(125,'CK-00000125','CO-00000045',2),(126,'CK-00000126','CO-00000045',5),(127,'CK-00000127','CO-00000046',4),(128,'CK-00000128','CO-00000046',5),(129,'CK-00000129','CO-00000046',20),(130,'CK-00000130','CO-00000047',3),(131,'CK-00000131','CO-00000047',2),(132,'CK-00000132','CO-00000048',5),(133,'CK-00000133','CO-00000048',10),(134,'CK-00000134','CO-00000049',3),(135,'CK-00000135','CO-00000049',2),(136,'CK-00000136','CO-00000049',4),(137,'CK-00000137','CO-00000050',5),(138,'CK-00000138','CO-00000051',44);
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
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `staff`
--

LOCK TABLES `staff` WRITE;
/*!40000 ALTER TABLE `staff` DISABLE KEYS */;
INSERT INTO `staff` VALUES (2,'Thandar Soe','0923424534','Hle Dan','1/t()23445',4,4,_binary '','2022-07-11'),(8,'Ye Maung','0867656','asdfas','1/wwe',2,2,_binary '','2022-07-14'),(9,'Thandar Soe','0923424534','Hle Dan','1/t()23445',4,4,_binary '','2022-07-14'),(10,'Nyi Nyi','234523','asdfas','asdf',5,3,_binary '','2022-07-20'),(11,'Min Min','8888','asdfasdf','1/ttt()asdf',5,4,_binary '','2022-07-20');
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
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `weight_price`
--

LOCK TABLES `weight_price` WRITE;
/*!40000 ALTER TABLE `weight_price` DISABLE KEYS */;
INSERT INTO `weight_price` VALUES (1,'2',2000),(2,'6',3000),(3,'10',5000),(4,'15',8000),(7,'20',10000),(8,'30',12000);
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

-- Dump completed on 2022-07-22 11:08:03
