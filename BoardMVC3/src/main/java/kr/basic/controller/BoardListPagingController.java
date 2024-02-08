package kr.basic.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.basic.model.Board;
import kr.basic.model.BoardDAO;

public class BoardListPagingController implements Controller {
	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getParameter("start") != null) {
			BoardDAO.getInstance().setCurPageNum(request.getParameter("start"));
		}
		if (request.getParameter("curNum") != null) {
			BoardDAO.getInstance().setStartPageNum(request.getParameter("curNum"));
		}
		ArrayList<Board> list = BoardDAO.getInstance().getPagingBoardList();
		request.setAttribute("list", list);
		// 게시글 시작 페이지 번호
		request.setAttribute("start", BoardDAO.getInstance().startPageNum);
		// 게시글 끝 페이지 번호
		request.setAttribute("end", BoardDAO.getInstance().getEndPageNum());
		// 한페이지에 보여줄 페이지 개수
		request.setAttribute("cnt", BoardDAO.getInstance().pageNumCnt);
		// 전체 페이지 개수
		request.setAttribute("totalCnt", BoardDAO.getInstance().getTotalPageCnt());
		return "boardListPaging";
	}
}