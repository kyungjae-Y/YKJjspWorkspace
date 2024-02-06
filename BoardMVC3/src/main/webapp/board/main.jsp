<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />

<body>
	<h1>게시판</h1>
	<h3>
		<a href="${ctx}/boardList.do">전체 게시글 확인하기</a>
	</h3>
	<h3>
		<a href="_02_addDummyPro.jsp">더미 게시글 추가하기</a>
	</h3>
	<h3>
		<a href="_03_deleteAllBoardPro.jsp">전체 게시글 삭제하기</a>
	</h3>
	<h3>
		<a href="_04_addBoard.jsp">게시글 추가하기</a>
	</h3>
	<hr>
	<h3>
		<a href="_07_boardListPaging.jsp">페이징 게시판</a>
	</h3>
</body>
</html>