/*
Navicat MySQL Data Transfer
Source Database       : oops
Target Server Type    : MYSQL
Target Server Version : 50616
File Encoding         : 65001
Date: 2014-11-04 09:23:23
Author: KingDom
*/

#DELIMITER ;;

SET FOREIGN_KEY_CHECKS=0;;

-- ----------------------------
-- Table structure for t_acl_permission
-- ----------------------------
DROP TABLE IF EXISTS `t_acl_permission`;;
CREATE TABLE `t_acl_permission` (
  `MENU_ID` bigint(20) NOT NULL,
  `PERMISSION_CODE` varchar(255) DEFAULT NULL,
  `MENU_DESC` varchar(255) DEFAULT NULL,
  `NAME_CN` varchar(255) DEFAULT NULL,
  `MENU_INDEX` int(11) DEFAULT NULL,
  `URL` varchar(255) DEFAULT NULL,
  `IMAGE_URL` varchar(255) DEFAULT NULL,
  `NAME_EN` varchar(255) DEFAULT NULL,
  `ENABLED` int(11) DEFAULT NULL,
  `MENU_TYPE` int(11) DEFAULT NULL,
  `PARENT_ID` bigint(20) DEFAULT NULL,
  CONSTRAINT `pk_acl_permission` PRIMARY KEY (`MENU_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;;

-- ----------------------------
-- Table structure for t_acl_resource
-- ----------------------------
DROP TABLE IF EXISTS `t_acl_resource`;;
CREATE TABLE `t_acl_resource` (
  `ACL_RESOURCE_ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `RESOURCE_KEY` varchar(255) NOT NULL,
  `RESOURCE_TYPE` int(11) NOT NULL,
  `ACL_USERGROUP_ID` bigint(20) NOT NULL,
  CONSTRAINT `pk_acl_resource` PRIMARY KEY (`ACL_RESOURCE_ID`),
  CONSTRAINT `fk_acl_resource_acl_usergroup_usergroup_id` FOREIGN KEY (`ACL_USERGROUP_ID`) REFERENCES `t_acl_usergroup` (`ACL_USERGROUP_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;;

-- ----------------------------
-- Table structure for t_acl_resource_define
-- ----------------------------
DROP TABLE IF EXISTS `t_acl_resource_define`;;
CREATE TABLE `t_acl_resource_define` (
  `ACL_RESOURCE_DEFINE_ID` bigint(20) NOT NULL,
  `BEAN_ID` varchar(255) DEFAULT NULL,
  `DYNAMIC` bit(1) DEFAULT NULL,
  `ENTITY_NAME` varchar(255) DEFAULT NULL,
  `RESOURCE_NAME` varchar(255) DEFAULT NULL,
  `REMARKS` varchar(255) DEFAULT NULL,
  `TABLE_NAME` varchar(255) DEFAULT NULL,
  `RESOURCE_CODE` int(11) DEFAULT NULL,
  CONSTRAINT `pk_acl_resource_define` PRIMARY KEY (`ACL_RESOURCE_DEFINE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;;

-- ----------------------------
-- Table structure for t_acl_role
-- ----------------------------
DROP TABLE IF EXISTS `t_acl_role`;;
CREATE TABLE `t_acl_role` (
  `ACL_ROLE_ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `CREATE_USER_ID` bigint(20) NOT NULL,
  `DESCRIPTION` varchar(255) DEFAULT NULL,
  `ENABLED` int(11) DEFAULT NULL,
  `INSERT_TIME` datetime NOT NULL,
  `ROLE_NAME` varchar(255) NOT NULL,
  `UPDATE_TIME` datetime NOT NULL,
  CONSTRAINT `pk_acl_role` PRIMARY KEY (`ACL_ROLE_ID`),
  CONSTRAINT `unique_role_name` unique(`ROLE_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;;

-- ----------------------------
-- Table structure for t_acl_role_permission
-- ----------------------------
DROP TABLE IF EXISTS `t_acl_role_permission`;;
CREATE TABLE `t_acl_role_permission` (
  `ACL_ROLE_ID` bigint(20) NOT NULL,
  `ACL_PERMISSION_ID` bigint(20) NOT NULL,
  CONSTRAINT `pk_acl_role_permission_role_id_permission_id` PRIMARY KEY (`ACL_ROLE_ID`,`ACL_PERMISSION_ID`),
  CONSTRAINT `fk_acl_role_permission_acl_role_role_id` FOREIGN KEY (`ACL_ROLE_ID`) REFERENCES `t_acl_role` (`ACL_ROLE_ID`),
  CONSTRAINT `fk_acl_role_permission_acl_permission_permission_id` FOREIGN KEY (`ACL_PERMISSION_ID`) REFERENCES `t_acl_permission` (`MENU_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;;

-- ----------------------------
-- Table structure for t_acl_user
-- ----------------------------
DROP TABLE IF EXISTS `t_acl_user`;;
CREATE TABLE `t_acl_user` (
  `ACL_USER_ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `ALIAS` varchar(255) DEFAULT NULL,
  `ARG1` int(11) DEFAULT NULL,
  `ARG2` int(11) DEFAULT NULL,
  `ARG3` varchar(255) DEFAULT NULL,
  `ARG4` varchar(255) DEFAULT NULL,
  `BIRTHDAY` varchar(255) DEFAULT NULL,
  `CREATE_USER_ID` bigint(20) NOT NULL,
  `DESCRIPTION` varchar(255) DEFAULT NULL,
  `E_MAIL` varchar(255) DEFAULT NULL,
  `INSERT_TIME` datetime NOT NULL,
  `IS_LEADER` int(11) DEFAULT NULL,
  `IS_PARTNER` int(11) DEFAULT NULL,
  `IS_SERVICE_MANAGER` int(11) DEFAULT NULL,
  `LOGIN_NAME` varchar(45) NOT NULL,
  `OFFICE_PHONE` varchar(255) DEFAULT NULL,
  `ORDER_INDEX` bigint(20) DEFAULT NULL,
  `PASSWORD` varchar(45) NOT NULL,
  `PASSWORD_UPDATE_DATE` date DEFAULT NULL,
  `TELEPHONE` varchar(255) DEFAULT NULL,
  `PID` varchar(255) DEFAULT NULL,
  `PINGYIN` varchar(255) DEFAULT NULL,
  `SEX` int(11) DEFAULT NULL,
  `STATUS` int(11) NOT NULL,
  `USER_TYPE` int(11) NOT NULL,
  `UPDATE_TIME` datetime NOT NULL,
  `ORG_ID` bigint(20) DEFAULT NULL,
  `REGION_ID` bigint(20) DEFAULT NULL,
  CONSTRAINT `pk_acl_user` PRIMARY KEY (`ACL_USER_ID`),
  CONSTRAINT `unique_user_user_id` UNIQUE(`LOGIN_NAME`),
  CONSTRAINT `fk_acl_user_t_region_region_id` FOREIGN KEY (`REGION_ID`) REFERENCES `t_region` (`REGION_ID`),
  CONSTRAINT `fk_acl_user_acl_usergroup_org_id` FOREIGN KEY (`ORG_ID`) REFERENCES `t_acl_usergroup` (`ACL_USERGROUP_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;;

-- ----------------------------
-- Table structure for t_acl_usergroup
-- ----------------------------
DROP TABLE IF EXISTS `t_acl_usergroup`;;
CREATE TABLE `t_acl_usergroup` (
  `ACL_USERGROUP_ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `CREATE_USER_ID` bigint(20) DEFAULT NULL,
  `DESCRIPTION` varchar(255) DEFAULT NULL,
  `GROUP_FULL_NAME` varchar(255) DEFAULT NULL,
  `INSERT_TIME` datetime DEFAULT NULL,
  `GROUP_NAME` varchar(255) DEFAULT NULL,
  `ORDER_INDEX` bigint(20) DEFAULT NULL,
  `ORG_LEVEL` int(11) DEFAULT NULL,
  `STATUS` int(11) DEFAULT NULL,
  `GROUP_TYPE` int(11) DEFAULT NULL,
  `UPDATE_TIME` datetime DEFAULT NULL,
  `PARENT_ID` bigint(20) DEFAULT NULL,
  `REGION_ID` bigint(20) DEFAULT NULL,
  CONSTRAINT `pk_acl_usergroup_usergroup_id` PRIMARY KEY (`ACL_USERGROUP_ID`),
  CONSTRAINT `fk_acl_usergroup_acl_usergroup_usergroup_id` FOREIGN KEY (`PARENT_ID`) REFERENCES `t_acl_usergroup` (`ACL_USERGROUP_ID`),
  CONSTRAINT `fk_acl_usergroup_t_region_region_id` FOREIGN KEY (`REGION_ID`) REFERENCES `t_region` (`REGION_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;;

-- ----------------------------
-- Table structure for t_acl_usergroup_role
-- ----------------------------
DROP TABLE IF EXISTS `t_acl_usergroup_role`;;
CREATE TABLE `t_acl_usergroup_role` (
  `ACL_USERGROUP_ID` bigint(20) NOT NULL,
  `ACL_ROLE_ID` bigint(20) NOT NULL,
  CONSTRAINT `fk_acl_usergroup_role_acl_role_role_id` FOREIGN KEY (`ACL_ROLE_ID`) REFERENCES `t_acl_role` (`ACL_ROLE_ID`),
  CONSTRAINT `fk_acl_usergroup_role_acl_usergroup_usergroup_id` FOREIGN KEY (`ACL_USERGROUP_ID`) REFERENCES `t_acl_usergroup` (`ACL_USERGROUP_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;;

-- ----------------------------
-- Table structure for t_acl_user_role
-- ----------------------------
DROP TABLE IF EXISTS `t_acl_user_role`;;
CREATE TABLE `t_acl_user_role` (
  `ACL_USER_ID` bigint(20) NOT NULL,
  `ACL_ROLE_ID` bigint(20) NOT NULL,
  CONSTRAINT `fk_acl_user_role_acl_role_role_id` FOREIGN KEY (`ACL_ROLE_ID`) REFERENCES `t_acl_role` (`ACL_ROLE_ID`),
  CONSTRAINT `fk_acl_user_role_acl_user_user_id` FOREIGN KEY (`ACL_USER_ID`) REFERENCES `t_acl_user` (`ACL_USER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;;

-- ----------------------------
-- Table structure for t_acl_user_usergroup
-- ----------------------------
DROP TABLE IF EXISTS `t_acl_user_usergroup`;;
CREATE TABLE `t_acl_user_usergroup` (
  `ACL_USERGROUP_ID` bigint(20) NOT NULL,
  `ACL_USER_ID` bigint(20) NOT NULL,
  CONSTRAINT `pk_acl_user_usergroup_usergroup_id_user_id` PRIMARY KEY (`ACL_USERGROUP_ID`,`ACL_USER_ID`),
  CONSTRAINT `fk_acl_user_usergroup_acl_usergroup_usergroup_id` FOREIGN KEY (`ACL_USERGROUP_ID`) REFERENCES `t_acl_usergroup` (`ACL_USERGROUP_ID`),
  CONSTRAINT `fk_acl_user_usergroup_acl_user_user_id` FOREIGN KEY (`ACL_USER_ID`) REFERENCES `t_acl_user` (`ACL_USER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;;

-- ----------------------------
-- Table structure for t_code
-- ----------------------------
DROP TABLE IF EXISTS `t_code`;;
CREATE TABLE `t_code` (
  `CODE_ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `COL_NAME` varchar(255) DEFAULT NULL,
  `DESC_NAME` varchar(255) DEFAULT NULL,
  `REMARK` varchar(255) DEFAULT NULL,
  `TABLE_NAME` varchar(255) DEFAULT NULL,
  `VALUE` varchar(255) DEFAULT NULL,
  CONSTRAINT `pk_t_code_code_id` PRIMARY KEY (`CODE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;;

-- ----------------------------
-- Table structure for t_region
-- ----------------------------
DROP TABLE IF EXISTS `t_region`;;
CREATE TABLE `t_region` (
  `REGION_ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `REGION_CODE` varchar(255) DEFAULT NULL,
  `NAME_CN` varchar(255) DEFAULT NULL,
  `NAME_PY` varchar(255) DEFAULT NULL,
  `NET_TITLE` varchar(255) DEFAULT NULL,
  `REGION_NO` varchar(255) DEFAULT NULL,
  `PARENT_REGION_ID` bigint(20) DEFAULT NULL,
  `REGION_TYPE` int(11) DEFAULT NULL,
  CONSTRAINT `pk_t_region` PRIMARY KEY (`REGION_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;;

-- ----------------------------
-- Table structure for t_sm_operate_log
-- ----------------------------
DROP TABLE IF EXISTS `t_sm_operate_log`;;
CREATE TABLE `t_sm_operate_log` (
  `SM_OPERATE_LOG_ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `HANDLE_USER_NAME` varchar(255) NOT NULL,
  `MODULE_TYPE` int(11) NOT NULL,
  `OPERATE_ACTION` varchar(255) DEFAULT NULL,
  `OPERATE_COMMENT` varchar(255) DEFAULT NULL,
  `OPERATE_RESULT_STATUS` int(11) DEFAULT NULL,
  `OPERATE_TIME` datetime NOT NULL,
  `REMARKS` varchar(255) DEFAULT NULL,
  CONSTRAINT `pk_t_sm_operate_log` PRIMARY KEY (`SM_OPERATE_LOG_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;;
