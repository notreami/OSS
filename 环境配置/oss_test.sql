/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50710
 Source Host           : localhost
 Source Database       : oss_test

 Target Server Type    : MySQL
 Target Server Version : 50710
 File Encoding         : utf-8

 Date: 01/06/2016 22:23:42 PM
*/

CREATE DATABASE `oss_test` DEFAULT CHARACTER SET utf8;

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `class`
-- ----------------------------
DROP TABLE IF EXISTS `class`;
CREATE TABLE `class` (
  `c_id` int(11) NOT NULL AUTO_INCREMENT,
  `c_name` varchar(20) DEFAULT NULL,
  `teacher_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`c_id`),
  KEY `fk_teacher_id` (`teacher_id`),
  CONSTRAINT `fk_teacher_id` FOREIGN KEY (`teacher_id`) REFERENCES `teacher` (`t_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `class`
-- ----------------------------
BEGIN;
INSERT INTO `class` VALUES ('1', 'class_a', '1'), ('2', 'class_b', '2');
COMMIT;

-- ----------------------------
--  Table structure for `fddatas`
-- ----------------------------
DROP TABLE IF EXISTS `fddatas`;
CREATE TABLE `fddatas` (
  `id` decimal(18,0) NOT NULL,
  `fdid` int(11) NOT NULL AUTO_INCREMENT,
  `version` int(11) NOT NULL DEFAULT '1',
  `createtime` datetime NOT NULL,
  `updatetime` datetime NOT NULL,
  `operator` varchar(64) NOT NULL DEFAULT '',
  `operator_mail` varchar(64) NOT NULL DEFAULT '',
  `org` char(3) NOT NULL DEFAULT '' COMMENT 'airport_from，出发',
  `dst` char(3) NOT NULL DEFAULT '' COMMENT 'airport_to，到达',
  `carrier` char(5) NOT NULL DEFAULT '' COMMENT '航空公司',
  `cabin` char(5) NOT NULL DEFAULT '' COMMENT '舱位',
  `cabin_type` char(1) NOT NULL DEFAULT '' COMMENT '舱位类型',
  `airline_type` char(2) NOT NULL DEFAULT '' COMMENT 'ow : 单程, rt : 往返',
  `distance` float NOT NULL DEFAULT '0' COMMENT '航程',
  `fuel_tax` float NOT NULL DEFAULT '0' COMMENT '燃油税',
  `price` float NOT NULL DEFAULT '0' COMMENT '运价',
  `discount` float NOT NULL DEFAULT '0' COMMENT '折扣',
  `currency` char(5) NOT NULL DEFAULT 'CNY' COMMENT '货币，人民币为CNY',
  `start_date` date NOT NULL COMMENT '运价数据的生效时间',
  `end_date` date NOT NULL COMMENT '运价数据的失效时间',
  `start_date2` bigint(20) DEFAULT '0' COMMENT '运价数据的生效时间，毫秒为单位',
  `end_date2` bigint(20) DEFAULT '0' COMMENT '运价数据的失效时间，毫秒微单位',
  `source` char(3) NOT NULL DEFAULT 'FD' COMMENT 'STA、MAN、FD、OLD（就是FD-OLD）、NFD、NFD-OLD',
  `verify_time` datetime NOT NULL COMMENT '有效时间',
  `remark` text NOT NULL COMMENT '注意事项',
  `status` tinyint(1) NOT NULL DEFAULT '2' COMMENT '状态：0，删除；1，有效；2，待审；3:实效；',
  `opid` char(32) NOT NULL DEFAULT '',
  PRIMARY KEY (`fdid`),
  KEY `idx_search` (`org`,`dst`,`carrier`),
  KEY `status_search` (`status`),
  KEY `verify_search` (`verify_time`),
  KEY `source_status_search` (`source`,`status`),
  KEY `idx_id` (`id`),
  KEY `idx_carrier` (`carrier`),
  KEY `idx_query` (`airline_type`,`status`,`fdid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `fddatas`
-- ----------------------------
BEGIN;
INSERT INTO `fddatas` VALUES ('1', '1', '1', '2016-01-06 13:41:12', '2016-01-06 13:41:14', '1', '1', '1', '1', '1', '1', '1', '1', '11', '1', '1', '1', '1', '2016-01-06', '2016-01-06', '1', '1', '1', '2016-01-06 13:41:46', '1', '1', '1');
COMMIT;

-- ----------------------------
--  Table structure for `orders`
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders` (
  `order_id` int(11) NOT NULL AUTO_INCREMENT,
  `order_no` varchar(20) DEFAULT NULL,
  `order_price` float DEFAULT NULL,
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `orders`
-- ----------------------------
BEGIN;
INSERT INTO `orders` VALUES ('1', 'aaaa', '23'), ('2', 'bbbb', '33'), ('3', 'cccc', '22');
COMMIT;

-- ----------------------------
--  Table structure for `p_user`
-- ----------------------------
DROP TABLE IF EXISTS `p_user`;
CREATE TABLE `p_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(10) DEFAULT NULL,
  `sex` varchar(4) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `p_user`
-- ----------------------------
BEGIN;
INSERT INTO `p_user` VALUES ('1', 'A', '男'), ('2', 'B', '女'), ('3', 'C', '男');
COMMIT;

-- ----------------------------
--  Table structure for `student`
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `s_id` int(11) NOT NULL AUTO_INCREMENT,
  `s_name` varchar(20) DEFAULT NULL,
  `class_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`s_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `student`
-- ----------------------------
BEGIN;
INSERT INTO `student` VALUES ('1', 'student_A', '1'), ('2', 'student_B', '1'), ('3', 'student_C', '1'), ('4', 'student_D', '2'), ('5', 'student_E', '2'), ('6', 'student_F', '2');
COMMIT;

-- ----------------------------
--  Table structure for `t_user`
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `user_id` varchar(32) NOT NULL,
  `user_name` varchar(30) DEFAULT NULL,
  `user_birthday` date DEFAULT NULL,
  `user_salary` double DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `t_user`
-- ----------------------------
BEGIN;
INSERT INTO `t_user` VALUES ('4eb7f208f30e48fe8324f6b021522116', '白虎神皇xdp', '2016-01-05', '10000'), ('730979cd517e41eeb0f59a13fab8c198', '白虎神皇xdp', '2016-01-02', '10000'), ('9d4f33fa7ff34b8688d4205daf6602a2', '白虎神皇xdp', '2016-01-02', '10000'), ('fb1c5941094e400b975f10d9a9d602a3', 'xdp_gacl_白虎神皇', '2016-01-02', '10000'), ('fb1c5941094e400b975f10d9a9d602a4', 'xdp_gacl_白虎神皇', '2016-01-05', '10000');
COMMIT;

-- ----------------------------
--  Table structure for `teacher`
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher` (
  `t_id` int(11) NOT NULL AUTO_INCREMENT,
  `t_name` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`t_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `teacher`
-- ----------------------------
BEGIN;
INSERT INTO `teacher` VALUES ('1', 'teacher1'), ('2', 'teacher2');
COMMIT;

-- ----------------------------
--  Table structure for `users`
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL COMMENT '名字',
  `age` int(11) DEFAULT NULL COMMENT '年龄',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `users`
-- ----------------------------
BEGIN;
INSERT INTO `users` VALUES ('1', '孤傲苍狼', '27'), ('2', '白虎神皇', '27');
COMMIT;

-- ----------------------------
--  Procedure structure for `get_user_count`
--  创建存储过程(查询得到男性或女性的数量, 如果传入的是0就女性否则是男性)
-- ----------------------------
DROP PROCEDURE IF EXISTS `get_user_count`;
delimiter ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `get_user_count`(IN sex_id int,OUT user_count int)
begin
if sex_id=0 then
select count(*) from oss_test.p_user where p_user.sex='女' into user_count;
else
select count(*) from oss_test.p_user where p_user.sex='男' into user_count;
end if;
end
 ;;
delimiter ;

SET FOREIGN_KEY_CHECKS = 1;
