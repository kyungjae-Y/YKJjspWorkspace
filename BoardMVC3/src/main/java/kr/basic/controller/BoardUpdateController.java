package kr.basic.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.basic.model.Board;
import kr.basic.model.BoardDAO;

@WebServlet("/boardUpdate.do")
public class BoardUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		int no = Integer.parseInt(req.getParameter("no"));
		String subject = req.getParameter("subject");
		String contents = req.getParameter("contents");
		String ctx = req.getContextPath();
		int cnt = BoardDAO.getInstance().boardUpdate(no, subject, contents);
		if (cnt > 0) {
			res.sendRedirect(ctx + "/boardList.do");
		} else {
			throw new ServletException("not update");
		}
	}
}