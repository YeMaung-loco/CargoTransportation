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
/*!40000 ALTER TABLE `authenticate` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customer` (
  `customet_id` int NOT NULL AUTO_INCREMENT,
  `c_name` varchar(45) DEFAULT NULL,
  `c_phone` varchar(45) DEFAULT NULL,
  `c_address` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`customet_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `department`
--

LOCK TABLES `department` WRITE;
/*!40000 ALTER TABLE `department` DISABLE KEYS */;
/*!40000 ALTER TABLE `department` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `destination_price`
--

DROP TABLE IF EXISTS `destination_price`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `destination_price` (
  `destinationPrice_id` int NOT NULL AUTO_INCREMENT,
  `destination_name` varchar(45) DEFAULT NULL,
  `destinationPrice` int DEFAULT NULL,
  PRIMARY KEY (`destinationPrice_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `destination_price`
--

LOCK TABLES `destination_price` WRITE;
/*!40000 ALTER TABLE `destination_price` DISABLE KEYS */;
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
  `created_date` date DEFAULT NULL,
  `weightPrice_id` int DEFAULT NULL,
  `destinationPrice_id` int DEFAULT NULL,
  `transportation_fees` int DEFAULT NULL,
  PRIMARY KEY (`order_id`),
  KEY `order_weightid_idx` (`weightPrice_id`),
  KEY `order_destinationid_idx` (`destinationPrice_id`),
  CONSTRAINT `order_destinationid` FOREIGN KEY (`destinationPrice_id`) REFERENCES `destination_price` (`destinationPrice_id`),
  CONSTRAINT `order_weightid` FOREIGN KEY (`weightPrice_id`) REFERENCES `weight_price` (`weightPrice_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order`
--

LOCK TABLES `order` WRITE;
/*!40000 ALTER TABLE `order` DISABLE KEYS */;
/*!40000 ALTER TABLE `order` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order_customer`
--

DROP TABLE IF EXISTS `order_customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `order_customer` (
  `order_id` int DEFAULT NULL,
  `customer_id` int DEFAULT NULL,
  KEY `dummyorderid_idx` (`order_id`),
  KEY `dummycustomerid_idx` (`customer_id`),
  CONSTRAINT `dummycustomerid` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`customet_id`),
  CONSTRAINT `dummyordecusrid` FOREIGN KEY (`order_id`) REFERENCES `order` (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_customer`
--

LOCK TABLES `order_customer` WRITE;
/*!40000 ALTER TABLE `order_customer` DISABLE KEYS */;
/*!40000 ALTER TABLE `order_customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order_staff`
--

DROP TABLE IF EXISTS `order_staff`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `order_staff` (
  `order_id` int DEFAULT NULL,
  `staff_id` int DEFAULT NULL,
  KEY `dummyorderid_idx` (`order_id`),
  KEY `dummystaffid_idx` (`staff_id`),
  CONSTRAINT `dummyorderid` FOREIGN KEY (`order_id`) REFERENCES `order` (`order_id`),
  CONSTRAINT `dummystaffid` FOREIGN KEY (`staff_id`) REFERENCES `staff` (`staff_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_staff`
--

LOCK TABLES `order_staff` WRITE;
/*!40000 ALTER TABLE `order_staff` DISABLE KEYS */;
/*!40000 ALTER TABLE `order_staff` ENABLE KEYS */;
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `staff`
--

LOCK TABLES `staff` WRITE;
/*!40000 ALTER TABLE `staff` DISABLE KEYS */;
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
  PRIMARY KEY (`weightPrice_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `weight_price`
--

LOCK TABLES `weight_price` WRITE;
/*!40000 ALTER TABLE `weight_price` DISABLE KEYS */;
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

-- Dump completed on 2022-07-08 13:47:52
