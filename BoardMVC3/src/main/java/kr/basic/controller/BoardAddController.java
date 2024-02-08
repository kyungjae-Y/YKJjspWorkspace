package kr.basic.controller;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.basic.model.Board;
import kr.basic.model.BoardDAO;

public class BoardAddController implements Controller {
	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		if (request.getParameter("b_no") == null) {
			return "boardAdd";
		}
		String writer = request.getParameter("b_writer");
		String subject = request.getParameter("b_subject");
		String contents = request.getParameter("b_contents");
		LocalDate regDate = LocalDate.now();

		Board b = new Board();
		b.setWriter(writer);
		b.setSubject(subject);
		b.setContents(contents);
		b.setRegDate(regDate.toString());
		String ctx = request.getContextPath();
		int cnt = BoardDAO.getInstance().boardAdd(b);
		if (cnt > 0) {
			return "redirect:" + ctx + "/boardAdd.do";
		} else {
			throw new ServletException("not add");
		}
	}
}