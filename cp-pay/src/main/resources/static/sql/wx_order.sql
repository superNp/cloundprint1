/*
 Navicat Premium Data Transfer

 Source Server         : wxpay
 Source Server Type    : MySQL
 Source Server Version : 80011
 Source Host           : localhost:3306
 Source Schema         : wxpay

 Target Server Type    : MySQL
 Target Server Version : 80011
 File Encoding         : 65001

 Date: 30/10/2020 09:54:23
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for wx_order
-- ----------------------------
DROP TABLE IF EXISTS `wx_order`;
CREATE TABLE `wx_order`  (
  `id` varchar(50) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `outtradeno` varchar(50) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '订单号',
  `totalfree` int(255) NULL DEFAULT NULL COMMENT '商品价格，分位',
  `body` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '商品',
  `starttime` datetime(0) NULL DEFAULT NULL COMMENT '订单起始时间',
  `endtime` datetime(0) NULL DEFAULT NULL COMMENT '订单完成时间',
  `userid` varchar(100) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '用户id',
  `paytime` datetime(0) NULL DEFAULT NULL COMMENT '支付时间',
  `zfbz` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '支付标志 Y 已支付 N未支付 F取消支付 ',
  `yxbz` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '有效标志 Y有效 N无效',
  `code_url` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '支付地址',
  `prepay_id` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '支付会话标识',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of wx_order
-- ----------------------------
INSERT INTO `wx_order` VALUES ('7C28164660D942A0B31B5C23ED67FBB9', 'dddb48cc160329537613731786208381', 582, '扫码停车', '2020-10-23 23:49:02', '2020-10-28 00:53:16', '1500000011', NULL, 'N', 'Y', 'weixin://wxpay/bizpayurl?pr=sMSoTKN00', 'wx28005317801027a4155f568ac669bf0000');

SET FOREIGN_KEY_CHECKS = 1;
