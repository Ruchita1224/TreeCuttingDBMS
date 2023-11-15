-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: treecuttingdb
-- ------------------------------------------------------
-- Server version	5.7.43-log

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
-- Table structure for table `admin`
--

DROP TABLE IF EXISTS `admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `admin` (
  `LoginID` varchar(100) NOT NULL,
  `Password` varchar(100) DEFAULT NULL,
  `ActionPerformed` varchar(100) DEFAULT NULL,
  `Timestamp` datetime DEFAULT NULL,
  PRIMARY KEY (`LoginID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin`
--

LOCK TABLES `admin` WRITE;
/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
INSERT INTO `admin` VALUES ('abc','abc','Account created','2023-10-26 00:00:00'),('admin10','Root*1234','Data insertion','2023-03-10 19:00:00'),('admin2','Root*1234','Data insertion','2023-03-02 11:00:00'),('admin3','Root*1234','Data insertion','2023-03-03 12:00:00'),('admin4','Root*1234','Data insertion','2023-03-04 13:00:00'),('admin5','Root*1234','Data insertion','2023-03-05 14:00:00'),('admin6','Root*1234','Data insertion','2023-03-06 15:00:00'),('admin7','Root*1234','Data insertion','2023-03-07 16:00:00'),('admin8','Root*1234','Data insertion','2023-03-08 17:00:00'),('admin9','Root*1234','Data insertion','2023-03-09 18:00:00'),('root','Root*1234','Database setup','2023-03-01 10:00:00');
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `billdetails`
--

DROP TABLE IF EXISTS `billdetails`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `billdetails` (
  `BillID` varchar(100) NOT NULL,
  `OrderID` varchar(100) DEFAULT NULL,
  `BilledDate` date DEFAULT NULL,
  `Amount` decimal(10,2) DEFAULT NULL,
  `Status` varchar(100) DEFAULT NULL,
  `Note` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`BillID`),
  KEY `OrderID` (`OrderID`),
  CONSTRAINT `billdetails_ibfk_1` FOREIGN KEY (`OrderID`) REFERENCES `orderdetails` (`OrderID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `billdetails`
--

