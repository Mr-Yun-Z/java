<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
		<link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
		<script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
		<script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
		<style type="text/css">
			ul{
				width: 200px;
				height: 200px;
				float: right;
				margin-top: 30px;
				
			}
		</style>
	</head>
	<body>
		<ul class="nav nav-pills nav-stacked">
			<li><a href="${pageContext.request.contextPath}/student?method=findAll" target="contain">学生管理</a></li>
			<li><a href="${pageContext.request.contextPath}/updateUser.jsp" target="contain">账号密码重置</a></li>
			<li><a href="${pageContext.request.contextPath}/logout" target="_parent">退出系统</a></li>
		</ul>

	</body>
</html>
