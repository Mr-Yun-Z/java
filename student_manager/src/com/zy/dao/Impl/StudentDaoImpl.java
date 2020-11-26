package com.zy.dao.Impl;

import com.zy.dao.StudentDao;
import com.zy.entity.Student;
import com.zy.util.JdbcUtil;

import java.sql.SQLException;
import java.util.List;

/**
 * @Auther: zhouyun
 * @Date: 2020/11/16 - 16 -14:59
 * @Description: com.zy.dao.Impl
 * @version: 1.0
 */
public class StudentDaoImpl implements StudentDao {

    public Integer add(Student student) {
        //创建一个操作数据库的对象
        JdbcUtil jdbcUtil = new JdbcUtil();
        //组装SQL语句
        String sql = "insert into student(sid,sname,sage,ssex,snativeplace,smajor,sclass,snative) values("+student.getSid()+",'"+student.getSname()+"',"+
                student.getSage()+",'"+student.getSsex()+"','"+student.getSnativeplace()+"','"+student.getSmajor()+"','"+student.getSclass()+"','"+student.getSnative()+"')";
        //调用函数执行SQL语句
        try {
            Integer result = jdbcUtil.studentUpdate(sql);
            if (result > 0) {
                System.out.println("insert 语句为:" + sql);
                System.out.println(student.getSid() + "号学生信息增加成功");
            } else {
                System.out.println(student.getSid() + "号学生信息增加失败");
            }
            return result;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return 0;
        }
    }

    public Integer deleteById(String sid) {
        String sql = "delete from student where sid = "+sid;
        JdbcUtil jdbcUtil = new JdbcUtil();
        try {
            Integer result = jdbcUtil.studentUpdate(sql);
            if (result > 0){
                System.out.println("删除语句为:"+sql);
                System.out.println(sid+"号学生已成功删除");
            }else {
                System.out.println(sql);
                System.out.println(sid+"号学生删除失败");
            }
            return result;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return 0;
    }

    public Integer update(Student student) {
        //创建一个操作数据库的对象
        JdbcUtil jdbcUtil = new JdbcUtil();
        //组装SQL语句
        String sql = "update student set sname='" + student.getSname() + "',sage=" + student.getSage() + ",ssex='" + student.getSsex()
                + "',snativeplace='" + student.getSnativeplace() + "',smajor='" + student.getSmajor()
                + "',sclass='" + student.getSclass() + "',snative='" + student.getSnative() + "'  where sid=" + student.getSid();
        Integer result = 0;
        try {
            result = jdbcUtil.studentUpdate(sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return result;
    }

    public List<Student> selectAll() {
        JdbcUtil jdbcUtil = new JdbcUtil();
        String sql = "select * from student";
        List<Student> list = null;
        try {
            list = jdbcUtil.getStudent(sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }

    public List<Student> selectByName(String name) {
        JdbcUtil jdbcUtil= new JdbcUtil();
        String sql = null;
        if (name == null) {
            sql = "select * from student";
        } else {
            sql = "select * from student where sname like '%" + name + "%'";
        }
        try {
            List<Student> list = jdbcUtil.getStudent(sql);
            return list;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }
}
