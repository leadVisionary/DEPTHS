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
INSERT INTO `administrator_has_groups` VALUES (74,-2024012907,298804656);
INSERT INTO `administrator_has_groups` VALUES (75,98,298804656);
INSERT INTO `administrator_has_groups` VALUES (76,-2024012907,95430500);
INSERT INTO `administrator_has_groups` VALUES (77,-2024012907,98307);
INSERT INTO `administrator_has_groups` VALUES (78,-2024012907,673009765);
INSERT INTO `administrator_has_groups` VALUES (79,98,673009765);
INSERT INTO `administrator_has_groups` VALUES (80,98,673009797);


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
INSERT INTO `administrators` VALUES (-2024012907,'zoran3','jeremic3','j','jeremycod3','j','','',1,'','http://',1,2);
INSERT INTO `administrators` VALUES (98,'b','b','b','b','b','','',1,'','http://',2,1);
INSERT INTO `administrators` VALUES (116,'t','t','t','t','t','','',1,'','http://',1,1);
INSERT INTO `administrators` VALUES (3327,'hg','hg','hg','hg','hg','','',1,'','http://',1,1);
INSERT INTO `administrators` VALUES (1388085105,'gdsf','gfdsgfewr','fgsdfgwer','fgsdfgwer','g','','',1,'','http://',1,1);


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
INSERT INTO `assistant_has_groups` VALUES (1,369193691,298804656);


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
INSERT INTO `assistant_has_privilegies` VALUES (1,369193691,1);
INSERT INTO `assistant_has_privilegies` VALUES (2,369193691,2);


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
INSERT INTO `assistants` VALUES (369193691,'fdsafwere','fdsa','fdsafewqe','f','f','','',1,'','http://',1,98);


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
  PRIMARY KEY  (`IDConceptInCourseForStudent`),
  KEY `Ref_01` (`conceptID`),
  KEY `Ref_12` (`IDStudentInCourse`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Dumping data for table conceptsincourseforstudent
#
INSERT INTO `conceptsincourseforstudent` VALUES (10,3,'c101',22,NULL,'2006.05.24 AD at 10:38:58 CEST','2006.05.24 AD at 10:39:20 CEST',2,0.871293912,0.9792852812,'el','ral');
INSERT INTO `conceptsincourseforstudent` VALUES (11,3,'c102',20,NULL,'2006.05.24 AD at 10:39:20 CEST','2006.05.24 AD at 10:39:40 CEST',1,1.7693787449,1.1768086471,'el','ral');
INSERT INTO `conceptsincourseforstudent` VALUES (12,3,'c103',12,NULL,'2006.05.24 AD at 10:39:41 CEST','2006.05.24 AD at 10:39:53 CEST',1,3.75,1.6914469177,'el','ral');


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
INSERT INTO `group_has_course` VALUES (35,298804656,'DP001');
INSERT INTO `group_has_course` VALUES (36,95430500,'DP001');
INSERT INTO `group_has_course` VALUES (37,98307,'DP001');
INSERT INTO `group_has_course` VALUES (38,673009765,'DP001');
INSERT INTO `group_has_course` VALUES (39,673009797,'DP001');


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
INSERT INTO `groups` VALUES (98307,'ccc',2,'');
INSERT INTO `groups` VALUES (95430500,'ddddd',3,'');
INSERT INTO `groups` VALUES (298804656,'grupa 5',2,'');
INSERT INTO `groups` VALUES (673009765,'grupa 44',1,'dd');
INSERT INTO `groups` VALUES (673009797,'grupa 55',1,'');


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
INSERT INTO `performance` VALUES (3056,1,1,NULL,'2006.05.24 AD at 10:39:53 CEST',1,NULL,NULL,'Java');
INSERT INTO `performance` VALUES (3057,3,3,NULL,NULL,2,NULL,NULL,'Java');
INSERT INTO `performance` VALUES (3058,1,1,NULL,NULL,1,NULL,NULL,'Java');
INSERT INTO `performance` VALUES (3059,1,1,NULL,NULL,1,NULL,NULL,'Java');


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
INSERT INTO `questionintestforstudent` VALUES (66,14,'q1011','0');
INSERT INTO `questionintestforstudent` VALUES (67,14,'q1012','1');
INSERT INTO `questionintestforstudent` VALUES (68,14,'q1013','0');
INSERT INTO `questionintestforstudent` VALUES (69,14,'q1015','0');
INSERT INTO `questionintestforstudent` VALUES (70,14,'q1014','0');
INSERT INTO `questionintestforstudent` VALUES (71,15,'q1016','1');
INSERT INTO `questionintestforstudent` VALUES (72,15,'q1018','0');
INSERT INTO `questionintestforstudent` VALUES (73,15,'q10110','1');
INSERT INTO `questionintestforstudent` VALUES (74,15,'q1017','0');
INSERT INTO `questionintestforstudent` VALUES (75,14,'q1011','0');
INSERT INTO `questionintestforstudent` VALUES (76,14,'q1012','1');
INSERT INTO `questionintestforstudent` VALUES (77,14,'q1013','0');
INSERT INTO `questionintestforstudent` VALUES (78,14,'q1015','0');
INSERT INTO `questionintestforstudent` VALUES (79,14,'q1014','0');
INSERT INTO `questionintestforstudent` VALUES (80,15,'q1016','1');
INSERT INTO `questionintestforstudent` VALUES (81,15,'q1018','0');
INSERT INTO `questionintestforstudent` VALUES (82,15,'q10110','1');
INSERT INTO `questionintestforstudent` VALUES (83,15,'q1017','0');
INSERT INTO `questionintestforstudent` VALUES (84,16,'q1016','0');
INSERT INTO `questionintestforstudent` VALUES (85,16,'q1019','0');
INSERT INTO `questionintestforstudent` VALUES (86,16,'q1018','0');
INSERT INTO `questionintestforstudent` VALUES (87,16,'q10110','0');
INSERT INTO `questionintestforstudent` VALUES (88,16,'q1017','0');
INSERT INTO `questionintestforstudent` VALUES (89,17,'q1021','1');
INSERT INTO `questionintestforstudent` VALUES (90,17,'q1023','0');
INSERT INTO `questionintestforstudent` VALUES (91,17,'q1024','1');
INSERT INTO `questionintestforstudent` VALUES (92,17,'q1025','0');
INSERT INTO `questionintestforstudent` VALUES (93,17,'q10210','1');
INSERT INTO `questionintestforstudent` VALUES (94,18,'q1031','0');
INSERT INTO `questionintestforstudent` VALUES (95,18,'q1037','1');
INSERT INTO `questionintestforstudent` VALUES (96,18,'q10312','1');
INSERT INTO `questionintestforstudent` VALUES (97,18,'q10315','1');
INSERT INTO `questionintestforstudent` VALUES (98,18,'q10318','1');


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
INSERT INTO `students` VALUES (3056,'a1','fdsadf','fdsa','a1','a1','','',1,'','http://',1,298804656);
INSERT INTO `students` VALUES (3057,'a2','a','a','a2','a2','','',1,'','http://',1,98307);
INSERT INTO `students` VALUES (3058,'a3','a3','a3','a3','a3','','',1,'','http://',1,673009765);
INSERT INTO `students` VALUES (3059,'a4','a4','a4','a4','a4','','',1,'','http://',1,673009797);


#
# Table structure for table studentsincourse
#

CREATE TABLE `studentsincourse` (
  `IDStudentInCourse` int(11) NOT NULL auto_increment,
  `studentID` int(11) NOT NULL default '0',
  `started` char(50) default NULL,
  `finished` char(50) default NULL,
  `numberOfPasses` tinyint(4) default NULL,
  `courseId` char(20) default NULL,
  PRIMARY KEY  (`IDStudentInCourse`),
  KEY `Ref_10` (`studentID`),
  KEY `courseId` (`courseId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Dumping data for table studentsincourse
#
INSERT INTO `studentsincourse` VALUES (3,3056,'2006.05.24 AD at 10:30:09 CEST','2006.05.24 AD at 10:30:09 CEST',1,'DP001');
INSERT INTO `studentsincourse` VALUES (4,3057,'2006.05.24 AD at 10:30:27 CEST','2006.05.24 AD at 10:30:27 CEST',1,'DP001');
INSERT INTO `studentsincourse` VALUES (5,3058,'2006.05.24 AD at 10:30:42 CEST','2006.05.24 AD at 10:30:42 CEST',1,'DP001');
INSERT INTO `studentsincourse` VALUES (6,3059,'2006.05.24 AD at 10:31:23 CEST','2006.05.24 AD at 10:31:23 CEST',1,'DP001');


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
INSERT INTO `teacher_has_groups` VALUES (54,98,298804656);
INSERT INTO `teacher_has_groups` VALUES (56,98,98307);
INSERT INTO `teacher_has_groups` VALUES (57,93674844,98307);
INSERT INTO `teacher_has_groups` VALUES (58,98,673009765);
INSERT INTO `teacher_has_groups` VALUES (59,98,673009797);


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
INSERT INTO `teacher_has_privilegies` VALUES (121,93674844,1);
INSERT INTO `teacher_has_privilegies` VALUES (122,93674844,2);
INSERT INTO `teacher_has_privilegies` VALUES (123,93674844,3);
INSERT INTO `teacher_has_privilegies` VALUES (124,93674844,4);
INSERT INTO `teacher_has_privilegies` VALUES (133,98,2);
INSERT INTO `teacher_has_privilegies` VALUES (134,98,3);
INSERT INTO `teacher_has_privilegies` VALUES (135,98,4);


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
INSERT INTO `teachers` VALUES (98,'b','b','b','b','b','','',1,'','http://',1,98);
INSERT INTO `teachers` VALUES (93674844,'bgfgb','bfg','bgfg','b','bgfb','','',1,'','http://',1,98);


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
INSERT INTO `testinconceptforstudent` VALUES (14,10,'1','2006.05.24 AD at 10:35:51 CEST','2006.05.24 AD at 10:35:58 CEST',1,0.5198114769,1,7,20,20,4);
INSERT INTO `testinconceptforstudent` VALUES (15,10,'2','2006.05.24 AD at 10:38:45 CEST','2006.05.24 AD at 10:38:50 CEST',1,1.75,1,5,20,50,10);
INSERT INTO `testinconceptforstudent` VALUES (16,10,'3','2006.05.24 AD at 10:39:07 CEST','2006.05.24 AD at 10:39:15 CEST',1,0.5198114769,1,8,20,0,0);
INSERT INTO `testinconceptforstudent` VALUES (17,11,'1','2006.05.24 AD at 10:39:31 CEST','2006.05.24 AD at 10:39:38 CEST',1,1.7693787449,1,7,20,60,12);
INSERT INTO `testinconceptforstudent` VALUES (18,12,'1','2006.05.24 AD at 10:39:45 CEST','2006.05.24 AD at 10:39:52 CEST',1,3.75,1,7,32,87.5,28);


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
INSERT INTO `unitsinconceptforstudent` VALUES (77,10,'u1011','2006.05.24 AD at 10:38:58 CEST','2006.05.24 AD at 10:38:58 CEST',3);
INSERT INTO `unitsinconceptforstudent` VALUES (78,10,'u1012','2006.05.24 AD at 10:39:00 CEST','2006.05.24 AD at 10:39:00 CEST',2);
INSERT INTO `unitsinconceptforstudent` VALUES (79,10,'u1013','2006.05.24 AD at 10:39:01 CEST','2006.05.24 AD at 10:39:01 CEST',3);
INSERT INTO `unitsinconceptforstudent` VALUES (80,10,'u1014','2006.05.24 AD at 10:39:04 CEST','2006.05.24 AD at 10:39:04 CEST',2);
INSERT INTO `unitsinconceptforstudent` VALUES (81,10,'u1015','2006.05.24 AD at 10:39:05 CEST','2006.05.24 AD at 10:39:05 CEST',3);
INSERT INTO `unitsinconceptforstudent` VALUES (82,10,'u1016','2006.05.24 AD at 10:39:05 CEST','2006.05.24 AD at 10:39:05 CEST',2);
INSERT INTO `unitsinconceptforstudent` VALUES (83,10,'u1017','2006.05.24 AD at 10:39:06 CEST','2006.05.24 AD at 10:39:06 CEST',3);
INSERT INTO `unitsinconceptforstudent` VALUES (84,11,'u1021','2006.05.24 AD at 10:39:20 CEST','2006.05.24 AD at 10:39:20 CEST',1);
INSERT INTO `unitsinconceptforstudent` VALUES (85,11,'u1022','2006.05.24 AD at 10:39:24 CEST','2006.05.24 AD at 10:39:24 CEST',1);
INSERT INTO `unitsinconceptforstudent` VALUES (86,11,'u1023','2006.05.24 AD at 10:39:26 CEST','2006.05.24 AD at 10:39:26 CEST',1);
INSERT INTO `unitsinconceptforstudent` VALUES (87,11,'u1024','2006.05.24 AD at 10:39:27 CEST','2006.05.24 AD at 10:39:27 CEST',1);
INSERT INTO `unitsinconceptforstudent` VALUES (88,11,'u1025','2006.05.24 AD at 10:39:27 CEST','2006.05.24 AD at 10:39:27 CEST',1);
INSERT INTO `unitsinconceptforstudent` VALUES (89,11,'u1026','2006.05.24 AD at 10:39:28 CEST','2006.05.24 AD at 10:39:28 CEST',1);
INSERT INTO `unitsinconceptforstudent` VALUES (90,11,'u1027','2006.05.24 AD at 10:39:29 CEST','2006.05.24 AD at 10:39:29 CEST',1);
INSERT INTO `unitsinconceptforstudent` VALUES (91,12,'u1031','2006.05.24 AD at 10:39:41 CEST','2006.05.24 AD at 10:39:41 CEST',1);
INSERT INTO `unitsinconceptforstudent` VALUES (92,12,'u1032','2006.05.24 AD at 10:39:43 CEST','2006.05.24 AD at 10:39:43 CEST',1);
INSERT INTO `unitsinconceptforstudent` VALUES (93,12,'u1033','2006.05.24 AD at 10:39:43 CEST','2006.05.24 AD at 10:39:43 CEST',1);
INSERT INTO `unitsinconceptforstudent` VALUES (94,12,'u1034','2006.05.24 AD at 10:39:44 CEST','2006.05.24 AD at 10:39:44 CEST',1);
INSERT INTO `unitsinconceptforstudent` VALUES (95,12,'u1035','2006.05.24 AD at 10:39:45 CEST','2006.05.24 AD at 10:39:45 CEST',1);


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

CREATE PROCEDURE `spInsertConceptInCourseForStudent`(IN studID INT, IN conceptID CHAR, IN duration INT, IN feedbackMessage CHAR, IN started CHAR, IN finished CHAR, IN numberOfPasses INT, IN degreeOfMastery DOUBLE, IN knowledgeLevel DOUBLE, IN experienceLevel CHAR, IN reasoningAbilityLevel CHAR)
BEGIN
  DECLARE idStudInCourse CHAR;
  SELECT IDStudentInCourse INTO idStudInCourse FROM studentsInCourse WHERE studentID=studID;
  INSERT INTO conceptsInCourseForStudent (IDStudentInCourse, conceptID,
  duration, feedbackMessage, started, finished,
  numberOfPasses, degreeOfMastery, knowledgeLevel,
  experienceLevel, reasoningAbilityLevel)
  VALUES (IDStudInCourse, conceptID,
  duration, feedbackMessage, started, finished,
  numberOfPasses, degreeOfMastery, knowledgeLevel,
  experienceLevel, reasoningAbilityLevel);
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

CREATE PROCEDURE `spInsertStudentInCourse`(IN studentID INTEGER, IN started CHAR, IN finished CHAR, IN numberOfPasses INTEGER, IN courseId CHAR)
BEGIN
  INSERT INTO studentsInCourse (studentID, started, finished, numberOfPasses,courseId)
  VALUES (studentID,  started, finished, numberOfPasses,courseId);
  
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

CREATE PROCEDURE `spUpdateConceptInCourseForStudent`(IN studID INT, IN concID CHAR, IN durat INT, IN feedbMessage CHAR, IN startedT CHAR, IN finishedT CHAR, IN numbOfPasses INT, IN degreeOfMast DOUBLE, IN knowledgeLev DOUBLE, IN experienceLev CHAR, IN reasoningAbilityLev CHAR)
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
  reasoningAbilityLevel=reasoningAbilityLev
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
  ADD FOREIGN KEY (`studentID`) REFERENCES `students` (`studentID`),
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
