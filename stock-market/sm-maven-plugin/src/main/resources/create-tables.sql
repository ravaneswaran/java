-- MySQL dump 10.13  Distrib 8.0.42, for Linux (x86_64)
--
-- Host: localhost    Database: stock_market
-- ------------------------------------------------------
-- Server version	8.0.42-0ubuntu0.24.04.1

CREATE TABLE IF NOT EXISTS QRTZ_JOB_DETAILS
  (
    SCHED_NAME VARCHAR(120) NOT NULL,
    JOB_NAME  VARCHAR(200) NOT NULL,
    JOB_GROUP VARCHAR(200) NOT NULL,
    DESCRIPTION VARCHAR(250) NULL,
    JOB_CLASS_NAME   VARCHAR(250) NOT NULL,
    IS_DURABLE VARCHAR(1) NOT NULL,
    IS_NONCONCURRENT VARCHAR(1) NOT NULL,
    IS_UPDATE_DATA VARCHAR(1) NOT NULL,
    REQUESTS_RECOVERY VARCHAR(1) NOT NULL,
    JOB_DATA BLOB NULL,
    PRIMARY KEY (SCHED_NAME,JOB_NAME,JOB_GROUP)
);

CREATE TABLE IF NOT EXISTS QRTZ_TRIGGERS
  (
    SCHED_NAME VARCHAR(120) NOT NULL,
    TRIGGER_NAME VARCHAR(200) NOT NULL,
    TRIGGER_GROUP VARCHAR(200) NOT NULL,
    JOB_NAME  VARCHAR(200) NOT NULL,
    JOB_GROUP VARCHAR(200) NOT NULL,
    DESCRIPTION VARCHAR(250) NULL,
    NEXT_FIRE_TIME BIGINT(13) NULL,
    PREV_FIRE_TIME BIGINT(13) NULL,
    PRIORITY INTEGER NULL,
    TRIGGER_STATE VARCHAR(16) NOT NULL,
    TRIGGER_TYPE VARCHAR(8) NOT NULL,
    START_TIME BIGINT(13) NOT NULL,
    END_TIME BIGINT(13) NULL,
    CALENDAR_NAME VARCHAR(200) NULL,
    MISFIRE_INSTR SMALLINT(2) NULL,
    JOB_DATA BLOB NULL,
    PRIMARY KEY (SCHED_NAME,TRIGGER_NAME,TRIGGER_GROUP),
    FOREIGN KEY (SCHED_NAME,JOB_NAME,JOB_GROUP)
        REFERENCES QRTZ_JOB_DETAILS(SCHED_NAME,JOB_NAME,JOB_GROUP)
);

CREATE TABLE IF NOT EXISTS QRTZ_SIMPLE_TRIGGERS
  (
    SCHED_NAME VARCHAR(120) NOT NULL,
    TRIGGER_NAME VARCHAR(200) NOT NULL,
    TRIGGER_GROUP VARCHAR(200) NOT NULL,
    REPEAT_COUNT BIGINT(7) NOT NULL,
    REPEAT_INTERVAL BIGINT(12) NOT NULL,
    TIMES_TRIGGERED BIGINT(10) NOT NULL,
    PRIMARY KEY (SCHED_NAME,TRIGGER_NAME,TRIGGER_GROUP),
    FOREIGN KEY (SCHED_NAME,TRIGGER_NAME,TRIGGER_GROUP)
        REFERENCES QRTZ_TRIGGERS(SCHED_NAME,TRIGGER_NAME,TRIGGER_GROUP)
);

CREATE TABLE IF NOT EXISTS QRTZ_CRON_TRIGGERS
  (
    SCHED_NAME VARCHAR(120) NOT NULL,
    TRIGGER_NAME VARCHAR(200) NOT NULL,
    TRIGGER_GROUP VARCHAR(200) NOT NULL,
    CRON_EXPRESSION VARCHAR(200) NOT NULL,
    TIME_ZONE_ID VARCHAR(80),
    PRIMARY KEY (SCHED_NAME,TRIGGER_NAME,TRIGGER_GROUP),
    FOREIGN KEY (SCHED_NAME,TRIGGER_NAME,TRIGGER_GROUP)
        REFERENCES QRTZ_TRIGGERS(SCHED_NAME,TRIGGER_NAME,TRIGGER_GROUP)
);

