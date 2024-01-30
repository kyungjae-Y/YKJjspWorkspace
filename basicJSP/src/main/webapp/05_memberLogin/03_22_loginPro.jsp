<%@ page import="java.util.Arrays"%>
<%@ page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
ArrayList<String> sampleId = new ArrayList<String>(Arrays.asList("qwer", "abcd", "hello", "admin"));
ArrayList<String> samplePw = new ArrayList<String>(Arrays.asList("1111", "2222", "3333", "admin"));
ArrayList<String> sampleName = new ArrayList<String>(Arrays.asList("이만수", "박영희", "이수민", "관리자"));
ArrayList<String> sampleGender = new ArrayList<String>(Arrays.asList("남성", "여성", "여성", "남성"));
int log = -1;

session.getAttribute("idList");
session.getAttribute("pwList");
session.getAttribute("nameList");
session.getAttribute("genderList");
session.getAttribute("log");

String enteredId = request.getParameter("id");
String enteredPw = request.getParameter("pw");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	for (int i = 0; i < sampleId.size(); i++) {
		if (enteredId.equals(sampleId.get(i)) && enteredPw.equals(samplePw.get(i))) {
			session.setAttribute("loggedInUser", sampleName.get(i));
			session.setAttribute("loggedInGender", sampleGender.get(i));
			log = 1;
			break;
		}
	}
	if (log == 3) {
		response.sendRedirect("01_11_adminMain.jsp");
	} else {
		response.sendRedirect("02_main.jsp");
	}
	%>
</body>
</html>