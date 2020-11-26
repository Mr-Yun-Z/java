package com.zy.dao;

import com.zy.entity.Student;
import com.zy.entity.User;

/**
 * @Auther: zhouyun
 * @Date: 2020/11/17 - 17 -15:08
 * @Description: com.zy.dao
 * @version: 1.0
 */
public interface UserDao {
    User selectOne(User user);
    Integer updateUser(User user);
}
