package kr.basic.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.basic.model.BoardDAO;

@WebServlet("/boardAddDummy.do")
public class BoardAddDummyController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String ctx = req.getContextPath();
		int cnt = BoardDAO.getInstance().createDummies(10);
		if (cnt > 0) {
			res.sendRedirect(ctx + "/boardList.do");
		} else {
			throw new ServletException("not add dummy");
		}
	}
}