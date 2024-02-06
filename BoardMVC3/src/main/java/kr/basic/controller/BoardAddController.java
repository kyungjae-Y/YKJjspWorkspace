package kr.basic.controller;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.basic.model.Board;
import kr.basic.model.BoardDAO;

@WebServlet("/boardAdd.do")
public class BoardAddController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String writer = req.getParameter("writer");
		String subject = req.getParameter("subject");
		String contents = req.getParameter("contents");
		LocalDate regDate = LocalDate.now();
		
		Board b = new Board();
		b.setWriter(writer);
		b.setSubject(subject);
		b.setContents(contents);
		b.setRegDate(regDate.toString());
		String ctx = req.getContextPath();
		int cnt = BoardDAO.getInstance().boardAdd(b);
	}
}