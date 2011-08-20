# MySQL-Front 3.2  (Build 7.10)
/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES 'latin1' */;


# Host: localhost    Database: depths
# ------------------------------------------------------
# Server version 5.0.15-nt

DROP DATABASE IF EXISTS `depths`;
CREATE DATABASE `depths` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `depths`;


#
# Table structure for table administrator_has_groups
#

CREATE TABLE `administrator_has_groups` (
  `NMID` int(11) NOT NULL auto_increment,
  `administratorId` int(11) default NULL,
  `groupId` int(11) default NULL,
  PRIMARY KEY  (`NMID`),
  KEY `administratorId` (`administratorId`),
  KEY `groupId` (`groupId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Dumping data for table administrator_has_groups
#
INSERT INTO `administrator_has_groups` VALUES (85,98,3680);
INSERT INTO `administrator_has_groups` VALUES (86,98,114130);
INSERT INTO `administrator_has_groups` VALUES (87,98,114131);
INSERT INTO `administrator_has_groups` VALUES (88,98,3056);
INSERT INTO `administrator_has_groups` VALUES (89,98,3057);


#
# Table structure for table administrators
#

CREATE TABLE `administrators` (
  `administratorId` int(11) NOT NULL,
  `firstName` char(50) default NULL,
  `lastName` char(50) default NULL,
  `password` char(50) default NULL,
  `userName` char(50) default NULL,
  `email` char(50) default NULL,
  `address` char(50) default NULL,
  `city` char(50) default NULL,
  `countryId` int(11) default '0',
  `organisation` char(50) default NULL,
  `webSite` char(50) default NULL,
  `languageId` int(11) default '0',
  `privilegieId_FK` int(11) NOT NULL default '0',
  PRIMARY KEY  (`administratorId`),
  KEY `Ref_27` (`privilegieId_FK`),
  KEY `Ref_22` (`countryId`),
  KEY `Ref_23` (`languageId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Dumping data for table administrators
#
INSERT INTO `administrators` VALUES (98,'b','b','b','b','b','','',1,'','http://',2,1);


#
# Table structure for table assistant_has_groups
#

CREATE TABLE `assistant_has_groups` (
  `NMID` int(11) NOT NULL auto_increment,
  `assistantId` int(11) default NULL,
  `groupId` int(11) default NULL,
  PRIMARY KEY  (`NMID`),
  KEY `assistantId` (`assistantId`),
  KEY `groupId` (`groupId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Dumping data for table assistant_has_groups
#


#
# Table structure for table assistant_has_privilegies
#

CREATE TABLE `assistant_has_privilegies` (
  `NMID` int(11) NOT NULL auto_increment,
  `assistantId` int(11) default NULL,
  `privilegieId` int(11) default NULL,
  PRIMARY KEY  (`NMID`),
  KEY `assistantId` (`assistantId`),
  KEY `privilegieId` (`privilegieId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Dumping data for table assistant_has_privilegies
#


#
# Table structure for table assistantprivilegies
#

CREATE TABLE `assistantprivilegies` (
  `privilegieId` int(11) NOT NULL,
  `privilegieName` char(20) default NULL,
  PRIMARY KEY  (`privilegieId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Dumping data for table assistantprivilegies
#
INSERT INTO `assistantprivilegies` VALUES (1,'create new student');
INSERT INTO `assistantprivilegies` VALUES (2,'remove student');


#
# Table structure for table assistants
#

CREATE TABLE `assistants` (
  `assistentId` int(11) NOT NULL,
  `username` char(20) default NULL,
  `firstName` char(20) default NULL,
  `lastName` char(20) default NULL,
  `password` char(20) default NULL,
  `email` char(50) default NULL,
  `address` char(50) default NULL,
  `city` char(20) default NULL,
  `countryId` int(11) default NULL,
  `organisation` char(50) default NULL,
  `webSite` char(50) default NULL,
  `languageId` int(11) default NULL,
  `teacherId` int(11) default NULL,
  PRIMARY KEY  (`assistentId`),
  KEY `teacherId` (`teacherId`),
  KEY `languageId` (`languageId`),
  KEY `countryId` (`countryId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Dumping data for table assistants
#


#
# Table structure for table concept
#

CREATE TABLE `concept` (
  `conceptID` char(11) NOT NULL,
  `title` char(150) default NULL,
  `reference` char(11) default NULL,
  `courseID` char(11) default NULL,
  PRIMARY KEY  (`conceptID`),
  KEY `Ref_07` (`courseID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Dumping data for table concept
#
INSERT INTO `concept` VALUES ('c101','Abstract Factory','','DP001');
INSERT INTO `concept` VALUES ('c102','Builder','','DP001');
INSERT INTO `concept` VALUES ('c103','Factory Method','','DP001');
INSERT INTO `concept` VALUES ('c104','Prototype','','DP001');
INSERT INTO `concept` VALUES ('c105','Singleton','','DP001');
INSERT INTO `concept` VALUES ('c201','Adapter','','DP001');
INSERT INTO `concept` VALUES ('c202','Bridge','','DP001');
INSERT INTO `concept` VALUES ('c203','Composite','','DP001');
INSERT INTO `concept` VALUES ('c204','Decorator','','DP001');
INSERT INTO `concept` VALUES ('c205','Facade','','DP001');
INSERT INTO `concept` VALUES ('c206','Flyweight','','DP001');
INSERT INTO `concept` VALUES ('c207','Proxy','','DP001');
INSERT INTO `concept` VALUES ('c301','Chain of Responsibility','','DP001');
INSERT INTO `concept` VALUES ('c302','Command','','DP001');
INSERT INTO `concept` VALUES ('c303','Interpreter','','DP001');
INSERT INTO `concept` VALUES ('c304','Iterator','','DP001');
INSERT INTO `concept` VALUES ('c305','Mediator','','DP001');
INSERT INTO `concept` VALUES ('c306','Memento','','DP001');
INSERT INTO `concept` VALUES ('c307','Observer','','DP001');
INSERT INTO `concept` VALUES ('c308','State','','DP001');
INSERT INTO `concept` VALUES ('c309','Strategy','','DP001');
INSERT INTO `concept` VALUES ('c310','Template Method','','DP001');
INSERT INTO `concept` VALUES ('c311','Visitor','','DP001');


#
# Table structure for table conceptsincourseforstudent
#

CREATE TABLE `conceptsincourseforstudent` (
  `IDConceptInCourseForStudent` int(11) NOT NULL auto_increment,
  `IDStudentInCourse` int(11) NOT NULL default '0',
  `conceptID` char(11) NOT NULL default '0',
  `duration` int(11) default NULL,
  `feedbackMessage` char(100) default NULL,
  `started` char(50) default NULL,
  `finished` char(50) default NULL,
  `numberOfPasses` tinyint(4) default NULL,
  `degreeOfMastery` double(13,10) default NULL,
  `knowledgeLevel` double(13,10) default NULL,
  `experienceLevel` char(30) default NULL,
  `reasoningAbilityLevel` char(30) default NULL,
  `courseId` char(20) default NULL,
  PRIMARY KEY  (`IDConceptInCourseForStudent`),
  KEY `Ref_01` (`conceptID`),
  KEY `Ref_12` (`IDStudentInCourse`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Dumping data for table conceptsincourseforstudent
#
INSERT INTO `conceptsincourseforstudent` VALUES (35,23,'c101',31,NULL,'2006.05.27 AD at 06:53:07 CEST','2006.05.27 AD at 06:53:38 CEST',1,0.5198114769,0.7599057384,'el','ral','DP001');
INSERT INTO `conceptsincourseforstudent` VALUES (36,23,'c102',20,NULL,'2006.05.27 AD at 06:53:38 CEST','2006.05.27 AD at 06:53:58 CEST',1,3.75,1.7566038256,'el','ral','DP001');
INSERT INTO `conceptsincourseforstudent` VALUES (37,23,'c103',15,NULL,'2006.05.27 AD at 06:53:58 CEST','2006.05.27 AD at 06:54:13 CEST',1,3.75,2.2549528692,'el','ral','DP001');
INSERT INTO `conceptsincourseforstudent` VALUES (38,23,'c206',14,NULL,'2006.05.27 AD at 06:54:13 CEST','2006.05.27 AD at 06:54:27 CEST',1,0.5198114769,1.9079245907,'el','ral','DP001');
INSERT INTO `conceptsincourseforstudent` VALUES (39,23,'c302',12,NULL,'2006.05.27 AD at 06:54:27 CEST','2006.05.27 AD at 06:54:39 CEST',1,0.5198114769,1.6765724051,'el','ral','DP001');
INSERT INTO `conceptsincourseforstudent` VALUES (40,24,'c101',30,NULL,'2006.05.27 AD at 06:55:05 CEST','2006.05.27 AD at 06:55:35 CEST',1,0.5198114769,0.7599057384,'el','ral','DP001');
INSERT INTO `conceptsincourseforstudent` VALUES (41,24,'c102',26,NULL,'2006.05.27 AD at 06:55:36 CEST','2006.05.27 AD at 06:56:02 CEST',1,0.4904095168,0.6700736646,'el','ral','DP001');
INSERT INTO `conceptsincourseforstudent` VALUES (42,24,'c103',17,NULL,'2006.05.27 AD at 06:56:02 CEST','2006.05.27 AD at 06:56:19 CEST',1,3.2116352461,1.3054640599,'el','ral','DP001');
INSERT INTO `conceptsincourseforstudent` VALUES (43,24,'c105',11,NULL,'2006.05.27 AD at 06:56:19 CEST','2006.05.27 AD at 06:56:30 CEST',1,0.5198114769,1.1483335433,'el','ral','DP001');
INSERT INTO `conceptsincourseforstudent` VALUES (44,24,'c201',5,NULL,'2006.05.27 AD at 06:56:31 CEST','2006.05.27 AD at 06:56:36 CEST',1,4.4309331338,1.6954334751,'el','ral','DP001');
INSERT INTO `conceptsincourseforstudent` VALUES (45,25,'c101',35,NULL,'2006.05.27 AD at 06:56:51 CEST','2006.05.27 AD at 06:57:26 CEST',1,1.1445951109,1.0722975554,'el','ral','DP001');
INSERT INTO `conceptsincourseforstudent` VALUES (46,25,'c102',23,NULL,'2006.05.27 AD at 06:57:27 CEST','2006.05.27 AD at 06:57:50 CEST',1,1.7638419607,1.3028123572,'el','ral','DP001');
INSERT INTO `conceptsincourseforstudent` VALUES (47,25,'c103',18,NULL,'2006.05.27 AD at 06:57:50 CEST','2006.05.27 AD at 06:58:08 CEST',1,3.2116352461,1.7800180794,'el','ral','DP001');
INSERT INTO `conceptsincourseforstudent` VALUES (48,25,'c105',11,NULL,'2006.05.27 AD at 06:58:08 CEST','2006.05.27 AD at 06:58:19 CEST',1,0.5198114769,1.5279767589,'el','ral','DP001');
INSERT INTO `conceptsincourseforstudent` VALUES (49,25,'c201',6,NULL,'2006.05.27 AD at 06:58:19 CEST','2006.05.27 AD at 06:58:25 CEST',1,4.4309331338,2.0118028214,'el','ral','DP001');
INSERT INTO `conceptsincourseforstudent` VALUES (50,27,'c101',29,NULL,'2006.05.27 AD at 23:11:01 CEST','2006.05.27 AD at 23:11:30 CEST',1,0.5198114769,0.7599057384,'el','ral','DP001');
INSERT INTO `conceptsincourseforstudent` VALUES (51,27,'c102',25,NULL,'2006.05.27 AD at 23:11:30 CEST','2006.05.27 AD at 23:11:55 CEST',1,1.4123595255,0.9773903341,'el','ral','DP001');
INSERT INTO `conceptsincourseforstudent` VALUES (52,27,'c103',19,NULL,'2006.05.27 AD at 23:12:38 CEST','2006.05.27 AD at 23:12:57 CEST',2,4.2898175396,2.5860684219,'el','ral','DP001');
INSERT INTO `conceptsincourseforstudent` VALUES (53,27,'c105',7,NULL,'2006.05.27 AD at 23:12:25 CEST','2006.05.27 AD at 23:12:32 CEST',1,4.4309331338,2.2453185983,'el','ral','DP001');
INSERT INTO `conceptsincourseforstudent` VALUES (54,27,'c206',6,NULL,'2006.05.27 AD at 23:12:58 CEST','2006.05.27 AD at 23:13:04 CEST',1,4.4309331338,2.8496205236,'el','ral','DP001');
INSERT INTO `conceptsincourseforstudent` VALUES (55,27,'c302',5,NULL,'2006.05.27 AD at 23:13:05 CEST','2006.05.27 AD at 23:13:10 CEST',1,4.4309331338,3.0472845999,'el','ral','DP001');


#
# Table structure for table countries
#

CREATE TABLE `countries` (
  `countryId` int(11) NOT NULL,
  `countryName` char(50) default NULL,
  `countryShortcut` char(3) default NULL,
  PRIMARY KEY  (`countryId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Dumping data for table countries
#
INSERT INTO `countries` VALUES (1,'Serbia and Montenegro','ser');
INSERT INTO `countries` VALUES (2,'United Kingdom','UK');


#
# Table structure for table course
#

CREATE TABLE `course` (
  `courseID` char(11) NOT NULL default '0',
  `title` char(100) NOT NULL default '0',
  `reference` char(50) NOT NULL default '0',
  PRIMARY KEY  (`courseID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Dumping data for table course
#
INSERT INTO `course` VALUES ('DP001','Design Patterns Teaching Help System','001');


#
# Table structure for table course_has_studentsincourse
#

CREATE TABLE `course_has_studentsincourse` (
  `NMID` int(11) NOT NULL,
  `courseID_FK` char(11) NOT NULL,
  `IDStudentInCourse_FK` int(11) NOT NULL default '0',
  PRIMARY KEY  (`NMID`),
  KEY `Ref_15` (`courseID_FK`),
  KEY `Ref_16` (`IDStudentInCourse_FK`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Dumping data for table course_has_studentsincourse
#


#
# Table structure for table group_has_course
#

CREATE TABLE `group_has_course` (
  `NMID` int(11) NOT NULL auto_increment,
  `groupId` int(11) default NULL,
  `courseId` char(20) default NULL,
  PRIMARY KEY  (`NMID`),
  KEY `groupId` (`groupId`),
  KEY `courseId` (`courseId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Dumping data for table group_has_course
#
INSERT INTO `group_has_course` VALUES (47,3056,'DP001');
INSERT INTO `group_has_course` VALUES (48,3057,'DP001');


#
# Table structure for table groups
#

CREATE TABLE `groups` (
  `groupId` int(11) NOT NULL,
  `groupName` char(50) default NULL,
  `languageId` int(11) default NULL,
  `description` text,
  PRIMARY KEY  (`groupId`),
  KEY `languageId` (`languageId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Dumping data for table groups
#
INSERT INTO `groups` VALUES (3056,'a1',1,'');
INSERT INTO `groups` VALUES (3057,'a2',1,'');
INSERT INTO `groups` VALUES (3680,'ss',1,'');
INSERT INTO `groups` VALUES (114130,'ss2',1,'');
INSERT INTO `groups` VALUES (114131,'ss3',1,'');


#
# Table structure for table languages
#

CREATE TABLE `languages` (
  `languageId` int(11) NOT NULL,
  `languageName` char(50) default NULL,
  `languageShortcut` char(5) default NULL,
  PRIMARY KEY  (`languageId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Dumping data for table languages
#
INSERT INTO `languages` VALUES (1,'English','en');
INSERT INTO `languages` VALUES (2,'French','fr');
INSERT INTO `languages` VALUES (3,'German','ger');
INSERT INTO `languages` VALUES (4,'Serbian','ser');
INSERT INTO `languages` VALUES (5,'Russian','ru');
INSERT INTO `languages` VALUES (6,'Spanish','sp');


#
# Table structure for table performance
#

CREATE TABLE `performance` (
  `studentID` int(11) NOT NULL default '0',
  `initialSkillLevel` double(13,10) default NULL,
  `actualSkillLevel` double(13,10) default NULL,
  `learningStyle` text,
  `timeOfLastSession` text,
  `detailLevel` tinyint(4) default NULL,
  `experienceLevel` text,
  `reasoningAbility` text,
  `programmingLanguage` text,
  PRIMARY KEY  (`studentID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Dumping data for table performance
#
INSERT INTO `performance` VALUES (3056,1,2.2549528692,NULL,'2006.05.27 AD at 06:54:39 CEST',1,NULL,NULL,'Java');
INSERT INTO `performance` VALUES (3057,1,1,NULL,'2006.05.27 AD at 06:56:36 CEST',1,NULL,NULL,'Java');
INSERT INTO `performance` VALUES (3058,1,2.0118028214,NULL,'2006.05.27 AD at 06:58:25 CEST',1,NULL,NULL,'Java');
INSERT INTO `performance` VALUES (3059,1,1,NULL,NULL,1,NULL,NULL,'Java');
INSERT INTO `performance` VALUES (3552,1,2.2453185983,NULL,'2006.05.27 AD at 23:13:10 CEST',1,NULL,NULL,'Java');
INSERT INTO `performance` VALUES (3553,1,1,NULL,NULL,1,NULL,NULL,'Java');
INSERT INTO `performance` VALUES (3554,1,1,NULL,NULL,1,NULL,NULL,'Java');
INSERT INTO `performance` VALUES (3555,1,1,NULL,NULL,1,NULL,NULL,'Java');


#
# Table structure for table privilegies
#

CREATE TABLE `privilegies` (
  `privilegieId` int(11) NOT NULL,
  `privType` char(50) default NULL,
  PRIMARY KEY  (`privilegieId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Dumping data for table privilegies
#
INSERT INTO `privilegies` VALUES (1,'Full');
INSERT INTO `privilegies` VALUES (2,'Limited');
INSERT INTO `privilegies` VALUES (3,'Guest');


#
# Table structure for table question
#

CREATE TABLE `question` (
  `questionID` char(11) NOT NULL,
  `qGroup` tinyint(4) default NULL,
  `conceptID` char(11) default NULL,
  PRIMARY KEY  (`questionID`),
  KEY `Ref_02` (`conceptID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Dumping data for table question
#
INSERT INTO `question` VALUES ('q1011',1,'c101');
INSERT INTO `question` VALUES ('q10110',4,'c101');
INSERT INTO `question` VALUES ('q10111',1,'c101');
INSERT INTO `question` VALUES ('q101110',4,'c101');
INSERT INTO `question` VALUES ('q101111',4,'c101');
INSERT INTO `question` VALUES ('q101112',5,'c101');
INSERT INTO `question` VALUES ('q101113',5,'c101');
INSERT INTO `question` VALUES ('q10112',1,'c101');
INSERT INTO `question` VALUES ('q10113',1,'c101');
INSERT INTO `question` VALUES ('q10114',1,'c101');
INSERT INTO `question` VALUES ('q10115',1,'c101');
INSERT INTO `question` VALUES ('q10116',2,'c101');
INSERT INTO `question` VALUES ('q10117',2,'c101');
INSERT INTO `question` VALUES ('q10118',2,'c101');
INSERT INTO `question` VALUES ('q10119',3,'c101');
INSERT INTO `question` VALUES ('q1012',2,'c101');
INSERT INTO `question` VALUES ('q1013',3,'c101');
INSERT INTO `question` VALUES ('q1014',5,'c101');
INSERT INTO `question` VALUES ('q1015',4,'c101');
INSERT INTO `question` VALUES ('q1016',1,'c101');
INSERT INTO `question` VALUES ('q1017',5,'c101');
INSERT INTO `question` VALUES ('q1018',3,'c101');
INSERT INTO `question` VALUES ('q1019',2,'c101');
INSERT INTO `question` VALUES ('q1021',1,'c102');
INSERT INTO `question` VALUES ('q10210',5,'c102');
INSERT INTO `question` VALUES ('q10211',5,'c102');
INSERT INTO `question` VALUES ('q10212',1,'c102');
INSERT INTO `question` VALUES ('q10213',1,'c102');
INSERT INTO `question` VALUES ('q10214',1,'c102');
INSERT INTO `question` VALUES ('q10215',1,'c102');
INSERT INTO `question` VALUES ('q10216',2,'c102');
INSERT INTO `question` VALUES ('q10217',2,'c102');
INSERT INTO `question` VALUES ('q10218',2,'c102');
INSERT INTO `question` VALUES ('q10219',3,'c102');
INSERT INTO `question` VALUES ('q1022',1,'c102');
INSERT INTO `question` VALUES ('q10220',3,'c102');
INSERT INTO `question` VALUES ('q10221',3,'c102');
INSERT INTO `question` VALUES ('q10222',4,'c102');
INSERT INTO `question` VALUES ('q10223',4,'c102');
INSERT INTO `question` VALUES ('q10224',5,'c102');
INSERT INTO `question` VALUES ('q10225',5,'c102');
INSERT INTO `question` VALUES ('q1023',2,'c102');
INSERT INTO `question` VALUES ('q1024',3,'c102');
INSERT INTO `question` VALUES ('q1025',4,'c102');
INSERT INTO `question` VALUES ('q1026',1,'c102');
INSERT INTO `question` VALUES ('q1027',2,'c102');
INSERT INTO `question` VALUES ('q1028',3,'c102');
INSERT INTO `question` VALUES ('q1029',4,'c102');
INSERT INTO `question` VALUES ('q1031',1,'c103');
INSERT INTO `question` VALUES ('q10310',2,'c103');
INSERT INTO `question` VALUES ('q10311',2,'c103');
INSERT INTO `question` VALUES ('q10312',3,'c103');
INSERT INTO `question` VALUES ('q10313',3,'c103');
INSERT INTO `question` VALUES ('q10314',3,'c103');
INSERT INTO `question` VALUES ('q10315',4,'c103');
INSERT INTO `question` VALUES ('q10316',4,'c103');
INSERT INTO `question` VALUES ('q10317',4,'c103');
INSERT INTO `question` VALUES ('q10318',5,'c103');
INSERT INTO `question` VALUES ('q10319',5,'c103');
INSERT INTO `question` VALUES ('q1032',1,'c103');
INSERT INTO `question` VALUES ('q1033',1,'c103');
INSERT INTO `question` VALUES ('q1034',1,'c103');
INSERT INTO `question` VALUES ('q1035',1,'c103');
INSERT INTO `question` VALUES ('q1036',1,'c103');
INSERT INTO `question` VALUES ('q1037',2,'c103');
INSERT INTO `question` VALUES ('q1038',2,'c103');
INSERT INTO `question` VALUES ('q1039',2,'c103');
INSERT INTO `question` VALUES ('q1041',1,'c104');
INSERT INTO `question` VALUES ('q1042',1,'c104');
INSERT INTO `question` VALUES ('q1043',1,'c104');
INSERT INTO `question` VALUES ('q1044',1,'c104');
INSERT INTO `question` VALUES ('q1045',1,'c104');
INSERT INTO `question` VALUES ('q1046',1,'c104');
INSERT INTO `question` VALUES ('q1051',1,'c105');
INSERT INTO `question` VALUES ('q1052',1,'c105');
INSERT INTO `question` VALUES ('q1053',1,'c105');
INSERT INTO `question` VALUES ('q1054',1,'c105');
INSERT INTO `question` VALUES ('q1055',1,'c105');
INSERT INTO `question` VALUES ('q1056',1,'c105');
INSERT INTO `question` VALUES ('q2011',1,'c201');
INSERT INTO `question` VALUES ('q2012',1,'c201');
INSERT INTO `question` VALUES ('q2013',1,'c201');
INSERT INTO `question` VALUES ('q2014',1,'c201');
INSERT INTO `question` VALUES ('q2015',1,'c201');
INSERT INTO `question` VALUES ('q2016',1,'c201');
INSERT INTO `question` VALUES ('q2021',1,'c202');
INSERT INTO `question` VALUES ('q2022',1,'c202');
INSERT INTO `question` VALUES ('q2023',1,'c202');
INSERT INTO `question` VALUES ('q2024',1,'c202');
INSERT INTO `question` VALUES ('q2025',1,'c202');
INSERT INTO `question` VALUES ('q2026',1,'c202');
INSERT INTO `question` VALUES ('q2031',1,'c203');
INSERT INTO `question` VALUES ('q2032',1,'c203');
INSERT INTO `question` VALUES ('q2033',1,'c203');
INSERT INTO `question` VALUES ('q2034',1,'c203');
INSERT INTO `question` VALUES ('q2035',1,'c203');
INSERT INTO `question` VALUES ('q2036',1,'c203');
INSERT INTO `question` VALUES ('q2041',1,'c204');
INSERT INTO `question` VALUES ('q2042',1,'c204');
INSERT INTO `question` VALUES ('q2043',1,'c204');
INSERT INTO `question` VALUES ('q2044',1,'c204');
INSERT INTO `question` VALUES ('q2045',1,'c204');
INSERT INTO `question` VALUES ('q2046',1,'c204');
INSERT INTO `question` VALUES ('q2051',1,'c205');
INSERT INTO `question` VALUES ('q2052',1,'c205');
INSERT INTO `question` VALUES ('q2053',1,'c205');
INSERT INTO `question` VALUES ('q2054',1,'c205');
INSERT INTO `question` VALUES ('q2055',1,'c205');
INSERT INTO `question` VALUES ('q2056',1,'c205');
INSERT INTO `question` VALUES ('q2061',1,'c206');
INSERT INTO `question` VALUES ('q2062',1,'c206');
INSERT INTO `question` VALUES ('q2063',1,'c206');
INSERT INTO `question` VALUES ('q2064',1,'c206');
INSERT INTO `question` VALUES ('q2065',1,'c206');
INSERT INTO `question` VALUES ('q2066',1,'c206');
INSERT INTO `question` VALUES ('q2071',1,'c207');
INSERT INTO `question` VALUES ('q2072',1,'c207');
INSERT INTO `question` VALUES ('q2073',1,'c207');
INSERT INTO `question` VALUES ('q2074',1,'c207');
INSERT INTO `question` VALUES ('q2075',1,'c207');
INSERT INTO `question` VALUES ('q2076',1,'c207');
INSERT INTO `question` VALUES ('q3011',1,'c301');
INSERT INTO `question` VALUES ('q3012',1,'c301');
INSERT INTO `question` VALUES ('q3013',1,'c301');
INSERT INTO `question` VALUES ('q3014',1,'c301');
INSERT INTO `question` VALUES ('q3015',1,'c301');
INSERT INTO `question` VALUES ('q3016',1,'c301');
INSERT INTO `question` VALUES ('q3021',1,'c302');
INSERT INTO `question` VALUES ('q3022',1,'c302');
INSERT INTO `question` VALUES ('q3023',1,'c302');
INSERT INTO `question` VALUES ('q3024',1,'c302');
INSERT INTO `question` VALUES ('q3025',1,'c302');
INSERT INTO `question` VALUES ('q3026',1,'c302');
INSERT INTO `question` VALUES ('q3031',1,'c303');
INSERT INTO `question` VALUES ('q3032',1,'c303');
INSERT INTO `question` VALUES ('q3033',1,'c303');
INSERT INTO `question` VALUES ('q3034',1,'c303');
INSERT INTO `question` VALUES ('q3035',1,'c303');
INSERT INTO `question` VALUES ('q3036',1,'c303');
INSERT INTO `question` VALUES ('q3041',1,'c304');
INSERT INTO `question` VALUES ('q3042',1,'c304');
INSERT INTO `question` VALUES ('q3043',1,'c304');
INSERT INTO `question` VALUES ('q3044',1,'c304');
INSERT INTO `question` VALUES ('q3045',1,'c304');
INSERT INTO `question` VALUES ('q3046',1,'c304');
INSERT INTO `question` VALUES ('q3051',1,'c305');
INSERT INTO `question` VALUES ('q3052',1,'c305');
INSERT INTO `question` VALUES ('q3053',1,'c305');
INSERT INTO `question` VALUES ('q3054',1,'c305');
INSERT INTO `question` VALUES ('q3055',1,'c305');
INSERT INTO `question` VALUES ('q3056',1,'c305');
INSERT INTO `question` VALUES ('q3061',1,'c306');
INSERT INTO `question` VALUES ('q3062',1,'c306');
INSERT INTO `question` VALUES ('q3063',1,'c306');
INSERT INTO `question` VALUES ('q3064',1,'c306');
INSERT INTO `question` VALUES ('q3065',1,'c306');
INSERT INTO `question` VALUES ('q3066',1,'c306');
INSERT INTO `question` VALUES ('q3071',1,'c307');
INSERT INTO `question` VALUES ('q3072',1,'c307');
INSERT INTO `question` VALUES ('q3073',1,'c307');
INSERT INTO `question` VALUES ('q3074',1,'c307');
INSERT INTO `question` VALUES ('q3075',1,'c307');
INSERT INTO `question` VALUES ('q3076',1,'c307');
INSERT INTO `question` VALUES ('q3081',1,'c308');
INSERT INTO `question` VALUES ('q3082',1,'c308');
INSERT INTO `question` VALUES ('q3083',1,'c308');
INSERT INTO `question` VALUES ('q3084',1,'c308');
INSERT INTO `question` VALUES ('q3085',1,'c308');
INSERT INTO `question` VALUES ('q3086',1,'c308');
INSERT INTO `question` VALUES ('q3091',1,'c309');
INSERT INTO `question` VALUES ('q3092',1,'c309');
INSERT INTO `question` VALUES ('q3093',1,'c309');
INSERT INTO `question` VALUES ('q3094',1,'c309');
INSERT INTO `question` VALUES ('q3095',1,'c309');
INSERT INTO `question` VALUES ('q3096',1,'c309');
INSERT INTO `question` VALUES ('q3101',1,'c310');
INSERT INTO `question` VALUES ('q3102',1,'c310');
INSERT INTO `question` VALUES ('q3103',1,'c310');
INSERT INTO `question` VALUES ('q3104',1,'c310');
INSERT INTO `question` VALUES ('q3105',1,'c310');
INSERT INTO `question` VALUES ('q3106',1,'c310');
INSERT INTO `question` VALUES ('q3111',1,'c311');
INSERT INTO `question` VALUES ('q3112',1,'c311');
INSERT INTO `question` VALUES ('q3113',1,'c311');
INSERT INTO `question` VALUES ('q3114',1,'c311');
INSERT INTO `question` VALUES ('q3115',1,'c311');
INSERT INTO `question` VALUES ('q3116',1,'c311');


#
# Table structure for table questionintestforstudent
#

CREATE TABLE `questionintestforstudent` (
  `IDQuestionInTestForStudent` int(11) NOT NULL auto_increment,
  `IDTestInConceptForStudent` int(11) default '0',
  `questionID` char(11) default NULL,
  `truth` char(11) default NULL,
  PRIMARY KEY  (`IDQuestionInTestForStudent`),
  KEY `Ref_11` (`questionID`),
  KEY `Ref_13` (`IDTestInConceptForStudent`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Dumping data for table questionintestforstudent
#
INSERT INTO `questionintestforstudent` VALUES (236,50,'q1011','0');
INSERT INTO `questionintestforstudent` VALUES (237,50,'q1012','1');
INSERT INTO `questionintestforstudent` VALUES (238,50,'q1013','0');
INSERT INTO `questionintestforstudent` VALUES (239,50,'q1015','0');
INSERT INTO `questionintestforstudent` VALUES (240,50,'q1014','0');
INSERT INTO `questionintestforstudent` VALUES (241,51,'q1016','0');
INSERT INTO `questionintestforstudent` VALUES (242,51,'q1018','0');
INSERT INTO `questionintestforstudent` VALUES (243,51,'q10110','1');
INSERT INTO `questionintestforstudent` VALUES (244,51,'q1017','0');
INSERT INTO `questionintestforstudent` VALUES (245,52,'q1021','1');
INSERT INTO `questionintestforstudent` VALUES (246,52,'q1023','1');
INSERT INTO `questionintestforstudent` VALUES (247,52,'q1024','0');
INSERT INTO `questionintestforstudent` VALUES (248,52,'q1025','1');
INSERT INTO `questionintestforstudent` VALUES (249,52,'q10210','1');
INSERT INTO `questionintestforstudent` VALUES (250,53,'q1031','0');
INSERT INTO `questionintestforstudent` VALUES (251,53,'q1037','1');
INSERT INTO `questionintestforstudent` VALUES (252,53,'q10312','1');
INSERT INTO `questionintestforstudent` VALUES (253,53,'q10315','1');
INSERT INTO `questionintestforstudent` VALUES (254,53,'q10318','1');
INSERT INTO `questionintestforstudent` VALUES (255,54,'q2061','0');
INSERT INTO `questionintestforstudent` VALUES (256,55,'q2061','0');
INSERT INTO `questionintestforstudent` VALUES (257,56,'q3021','0');
INSERT INTO `questionintestforstudent` VALUES (258,57,'q3021','0');
INSERT INTO `questionintestforstudent` VALUES (259,58,'q1011','0');
INSERT INTO `questionintestforstudent` VALUES (260,58,'q1012','1');
INSERT INTO `questionintestforstudent` VALUES (261,58,'q1013','0');
INSERT INTO `questionintestforstudent` VALUES (262,58,'q1015','0');
INSERT INTO `questionintestforstudent` VALUES (263,58,'q1014','0');
INSERT INTO `questionintestforstudent` VALUES (264,59,'q1016','0');
INSERT INTO `questionintestforstudent` VALUES (265,59,'q1018','0');
INSERT INTO `questionintestforstudent` VALUES (266,59,'q10110','1');
INSERT INTO `questionintestforstudent` VALUES (267,59,'q1017','0');
INSERT INTO `questionintestforstudent` VALUES (268,60,'q1021','1');
INSERT INTO `questionintestforstudent` VALUES (269,60,'q1023','0');
INSERT INTO `questionintestforstudent` VALUES (270,60,'q1024','1');
INSERT INTO `questionintestforstudent` VALUES (271,60,'q1025','0');
INSERT INTO `questionintestforstudent` VALUES (272,60,'q10210','0');
INSERT INTO `questionintestforstudent` VALUES (273,61,'q1027','0');
INSERT INTO `questionintestforstudent` VALUES (274,61,'q1029','1');
INSERT INTO `questionintestforstudent` VALUES (275,61,'q10211','0');
INSERT INTO `questionintestforstudent` VALUES (276,62,'q1031','0');
INSERT INTO `questionintestforstudent` VALUES (277,62,'q1037','1');
INSERT INTO `questionintestforstudent` VALUES (278,62,'q10312','1');
INSERT INTO `questionintestforstudent` VALUES (279,62,'q10315','1');
INSERT INTO `questionintestforstudent` VALUES (280,62,'q10318','1');
INSERT INTO `questionintestforstudent` VALUES (281,63,'q1032','0');
INSERT INTO `questionintestforstudent` VALUES (282,64,'q1051','0');
INSERT INTO `questionintestforstudent` VALUES (283,65,'q1051','0');
INSERT INTO `questionintestforstudent` VALUES (284,66,'q2011','1');
INSERT INTO `questionintestforstudent` VALUES (285,67,'q1011','0');
INSERT INTO `questionintestforstudent` VALUES (286,67,'q1012','0');
INSERT INTO `questionintestforstudent` VALUES (287,67,'q1013','0');
INSERT INTO `questionintestforstudent` VALUES (288,67,'q1015','0');
INSERT INTO `questionintestforstudent` VALUES (289,67,'q1014','0');
INSERT INTO `questionintestforstudent` VALUES (290,68,'q1016','1');
INSERT INTO `questionintestforstudent` VALUES (291,68,'q1019','1');
INSERT INTO `questionintestforstudent` VALUES (292,68,'q1018','0');
INSERT INTO `questionintestforstudent` VALUES (293,68,'q10110','1');
INSERT INTO `questionintestforstudent` VALUES (294,68,'q1017','0');
INSERT INTO `questionintestforstudent` VALUES (295,69,'q1021','1');
INSERT INTO `questionintestforstudent` VALUES (296,69,'q1023','0');
INSERT INTO `questionintestforstudent` VALUES (297,69,'q1024','1');
INSERT INTO `questionintestforstudent` VALUES (298,69,'q1025','0');
INSERT INTO `questionintestforstudent` VALUES (299,69,'q10210','1');
INSERT INTO `questionintestforstudent` VALUES (300,70,'q1027','1');
INSERT INTO `questionintestforstudent` VALUES (301,70,'q1029','0');
INSERT INTO `questionintestforstudent` VALUES (302,71,'q1031','0');
INSERT INTO `questionintestforstudent` VALUES (303,71,'q1037','1');
INSERT INTO `questionintestforstudent` VALUES (304,71,'q10312','1');
INSERT INTO `questionintestforstudent` VALUES (305,71,'q10315','1');
INSERT INTO `questionintestforstudent` VALUES (306,71,'q10318','1');
INSERT INTO `questionintestforstudent` VALUES (307,72,'q1032','0');
INSERT INTO `questionintestforstudent` VALUES (308,73,'q1051','0');
INSERT INTO `questionintestforstudent` VALUES (309,74,'q1051','0');
INSERT INTO `questionintestforstudent` VALUES (310,75,'q2011','1');
INSERT INTO `questionintestforstudent` VALUES (311,76,'q1011','0');
INSERT INTO `questionintestforstudent` VALUES (312,76,'q1012','1');
INSERT INTO `questionintestforstudent` VALUES (313,76,'q1013','0');
INSERT INTO `questionintestforstudent` VALUES (314,76,'q1015','1');
INSERT INTO `questionintestforstudent` VALUES (315,76,'q1014','0');
INSERT INTO `questionintestforstudent` VALUES (316,77,'q1016','1');
INSERT INTO `questionintestforstudent` VALUES (317,77,'q1018','0');
INSERT INTO `questionintestforstudent` VALUES (318,77,'q1017','0');
INSERT INTO `questionintestforstudent` VALUES (319,78,'q1021','1');
INSERT INTO `questionintestforstudent` VALUES (320,78,'q1023','0');
INSERT INTO `questionintestforstudent` VALUES (321,78,'q1024','1');
INSERT INTO `questionintestforstudent` VALUES (322,78,'q1025','0');
INSERT INTO `questionintestforstudent` VALUES (323,78,'q10210','1');
INSERT INTO `questionintestforstudent` VALUES (324,79,'q1027','0');
INSERT INTO `questionintestforstudent` VALUES (325,79,'q1029','0');
INSERT INTO `questionintestforstudent` VALUES (326,80,'q1031','0');
INSERT INTO `questionintestforstudent` VALUES (327,80,'q1037','1');
INSERT INTO `questionintestforstudent` VALUES (328,80,'q10312','1');
INSERT INTO `questionintestforstudent` VALUES (329,80,'q10315','1');
INSERT INTO `questionintestforstudent` VALUES (330,80,'q10318','1');
INSERT INTO `questionintestforstudent` VALUES (331,81,'q1032','1');
INSERT INTO `questionintestforstudent` VALUES (332,82,'q1051','1');
INSERT INTO `questionintestforstudent` VALUES (333,80,'q1031','0');
INSERT INTO `questionintestforstudent` VALUES (334,80,'q1037','1');
INSERT INTO `questionintestforstudent` VALUES (335,80,'q10312','1');
INSERT INTO `questionintestforstudent` VALUES (336,80,'q10315','1');
INSERT INTO `questionintestforstudent` VALUES (337,80,'q10318','1');
INSERT INTO `questionintestforstudent` VALUES (338,81,'q1032','1');
INSERT INTO `questionintestforstudent` VALUES (339,83,'q1033','1');
INSERT INTO `questionintestforstudent` VALUES (340,83,'q1038','1');
INSERT INTO `questionintestforstudent` VALUES (341,83,'q10313','1');
INSERT INTO `questionintestforstudent` VALUES (342,83,'q10316','1');
INSERT INTO `questionintestforstudent` VALUES (343,83,'q10319','1');
INSERT INTO `questionintestforstudent` VALUES (344,84,'q2061','1');
INSERT INTO `questionintestforstudent` VALUES (345,85,'q3021','1');


#
# Table structure for table students
#

CREATE TABLE `students` (
  `studentID` int(11) NOT NULL default '0',
  `userName` char(20) NOT NULL,
  `firstName` char(20) NOT NULL,
  `lastName` char(20) NOT NULL,
  `password` char(20) NOT NULL,
  `email` char(50) default NULL,
  `address` char(70) default NULL,
  `city` char(50) default NULL,
  `countryId` int(11) default '0',
  `organization` char(70) default NULL,
  `webSite` char(70) default NULL,
  `languageId` int(11) default NULL,
  `groupId` int(11) default NULL,
  PRIMARY KEY  (`studentID`),
  KEY `Ref_17` (`groupId`),
  KEY `Ref_23` (`countryId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Dumping data for table students
#
INSERT INTO `students` VALUES (3056,'a1','a1','a1','a1','a1','','',1,'','http://',1,3056);
INSERT INTO `students` VALUES (3057,'a2','a2','a2','a2','a2','','',1,'','http://',1,3056);
INSERT INTO `students` VALUES (3058,'a3','a3','a3','a3','a3','','',1,'','http://',1,3056);
INSERT INTO `students` VALUES (3059,'a4','a4','a4','a4','a4','','',1,'','http://',1,3056);
INSERT INTO `students` VALUES (3552,'q1','q1','q1','q1','q1','','',1,'','http://',1,3057);
INSERT INTO `students` VALUES (3553,'q2','q2','q2','q2','q2','','',1,'','http://',1,3057);
INSERT INTO `students` VALUES (3554,'q3','q3','q3','q3','q3','','',1,'','http://',1,3057);
INSERT INTO `students` VALUES (3555,'q4','q4','q4','q4','q4','','',1,'','http://',1,3057);
INSERT INTO `students` VALUES (3614,'s1','s1','s1','s1','s1','','',1,'','http://',1,3680);
INSERT INTO `students` VALUES (112084,'s12','s12','s12','s12','s12','','',1,'','http://',1,3680);
INSERT INTO `students` VALUES (112085,'s13','s13','s13','s13','s13','','',1,'','http://',1,3680);
INSERT INTO `students` VALUES (112086,'s14','s14','s14','s14','s14','','',1,'','http://',1,3680);
INSERT INTO `students` VALUES (112114,'s21','s21','s21','s21','s21','','',1,'','http://',1,114130);
INSERT INTO `students` VALUES (112115,'s22','s22','s22','s22','s22','','',1,'','http://',1,114130);
INSERT INTO `students` VALUES (112116,'s23','s23','s23','s23','s23','','',1,'','http://',1,114130);


#
# Table structure for table studentsincourse
#

CREATE TABLE `studentsincourse` (
  `IDStudentInCourse` int(11) NOT NULL auto_increment,
  `studentID` int(11) NOT NULL default '0',
  `started` char(50) default NULL,
  `finished` char(50) default NULL,
  `numberOfPasses` tinyint(4) default NULL,
  `groupId` int(11) default NULL,
  PRIMARY KEY  (`IDStudentInCourse`),
  KEY `Ref_10` (`studentID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Dumping data for table studentsincourse
#
INSERT INTO `studentsincourse` VALUES (23,3056,'2006.05.27 AD at 06:50:44 CEST','2006.05.27 AD at 06:50:44 CEST',1,3056);
INSERT INTO `studentsincourse` VALUES (24,3057,'2006.05.27 AD at 06:50:57 CEST','2006.05.27 AD at 06:50:57 CEST',1,3056);
INSERT INTO `studentsincourse` VALUES (25,3058,'2006.05.27 AD at 06:51:10 CEST','2006.05.27 AD at 06:51:10 CEST',1,3056);
INSERT INTO `studentsincourse` VALUES (26,3059,'2006.05.27 AD at 06:51:23 CEST','2006.05.27 AD at 06:51:23 CEST',1,3056);
INSERT INTO `studentsincourse` VALUES (27,3552,'2006.05.27 AD at 06:51:37 CEST','2006.05.27 AD at 06:51:37 CEST',1,3057);
INSERT INTO `studentsincourse` VALUES (28,3553,'2006.05.27 AD at 06:51:49 CEST','2006.05.27 AD at 06:51:49 CEST',1,3057);
INSERT INTO `studentsincourse` VALUES (29,3554,'2006.05.27 AD at 06:52:23 CEST','2006.05.27 AD at 06:52:23 CEST',1,3057);
INSERT INTO `studentsincourse` VALUES (30,3555,'2006.05.27 AD at 06:52:39 CEST','2006.05.27 AD at 06:52:39 CEST',1,3057);


#
# Table structure for table teacher_has_course
#

CREATE TABLE `teacher_has_course` (
  `NMID` int(11) NOT NULL auto_increment,
  `teacherId` int(11) default NULL,
  `courseId` char(11) default NULL,
  PRIMARY KEY  (`NMID`),
  KEY `teacherId` (`teacherId`),
  KEY `courseId` (`courseId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Dumping data for table teacher_has_course
#
INSERT INTO `teacher_has_course` VALUES (3,97,'DP001');


#
# Table structure for table teacher_has_groups
#

CREATE TABLE `teacher_has_groups` (
  `NMID` int(11) NOT NULL auto_increment,
  `teacherId` int(11) default NULL,
  `groupId` int(11) default NULL,
  PRIMARY KEY  (`NMID`),
  KEY `teacherId` (`teacherId`),
  KEY `groupId` (`groupId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Dumping data for table teacher_has_groups
#
INSERT INTO `teacher_has_groups` VALUES (67,97,3056);
INSERT INTO `teacher_has_groups` VALUES (68,97,3057);


#
# Table structure for table teacher_has_privilegies
#

CREATE TABLE `teacher_has_privilegies` (
  `NMID` int(11) NOT NULL auto_increment,
  `teacherId_FK` int(11) NOT NULL default '0',
  `privilegieId_FK` int(11) NOT NULL default '0',
  PRIMARY KEY  (`NMID`),
  KEY `Ref_24` (`teacherId_FK`),
  KEY `Ref_25` (`privilegieId_FK`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Dumping data for table teacher_has_privilegies
#
INSERT INTO `teacher_has_privilegies` VALUES (156,97,1);
INSERT INTO `teacher_has_privilegies` VALUES (157,97,2);
INSERT INTO `teacher_has_privilegies` VALUES (158,97,3);
INSERT INTO `teacher_has_privilegies` VALUES (159,97,4);


#
# Table structure for table teacherprivilegies
#

CREATE TABLE `teacherprivilegies` (
  `privilegieId` int(11) NOT NULL,
  `privilegieName` char(50) default NULL,
  PRIMARY KEY  (`privilegieId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Dumping data for table teacherprivilegies
#
INSERT INTO `teacherprivilegies` VALUES (1,'create new teacher');
INSERT INTO `teacherprivilegies` VALUES (2,'create new group');
INSERT INTO `teacherprivilegies` VALUES (3,'create new student');
INSERT INTO `teacherprivilegies` VALUES (4,'create new assistant');


#
# Table structure for table teachers
#

CREATE TABLE `teachers` (
  `teacherId` int(11) NOT NULL,
  `username` char(20) default NULL,
  `firstName` char(20) default NULL,
  `lastName` char(20) default NULL,
  `password` char(20) default NULL,
  `email` char(50) default NULL,
  `address` char(50) default NULL,
  `city` char(50) default NULL,
  `countryId` int(11) default NULL,
  `organisation` char(50) default NULL,
  `webSite` char(50) default NULL,
  `languageId` int(11) default NULL,
  `administratorId` int(11) default '0',
  PRIMARY KEY  (`teacherId`),
  KEY `Ref_22` (`administratorId`),
  KEY `countryId` (`countryId`),
  KEY `languageId` (`languageId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Dumping data for table teachers
#
INSERT INTO `teachers` VALUES (97,'a','a','a','a','a','','',1,'','http://',1,98);


#
# Table structure for table test
#

CREATE TABLE `test` (
  `testID` int(11) NOT NULL,
  `title` char(11) default NULL,
  `reference` char(11) default NULL,
  `conceptID` char(11) default NULL,
  PRIMARY KEY  (`testID`),
  KEY `Ref_03` (`conceptID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Dumping data for table test
#


#
# Table structure for table testinconceptforstudent
#

CREATE TABLE `testinconceptforstudent` (
  `IDTestInConceptForStudent` int(11) NOT NULL auto_increment,
  `IDConceptInCourseForStudent` int(11) NOT NULL default '0',
  `testID` char(11) NOT NULL,
  `started` char(50) default NULL,
  `finished` char(50) default NULL,
  `numberOfPasses` tinyint(4) default NULL,
  `degreeOfMastery` double(13,10) default NULL,
  `knowledgeLevel` double(13,10) default NULL,
  `duration` int(11) default NULL,
  `testDifficultyFactor` double(13,10) default NULL,
  `success` double(13,10) default NULL,
  `testPointsNumber` double(13,10) default NULL,
  PRIMARY KEY  (`IDTestInConceptForStudent`),
  KEY `Ref_05` (`IDConceptInCourseForStudent`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Dumping data for table testinconceptforstudent
#
INSERT INTO `testinconceptforstudent` VALUES (50,35,'1','2006.05.27 AD at 06:53:16 CEST','2006.05.27 AD at 06:53:23 CEST',1,0.5198114769,1,7,20,20,4);
INSERT INTO `testinconceptforstudent` VALUES (51,35,'2','2006.05.27 AD at 06:53:29 CEST','2006.05.27 AD at 06:53:35 CEST',1,0.5198114769,1,6,20,25,5);
INSERT INTO `testinconceptforstudent` VALUES (52,36,'1','2006.05.27 AD at 06:53:48 CEST','2006.05.27 AD at 06:53:55 CEST',1,3.75,1,7,20,80,16);
INSERT INTO `testinconceptforstudent` VALUES (53,37,'1','2006.05.27 AD at 06:54:03 CEST','2006.05.27 AD at 06:54:10 CEST',1,3.75,1,7,32,87.5,28);
INSERT INTO `testinconceptforstudent` VALUES (54,38,'1','2006.05.27 AD at 06:54:14 CEST','2006.05.27 AD at 06:54:17 CEST',1,0.5198114769,2.2549528692,3,20,0,0);
INSERT INTO `testinconceptforstudent` VALUES (55,38,'2','2006.05.27 AD at 06:54:22 CEST','2006.05.27 AD at 06:54:24 CEST',1,0.5198114769,2.2549528692,2,20,0,0);
INSERT INTO `testinconceptforstudent` VALUES (56,39,'1','2006.05.27 AD at 06:54:30 CEST','2006.05.27 AD at 06:54:32 CEST',1,0.5198114769,2.2549528692,2,20,0,0);
INSERT INTO `testinconceptforstudent` VALUES (57,39,'2','2006.05.27 AD at 06:54:35 CEST','2006.05.27 AD at 06:54:37 CEST',1,0.5198114769,2.2549528692,2,20,0,0);
INSERT INTO `testinconceptforstudent` VALUES (58,40,'1','2006.05.27 AD at 06:55:14 CEST','2006.05.27 AD at 06:55:21 CEST',1,0.5198114769,1,7,20,20,4);
INSERT INTO `testinconceptforstudent` VALUES (59,40,'2','2006.05.27 AD at 06:55:28 CEST','2006.05.27 AD at 06:55:34 CEST',1,0.5198114769,1,6,20,25,5);
INSERT INTO `testinconceptforstudent` VALUES (60,41,'1','2006.05.27 AD at 06:55:43 CEST','2006.05.27 AD at 06:55:50 CEST',1,0.5198114769,1,7,20,40,8);
INSERT INTO `testinconceptforstudent` VALUES (61,41,'2','2006.05.27 AD at 06:55:56 CEST','2006.05.27 AD at 06:56:00 CEST',1,0.44140625,1,4,26.6666666667,25,6.6666666667);
INSERT INTO `testinconceptforstudent` VALUES (62,42,'1','2006.05.27 AD at 06:56:06 CEST','2006.05.27 AD at 06:56:13 CEST',1,3.75,1,7,32,87.5,28);
INSERT INTO `testinconceptforstudent` VALUES (63,42,'2','2006.05.27 AD at 06:56:15 CEST','2006.05.27 AD at 06:56:18 CEST',1,0.5198114769,1,3,20,0,0);
INSERT INTO `testinconceptforstudent` VALUES (64,43,'1','2006.05.27 AD at 06:56:21 CEST','2006.05.27 AD at 06:56:24 CEST',1,0.5198114769,1,3,20,0,0);
INSERT INTO `testinconceptforstudent` VALUES (65,43,'2','2006.05.27 AD at 06:56:26 CEST','2006.05.27 AD at 06:56:29 CEST',1,0.5198114769,1,3,20,0,0);
INSERT INTO `testinconceptforstudent` VALUES (66,44,'1','2006.05.27 AD at 06:56:32 CEST','2006.05.27 AD at 06:56:34 CEST',1,4.4309331338,1,2,20,100,20);
INSERT INTO `testinconceptforstudent` VALUES (67,45,'1','2006.05.27 AD at 06:57:02 CEST','2006.05.27 AD at 06:57:09 CEST',1,0.5198114769,1,7,20,0,0);
INSERT INTO `testinconceptforstudent` VALUES (68,45,'2','2006.05.27 AD at 06:57:18 CEST','2006.05.27 AD at 06:57:25 CEST',1,1.7693787449,1,7,20,60,12);
INSERT INTO `testinconceptforstudent` VALUES (69,46,'1','2006.05.27 AD at 06:57:34 CEST','2006.05.27 AD at 06:57:41 CEST',1,1.7693787449,1,7,20,60,12);
INSERT INTO `testinconceptforstudent` VALUES (70,46,'2','2006.05.27 AD at 06:57:45 CEST','2006.05.27 AD at 06:57:48 CEST',1,1.75,1,3,20,50,10);
INSERT INTO `testinconceptforstudent` VALUES (71,47,'1','2006.05.27 AD at 06:57:54 CEST','2006.05.27 AD at 06:58:02 CEST',1,3.75,1,8,32,87.5,28);
INSERT INTO `testinconceptforstudent` VALUES (72,47,'2','2006.05.27 AD at 06:58:04 CEST','2006.05.27 AD at 06:58:07 CEST',1,0.5198114769,1,3,20,0,0);
INSERT INTO `testinconceptforstudent` VALUES (73,48,'1','2006.05.27 AD at 06:58:09 CEST','2006.05.27 AD at 06:58:12 CEST',1,0.5198114769,1,3,20,0,0);
INSERT INTO `testinconceptforstudent` VALUES (74,48,'2','2006.05.27 AD at 06:58:15 CEST','2006.05.27 AD at 06:58:18 CEST',1,0.5198114769,1,3,20,0,0);
INSERT INTO `testinconceptforstudent` VALUES (75,49,'1','2006.05.27 AD at 06:58:20 CEST','2006.05.27 AD at 06:58:23 CEST',1,4.4309331338,1,3,20,100,20);
INSERT INTO `testinconceptforstudent` VALUES (76,50,'1','2006.05.27 AD at 23:11:11 CEST','2006.05.27 AD at 23:11:18 CEST',1,0.5198114769,1,7,20,40,8);
INSERT INTO `testinconceptforstudent` VALUES (77,50,'2','2006.05.27 AD at 23:11:24 CEST','2006.05.27 AD at 23:11:29 CEST',1,0.5198114769,1,5,20,33.3333333333,6.6666666667);
INSERT INTO `testinconceptforstudent` VALUES (78,51,'1','2006.05.27 AD at 23:11:39 CEST','2006.05.27 AD at 23:11:46 CEST',1,1.7693787449,1,7,20,60,12);
INSERT INTO `testinconceptforstudent` VALUES (79,51,'2','2006.05.27 AD at 23:11:50 CEST','2006.05.27 AD at 23:11:54 CEST',1,0.5198114769,1,4,20,0,0);
INSERT INTO `testinconceptforstudent` VALUES (80,52,'1','2006.05.27 AD at 23:12:02 CEST','2006.05.27 AD at 23:12:16 CEST',1,3.75,1,14,32,87.5,28);
INSERT INTO `testinconceptforstudent` VALUES (81,52,'2','2006.05.27 AD at 23:12:20 CEST','2006.05.27 AD at 23:12:23 CEST',1,4.4309331338,1,3,20,100,20);
INSERT INTO `testinconceptforstudent` VALUES (82,53,'1','2006.05.27 AD at 23:12:27 CEST','2006.05.27 AD at 23:12:29 CEST',1,4.4309331338,1,2,20,100,20);
INSERT INTO `testinconceptforstudent` VALUES (83,52,'3','2006.05.27 AD at 23:12:49 CEST','2006.05.27 AD at 23:12:56 CEST',1,4.8014119604,2.2453185983,7,56,100,56);
INSERT INTO `testinconceptforstudent` VALUES (84,54,'1','2006.05.27 AD at 23:12:59 CEST','2006.05.27 AD at 23:13:03 CEST',1,4.4309331338,2.2453185983,4,20,100,20);
INSERT INTO `testinconceptforstudent` VALUES (85,55,'1','2006.05.27 AD at 23:13:06 CEST','2006.05.27 AD at 23:13:08 CEST',1,4.4309331338,2.2453185983,2,20,100,20);


#
# Table structure for table unit
#

CREATE TABLE `unit` (
  `unitID` char(11) NOT NULL,
  `title` char(150) default NULL,
  `reference` char(11) default NULL,
  `ordinalNumber` tinyint(4) default NULL,
  `conceptID` char(11) default NULL,
  PRIMARY KEY  (`unitID`),
  KEY `Ref_04` (`conceptID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Dumping data for table unit
#
INSERT INTO `unit` VALUES ('u1011','Introduction','',0,'c101');
INSERT INTO `unit` VALUES ('u1012','Structure','',0,'c101');
INSERT INTO `unit` VALUES ('u1013','Participants and Collaborations','',0,'c101');
INSERT INTO `unit` VALUES ('u1014','Consequences','',0,'c101');
INSERT INTO `unit` VALUES ('u1015','Implementation','',0,'c101');
INSERT INTO `unit` VALUES ('u1016','Sample Code','',0,'c101');
INSERT INTO `unit` VALUES ('u1017','Known Uses and Related Patterns','',0,'c101');
INSERT INTO `unit` VALUES ('u1021','Introduction','',0,'c102');
INSERT INTO `unit` VALUES ('u1022','Structure','',0,'c102');
INSERT INTO `unit` VALUES ('u1023','Participants and Collaborations','',0,'c102');
INSERT INTO `unit` VALUES ('u1024','Consequences','',0,'c102');
INSERT INTO `unit` VALUES ('u1025','Implementation','',0,'c102');
INSERT INTO `unit` VALUES ('u1026','Sample Code','',0,'c102');
INSERT INTO `unit` VALUES ('u1027','Known Uses and Related Patterns','',0,'c102');
INSERT INTO `unit` VALUES ('u1031','Under the construction','',0,'c103');
INSERT INTO `unit` VALUES ('u1032','under the construction','',0,'c103');
INSERT INTO `unit` VALUES ('u1033','under the construction','',0,'c103');
INSERT INTO `unit` VALUES ('u1034','under the construction','',0,'c103');
INSERT INTO `unit` VALUES ('u1035','under the construction','',0,'c103');
INSERT INTO `unit` VALUES ('u1041','Under the construction','',0,'c104');
INSERT INTO `unit` VALUES ('u1051','Under the construction','',0,'c105');
INSERT INTO `unit` VALUES ('u2011','Under the construction','',0,'c201');
INSERT INTO `unit` VALUES ('u2021','Under the construction','',0,'c202');
INSERT INTO `unit` VALUES ('u2031','Under the construction','',0,'c203');
INSERT INTO `unit` VALUES ('u2041','Under the construction','',0,'c204');
INSERT INTO `unit` VALUES ('u2051','Under the construction','',0,'c205');
INSERT INTO `unit` VALUES ('u2061','Under the construction','',0,'c206');
INSERT INTO `unit` VALUES ('u2071','Under the construction','',0,'c207');
INSERT INTO `unit` VALUES ('u3011','Under the construction','',0,'c301');
INSERT INTO `unit` VALUES ('u3021','Under the construction','',0,'c302');
INSERT INTO `unit` VALUES ('u3031','Under the construction','',0,'c303');
INSERT INTO `unit` VALUES ('u3041','Under the construction','',0,'c304');
INSERT INTO `unit` VALUES ('u3051','Under the construction','',0,'c305');
INSERT INTO `unit` VALUES ('u3061','Under the construction','',0,'c306');
INSERT INTO `unit` VALUES ('u3071','Under the construction','',0,'c307');
INSERT INTO `unit` VALUES ('u3081','Under the construction','',0,'c308');
INSERT INTO `unit` VALUES ('u3091','Under the construction','',0,'c309');
INSERT INTO `unit` VALUES ('u3101','Under the construction','',0,'c310');
INSERT INTO `unit` VALUES ('u3111','Under the construction','',0,'c311');


#
# Table structure for table unitsinconceptforstudent
#

CREATE TABLE `unitsinconceptforstudent` (
  `IDUnitInConceptForStudent` int(11) NOT NULL auto_increment,
  `IDConceptInCourseForStudent` int(11) default '0',
  `unitID` char(11) default NULL,
  `started` char(50) default NULL,
  `finished` char(50) default NULL,
  `numberOfPasses` tinyint(4) default NULL,
  PRIMARY KEY  (`IDUnitInConceptForStudent`),
  KEY `Ref_06` (`IDConceptInCourseForStudent`),
  KEY `Ref_14` (`unitID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Dumping data for table unitsinconceptforstudent
#
INSERT INTO `unitsinconceptforstudent` VALUES (238,35,'u1011','2006.05.27 AD at 06:53:25 CEST','2006.05.27 AD at 06:53:25 CEST',2);
INSERT INTO `unitsinconceptforstudent` VALUES (239,35,'u1012','2006.05.27 AD at 06:53:10 CEST','2006.05.27 AD at 06:53:10 CEST',1);
INSERT INTO `unitsinconceptforstudent` VALUES (240,35,'u1013','2006.05.27 AD at 06:53:26 CEST','2006.05.27 AD at 06:53:26 CEST',2);
INSERT INTO `unitsinconceptforstudent` VALUES (241,35,'u1014','2006.05.27 AD at 06:53:12 CEST','2006.05.27 AD at 06:53:12 CEST',1);
INSERT INTO `unitsinconceptforstudent` VALUES (242,35,'u1015','2006.05.27 AD at 06:53:27 CEST','2006.05.27 AD at 06:53:27 CEST',2);
INSERT INTO `unitsinconceptforstudent` VALUES (243,35,'u1016','2006.05.27 AD at 06:53:14 CEST','2006.05.27 AD at 06:53:14 CEST',1);
INSERT INTO `unitsinconceptforstudent` VALUES (244,35,'u1017','2006.05.27 AD at 06:53:28 CEST','2006.05.27 AD at 06:53:28 CEST',2);
INSERT INTO `unitsinconceptforstudent` VALUES (245,36,'u1021','2006.05.27 AD at 06:53:38 CEST','2006.05.27 AD at 06:53:38 CEST',1);
INSERT INTO `unitsinconceptforstudent` VALUES (246,36,'u1022','2006.05.27 AD at 06:53:41 CEST','2006.05.27 AD at 06:53:41 CEST',1);
INSERT INTO `unitsinconceptforstudent` VALUES (247,36,'u1023','2006.05.27 AD at 06:53:42 CEST','2006.05.27 AD at 06:53:42 CEST',1);
INSERT INTO `unitsinconceptforstudent` VALUES (248,36,'u1024','2006.05.27 AD at 06:53:44 CEST','2006.05.27 AD at 06:53:44 CEST',1);
INSERT INTO `unitsinconceptforstudent` VALUES (249,36,'u1025','2006.05.27 AD at 06:53:45 CEST','2006.05.27 AD at 06:53:45 CEST',1);
INSERT INTO `unitsinconceptforstudent` VALUES (250,36,'u1026','2006.05.27 AD at 06:53:46 CEST','2006.05.27 AD at 06:53:46 CEST',1);
INSERT INTO `unitsinconceptforstudent` VALUES (251,36,'u1027','2006.05.27 AD at 06:53:47 CEST','2006.05.27 AD at 06:53:47 CEST',1);
INSERT INTO `unitsinconceptforstudent` VALUES (252,37,'u1031','2006.05.27 AD at 06:53:58 CEST','2006.05.27 AD at 06:53:58 CEST',1);
INSERT INTO `unitsinconceptforstudent` VALUES (253,37,'u1032','2006.05.27 AD at 06:54:00 CEST','2006.05.27 AD at 06:54:00 CEST',1);
INSERT INTO `unitsinconceptforstudent` VALUES (254,37,'u1033','2006.05.27 AD at 06:54:01 CEST','2006.05.27 AD at 06:54:01 CEST',1);
INSERT INTO `unitsinconceptforstudent` VALUES (255,37,'u1034','2006.05.27 AD at 06:54:01 CEST','2006.05.27 AD at 06:54:01 CEST',1);
INSERT INTO `unitsinconceptforstudent` VALUES (256,37,'u1035','2006.05.27 AD at 06:54:02 CEST','2006.05.27 AD at 06:54:02 CEST',1);
INSERT INTO `unitsinconceptforstudent` VALUES (257,38,'u2061','2006.05.27 AD at 06:54:20 CEST','2006.05.27 AD at 06:54:20 CEST',2);
INSERT INTO `unitsinconceptforstudent` VALUES (258,39,'u3021','2006.05.27 AD at 06:54:34 CEST','2006.05.27 AD at 06:54:34 CEST',2);
INSERT INTO `unitsinconceptforstudent` VALUES (259,40,'u1011','2006.05.27 AD at 06:55:24 CEST','2006.05.27 AD at 06:55:24 CEST',2);
INSERT INTO `unitsinconceptforstudent` VALUES (260,40,'u1012','2006.05.27 AD at 06:55:08 CEST','2006.05.27 AD at 06:55:08 CEST',1);
INSERT INTO `unitsinconceptforstudent` VALUES (261,40,'u1013','2006.05.27 AD at 06:55:25 CEST','2006.05.27 AD at 06:55:25 CEST',2);
INSERT INTO `unitsinconceptforstudent` VALUES (262,40,'u1014','2006.05.27 AD at 06:55:10 CEST','2006.05.27 AD at 06:55:10 CEST',1);
INSERT INTO `unitsinconceptforstudent` VALUES (263,40,'u1015','2006.05.27 AD at 06:55:26 CEST','2006.05.27 AD at 06:55:26 CEST',2);
INSERT INTO `unitsinconceptforstudent` VALUES (264,40,'u1016','2006.05.27 AD at 06:55:12 CEST','2006.05.27 AD at 06:55:12 CEST',1);
INSERT INTO `unitsinconceptforstudent` VALUES (265,40,'u1017','2006.05.27 AD at 06:55:27 CEST','2006.05.27 AD at 06:55:27 CEST',2);
INSERT INTO `unitsinconceptforstudent` VALUES (266,41,'u1021','2006.05.27 AD at 06:55:36 CEST','2006.05.27 AD at 06:55:36 CEST',1);
INSERT INTO `unitsinconceptforstudent` VALUES (267,41,'u1022','2006.05.27 AD at 06:55:52 CEST','2006.05.27 AD at 06:55:52 CEST',2);
INSERT INTO `unitsinconceptforstudent` VALUES (268,41,'u1023','2006.05.27 AD at 06:55:38 CEST','2006.05.27 AD at 06:55:38 CEST',1);
INSERT INTO `unitsinconceptforstudent` VALUES (269,41,'u1024','2006.05.27 AD at 06:55:38 CEST','2006.05.27 AD at 06:55:38 CEST',1);
INSERT INTO `unitsinconceptforstudent` VALUES (270,41,'u1025','2006.05.27 AD at 06:55:54 CEST','2006.05.27 AD at 06:55:54 CEST',2);
INSERT INTO `unitsinconceptforstudent` VALUES (271,41,'u1026','2006.05.27 AD at 06:55:40 CEST','2006.05.27 AD at 06:55:40 CEST',1);
INSERT INTO `unitsinconceptforstudent` VALUES (272,41,'u1027','2006.05.27 AD at 06:55:55 CEST','2006.05.27 AD at 06:55:55 CEST',2);
INSERT INTO `unitsinconceptforstudent` VALUES (273,42,'u1031','2006.05.27 AD at 06:56:14 CEST','2006.05.27 AD at 06:56:14 CEST',2);
INSERT INTO `unitsinconceptforstudent` VALUES (274,42,'u1032','2006.05.27 AD at 06:56:03 CEST','2006.05.27 AD at 06:56:03 CEST',1);
INSERT INTO `unitsinconceptforstudent` VALUES (275,42,'u1033','2006.05.27 AD at 06:56:04 CEST','2006.05.27 AD at 06:56:04 CEST',1);
INSERT INTO `unitsinconceptforstudent` VALUES (276,42,'u1034','2006.05.27 AD at 06:56:05 CEST','2006.05.27 AD at 06:56:05 CEST',1);
INSERT INTO `unitsinconceptforstudent` VALUES (277,42,'u1035','2006.05.27 AD at 06:56:05 CEST','2006.05.27 AD at 06:56:05 CEST',1);
INSERT INTO `unitsinconceptforstudent` VALUES (278,43,'u1051','2006.05.27 AD at 06:56:25 CEST','2006.05.27 AD at 06:56:25 CEST',2);
INSERT INTO `unitsinconceptforstudent` VALUES (279,44,'u2011','2006.05.27 AD at 06:56:31 CEST','2006.05.27 AD at 06:56:31 CEST',1);
INSERT INTO `unitsinconceptforstudent` VALUES (280,45,'u1011','2006.05.27 AD at 06:57:12 CEST','2006.05.27 AD at 06:57:12 CEST',2);
INSERT INTO `unitsinconceptforstudent` VALUES (281,45,'u1012','2006.05.27 AD at 06:56:56 CEST','2006.05.27 AD at 06:56:56 CEST',1);
INSERT INTO `unitsinconceptforstudent` VALUES (282,45,'u1013','2006.05.27 AD at 06:57:14 CEST','2006.05.27 AD at 06:57:14 CEST',2);
INSERT INTO `unitsinconceptforstudent` VALUES (283,45,'u1014','2006.05.27 AD at 06:57:13 CEST','2006.05.27 AD at 06:57:13 CEST',2);
INSERT INTO `unitsinconceptforstudent` VALUES (284,45,'u1015','2006.05.27 AD at 06:57:15 CEST','2006.05.27 AD at 06:57:15 CEST',2);
INSERT INTO `unitsinconceptforstudent` VALUES (285,45,'u1016','2006.05.27 AD at 06:57:00 CEST','2006.05.27 AD at 06:57:00 CEST',1);
INSERT INTO `unitsinconceptforstudent` VALUES (286,45,'u1017','2006.05.27 AD at 06:57:16 CEST','2006.05.27 AD at 06:57:16 CEST',2);
INSERT INTO `unitsinconceptforstudent` VALUES (287,46,'u1021','2006.05.27 AD at 06:57:27 CEST','2006.05.27 AD at 06:57:27 CEST',1);
INSERT INTO `unitsinconceptforstudent` VALUES (288,46,'u1022','2006.05.27 AD at 06:57:42 CEST','2006.05.27 AD at 06:57:42 CEST',2);
INSERT INTO `unitsinconceptforstudent` VALUES (289,46,'u1023','2006.05.27 AD at 06:57:29 CEST','2006.05.27 AD at 06:57:29 CEST',1);
INSERT INTO `unitsinconceptforstudent` VALUES (290,46,'u1024','2006.05.27 AD at 06:57:30 CEST','2006.05.27 AD at 06:57:30 CEST',1);
INSERT INTO `unitsinconceptforstudent` VALUES (291,46,'u1025','2006.05.27 AD at 06:57:44 CEST','2006.05.27 AD at 06:57:44 CEST',2);
INSERT INTO `unitsinconceptforstudent` VALUES (292,46,'u1026','2006.05.27 AD at 06:57:32 CEST','2006.05.27 AD at 06:57:32 CEST',1);
INSERT INTO `unitsinconceptforstudent` VALUES (293,46,'u1027','2006.05.27 AD at 06:57:33 CEST','2006.05.27 AD at 06:57:33 CEST',1);
INSERT INTO `unitsinconceptforstudent` VALUES (294,47,'u1031','2006.05.27 AD at 06:58:03 CEST','2006.05.27 AD at 06:58:03 CEST',2);
INSERT INTO `unitsinconceptforstudent` VALUES (295,47,'u1032','2006.05.27 AD at 06:57:51 CEST','2006.05.27 AD at 06:57:51 CEST',1);
INSERT INTO `unitsinconceptforstudent` VALUES (296,47,'u1033','2006.05.27 AD at 06:57:52 CEST','2006.05.27 AD at 06:57:52 CEST',1);
INSERT INTO `unitsinconceptforstudent` VALUES (297,47,'u1034','2006.05.27 AD at 06:57:52 CEST','2006.05.27 AD at 06:57:52 CEST',1);
INSERT INTO `unitsinconceptforstudent` VALUES (298,47,'u1035','2006.05.27 AD at 06:57:53 CEST','2006.05.27 AD at 06:57:53 CEST',1);
INSERT INTO `unitsinconceptforstudent` VALUES (299,48,'u1051','2006.05.27 AD at 06:58:14 CEST','2006.05.27 AD at 06:58:14 CEST',2);
INSERT INTO `unitsinconceptforstudent` VALUES (300,49,'u2011','2006.05.27 AD at 06:58:19 CEST','2006.05.27 AD at 06:58:19 CEST',1);
INSERT INTO `unitsinconceptforstudent` VALUES (301,50,'u1011','2006.05.27 AD at 23:11:20 CEST','2006.05.27 AD at 23:11:20 CEST',2);
INSERT INTO `unitsinconceptforstudent` VALUES (302,50,'u1012','2006.05.27 AD at 23:11:04 CEST','2006.05.27 AD at 23:11:04 CEST',1);
INSERT INTO `unitsinconceptforstudent` VALUES (303,50,'u1013','2006.05.27 AD at 23:11:21 CEST','2006.05.27 AD at 23:11:21 CEST',2);
INSERT INTO `unitsinconceptforstudent` VALUES (304,50,'u1014','2006.05.27 AD at 23:11:06 CEST','2006.05.27 AD at 23:11:06 CEST',1);
INSERT INTO `unitsinconceptforstudent` VALUES (305,50,'u1015','2006.05.27 AD at 23:11:07 CEST','2006.05.27 AD at 23:11:07 CEST',1);
INSERT INTO `unitsinconceptforstudent` VALUES (306,50,'u1016','2006.05.27 AD at 23:11:09 CEST','2006.05.27 AD at 23:11:09 CEST',1);
INSERT INTO `unitsinconceptforstudent` VALUES (307,50,'u1017','2006.05.27 AD at 23:11:22 CEST','2006.05.27 AD at 23:11:22 CEST',2);
INSERT INTO `unitsinconceptforstudent` VALUES (308,51,'u1021','2006.05.27 AD at 23:11:30 CEST','2006.05.27 AD at 23:11:30 CEST',1);
INSERT INTO `unitsinconceptforstudent` VALUES (309,51,'u1022','2006.05.27 AD at 23:11:48 CEST','2006.05.27 AD at 23:11:48 CEST',2);
INSERT INTO `unitsinconceptforstudent` VALUES (310,51,'u1023','2006.05.27 AD at 23:11:32 CEST','2006.05.27 AD at 23:11:32 CEST',1);
INSERT INTO `unitsinconceptforstudent` VALUES (311,51,'u1024','2006.05.27 AD at 23:11:34 CEST','2006.05.27 AD at 23:11:34 CEST',1);
INSERT INTO `unitsinconceptforstudent` VALUES (312,51,'u1025','2006.05.27 AD at 23:11:49 CEST','2006.05.27 AD at 23:11:49 CEST',2);
INSERT INTO `unitsinconceptforstudent` VALUES (313,51,'u1026','2006.05.27 AD at 23:11:36 CEST','2006.05.27 AD at 23:11:36 CEST',1);
INSERT INTO `unitsinconceptforstudent` VALUES (314,51,'u1027','2006.05.27 AD at 23:11:37 CEST','2006.05.27 AD at 23:11:37 CEST',1);
INSERT INTO `unitsinconceptforstudent` VALUES (315,52,'u1031','2006.05.27 AD at 23:12:38 CEST','2006.05.27 AD at 23:12:38 CEST',3);
INSERT INTO `unitsinconceptforstudent` VALUES (316,52,'u1032','2006.05.27 AD at 23:12:45 CEST','2006.05.27 AD at 23:12:45 CEST',2);
INSERT INTO `unitsinconceptforstudent` VALUES (317,52,'u1033','2006.05.27 AD at 23:12:46 CEST','2006.05.27 AD at 23:12:46 CEST',2);
INSERT INTO `unitsinconceptforstudent` VALUES (318,52,'u1034','2006.05.27 AD at 23:12:47 CEST','2006.05.27 AD at 23:12:47 CEST',2);
INSERT INTO `unitsinconceptforstudent` VALUES (319,52,'u1035','2006.05.27 AD at 23:12:48 CEST','2006.05.27 AD at 23:12:48 CEST',2);
INSERT INTO `unitsinconceptforstudent` VALUES (320,53,'u1051','2006.05.27 AD at 23:12:25 CEST','2006.05.27 AD at 23:12:25 CEST',1);
INSERT INTO `unitsinconceptforstudent` VALUES (321,54,'u2061','2006.05.27 AD at 23:12:58 CEST','2006.05.27 AD at 23:12:58 CEST',1);
INSERT INTO `unitsinconceptforstudent` VALUES (322,55,'u3021','2006.05.27 AD at 23:13:05 CEST','2006.05.27 AD at 23:13:05 CEST',1);


#
# Source for procedure spInsertConcept
#

CREATE PROCEDURE `spInsertConcept`(IN courseID CHAR, IN cID CHAR, IN title CHAR)
BEGIN
  DECLARE conc INT DEFAULT 0;
  SELECT COUNT(*) INTO conc FROM concept  WHERE concept.`conceptID`=cID;
  IF conc=0 THEN
  INSERT INTO concept (conceptID, title, courseID)
  VALUES (cID, title, courseID);
  ELSE
  UPDATE concept SET conceptID=cID, title=title, courseID=courseID
  WHERE conceptID=cID;
  END IF;
END;

#
# Source for procedure spInsertConceptInCourseForStudent
#

CREATE PROCEDURE `spInsertConceptInCourseForStudent`(IN studID INTEGER, IN conceptID CHAR, IN duration INTEGER, IN feedbackMessage CHAR, IN started CHAR, IN finished CHAR, IN numberOfPasses INTEGER, IN degreeOfMastery DOUBLE, IN knowledgeLevel DOUBLE, IN experienceLevel CHAR, IN reasoningAbilityLevel CHAR, IN courseId CHAR)
BEGIN
  DECLARE idStudInCourse CHAR;
  SELECT IDStudentInCourse INTO idStudInCourse FROM studentsInCourse WHERE studentID=studID;
  INSERT INTO conceptsInCourseForStudent (IDStudentInCourse, conceptID,
  duration, feedbackMessage, started, finished,
  numberOfPasses, degreeOfMastery, knowledgeLevel,
  experienceLevel, reasoningAbilityLevel,courseId)
  VALUES (IDStudInCourse, conceptID,
  duration, feedbackMessage, started, finished,
  numberOfPasses, degreeOfMastery, knowledgeLevel,
  experienceLevel, reasoningAbilityLevel,courseId);
END;

#
# Source for procedure spInsertGroupAdministrator
#

CREATE PROCEDURE `spInsertGroupAdministrator`(IN groupId INTEGER(11), IN adminId INTEGER(11))
BEGIN
INSERT INTO `administrator_has_groups` (groupId, administratorId)
  VALUES (groupId, adminId);
END;

#
# Source for procedure spInsertGroupCourse
#

CREATE PROCEDURE `spInsertGroupCourse`(IN groupId INTEGER(11), IN courseId CHAR(50))
BEGIN
INSERT INTO `group_has_course` (groupId, courseId)
  VALUES (groupId, courseId);
END;

#
# Source for procedure spInsertGroupData
#

CREATE PROCEDURE `spInsertGroupData`(IN groupId INTEGER(11), IN groupName CHAR(50), IN langId INTEGER(11), IN description TEXT)
BEGIN
INSERT INTO `groups` (groupId, groupName, languageId,description)
  VALUES (groupId, groupName,langId,description);
END;

#
# Source for procedure spInsertGroupTeacher
#

CREATE PROCEDURE `spInsertGroupTeacher`(IN groupId INTEGER(11), IN teacherId INTEGER(11))
BEGIN
INSERT INTO `teacher_has_groups` (groupId, teacherId)
  VALUES (groupId, teacherId);
END;

#
# Source for procedure spInsertNewAdminData
#

CREATE PROCEDURE `spInsertNewAdminData`(IN adminId INT, IN fName CHAR, IN lName CHAR, IN uName CHAR, IN passw CHAR, IN email CHAR, IN addr CHAR, IN city CHAR, IN country INT, IN organisation CHAR, IN webSite CHAR, IN langId INT, IN privilegies CHAR)
BEGIN
  DECLARE privilegId CHAR;
  SELECT privilegieId INTO privilegId FROM privilegies WHERE privType=privilegies;
  INSERT INTO administrators (administratorId, firstName, lastName, userName, password, email,address, city,countryId,organisation, webSite,languageId,privilegieId_FK)
  VALUES (adminId, fName, lName, uName, passw, email,addr, city,country,organisation, webSite,langId,privilegId);
END;

#
# Source for procedure spInsertNewAssistantData
#

CREATE PROCEDURE `spInsertNewAssistantData`(IN assistantId INTEGER(11), IN fName CHAR, IN lName CHAR, IN uName CHAR, IN passw CHAR, IN email CHAR, IN address CHAR, IN city CHAR, IN countryId INTEGER(11), IN organisation CHAR, IN webS CHAR, IN langId INTEGER(11), IN teacherId INTEGER(11))
BEGIN
INSERT INTO assistants (assistentId, firstName, lastName, userName, password, email,address, city,countryId,organisation, webSite,languageId,teacherId)
  VALUES (assistantId, fName, lName, uName, passw, email,address, city,countryId,organisation, webS,langId,teacherId);
END;

#
# Source for procedure spInsertNewAssistantGroup
#

CREATE PROCEDURE `spInsertNewAssistantGroup`(IN assistantId INTEGER(11), IN groupId INTEGER(11))
BEGIN
INSERT INTO `assistant_has_groups`(assistantId, groupId)
VALUES (assistantId,groupId);
END;

#
# Source for procedure spInsertNewAssistantPrivilegie
#

CREATE PROCEDURE `spInsertNewAssistantPrivilegie`(IN assistantId INTEGER(11), IN privilegieId INTEGER(11))
BEGIN
INSERT INTO `assistant_has_privilegies`(assistantId, privilegieId)
VALUES (assistantId,privilegieId);
END;

#
# Source for procedure spInsertNewTeacherData
#

CREATE PROCEDURE `spInsertNewTeacherData`(IN teacherId INT, IN fName CHAR, IN lName CHAR, IN uName CHAR, IN passw CHAR, IN email CHAR, IN addr CHAR, IN city CHAR, IN countryId INT, IN organisation CHAR, IN webSite CHAR, IN langId INT, IN adminId INT)
BEGIN
  
  INSERT INTO teachers (teacherId, firstName, lastName, userName, password, email,address, city,countryId,organisation, webSite,languageId, administratorId)
  VALUES (teacherId, fName, lName, uName, passw, email,addr, city,countryId,organisation, webSite,langId,adminId);
END;

#
# Source for procedure spInsertQuestion
#

CREATE PROCEDURE `spInsertQuestion`(IN cID CHAR, IN qID CHAR, IN gr INT)
BEGIN
  DECLARE quest INT DEFAULT 0;
  SELECT COUNT(*) INTO quest FROM question
  WHERE ((question.`conceptID`=cID)AND(question.`questionID`=qID));
  IF quest=0 THEN
  INSERT INTO question (questionID, qGroup, conceptID)
  VALUES (qID,gr, cID);
  ELSE
  UPDATE question SET questionID=qID, qGroup=gr, conceptID=cID
  WHERE ((question.`conceptID`=cID) AND (question.`questionID`=qID));
  END IF;
END;

#
# Source for procedure spInsertQuestionInTestForStudent
#

CREATE PROCEDURE `spInsertQuestionInTestForStudent`(IN studID INT, IN concID CHAR, IN testId INT, IN questionId CHAR, IN truth CHAR)
BEGIN
  DECLARE idStudInCourse CHAR;
  DECLARE idConcInCourse CHAR;
  DECLARE idTestInConcept CHAR;
  SELECT IDStudentInCourse INTO idStudInCourse FROM studentsInCourse WHERE studentsInCourse.`studentID`=studID;
  SELECT IDConceptInCourseForStudent INTO idConcInCourse FROM conceptsInCourseForStudent
  WHERE ((conceptsInCourseForStudent.`conceptID`=concID) AND (conceptsInCourseForStudent.`IDStudentInCourse`=idStudInCourse));
  SELECT IDTestInConceptForStudent INTO idTestInConcept FROM testInConceptForStudent
  WHERE ((testInConceptForStudent.`testID`=testId) AND (testInConceptForStudent.`IDConceptInCourseForStudent`=idConcInCourse));
  INSERT INTO questionInTestForStudent (IDTestInConceptForStudent, questionID, truth)
  VALUES (idTestInConcept, questionId, truth);
END;

#
# Source for procedure spInsertStudentData
#

CREATE PROCEDURE `spInsertStudentData`(IN studId INT, IN fName CHAR, IN lName CHAR, IN uName CHAR, IN passw CHAR, IN email CHAR, IN addr CHAR, IN city CHAR, IN country INT, IN organization CHAR, IN webSite CHAR, IN language INT)
BEGIN
  INSERT INTO students (studentID, firstName, lastName, userName, password, email,address, city,countryId,organization, webSite,languageId)
  VALUES (studId, fName, lName,uName,passw,email,addr,city,country,organization,webSite,language);
END;

#
# Source for procedure spInsertStudentInCourse
#

CREATE PROCEDURE `spInsertStudentInCourse`(IN studentID INTEGER, IN started CHAR, IN finished CHAR, IN numberOfPasses INTEGER, IN groupId INTEGER(11))
BEGIN
  INSERT INTO studentsInCourse (studentID, started, finished, numberOfPasses,groupId)
  VALUES (studentID,  started, finished, numberOfPasses,groupId);
END;

#
# Source for procedure spInsertStudentInitialPerformances
#

CREATE PROCEDURE `spInsertStudentInitialPerformances`(IN studId INT, IN inSkLev DOUBLE, IN detLev INT, IN programmLang CHAR)
BEGIN
  INSERT INTO performance (studentID, initialSkillLevel, actualSkillLevel, detailLevel, programmingLanguage)
  VALUES (studId, inSkLev,inSkLev, detLev,programmLang);
END;

#
# Source for procedure spInsertStudentPerformances
#

CREATE PROCEDURE `spInsertStudentPerformances`(IN studId INT, IN actSkLev DOUBLE, IN learnStyle CHAR, IN timeOfLastS CHAR, IN detLev INT, IN experienceLev CHAR, IN reasoningAb CHAR, IN programmLang CHAR)
BEGIN
  UPDATE `performance` SET
  `actualSkillLevel`=actSkLev,
  `learningStyle`=learnStyle,
  `timeOfLastSession`=timeOfLastS,
  `detailLevel`=detLev,
  `experienceLevel`=experienceLev,
  `reasoningAbility`=reasoningAb,
  `programmingLanguage`=programmLang
  WHERE (`studentID`= studId);
END;

#
# Source for procedure spInsertTeacherCourse
#

CREATE PROCEDURE `spInsertTeacherCourse`(IN teacherId INTEGER(11), IN courseId CHAR)
BEGIN
INSERT INTO `teacher_has_course` (teacherId, courseId)
  VALUES (teacherId,courseId);
END;

#
# Source for procedure spInsertTeacherPrivilegies
#

CREATE PROCEDURE `spInsertTeacherPrivilegies`(IN teachId INT,IN privId INT)
BEGIN
INSERT INTO teacher_has_privilegies (teacherId_FK, privilegieId_FK)
VALUES (teachId,privId);
END;

#
# Source for procedure spInsertTestInConceptForStudent
#

CREATE PROCEDURE `spInsertTestInConceptForStudent`(IN studID INT, IN concID CHAR, IN testId CHAR, IN started CHAR, IN finished CHAR, IN numberOfPasses INT, IN degreeOfMastery DOUBLE, IN knowlLev DOUBLE, IN duration INT, IN testDiff DOUBLE, IN succ DOUBLE, IN testPNum DOUBLE)
BEGIN
  DECLARE idStudInCourse CHAR;
  DECLARE idConcInCourse CHAR;
  DECLARE tests INT DEFAULT 0;
  SELECT IDStudentInCourse INTO idStudInCourse FROM studentsInCourse WHERE studentID=studID;
  SELECT IDConceptInCourseForStudent INTO idConcInCourse FROM conceptsInCourseForStudent WHERE (IDStudentInCourse=idStudInCourse and conceptsInCourseForStudent.`conceptID`=concId);
  SELECT COUNT(*) INTO tests FROM testInConceptForStudent WHERE (testInConceptForStudent.`testID`=testId AND testInConceptForStudent.`IDConceptInCourseForStudent`=idConcInCourse);
  IF tests=0 THEN
  INSERT INTO testInConceptForStudent (IDConceptInCourseForStudent, testID,started, finished, numberOfPasses, degreeOfMastery, knowledgeLevel, duration, testDifficultyFactor, success, testPointsNumber)
  VALUES (idConcInCourse, testId, started, finished, numberOfPasses, degreeOfMastery, knowlLev, duration, testDiff, succ, testPNum);
  END IF;
END;

#
# Source for procedure spInsertUnit
#

CREATE PROCEDURE `spInsertUnit`(IN cID CHAR, IN uID CHAR, IN tit CHAR, IN ordN INT)
BEGIN
  DECLARE un INT DEFAULT 0;
  SELECT COUNT(*) INTO un FROM unit
  WHERE ((unit.`conceptID`=cID)AND(unit.`unitID`=uID));
  IF un=0 THEN
  INSERT INTO unit (unitID, title, ordinalNumber, conceptID)
  VALUES (uID, tit, ordN, cID);
  ELSE
  UPDATE unit SET unitID=uID, title=tit, ordinalNumber=ordN, conceptID=cID
  WHERE conceptID=cID AND unitID=uID;
  END IF;
END;

#
# Source for procedure spInsertUnitInConceptForStudent
#

CREATE PROCEDURE `spInsertUnitInConceptForStudent`(IN studID INT, IN concID CHAR, IN unitId CHAR, IN started CHAR, IN finished CHAR, IN numberOfPasses INT)
BEGIN
  DECLARE idStudInCourse CHAR;
  DECLARE idConcInCourse CHAR;
  SELECT IDStudentInCourse INTO idStudInCourse FROM studentsInCourse WHERE studentID=studID;
  SELECT IDConceptInCourseForStudent INTO idConcInCourse FROM conceptsInCourseForStudent
  WHERE ((conceptsInCourseForStudent.`conceptID`=concID) AND (conceptsInCourseForStudent.`IDStudentInCourse`=idStudInCourse));
  INSERT INTO unitsInConceptForStudent (IDConceptInCourseForStudent, unitID,
  started, finished, numberOfPasses)
  VALUES (idConcInCourse, unitId, started, finished, numberOfPasses);
END;

#
# Source for procedure spUpdateAdminData
#

CREATE PROCEDURE `spUpdateAdminData`(IN fName CHAR, IN lName CHAR,IN uName CHAR, IN email CHAR, IN passw CHAR,IN address CHAR,
                                       IN city CHAR, IN country INT,IN organisat CHAR, IN webS CHAR, IN lang INT)
BEGIN
 
  UPDATE administrators
  SET
  firstName=fName,
  lastName=lName,
  email=email,
  password=passw,
  address=address,
  city=city,
  countryId=country,
  organisation=organisat,
  webSite=webS,
  languageId=lang
  
  WHERE (userName=uName);
END;

#
# Source for procedure spUpdateAdminPrivilegies
#

CREATE PROCEDURE `spUpdateAdminPrivilegies`(IN admID INT, IN privID INT)
BEGIN
 
  UPDATE administrators
  SET
  privilegieId_FK=privID
  WHERE (administratorId=admID);
END;

#
# Source for procedure spUpdateConceptInCourseForStudent
#

CREATE PROCEDURE `spUpdateConceptInCourseForStudent`(IN studID INTEGER, IN concID CHAR, IN durat INTEGER, IN feedbMessage CHAR, IN startedT CHAR, IN finishedT CHAR, IN numbOfPasses INTEGER, IN degreeOfMast DOUBLE, IN knowledgeLev DOUBLE, IN experienceLev CHAR, IN reasoningAbilityLev CHAR, IN courseId CHAR)
BEGIN
  DECLARE idStudInCourse CHAR;
  SELECT IDStudentInCourse INTO idStudInCourse FROM studentsInCourse WHERE studentID=studID;
  UPDATE conceptsInCourseForStudent
  SET
  IDStudentInCourse=idStudInCourse,
  conceptID=concID,
  duration=durat,
  feedbackMessage=feedbMessage,
  started=startedT,
  finished=finishedT,
  numberOfPasses=numbOfPasses,
  degreeOfMastery=degreeOfMast,
  knowledgeLevel=knowledgeLev,
  experienceLevel=experienceLev,
  reasoningAbilityLevel=reasoningAbilityLev,
  courseId=courseId
  WHERE ((IDStudentInCourse=idStudInCourse)AND(conceptID=concID));
END;

#
# Source for procedure spUpdateStudentGroup
#

CREATE PROCEDURE `spUpdateStudentGroup`(IN studId INTEGER(11), IN grId INTEGER(11))
BEGIN
UPDATE students
  SET
  groupId=grId

  WHERE (studentId=studId);
END;

#
# Source for procedure spUpdateUnitInConceptForStudent
#

CREATE PROCEDURE `spUpdateUnitInConceptForStudent`(IN studID INT, IN concID CHAR, IN unitId CHAR, IN startedT CHAR, IN finishedT CHAR, IN numberOfPass INT)
BEGIN
  DECLARE idStudInCourse CHAR;
  DECLARE idConcInCourse CHAR;
  SELECT IDStudentInCourse INTO idStudInCourse FROM studentsInCourse WHERE studentID=studID;
  SELECT IDConceptInCourseForStudent INTO idConcInCourse FROM conceptsInCourseForStudent
  WHERE ((conceptsInCourseForStudent.`conceptID`=concID) AND (conceptsInCourseForStudent.`IDStudentInCourse`=idStudInCourse));
  UPDATE unitsInConceptForStudent
  SET
  started=startedT,
  finished=finishedT,
  numberOfPasses=numberOfPass
  WHERE ((unitsInConceptForStudent.`unitID`=unitId)AND(unitsInConceptForStudent.`IDConceptInCourseForStudent`=idConcInCourse));
END;

#
#  Foreign keys for table administrator_has_groups
#

ALTER TABLE `administrator_has_groups`
  ADD FOREIGN KEY (`administratorId`) REFERENCES `administrators` (`administratorId`),
  ADD FOREIGN KEY (`groupId`) REFERENCES `groups` (`groupId`);

#
#  Foreign keys for table administrators
#

ALTER TABLE `administrators`
  ADD FOREIGN KEY (`countryId`) REFERENCES `countries` (`countryId`),
  ADD FOREIGN KEY (`privilegieId_FK`) REFERENCES `privilegies` (`privilegieId`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD FOREIGN KEY (`languageId`) REFERENCES `languages` (`languageId`) ON DELETE NO ACTION ON UPDATE NO ACTION;

#
#  Foreign keys for table assistant_has_groups
#

ALTER TABLE `assistant_has_groups`
  ADD FOREIGN KEY (`groupId`) REFERENCES `groups` (`groupId`),
  ADD FOREIGN KEY (`assistantId`) REFERENCES `assistants` (`assistentId`);

#
#  Foreign keys for table assistant_has_privilegies
#

ALTER TABLE `assistant_has_privilegies`
  ADD FOREIGN KEY (`assistantId`) REFERENCES `assistants` (`assistentId`),
  ADD FOREIGN KEY (`privilegieId`) REFERENCES `assistantprivilegies` (`privilegieId`);

#
#  Foreign keys for table assistants
#

ALTER TABLE `assistants`
  ADD FOREIGN KEY (`teacherId`) REFERENCES `teachers` (`teacherId`),
  ADD FOREIGN KEY (`languageId`) REFERENCES `languages` (`languageId`),
  ADD FOREIGN KEY (`countryId`) REFERENCES `countries` (`countryId`);

#
#  Foreign keys for table concept
#

ALTER TABLE `concept`
  ADD FOREIGN KEY (`courseID`) REFERENCES `course` (`courseID`) ON DELETE NO ACTION ON UPDATE NO ACTION;

#
#  Foreign keys for table conceptsincourseforstudent
#

ALTER TABLE `conceptsincourseforstudent`
  ADD FOREIGN KEY (`conceptID`) REFERENCES `concept` (`conceptID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD FOREIGN KEY (`IDStudentInCourse`) REFERENCES `studentsincourse` (`IDStudentInCourse`) ON DELETE NO ACTION ON UPDATE NO ACTION;

#
#  Foreign keys for table course_has_studentsincourse
#

ALTER TABLE `course_has_studentsincourse`
  ADD FOREIGN KEY (`courseID_FK`) REFERENCES `course` (`courseID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD FOREIGN KEY (`IDStudentInCourse_FK`) REFERENCES `studentsincourse` (`IDStudentInCourse`) ON DELETE NO ACTION ON UPDATE NO ACTION;

#
#  Foreign keys for table group_has_course
#

ALTER TABLE `group_has_course`
  ADD FOREIGN KEY (`groupId`) REFERENCES `groups` (`groupId`),
  ADD FOREIGN KEY (`courseId`) REFERENCES `course` (`courseID`);

#
#  Foreign keys for table groups
#

ALTER TABLE `groups`
  ADD FOREIGN KEY (`languageId`) REFERENCES `languages` (`languageId`);

#
#  Foreign keys for table performance
#

ALTER TABLE `performance`
  ADD FOREIGN KEY (`studentID`) REFERENCES `students` (`studentID`) ON DELETE NO ACTION ON UPDATE NO ACTION;

#
#  Foreign keys for table question
#

ALTER TABLE `question`
  ADD FOREIGN KEY (`conceptID`) REFERENCES `concept` (`conceptID`) ON DELETE NO ACTION ON UPDATE NO ACTION;

#
#  Foreign keys for table questionintestforstudent
#

ALTER TABLE `questionintestforstudent`
  ADD FOREIGN KEY (`questionID`) REFERENCES `question` (`questionID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD FOREIGN KEY (`IDTestInConceptForStudent`) REFERENCES `testinconceptforstudent` (`IDTestInConceptForStudent`) ON DELETE NO ACTION ON UPDATE NO ACTION;

#
#  Foreign keys for table students
#

ALTER TABLE `students`
  ADD FOREIGN KEY (`countryId`) REFERENCES `countries` (`countryId`),
  ADD FOREIGN KEY (`groupId`) REFERENCES `groups` (`groupId`);

#
#  Foreign keys for table studentsincourse
#

ALTER TABLE `studentsincourse`
  ADD FOREIGN KEY (`studentID`) REFERENCES `students` (`studentID`);

#
#  Foreign keys for table teacher_has_course
#

ALTER TABLE `teacher_has_course`
  ADD FOREIGN KEY (`teacherId`) REFERENCES `teachers` (`teacherId`),
  ADD FOREIGN KEY (`courseId`) REFERENCES `course` (`courseID`);

#
#  Foreign keys for table teacher_has_groups
#

ALTER TABLE `teacher_has_groups`
  ADD FOREIGN KEY (`teacherId`) REFERENCES `teachers` (`teacherId`),
  ADD FOREIGN KEY (`groupId`) REFERENCES `groups` (`groupId`);

#
#  Foreign keys for table teacher_has_privilegies
#

ALTER TABLE `teacher_has_privilegies`
  ADD FOREIGN KEY (`privilegieId_FK`) REFERENCES `teacherprivilegies` (`privilegieId`),
  ADD FOREIGN KEY (`teacherId_FK`) REFERENCES `teachers` (`teacherId`);

#
#  Foreign keys for table teachers
#

ALTER TABLE `teachers`
  ADD FOREIGN KEY (`countryId`) REFERENCES `countries` (`countryId`),
  ADD FOREIGN KEY (`administratorId`) REFERENCES `administrators` (`administratorId`),
  ADD FOREIGN KEY (`languageId`) REFERENCES `languages` (`languageId`);

#
#  Foreign keys for table test
#

ALTER TABLE `test`
  ADD FOREIGN KEY (`conceptID`) REFERENCES `concept` (`conceptID`) ON DELETE NO ACTION ON UPDATE NO ACTION;

#
#  Foreign keys for table testinconceptforstudent
#

ALTER TABLE `testinconceptforstudent`
  ADD FOREIGN KEY (`IDConceptInCourseForStudent`) REFERENCES `conceptsincourseforstudent` (`IDConceptInCourseForStudent`) ON DELETE NO ACTION ON UPDATE NO ACTION;

#
#  Foreign keys for table unit
#

ALTER TABLE `unit`
  ADD FOREIGN KEY (`conceptID`) REFERENCES `concept` (`conceptID`) ON DELETE NO ACTION ON UPDATE NO ACTION;

#
#  Foreign keys for table unitsinconceptforstudent
#

ALTER TABLE `unitsinconceptforstudent`
  ADD FOREIGN KEY (`IDConceptInCourseForStudent`) REFERENCES `conceptsincourseforstudent` (`IDConceptInCourseForStudent`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD FOREIGN KEY (`unitID`) REFERENCES `unit` (`unitID`) ON DELETE NO ACTION ON UPDATE NO ACTION;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
