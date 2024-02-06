package kr.basic.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.basic.model.MemberDAO;

public class MemberDeleteController implements Controller {
	@Override
	public String requestHandler(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String ctx = req.getContextPath();
		int cnt = MemberDAO.getInstance().memberDelete(req.getParameter("id"));
		if (cnt > 0) {
			return "redirect:" + ctx + "/memberList.do";
		} else {
			throw new ServletException("not delete");
		}
	}
}