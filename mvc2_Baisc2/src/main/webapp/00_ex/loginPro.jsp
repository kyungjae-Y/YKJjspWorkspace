<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
String id = request.getParameter("id");
String pw = request.getParameter("pw");

int check2 = (int) request.getAttribute("check");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>id = ${ id }</h2>
	<h2>check = ${ check }</h2>
	<h2>
		check =
		<%=check2%></h2>
	<h3>
		<%=id%></h3>
	<h3>
		<%=pw%></h3>
</body>
</html>