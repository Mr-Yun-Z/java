package com.zy.util;

/**
 * @Auther: zhouyun
 * @Date: 2020/11/16 - 16 -14:46
 * @Description: com.zy.util
 * @version: 1.0
 */
import com.zy.entity.Student;
import com.zy.entity.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *  操作数据库的类
 */
public class JdbcUtil {
    //写一个获取mysql数据库连接的函数
    /**
     *  函数功能：获取数据库连接对象
     * @return 返回数据库连接对象
     *  使用说明：提前知道获取数据库连接对象时所需要的四大参数
     *  1、驱动类的名称（数据库不同，驱动类的名称不同）
     *  2、数据库的URL
     *  3、使用数据库时的用户名
     *  4、用户名对应的密码
     *  一定要导入相对应的jar包
     */
    private static Connection getConn(){
        //第一步：加载驱动类(如果有异常，则抛出异常或者使用try..catch..语句块处理)
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("驱动类加载失败。");
            /**
             *  这里可能报错：ClassNotFoundException
             *  错误原因：可能是驱动类的名称拼写错误，也可能是所需要的jar包没有导入
             */
        }
        //第二步：获取连接对象
        String url = "jdbc:mysql://localhost:3306/student_manager?userSSL=false&serverTimezone=UTC&useUnicode=true&CharacterEncoding=utf-8";
        String username = "root";
        String password = "root";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url,username,password);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("连接对象获取失败。");
        }
        //返回一个连接对象
        return conn;
    }

    /**
     *  函数功能：通过查询语句来获取数据库中的表格信息
     * @param sql
     * @return 返回一个List对象
     * @throws SQLException
     */
    public List<Student> getStudent(String sql) throws SQLException {
        //查询语句的执行结果为一个表格，即多个学生对象的集合，所有可以创建数组列表对象来存储
        List<Student> list = new ArrayList<Student>();
        //获取连接对象
        Connection conn = getConn();
        try {
            //连接对象conn调用createStatement()方法，创建一个执行SQL语句的对象st
            Statement st = conn.createStatement();
            //执行SQL语句的对象st调用executeQuery()方法，执行查询语句，将查询到的结果返回到一个结果集中
            ResultSet rs = st.executeQuery(sql);
            //遍历结果集对象
            while(rs.next()){
                Student stu = new Student();
                stu.setSid(rs.getString("sid"));
                stu.setSname(rs.getString("sname"));
                stu.setSage(rs.getInt("sage"));
                stu.setSsex(rs.getString("ssex"));
                stu.setSnativeplace(rs.getString("snativeplace"));
                stu.setSmajor(rs.getString("smajor"));
                stu.setSclass(rs.getString("sclass"));
                stu.setSnative(rs.getString("snative"));
                list.add(stu);
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }finally {
            //资源使用完之后，如果没有关闭，则需要关闭
            if (conn!=null){
                conn.close();
            }
        }
        return list;
    }

    public User getUser(String sql) throws SQLException {
        //获取连接对象
        Connection conn = getConn();
        User user =  new User();
        try {
            //连接对象conn调用createStatement()方法，创建一个执行SQL语句的对象st
            Statement st = conn.createStatement();
            //执行SQL语句的对象st调用executeQuery()方法，执行查询语句，将查询到的结果返回到一个结果集中
            ResultSet rs = st.executeQuery(sql);
            if(rs.next()) {
                user.setId(rs.getInt("id"));
                user.setUser(rs.getString("user"));
                user.setPassword(rs.getString("password"));
                return user;
            }
            System.out.println(user);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }finally {
            //资源使用完之后，如果没有关闭，则需要关闭
            if (conn!=null){
                conn.close();
            }
        }
        return null;
    }

    public Integer setUser(String sql) throws SQLException {
        //获取数据库连接对象
        Connection conn = getConn();
        try {
            //连接对象调用createStatement()方法，创建一个执行SQL语句的对象
            Statement st = conn.createStatement();
            //执行SQL语句的对象st，调用executeUpdate()方法执行SQL语句，执行结果为int类型，表示受到影响的记录条数
            //executeUpdate( )方法可以执行增删改DML语句和创建表、删除表等DDL语句
            int cnt = st.executeUpdate(sql);
            return cnt; //如果有记录受到影响，则表示更新操作成功
        }catch (Exception e){
            System.out.println(e.getMessage());
            return 0;
        }finally {
            if (conn!=null)
                conn.close();
        }
    }

    /**
     *  函数功能：对表中数据进行增删改操作
     * @param sql
     * @throws SQLException
     */
    public Integer studentUpdate(String sql) throws SQLException {
        //获取数据库连接对象
        Connection conn = getConn();
        try {
            //连接对象调用createStatement()方法，创建一个执行SQL语句的对象
            Statement st = conn.createStatement();
            //执行SQL语句的对象st，调用executeUpdate()方法执行SQL语句，执行结果为int类型，表示受到影响的记录条数
            //executeUpdate( )方法可以执行增删改DML语句和创建表、删除表等DDL语句
            int cnt = st.executeUpdate(sql);
            return cnt; //如果有记录受到影响，则表示更新操作成功
        }catch (Exception e){
            System.out.println(e.getMessage());
            return 0;
        }finally {
            if (conn!=null)
                conn.close();
        }
    }
}
