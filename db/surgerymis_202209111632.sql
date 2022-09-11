-- MySQL dump 10.13  Distrib 8.0.30, for Linux (x86_64)
--
-- Host: localhost    Database: surgerymis
-- ------------------------------------------------------
-- Server version	8.0.30-0ubuntu0.22.04.1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `anesthesia`
--

DROP TABLE IF EXISTS `anesthesia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `anesthesia` (
  `id` int NOT NULL AUTO_INCREMENT,
  `patient_id` int DEFAULT NULL,
  `operation_id` int DEFAULT NULL,
  `anesthesia_type` varchar(255) DEFAULT NULL,
  `induction` varchar(255) NOT NULL,
  `operative_duration` varchar(255) DEFAULT NULL,
  `anesthesia_duration` varchar(255) DEFAULT NULL,
  `anesthetist_id` int DEFAULT NULL,
  `post_op_disposition` text,
  `created_at` datetime DEFAULT CURRENT_TIMESTAMP,
  `updated_at` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `is_deleted` tinyint(1) DEFAULT '0',
  `deleted_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `patient_id` (`patient_id`),
  KEY `operation_id` (`operation_id`),
  KEY `anesthetist_id` (`anesthetist_id`),
  CONSTRAINT `anesthesia_ibfk_1` FOREIGN KEY (`patient_id`) REFERENCES `patients` (`id`),
  CONSTRAINT `anesthesia_ibfk_2` FOREIGN KEY (`operation_id`) REFERENCES `operations` (`id`),
  CONSTRAINT `anesthesia_ibfk_4` FOREIGN KEY (`anesthetist_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `anesthesia`
--

LOCK TABLES `anesthesia` WRITE;
/*!40000 ALTER TABLE `anesthesia` DISABLE KEYS */;
INSERT INTO `anesthesia` VALUES (1,1,1,'kin','','3 hours','30 min',3,'1','2022-07-27 23:26:53',NULL,NULL,NULL),(2,3,2,'for surgery','','More than 4 hours','6 hours',2,'0','2022-08-15 14:16:57',NULL,NULL,NULL),(3,3,2,'surgery','','3 hours','4.5 hours',2,'0','2022-08-15 14:19:50',NULL,NULL,NULL),(4,3,3,'sdfsfd','','hkghgjhg','erdssdfgd',2,'0','2022-08-15 15:58:26',NULL,NULL,NULL),(5,8,4,'Regional','Anytime soon','2 hours','3 hours',2,'0','2022-09-07 19:31:21',NULL,NULL,NULL);
/*!40000 ALTER TABLE `anesthesia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `operating_room`
--

DROP TABLE IF EXISTS `operating_room`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `operating_room` (
  `id` int NOT NULL AUTO_INCREMENT,
  `patient_id` int DEFAULT NULL,
  `operation_id` int DEFAULT NULL,
  `surgeon_id` int DEFAULT NULL,
  `nurse_id` int DEFAULT NULL,
  `intra_op_diagnosis` text,
  `op_procedure` text,
  `emergence_or_entrance` varchar(255) DEFAULT NULL,
  `dressing` text,
  `out_` text,
  `cleaning` text,
  `operation_status` varchar(50) NOT NULL DEFAULT 'Minor',
  `observation` text,
  `created_at` datetime DEFAULT CURRENT_TIMESTAMP,
  `updated_at` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `is_deleted` tinyint(1) DEFAULT '0',
  `deleted_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `patient_id` (`patient_id`),
  KEY `operation_id` (`operation_id`),
  KEY `surgeon_id` (`surgeon_id`),
  KEY `nurse_id` (`nurse_id`),
  CONSTRAINT `operating_room_ibfk_1` FOREIGN KEY (`patient_id`) REFERENCES `patients` (`id`),
  CONSTRAINT `operating_room_ibfk_2` FOREIGN KEY (`operation_id`) REFERENCES `operations` (`id`),
  CONSTRAINT `operating_room_ibfk_3` FOREIGN KEY (`surgeon_id`) REFERENCES `users` (`id`),
  CONSTRAINT `operating_room_ibfk_5` FOREIGN KEY (`nurse_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `operating_room`
--

LOCK TABLES `operating_room` WRITE;
/*!40000 ALTER TABLE `operating_room` DISABLE KEYS */;
INSERT INTO `operating_room` VALUES (2,3,2,15,9,'Lung cancer','surgery','Low','gloves','adone','well done','not really','Operation may be successful','2022-08-15 14:56:11',NULL,NULL,NULL),(3,3,3,16,8,'afdsfsdsd','asdsadasdas                                        ','asdsada','asdasdas','sfsdsd','ksdkfkdsk','asdasdas','ASDSADSAS','2022-08-15 15:57:11',NULL,NULL,NULL),(4,8,4,15,4,'starter','lung cancer surgery',NULL,'sdfsdfs','sfsdf','Well done','Intermediate','sdfsdf','2022-09-07 19:39:24',NULL,NULL,NULL),(5,3,2,15,4,'Symtoms of tube','medics of 6months',NULL,'As a doctor','2022-06-06','Well done','Minor','Not severe','2022-09-11 14:50:05',NULL,NULL,NULL);
/*!40000 ALTER TABLE `operating_room` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `operations`
--

DROP TABLE IF EXISTS `operations`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `operations` (
  `id` int NOT NULL AUTO_INCREMENT,
  `patient_id` int DEFAULT NULL,
  `district_hospital` varchar(255) DEFAULT NULL,
  `pre_op_diagnostic` text,
  `planned_procedure` text,
  `assurance` varchar(255) DEFAULT NULL,
  `accompanying` varchar(255) DEFAULT NULL,
  `observation` varchar(255) DEFAULT NULL,
  `created_at` datetime DEFAULT CURRENT_TIMESTAMP,
  `updated_at` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `is_deleted` tinyint(1) DEFAULT '0',
  `deleted_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `patient_id` (`patient_id`),
  CONSTRAINT `operations_ibfk_1` FOREIGN KEY (`patient_id`) REFERENCES `patients` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `operations`
--

LOCK TABLES `operations` WRITE;
/*!40000 ALTER TABLE `operations` DISABLE KEYS */;
INSERT INTO `operations` VALUES (1,1,'Kamonyi','Diabete 2','Surgery','MMI','Parent','yes and he is recovering',NULL,NULL,NULL,NULL),(2,3,'Remera','prepared                                        ','circonsision','MMMI','Parents',NULL,'2022-08-10 21:01:30',NULL,NULL,NULL),(3,3,'Kibagabaga','Lung cancer','Surgery','MMI','Ineza',NULL,'2022-08-15 15:52:21',NULL,NULL,NULL),(4,8,'Gasabo','Lung cancer','Lung cancer surgery','MMI','Mother','Very very bad','2022-09-04 15:00:43',NULL,NULL,NULL),(5,8,'Kigali','brain cancer','brain surgery','RSSB','Brother','complicated','2022-09-07 19:40:41',NULL,NULL,NULL);
/*!40000 ALTER TABLE `operations` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pacu`
--

DROP TABLE IF EXISTS `pacu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pacu` (
  `id` int NOT NULL AUTO_INCREMENT,
  `patient_id` int DEFAULT NULL,
  `operation_id` int DEFAULT NULL,
  `exit_date` varchar(255) DEFAULT NULL,
  `destination` varchar(255) DEFAULT NULL,
  `observation` varchar(255) DEFAULT NULL,
  `created_at` datetime DEFAULT CURRENT_TIMESTAMP,
  `updated_at` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `is_deleted` tinyint(1) DEFAULT '0',
  `deleted_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `patient_id` (`patient_id`),
  KEY `operation_id` (`operation_id`),
  CONSTRAINT `pacu_ibfk_1` FOREIGN KEY (`patient_id`) REFERENCES `patients` (`id`),
  CONSTRAINT `pacu_ibfk_2` FOREIGN KEY (`operation_id`) REFERENCES `operations` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pacu`
--

LOCK TABLES `pacu` WRITE;
/*!40000 ALTER TABLE `pacu` DISABLE KEYS */;
INSERT INTO `pacu` VALUES (1,1,1,'2022-07-29','R1','He is recovering',NULL,NULL,NULL,NULL),(2,3,2,'2022-08-12','Faisal','May get well soon                                        ',NULL,NULL,NULL,NULL),(3,3,3,'2022-08-15','hghghghgh','mkkjkjk','2022-08-15 16:00:23',NULL,NULL,NULL),(4,8,4,'2022-09-04','recovery room','operation went well                                        ','2022-09-04 15:01:12',NULL,NULL,NULL);
/*!40000 ALTER TABLE `pacu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `patients`
--

DROP TABLE IF EXISTS `patients`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `patients` (
  `id` int NOT NULL AUTO_INCREMENT,
  `patient_names` varchar(255) NOT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `province` varchar(30) DEFAULT NULL,
  `district` varchar(30) DEFAULT NULL,
  `dob` date DEFAULT NULL,
  `gender` enum('Male','Female') DEFAULT NULL,
  `created_at` datetime DEFAULT CURRENT_TIMESTAMP,
  `updated_at` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `is_deleted` tinyint(1) DEFAULT '0',
  `deleted_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `patients`
--

LOCK TABLES `patients` WRITE;
/*!40000 ALTER TABLE `patients` DISABLE KEYS */;
INSERT INTO `patients` VALUES (1,'Manzi','07896542','Kigali','Gasabo','2022-07-12','Female',NULL,NULL,NULL,NULL),(2,'Channy','0789632145','Kigali','Kicukiro','2022-08-03','Female','2022-08-10 19:39:19',NULL,NULL,NULL),(3,'Anais','0745123457','Kigali','Nyarugenge','2022-08-02','Female','2022-08-10 19:43:45',NULL,NULL,NULL),(4,'Damn','0789632123','Kigali','Gasabo','2022-08-02','Female','2022-08-10 19:53:22',NULL,NULL,NULL),(5,'Yves','0726132125','Kigali city','Gasabo','2022-08-09','Female','2022-08-15 15:41:42',NULL,NULL,NULL),(6,'Japhet','0788349092','Kigali','Gasabo','2022-06-15','Female','2022-09-04 14:49:55',NULL,NULL,NULL),(8,'Cure Japhet','0788349092','Kigali city','Gasabo','2022-05-03','Female','2022-09-04 14:56:12',NULL,NULL,NULL);
/*!40000 ALTER TABLE `patients` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pharmacy`
--

DROP TABLE IF EXISTS `pharmacy`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pharmacy` (
  `id` int NOT NULL AUTO_INCREMENT,
  `pharmacy_name` varchar(255) NOT NULL,
  `represented_by_id` int DEFAULT NULL,
  `created_at` datetime DEFAULT CURRENT_TIMESTAMP,
  `updated_at` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `is_deleted` tinyint(1) DEFAULT '0',
  `deleted_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `represented_by_id` (`represented_by_id`),
  CONSTRAINT `pharmacy_ibfk_1` FOREIGN KEY (`represented_by_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pharmacy`
--

LOCK TABLES `pharmacy` WRITE;
/*!40000 ALTER TABLE `pharmacy` DISABLE KEYS */;
INSERT INTO `pharmacy` VALUES (1,'Kacyiru',NULL,'2022-07-26 20:16:50',NULL,NULL,NULL),(2,'Kacyiru',NULL,'2022-07-26 20:17:44',NULL,NULL,NULL),(3,'Kacyiru',3,'2022-07-26 20:49:39','2022-09-11 15:21:25',NULL,NULL),(4,'Ikizere',9,'2022-08-10 20:14:22',NULL,NULL,NULL),(5,'Umurama',10,'2022-08-10 20:15:27',NULL,NULL,NULL),(6,'Kipharma',9,'2022-08-15 15:43:02',NULL,NULL,NULL);
/*!40000 ALTER TABLE `pharmacy` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pharmacy_orders`
--

DROP TABLE IF EXISTS `pharmacy_orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pharmacy_orders` (
  `id` int NOT NULL AUTO_INCREMENT,
  `patient_id` int DEFAULT NULL,
  `pharmacy_id` int DEFAULT NULL,
  `nurse_id` int DEFAULT NULL,
  `kit` varchar(255) DEFAULT NULL,
  `delivery` varchar(255) DEFAULT NULL,
  `created_at` datetime DEFAULT CURRENT_TIMESTAMP,
  `updated_at` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `is_deleted` tinyint(1) DEFAULT '0',
  `deleted_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `patient_id` (`patient_id`),
  KEY `pharmacy_id` (`pharmacy_id`),
  KEY `nurse_id` (`nurse_id`),
  CONSTRAINT `pharmacy_orders_ibfk_1` FOREIGN KEY (`patient_id`) REFERENCES `patients` (`id`),
  CONSTRAINT `pharmacy_orders_ibfk_2` FOREIGN KEY (`pharmacy_id`) REFERENCES `pharmacy` (`id`),
  CONSTRAINT `pharmacy_orders_ibfk_3` FOREIGN KEY (`nurse_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pharmacy_orders`
--

LOCK TABLES `pharmacy_orders` WRITE;
/*!40000 ALTER TABLE `pharmacy_orders` DISABLE KEYS */;
INSERT INTO `pharmacy_orders` VALUES (1,3,4,NULL,'Ipamba','Delivered','2022-08-15 15:10:02',NULL,NULL,NULL),(2,3,4,NULL,'Gloves','Next day','2022-08-15 15:15:48',NULL,NULL,NULL),(3,4,4,NULL,'Gloves','Done','2022-08-15 15:48:09',NULL,NULL,NULL),(4,8,3,9,'Umukasi','done','2022-09-11 14:58:57',NULL,NULL,NULL);
/*!40000 ALTER TABLE `pharmacy_orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `phone` varchar(20) NOT NULL,
  `user_type` varchar(255) DEFAULT NULL,
  `is_password_changed` tinyint(1) DEFAULT NULL,
  `password` varchar(255) NOT NULL,
  `is_otp_required` tinyint(1) DEFAULT NULL,
  `otp` varchar(15) NOT NULL,
  `created_at` datetime DEFAULT CURRENT_TIMESTAMP,
  `updated_at` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `is_deleted` tinyint(1) DEFAULT '0',
  `deleted_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'Manzi','h@yop.com','07896542',NULL,NULL,'12345',NULL,'',NULL,NULL,NULL,NULL),(2,'Asua','h@yopmail.fr','0726156846','Anesthetist',NULL,'12345',NULL,'','2022-07-26 19:52:39','2022-07-27 23:42:53',NULL,NULL),(3,'Manzi','pharmacist@gmail.com','07896542','Pharmacist',NULL,'12345',NULL,'','2022-07-26 20:16:07','2022-09-07 18:33:53',NULL,NULL),(4,'Dieudonne','h.h.c','0726123456','Nurse',0,'12345',NULL,'','2022-08-08 21:58:36',NULL,NULL,NULL),(5,'Dieudonne','admin@gmail.com','0726123456','Admin',0,'12345',NULL,'','2022-08-08 22:00:16','2022-09-07 18:33:53',NULL,NULL),(6,'Dieudonne','receptionist@gmail.com','0789123321','Receptionist',0,'12345',NULL,'','2022-08-08 22:01:44','2022-09-07 18:33:53',NULL,NULL),(7,'Damn','h@h.c','07891232','Assistant',0,'12345',NULL,'','2022-08-08 22:02:54',NULL,NULL,NULL),(8,'Dickson','h@h.c','078945613','Nurse',0,'12345',NULL,'','2022-08-08 22:03:51',NULL,NULL,NULL),(9,'Channy','h@h.c','079456123','Nurse',0,'12345',NULL,'','2022-08-08 22:06:28',NULL,NULL,NULL),(10,'Drama','h@s.c','078945612','Nurse',0,'12345',NULL,'','2022-08-08 22:08:49',NULL,NULL,NULL),(11,'Name','sdfs','5645645645','Admin',0,'12345',NULL,'','2022-08-08 22:10:15',NULL,NULL,NULL),(12,'Dieudonne','h@h.c','078912321','Nurse',0,'12345',NULL,'','2022-08-08 22:11:45',NULL,NULL,NULL),(13,'Phar','phar@gmail.com','','Pharmacist',0,'12345',NULL,'','2022-08-08 22:11:49','2022-09-11 15:19:16',NULL,NULL),(14,'Emma','e@gmail.com','079412635','Anesthesiologist',0,'12345',NULL,'','2022-08-15 14:10:54','2022-08-15 14:12:50',NULL,NULL),(15,'Amina','a@gmail.com','0751236254','Surgeon',0,'12345',NULL,'','2022-08-15 14:40:43',NULL,NULL,NULL),(16,'Kapanga','operation@gmail.com','0793625124','Operation manager',0,'12345',NULL,'','2022-08-15 15:40:15','2022-09-07 18:33:53',NULL,NULL),(17,'louise','inemA@','0788671144','Nurse',0,'12345',NULL,'','2022-08-30 21:45:19',NULL,NULL,NULL);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-09-11 16:32:50
