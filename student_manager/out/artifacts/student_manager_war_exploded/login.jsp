<%@ page import="java.net.URLDecoder" %><%--
  Created by IntelliJ IDEA.
  User: MY Pc
  Date: 2020/11/17
  Time: 13:05
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8" />
    <title>请登录</title>
    <link href="Resources/css/Login.css" type="text/css" rel="stylesheet" />
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/4.1.0/css/bootstrap.min.css">
    <script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://cdn.bootcss.com/popper.js/1.12.5/umd/popper.min.js"></script>
    <script src="https://cdn.bootcss.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>
    <script language="JavaScript">
        function checkForm(form){
            for(var i = 0;i<form.elements.length;i++){
                if(form.elements[i].type == "text" && form.elements[i].value == ""){
                    alert("请输入用户名或密码！");
                    return false;
                }
            }
            return true;
        }

    </script>
</head>
<body>
<div id="bg">
    <div id="whiteblock">
        <h2>学籍管理系统登录</h2>
        <p style="color: red">${msg}</p>
        <%
            String username = "";
            String password = "";
            Cookie[] cookies = request.getCookies();
            if (cookies != null) {
                for (int i = 0; i < cookies.length; i++) {
                    if (cookies[i].getName().equals("namepsd")) {
                        username = URLDecoder.decode(cookies[i].getValue(), "utf-8").split("-")[0];
                        password = URLDecoder.decode(cookies[i].getValue(), "utf-8").split("-")[1];
                    }
                }
            }
        %>
        <form action="${pageContext.request.contextPath}/login" method="post" onsubmit="return checkForm(this)">
            <div class="input-group input-group-lg">
                <p><input type="text" name="user" class="form-control user" placeholder="请输入管理员用户名" size="25" value="<%=username%>"></p>
                <p><input type="password" name="password" class="form-control user" placeholder="请输入管理员密码" size="25" value="<%=password%>"></p>
            </div>
            <p>
                <input type="submit" id="put1" value="登录" class="btn btn-primary" />
                <input type="reset" id="put2" value="重置" class="btn btn-danger" />
            </p>
        </form>
    </div>
</div>
</body>
</html>