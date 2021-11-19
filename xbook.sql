/*
 Navicat Premium Data Transfer

 Source Server         : Remeio-AliServer
 Source Server Type    : MySQL
 Source Server Version : 50733
 Source Host           : 115.29.198.114:3306
 Source Schema         : xbook

 Target Server Type    : MySQL
 Target Server Version : 50733
 File Encoding         : 65001

 Date: 19/11/2021 15:49:55
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for book
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '书籍ID',
  `book_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL DEFAULT '' COMMENT '书籍名称',
  `book_isbn` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '书籍ISBN',
  `book_description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '书籍描述',
  `book_max_period` int(11) UNSIGNED NOT NULL DEFAULT 0 COMMENT '书籍借出最大周期',
  `book_deposit` bigint(11) UNSIGNED NOT NULL DEFAULT 0 COMMENT '书籍所需押金',
  `book_image_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL DEFAULT '' COMMENT '书籍图片URL',
  `book_catalog_id` bigint(20) UNSIGNED NOT NULL DEFAULT 0 COMMENT '书籍分类ID',
  `school_id` bigint(20) UNSIGNED NOT NULL DEFAULT 0 COMMENT '学校ID',
  `user_id` bigint(20) UNSIGNED NOT NULL DEFAULT 0 COMMENT '用户ID',
  `book_status` int(1) UNSIGNED NOT NULL DEFAULT 0 COMMENT '书籍状态【1：空闲，2：受理中，3：异常，4：已下架，5：已删除】',
  `gmt_create` datetime(6) NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 60 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for book_catalog
-- ----------------------------
DROP TABLE IF EXISTS `book_catalog`;
CREATE TABLE `book_catalog`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '书籍分类ID',
  `book_catalog_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '书籍分类名称',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uq_book_catalog_name`(`book_catalog_name`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 16 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for bookcase
-- ----------------------------
DROP TABLE IF EXISTS `bookcase`;
CREATE TABLE `bookcase`  (
  `id` bigint(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_id` bigint(10) UNSIGNED NOT NULL DEFAULT 0 COMMENT '用户ID',
  `book_id` bigint(10) UNSIGNED NOT NULL DEFAULT 0 COMMENT '书籍ID',
  `gmt_create` datetime(6) NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 52 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for deposit
-- ----------------------------
DROP TABLE IF EXISTS `deposit`;
CREATE TABLE `deposit`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '押金ID',
  `deposit_order_no` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '押金订单号',
  `deposit_amount` bigint(20) UNSIGNED NOT NULL DEFAULT 0 COMMENT '押金金额',
  `deposit_operate_type` int(1) UNSIGNED NOT NULL DEFAULT 0 COMMENT '操作类型：【1：缴纳，2：提取，3：占用押金，4：释放押金，5：支付损失，6：所得补偿】',
  `user_id` bigint(20) UNSIGNED NOT NULL COMMENT '用户ID',
  `inner_order_no` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL DEFAULT '' COMMENT '内部订单号（关联支付损失和所得补偿）',
  `outer_order_no` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '外部订单号（关联缴纳和提取）',
  `gmt_create` datetime(6) NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 112 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for feedback
-- ----------------------------
DROP TABLE IF EXISTS `feedback`;
CREATE TABLE `feedback`  (
  `id` bigint(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_id` bigint(10) UNSIGNED NOT NULL DEFAULT 0 COMMENT '用户ID',
  `feedback_content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '反馈内容',
  `feedback_order` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '反馈关联订单',
  `gmt_create` datetime(6) NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for message
-- ----------------------------
DROP TABLE IF EXISTS `message`;
CREATE TABLE `message`  (
  `id` bigint(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键',
  `message_content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '消息内容',
  `share_record_id` bigint(10) UNSIGNED NOT NULL DEFAULT 0 COMMENT '共享记录ID',
  `operator_type` int(1) UNSIGNED NOT NULL DEFAULT 0 COMMENT '操作人类型【1：共享者，2：借阅者】',
  `gmt_create` datetime(6) NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 111 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for school
-- ----------------------------
DROP TABLE IF EXISTS `school`;
CREATE TABLE `school`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '学校ID',
  `school_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '学校名称',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for share_log
-- ----------------------------
DROP TABLE IF EXISTS `share_log`;
CREATE TABLE `share_log`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '共享日志ID',
  `share_record_id` bigint(20) UNSIGNED NOT NULL DEFAULT 0 COMMENT '共享记录ID',
  `share_record_status` int(1) UNSIGNED NOT NULL DEFAULT 0 COMMENT '共享记录状态【1：已下单，2：借阅中，3：已归还，4：逾期归还，5：下单后取消，6：书籍丢失或严重受损，7：书籍超时严重不归还】',
  `operator_type` int(1) UNSIGNED NOT NULL DEFAULT 0 COMMENT '操作人类型【1：共享者，2：借阅者】',
  `gmt_create` datetime(6) NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 131 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for share_record
-- ----------------------------
DROP TABLE IF EXISTS `share_record`;
CREATE TABLE `share_record`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '共享记录ID',
  `order_no` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '订单号',
  `book_id` bigint(20) UNSIGNED NOT NULL DEFAULT 0 COMMENT '书籍ID',
  `share_user_id` bigint(20) UNSIGNED NOT NULL DEFAULT 0 COMMENT '共享者ID',
  `borrow_user_id` bigint(20) UNSIGNED NOT NULL DEFAULT 0 COMMENT '借阅者ID',
  `record_status` int(1) UNSIGNED NOT NULL DEFAULT 0 COMMENT '共享记录状态【1：已下单，2：借阅中，3：已归还，4：逾期归还，5：下单后取消，6：书籍丢失或严重受损，7：书籍超时严重不归还】',
  `score` double(5, 1) UNSIGNED NOT NULL DEFAULT 0.0 COMMENT '评分【1，1.5，2，2.5，3，3.5，4，4.5，5】',
  `gmt_create` datetime(6) NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 54 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `user_phone` varchar(20) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL DEFAULT '' COMMENT '用户手机号',
  `user_password` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL DEFAULT '' COMMENT '用户密码',
  `user_full_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '用户姓名',
  `school_id` bigint(20) UNSIGNED NOT NULL DEFAULT 0 COMMENT '学校ID',
  `can_use_deposit` bigint(20) UNSIGNED NOT NULL DEFAULT 0 COMMENT '可用押金',
  `occupy_deposit` bigint(20) UNSIGNED NOT NULL DEFAULT 0 COMMENT '占用押金',
  `loss_deposit` bigint(20) UNSIGNED NOT NULL DEFAULT 0 COMMENT '支付损失押金',
  `make_up_deposit` bigint(20) UNSIGNED NOT NULL DEFAULT 0 COMMENT '所得补偿押金',
  `gmt_create` datetime(6) NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = DYNAMIC;

SET FOREIGN_KEY_CHECKS = 1;
