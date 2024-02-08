package kr.basic.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.basic.model.BoardDAO;

@WebServlet("/boardUpdate.do")
public class BoardUpdateController implements Controller {
	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ctx = request.getContextPath();
		int no = Integer.parseInt(request.getParameter("no"));
		String subject = request.getParameter("subject");
		String contents = request.getParameter("contents");
		int cnt = BoardDAO.getInstance().boardUpdate(no, subject, contents);
		if (cnt > 0) {
			return "redirect:" + ctx + "/boardList.do";
		} else {
			throw new ServletException("not update");
		}
	}
}