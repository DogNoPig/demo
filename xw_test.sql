/*
Navicat MySQL Data Transfer

Source Server         : 192.168.1.248
Source Server Version : 50510
Source Host           : 192.168.1.248:3306
Source Database       : xw_test

Target Server Type    : MYSQL
Target Server Version : 50510
File Encoding         : 65001

Date: 2019-03-29 17:45:24
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for category_
-- ----------------------------
DROP TABLE IF EXISTS `category_`;
CREATE TABLE `category_` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of category_
-- ----------------------------
INSERT INTO `category_` VALUES ('1', 'category 1');
INSERT INTO `category_` VALUES ('2', 'category 2');
INSERT INTO `category_` VALUES ('3', 'category 3');
INSERT INTO `category_` VALUES ('4', 'category 4');
INSERT INTO `category_` VALUES ('5', 'category 5');
INSERT INTO `category_` VALUES ('6', 'category 6');
INSERT INTO `category_` VALUES ('7', 'category 7');
INSERT INTO `category_` VALUES ('8', 'category 8');

-- ----------------------------
-- Table structure for category_1
-- ----------------------------
DROP TABLE IF EXISTS `category_1`;
CREATE TABLE `category_1` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of category_1
-- ----------------------------
INSERT INTO `category_1` VALUES ('5', 'category 1');
INSERT INTO `category_1` VALUES ('6', 'category 2');
INSERT INTO `category_1` VALUES ('7', 'category 3');
INSERT INTO `category_1` VALUES ('8', 'category 4');

-- ----------------------------
-- Table structure for sys_permission
-- ----------------------------
DROP TABLE IF EXISTS `sys_permission`;
CREATE TABLE `sys_permission` (
  `PERMISION_ID` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '权限id',
  `PERMISION_NAME` varchar(50) DEFAULT NULL COMMENT '权限名称',
  `PERMISION_MARK` varchar(50) DEFAULT NULL COMMENT '权限标志',
  `PERMISION_DESCRIPTION` varchar(250) DEFAULT NULL COMMENT '权限描述',
  `CREATE_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `CREATE_BY` int(11) DEFAULT NULL,
  `UPDATE_TIME` datetime DEFAULT NULL COMMENT '修改时间',
  `UPDATE_BY` int(11) DEFAULT NULL,
  PRIMARY KEY (`PERMISION_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_permission
-- ----------------------------
INSERT INTO `sys_permission` VALUES ('1', '一级权限', 'NO1', null, '2019-03-15 15:56:21', '1', null, null);
INSERT INTO `sys_permission` VALUES ('2', '二级权限', 'NO2', null, '2019-03-15 15:56:53', '1', null, null);

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `ROLE_ID` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '角色id',
  `ROLE_NAME` varchar(50) DEFAULT NULL COMMENT '角色名称',
  `ROLE_MARK` varchar(50) DEFAULT NULL COMMENT '角色标志',
  `CREATE_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `CREATE_BY` int(11) DEFAULT NULL COMMENT '创建人',
  `UPDATE_TIME` datetime DEFAULT NULL COMMENT '修改人',
  `UPDATE_BY` int(11) DEFAULT NULL COMMENT '修改人',
  PRIMARY KEY (`ROLE_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('1', '创建者', 'root', '2019-03-15 15:58:57', '1', null, null);
INSERT INTO `sys_role` VALUES ('2', '使用者', 'user', '2019-03-15 15:59:12', '1', null, null);

-- ----------------------------
-- Table structure for sys_role_permission
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_permission`;
CREATE TABLE `sys_role_permission` (
  `ROLE_ID` int(11) NOT NULL,
  `PERMISSION_ID` int(11) NOT NULL,
  PRIMARY KEY (`ROLE_ID`,`PERMISSION_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role_permission
-- ----------------------------
INSERT INTO `sys_role_permission` VALUES ('1', '1');
INSERT INTO `sys_role_permission` VALUES ('1', '2');
INSERT INTO `sys_role_permission` VALUES ('2', '2');

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `USER_ID` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `USER_NAME` varchar(50) DEFAULT NULL,
  `PASSWORD` varchar(255) DEFAULT NULL,
  `ADD_TIME` datetime DEFAULT NULL,
  `ADD_BY` int(11) DEFAULT NULL,
  PRIMARY KEY (`USER_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('1', 'root', 'root', '2019-03-15 16:00:22', '1');
INSERT INTO `sys_user` VALUES ('2', 'user', 'user', '2019-03-15 16:00:55', '1');
INSERT INTO `sys_user` VALUES ('3', 'loser', 'loser', '2019-03-18 16:45:21', '1');

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role` (
  `USER_ID` int(11) NOT NULL,
  `ROLE_ID` int(11) NOT NULL,
  PRIMARY KEY (`USER_ID`,`ROLE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES ('1', '1');
INSERT INTO `sys_user_role` VALUES ('2', '2');
