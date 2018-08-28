/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50559
Source Host           : localhost:3306
Source Database       : daxia

Target Server Type    : MYSQL
Target Server Version : 50559
File Encoding         : 65001

Date: 2018-08-28 13:59:48
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for eos_qrtz_blob_triggers
-- ----------------------------
DROP TABLE IF EXISTS `eos_qrtz_blob_triggers`;
CREATE TABLE `eos_qrtz_blob_triggers` (
  `TRIGGER_NAME` varchar(80) NOT NULL,
  `TRIGGER_GROUP` varchar(80) NOT NULL,
  `BLOB_DATA` blob,
  PRIMARY KEY (`TRIGGER_NAME`,`TRIGGER_GROUP`),
  KEY `FK477B155B2D997664` (`TRIGGER_NAME`,`TRIGGER_GROUP`),
  CONSTRAINT `FK477B155B2D997664` FOREIGN KEY (`TRIGGER_NAME`, `TRIGGER_GROUP`) REFERENCES `eos_qrtz_triggers` (`TRIGGER_NAME`, `TRIGGER_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of eos_qrtz_blob_triggers
-- ----------------------------

-- ----------------------------
-- Table structure for eos_qrtz_calendars
-- ----------------------------
DROP TABLE IF EXISTS `eos_qrtz_calendars`;
CREATE TABLE `eos_qrtz_calendars` (
  `CALENDAR_NAME` varchar(80) NOT NULL,
  `CALENDAR` blob NOT NULL,
  PRIMARY KEY (`CALENDAR_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of eos_qrtz_calendars
-- ----------------------------

-- ----------------------------
-- Table structure for eos_qrtz_cron_triggers
-- ----------------------------
DROP TABLE IF EXISTS `eos_qrtz_cron_triggers`;
CREATE TABLE `eos_qrtz_cron_triggers` (
  `TRIGGER_NAME` varchar(80) NOT NULL,
  `TRIGGER_GROUP` varchar(80) NOT NULL,
  `CRON_EXPRESSION` varchar(80) NOT NULL,
  `TIME_ZONE_ID` varchar(80) DEFAULT NULL,
  PRIMARY KEY (`TRIGGER_NAME`,`TRIGGER_GROUP`),
  KEY `FKD799498A2D997664` (`TRIGGER_NAME`,`TRIGGER_GROUP`),
  CONSTRAINT `FKD799498A2D997664` FOREIGN KEY (`TRIGGER_NAME`, `TRIGGER_GROUP`) REFERENCES `eos_qrtz_triggers` (`TRIGGER_NAME`, `TRIGGER_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of eos_qrtz_cron_triggers
-- ----------------------------

-- ----------------------------
-- Table structure for eos_qrtz_fired_triggers
-- ----------------------------
DROP TABLE IF EXISTS `eos_qrtz_fired_triggers`;
CREATE TABLE `eos_qrtz_fired_triggers` (
  `ENTRY_ID` varchar(95) NOT NULL,
  `TRIGGER_NAME` varchar(80) NOT NULL,
  `TRIGGER_GROUP` varchar(80) NOT NULL,
  `IS_VOLATILE` int(11) NOT NULL,
  `INSTANCE_NAME` varchar(80) NOT NULL,
  `FIRED_TIME` bigint(20) NOT NULL,
  `STATE` varchar(16) NOT NULL,
  `JOB_NAME` varchar(80) DEFAULT NULL,
  `JOB_GROUP` varchar(80) DEFAULT NULL,
  `IS_STATEFUL` int(11) DEFAULT NULL,
  `REQUESTS_RECOVERY` int(11) DEFAULT NULL,
  PRIMARY KEY (`ENTRY_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of eos_qrtz_fired_triggers
-- ----------------------------

-- ----------------------------
-- Table structure for eos_qrtz_job_details
-- ----------------------------
DROP TABLE IF EXISTS `eos_qrtz_job_details`;
CREATE TABLE `eos_qrtz_job_details` (
  `JOB_NAME` varchar(80) NOT NULL,
  `JOB_GROUP` varchar(80) NOT NULL,
  `DESCRIPTION` varchar(120) DEFAULT NULL,
  `JOB_CLASS_NAME` varchar(128) NOT NULL,
  `IS_DURABLE` int(11) NOT NULL,
  `IS_VOLATILE` int(11) NOT NULL,
  `IS_STATEFUL` int(11) NOT NULL,
  `REQUESTS_RECOVERY` int(11) NOT NULL,
  `JOB_DATA` blob,
  PRIMARY KEY (`JOB_NAME`,`JOB_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of eos_qrtz_job_details
-- ----------------------------

-- ----------------------------
-- Table structure for eos_qrtz_job_listeners
-- ----------------------------
DROP TABLE IF EXISTS `eos_qrtz_job_listeners`;
CREATE TABLE `eos_qrtz_job_listeners` (
  `JOB_LISTENER` varchar(80) NOT NULL,
  `JOB_NAME` varchar(80) NOT NULL,
  `JOB_GROUP` varchar(80) NOT NULL,
  PRIMARY KEY (`JOB_LISTENER`,`JOB_NAME`,`JOB_GROUP`),
  KEY `FKBF2E553BBCB755AB` (`JOB_NAME`,`JOB_GROUP`),
  CONSTRAINT `FKBF2E553BBCB755AB` FOREIGN KEY (`JOB_NAME`, `JOB_GROUP`) REFERENCES `eos_qrtz_job_details` (`JOB_NAME`, `JOB_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of eos_qrtz_job_listeners
-- ----------------------------

-- ----------------------------
-- Table structure for eos_qrtz_locks
-- ----------------------------
DROP TABLE IF EXISTS `eos_qrtz_locks`;
CREATE TABLE `eos_qrtz_locks` (
  `LOCK_NAME` varchar(40) NOT NULL,
  PRIMARY KEY (`LOCK_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of eos_qrtz_locks
-- ----------------------------
INSERT INTO `eos_qrtz_locks` VALUES ('CALENDAR_ACCESS');
INSERT INTO `eos_qrtz_locks` VALUES ('JOB_ACCESS');
INSERT INTO `eos_qrtz_locks` VALUES ('MISFIRE_ACCESS');
INSERT INTO `eos_qrtz_locks` VALUES ('STATE_ACCESS');
INSERT INTO `eos_qrtz_locks` VALUES ('TRIGGER_ACCESS');

-- ----------------------------
-- Table structure for eos_qrtz_paused_trigger_grps
-- ----------------------------
DROP TABLE IF EXISTS `eos_qrtz_paused_trigger_grps`;
CREATE TABLE `eos_qrtz_paused_trigger_grps` (
  `TRIGGER_GROUP` varchar(80) NOT NULL,
  PRIMARY KEY (`TRIGGER_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of eos_qrtz_paused_trigger_grps
-- ----------------------------

-- ----------------------------
-- Table structure for eos_qrtz_scheduler_state
-- ----------------------------
DROP TABLE IF EXISTS `eos_qrtz_scheduler_state`;
CREATE TABLE `eos_qrtz_scheduler_state` (
  `INSTANCE_NAME` varchar(80) NOT NULL,
  `LAST_CHECKIN_TIME` bigint(20) NOT NULL,
  `CHECKIN_INTERVAL` bigint(20) NOT NULL,
  `RECOVERER` varchar(80) DEFAULT NULL,
  PRIMARY KEY (`INSTANCE_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of eos_qrtz_scheduler_state
-- ----------------------------

-- ----------------------------
-- Table structure for eos_qrtz_simple_triggers
-- ----------------------------
DROP TABLE IF EXISTS `eos_qrtz_simple_triggers`;
CREATE TABLE `eos_qrtz_simple_triggers` (
  `TRIGGER_NAME` varchar(80) NOT NULL,
  `TRIGGER_GROUP` varchar(80) NOT NULL,
  `REPEAT_COUNT` bigint(20) NOT NULL,
  `REPEAT_INTERVAL` bigint(20) NOT NULL,
  `TIMES_TRIGGERED` bigint(20) NOT NULL,
  PRIMARY KEY (`TRIGGER_NAME`,`TRIGGER_GROUP`),
  KEY `FK1FF9C7662D997664` (`TRIGGER_NAME`,`TRIGGER_GROUP`),
  CONSTRAINT `FK1FF9C7662D997664` FOREIGN KEY (`TRIGGER_NAME`, `TRIGGER_GROUP`) REFERENCES `eos_qrtz_triggers` (`TRIGGER_NAME`, `TRIGGER_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of eos_qrtz_simple_triggers
-- ----------------------------

-- ----------------------------
-- Table structure for eos_qrtz_triggers
-- ----------------------------
DROP TABLE IF EXISTS `eos_qrtz_triggers`;
CREATE TABLE `eos_qrtz_triggers` (
  `TRIGGER_NAME` varchar(80) NOT NULL,
  `TRIGGER_GROUP` varchar(80) NOT NULL,
  `IS_VOLATILE` int(11) NOT NULL,
  `DESCRIPTION` varchar(120) DEFAULT NULL,
  `NEXT_FIRE_TIME` bigint(20) DEFAULT NULL,
  `PREV_FIRE_TIME` bigint(20) DEFAULT NULL,
  `TRIGGER_STATE` varchar(16) NOT NULL,
  `TRIGGER_TYPE` varchar(8) NOT NULL,
  `START_TIME` bigint(20) NOT NULL,
  `END_TIME` bigint(20) DEFAULT NULL,
  `CALENDAR_NAME` varchar(80) DEFAULT NULL,
  `MISFIRE_INSTR` smallint(6) DEFAULT '2',
  `JOB_DATA` blob,
  `JOB_NAME` varchar(80) NOT NULL,
  `JOB_GROUP` varchar(80) NOT NULL,
  PRIMARY KEY (`TRIGGER_NAME`,`TRIGGER_GROUP`),
  KEY `FK861889BDBCB755AB` (`JOB_NAME`,`JOB_GROUP`),
  CONSTRAINT `FK861889BDBCB755AB` FOREIGN KEY (`JOB_NAME`, `JOB_GROUP`) REFERENCES `eos_qrtz_job_details` (`JOB_NAME`, `JOB_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of eos_qrtz_triggers
-- ----------------------------

-- ----------------------------
-- Table structure for eos_qrtz_trigger_listeners
-- ----------------------------
DROP TABLE IF EXISTS `eos_qrtz_trigger_listeners`;
CREATE TABLE `eos_qrtz_trigger_listeners` (
  `TRIGGER_LISTENER` varchar(80) NOT NULL,
  `TRIGGER_NAME` varchar(80) NOT NULL,
  `TRIGGER_GROUP` varchar(80) NOT NULL,
  PRIMARY KEY (`TRIGGER_LISTENER`,`TRIGGER_NAME`,`TRIGGER_GROUP`),
  KEY `FK4D8F4A762D997664` (`TRIGGER_NAME`,`TRIGGER_GROUP`),
  CONSTRAINT `FK4D8F4A762D997664` FOREIGN KEY (`TRIGGER_NAME`, `TRIGGER_GROUP`) REFERENCES `eos_qrtz_triggers` (`TRIGGER_NAME`, `TRIGGER_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of eos_qrtz_trigger_listeners
-- ----------------------------

-- ----------------------------
-- Table structure for sys_cron
-- ----------------------------
DROP TABLE IF EXISTS `sys_cron`;
CREATE TABLE `sys_cron` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) DEFAULT NULL,
  `tgroup` varchar(11) DEFAULT NULL,
  `description` varchar(120) DEFAULT NULL,
  `className` varchar(50) DEFAULT NULL,
  `expression` varchar(40) DEFAULT NULL,
  `status` varchar(11) DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_cron
-- ----------------------------
INSERT INTO `sys_cron` VALUES ('1', 'klay1', 'g1', '测试任务1', 'com.cn.quarts.job.TestJob1', '0/20 * * * * ?', '1', '2017-11-13 16:04:39');
INSERT INTO `sys_cron` VALUES ('2', 'klay2', 'g1', '测试任务2', 'com.cn.quarts.job.TestJob2', '0/20 * * * * ?', '1', '2017-11-13 16:04:39');

-- ----------------------------
-- Table structure for sys_dict_data
-- ----------------------------
DROP TABLE IF EXISTS `sys_dict_data`;
CREATE TABLE `sys_dict_data` (
  `dict_code` int(11) NOT NULL AUTO_INCREMENT COMMENT '字典编码',
  `dict_sort` int(4) DEFAULT '0' COMMENT '字典排序',
  `dict_label` varchar(100) DEFAULT '' COMMENT '字典标签',
  `dict_value` varchar(100) DEFAULT '' COMMENT '字典键值',
  `dict_type` varchar(100) DEFAULT '' COMMENT '字典类型',
  `css_class` varchar(500) DEFAULT '' COMMENT '样式属性',
  `list_class` varchar(500) DEFAULT '' COMMENT '回显样式',
  `is_default` char(1) DEFAULT 'N' COMMENT '是否默认（Y是 N否）',
  `status` char(1) DEFAULT '0' COMMENT '状态（0正常 1停用）',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT '' COMMENT '备注',
  PRIMARY KEY (`dict_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='字典数据表';

-- ----------------------------
-- Records of sys_dict_data
-- ----------------------------

-- ----------------------------
-- Table structure for sys_dict_type
-- ----------------------------
DROP TABLE IF EXISTS `sys_dict_type`;
CREATE TABLE `sys_dict_type` (
  `dict_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '字典主键',
  `dict_name` varchar(100) DEFAULT '' COMMENT '字典名称',
  `dict_type` varchar(100) DEFAULT '' COMMENT '字典类型',
  `status` char(1) DEFAULT '0' COMMENT '状态（0正常 1停用）',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT '' COMMENT '备注',
  PRIMARY KEY (`dict_id`),
  UNIQUE KEY `dict_type` (`dict_type`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='字典类型表';

-- ----------------------------
-- Records of sys_dict_type
-- ----------------------------

-- ----------------------------
-- Table structure for sys_logininfor
-- ----------------------------
DROP TABLE IF EXISTS `sys_logininfor`;
CREATE TABLE `sys_logininfor` (
  `info_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '访问ID',
  `login_name` varchar(50) DEFAULT '' COMMENT '登录账号',
  `ipaddr` varchar(50) DEFAULT '' COMMENT '登录IP地址',
  `login_location` varchar(255) DEFAULT '' COMMENT '登录地点',
  `browser` varchar(50) DEFAULT '' COMMENT '浏览器类型',
  `os` varchar(50) DEFAULT '' COMMENT '操作系统',
  `status` char(1) DEFAULT '0' COMMENT '登录状态（0成功 1失败）',
  `msg` varchar(255) DEFAULT '' COMMENT '提示消息',
  `login_time` datetime DEFAULT NULL COMMENT '访问时间',
  PRIMARY KEY (`info_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统访问记录';

-- ----------------------------
-- Records of sys_logininfor
-- ----------------------------

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu` (
  `menu_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '菜单ID',
  `menu_name` varchar(50) NOT NULL COMMENT '菜单名称',
  `parent_id` int(11) DEFAULT '0' COMMENT '父菜单ID',
  `order_num` int(4) DEFAULT NULL COMMENT '显示顺序',
  `url` varchar(200) DEFAULT '' COMMENT '请求地址',
  `menu_type` char(1) DEFAULT '' COMMENT '菜单类型（M目录 C菜单 F按钮）',
  `visible` char(1) DEFAULT '0' COMMENT '菜单状态（0显示 1隐藏）',
  `perms` varchar(100) DEFAULT '' COMMENT '权限标识',
  `icon` varchar(100) DEFAULT '' COMMENT '菜单图标',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT '' COMMENT '备注',
  PRIMARY KEY (`menu_id`)
) ENGINE=InnoDB AUTO_INCREMENT=502 DEFAULT CHARSET=utf8 COMMENT='菜单权限表';

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES ('1', '系统管理', '0', '1', '#', 'M', '0', '', 'iconfont icon-xitongguanli', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '系统管理目录');
INSERT INTO `sys_menu` VALUES ('2', '系统监控', '0', '2', '#', 'M', '1', '', 'iconfont icon-yonghuguanli', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '系统监控目录');
INSERT INTO `sys_menu` VALUES ('3', '系统工具', '0', '3', '#', 'M', '1', '', 'iconfont ', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '系统工具目录');
INSERT INTO `sys_menu` VALUES ('100', '用户管理', '1', '1', '/sys/user', 'C', '0', 'system:user:view', 'iconfont icon-yonghuguanli', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '用户管理菜单');
INSERT INTO `sys_menu` VALUES ('101', '角色管理', '1', '2', '/sys/role', 'C', '0', 'system:role:view', 'iconfont icon-jiaoseguanli', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '角色管理菜单');
INSERT INTO `sys_menu` VALUES ('102', '菜单管理', '1', '3', '/sys/menu', 'C', '0', 'system:menu:view', 'iconfont icon-erji-caidanguanli', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '菜单管理菜单');
INSERT INTO `sys_menu` VALUES ('103', '部门管理', '1', '4', '/sys/dept', 'C', '1', 'system:dept:view', 'iconfont ', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '部门管理菜单');
INSERT INTO `sys_menu` VALUES ('104', '岗位管理', '1', '5', '/sys/post', 'C', '1', 'system:post:view', 'iconfont', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '岗位管理菜单');
INSERT INTO `sys_menu` VALUES ('105', '字典管理', '1', '6', '/sys/dict', 'C', '0', 'system:dict:view', 'iconfont icon-shujuzidianguanli', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '字典管理菜单');
INSERT INTO `sys_menu` VALUES ('106', '参数设置', '1', '7', '/sys/user', 'C', '1', 'system:config:view', 'iconfont', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '参数设置菜单');
INSERT INTO `sys_menu` VALUES ('107', '通知公告', '1', '8', '/sys/user', 'C', '1', 'system:notice:view', 'iconfont icon-qunfengtongzhigonggao', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '通知公告菜单');
INSERT INTO `sys_menu` VALUES ('108', '日志管理', '1', '9', '#', 'M', '1', '', 'iconfont icon-xitongrizhiguanli', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '日志管理菜单');
INSERT INTO `sys_menu` VALUES ('109', '在线用户', '2', '1', '/sys/user', 'C', '1', 'monitor:online:view', 'iconfont', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '在线用户菜单');
INSERT INTO `sys_menu` VALUES ('110', '定时任务', '2', '2', '/sys/user', 'C', '0', 'monitor:job:view', 'iconfont icon-navicon-dsrwpz', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '定时任务菜单');
INSERT INTO `sys_menu` VALUES ('111', '数据监控', '2', '3', '/sys/user', 'C', '1', 'monitor:data:view', 'iconfont', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '数据监控菜单');
INSERT INTO `sys_menu` VALUES ('112', '表单构建', '3', '1', '/sys/user', 'C', '1', 'tool:build:view', 'iconfont', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '表单构建菜单');
INSERT INTO `sys_menu` VALUES ('113', '代码生成', '3', '2', '/sys/user', 'C', '1', 'tool:gen:view', 'iconfont', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '代码生成菜单');
INSERT INTO `sys_menu` VALUES ('114', '系统接口', '3', '3', '/sys/user', 'C', '1', 'tool:swagger:view', 'iconfont', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '系统接口菜单');
INSERT INTO `sys_menu` VALUES ('500', '操作日志', '108', '1', '/sys/user', 'C', '1', 'monitor:operlog:view', 'iconfont', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '操作日志菜单');
INSERT INTO `sys_menu` VALUES ('501', '登录日志', '108', '2', '/sys/user', 'C', '1', 'monitor:logininfor:view', 'iconfont', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '登录日志菜单');

-- ----------------------------
-- Table structure for sys_notice
-- ----------------------------
DROP TABLE IF EXISTS `sys_notice`;
CREATE TABLE `sys_notice` (
  `notice_id` int(4) NOT NULL AUTO_INCREMENT COMMENT '公告ID',
  `notice_title` varchar(50) NOT NULL COMMENT '公告标题',
  `notice_type` char(2) NOT NULL COMMENT '公告类型（1通知 2公告）',
  `notice_content` varchar(500) NOT NULL COMMENT '公告内容',
  `status` char(1) DEFAULT '0' COMMENT '公告状态（0正常 1关闭）',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(255) DEFAULT '' COMMENT '备注',
  PRIMARY KEY (`notice_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='通知公告表';

-- ----------------------------
-- Records of sys_notice
-- ----------------------------

-- ----------------------------
-- Table structure for sys_oper_log
-- ----------------------------
DROP TABLE IF EXISTS `sys_oper_log`;
CREATE TABLE `sys_oper_log` (
  `oper_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '日志主键',
  `title` varchar(50) DEFAULT '' COMMENT '模块标题',
  `action` varchar(100) DEFAULT '' COMMENT '功能请求',
  `method` varchar(100) DEFAULT '' COMMENT '方法名称',
  `channel` varchar(20) DEFAULT '' COMMENT '来源渠道（manage后台用户 mobile手机端用户 other其它）',
  `oper_name` varchar(50) DEFAULT '' COMMENT '操作人员',
  `org_name` varchar(50) DEFAULT '' COMMENT '组织名称',
  `oper_url` varchar(255) DEFAULT '' COMMENT '请求URL',
  `oper_ip` varchar(30) DEFAULT '' COMMENT '主机地址',
  `oper_location` varchar(255) DEFAULT '' COMMENT '操作地点',
  `oper_param` varchar(255) DEFAULT '' COMMENT '请求参数',
  `status` char(1) DEFAULT '0' COMMENT '操作状态（0正常 1异常）',
  `error_msg` varchar(2000) DEFAULT '' COMMENT '错误消息',
  `oper_time` datetime DEFAULT NULL COMMENT '操作时间',
  PRIMARY KEY (`oper_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='操作日志记录';

-- ----------------------------
-- Records of sys_oper_log
-- ----------------------------

-- ----------------------------
-- Table structure for sys_post
-- ----------------------------
DROP TABLE IF EXISTS `sys_post`;
CREATE TABLE `sys_post` (
  `post_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '岗位ID',
  `post_code` varchar(64) NOT NULL COMMENT '岗位编码',
  `post_name` varchar(50) NOT NULL COMMENT '岗位名称',
  `post_sort` int(4) NOT NULL COMMENT '显示顺序',
  `status` char(1) NOT NULL COMMENT '状态（0正常 1停用）',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT '' COMMENT '备注',
  PRIMARY KEY (`post_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='岗位信息表';

-- ----------------------------
-- Records of sys_post
-- ----------------------------

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `role_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '角色ID',
  `role_name` varchar(30) NOT NULL COMMENT '角色名称',
  `role_key` varchar(100) NOT NULL COMMENT '角色权限字符串',
  `role_sort` int(4) NOT NULL COMMENT '显示顺序',
  `status` char(1) NOT NULL COMMENT '角色状态（0正常 1停用）',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT '' COMMENT '备注',
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='角色信息表';

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('1', 'admin', '1', '1', '0', '', null, '', null, '');

-- ----------------------------
-- Table structure for sys_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_menu`;
CREATE TABLE `sys_role_menu` (
  `role_id` int(11) NOT NULL COMMENT '角色ID',
  `menu_id` int(11) NOT NULL COMMENT '菜单ID',
  PRIMARY KEY (`role_id`,`menu_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色和菜单关联表';

-- ----------------------------
-- Records of sys_role_menu
-- ----------------------------
INSERT INTO `sys_role_menu` VALUES ('1', '1');
INSERT INTO `sys_role_menu` VALUES ('1', '2');
INSERT INTO `sys_role_menu` VALUES ('1', '3');
INSERT INTO `sys_role_menu` VALUES ('1', '100');
INSERT INTO `sys_role_menu` VALUES ('1', '101');
INSERT INTO `sys_role_menu` VALUES ('1', '102');
INSERT INTO `sys_role_menu` VALUES ('1', '103');
INSERT INTO `sys_role_menu` VALUES ('1', '104');
INSERT INTO `sys_role_menu` VALUES ('1', '105');
INSERT INTO `sys_role_menu` VALUES ('1', '106');
INSERT INTO `sys_role_menu` VALUES ('1', '107');
INSERT INTO `sys_role_menu` VALUES ('1', '108');
INSERT INTO `sys_role_menu` VALUES ('1', '109');
INSERT INTO `sys_role_menu` VALUES ('1', '110');
INSERT INTO `sys_role_menu` VALUES ('1', '111');
INSERT INTO `sys_role_menu` VALUES ('1', '112');
INSERT INTO `sys_role_menu` VALUES ('1', '113');
INSERT INTO `sys_role_menu` VALUES ('1', '114');

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `org_id` int(11) DEFAULT NULL COMMENT '组织ID',
  `login_name` varchar(30) NOT NULL COMMENT '登录账号',
  `user_name` varchar(30) NOT NULL COMMENT '用户昵称',
  `user_type` varchar(2) DEFAULT '00' COMMENT '用户类型（00系统用户）',
  `email` varchar(50) DEFAULT '' COMMENT '用户邮箱',
  `phonenumber` varchar(11) DEFAULT '' COMMENT '手机号码',
  `sex` char(1) DEFAULT '0' COMMENT '用户性别（0男 1女 2未知）',
  `avatar` varchar(100) DEFAULT '' COMMENT '头像路径',
  `password` varchar(50) DEFAULT '' COMMENT '密码',
  `salt` varchar(20) DEFAULT '' COMMENT '盐加密',
  `status` char(1) DEFAULT '0' COMMENT '帐号状态（0正常 1停用）',
  `del_flag` char(1) DEFAULT '0' COMMENT '删除标志（0代表存在 2代表删除）',
  `login_ip` varchar(20) DEFAULT '' COMMENT '最后登陆IP',
  `login_date` datetime DEFAULT NULL COMMENT '最后登陆时间',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT '' COMMENT '备注',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='用户信息表';

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('1', null, 'admin', 'admin', '00', '', '', '0', '', 'aab10520eee3a1d4d756f9e0c500d1b2', 'b18245', '0', '0', '', null, '', null, '', null, '');

-- ----------------------------
-- Table structure for sys_user_post
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_post`;
CREATE TABLE `sys_user_post` (
  `user_id` varchar(64) NOT NULL COMMENT '用户ID',
  `post_id` varchar(64) NOT NULL COMMENT '岗位ID',
  PRIMARY KEY (`user_id`,`post_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户与岗位关联表';

-- ----------------------------
-- Records of sys_user_post
-- ----------------------------

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role` (
  `user_id` int(11) NOT NULL COMMENT '用户ID',
  `role_id` int(11) NOT NULL COMMENT '角色ID',
  PRIMARY KEY (`user_id`,`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户和角色关联表';

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES ('1', '1');
