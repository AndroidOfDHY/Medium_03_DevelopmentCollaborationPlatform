# MySQL-Front 5.1  (Build 3.35)

/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE */;
/*!40101 SET SQL_MODE='STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES */;
/*!40103 SET SQL_NOTES='ON' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS */;
/*!40014 SET FOREIGN_KEY_CHECKS=0 */;


# Host: localhost    Database: oops
# ------------------------------------------------------
# Server version 5.0.91-community-nt

#
# Source for table business
#

DROP TABLE IF EXISTS `business`;
CREATE TABLE `business` (
  `id` int(11) NOT NULL auto_increment,
  `link` varchar(255) default NULL,
  `company` varchar(255) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

#
# Dumping data for table business
#
LOCK TABLES `business` WRITE;
/*!40000 ALTER TABLE `business` DISABLE KEYS */;

INSERT INTO `business` VALUES (1,'2012-07-23_135925.png','IBM');
INSERT INTO `business` VALUES (2,'2012-07-23_135939.png','SAP');
INSERT INTO `business` VALUES (3,'2012-07-23_135949.png','DAMCO');
INSERT INTO `business` VALUES (4,'2012-07-23_135959.png','埃森哲');
INSERT INTO `business` VALUES (5,'2012-07-23_140009.png','腾讯');
INSERT INTO `business` VALUES (6,'2012-07-23_140018.png','西门子');
INSERT INTO `business` VALUES (7,'2012-07-23_140030.png','Established');
INSERT INTO `business` VALUES (8,'2012-07-23_140042.png','华为');
/*!40000 ALTER TABLE `business` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table drill_book
#

DROP TABLE IF EXISTS `drill_book`;
CREATE TABLE `drill_book` (
  `uid` varchar(255) NOT NULL default '',
  `unit` varchar(255) default NULL,
  `project` varchar(255) default NULL,
  `uname` varchar(255) default NULL,
  `phone` varchar(255) default NULL,
  `phone1` varchar(255) default NULL,
  `email` varchar(255) default NULL,
  PRIMARY KEY  (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Dumping data for table drill_book
#
LOCK TABLES `drill_book` WRITE;
/*!40000 ALTER TABLE `drill_book` DISABLE KEYS */;

INSERT INTO `drill_book` VALUES ('aaaaaaa','单位','项目','联系人','电话','手机','5');
INSERT INTO `drill_book` VALUES ('customer','abcd','abc','客户经理','647279','12222','oops');
INSERT INTO `drill_book` VALUES ('student','aa','aaa','aaa','aaa','kkk','aa');
/*!40000 ALTER TABLE `drill_book` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table essential_information
#

DROP TABLE IF EXISTS `essential_information`;
CREATE TABLE `essential_information` (
  `account` varchar(30) NOT NULL default '',
  `password` varchar(30) NOT NULL default '',
  `flag` int(11) NOT NULL default '0',
  `uname` varchar(20) NOT NULL default '',
  `birthday` varchar(30) default NULL,
  `nowlive` varchar(30) default NULL,
  `hj` varchar(30) default NULL,
  `phone` varchar(20) default NULL,
  `email` varchar(30) NOT NULL default '',
  `qq` varchar(15) NOT NULL default '',
  `gzcmy` varchar(50) NOT NULL default '',
  PRIMARY KEY  (`account`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Dumping data for table essential_information
#
LOCK TABLES `essential_information` WRITE;
/*!40000 ALTER TABLE `essential_information` DISABLE KEYS */;

INSERT INTO `essential_information` VALUES ('0a+XIPEwy9zBm0BBPVka/A==','3APW2qKZWzfhUsK6HgDSbQ==',1,'临时学员','1991-6-15','吕庄大厦','浙江 乐清','15258284661','4219@qq.com','4219','');
INSERT INTO `essential_information` VALUES ('3dCqcHEWp7ouHQN70cdGJA==','4QrcOUm6Wau+VuBX8g+IPg==',1,'小宝','1993-5-1','宁波','浙江 宁波','15258284661','325600@qq.com','12345678','');
INSERT INTO `essential_information` VALUES ('GM1PVwpge9FD7Rpb908Yvg==','4QrcOUm6Wau+VuBX8g+IPg==',3,'果冻豆','2050-5-1','上海三湘四季小区','浙江 乐清','18918966789','@qq.com','289721322','1,2,3,4,5,6');
INSERT INTO `essential_information` VALUES ('ISMvKXpXpadDiUoOSoAfww==','Qpf0SxOVUjUkWySXOZ16kw==',2,'超级管理员','1991-5-1','浙江 乐清','浙江 乐清','15258284661','oops@163.com','421949274','');
/*!40000 ALTER TABLE `essential_information` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table img
#

DROP TABLE IF EXISTS `img`;
CREATE TABLE `img` (
  `id` int(11) NOT NULL auto_increment,
  `link` varchar(255) default NULL,
  `company` varchar(255) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

#
# Dumping data for table img
#
LOCK TABLES `img` WRITE;
/*!40000 ALTER TABLE `img` DISABLE KEYS */;

INSERT INTO `img` VALUES (1,'example_1.jsp','绿城万华城');
INSERT INTO `img` VALUES (2,'#','五和苹果国际');
INSERT INTO `img` VALUES (3,'#','手机widgets');
INSERT INTO `img` VALUES (4,'#','公司');
INSERT INTO `img` VALUES (5,'#','江西旅游网');
INSERT INTO `img` VALUES (6,'#','公司');
INSERT INTO `img` VALUES (7,'#','江西旅游网');
INSERT INTO `img` VALUES (8,'#','绿城万华城');
INSERT INTO `img` VALUES (9,'#','五和苹果国际');
INSERT INTO `img` VALUES (10,'#','手机widgets');
/*!40000 ALTER TABLE `img` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table info
#

DROP TABLE IF EXISTS `info`;
CREATE TABLE `info` (
  `Id` int(11) NOT NULL auto_increment,
  `username` varchar(255) default NULL,
  `email` varchar(255) default '',
  `phone` varchar(255) default NULL,
  `message` varchar(255) default NULL,
  PRIMARY KEY  (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

#
# Dumping data for table info
#
LOCK TABLES `info` WRITE;
/*!40000 ALTER TABLE `info` DISABLE KEYS */;

INSERT INTO `info` VALUES (1,'1','@q.com','1111111111','hello');
INSERT INTO `info` VALUES (2,'xyz','@qq.com','12121212121','wwwwwww');
INSERT INTO `info` VALUES (3,'xxx','@qq.com','15258284661','Hello world!');
/*!40000 ALTER TABLE `info` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table job_info
#

DROP TABLE IF EXISTS `job_info`;
CREATE TABLE `job_info` (
  `uid` varchar(11) NOT NULL default '',
  `uname` varchar(255) NOT NULL default 'uname',
  `email` varchar(255) NOT NULL default '',
  PRIMARY KEY  (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Dumping data for table job_info
#
LOCK TABLES `job_info` WRITE;
/*!40000 ALTER TABLE `job_info` DISABLE KEYS */;

INSERT INTO `job_info` VALUES ('student','你 好 ！','12345@qq.com');
/*!40000 ALTER TABLE `job_info` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table long_train
#

DROP TABLE IF EXISTS `long_train`;
CREATE TABLE `long_train` (
  `Id` int(11) NOT NULL auto_increment,
  `title` varchar(255) default NULL,
  `time` varchar(255) default NULL,
  `remark` varchar(255) default '预约',
  PRIMARY KEY  (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

#
# Dumping data for table long_train
#
LOCK TABLES `long_train` WRITE;
/*!40000 ALTER TABLE `long_train` DISABLE KEYS */;

INSERT INTO `long_train` VALUES (1,'服务外包','2012-2-2','下载');
INSERT INTO `long_train` VALUES (2,'C语言','2012-2-22','下载');
INSERT INTO `long_train` VALUES (3,'Linux','2012-3-1','下载');
INSERT INTO `long_train` VALUES (4,'编译原理','2012-3-15','下载');
INSERT INTO `long_train` VALUES (5,'数据库设计','2012-3-25','下载');
INSERT INTO `long_train` VALUES (6,'JSP网络技术','2012-4-5','下载');
INSERT INTO `long_train` VALUES (7,'专业英语','2012-4-15','下载');
INSERT INTO `long_train` VALUES (8,'电子相册','2012-4-20','下载');
/*!40000 ALTER TABLE `long_train` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table new_img
#

DROP TABLE IF EXISTS `new_img`;
CREATE TABLE `new_img` (
  `Id` int(11) NOT NULL auto_increment,
  `link` varchar(255) default NULL,
  `company` varchar(255) default NULL,
  PRIMARY KEY  (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

#
# Dumping data for table new_img
#
LOCK TABLES `new_img` WRITE;
/*!40000 ALTER TABLE `new_img` DISABLE KEYS */;

INSERT INTO `new_img` VALUES (1,'#','oops');
INSERT INTO `new_img` VALUES (2,'#','绿城万华城');
INSERT INTO `new_img` VALUES (3,'#','五和苹果国际');
INSERT INTO `new_img` VALUES (4,'#','手机widgets');
INSERT INTO `new_img` VALUES (5,'#','公司');
INSERT INTO `new_img` VALUES (6,'#','江西旅游网');
INSERT INTO `new_img` VALUES (7,'#','公司');
INSERT INTO `new_img` VALUES (8,'#','江西旅游网');
INSERT INTO `new_img` VALUES (9,'#','绿城万华城');
INSERT INTO `new_img` VALUES (10,'#','五和苹果国际');
INSERT INTO `new_img` VALUES (11,'#','手机widgets');
/*!40000 ALTER TABLE `new_img` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table newtb
#

DROP TABLE IF EXISTS `newtb`;
CREATE TABLE `newtb` (
  `id` int(11) NOT NULL auto_increment,
  `username` varchar(255) default NULL,
  `title` varchar(255) default NULL,
  `message` varchar(255) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

#
# Dumping data for table newtb
#
LOCK TABLES `newtb` WRITE;
/*!40000 ALTER TABLE `newtb` DISABLE KEYS */;

INSERT INTO `newtb` VALUES (1,'student','大家好！','很高兴能参加oops团队，感谢大家的支持和鼓励！');
INSERT INTO `newtb` VALUES (2,'student','我是学生！','我是一名本科院校的学生！');
INSERT INTO `newtb` VALUES (3,'student','哈哈','哈哈');
INSERT INTO `newtb` VALUES (4,'customer','!-_-!~~','你好，hello world！');
/*!40000 ALTER TABLE `newtb` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table ofrc
#

DROP TABLE IF EXISTS `ofrc`;
CREATE TABLE `ofrc` (
  `Id` int(11) NOT NULL auto_increment,
  `title` varchar(255) default NULL,
  PRIMARY KEY  (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

#
# Dumping data for table ofrc
#
LOCK TABLES `ofrc` WRITE;
/*!40000 ALTER TABLE `ofrc` DISABLE KEYS */;

INSERT INTO `ofrc` VALUES (1,'什么是SEO');
INSERT INTO `ofrc` VALUES (2,'软文推广对提升网站权重的重要性');
INSERT INTO `ofrc` VALUES (3,'增加网站反向链接的10种方法');
INSERT INTO `ofrc` VALUES (4,'网络推广效果重在网站市场分析');
INSERT INTO `ofrc` VALUES (5,'如何增加关键字密度');
INSERT INTO `ofrc` VALUES (6,'如何学好JSP技术');
INSERT INTO `ofrc` VALUES (7,'数据库的池连接和桥连接的好处');
/*!40000 ALTER TABLE `ofrc` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table order_information
#

DROP TABLE IF EXISTS `order_information`;
CREATE TABLE `order_information` (
  `id` int(11) NOT NULL auto_increment,
  `account` varchar(30) NOT NULL default '',
  `project` varchar(30) default NULL,
  `company` varchar(30) default NULL,
  `times` varchar(39) default NULL,
  `feedback` varchar(30) default NULL,
  PRIMARY KEY  (`id`),
  KEY `预约` (`account`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

#
# Dumping data for table order_information
#
LOCK TABLES `order_information` WRITE;
/*!40000 ALTER TABLE `order_information` DISABLE KEYS */;

INSERT INTO `order_information` VALUES (3,'ISMvKXpXpadDiUoOSoAfww==','android','google','2012-7-7','t');
INSERT INTO `order_information` VALUES (4,'ISMvKXpXpadDiUoOSoAfww==','数据库设计','浙大网新','2012-7-17','t');
INSERT INTO `order_information` VALUES (5,'ISMvKXpXpadDiUoOSoAfww==','网页设计','阿里巴巴','2012-7-27','f');
/*!40000 ALTER TABLE `order_information` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table ordinary_comm
#

DROP TABLE IF EXISTS `ordinary_comm`;
CREATE TABLE `ordinary_comm` (
  `first` varchar(25) default NULL,
  `second` varchar(25) default NULL,
  `third` varchar(25) default NULL,
  `fourth` varchar(20) default NULL,
  `usernm` varchar(255) NOT NULL default '',
  `pj` varchar(255) default NULL,
  PRIMARY KEY  (`usernm`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Dumping data for table ordinary_comm
#
LOCK TABLES `ordinary_comm` WRITE;
/*!40000 ALTER TABLE `ordinary_comm` DISABLE KEYS */;

INSERT INTO `ordinary_comm` VALUES ('4','4','4','4','0a+XIPEwy9zBm0BBPVka/A==','å¹¿åè¥éç³»ç»');
INSERT INTO `ordinary_comm` VALUES ('3','3','5','5','customer','2');
/*!40000 ALTER TABLE `ordinary_comm` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table ordinary_user
#

DROP TABLE IF EXISTS `ordinary_user`;
CREATE TABLE `ordinary_user` (
  `username` varchar(255) NOT NULL default '',
  `password` varchar(255) NOT NULL default '',
  `flag` int(11) NOT NULL default '0',
  PRIMARY KEY  (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Dumping data for table ordinary_user
#
LOCK TABLES `ordinary_user` WRITE;
/*!40000 ALTER TABLE `ordinary_user` DISABLE KEYS */;

INSERT INTO `ordinary_user` VALUES ('admin','123',2);
INSERT INTO `ordinary_user` VALUES ('bobo11','123123',1);
INSERT INTO `ordinary_user` VALUES ('bobo22','123123',1);
INSERT INTO `ordinary_user` VALUES ('bobo44','123123',1);
INSERT INTO `ordinary_user` VALUES ('bobobo','123123',1);
INSERT INTO `ordinary_user` VALUES ('company','123',4);
INSERT INTO `ordinary_user` VALUES ('customer','123',3);
INSERT INTO `ordinary_user` VALUES ('dhy2603','w123456',3);
INSERT INTO `ordinary_user` VALUES ('dhy2604','w123456',1);
INSERT INTO `ordinary_user` VALUES ('dhy_jw','123',1);
INSERT INTO `ordinary_user` VALUES ('student','123',1);
INSERT INTO `ordinary_user` VALUES ('超级管理员','123',2);
/*!40000 ALTER TABLE `ordinary_user` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table plan__information
#

DROP TABLE IF EXISTS `plan__information`;
CREATE TABLE `plan__information` (
  `Id` int(11) NOT NULL auto_increment,
  `p_name` varchar(255) default NULL,
  `company` varchar(255) default NULL,
  `times` varchar(255) default NULL,
  `plan` int(11) default NULL,
  `account` varchar(255) default NULL,
  PRIMARY KEY  (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

#
# Dumping data for table plan__information
#
LOCK TABLES `plan__information` WRITE;
/*!40000 ALTER TABLE `plan__information` DISABLE KEYS */;

INSERT INTO `plan__information` VALUES (1,'广告营销系统','浙大网新','2012-7-15',100,'345');
INSERT INTO `plan__information` VALUES (2,'学生成绩系统','无锡海辉','2012-7-20',60,'345');
/*!40000 ALTER TABLE `plan__information` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table project
#

DROP TABLE IF EXISTS `project`;
CREATE TABLE `project` (
  `id` int(11) NOT NULL auto_increment,
  `pjname` varchar(251) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

#
# Dumping data for table project
#
LOCK TABLES `project` WRITE;
/*!40000 ALTER TABLE `project` DISABLE KEYS */;

INSERT INTO `project` VALUES (1,'协作平台');
INSERT INTO `project` VALUES (2,'财务系统');
/*!40000 ALTER TABLE `project` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table project_order
#

DROP TABLE IF EXISTS `project_order`;
CREATE TABLE `project_order` (
  `Id` int(11) NOT NULL auto_increment,
  `title` varchar(255) default NULL,
  `time` varchar(255) default NULL,
  `remark` varchar(255) default '预约',
  PRIMARY KEY  (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

#
# Dumping data for table project_order
#
LOCK TABLES `project_order` WRITE;
/*!40000 ALTER TABLE `project_order` DISABLE KEYS */;

INSERT INTO `project_order` VALUES (1,'数据库','2012-1-1','预约');
INSERT INTO `project_order` VALUES (2,'网络技术','2012-2-2','预约');
INSERT INTO `project_order` VALUES (3,'JAVA EE','201-2-15','预约');
INSERT INTO `project_order` VALUES (4,'ORACLE','2012-3-3','预约');
INSERT INTO `project_order` VALUES (5,'软件工程','2012-3-18','预约');
INSERT INTO `project_order` VALUES (6,'网络工程','2012-4-3','预约');
INSERT INTO `project_order` VALUES (7,'服务外包','2012-4-20','预约');
INSERT INTO `project_order` VALUES (8,'网页设计','2012-5-5','预约');
/*!40000 ALTER TABLE `project_order` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table project_plan
#

DROP TABLE IF EXISTS `project_plan`;
CREATE TABLE `project_plan` (
  `title` varchar(255) default NULL,
  `time` varchar(255) default NULL,
  `remark` varchar(255) default NULL,
  `number` int(11) default NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Dumping data for table project_plan
#
LOCK TABLES `project_plan` WRITE;
/*!40000 ALTER TABLE `project_plan` DISABLE KEYS */;

INSERT INTO `project_plan` VALUES ('课程（周二）','上课时间','地点',20);
INSERT INTO `project_plan` VALUES ('软件工程(教师：黛玉8：00—9：45)','2012-5-8','JX-507',22);
INSERT INTO `project_plan` VALUES ('课程（周一）','上课时间','地点',10);
INSERT INTO `project_plan` VALUES ('平面设计(教师：宝钗8：00—9：45)','2012-5-7','JX-505',12);
INSERT INTO `project_plan` VALUES ('课程（周三）','上课时间','地点',30);
INSERT INTO `project_plan` VALUES ('课程（周四）','上课时间','地点',40);
INSERT INTO `project_plan` VALUES ('网络工程(教师：JAY8：00—9：45)','2012-5-9','XX-707',32);
INSERT INTO `project_plan` VALUES ('课程（周五）','上课时间','地点',50);
INSERT INTO `project_plan` VALUES ('JAVA(教师：HGJ10：00—11：30)','2012-5-11','XX-301',52);
INSERT INTO `project_plan` VALUES ('web网页设计(教师：Jack8：00—9：45)','2012-5-10','JX-101',42);
INSERT INTO `project_plan` VALUES ('编译原理(教师：宝玉13：30—15：15)','2012-5-7','JX-105',11);
INSERT INTO `project_plan` VALUES ('JSP页面设计(教师：BOBO10：00—11：30)','2012-5-8','JX-303',21);
INSERT INTO `project_plan` VALUES ('专业英语(教师：佐助10：00—11：30','2012-5-9','XX-404',31);
INSERT INTO `project_plan` VALUES ('网络技术(教师：WM8：00—9：45)','2012-5-11','XX-3-3',51);
INSERT INTO `project_plan` VALUES ('嵌入式应用开发(教师：一休哥13：30—15：15)','2012-5-11','JX-103',52);
INSERT INTO `project_plan` VALUES ('电工(教师：LXL10：00—11：30)','2012-5-10','JX-206',41);
INSERT INTO `project_plan` VALUES ('oops(教师：Tom13：30—15：15)','2012-5-9','JX-202',32);
/*!40000 ALTER TABLE `project_plan` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table project_trends
#

DROP TABLE IF EXISTS `project_trends`;
CREATE TABLE `project_trends` (
  `Id` int(11) NOT NULL auto_increment,
  `title` varchar(255) default NULL,
  `time` varchar(255) default NULL,
  `remark` varchar(255) default NULL,
  PRIMARY KEY  (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

#
# Dumping data for table project_trends
#
LOCK TABLES `project_trends` WRITE;
/*!40000 ALTER TABLE `project_trends` DISABLE KEYS */;

INSERT INTO `project_trends` VALUES (1,'软件工程','2012-1-1','2012-2-1');
INSERT INTO `project_trends` VALUES (2,'web前台设计','2010-1-1','2012-2-1');
INSERT INTO `project_trends` VALUES (3,'编译原理','2012-1-1','2012-2-1');
INSERT INTO `project_trends` VALUES (4,'C语言','2012-1-1','2012-2-1');
INSERT INTO `project_trends` VALUES (5,'嵌入式平台设计','2012-1-5','2012-2-1');
INSERT INTO `project_trends` VALUES (6,'数据结构','2012-1-5','2012-2-1');
INSERT INTO `project_trends` VALUES (7,'软件工程','2012-1-5','2012-2-1');
INSERT INTO `project_trends` VALUES (9,'服务外包','2012-1-5','2012-2-1');
/*!40000 ALTER TABLE `project_trends` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table talents
#

DROP TABLE IF EXISTS `talents`;
CREATE TABLE `talents` (
  `Id` int(11) NOT NULL auto_increment,
  PRIMARY KEY  (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Dumping data for table talents
#
LOCK TABLES `talents` WRITE;
/*!40000 ALTER TABLE `talents` DISABLE KEYS */;

/*!40000 ALTER TABLE `talents` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table talents_information
#

DROP TABLE IF EXISTS `talents_information`;
CREATE TABLE `talents_information` (
  `id` int(11) NOT NULL auto_increment,
  `account` varchar(30) NOT NULL default '',
  `first` varchar(30) NOT NULL default '',
  `second` varchar(30) NOT NULL default '',
  `job` varchar(30) NOT NULL default '',
  `pay` int(11) default NULL,
  `skill` varchar(30) default NULL,
  `speciality` varchar(100) default NULL,
  `remark` varchar(100) default NULL,
  PRIMARY KEY  (`id`),
  KEY `人才` (`account`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

#
# Dumping data for table talents_information
#
LOCK TABLES `talents_information` WRITE;
/*!40000 ALTER TABLE `talents_information` DISABLE KEYS */;

INSERT INTO `talents_information` VALUES (1,'GM1PVwpge9FD7Rpb908Yvg==','2','3','4',5,'6','7','8');
/*!40000 ALTER TABLE `talents_information` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table teach
#

DROP TABLE IF EXISTS `teach`;
CREATE TABLE `teach` (
  `Id` int(11) NOT NULL auto_increment,
  `title` varchar(255) default NULL,
  `time` varchar(255) default NULL,
  `remark` varchar(255) default '下载',
  PRIMARY KEY  (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

#
# Dumping data for table teach
#
LOCK TABLES `teach` WRITE;
/*!40000 ALTER TABLE `teach` DISABLE KEYS */;

INSERT INTO `teach` VALUES (1,'软件工程','PPT','下载');
INSERT INTO `teach` VALUES (2,'网络工程','视频','下载');
INSERT INTO `teach` VALUES (3,'编译原理','word','下载');
INSERT INTO `teach` VALUES (4,'数据库设计','PPT','下载');
INSERT INTO `teach` VALUES (5,'Android','视频','下载');
INSERT INTO `teach` VALUES (6,'JavaEE框架技术','PDF','下载');
INSERT INTO `teach` VALUES (7,'计算机网络技术','视频','下载');
INSERT INTO `teach` VALUES (8,'计算机网络工程','word','下载');
/*!40000 ALTER TABLE `teach` ENABLE KEYS */;
UNLOCK TABLES;

#
#  Foreign keys for table order_information
#

ALTER TABLE `order_information`
ADD CONSTRAINT `预约` FOREIGN KEY (`account`) REFERENCES `essential_information` (`account`);

#
#  Foreign keys for table talents_information
#

ALTER TABLE `talents_information`
ADD CONSTRAINT `人才` FOREIGN KEY (`account`) REFERENCES `essential_information` (`account`);


/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
