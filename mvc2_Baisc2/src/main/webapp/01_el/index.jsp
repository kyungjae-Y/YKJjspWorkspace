<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	if (session.getAttribute("log") == null) {
	%>
	<a href="login.jsp">로그인</a>
	<%
	} else {
	%>
	<h1>${ log }</h1>
	<a href="">로그아웃</a>
	<%
	}
	%>
</body>
</html>