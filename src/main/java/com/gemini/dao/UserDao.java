package com.gemini.dao;

import com.gemini.security.entity.User;
import com.gemini.template.Dao;

public interface UserDao extends Dao<User> {
    User getUserByUsername(String username);
}
