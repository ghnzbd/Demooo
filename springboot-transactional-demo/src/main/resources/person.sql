/*
Navicat MySQL Data Transfer

Source Server         : weige-阿里云
Source Server Version : 50648
Source Host           : 47.105.176.145:3306
Source Database       : readwritedemo

Target Server Type    : MYSQL
Target Server Version : 50648
File Encoding         : 65001

Date: 2021-03-06 18:42:28
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for person
-- ----------------------------
DROP TABLE IF EXISTS `person`;
CREATE TABLE `person` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of person
-- ----------------------------
