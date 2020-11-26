package com.zy.controller;

import com.zy.entity.User;
import com.zy.service.Impl.UserServiceImpl;
import com.zy.service.UserService;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Auther: zhouyun
 * @Date: 2020/11/20 - 20 -11:40
 * @Description: com.zy.controller
 * @version: 1.0
 */
@WebServlet("/updateUser")
public class UpdateUserController extends HttpServlet {
    private UserServiceImpl userService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        userService = new UserServiceImpl();
        String username = request.getParameter("user");
        String password = request.getParameter("password");
        User user = new User(username, password);
        Integer result = userService.updateUser(user);
        if (result != 0) {
             System.out.println("修改成功");
            request.getSession().invalidate();
            PrintWriter out = response.getWriter();
            out.print("<script type='text/javascript'>alert('更改密码成功!请重新登录!');window.parent.frames.location.href='login.jsp';</script>");
        }else {
            System.out.println("修改失败");
            request.setAttribute("msg", "修改失败，请重试！");
            request.getRequestDispatcher("/updateUser.jsp").forward(request, response);
        }
    }

}
