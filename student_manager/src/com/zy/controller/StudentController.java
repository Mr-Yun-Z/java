package com.zy.controller;

import com.zy.entity.Student;
import com.zy.service.Impl.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @Auther: zhouyun
 * @Date: 2020/11/16 - 16 -15:02
 * @Description: com.zy.controller
 * @version: 1.0
 */
@WebServlet("/student")
public class StudentController extends HttpServlet {

    private static StudentServiceImpl studentService;
    static {
        studentService = new StudentServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //接收数据
        String method = request.getParameter("method");
        //判断
        if("delete".equals(method)) {
            delete(request,response);
        }else if("update".equals(method)) {
            update(request,response);
        }else if("add".equals(method)) {
            add(request,response);
        }else if("findByName".equals(method)) {
            findByName(request,response);
        } else if ("findAll".equals(method)) {
            findAll(request,response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }

    private void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取表单中各个输入框中的值
        Student student = toStudent(request);
        Integer result = studentService.add(student);
        if (result > 0) {
            System.out.println(student.getSid() + "号学生信息增加成功");
        } else {
            System.out.println(student.getSid() + "号学生信息增加失败");
        }
        request.getRequestDispatcher("/student?method=findAll").forward(request, response);
    }

    private void findByName(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String sname = request.getParameter("sname");
        List<Student> list = studentService.selectByName(sname);
        request.setAttribute("stuLst", list);
        request.getRequestDispatcher("/student.jsp").forward(request, response);
    }

    private void findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Student> list = studentService.selectAll();
        request.setAttribute("stuLst", list);
        request.getRequestDispatcher("/student.jsp").forward(request, response);
    }


    private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取表单中的数据
        Student student = toStudent(request);
        Integer result = studentService.update(student);
        if (result > 0) {
            System.out.println(student.getSid() + "号学生信息修改成功");
        } else {
            System.out.println(student.getSid() + "号学生信息修改失败");
        }
        request.getRequestDispatcher("/student?method=findAll").forward(request, response);
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String sid = request.getParameter("sid");
        Integer result = studentService.delete(sid);
        if (result > 0) {
            System.out.println(sid + "号学生信息删除成功");
        } else {
            System.out.println(sid + "号学生信息增加失败");
        }
        request.getRequestDispatcher("/student?method=findAll").forward(request, response);
    }



    private Student toStudent(HttpServletRequest request) {
        String sid = request.getParameter("sid");
        String sname = request.getParameter("sname");
        Integer sage = Integer.parseInt(request.getParameter("sage"));
        String ssex = request.getParameter("ssex");
        String snativeplace = request.getParameter("snativeplace");
        String smajor = request.getParameter("smajor");
        String sclass = request.getParameter("sclass");
        String snative = request.getParameter("snative");
        Student student = new Student(sid, sname, sage, ssex, snativeplace, smajor, sclass, snative);
        return student;
    }
}
