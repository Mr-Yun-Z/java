package com.zy.service;

import com.zy.entity.Student;

import java.util.List;

/**
 * @Auther: zhouyun
 * @Date: 2020/11/16 - 16 -15:23
 * @Description: com.zy.service
 * @version: 1.0
 */
public interface StudentService {
    List<Student> selectAll();

    List<Student> selectByName(String name);

    Integer update(Student student);

    Integer add(Student student);

    Integer delete(String sid);
}
