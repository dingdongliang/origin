/*
Navicat MySQL Data Transfer

Source Server         : 本地库
Source Server Version : 50533
Source Host           : localhost:3306
Source Database       : origin

Target Server Type    : MYSQL
Target Server Version : 50533
File Encoding         : 65001

Date: 2016-05-13 18:23:13
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for gen_answer
-- ----------------------------
DROP TABLE IF EXISTS `gen_answer`;
CREATE TABLE `gen_answer` (
  `ANSR_ID` varchar(32) NOT NULL COMMENT '答复ID',
  `QSTN_ID` varchar(32) NOT NULL COMMENT '问题ID',
  `ANSR_DESC` varchar(5000) DEFAULT NULL COMMENT '回答内容描述',
  `ANSR_AGREE` int(11) DEFAULT '0' COMMENT '赞同次数',
  `ANSR_OPOS` int(11) DEFAULT '0' COMMENT '反对次数',
  `CREATED` datetime DEFAULT NULL COMMENT '回答日期',
  `LASTMOD` datetime DEFAULT NULL COMMENT '修改日期',
  `CREATER` varchar(32) DEFAULT NULL COMMENT '回答人',
  `MODIFYER` varchar(32) DEFAULT NULL COMMENT '修改人',
  PRIMARY KEY (`QSTN_ID`),
  KEY `FK_ANSR_QSTN` (`QSTN_ID`),
  CONSTRAINT `FK_ANSR_QSTN` FOREIGN KEY (`QSTN_ID`) REFERENCES `gen_question` (`QSTN_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='答题表';

-- ----------------------------
-- Records of gen_answer
-- ----------------------------

-- ----------------------------
-- Table structure for gen_front_menu
-- ----------------------------
DROP TABLE IF EXISTS `gen_front_menu`;
CREATE TABLE `gen_front_menu` (
  `FM_ID` varchar(32) NOT NULL COMMENT '菜单ID',
  `FM_URL` varchar(200) NOT NULL COMMENT '菜单链接',
  `FM_DESC` varchar(5000) DEFAULT NULL COMMENT '菜单描述',
  `SORT` int(11) DEFAULT NULL COMMENT '排序列',
  `STATUS` char(1) NOT NULL DEFAULT 'E' COMMENT '当前状态,E:有效的,I:无效的',
  `CREATED` datetime DEFAULT NULL COMMENT '录入日期',
  `LASTMOD` datetime DEFAULT NULL COMMENT '修改日期',
  `CREATER` varchar(32) DEFAULT NULL COMMENT '录入人',
  `MODIFYER` varchar(32) DEFAULT NULL COMMENT '修改人',
  PRIMARY KEY (`FM_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='前端栏目表';

-- ----------------------------
-- Records of gen_front_menu
-- ----------------------------

-- ----------------------------
-- Table structure for gen_qa_log
-- ----------------------------
DROP TABLE IF EXISTS `gen_qa_log`;
CREATE TABLE `gen_qa_log` (
  `LOG_ID` varchar(32) NOT NULL COMMENT '日志ID',
  `QA_TYPE` char(1) NOT NULL COMMENT '操作类型，A:agree赞同,O:Oppose反对',
  `CREATED` datetime DEFAULT NULL COMMENT '操作日期',
  `LASTMOD` datetime DEFAULT NULL COMMENT '修改日期',
  `CREATER` varchar(32) DEFAULT NULL COMMENT '操作人',
  `MODIFYER` varchar(32) DEFAULT NULL COMMENT '修改人',
  PRIMARY KEY (`LOG_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='问答日志表';

-- ----------------------------
-- Records of gen_qa_log
-- ----------------------------

-- ----------------------------
-- Table structure for gen_question
-- ----------------------------
DROP TABLE IF EXISTS `gen_question`;
CREATE TABLE `gen_question` (
  `QSTN_ID` varchar(32) NOT NULL COMMENT '问题ID',
  `QSTN_TITLE` varchar(200) NOT NULL COMMENT '问题标题',
  `QSTN_KEY` varchar(200) DEFAULT NULL COMMENT '问题关键字',
  `QSTN_DESC` varchar(5000) DEFAULT NULL COMMENT '问题描述',
  `STATUS` char(1) DEFAULT 'N' COMMENT '当前状态,N:new新问题,C:closed已完结,D:doing进行中,B:back撤回',
  `CREATED` datetime DEFAULT NULL COMMENT '提问日期',
  `LASTMOD` datetime DEFAULT NULL COMMENT '修改日期',
  `CREATER` varchar(32) DEFAULT NULL COMMENT '问题录入员',
  `MODIFYER` varchar(32) DEFAULT NULL COMMENT '修改人',
  PRIMARY KEY (`QSTN_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='问题表';

-- ----------------------------
-- Records of gen_question
-- ----------------------------
INSERT INTO `gen_question` VALUES ('b1ac8f2ae80b4392be07b7d161c4a944', 'ubuntu 14.04开机出现错误“Error found when loading /root/.profile”解决', 'linux,ubuntu,开机错误,profile', '在刚修改完root权限自动登录后，发现开机出现以下提示：\r\nError found when loading /root/.profile\r\nstdin:is not a tty', 'N', '2016-05-13 11:53:00', '2016-05-13 11:53:00', '9e6706baa946413b878d4fbaa6ec4322', '9e6706baa946413b878d4fbaa6ec4322');

-- ----------------------------
-- Table structure for sys_company
-- ----------------------------
DROP TABLE IF EXISTS `sys_company`;
CREATE TABLE `sys_company` (
  `CO_ID` varchar(32) NOT NULL COMMENT '公司自增ID',
  `CO_NAME` varchar(100) NOT NULL COMMENT '公司名称',
  `PRNT_ID` varchar(32) DEFAULT NULL COMMENT '父公司ID',
  `PRNT_NAME` varchar(100) DEFAULT NULL COMMENT '父公司名称',
  `STATE` varchar(10) DEFAULT 'closed' COMMENT '是否有下级公司',
  `ICON_CLS` varchar(255) DEFAULT 'icon-company' COMMENT '公司标记',
  `CO_PHONE` varchar(20) DEFAULT NULL COMMENT '公司电话',
  `CO_FAX` varchar(20) DEFAULT NULL COMMENT '公司传真',
  `CO_ADR` varchar(500) DEFAULT NULL COMMENT '公司地址',
  `CO_ZIP` varchar(10) DEFAULT NULL COMMENT '邮政编码',
  `SORT` int(11) DEFAULT NULL COMMENT '排序列',
  `CO_EMAIL` varchar(100) DEFAULT NULL COMMENT '公司邮件地址',
  `CONTACT` varchar(100) DEFAULT NULL COMMENT '公司联络人',
  `STATUS` char(1) NOT NULL DEFAULT 'E' COMMENT '当前状态,E:有效的,I:无效的',
  `MANAGER` varchar(100) DEFAULT NULL COMMENT '公司负责人',
  `BANK` varchar(100) DEFAULT NULL COMMENT '开户行',
  `BANK_ACCT` varchar(100) DEFAULT NULL COMMENT '银行账号',
  `CO_DESC` varchar(500) DEFAULT NULL COMMENT '备注',
  `CREATER` varchar(32) DEFAULT NULL COMMENT '创建人',
  `MODIFYER` varchar(32) DEFAULT NULL COMMENT '修改人',
  `CREATED` datetime DEFAULT NULL COMMENT '创造日期',
  `LASTMOD` datetime DEFAULT NULL COMMENT '修改日期',
  PRIMARY KEY (`CO_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='公司表';

-- ----------------------------
-- Records of sys_company
-- ----------------------------
INSERT INTO `sys_company` VALUES ('5f33f03536804f189c4c65b050cb1073', '称心如意集团公司', '0', '', 'closed', 'icon-company', '15981852507', '', '河南郑州', '450000', null, 'dyenigma@163.com', 'dyenigma', 'E', 'dyenigma', '', '', '如意如意,称我心意,快快显灵!', '9e6706baa946413b878d4fbaa6ec4322', '9e6706baa946413b878d4fbaa6ec4322', '2016-05-06 08:17:43', '2016-05-06 17:00:26');

-- ----------------------------
-- Table structure for sys_division
-- ----------------------------
DROP TABLE IF EXISTS `sys_division`;
CREATE TABLE `sys_division` (
  `DIV_ID` varchar(32) NOT NULL COMMENT '部门自增ID',
  `DIV_NAME` varchar(100) NOT NULL COMMENT '部门名称',
  `MANAGER` varchar(32) DEFAULT NULL COMMENT '部门领导对应的USERID',
  `DIV_PHONE` varchar(50) DEFAULT NULL COMMENT '部门电话',
  `DIV_ADR` varchar(500) DEFAULT NULL COMMENT '部门地址',
  `CO_ID` varchar(32) NOT NULL COMMENT '所属公司ID',
  `CO_NAME` varchar(100) DEFAULT NULL COMMENT '公司名称',
  `DIV_DESC` varchar(500) DEFAULT NULL COMMENT '备注',
  `STATUS` char(1) NOT NULL DEFAULT 'E' COMMENT '当前状态,E:有效的,I:无效的',
  `ICON_CLS` varchar(100) DEFAULT 'icon-flower' COMMENT '图标',
  `STATE` varchar(10) DEFAULT 'open' COMMENT '标记能否打开，相当于叶节点判断，open不能打开closed可以打开',
  `CREATED` datetime DEFAULT NULL COMMENT '创造日期',
  `LASTMOD` datetime DEFAULT NULL COMMENT '修改日期',
  `CREATER` varchar(32) DEFAULT NULL COMMENT '创建人',
  `MODIFYER` varchar(32) DEFAULT NULL COMMENT '修改人',
  PRIMARY KEY (`DIV_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='组织部门表';

-- ----------------------------
-- Records of sys_division
-- ----------------------------
INSERT INTO `sys_division` VALUES ('d584d9ea71d54b86899cb88225bf1da1', '研发部', '9e6706baa946413b878d4fbaa6ec4322', '', '', '5f33f03536804f189c4c65b050cb1073', '称心如意集团公司', '', 'E', 'icon-flower', 'open', '2016-05-12 18:18:22', '2016-05-12 18:18:22', '9e6706baa946413b878d4fbaa6ec4322', '9e6706baa946413b878d4fbaa6ec4322');

-- ----------------------------
-- Table structure for sys_permission
-- ----------------------------
DROP TABLE IF EXISTS `sys_permission`;
CREATE TABLE `sys_permission` (
  `PMSN_ID` varchar(32) NOT NULL COMMENT '权限自增ID',
  `PMSN_NAME` varchar(100) NOT NULL COMMENT '权限名称',
  `PRNT_ID` varchar(32) DEFAULT NULL COMMENT '父权限ID',
  `PRNT_NAME` varchar(100) DEFAULT NULL COMMENT '父权限名称',
  `PMSN_CODE` varchar(100) NOT NULL COMMENT '权限标识',
  `SORT` int(11) DEFAULT NULL COMMENT '排序列',
  `PMSN_TYPE` char(1) DEFAULT 'M' COMMENT '权限类型,M:菜单,O:操作',
  `STATUS` char(1) NOT NULL DEFAULT 'E' COMMENT '当前状态,E:有效的,I:无效的',
  `PMSN_URL` varchar(500) DEFAULT NULL COMMENT '权限对应URL',
  `ICON_CLS` varchar(100) DEFAULT NULL COMMENT '图标',
  `PMSN_DESC` varchar(500) DEFAULT NULL COMMENT '权限描述',
  `STATE` varchar(10) DEFAULT 'closed' COMMENT '标记能否打开，相当于叶节点判断，open不能打开closed可以打开',
  `IS_DEFAULT` char(1) DEFAULT 'N' COMMENT '是否默认权限，Y是N否',
  `IS_USED` char(1) DEFAULT 'Y' COMMENT '是否启动，Y是N否',
  `CREATED` datetime DEFAULT NULL COMMENT '创造日期',
  `LASTMOD` datetime DEFAULT NULL COMMENT '修改日期',
  `CREATER` varchar(32) DEFAULT NULL COMMENT '创建人',
  `MODIFYER` varchar(32) DEFAULT NULL COMMENT '修改人',
  PRIMARY KEY (`PMSN_ID`),
  UNIQUE KEY `PMSN_CODE` (`PMSN_CODE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='权限表';

-- ----------------------------
-- Records of sys_permission
-- ----------------------------
INSERT INTO `sys_permission` VALUES ('06d3df9bfd1a40078f3d6713d467c24d', '授予角色', 'cf62aa538ffe426189586f972fce646e', '用户管理', 'userRole', '4', 'O', 'E', 'javascript:void(0);', 'icon-love', '', 'open', 'N', 'Y', '2016-04-25 21:22:48', '2016-04-25 21:22:48', '9e6706baa946413b878d4fbaa6ec4322', '9e6706baa946413b878d4fbaa6ec4322');
INSERT INTO `sys_permission` VALUES ('0be1b48a3f2c415084dc083c000d4280', '删除用户', 'cf62aa538ffe426189586f972fce646e', '用户管理', 'userDel', '3', 'O', 'E', 'javascript:void(0);', 'icon-remove', '', 'open', 'N', 'Y', '2016-04-25 21:20:56', '2016-04-25 21:20:56', '9e6706baa946413b878d4fbaa6ec4322', '9e6706baa946413b878d4fbaa6ec4322');
INSERT INTO `sys_permission` VALUES ('0d9477feda9a4bbea3a2b217a874a1e3', '授予角色', '6c7df65147f441eb89c5666a609c84fa', '项目组', 'prjRole', '5', 'O', 'E', 'javascript:void(0);', 'icon-puzzle', '', 'open', 'N', 'Y', '2016-04-25 21:26:16', '2016-04-25 21:26:16', '9e6706baa946413b878d4fbaa6ec4322', '9e6706baa946413b878d4fbaa6ec4322');
INSERT INTO `sys_permission` VALUES ('1034e9a3a9ad46e29b430a29f803138b', '删除项目组', '6c7df65147f441eb89c5666a609c84fa', '项目组', 'prjDel', '3', 'O', 'E', 'javascript:void(0);', 'icon-remove', '', 'open', 'N', 'Y', '2016-04-25 21:24:42', '2016-04-25 21:24:42', '9e6706baa946413b878d4fbaa6ec4322', '9e6706baa946413b878d4fbaa6ec4322');
INSERT INTO `sys_permission` VALUES ('10e82ae666374e348b46fa98af6fff98', '系统管理', '0', '', 'systemMgr', '19', 'M', 'E', 'javascript:void(0);', 'icon-power', '', 'closed', 'N', 'Y', '2016-05-02 22:16:59', '2016-05-05 14:59:09', '9e6706baa946413b878d4fbaa6ec4322', '9e6706baa946413b878d4fbaa6ec4322');
INSERT INTO `sys_permission` VALUES ('15965f60c044463c94dd11c511fd6883', '运行状态',
'10e82ae666374e348b46fa98af6fff98', '系统管理', 'dataMgr', '1', 'M', 'E', '/druid', 'icon-camera', '', 'closed', 'N', 'Y', '2016-04-25 22:03:36', '2016-05-03 09:48:03', '9e6706baa946413b878d4fbaa6ec4322', '9e6706baa946413b878d4fbaa6ec4322');
INSERT INTO `sys_permission` VALUES ('1e286edc9a064fb385f816efeebf2def', '公司管理', '6a3ef216053941ee824e847cf23a47af', '权限管理', 'coMgr', '2', 'M', 'E', '/manage/comp/compMain', 'icon-company', '', 'closed', 'N', 'Y', '2016-04-25 18:12:20', '2016-04-25 23:09:28', '9e6706baa946413b878d4fbaa6ec4322', '9e6706baa946413b878d4fbaa6ec4322');
INSERT INTO `sys_permission` VALUES ('22bf78a358ef4c6585c6c3678f12cf8d', '提问', '3c63fd129f2245139c02344b824c520b', '问答区', 'question', '1', 'O', 'I', 'javascript:void(0);', 'icon-add', '', 'open', 'N', 'Y', '2016-05-12 18:22:33', '2016-05-12 18:22:33', '9e6706baa946413b878d4fbaa6ec4322', '9e6706baa946413b878d4fbaa6ec4322');
INSERT INTO `sys_permission` VALUES ('25f4d13ed3c3428490254ec5079f90dd', '编辑菜单', 'fcd5fd3640a240d5b532143fc631b0f5', '前端菜单', 'editFrontMenu', '2', 'O', 'E', 'javascript:void(0);', 'icon-edit', '', 'open', 'N', 'Y', '2016-05-13 08:24:46', '2016-05-13 08:24:46', '9e6706baa946413b878d4fbaa6ec4322', '9e6706baa946413b878d4fbaa6ec4322');
INSERT INTO `sys_permission` VALUES ('2c3cf67c362d492da75b514f3d1947ea', '新增用户', 'cf62aa538ffe426189586f972fce646e', '用户管理', 'userAdd', '1', 'O', 'E', 'javascript:void(0);', 'icon-add', '', 'open', 'N', 'Y', '2016-04-25 21:20:12', '2016-04-29 12:49:20', '9e6706baa946413b878d4fbaa6ec4322', '9e6706baa946413b878d4fbaa6ec4322');
INSERT INTO `sys_permission` VALUES ('2e0b4be914de494d99236f7d5141804a', '前端管理', '0', '', 'frontMgr', '3', 'M', 'E', 'javascript:void(0);', 'icon-role', '', 'closed', 'N', 'Y', '2016-05-13 08:22:00', '2016-05-13 08:22:00', '9e6706baa946413b878d4fbaa6ec4322', '9e6706baa946413b878d4fbaa6ec4322');
INSERT INTO `sys_permission` VALUES ('2fa3504ab24b478aa9eab920431a85b6', '删除菜单', '9589d7be38b442598c345ae0595d25a4', '菜单设定', 'menuDel', '3', 'O', 'E', 'javascript:void(0);', 'icon-remove', '', 'open', 'N', 'Y', '2016-04-24 13:16:25', '2016-04-26 08:12:47', '9e6706baa946413b878d4fbaa6ec4322', '9e6706baa946413b878d4fbaa6ec4322');
INSERT INTO `sys_permission` VALUES ('34f5968f90a045b2a8785279f45e6a8a', '添加项目组', '6c7df65147f441eb89c5666a609c84fa', '项目组', 'prjAdd', '1', 'O', 'E', 'javascript:void(0);', 'icon-add', '', 'open', 'N', 'Y', '2016-04-25 21:24:02', '2016-04-25 22:01:40', '9e6706baa946413b878d4fbaa6ec4322', '9e6706baa946413b878d4fbaa6ec4322');
INSERT INTO `sys_permission` VALUES ('38abbd19048240129ee673958b20aa15', '设定岗位', 'cf62aa538ffe426189586f972fce646e', '用户管理', 'userPost', '6', 'O', 'E', 'javascript:void(0);', 'icon-address', '', 'open', 'N', 'Y', '2016-04-27 16:11:39', '2016-04-27 16:11:57', '9e6706baa946413b878d4fbaa6ec4322', '9e6706baa946413b878d4fbaa6ec4322');
INSERT INTO `sys_permission` VALUES ('3c63fd129f2245139c02344b824c520b', '问答管理', '78bccfa410fc44099ebc2d0194e0af43', '研发之家', 'qaMgr', '1', 'M', 'E', '/manage/qstn/qaList', 'icon-question', '', 'closed', 'N', 'Y', '2016-05-12 18:21:51', '2016-05-13 11:36:33', '9e6706baa946413b878d4fbaa6ec4322', '9e6706baa946413b878d4fbaa6ec4322');
INSERT INTO `sys_permission` VALUES ('3c8adb7b17de4b20b540bb137bf9d874', '分配成员', '6c7df65147f441eb89c5666a609c84fa', '项目组', 'prjUser', '4', 'O', 'E', 'javascript:void(0);', 'icon-man', '', 'open', 'N', 'Y', '2016-04-25 21:25:29', '2016-04-25 21:25:29', '9e6706baa946413b878d4fbaa6ec4322', '9e6706baa946413b878d4fbaa6ec4322');
INSERT INTO `sys_permission` VALUES ('452dae04f41b4b81b996c2ca89008411', '删除部门', '5d169572b3f34ce7a2b232fad7c16b07', '部门管理', 'divDel', '3', 'O', 'E', 'javascript:void(0);', 'icon-remove', '', 'open', 'N', 'Y', '2016-04-25 21:11:19', '2016-04-25 21:15:44', '9e6706baa946413b878d4fbaa6ec4322', '9e6706baa946413b878d4fbaa6ec4322');
INSERT INTO `sys_permission` VALUES ('5184c1e4ac794e48a929cc435b35ee32', '删除岗位', '5692baac3c774864857f0f59a75809c0', '岗位管理', 'postDel', '3', 'O', 'E', 'javascript:void(0);', 'icon-remove', '', 'open', 'N', 'Y', '2016-04-25 21:16:49', '2016-04-25 21:16:49', '9e6706baa946413b878d4fbaa6ec4322', '9e6706baa946413b878d4fbaa6ec4322');
INSERT INTO `sys_permission` VALUES ('51f8e78d06b04af9b41dd7358e6f698f', '修改项目组', '6c7df65147f441eb89c5666a609c84fa', '项目组', 'prjEdit', '2', 'O', 'E', 'javascript:void(0);', 'icon-edit', '', 'open', 'N', 'Y', '2016-04-25 21:24:25', '2016-04-25 21:24:25', '9e6706baa946413b878d4fbaa6ec4322', '9e6706baa946413b878d4fbaa6ec4322');
INSERT INTO `sys_permission` VALUES ('5692baac3c774864857f0f59a75809c0', '岗位管理', '6a3ef216053941ee824e847cf23a47af', '权限管理', 'postMgr', '4', 'M', 'E', '/manage/post/postMain', 'icon-conn', '', 'closed', 'N', 'Y', '2016-04-25 18:18:50', '2016-04-25 23:09:59', '9e6706baa946413b878d4fbaa6ec4322', '9e6706baa946413b878d4fbaa6ec4322');
INSERT INTO `sys_permission` VALUES ('58df87dd13cb4a7aad07fba972de797b', '数据备份', '10e82ae666374e348b46fa98af6fff98', '系统管理', 'dataBak', '4', 'M', 'E', 'javascript:void(0);', 'icon-db', '', 'closed', 'N', 'Y', '2016-04-25 22:54:31', '2016-05-03 09:55:51', '9e6706baa946413b878d4fbaa6ec4322', '9e6706baa946413b878d4fbaa6ec4322');
INSERT INTO `sys_permission` VALUES ('58e28bd105aa4fcc97a1e418db5cae10', '导出信息', '1e286edc9a064fb385f816efeebf2def', '公司管理', 'excelOut', '4', 'O', 'E', 'javascript:void(0);', 'icon-menu', '', 'open', 'N', 'Y', '2016-04-25 21:08:37', '2016-04-25 21:08:37', '9e6706baa946413b878d4fbaa6ec4322', '9e6706baa946413b878d4fbaa6ec4322');
INSERT INTO `sys_permission` VALUES ('5be140b4acfa422480c0336ea56a8360', '删除角色', '792c0f70450c472cbc44fa8cfb80d826', '角色管理', 'roleDel', '3', 'O', 'E', 'javascript:void(0);', 'icon-remove', '', 'open', 'N', 'Y', '2016-04-25 21:18:32', '2016-04-25 21:18:32', '9e6706baa946413b878d4fbaa6ec4322', '9e6706baa946413b878d4fbaa6ec4322');
INSERT INTO `sys_permission` VALUES ('5d169572b3f34ce7a2b232fad7c16b07', '部门管理', '6a3ef216053941ee824e847cf23a47af', '权限管理', 'divMgr', '3', 'M', 'E', '/manage/organ/organMain', 'icon-organ', '', 'closed', 'N', 'Y', '2016-04-25 18:16:46', '2016-04-25 23:09:00', '9e6706baa946413b878d4fbaa6ec4322', '9e6706baa946413b878d4fbaa6ec4322');
INSERT INTO `sys_permission` VALUES ('637009e09b9d4a7180c4afe1791a3d12', '添加公司', '1e286edc9a064fb385f816efeebf2def', '公司管理', 'coAdd', '1', 'O', 'E', 'javascript:void(0);', 'icon-add', '', 'open', 'N', 'Y', '2016-04-25 21:00:29', '2016-04-25 21:00:29', '9e6706baa946413b878d4fbaa6ec4322', '9e6706baa946413b878d4fbaa6ec4322');
INSERT INTO `sys_permission` VALUES ('671af03f798b4abe870b73b56f75823e', '问题反馈', '10e82ae666374e348b46fa98af6fff98', '系统管理', 'bugMgr', '8', 'M', 'E', 'javascript:void(0);', 'icon-danger', '', 'closed', 'N', 'Y', '2016-04-25 22:55:29', '2016-05-05 14:57:53', '9e6706baa946413b878d4fbaa6ec4322', '9e6706baa946413b878d4fbaa6ec4322');
INSERT INTO `sys_permission` VALUES ('6a3ef216053941ee824e847cf23a47af', '权限管理', '0', '', 'sysMgr', '1', 'M', 'E', 'javascript:void(0);', 'icon-home', '', 'closed', 'N', 'Y', '2016-04-24 13:16:12', '2016-04-26 08:11:56', '9e6706baa946413b878d4fbaa6ec4322', '9e6706baa946413b878d4fbaa6ec4322');
INSERT INTO `sys_permission` VALUES ('6b12817ab5b943e1b4d4218617dd3ca3', '修改菜单', '9589d7be38b442598c345ae0595d25a4', '菜单设定', 'menuEdit', '2', 'O', 'E', 'javascript:void(0);', 'icon-edit', '', 'open', 'N', 'Y', '2016-04-24 13:16:23', '2016-04-26 08:12:38', '9e6706baa946413b878d4fbaa6ec4322', '9e6706baa946413b878d4fbaa6ec4322');
INSERT INTO `sys_permission` VALUES ('6c7df65147f441eb89c5666a609c84fa', '项目组', '6a3ef216053941ee824e847cf23a47af', '权限管理', 'prjMgr', '7', 'M', 'E', '/manage/project/prjMain', 'icon-chart', '', 'closed', 'N', 'Y', '2016-04-25 18:21:58', '2016-04-25 23:10:22', '9e6706baa946413b878d4fbaa6ec4322', '9e6706baa946413b878d4fbaa6ec4322');
INSERT INTO `sys_permission` VALUES ('6e8d8226d10c45f792b3f75221755764', '删除', '3c63fd129f2245139c02344b824c520b', '问答管理', 'delQA', '1', 'O', 'E', 'javascript:void(0);', 'icon-remove', '', 'open', 'N', 'Y', '2016-05-13 10:28:19', '2016-05-13 10:28:52', '9e6706baa946413b878d4fbaa6ec4322', '9e6706baa946413b878d4fbaa6ec4322');
INSERT INTO `sys_permission` VALUES ('78bccfa410fc44099ebc2d0194e0af43', '研发之家', '0', '', 'sdHome', '2', 'M', 'E', 'javascript:void(0);', 'icon-conn', '', 'closed', 'N', 'Y', '2016-05-12 18:20:54', '2016-05-12 18:20:54', '9e6706baa946413b878d4fbaa6ec4322', '9e6706baa946413b878d4fbaa6ec4322');
INSERT INTO `sys_permission` VALUES ('792c0f70450c472cbc44fa8cfb80d826', '角色管理', '6a3ef216053941ee824e847cf23a47af', '权限管理', 'roleMgr', '5', 'M', 'E', '/manage/role/roleMgr', 'icon-puzzle', '', 'closed', 'N', 'Y', '2016-04-25 18:21:27', '2016-04-25 23:07:40', '9e6706baa946413b878d4fbaa6ec4322', '9e6706baa946413b878d4fbaa6ec4322');
INSERT INTO `sys_permission` VALUES ('7d5a94387e314892b60fa1a7bb5762f7', '编辑信息', '1e286edc9a064fb385f816efeebf2def', '公司管理', 'coEdit', '2', 'O', 'E', 'javascript:void(0);', 'icon-edit', '', 'open', 'N', 'Y', '2016-04-25 21:01:00', '2016-04-25 21:01:00', '9e6706baa946413b878d4fbaa6ec4322', '9e6706baa946413b878d4fbaa6ec4322');
INSERT INTO `sys_permission` VALUES ('8242538facb24c4d8eca15d9d60ca2cb', '分配权限', '792c0f70450c472cbc44fa8cfb80d826', '角色管理', 'rolePmsn', '4', 'O', 'E', 'javascript:void(0);', 'icon-star', '', 'open', 'N', 'Y', '2016-04-25 21:19:32', '2016-04-25 21:19:32', '9e6706baa946413b878d4fbaa6ec4322', '9e6706baa946413b878d4fbaa6ec4322');
INSERT INTO `sys_permission` VALUES ('84a1134701c4442398730cbcb7ce6924', '添加菜单', 'fcd5fd3640a240d5b532143fc631b0f5', '前端菜单', 'addFrontMenu', '1', 'O', 'E', 'javascript:void(0);', 'icon-add', '', 'open', 'N', 'Y', '2016-05-13 08:24:18', '2016-05-13 08:24:18', '9e6706baa946413b878d4fbaa6ec4322', '9e6706baa946413b878d4fbaa6ec4322');
INSERT INTO `sys_permission` VALUES ('8dfa86e426234100b6d5751e1d3477a2', '编辑用户', 'cf62aa538ffe426189586f972fce646e', '用户管理', 'userEdit', '2', 'O', 'E', 'javascript:void(0);', 'icon-edit', '', 'open', 'N', 'Y', '2016-04-25 21:20:32', '2016-04-25 21:20:32', '9e6706baa946413b878d4fbaa6ec4322', '9e6706baa946413b878d4fbaa6ec4322');
INSERT INTO `sys_permission` VALUES ('914a5a061f8a4b0ea0d37676b508ac39', '岗位授权', '5692baac3c774864857f0f59a75809c0', '岗位管理', 'postRole', '4', 'O', 'E', 'javascript:void(0);', 'icon-save', '', 'open', 'N', 'Y', '2016-04-27 12:53:09', '2016-04-27 12:53:09', '9e6706baa946413b878d4fbaa6ec4322', '9e6706baa946413b878d4fbaa6ec4322');
INSERT INTO `sys_permission` VALUES ('9589d7be38b442598c345ae0595d25a4', '菜单设定', '6a3ef216053941ee824e847cf23a47af', '权限管理', 'pmsnMgr', '1', 'M', 'E', '/manage/menu/menuMain', 'icon-setting', '', 'closed', 'N', 'Y', '2016-04-24 13:16:16', '2016-04-26 08:12:19', '9e6706baa946413b878d4fbaa6ec4322', '9e6706baa946413b878d4fbaa6ec4322');
INSERT INTO `sys_permission` VALUES ('9628e603b6b34821a86772a619ac1d3f', '添加岗位', '5692baac3c774864857f0f59a75809c0', '岗位管理', 'postAdd', '1', 'O', 'E', 'javascript:void(0);', 'icon-add', '', 'open', 'N', 'Y', '2016-04-25 21:14:17', '2016-04-25 21:16:02', '9e6706baa946413b878d4fbaa6ec4322', '9e6706baa946413b878d4fbaa6ec4322');
INSERT INTO `sys_permission` VALUES ('99a05c2281134500806ee093f5af9428', '岗位编辑', '5692baac3c774864857f0f59a75809c0', '岗位管理', 'postEdit', '2', 'O', 'E', 'javascript:void(0);', 'icon-edit', '', 'open', 'N', 'Y', '2016-04-25 21:16:27', '2016-04-25 21:16:27', '9e6706baa946413b878d4fbaa6ec4322', '9e6706baa946413b878d4fbaa6ec4322');
INSERT INTO `sys_permission` VALUES ('99c6ec4a71534559b048c5404b7f0906', '编辑角色', '792c0f70450c472cbc44fa8cfb80d826', '角色管理', 'roleEdit', '2', 'O', 'E', 'javascript:void(0);', 'icon-edit', '', 'open', 'N', 'Y', '2016-04-25 21:18:14', '2016-04-25 21:18:14', '9e6706baa946413b878d4fbaa6ec4322', '9e6706baa946413b878d4fbaa6ec4322');
INSERT INTO `sys_permission` VALUES ('a2795a4e7df341ee96006ef06cf3515b', '用户中心', '10e82ae666374e348b46fa98af6fff98', '系统管理', 'userZone', '6', 'M', 'E', 'javascript:void(0);', 'icon-user', '', 'closed', 'N', 'Y', '2016-04-28 14:20:03', '2016-05-03 09:56:26', '9e6706baa946413b878d4fbaa6ec4322', '9e6706baa946413b878d4fbaa6ec4322');
INSERT INTO `sys_permission` VALUES ('a44f18711ca94f47947de6830432831f', '日志管理', '10e82ae666374e348b46fa98af6fff98', '系统管理', 'logMgr', '5', 'M', 'E', 'javascript:void(0);', 'icon-info', '', 'closed', 'N', 'Y', '2016-04-25 22:55:04', '2016-05-03 09:56:08', '9e6706baa946413b878d4fbaa6ec4322', '9e6706baa946413b878d4fbaa6ec4322');
INSERT INTO `sys_permission` VALUES ('aa2a686e5d4642c481de289bc8357375', '添加角色', '792c0f70450c472cbc44fa8cfb80d826', '角色管理', 'roleAdd', '1', 'O', 'E', 'javascript:void(0);', 'icon-add', '', 'open', 'N', 'Y', '2016-04-25 21:17:52', '2016-04-25 21:17:52', '9e6706baa946413b878d4fbaa6ec4322', '9e6706baa946413b878d4fbaa6ec4322');
INSERT INTO `sys_permission` VALUES ('b0d436b54137406681e904d479e1fd00', '删除菜单', 'fcd5fd3640a240d5b532143fc631b0f5', '前端菜单', 'delFrontMenu', '3', 'O', 'E', 'javascript:void(0);', 'icon-remove', '', 'open', 'N', 'Y', '2016-05-13 08:25:10', '2016-05-13 08:25:10', '9e6706baa946413b878d4fbaa6ec4322', '9e6706baa946413b878d4fbaa6ec4322');
INSERT INTO `sys_permission` VALUES ('b2bb462afbc54f9c8944b5738da1d974', '删除公司', '1e286edc9a064fb385f816efeebf2def', '公司管理', 'coDel', '3', 'O', 'E', 'javascript:void(0);', 'icon-remove', '', 'open', 'N', 'Y', '2016-04-25 21:01:27', '2016-04-25 21:01:27', '9e6706baa946413b878d4fbaa6ec4322', '9e6706baa946413b878d4fbaa6ec4322');
INSERT INTO `sys_permission` VALUES ('b800825413d243e78f211ae30cfab98d', '标记无效', 'f3fa019a4b6e4f0f955e8daf5da566d2', '问题列表', 'bugDel', '2', 'O', 'E', 'javascript:void(0);', 'icon-no', '', 'open', 'N', 'Y', '2016-04-25 23:04:25', '2016-04-25 23:04:25', '9e6706baa946413b878d4fbaa6ec4322', '9e6706baa946413b878d4fbaa6ec4322');
INSERT INTO `sys_permission` VALUES ('bab7dbfc082a4cf7b77addf50937ac4f', '回答', '3c63fd129f2245139c02344b824c520b', '问答区', 'answer', '2', 'O', 'I', 'javascript:void(0);', 'icon-yes', '', 'open', 'N', 'Y', '2016-05-12 18:23:05', '2016-05-12 18:23:05', '9e6706baa946413b878d4fbaa6ec4322', '9e6706baa946413b878d4fbaa6ec4322');
INSERT INTO `sys_permission` VALUES ('c168d657165042b2bc388bb09ca57f21', '用户资料', 'a2795a4e7df341ee96006ef06cf3515b', '用户中心', 'userInfo', '1', 'M', 'E', 'javascript:void(0);', 'icon-address', '', 'closed', 'N', 'Y', '2016-04-28 14:21:22', '2016-04-28 14:21:22', '9e6706baa946413b878d4fbaa6ec4322', '9e6706baa946413b878d4fbaa6ec4322');
INSERT INTO `sys_permission` VALUES ('c6f5ebf02a29499695b0f464d5ad228e', '修改部门', '5d169572b3f34ce7a2b232fad7c16b07', '部门管理', 'divEdit', '2', 'O', 'E', 'javascript:void(0);', 'icon-edit', '', 'open', 'N', 'Y', '2016-04-25 21:10:58', '2016-04-25 21:15:35', '9e6706baa946413b878d4fbaa6ec4322', '9e6706baa946413b878d4fbaa6ec4322');
INSERT INTO `sys_permission` VALUES ('cc5bbddb80974c88a18a30d9e4ac2ee8', '日志列表', 'a44f18711ca94f47947de6830432831f', '日志管理', 'logList', '1', 'M', 'E', 'javascript:void(0);', 'icon-log', '', 'closed', 'N', 'Y', '2016-04-25 23:05:09', '2016-04-25 23:05:09', '9e6706baa946413b878d4fbaa6ec4322', '9e6706baa946413b878d4fbaa6ec4322');
INSERT INTO `sys_permission` VALUES ('cf62aa538ffe426189586f972fce646e', '用户管理', '6a3ef216053941ee824e847cf23a47af', '权限管理', 'userMgr', '6', 'M', 'E', '/manage/users/usersMain', 'icon-user', '', 'closed', 'N', 'Y', '2016-04-25 18:20:35', '2016-04-25 23:07:22', '9e6706baa946413b878d4fbaa6ec4322', '9e6706baa946413b878d4fbaa6ec4322');
INSERT INTO `sys_permission` VALUES ('d0c45597bc9445aa8736e1cf3c916d03', '默认权限', '792c0f70450c472cbc44fa8cfb80d826', '角色管理', 'roleDefault', '5', 'O', 'E', 'javascript:void(0);', 'icon-love', '授予通用角色所有默认权限的操作按钮', 'open', 'N', 'Y', '2016-05-05 15:07:45', '2016-05-05 15:07:45', '9e6706baa946413b878d4fbaa6ec4322', '9e6706baa946413b878d4fbaa6ec4322');
INSERT INTO `sys_permission` VALUES ('d43f61e893004e0594efa059cd370af0', '修改密码', 'c168d657165042b2bc388bb09ca57f21', '用户资料', 'pwdEdit', '1', 'O', 'E', 'javascript:void(0);', 'icon-danger', '', 'open', 'Y', 'Y', '2016-04-28 14:21:42', '2016-04-28 14:22:05', '9e6706baa946413b878d4fbaa6ec4322', '9e6706baa946413b878d4fbaa6ec4322');
INSERT INTO `sys_permission` VALUES ('db8b14b18eff4b14ad0b986baba28cbc', 'BUG回馈', 'f3fa019a4b6e4f0f955e8daf5da566d2', '问题列表', 'bugReply', '1', 'O', 'E', 'javascript:void(0);', 'icon-yes', '', 'open', 'N', 'Y', '2016-04-25 23:03:50', '2016-04-29 12:49:07', '9e6706baa946413b878d4fbaa6ec4322', '9e6706baa946413b878d4fbaa6ec4322');
INSERT INTO `sys_permission` VALUES ('e042ffe86c284294bdedf75f2ad04be5', '添加部门', '5d169572b3f34ce7a2b232fad7c16b07', '部门管理', 'divAdd', '1', 'O', 'E', 'javascript:void(0);', 'icon-add', '', 'open', 'N', 'Y', '2016-04-25 21:10:30', '2016-04-25 21:15:25', '9e6706baa946413b878d4fbaa6ec4322', '9e6706baa946413b878d4fbaa6ec4322');
INSERT INTO `sys_permission` VALUES ('e805435d0bbc4015afdf7804511f7e66', '新增菜单', '9589d7be38b442598c345ae0595d25a4', '菜单设定', 'menuAdd', '1', 'O', 'E', 'javascript:void(0);', 'icon-add', '', 'open', 'N', 'Y', '2016-04-24 13:16:19', '2016-04-26 08:12:29', '9e6706baa946413b878d4fbaa6ec4322', '9e6706baa946413b878d4fbaa6ec4322');
INSERT INTO `sys_permission` VALUES ('e82a6d5244f94c28aabaa3df456b1aa1', '岗位成员', '6a3ef216053941ee824e847cf23a47af', '权限管理', 'postView', '8', 'M', 'E', '/manage/post/postView', 'icon-man', '查看各个公司、各个部门、各个岗位的用户', 'closed', 'N', 'Y', '2016-04-28 14:40:58', '2016-04-28 14:54:41', '9e6706baa946413b878d4fbaa6ec4322', '9e6706baa946413b878d4fbaa6ec4322');
INSERT INTO `sys_permission` VALUES ('f0c524425c0e49b0ad2f006786e0b939', '定时备份', '58df87dd13cb4a7aad07fba972de797b', '数据备份', 'autoBak', '1', 'M', 'E', 'javascript:void(0);', 'icon-save', '', 'closed', 'N', 'Y', '2016-04-25 23:02:18', '2016-04-25 23:02:18', '9e6706baa946413b878d4fbaa6ec4322', '9e6706baa946413b878d4fbaa6ec4322');
INSERT INTO `sys_permission` VALUES ('f250ee14357343f89ee39a6b4460c6f4', '单独授权', 'cf62aa538ffe426189586f972fce646e', '用户管理', 'userPmsn', '5', 'O', 'E', 'javascript:void(0);', 'icon-key', '', 'open', 'N', 'Y', '2016-04-25 21:23:13', '2016-04-25 21:23:13', '9e6706baa946413b878d4fbaa6ec4322', '9e6706baa946413b878d4fbaa6ec4322');
INSERT INTO `sys_permission` VALUES ('f3fa019a4b6e4f0f955e8daf5da566d2', '问题列表', '671af03f798b4abe870b73b56f75823e', '问题反馈', 'bugList', '1', 'M', 'E', 'javascript:void(0);', 'icon-question', '', 'closed', 'N', 'Y', '2016-04-25 22:57:34', '2016-04-25 22:57:34', '9e6706baa946413b878d4fbaa6ec4322', '9e6706baa946413b878d4fbaa6ec4322');
INSERT INTO `sys_permission` VALUES ('fc6a211b4cf64882a7a405f894d4262e', '手动备份', '58df87dd13cb4a7aad07fba972de797b', '数据备份', 'artflBak', '2', 'M', 'E', 'javascript:void(0);', 'icon-dbadd', '', 'closed', 'N', 'Y', '2016-04-25 23:01:40', '2016-04-25 23:01:40', '9e6706baa946413b878d4fbaa6ec4322', '9e6706baa946413b878d4fbaa6ec4322');
INSERT INTO `sys_permission` VALUES ('fcd5fd3640a240d5b532143fc631b0f5', '前端菜单', '2e0b4be914de494d99236f7d5141804a', '前端管理', 'frontMenu', '1', 'M', 'E', 'javascript:void(0);', 'icon-address', '', 'closed', 'N', 'Y', '2016-05-13 08:22:56', '2016-05-13 08:22:56', '9e6706baa946413b878d4fbaa6ec4322', '9e6706baa946413b878d4fbaa6ec4322');

-- ----------------------------
-- Table structure for sys_post
-- ----------------------------
DROP TABLE IF EXISTS `sys_post`;
CREATE TABLE `sys_post` (
  `POST_ID` varchar(32) NOT NULL COMMENT '岗位自增ID',
  `POST_NAME` varchar(100) NOT NULL COMMENT '岗位名称',
  `DIV_ID` varchar(32) DEFAULT NULL COMMENT '部门ID',
  `POST_DESC` varchar(500) DEFAULT NULL COMMENT '备注',
  `STATUS` char(1) NOT NULL DEFAULT 'E' COMMENT '当前状态,E:有效的,I:无效的',
  `CREATED` datetime DEFAULT NULL COMMENT '创造日期',
  `LASTMOD` datetime DEFAULT NULL COMMENT '修改日期',
  `CREATER` varchar(32) DEFAULT NULL COMMENT '创建人',
  `MODIFYER` varchar(32) DEFAULT NULL COMMENT '修改人',
  PRIMARY KEY (`POST_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='岗位表';

-- ----------------------------
-- Records of sys_post
-- ----------------------------
INSERT INTO `sys_post` VALUES ('c4517de81fac423bb782baa4e48d311b', '问答管理员', 'd584d9ea71d54b86899cb88225bf1da1', '', 'E', '2016-05-12 18:19:00', '2016-05-12 18:19:00', '9e6706baa946413b878d4fbaa6ec4322', '9e6706baa946413b878d4fbaa6ec4322');

-- ----------------------------
-- Table structure for sys_post_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_post_role`;
CREATE TABLE `sys_post_role` (
  `PR_ID` varchar(32) NOT NULL COMMENT '岗位角色配置自增ID',
  `ROLE_ID` varchar(32) NOT NULL COMMENT '角色ID',
  `POST_ID` varchar(32) NOT NULL COMMENT '岗位ID',
  `STATUS` char(1) NOT NULL DEFAULT 'E' COMMENT '当前状态,E:有效的,I:无效的',
  `CREATED` datetime DEFAULT NULL COMMENT '创造日期',
  `LASTMOD` datetime DEFAULT NULL COMMENT '修改日期',
  `CREATER` varchar(32) DEFAULT NULL COMMENT '创建人',
  `MODIFYER` varchar(32) DEFAULT NULL COMMENT '修改人',
  PRIMARY KEY (`PR_ID`),
  KEY `FK_PR_ROLE` (`ROLE_ID`),
  KEY `FK_PR_POST` (`POST_ID`),
  CONSTRAINT `FK_PR_POST` FOREIGN KEY (`POST_ID`) REFERENCES `sys_post` (`POST_ID`),
  CONSTRAINT `FK_PR_ROLE` FOREIGN KEY (`ROLE_ID`) REFERENCES `sys_role` (`ROLE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='岗位角色表';

-- ----------------------------
-- Records of sys_post_role
-- ----------------------------

-- ----------------------------
-- Table structure for sys_prj_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_prj_role`;
CREATE TABLE `sys_prj_role` (
  `PR_ID` varchar(32) NOT NULL COMMENT '项目组角色配置自增ID',
  `PRJ_ID` varchar(32) NOT NULL COMMENT '项目组ID',
  `ROLE_ID` varchar(32) NOT NULL COMMENT '角色ID',
  `STATUS` char(1) NOT NULL DEFAULT 'E' COMMENT '当前状态,E:有效的,I:无效的',
  `CREATED` datetime DEFAULT NULL COMMENT '创造日期',
  `LASTMOD` datetime DEFAULT NULL COMMENT '修改日期',
  `CREATER` varchar(32) DEFAULT NULL COMMENT '创建人',
  `MODIFYER` varchar(32) DEFAULT NULL COMMENT '修改人',
  PRIMARY KEY (`PR_ID`),
  KEY `FK_PRR_PRJ` (`PRJ_ID`),
  KEY `FK_PRR_ROLE` (`ROLE_ID`),
  CONSTRAINT `FK_PRR_PRJ` FOREIGN KEY (`PRJ_ID`) REFERENCES `sys_project` (`PRJ_ID`),
  CONSTRAINT `FK_PRR_ROLE` FOREIGN KEY (`ROLE_ID`) REFERENCES `sys_role` (`ROLE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='项目组角色表';

-- ----------------------------
-- Records of sys_prj_role
-- ----------------------------

-- ----------------------------
-- Table structure for sys_prj_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_prj_user`;
CREATE TABLE `sys_prj_user` (
  `PU_ID` varchar(32) NOT NULL COMMENT '项目成员配置自增ID',
  `PRJ_ID` varchar(32) NOT NULL COMMENT '项目组ID',
  `USER_ID` varchar(32) NOT NULL COMMENT '用户ID',
  `STATUS` char(1) NOT NULL DEFAULT 'E' COMMENT '当前状态,E:有效的,I:无效的',
  `CREATED` datetime DEFAULT NULL COMMENT '创造日期',
  `LASTMOD` datetime DEFAULT NULL COMMENT '修改日期',
  `CREATER` varchar(32) DEFAULT NULL COMMENT '创建人',
  `MODIFYER` varchar(32) DEFAULT NULL COMMENT '修改人',
  PRIMARY KEY (`PU_ID`),
  KEY `FK_PU_PRJ` (`PRJ_ID`),
  KEY `FK_PU_USER` (`USER_ID`),
  CONSTRAINT `FK_PU_PRJ` FOREIGN KEY (`PRJ_ID`) REFERENCES `sys_project` (`PRJ_ID`),
  CONSTRAINT `FK_PU_USER` FOREIGN KEY (`USER_ID`) REFERENCES `sys_user` (`USER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='项目组成员表';

-- ----------------------------
-- Records of sys_prj_user
-- ----------------------------

-- ----------------------------
-- Table structure for sys_project
-- ----------------------------
DROP TABLE IF EXISTS `sys_project`;
CREATE TABLE `sys_project` (
  `PRJ_ID` varchar(32) NOT NULL COMMENT '项目自增ID',
  `PRJ_NAME` varchar(100) NOT NULL COMMENT '项目名称',
  `PRJ_DESC` varchar(500) DEFAULT NULL COMMENT '项目描述',
  `LEADER` varchar(32) NOT NULL COMMENT '项目领导',
  `LEVEL` varchar(32) DEFAULT '1' COMMENT '项目等级(可扩展为外键)',
  `STATUS` char(1) NOT NULL DEFAULT 'E' COMMENT '当前状态,E:有效的,I:无效的',
  `CREATED` datetime DEFAULT NULL COMMENT '创造日期',
  `LASTMOD` datetime DEFAULT NULL COMMENT '修改日期',
  `CREATER` varchar(32) DEFAULT NULL COMMENT '创建人',
  `MODIFYER` varchar(32) DEFAULT NULL COMMENT '修改人',
  `CO_ID` varchar(32) DEFAULT NULL COMMENT '所属公司ID',
  `CO_NAME` varchar(100) DEFAULT NULL COMMENT '所属公司名称',
  PRIMARY KEY (`PRJ_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='项目组表';

-- ----------------------------
-- Records of sys_project
-- ----------------------------

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `ROLE_ID` varchar(32) NOT NULL COMMENT '角色自增ID',
  `ROLE_NAME` varchar(100) NOT NULL COMMENT '角色名称',
  `ROLE_DESC` varchar(500) DEFAULT NULL COMMENT '角色描述',
  `SORT` int(11) DEFAULT NULL COMMENT '排序列',
  `STATUS` char(1) NOT NULL DEFAULT 'E' COMMENT '当前状态,E:有效的,I:无效的',
  `CREATED` datetime DEFAULT NULL COMMENT '创造日期',
  `LASTMOD` datetime DEFAULT NULL COMMENT '修改日期',
  `CREATER` varchar(32) DEFAULT NULL COMMENT '创建人',
  `MODIFYER` varchar(32) DEFAULT NULL COMMENT '修改人',
  `IS_DEFAULT` char(1) DEFAULT 'N' COMMENT '是否默认角色',
  PRIMARY KEY (`ROLE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色表';

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('66af6a49af404a6da7c88b07fb857967', '超级管理员', '具有所有的有效权限', '1', 'E', '2016-04-26 08:20:59', '2016-05-03 13:27:30', '9e6706baa946413b878d4fbaa6ec4322', '9e6706baa946413b878d4fbaa6ec4322', 'N');
INSERT INTO `sys_role` VALUES ('d9647a7401374edd849ff8baeec8e491', '通用角色', '所有用户都有的角色，里面包含通用的权限', '2', 'E', '2016-05-05 16:21:40', '2016-05-05 16:21:40', '9e6706baa946413b878d4fbaa6ec4322', '9e6706baa946413b878d4fbaa6ec4322', 'Y');

-- ----------------------------
-- Table structure for sys_role_pmsn
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_pmsn`;
CREATE TABLE `sys_role_pmsn` (
  `RP_ID` varchar(32) NOT NULL COMMENT '权限角色配置自增ID',
  `ROLE_ID` varchar(32) NOT NULL COMMENT '角色ID',
  `PMSN_ID` varchar(32) NOT NULL COMMENT '权限ID',
  `STATUS` char(1) NOT NULL DEFAULT 'E' COMMENT '当前状态,E:有效的,I:无效的',
  `CREATED` datetime DEFAULT NULL COMMENT '创造日期',
  `LASTMOD` datetime DEFAULT NULL COMMENT '修改日期',
  `CREATER` varchar(32) DEFAULT NULL COMMENT '创建人',
  `MODIFYER` varchar(32) DEFAULT NULL COMMENT '修改人',
  PRIMARY KEY (`RP_ID`),
  KEY `FK_RP_ROLE` (`ROLE_ID`),
  KEY `FK_RP_PMSN` (`PMSN_ID`),
  CONSTRAINT `FK_RP_PMSN` FOREIGN KEY (`PMSN_ID`) REFERENCES `sys_permission` (`PMSN_ID`),
  CONSTRAINT `FK_RP_ROLE` FOREIGN KEY (`ROLE_ID`) REFERENCES `sys_role` (`ROLE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='权限角色表';

-- ----------------------------
-- Records of sys_role_pmsn
-- ----------------------------
INSERT INTO `sys_role_pmsn` VALUES ('0d6b373b800e430492f38541e7416bb1', 'd9647a7401374edd849ff8baeec8e491', '3c63fd129f2245139c02344b824c520b', 'E', '2016-05-12 18:24:15', '2016-05-12 18:24:15', '9e6706baa946413b878d4fbaa6ec4322', '9e6706baa946413b878d4fbaa6ec4322');
INSERT INTO `sys_role_pmsn` VALUES ('0fc29c1e718c4cd0bba5d39f5b242f07', '66af6a49af404a6da7c88b07fb857967', 'cf62aa538ffe426189586f972fce646e', 'E', '2016-04-29 14:06:40', '2016-05-13 08:25:35', '9e6706baa946413b878d4fbaa6ec4322', '9e6706baa946413b878d4fbaa6ec4322');
INSERT INTO `sys_role_pmsn` VALUES ('10c82dad6c374cb2abbecb7207cd2ffe', '66af6a49af404a6da7c88b07fb857967', 'd0c45597bc9445aa8736e1cf3c916d03', 'E', '2016-05-05 15:08:35', '2016-05-13 08:25:35', '9e6706baa946413b878d4fbaa6ec4322', '9e6706baa946413b878d4fbaa6ec4322');
INSERT INTO `sys_role_pmsn` VALUES ('2398064b27bf44fcad3f9a72f9d1a76e', '66af6a49af404a6da7c88b07fb857967', '06d3df9bfd1a40078f3d6713d467c24d', 'E', '2016-04-29 14:06:40', '2016-05-13 08:25:35', '9e6706baa946413b878d4fbaa6ec4322', '9e6706baa946413b878d4fbaa6ec4322');
INSERT INTO `sys_role_pmsn` VALUES ('258e8725a39d4cb280b57cb800c3337d', '66af6a49af404a6da7c88b07fb857967', 'b0d436b54137406681e904d479e1fd00', 'E', '2016-05-13 08:25:35', '2016-05-13 08:25:35', '9e6706baa946413b878d4fbaa6ec4322', '9e6706baa946413b878d4fbaa6ec4322');
INSERT INTO `sys_role_pmsn` VALUES ('28aab2d15da64ee6bcaf58e218686739', '66af6a49af404a6da7c88b07fb857967', '5184c1e4ac794e48a929cc435b35ee32', 'E', '2016-04-29 14:06:40', '2016-05-13 08:25:35', '9e6706baa946413b878d4fbaa6ec4322', '9e6706baa946413b878d4fbaa6ec4322');
INSERT INTO `sys_role_pmsn` VALUES ('2acfde5025c14c9ba807592632e8a587', 'd9647a7401374edd849ff8baeec8e491', '10e82ae666374e348b46fa98af6fff98', 'E', '2016-05-05 16:39:56', '2016-05-12 18:24:15', '9e6706baa946413b878d4fbaa6ec4322', '9e6706baa946413b878d4fbaa6ec4322');
INSERT INTO `sys_role_pmsn` VALUES ('2b84e29aafbb46039b24f82fb8ad94d8', '66af6a49af404a6da7c88b07fb857967', '671af03f798b4abe870b73b56f75823e', 'E', '2016-05-05 15:04:41', '2016-05-13 08:25:35', '9e6706baa946413b878d4fbaa6ec4322', '9e6706baa946413b878d4fbaa6ec4322');
INSERT INTO `sys_role_pmsn` VALUES ('2dfd1b79767c40e89e3a33e249145a18', '66af6a49af404a6da7c88b07fb857967', 'c6f5ebf02a29499695b0f464d5ad228e', 'E', '2016-04-29 14:06:40', '2016-05-13 08:25:35', '9e6706baa946413b878d4fbaa6ec4322', '9e6706baa946413b878d4fbaa6ec4322');
INSERT INTO `sys_role_pmsn` VALUES ('2fe547addfd441fcb0ff207d3cd1bc42', '66af6a49af404a6da7c88b07fb857967', '51f8e78d06b04af9b41dd7358e6f698f', 'E', '2016-04-29 14:06:40', '2016-05-13 08:25:35', '9e6706baa946413b878d4fbaa6ec4322', '9e6706baa946413b878d4fbaa6ec4322');
INSERT INTO `sys_role_pmsn` VALUES ('3859d151b05642ca9c110a60473ddc14', '66af6a49af404a6da7c88b07fb857967', 'cc5bbddb80974c88a18a30d9e4ac2ee8', 'E', '2016-05-05 15:04:41', '2016-05-13 08:25:35', '9e6706baa946413b878d4fbaa6ec4322', '9e6706baa946413b878d4fbaa6ec4322');
INSERT INTO `sys_role_pmsn` VALUES ('3b4b7b96b52040448223a25f94a8e19a', '66af6a49af404a6da7c88b07fb857967', '2c3cf67c362d492da75b514f3d1947ea', 'E', '2016-04-29 14:06:40', '2016-05-13 08:25:35', '9e6706baa946413b878d4fbaa6ec4322', '9e6706baa946413b878d4fbaa6ec4322');
INSERT INTO `sys_role_pmsn` VALUES ('3c7de76d34ee49c8ab8ef50748113602', '66af6a49af404a6da7c88b07fb857967', 'e82a6d5244f94c28aabaa3df456b1aa1', 'E', '2016-04-29 14:06:40', '2016-05-13 08:25:35', '9e6706baa946413b878d4fbaa6ec4322', '9e6706baa946413b878d4fbaa6ec4322');
INSERT INTO `sys_role_pmsn` VALUES ('3f955be0bde745928af2fdae4f50675d', '66af6a49af404a6da7c88b07fb857967', '914a5a061f8a4b0ea0d37676b508ac39', 'E', '2016-04-29 14:06:40', '2016-05-13 08:25:35', '9e6706baa946413b878d4fbaa6ec4322', '9e6706baa946413b878d4fbaa6ec4322');
INSERT INTO `sys_role_pmsn` VALUES ('4390b8b45a1c4cf8bd81243eab23fbac', '66af6a49af404a6da7c88b07fb857967', '58e28bd105aa4fcc97a1e418db5cae10', 'E', '2016-04-29 14:06:40', '2016-05-13 08:25:35', '9e6706baa946413b878d4fbaa6ec4322', '9e6706baa946413b878d4fbaa6ec4322');
INSERT INTO `sys_role_pmsn` VALUES ('45365500112c45efaaa744c43db27487', '66af6a49af404a6da7c88b07fb857967', '78bccfa410fc44099ebc2d0194e0af43', 'E', '2016-05-12 18:23:55', '2016-05-13 08:25:35', '9e6706baa946413b878d4fbaa6ec4322', '9e6706baa946413b878d4fbaa6ec4322');
INSERT INTO `sys_role_pmsn` VALUES ('4d469a31a7db45a6915129effaa4654d', '66af6a49af404a6da7c88b07fb857967', '1e286edc9a064fb385f816efeebf2def', 'E', '2016-04-29 14:06:40', '2016-05-13 08:25:35', '9e6706baa946413b878d4fbaa6ec4322', '9e6706baa946413b878d4fbaa6ec4322');
INSERT INTO `sys_role_pmsn` VALUES ('4f3648097f4546ccb26d6089f92c7e36', '66af6a49af404a6da7c88b07fb857967', '7d5a94387e314892b60fa1a7bb5762f7', 'E', '2016-04-29 14:06:40', '2016-05-13 08:25:35', '9e6706baa946413b878d4fbaa6ec4322', '9e6706baa946413b878d4fbaa6ec4322');
INSERT INTO `sys_role_pmsn` VALUES ('5615d0a84f98493fa230e509cc2d6b5d', '66af6a49af404a6da7c88b07fb857967', '5d169572b3f34ce7a2b232fad7c16b07', 'E', '2016-04-29 14:06:40', '2016-05-13 08:25:35', '9e6706baa946413b878d4fbaa6ec4322', '9e6706baa946413b878d4fbaa6ec4322');
INSERT INTO `sys_role_pmsn` VALUES ('5fdd789f31dd486e92f9d743943cafcc', '66af6a49af404a6da7c88b07fb857967', 'c168d657165042b2bc388bb09ca57f21', 'E', '2016-04-29 14:06:40', '2016-05-13 08:25:35', '9e6706baa946413b878d4fbaa6ec4322', '9e6706baa946413b878d4fbaa6ec4322');
INSERT INTO `sys_role_pmsn` VALUES ('65b4c027d5204f86a58518ee572d3350', '66af6a49af404a6da7c88b07fb857967', '99a05c2281134500806ee093f5af9428', 'E', '2016-04-29 14:06:40', '2016-05-13 08:25:35', '9e6706baa946413b878d4fbaa6ec4322', '9e6706baa946413b878d4fbaa6ec4322');
INSERT INTO `sys_role_pmsn` VALUES ('65de619778d145c7a1558edd0270d371', '66af6a49af404a6da7c88b07fb857967', 'aa2a686e5d4642c481de289bc8357375', 'E', '2016-04-29 14:06:40', '2016-05-13 08:25:35', '9e6706baa946413b878d4fbaa6ec4322', '9e6706baa946413b878d4fbaa6ec4322');
INSERT INTO `sys_role_pmsn` VALUES ('72308fed16584074a35b5f8acf4c6b9c', '66af6a49af404a6da7c88b07fb857967', '452dae04f41b4b81b996c2ca89008411', 'E', '2016-04-29 14:06:40', '2016-05-13 08:25:35', '9e6706baa946413b878d4fbaa6ec4322', '9e6706baa946413b878d4fbaa6ec4322');
INSERT INTO `sys_role_pmsn` VALUES ('74dc28178c0945f0917e7e04e60c4da0', '66af6a49af404a6da7c88b07fb857967', 'fcd5fd3640a240d5b532143fc631b0f5', 'E', '2016-05-13 08:25:35', '2016-05-13 08:25:35', '9e6706baa946413b878d4fbaa6ec4322', '9e6706baa946413b878d4fbaa6ec4322');
INSERT INTO `sys_role_pmsn` VALUES ('75d406e138f64011b3454fa1343fd0fa', '66af6a49af404a6da7c88b07fb857967', '2e0b4be914de494d99236f7d5141804a', 'E', '2016-05-13 08:25:35', '2016-05-13 08:25:35', '9e6706baa946413b878d4fbaa6ec4322', '9e6706baa946413b878d4fbaa6ec4322');
INSERT INTO `sys_role_pmsn` VALUES ('792a3a8c87b64685acb5a835ed2e3b86', '66af6a49af404a6da7c88b07fb857967', '5692baac3c774864857f0f59a75809c0', 'E', '2016-04-29 14:06:40', '2016-05-13 08:25:35', '9e6706baa946413b878d4fbaa6ec4322', '9e6706baa946413b878d4fbaa6ec4322');
INSERT INTO `sys_role_pmsn` VALUES ('7ccbb63fd9944910845e05d44b066306', '66af6a49af404a6da7c88b07fb857967', '1034e9a3a9ad46e29b430a29f803138b', 'E', '2016-04-29 14:06:40', '2016-05-13 08:25:35', '9e6706baa946413b878d4fbaa6ec4322', '9e6706baa946413b878d4fbaa6ec4322');
INSERT INTO `sys_role_pmsn` VALUES ('7d3e8fc116084fd8bcae484c27a61e7f', 'd9647a7401374edd849ff8baeec8e491', 'a2795a4e7df341ee96006ef06cf3515b', 'E', '2016-05-05 16:40:01', '2016-05-12 18:24:15', '9e6706baa946413b878d4fbaa6ec4322', '9e6706baa946413b878d4fbaa6ec4322');
INSERT INTO `sys_role_pmsn` VALUES ('7f0df01290b94b44a62143c06247258d', '66af6a49af404a6da7c88b07fb857967', 'a44f18711ca94f47947de6830432831f', 'E', '2016-05-05 15:04:41', '2016-05-13 08:25:35', '9e6706baa946413b878d4fbaa6ec4322', '9e6706baa946413b878d4fbaa6ec4322');
INSERT INTO `sys_role_pmsn` VALUES ('820f9051d8a64c8890a3c647b940599c', '66af6a49af404a6da7c88b07fb857967', '0d9477feda9a4bbea3a2b217a874a1e3', 'E', '2016-04-29 14:06:40', '2016-05-13 08:25:35', '9e6706baa946413b878d4fbaa6ec4322', '9e6706baa946413b878d4fbaa6ec4322');
INSERT INTO `sys_role_pmsn` VALUES ('84dd484903674e6bb6e546e405d29c23', '66af6a49af404a6da7c88b07fb857967', '792c0f70450c472cbc44fa8cfb80d826', 'E', '2016-04-29 14:06:40', '2016-05-13 08:25:35', '9e6706baa946413b878d4fbaa6ec4322', '9e6706baa946413b878d4fbaa6ec4322');
INSERT INTO `sys_role_pmsn` VALUES ('8d0e0f0ef48e4ae9b67aaa10431c63d2', '66af6a49af404a6da7c88b07fb857967', '84a1134701c4442398730cbcb7ce6924', 'E', '2016-05-13 08:25:35', '2016-05-13 08:25:35', '9e6706baa946413b878d4fbaa6ec4322', '9e6706baa946413b878d4fbaa6ec4322');
INSERT INTO `sys_role_pmsn` VALUES ('8d73549a51bd43aabf73abb80630b45b', '66af6a49af404a6da7c88b07fb857967', '6b12817ab5b943e1b4d4218617dd3ca3', 'E', '2016-04-29 14:06:40', '2016-05-13 08:25:35', '9e6706baa946413b878d4fbaa6ec4322', '9e6706baa946413b878d4fbaa6ec4322');
INSERT INTO `sys_role_pmsn` VALUES ('91a0e7e395734c97b9d174db74407eba', '66af6a49af404a6da7c88b07fb857967', '5be140b4acfa422480c0336ea56a8360', 'E', '2016-04-29 14:06:40', '2016-05-13 08:25:35', '9e6706baa946413b878d4fbaa6ec4322', '9e6706baa946413b878d4fbaa6ec4322');
INSERT INTO `sys_role_pmsn` VALUES ('91cdc4126a89497391ea46bae0bb3abd', '66af6a49af404a6da7c88b07fb857967', '0be1b48a3f2c415084dc083c000d4280', 'E', '2016-04-29 14:06:40', '2016-05-13 08:25:35', '9e6706baa946413b878d4fbaa6ec4322', '9e6706baa946413b878d4fbaa6ec4322');
INSERT INTO `sys_role_pmsn` VALUES ('92da0427fd524fcb9ed9abea98ccc449', '66af6a49af404a6da7c88b07fb857967', '8dfa86e426234100b6d5751e1d3477a2', 'E', '2016-04-29 14:06:40', '2016-05-13 08:25:35', '9e6706baa946413b878d4fbaa6ec4322', '9e6706baa946413b878d4fbaa6ec4322');
INSERT INTO `sys_role_pmsn` VALUES ('946b18764aaa43a5ac91cf826123d3c8', '66af6a49af404a6da7c88b07fb857967', '9589d7be38b442598c345ae0595d25a4', 'E', '2016-04-29 14:06:40', '2016-05-13 08:25:35', '9e6706baa946413b878d4fbaa6ec4322', '9e6706baa946413b878d4fbaa6ec4322');
INSERT INTO `sys_role_pmsn` VALUES ('95cf2cff0b1c4802a46d9ec2aa16bd87', '66af6a49af404a6da7c88b07fb857967', '6c7df65147f441eb89c5666a609c84fa', 'E', '2016-04-29 14:06:40', '2016-05-13 08:25:35', '9e6706baa946413b878d4fbaa6ec4322', '9e6706baa946413b878d4fbaa6ec4322');
INSERT INTO `sys_role_pmsn` VALUES ('99561221c9824011b4cb56ffaf48e5e9', '66af6a49af404a6da7c88b07fb857967', '8242538facb24c4d8eca15d9d60ca2cb', 'E', '2016-04-29 14:06:40', '2016-05-13 08:25:35', '9e6706baa946413b878d4fbaa6ec4322', '9e6706baa946413b878d4fbaa6ec4322');
INSERT INTO `sys_role_pmsn` VALUES ('99d87231c1854be282a733377f2ce529', '66af6a49af404a6da7c88b07fb857967', 'a2795a4e7df341ee96006ef06cf3515b', 'E', '2016-04-29 14:06:40', '2016-05-13 08:25:35', '9e6706baa946413b878d4fbaa6ec4322', '9e6706baa946413b878d4fbaa6ec4322');
INSERT INTO `sys_role_pmsn` VALUES ('a023009da6e847cf9c9d86fe70292bee', '66af6a49af404a6da7c88b07fb857967', 'f0c524425c0e49b0ad2f006786e0b939', 'E', '2016-05-05 15:04:41', '2016-05-13 08:25:35', '9e6706baa946413b878d4fbaa6ec4322', '9e6706baa946413b878d4fbaa6ec4322');
INSERT INTO `sys_role_pmsn` VALUES ('a6b724c1ba50457aa9c71e654d33d40b', '66af6a49af404a6da7c88b07fb857967', '2fa3504ab24b478aa9eab920431a85b6', 'E', '2016-04-29 14:06:40', '2016-05-13 08:25:35', '9e6706baa946413b878d4fbaa6ec4322', '9e6706baa946413b878d4fbaa6ec4322');
INSERT INTO `sys_role_pmsn` VALUES ('a893387216e64e47acefbd6a974af874', '66af6a49af404a6da7c88b07fb857967', '3c63fd129f2245139c02344b824c520b', 'E', '2016-05-12 18:23:55', '2016-05-13 08:25:35', '9e6706baa946413b878d4fbaa6ec4322', '9e6706baa946413b878d4fbaa6ec4322');
INSERT INTO `sys_role_pmsn` VALUES ('a8ed5102af574441949267be4dd10db7', '66af6a49af404a6da7c88b07fb857967', 'e805435d0bbc4015afdf7804511f7e66', 'E', '2016-04-29 14:06:40', '2016-05-13 08:25:35', '9e6706baa946413b878d4fbaa6ec4322', '9e6706baa946413b878d4fbaa6ec4322');
INSERT INTO `sys_role_pmsn` VALUES ('a9045c2f94d84a5eac94d9b256c1738f', '66af6a49af404a6da7c88b07fb857967', 'b800825413d243e78f211ae30cfab98d', 'E', '2016-05-05 15:04:41', '2016-05-13 08:25:35', '9e6706baa946413b878d4fbaa6ec4322', '9e6706baa946413b878d4fbaa6ec4322');
INSERT INTO `sys_role_pmsn` VALUES ('aaf470bedb634186a8d2547b982c797f', '66af6a49af404a6da7c88b07fb857967', 'b2bb462afbc54f9c8944b5738da1d974', 'E', '2016-04-29 14:06:40', '2016-05-13 08:25:35', '9e6706baa946413b878d4fbaa6ec4322', '9e6706baa946413b878d4fbaa6ec4322');
INSERT INTO `sys_role_pmsn` VALUES ('acaceb4f17f840428906594b547ce087', '66af6a49af404a6da7c88b07fb857967', 'f250ee14357343f89ee39a6b4460c6f4', 'E', '2016-04-29 14:06:40', '2016-05-13 08:25:35', '9e6706baa946413b878d4fbaa6ec4322', '9e6706baa946413b878d4fbaa6ec4322');
INSERT INTO `sys_role_pmsn` VALUES ('ba1e85c98666443e9202992d149054af', '66af6a49af404a6da7c88b07fb857967', '15965f60c044463c94dd11c511fd6883', 'E', '2016-04-29 14:06:40', '2016-05-13 08:25:35', '9e6706baa946413b878d4fbaa6ec4322', '9e6706baa946413b878d4fbaa6ec4322');
INSERT INTO `sys_role_pmsn` VALUES ('be167248350c4c1d95301c7d8d566847', '66af6a49af404a6da7c88b07fb857967', '3c8adb7b17de4b20b540bb137bf9d874', 'E', '2016-04-29 14:06:40', '2016-05-13 08:25:35', '9e6706baa946413b878d4fbaa6ec4322', '9e6706baa946413b878d4fbaa6ec4322');
INSERT INTO `sys_role_pmsn` VALUES ('c7b04d0e3dfc423bbfbd951ca20edcdd', '66af6a49af404a6da7c88b07fb857967', '25f4d13ed3c3428490254ec5079f90dd', 'E', '2016-05-13 08:25:35', '2016-05-13 08:25:35', '9e6706baa946413b878d4fbaa6ec4322', '9e6706baa946413b878d4fbaa6ec4322');
INSERT INTO `sys_role_pmsn` VALUES ('cab95e7a18254302a2fc570dea8e2966', '66af6a49af404a6da7c88b07fb857967', 'e042ffe86c284294bdedf75f2ad04be5', 'E', '2016-04-29 14:06:40', '2016-05-13 08:25:35', '9e6706baa946413b878d4fbaa6ec4322', '9e6706baa946413b878d4fbaa6ec4322');
INSERT INTO `sys_role_pmsn` VALUES ('cfffb65c9b6f4aeebdf4536d9cd4b711', '66af6a49af404a6da7c88b07fb857967', 'db8b14b18eff4b14ad0b986baba28cbc', 'E', '2016-05-05 15:04:41', '2016-05-13 08:25:35', '9e6706baa946413b878d4fbaa6ec4322', '9e6706baa946413b878d4fbaa6ec4322');
INSERT INTO `sys_role_pmsn` VALUES ('d1ec20824e324fb7bff8526295ec0a10', '66af6a49af404a6da7c88b07fb857967', '58df87dd13cb4a7aad07fba972de797b', 'E', '2016-05-05 15:04:41', '2016-05-13 08:25:35', '9e6706baa946413b878d4fbaa6ec4322', '9e6706baa946413b878d4fbaa6ec4322');
INSERT INTO `sys_role_pmsn` VALUES ('d97cf8cef8634128b64e8b1dfabe9735', '66af6a49af404a6da7c88b07fb857967', '34f5968f90a045b2a8785279f45e6a8a', 'E', '2016-04-29 14:06:40', '2016-05-13 08:25:35', '9e6706baa946413b878d4fbaa6ec4322', '9e6706baa946413b878d4fbaa6ec4322');
INSERT INTO `sys_role_pmsn` VALUES ('db630a9106df4cc08312e576f68956dd', '66af6a49af404a6da7c88b07fb857967', 'd43f61e893004e0594efa059cd370af0', 'E', '2016-04-29 14:06:40', '2016-05-13 08:25:35', '9e6706baa946413b878d4fbaa6ec4322', '9e6706baa946413b878d4fbaa6ec4322');
INSERT INTO `sys_role_pmsn` VALUES ('de4bdb1c80454f69a710cac2d7b48e86', '66af6a49af404a6da7c88b07fb857967', '99c6ec4a71534559b048c5404b7f0906', 'E', '2016-04-29 14:06:40', '2016-05-13 08:25:35', '9e6706baa946413b878d4fbaa6ec4322', '9e6706baa946413b878d4fbaa6ec4322');
INSERT INTO `sys_role_pmsn` VALUES ('e52c6c9c8bbc4a5f9254d536a506e357', '66af6a49af404a6da7c88b07fb857967', '6a3ef216053941ee824e847cf23a47af', 'E', '2016-04-29 14:06:40', '2016-05-13 08:25:35', '9e6706baa946413b878d4fbaa6ec4322', '9e6706baa946413b878d4fbaa6ec4322');
INSERT INTO `sys_role_pmsn` VALUES ('e5bbf1c34d8f473281548030f149cefc', '66af6a49af404a6da7c88b07fb857967', '9628e603b6b34821a86772a619ac1d3f', 'E', '2016-04-29 14:06:40', '2016-05-13 08:25:35', '9e6706baa946413b878d4fbaa6ec4322', '9e6706baa946413b878d4fbaa6ec4322');
INSERT INTO `sys_role_pmsn` VALUES ('e99e8d4e8f2848d5b32a4082e9e2b261', '66af6a49af404a6da7c88b07fb857967', '38abbd19048240129ee673958b20aa15', 'E', '2016-04-29 14:06:40', '2016-05-13 08:25:35', '9e6706baa946413b878d4fbaa6ec4322', '9e6706baa946413b878d4fbaa6ec4322');
INSERT INTO `sys_role_pmsn` VALUES ('f15132ea1e624fafbe0ed5989df1b3f1', '66af6a49af404a6da7c88b07fb857967', 'fc6a211b4cf64882a7a405f894d4262e', 'E', '2016-05-05 15:04:41', '2016-05-13 08:25:35', '9e6706baa946413b878d4fbaa6ec4322', '9e6706baa946413b878d4fbaa6ec4322');
INSERT INTO `sys_role_pmsn` VALUES ('f2df50ed39d247dab9957cbc1ba23cc7', 'd9647a7401374edd849ff8baeec8e491', 'd43f61e893004e0594efa059cd370af0', 'E', '2016-05-05 16:39:53', '2016-05-12 18:24:15', '9e6706baa946413b878d4fbaa6ec4322', '9e6706baa946413b878d4fbaa6ec4322');
INSERT INTO `sys_role_pmsn` VALUES ('f50323c9ae9049e889da96f0ab988741', '66af6a49af404a6da7c88b07fb857967', '637009e09b9d4a7180c4afe1791a3d12', 'E', '2016-04-29 14:06:40', '2016-05-13 08:25:35', '9e6706baa946413b878d4fbaa6ec4322', '9e6706baa946413b878d4fbaa6ec4322');
INSERT INTO `sys_role_pmsn` VALUES ('f62bc48e441244a9b3dc009bca210f2c', '66af6a49af404a6da7c88b07fb857967', 'f3fa019a4b6e4f0f955e8daf5da566d2', 'E', '2016-05-05 15:04:41', '2016-05-13 08:25:35', '9e6706baa946413b878d4fbaa6ec4322', '9e6706baa946413b878d4fbaa6ec4322');
INSERT INTO `sys_role_pmsn` VALUES ('f9c7ecd6546b4800b5c585c0b3594ac2', 'd9647a7401374edd849ff8baeec8e491', 'c168d657165042b2bc388bb09ca57f21', 'E', '2016-05-05 16:40:01', '2016-05-12 18:24:15', '9e6706baa946413b878d4fbaa6ec4322', '9e6706baa946413b878d4fbaa6ec4322');
INSERT INTO `sys_role_pmsn` VALUES ('fae0d90e2204498d846134ba0b3595eb', 'd9647a7401374edd849ff8baeec8e491', '78bccfa410fc44099ebc2d0194e0af43', 'E', '2016-05-12 18:24:15', '2016-05-12 18:24:15', '9e6706baa946413b878d4fbaa6ec4322', '9e6706baa946413b878d4fbaa6ec4322');
INSERT INTO `sys_role_pmsn` VALUES ('fc81ece99f2a449083d07d8c1d1fe5a8', '66af6a49af404a6da7c88b07fb857967', '10e82ae666374e348b46fa98af6fff98', 'E', '2016-05-02 22:40:53', '2016-05-13 08:25:35', '9e6706baa946413b878d4fbaa6ec4322', '9e6706baa946413b878d4fbaa6ec4322');

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `USER_ID` varchar(32) NOT NULL COMMENT '用户自增ID',
  `USER_NAME` varchar(20) NOT NULL COMMENT '用户名称',
  `ACCOUNT` varchar(20) NOT NULL COMMENT '用户账号',
  `PASSWORD` varchar(100) DEFAULT NULL COMMENT '密码',
  `USER_EMAIL` varchar(200) DEFAULT NULL COMMENT '电子邮箱',
  `USER_PHONE` varchar(20) DEFAULT NULL COMMENT '用户电话',
  `FIRST_LOGIN` datetime DEFAULT NULL COMMENT '第一次登录',
  `PREV_LOGIN` datetime DEFAULT NULL COMMENT '上一次登录',
  `PREV_IP` varchar(20) DEFAULT NULL COMMENT '上一次登录IP地址',
  `LAST_LOGIN` datetime DEFAULT NULL COMMENT '最后一次登录',
  `LOGIN_COUNT` varchar(32) DEFAULT NULL COMMENT '登录次数',
  `STATUS` char(1) NOT NULL DEFAULT 'E' COMMENT '当前状态,E:有效的,I:无效的',
  `USER_DESC` varchar(500) DEFAULT NULL COMMENT '备注',
  `IS_ONLINE` int(1) DEFAULT NULL COMMENT '是否在线，1在线0不在线',
  `SORT` int(11) DEFAULT NULL COMMENT '排序列',
  `CREATED` datetime DEFAULT NULL COMMENT '创造日期',
  `LASTMOD` datetime DEFAULT NULL COMMENT '修改日期',
  `CREATER` varchar(32) DEFAULT NULL COMMENT '创建人',
  `MODIFYER` varchar(32) DEFAULT NULL COMMENT '修改人',
  PRIMARY KEY (`USER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表';

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('9e6706baa946413b878d4fbaa6ec4322', '超级管理员', 'system', '54B53072540EEEB8F8E9343E71F28176', 'dyenigma@163.com', '15981852507', '2016-04-02 09:21:34', '2016-05-13 16:20:37', '127.0.0.1', '2016-04-28 09:21:54', '83', 'E', '超级管理员', '0', '0', '2016-04-01 09:22:26', '2016-04-28 09:22:30', '9e6706baa946413b878d4fbaa6ec4322', '9e6706baa946413b878d4fbaa6ec4322');

-- ----------------------------
-- Table structure for sys_user_pmsn
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_pmsn`;
CREATE TABLE `sys_user_pmsn` (
  `UPM_ID` varchar(32) NOT NULL COMMENT '用户权限配置自增ID',
  `USER_ID` varchar(32) NOT NULL COMMENT '用户ID',
  `PMSN_ID` varchar(32) NOT NULL COMMENT '权限ID',
  `STATUS` char(1) NOT NULL DEFAULT 'E' COMMENT '当前状态,E:有效的,I:无效的',
  `CREATED` datetime DEFAULT NULL COMMENT '创造日期',
  `LASTMOD` datetime DEFAULT NULL COMMENT '修改日期',
  `CREATER` varchar(32) DEFAULT NULL COMMENT '创建人',
  `MODIFYER` varchar(32) DEFAULT NULL COMMENT '修改人',
  PRIMARY KEY (`UPM_ID`),
  KEY `FK_UPM_USER` (`USER_ID`),
  KEY `FK_UPM_PMSN` (`PMSN_ID`),
  CONSTRAINT `FK_UPM_PMSN` FOREIGN KEY (`PMSN_ID`) REFERENCES `sys_permission` (`PMSN_ID`),
  CONSTRAINT `FK_UPM_USER` FOREIGN KEY (`USER_ID`) REFERENCES `sys_user` (`USER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户权限表';

-- ----------------------------
-- Records of sys_user_pmsn
-- ----------------------------

-- ----------------------------
-- Table structure for sys_user_post
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_post`;
CREATE TABLE `sys_user_post` (
  `UP_ID` varchar(32) NOT NULL COMMENT '用户岗位配置自增ID',
  `USER_ID` varchar(32) NOT NULL COMMENT '角色ID',
  `POST_ID` varchar(32) NOT NULL COMMENT '权限ID',
  `STATUS` char(1) NOT NULL DEFAULT 'E' COMMENT '当前状态,E:有效的,I:无效的',
  `CREATED` datetime DEFAULT NULL COMMENT '创造日期',
  `LASTMOD` datetime DEFAULT NULL COMMENT '修改日期',
  `CREATER` varchar(32) DEFAULT NULL COMMENT '创建人',
  `MODIFYER` varchar(32) DEFAULT NULL COMMENT '修改人',
  PRIMARY KEY (`UP_ID`),
  KEY `FK_UP_USER` (`USER_ID`),
  KEY `FK_UP_POST` (`POST_ID`),
  CONSTRAINT `FK_UP_POST` FOREIGN KEY (`POST_ID`) REFERENCES `sys_post` (`POST_ID`),
  CONSTRAINT `FK_UP_USER` FOREIGN KEY (`USER_ID`) REFERENCES `sys_user` (`USER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户岗位表';

-- ----------------------------
-- Records of sys_user_post
-- ----------------------------

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role` (
  `UR_ID` varchar(32) NOT NULL COMMENT '用户角色配置自增ID',
  `ROLE_ID` varchar(32) NOT NULL COMMENT '角色ID',
  `USER_ID` varchar(32) NOT NULL COMMENT '用户ID',
  `STATUS` char(1) NOT NULL DEFAULT 'E' COMMENT '当前状态,E:有效的,I:无效的',
  `CREATED` datetime DEFAULT NULL COMMENT '创造日期',
  `LASTMOD` datetime DEFAULT NULL COMMENT '修改日期',
  `CREATER` varchar(32) DEFAULT NULL COMMENT '创建人',
  `MODIFYER` varchar(32) DEFAULT NULL COMMENT '修改人',
  PRIMARY KEY (`UR_ID`),
  KEY `FK_UR_ROLE` (`ROLE_ID`),
  KEY `FK_UR_USER` (`USER_ID`),
  CONSTRAINT `FK_UR_ROLE` FOREIGN KEY (`ROLE_ID`) REFERENCES `sys_role` (`ROLE_ID`),
  CONSTRAINT `FK_UR_USER` FOREIGN KEY (`USER_ID`) REFERENCES `sys_user` (`USER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户角色表';

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES ('4ddb7d8eaf694e75b499e1eec9772b7a', '66af6a49af404a6da7c88b07fb857967', '9e6706baa946413b878d4fbaa6ec4322', 'E', '2016-04-29 14:37:05', '2016-04-29 14:41:50', '9e6706baa946413b878d4fbaa6ec4322', '9e6706baa946413b878d4fbaa6ec4322');