CREATE TABLE IF NOT EXISTS QRTZ_SIMPROP_TRIGGERS
  (
    SCHED_NAME VARCHAR(120) NOT NULL,
    TRIGGER_NAME VARCHAR(200) NOT NULL,
    TRIGGER_GROUP VARCHAR(200) NOT NULL,
    STR_PROP_1 VARCHAR(512) NULL,
    STR_PROP_2 VARCHAR(512) NULL,
    STR_PROP_3 VARCHAR(512) NULL,
    INT_PROP_1 INT NULL,
    INT_PROP_2 INT NULL,
    LONG_PROP_1 BIGINT NULL,
    LONG_PROP_2 BIGINT NULL,
    DEC_PROP_1 NUMERIC(13,4) NULL,
    DEC_PROP_2 NUMERIC(13,4) NULL,
    BOOL_PROP_1 VARCHAR(1) NULL,
    BOOL_PROP_2 VARCHAR(1) NULL,
    PRIMARY KEY (SCHED_NAME,TRIGGER_NAME,TRIGGER_GROUP),
    FOREIGN KEY (SCHED_NAME,TRIGGER_NAME,TRIGGER_GROUP)
    REFERENCES QRTZ_TRIGGERS(SCHED_NAME,TRIGGER_NAME,TRIGGER_GROUP)
);

CREATE TABLE IF NOT EXISTS QRTZ_BLOB_TRIGGERS
  (
    SCHED_NAME VARCHAR(120) NOT NULL,
    TRIGGER_NAME VARCHAR(200) NOT NULL,
    TRIGGER_GROUP VARCHAR(200) NOT NULL,
    BLOB_DATA BLOB NULL,
    PRIMARY KEY (SCHED_NAME,TRIGGER_NAME,TRIGGER_GROUP),
    FOREIGN KEY (SCHED_NAME,TRIGGER_NAME,TRIGGER_GROUP)
        REFERENCES QRTZ_TRIGGERS(SCHED_NAME,TRIGGER_NAME,TRIGGER_GROUP)
);

CREATE TABLE IF NOT EXISTS QRTZ_CALENDARS
  (
    SCHED_NAME VARCHAR(120) NOT NULL,
    CALENDAR_NAME  VARCHAR(200) NOT NULL,
    CALENDAR BLOB NOT NULL,
    PRIMARY KEY (SCHED_NAME,CALENDAR_NAME)
);

CREATE TABLE IF NOT EXISTS QRTZ_PAUSED_TRIGGER_GRPS
  (
    SCHED_NAME VARCHAR(120) NOT NULL,
    TRIGGER_GROUP  VARCHAR(200) NOT NULL,
    PRIMARY KEY (SCHED_NAME,TRIGGER_GROUP)
);

CREATE TABLE IF NOT EXISTS QRTZ_FIRED_TRIGGERS
  (
    SCHED_NAME VARCHAR(120) NOT NULL,
    ENTRY_ID VARCHAR(95) NOT NULL,
    TRIGGER_NAME VARCHAR(200) NOT NULL,
    TRIGGER_GROUP VARCHAR(200) NOT NULL,
    INSTANCE_NAME VARCHAR(200) NOT NULL,
    FIRED_TIME BIGINT(13) NOT NULL,
    SCHED_TIME BIGINT(13) NOT NULL,
    PRIORITY INTEGER NOT NULL,
    STATE VARCHAR(16) NOT NULL,
    JOB_NAME VARCHAR(200) NULL,
    JOB_GROUP VARCHAR(200) NULL,
    IS_NONCONCURRENT VARCHAR(1) NULL,
    REQUESTS_RECOVERY VARCHAR(1) NULL,
    PRIMARY KEY (SCHED_NAME,ENTRY_ID)
);

CREATE TABLE IF NOT EXISTS QRTZ_SCHEDULER_STATE
  (
    SCHED_NAME VARCHAR(120) NOT NULL,
    INSTANCE_NAME VARCHAR(200) NOT NULL,
    LAST_CHECKIN_TIME BIGINT(13) NOT NULL,
    CHECKIN_INTERVAL BIGINT(13) NOT NULL,
    PRIMARY KEY (SCHED_NAME,INSTANCE_NAME)
);

CREATE TABLE IF NOT EXISTS QRTZ_LOCKS
  (
    SCHED_NAME VARCHAR(120) NOT NULL,
    LOCK_NAME  VARCHAR(40) NOT NULL,
    PRIMARY KEY (SCHED_NAME,LOCK_NAME)
);

