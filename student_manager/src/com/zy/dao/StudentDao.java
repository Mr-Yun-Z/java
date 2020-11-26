package com.zy.dao;

import com.zy.entity.Student;

import java.util.List;

/**
 * @Auther: zhouyun
 * @Date: 2020/11/16 - 16 -14:53
 * @Description: com.zy.dao
 * @version: 1.0
 */
public interface StudentDao {
    Integer add(Student student);

    Integer deleteById(String sid);

    Integer update(Student student);

    List<Student> selectAll();

    List<Student> selectByName(String name);

}
