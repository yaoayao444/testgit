<%@ page language="java"
	import="java.util.*,com.dao.*,com.dao.impl.*,com.beans.*"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
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
<script type="text/javascript" src="js/jquery-1.8.0.js"></script>
<script type="text/javascript">
	$(function() {
		$("#but").click(function() {
			teaId_str = "";
			$('input[id="teaId"]:checked').each(function() {
				teaId_str += $(this).val() + " ";
			});
			alert(teaId_str);
			$.ajax({
				url : "${pageContext.request.contextPath}/stuxk",
				type : "post",
				data : {
					teaId : teaId_str,
					stuId : $("#stuId").val()
				},
				success : function(data) {
					$("#msg").html(data);
				}

			});
		});
	});
</script>

<body>
	<%
		MethodDao md = new MethodDaoImpl();
		List<Teacher> teaList = md.querytea();
		request.setAttribute("teaList", teaList);
		List<Stu_Tea> s_tList = md.querystatus();
		request.setAttribute("s_tList", s_tList);
	%>
	<form>
		<input type="hidden" name=stuId id="stuId" value="${s.id }">
		<table width="80%" border="1">
			<tr>
				<th>序号</th>
				<th>老师姓名</th>
				<th>课程</th>
				<th>状态</th>
				<th>选课</th>
			</tr>
			<c:forEach var="tea" items="${teaList }">
				<tr>
					<td>${tea.id }</td>
					<td>${tea.name }</td>
					<td>${tea.lesson }</td>
					<td><c:set var="flag" value="true"></c:set> <c:forEach
							var="st" items="${s_tList }">
							<c:choose>
								<c:when
									test="${st.status==0&&st.stuId==s.id&&st.teaId==tea.id }">
							<c:set var="flag" value="false" />申请中
								</c:when>
								<c:when
									test="${st.status==1&&st.stuId==s.id&&st.teaId==tea.id }">
							 <c:set var="flag" value="false" />已拒绝
								</c:when>
								<c:when
									test="${st.status==2&&st.stuId==s.id&&st.teaId==tea.id }">
							 <c:set var="flag" value="false" />申请成功
								</c:when>
							</c:choose>
						</c:forEach></td>
						<td>
						<c:if test="${flag }">
						<input type="checkbox" id="teaId" value="${tea.id }" />
						</c:if>
						</td>

				</tr>
			</c:forEach>
		</table>
		<input type="button" id="but" value="提交">
	</form>
	<label id="msg"></label>
</body>
</html>
