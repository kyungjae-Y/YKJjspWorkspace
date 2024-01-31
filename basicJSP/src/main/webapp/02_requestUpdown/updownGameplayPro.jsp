<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
String msg = "";

int num = Integer.parseInt(request.getParameter("number"));
int com = Integer.parseInt(request.getParameter("com"));
if (num < com) {
	msg = "Up";
} else if (num > com) {
	msg = "Down";
} else {
	msg = "정답";
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1><%=msg%></h1>
	<%
	if (msg == "Down" || msg == "Up") {
	%>
	<a href="updownGameplay.jsp?com=<%=com%>">뒤로가기</a>
	<%
	} else {
	%>
	<a href="index.jsp">처음으로</a>
	<%
	}
	%>
</body>
</html>