--
-- Table structure for table `bse_active_100`
--
CREATE TABLE IF NOT EXISTS `bse_active_100` (
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

--
-- Table structure for table `bse_active_100_history`
--
CREATE TABLE IF NOT EXISTS `bse_active_100_history` (
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

--
-- Table structure for table `bse_active_200`
--
CREATE TABLE IF NOT EXISTS `bse_active_200` (
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

--
-- Table structure for table `bse_active_200_history`
--
CREATE TABLE IF NOT EXISTS `bse_active_200_history` (
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

--
-- Table structure for table `bse_active_500`
--
CREATE TABLE IF NOT EXISTS `bse_active_500` (
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

--
-- Table structure for table `bse_active_500_history`
--
CREATE TABLE IF NOT EXISTS `bse_active_500_history` (
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

--
-- Table structure for table `bse_stock_base`
--
CREATE TABLE IF NOT EXISTS `bse_stock_base` (
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

--
-- Table structure for table `bse_day_price_detail`
--
CREATE TABLE IF NOT EXISTS `bse_day_price_detail` (
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

--
-- Table structure for table `bse_mid_cap_gainer`
--
CREATE TABLE IF NOT EXISTS `bse_mid_cap_gainer` (
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

--
-- Table structure for table `bse_price_shockers`
--
CREATE TABLE IF NOT EXISTS `bse_price_shockers` (
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

--
-- Table structure for table `bse_price_shockers_history`
--
CREATE TABLE IF NOT EXISTS `bse_price_shockers_history` (
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

--
-- Table structure for table `bse_sensex`
--
CREATE TABLE IF NOT EXISTS `bse_sensex` (
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

--
-- Table structure for table `bse_small_cap_gainer`
--
CREATE TABLE IF NOT EXISTS `bse_small_cap_gainer` (
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

--
-- Table structure for table `bse_top_dividend`
--
CREATE TABLE IF NOT EXISTS `bse_top_dividend` (
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

--
-- Table structure for table `bse_volume_shockers`
--
CREATE TABLE IF NOT EXISTS `bse_volume_shockers` (
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

--
-- Table structure for table `bse_volume_shockers_history`
--
CREATE TABLE IF NOT EXISTS `bse_volume_shockers_history` (
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

--
-- Table structure for table `holidays`
--
CREATE TABLE IF NOT EXISTS `holidays` (
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

--
-- Table structure for table `nse_stock_base`
--
CREATE TABLE IF NOT EXISTS `nse_stock_base` (
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

--
-- Table structure for table `nse_day_block_deal_detail`
--
CREATE TABLE IF NOT EXISTS `nse_day_block_deal_detail` (
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

--
-- Table structure for table `nse_day_bulk_deal_detail`
--
CREATE TABLE IF NOT EXISTS `nse_day_bulk_deal_detail` (
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

--
-- Table structure for table `nse_day_price_detail`
--
CREATE TABLE IF NOT EXISTS `nse_day_price_detail` (
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

--
-- Table structure for table `nse_day_short_sell_detail`
--
CREATE TABLE IF NOT EXISTS `nse_day_short_sell_detail` (
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

--
-- Table structure for table `nse_etf_detail`
--
CREATE TABLE IF NOT EXISTS `nse_etf_detail` (
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

--
-- Table structure for table `nse_main_board_detail`
--
CREATE TABLE IF NOT EXISTS `nse_main_board_detail` (
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

--
-- Table structure for table `nse_pre_open_market_detail`
--
CREATE TABLE IF NOT EXISTS `nse_pre_open_market_detail` (
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

--
-- Table structure for table `nse_price_spurt_detail`
--
CREATE TABLE IF NOT EXISTS `nse_price_spurt_detail` (
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

--
-- Table structure for table `nse_sme_detail`
--
CREATE TABLE IF NOT EXISTS `nse_sme_detail` (
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

--
-- Table structure for table `nse_top20_detail`
--
CREATE TABLE IF NOT EXISTS `nse_top20_detail` (
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

--
-- Table structure for table `nse_volume_spurt_detail`
--
CREATE TABLE IF NOT EXISTS `nse_volume_spurt_detail` (
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

-- Dump completed on 2025-10-26 18:40:21
