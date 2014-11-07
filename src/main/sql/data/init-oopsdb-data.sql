#DELIMITER ;;

-- ----------------------------
-- Records of t_acl_permission
-- ----------------------------

INSERT INTO `t_acl_permission` VALUES ('1', null, null, '安全管理', '1', '/index.jsp', '/resources/images/safe_bak.png', null, '1', '0', null);;
INSERT INTO `t_acl_permission` VALUES ('2', null, null, '缓存管理', '2', '/sys/ehcache_manager.zul', null, null, '1', '0', null);;
INSERT INTO `t_acl_permission` VALUES ('3', null, null, '日志管理', '3', '/sys/log_mgmt.zul', null, null, '1', '0', null);;
INSERT INTO `t_acl_permission` VALUES ('4', null, null, '密码修改', '4', '/sys/user/pswd_modify.zul', null, null, '1', '2', null);;
INSERT INTO `t_acl_permission` VALUES ('5', null, null, '在线用户监控', '5', '/sys/users_online.zul', null, null, '1', '0', null);;
INSERT INTO `t_acl_permission` VALUES ('6', null, null, '字典值管理', '6', '/sys/code_mgmt.zul', null, null, '1', '0', null);;
INSERT INTO `t_acl_permission` VALUES ('7', '菜单配置管理', null, '菜单管理', '7', '/sys/menuitem_mgmt.zul', null, null, '1', '0', null);;
INSERT INTO `t_acl_permission` VALUES ('8', null, null, '权限管理', '8', '/panqd/index.jsp', null, null, '1', '0', null);;
INSERT INTO `t_acl_permission` VALUES ('9', null, null, '用户管理', '9', '/sys/user/index.zul', null, null, '1', '0', null);;
INSERT INTO `t_acl_permission` VALUES ('10', null, null, '角色管理', '10', '/sys/role/index.zul', null, null, '1', '0', null);;
INSERT INTO `t_acl_permission` VALUES ('11', null, null, '用户组管理', '11', '/sys/usergroup/index.zul', null, null, '1', '0', null);;

-- ----------------------------
-- Records of t_acl_role
-- ----------------------------
INSERT INTO `t_acl_role` VALUES ('1', '0', '管理员', '1', '0000-00-00 00:00:00', 'ROLE_ADMIN', '0000-00-00 00:00:00');;
INSERT INTO `t_acl_role` VALUES ('2', '0', '普通用户', '1', '0000-00-00 00:00:00', 'ROLE_USER', '0000-00-00 00:00:00');;

-- ----------------------------
-- Records of t_acl_role_permission
-- ----------------------------
INSERT INTO `t_acl_role_permission` VALUES ('1', '1');;
INSERT INTO `t_acl_role_permission` VALUES ('1', '2');;
INSERT INTO `t_acl_role_permission` VALUES ('1', '3');;
INSERT INTO `t_acl_role_permission` VALUES ('1', '4');;
INSERT INTO `t_acl_role_permission` VALUES ('2', '5');;
INSERT INTO `t_acl_role_permission` VALUES ('2', '6');;
INSERT INTO `t_acl_role_permission` VALUES ('2', '7');;
INSERT INTO `t_acl_role_permission` VALUES ('2', '8');;

-- ----------------------------
-- Records of t_acl_user
-- ----------------------------
INSERT INTO `t_acl_user` VALUES ('1', null, null, null, null, null, null, '0', null, null, '0000-00-00 00:00:00', null, null, null, 'admin', null, null, '24B426D3E67656F6150362AB448457BF', null, null, null, null, null, '1', '0', '0000-00-00 00:00:00', null, null);;
INSERT INTO `t_acl_user` VALUES ('2', null, null, null, null, null, null, '0', null, null, '0000-00-00 00:00:00', null, null, null, 'user', null, null, '24B426D3E67656F6150362AB448457BF', null, null, null, null, null, '1', '0', '0000-00-00 00:00:00', null, null);;
INSERT INTO `t_acl_user` VALUES ('3', null, null, null, null, null, null, '0', null, null, '0000-00-00 00:00:00', null, null, null, 'panqd', null, null, '24B426D3E67656F6150362AB448457BF', null, null, null, null, null, '1', '0', '0000-00-00 00:00:00', null, null);;

-- ----------------------------
-- Records of t_acl_usergroup
-- ----------------------------
INSERT INTO `t_acl_usergroup` VALUES ('1', null, null, null, null, 'ROOT', '1', '1', '1', '1', null, null, null);;
INSERT INTO `t_acl_usergroup` VALUES ('2', null, null, null, null, '自定义用户组', '2', '1', '1', '1', null, null, null);;
INSERT INTO `t_acl_usergroup` VALUES ('3', null, null, null, null, '组织机构', '3', '1', '1', '2', null, null, null);;

-- ----------------------------
-- Records of t_acl_usergroup_role
-- ----------------------------
INSERT INTO `t_acl_usergroup_role` VALUES ('1', '1');;
INSERT INTO `t_acl_usergroup_role` VALUES ('2', '2');;
INSERT INTO `t_acl_usergroup_role` VALUES ('3', '2');;

-- ----------------------------
-- Records of t_acl_user_role
-- ----------------------------
INSERT INTO `t_acl_user_role` VALUES ('1', '1');;
INSERT INTO `t_acl_user_role` VALUES ('1', '2');;
INSERT INTO `t_acl_user_role` VALUES ('2', '2');;

-- ----------------------------
-- Records of t_acl_user_usergroup
-- ----------------------------
INSERT INTO `t_acl_user_usergroup` VALUES ('1', '1');;
INSERT INTO `t_acl_user_usergroup` VALUES ('1', '2');;
INSERT INTO `t_acl_user_usergroup` VALUES ('2', '3');;
INSERT INTO `t_acl_user_usergroup` VALUES ('3', '3');;

-- ----------------------------
-- Records of t_code
-- ----------------------------
INSERT INTO `t_code` VALUES ('1', 'OPERATE_RESULT_STATUS', '成功', '操作结果', 'T_SM_OPERATE_LOG', '1');;
INSERT INTO `t_code` VALUES ('2', 'OPERATE_RESULT_STATUS', '失败', '操作结果', 'T_SM_OPERATE_LOG', '2');;
INSERT INTO `t_code` VALUES ('3', 'USER_TYPE', '超级管理员', '用户类别', 'T_ACL_USER', '1');;
INSERT INTO `t_code` VALUES ('4', 'USER_TYPE', '监控人员', '用户类别', 'T_ACL_USER', '2');;
INSERT INTO `t_code` VALUES ('5', 'STATUS', '在用', '用户状态', 'T_ACL_USER', '1');;
INSERT INTO `t_code` VALUES ('6', 'STATUS', '注销', '用户状态', 'T_ACL_USER', '2');;
INSERT INTO `t_code` VALUES ('7', 'STATUS', '锁定', '用户状态', 'T_ACL_USER', '3');;
INSERT INTO `t_code` VALUES ('8', 'GROUP_TYPE', '组织结构', '用户组类型', 'T_ACL_USERGROUP', '2');;
INSERT INTO `t_code` VALUES ('9', 'GROUP_TYPE', '普通用户组', '用户组类型', 'T_ACL_USERGROUP', '1');;
