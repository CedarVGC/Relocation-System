/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 5.5.64-MariaDB : Database - test
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`test` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `test`;

/*Table structure for table `allpurview` */

DROP TABLE IF EXISTS `allpurview`;

CREATE TABLE `allpurview` (
  `ap_popedom` int(11) NOT NULL COMMENT '权限编号',
  `ap_name` varchar(50) DEFAULT NULL COMMENT '权限名字',
  `ap_remark` varchar(50) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`ap_popedom`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `allpurview` */

insert  into `allpurview`(`ap_popedom`,`ap_name`,`ap_remark`) values (1,'审核','审核权限'),(2,'浏览',NULL),(3,'编辑',NULL),(4,'删除',NULL),(5,'权限分配',NULL);

/*Table structure for table `company` */

DROP TABLE IF EXISTS `company`;

CREATE TABLE `company` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '测量表序号',
  `measuredate` date NOT NULL COMMENT '测量日期',
  `name` varchar(50) NOT NULL COMMENT '企业名称',
  `address` varchar(100) NOT NULL COMMENT '地址',
  `project` varchar(20) NOT NULL COMMENT '征占项目',
  `recorder` varchar(10) NOT NULL COMMENT '记录人',
  `measurer` varchar(50) NOT NULL COMMENT '测量人员',
  `autograph` varchar(10) NOT NULL COMMENT '动迁人签字',
  `dautograph` varchar(10) NOT NULL COMMENT '被动迁人签字',
  `writedate` date NOT NULL COMMENT '填写日期',
  `writer` varchar(10) NOT NULL COMMENT '填写人',
  `verify` int(11) DEFAULT '0' COMMENT '是否审核',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Data for the table `company` */

insert  into `company`(`id`,`measuredate`,`name`,`address`,`project`,`recorder`,`measurer`,`autograph`,`dautograph`,`writedate`,`writer`,`verify`) values (1,'2020-03-03','江南皮革厂','李家村','拆迁项目','村长','小明','村长','李老板','2020-03-12','小明',0),(2,'2020-04-06','方法','222','222','222','222','22','222','2020-04-20','222',0),(3,'2020-04-19','大大乐','村','aa','aa','aa','aaa','aaa','2020-04-27','aaa',1),(4,'2020-04-19','甜美公司','李家村','动迁','王一飞','王一飞','王一飞','王一飞','2020-04-13','王一飞',1);

/*Table structure for table `companycompensation` */

DROP TABLE IF EXISTS `companycompensation`;

CREATE TABLE `companycompensation` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '企业补偿表编号',
  `mainid` int(11) NOT NULL COMMENT '企业测量表id',
  `name` varchar(50) NOT NULL COMMENT '企业名称',
  `totalmoney` double DEFAULT NULL COMMENT '总金额',
  `asphaltroadnum` int(11) DEFAULT NULL COMMENT '沥青路面积',
  `asphaltroaduprice` double DEFAULT NULL COMMENT '沥青路单价',
  `asphaltroadprice` double DEFAULT NULL COMMENT '沥青路金额',
  `cementroadnum` int(11) DEFAULT NULL COMMENT '水泥路面积',
  `cementroaduprice` double DEFAULT NULL COMMENT '水泥路单价',
  `cementroadprice` double DEFAULT NULL COMMENT '水泥路金额',
  `concretenum` int(11) DEFAULT NULL COMMENT '水泥地面积',
  `concreteuprice` double DEFAULT NULL COMMENT '水泥地单价',
  `concreteprice` double DEFAULT NULL COMMENT '水泥地金额',
  `houseletnum` int(11) DEFAULT NULL COMMENT '小楼面积',
  `houseletuprice` double DEFAULT NULL COMMENT '小楼单价',
  `houseletprice` double DEFAULT NULL COMMENT '小楼金额',
  `officenum` int(11) DEFAULT NULL COMMENT '办公楼面积',
  `officelv` int(11) DEFAULT NULL COMMENT '办公楼等级',
  `officeuprice` double DEFAULT NULL COMMENT '办公楼单价',
  `officeprice` double DEFAULT NULL COMMENT '办公楼金额',
  `plantnum` int(11) DEFAULT NULL COMMENT '厂房面积',
  `plantlv` int(11) DEFAULT NULL COMMENT '厂房等级',
  `plantuprice` double DEFAULT NULL COMMENT '厂房单价',
  `plantprice` double DEFAULT NULL COMMENT '厂房金额',
  `retainwallnum` int(11) DEFAULT NULL COMMENT '挡土墙面积',
  `retainwalluprice` double DEFAULT NULL COMMENT '挡土墙单价',
  `retainwallprice` double DEFAULT NULL COMMENT '挡土墙金额',
  `slopewallnum` int(11) DEFAULT NULL COMMENT '护坡墙面积',
  `slopewalluprice` double DEFAULT NULL COMMENT '护坡墙单价',
  `slopewallprice` double DEFAULT NULL COMMENT '护坡墙金额',
  `tilenum` int(11) DEFAULT NULL COMMENT '砖地面积',
  `tileuprice` double DEFAULT NULL COMMENT '砖地单价',
  `tileprice` double DEFAULT NULL COMMENT '砖地金额',
  `wallnum` int(11) DEFAULT NULL COMMENT '围墙面积',
  `walluprice` double DEFAULT NULL COMMENT '围墙单价',
  `wallprice` double DEFAULT NULL COMMENT '围墙金额',
  `shednum` int(11) DEFAULT NULL COMMENT '棚厦个数',
  `sheduprice` double DEFAULT NULL COMMENT '棚厦单价',
  `shedprice` double DEFAULT NULL COMMENT '棚厦金额',
  `wellnum` int(11) DEFAULT NULL COMMENT '水井个数',
  `welluprice` double DEFAULT NULL COMMENT '水井单价',
  `wellprice` double DEFAULT NULL COMMENT '水井金额',
  `doornum` int(11) DEFAULT NULL COMMENT '院门个数',
  `dooruprice` double DEFAULT NULL COMMENT '院门单价',
  `doorpricre` double DEFAULT NULL COMMENT '院门金额',
  `fencenum` int(11) DEFAULT NULL COMMENT '栅栏个数',
  `fenceuprice` double DEFAULT NULL COMMENT '栅栏单价',
  `fenceprice` double DEFAULT NULL COMMENT '栅栏金额',
  `phonenum` int(11) DEFAULT NULL COMMENT '电话个数',
  `phoneuprice` double DEFAULT NULL COMMENT '电话单价',
  `phoneprice` double DEFAULT NULL COMMENT '电话金额',
  `tvnum` int(11) DEFAULT NULL COMMENT '有线电视个数',
  `tvuprice` double DEFAULT NULL COMMENT '有线电视单价',
  `tvprice` double DEFAULT NULL COMMENT '有线电视金额',
  `remark` varchar(50) DEFAULT NULL COMMENT '其它',
  PRIMARY KEY (`id`),
  KEY `mainid` (`mainid`),
  CONSTRAINT `companycompensation_ibfk_1` FOREIGN KEY (`mainid`) REFERENCES `company` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `companycompensation` */

insert  into `companycompensation`(`id`,`mainid`,`name`,`totalmoney`,`asphaltroadnum`,`asphaltroaduprice`,`asphaltroadprice`,`cementroadnum`,`cementroaduprice`,`cementroadprice`,`concretenum`,`concreteuprice`,`concreteprice`,`houseletnum`,`houseletuprice`,`houseletprice`,`officenum`,`officelv`,`officeuprice`,`officeprice`,`plantnum`,`plantlv`,`plantuprice`,`plantprice`,`retainwallnum`,`retainwalluprice`,`retainwallprice`,`slopewallnum`,`slopewalluprice`,`slopewallprice`,`tilenum`,`tileuprice`,`tileprice`,`wallnum`,`walluprice`,`wallprice`,`shednum`,`sheduprice`,`shedprice`,`wellnum`,`welluprice`,`wellprice`,`doornum`,`dooruprice`,`doorpricre`,`fencenum`,`fenceuprice`,`fenceprice`,`phonenum`,`phoneuprice`,`phoneprice`,`tvnum`,`tvuprice`,`tvprice`,`remark`) values (1,2,'方法',72,2,2,4,2,2,4,2,2,4,2,2,4,2,2,2,8,2,2,2,8,2,2,4,2,2,4,2,2,4,2,2,4,2,2,4,2,2,4,2,2,4,2,2,4,2,2,4,2,2,4,'无');

/*Table structure for table `companysettlement` */

DROP TABLE IF EXISTS `companysettlement`;

CREATE TABLE `companysettlement` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `mainid` int(11) NOT NULL COMMENT '动迁人口登记表ID',
  `name` varchar(50) NOT NULL COMMENT '公司名称',
  `oldaddress` varchar(100) NOT NULL COMMENT '原地址',
  `allocationaddress` varchar(50) NOT NULL COMMENT '分配地址',
  `housenum` int(11) NOT NULL COMMENT '原房间数',
  `housearea` double NOT NULL COMMENT '原房面积',
  `houselv` int(11) NOT NULL COMMENT '原房等级',
  `houseuprice` double NOT NULL COMMENT '原房单价',
  `houseprice` double NOT NULL COMMENT '原房金额',
  `facilitiesprice` double NOT NULL COMMENT '原房院内设施金额',
  `allprice1` double NOT NULL COMMENT '合计金额',
  `distributionnum` int(11) NOT NULL COMMENT '分配楼房室数',
  `distributionarea` double NOT NULL COMMENT '分配楼房平数',
  `areacash` double DEFAULT NULL COMMENT '分配楼房面积兑现',
  `areadivided` double DEFAULT NULL COMMENT '分配楼房面积应分',
  `areaadd` double DEFAULT NULL COMMENT '分配楼房面积增档',
  `areaover` double DEFAULT NULL COMMENT '分配楼房面积超档',
  `upcash` double DEFAULT NULL COMMENT '分配楼房增加兑现',
  `updivided` double DEFAULT NULL COMMENT '分配楼房增加应分',
  `upadd` double DEFAULT NULL COMMENT '分配楼房增加增档',
  `upover` double DEFAULT NULL COMMENT '分配楼房增加超档',
  `downcash` double DEFAULT NULL COMMENT '分配楼房减少兑现',
  `downdivided` double DEFAULT NULL COMMENT '分配楼房减少应分',
  `downadd` double DEFAULT NULL COMMENT '分配楼房减少增档',
  `downover` double DEFAULT NULL COMMENT '分配楼房减少超档',
  `pricecash` double DEFAULT NULL COMMENT '分配楼房金额兑现',
  `pricedivided` double DEFAULT NULL COMMENT '分配楼房金额应分',
  `priceadd` double DEFAULT NULL COMMENT '分配楼房金额增档',
  `priceover` double DEFAULT NULL COMMENT '分配楼房金额超档',
  `upricecash` double DEFAULT NULL COMMENT '分配楼房单价兑现',
  `upricedivided` double DEFAULT NULL COMMENT '分配楼房单价应分',
  `upriceadd` double DEFAULT NULL COMMENT '分配楼房单价增档',
  `upriceover` double DEFAULT NULL COMMENT '分配楼房单价超档',
  `allprice2` double DEFAULT NULL COMMENT '合计金额',
  `otherprice` double DEFAULT NULL COMMENT '其它计费项目',
  `settlementprice1` double DEFAULT NULL COMMENT '分配楼房与原房结算金额小写',
  `settlementprice2` varchar(11) DEFAULT NULL COMMENT '分配楼房与原房结算金额大写',
  `remark` varchar(200) DEFAULT NULL COMMENT '备注',
  `director` varchar(50) NOT NULL COMMENT '所长',
  `examine` varchar(50) NOT NULL COMMENT '收款审核',
  `settlement` varchar(50) NOT NULL COMMENT '结算',
  `people` varchar(50) NOT NULL COMMENT '动迁户',
  PRIMARY KEY (`id`),
  KEY `mainid` (`mainid`),
  CONSTRAINT `companysettlement_ibfk_1` FOREIGN KEY (`mainid`) REFERENCES `company` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `companysettlement` */

/*Table structure for table `departmentpurview` */

DROP TABLE IF EXISTS `departmentpurview`;

CREATE TABLE `departmentpurview` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '权限表编号',
  `dp_popedom` int(11) NOT NULL COMMENT '权限编号',
  `dp_number` int(11) NOT NULL COMMENT '部门编号',
  `dp_remark` varchar(50) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`),
  KEY `dep_number` (`dp_number`),
  KEY `dp_popedom` (`dp_popedom`),
  CONSTRAINT `departmentpurview_ibfk_1` FOREIGN KEY (`dp_number`) REFERENCES `departments` (`dep_number`),
  CONSTRAINT `departmentpurview_ibfk_2` FOREIGN KEY (`dp_popedom`) REFERENCES `allpurview` (`ap_popedom`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

/*Data for the table `departmentpurview` */

insert  into `departmentpurview`(`id`,`dp_popedom`,`dp_number`,`dp_remark`) values (1,1,1,NULL),(2,2,1,NULL),(3,3,1,NULL),(5,1,2,NULL),(6,2,2,NULL),(9,3,2,NULL),(12,4,1,NULL),(13,5,1,NULL);

/*Table structure for table `departments` */

DROP TABLE IF EXISTS `departments`;

CREATE TABLE `departments` (
  `dep_number` int(11) NOT NULL AUTO_INCREMENT COMMENT '部门编号',
  `dep_name` varchar(10) DEFAULT NULL COMMENT '部门名称',
  `dep_describe` varchar(50) DEFAULT NULL COMMENT '部门描述',
  `dep_managename` varchar(11) DEFAULT NULL COMMENT '部门经理',
  PRIMARY KEY (`dep_number`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `departments` */

insert  into `departments`(`dep_number`,`dep_name`,`dep_describe`,`dep_managename`) values (1,'前端','负责前端','阿飞'),(2,'后端','负责后端','小黄');

/*Table structure for table `employee` */

DROP TABLE IF EXISTS `employee`;

CREATE TABLE `employee` (
  `e_number` int(11) NOT NULL AUTO_INCREMENT COMMENT '员工编号',
  `e_name` varchar(50) NOT NULL COMMENT '员工姓名',
  `e_email` varchar(50) DEFAULT NULL COMMENT '员工电子邮箱',
  `dep_number` int(11) NOT NULL COMMENT '所属部门编号',
  `e_gender` int(11) NOT NULL COMMENT '性别(1:女，2：男）',
  `e_phone` varchar(50) NOT NULL COMMENT '员工电话',
  `e_birthday` date DEFAULT NULL COMMENT '员工生日',
  `e_remark` varchar(50) DEFAULT NULL COMMENT '备注',
  `e_job` varchar(50) DEFAULT NULL COMMENT '工作',
  `password` varchar(12) DEFAULT '123456' COMMENT '登录密码',
  PRIMARY KEY (`e_number`),
  KEY `dep_number` (`dep_number`),
  CONSTRAINT `employee_ibfk_1` FOREIGN KEY (`dep_number`) REFERENCES `departments` (`dep_number`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Data for the table `employee` */

insert  into `employee`(`e_number`,`e_name`,`e_email`,`dep_number`,`e_gender`,`e_phone`,`e_birthday`,`e_remark`,`e_job`,`password`) values (1,'root','123@qq.com',1,2,'123456','2020-01-27',NULL,'前端','1234567'),(2,'mi','123@123.com',2,1,'654321','2020-02-27',NULL,'后端','123456'),(3,'ti','1111111',2,2,'1222','2020-04-01','eee','eee','123456'),(4,'ww','11',2,1,'11','2020-04-14','we','r','123456');

/*Table structure for table `employeepurview` */

DROP TABLE IF EXISTS `employeepurview`;

CREATE TABLE `employeepurview` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '权限表id',
  `ep_popedom` int(11) NOT NULL COMMENT '权限编号',
  `ep_number` int(11) NOT NULL COMMENT '员工编号',
  `ep_remark` varchar(50) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`),
  KEY `ep_number` (`ep_number`),
  KEY `ep_popedom` (`ep_popedom`),
  CONSTRAINT `employeepurview_ibfk_1` FOREIGN KEY (`ep_number`) REFERENCES `employee` (`e_number`),
  CONSTRAINT `employeepurview_ibfk_2` FOREIGN KEY (`ep_popedom`) REFERENCES `allpurview` (`ap_popedom`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8;

/*Data for the table `employeepurview` */

insert  into `employeepurview`(`id`,`ep_popedom`,`ep_number`,`ep_remark`) values (1,1,1,NULL),(2,2,1,NULL),(5,1,2,NULL),(13,3,1,NULL),(14,4,1,NULL),(15,5,1,NULL),(18,1,3,NULL),(19,2,2,NULL),(20,3,2,NULL),(26,2,3,NULL),(27,3,3,NULL);

/*Table structure for table `people` */

DROP TABLE IF EXISTS `people`;

CREATE TABLE `people` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `name` varchar(20) NOT NULL COMMENT '户主姓名',
  `address` varchar(50) NOT NULL COMMENT '地址',
  `registerdate` date NOT NULL COMMENT '登记日期',
  `remark` varchar(200) DEFAULT NULL COMMENT '需说明事项',
  `autograph` varchar(20) NOT NULL COMMENT '户主签字',
  `head` varchar(10) NOT NULL COMMENT '负责人',
  `agent` varchar(10) NOT NULL COMMENT '经办人',
  `writedate` date NOT NULL COMMENT '填表日期',
  `preparer` varchar(10) NOT NULL COMMENT '添表人',
  `verify` int(1) DEFAULT '0' COMMENT '是否审核',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `people` */

insert  into `people`(`id`,`name`,`address`,`registerdate`,`remark`,`autograph`,`head`,`agent`,`writedate`,`preparer`,`verify`) values (1,'李大壮','李家村','2020-03-01',NULL,'李大壮','村长','支书','2020-03-07','统计员',0),(2,'王翠花','王家屯','2020-03-01',NULL,'王翠花','村长','支书','2020-03-07','统计员',0),(3,'赵四','赵村','2020-04-01','实验','ee','ee','ee','2020-04-08','ee',0);

/*Table structure for table `peoplecompensation` */

DROP TABLE IF EXISTS `peoplecompensation`;

CREATE TABLE `peoplecompensation` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '补偿表编号',
  `mainid` int(11) NOT NULL COMMENT '测量表id',
  `name` varchar(50) NOT NULL COMMENT '户主姓名',
  `address` varchar(50) NOT NULL COMMENT '住址',
  `measuredate` date NOT NULL COMMENT '丈量时间',
  `totalmoney` double DEFAULT NULL COMMENT '总金额',
  `housenum` int(11) DEFAULT NULL COMMENT '房屋数量',
  `housearea` int(11) DEFAULT NULL COMMENT '房屋面积',
  `houselv` int(11) DEFAULT NULL COMMENT '房屋等级',
  `houseuprice` double DEFAULT NULL COMMENT '房屋单价',
  `houseprice` double DEFAULT NULL COMMENT '房屋金额',
  `cellanum` int(11) DEFAULT NULL COMMENT '小房数量',
  `cellaarea` int(11) DEFAULT NULL COMMENT '小房面积',
  `cellalv` int(11) DEFAULT NULL COMMENT '小房等级',
  `cellauprice` double DEFAULT NULL COMMENT '小房单价',
  `cellaprice` double DEFAULT NULL COMMENT '小房金额',
  `wellnum` int(11) DEFAULT NULL COMMENT '水井眼数',
  `welluprice` double DEFAULT NULL COMMENT '水井单价',
  `wellprice` double DEFAULT NULL COMMENT '水井金额',
  `phonenum` int(11) DEFAULT NULL COMMENT '电话迁移盘数',
  `phoneuprice` double DEFAULT NULL COMMENT '电话迁移单价',
  `phoneprice` double DEFAULT NULL COMMENT '电话迁移金额',
  `digesternum` int(11) DEFAULT NULL COMMENT '沼气池个数',
  `digesteruprice` double DEFAULT NULL COMMENT '沼气池单价',
  `digesterprice` double DEFAULT NULL COMMENT '沼气池金额',
  `wallnum` int(11) DEFAULT NULL COMMENT '围墙面积',
  `walluprice` double DEFAULT NULL COMMENT '围墙单价',
  `wallprice` double DEFAULT NULL COMMENT '围墙金额',
  `pigpennum` int(11) DEFAULT NULL COMMENT '猪圈个数',
  `pigpenuprice` double DEFAULT NULL COMMENT '猪圈单价',
  `pigpenprice` double DEFAULT NULL COMMENT '猪圈金额',
  `wcnum` int(11) DEFAULT NULL COMMENT '厕所个数',
  `wcuprice` double DEFAULT NULL COMMENT '厕所单价',
  `wcprice` double DEFAULT NULL COMMENT '厕所金额',
  `concretenum` int(11) DEFAULT NULL COMMENT '水泥地面积',
  `concreteuprice` double DEFAULT NULL COMMENT '水泥地单价',
  `concreteprice` double DEFAULT NULL COMMENT '水泥地金额',
  `cellarnum` int(11) DEFAULT NULL COMMENT '地窖个数',
  `cellaruprice` double DEFAULT NULL COMMENT '地窖单价',
  `cellarprice` double DEFAULT NULL COMMENT '地窖金额',
  `shacknum` int(11) DEFAULT NULL COMMENT '畜禽舍棚个数',
  `shackuprice` double DEFAULT NULL COMMENT '畜禽舍棚单价',
  `shackprice` double DEFAULT NULL COMMENT '畜禽舍棚金额',
  `waternum` int(11) DEFAULT NULL COMMENT '自来水个数',
  `wateruprice` double DEFAULT NULL COMMENT '自来水单价',
  `waterprice` double DEFAULT NULL COMMENT '自来水金额',
  `tvnum` int(11) DEFAULT NULL COMMENT '有线电视迁移个数',
  `tvuprice` double DEFAULT NULL COMMENT '有线电视迁移单价',
  `tvprice` double DEFAULT NULL COMMENT '有线电视迁移金额',
  `archnum` int(11) DEFAULT NULL COMMENT '门楼个数',
  `archuprice` double DEFAULT NULL COMMENT '门楼单价',
  `archprice` double DEFAULT NULL COMMENT '门楼金额',
  `tree7num` int(11) DEFAULT NULL COMMENT '果树1-7年个数',
  `tree7uprice` double DEFAULT NULL COMMENT '果树1-7年单价',
  `tree7price` double DEFAULT NULL COMMENT '果树1-7年金额',
  `tree8num` int(11) DEFAULT NULL COMMENT '果树1-8年个数',
  `tree8uprice` double DEFAULT NULL COMMENT '果树1-8年单价',
  `tree8price` double DEFAULT NULL COMMENT '果树1-8年金额',
  `treespnum` int(11) DEFAULT NULL COMMENT '果树特殊个数',
  `treespuprice` double DEFAULT NULL COMMENT '果树特殊单价',
  `treespprice` double DEFAULT NULL COMMENT '果树特殊金额',
  `remark` varchar(100) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`),
  KEY `mainid` (`mainid`),
  CONSTRAINT `peoplecompensation_ibfk_1` FOREIGN KEY (`mainid`) REFERENCES `people` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `peoplecompensation` */

insert  into `peoplecompensation`(`id`,`mainid`,`name`,`address`,`measuredate`,`totalmoney`,`housenum`,`housearea`,`houselv`,`houseuprice`,`houseprice`,`cellanum`,`cellaarea`,`cellalv`,`cellauprice`,`cellaprice`,`wellnum`,`welluprice`,`wellprice`,`phonenum`,`phoneuprice`,`phoneprice`,`digesternum`,`digesteruprice`,`digesterprice`,`wallnum`,`walluprice`,`wallprice`,`pigpennum`,`pigpenuprice`,`pigpenprice`,`wcnum`,`wcuprice`,`wcprice`,`concretenum`,`concreteuprice`,`concreteprice`,`cellarnum`,`cellaruprice`,`cellarprice`,`shacknum`,`shackuprice`,`shackprice`,`waternum`,`wateruprice`,`waterprice`,`tvnum`,`tvuprice`,`tvprice`,`archnum`,`archuprice`,`archprice`,`tree7num`,`tree7uprice`,`tree7price`,`tree8num`,`tree8uprice`,`tree8price`,`treespnum`,`treespuprice`,`treespprice`,`remark`) values (1,1,'弟弟','汪汪汪汪','2020-02-24',17,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,'1');

/*Table structure for table `peopledetail` */

DROP TABLE IF EXISTS `peopledetail`;

CREATE TABLE `peopledetail` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `mainid` int(11) NOT NULL COMMENT '主表ID',
  `name` varchar(10) NOT NULL COMMENT '姓名',
  `relationship` varchar(10) NOT NULL COMMENT '与户主关系',
  `gender` int(11) NOT NULL COMMENT '性别',
  `onlychild` int(11) NOT NULL COMMENT '是否是独生子女',
  `birthday` date NOT NULL COMMENT '出生年月日',
  `residencefrom` varchar(50) NOT NULL COMMENT '户口本发证派出所',
  `residenceid` varchar(20) NOT NULL COMMENT '户口本户口编号',
  `residencedate` date NOT NULL COMMENT '户口本立户时间',
  `marryfrom` varchar(50) DEFAULT NULL COMMENT '结婚证发证机关',
  `marryid` varchar(20) DEFAULT NULL COMMENT '结婚证编号',
  `marrydate` date DEFAULT NULL COMMENT '结婚证登记时间',
  `remark` varchar(50) DEFAULT NULL COMMENT '备注',
  `verify` int(11) DEFAULT '0' COMMENT '是否审核',
  PRIMARY KEY (`id`),
  KEY `mainid` (`mainid`),
  CONSTRAINT `peopledetail_ibfk_1` FOREIGN KEY (`mainid`) REFERENCES `people` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Data for the table `peopledetail` */

insert  into `peopledetail`(`id`,`mainid`,`name`,`relationship`,`gender`,`onlychild`,`birthday`,`residencefrom`,`residenceid`,`residencedate`,`marryfrom`,`marryid`,`marrydate`,`remark`,`verify`) values (1,1,'李一飞','父子',2,2,'2020-02-24','华夏派出所','1111','2020-02-26','华夏民政局','1111','2020-02-24','长子',0),(2,1,'李二飞','父子',2,2,'2020-02-24','华夏派出所','1111','2020-02-26',NULL,NULL,NULL,'次子',0),(3,2,'王一丫','母女',1,1,'2020-04-03','华夏派出所','1112','2020-03-04','华夏',NULL,NULL,'独女',0),(4,3,'赵水','母子',2,1,'2020-04-13','111','111','2020-04-20','111','11','2020-04-20','外网',0);

/*Table structure for table `peoplesettlement` */

DROP TABLE IF EXISTS `peoplesettlement`;

CREATE TABLE `peoplesettlement` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `mainid` int(11) NOT NULL COMMENT '动迁人口登记表ID',
  `name` varchar(50) NOT NULL COMMENT '户主姓名',
  `oldaddress` varchar(100) NOT NULL COMMENT '原住址',
  `chambertype` varchar(50) NOT NULL COMMENT '分配室型',
  `buildingnumber` varchar(50) NOT NULL COMMENT '楼号',
  `housenum` int(11) NOT NULL COMMENT '原房间数',
  `housearea` double NOT NULL COMMENT '原房面积',
  `houselv` int(11) NOT NULL COMMENT '原房等级',
  `houseuprice` double NOT NULL COMMENT '原房单价',
  `houseprice` double NOT NULL COMMENT '原房金额',
  `facilitiesprice` double NOT NULL COMMENT '原房院内设施金额',
  `allprice1` double NOT NULL COMMENT '合计金额',
  `distributionnum` int(11) NOT NULL COMMENT '分配楼房室数',
  `distributionarea` double NOT NULL COMMENT '分配楼房平数',
  `areacash` double DEFAULT NULL COMMENT '分配楼房面积兑现',
  `areadivided` double DEFAULT NULL COMMENT '分配楼房面积应分',
  `areaadd` double DEFAULT NULL COMMENT '分配楼房面积增档',
  `areaover` double DEFAULT NULL COMMENT '分配楼房面积超档',
  `upcash` double DEFAULT NULL COMMENT '分配楼房增加兑现',
  `updivided` double DEFAULT NULL COMMENT '分配楼房增加应分',
  `upadd` double DEFAULT NULL COMMENT '分配楼房增加增档',
  `upover` double DEFAULT NULL COMMENT '分配楼房增加超档',
  `downcash` double DEFAULT NULL COMMENT '分配楼房减少兑现',
  `downdivided` double DEFAULT NULL COMMENT '分配楼房减少应分',
  `downadd` double DEFAULT NULL COMMENT '分配楼房减少增档',
  `downover` double DEFAULT NULL COMMENT '分配楼房减少超档',
  `pricecash` double DEFAULT NULL COMMENT '分配楼房金额兑现',
  `pricedivided` double DEFAULT NULL COMMENT '分配楼房金额应分',
  `priceadd` double DEFAULT NULL COMMENT '分配楼房金额增档',
  `priceover` double DEFAULT NULL COMMENT '分配楼房金额超档',
  `upricecash` double DEFAULT NULL COMMENT '分配楼房单价兑现',
  `upricedivided` double DEFAULT NULL COMMENT '分配楼房单价应分',
  `upriceadd` double DEFAULT NULL COMMENT '分配楼房单价增档',
  `upriceover` double DEFAULT NULL COMMENT '分配楼房单价超档',
  `allprice2` double DEFAULT NULL COMMENT '合计金额',
  `otherprice` double DEFAULT NULL COMMENT '其它计费项目',
  `settlementprice1` double DEFAULT NULL COMMENT '分配楼房与原房结算金额小写',
  `settlementprice2` varchar(50) DEFAULT NULL COMMENT '分配楼房与原房结算金额大写',
  `remark` varchar(200) DEFAULT NULL COMMENT '备注',
  `director` varchar(50) NOT NULL COMMENT '所长',
  `examine` varchar(50) NOT NULL COMMENT '收款审核',
  `settlement` varchar(50) NOT NULL COMMENT '结算',
  `people` varchar(50) NOT NULL COMMENT '动迁户',
  PRIMARY KEY (`id`),
  KEY `mainid` (`mainid`),
  CONSTRAINT `peoplesettlement_ibfk_1` FOREIGN KEY (`mainid`) REFERENCES `people` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `peoplesettlement` */

insert  into `peoplesettlement`(`id`,`mainid`,`name`,`oldaddress`,`chambertype`,`buildingnumber`,`housenum`,`housearea`,`houselv`,`houseuprice`,`houseprice`,`facilitiesprice`,`allprice1`,`distributionnum`,`distributionarea`,`areacash`,`areadivided`,`areaadd`,`areaover`,`upcash`,`updivided`,`upadd`,`upover`,`downcash`,`downdivided`,`downadd`,`downover`,`pricecash`,`pricedivided`,`priceadd`,`priceover`,`upricecash`,`upricedivided`,`upriceadd`,`upriceover`,`allprice2`,`otherprice`,`settlementprice1`,`settlementprice2`,`remark`,`director`,`examine`,`settlement`,`people`) values (1,1,'我','我','我','1',0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,0,'0','','','','','');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
