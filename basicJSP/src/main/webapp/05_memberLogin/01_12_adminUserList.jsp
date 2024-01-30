<%@page import="java.util.Arrays"%>
<%@page import="java.util.ArrayList"%>
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
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div align="center">
	<h1>관리자 페이지(회원 정보 확인하기)</h1>
	<form action="01_13_adminUserDelete.jsp">
		<table border="1">
			<tr>
				<td>아이디</td>
				<td>패스워드</td>
				<td>이름</td>
				<td>성별</td>
				<td>삭제</td>
			</tr>
			<tr>
				<td><%=sampleId.get(0)%></td>
				<td><%=samplePw.get(0)%></td>
				<td><%=sampleName.get(0)%></td>
				<td><%=sampleGender.get(0)%></td>
				<td><input type="submit" value="삭제"></td>
			</tr>
			<tr>
				<td><%=sampleId.get(1)%></td>
				<td><%=samplePw.get(1)%></td>
				<td><%=sampleName.get(1)%></td>
				<td><%=sampleGender.get(1)%></td>
				<td><input type="submit" value="삭제"></td>
			</tr>
			<tr>
				<td><%=sampleId.get(2)%></td>
				<td><%=samplePw.get(2)%></td>
				<td><%=sampleName.get(2)%></td>
				<td><%=sampleGender.get(2)%></td>
				<td><input type="submit" value="삭제"></td>
			</tr>
		</table>
	</form>
		&nbsp;
	<form action="01_11_adminMain.jsp">
		<input type="submit" value="뒤로가기">
	</form>
</div>
</body>
</html>