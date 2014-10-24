/*
Navicat MySQL Data Transfer

Source Server         : MySql
Source Server Version : 50530
Source Host           : localhost:3306
Source Database       : ehcachetest

Target Server Type    : MYSQL
Target Server Version : 50530
File Encoding         : 65001

Date: 2014-10-25 00:33:34
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) NOT NULL,
  `age` tinyint(4) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES ('1', 'ian', '21');
INSERT INTO `users` VALUES ('2', 'wade', '33');
INSERT INTO `users` VALUES ('3', 'joe', '13');