LOCK TABLES `billdetails` WRITE;
/*!40000 ALTER TABLE `billdetails` DISABLE KEYS */;
INSERT INTO `billdetails` VALUES ('1','1','2023-02-10',500.00,'Paid','Payment received'),('10','10','2023-02-19',600.00,'Pending','Payment pending'),('2','2','2023-02-11',750.00,'Pending','Payment due'),('3','3','2023-02-12',400.00,'Paid','Payment received'),('4','4','2023-02-13',600.00,'Processing','Payment processing'),('5','5','2023-02-14',550.00,'Pending','Payment pending'),('6','6','2023-02-15',700.00,'Paid','Payment received'),('7','7','2023-02-16',800.00,'Completed','Payment complete'),('8','8','2023-02-17',450.00,'Pending','Payment due'),('9','9','2023-02-18',650.00,'Processing','Payment processing');
/*!40000 ALTER TABLE `billdetails` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `client`
--

DROP TABLE IF EXISTS `client`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `client` (
  `ClientID` varchar(50) NOT NULL,
  `FirstName` varchar(100) DEFAULT NULL,
  `LastName` varchar(100) DEFAULT NULL,
  `Address` varchar(255) DEFAULT NULL,
  `CreditCardInfo` varchar(50) DEFAULT NULL,
  `PhoneNumber` varchar(50) DEFAULT NULL,
  `Email` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`ClientID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `client`
--

LOCK TABLES `client` WRITE;
/*!40000 ALTER TABLE `client` DISABLE KEYS */;
INSERT INTO `client` VALUES ('1','John','Doe','123 Main St','1234-5678-9012-3456','555-555-5555','john.doe@email.com'),('10','Megan','Miller','6666 Poplar St','5678-1234-9876-5432','505-505-5050','megan.miller@email.com'),('2','Jane','Smith','456 Elm St','9876-5432-1098-7654','666-666-6666','jane.smith@email.com'),('3','Mike','Johnson','789 Oak St','5678-1234-9876-5432','777-777-7777','mike.johnson@email.com'),('4','Sarah','Brown','101 Pine St','4321-8765-5432-1098','888-888-8888','sarah.brown@email.com'),('5','David','Wilson','1111 Cedar St','8765-4321-7654-3210','999-999-9999','david.wilson@email.com'),('6','Linda','Lee','2222 Birch St','2345-6789-2109-8765','101-101-1010','linda.lee@email.com'),('7','Robert','Davis','3333 Maple St','6789-2345-4321-9876','202-202-2020','robert.davis@email.com'),('8','Emily','White','4444 Redwood St','8765-4321-7654-3210','303-303-3030','emily.white@email.com'),('9','Chris','Taylor','5555 Walnut St','1234-5678-9012-3456','404-404-4040','chris.taylor@email.com');
/*!40000 ALTER TABLE `client` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orderdetails`
--

DROP TABLE IF EXISTS `orderdetails`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `orderdetails` (
  `OrderID` varchar(100) NOT NULL,
  `QuoteID` varchar(100) DEFAULT NULL,
  `OrderDate` date DEFAULT NULL,
  `Status` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`OrderID`),
  KEY `QuoteID` (`QuoteID`),
  CONSTRAINT `orderdetails_ibfk_1` FOREIGN KEY (`QuoteID`) REFERENCES `quote` (`QuoteID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orderdetails`
--

LOCK TABLES `orderdetails` WRITE;
/*!40000 ALTER TABLE `orderdetails` DISABLE KEYS */;
INSERT INTO `orderdetails` VALUES ('1','1','2023-01-25','Processing'),('10','10','2023-02-03','Pending'),('2','2','2023-01-26','Pending'),('3','3','2023-01-27','Completed'),('4','4','2023-01-28','In Progress'),('5','5','2023-01-29','Processing'),('6','6','2023-01-30','Pending'),('7','7','2023-01-31','Completed'),('8','8','2023-02-01','Processing'),('9','9','2023-02-02','In Progress');
/*!40000 ALTER TABLE `orderdetails` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `quote`
--

DROP TABLE IF EXISTS `quote`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `quote` (
  `QuoteID` varchar(100) NOT NULL,
  `RequestID` varchar(100) DEFAULT NULL,
  `QuoteDate` date DEFAULT NULL,
  `Price` decimal(10,2) DEFAULT NULL,
  `TimeWindow` varchar(100) DEFAULT NULL,
  `Status` varchar(100) DEFAULT NULL,
  `Note` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`QuoteID`),
  KEY `RequestID` (`RequestID`),
  CONSTRAINT `quote_ibfk_1` FOREIGN KEY (`RequestID`) REFERENCES `treerequest` (`RequestID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `quote`
--

LOCK TABLES `quote` WRITE;
/*!40000 ALTER TABLE `quote` DISABLE KEYS */;
INSERT INTO `quote` VALUES ('1','1','2023-01-15',500.00,'8:00 AM - 12:00 PM','Pending','Initial quote'),('10','10','2023-01-24',600.00,'5:00 PM - 9:00 PM','Pending','Standard quote'),('2','2','2023-01-16',750.00,'9:00 AM - 1:00 PM','Pending','Custom quote'),('3','3','2023-01-17',400.00,'10:00 AM - 2:00 PM','Accepted','Standard quote'),('4','4','2023-01-18',600.00,'11:00 AM - 3:00 PM','Pending','Emergency quote'),('5','5','2023-01-19',550.00,'12:00 PM - 4:00 PM','Pending','Detailed quote'),('6','6','2023-01-20',700.00,'1:00 PM - 5:00 PM','Accepted','Custom quote'),('7','7','2023-01-21',800.00,'2:00 PM - 6:00 PM','Completed','Final quote'),('8','8','2023-01-22',450.00,'3:00 PM - 7:00 PM','Pending','Standard quote'),('9','9','2023-01-23',650.00,'4:00 PM - 8:00 PM','In Progress','Custom quote');
/*!40000 ALTER TABLE `quote` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `treeinformation`
--

DROP TABLE IF EXISTS `treeinformation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `treeinformation` (
  `TreeInfoID` varchar(100) NOT NULL,
  `RequestID` varchar(100) DEFAULT NULL,
  `Size` decimal(5,2) DEFAULT NULL,
  `Height` decimal(5,2) DEFAULT NULL,
  `Location` varchar(100) DEFAULT NULL,
  `NearHouse` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`TreeInfoID`),
  KEY `RequestID` (`RequestID`),
  CONSTRAINT `treeinformation_ibfk_1` FOREIGN KEY (`RequestID`) REFERENCES `treerequest` (`RequestID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `treeinformation`
--

LOCK TABLES `treeinformation` WRITE;
/*!40000 ALTER TABLE `treeinformation` DISABLE KEYS */;
INSERT INTO `treeinformation` VALUES ('1','1',10.50,25.30,'Front Yard',1),('10','10',10.90,24.80,'Front Yard',1),('2','2',15.20,30.00,'Backyard',0),('3','3',8.70,20.10,'Side Yard',1),('4','4',12.30,28.50,'Front Yard',1),('5','5',9.80,22.00,'Backyard',0),('6','6',14.10,32.70,'Side Yard',1),('7','7',11.00,26.60,'Front Yard',1),('8','8',7.50,18.40,'Backyard',0),('9','9',13.40,31.20,'Side Yard',1);
/*!40000 ALTER TABLE `treeinformation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `treepicture`
--

DROP TABLE IF EXISTS `treepicture`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `treepicture` (
  `PictureID` varchar(100) NOT NULL,
  `PictureURL` varchar(255) DEFAULT NULL,
  `TreeInfoID` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`PictureID`),
  KEY `TreeInfoID` (`TreeInfoID`),
  CONSTRAINT `treepicture_ibfk_1` FOREIGN KEY (`TreeInfoID`) REFERENCES `treeinformation` (`TreeInfoID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `treepicture`
--

LOCK TABLES `treepicture` WRITE;
/*!40000 ALTER TABLE `treepicture` DISABLE KEYS */;
INSERT INTO `treepicture` VALUES ('1','http://example.com/tree1.jpg','1'),('10','http://example.com/tree10.jpg','10'),('2','http://example.com/tree2.jpg','2'),('3','http://example.com/tree3.jpg','3'),('4','http://example.com/tree4.jpg','4'),('5','http://example.com/tree5.jpg','5'),('6','http://example.com/tree6.jpg','6'),('7','http://example.com/tree7.jpg','7'),('8','http://example.com/tree8.jpg','8'),('9','http://example.com/tree9.jpg','9');
/*!40000 ALTER TABLE `treepicture` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `treerequest`
--

DROP TABLE IF EXISTS `treerequest`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `treerequest` (
  `RequestID` varchar(100) NOT NULL,
  `ClientID` varchar(50) DEFAULT NULL,
  `RequestDate` date DEFAULT NULL,
  `Status` varchar(100) DEFAULT NULL,
  `Note` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`RequestID`),
  KEY `ClientID` (`ClientID`),
  CONSTRAINT `treerequest_ibfk_1` FOREIGN KEY (`ClientID`) REFERENCES `client` (`ClientID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `treerequest`
--

LOCK TABLES `treerequest` WRITE;
/*!40000 ALTER TABLE `treerequest` DISABLE KEYS */;
INSERT INTO `treerequest` VALUES ('1','1','2023-01-01','Pending','Tree trimming needed'),('10','10','2023-01-10','Pending','Tree assessment required'),('2','2','2023-01-02','Pending','Tree removal requested'),('3','3','2023-01-03','Completed','Tree assessment completed'),('4','4','2023-01-04','In Progress','Emergency tree service'),('5','5','2023-01-05','Pending','Tree inspection required'),('6','6','2023-01-06','In Progress','Tree pruning in progress'),('7','7','2023-01-07','Completed','Tree removal completed'),('8','8','2023-01-08','Pending','Tree trimming needed'),('9','9','2023-01-09','In Progress','Tree inspection in progress');
/*!40000 ALTER TABLE `treerequest` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Username` varchar(50) NOT NULL,
  `Password` varchar(255) NOT NULL,
  `Role` enum('David Smith','Client','Admin Root') NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'davidsmith','davidsmith','David Smith'),(2,'clientuser','clientuser','Client'),(3,'adminroot','adminroot','Admin Root'),(4,'abc','abc','Admin Root'),(5,'ruchi','ruchi','David Smith');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-11-01 19:32:21
