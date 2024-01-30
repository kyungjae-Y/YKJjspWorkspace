<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div align="center">
	<h1>회원정보 수정</h1>
	<form action="03_32_updatePro.jsp">
		<table border="1">
			<tr>
				<td>아이디</td>
				<td colspan="2"><input type="text" name="id"></td>
			</tr>
			<tr>
				<td>패스워드</td>
				<td colspan="2"><input type="password" name="pw"></td>
			</tr>
			<tr>
				<td>이름</td>
				<td colspan="2"><input type="text" name="name"></td>
			</tr>
			<tr>
				<td>성별</td>
				<td colspan="2">
				<input type="radio" name="gender"> 남성
				<input type="radio" name="gender"> 여성
				</td>
			</tr>
			<tr>
				<td colspan="3" align="center"><input type="submit" value="입력완료"></td>
			</tr>
		</table>
		<br>
	</form>
	&nbsp;
	<form action="02_main.jsp">
		<input type="submit" value="메인화면">
	</form>
</div>
</body>
</html>