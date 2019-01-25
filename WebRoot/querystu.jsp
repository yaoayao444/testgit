<%@ page language="java"
	import="java.util.*,com.dao.*,com.dao.impl.*,com.beans.*"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'querystu.jsp' starting page</title>

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
	<%
		MethodDao md = new MethodDaoImpl();
		List<Students> stuList = md.querystu();
		request.setAttribute("stuList", stuList);
		List<Stu_Tea> s_tList = md.querystatus();
		request.setAttribute("s_tList", s_tList);
	%>
	<form action="${pageContext.request.contextPath}/teaXK">
		<table width="80%" border="1">
			<tr>
				<th>序号</th>
				<th>学生姓名</th>
				<th>状态</th>
				<th>操作</th>
			</tr>
			<c:forEach var="stu" items="${stuList }">

				<tr>
					<td>${stu.id }</td>
					<td>${stu.name }</td>
					<td><c:forEach var="st" items="${s_tList }">
							<c:if test="${st.stuId==stu.id&&st.teaId==t.id}">
								<c:if test="${st.status==0 }">已申请</c:if>
								<c:if test="${st.status==1 }">已拒绝</c:if>
								<c:if test="${st.status==2 }">已同意</c:if>

							</c:if>
						</c:forEach></td>
					<td><c:forEach var="st" items="${s_tList }">
							<c:if test="${st.stuId==stu.id&&st.teaId==t.id}">
								<c:if test="${st.status==0 }">

									<a
										href="${pageContext.request.contextPath}/teaXK?teaId=${t.id}&stuId=${st.stuId}&check=2">同意</a>

									<a
										href="${pageContext.request.contextPath}/teaXK?teaId=${t.id}&stuId=${st.stuId}&check=1">拒绝</a>
								</c:if>

							</c:if>
						</c:forEach></td>
				</tr>
			</c:forEach>
		</table>
		<input type="hidden" name="teaId" value="${t.id }">
	</form>
</body>
</html>
