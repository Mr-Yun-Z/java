<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学籍管理系统</title>
</head>
<frameset rows="10%,*" frameborder="0" framespacing="10">
		<frame src="${pageContext.request.contextPath}/Top.jsp" noresize="noresize" scrolling="yes" />
		<frameset cols="30%,*">
			<frame src="${pageContext.request.contextPath}/Left_nav.jsp" noresize="noresize" />
			<frame src="${pageContext.request.contextPath}/student?method=findAll" name="contain" />
		</frameset>
	</frameset>
</html>