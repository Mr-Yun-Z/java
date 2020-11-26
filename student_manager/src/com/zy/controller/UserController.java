package com.zy.controller;

import com.zy.entity.User;
import com.zy.service.Impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.net.URLEncoder;

/**
 * @Auther: zhouyun
 * @Date: 2020/11/17 - 17 -16:35
 * @Description: com.zy.controller
 * @version: 1.0
 */
@WebServlet("/login")
public class UserController extends HttpServlet {
    private static UserServiceImpl userService;
    static {
        userService = new UserServiceImpl();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("user");
        String password = request.getParameter("password");
        User user = userService.selectOne(new User(username, password));
        if (user != null) {
            System.out.println("登录成功");
            HttpSession session = request.getSession();
            session.setAttribute("user",user);
//            Cookie cookieName = new Cookie("username", username);
//            Cookie cookiePassword = new Cookie("password", password);
//            cookieName.setMaxAge(7*24*3600);
//            cookiePassword.setMaxAge(7 * 24 * 3600);
//            response.addCookie(cookieName);
//            response.addCookie(cookiePassword);
            Cookie namepsd = new Cookie("namepsd", URLEncoder.encode(username + "-" + password, "UTF-8"));
            namepsd.setMaxAge(7 * 24 * 3600);
            namepsd.setPath("/");
            response.addCookie(namepsd);
            response.sendRedirect(request.getContextPath()+"/frame.jsp");
        }else {
            System.out.println("登录失败");
            request.setAttribute("msg", "用户名或密码错误！");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
    }
}
