package com.gemini.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.stereotype.Component;

import com.gemini.dao.RolePermissionDao;
import com.gemini.security.entity.Permission;
import com.gemini.security.entity.Role;

@Component("rolePermissionDaoImpl")
public class RolePermissionDaoImpl implements RolePermissionDao {

    private JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return this.jdbcTemplate;
    }

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private final static String GET_ROLE_MAPPING_PERMISSION = "select p.URL, r.ROLE_NAME from t_acl_permission p,t_acl_role r,t_acl_role_permission rp where p.MENU_ID=rp.ACL_PERMISSION_ID and rp.ACL_ROLE_ID=r.ACL_ROLE_ID";

    @Override
    public List<Map<Role, Permission>> getRoleMappingPermission() {
        return this.getJdbcTemplate().execute(GET_ROLE_MAPPING_PERMISSION,
                new PreparedStatementCallback<List<Map<Role, Permission>>>() {
                    @Override
                    public List<Map<Role, Permission>> doInPreparedStatement(
                            PreparedStatement pstmt) throws SQLException,
                            DataAccessException {
                        List<Map<Role, Permission>> result = new ArrayList<Map<Role, Permission>>();
                        ResultSet rs = pstmt.executeQuery();
                        Role r = null;
                        Permission p = null;
                        while (rs.next()) {
                            r = new Role();
                            r.setName(rs.getString(2));
                            p = new Permission();
                            p.setPageUrl(rs.getString(1));
                            Map<Role, Permission> m = new HashMap<Role, Permission>();
                            m.put(r, p);
                            result.add(m);
                        }
                        return result;
                    }
                });
    }
}
