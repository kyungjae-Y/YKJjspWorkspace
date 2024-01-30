<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
if (session.getAttribute("log") == null) {
	response.sendRedirect("index.jsp");
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div align="center">
	<h1>메인 페이지</h1>
	<a href="03_11_joinForm.jsp">회원가입</a>
	<a href="03_21_loginForm.jsp">로그인</a>
</div>
</body>
</html>