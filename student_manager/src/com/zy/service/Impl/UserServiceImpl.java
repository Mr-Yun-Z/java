package com.zy.service.Impl;

import com.zy.dao.Impl.UserDaoImpl;
import com.zy.dao.UserDao;
import com.zy.entity.User;
import com.zy.service.UserService;

/**
 * @Auther: zhouyun
 * @Date: 2020/11/17 - 17 -16:32
 * @Description: com.zy.service.Impl
 * @version: 1.0
 */
public class UserServiceImpl implements UserService {
    private static UserDaoImpl userDao;

    static {
        userDao = new UserDaoImpl();
    }

    public User selectOne(User user) {
        User result = userDao.selectOne(user);
        return result;
    }

    public Integer updateUser(User user) {
        return userDao.updateUser(user);
    }
}
