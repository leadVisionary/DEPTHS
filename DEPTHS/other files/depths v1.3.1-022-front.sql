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
INSERT INTO `administrator_has_groups` VALUES (90,98,3104);
INSERT INTO `administrator_has_groups` VALUES (91,98,3136);


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
# Table structure for table answer
#

CREATE TABLE `answer` (
  `truth` tinyint(1) default NULL,
  `textOfAnswer` text,
  `questionId` char(11) default NULL,
  `ordNumb` int(11) default NULL,
  `NMID` int(11) NOT NULL auto_increment,
  PRIMARY KEY  (`NMID`),
  KEY `questinId` (`questionId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Dumping data for table answer
#
INSERT INTO `answer` VALUES (0,'Define an interface for creating an object, but let subclasses decidentifiere which class to instantiate.','q1011',1,1);
INSERT INTO `answer` VALUES (1,'It providentifiere an interface for creating families of related or dependent objects without specifying their concrete classes.','q1011',2,2);
INSERT INTO `answer` VALUES (0,'Separate the construction of a complex object from its representation so that the same construction process can create different representations.','q1011',3,3);
INSERT INTO `answer` VALUES (0,'The construction process must allow different representations for the objects that\'s constructed.','q1012',1,4);
INSERT INTO `answer` VALUES (1,'You want to providentifiere a class library of products, and you want to reveal just their interfaces, not their implementations.','q1012',2,5);
INSERT INTO `answer` VALUES (0,'Classes delegate responsibility to one of several helper subclasses, and you want to localize the knowledge of which helper subclass is the delegate.','q1012',3,6);
INSERT INTO `answer` VALUES (0,'Declares an interface for operations that create abstract product objects.','q1013',1,7);
INSERT INTO `answer` VALUES (0,'Implements the AbstractProduct interface.','q1013',2,8);
INSERT INTO `answer` VALUES (1,'Declares an interface for a type of product object.','q1013',3,9);
INSERT INTO `answer` VALUES (0,'Prototype, Composite, Singleton.','q1014',1,10);
INSERT INTO `answer` VALUES (0,'Factory Method, Adapter, Bridentifierge.','q1014',2,11);
INSERT INTO `answer` VALUES (1,'Factory Method, Prototype, Singleton.','q1014',3,12);
INSERT INTO `answer` VALUES (0,'They are often implemented with singleton methods, but they can also be implemented using Adapter.','q1015',1,13);
INSERT INTO `answer` VALUES (1,'They are often implemented with factory methods, but they can also be implemented using Prototype.','q1015',2,14);
INSERT INTO `answer` VALUES (0,'They are often implemented with factory methods, but they can also be implemented using Adapter.','q1015',3,15);
INSERT INTO `answer` VALUES (1,'Kit','q1016',1,16);
INSERT INTO `answer` VALUES (0,'Creator','q1016',2,17);
INSERT INTO `answer` VALUES (0,'Product','q1016',3,18);
INSERT INTO `answer` VALUES (0,'InterViews uses the \"Kit\" suffix to denote AbstractFactory classes.<br> ET++ extends the Abstract Factory pattern in that the WindowPort keeps a reference back to the Window.','q1017',1,19);
INSERT INTO `answer` VALUES (0,'InterViews uses the \"Kit\" suffix to denote AbstractFactory classes.<br> ET++ uses the Abstract Factory pattern to providentifiere a point-and-click interface to different line-oriented debuggers. ','q1017',2,20);
INSERT INTO `answer` VALUES (1,'InterViews uses the \"Kit\" suffix to denote AbstractFactory classes.<br> ET++ uses the Abstract Factory pattern to achieve portability across different window systems.','q1017',3,21);
INSERT INTO `answer` VALUES (0,'It isolates concrete classes.<br> It lets you vary a product\'s internal representation. .<br> It isolates code for construction and representation.','q1018',1,22);
INSERT INTO `answer` VALUES (0,'It gives you finer control over the construction process. .<br> It lets you vary a product\'s internal representation..<br>It promotes consistency among products. .<br> Supporting new kinds of products in difficult.','q1018',2,23);
INSERT INTO `answer` VALUES (1,'It isolates concrete classes.<br> It makes exchanging product families easy.<br> It promotes consistency among products.<br> Supporting new kind of products is difficult.','q1018',3,24);
INSERT INTO `answer` VALUES (1,'Separate the construction of a complex object from its representation so that the same construction process can create different representations. \n','q1019',1,25);
INSERT INTO `answer` VALUES (1,'To provide an interface for creating families of related or dependent objects without specifying their concrete classes.','q1019',2,26);
INSERT INTO `answer` VALUES (0,'Define an interface for creating an object, but let subclasses decide which class to instantiate. Factory Method lets a class defer instantiation to subclasses. \n','q1019',3,27);
INSERT INTO `answer` VALUES (1,'An application typically needs only one instance of a Concrete Factory per product family. ','q10110',1,28);
INSERT INTO `answer` VALUES (0,'An application typically needs two instances of a ConcreteFactory per product family.','q10110',2,29);
INSERT INTO `answer` VALUES (0,'An application typically needs more than two instances of a ConcreteFactory per product family.','q10110',3,30);
INSERT INTO `answer` VALUES (1,'answer 1\t','q10111',1,31);
INSERT INTO `answer` VALUES (0,'answer 2','q10111',2,32);
INSERT INTO `answer` VALUES (0,'answer 3','q10111',3,33);
INSERT INTO `answer` VALUES (0,'answer 4','q10111',4,34);
INSERT INTO `answer` VALUES (0,'answer 1','q10112',1,35);
INSERT INTO `answer` VALUES (1,'answer 2 t','q10112',2,36);
INSERT INTO `answer` VALUES (0,'answer 3','q10112',3,37);
INSERT INTO `answer` VALUES (0,'answer 4','q10112',4,38);
INSERT INTO `answer` VALUES (0,'a 1','q10113',1,39);
INSERT INTO `answer` VALUES (0,'a 2','q10113',2,40);
INSERT INTO `answer` VALUES (0,'a3','q10113',3,41);
INSERT INTO `answer` VALUES (1,'a4','q10113',4,42);
INSERT INTO `answer` VALUES (0,'a 1','q10114',1,43);
INSERT INTO `answer` VALUES (0,'a2','q10114',2,44);
INSERT INTO `answer` VALUES (1,'a3','q10114',3,45);
INSERT INTO `answer` VALUES (1,'a1t','q10115',1,46);
INSERT INTO `answer` VALUES (0,'a2','q10115',2,47);
INSERT INTO `answer` VALUES (0,'a3','q10115',3,48);
INSERT INTO `answer` VALUES (1,'a1t','q10116',1,49);
INSERT INTO `answer` VALUES (0,'a2','q10116',2,50);
INSERT INTO `answer` VALUES (0,'a3','q10116',3,51);
INSERT INTO `answer` VALUES (0,'a4','q10116',4,52);
INSERT INTO `answer` VALUES (0,'a1','q10117',1,53);
INSERT INTO `answer` VALUES (1,'a2','q10117',2,54);
INSERT INTO `answer` VALUES (0,'a3','q10117',3,55);
INSERT INTO `answer` VALUES (1,'a1t','q10118',1,56);
INSERT INTO `answer` VALUES (0,'a2','q10118',2,57);
INSERT INTO `answer` VALUES (0,'a3','q10118',3,58);
INSERT INTO `answer` VALUES (0,'a1','q10119',1,59);
INSERT INTO `answer` VALUES (0,'a2','q10119',2,60);
INSERT INTO `answer` VALUES (1,'a3','q10119',3,61);
INSERT INTO `answer` VALUES (1,'a1','q101110',1,62);
INSERT INTO `answer` VALUES (0,'a2','q101110',2,63);
INSERT INTO `answer` VALUES (0,'a3t','q101110',3,64);
INSERT INTO `answer` VALUES (1,'a1t','q101111',1,65);
INSERT INTO `answer` VALUES (0,'a2','q101111',2,66);
INSERT INTO `answer` VALUES (0,'a3','q101111',3,67);
INSERT INTO `answer` VALUES (0,'a4','q101111',4,68);
INSERT INTO `answer` VALUES (0,'a1','q101112',1,69);
INSERT INTO `answer` VALUES (1,'a2','q101112',2,70);
INSERT INTO `answer` VALUES (0,'a3','q101112',3,71);
INSERT INTO `answer` VALUES (1,'a1t','q101113',1,72);
INSERT INTO `answer` VALUES (0,'a2','q101113',2,73);
INSERT INTO `answer` VALUES (0,'a3','q101113',3,74);
INSERT INTO `answer` VALUES (1,'Answer 1 (true)','q1021',1,75);
INSERT INTO `answer` VALUES (0,'Answer 2','q1021',2,76);
INSERT INTO `answer` VALUES (0,'Answer 3','q1021',3,77);
INSERT INTO `answer` VALUES (0,'Under the construction','q1022',1,78);
INSERT INTO `answer` VALUES (0,'Under the construction','q1022',2,79);
INSERT INTO `answer` VALUES (1,'Under the construction','q1022',3,80);
INSERT INTO `answer` VALUES (1,'Under the construction','q1023',1,81);
INSERT INTO `answer` VALUES (0,'Under the construction','q1023',2,82);
INSERT INTO `answer` VALUES (0,'Under the construction','q1023',3,83);
INSERT INTO `answer` VALUES (1,'Under the construction','q1024',1,84);
INSERT INTO `answer` VALUES (0,'Under the construction','q1024',2,85);
INSERT INTO `answer` VALUES (0,'Under the construction','q1024',3,86);
INSERT INTO `answer` VALUES (1,'Under the construction\t','q1025',1,87);
INSERT INTO `answer` VALUES (0,'Under the construction','q1025',2,88);
INSERT INTO `answer` VALUES (0,'Under the construction','q1025',3,89);
INSERT INTO `answer` VALUES (1,'Under the construction','q1026',1,90);
INSERT INTO `answer` VALUES (0,'Under the construction','q1026',2,91);
INSERT INTO `answer` VALUES (0,'Under the construction','q1026',3,92);
INSERT INTO `answer` VALUES (1,'Under the construction','q1027',1,93);
INSERT INTO `answer` VALUES (0,'Under the construction','q1027',2,94);
INSERT INTO `answer` VALUES (0,'Under the construction','q1027',3,95);
INSERT INTO `answer` VALUES (1,'Under the construction','q1028',1,96);
INSERT INTO `answer` VALUES (0,'Under the construction','q1028',2,97);
INSERT INTO `answer` VALUES (0,'Under the construction','q1028',3,98);
INSERT INTO `answer` VALUES (1,'Under the construction','q1029',1,99);
INSERT INTO `answer` VALUES (0,'Under the construction','q1029',2,100);
INSERT INTO `answer` VALUES (0,'Under the construction','q1029',3,101);
INSERT INTO `answer` VALUES (1,'Under the construction','q10210',1,102);
INSERT INTO `answer` VALUES (0,'Under the construction','q10210',2,103);
INSERT INTO `answer` VALUES (0,'Under the construction','q10210',3,104);
INSERT INTO `answer` VALUES (1,'Under the construction','q10211',1,105);
INSERT INTO `answer` VALUES (0,'Under the construction','q10211',2,106);
INSERT INTO `answer` VALUES (0,'Under the construction','q10211',3,107);
INSERT INTO `answer` VALUES (1,'a1t','q10213',1,108);
INSERT INTO `answer` VALUES (0,'a2','q10213',2,109);
INSERT INTO `answer` VALUES (0,'a3','q10213',3,110);
INSERT INTO `answer` VALUES (0,'a1','q10212',1,111);
INSERT INTO `answer` VALUES (1,'a2t','q10212',2,112);
INSERT INTO `answer` VALUES (0,'a3','q10212',3,113);
INSERT INTO `answer` VALUES (0,'a1','q10214',1,114);
INSERT INTO `answer` VALUES (0,'a2','q10214',2,115);
INSERT INTO `answer` VALUES (0,'a3t','q10214',3,116);
INSERT INTO `answer` VALUES (0,'a4','q10214',4,117);
INSERT INTO `answer` VALUES (1,'a1','q10215',1,118);
INSERT INTO `answer` VALUES (0,'a2','q10215',2,119);
INSERT INTO `answer` VALUES (0,'a3t','q10215',3,120);
INSERT INTO `answer` VALUES (0,'a4','q10215',4,121);
INSERT INTO `answer` VALUES (1,'a1t','q10217',1,122);
INSERT INTO `answer` VALUES (0,'a2','q10217',2,123);
INSERT INTO `answer` VALUES (0,'a3','q10217',3,124);
INSERT INTO `answer` VALUES (0,'a1','q10218',1,125);
INSERT INTO `answer` VALUES (0,'a2','q10218',2,126);
INSERT INTO `answer` VALUES (0,'a3','q10218',3,127);
INSERT INTO `answer` VALUES (1,'a4t','q10218',4,128);
INSERT INTO `answer` VALUES (1,'a1t','q10216',1,129);
INSERT INTO `answer` VALUES (0,'a2','q10216',2,130);
INSERT INTO `answer` VALUES (0,'a3','q10216',3,131);
INSERT INTO `answer` VALUES (0,'a1','q10219',1,132);
INSERT INTO `answer` VALUES (1,'a2t','q10219',2,133);
INSERT INTO `answer` VALUES (0,'a3','q10219',3,134);
INSERT INTO `answer` VALUES (1,'a1t','q10220',1,135);
INSERT INTO `answer` VALUES (0,'a2','q10220',2,136);
INSERT INTO `answer` VALUES (0,'a3','q10220',3,137);
INSERT INTO `answer` VALUES (0,'a1','q10221',1,138);
INSERT INTO `answer` VALUES (0,'a2','q10221',2,139);
INSERT INTO `answer` VALUES (1,'a3t','q10221',3,140);
INSERT INTO `answer` VALUES (1,'a1t','q10222',1,141);
INSERT INTO `answer` VALUES (0,'a2','q10222',2,142);
INSERT INTO `answer` VALUES (0,'a3','q10222',3,143);
INSERT INTO `answer` VALUES (0,'a4','q10222',4,144);
INSERT INTO `answer` VALUES (1,'a1t','q10223',1,145);
INSERT INTO `answer` VALUES (0,'a2','q10223',2,146);
INSERT INTO `answer` VALUES (0,'a3','q10223',3,147);
INSERT INTO `answer` VALUES (0,'a1','q10224',1,148);
INSERT INTO `answer` VALUES (0,'a2','q10224',2,149);
INSERT INTO `answer` VALUES (1,'a3t','q10224',3,150);
INSERT INTO `answer` VALUES (1,'a1t','q10225',1,151);
INSERT INTO `answer` VALUES (0,'a2','q10225',2,152);
INSERT INTO `answer` VALUES (0,'a3','q10225',3,153);
INSERT INTO `answer` VALUES (0,'a4','q10225',4,154);
INSERT INTO `answer` VALUES (0,'a1','q1031',1,155);
INSERT INTO `answer` VALUES (0,'a2','q1031',2,156);
INSERT INTO `answer` VALUES (1,'a3','q1031',3,157);
INSERT INTO `answer` VALUES (1,'Under the construction','q1032',1,158);
INSERT INTO `answer` VALUES (0,'Under the construction','q1032',2,159);
INSERT INTO `answer` VALUES (0,'Under the construction','q1032',3,160);
INSERT INTO `answer` VALUES (1,'Under the construction','q1033',1,161);
INSERT INTO `answer` VALUES (0,'Under the construction','q1033',2,162);
INSERT INTO `answer` VALUES (0,'Under the construction','q1033',3,163);
INSERT INTO `answer` VALUES (1,'Under the construction','q1034',1,164);
INSERT INTO `answer` VALUES (0,'Under the construction','q1034',2,165);
INSERT INTO `answer` VALUES (0,'Under the construction','q1034',3,166);
INSERT INTO `answer` VALUES (1,'Under the construction','q1035',1,167);
INSERT INTO `answer` VALUES (0,'Under the construction','q1035',2,168);
INSERT INTO `answer` VALUES (0,'Under the construction','q1035',3,169);
INSERT INTO `answer` VALUES (1,'Under the construction','q1036',1,170);
INSERT INTO `answer` VALUES (0,'Under the construction','q1036',2,171);
INSERT INTO `answer` VALUES (0,'Under the construction','q1036',3,172);
INSERT INTO `answer` VALUES (1,'a1t','q1037',1,173);
INSERT INTO `answer` VALUES (0,'a2','q1037',2,174);
INSERT INTO `answer` VALUES (0,'a3','q1037',3,175);
INSERT INTO `answer` VALUES (0,'a1','q1038',1,176);
INSERT INTO `answer` VALUES (1,'a2t','q1038',2,177);
INSERT INTO `answer` VALUES (0,'a3','q1038',3,178);
INSERT INTO `answer` VALUES (0,'a4','q1038',4,179);
INSERT INTO `answer` VALUES (0,'a1','q10310',1,180);
INSERT INTO `answer` VALUES (0,'a2','q10310',2,181);
INSERT INTO `answer` VALUES (1,'a3','q10310',3,182);
INSERT INTO `answer` VALUES (1,'a1t','q10311',1,183);
INSERT INTO `answer` VALUES (0,'a2','q10311',2,184);
INSERT INTO `answer` VALUES (0,'a3','q10311',3,185);
INSERT INTO `answer` VALUES (0,'a1','q10312',1,186);
INSERT INTO `answer` VALUES (0,'a2','q10312',2,187);
INSERT INTO `answer` VALUES (1,'a3t','q10312',3,188);
INSERT INTO `answer` VALUES (1,'a1t','q1039',1,189);
INSERT INTO `answer` VALUES (0,'a2','q1039',2,190);
INSERT INTO `answer` VALUES (0,'a3','q1039',3,191);
INSERT INTO `answer` VALUES (1,'a1t','q10313',1,192);
INSERT INTO `answer` VALUES (0,'a2','q10313',2,193);
INSERT INTO `answer` VALUES (0,'a3','q10313',3,194);
INSERT INTO `answer` VALUES (0,'a1','q10314',1,195);
INSERT INTO `answer` VALUES (1,'a2t','q10314',2,196);
INSERT INTO `answer` VALUES (0,'a3','q10314',3,197);
INSERT INTO `answer` VALUES (0,'a4','q10314',4,198);
INSERT INTO `answer` VALUES (0,'a1','q10315',1,199);
INSERT INTO `answer` VALUES (1,'a2t','q10315',2,200);
INSERT INTO `answer` VALUES (0,'a3','q10315',3,201);
INSERT INTO `answer` VALUES (1,'a1t','q10316',1,202);
INSERT INTO `answer` VALUES (0,'a2','q10316',2,203);
INSERT INTO `answer` VALUES (0,'a3','q10316',3,204);
INSERT INTO `answer` VALUES (0,'a4','q10316',4,205);
INSERT INTO `answer` VALUES (0,'a1','q10317',1,206);
INSERT INTO `answer` VALUES (0,'a2','q10317',2,207);
INSERT INTO `answer` VALUES (1,'a3','q10317',3,208);
INSERT INTO `answer` VALUES (1,'a1t','q10318',1,209);
INSERT INTO `answer` VALUES (0,'a2','q10318',2,210);
INSERT INTO `answer` VALUES (0,'a3','q10318',3,211);
INSERT INTO `answer` VALUES (0,'a1','q10319',1,212);
INSERT INTO `answer` VALUES (0,'a2','q10319',2,213);
INSERT INTO `answer` VALUES (1,'a3t','q10319',3,214);
INSERT INTO `answer` VALUES (0,'a1','q1041',1,215);
INSERT INTO `answer` VALUES (1,'a2','q1041',2,216);
INSERT INTO `answer` VALUES (0,'a3','q1041',3,217);
INSERT INTO `answer` VALUES (0,'a1','q1051',1,218);
INSERT INTO `answer` VALUES (1,'a2','q1051',2,219);
INSERT INTO `answer` VALUES (0,'a3','q1051',3,220);
INSERT INTO `answer` VALUES (1,'a1','q2011',1,221);
INSERT INTO `answer` VALUES (0,'a2','q2011',2,222);
INSERT INTO `answer` VALUES (0,'a3','q2011',3,223);
INSERT INTO `answer` VALUES (0,'a1','q2021',1,224);
INSERT INTO `answer` VALUES (1,'a2','q2021',2,225);
INSERT INTO `answer` VALUES (0,'a3','q2021',3,226);
INSERT INTO `answer` VALUES (0,'a1','q2031',1,227);
INSERT INTO `answer` VALUES (1,'a2','q2031',2,228);
INSERT INTO `answer` VALUES (0,'a3','q2031',3,229);
INSERT INTO `answer` VALUES (0,'a1','q2041',1,230);
INSERT INTO `answer` VALUES (0,'a2','q2041',2,231);
INSERT INTO `answer` VALUES (1,'a3','q2041',3,232);
INSERT INTO `answer` VALUES (0,'a1','q2051',1,233);
INSERT INTO `answer` VALUES (0,'a2','q2051',2,234);
INSERT INTO `answer` VALUES (1,'a3','q2051',3,235);
INSERT INTO `answer` VALUES (0,'a1','q2061',1,236);
INSERT INTO `answer` VALUES (0,'a2','q2061',2,237);
INSERT INTO `answer` VALUES (1,'a3','q2061',3,238);
INSERT INTO `answer` VALUES (0,'a1','q2071',1,239);
INSERT INTO `answer` VALUES (0,'a2','q2071',2,240);
INSERT INTO `answer` VALUES (1,'a3','q2071',3,241);
INSERT INTO `answer` VALUES (0,'a1','q3011',1,242);
INSERT INTO `answer` VALUES (0,'a2','q3011',2,243);
INSERT INTO `answer` VALUES (1,'a3','q3011',3,244);
INSERT INTO `answer` VALUES (0,'a1','q3021',1,245);
INSERT INTO `answer` VALUES (0,'a2','q3021',2,246);
INSERT INTO `answer` VALUES (1,'a3','q3021',3,247);
INSERT INTO `answer` VALUES (1,'a1','q3031',1,248);
INSERT INTO `answer` VALUES (0,'a2','q3031',2,249);
INSERT INTO `answer` VALUES (0,'a3','q3031',3,250);
INSERT INTO `answer` VALUES (0,'a1','q3041',1,251);
INSERT INTO `answer` VALUES (0,'a2','q3041',2,252);
INSERT INTO `answer` VALUES (1,'a3','q3041',3,253);
INSERT INTO `answer` VALUES (0,'a1','q3051',1,254);
INSERT INTO `answer` VALUES (0,'a2','q3051',2,255);
INSERT INTO `answer` VALUES (1,'a3','q3051',3,256);
INSERT INTO `answer` VALUES (0,'a1','q3061',1,257);
INSERT INTO `answer` VALUES (1,'a2','q3061',2,258);
INSERT INTO `answer` VALUES (0,'a3','q3061',3,259);
INSERT INTO `answer` VALUES (0,'a1','q3071',1,260);
INSERT INTO `answer` VALUES (1,'a2','q3071',2,261);
INSERT INTO `answer` VALUES (0,'a3','q3071',3,262);
INSERT INTO `answer` VALUES (0,'a1','q3081',1,263);
INSERT INTO `answer` VALUES (0,'a2','q3081',2,264);
INSERT INTO `answer` VALUES (1,'a3','q3081',3,265);
INSERT INTO `answer` VALUES (1,'a1','q3091',1,266);
INSERT INTO `answer` VALUES (0,'a2','q3091',2,267);
INSERT INTO `answer` VALUES (0,'a3','q3091',3,268);
INSERT INTO `answer` VALUES (0,'a1','q3101',1,269);
INSERT INTO `answer` VALUES (0,'a2','q3101',2,270);
INSERT INTO `answer` VALUES (1,'a3','q3101',3,271);
INSERT INTO `answer` VALUES (0,'a1','q3111',1,272);
INSERT INTO `answer` VALUES (0,'a2','q3111',2,273);
INSERT INTO `answer` VALUES (1,'a3','q3111',3,274);


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
  `courseID` char(11) default NULL,
  `type` char(11) default NULL,
  `minKnowledgeLevel` int(11) default NULL,
  `ordinalNumber` tinyint(4) default NULL,
  PRIMARY KEY  (`conceptID`),
  KEY `Ref_07` (`courseID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Dumping data for table concept
#
INSERT INTO `concept` VALUES ('c101','Abstract Factory','DP001','Creational',1,1);
INSERT INTO `concept` VALUES ('c102','Builder','DP001','Creational',1,2);
INSERT INTO `concept` VALUES ('c103','Factory Method','DP001','Creational',1,3);
INSERT INTO `concept` VALUES ('c104','Prototype','DP001','Creational',3,4);
INSERT INTO `concept` VALUES ('c105','Singleton','DP001','Creational',1,5);
INSERT INTO `concept` VALUES ('c201','Adapter','DP001','Structural',1,6);
INSERT INTO `concept` VALUES ('c202','Bridge','DP001','Structural',1,7);
INSERT INTO `concept` VALUES ('c203','Composite','DP001','Structural',4,8);
INSERT INTO `concept` VALUES ('c204','Decorator','DP001','Structural',1,9);
INSERT INTO `concept` VALUES ('c205','Facade','DP001','Structural',1,10);
INSERT INTO `concept` VALUES ('c206','Flyweight','DP001','Structural',2,11);
INSERT INTO `concept` VALUES ('c207','Proxy','DP001','Structural',4,12);
INSERT INTO `concept` VALUES ('c301','Chain of Responsibility','DP001','Behavioral',1,13);
INSERT INTO `concept` VALUES ('c302','Command','DP001','Behavioral',2,14);
INSERT INTO `concept` VALUES ('c303','Interpreter','DP001','Behavioral',3,15);
INSERT INTO `concept` VALUES ('c304','Iterator','DP001','Behavioral',4,16);
INSERT INTO `concept` VALUES ('c305','Mediator','DP001','Behavioral',3,17);
INSERT INTO `concept` VALUES ('c306','Memento','DP001','Behavioral',4,18);
INSERT INTO `concept` VALUES ('c307','Observer','DP001','Behavioral',3,19);
INSERT INTO `concept` VALUES ('c308','State','DP001','Behavioral',2,20);
INSERT INTO `concept` VALUES ('c309','Strategy','DP001','Behavioral',1,21);
INSERT INTO `concept` VALUES ('c310','Template Method','DP001','Behavioral',1,22);
INSERT INTO `concept` VALUES ('c311','Visitor','DP001','Behavioral',2,23);


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
INSERT INTO `conceptsincourseforstudent` VALUES (61,5,'c101',120,NULL,'2006.06.07 AD at 05:06:02 CEST','2006.06.07 AD at 05:08:02 CEST',1,4.0449685795,4.5224842897,'el','ral','DP001');
INSERT INTO `conceptsincourseforstudent` VALUES (62,5,'c101',37,NULL,'2006.06.07 AD at 05:11:16 CEST','2006.06.07 AD at 05:11:53 CEST',1,4.0449685795,4.5224842897,'el','ral','DP001');
INSERT INTO `conceptsincourseforstudent` VALUES (63,5,'c101',42,NULL,'2006.06.07 AD at 05:16:30 CEST','2006.06.07 AD at 05:17:12 CEST',1,5.6144963739,5.307248187,'el','ral','DP001');
INSERT INTO `conceptsincourseforstudent` VALUES (64,5,'c102',32,NULL,'2006.06.07 AD at 05:17:17 CEST','2006.06.07 AD at 05:17:49 CEST',1,4.3390625959,4.9845196566,'el','ral','DP001');
INSERT INTO `conceptsincourseforstudent` VALUES (65,5,'c103',22,NULL,'2006.06.07 AD at 05:17:50 CEST','2006.06.07 AD at 05:18:12 CEST',1,4.75,4.9258897425,'el','ral','DP001');
INSERT INTO `conceptsincourseforstudent` VALUES (66,5,'c104',5,NULL,'2006.06.07 AD at 05:18:13 CEST','2006.06.07 AD at 05:18:18 CEST',1,4.4309331338,4.8268984207,'el','ral','DP001');
INSERT INTO `conceptsincourseforstudent` VALUES (67,5,'c105',11,NULL,'2006.06.07 AD at 05:18:19 CEST','2006.06.07 AD at 05:18:30 CEST',1,0.5198114769,4.1090505967,'el','ral','DP001');


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
# Table structure for table fragment
#

CREATE TABLE `fragment` (
  `detailLevel` tinyint(4) default NULL,
  `content` text,
  `type` char(20) default NULL,
  `fragmentID` char(11) NOT NULL,
  `title` text,
  `difficultyLevel` tinyint(4) default NULL,
  `unitId` char(20) default NULL,
  PRIMARY KEY  (`fragmentID`),
  KEY `unitId` (`unitId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Dumping data for table fragment
#
INSERT INTO `fragment` VALUES (1,'Provide an interface for creating families of related or dependent objects without specifying their concrete classes.','any','f10111','Intent',1,'u1011');
INSERT INTO `fragment` VALUES (2,'a system should be configured with one of multiple families of products. ','any','f101110','Applicability',1,'u1011');
INSERT INTO `fragment` VALUES (2,'a family of related product objects is designed to be used together, and you need to enforce this constraint. ','any','f101111','Applicability',1,'u1011');
INSERT INTO `fragment` VALUES (2,'you want to provide a class library of products, and you want to reveal just their interfaces, not their implementations. \n','any','f101112','Applicability',1,'u1011');
INSERT INTO `fragment` VALUES (1,'Kit','any','f10112','Also Known As',1,'u1011');
INSERT INTO `fragment` VALUES (1,'Consider a user interface toolkit that supports multiple look-and-feel standards, such as Motif and Presentation Manager. Different look-and-feels define different appearances and behaviors for user interface \"widgets\" like scroll bars, windows, and buttons. To be portable across look-and-feel standards, an application should not hard-code its widgets for a particular look and feel. Instantiating look-and-feel-specific classes of widgets throughout the application makes it hard to change the look and feel later.\n\n','any','f10113','Motivation',1,'u1011');
INSERT INTO `fragment` VALUES (1,'We can solve this problem by defining an abstract WidgetFactory class that declares an interface for creating each basic kind of widget. There\'s also an abstract class for each kind of widget, and concrete subclasses implement widgets for specific look-and-feel standards. WidgetFactory\'s interface has an operation that returns a new widget object for each abstract widget class. Clients call these operations to obtain widget instances, but clients aren\'t aware of the concrete classes they\'re using. Thus clients stay independent of the prevailing look and feel.\n\n','any','f10114','Motivation',1,'u1011');
INSERT INTO `fragment` VALUES (2,'AbstractFactory_01','any','f10115','Motivation',1,'u1011');
INSERT INTO `fragment` VALUES (3,'There is a concrete subclass of WidgetFactory for each look-and-feel standard. Each subclass implements the operations to create the appropriate widget for the look and feel. For example, the CreateScrollBar operation on the MotifWidgetFactory instantiates and returns a Motif scroll bar, while the corresponding operation on the PMWidgetFactory returns a scroll bar for Presentation Manager. Clients create widgets solely through the WidgetFactory interface and have no knowledge of the classes that implement widgets for a particular look and feel. In other words, clients only have to commit to an interface defined by an abstract class, not a particular concrete class.\n\n','any','f10116','Motivation',1,'u1011');
INSERT INTO `fragment` VALUES (3,'A WidgetFactory also enforces dependencies between the concrete widget classes. A Motif scroll bar should be used with a Motif button and a Motif text editor, and that constraint is enforced automatically as a consequence of using a MotifWidgetFactory.\n\n','any','f10117','Motivation',1,'u1011');
INSERT INTO `fragment` VALUES (1,'Use the Abstract Factory pattern when','any','f10118','Applicability',1,'u1011');
INSERT INTO `fragment` VALUES (1,'a system should be independent of how its products are created, composed, and represented. ','any','f10119','Applicability',1,'u1011');
INSERT INTO `fragment` VALUES (1,'AbstractFactory_02','any','f10121','Structure',1,'u1012');
INSERT INTO `fragment` VALUES (1,' ','any','f10131','Participants',1,'u1013');
INSERT INTO `fragment` VALUES (2,'implements the AbstractProduct interface. ','any','f101310','Participants',1,'u1013');
INSERT INTO `fragment` VALUES (1,'Client ','any','f101311','Participants',1,'u1013');
INSERT INTO `fragment` VALUES (2,'uses only interfaces declared by AbstractFactory and AbstractProduct classes. \n','any','f101312','Participants',1,'u1013');
INSERT INTO `fragment` VALUES (1,' ','any','f101313','Collaborations',1,'u1013');
INSERT INTO `fragment` VALUES (1,'Normally a single instance of a ConcreteFactory class is created at run-time. This concrete factory creates product objects having a particular implementation. To create different product objects, clients should use a different concrete factory. ','any','f101314','Collaborations',1,'u1013');
INSERT INTO `fragment` VALUES (1,'AbstractFactory defers creation of product objects to its ConcreteFactory subclass. \n','any','f101315','Collaborations',1,'u1013');
INSERT INTO `fragment` VALUES (1,'AbstractFactory (WidgetFactory) ','any','f10132','Participants',1,'u1013');
INSERT INTO `fragment` VALUES (2,'declares an interface for operations that create abstract product objects. \n','any','f10133','Participants',1,'u1013');
INSERT INTO `fragment` VALUES (1,'ConcreteFactory (MotifWidgetFactory, PMWidgetFactory) ','any','f10134','Participants',1,'u1013');
INSERT INTO `fragment` VALUES (2,'implements the operations to create concrete product objects. \n','any','f10135','Participants',1,'u1013');
INSERT INTO `fragment` VALUES (1,'AbstractProduct (Window, ScrollBar) ','any','f10136','Participants',1,'u1013');
INSERT INTO `fragment` VALUES (2,'declares an interface for a type of product object. \n','any','f10137','Participants',1,'u1013');
INSERT INTO `fragment` VALUES (1,'ConcreteProduct (MotifWindow, MotifScrollBar) ','any','f10138','Participants',1,'u1013');
INSERT INTO `fragment` VALUES (2,'defines a product object to be created by the corresponding concrete factory. ','any','f10139','Participants',1,'u1013');
INSERT INTO `fragment` VALUES (1,'The Abstract Factory pattern has the following benefits and liabilities:\n\n','any','f10141','Consequences',1,'u1014');
INSERT INTO `fragment` VALUES (1,'1. It isolates concrete classes. The Abstract Factory pattern helps you control the classes of objects that an application creates. Because a factory encapsulates the responsibility and the process of creating product objects, it isolates clients from implementation classes. Clients manipulate instances through their abstract interfaces. Product class names are isolated in the implementation of the concrete factory; they do not appear in client code. ','any','f10142','Consequences',1,'u1014');
INSERT INTO `fragment` VALUES (1,'2. It makes exchanging product families easy. The class of a concrete factory appears only once in an application?that is, where it\'s instantiated. This makes it easy to change the concrete factory an application uses. It can use different product configurations simply by changing the concrete factory. Because an abstract factory creates a complete family of products, the whole product family changes at once. In our user interface example, we can switch from Motif widgets to Presentation Manager widgets simply by switching the corresponding factory objects and recreating the interface. ','any','f10143','Consequences',1,'u1014');
INSERT INTO `fragment` VALUES (1,'3. It promotes consistency among products. When product objects in a family are designed to work together, it\'s important that an application use objects from only one family at a time. AbstractFactory makes this easy to enforce. ','any','f10144','Consequences',1,'u1014');
INSERT INTO `fragment` VALUES (1,'4. Supporting new kinds of products is difficult. Extending abstract factories to produce new kinds of Products isn\'t easy. That\'s because the AbstractFactory interface fixes the set of products that can be created. Supporting new kinds of products requires extending the factory interface, which involves changing the AbstractFactory class and all of its subclasses. We discuss one solution to this problem in the Implementation section. \n','any','f10145','Consequences',1,'u1014');
INSERT INTO `fragment` VALUES (1,'Here are some useful techniques for implementing the Abstract Factory pattern.','any','f10151','Implementation',1,'u1015');
INSERT INTO `fragment` VALUES (3,'aFactory addPart: aPrototype named: #ACMEWidget\n','any','f101510','Implementation',1,'u1015');
INSERT INTO `fragment` VALUES (3,'A variation on the Prototype-based approach is possible in languages that treat classes as first-class objects (Smalltalk and Objective C, for example). You can think of a class in these languages as a degenerate factory that creates only one kind of product. You can store classes inside a concrete factory that create the various concrete products in variables, much like prototypes. These classes create new instances on behalf of the concrete factory. You define a new factory by initializing an instance of a concrete factory with classes of products rather than by subclassing. This approach takes advantage of language characteristics, whereas the pure Prototype-based approach is language-independent.','any','f101511','Implementation',1,'u1015');
INSERT INTO `fragment` VALUES (3,'Like the Prototype-based factory in Smalltalk just discussed, the class-based version will have a single instance variable partCatalog, which is a dictionary whose key is the name of the part. Instead of storing prototypes to be cloned, partCatalog stores the classes of the products. The method make: now looks like this:\n\n','any','f101512','Implementation',1,'u1015');
INSERT INTO `fragment` VALUES (3,'make: partName <br>  ^ (partCatalog at: partName) new\n\n','any','f101513','Implementation',1,'u1015');
INSERT INTO `fragment` VALUES (1,'3. Defining extensible factories. AbstractFactory usually defines a different operation for each kind of product it can produce. The kinds of products are encoded in the operation signatures. Adding a new kind of product requires changing the AbstractFactory interface and all the classes that depend on it. ','any','f101514','Implementation',1,'u1015');
INSERT INTO `fragment` VALUES (2,'A more flexible but less safe design is to add a parameter to operations that create objects. This parameter specifies the kind of object to be created. It could be a class identifier, an integer, a string, or anything else that identifies the kind of product. In fact with this approach, AbstractFactory only needs a single \"Make\" operation with a parameter indicating the kind of object to create. This is the technique used in the Prototype- and the class-based abstract factories discussed earlier.\n\n','any','f101515','Implementation',1,'u1015');
INSERT INTO `fragment` VALUES (3,'This variation is easier to use in a dynamically typed language like Smalltalk than in a statically typed language like C++. You can use it in C++ only when all objects have the same abstract base class or when the product objects can be safely coerced to the correct type by the client that requested them. The implementation section of Factory Method (107) shows how to implement such parameterized operations in C++.\n\n','any','f101516','Implementation',1,'u1015');
INSERT INTO `fragment` VALUES (3,'But even when no coercion is needed, an inherent problem remains: All products are returned to the client with the same abstract interface as given by the return type. The client will not be able to differentiate or make safe assumptions about the class of a product. If clients need to perform subclass-specific operations, they won\'t be accessible through the abstract interface. Although the client could perform a downcast (e.g., with dynamic_cast in C++), that\'s not always feasible or safe, because the downcast can fail. This is the classic trade-off for a highly flexible and extensible interface.\n\n','any','f101517','Implementation',1,'u1015');
INSERT INTO `fragment` VALUES (1,'1. Factories as singletons. An application typically needs only one instance of a ConcreteFactory per product family. So it\'s usually best implemented as a Singleton (127). ','any','f10152','Implementation',1,'u1015');
INSERT INTO `fragment` VALUES (1,'2. Creating the products. AbstractFactory only declares an interface for creating products. It\'s up to ConcreteProduct subclasses to actually create them. The most common way to do this is to define a factory method (see Factory Method (107)) for each product. A concrete factory will specify its products by overriding the factory method for each. While this implementation is simple, it requires a new concrete factory subclass for each product family, even if the product families differ only slightly. ','any','f10153','Implementation',1,'u1015');
INSERT INTO `fragment` VALUES (2,'If many product families are possible, the concrete factory can be implemented using the Prototype (117) pattern. The concrete factory is initialized with a prototypical instance of each product in the family, and it creates a new product by cloning its prototype. The Prototype-based approach eliminates the need for a new concrete factory class for each new product family.\n\n','any','f10154','Implementation',1,'u1015');
INSERT INTO `fragment` VALUES (3,'Here\'s a way to implement a Prototype-based factory in Smalltalk. The concrete factory stores the prototypes to be cloned in a dictionary called partCatalog. The method make: retrieves the prototype and clones it:\n\n','any','f10155','Implementation',1,'u1015');
INSERT INTO `fragment` VALUES (3,'make: partName <br>   ^ (partCatalog at: partName) copy\n','any','f10156','Implementation',1,'u1015');
INSERT INTO `fragment` VALUES (3,'The concrete factory has a method for adding parts to the catalog.\n\n','any','f10157','Implementation',1,'u1015');
INSERT INTO `fragment` VALUES (3,'addPart: partTemplate named: partName <br>   partCatalog at: partName put: partTemplate\n','any','f10158','Implementation',1,'u1015');
INSERT INTO `fragment` VALUES (3,'Prototypes are added to the factory by identifying them with a symbol:\n\n','any','f10159','Implementation',1,'u1015');
INSERT INTO `fragment` VALUES (1,'We\'ll apply the Abstract Factory pattern to creating the mazes we discussed at the beginning of this chapter.\n\n','any','f10161','Sample Code',1,'u1016');
INSERT INTO `fragment` VALUES (1,'Class MazeFactory can create components of mazes. It builds rooms, walls, and doors between rooms. It might be used by a program that reads plans for mazes from a file and builds the corresponding maze. Or it might be used by a program that builds mazes randomly. Programs that build mazes take a MazeFactory as an argument so that the programmer can specify the classes of rooms, walls, and doors to construct.\n\n','any','f10162','Sample Code',1,'u1016');
INSERT INTO `fragment` VALUES (2,'class MazeFactory { <br> public: <br>  MazeFactory(); \n<br> virtual Maze* MakeMaze() const <br>   { return new Maze; }\n<br>virtual Wall* MakeWall() const\n<br> { return new Wall; }\n<br> virtual Room* MakeRoom(int n) const\n<br>  { return new Room(n); }\n<br> virtual Door* MakeDoor(Room* r1, Room* r2) const\n<br>  { return new Door(r1, r2); }\n\n\n\n','any','f10163','Sample Code',1,'u1016');
INSERT INTO `fragment` VALUES (2,'Recall that the member function CreateMaze (page 84) builds a small maze consisting of two rooms with a door between them. CreateMaze hard-codes the class names, making it difficult to create mazes with different components.\n\n','any','f10164','Sample Code',1,'u1016');
INSERT INTO `fragment` VALUES (2,'Here\'s a version of CreateMaze that remedies that shortcoming by taking a MazeFactory as a parameter:\n\n','any','f10165','Sample Code',1,'u1016');
INSERT INTO `fragment` VALUES (2,'Maze* MazeGame::CreateMaze (MazeFactory factory) {\n<br>         Maze* aMaze = factory.MakeMaze();\n<br>         Room* r1 = factory.MakeRoom(1);\n<br>       Room* r2 = factory.MakeRoom(2);\n<br>        Door* aDoor = factory.MakeDoor(r1, r2);\n<br>\n<br>       aMaze->AddRoom(r1);\n<br>         aMaze->AddRoom(r2);\n<br>\n<br>        r1->SetSide(North, factory.MakeWall());\n<br>        r1->SetSide(East, aDoor);\n<br>        r1->SetSide(South, factory.MakeWall());\n<br>         r1->SetSide(West, factory.MakeWall());\n<br>\n<br>        r2->SetSide(North, factory.MakeWall());\n<br>         r2->SetSide(East, factory.MakeWall());\n<br>         r2->SetSide(South, factory.MakeWall());\n<br>         r2->SetSide(West, aDoor);\n<br>\n<br>        return aMaze;\n    }\n','any','f10166','Sample Code',1,'u1016');
INSERT INTO `fragment` VALUES (1,'We can create EnchantedMazeFactory, a factory for enchanted mazes, by subclassing MazeFactory. EnchantedMazeFactory will override different member functions and return different subclasses of Room, Wall, etc.\n\n','any','f10167','Sample Code',1,'u1016');
INSERT INTO `fragment` VALUES (2,' class EnchantedMazeFactory : public MazeFactory {\n<br>    public:\n<br>     EnchantedMazeFactory();\n<br>\n<br>         virtual Room* MakeRoom(int n)  const\n<br>                { return new EnchantedRoom(n, CastSpell()); }\n<br>\n<br>        virtual Door* MakeDoor(Room* r1, Room* r2)  const\n<br>        { return new DoorNeedingSpell(r1, r2); }\n<br>  \n<br>    protected:\n<br>      Spell* CastSpell() const;\n<br>    };\n','any','f10168','Sample Code',1,'u1016');
INSERT INTO `fragment` VALUES (1,'InterViews uses the \"Kit\" suffix [Lin92] to denote AbstractFactory classes. It defines WidgetKit and DialogKit abstract factories for generating look-and-feel-specific user interface objects. InterViews also includes a LayoutKit that generates different composition objects depending on the layout desired. For example, a layout that is conceptually horizontal may require different composition objects depending on the document\'s orientation (portrait or landscape).\n\n','any','f10171','Known Uses',1,'u1017');
INSERT INTO `fragment` VALUES (3,'ET++ [WGM88] uses the Abstract Factory pattern to achieve portability across different window systems (X Windows and SunView, for example). The WindowSystem abstract base class defines the interface for creating objects that represent window system resources (MakeWindow, MakeFont, MakeColor, for example). Concrete subclasses implement the interfaces for a specific window system. At run-time, ET++ creates an instance of a concrete WindowSystem subclass that creates concrete system resource objects.\n\n','any','f10172','Known Uses',1,'u1017');
INSERT INTO `fragment` VALUES (1,'AbstractFactory classes are often implemented with factory methods (Factory Method (107)), but they can also be implemented using Prototype (117).\n\n','any','f10173','Related Patterns',1,'u1017');
INSERT INTO `fragment` VALUES (1,'A concrete factory is often a singleton (Singleton (127)). ','any','f10174','Related Patterns',1,'u1017');
INSERT INTO `fragment` VALUES (1,' Builder\n','any','f10175','Related Patterns',1,'u1017');
INSERT INTO `fragment` VALUES (1,' Creational Patterns ','any','f10176','Related Patterns',1,'u1017');
INSERT INTO `fragment` VALUES (1,'Separate the construction of a complex object from its representation so that the same construction process can create different representations.\n\n','any','f10211','Intent',1,'u1021');
INSERT INTO `fragment` VALUES (1,'the construction process must allow different representations for the object that\'s constructed.','any','f102110','Applicability',1,'u1021');
INSERT INTO `fragment` VALUES (1,'A reader for the RTF (Rich Text Format) document exchange format should be able to convert RTF to many text formats. The reader might convert RTF documents into plain ASCII text or into a text widget that can be edited interactively. The problem, however, is that the number of possible conversions is open-ended. So it should be easy to add a new conversion without modifying the reader.','any','f10212','Motivation',1,'u1021');
INSERT INTO `fragment` VALUES (1,'A solution is to configure the RTFReader class with a TextConverter object that converts RTF to another textual representation. As the RTFReader parses the RTF document, it uses the TextConverter to perform the conversion. Whenever the RTFReader recognizes an RTF token (either plain text or an RTF control word), it issues a request to the TextConverter to convert the token. TextConverter objects are responsible both for performing the data conversion and for representing the token in a particular format.\n\n','any','f10213','Motivation',1,'u1021');
INSERT INTO `fragment` VALUES (2,'Subclasses of TextConverter specialize in different conversions and formats. For example, an ASCIIConverter ignores requests to convert anything except plain text. A TeXConverter, on the other hand, will implement operations for all requests in order to produce a TeX representation that captures all the stylistic information in the text. A TextWidgetConverter will produce a complex user interface object that lets the user see and edit the text.\n\n','any','f10214','Motivation',1,'u1021');
INSERT INTO `fragment` VALUES (2,'Builder_01','any','f10215','Motivation',1,'u1021');
INSERT INTO `fragment` VALUES (3,'Each kind of converter class takes the mechanism for creating and assembling a complex object and puts it behind an abstract interface. The converter is separate from the reader, which is responsible for parsing an RTF document.\n\n','any','f10216','Motivation',1,'u1021');
INSERT INTO `fragment` VALUES (3,'The Builder pattern captures all these relationships. Each converter class is called a builder in the pattern, and the reader is called the director. Applied to this example, the Builder pattern separates the algorithm for interpreting a textual format (that is, the parser for RTF documents) from how a converted format gets created and represented. This lets us reuse the RTFReader\'s parsing algorithm to create different text representations from RTF documents?just configure the RTFReader with different subclasses of TextConverter.\n\n','any','f10217','Motivation',1,'u1021');
INSERT INTO `fragment` VALUES (1,'Use the Builder pattern when:\n\n','any','f10218','Applicability',1,'u1021');
INSERT INTO `fragment` VALUES (1,'the algorithm for creating a complex object should be independent of the parts that make up the object and how they\'re assembled.','any','f10219','Applicability',1,'u1021');
INSERT INTO `fragment` VALUES (1,'Builder_02','any','f10221','Structure',1,'u1022');
INSERT INTO `fragment` VALUES (1,' ','any','f10230','Participants',1,'u1023');
INSERT INTO `fragment` VALUES (1,' Builder (TextConverter) ','any','f10231','Participants',1,'u1023');
INSERT INTO `fragment` VALUES (2,'represents the complex object under construction. ConcreteBuilder builds the product\'s internal representation and defines the process by which it\'s assembled. ','any','f102310','Participants',1,'u1023');
INSERT INTO `fragment` VALUES (2,'includes classes that define the constituent parts, including interfaces for assembling the parts into the final result. ','any','f102311','Participants',1,'u1023');
INSERT INTO `fragment` VALUES (1,' ','any','f102312','Collaboration',1,'u1023');
INSERT INTO `fragment` VALUES (1,'The client creates the Director object and configures it with the desired Builder object. ','any','f102313','Collaboration',1,'u1023');
INSERT INTO `fragment` VALUES (1,'Director notifies the builder whenever a part of the product should be built. ','any','f102314','Collaboration',1,'u1023');
INSERT INTO `fragment` VALUES (1,'Builder handles requests from the director and adds parts to the product. ','any','f102315','Collaboration',1,'u1023');
INSERT INTO `fragment` VALUES (1,'The client retrieves the product from the builder. \n','any','f102316','Collaboration',1,'u1023');
INSERT INTO `fragment` VALUES (2,'The following interaction diagram illustrates how Builder and Director cooperate with a client.\n\n','any','f102317','Collaboration',1,'u1023');
INSERT INTO `fragment` VALUES (2,'Builder_03','any','f102318','Collaboration',1,'u1023');
INSERT INTO `fragment` VALUES (2,'specifies an abstract interface for creating parts of a Product object. ','any','f10232','Participants',1,'u1023');
INSERT INTO `fragment` VALUES (1,'ConcreteBuilder (ASCIIConverter, TeXConverter, TextWidgetConverter) ','any','f10233','Participants',1,'u1023');
INSERT INTO `fragment` VALUES (2,'constructs and assembles parts of the product by implementing the Builder interface. ','any','f10234','Participants',1,'u1023');
INSERT INTO `fragment` VALUES (2,'defines and keeps track of the representation it creates. ','any','f10235','Participants',1,'u1023');
INSERT INTO `fragment` VALUES (2,'provides an interface for retrieving the product (e.g., GetASCIIText, GetTextWidget). \n','any','f10236','Participants',1,'u1023');
INSERT INTO `fragment` VALUES (1,'Director (RTFReader) ','any','f10237','Participants',1,'u1023');
INSERT INTO `fragment` VALUES (2,'constructs an object using the Builder interface. \n','any','f10238','Participants',1,'u1023');
INSERT INTO `fragment` VALUES (1,'Product (ASCIIText, TeXText, TextWidget) ','any','f10239','Participants',1,'u1023');
INSERT INTO `fragment` VALUES (1,' Here are key consequences of the Builder pattern:\n\n','any','f10241','Consequences',1,'u1024');
INSERT INTO `fragment` VALUES (1,'1. It lets you vary a product\'s internal representation. The Builder object provides the director with an abstract interface for constructing the product. The interface lets the builder hide the representation and internal structure of the product. It also hides how the product gets assembled. Because the product is constructed through an abstract interface, all you have to do to change the product\'s internal representation is define a new kind of builder. ','any','f10242','Consequences',1,'u1024');
INSERT INTO `fragment` VALUES (1,'2. It isolates code for construction and representation. The Builder pattern improves modularity by encapsulating the way a complex object is constructed and represented. Clients needn\'t know anything about the classes that define the product\'s internal structure; such classes don\'t appear in Builder\'s interface. ','any','f10243','Consequences',1,'u1024');
INSERT INTO `fragment` VALUES (2,'Each ConcreteBuilder contains all the code to create and assemble a particular kind of product. The code is written once; then different Directors can reuse it to build Product variants from the same set of parts. In the earlier RTF example, we could define a reader for a format other than RTF, say, an SGMLReader, and use the same TextConverters to generate ASCIIText, TeXText, and TextWidget renditions of SGML documents. ','any','f10244','Consequences',1,'u1024');
INSERT INTO `fragment` VALUES (1,'3. It gives you finer control over the construction process. Unlike creational patterns that construct products in one shot, the Builder pattern constructs the product step by step under the director\'s control. Only when the product is finished does the director retrieve it from the builder. Hence the Builder interface reflects the process of constructing the product more than other creational patterns. This gives you finer control over the construction process and consequently the internal structure of the resulting product. \n','any','f10245','Consequences',1,'u1024');
INSERT INTO `fragment` VALUES (1,' Typically there\'s an abstract Builder class that defines an operation for each component that a director may ask it to create. The operations do nothing by default. A ConcreteBuilder class overrides operations for components it\'s interested in creating.\n\n','any','f10251','Implementation',1,'u1025');
INSERT INTO `fragment` VALUES (1,'Here are other implementation issues to consider:\n\n','any','f10252','Implementation',1,'u1025');
INSERT INTO `fragment` VALUES (1,'1. Assembly and construction interface. Builders construct their products in step-by-step fashion. Therefore the Builder class interface must be general enough to allow the construction of products for all kinds of concrete builders. ','any','f10253','Implementation',1,'u1025');
INSERT INTO `fragment` VALUES (1,'A key design issue concerns the model for the construction and assembly process. A model where the results of construction requests are simply appended to the product is usually sufficient. In the RTF example, the builder converts and appends the next token to the text it has converted so far.','any','f10254','Implementation',1,'u1025');
INSERT INTO `fragment` VALUES (1,'But sometimes you might need access to parts of the product constructed earlier. In the Maze example we present in the Sample Code, the MazeBuilder interface lets you add a door between existing rooms. Tree structures such as parse trees that are built bottom-up are another example. In that case, the builder would return child nodes to the director, which then would pass them back to the builder to build the parent nodes.','any','f10255','Implementation',1,'u1025');
INSERT INTO `fragment` VALUES (1,'2. Why no abstract class for products? In the common case, the products produced by the concrete builders differ so greatly in their representation that there is little to gain from giving different products a common parent class. In the RTF example, the ASCIIText and the TextWidget objects are unlikely to have a common interface, nor do they need one. Because the client usually configures the director with the proper concrete builder, the client is in a position to know which concrete subclass of Builder is in use and can handle its products accordingly. ','any','f10256','Implementation',1,'u1025');
INSERT INTO `fragment` VALUES (1,'Empty methods as default in Builder. In C++, the build methods are intentionally not declared pure virtual member functions. They\'re defined as empty methods instead, letting clients override only the operations they\'re interested in. \n','any','f10257','Implementation',1,'u1025');
INSERT INTO `fragment` VALUES (1,' Some content should be added here!','any','f10261','Under the construction',1,'u1026');
INSERT INTO `fragment` VALUES (1,' The RTF converter application is from ET++ [WGM88]. Its text building block uses a builder to process text stored in the RTF format.\n\n','any','f10271','Known Uses',1,'u1027');
INSERT INTO `fragment` VALUES (1,'Builder is a common pattern in Smalltalk-80 [Par90]:\n\n','any','f10272','Known Uses',1,'u1027');
INSERT INTO `fragment` VALUES (1,'The Parser class in the compiler subsystem is a Director that takes a ProgramNodeBuilder object as an argument. A Parser object notifies its ProgramNodeBuilder object each time it recognizes a syntactic construct. When the parser is done, it asks the builder for the parse tree it built and returns it to the client. ','any','f10273','Known Uses',1,'u1027');
INSERT INTO `fragment` VALUES (1,'ClassBuilder is a builder that Classes use to create subclasses for themselves. In this case a Class is both the Director and the Product. ','any','f10274','Known Uses',1,'u1027');
INSERT INTO `fragment` VALUES (1,'ByteCodeStream is a builder that creates a compiled method as a byte array. ByteCodeStream is a nonstandard use of the Builder pattern, because the complex object it builds is encoded as a byte array, not as a normal Smalltalk object. But the interface to ByteCodeStream is typical of a builder, and it would be easy to replace ByteCodeStream with a different class that represented programs as a composite object. \n','any','f10275','Known Uses',1,'u1027');
INSERT INTO `fragment` VALUES (1,'The Service Configurator framework from the Adaptive Communications Environment uses a builder to construct network service components that are linked into a server at run-time [SS94]. The components are described with a configuration language that\'s parsed by an LALR(1) parser. The semantic actions of the parser perform operations on the builder that add information to the service component. In this case, the parser is the Director.\n\n','any','f10276','Known Uses',1,'u1027');
INSERT INTO `fragment` VALUES (1,'Abstract Factory (87) is similar to Builder in that it too may construct complex objects. The primary difference is that the Builder pattern focuses on constructing a complex object step by step. Abstract Factory\'s emphasis is on families of product objects (either simple or complex). Builder returns the product as a final step, but as far as the Abstract Factory pattern is concerned, the product gets returned immediately.\n\n','any','f10277','Related Patterns',1,'u1027');
INSERT INTO `fragment` VALUES (1,'A Composite (163) is what the builder often builds.\n\n','any','f10278','Related Patterns',1,'u1027');
INSERT INTO `fragment` VALUES (1,' Some content should be added here!','any','f10311','Under the construction',1,'u1031');
INSERT INTO `fragment` VALUES (1,'fff','any','f10321','fragment',2,'u1032');
INSERT INTO `fragment` VALUES (2,'fff','any','f10331','fragment',2,'u1033');
INSERT INTO `fragment` VALUES (1,'fff','any','f10341','fragment',3,'u1034');
INSERT INTO `fragment` VALUES (2,'ggg','any','f10351','fragment',2,'u1035');
INSERT INTO `fragment` VALUES (1,' Some content should be added here!','any','f10411','Under the construction',1,'u1041');
INSERT INTO `fragment` VALUES (1,' Some content should be added here!','any','f10511','Under the construction',1,'u1051');
INSERT INTO `fragment` VALUES (1,' Some content should be added here!','any','f20111','Under the construction',1,'u2011');
INSERT INTO `fragment` VALUES (1,' Some content should be added here!','any','f20211','Under the construction',1,'u2021');
INSERT INTO `fragment` VALUES (1,' Some content should be added here!','any','f20311','Under the construction',1,'u2031');
INSERT INTO `fragment` VALUES (1,' Some content should be added here!','any','f20411','Under the construction',1,'u2041');
INSERT INTO `fragment` VALUES (1,' Some content should be added here!','any','f20511','Under the construction',1,'u2051');
INSERT INTO `fragment` VALUES (1,' Some content should be added here!','any','f20611','Under the construction',1,'u2061');
INSERT INTO `fragment` VALUES (1,' Some content should be added here!','any','f20711','Under the construction',1,'u2071');
INSERT INTO `fragment` VALUES (1,' Some content should be added here!','any','f30111','Under the construction',1,'u3011');
INSERT INTO `fragment` VALUES (1,' Some content should be added here!','any','f30211','Under the construction',1,'u3021');
INSERT INTO `fragment` VALUES (1,' Some content should be added here!','any','f30311','Under the construction',1,'u3031');
INSERT INTO `fragment` VALUES (1,' Some content should be added here!','any','f30411','Under the construction',1,'u3041');
INSERT INTO `fragment` VALUES (1,'  ','any','f3051','Under the construction',1,'u3051');
INSERT INTO `fragment` VALUES (1,' Some content should be added here!','any','f30611','Under the construction',1,'u3061');
INSERT INTO `fragment` VALUES (1,' Some content should be added here!','any','f30711','Under the construction',1,'u3071');
INSERT INTO `fragment` VALUES (1,' Some content should be added here!','any','f30811','Under the construction',1,'u3081');
INSERT INTO `fragment` VALUES (1,' Some content should be added here!','any','f30911','Under the construction',1,'u3091');
INSERT INTO `fragment` VALUES (1,' Some content should be added here!','any','f31011','Under the construction',1,'u3101');
INSERT INTO `fragment` VALUES (1,' Some content should be added here!','any','f31111','Under the construction',1,'u3111');


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
INSERT INTO `group_has_course` VALUES (49,3104,'DP001');
INSERT INTO `group_has_course` VALUES (50,3136,'DP001');


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
INSERT INTO `groups` VALUES (3104,'aa',1,'');
INSERT INTO `groups` VALUES (3136,'bb',1,'');


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
INSERT INTO `performance` VALUES (100,1,1,NULL,NULL,1,NULL,NULL,'Java');
INSERT INTO `performance` VALUES (3056,5,5,NULL,'2006.06.07 AD at 05:18:30 CEST',1,NULL,NULL,'Java');
INSERT INTO `performance` VALUES (3057,3,3,NULL,NULL,1,NULL,NULL,'Java');
INSERT INTO `performance` VALUES (3087,1,1,NULL,NULL,1,NULL,NULL,'Java');
INSERT INTO `performance` VALUES (3088,5,5,NULL,NULL,1,NULL,NULL,'Java');
INSERT INTO `performance` VALUES (3126,1,1,NULL,NULL,1,NULL,NULL,'Java');


#
# Table structure for table prerequisites
#

CREATE TABLE `prerequisites` (
  `NMID` int(11) NOT NULL auto_increment,
  `conceptId` char(20) default NULL,
  `prerequisiteId` char(20) default NULL,
  PRIMARY KEY  (`NMID`),
  KEY `conceptId` (`conceptId`),
  KEY `prerequisiteId` (`prerequisiteId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Dumping data for table prerequisites
#
INSERT INTO `prerequisites` VALUES (1,'c101','0');
INSERT INTO `prerequisites` VALUES (2,'c102','0');
INSERT INTO `prerequisites` VALUES (3,'c103','0');
INSERT INTO `prerequisites` VALUES (4,'c104','0');
INSERT INTO `prerequisites` VALUES (5,'c105','c104');
INSERT INTO `prerequisites` VALUES (6,'c201','0');
INSERT INTO `prerequisites` VALUES (7,'c202','0');
INSERT INTO `prerequisites` VALUES (8,'c203','0');
INSERT INTO `prerequisites` VALUES (9,'c204','c205');
INSERT INTO `prerequisites` VALUES (10,'c205','0');
INSERT INTO `prerequisites` VALUES (11,'c206','0');
INSERT INTO `prerequisites` VALUES (12,'c207','0');
INSERT INTO `prerequisites` VALUES (13,'c301','0');
INSERT INTO `prerequisites` VALUES (14,'c302','0');
INSERT INTO `prerequisites` VALUES (15,'c303','0');
INSERT INTO `prerequisites` VALUES (16,'c304','0');
INSERT INTO `prerequisites` VALUES (17,'c305','0');
INSERT INTO `prerequisites` VALUES (18,'c306','0');
INSERT INTO `prerequisites` VALUES (19,'c307','0');
INSERT INTO `prerequisites` VALUES (20,'c308','0');
INSERT INTO `prerequisites` VALUES (21,'c309','0');
INSERT INTO `prerequisites` VALUES (22,'c310','0');
INSERT INTO `prerequisites` VALUES (23,'c311','0');


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
  `content` text,
  `difficultyLevel` int(11) default NULL,
  `relatedTo` char(11) default NULL,
  PRIMARY KEY  (`questionID`),
  KEY `Ref_02` (`conceptID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Dumping data for table question
#
INSERT INTO `question` VALUES ('q1011',1,'c101','What is intent of Abstract Factory pattern?',1,'u1011');
INSERT INTO `question` VALUES ('q10110',4,'c101','Select one of the statements that is true?',1,'u1017');
INSERT INTO `question` VALUES ('q10111',1,'c101','question example group 1 diff 1',1,'u1011');
INSERT INTO `question` VALUES ('q101110',4,'c101','question group 4 diff 2',2,'u1016');
INSERT INTO `question` VALUES ('q101111',4,'c101','question group 4 diff 5',5,'u1015');
INSERT INTO `question` VALUES ('q101112',5,'c101','question group 5 diff 3',3,'u1016');
INSERT INTO `question` VALUES ('q101113',5,'c101','question group 5 diff 5',5,'u1017');
INSERT INTO `question` VALUES ('q10112',1,'c101','question group 1 diff 2',2,'u1011');
INSERT INTO `question` VALUES ('q10113',1,'c101','question group 1 diff 3',3,'u1011');
INSERT INTO `question` VALUES ('q10114',1,'c101','question group 1 diff 4',4,'u1011');
INSERT INTO `question` VALUES ('q10115',1,'c101','question group 1 diff ',5,'u1011');
INSERT INTO `question` VALUES ('q10116',2,'c101','question group 2 diff 2',2,'u1014');
INSERT INTO `question` VALUES ('q10117',2,'c101','question group 2 diff 3',3,'u1014');
INSERT INTO `question` VALUES ('q10118',2,'c101','question group 2 diff 4',4,'u1014');
INSERT INTO `question` VALUES ('q10119',3,'c101','question group 3 diff 3',3,'u1015');
INSERT INTO `question` VALUES ('q1012',2,'c101','In which case you will use Abstract Factory pattern?',1,'u1014');
INSERT INTO `question` VALUES ('q1013',3,'c101','What is the role of AbstractProduct participant?',1,'u1013');
INSERT INTO `question` VALUES ('q1014',5,'c101','What are the most related patterns to Abstract Factory pattern?',1,'u1017');
INSERT INTO `question` VALUES ('q1015',4,'c101','How can the Abstract factory classes be implemented?',1,'u1015');
INSERT INTO `question` VALUES ('q1016',1,'c101','What is the other name of Abstract Factory pattern?',1,'u1011');
INSERT INTO `question` VALUES ('q1017',5,'c101','What are the known uses of Abstract Factory?',1,'u1017');
INSERT INTO `question` VALUES ('q1018',3,'c101','Choose one of the following statment that best describe the benefits and liabilities of Abstract Factory pattern.',1,'u1015');
INSERT INTO `question` VALUES ('q1019',2,'c101','What is the motivation of Abstract Factory pattern?',1,'u1013');
INSERT INTO `question` VALUES ('q1021',1,'c102','question 1?\t',1,'u1021');
INSERT INTO `question` VALUES ('q10210',5,'c102','Under the construction?',1,'u1027');
INSERT INTO `question` VALUES ('q10211',5,'c102','Under the construction?',2,'u1026');
INSERT INTO `question` VALUES ('q10212',1,'c102','question group 1 diff 3',3,'u1021');
INSERT INTO `question` VALUES ('q10213',1,'c102','question group 1 diff 2',2,'u1021');
INSERT INTO `question` VALUES ('q10214',1,'c102','question group 1 diff 4',4,'u1021');
INSERT INTO `question` VALUES ('q10215',1,'c102','question group 1 diff 5',5,'u1021');
INSERT INTO `question` VALUES ('q10216',2,'c102','question group 2 diff 4',4,'u1022');
INSERT INTO `question` VALUES ('q10217',2,'c102','question group 2 diff 2',2,'u1022');
INSERT INTO `question` VALUES ('q10218',2,'c102','question group 2 diff 3',3,'u1022');
INSERT INTO `question` VALUES ('q10219',3,'c102','question group 3 diff 2',2,'u1023');
INSERT INTO `question` VALUES ('q1022',1,'c102','Under the construction?',1,'u1021');
INSERT INTO `question` VALUES ('q10220',3,'c102','question group 3 diff 3',3,'u1023');
INSERT INTO `question` VALUES ('q10221',3,'c102','question group 3 diff 5',5,'u1023');
INSERT INTO `question` VALUES ('q10222',4,'c102','question group 4 diff 2',2,'u1025');
INSERT INTO `question` VALUES ('q10223',4,'c102','question group 4 diff 4',4,'u1024');
INSERT INTO `question` VALUES ('q10224',5,'c102','question group  diff 3',3,'u1026');
INSERT INTO `question` VALUES ('q10225',5,'c102','question group 5 diff 4',4,'u1026');
INSERT INTO `question` VALUES ('q1023',2,'c102','Under the construction?',1,'u1022');
INSERT INTO `question` VALUES ('q1024',3,'c102','Under the construction?',1,'u1023');
INSERT INTO `question` VALUES ('q1025',4,'c102','Under the construction?',1,'u1025');
INSERT INTO `question` VALUES ('q1026',1,'c102','Under the construction?',1,'u1021');
INSERT INTO `question` VALUES ('q1027',2,'c102','Under the construction?',1,'u1022');
INSERT INTO `question` VALUES ('q1028',3,'c102','Under the construction?',1,'u1023');
INSERT INTO `question` VALUES ('q1029',4,'c102','Under the construction?',1,'u1024');
INSERT INTO `question` VALUES ('q1031',1,'c103','q1',1,'u1031');
INSERT INTO `question` VALUES ('q10310',2,'c103','question group 2 diff 3',3,'u1032');
INSERT INTO `question` VALUES ('q10311',2,'c103','question group 2 diff 4',4,'u1032');
INSERT INTO `question` VALUES ('q10312',3,'c103','question group 3 diff 2',2,'u1033');
INSERT INTO `question` VALUES ('q10313',3,'c103','question group 3 diff 2',2,'u1033');
INSERT INTO `question` VALUES ('q10314',3,'c103','question group 3 diff 5',5,'u1033');
INSERT INTO `question` VALUES ('q10315',4,'c103','question group 4 diff 2',2,'u1034');
INSERT INTO `question` VALUES ('q10316',4,'c103','question group 4 diff 4',4,'u1034');
INSERT INTO `question` VALUES ('q10317',4,'c103','question group 4 diff 4',4,'u1034');
INSERT INTO `question` VALUES ('q10318',5,'c103','question group 5 diff 2',2,'u1035');
INSERT INTO `question` VALUES ('q10319',5,'c103','question group 5 diff 4',4,'u1035');
INSERT INTO `question` VALUES ('q1032',1,'c103','Under the construction',1,'u1031');
INSERT INTO `question` VALUES ('q1033',1,'c103','Under the construction',2,'u1031');
INSERT INTO `question` VALUES ('q1034',1,'c103','Under the construction',3,'u1031');
INSERT INTO `question` VALUES ('q1035',1,'c103','Under the construction',4,'u1031');
INSERT INTO `question` VALUES ('q1036',1,'c103','Under the construction',5,'u1031');
INSERT INTO `question` VALUES ('q1037',2,'c103','queastion group 2 diff 1',1,'u1032');
INSERT INTO `question` VALUES ('q1038',2,'c103','question group 2 diff 2',2,'u1032');
INSERT INTO `question` VALUES ('q1039',2,'c103','question group 2 diff 4',4,'u1033');
INSERT INTO `question` VALUES ('q1041',1,'c104','q1',1,'u1041');
INSERT INTO `question` VALUES ('q1051',1,'c105','q1',1,'u1051');
INSERT INTO `question` VALUES ('q2011',1,'c201','q1',1,'u2011');
INSERT INTO `question` VALUES ('q2021',1,'c202','q1',1,'u2021');
INSERT INTO `question` VALUES ('q2031',1,'c203','q1',1,'u2031');
INSERT INTO `question` VALUES ('q2041',1,'c204','q1',1,'u2041');
INSERT INTO `question` VALUES ('q2051',1,'c205','q1',1,'u2051');
INSERT INTO `question` VALUES ('q2061',1,'c206','q1',1,'u2061');
INSERT INTO `question` VALUES ('q2071',1,'c207','q1',1,'u2071');
INSERT INTO `question` VALUES ('q3011',1,'c301','q1',1,'u3011');
INSERT INTO `question` VALUES ('q3021',1,'c302','q1',1,'u3021');
INSERT INTO `question` VALUES ('q3031',1,'c303','q1',1,'u3031');
INSERT INTO `question` VALUES ('q3041',1,'c304','q1',1,'u3041');
INSERT INTO `question` VALUES ('q3051',1,'c305','q1',1,'u3051');
INSERT INTO `question` VALUES ('q3061',1,'c306','q1',1,'u3061');
INSERT INTO `question` VALUES ('q3071',1,'c307','q1',1,'u3071');
INSERT INTO `question` VALUES ('q3081',1,'c308','q1',1,'u3081');
INSERT INTO `question` VALUES ('q3091',1,'c309','q1',1,'u3091');
INSERT INTO `question` VALUES ('q3101',1,'c310','q1',1,'u3101');
INSERT INTO `question` VALUES ('q3111',1,'c311','q1',1,'u3111');


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
INSERT INTO `questionintestforstudent` VALUES (453,96,'q10115','1');
INSERT INTO `questionintestforstudent` VALUES (454,96,'q10118','1');
INSERT INTO `questionintestforstudent` VALUES (455,96,'q10119','0');
INSERT INTO `questionintestforstudent` VALUES (456,96,'q101111','1');
INSERT INTO `questionintestforstudent` VALUES (457,96,'q101113','1');
INSERT INTO `questionintestforstudent` VALUES (458,97,'q1013','0');
INSERT INTO `questionintestforstudent` VALUES (459,98,'q10215','1');
INSERT INTO `questionintestforstudent` VALUES (460,98,'q10216','1');
INSERT INTO `questionintestforstudent` VALUES (461,98,'q10221','0');
INSERT INTO `questionintestforstudent` VALUES (462,98,'q10223','1');
INSERT INTO `questionintestforstudent` VALUES (463,98,'q10225','1');
INSERT INTO `questionintestforstudent` VALUES (464,99,'q10220','1');
INSERT INTO `questionintestforstudent` VALUES (465,100,'q1036','1');
INSERT INTO `questionintestforstudent` VALUES (466,100,'q10311','1');
INSERT INTO `questionintestforstudent` VALUES (467,100,'q10314','1');
INSERT INTO `questionintestforstudent` VALUES (468,100,'q10316','1');
INSERT INTO `questionintestforstudent` VALUES (469,100,'q10319','0');
INSERT INTO `questionintestforstudent` VALUES (470,101,'q10318','1');
INSERT INTO `questionintestforstudent` VALUES (471,102,'q1041','1');
INSERT INTO `questionintestforstudent` VALUES (472,103,'q1051','0');
INSERT INTO `questionintestforstudent` VALUES (473,104,'q1051','0');


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
INSERT INTO `students` VALUES (100,'d','d','d','d','d','','',1,'','http://',1,3136);
INSERT INTO `students` VALUES (3056,'a1','a1','a1','a1','a1','','',1,'','http://',1,3104);
INSERT INTO `students` VALUES (3057,'a2','a2','a2','a2','a2','','',1,'','http://',1,3104);
INSERT INTO `students` VALUES (3087,'b1','b1','b1','b1','b1','','',1,'','http://',1,3136);
INSERT INTO `students` VALUES (3088,'b2','b2','b2','b2','b2','','',1,'','http://',1,3136);
INSERT INTO `students` VALUES (3126,'aw','aw','aw','aw','aw','','',1,'','http://',1,3136);


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
  `courseId` char(20) default NULL,
  PRIMARY KEY  (`IDStudentInCourse`),
  KEY `Ref_10` (`studentID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Dumping data for table studentsincourse
#
INSERT INTO `studentsincourse` VALUES (5,3056,'2006.06.07 AD at 05:04:46 CEST','2006.06.07 AD at 05:04:46 CEST',1,3104,'DP001');
INSERT INTO `studentsincourse` VALUES (6,3057,'2006.06.07 AD at 05:05:01 CEST','2006.06.07 AD at 05:05:01 CEST',1,3104,'DP001');
INSERT INTO `studentsincourse` VALUES (7,3087,'2006.06.07 AD at 05:05:19 CEST','2006.06.07 AD at 05:05:19 CEST',1,3136,'DP001');
INSERT INTO `studentsincourse` VALUES (8,3088,'2006.06.07 AD at 05:05:43 CEST','2006.06.07 AD at 05:05:43 CEST',1,3136,'DP001');
INSERT INTO `studentsincourse` VALUES (9,3126,'2006.06.07 AD at 05:40:44 CEST','2006.06.07 AD at 05:40:44 CEST',1,3136,'DP001');
INSERT INTO `studentsincourse` VALUES (10,100,'2006.06.07 AD at 05:44:39 CEST','2006.06.07 AD at 05:44:39 CEST',1,3136,'0');


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
INSERT INTO `teacher_has_course` VALUES (4,97,'DP001');


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
INSERT INTO `teacher_has_groups` VALUES (69,97,3104);
INSERT INTO `teacher_has_groups` VALUES (70,97,3136);


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
INSERT INTO `teacher_has_privilegies` VALUES (160,97,1);
INSERT INTO `teacher_has_privilegies` VALUES (161,97,2);
INSERT INTO `teacher_has_privilegies` VALUES (162,97,3);
INSERT INTO `teacher_has_privilegies` VALUES (163,97,4);


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
INSERT INTO `testinconceptforstudent` VALUES (96,61,'1','2006.06.07 AD at 05:07:33 CEST','2006.06.07 AD at 05:07:44 CEST',1,4.75,5,11,88,86.3636363636,76);
INSERT INTO `testinconceptforstudent` VALUES (97,61,'2','2006.06.07 AD at 05:07:58 CEST','2006.06.07 AD at 05:08:01 CEST',1,0.5198114769,5,3,20,0,0);
INSERT INTO `testinconceptforstudent` VALUES (98,64,'1','2006.06.07 AD at 05:17:30 CEST','2006.06.07 AD at 05:17:38 CEST',1,4.2122453913,5,8,88,77.2727272727,68);
INSERT INTO `testinconceptforstudent` VALUES (99,64,'2','2006.06.07 AD at 05:17:43 CEST','2006.06.07 AD at 05:17:46 CEST',1,4.9731486189,5,3,60,100,60);
INSERT INTO `testinconceptforstudent` VALUES (100,65,'1','2006.06.07 AD at 05:17:56 CEST','2006.06.07 AD at 05:18:03 CEST',1,4.75,5,7,88,81.8181818182,72);
INSERT INTO `testinconceptforstudent` VALUES (101,65,'2','2006.06.07 AD at 05:18:07 CEST','2006.06.07 AD at 05:18:10 CEST',1,4.75,5,3,40,100,40);
INSERT INTO `testinconceptforstudent` VALUES (102,66,'1','2006.06.07 AD at 05:18:14 CEST','2006.06.07 AD at 05:18:17 CEST',1,4.4309331338,5,3,20,100,20);
INSERT INTO `testinconceptforstudent` VALUES (103,67,'1','2006.06.07 AD at 05:18:20 CEST','2006.06.07 AD at 05:18:23 CEST',1,0.5198114769,5,3,20,0,0);
INSERT INTO `testinconceptforstudent` VALUES (104,67,'2','2006.06.07 AD at 05:18:26 CEST','2006.06.07 AD at 05:18:29 CEST',1,0.5198114769,5,3,20,0,0);


#
# Table structure for table unit
#

CREATE TABLE `unit` (
  `unitID` char(11) NOT NULL,
  `title` char(150) default NULL,
  `ordinalNumber` tinyint(4) default NULL,
  `conceptID` char(11) default NULL,
  `difficultyLevel` tinyint(4) default NULL,
  PRIMARY KEY  (`unitID`),
  KEY `Ref_04` (`conceptID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Dumping data for table unit
#
INSERT INTO `unit` VALUES ('u1011','Introduction',1,'c101',1);
INSERT INTO `unit` VALUES ('u1012','Structure',2,'c101',1);
INSERT INTO `unit` VALUES ('u1013','Participants and Collaborations',3,'c101',1);
INSERT INTO `unit` VALUES ('u1014','Consequences',4,'c101',1);
INSERT INTO `unit` VALUES ('u1015','Implementation',5,'c101',1);
INSERT INTO `unit` VALUES ('u1016','Sample Code',6,'c101',1);
INSERT INTO `unit` VALUES ('u1017','Known Uses and Related Patterns',7,'c101',1);
INSERT INTO `unit` VALUES ('u1021','Introduction',1,'c102',1);
INSERT INTO `unit` VALUES ('u1022','Structure',2,'c102',1);
INSERT INTO `unit` VALUES ('u1023','Participants and Collaborations',3,'c102',1);
INSERT INTO `unit` VALUES ('u1024','Consequences',4,'c102',1);
INSERT INTO `unit` VALUES ('u1025','Implementation',5,'c102',1);
INSERT INTO `unit` VALUES ('u1026','Sample Code',6,'c102',1);
INSERT INTO `unit` VALUES ('u1027','Known Uses and Related Patterns',7,'c102',1);
INSERT INTO `unit` VALUES ('u1031','Under the construction',1,'c103',1);
INSERT INTO `unit` VALUES ('u1032','under the construction',2,'c103',2);
INSERT INTO `unit` VALUES ('u1033','under the construction',3,'c103',2);
INSERT INTO `unit` VALUES ('u1034','under the construction',4,'c103',3);
INSERT INTO `unit` VALUES ('u1035','under the construction',5,'c103',2);
INSERT INTO `unit` VALUES ('u1041','Under the construction',1,'c104',1);
INSERT INTO `unit` VALUES ('u1051','Under the construction',1,'c105',1);
INSERT INTO `unit` VALUES ('u2011','Under the construction',1,'c201',1);
INSERT INTO `unit` VALUES ('u2021','Under the construction',1,'c202',1);
INSERT INTO `unit` VALUES ('u2031','Under the construction',1,'c203',1);
INSERT INTO `unit` VALUES ('u2041','Under the construction',1,'c204',1);
INSERT INTO `unit` VALUES ('u2051','Under the construction',1,'c205',1);
INSERT INTO `unit` VALUES ('u2061','Under the construction',1,'c206',1);
INSERT INTO `unit` VALUES ('u2071','Under the construction',1,'c207',1);
INSERT INTO `unit` VALUES ('u3011','Under the construction',1,'c301',1);
INSERT INTO `unit` VALUES ('u3021','Under the construction',1,'c302',1);
INSERT INTO `unit` VALUES ('u3031','Under the construction',1,'c303',1);
INSERT INTO `unit` VALUES ('u3041','Under the construction',1,'c304',1);
INSERT INTO `unit` VALUES ('u3051','Under the construction',1,'c305',1);
INSERT INTO `unit` VALUES ('u3061','Under the construction',1,'c306',1);
INSERT INTO `unit` VALUES ('u3071','Under the construction',1,'c307',1);
INSERT INTO `unit` VALUES ('u3081','Under the construction',1,'c308',1);
INSERT INTO `unit` VALUES ('u3091','Under the construction',1,'c309',1);
INSERT INTO `unit` VALUES ('u3101','Under the construction',1,'c310',1);
INSERT INTO `unit` VALUES ('u3111','Under the construction',1,'c311',1);


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
INSERT INTO `unitsinconceptforstudent` VALUES (423,61,'u1011','2006.06.07 AD at 05:06:16 CEST','2006.06.07 AD at 05:06:16 CEST',1);
INSERT INTO `unitsinconceptforstudent` VALUES (424,61,'u1012','2006.06.07 AD at 05:06:19 CEST','2006.06.07 AD at 05:06:19 CEST',1);
INSERT INTO `unitsinconceptforstudent` VALUES (425,61,'u1013','2006.06.07 AD at 05:07:01 CEST','2006.06.07 AD at 05:07:01 CEST',1);
INSERT INTO `unitsinconceptforstudent` VALUES (426,61,'u1014','2006.06.07 AD at 05:07:03 CEST','2006.06.07 AD at 05:07:03 CEST',1);
INSERT INTO `unitsinconceptforstudent` VALUES (427,61,'u1015','2006.06.07 AD at 05:07:56 CEST','2006.06.07 AD at 05:07:56 CEST',2);
INSERT INTO `unitsinconceptforstudent` VALUES (428,61,'u1016','2006.06.07 AD at 05:07:30 CEST','2006.06.07 AD at 05:07:30 CEST',1);
INSERT INTO `unitsinconceptforstudent` VALUES (429,61,'u1017','2006.06.07 AD at 05:07:31 CEST','2006.06.07 AD at 05:07:31 CEST',1);
INSERT INTO `unitsinconceptforstudent` VALUES (430,64,'u1021','2006.06.07 AD at 05:17:17 CEST','2006.06.07 AD at 05:17:17 CEST',1);
INSERT INTO `unitsinconceptforstudent` VALUES (431,64,'u1022','2006.06.07 AD at 05:17:19 CEST','2006.06.07 AD at 05:17:19 CEST',1);
INSERT INTO `unitsinconceptforstudent` VALUES (432,64,'u1023','2006.06.07 AD at 05:17:41 CEST','2006.06.07 AD at 05:17:41 CEST',2);
INSERT INTO `unitsinconceptforstudent` VALUES (433,64,'u1024','2006.06.07 AD at 05:17:22 CEST','2006.06.07 AD at 05:17:22 CEST',1);
INSERT INTO `unitsinconceptforstudent` VALUES (434,64,'u1025','2006.06.07 AD at 05:17:24 CEST','2006.06.07 AD at 05:17:24 CEST',1);
INSERT INTO `unitsinconceptforstudent` VALUES (435,64,'u1026','2006.06.07 AD at 05:17:26 CEST','2006.06.07 AD at 05:17:26 CEST',1);
INSERT INTO `unitsinconceptforstudent` VALUES (436,64,'u1027','2006.06.07 AD at 05:17:27 CEST','2006.06.07 AD at 05:17:27 CEST',1);
INSERT INTO `unitsinconceptforstudent` VALUES (437,65,'u1031','2006.06.07 AD at 05:17:50 CEST','2006.06.07 AD at 05:17:50 CEST',1);
INSERT INTO `unitsinconceptforstudent` VALUES (438,65,'u1032','2006.06.07 AD at 05:17:52 CEST','2006.06.07 AD at 05:17:52 CEST',1);
INSERT INTO `unitsinconceptforstudent` VALUES (439,65,'u1033','2006.06.07 AD at 05:17:53 CEST','2006.06.07 AD at 05:17:53 CEST',1);
INSERT INTO `unitsinconceptforstudent` VALUES (440,65,'u1034','2006.06.07 AD at 05:17:54 CEST','2006.06.07 AD at 05:17:54 CEST',1);
INSERT INTO `unitsinconceptforstudent` VALUES (441,65,'u1035','2006.06.07 AD at 05:18:05 CEST','2006.06.07 AD at 05:18:05 CEST',2);
INSERT INTO `unitsinconceptforstudent` VALUES (442,66,'u1041','2006.06.07 AD at 05:18:13 CEST','2006.06.07 AD at 05:18:13 CEST',1);
INSERT INTO `unitsinconceptforstudent` VALUES (443,67,'u1051','2006.06.07 AD at 05:18:25 CEST','2006.06.07 AD at 05:18:25 CEST',2);


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

CREATE PROCEDURE `spInsertStudentInCourse`(IN studentID INTEGER, IN started CHAR, IN finished CHAR, IN numberOfPasses INTEGER, IN groupId INTEGER(11), IN courseId CHAR)
BEGIN
  INSERT INTO studentsInCourse (studentID, started, finished, numberOfPasses,groupId,courseId)
  VALUES (studentID,  started, finished, numberOfPasses,groupId,courseId);
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
# Source for procedure spReadNewAnswerContent
#

CREATE PROCEDURE `spReadNewAnswerContent`(IN qId CHAR, IN content TEXT, IN truth BOOLEAN, IN ordNum INTEGER(11))
BEGIN
declare an int default 0;
select count(*) into an from answer where (answer.`ordNumb`=ordNum and answer.`questionId`=qId);
if an=0
THEN
insert INTO answer (questionId,textOfAnswer,truth,ordNumb)
values (qId,content,truth,ordNum);
ELSE
update answer set
textOfAnswer=content,
truth=truth
where answer.`questionId`=qId and answer.`ordNumb`=ordNum;
end if;

END;

#
# Source for procedure spReadNewFragmentInfo
#

CREATE PROCEDURE `spReadNewFragmentInfo`(IN cId CHAR, IN uId CHAR, IN fId CHAR, IN progrLang CHAR, IN detLev INTEGER(11), IN diffLev INTEGER(11), IN content TEXT, IN title TEXT)
BEGIN
declare fr int default 0;
select count(*) into fr from fragment where fragment.`fragmentID`=fId;
if fr=0
THEN
insert INTO fragment(fragmentID,unitId,difficultyLevel,type,detailLevel,title,content)
values (fId,uId,diffLev,progrLang,detLev,title,content);
ELSE
update `fragment` set
fragmentID=fId,unitId=uId,
difficultyLevel=diffLev,type=progrLang,
detailLevel=detLev,title=title,
content=content
where fragment.`fragmentID`=fId;
end if;
END;

#
# Source for procedure spReadNewQuestionInfo
#

CREATE PROCEDURE `spReadNewQuestionInfo`(IN cId CHAR, IN qId CHAR, IN diffLev INTEGER(11), IN gr INTEGER(11), IN relatedTo CHAR, IN content TEXT)
BEGIN
declare qu int default 0;
select count(*) into qu from question where question.`questionID`=qId;
if qu=0
THEN
insert INTO question(questionID,qGroup,conceptID,content,difficultyLevel,relatedTo)
values (qId,gr,cId,content,diffLev,relatedTo);
ELSE
update `question` set
qGroup=gr,conceptID=cId,
content=content,difficultyLevel=diffLev,
relatedTo=relatedTo
where question.`questionID`=qId;
end if;
END;

#
# Source for procedure spReadNewUnitInfo
#

CREATE PROCEDURE `spReadNewUnitInfo`(IN unId CHAR, IN cId CHAR, IN title TEXT, IN diffLev INTEGER(11), IN ordNum INTEGER(11))
BEGIN
declare un int default 0;
select count(*) into un from unit where unit.`unitID`=unId;
if un=0
THEN
insert INTO unit(unitID,title,ordinalNumber,conceptID,difficultyLevel)
values (unId,title,ordNum,cId,diffLev);
ELSE
update `unit` set
title=title,ordinalNumber=ordNum,conceptID=cId,difficultyLevel=diffLev
where unit.`unitID`=unId;
end if;
END;

#
# Source for procedure spReadPrerequisites
#

CREATE PROCEDURE `spReadPrerequisites`(IN cId CHAR, IN prerId CHAR)
BEGIN
declare an int default 0;
select count(*) into an from prerequisites where (prerequisites.`conceptId`=cId and prerequisites.`prerequisiteId`=prerId);
if an=0
THEN
insert INTO prerequisites (conceptId,prerequisiteId)
values (cId,prerId);

end if;
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
# Source for procedure spWriteNewConceptInfo
#

CREATE PROCEDURE `spWriteNewConceptInfo`(IN cId CHAR, IN courseId CHAR, IN minKnLev INTEGER(11), IN title TEXT, IN type CHAR, IN ordNum INTEGER(11))
BEGIN
declare conc int default 0;
select count(*) into conc from concept where concept.`conceptID`=cId;
if conc=0
THEN
insert INTO concept(conceptID,courseID,type,title,minKnowledgeLevel,ordinalNumber)
values (cId,courseId,type,title,minKnLev,ordNum);
ELSE
update `concept` set 
courseID=courseId,type=type,title=title,
minKnowledgeLevel=minKnLev,ordinalNumber=ordNum
where conceptID=cId;
end if;
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
#  Foreign keys for table answer
#

ALTER TABLE `answer`
  ADD FOREIGN KEY (`questionId`) REFERENCES `question` (`questionID`);

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
#  Foreign keys for table fragment
#

ALTER TABLE `fragment`
  ADD FOREIGN KEY (`unitId`) REFERENCES `unit` (`unitID`);

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
#  Foreign keys for table prerequisites
#

ALTER TABLE `prerequisites`
  ADD FOREIGN KEY (`conceptId`) REFERENCES `concept` (`conceptID`);

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
