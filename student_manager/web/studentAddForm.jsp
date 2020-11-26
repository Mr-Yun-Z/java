<%--
  Created by IntelliJ IDEA.
  User: MY Pc
  Date: 2020/11/16
  Time: 14:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>增加学生信息页面</title>
    <style>
        <%--  div块居中显示  --%>
        .divcenter {
            width: 850px;
            height: 400px;
            background-color: aquamarine;
            /* margin: auto;使div块居中显示 */
            margin: auto;
        }
    </style>
</head>
<body>
<div class="divcenter">
    <div style="height: 10px"></div>
    <%--  使用<form>标签创建表单，在表单中使用<table>标签进行页面布局，使用<input>标签搜集用户输入的数据  --%>
    <form action="${pageContext.request.contextPath}/student" style="text-align: center;" method="post">
        <input type="hidden" name="method" id="method" value="add">
        <%-- 表格使用align="center"居中显示 --%>
        <table align="center">
            <tr>
                <td colspan="2" style="text-align: center">
                    <font style="color: red">* 代表必填项</font>
                </td>
            </tr>
            <tr>
                <td>学号：</td>
                <td>
                    <input id="sid" name="sid" placeholder="请输入学号" required >
                    <font style="color: red">*</font>
                </td>
            </tr>
            <tr>
                <td>姓名：</td>
                <td><input id="sname" name="sname" placeholder="请输入姓名" required>
                    <font style="color: red">*</font>
                </td>
            </tr>
            <tr>
                <td>年龄：</td>
                <td><input id="sage" name="sage" placeholder="请输入年龄" required>
                    <font style="color: red">*</font>
                </td>
            </tr>
            <tr>
                <td>性别：</td>
                <td><input id="ssex" name="ssex" placeholder="请输入性别" required>
                    <font style="color: red">*</font>
                </td>
            </tr>
            <tr>
                <td>地区：</td>
                <td><input id="snativeplace" name="snativeplace" placeholder="请输入学生所在地区" required>
                    <font style="color: red">*</font>
                </td>
            </tr>
            <tr>
                <td>专业：</td>
                <td><input id="smajor" name="smajor" placeholder="请输入学生所在专业" required>
                    <font style="color: red">*</font>
                </td>
            </tr>
            <tr>
                <td>班级：</td>
                <td><input id="sclass" name="sclass" placeholder="请输入学生所在班级" required>
                    <font style="color: red">*</font>
                </td>
            </tr>
            <tr>
                <td>民族：</td>
                <td><input id="snative" name="snative" placeholder="请输入学生所属民族" required>
                    <font style="color: red">*</font>
                </td>
            </tr>
        </table>
        <table align="center">
            <tr style="text-align: center">
                <td>
                    <input type="submit" value="增加">
                </td>
                <td>
                    <input type="reset" value="重置">
                </td>
                <td>
                    <input type="button" value="返回" onclick="window.location.href='student.jsp'">
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
