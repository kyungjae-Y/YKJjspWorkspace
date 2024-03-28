<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<body>
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
	<c:if test="${start > cnt}">
		[<a href="${ctx}/boardListPaging.do?start=${start - 1}&curNum=${start - cnt}">이전</a>]
	</c:if>
	<c:forEach var="i" begin="${start}" end="${end}">
		[<a href="${ctx}/boardListPaging.do?start=${i}&curNum=${start}">${i}</a>]
	</c:forEach>
	<c:if test="${end < totalCnt}">
		[<a href="${ctx}/boardListPaging.do?start=${start + cnt}&curNum=${start + cnt}">이후</a>]
	</c:if>
	<br>
	<button onclick="location.href='${ctx}/board/main.jsp'">메인으로</button>
</body>