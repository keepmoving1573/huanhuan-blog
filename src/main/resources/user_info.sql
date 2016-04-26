/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50627
Source Host           : localhost:3306
Source Database       : huan_blog

Target Server Type    : MYSQL
Target Server Version : 50627
File Encoding         : 65001

Date: 2016-04-27 01:03:49
*/

SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for user_info
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info` (
  `id`                  VARCHAR(100) NOT NULL,
  `username`            VARCHAR(255) DEFAULT NULL,
  `net_name`            VARCHAR(255) DEFAULT NULL,
  `job`                 VARCHAR(255) DEFAULT NULL,
  `family_native_place` VARCHAR(255) DEFAULT NULL,
  `mobile`              VARCHAR(100) DEFAULT NULL,
  `email`               VARCHAR(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

-- ----------------------------
-- Records of user_info
-- ----------------------------
INSERT INTO `user_info` VALUES ('1', '詹欢欢', 'heikehuan', 'java后端开发', '湖北省孝感市', '15010696512', '873089992@qq.com');
