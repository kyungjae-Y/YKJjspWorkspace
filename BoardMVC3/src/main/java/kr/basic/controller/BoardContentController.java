package kr.basic.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.basic.model.Board;
import kr.basic.model.BoardDAO;

public class BoardContentController implements Controller {
	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ctx = request.getContextPath();
		int num = -1;
		if (request.getParameter("no") == null) {
			return "redirect:" + ctx + "/boardList.do";
		} else {
			num = Integer.parseInt(request.getParameter("no"));
		}
		Board b = BoardDAO.getInstance().boardContent(num);
		request.setAttribute("b", b);
		return "boardContent";
	}
}