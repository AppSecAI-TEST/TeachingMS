/*
Navicat MySQL Data Transfer

Source Server         : my
Source Server Version : 50624
Source Host           : localhost:3306
Source Database       : db_soft

Target Server Type    : MYSQL
Target Server Version : 50624
File Encoding         : 65001

Date: 2017-08-04 15:55:28
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `t_class`
-- ----------------------------
DROP TABLE IF EXISTS `t_class`;
CREATE TABLE `t_class` (
  `class_id` varchar(255) NOT NULL COMMENT '班级编号（如：20171001）',
  `teacher_name` varchar(255) DEFAULT NULL COMMENT '教师名字',
  `scale_id` int(11) NOT NULL COMMENT '教室规模id（关联教室规模表）',
  PRIMARY KEY (`class_id`),
  KEY `scale_id` (`scale_id`),
  CONSTRAINT `scale_id` FOREIGN KEY (`scale_id`) REFERENCES `t_scale` (`scale_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='班级信息';

-- ----------------------------
-- Records of t_class
-- ----------------------------

-- ----------------------------
-- Table structure for `t_scale`
-- ----------------------------
DROP TABLE IF EXISTS `t_scale`;
CREATE TABLE `t_scale` (
  `scale_id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `row` int(11) NOT NULL DEFAULT '0' COMMENT '排',
  `column` int(11) NOT NULL DEFAULT '0' COMMENT '列',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`scale_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='教室规模';

-- ----------------------------
-- Records of t_scale
-- ----------------------------

-- ----------------------------
-- Table structure for `t_stu`
-- ----------------------------
DROP TABLE IF EXISTS `t_stu`;
CREATE TABLE `t_stu` (
  `stu_id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(255) NOT NULL COMMENT '学生名字',
  `phone` varchar(255) DEFAULT NULL COMMENT '联系方式',
  `qq` varchar(255) DEFAULT NULL COMMENT 'qq号',
  `email` varchar(255) DEFAULT NULL COMMENT '邮箱',
  `row` int(11) DEFAULT NULL COMMENT '排',
  `column` int(11) DEFAULT NULL COMMENT '列',
  `class_id` varchar(255) DEFAULT NULL COMMENT '所属班级编号',
  PRIMARY KEY (`stu_id`),
  KEY `class_id` (`class_id`),
  CONSTRAINT `class_id` FOREIGN KEY (`class_id`) REFERENCES `t_class` (`class_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='学生信息';

-- ----------------------------
-- Records of t_stu
-- ----------------------------
