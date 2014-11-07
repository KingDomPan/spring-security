package com.gemini.dao.impl;

import org.springframework.stereotype.Component;

import com.gemini.dao.UserDao;
import com.gemini.security.entity.User;
import com.gemini.template.BaseDao;

@Component("userDaoImpl")
public class UserDaoImpl extends BaseDao<User> implements UserDao {

    @Override
    public User getUserByUsername(String username) {
        String hql = "from User u where u.name='" + username + "' and u.statusValue = 1";
        return (User) this.crudHandler.sclar(hql);
    }

}
