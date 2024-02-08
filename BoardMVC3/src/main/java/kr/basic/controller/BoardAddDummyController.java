package kr.basic.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.basic.model.BoardDAO;

public class BoardAddDummyController implements Controller {
	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ctx = request.getContextPath();
		BoardDAO.getInstance().createDummies(10);
		return "redirect:" + ctx + "/boardList.do";
	}
}