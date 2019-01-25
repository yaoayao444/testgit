<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  <body>
    <form action="${pageContext.request.contextPath}/login" method="post">
    姓名：<input type="text" name="name" id="name"><br>
    密码：<input type="password" name="password" id="password"><br>
    &nbsp; &nbsp; &nbsp;老师<input type="checkbox" name="role" value="0">&nbsp; &nbsp; &nbsp;学生<input type="checkbox" name="role" value="1"><br>
    <input type="submit" id="tologin" value="登录">
    </form>
  </body>
</html>
