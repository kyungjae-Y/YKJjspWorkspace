<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="./header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>게시글 수정하기</h1>
	<form method="post" action="${ctx}/boardUpdate.do">
	<input type="hidden" name="no" value="${board.no}">
		<table border="1">
			<tr>
				<th>번호</th>
				<td colspan="3">${board.no}</td>
			</tr>
			<tr>
				<th>작성자</th>
				<td>${board.writer}</td>
			</tr>
			<tr>
				<th>제목</th>
				<td colspan="3"><input type="text" name="subject" value="${board.subject}"></td>
			</tr>
			<tr>
				<th>내용</th>
				<td colspan="3"><textarea rows="10" cols="20" name="contents">${board.contents}</textarea></td>
			</tr>
			<tr>
				<th>작성일</th>
				<td>${board.regDate}</td>
			</tr>
			<tr>
				<td colspan="4">
					<input type="hidden" name="index">
					<input type="submit" value="수정하기">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>