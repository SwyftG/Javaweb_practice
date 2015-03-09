-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.0.16-nt


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema logistics
--

CREATE DATABASE IF NOT EXISTS logistics;
USE logistics;

--
-- Definition of table `goods`
--

DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods` (
  `GdID` int(10) unsigned NOT NULL auto_increment,
  `GdType` varchar(45) NOT NULL,
  `GdWeight` float NOT NULL,
  `GyName` varchar(45) NOT NULL,
  `GdDanger` varchar(45) NOT NULL,
  `GdStatus` varchar(45) NOT NULL,
  `GdRmk` varchar(45) default NULL,
  PRIMARY KEY  USING BTREE (`GdID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `goods`
--

/*!40000 ALTER TABLE `goods` DISABLE KEYS */;
INSERT INTO `goods` (`GdID`,`GdType`,`GdWeight`,`GyName`,`GdDanger`,`GdStatus`,`GdRmk`) VALUES 
 (100024,'散装',12,'北京货场11','否','未装运','11'),
 (100025,'液态',130,'北京货场12','否','未装运','water'),
 (100026,'生物类',45,'上海货场33','是','未装运','pig'),
 (100027,'低温冷藏',12,'上海货场33','否','未装运','ice'),
 (100028,'箱式运输',12,'北京货场11','否','未装运','方便面');
/*!40000 ALTER TABLE `goods` ENABLE KEYS */;


--
-- Definition of table `goodslist`
--

DROP TABLE IF EXISTS `goodslist`;
CREATE TABLE `goodslist` (
  `GLID` int(10) unsigned NOT NULL auto_increment,
  `UserName` varchar(45) NOT NULL,
  `VhcLcs` varchar(45) NOT NULL,
  `SGyName` varchar(45) NOT NULL,
  `DGyName` varchar(45) NOT NULL,
  `GdID` int(10) unsigned NOT NULL,
  `GLKm` int(10) unsigned NOT NULL,
  `GLStime` datetime NOT NULL,
  `GLDtime` datetime NOT NULL,
  `GlStatus` varchar(45) NOT NULL,
  PRIMARY KEY  USING BTREE (`GLID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `goodslist`
--

/*!40000 ALTER TABLE `goodslist` DISABLE KEYS */;
INSERT INTO `goodslist` (`GLID`,`UserName`,`VhcLcs`,`SGyName`,`DGyName`,`GdID`,`GLKm`,`GLStime`,`GLDtime`,`GlStatus`) VALUES 
 (200023,'王一凡','HS1245','天津货场21','上海货场32',100021,15,'1399-01-14 00:00:00','1996-02-01 00:00:00','已分配'),
 (200024,'王一凡','GX2345','上海货场32','上海货场34',100026,12,'2011-07-14 15:21:56','2011-07-18 15:22:02','已送达'),
 (200026,'王一凡','GX2345','上海货场32','上海货场34',100027,12,'2011-07-01 00:00:00','2011-07-01 00:00:00','已确认'),
 (200027,'罗盛','1','北京货场12','上海货场32',100026,78,'2008-01-29 00:00:00','2008-01-30 00:00:00','已分配');
/*!40000 ALTER TABLE `goodslist` ENABLE KEYS */;


--
-- Definition of table `goodsyard`
--

DROP TABLE IF EXISTS `goodsyard`;
CREATE TABLE `goodsyard` (
  `GyName` varchar(30) NOT NULL,
  `RegName` varchar(45) NOT NULL,
  `GyAddress` varchar(100) NOT NULL,
  `GyArea` int(10) NOT NULL,
  `GyIndoor` varchar(45) NOT NULL,
  `GyDanger` varchar(45) NOT NULL,
  `GyRmk` varchar(500) default NULL,
  PRIMARY KEY  USING BTREE (`GyName`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `goodsyard`
--

/*!40000 ALTER TABLE `goodsyard` DISABLE KEYS */;
INSERT INTO `goodsyard` (`GyName`,`RegName`,`GyAddress`,`GyArea`,`GyIndoor`,`GyDanger`,`GyRmk`) VALUES 
 ('货场11','北京','2区1号',100,'true','true','北京主货场'),
 ('货场12','北京','2区2号',655,'false','true',NULL),
 ('货场21','天津','3区1号',54,'false','true',NULL),
 ('货场32','上海','2区2号',44,'true','true',NULL),
 ('货场33','上海','1区2号',768,'true','false','浦东区'),
 ('货场34','上海','1区3号',54,'true','false',''),
 ('货场35','上海','1区4号',56,'true','false','');
/*!40000 ALTER TABLE `goodsyard` ENABLE KEYS */;


--
-- Definition of table `manager`
--

DROP TABLE IF EXISTS `manager`;
CREATE TABLE `manager` (
  `UID` int(10) unsigned NOT NULL auto_increment,
  `UserName` varchar(45) NOT NULL,
  `UserPwd` varchar(45) character set latin1 NOT NULL,
  `UserPower` varchar(45) default NULL,
  PRIMARY KEY  (`UID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `manager`
--

/*!40000 ALTER TABLE `manager` DISABLE KEYS */;
INSERT INTO `manager` (`UID`,`UserName`,`UserPwd`,`UserPower`) VALUES 
 (1,'Admin','0','null'),
 (8,'罗盛 ','ss','司机'),
 (14,'王一凡','123','司机'),
 (104,'vv','vv','管理员');
/*!40000 ALTER TABLE `manager` ENABLE KEYS */;


--
-- Definition of table `region`
--

DROP TABLE IF EXISTS `region`;
CREATE TABLE `region` (
  `RegName` varchar(45) NOT NULL,
  `RegRmk` varchar(500) default NULL,
  PRIMARY KEY  USING BTREE (`RegName`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `region`
--

/*!40000 ALTER TABLE `region` DISABLE KEYS */;
INSERT INTO `region` (`RegName`,`RegRmk`) VALUES 
 ('上海','第一个区域啊!上海'),
 ('北京','第二个区域'),
 ('天津','天津1');
/*!40000 ALTER TABLE `region` ENABLE KEYS */;


--
-- Definition of table `vehicle`
--

DROP TABLE IF EXISTS `vehicle`;
CREATE TABLE `vehicle` (
  `VhcLcs` varchar(45) NOT NULL,
  `VhcForm` varchar(45) NOT NULL,
  `OilType` varchar(45) NOT NULL,
  `OilCpt` float NOT NULL,
  `LoadCpt` float NOT NULL,
  `VhcType` varchar(45) NOT NULL,
  `VhcSpc` tinyint(1) NOT NULL,
  `VhcRmk` varchar(45) NOT NULL,
  PRIMARY KEY  (`VhcLcs`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `vehicle`
--

/*!40000 ALTER TABLE `vehicle` DISABLE KEYS */;
INSERT INTO `vehicle` (`VhcLcs`,`VhcForm`,`OilType`,`OilCpt`,`LoadCpt`,`VhcType`,`VhcSpc`,`VhcRmk`) VALUES 
 ('1','ABCD-11','汽油',77,77,'普通',0,'1'),
 ('GB1456','ABCD-5','汽油',16,2.21,'箱式',0,'	                	第一辆车\r\n	                '),
 ('GX2345','ABCD-1','汽油',21,12,'箱式',0,'GX2345'),
 ('GX3000','ABCD-3','柴油',45.1,5.6,'油罐',1,'第三辆车'),
 ('HS1245','ABCD-9','汽油',45,75,'普通',0,'第五辆车');
/*!40000 ALTER TABLE `vehicle` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
