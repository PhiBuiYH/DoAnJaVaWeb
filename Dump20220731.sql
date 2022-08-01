-- MySQL dump 10.13  Distrib 8.0.29, for Win64 (x86_64)
--
-- Host: localhost    Database: web_ban_quan_ao
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
-- Table structure for table `brand`
--

DROP TABLE IF EXISTS `brand`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `brand` (
  `brand_id` int NOT NULL AUTO_INCREMENT,
  `brand_name` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`brand_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `brand`
--

LOCK TABLES `brand` WRITE;
/*!40000 ALTER TABLE `brand` DISABLE KEYS */;
INSERT INTO `brand` VALUES (1,'Adidas'),(2,'Nike'),(3,'Vans'),(4,'levis'),(5,'H&M');
/*!40000 ALTER TABLE `brand` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cart`
--

DROP TABLE IF EXISTS `cart`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cart` (
  `id` int NOT NULL AUTO_INCREMENT,
  `u_id` int NOT NULL,
  `buyDate` date DEFAULT NULL,
  `action` bit(1) DEFAULT NULL,
  `note` varchar(255) DEFAULT NULL,
  `status` int DEFAULT NULL,
  `c_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `u_id` (`u_id`),
  CONSTRAINT `cart_ibfk_1` FOREIGN KEY (`u_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cart`
--

LOCK TABLES `cart` WRITE;
/*!40000 ALTER TABLE `cart` DISABLE KEYS */;
INSERT INTO `cart` VALUES (2,1,'2020-12-15',_binary '\0',NULL,NULL,NULL),(8,1,'2021-01-06',_binary '\0',NULL,NULL,NULL),(9,1,'2021-01-06',_binary '\0',NULL,NULL,NULL),(10,1,'2021-01-06',_binary '\0',NULL,NULL,NULL),(11,1,'2021-01-06',_binary '\0',NULL,NULL,NULL),(12,1,'2021-01-06',_binary '\0',NULL,NULL,NULL),(13,1,'2021-01-06',_binary '\0',NULL,NULL,NULL),(14,1,'2021-01-06',_binary '\0',NULL,NULL,NULL),(15,1,'2021-01-06',_binary '\0',NULL,NULL,NULL),(16,1,'2021-01-06',_binary '\0',NULL,NULL,NULL),(17,1,'2021-01-06',_binary '\0',NULL,NULL,NULL),(18,1,'2021-01-06',_binary '\0',NULL,NULL,NULL),(19,1,'2021-01-06',_binary '\0',NULL,NULL,NULL),(20,1,'2021-01-06',_binary '\0',NULL,NULL,NULL),(21,1,'2021-01-06',_binary '\0',NULL,NULL,NULL),(22,1,'2021-01-06',_binary '\0',NULL,NULL,NULL),(23,1,'2021-01-06',_binary '\0',NULL,NULL,NULL),(24,1,'2021-01-06',_binary '\0',NULL,NULL,NULL),(25,1,'2021-01-06',_binary '\0',NULL,NULL,NULL),(26,1,'2021-01-08',_binary '\0',NULL,NULL,NULL),(27,1,'2021-01-08',_binary '\0',NULL,NULL,NULL),(28,1,'2021-01-08',_binary '\0',NULL,NULL,NULL),(29,1,'2021-01-08',_binary '\0',NULL,NULL,NULL),(30,1,'2021-01-08',_binary '\0',NULL,NULL,NULL),(31,1,'2021-01-08',_binary '\0',NULL,NULL,NULL),(32,1,'2021-01-08',_binary '\0',NULL,NULL,NULL),(33,1,'2021-01-08',_binary '\0',NULL,NULL,NULL),(34,1,'2021-01-08',_binary '\0',NULL,NULL,NULL),(35,1,'2021-01-08',_binary '\0',NULL,NULL,NULL),(36,1,'2021-01-08',_binary '\0',NULL,NULL,NULL),(37,1,'2021-01-08',_binary '\0',NULL,NULL,NULL),(38,1,'2021-01-08',_binary '\0',NULL,NULL,NULL),(39,1,'2021-01-08',_binary '\0',NULL,NULL,NULL),(40,1,'2021-01-08',_binary '\0',NULL,NULL,NULL),(41,1,'2021-01-08',_binary '\0',NULL,NULL,NULL),(42,1,'2021-01-08',_binary '\0',NULL,NULL,NULL),(43,1,'2021-01-08',_binary '',NULL,NULL,NULL),(44,1,'2021-01-08',_binary '\0',NULL,NULL,NULL),(45,1,'2021-01-08',_binary '\0',NULL,NULL,NULL),(46,1,'2021-01-08',_binary '\0',NULL,NULL,NULL),(47,1,'2021-01-08',_binary '\0',NULL,NULL,NULL),(49,4,'2020-12-15',_binary '\0',NULL,NULL,NULL),(50,1,'2021-01-08',_binary '\0',NULL,NULL,NULL);
/*!40000 ALTER TABLE `cart` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cart_cartitem`
--

DROP TABLE IF EXISTS `cart_cartitem`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cart_cartitem` (
  `CartEntity_id` int NOT NULL,
  `cartitemEntities_id` int NOT NULL,
  UNIQUE KEY `UK_rsw720jkegakvfxmw1s0thgom` (`cartitemEntities_id`),
  KEY `FK39repijm06a6pqlkfl2cig2f8` (`CartEntity_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cart_cartitem`
--

LOCK TABLES `cart_cartitem` WRITE;
/*!40000 ALTER TABLE `cart_cartitem` DISABLE KEYS */;
/*!40000 ALTER TABLE `cart_cartitem` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cartitem`
--

DROP TABLE IF EXISTS `cartitem`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cartitem` (
  `id` int NOT NULL AUTO_INCREMENT,
  `pro_id` int NOT NULL,
  `cart_id` int NOT NULL,
  `quantity` int DEFAULT NULL,
  `sku_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `pro_id` (`pro_id`),
  KEY `cart_id` (`cart_id`),
  KEY `FK8ikf2bq21w99do1oq5ibw02ub` (`sku_id`),
  CONSTRAINT `cartitem_ibfk_1` FOREIGN KEY (`pro_id`) REFERENCES `product` (`id`),
  CONSTRAINT `cartitem_ibfk_2` FOREIGN KEY (`cart_id`) REFERENCES `cart` (`id`),
  CONSTRAINT `FK8ikf2bq21w99do1oq5ibw02ub` FOREIGN KEY (`sku_id`) REFERENCES `sku` (`SKU_id`)
) ENGINE=InnoDB AUTO_INCREMENT=54 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cartitem`
--

LOCK TABLES `cartitem` WRITE;
/*!40000 ALTER TABLE `cartitem` DISABLE KEYS */;
INSERT INTO `cartitem` VALUES (1,1,2,4,NULL),(4,2,13,1,NULL),(5,2,14,1,NULL),(6,2,15,1,NULL),(7,1,16,1,NULL),(8,1,17,1,NULL),(9,1,18,1,NULL),(10,1,19,1,NULL),(11,2,20,3,NULL),(12,1,21,1,NULL),(13,1,22,1,NULL),(14,2,23,1,NULL),(15,2,24,2,NULL),(16,2,25,5,NULL),(17,1,26,2,NULL),(18,1,27,3,NULL),(19,2,27,1,NULL),(20,1,27,1,NULL),(21,1,28,4,NULL),(22,2,28,1,NULL),(23,1,29,5,NULL),(24,2,29,7,NULL),(25,1,30,1,NULL),(26,2,31,5,NULL),(27,1,31,2,NULL),(28,2,32,1,NULL),(29,1,33,1,NULL),(30,1,34,1,NULL),(34,2,35,5,NULL),(35,1,36,1,NULL),(36,1,37,1,NULL),(37,2,37,1,NULL),(38,1,38,2,NULL),(39,2,38,3,NULL),(40,2,39,1,NULL),(41,1,40,1,NULL),(42,2,41,1,NULL),(43,2,42,1,NULL),(44,2,43,1,NULL),(45,1,44,1,NULL),(48,1,46,1,NULL),(51,1,47,1,NULL),(52,2,47,3,NULL),(53,1,50,1,NULL);
/*!40000 ALTER TABLE `cartitem` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `category` (
  `cate_id` int NOT NULL AUTO_INCREMENT,
  `cate_name` varchar(255) NOT NULL,
  PRIMARY KEY (`cate_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES (1,'Giày nike'),(2,'Giày adidas'),(3,'áo thun '),(4,'Áo so mi'),(5,'quan jean'),(6,'quan kaki');
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `color`
--

DROP TABLE IF EXISTS `color`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `color` (
  `color_id` int NOT NULL AUTO_INCREMENT,
  `color_name` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`color_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `color`
--

LOCK TABLES `color` WRITE;
/*!40000 ALTER TABLE `color` DISABLE KEYS */;
INSERT INTO `color` VALUES (1,'Xanh'),(2,'do'),(3,'Tím'),(4,'Vàng'),(5,'Nâu'),(6,'den'),(7,'Hồng');
/*!40000 ALTER TABLE `color` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `contact`
--

DROP TABLE IF EXISTS `contact`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `contact` (
  `id` int NOT NULL AUTO_INCREMENT,
  `email` varchar(255) DEFAULT NULL,
  `mobile` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `subject` varchar(255) DEFAULT NULL,
  `status` int DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contact`
--

LOCK TABLES `contact` WRITE;
/*!40000 ALTER TABLE `contact` DISABLE KEYS */;
/*!40000 ALTER TABLE `contact` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customer` (
  `id` int NOT NULL,
  `address` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `fullname` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product` (
  `id` int NOT NULL AUTO_INCREMENT,
  `image` varchar(50) DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8_general_ci NOT NULL,
  `price` float DEFAULT NULL,
  `cate_id` int NOT NULL,
  `brand_id` int NOT NULL,
  `des` varchar(2000) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `cate_id` (`cate_id`),
  KEY `brand_id` (`brand_id`),
  CONSTRAINT `product_ibfk_1` FOREIGN KEY (`cate_id`) REFERENCES `category` (`cate_id`),
  CONSTRAINT `product_ibfk_2` FOREIGN KEY (`brand_id`) REFERENCES `brand` (`brand_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (1,'jordan-max-200-shoe-C2S1xN.jpg','giày nike air 2021',300,1,2,'<p>Ra m&#7855;t l&#7847;n &#273;&#7847;u v&agrave;o n&#259;m 1982, nh&#7919;ng t&#432;&#7903;ng Air Force ch&#7881; h&#7907;p v&#7899;i d&acirc;n nghi&#7873;n th&#7875; thao</p>\r\n'),(2,'Nike Air Max Impact 2.jpg','Nike Air Max 90 ',3000,1,2,'<p>&#272;&ocirc;i &#273;&#7847;u ti&ecirc;n SaigonSneaker.com mu&#7889;n gi&#7899;i thi&#7879;u cho b&#7841;n ch&iacute;nh l&agrave; huy&#7873;n tho&#7841;i c&#7911;a c&aacute;c t&iacute;n &#273;&#7891; theo &#273;u&#7893;i Retro Runner. Nike Air Max 90 l&#7847;n &#273;&#7847;u &#273;&#432;&#7907;c ra m&#7855;t &#273;&atilde; g&acirc;y b&atilde;o th&#7901;i &#273;i&#7875;m &#273;&oacute;, ng&#432;&#7901;i ng&#432;&#7901;i nh&agrave; nh&agrave; &#273;&#7893; x&ocirc; &#273;i mua Nike Air Max 90 v&igrave; thi&#7871;t k&#7871; &#273;&#7865;p m&#7855;t k&egrave;m theo c&ocirc;ng ngh&#7879; Air l&#7841; l&#7851;m.</p>\r\n'),(3,'aothun1.png','Áo thun tay dài nam',250000,3,5,'<p>D&ugrave; &aacute;o thun ng&#7855;n tay quen thu&#7897;c v&#7899;i c&aacute;c b&#7841;n nam h&#417;n song do th&#7901;i ti&#7871;t &#273;ang chu&#7849;n b&#7883; sang thu n&ecirc;n ch&uacute;ng t&ocirc;i mu&#7889;n gi&#7899;i thi&#7879;u v&#7899;i b&#7841;n m&#7851;u &aacute;o n&agrave;y. Trang ph&#7909;c n&agrave;y c&oacute; th&#7875; n&oacute;i l&agrave; &ldquo;&#273;&oacute;ng &#273;inh&rdquo; cho c&aacute;c ch&agrave;ng v&agrave;o nh&#7919;ng ng&agrave;y giao m&ugrave;a.</p>\r\n'),(4,'somi4.jpg','Áo s&#417; mi nam D506',150000,4,5,'<p>&Aacute;o s&#417; mi nam &nbsp;&#273;&#432;&#7907;c &#273;&aacute;nh gi&aacute; l&agrave; m&#7897;t trong nh&#7919;ng m&oacute;n &#273;&#7891; th&#7901;i trang c&#432;&#803;c &#273;&#7865;p va&#768; phong c&aacute;ch m&agrave; anh ch&agrave;ng n&agrave;o c&#361;ng pha&#777;i co&#769; m&#7897;t chi&ecirc;&#769;c trong tu&#777; qu&acirc;&#768;n a&#769;o.</p>\r\n'),(5,'jean2.jpg','qu&#7847;n Tây cho nam',400000,5,5,'<p>V&#7899;i form d&aacute;ng Slim Fit nh&#7919;ng chi&#7871;c qu&#7847;n t&acirc;y s&#7869; mang &#273;&#7871;n cho b&#7841;n m&#7897;t phong c&aacute;ch tr&#7867; trung, sang tr&#7885;ng nh&#432;ng kh&ocirc;ng k&eacute;m ph&#7847;n l&#7883;ch l&atilde;m.</p>\r\n'),(6,'kaki3.png','Qu&#7847;n Jogger Kaki nam',250000,6,5,'<p>S&#7921; k&#7871;t h&#7907;p gi&#7919;a qu&#7847;n Jogger v&#7899;i ch&#7845;t v&#7843;i kaki &#273;&atilde; &#273;em &#273;&#7871;n m&#7897;t ki&#7875;u qu&#7847;n v&ocirc; c&ugrave;ng ch&#7845;t l&#7915;. N&#7871;u nh&#432; qu&#7847;n short kaki mang &#273;&#7871;n s&#7921; tr&#7867; trung, n&#259;ng &#273;&#7897;ng nh&#432;ng th&iacute;ch h&#7907;p &#273;&#7875; &#273;i ch&#417;i.</p>\r\n'),(7,'3343e085eaad0e9bf4c2f834eb6d2112.jpg','q',2000,1,1,'<p>a</p>\r\n');
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `promotion`
--

DROP TABLE IF EXISTS `promotion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `promotion` (
  `new_id` varchar(20) NOT NULL,
  `new_name` varchar(150) DEFAULT NULL,
  `date_create` date DEFAULT NULL,
  `new_category` varchar(50) DEFAULT NULL,
  `date_open` date DEFAULT NULL,
  `date_close` date DEFAULT NULL,
  PRIMARY KEY (`new_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `promotion`
--

LOCK TABLES `promotion` WRITE;
/*!40000 ALTER TABLE `promotion` DISABLE KEYS */;
/*!40000 ALTER TABLE `promotion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `size`
--

DROP TABLE IF EXISTS `size`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `size` (
  `Size_id` int NOT NULL AUTO_INCREMENT,
  `Size_name` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`Size_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `size`
--

LOCK TABLES `size` WRITE;
/*!40000 ALTER TABLE `size` DISABLE KEYS */;
INSERT INTO `size` VALUES (1,'S'),(2,'M'),(3,'L'),(4,'XL'),(5,'2XL'),(6,'37'),(7,'38'),(8,'39'),(9,'40'),(10,'41');
/*!40000 ALTER TABLE `size` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sku`
--

DROP TABLE IF EXISTS `sku`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sku` (
  `SKU_id` int NOT NULL AUTO_INCREMENT,
  `pro_id` int NOT NULL,
  `color_id` int NOT NULL,
  `size_id` int NOT NULL,
  `quantity` int DEFAULT NULL,
  PRIMARY KEY (`SKU_id`),
  KEY `pro_id` (`pro_id`),
  KEY `color_id` (`color_id`),
  KEY `size_id` (`size_id`),
  CONSTRAINT `sku_ibfk_1` FOREIGN KEY (`pro_id`) REFERENCES `product` (`id`),
  CONSTRAINT `sku_ibfk_2` FOREIGN KEY (`color_id`) REFERENCES `color` (`color_id`),
  CONSTRAINT `sku_ibfk_3` FOREIGN KEY (`size_id`) REFERENCES `size` (`Size_id`)
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sku`
--

LOCK TABLES `sku` WRITE;
/*!40000 ALTER TABLE `sku` DISABLE KEYS */;
INSERT INTO `sku` VALUES (1,1,1,8,5),(2,1,6,1,5),(3,1,5,1,5),(30,2,1,9,5),(31,2,6,1,5),(33,3,1,1,10),(34,3,3,1,100),(35,3,1,2,10),(36,3,1,4,10),(37,5,1,3,5),(39,5,1,2,8),(40,4,1,3,8),(41,4,1,2,10),(42,4,6,1,8),(43,6,5,1,10),(44,6,6,2,11);
/*!40000 ALTER TABLE `sku` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `avatar` varchar(50) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `userName` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(36) NOT NULL,
  `address` varchar(50) DEFAULT NULL,
  `permission` int DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `userName` (`userName`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'image.jpg','huynhtrongnghia1090@gmail.com','phibu','123456','134 Tân V?nh Thu?n',1,'0352407124'),(3,'image.jpg','admin123@gmail.com','Nghĩa Cris','123456','134 Tân Vĩnh Thuận',1,NULL),(4,'image.jpg','anhlakemaiman@gmail.com','Nghĩa','123456','134 Tân Vĩnh Thuận',0,NULL),(5,NULL,'phiphibb11@gmail.com','phibui','Phj9a123456','sg',0,'0352407124');
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

-- Dump completed on 2022-07-31 17:09:29
