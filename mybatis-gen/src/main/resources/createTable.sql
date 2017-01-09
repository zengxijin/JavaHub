-- MySQL dump 10.11
--
-- Host: localhost    Database: bpm_app
-- ------------------------------------------------------
-- Server version	5.0.96-community-nt

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `bpm_inst_info`
--

DROP TABLE IF EXISTS `bpm_inst_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bpm_inst_info` (
  `transaction_no` char(36) NOT NULL COMMENT '流水号',
  `process_inst_id` bigint(20) default NULL COMMENT '流程实例id',
  `process_status` varchar(50) default NULL COMMENT '流程状态',
  `created_by` varchar(50) default NULL COMMENT '创建用户',
  `created_date` datetime default NULL COMMENT '创建时间',
  `updated_by` varchar(50) default NULL COMMENT '更新用户',
  `updated_date` datetime default NULL COMMENT '更新时间',
  PRIMARY KEY  (`transaction_no`),
  KEY `idx_process_inst_id` (`process_inst_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='BPM活动实例表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tenant_schema_cfg`
--

DROP TABLE IF EXISTS `tenant_schema_cfg`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tenant_schema_cfg` (
  `id` bigint(20) NOT NULL auto_increment,
  `tenant_id` varchar(50) default NULL COMMENT '租户id',
  `tenant_schema` varchar(50) default NULL COMMENT '租户数据库schema',
  `db_type` varchar(50) default NULL COMMENT '数据库类型',
  `created_date` datetime default NULL COMMENT '创建时间',
  `created_by` varchar(50) default NULL COMMENT '创建用户',
  `description` varchar(100) default NULL COMMENT '备注说明',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='租户与数据库配置表';
/*!40101 SET character_set_client = @saved_cs_client */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-01-09 10:16:35
