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
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-10-26 18:40:21
