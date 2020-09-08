/*
Navicat MySQL Data Transfer

Source Server         : localtest
Source Server Version : 50712
Source Host           : localhost:3306
Source Database       : security

Target Server Type    : MYSQL
Target Server Version : 50712
File Encoding         : 65001

Date: 2020-09-08 15:25:59
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for s_authority
-- ----------------------------
DROP TABLE IF EXISTS `s_authority`;
CREATE TABLE `s_authority` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(255) DEFAULT NULL,
  `permission` varchar(255) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of s_authority
-- ----------------------------
INSERT INTO `s_authority` VALUES ('1', 'a1', 'admin', '/**');
INSERT INTO `s_authority` VALUES ('2', 'u1', 'user', '/user/**');

-- ----------------------------
-- Table structure for s_role
-- ----------------------------
DROP TABLE IF EXISTS `s_role`;
CREATE TABLE `s_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of s_role
-- ----------------------------
INSERT INTO `s_role` VALUES ('1', 'admin', '管理员', 'admin');
INSERT INTO `s_role` VALUES ('2', 'user', '用户', 'user');

-- ----------------------------
-- Table structure for s_role_auth
-- ----------------------------
DROP TABLE IF EXISTS `s_role_auth`;
CREATE TABLE `s_role_auth` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `auth_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of s_role_auth
-- ----------------------------
INSERT INTO `s_role_auth` VALUES ('1', '1', '1');
INSERT INTO `s_role_auth` VALUES ('2', '2', '2');

-- ----------------------------
-- Table structure for s_user
-- ----------------------------
DROP TABLE IF EXISTS `s_user`;
CREATE TABLE `s_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `age` int(11) NOT NULL,
  `create_time` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `tel` varchar(255) DEFAULT NULL,
  `update_time` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of s_user
-- ----------------------------
INSERT INTO `s_user` VALUES ('1', '18', '2020-08-10', 'jason@163.com', '123', '17679082000', '2020-08-10', 'admin');
INSERT INTO `s_user` VALUES ('2', '50', '2020-08-10', 'jason@163.com', '123', '17679082000', '2020-08-10', 'zhangsan');

-- ----------------------------
-- Table structure for s_user_role
-- ----------------------------
DROP TABLE IF EXISTS `s_user_role`;
CREATE TABLE `s_user_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of s_user_role
-- ----------------------------
INSERT INTO `s_user_role` VALUES ('1', '1', '1');
INSERT INTO `s_user_role` VALUES ('2', '2', '2');
INSERT INTO `s_user_role` VALUES ('3', '2', '1');
