<%@page import="gugudan.GugudanDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
if (session.getAttribute("dao") == null) {
	response.sendRedirect("index.jsp");
	return;
}
GugudanDAO dao = (GugudanDAO) session.getAttribute("dao");
if (dao.getCount() == 5) {
	session.invalidate();
	response.sendRedirect("index.jsp");
	return;
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>구구단 게임</h1>
	<%
	if (dao.getCount() < 5) {
	%>
	<h2><%=dao.getCount() + 1%>
		번 째 문제 (점수 :
		<%=dao.getScore()%>)
	</h2>
	<form action="gugudanPro.jsp">
		<h2><%=dao.getQuiz()%>
			= <input type="number" name="answer" required />
		</h2>
		<button>전송</button>
	</form>
	<%
	} else {
	%>
	<h1>게임 종료 !</h1>
	<h2>
		당신의 점수는
		<%=dao.getScore()%></h2>
	<a href="index.jsp"> 처음으로 </a>
	<%
	}
	%>
</body>
</html>