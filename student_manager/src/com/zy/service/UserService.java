package com.zy.service;

import com.zy.entity.User;

/**
 * @Auther: zhouyun
 * @Date: 2020/11/17 - 17 -16:29
 * @Description: com.zy.service
 * @version: 1.0
 */
public interface UserService {
    User selectOne(User user);

    Integer updateUser(User user);
}
