package com.zy.service.Impl;

import com.zy.dao.Impl.StudentDaoImpl;
import com.zy.entity.Student;
import com.zy.service.StudentService;

import java.util.List;

/**
 * @Auther: zhouyun
 * @Date: 2020/11/16 - 16 -15:29
 * @Description: com.zy.service.Impl
 * @version: 1.0
 */
public class StudentServiceImpl implements StudentService {
    StudentDaoImpl studentDao = new StudentDaoImpl();
    public List<Student> selectAll() {
        return studentDao.selectAll();
    }

    public List<Student> selectByName(String name) {
        return studentDao.selectByName(name);
    }

    public Integer update(Student student) {
        return studentDao.update(student);
    }

    public Integer add(Student student) {
        return studentDao.add(student);
    }

    public Integer delete(String sid) {
        return studentDao.deleteById(sid);
    }
}
