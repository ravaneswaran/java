USE stock_market;

-- MySQL dump 10.13  Distrib 8.0.42, for Linux (x86_64)
--
-- Host: localhost    Database: stock_market
-- ------------------------------------------------------
-- Server version	8.0.42-0ubuntu0.24.04.1

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
-- Table structure for table `DATABASECHANGELOG`
--

DROP TABLE IF EXISTS `DATABASECHANGELOG`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `DATABASECHANGELOG` (
  `ID` varchar(255) NOT NULL,
  `AUTHOR` varchar(255) NOT NULL,
  `FILENAME` varchar(255) NOT NULL,
  `DATEEXECUTED` datetime NOT NULL,
  `ORDEREXECUTED` int NOT NULL,
  `EXECTYPE` varchar(10) NOT NULL,
  `MD5SUM` varchar(35) DEFAULT NULL,
  `DESCRIPTION` varchar(255) DEFAULT NULL,
  `COMMENTS` varchar(255) DEFAULT NULL,
  `TAG` varchar(255) DEFAULT NULL,
  `LIQUIBASE` varchar(20) DEFAULT NULL,
  `CONTEXTS` varchar(255) DEFAULT NULL,
  `LABELS` varchar(255) DEFAULT NULL,
  `DEPLOYMENT_ID` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `DATABASECHANGELOG`
--

LOCK TABLES `DATABASECHANGELOG` WRITE;
/*!40000 ALTER TABLE `DATABASECHANGELOG` DISABLE KEYS */;
INSERT INTO `DATABASECHANGELOG` VALUES ('001','Ravaneswaran Chinnasamy','src/main/resources/liquibase/changelogs/bse/bse-active-100-changelog.xml','2025-11-03 20:28:56',1,'EXECUTED','9:0798db58cea22fe93dd2af493217fef0','createTable tableName=bse_active_100','',NULL,'4.31.1',NULL,NULL,'2181933206'),('001','Ravaneswaran Chinnasamy','src/main/resources/liquibase/changelogs/bse/bse-active-100-history-changelog.xml','2025-11-03 20:28:56',2,'EXECUTED','9:bef319e9ffd2a0f340b8641298393741','createTable tableName=bse_active_100_history','',NULL,'4.31.1',NULL,NULL,'2181933206'),('001','Ravaneswaran Chinnasamy','src/main/resources/liquibase/changelogs/bse/bse-active-200-changelog.xml','2025-11-03 20:28:56',3,'EXECUTED','9:8de9bd26debc04cb499473970eb61e5e','createTable tableName=bse_active_200','',NULL,'4.31.1',NULL,NULL,'2181933206'),('001','Ravaneswaran Chinnasamy','src/main/resources/liquibase/changelogs/bse/bse-active-200-history-changelog.xml','2025-11-03 20:28:56',4,'EXECUTED','9:279bd01c4b307c2ff145a644af351d83','createTable tableName=bse_active_200_history','',NULL,'4.31.1',NULL,NULL,'2181933206'),('001','Ravaneswaran Chinnasamy','src/main/resources/liquibase/changelogs/bse/bse-active-500-changelog.xml','2025-11-03 20:28:57',5,'EXECUTED','9:ff9749a6cfd74c1853874ccdc3bf9537','createTable tableName=bse_active_500','',NULL,'4.31.1',NULL,NULL,'2181933206'),('001','Ravaneswaran Chinnasamy','src/main/resources/liquibase/changelogs/bse/bse-active-500-history-changelog.xml','2025-11-03 20:28:57',6,'EXECUTED','9:bfc22f3a21977f5862f7a268f424d39c','createTable tableName=bse_active_500_history','',NULL,'4.31.1',NULL,NULL,'2181933206'),('001','Ravaneswaran Chinnasamy','src/main/resources/liquibase/changelogs/bse/bse-top-dividend-changelog.xml','2025-11-03 20:28:57',7,'EXECUTED','9:7dc7b6affd12018f420c5e8d7c7eb8d2','createTable tableName=bse_top_dividend','',NULL,'4.31.1',NULL,NULL,'2181933206'),('001','Ravaneswaran Chinnasamy','src/main/resources/liquibase/changelogs/bse/bse-small-cap-gainer-changelog.xml','2025-11-03 20:28:57',8,'EXECUTED','9:9b3c0e257359c03c72d506ae9e45d5c4','createTable tableName=bse_small_cap_gainer','',NULL,'4.31.1',NULL,NULL,'2181933206'),('001','Ravaneswaran Chinnasamy','src/main/resources/liquibase/changelogs/bse/bse-mid-cap-gainer-changelog.xml','2025-11-03 20:28:57',9,'EXECUTED','9:d9729ac0d3ed870152ea35b78203ffbc','createTable tableName=bse_mid_cap_gainer','',NULL,'4.31.1',NULL,NULL,'2181933206'),('001','Ravaneswaran Chinnasamy','src/main/resources/liquibase/changelogs/bse/bse-price-shockers-changelog.xml','2025-11-03 20:28:57',10,'EXECUTED','9:fad13c65a20629c721f3da0a86837655','createTable tableName=bse_price_shockers','',NULL,'4.31.1',NULL,NULL,'2181933206'),('001','Ravaneswaran Chinnasamy','src/main/resources/liquibase/changelogs/bse/bse-price-shockers-history-changelog.xml','2025-11-03 20:28:57',11,'EXECUTED','9:7aa21f24f50d5a9fbbcb2597bae7f7e1','createTable tableName=bse_price_shockers_history','',NULL,'4.31.1',NULL,NULL,'2181933206'),('001','Ravaneswaran Chinnasamy','src/main/resources/liquibase/changelogs/bse/bse-volume-shockers-changelog.xml','2025-11-03 20:28:57',12,'EXECUTED','9:e9d4076888afe019ba0be17ce5b156d5','createTable tableName=bse_volume_shockers','',NULL,'4.31.1',NULL,NULL,'2181933206'),('001','Ravaneswaran Chinnasamy','src/main/resources/liquibase/changelogs/bse/bse-volume-shockers-history-changelog.xml','2025-11-03 20:28:57',13,'EXECUTED','9:15bb5cc76dd89e49a8f4906cf2b1e2d0','createTable tableName=bse_volume_shockers_history','',NULL,'4.31.1',NULL,NULL,'2181933206'),('001','Ravaneswaran Chinnasamy','src/main/resources/liquibase/changelogs/bse/bse-sensex-changelog.xml','2025-11-03 20:28:57',14,'EXECUTED','9:4ddd749d1d1d5480048fa1ca48350588','createTable tableName=bse_sensex','',NULL,'4.31.1',NULL,NULL,'2181933206'),('001','Ravaneswaran Chinnasamy','src/main/resources/liquibase/changelogs/bse/bse-stock-base-changelog.xml','2025-11-03 20:28:57',15,'EXECUTED','9:a0a1e2d83d51e29432433530222fa5df','createTable tableName=bse_stock_base','',NULL,'4.31.1',NULL,NULL,'2181933206'),('001','Ravaneswaran Chinnasamy','src/main/resources/liquibase/changelogs/bse/bse-day-price-detail-changelog.xml','2025-11-03 20:28:58',16,'EXECUTED','9:4b09040b30a7e5ebf40fef9a0442324d','createTable tableName=bse_day_price_detail; addForeignKeyConstraint baseTableName=bse_day_price_detail, constraintName=fk_bse_day_price_detail_bse_stock_base, referencedTableName=bse_stock_base','',NULL,'4.31.1',NULL,NULL,'2181933206'),('001','Ravaneswaran Chinnasamy','src/main/resources/liquibase/changelogs/bse/bse-day-price-last-run-detail-changelog.xml','2025-11-03 20:28:58',17,'EXECUTED','9:80e3a5599d8a26ab8248e343024d5741','createTable tableName=bse_day_price_last_run_detail','',NULL,'4.31.1',NULL,NULL,'2181933206'),('002','Ravaneswaran Chinnasamy','src/main/resources/liquibase/changelogs/bse/bse-day-price-last-run-detail-changelog.xml','2025-11-03 20:28:58',18,'EXECUTED','9:94444468dc57f284b1dc6f4a22f03efc','sql','',NULL,'4.31.1',NULL,NULL,'2181933206'),('001','Ravaneswaran Chinnasamy','src/main/resources/liquibase/changelogs/groww/holidays-changelog.xml','2025-11-03 20:28:58',19,'EXECUTED','9:b273dd9bd7631e825b62153ceb3c4636','createTable tableName=holidays','',NULL,'4.31.1',NULL,NULL,'2181933206'),('001','Ravaneswaran Chinnasamy','src/main/resources/liquibase/changelogs/nse/nse-stock-base-changelog.xml','2025-11-03 20:28:58',20,'EXECUTED','9:2580b41f4d12a885927e6bee8e7f224b','createTable tableName=nse_stock_base','',NULL,'4.31.1',NULL,NULL,'2181933206'),('001','Ravaneswaran Chinnasamy','src/main/resources/liquibase/changelogs/nse/nse-day-price-detail-changelog.xml','2025-11-03 20:28:58',21,'EXECUTED','9:4431003409ddd2ac860e45c7033f67b0','createTable tableName=nse_day_price_detail; addForeignKeyConstraint baseTableName=nse_day_price_detail, constraintName=fk_nsedpd_nsesb, referencedTableName=nse_stock_base','',NULL,'4.31.1',NULL,NULL,'2181933206'),('001','Ravaneswaran Chinnasamy','src/main/resources/liquibase/changelogs/nse/nse-pre-open-market-detail-changelog.xml','2025-11-03 20:28:58',22,'EXECUTED','9:c4430eb48e05df7d13288f14ddc128bf','createTable tableName=nse_pre_open_market_detail; addForeignKeyConstraint baseTableName=nse_pre_open_market_detail, constraintName=fk_nse_open_market_nse_stock_base, referencedTableName=nse_stock_base','',NULL,'4.31.1',NULL,NULL,'2181933206'),('001','Ravaneswaran Chinnasamy','src/main/resources/liquibase/changelogs/nse/nse-price-spurt-detail-changelog.xml','2025-11-03 20:28:59',23,'EXECUTED','9:2ad4f9fc4e68264ec842f6f08a08f40f','createTable tableName=nse_price_spurts_detail; addForeignKeyConstraint baseTableName=nse_price_spurts_detail, constraintName=fk_nse_price_spurts_detail_nse_stock_base, referencedTableName=nse_stock_base','',NULL,'4.31.1',NULL,NULL,'2181933206'),('002','Ravaneswaran Chinnasamy','src/main/resources/liquibase/changelogs/nse/nse-price-spurt-detail-changelog.xml','2025-11-03 20:28:59',24,'EXECUTED','9:111054e1c60b741669caa1603731b349','sql','',NULL,'4.31.1',NULL,NULL,'2181933206'),('003','Ravaneswaran Chinnasamy','src/main/resources/liquibase/changelogs/nse/nse-price-spurt-detail-changelog.xml','2025-11-03 20:28:59',25,'EXECUTED','9:5f96c6499ee7e05dac4b65e4d8c0526a','dropForeignKeyConstraint baseTableName=nse_price_spurts_detail, constraintName=fk_nse_price_spurts_detail_nse_stock_base','',NULL,'4.31.1',NULL,NULL,'2181933206'),('004','Ravaneswaran Chinnasamy','src/main/resources/liquibase/changelogs/nse/nse-price-spurt-detail-changelog.xml','2025-11-03 20:28:59',26,'EXECUTED','9:6fd794fa5be90e7969a6fbfd21f8ffee','renameTable newTableName=nse_price_spurt_detail, oldTableName=nse_price_spurts_detail','',NULL,'4.31.1',NULL,NULL,'2181933206'),('005','Ravaneswaran Chinnasamy','src/main/resources/liquibase/changelogs/nse/nse-price-spurt-detail-changelog.xml','2025-11-03 20:28:59',27,'EXECUTED','9:4343c4c50cd89390cea9b39a7af3d2e4','addForeignKeyConstraint baseTableName=nse_price_spurt_detail, constraintName=fk_nse_price_spurt_detail_nse_stock_base, referencedTableName=nse_stock_base','',NULL,'4.31.1',NULL,NULL,'2181933206'),('006','Ravaneswaran Chinnasamy','src/main/resources/liquibase/changelogs/nse/nse-price-spurt-detail-changelog.xml','2025-11-03 20:28:59',28,'EXECUTED','9:98247591d41c43553b6d26b4b0455d54','renameColumn newColumnName=spurt_type, oldColumnName=spurts_type, tableName=nse_price_spurt_detail','',NULL,'4.31.1',NULL,NULL,'2181933206'),('001','Ravaneswaran Chinnasamy','src/main/resources/liquibase/changelogs/nse/nse-volume-spurt-detail-changelog.xml','2025-11-03 20:28:59',29,'EXECUTED','9:f40f14a580348c3af1a4b5f0b5cdf42d','createTable tableName=nse_volume_spurts_detail; addForeignKeyConstraint baseTableName=nse_volume_spurts_detail, constraintName=fk_nse_volume_spurts_detail_nse_stock_base, referencedTableName=nse_stock_base','',NULL,'4.31.1',NULL,NULL,'2181933206'),('002','Ravaneswaran Chinnasamy','src/main/resources/liquibase/changelogs/nse/nse-volume-spurt-detail-changelog.xml','2025-11-03 20:28:59',30,'EXECUTED','9:e69894294a452eceffe2e469c50ea3b1','dropForeignKeyConstraint baseTableName=nse_volume_spurts_detail, constraintName=fk_nse_volume_spurts_detail_nse_stock_base','',NULL,'4.31.1',NULL,NULL,'2181933206'),('003','Ravaneswaran Chinnasamy','src/main/resources/liquibase/changelogs/nse/nse-volume-spurt-detail-changelog.xml','2025-11-03 20:28:59',31,'EXECUTED','9:9d203e214af7bf13c8be842046377d29','renameTable newTableName=nse_volume_spurt_detail, oldTableName=nse_volume_spurts_detail','',NULL,'4.31.1',NULL,NULL,'2181933206'),('004','Ravaneswaran Chinnasamy','src/main/resources/liquibase/changelogs/nse/nse-volume-spurt-detail-changelog.xml','2025-11-03 20:29:00',32,'EXECUTED','9:8a60a2c0bdceea42244ead86feaa5e91','addForeignKeyConstraint baseTableName=nse_volume_spurt_detail, constraintName=fk_nse_volume_spurt_detail_nse_stock_base, referencedTableName=nse_stock_base','',NULL,'4.31.1',NULL,NULL,'2181933206'),('001','Ravaneswaran Chinnasamy','src/main/resources/liquibase/changelogs/nse/nse-sme-detail-changelog.xml','2025-11-03 20:29:00',33,'EXECUTED','9:cd3a9a571dda5ebca437006198915f3a','createTable tableName=nse_sme_detail; addForeignKeyConstraint baseTableName=nse_sme_detail, constraintName=fk_nse_sme_detail_nse_stock_base, referencedTableName=nse_stock_base','',NULL,'4.31.1',NULL,NULL,'2181933206'),('001','Ravaneswaran Chinnasamy','src/main/resources/liquibase/changelogs/nse/nse-main-board-detail-changelog.xml','2025-11-03 20:29:00',34,'EXECUTED','9:01661f7e426cbfd26b78d23a2978baa2','createTable tableName=nse_main_board_detail; addForeignKeyConstraint baseTableName=nse_main_board_detail, constraintName=fk_nse_main_board_detail_nse_stock_base, referencedTableName=nse_stock_base','',NULL,'4.31.1',NULL,NULL,'2181933206'),('002','Ravaneswaran Chinnasamy','src/main/resources/liquibase/changelogs/nse/nse-main-board-detail-changelog.xml','2025-11-03 20:29:00',35,'EXECUTED','9:eb347f2d5bfc94580c82a0002544bb3c','renameColumn newColumnName=volume_in_shares, oldColumnName=volume, tableName=nse_main_board_detail; renameColumn newColumnName=value_in_lakhs, oldColumnName=value, tableName=nse_main_board_detail','',NULL,'4.31.1',NULL,NULL,'2181933206'),('001','Ravaneswaran Chinnasamy','src/main/resources/liquibase/changelogs/nse/nse-etf-detail-changelog.xml','2025-11-03 20:29:00',36,'EXECUTED','9:ceb5c8de860211daab50aa5b16e24fcc','createTable tableName=nse_etf_detail; addForeignKeyConstraint baseTableName=nse_etf_detail, constraintName=fk_nse_eft_detail_nse_stock_base, referencedTableName=nse_stock_base','',NULL,'4.31.1',NULL,NULL,'2181933206'),('001','Ravaneswaran Chinnasamy','src/main/resources/liquibase/changelogs/nse/nse-top20-detail-changelog.xml','2025-11-03 20:29:01',37,'EXECUTED','9:d7c2012e08a7b47d0fc8c79d603902bd','createTable tableName=nse_top20_detail; addForeignKeyConstraint baseTableName=nse_top20_detail, constraintName=fk_nse_top20_detail_nse_stock_base, referencedTableName=nse_stock_base','',NULL,'4.31.1',NULL,NULL,'2181933206'),('002','Ravaneswaran Chinnasamy','src/main/resources/liquibase/changelogs/nse/nse-top20-detail-changelog.xml','2025-11-03 20:29:01',38,'EXECUTED','9:172a524ed3294c45f69e65852854abf6','sql','',NULL,'4.31.1',NULL,NULL,'2181933206'),('001','Ravaneswaran Chinnasamy','src/main/resources/liquibase/changelogs/nse/nse-day-block-deal-detail-changelog.xml','2025-11-03 20:29:01',39,'EXECUTED','9:7c98ea69a6b2c83f601cbdf1c531046a','createTable tableName=nse_day_block_deal_detail; addForeignKeyConstraint baseTableName=nse_day_block_deal_detail, constraintName=fk_nse_day_block_deal_detail_nse_stock_base, referencedTableName=nse_stock_base','',NULL,'4.31.1',NULL,NULL,'2181933206'),('002','Ravaneswaran Chinnasamy','src/main/resources/liquibase/changelogs/nse/nse-day-block-deal-detail-changelog.xml','2025-11-03 20:29:01',40,'EXECUTED','9:8151e71002e505d356deedeca09824b8','dropColumn columnName=previous_close_price, tableName=nse_day_block_deal_detail','',NULL,'4.31.1',NULL,NULL,'2181933206'),('001','Ravaneswaran Chinnasamy','src/main/resources/liquibase/changelogs/nse/nse-day-bulk-deal-detail-changelog.xml','2025-11-03 20:29:01',41,'EXECUTED','9:bd4fdcc46465016b8f1bdac3e35f2959','createTable tableName=nse_day_bulk_deal_detail; addForeignKeyConstraint baseTableName=nse_day_bulk_deal_detail, constraintName=fk_nse_day_bulk_deal_detail_nse_stock_base, referencedTableName=nse_stock_base','',NULL,'4.31.1',NULL,NULL,'2181933206'),('001','Ravaneswaran Chinnasamy','src/main/resources/liquibase/changelogs/nse/nse-day-short-sell-detail-changelog.xml','2025-11-03 20:29:02',42,'EXECUTED','9:67b6e6a214d3cf3f10bfc615f366ef84','createTable tableName=nse_day_short_sell_detail; addForeignKeyConstraint baseTableName=nse_day_bulk_deal_detail, constraintName=fk_nse_day_short_sell_detail_nse_stock_base, referencedTableName=nse_stock_base','',NULL,'4.31.1',NULL,NULL,'2181933206'),('001','Ravaneswaran Chinnasamy','src/main/resources/liquibase/changelogs/nse/nse-day-price-last-run-detail-changelog.xml','2025-11-03 20:29:02',43,'EXECUTED','9:0f8bfef32d880c4b054fbcbc86bbd218','createTable tableName=nse_day_price_last_run_detail','',NULL,'4.31.1',NULL,NULL,'2181933206'),('002','Ravaneswaran Chinnasamy','src/main/resources/liquibase/changelogs/nse/nse-day-price-last-run-detail-changelog.xml','2025-11-03 20:29:02',44,'EXECUTED','9:e4cbc5b0322387594549ca8642ed1c16','sql','',NULL,'4.31.1',NULL,NULL,'2181933206'),('001','Ravaneswaran Chinnasamy','src/main/resources/liquibase/changelogs/quartz/quartz-scheduler-changelog.xml','2025-11-03 20:29:02',45,'EXECUTED','9:8fb06be051971ada7caff9086f2780da','sql','',NULL,'4.31.1',NULL,NULL,'2181933206'),('002','Ravaneswaran Chinnasamy','src/main/resources/liquibase/changelogs/quartz/quartz-scheduler-changelog.xml','2025-11-03 20:29:02',46,'EXECUTED','9:8db8764f56ad07fae8854b3055f3fe24','sql','',NULL,'4.31.1',NULL,NULL,'2181933206'),('003','Ravaneswaran Chinnasamy','src/main/resources/liquibase/changelogs/quartz/quartz-scheduler-changelog.xml','2025-11-03 20:29:02',47,'EXECUTED','9:71a4d02fcbcc96093579d29001fe4501','sql','',NULL,'4.31.1',NULL,NULL,'2181933206'),('004','Ravaneswaran Chinnasamy','src/main/resources/liquibase/changelogs/quartz/quartz-scheduler-changelog.xml','2025-11-03 20:29:02',48,'EXECUTED','9:6579fb03066df47f4edaf0bf616858bb','sql','',NULL,'4.31.1',NULL,NULL,'2181933206'),('005','Ravaneswaran Chinnasamy','src/main/resources/liquibase/changelogs/quartz/quartz-scheduler-changelog.xml','2025-11-03 20:29:02',49,'EXECUTED','9:a38fa89de39da81ca95a5ece1510452f','sql','',NULL,'4.31.1',NULL,NULL,'2181933206'),('006','Ravaneswaran Chinnasamy','src/main/resources/liquibase/changelogs/quartz/quartz-scheduler-changelog.xml','2025-11-03 20:29:02',50,'EXECUTED','9:cfa9a76c7bcfde8d8bc66fb3fb186d44','sql','',NULL,'4.31.1',NULL,NULL,'2181933206'),('007','Ravaneswaran Chinnasamy','src/main/resources/liquibase/changelogs/quartz/quartz-scheduler-changelog.xml','2025-11-03 20:29:02',51,'EXECUTED','9:b58c33c14280baa6b46c0675af5ef550','sql','',NULL,'4.31.1',NULL,NULL,'2181933206'),('008','Ravaneswaran Chinnasamy','src/main/resources/liquibase/changelogs/quartz/quartz-scheduler-changelog.xml','2025-11-03 20:29:02',52,'EXECUTED','9:93b332bd12dc54a05955e685eaa9842d','sql','',NULL,'4.31.1',NULL,NULL,'2181933206'),('009','Ravaneswaran Chinnasamy','src/main/resources/liquibase/changelogs/quartz/quartz-scheduler-changelog.xml','2025-11-03 20:29:02',53,'EXECUTED','9:23d5d536bd8806c97b8342abe46fa163','sql','',NULL,'4.31.1',NULL,NULL,'2181933206'),('010','Ravaneswaran Chinnasamy','src/main/resources/liquibase/changelogs/quartz/quartz-scheduler-changelog.xml','2025-11-03 20:29:03',54,'EXECUTED','9:67bda7f7c6e86894fc17c5a2f557c972','sql','',NULL,'4.31.1',NULL,NULL,'2181933206'),('011','Ravaneswaran Chinnasamy','src/main/resources/liquibase/changelogs/quartz/quartz-scheduler-changelog.xml','2025-11-03 20:29:03',55,'EXECUTED','9:e103e7af63fd6e48a999db3857a2e81b','sql','',NULL,'4.31.1',NULL,NULL,'2181933206');
/*!40000 ALTER TABLE `DATABASECHANGELOG` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `DATABASECHANGELOGLOCK`
--

DROP TABLE IF EXISTS `DATABASECHANGELOGLOCK`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `DATABASECHANGELOGLOCK` (
  `ID` int NOT NULL,
  `LOCKED` tinyint NOT NULL,
  `LOCKGRANTED` datetime DEFAULT NULL,
  `LOCKEDBY` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `DATABASECHANGELOGLOCK`
--

LOCK TABLES `DATABASECHANGELOGLOCK` WRITE;
/*!40000 ALTER TABLE `DATABASECHANGELOGLOCK` DISABLE KEYS */;
INSERT INTO `DATABASECHANGELOGLOCK` VALUES (1,0,NULL,NULL);
/*!40000 ALTER TABLE `DATABASECHANGELOGLOCK` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `QUARTZ_BLOB_TRIGGERS`
--

DROP TABLE IF EXISTS `QUARTZ_BLOB_TRIGGERS`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `QUARTZ_BLOB_TRIGGERS` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `TRIGGER_NAME` varchar(200) NOT NULL,
  `TRIGGER_GROUP` varchar(200) NOT NULL,
  `BLOB_DATA` blob,
  PRIMARY KEY (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`),
  CONSTRAINT `QUARTZ_BLOB_TRIGGERS_ibfk_1` FOREIGN KEY (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) REFERENCES `QUARTZ_TRIGGERS` (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `QUARTZ_BLOB_TRIGGERS`
--

LOCK TABLES `QUARTZ_BLOB_TRIGGERS` WRITE;
/*!40000 ALTER TABLE `QUARTZ_BLOB_TRIGGERS` DISABLE KEYS */;
/*!40000 ALTER TABLE `QUARTZ_BLOB_TRIGGERS` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `QUARTZ_CALENDARS`
--

DROP TABLE IF EXISTS `QUARTZ_CALENDARS`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `QUARTZ_CALENDARS` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `CALENDAR_NAME` varchar(200) NOT NULL,
  `CALENDAR` blob NOT NULL,
  PRIMARY KEY (`SCHED_NAME`,`CALENDAR_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `QUARTZ_CALENDARS`
--

LOCK TABLES `QUARTZ_CALENDARS` WRITE;
/*!40000 ALTER TABLE `QUARTZ_CALENDARS` DISABLE KEYS */;
/*!40000 ALTER TABLE `QUARTZ_CALENDARS` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `QUARTZ_CRON_TRIGGERS`
--

DROP TABLE IF EXISTS `QUARTZ_CRON_TRIGGERS`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `QUARTZ_CRON_TRIGGERS` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `TRIGGER_NAME` varchar(200) NOT NULL,
  `TRIGGER_GROUP` varchar(200) NOT NULL,
  `CRON_EXPRESSION` varchar(200) NOT NULL,
  `TIME_ZONE_ID` varchar(80) DEFAULT NULL,
  PRIMARY KEY (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`),
  CONSTRAINT `QUARTZ_CRON_TRIGGERS_ibfk_1` FOREIGN KEY (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) REFERENCES `QUARTZ_TRIGGERS` (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `QUARTZ_CRON_TRIGGERS`
--

LOCK TABLES `QUARTZ_CRON_TRIGGERS` WRITE;
/*!40000 ALTER TABLE `QUARTZ_CRON_TRIGGERS` DISABLE KEYS */;
/*!40000 ALTER TABLE `QUARTZ_CRON_TRIGGERS` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `QUARTZ_FIRED_TRIGGERS`
--

DROP TABLE IF EXISTS `QUARTZ_FIRED_TRIGGERS`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `QUARTZ_FIRED_TRIGGERS` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `ENTRY_ID` varchar(95) NOT NULL,
  `TRIGGER_NAME` varchar(200) NOT NULL,
  `TRIGGER_GROUP` varchar(200) NOT NULL,
  `INSTANCE_NAME` varchar(200) NOT NULL,
  `FIRED_TIME` bigint NOT NULL,
  `SCHED_TIME` bigint NOT NULL,
  `PRIORITY` int NOT NULL,
  `STATE` varchar(16) NOT NULL,
  `JOB_NAME` varchar(200) DEFAULT NULL,
  `JOB_GROUP` varchar(200) DEFAULT NULL,
  `IS_NONCONCURRENT` varchar(1) DEFAULT NULL,
  `REQUESTS_RECOVERY` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`SCHED_NAME`,`ENTRY_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `QUARTZ_FIRED_TRIGGERS`
--

LOCK TABLES `QUARTZ_FIRED_TRIGGERS` WRITE;
/*!40000 ALTER TABLE `QUARTZ_FIRED_TRIGGERS` DISABLE KEYS */;
/*!40000 ALTER TABLE `QUARTZ_FIRED_TRIGGERS` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `QUARTZ_JOB_DETAILS`
--

DROP TABLE IF EXISTS `QUARTZ_JOB_DETAILS`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `QUARTZ_JOB_DETAILS` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `JOB_NAME` varchar(200) NOT NULL,
  `JOB_GROUP` varchar(200) NOT NULL,
  `DESCRIPTION` varchar(250) DEFAULT NULL,
  `JOB_CLASS_NAME` varchar(250) NOT NULL,
  `IS_DURABLE` varchar(1) NOT NULL,
  `IS_NONCONCURRENT` varchar(1) NOT NULL,
  `IS_UPDATE_DATA` varchar(1) NOT NULL,
  `REQUESTS_RECOVERY` varchar(1) NOT NULL,
  `JOB_DATA` blob,
  PRIMARY KEY (`SCHED_NAME`,`JOB_NAME`,`JOB_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `QUARTZ_JOB_DETAILS`
--

LOCK TABLES `QUARTZ_JOB_DETAILS` WRITE;
/*!40000 ALTER TABLE `QUARTZ_JOB_DETAILS` DISABLE KEYS */;
/*!40000 ALTER TABLE `QUARTZ_JOB_DETAILS` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `QUARTZ_LOCKS`
--

DROP TABLE IF EXISTS `QUARTZ_LOCKS`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `QUARTZ_LOCKS` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `LOCK_NAME` varchar(40) NOT NULL,
  PRIMARY KEY (`SCHED_NAME`,`LOCK_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `QUARTZ_LOCKS`
--

LOCK TABLES `QUARTZ_LOCKS` WRITE;
/*!40000 ALTER TABLE `QUARTZ_LOCKS` DISABLE KEYS */;
/*!40000 ALTER TABLE `QUARTZ_LOCKS` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `QUARTZ_PAUSED_TRIGGER_GRPS`
--

DROP TABLE IF EXISTS `QUARTZ_PAUSED_TRIGGER_GRPS`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `QUARTZ_PAUSED_TRIGGER_GRPS` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `TRIGGER_GROUP` varchar(200) NOT NULL,
  PRIMARY KEY (`SCHED_NAME`,`TRIGGER_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `QUARTZ_PAUSED_TRIGGER_GRPS`
--

LOCK TABLES `QUARTZ_PAUSED_TRIGGER_GRPS` WRITE;
/*!40000 ALTER TABLE `QUARTZ_PAUSED_TRIGGER_GRPS` DISABLE KEYS */;
/*!40000 ALTER TABLE `QUARTZ_PAUSED_TRIGGER_GRPS` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `QUARTZ_SCHEDULER_STATE`
--

DROP TABLE IF EXISTS `QUARTZ_SCHEDULER_STATE`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `QUARTZ_SCHEDULER_STATE` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `INSTANCE_NAME` varchar(200) NOT NULL,
  `LAST_CHECKIN_TIME` bigint NOT NULL,
  `CHECKIN_INTERVAL` bigint NOT NULL,
  PRIMARY KEY (`SCHED_NAME`,`INSTANCE_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `QUARTZ_SCHEDULER_STATE`
--

LOCK TABLES `QUARTZ_SCHEDULER_STATE` WRITE;
/*!40000 ALTER TABLE `QUARTZ_SCHEDULER_STATE` DISABLE KEYS */;
/*!40000 ALTER TABLE `QUARTZ_SCHEDULER_STATE` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `QUARTZ_SIMPLE_TRIGGERS`
--

DROP TABLE IF EXISTS `QUARTZ_SIMPLE_TRIGGERS`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `QUARTZ_SIMPLE_TRIGGERS` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `TRIGGER_NAME` varchar(200) NOT NULL,
  `TRIGGER_GROUP` varchar(200) NOT NULL,
  `REPEAT_COUNT` bigint NOT NULL,
  `REPEAT_INTERVAL` bigint NOT NULL,
  `TIMES_TRIGGERED` bigint NOT NULL,
  PRIMARY KEY (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`),
  CONSTRAINT `QUARTZ_SIMPLE_TRIGGERS_ibfk_1` FOREIGN KEY (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) REFERENCES `QUARTZ_TRIGGERS` (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `QUARTZ_SIMPLE_TRIGGERS`
--

LOCK TABLES `QUARTZ_SIMPLE_TRIGGERS` WRITE;
/*!40000 ALTER TABLE `QUARTZ_SIMPLE_TRIGGERS` DISABLE KEYS */;
/*!40000 ALTER TABLE `QUARTZ_SIMPLE_TRIGGERS` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `QUARTZ_SIMPROP_TRIGGERS`
--

DROP TABLE IF EXISTS `QUARTZ_SIMPROP_TRIGGERS`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `QUARTZ_SIMPROP_TRIGGERS` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `TRIGGER_NAME` varchar(200) NOT NULL,
  `TRIGGER_GROUP` varchar(200) NOT NULL,
  `STR_PROP_1` varchar(512) DEFAULT NULL,
  `STR_PROP_2` varchar(512) DEFAULT NULL,
  `STR_PROP_3` varchar(512) DEFAULT NULL,
  `INT_PROP_1` int DEFAULT NULL,
  `INT_PROP_2` int DEFAULT NULL,
  `LONG_PROP_1` bigint DEFAULT NULL,
  `LONG_PROP_2` bigint DEFAULT NULL,
  `DEC_PROP_1` decimal(13,4) DEFAULT NULL,
  `DEC_PROP_2` decimal(13,4) DEFAULT NULL,
  `BOOL_PROP_1` varchar(1) DEFAULT NULL,
  `BOOL_PROP_2` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`),
  CONSTRAINT `QUARTZ_SIMPROP_TRIGGERS_ibfk_1` FOREIGN KEY (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) REFERENCES `QUARTZ_TRIGGERS` (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `QUARTZ_SIMPROP_TRIGGERS`
--

LOCK TABLES `QUARTZ_SIMPROP_TRIGGERS` WRITE;
/*!40000 ALTER TABLE `QUARTZ_SIMPROP_TRIGGERS` DISABLE KEYS */;
/*!40000 ALTER TABLE `QUARTZ_SIMPROP_TRIGGERS` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `QUARTZ_TRIGGERS`
--

DROP TABLE IF EXISTS `QUARTZ_TRIGGERS`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `QUARTZ_TRIGGERS` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `TRIGGER_NAME` varchar(200) NOT NULL,
  `TRIGGER_GROUP` varchar(200) NOT NULL,
  `JOB_NAME` varchar(200) NOT NULL,
  `JOB_GROUP` varchar(200) NOT NULL,
  `DESCRIPTION` varchar(250) DEFAULT NULL,
  `NEXT_FIRE_TIME` bigint DEFAULT NULL,
  `PREV_FIRE_TIME` bigint DEFAULT NULL,
  `PRIORITY` int DEFAULT NULL,
  `TRIGGER_STATE` varchar(16) NOT NULL,
  `TRIGGER_TYPE` varchar(8) NOT NULL,
  `START_TIME` bigint NOT NULL,
  `END_TIME` bigint DEFAULT NULL,
  `CALENDAR_NAME` varchar(200) DEFAULT NULL,
  `MISFIRE_INSTR` smallint DEFAULT NULL,
  `JOB_DATA` blob,
  PRIMARY KEY (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`),
  KEY `SCHED_NAME` (`SCHED_NAME`,`JOB_NAME`,`JOB_GROUP`),
  CONSTRAINT `QUARTZ_TRIGGERS_ibfk_1` FOREIGN KEY (`SCHED_NAME`, `JOB_NAME`, `JOB_GROUP`) REFERENCES `QUARTZ_JOB_DETAILS` (`SCHED_NAME`, `JOB_NAME`, `JOB_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `QUARTZ_TRIGGERS`
--

LOCK TABLES `QUARTZ_TRIGGERS` WRITE;
/*!40000 ALTER TABLE `QUARTZ_TRIGGERS` DISABLE KEYS */;
/*!40000 ALTER TABLE `QUARTZ_TRIGGERS` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bse_active_100`
--

DROP TABLE IF EXISTS `bse_active_100`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bse_active_100` (
  `stock_name` varchar(100) NOT NULL,
  `category` varchar(100) DEFAULT NULL,
  `high` varchar(100) DEFAULT NULL,
  `low` varchar(100) DEFAULT NULL,
  `last_price` varchar(100) DEFAULT NULL,
  `last_price_movement` varchar(1000) DEFAULT NULL,
  `percentage_change` varchar(100) DEFAULT NULL,
  `value_in_crores` varchar(100) DEFAULT NULL,
  `average_volume_5d` varchar(100) DEFAULT NULL,
  `average_volume_10d` varchar(100) DEFAULT NULL,
  `average_volume_30d` varchar(100) DEFAULT NULL,
  `price_to_earning_ratio` varchar(100) DEFAULT NULL,
  `price_to_book_ratio` varchar(100) DEFAULT NULL,
  `upper_circuit` varchar(100) DEFAULT NULL,
  `lower_circuit` varchar(100) DEFAULT NULL,
  `volume_weighted_average_price` varchar(100) DEFAULT NULL,
  `displaced_moving_average_30d` varchar(100) DEFAULT NULL,
  `displaced_moving_average_50d` varchar(100) DEFAULT NULL,
  `displaced_moving_average_150d` varchar(100) DEFAULT NULL,
  `displaced_moving_average_200d` varchar(100) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `modified_date` datetime DEFAULT NULL,
  `created_by` varchar(100) DEFAULT NULL,
  `modified_by` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`stock_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bse_active_100`
--

LOCK TABLES `bse_active_100` WRITE;
/*!40000 ALTER TABLE `bse_active_100` DISABLE KEYS */;
/*!40000 ALTER TABLE `bse_active_100` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bse_active_100_history`
--

DROP TABLE IF EXISTS `bse_active_100_history`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bse_active_100_history` (
  `stock_name` varchar(100) DEFAULT NULL,
  `category` varchar(100) DEFAULT NULL,
  `high` varchar(100) DEFAULT NULL,
  `low` varchar(100) DEFAULT NULL,
  `last_price` varchar(100) DEFAULT NULL,
  `last_price_movement` varchar(1000) DEFAULT NULL,
  `percentage_change` varchar(100) DEFAULT NULL,
  `value_in_crores` varchar(100) DEFAULT NULL,
  `average_volume_5d` varchar(100) DEFAULT NULL,
  `average_volume_10d` varchar(100) DEFAULT NULL,
  `average_volume_30d` varchar(100) DEFAULT NULL,
  `price_to_earning_ratio` varchar(100) DEFAULT NULL,
  `price_to_book_ratio` varchar(100) DEFAULT NULL,
  `upper_circuit` varchar(100) DEFAULT NULL,
  `lower_circuit` varchar(100) DEFAULT NULL,
  `volume_weighted_average_price` varchar(100) DEFAULT NULL,
  `displaced_moving_average_30d` varchar(100) DEFAULT NULL,
  `displaced_moving_average_50d` varchar(100) DEFAULT NULL,
  `displaced_moving_average_150d` varchar(100) DEFAULT NULL,
  `displaced_moving_average_200d` varchar(100) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `modified_date` datetime DEFAULT NULL,
  `created_by` varchar(100) DEFAULT NULL,
  `modified_by` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bse_active_100_history`
--

LOCK TABLES `bse_active_100_history` WRITE;
/*!40000 ALTER TABLE `bse_active_100_history` DISABLE KEYS */;
/*!40000 ALTER TABLE `bse_active_100_history` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bse_active_200`
--

DROP TABLE IF EXISTS `bse_active_200`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bse_active_200` (
  `stock_name` varchar(100) NOT NULL,
  `category` varchar(100) DEFAULT NULL,
  `high` varchar(100) DEFAULT NULL,
  `low` varchar(100) DEFAULT NULL,
  `last_price` varchar(100) DEFAULT NULL,
  `last_price_movement` varchar(1000) DEFAULT NULL,
  `percentage_change` varchar(100) DEFAULT NULL,
  `value_in_crores` varchar(100) DEFAULT NULL,
  `average_volume_5d` varchar(100) DEFAULT NULL,
  `average_volume_10d` varchar(100) DEFAULT NULL,
  `average_volume_30d` varchar(100) DEFAULT NULL,
  `price_to_earning_ratio` varchar(100) DEFAULT NULL,
  `price_to_book_ratio` varchar(100) DEFAULT NULL,
  `upper_circuit` varchar(100) DEFAULT NULL,
  `lower_circuit` varchar(100) DEFAULT NULL,
  `volume_weighted_average_price` varchar(100) DEFAULT NULL,
  `displaced_moving_average_30d` varchar(100) DEFAULT NULL,
  `displaced_moving_average_50d` varchar(100) DEFAULT NULL,
  `displaced_moving_average_150d` varchar(100) DEFAULT NULL,
  `displaced_moving_average_200d` varchar(100) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `modified_date` datetime DEFAULT NULL,
  `created_by` varchar(100) DEFAULT NULL,
  `modified_by` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`stock_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bse_active_200`
--

LOCK TABLES `bse_active_200` WRITE;
/*!40000 ALTER TABLE `bse_active_200` DISABLE KEYS */;
/*!40000 ALTER TABLE `bse_active_200` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bse_active_200_history`
--

DROP TABLE IF EXISTS `bse_active_200_history`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bse_active_200_history` (
  `stock_name` varchar(100) DEFAULT NULL,
  `category` varchar(100) DEFAULT NULL,
  `high` varchar(100) DEFAULT NULL,
  `low` varchar(100) DEFAULT NULL,
  `last_price` varchar(100) DEFAULT NULL,
  `last_price_movement` varchar(1000) DEFAULT NULL,
  `percentage_change` varchar(100) DEFAULT NULL,
  `value_in_crores` varchar(100) DEFAULT NULL,
  `average_volume_5d` varchar(100) DEFAULT NULL,
  `average_volume_10d` varchar(100) DEFAULT NULL,
  `average_volume_30d` varchar(100) DEFAULT NULL,
  `price_to_earning_ratio` varchar(100) DEFAULT NULL,
  `price_to_book_ratio` varchar(100) DEFAULT NULL,
  `upper_circuit` varchar(100) DEFAULT NULL,
  `lower_circuit` varchar(100) DEFAULT NULL,
  `volume_weighted_average_price` varchar(100) DEFAULT NULL,
  `displaced_moving_average_30d` varchar(100) DEFAULT NULL,
  `displaced_moving_average_50d` varchar(100) DEFAULT NULL,
  `displaced_moving_average_150d` varchar(100) DEFAULT NULL,
  `displaced_moving_average_200d` varchar(100) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `modified_date` datetime DEFAULT NULL,
  `created_by` varchar(100) DEFAULT NULL,
  `modified_by` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bse_active_200_history`
--

LOCK TABLES `bse_active_200_history` WRITE;
/*!40000 ALTER TABLE `bse_active_200_history` DISABLE KEYS */;
/*!40000 ALTER TABLE `bse_active_200_history` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bse_active_500`
--

DROP TABLE IF EXISTS `bse_active_500`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bse_active_500` (
  `stock_name` varchar(100) NOT NULL,
  `category` varchar(100) DEFAULT NULL,
  `high` varchar(100) DEFAULT NULL,
  `low` varchar(100) DEFAULT NULL,
  `last_price` varchar(100) DEFAULT NULL,
  `last_price_movement` varchar(1000) DEFAULT NULL,
  `percentage_change` varchar(100) DEFAULT NULL,
  `value_in_crores` varchar(100) DEFAULT NULL,
  `average_volume_5d` varchar(100) DEFAULT NULL,
  `average_volume_10d` varchar(100) DEFAULT NULL,
  `average_volume_30d` varchar(100) DEFAULT NULL,
  `price_to_earning_ratio` varchar(100) DEFAULT NULL,
  `price_to_book_ratio` varchar(100) DEFAULT NULL,
  `upper_circuit` varchar(100) DEFAULT NULL,
  `lower_circuit` varchar(100) DEFAULT NULL,
  `volume_weighted_average_price` varchar(100) DEFAULT NULL,
  `displaced_moving_average_30d` varchar(100) DEFAULT NULL,
  `displaced_moving_average_50d` varchar(100) DEFAULT NULL,
  `displaced_moving_average_150d` varchar(100) DEFAULT NULL,
  `displaced_moving_average_200d` varchar(100) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `modified_date` datetime DEFAULT NULL,
  `created_by` varchar(100) DEFAULT NULL,
  `modified_by` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`stock_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bse_active_500`
--

LOCK TABLES `bse_active_500` WRITE;
/*!40000 ALTER TABLE `bse_active_500` DISABLE KEYS */;
/*!40000 ALTER TABLE `bse_active_500` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bse_active_500_history`
--

DROP TABLE IF EXISTS `bse_active_500_history`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bse_active_500_history` (
  `stock_name` varchar(100) DEFAULT NULL,
  `category` varchar(100) DEFAULT NULL,
  `high` varchar(100) DEFAULT NULL,
  `low` varchar(100) DEFAULT NULL,
  `last_price` varchar(100) DEFAULT NULL,
  `last_price_movement` varchar(1000) DEFAULT NULL,
  `percentage_change` varchar(100) DEFAULT NULL,
  `value_in_crores` varchar(100) DEFAULT NULL,
  `average_volume_5d` varchar(100) DEFAULT NULL,
  `average_volume_10d` varchar(100) DEFAULT NULL,
  `average_volume_30d` varchar(100) DEFAULT NULL,
  `price_to_earning_ratio` varchar(100) DEFAULT NULL,
  `price_to_book_ratio` varchar(100) DEFAULT NULL,
  `upper_circuit` varchar(100) DEFAULT NULL,
  `lower_circuit` varchar(100) DEFAULT NULL,
  `volume_weighted_average_price` varchar(100) DEFAULT NULL,
  `displaced_moving_average_30d` varchar(100) DEFAULT NULL,
  `displaced_moving_average_50d` varchar(100) DEFAULT NULL,
  `displaced_moving_average_150d` varchar(100) DEFAULT NULL,
  `displaced_moving_average_200d` varchar(100) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `modified_date` datetime DEFAULT NULL,
  `created_by` varchar(100) DEFAULT NULL,
  `modified_by` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bse_active_500_history`
--

LOCK TABLES `bse_active_500_history` WRITE;
/*!40000 ALTER TABLE `bse_active_500_history` DISABLE KEYS */;
/*!40000 ALTER TABLE `bse_active_500_history` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bse_day_price_detail`
--

DROP TABLE IF EXISTS `bse_day_price_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bse_day_price_detail` (
  `id` varchar(100) NOT NULL,
  `stock_base_id` varchar(100) DEFAULT NULL,
  `traded_date` datetime DEFAULT NULL,
  `business_date` datetime DEFAULT NULL,
  `segment` varchar(100) DEFAULT NULL,
  `financial_instrument_type` varchar(100) DEFAULT NULL,
  `financial_instrument_id` varchar(100) DEFAULT NULL,
  `isi_number` varchar(100) DEFAULT NULL,
  `ticker_symbol` varchar(100) DEFAULT NULL,
  `security_series` varchar(100) DEFAULT NULL,
  `expiry_date` datetime DEFAULT NULL,
  `financial_instrument_actual_expiry_date` datetime DEFAULT NULL,
  `strike_price` double DEFAULT NULL,
  `option_type` varchar(100) DEFAULT NULL,
  `financial_instrument_name` varchar(100) DEFAULT NULL,
  `open_price` double DEFAULT NULL,
  `high_price` double DEFAULT NULL,
  `low_price` double DEFAULT NULL,
  `close_price` double DEFAULT NULL,
  `last_price` double DEFAULT NULL,
  `previous_close_price` double DEFAULT NULL,
  `underlying_price` double DEFAULT NULL,
  `settlement_price` double DEFAULT NULL,
  `open_interest` double DEFAULT NULL,
  `change_in_open_interest` varchar(100) DEFAULT NULL,
  `total_traded_volume` double DEFAULT NULL,
  `total_traded_value` double DEFAULT NULL,
  `total_number_of_transaction_executed` int DEFAULT NULL,
  `session_id` varchar(100) DEFAULT NULL,
  `new_board_lot_quantity` varchar(100) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `modified_date` datetime DEFAULT NULL,
  `created_by` varchar(100) DEFAULT NULL,
  `modified_by` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_bse_day_price_detail_bse_stock_base` (`stock_base_id`),
  CONSTRAINT `fk_bse_day_price_detail_bse_stock_base` FOREIGN KEY (`stock_base_id`) REFERENCES `bse_stock_base` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bse_day_price_detail`
--

LOCK TABLES `bse_day_price_detail` WRITE;
/*!40000 ALTER TABLE `bse_day_price_detail` DISABLE KEYS */;
/*!40000 ALTER TABLE `bse_day_price_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bse_day_price_last_run_detail`
--

DROP TABLE IF EXISTS `bse_day_price_last_run_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bse_day_price_last_run_detail` (
  `id` varchar(100) NOT NULL,
  `last_run_at` datetime DEFAULT NULL,
  `last_run_at_str` varchar(50) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `modified_date` datetime DEFAULT NULL,
  `created_by` varchar(100) DEFAULT NULL,
  `modified_by` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bse_day_price_last_run_detail`
--

LOCK TABLES `bse_day_price_last_run_detail` WRITE;
/*!40000 ALTER TABLE `bse_day_price_last_run_detail` DISABLE KEYS */;
/*!40000 ALTER TABLE `bse_day_price_last_run_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bse_mid_cap_gainer`
--

DROP TABLE IF EXISTS `bse_mid_cap_gainer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bse_mid_cap_gainer` (
  `stock_name` varchar(100) NOT NULL,
  `high` varchar(100) DEFAULT NULL,
  `low` varchar(100) DEFAULT NULL,
  `last_price` varchar(100) DEFAULT NULL,
  `previous_close` varchar(100) DEFAULT NULL,
  `variation` varchar(100) DEFAULT NULL,
  `percentage_gain` varchar(100) DEFAULT NULL,
  `average_volume_5d` varchar(100) DEFAULT NULL,
  `average_volume_10d` varchar(100) DEFAULT NULL,
  `average_volume_30d` varchar(100) DEFAULT NULL,
  `price_to_earning_ratio` varchar(100) DEFAULT NULL,
  `price_to_book_ratio` varchar(100) DEFAULT NULL,
  `upper_circuit` varchar(100) DEFAULT NULL,
  `lower_circuit` varchar(100) DEFAULT NULL,
  `volume_weighted_average_price` varchar(100) DEFAULT NULL,
  `displaced_moving_average_30d` varchar(100) DEFAULT NULL,
  `displaced_moving_average_50d` varchar(100) DEFAULT NULL,
  `displaced_moving_average_150d` varchar(100) DEFAULT NULL,
  `displaced_moving_average_200d` varchar(100) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `modified_date` datetime DEFAULT NULL,
  `created_by` varchar(100) DEFAULT NULL,
  `modified_by` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`stock_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bse_mid_cap_gainer`
--

LOCK TABLES `bse_mid_cap_gainer` WRITE;
/*!40000 ALTER TABLE `bse_mid_cap_gainer` DISABLE KEYS */;
/*!40000 ALTER TABLE `bse_mid_cap_gainer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bse_price_shockers`
--

DROP TABLE IF EXISTS `bse_price_shockers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bse_price_shockers` (
  `stock_name` varchar(100) NOT NULL,
  `category` varchar(100) DEFAULT NULL,
  `sector` varchar(100) DEFAULT NULL,
  `current_price` varchar(100) DEFAULT NULL,
  `current_price_movement` varchar(1000) DEFAULT NULL,
  `previous_price` varchar(100) DEFAULT NULL,
  `percentage_change` varchar(100) DEFAULT NULL,
  `average_volume_5d` varchar(100) DEFAULT NULL,
  `average_volume_10d` varchar(100) DEFAULT NULL,
  `average_volume_30d` varchar(100) DEFAULT NULL,
  `price_to_earning_ratio` varchar(100) DEFAULT NULL,
  `price_to_book_ratio` varchar(100) DEFAULT NULL,
  `upper_circuit` varchar(100) DEFAULT NULL,
  `lower_circuit` varchar(100) DEFAULT NULL,
  `volume_weighted_average_price` varchar(100) DEFAULT NULL,
  `displaced_moving_average_30d` varchar(100) DEFAULT NULL,
  `displaced_moving_average_50d` varchar(100) DEFAULT NULL,
  `displaced_moving_average_150d` varchar(100) DEFAULT NULL,
  `displaced_moving_average_200d` varchar(100) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `modified_date` datetime DEFAULT NULL,
  `created_by` varchar(100) DEFAULT NULL,
  `modified_by` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`stock_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bse_price_shockers`
--

LOCK TABLES `bse_price_shockers` WRITE;
/*!40000 ALTER TABLE `bse_price_shockers` DISABLE KEYS */;
/*!40000 ALTER TABLE `bse_price_shockers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bse_price_shockers_history`
--

DROP TABLE IF EXISTS `bse_price_shockers_history`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bse_price_shockers_history` (
  `stock_name` varchar(100) DEFAULT NULL,
  `category` varchar(100) DEFAULT NULL,
  `sector` varchar(100) DEFAULT NULL,
  `current_price` varchar(100) DEFAULT NULL,
  `current_price_movement` varchar(1000) DEFAULT NULL,
  `previous_price` varchar(100) DEFAULT NULL,
  `percentage_change` varchar(100) DEFAULT NULL,
  `average_volume_5d` varchar(100) DEFAULT NULL,
  `average_volume_10d` varchar(100) DEFAULT NULL,
  `average_volume_30d` varchar(100) DEFAULT NULL,
  `price_to_earning_ratio` varchar(100) DEFAULT NULL,
  `price_to_book_ratio` varchar(100) DEFAULT NULL,
  `upper_circuit` varchar(100) DEFAULT NULL,
  `lower_circuit` varchar(100) DEFAULT NULL,
  `volume_weighted_average_price` varchar(100) DEFAULT NULL,
  `displaced_moving_average_30d` varchar(100) DEFAULT NULL,
  `displaced_moving_average_50d` varchar(100) DEFAULT NULL,
  `displaced_moving_average_150d` varchar(100) DEFAULT NULL,
  `displaced_moving_average_200d` varchar(100) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `modified_date` datetime DEFAULT NULL,
  `created_by` varchar(100) DEFAULT NULL,
  `modified_by` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bse_price_shockers_history`
--

LOCK TABLES `bse_price_shockers_history` WRITE;
/*!40000 ALTER TABLE `bse_price_shockers_history` DISABLE KEYS */;
/*!40000 ALTER TABLE `bse_price_shockers_history` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bse_sensex`
--

DROP TABLE IF EXISTS `bse_sensex`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bse_sensex` (
  `stock_name` varchar(100) NOT NULL,
  `category` varchar(100) DEFAULT NULL,
  `high` varchar(100) DEFAULT NULL,
  `low` varchar(100) DEFAULT NULL,
  `last_price` varchar(100) DEFAULT NULL,
  `last_price_movement` varchar(1000) DEFAULT NULL,
  `percentage_change` varchar(100) DEFAULT NULL,
  `value_in_crores` varchar(100) DEFAULT NULL,
  `average_volume_5d` varchar(100) DEFAULT NULL,
  `average_volume_10d` varchar(100) DEFAULT NULL,
  `average_volume_30d` varchar(100) DEFAULT NULL,
  `price_to_earning_ratio` varchar(100) DEFAULT NULL,
  `price_to_book_ratio` varchar(100) DEFAULT NULL,
  `upper_circuit` varchar(100) DEFAULT NULL,
  `lower_circuit` varchar(100) DEFAULT NULL,
  `volume_weighted_average_price` varchar(100) DEFAULT NULL,
  `displaced_moving_average_30d` varchar(100) DEFAULT NULL,
  `displaced_moving_average_50d` varchar(100) DEFAULT NULL,
  `displaced_moving_average_150d` varchar(100) DEFAULT NULL,
  `displaced_moving_average_200d` varchar(100) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `modified_date` datetime DEFAULT NULL,
  `created_by` varchar(100) DEFAULT NULL,
  `modified_by` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`stock_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bse_sensex`
--

LOCK TABLES `bse_sensex` WRITE;
/*!40000 ALTER TABLE `bse_sensex` DISABLE KEYS */;
/*!40000 ALTER TABLE `bse_sensex` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bse_small_cap_gainer`
--

DROP TABLE IF EXISTS `bse_small_cap_gainer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bse_small_cap_gainer` (
  `stock_name` varchar(100) NOT NULL,
  `high` varchar(100) DEFAULT NULL,
  `low` varchar(100) DEFAULT NULL,
  `last_price` varchar(100) DEFAULT NULL,
  `previous_close` varchar(100) DEFAULT NULL,
  `variation` varchar(100) DEFAULT NULL,
  `percentage_gain` varchar(100) DEFAULT NULL,
  `average_volume_5d` varchar(100) DEFAULT NULL,
  `average_volume_10d` varchar(100) DEFAULT NULL,
  `average_volume_30d` varchar(100) DEFAULT NULL,
  `price_to_earning_ratio` varchar(100) DEFAULT NULL,
  `price_to_book_ratio` varchar(100) DEFAULT NULL,
  `upper_circuit` varchar(100) DEFAULT NULL,
  `lower_circuit` varchar(100) DEFAULT NULL,
  `volume_weighted_average_price` varchar(100) DEFAULT NULL,
  `displaced_moving_average_30d` varchar(100) DEFAULT NULL,
  `displaced_moving_average_50d` varchar(100) DEFAULT NULL,
  `displaced_moving_average_150d` varchar(100) DEFAULT NULL,
  `displaced_moving_average_200d` varchar(100) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `modified_date` datetime DEFAULT NULL,
  `created_by` varchar(100) DEFAULT NULL,
  `modified_by` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`stock_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bse_small_cap_gainer`
--

LOCK TABLES `bse_small_cap_gainer` WRITE;
/*!40000 ALTER TABLE `bse_small_cap_gainer` DISABLE KEYS */;
/*!40000 ALTER TABLE `bse_small_cap_gainer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bse_stock_base`
--

DROP TABLE IF EXISTS `bse_stock_base`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bse_stock_base` (
  `id` varchar(100) NOT NULL,
  `scrip_code` varchar(100) DEFAULT NULL,
  `scrip_name` varchar(100) DEFAULT NULL,
  `scrip_group` varchar(100) DEFAULT NULL,
  `scrip_type` varchar(100) DEFAULT NULL,
  `isi_number` varchar(100) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `modified_date` datetime DEFAULT NULL,
  `created_by` varchar(100) DEFAULT NULL,
  `modified_by` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bse_stock_base`
--

LOCK TABLES `bse_stock_base` WRITE;
/*!40000 ALTER TABLE `bse_stock_base` DISABLE KEYS */;
/*!40000 ALTER TABLE `bse_stock_base` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bse_top_dividend`
--

DROP TABLE IF EXISTS `bse_top_dividend`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bse_top_dividend` (
  `stock_name` varchar(100) NOT NULL,
  `last_price` varchar(100) DEFAULT NULL,
  `latest_dividend_percentage` varchar(100) DEFAULT NULL,
  `dividend_yield_percentage_52_high` varchar(100) DEFAULT NULL,
  `dividend_yield_percentage_52_low` varchar(100) DEFAULT NULL,
  `dividend_yield_percentage_at_current` varchar(100) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `modified_date` datetime DEFAULT NULL,
  `created_by` varchar(100) DEFAULT NULL,
  `modified_by` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`stock_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bse_top_dividend`
--

LOCK TABLES `bse_top_dividend` WRITE;
/*!40000 ALTER TABLE `bse_top_dividend` DISABLE KEYS */;
/*!40000 ALTER TABLE `bse_top_dividend` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bse_volume_shockers`
--

DROP TABLE IF EXISTS `bse_volume_shockers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bse_volume_shockers` (
  `stock_name` varchar(100) NOT NULL,
  `category` varchar(100) DEFAULT NULL,
  `sector` varchar(100) DEFAULT NULL,
  `last_price` varchar(100) DEFAULT NULL,
  `last_price_movement` varchar(1000) DEFAULT NULL,
  `percentage_change` varchar(100) DEFAULT NULL,
  `average_volume` varchar(100) DEFAULT NULL,
  `average_volume_5d` varchar(100) DEFAULT NULL,
  `average_volume_10d` varchar(100) DEFAULT NULL,
  `average_volume_30d` varchar(100) DEFAULT NULL,
  `price_to_earning_ratio` varchar(100) DEFAULT NULL,
  `price_to_book_ratio` varchar(100) DEFAULT NULL,
  `upper_circuit` varchar(100) DEFAULT NULL,
  `lower_circuit` varchar(100) DEFAULT NULL,
  `volume_weighted_average_price` varchar(100) DEFAULT NULL,
  `displaced_moving_average_30d` varchar(100) DEFAULT NULL,
  `displaced_moving_average_50d` varchar(100) DEFAULT NULL,
  `displaced_moving_average_150d` varchar(100) DEFAULT NULL,
  `displaced_moving_average_200d` varchar(100) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `modified_date` datetime DEFAULT NULL,
  `created_by` varchar(100) DEFAULT NULL,
  `modified_by` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`stock_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bse_volume_shockers`
--

LOCK TABLES `bse_volume_shockers` WRITE;
/*!40000 ALTER TABLE `bse_volume_shockers` DISABLE KEYS */;
/*!40000 ALTER TABLE `bse_volume_shockers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bse_volume_shockers_history`
--

DROP TABLE IF EXISTS `bse_volume_shockers_history`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bse_volume_shockers_history` (
  `stock_name` varchar(100) DEFAULT NULL,
  `category` varchar(100) DEFAULT NULL,
  `sector` varchar(100) DEFAULT NULL,
  `last_price` varchar(100) DEFAULT NULL,
  `last_price_movement` varchar(1000) DEFAULT NULL,
  `percentage_change` varchar(100) DEFAULT NULL,
  `average_volume` varchar(100) DEFAULT NULL,
  `average_volume_5d` varchar(100) DEFAULT NULL,
  `average_volume_10d` varchar(100) DEFAULT NULL,
  `average_volume_30d` varchar(100) DEFAULT NULL,
  `price_to_earning_ratio` varchar(100) DEFAULT NULL,
  `price_to_book_ratio` varchar(100) DEFAULT NULL,
  `upper_circuit` varchar(100) DEFAULT NULL,
  `lower_circuit` varchar(100) DEFAULT NULL,
  `volume_weighted_average_price` varchar(100) DEFAULT NULL,
  `displaced_moving_average_30d` varchar(100) DEFAULT NULL,
  `displaced_moving_average_50d` varchar(100) DEFAULT NULL,
  `displaced_moving_average_150d` varchar(100) DEFAULT NULL,
  `displaced_moving_average_200d` varchar(100) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `modified_date` datetime DEFAULT NULL,
  `created_by` varchar(100) DEFAULT NULL,
  `modified_by` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bse_volume_shockers_history`
--

LOCK TABLES `bse_volume_shockers_history` WRITE;
/*!40000 ALTER TABLE `bse_volume_shockers_history` DISABLE KEYS */;
/*!40000 ALTER TABLE `bse_volume_shockers_history` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `holidays`
--

DROP TABLE IF EXISTS `holidays`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `holidays` (
  `id` varchar(100) NOT NULL,
  `holidate` varchar(100) DEFAULT NULL,
  `holiday` varchar(100) DEFAULT NULL,
  `description` varchar(100) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `modified_date` datetime DEFAULT NULL,
  `created_by` varchar(100) DEFAULT NULL,
  `modified_by` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `holidays`
--

LOCK TABLES `holidays` WRITE;
/*!40000 ALTER TABLE `holidays` DISABLE KEYS */;
/*!40000 ALTER TABLE `holidays` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nse_day_block_deal_detail`
--

DROP TABLE IF EXISTS `nse_day_block_deal_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `nse_day_block_deal_detail` (
  `id` varchar(100) NOT NULL,
  `stock_base_id` varchar(100) DEFAULT NULL,
  `business_date` datetime DEFAULT NULL,
  `symbol` varchar(100) DEFAULT NULL,
  `security_name` varchar(100) DEFAULT NULL,
  `client_name` varchar(100) DEFAULT NULL,
  `deal_type` varchar(100) DEFAULT NULL,
  `quantity_traded` varchar(100) DEFAULT NULL,
  `trade_price` varchar(100) DEFAULT NULL,
  `remarks` varchar(100) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `modified_date` datetime DEFAULT NULL,
  `created_by` varchar(100) DEFAULT NULL,
  `modified_by` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_nse_day_block_deal_detail_nse_stock_base` (`stock_base_id`),
  CONSTRAINT `fk_nse_day_block_deal_detail_nse_stock_base` FOREIGN KEY (`stock_base_id`) REFERENCES `nse_stock_base` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nse_day_block_deal_detail`
--

LOCK TABLES `nse_day_block_deal_detail` WRITE;
/*!40000 ALTER TABLE `nse_day_block_deal_detail` DISABLE KEYS */;
/*!40000 ALTER TABLE `nse_day_block_deal_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nse_day_bulk_deal_detail`
--

DROP TABLE IF EXISTS `nse_day_bulk_deal_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `nse_day_bulk_deal_detail` (
  `id` varchar(100) NOT NULL,
  `stock_base_id` varchar(100) DEFAULT NULL,
  `business_date` datetime DEFAULT NULL,
  `symbol` varchar(100) DEFAULT NULL,
  `security_name` varchar(100) DEFAULT NULL,
  `client_name` varchar(100) DEFAULT NULL,
  `deal_type` varchar(100) DEFAULT NULL,
  `quantity_traded` varchar(100) DEFAULT NULL,
  `trade_price` varchar(100) DEFAULT NULL,
  `remarks` varchar(100) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `modified_date` datetime DEFAULT NULL,
  `created_by` varchar(100) DEFAULT NULL,
  `modified_by` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_nse_day_short_sell_detail_nse_stock_base` (`stock_base_id`),
  CONSTRAINT `fk_nse_day_bulk_deal_detail_nse_stock_base` FOREIGN KEY (`stock_base_id`) REFERENCES `nse_stock_base` (`id`),
  CONSTRAINT `fk_nse_day_short_sell_detail_nse_stock_base` FOREIGN KEY (`stock_base_id`) REFERENCES `nse_stock_base` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nse_day_bulk_deal_detail`
--

LOCK TABLES `nse_day_bulk_deal_detail` WRITE;
/*!40000 ALTER TABLE `nse_day_bulk_deal_detail` DISABLE KEYS */;
/*!40000 ALTER TABLE `nse_day_bulk_deal_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nse_day_price_detail`
--

DROP TABLE IF EXISTS `nse_day_price_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `nse_day_price_detail` (
  `id` varchar(100) NOT NULL,
  `stock_base_id` varchar(100) DEFAULT NULL,
  `business_date` datetime DEFAULT NULL,
  `mkt` varchar(100) DEFAULT NULL,
  `series` varchar(100) DEFAULT NULL,
  `symbol` varchar(100) DEFAULT NULL,
  `company_name` varchar(100) DEFAULT NULL,
  `previous_close_price` varchar(100) DEFAULT NULL,
  `open_price` varchar(100) DEFAULT NULL,
  `high_price` varchar(100) DEFAULT NULL,
  `low_price` varchar(100) DEFAULT NULL,
  `close_price` varchar(100) DEFAULT NULL,
  `net_traded_value` varchar(100) DEFAULT NULL,
  `net_traded_quantity` varchar(100) DEFAULT NULL,
  `index_or_security` varchar(100) DEFAULT NULL,
  `corp_index` varchar(100) DEFAULT NULL,
  `trades` varchar(100) DEFAULT NULL,
  `high_52_week` varchar(100) DEFAULT NULL,
  `low_52_week` varchar(100) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `modified_date` datetime DEFAULT NULL,
  `created_by` varchar(100) DEFAULT NULL,
  `modified_by` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_nsedpd_nsesb` (`stock_base_id`),
  CONSTRAINT `fk_nsedpd_nsesb` FOREIGN KEY (`stock_base_id`) REFERENCES `nse_stock_base` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nse_day_price_detail`
--

LOCK TABLES `nse_day_price_detail` WRITE;
/*!40000 ALTER TABLE `nse_day_price_detail` DISABLE KEYS */;
/*!40000 ALTER TABLE `nse_day_price_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nse_day_price_last_run_detail`
--

DROP TABLE IF EXISTS `nse_day_price_last_run_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `nse_day_price_last_run_detail` (
  `id` varchar(100) NOT NULL,
  `last_run_at` datetime DEFAULT NULL,
  `last_run_at_str` varchar(50) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `modified_date` datetime DEFAULT NULL,
  `created_by` varchar(100) DEFAULT NULL,
  `modified_by` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nse_day_price_last_run_detail`
--

LOCK TABLES `nse_day_price_last_run_detail` WRITE;
/*!40000 ALTER TABLE `nse_day_price_last_run_detail` DISABLE KEYS */;
/*!40000 ALTER TABLE `nse_day_price_last_run_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nse_day_short_sell_detail`
--

DROP TABLE IF EXISTS `nse_day_short_sell_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `nse_day_short_sell_detail` (
  `id` varchar(100) NOT NULL,
  `stock_base_id` varchar(100) DEFAULT NULL,
  `business_date` datetime DEFAULT NULL,
  `symbol` varchar(100) DEFAULT NULL,
  `security_name` varchar(100) DEFAULT NULL,
  `quantity` int DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `modified_date` datetime DEFAULT NULL,
  `created_by` varchar(100) DEFAULT NULL,
  `modified_by` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nse_day_short_sell_detail`
--

LOCK TABLES `nse_day_short_sell_detail` WRITE;
/*!40000 ALTER TABLE `nse_day_short_sell_detail` DISABLE KEYS */;
/*!40000 ALTER TABLE `nse_day_short_sell_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nse_etf_detail`
--

DROP TABLE IF EXISTS `nse_etf_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `nse_etf_detail` (
  `id` varchar(100) NOT NULL,
  `stock_base_id` varchar(100) DEFAULT NULL,
  `symbol` varchar(100) DEFAULT NULL,
  `open_price` double DEFAULT NULL,
  `high_price` double DEFAULT NULL,
  `low_price` double DEFAULT NULL,
  `last_traded_price` double DEFAULT NULL,
  `net_asset_value` double DEFAULT NULL,
  `percentage_change` double DEFAULT NULL,
  `volume_in_shares` int DEFAULT NULL,
  `value_in_lakhs` double DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `modified_date` datetime DEFAULT NULL,
  `created_by` varchar(100) DEFAULT NULL,
  `modified_by` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_nse_eft_detail_nse_stock_base` (`stock_base_id`),
  CONSTRAINT `fk_nse_eft_detail_nse_stock_base` FOREIGN KEY (`stock_base_id`) REFERENCES `nse_stock_base` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nse_etf_detail`
--

LOCK TABLES `nse_etf_detail` WRITE;
/*!40000 ALTER TABLE `nse_etf_detail` DISABLE KEYS */;
/*!40000 ALTER TABLE `nse_etf_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nse_main_board_detail`
--

DROP TABLE IF EXISTS `nse_main_board_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `nse_main_board_detail` (
  `id` varchar(100) NOT NULL,
  `stock_base_id` varchar(100) DEFAULT NULL,
  `symbol` varchar(100) DEFAULT NULL,
  `open_price` double DEFAULT NULL,
  `high_price` double DEFAULT NULL,
  `low_price` double DEFAULT NULL,
  `previous_close_price` double DEFAULT NULL,
  `last_traded_price` double DEFAULT NULL,
  `percentage_change` double DEFAULT NULL,
  `volume_in_shares` int DEFAULT NULL,
  `value_in_lakhs` double DEFAULT NULL,
  `ca` datetime DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `modified_date` datetime DEFAULT NULL,
  `created_by` varchar(100) DEFAULT NULL,
  `modified_by` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_nse_main_board_detail_nse_stock_base` (`stock_base_id`),
  CONSTRAINT `fk_nse_main_board_detail_nse_stock_base` FOREIGN KEY (`stock_base_id`) REFERENCES `nse_stock_base` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nse_main_board_detail`
--

LOCK TABLES `nse_main_board_detail` WRITE;
/*!40000 ALTER TABLE `nse_main_board_detail` DISABLE KEYS */;
/*!40000 ALTER TABLE `nse_main_board_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nse_pre_open_market_detail`
--

DROP TABLE IF EXISTS `nse_pre_open_market_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `nse_pre_open_market_detail` (
  `id` varchar(100) NOT NULL,
  `stock_base_id` varchar(100) DEFAULT NULL,
  `business_date` datetime DEFAULT NULL,
  `pre_open_type` varchar(30) DEFAULT NULL,
  `symbol` varchar(100) DEFAULT NULL,
  `previous_close` double DEFAULT NULL,
  `indicative_equilibrium_price` double DEFAULT NULL,
  `price_change` double DEFAULT NULL,
  `price_percentage_change` double DEFAULT NULL,
  `final_price` double DEFAULT NULL,
  `final_quantity` double DEFAULT NULL,
  `value_in_crores` decimal(20,2) DEFAULT NULL,
  `free_float_market_capitalization` decimal(20,2) DEFAULT NULL,
  `new_market_52_week_high` double DEFAULT NULL,
  `new_market_52_week_low` double DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `modified_date` datetime DEFAULT NULL,
  `created_by` varchar(100) DEFAULT NULL,
  `modified_by` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_nse_open_market_nse_stock_base` (`stock_base_id`),
  CONSTRAINT `fk_nse_open_market_nse_stock_base` FOREIGN KEY (`stock_base_id`) REFERENCES `nse_stock_base` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nse_pre_open_market_detail`
--

LOCK TABLES `nse_pre_open_market_detail` WRITE;
/*!40000 ALTER TABLE `nse_pre_open_market_detail` DISABLE KEYS */;
/*!40000 ALTER TABLE `nse_pre_open_market_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nse_price_spurt_detail`
--

DROP TABLE IF EXISTS `nse_price_spurt_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `nse_price_spurt_detail` (
  `id` varchar(100) NOT NULL,
  `stock_base_id` varchar(100) DEFAULT NULL,
  `spurt_type` varchar(50) DEFAULT NULL,
  `symbol` varchar(100) DEFAULT NULL,
  `open_price` double DEFAULT NULL,
  `high_price` double DEFAULT NULL,
  `low_price` double DEFAULT NULL,
  `previous_close_price` double DEFAULT NULL,
  `last_traded_price` double DEFAULT NULL,
  `percentage_change` double DEFAULT NULL,
  `volume` int DEFAULT NULL,
  `value` double DEFAULT NULL,
  `ca` datetime DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `modified_date` datetime DEFAULT NULL,
  `created_by` varchar(100) DEFAULT NULL,
  `modified_by` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_nse_price_spurt_detail_nse_stock_base` (`stock_base_id`),
  CONSTRAINT `fk_nse_price_spurt_detail_nse_stock_base` FOREIGN KEY (`stock_base_id`) REFERENCES `nse_stock_base` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nse_price_spurt_detail`
--

LOCK TABLES `nse_price_spurt_detail` WRITE;
/*!40000 ALTER TABLE `nse_price_spurt_detail` DISABLE KEYS */;
/*!40000 ALTER TABLE `nse_price_spurt_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nse_sme_detail`
--

DROP TABLE IF EXISTS `nse_sme_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `nse_sme_detail` (
  `id` varchar(100) NOT NULL,
  `stock_base_id` varchar(100) DEFAULT NULL,
  `symbol` varchar(100) DEFAULT NULL,
  `open_price` double DEFAULT NULL,
  `high_price` double DEFAULT NULL,
  `low_price` double DEFAULT NULL,
  `previous_close_price` double DEFAULT NULL,
  `last_traded_price` double DEFAULT NULL,
  `percentage_change` double DEFAULT NULL,
  `volume` int DEFAULT NULL,
  `value_in_lakhs` double DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `modified_date` datetime DEFAULT NULL,
  `created_by` varchar(100) DEFAULT NULL,
  `modified_by` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_nse_sme_detail_nse_stock_base` (`stock_base_id`),
  CONSTRAINT `fk_nse_sme_detail_nse_stock_base` FOREIGN KEY (`stock_base_id`) REFERENCES `nse_stock_base` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nse_sme_detail`
--

LOCK TABLES `nse_sme_detail` WRITE;
/*!40000 ALTER TABLE `nse_sme_detail` DISABLE KEYS */;
/*!40000 ALTER TABLE `nse_sme_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nse_stock_base`
--

DROP TABLE IF EXISTS `nse_stock_base`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `nse_stock_base` (
  `id` varchar(100) NOT NULL,
  `isi_number` varchar(100) DEFAULT NULL,
  `symbol` varchar(100) DEFAULT NULL,
  `company_name` varchar(100) DEFAULT NULL,
  `series` varchar(100) DEFAULT NULL,
  `date_of_listing` datetime DEFAULT NULL,
  `paid_up_value` int DEFAULT NULL,
  `face_value` int DEFAULT NULL,
  `market_lot` int DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `modified_date` datetime DEFAULT NULL,
  `created_by` varchar(100) DEFAULT NULL,
  `modified_by` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nse_stock_base`
--

LOCK TABLES `nse_stock_base` WRITE;
/*!40000 ALTER TABLE `nse_stock_base` DISABLE KEYS */;
/*!40000 ALTER TABLE `nse_stock_base` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nse_top20_detail`
--

DROP TABLE IF EXISTS `nse_top20_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `nse_top20_detail` (
  `id` varchar(100) NOT NULL,
  `stock_base_id` varchar(100) DEFAULT NULL,
  `top20_type` varchar(100) DEFAULT NULL,
  `top20_sub_type` varchar(50) DEFAULT NULL,
  `symbol` varchar(100) DEFAULT NULL,
  `open_price` double DEFAULT NULL,
  `high_price` double DEFAULT NULL,
  `low_price` double DEFAULT NULL,
  `previous_close_price` double DEFAULT NULL,
  `last_traded_price` double DEFAULT NULL,
  `percentage_change` double DEFAULT NULL,
  `volume_in_shares` int DEFAULT NULL,
  `value_in_lakhs` double DEFAULT NULL,
  `ca` datetime DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `modified_date` datetime DEFAULT NULL,
  `created_by` varchar(100) DEFAULT NULL,
  `modified_by` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_nse_top20_detail_nse_stock_base` (`stock_base_id`),
  CONSTRAINT `fk_nse_top20_detail_nse_stock_base` FOREIGN KEY (`stock_base_id`) REFERENCES `nse_stock_base` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nse_top20_detail`
--

LOCK TABLES `nse_top20_detail` WRITE;
/*!40000 ALTER TABLE `nse_top20_detail` DISABLE KEYS */;
/*!40000 ALTER TABLE `nse_top20_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nse_volume_spurt_detail`
--

DROP TABLE IF EXISTS `nse_volume_spurt_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `nse_volume_spurt_detail` (
  `id` varchar(100) NOT NULL,
  `stock_base_id` varchar(100) DEFAULT NULL,
  `symbol` varchar(100) DEFAULT NULL,
  `volume` int DEFAULT NULL,
  `one_week_average_volume` int DEFAULT NULL,
  `no_of_times` double DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `modified_date` datetime DEFAULT NULL,
  `created_by` varchar(100) DEFAULT NULL,
  `modified_by` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_nse_volume_spurt_detail_nse_stock_base` (`stock_base_id`),
  CONSTRAINT `fk_nse_volume_spurt_detail_nse_stock_base` FOREIGN KEY (`stock_base_id`) REFERENCES `nse_stock_base` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nse_volume_spurt_detail`
--

LOCK TABLES `nse_volume_spurt_detail` WRITE;
/*!40000 ALTER TABLE `nse_volume_spurt_detail` DISABLE KEYS */;
/*!40000 ALTER TABLE `nse_volume_spurt_detail` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-11-03 20:29:23
