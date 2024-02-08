package kr.basic.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.basic.model.BoardDAO;

public class BoardDeleteController implements Controller {
	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ctx = request.getContextPath();
		int cnt = BoardDAO.getInstance().boardDelete(Integer.parseInt(request.getParameter("no")));
		if (cnt > 0) {
			return "redirect:" + ctx + "/boardList.do";
		} else {
			throw new ServletException("not delete");
		}
	}
}