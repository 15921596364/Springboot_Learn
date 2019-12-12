/*
 Navicat Premium Data Transfer

 Source Server         : Mtime_learn_mysql
 Source Server Type    : MySQL
 Source Server Version : 50646
 Source Host           : 192.168.198.100:3306
 Source Schema         : mtime

 Target Server Type    : MySQL
 Target Server Version : 50646
 File Encoding         : 65001

 Date: 11/12/2019 10:00:13
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for cinema
-- ----------------------------
DROP TABLE IF EXISTS `cinema`;
CREATE TABLE `cinema`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键自增',
  `inner_code` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '影院内码',
  `gov_code` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '影院内码',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '影院名称',
  `hall_count` int(255) NULL DEFAULT NULL COMMENT '影厅数',
  `seat_count` int(10) NULL DEFAULT NULL COMMENT '座位数',
  `property_type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '物业类型',
  `region_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '区域',
  `province_id` int(11) NULL DEFAULT NULL COMMENT '省份',
  `city_id` int(11) NULL DEFAULT NULL COMMENT '城市',
  `open_status` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '开业状态',
  `business_start_time` datetime(0) NULL DEFAULT NULL COMMENT '营业起始时间',
  `business_end_time` datetime(0) NULL DEFAULT NULL COMMENT '营业终止时间',
  `dna_items` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'DNA标签',
  `deleted` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '是否删除',
  `box_office_count` double NULL DEFAULT NULL COMMENT '去年票房总量',
  `update_user` int(11) NULL DEFAULT NULL COMMENT '操作用户',
  `update_time` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of cinema
-- ----------------------------
INSERT INTO `cinema` VALUES (1, '111', '1111111', '北京CBD万达影院', 30, 5555, 'A', '01', 1, 1, 'true', NULL, NULL, 'a,b,c', '0', 200000000, 1, '2019-12-10 15:53:45');
INSERT INTO `cinema` VALUES (2, '112', '1111112', '北京通州万达广场店', 28, 5555, 'A', '01', 1, 1, 'true', NULL, NULL, 'd,e,f', '0', 290000000, 1, '2019-12-10 15:53:45');
INSERT INTO `cinema` VALUES (3, '113', '1111113', '北京朝阳万达广场店', 31, 5555, 'A', '01', 1, 1, 'true', NULL, NULL, 'r,o,h', '0', 250000000, 1, '2019-12-10 15:53:45');
INSERT INTO `cinema` VALUES (4, '114', '1111114', '北京龙德广场店', 22, 5555, 'B', '01', 1, 1, 'true', NULL, NULL, 'd,f,g', '0', 180000000, 1, '2019-12-10 15:53:45');
INSERT INTO `cinema` VALUES (5, '115', '1111115', '北京石景山万达广场店', 25, 5555, 'B', '01', 1, 1, 'true', NULL, NULL, 'r,f,g', '0', 160000000, 1, '2019-12-10 15:53:45');
INSERT INTO `cinema` VALUES (6, '6', '1116', '测试万达广场店', 20, 5555, 'B', '01', 1, 1, 'true', NULL, NULL, 'V,B,B', '0', 100000000, 1, '2019-12-10 15:53:45');
INSERT INTO `cinema` VALUES (7, '117', '1111117', 'demo万达广场店', 12343, 88888, 'B', '01', 1, 1, 'true', NULL, NULL, 'a,s,d,f', '0', 160000000, 1, '2019-12-10 16:18:17');

SET FOREIGN_KEY_CHECKS = 1;
