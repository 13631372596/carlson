/*
Navicat MySQL Data Transfer

Source Server         : rootadmin
Source Server Version : 50611
Source Host           : 127.0.0.1:3306
Source Database       : carlson-demo

Target Server Type    : MYSQL
Target Server Version : 50611
File Encoding         : 65001

Date: 2017-11-27 23:41:58
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tb_demo_permission
-- ----------------------------
DROP TABLE IF EXISTS `tb_demo_permission`;
CREATE TABLE `tb_demo_permission` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `permissionName` varchar(20) DEFAULT NULL,
  `permissionValue` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_demo_permission
-- ----------------------------
INSERT INTO `tb_demo_permission` VALUES ('2', '修改', 'edit');
INSERT INTO `tb_demo_permission` VALUES ('3', '新增', 'add');

-- ----------------------------
-- Table structure for tb_demo_role
-- ----------------------------
DROP TABLE IF EXISTS `tb_demo_role`;
CREATE TABLE `tb_demo_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `roleName` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_demo_role
-- ----------------------------

-- ----------------------------
-- Table structure for tb_demo_role_permission
-- ----------------------------
DROP TABLE IF EXISTS `tb_demo_role_permission`;
CREATE TABLE `tb_demo_role_permission` (
  `roleId` int(11) NOT NULL,
  `permissionId` int(11) NOT NULL,
  PRIMARY KEY (`roleId`,`permissionId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_demo_role_permission
-- ----------------------------
INSERT INTO `tb_demo_role_permission` VALUES ('2', '3');

-- ----------------------------
-- Table structure for tb_demo_user
-- ----------------------------
DROP TABLE IF EXISTS `tb_demo_user`;
CREATE TABLE `tb_demo_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_demo_user
-- ----------------------------
INSERT INTO `tb_demo_user` VALUES ('1', 'admin', 'carlson');

-- ----------------------------
-- Table structure for tb_demo_user_role
-- ----------------------------
DROP TABLE IF EXISTS `tb_demo_user_role`;
CREATE TABLE `tb_demo_user_role` (
  `userId` int(11) NOT NULL,
  `roleId` int(11) NOT NULL,
  PRIMARY KEY (`userId`,`roleId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_demo_user_role
-- ----------------------------
