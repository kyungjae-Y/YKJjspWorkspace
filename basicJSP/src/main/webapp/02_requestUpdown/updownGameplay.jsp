<%@ page import="java.util.Random"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
Random random = new Random();
String com = request.getParameter("com");
int rNum = com == null ? random.nextInt(100) + 1 : Integer.parseInt(com);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p>
		치트키 :
		<%=rNum%>
	</p>
	<form action="updownGameplayPro.jsp">
		<input type="hidden" name="com" value=<%=rNum%> /> <input type="number" name="number" />
		<button>전송</button>
	</form>
</body>
</html>