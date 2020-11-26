package com.zy.filter;

import com.zy.entity.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Auther: zhouyun
 * @Date: 2020/11/19 - 19 -19:39
 * @Description: com.zy.filter
 * @version: 1.0
 */
public class UserFilter implements Filter {
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        User user = (User)req.getSession().getAttribute("user");
        if(user == null) {
            res.sendRedirect(req.getContextPath()+"/login.jsp");
        }
        chain.doFilter(request, response);
    }

    public void destroy() {

    }
}
