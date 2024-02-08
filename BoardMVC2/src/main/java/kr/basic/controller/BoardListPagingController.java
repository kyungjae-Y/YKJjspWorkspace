package kr.basic.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.basic.model.Board;
import kr.basic.model.BoardDAO;

@WebServlet("/boardListPaging.do")
public class BoardListPagingController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		if (req.getParameter("start") != null) {
			BoardDAO.getInstance().setCurPageNum(req.getParameter("start"));
		}
		if (req.getParameter("curNum") != null) {
			BoardDAO.getInstance().setStartPageNum(req.getParameter("curNum"));
		}
		ArrayList<Board> list = BoardDAO.getInstance().getPagingBoardList();
		req.setAttribute("list", list);
		// 게시글 시작 페이지 번호
		req.setAttribute("start", BoardDAO.getInstance().startPageNum);
		// 게시글 끝 페이지 번호
		req.setAttribute("end", BoardDAO.getInstance().getEndPageNum());
		// 한페이지에 보여줄 페이지 개수
		req.setAttribute("cnt", BoardDAO.getInstance().pageNumCnt);
		// 전체 페이지 개수
		req.setAttribute("totalCnt", BoardDAO.getInstance().getTotalPageCnt());
		RequestDispatcher rd = req.getRequestDispatcher("board/boardListPaging.jsp");
		rd.forward(req, res);
	}
}