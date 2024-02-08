package kr.basic.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.basic.model.Board;
import kr.basic.model.BoardDAO;

public class BoardListController implements Controller {
	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Board> list = BoardDAO.getInstance().boardList();
		request.setAttribute("list", list);
		HttpSession session = request.getSession();
		if (session.getAttribute("log") != null) {
			int num = (int) session.getAttribute("log");
			request.setAttribute("no", num);
		} else {
			request.setAttribute("no", null);
		}
		return "boardList";
	}
}