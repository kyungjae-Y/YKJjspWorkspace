package kr.basic.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.basic.model.MemberDAO;

@WebServlet("/memberDelete.do")
public class MemberDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String ctx = req.getContextPath();
		String num = req.getParameter("num");
		if (num == null) {
			res.sendRedirect(ctx + "/memberList.do");
			return;
		}
		MemberDAO.getInstance().deleteOneMember(Integer.parseInt(num));
		res.sendRedirect(ctx + "/memberList.do");
	}
}