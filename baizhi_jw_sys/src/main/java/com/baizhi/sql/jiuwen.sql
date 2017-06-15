/*
Navicat MySQL Data Transfer

Source Server         : dangdang
Source Server Version : 50528
Source Host           : 127.0.0.1:3306
Source Database       : ask

Target Server Type    : MYSQL
Target Server Version : 50528
File Encoding         : 65001

Date: 2017-06-11 09:37:52
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for jw_admin管理员表
-- ----------------------------
CREATE TABLE `jw_admin` (
  `id` varchar(40) NOT NULL,
  `adminname` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `salt` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of jw_admin
-- ----------------------------

-- ----------------------------
-- Table structure for jw_comment评价表
-- ----------------------------
CREATE TABLE `jw_comment` (
  `id` varchar(40) NOT NULL,
  `score` double(5,2) DEFAULT NULL,
  `content` varchar(5000) DEFAULT NULL,
  `createtime` datetime DEFAULT NULL,
  `orderid` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `comment_order` (`orderid`),
  CONSTRAINT `comment_order` FOREIGN KEY (`orderid`) REFERENCES `jw_order` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of jw_comment
-- ----------------------------

-- ----------------------------
-- Table structure for jw_deal解决方案表
-- ----------------------------
CREATE TABLE `jw_deal` (
  `id` varchar(40) NOT NULL,
  `title` varchar(500) DEFAULT NULL,
  `createtime` date DEFAULT NULL,
  `content` varchar(5000) DEFAULT NULL,
  `dealtypeid` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `deal_to_dealtype` (`dealtypeid`),
  CONSTRAINT `deal_to_dealtype` FOREIGN KEY (`dealtypeid`) REFERENCES `jw_dealtype` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of jw_deal
-- ----------------------------

-- ----------------------------
-- Table structure for jw_dealtype解决方案分类表
-- ----------------------------
CREATE TABLE `jw_dealtype` (
  `id` varchar(40) NOT NULL,
  `name` varchar(80) DEFAULT NULL,
  `parentid` varchar(40) DEFAULT NULL,
  `flag` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `self_to_type` (`parentid`),
  CONSTRAINT `self_to_type` FOREIGN KEY (`parentid`) REFERENCES `jw_dealtype` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of jw_dealtype
-- ----------------------------

-- ----------------------------
-- Table structure for jw_favorite收藏表
-- ----------------------------
CREATE TABLE `jw_favorite` (
  `userid` varchar(40) NOT NULL,
  `lawerid` varchar(40) NOT NULL,
  PRIMARY KEY (`userid`,`lawerid`),
  KEY `favorite_to_lawer` (`lawerid`),
  CONSTRAINT `favorite_to_user` FOREIGN KEY (`userid`) REFERENCES `jw_user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `favorite_to_lawer` FOREIGN KEY (`lawerid`) REFERENCES `jw_lawer` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of jw_favorite
-- ----------------------------

-- ----------------------------
-- Table structure for jw_lawer律师表
-- ----------------------------
CREATE TABLE `jw_lawer` (
  `id` varchar(40) NOT NULL,
  `name` varchar(40) DEFAULT NULL,
  `address` varchar(500) DEFAULT NULL,
  `year` varchar(2) DEFAULT NULL,
  `number` varchar(30) DEFAULT NULL,
  `workspace` varchar(500) DEFAULT NULL,
  `desc` varchar(5000) DEFAULT NULL,
  `wordprice` decimal(8,2) DEFAULT NULL,
  `phoneprice` decimal(8,2) DEFAULT NULL,
  `photo` varchar(500) DEFAULT NULL,
  `status` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of jw_lawer
-- ----------------------------

-- ----------------------------
-- Table structure for jw_lawertype律师分类表
-- ----------------------------
CREATE TABLE `jw_lawertype` (
  `id` varchar(40) NOT NULL,
  `name` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of jw_lawertype
-- ----------------------------

-- ----------------------------
-- Table structure for jw_menu菜单表
-- ----------------------------
CREATE TABLE `jw_menu` (
  `id` varchar(40) NOT NULL,
  `name` varchar(80) DEFAULT NULL,
  `parentid` varchar(40) DEFAULT NULL,
  `href` varchar(40),
  `iconCls` varchar(40),
  PRIMARY KEY (`id`),
  KEY `system_to_self` (`parentid`),
  CONSTRAINT `system_to_self` FOREIGN KEY (`parentid`) REFERENCES `jw_menu` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of jw_menu
--
-- ----------------------------
INSERT INTO `jw_menu` VALUES ('1', '系统模块', null);
INSERT INTO `jw_menu` VALUES ('2', '律师模块', null);
INSERT INTO `jw_menu` VALUES ('3', '用户模块', null);
INSERT INTO `jw_menu` VALUES ('4', '订单模块', null);
INSERT INTO `jw_menu` VALUES ('5', '案例模块', null);

INSERT INTO `jw_menu` VALUES ('6', '数据备份', '1');
INSERT INTO `jw_menu` VALUES ('7', '系统背景', '1');
INSERT INTO `jw_menu` VALUES ('8', '清除缓存', '1');
INSERT INTO `jw_menu` VALUES ('9', '系统日志', '1');
INSERT INTO `jw_menu` VALUES ('10', '律师管理', '2');
INSERT INTO `jw_menu` VALUES ('11', '分类管理', '2');
INSERT INTO `jw_menu` VALUES ('12', '用户管理', '3');
INSERT INTO `jw_menu` VALUES ('13', '订单管理', '4');
INSERT INTO `jw_menu` VALUES ('14', '分类管理', '5');
INSERT INTO `jw_menu` VALUES ('15', '案例管理', '5');

-- ----------------------------
-- Table structure for jw_order订单表
-- ----------------------------
CREATE TABLE `jw_order` (
  `id` varchar(40) NOT NULL,
  `userid` varchar(40) DEFAULT NULL,
  `content` varchar(5000) DEFAULT NULL,
  `type` varchar(500) DEFAULT NULL,
  `status` int(2) DEFAULT NULL,
  `lawerid` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `order_userid` (`userid`),
  KEY `order_lawerid` (`lawerid`),
  CONSTRAINT `order_lawerid` FOREIGN KEY (`lawerid`) REFERENCES `jw_lawer` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `order_userid` FOREIGN KEY (`userid`) REFERENCES `jw_user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of jw_order
-- ----------------------------

-- ----------------------------
-- Table structure for jw_redpackage红包表
-- ----------------------------
CREATE TABLE `jw_redpackage` (
  `id` varchar(40) NOT NULL,
  `redpackage` decimal(8,2) DEFAULT NULL,
  `content` varchar(5000) DEFAULT NULL,
  `lawerid` varchar(40) DEFAULT NULL,
  `userid` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `red_lawer` (`lawerid`),
  KEY `red_user` (`userid`),
  CONSTRAINT `red_user` FOREIGN KEY (`userid`) REFERENCES `jw_user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `red_lawer` FOREIGN KEY (`lawerid`) REFERENCES `jw_lawer` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of jw_redpackage
-- ----------------------------

-- ----------------------------
-- Table structure for jw_type_lawer律师分类 多对多关系表
-- ----------------------------
CREATE TABLE `jw_type_lawer` (
  `lawerid` varchar(40) NOT NULL,
  `lawertypeid` varchar(40) NOT NULL,
  PRIMARY KEY (`lawerid`,`lawertypeid`),
  KEY `type_lawertypeid` (`lawertypeid`),
  CONSTRAINT `type_lawerid` FOREIGN KEY (`lawerid`) REFERENCES `jw_lawer` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `type_lawertypeid` FOREIGN KEY (`lawertypeid`) REFERENCES `jw_lawertype` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of jw_type_lawer
-- ----------------------------

-- ----------------------------
-- Table structure for jw_user用户表
-- ----------------------------
CREATE TABLE `jw_user` (
  `id` varchar(40) NOT NULL,
  `name` varchar(40) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `money` double(8,2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of jw_user
-- ----------------------------
