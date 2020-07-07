/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 80017
Source Host           : localhost:3306
Source Database       : kafei-summary

Target Server Type    : MYSQL
Target Server Version : 80017
File Encoding         : 65001

Date: 2020-07-04 15:03:18
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `user_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `dept_id` bigint(20) DEFAULT NULL COMMENT '部门ID',
  `login_name` varchar(30) CHARACTER SET utf8 COLLATE utf8_german2_ci NOT NULL COMMENT '登录账号',
  `user_name` varchar(30) CHARACTER SET utf8 COLLATE utf8_german2_ci NOT NULL COMMENT '用户昵称',
  `user_type` varchar(2) CHARACTER SET utf8 COLLATE utf8_german2_ci DEFAULT '00' COMMENT '用户类型（00系统用户）',
  `email` varchar(50) CHARACTER SET utf8 COLLATE utf8_german2_ci DEFAULT '' COMMENT '用户邮箱',
  `phonenumber` varchar(11) CHARACTER SET utf8 COLLATE utf8_german2_ci DEFAULT '' COMMENT '手机号码',
  `sex` char(1) CHARACTER SET utf8 COLLATE utf8_german2_ci DEFAULT '0' COMMENT '用户性别（0男 1女 2未知）',
  `avatar` varchar(100) CHARACTER SET utf8 COLLATE utf8_german2_ci DEFAULT '' COMMENT '头像路径',
  `password` varchar(50) CHARACTER SET utf8 COLLATE utf8_german2_ci DEFAULT '' COMMENT '密码',
  `salt` varchar(20) CHARACTER SET utf8 COLLATE utf8_german2_ci DEFAULT '' COMMENT '盐加密',
  `status` char(1) CHARACTER SET utf8 COLLATE utf8_german2_ci DEFAULT '0' COMMENT '帐号状态（0正常 1停用）',
  `del_flag` char(1) CHARACTER SET utf8 COLLATE utf8_german2_ci DEFAULT '0' COMMENT '删除标志（0代表存在 2代表删除）',
  `login_ip` varchar(50) CHARACTER SET utf8 COLLATE utf8_german2_ci DEFAULT '' COMMENT '最后登陆IP',
  `login_date` datetime DEFAULT NULL COMMENT '最后登陆时间',
  `create_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_german2_ci DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_german2_ci DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) CHARACTER SET utf8 COLLATE utf8_german2_ci DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=110 DEFAULT CHARSET=utf8 COLLATE=utf8_german2_ci COMMENT='用户信息表';

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('1', '103', 'admin', '咖啡莫加糖', '00', 'ry@163.com', '15888888888', '0', '\\static\\avatar\\20200627125750db4dd908.png', 'admin123', '111111', '0', '0', '127.0.0.1', '2020-06-20 22:03:34', '咖啡', '2018-03-16 11:33:00', '咖啡', '2020-07-02 16:48:14', '管理员');
INSERT INTO `sys_user` VALUES ('101', null, 'liu_shuai', 'liu_shuai', '', '', '', '0', '\\static\\avatar\\20200702132314a4a2c48f.png', 'liu_shuai', '', '0', '0', '127.0.0.1', '2020-06-27 01:11:28', '咖啡', '2020-06-27 01:11:28', '咖啡', '2020-07-02 13:23:23', 'asdads');
INSERT INTO `sys_user` VALUES ('102', null, 'klllllll', 'sfda', '', '', '', '0', '', '123', 's', '0', '0', '127.0.0.1', '2020-06-30 10:54:04', '咖啡', '2020-06-30 10:54:04', '咖啡', '2020-07-03 10:05:48', 'sdfs');
INSERT INTO `sys_user` VALUES ('103', null, 'sdas', 'sad', '', '', '', '0', '', 'saa', 's', '0', '1', '127.0.0.1', '2020-06-30 11:09:14', '咖啡', '2020-06-30 11:09:14', '咖啡', '2020-06-30 11:09:14', 'c cx v');
INSERT INTO `sys_user` VALUES ('104', null, '12', '12', '', '', '', '0', '', '21', '', '1', '0', '127.0.0.1', '2020-06-30 11:10:28', '咖啡', '2020-06-30 11:10:28', '咖啡', '2020-06-30 11:10:28', '');
INSERT INTO `sys_user` VALUES ('105', null, '111', '111', '', '', '', '0', '', '11', '', '0', '0', '127.0.0.1', '2020-06-30 11:14:56', '咖啡', '2020-06-30 11:14:56', '咖啡', '2020-06-30 11:14:56', '');
INSERT INTO `sys_user` VALUES ('106', null, '121212', '121212', '', '', '', '0', '', '1212', '121212', '0', '0', '127.0.0.1', '2020-06-30 11:24:04', '咖啡', '2020-06-30 11:24:04', '咖啡', '2020-06-30 11:24:04', '');
INSERT INTO `sys_user` VALUES ('107', null, '13333', '3333', '', '', '', '0', '', '333', '', '0', '0', '127.0.0.1', '2020-06-30 11:27:20', '咖啡', '2020-06-30 11:27:20', '咖啡', '2020-06-30 11:27:20', '');
INSERT INTO `sys_user` VALUES ('109', null, 'qqq', '1111', '', '', '', '0', '\\static\\avatar\\20200702114953d6d5cef6.png', '555', '', '0', '0', '127.0.0.1', '2020-07-02 11:49:56', '咖啡', '2020-07-02 11:49:56', '咖啡', '2020-07-02 12:10:27', '');
