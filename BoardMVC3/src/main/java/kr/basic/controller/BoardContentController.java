package kr.basic.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.basic.model.BoardDAO;

@WebServlet("/boardContent.do")
public class BoardContentController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String no = req.getParameter("no");

		req.setAttribute("board", BoardDAO.getInstance().boardContent(Integer.parseInt(no)));
		RequestDispatcher rd = req.getRequestDispatcher("board/boardUpdate.jsp");
		rd.forward(req, res);
	}
}