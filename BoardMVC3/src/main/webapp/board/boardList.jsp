<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="./header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p>전체 게시글 수 ${list.size()}</p>
	<table border="1">
		<tr>
			<th>번호</th>
			<th>작성자</th>
			<th>제목</th>
			<th>내용</th>
			<th>작성일</th>
			<th>삭제</th>
		</tr>
		<c:forEach var="board" items="${list}">
			<tr>
				<td>
					<a href="boardContent.do?no=${board.no}">${board.no}</a>
				</td>
				<td>${board.writer}</td>
				<td>${board.subject}</td>
				<td>${board.contents}</td>
				<td>${board.regDate}</td>
				<td>
					<button onclick="location.href='${ctx}/boardDelete.do?no=${board.no}'">삭제</button>
				</td>
			</tr>
		</c:forEach>
	</table>
	<br>
	<button onclick="location.href='${ctx}/board/main.jsp'">메인으로</button>
</body>
</html>