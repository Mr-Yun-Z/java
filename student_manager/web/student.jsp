<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
		<!-- Bootstrap CSS -->
		<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
		<script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
		<script src="https://cdn.bootcss.com/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
		<script src="https://cdn.bootcss.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
		<script type="text/javascript">
			function del() {
				if(!confirm("确认要删除？")) {
					window.event.returnValue = false;
				}
			}
		</script>
		<title>学籍管理系统</title>
		<style type="text/css">
			body {
				/*background-color: #eee;*/
			}
			
			form h1 {
				display: inline-block;
				width: 820px;
			}
			
			.check {
				padding: 30px 30px;
			}
			
			form {
				display: inline;
			}
			
			.contain {
				width: 1000px;
				border-radius: 10px;
				border: 1px #bbb solid;
				background-color: #eee;
				padding-top: 20px;
			}
			
			button {
				margin-left: 10px;
			}
			
			.search {
				display: inline-block;
				margin-left: 500px;
			}
			
			.add {
				float: right;
				margin-right: 50px;
			}
			.pageNav{
				margin-left: 200px;
			}
		</style>
	</head>
	<body>
		<div class="contain pull-left">
			<form action="${pageContext.request.contextPath}/student" class="form-inline " method="post">
				<h2>学生学籍管理</h2>
				<div class="form-group search">
					<input type="hidden" name="method" value="findByName">
					<input type="text" name="sname" class="form-control" placeholder="请输入查询姓名" />
					<input type="submit" name="submit" class="btn" value="搜索" />
				</div>
			</form>
			<a href="${pageContext.request.contextPath}/studentAddForm.jsp" target="_self"><button class="btn btn-primary add">添加学生资料</button></a>
			<div class="pull-left">
				<table class="table table-hover">
					<thead>
						<tr>
							<th>学号</th>
							<th>姓名</th>
							<th>年龄</th>
							<th>性别</th>
							<th>地区</th>
							<th>专业</th>
							<th>班级</th>
							<th>民族</th>
							<%--  colspan属性用于将指定的横向单元格合并  --%>
							<th colspan="2">操作</th>
						</tr>
					</thead>
					<tbody>
					<c:forEach items="${stuLst}" var="stu">
						<tr id="${stu.sid}">
							<td>${stu.sid}</td>
							<td>${stu.sname}</td>
							<td>${stu.sage}</td>
							<td>${stu.ssex}</td>
							<td>${stu.snativeplace}</td>
							<td>${stu.smajor}</td>
							<td>${stu.sclass}</td>
							<td>${stu.snative}</td>
							<td><a href="${pageContext.request.contextPath}/student?method=delete&sid=${stu.sid}" style="text-decoration: none" onclick="javascript:return del();"><button class='btn btn-danger'>删除</button></a></td>
							<td>
								<a href="stuModForm.jsp?sid=${stu.sid}&sname=${stu.sname}&sage=${stu.sage}&ssex=${stu.ssex}&snativeplace=${stu.snativeplace}&smajor=${stu.smajor}&sclass=${stu.sclass}&snative=${stu.snative}"
								   style="text-decoration: none"><button class='btn btn-primary'>修改</button></a>
							</td>
						</tr>
					</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</body>
</html>