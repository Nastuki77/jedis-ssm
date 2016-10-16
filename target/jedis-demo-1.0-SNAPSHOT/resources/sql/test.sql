/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50624
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50624
File Encoding         : 65001

Date: 2016-10-14 18:26:39
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `permit`
-- ----------------------------
DROP TABLE IF EXISTS `permit`;
CREATE TABLE `permit` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `moduleName` varchar(30) DEFAULT NULL,
  `moduleValue` varchar(30) DEFAULT NULL,
  `permitName` varchar(30) DEFAULT NULL,
  `permitValue` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of permit
-- ----------------------------
INSERT INTO `permit` VALUES ('1', '用户', 'user', '主页', 'home');
INSERT INTO `permit` VALUES ('9', '登陆', 'login', '登陆验证', 'loginConfirm');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) NOT NULL,
  `age` int(3),
  `password` varchar(32) NOT NULL,
  `email` varchar(20) DEFAULT NULL,
  `address` varchar(80) DEFAULT NULL,
  `permissions` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('9', 'alice', '0', '123123', 'chaiql@qq.com', '', '');
INSERT INTO `user` VALUES ('10', 'Nastuki', '0', '08b8ce5e05c3bd07d4d4bb0848fe51ad', 'chaiql@qq.com', '', '');
