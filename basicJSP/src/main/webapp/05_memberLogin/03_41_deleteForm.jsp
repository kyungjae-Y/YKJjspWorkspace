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
		<h1>회원탈퇴</h1>
		<form action="03_42_deletePro.jsp">
			<table border="1">
				<tr>
					<td>비밀번호</td>
					<td colspan="2"><input type="password"></td>
				</tr>
				<tr>
					<td colspan="3" align="center"><input type="submit" value="입력완료"></td>
				</tr>
			</table>
		</form>
		&nbsp;
		<form action="02_main.jsp">
			<input type="submit" value="메인화면">
		</form>
	</div>
</body>
</html>