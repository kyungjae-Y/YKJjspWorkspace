<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="board.BoardDAO, board.BoardVO"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="java.util.Date"%>

<%
BoardDAO boardDAO = new BoardDAO();
boardDAO.addBoard(new BoardVO(1, "John Doe", "Sample Title", "Sample Content", "2024-01-31"));
boardDAO.addBoard(new BoardVO(2, "Jane Doe", "Another Title", "Another Content", "2024-02-01"));

List<BoardVO> boardList = boardDAO.getAllBoards();
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Board List</title>
</head>
<body>
<form action="_06_deleteBoardPro.jsp">
	<table border="1">
		<tr>
			<th>번호</th>
			<th>작성자</th>
			<th>작성일</th>
			<th>제목</th>
			<th>내용</th>
			<th>삭제</th>
		</tr>
		<%
		for (BoardVO board : boardList) {
		%>
		<tr>
			<td><%=board.getNo()%></td>
			<td><%=board.getWriter()%></td>
			<td><%=board.getRegDate()%></td>
			<td><a href="_05_updateBoard.jsp?boardNo=<%=board.getSubject()%>"><%=board.getSubject()%></a></td>
			<td><%=board.getContents()%></td>
			<td><button type="submit">삭제</button></td>
			<%-- <td><a href="_06_deleteBoardPro.jsp?boardNo=<%=board.getNo()%>">삭제</a></td> --%>
		</tr>
		<%
		}
		%>
	</table>
</form>
</body>
</html>