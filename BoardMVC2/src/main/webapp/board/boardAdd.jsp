<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="./header.jsp"%>
<body>
	<h1>게시글 추가하기</h1>
	<form method="post" action="${ctx}/boardAdd.do">
		<table border="1">
			<tr>
				<th>번호</th>
				<td>${list.size() + 1}</td>
			</tr>
			<tr>
				<th>작성자</th>
				<td><input type="text" name="b_writer" required></td>
			</tr>
			<tr>
				<th>제목</th>
				<td><input type="text" name="b_subject" required></td>
			</tr>
			<tr>
				<th>내용</th>
				<td><textarea rows="10" cols="20" name="b_contents" required></textarea></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="작성완료"></td>
			</tr>
		</table>
	</form>
	<button onclick="location.href='${ctx}/board/main.jsp'">메인으로</button>
</body>