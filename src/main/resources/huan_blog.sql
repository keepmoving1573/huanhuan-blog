/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : huan_blog

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2017-01-12 17:03:33
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for article_list
-- ----------------------------
DROP TABLE IF EXISTS `article_list`;
CREATE TABLE `article_list` (
  `id` varchar(100) NOT NULL,
  `content` text,
  `subject` varchar(255) DEFAULT NULL,
  `create_time` varchar(255) DEFAULT NULL,
  `user_id` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `img_url` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of article_list
-- ----------------------------
INSERT INTO `article_list` VALUES ('4123gsdfgsgsdf', '2014第一版《草根寻梦》个人博客模板简单、优雅、稳重、大气、低调。专为年轻有志向却又低调的草根站长设计。模板采用html5+css3设计，nav导航实现鼠标悬停渐变显示英文标题的效果。banner部分，选择大图作为背景，利用css3中animation属性结合文字图片实现文字从左到右的渐变效果', '个人博客模板（2014草根寻梦）', '2014-05-19 11:11:00', '1', 'diary', '/images/02.jpg');
INSERT INTO `article_list` VALUES ('8789gshfggsdf', '之前服务器放在电信机房，\r\n                        联通用户访问速度很不稳定，经常出现访问速度慢的问题，换到阿里云解决了之前的问题。很多人都问我的博客选得什么空间，一年的费用得多少钱，今天我列个表出来，供大家参考。', '我的个人博客之――阿里云空间选择', '2014-05-19 11:11:00', '1', 'diary', '/images/03.png');
INSERT INTO `article_list` VALUES ('dasdfa413241234', '看到昔日好友发了一篇日志《咎由自取》他说他是一个悲观者，感觉社会抛弃了他，脾气、性格在6年的时间里变化很大，很难适应这个社会。人生其实就是不断犯错的过程，在这个过程中不断的犯错，不断的吸取教训，不断的成长。也许日子里的惊涛骇浪，不过是人生中的水花摇晃，别用显微镜放大你的悲伤。', '犯错了怎么办？', '2014-05-19 11:11:00', '1', 'diary', '/images/01.jpg');
INSERT INTO `article_list` VALUES ('fasdfadf868968', '本应用由CSS3代码实现，无图片和flash，请使用Chrome等webkit内核浏览器或Firefox打开。破解攻略和大家分享下：首先，破解魔方，我们就要先了解它的结构，魔方共6色6面，每面又分为中央块（最中间的块6个）、角块（4角的块8个）和边块（4条边中间的块12个）...', 'css3制作的一个魔方', '2014-05-19 11:11:00', '1', 'diary', '/images/04.png');
INSERT INTO `article_list` VALUES ('sgfdgs867hfghd', '作为一个优秀、专业的网页设计师，首先要了解各种颜色的象征，以及不同类型网站常用的色彩搭配。色彩搭配看似复杂,但并不神秘。一般来说,网页的背景色应该柔和一些、素一些、淡一些,再配上深色的文字,使人看起来自然、舒畅。色彩是人的视觉最敏感的东西。主页的色彩处理得好，可以锦上添花，达到事半功倍的效果。', '从摄影作品中获取网页颜色搭配技巧', '2014-05-19 11:11:00', '1', 'diary', '/images/04.jpg');

-- ----------------------------
-- Table structure for article_type
-- ----------------------------
DROP TABLE IF EXISTS `article_type`;
CREATE TABLE `article_type` (
  `id` varchar(100) NOT NULL,
  `code` varchar(100) DEFAULT NULL,
  `name` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of article_type
-- ----------------------------
INSERT INTO `article_type` VALUES ('fasdfas2weeqw', 'diary', '日记');
INSERT INTO `article_type` VALUES ('fasdjiuyte31275678', 'website_build', '网站建设');

-- ----------------------------
-- Table structure for user_info
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info` (
  `id` varchar(100) NOT NULL,
  `username` varchar(255) DEFAULT NULL,
  `net_name` varchar(255) DEFAULT NULL,
  `job` varchar(255) DEFAULT NULL,
  `family_native_place` varchar(255) DEFAULT NULL,
  `mobile` varchar(100) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_info
-- ----------------------------
INSERT INTO `user_info` VALUES ('1', '樱木花道', 'heikehuan', 'java后端开发', '湘北省麻衣市', '15010696511', '873081235@qq.com');
