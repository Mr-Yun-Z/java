package com.zy.dao.Impl;

import com.zy.dao.UserDao;
import com.zy.entity.Student;
import com.zy.entity.User;
import com.zy.util.JdbcUtil;

import javax.xml.transform.Result;
import java.sql.SQLException;
import java.util.List;

/**
 * @Auther: zhouyun
 * @Date: 2020/11/17 - 17 -15:16
 * @Description: com.zy.dao.Impl
 * @version: 1.0
 */
public class UserDaoImpl implements UserDao {
    public User selectOne(User user) {
        JdbcUtil jdbcUtil= new JdbcUtil();
        String sql = "select * from login where user='" + user.getUser() + "' and password='" + user.getPassword()+"'";
        User result = null;
        try {
            result = jdbcUtil.getUser(sql);
            return result;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }

    public Integer updateUser(User user) {
        JdbcUtil jdbcUtil = new JdbcUtil();
        String sql = "update login set user='" + user.getUser() + "',password='" + user.getPassword() + "' where user='" + user.getUser() + "'";
        Integer result;
        try {
            result = jdbcUtil.setUser(sql);
            return result;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return 0;
    }
}
