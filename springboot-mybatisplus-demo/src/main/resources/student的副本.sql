/*
 Navicat Premium Data Transfer

 Source Server         : my-aliyun
 Source Server Type    : MySQL
 Source Server Version : 50562
 Source Host           : 39.105.30.146:3306
 Source Schema         : test

 Target Server Type    : MySQL
 Target Server Version : 50562
 File Encoding         : 65001

 Date: 10/03/2021 20:15:46
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `sex` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of student
-- ----------------------------
BEGIN;
INSERT INTO `student` VALUES (1, '1', 1, 1);
INSERT INTO `student` VALUES (2, 'lisi', 12, 0);
INSERT INTO `student` VALUES (3, 'wangwu', 20, 1);
INSERT INTO `student` VALUES (6, '1', 1, 1);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
